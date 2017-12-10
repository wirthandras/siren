package siren.persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import siren.jobs.Employee;
import siren.jobs.IJob;
import siren.jobs.JobFactory;

public class ReadWorkers {

	public static List<Employee> readEmployees(File file) throws IOException {
		List<Employee> emps = new ArrayList<Employee>();
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = null;
		IJob job = null;

		Random r = new Random();

		while ((line = br.readLine()) != null) {
			if (line.contains(IJob.class.getSimpleName())) {
				String type = line.replace(IJob.class.getSimpleName(), "");
				job = JobFactory.getJob(type);
			} else {
				boolean is24Service = r.nextBoolean();

				emps.add(new Employee(line, job, is24Service));
			}
		}
		br.close();
		return emps;
	}

}
