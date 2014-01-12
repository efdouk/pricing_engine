/**
 * @author Konrad Zdanowicz (zdanowicz.konrad@gmail.com)
 * 
 */
package softcomputing.task2.carpurchase.model;

import java.util.List;

/**
 * 
 */
public interface CarFilter {
	public List<Car> filter(List<Car> inputCars, Object request);
}
