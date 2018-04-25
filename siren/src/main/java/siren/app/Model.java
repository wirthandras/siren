package siren.app;

import java.util.ArrayList;
import java.util.List;

import siren.components.Car;

public class Model {

	private static Model instance;

	private List<Car> cars;

	Model() {
		cars = new ArrayList<Car>();
	}

	public static Model getInstance() {
		if (instance == null) {
			instance = new Model();
		}
		return instance;
	}

	public void addCar(Car car) {
		cars.add(car);
	}

	public List<Car> getCars() {
		return cars;
	}
	
	public boolean identifierIsExist(String newIdentifier) {
		return cars.stream().anyMatch(p -> p.getIdentifier().equals(newIdentifier));
	}
}
