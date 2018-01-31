package siren.outofoffice;

import java.util.HashMap;
import java.util.Map;

import siren.jobs.Employee;

public class OutOfOffice {

	private Map<Employee, Holidays> outOfOffice;
	
	public OutOfOffice() {
		outOfOffice = new HashMap<Employee, Holidays>();
	}
	
	public void put(Employee employee, Integer day, EOutType type) {
		Holidays h = outOfOffice.get(employee);
		if (h != null) {
			h.put(day, type);
		} else {
			Holidays entry = new Holidays();
			entry.put(day, type);
			outOfOffice.put(employee, entry);
		}
	}
	
	public Holidays get(Employee employee) {
		return outOfOffice.get(employee);
	}
	

}
