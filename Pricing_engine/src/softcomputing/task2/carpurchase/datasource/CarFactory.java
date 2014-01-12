/**
 * @author Konrad Zdanowicz (zdanowicz.konrad@gmail.com)
 * 
 */
package softcomputing.task2.carpurchase.datasource;

import java.util.LinkedHashSet;
import java.util.Set;

import softcomputing.task2.carpurchase.model.Car;
import softcomputing.task2.carpurchase.model.CarBrand;
import softcomputing.task2.carpurchase.model.CarFeature;
import softcomputing.task2.carpurchase.model.CarType;
import softcomputing.task2.carpurchase.model.FuelType;
import softcomputing.task2.carpurchase.model.Transmission;

/**
 *  Sample implementation of car factory
 */
public class CarFactory { 

	public Car ferrariTestarossa() {
		LinkedHashSet<CarType> carType = new LinkedHashSet<CarType>();
		carType.add(CarType.SPORT);
		carType.add(CarType.COUPE);
		Set<CarFeature> features = new LinkedHashSet<CarFeature>();
		features.add(CarFeature.ELECTRICAL_MIRRORS);
		features.add(CarFeature.ABS);
		features.add(CarFeature.CLIMA);
		features.add(CarFeature.ELECTRICAL_WINDOWS);
		Car aCar = new Car(CarBrand.FERRARI, "Testarossa", 1987., 150000., carType, 3., 50., 2.4, FuelType.GASOLINE, 120000.0, 2.5, Transmission.AUTOMATIC,features );
		return aCar;
	}

	public Car opelCorsa() {
		LinkedHashSet<CarType> carType = new LinkedHashSet<CarType>();
		carType.add(CarType.COUPE);
		Set<CarFeature> features = new LinkedHashSet<CarFeature>();
		features.add(CarFeature.ELECTRICAL_MIRRORS);
		features.add(CarFeature.ABS);
		features.add(CarFeature.CLIMA);
		features.add(CarFeature.ELECTRICAL_WINDOWS);
		Car aCar = new Car(CarBrand.OPEL, "Corsa CDTI", 2007., 150000., carType, 5., 20., 1.3, FuelType.DIESEL, 20000.0, 4.1, Transmission.MANUAL,features );
		return aCar;
	}

	public Car mercedesSClass() {
		LinkedHashSet<CarType> carType = new LinkedHashSet<CarType>();
		carType.add(CarType.LIMOUSINE);
		Set<CarFeature> features = new LinkedHashSet<CarFeature>();
		features.add(CarFeature.ELECTRICAL_MIRRORS);
		features.add(CarFeature.ABS);
		features.add(CarFeature.CLIMA);
		features.add(CarFeature.ELECTRICAL_WINDOWS);
		features.add(CarFeature.ALARM);
		features.add(CarFeature.HYDRAULIC_SUSPENSION);
		features.add(CarFeature.GPS);
		features.add(CarFeature.COMPUTER);
		Car aCar = new Car(CarBrand.MERCEDES, "S 320", 2002., 300000., carType, 5., 120., 2.8, FuelType.GASOLINE, 40000.0, 6.0, Transmission.AUTOMATIC,features );
		return aCar;
	}

}
