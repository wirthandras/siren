package siren.components;

public class Shift implements Comparable<Shift> {

	private int day;
	private int id;
	private int from;
	private int to;
	private ECarType carType;

	public Shift(int day, int id, int from, int to, ECarType carType) {
		super();
		this.day = day;
		this.id = id;
		this.from = from;
		this.to = to;
		this.carType = carType;
	}
	
	public ECarType getCarType() {
		return carType;
	}

	public boolean isNight() {
		return getTo() - getFrom() < 0;
	}

	public int duration() {
		if (getFrom() > getTo()) {
			return getFrom() - getTo();
		} else {
			return getTo() - getFrom();
		}
	}

	@Override
	public String toString() {
		return "{" + getDay() + "/" + id + ":" + getFrom() + "-" + getTo() + "}";
	}

	public int getDay() {
		return day;
	}

	public int getFrom() {
		return from;
	}

	public int getTo() {
		return to;
	}

	@Override
	public int compareTo(Shift o) {
		int result = Integer.compare(day, o.getDay());
		if (result == 0) {
			result = Integer.compare(from, o.getFrom());
			if (result == 0) {
				result = Integer.compare(to, o.getTo());
			}
		}
		return result;
	}
}
