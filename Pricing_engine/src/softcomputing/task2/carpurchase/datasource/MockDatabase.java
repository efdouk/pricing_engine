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
	}

	private void reinitializeCars() {
		items = new ArrayList<Car>();
		factory = new CarFactory();
		
		items.add(factory.ferrariTestarossa());
		items.add(factory.opelCorsa());
		items.add(factory.mercedesSClass());
		items.add(factory.kiaRio());
		items.add(factory.bugattiVeyron());
		items.add(factory.citroenBerlingo());
		items.add(factory.skodaOctavia());
		items.add(factory.volkswagenGolf());
		
	}

	@Override
	public List<Car> getCars() {
		reinitializeCars();
		return items;
	}

}
