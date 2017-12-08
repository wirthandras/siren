package siren.jobs;

public class Doctor implements IJob {

	@Override
	public boolean isNightWorking() {
		return true;
	}

}
