package siren.jobs;

import java.util.ArrayList;
import java.util.List;

public class JobFactory {

	public static IJob doctor = new Doctor();
	public static IJob paramedic = new Paramedic();
	public static IJob nurse = new Nurse();
	public static IJob majorNurse = new MajorNurse();
	public static IJob driver = new Driver();

	public static List<IJob> jobs = new ArrayList<IJob>();
	
	static {
		jobs.add(doctor);
		jobs.add(paramedic);
		jobs.add(nurse);
		jobs.add(majorNurse);
		jobs.add(driver);		
	}

	public static IJob getJob(String jobName) {

		if (jobName == null) {
			return null;
		}

		if (jobName.equalsIgnoreCase("PARAMEDIC")) {
			return paramedic;
		} else if (jobName.equalsIgnoreCase("NURSE")) {
			return nurse;
		} else if (jobName.equalsIgnoreCase("MAJOR_NURSE")) {
			return majorNurse;
		} else if (jobName.equalsIgnoreCase("DRIVER")) {
			return driver;
		} else if (jobName.equalsIgnoreCase("DOCTOR")) {
			return doctor;
		}

		return null;
	}

}
