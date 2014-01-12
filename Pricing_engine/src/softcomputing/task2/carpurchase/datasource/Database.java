/**
 * @author Konrad Zdanowicz (zdanowicz.konrad@gmail.com)
 * 
 */
package softcomputing.task2.carpurchase.datasource;

import java.util.List;

import softcomputing.task2.carpurchase.model.Car;

/**
 * Database interface
 */ 
public interface Database {
	
	List<Car> getCars();

}