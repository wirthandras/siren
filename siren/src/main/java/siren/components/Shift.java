package siren.components;

public class Shift implements Comparable<Shift> {

	private int day;
	private int from;
	private int to;

	public Shift(int day, int from, int to) {
		super();
		this.day = day;
		this.from = from;
		this.to = to;
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
		return "{" + getDay() + ":" + getFrom() + "-" + getTo() + "}";
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
