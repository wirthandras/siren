package siren.components;

public class Shift {

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
	
	public int getDay() {
		return day;
	}

	public int getFrom() {
		return from;
	}

	public int getTo() {
		return to;
	}
}
