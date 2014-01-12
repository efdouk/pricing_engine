/**
 * @author Konrad Zdanowicz (zdanowicz.konrad@gmail.com)
 * 
 */
package softcomputing.task2.carpurchase;

import java.util.List;

import softcomputing.task2.carpurchase.model.Car;
import softcomputing.task2.carpurchase.model.UserRequest;

/**
 * 
 */
public class CarFilterFirst implements CarFilter {

	@Override
	public List<Car> filter(List<Car> inputCars, Object request) {
		UserRequest req = (UserRequest) request;
		return null;
		
		
	}

}
