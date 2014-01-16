/**
 * @author Konrad Zdanowicz (zdanowicz.konrad@gmail.com)
 * 
 */
package softcomputing.task2.carpurchase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import softcomputing.task2.carpurchase.model.Car;
import softcomputing.task2.carpurchase.model.CarCriterion;
import softcomputing.task2.carpurchase.model.CarFeature;
import softcomputing.task2.carpurchase.model.Step1UserRequest;
import softcomputing.task2.carpurchase.model.Step2UserRequest;
import softcomputing.task2.carpurchase.model.Step3UserRequest;

/**
 * Steps performed on car list and user requests in order to fulfill the expert
 * system contract
 * 
 * Each step method takes cars and user request and returns the narrows copy of
 * the car list
 */
public class Steps {

	/**
	 * Evaluates each car and sorts the car list from the most attractive to the
	 * least fitting
	 * 
	 * @return modified car list with the evaluation value set
	 */
	public List<Car> step1(List<Car> cars, Step1UserRequest userRequest) {
		CarCriterion firstCriterion = userRequest.getFirstCriterion();

		for (Car car : cars) {
			firstCriterion.getEvaluator().evaluate(car, 1.);
			userRequest.getCarDomainType().getEvaluator().evaluate(car, 2.);
		}
		if (userRequest.getSecondCriterion() != null) {
			for (Car car : cars) {
				userRequest.getSecondCriterion().getEvaluator().evaluate(car, 0.1);
			}
			if (userRequest.getThirdCriterion() != null) {
				for (Car car : cars) {
					userRequest.getThirdCriterion().getEvaluator().evaluate(car, 0.01);
				}
			}
		}

		Collections.sort(cars);

		List<Car> newList = new ArrayList<Car>();
		for (int i = 0; i < cars.size(); i++) {
			if (fulfills(cars.get(i), userRequest)) {
				newList.add(cars.get(i));
			}
		}
		return newList;
	}

	private boolean fulfills(Car car, Step1UserRequest userRequest) {
		if (userRequest.getPriceMin() != null && car.getPrice() < userRequest.getPriceMin())
			return false;
		if (userRequest.getPriceMax() != null && car.getPrice() > userRequest.getPriceMax())
			return false;
		return true;
	}

	public List<Car> step2(List<Car> cars, Step2UserRequest userRequest) {
		List<Car> newList = new ArrayList<Car>();
		for (int i = 0; i < cars.size(); i++) {
			if (fulfills(cars.get(i), userRequest)) {
				newList.add(cars.get(i));
			}
		}
		return newList;
	}

	private boolean fulfills(Car car, Step2UserRequest userRequest) {
		if (userRequest.getBurningMin() != null && car.getAverageBurningCostPer100km() < userRequest.getBurningMin())
			return false;
		if (userRequest.getBurningMax() != null && car.getAverageBurningCostPer100km() > userRequest.getBurningMax())
			return false;
		if (userRequest.getCapacityMin() != null && car.getEngineCapacity() < userRequest.getCapacityMin())
			return false;
		if (userRequest.getCapacityMax() != null && car.getEngineCapacity() > userRequest.getCapacityMax())
			return false;
		if (userRequest.getCarType() != null && !car.getType().contains(userRequest.getCarType()))
			return false;
		if (userRequest.getFuelType() != null && userRequest.getFuelType().contains(userRequest.getFuelType()))
			return false;
		if (userRequest.getKilometersMin() != null && userRequest.getKilometersMin() > car.getKilometersOnTheGauge())
			return false;
		if (userRequest.getKilometersMax() != null && userRequest.getKilometersMax() < car.getKilometersOnTheGauge())
			return false;
		return true;
	}

	public List<Car> step3(List<Car> cars, Step3UserRequest userRequest3) {
		List<Car> newList = new ArrayList<Car>();
		for (int i = 0; i < cars.size(); i++) {
			if (fulfills(cars.get(i), userRequest3)) {
				newList.add(cars.get(i));
			}
		}

		return newList;
	}

	private boolean fulfills(Car car, Step3UserRequest userRequest3) {
		if (userRequest3.getMinyearOfProduction() != null && car.getYearOfProduction() < userRequest3.getMinyearOfProduction())
			return false;
		if (userRequest3.getMaxyearOfProduction() != null && car.getYearOfProduction() > userRequest3.getMaxyearOfProduction())
			return false;
		if (userRequest3.getFeatures() != null) {
			for (CarFeature feature : userRequest3.getFeatures()) {
				if (!car.getFeatures().contains(feature))
					return false;
			}
		}
		return true;
	}
}
