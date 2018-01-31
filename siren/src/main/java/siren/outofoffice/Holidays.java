package siren.outofoffice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * This class holds the information about the holidays and the sicks.
 * 
 * @author Andras Wirth
 *
 */
// TODO the name of the is not best, try to find out a better name.
public class Holidays {

	private Map<Integer, EOutType> entry;

	public Holidays() {
		entry = new HashMap<Integer, EOutType>();
	}

	public void put(Integer day, EOutType type) {
		entry.put(day, type);
	}

	public EOutType get(Integer day) {
		return entry.get(day);
	}

	public int getNumberOfHolidays() {
		int sum = 0;
		for (EOutType t : entry.values()) {
			if (EOutType.HOLIDAY.equals(t)) {
				sum++;
			}
		}
		return sum;
	}

	public Set<Integer> getHolidays() {
		return get(EOutType.HOLIDAY);
	}
	
	public Set<Integer> getSicks() {
		return get(EOutType.SICK);
	}
	
	private Set<Integer> get(EOutType type) {
		Set<Integer> result = new HashSet<Integer>();
		for (Integer key : entry.keySet()) {
			if (type.equals(entry.get(key))) {
				result.add(key);
			}
		}
		return result;
	} 

}
