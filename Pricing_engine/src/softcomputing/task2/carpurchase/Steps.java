/**
 * @author Konrad Zdanowicz (zdanowicz.konrad@gmail.com)
 * 
 */
package softcomputing.task2.carpurchase;

import java.awt.SecondaryLoop;
import java.util.Collections;
import java.util.List;

import softcomputing.task2.carpurchase.model.Car;
import softcomputing.task2.carpurchase.model.CarCriterion;
import softcomputing.task2.carpurchase.model.UserRequest;

/**
 * 
 */
public class Steps {

	public List<Car> step1(List<Car> cars, UserRequest userRequest) {
		CarCriterion firstCriterion = userRequest.getFirstCriterion();
		
		for (Car car : cars) {
			firstCriterion.getEvaluator().evaluate(car,1.);
			userRequest.getCarDomainType().getEvaluator().evaluate(car, 2.);
		}
		if(userRequest.getSecondCriterion()!=null) {
			for (Car car : cars) {
				userRequest.getSecondCriterion().getEvaluator().evaluate(car, 0.1);
			}
			if(userRequest.getThirdCriterion()!=null) {
				for (Car car : cars) {
					userRequest.getThirdCriterion().getEvaluator().evaluate(car, 0.01);
				}
			}
		}
		
		Collections.sort(cars);
		return cars;
	}
	
	
}
