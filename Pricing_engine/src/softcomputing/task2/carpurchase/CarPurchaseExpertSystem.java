/**
 * @author Konrad Zdanowicz (zdanowicz.konrad@gmail.com)
 * 
 */
package softcomputing.task2.carpurchase;

import static softcomputing.task2.carpurchase.console.ConsoleHumanizer.sysin;
import static softcomputing.task2.carpurchase.console.ConsoleHumanizer.sysline;
import static softcomputing.task2.carpurchase.console.ConsoleHumanizer.sysout;
import static softcomputing.task2.carpurchase.console.ConsoleHumanizer.tab;
import static softcomputing.task2.carpurchase.console.ConsoleHumanizer.untab;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import softcomputing.task2.carpurchase.console.ExitInputedException;
import softcomputing.task2.carpurchase.console.FinishInputedException;
import softcomputing.task2.carpurchase.console.RestartInputedException;
import softcomputing.task2.carpurchase.datasource.MockDatabase;
import softcomputing.task2.carpurchase.model.Car;
import softcomputing.task2.carpurchase.model.CarBrand;
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

	/* step 1 */
	static CarCriterion criterion1 = null;
	static CarCriterion criterion2 = null;
	static CarCriterion criterion3 = null;
	static CarDomainType carDomainType = null;
	static Double minPrice = null;
	static Double maxPrice = null;
	/* step 2 */
	static Double burningMin = null;
	static Double burningMax = null;
	static CarType carType = null;
	static Double kilometersMin = null;
	static Double kilometersMax = null;
	static Double capacityMin = null;
	static Double capacityMax = null;
	static FuelType fuelType = null;

	/* step 3 */
	static Set<CarFeature> carFeatures = null;
	static CarBrand brand = null;
	static Double minyearOfProduction = null;
	static Double maxyearOfProduction = null;

	public static void main(String args[]) {

		runCommandLineInterface();

	}

	private static void runCommandLineInterface() {
		boolean keepGoing = true;
		while (keepGoing) {
			try {
				specialActionHandler();
			} catch (ExitInputedException e) {
				keepGoing = false;
				sysout("Terminating...");
			} catch (RestartInputedException e) {
				sysout("Restarting...");
			} catch (FinishInputedException e) {
				endWindow();
			}
			if (keepGoing) {
				sysout("Input enter to restart or EXIT to exit.");

				try {
					sysin();
				} catch (ExitInputedException e) {
					keepGoing = false;
					sysline();
					sysout("Thank you for using the expert system. Goodbye!");
				} catch (RestartInputedException e) {
				} catch (FinishInputedException e) {
				}
			}
		}
	}

	private static void specialActionHandler() throws ExitInputedException, RestartInputedException, FinishInputedException {
		intro();

		step1window();
		step2Window();
		step3window();
		
		endWindow();

	}

	private static void intro() {
		clearVariables();
		sysline();
		sysout("CAR PURCHASE EXPERT SYSTEM");
		sysline();
		sysout("This application will ask you a few questions about the car you wish to buy.");
		sysout("There will be three steps. After each you will be asked, if you want to finish \nor continue the car selection.");
		sysout("if you wish to exit, anytime you can type EXIT to exit program or RESET to start \nover or FINISH to omit all steps and see suggested cars.");
		sysout("If you want to skip any question, just press enter without any answer to move to \nthe next question. Questions marked with asterisk are mandatory.");
	}

	private static void clearVariables() {
		/* step 1 */
		criterion1 = null;
		criterion2 = null;
		criterion3 = null;
		carDomainType = null;
		minPrice = null;
		maxPrice = null;
		/* step 2 */
		burningMin = null;
		burningMax = null;
		carType = null;
		kilometersMin = null;
		kilometersMax = null;
		capacityMin = null;
		capacityMax = null;
		fuelType = null;

		/* step 3 */
		carFeatures = null;
		brand = null;
		minyearOfProduction = null;
		maxyearOfProduction = null;
	}

	private static void endWindow() {
		sysline();
		sysout("The system is looking for the most suitable car for you. Please wait...");
		sysline();
		Step1UserRequest req1 = new Step1UserRequest(criterion1, criterion2, criterion3, carDomainType, minPrice, maxPrice);
		Step2UserRequest req2 = new Step2UserRequest(burningMin, burningMax, carType, kilometersMin, kilometersMax, capacityMin, capacityMax, fuelType);
		Step3UserRequest req3 = new Step3UserRequest(carFeatures, brand, minyearOfProduction, maxyearOfProduction);
		Steps steps = new Steps();
		List<Car> step1 = steps.step1(new MockDatabase().getCars(), req1);
		List<Car> step2 = steps.step2(step1, req2);
		List<Car> step3 = steps.step3(step2, req3);
		Collections.sort(step3);
		sysout("The system have found " + step3.size() + " cars, that suits your needs best.");

		Double max = null;
		int i = 1;
		for (Car car : step3) {
			if (max == null)
				max = car.getEvaluation();
			sysline();
			sysout(String.format("%d) %s %s (%.0f%% fit)", i, car.getBrand(), car.getName(), 100 * car.getEvaluation() / max));
			sysline();
			if (i < 6) {
				carDetails(car);
			}
			i++;
		}
	}

	private static void carDetails(Car car) {
		tab();
		sysout("Year:                          " + car.getYearOfProduction());
		sysout("Cost:                          " + car.getPrice() + " zl");
		sysout("Average burning cost of 100km: " + car.getAverageBurningCostPer100km() + " zl");
		sysout("Door count:                    " + car.getDoorCount());
		String features = "";
		for (CarFeature carFeature : car.getFeatures()) {
			features += carFeature + " ";
		}
		sysout("Features:                      " + features);
		sysout("Kilometers done:               " + car.getKilometersOnTheGauge() + " km");
		sysout("Engine capacity:               " + car.getEngineCapacity() + "l");
		sysout("Transmission:                  " + car.getTransmission());
		sysout("Luggage capacity:              " + car.getLuggageCapacity() + "l");
		sysout("Fuel type:                     " + car.getFuel());

		untab();
	}

	private static void step3window() throws ExitInputedException, RestartInputedException, FinishInputedException {
		sysline();
		sysout("STEP 3");
		sysline();
		sysout("Please select the features that you wish your car to have.");
		sysout("You can choose few of them, separating each value with comma.");
		tab();
		carFeatures = new HashSet<CarFeature>();
		for (CarFeature carFeature : CarFeature.values()) {
			sysout(carFeature.toString());
		}
		untab();
		String in = sysin();
		String[] features = in.split(",");
		for (String string : features) {
			if (string.trim().length() > 0)
				carFeatures.add(CarFeature.valueOf(string));
		}
		sysout("Do you want to choose the car's brand? Y/N");
		in = sysin();
		if (in.equalsIgnoreCase("Y")) {
			sysout("Available car brands:");
			tab();
			for (CarBrand carBrand : CarBrand.values()) {
				sysout(carBrand.toString());
			}
			untab();
			in = sysin();
			brand = CarBrand.valueOf(in);
		}
		sysout("What should be the year of the car production?");
		tab();
		sysout("from");
		in = sysin();
		if (in.trim().length() > 0)
			minyearOfProduction = Double.valueOf(in);

		sysout("to");
		in = sysin();
		if (in.trim().length() > 0)
			maxyearOfProduction = Double.valueOf(in);
		untab();
	}

	private static void step1window() throws ExitInputedException, RestartInputedException, FinishInputedException {
		sysline();
		sysout("STEP 1");
		sysline();
		sysout("Please specify what is the most important criterion for you: * ");
		tab();
		for (CarCriterion carCriterion : CarCriterion.values()) {
			if (!carCriterion.toString().equals("select"))
				sysout(carCriterion.toString());
		}
		untab();
		sysout("You can type maximally three criterions separated by comma, \nfrom the highest to the lowest priority.");
		String criterion = sysin();
		String[] criterions = criterion.split(",");
		if (criterions.length > 0) {
			criterion1 = CarCriterion.valueOf(criterions[0].trim());
			sysout(criterions[0]);
		}
		if (criterions.length > 1) {
			criterion2 = CarCriterion.valueOf(criterions[1].trim());
		}
		if (criterions.length > 2) {
			criterion1 = CarCriterion.valueOf(criterions[2].trim());
		}
		sysout("What is the general character of your car? * ");
		tab();
		for (CarDomainType carDomainType : CarDomainType.values()) {
			if (!carDomainType.toString().equals("select"))
				sysout(carDomainType.toString());
		}
		untab();
		String in = sysin();
		if (in.trim().length() > 0)
			carDomainType = CarDomainType.valueOf(in);
		sysout("How much money do you want spend maximally? (zlotys)");
		in = sysin();
	}

	private static void step2Window() throws ExitInputedException, RestartInputedException, FinishInputedException {
		String in;
		sysline();
		sysout("STEP 2");
		sysline();
		sysout("What is the car type?");
		tab();
		for (CarType carType : CarType.values()) {
			if (!carType.toString().equals("select"))
				sysout(carType.toString());
		}
		untab();
		in = sysin();
		if (in.trim().length() > 0)
			carType = CarType.valueOf(in);
		sysout("What is the fuel type preference?");
		tab();
		for (FuelType fuelType : FuelType.values()) {
			if (!fuelType.toString().equals("select"))
				sysout(fuelType.toString());
		}
		untab();
		in = sysin();
		if (in.trim().length() > 0)
			fuelType = FuelType.valueOf(in);
		sysout("What should be the maximal average cost of driving the 100km? (zlotys)");
		in = sysin();
		if (in.trim().length() > 0)
			burningMax = Double.valueOf(in);
		sysout("How much can the car have kilometers made?");
		in = sysin();
		if (in.trim().length() > 0)
			kilometersMax = Double.valueOf(in);
		sysout("Specify the engine capacity (dm^3):");
		tab();
		sysout("minimum");
		in = sysin();
		if (in.trim().length() > 0)
			capacityMin = Double.valueOf(in);

		sysout("maximum");
		in = sysin();
		if (in.trim().length() > 0)
			capacityMax = Double.valueOf(in);
		untab();
	}

}
