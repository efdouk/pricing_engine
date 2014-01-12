/**
 * @author Konrad Zdanowicz (zdanowicz.konrad@gmail.com)
 * 
 */
package softcomputing.task2.carpurchase.datasource;

import java.util.List;

import softcomputing.task2.carpurchase.model.Car;

/**
 * 
 */ 
public interface Database {

	public abstract void addCar(Car car);

	public abstract List<Car> getCars();

}