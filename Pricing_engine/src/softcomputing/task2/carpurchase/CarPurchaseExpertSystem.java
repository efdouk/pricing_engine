/**
 * @author Konrad Zdanowicz (zdanowicz.konrad@gmail.com)
 * 
 */
package softcomputing.task2.carpurchase;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import softcomputing.task2.carpurchase.datasource.Database;
import softcomputing.task2.carpurchase.datasource.MockDatabase;
import softcomputing.task2.carpurchase.model.Car;
import softcomputing.task2.carpurchase.model.CarCriterion;
import softcomputing.task2.carpurchase.model.CarDomainType;
import softcomputing.task2.carpurchase.model.CarFeature;
import softcomputing.task2.carpurchase.model.CarType;
import softcomputing.task2.carpurchase.model.FuelType;
import softcomputing.task2.carpurchase.model.Step1UserRequest;
import softcomputing.task2.carpurchase.model.Step2UserRequest;
import softcomputing.task2.carpurchase.model.Step3UserRequest;

/**
 * Sample implementation using heuristic rule-following backward-chaining expert
 * system engine
 */
public class CarPurchaseExpertSystem {
	public static void main(String args[]) {
		Database database = new MockDatabase();

		Steps steps = new Steps();

		Step1UserRequest userRequest = new Step1UserRequest(CarCriterion.PERFORMANCE, CarCriterion.COMFORT, null, CarDomainType.SPORT,10000.,40000.);
		List<Car> cars = steps.step1(database.getCars(), userRequest);

		showCars(cars, 1);

		Step2UserRequest userRequest2 = new Step2UserRequest(null, null, CarType.COUPE, null, null, null, null, FuelType.GASOLINE);
		cars = steps.step2(cars, userRequest2);

		showCars(cars, 2);

		Set<CarFeature> features = new HashSet<CarFeature>();
		features.add(CarFeature.CLIMA);
		features.add(CarFeature.ELECTRICAL_MIRRORS);
		Step3UserRequest userRequest3 = new Step3UserRequest(features,null, 1966.0, 2000.0);

		cars = steps.step3(cars, userRequest3);

		showCars(cars, 3);
	}
	

	
	
	private static void showCars(List<Car> cars, int step) {
		if (cars.size() == 0) {
			System.out.println("Sorry, but there are no cars fulfilling your request.");
		} else {
			System.out.println(String.format("After the " + step + ". step, the following cars (%d) are suggested to you:", cars.size()));
			for (Car car : cars) {
				System.out.println(car.getEvaluation() + " " + car.getBrand() + " " + car.getName());
			}
		}
	}
}
