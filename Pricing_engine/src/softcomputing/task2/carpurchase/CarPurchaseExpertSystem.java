package softcomputing.task2.carpurchase;

import java.util.List;

import softcomputing.task2.carpurchase.datasource.Database;
import softcomputing.task2.carpurchase.datasource.MockDatabase;
import softcomputing.task2.carpurchase.model.Car;
import softcomputing.task2.carpurchase.model.CarCriterion;
import softcomputing.task2.carpurchase.model.CarDomainType;
import softcomputing.task2.carpurchase.model.UserRequest;
/**
 * @author Konrad Zdanowicz (zdanowicz.konrad@gmail.com)
 * 
 */

/**
 * 
 */
public class CarPurchaseExpertSystem {
	public static void main(String args[]) {
		Database database = new MockDatabase();
		
		
		Steps steps = new Steps();
		UserRequest userRequest=new UserRequest(CarCriterion.ECONOMY, CarCriterion.COMFORT, null, CarDomainType.FAMILY);
		List<Car> step1 = steps.step1(database.getCars(), userRequest);
		for (Car car : step1) {
			System.out.println(car.getEvaluation()+" "+car.getBrand()+" "+car.getName());
		}
		
	}
}
