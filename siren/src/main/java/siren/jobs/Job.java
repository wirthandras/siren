package siren.jobs;

public abstract class Job implements IJob {

	protected String jobName;

	public Job() {
		jobName = getClass().getSimpleName();
	}

	@Override
	public String toString() {
		return jobName;
	}

}
