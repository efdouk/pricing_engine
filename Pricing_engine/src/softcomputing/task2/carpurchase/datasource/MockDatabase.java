/**
 * @author Konrad Zdanowicz (zdanowicz.konrad@gmail.com)
 * 
 */
package softcomputing.task2.carpurchase.datasource;

import java.util.ArrayList;
import java.util.List;

import softcomputing.task2.carpurchase.model.Car;

/**
 * Mock implementation of the database
 */
public class MockDatabase implements Database {

	private List<Car> items;
	private CarFactory factory;
	
	public MockDatabase() {
		items = new ArrayList<Car>();
		factory = new CarFactory();
		
		items.add(factory.ferrariTestarossa());
		items.add(factory.opelCorsa());
		items.add(factory.mercedesSClass());
		
	}

	@Override
	public void addCar(Car car) {
		if (!items.contains(car))
			items.add(car);
	}

	@Override
	public List<Car> getCars() {
		return items;
	}

}
