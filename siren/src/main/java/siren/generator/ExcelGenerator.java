package siren.generator;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.util.CellRangeAddress;

import siren.components.Plan;
import siren.jobs.Employee;
import siren.jobs.EmployeeService;
import siren.jobs.IJob;
import siren.jobs.JobFactory;
import siren.outofoffice.OutOfOffice;

public class ExcelGenerator {

	private static final String OSSZ_ORA = "Ossz ora";
	private static final String NAMES = "Nevsor";
	private static final String HOLIDAYS = "Szabi";

	private static final String SICK_SHORT = "B";
	private static final String HOLIDAY_SHORT = "sz";

	private Plan plan;
	private EmployeeService employeeService;
	private OutOfOffice out;

	public ExcelGenerator(Plan plan, EmployeeService employeeService, OutOfOffice out) {
		this.plan = plan;
		this.employeeService = employeeService;
		this.out = out;
	}

	public HSSFWorkbook generate() {
		HSSFWorkbook workbook = new HSSFWorkbook();

		generateSheet(workbook, JobFactory.paramedic);
		generateSheet(workbook, JobFactory.nurse);
		generateSheet(workbook, JobFactory.driver);

		return workbook;
	}

	private void generateSheet(HSSFWorkbook workbook, IJob job) {

		Set<Employee> filteredEmployees = employeeService.filter(job);
		generateOneSheet(workbook, plan, filteredEmployees, job.toString());
	}

	private void generateOneSheet(HSSFWorkbook workbook, Plan plan, Set<Employee> employees, String sheetName) {
		HSSFSheet sheet = workbook.createSheet(sheetName);

		int actRow = 0;

		createHeaderRow(workbook, sheet, actRow, plan.getDays());

		actRow++;

		createEmployeeTable(workbook, sheet, actRow, employees, plan.getDays());

		normalizeBorder(sheet, plan.getDays());

		// merge names
		mergeCellsForEmployee(sheet, employees.size(), 0);
		// merge holidays
		mergeCellsForEmployee(sheet, employees.size(), plan.getDays() + 1);
		// merge sum
		mergeCellsForEmployee(sheet, employees.size(), plan.getDays() + 2);
	}

	private void normalizeBorder(HSSFSheet sheet, int days) {
		for (int i = 0; i <= days; i++) {
			sheet.autoSizeColumn(i);
		}
	}

	private void createEmployeeTable(HSSFWorkbook workbook, HSSFSheet sheet, int actRow, Set<Employee> employees,
			int day) {
		
		int localRowIndex = actRow;
		List<Employee> employeeList = new ArrayList<Employee>(employees);
		Collections.sort(employeeList);
		for (int i = 0; i < employees.size(); i++) {

			Employee emp = employeeList.get(i);
			HSSFRow rowStart = sheet.createRow(localRowIndex);
			localRowIndex++;
			HSSFRow rowFinish = sheet.createRow(localRowIndex);
			localRowIndex++;

			oneRow(workbook, rowStart, emp, day, true);
			oneRow(workbook, rowFinish, emp, day, false);

		}
	}

	private void oneRow(HSSFWorkbook workbook, HSSFRow row, Employee emp, int day, boolean start) {
		for (int j = 0; j <= day + 2; j++) {
			HSSFCell cell = row.createCell(j);

			if (j == 0) {
				cell.setCellValue(emp.getName());
			} else {
				if (j == day + 2) {
					cell.setCellValue(plan.sumWorkingHours(emp));
				} else {
					if (j == day + 1) {
						int WORK_DAY_HOURS = 8;
						cell.setCellValue(out.get(emp).getNumberOfHolidays() * WORK_DAY_HOURS);
					} else {
						if (out.get(emp).getSicks().contains(j)) {
							if (!start) {
								cell.setCellValue(SICK_SHORT);
							}
						} else {
							if (out.get(emp).getHolidays().contains(j)) {
								if (!start) {
									cell.setCellValue(HOLIDAY_SHORT);
								}
							} else {
								if (plan.isNormalShiftDay(emp, j)) {
									setCellValue(emp, cell, start, j);
								}
							}
						}
						setCellStyle(workbook, cell, j);
					}
				}
			}

		}
	}

	/**
	 * 
	 * @param emp
	 * @param cell
	 * @param start
	 *            true means arrive cell, false means go home cell.
	 * @param actDay
	 */
	private void setCellValue(Employee emp, HSSFCell cell, boolean start, int actDay) {
		int value = plan.getTime(emp, actDay, start);
		//TODO handle -1 via exception
		if (value != -1) {
			cell.setCellValue(value);
		}
	}

	private void createHeaderRow(HSSFWorkbook wb, HSSFSheet sheet, int rowNum, int days) {
		HSSFRow row = sheet.createRow(rowNum);
		for (int j = 0; j <= days + 2; j++) {
			HSSFCell cell = row.createCell(j);
			if (j == 0) {
				cell.setCellValue(NAMES);
			} else {
				if (j == days + 1) {
					cell.setCellValue(HOLIDAYS);
				} else {
					if (j == days + 2) {
						cell.setCellValue(OSSZ_ORA);
					} else {
						setCellStyle(wb, cell, j);
						cell.setCellValue(j);
					}
				}
			}
		}
	}

	private CellStyle getSaturdayCellStyle(HSSFWorkbook wb) {
		// Aqua background
		HSSFCellStyle style = wb.createCellStyle();
		style.setFillForegroundColor(HSSFColor.YELLOW.index);
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		return style;
	}

	private CellStyle getSundayCellStyle(HSSFWorkbook wb) {
		// Aqua background
		HSSFCellStyle style = wb.createCellStyle();
		style.setFillForegroundColor(HSSFColor.AQUA.index);
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		return style;
	}

	private void setCellStyle(HSSFWorkbook wb, HSSFCell cell, int day) {

		Calendar mycal = new GregorianCalendar();
		mycal.set(Calendar.DAY_OF_MONTH, day);
		int dayOfWeek = mycal.get(Calendar.DAY_OF_WEEK);

		switch (dayOfWeek) {
		case Calendar.SATURDAY:
			cell.setCellStyle(getSaturdayCellStyle(wb));
			break;
		case Calendar.SUNDAY:
			cell.setCellStyle(getSundayCellStyle(wb));
			break;

		default:
			break;
		}
	}

	private void mergeCellsForEmployee(HSSFSheet sheet, int numberOfEmployees, int column) {
		for (int i = 0; i < numberOfEmployees + 2; i++) {
			int rowIndex = i * 2 + 1;
			sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex + 1, column, column));
		}
	}

}
