package siren.components;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import siren.jobs.IJob;
import siren.jobs.JobFactory;

public class CarRequiredJobs {

	private static Map<ECarType, Set<IJob>> assign;

	static {
		assign = new HashMap<ECarType, Set<IJob>>();
		Set<IJob> roham = new HashSet<IJob>();
		roham.add(JobFactory.paramedic);
		roham.add(JobFactory.driver);
		roham.add(JobFactory.nurse);
		assign.put(ECarType.ROHAMKOCSI, roham);

		Set<IJob> eset = new HashSet<IJob>();
		eset.add(JobFactory.driver);
		eset.add(JobFactory.nurse);
		assign.put(ECarType.ESETKOCSI, eset);
	}

	public static Set<IJob> get(ECarType type) {
		return new HashSet<IJob>(assign.get(type));
	}
}
