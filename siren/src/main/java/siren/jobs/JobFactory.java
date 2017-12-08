package siren.jobs;

import java.util.HashSet;
import java.util.Set;

public class JobFactory {

	public static Doctor doctor = new Doctor();
	public static Paramedic paramedic = new Paramedic();
	public static Nurse nurse = new Nurse();
	public static MajorNurse majorNurse = new MajorNurse();
	public static Driver driver = new Driver();

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

	// TODO rename
	public static Set<IJob> getAll() {
		Set<IJob> jobs = new HashSet<IJob>();
		jobs.add(paramedic);
		jobs.add(nurse);
		jobs.add(driver);
		return jobs;
	}
}
