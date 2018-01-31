package siren.jobs;

public class Employee implements Comparable<Employee> {

	private String name;
	private IJob job;
	private boolean is24hService;

	public Employee(String name, IJob job, boolean is24hService) {
		super();
		this.name = name;
		this.job = job;
		this.is24hService = is24hService;
	}

	public String getName() {
		return name;
	}

	public IJob getJob() {
		return job;
	}

	public boolean isIs24hService() {
		return is24hService;
	}

	@Override
	public int compareTo(Employee o) {
		return this.name.compareTo(o.getName());
	}
	
}
