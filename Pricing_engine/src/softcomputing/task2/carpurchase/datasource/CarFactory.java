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
		Car aCar = new Car(CarBrand.FERRARI, "Testarossa", 1987., 150000., carType, 3., 70., 2.4, FuelType.GASOLINE, 100000.0, 2.5, Transmission.AUTOMATIC,features );
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
		features.add(CarFeature.CAR_AUDIO);
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
		Car aCar = new Car(CarBrand.MERCEDES, "S 320", 2002., 300000., carType, 5., 100., 2.8, FuelType.GASOLINE, 60000.0, 10.0, Transmission.AUTOMATIC,features );
		return aCar;
	}

	public Car bugattiVeyron() {
		LinkedHashSet<CarType> carType = new LinkedHashSet<CarType>();
		carType.add(CarType.SPORT);
		Set<CarFeature> features = new LinkedHashSet<CarFeature>();
		features.add(CarFeature.ELECTRICAL_MIRRORS);
		features.add(CarFeature.ABS);
		features.add(CarFeature.CLIMA);
		features.add(CarFeature.ELECTRICAL_WINDOWS);
		features.add(CarFeature.ALARM);
		features.add(CarFeature.HYDRAULIC_SUSPENSION);
		features.add(CarFeature.GPS);
		features.add(CarFeature.COMPUTER);
		features.add(CarFeature.CAR_AUDIO);
		Car aCar = new Car(CarBrand.BUGATTI, "Veyron EB 16.4", 2005., 150000., carType, 2., 200., 8., FuelType.GASOLINE, 200000.0, 2., Transmission.AUTOMATIC,features);
		return aCar;
	}
	
	public Car skodaOctavia() {
		LinkedHashSet<CarType> carType = new LinkedHashSet<CarType>();
		carType.add(CarType.HATCHBACK);
		Set<CarFeature> features = new LinkedHashSet<CarFeature>();
		features.add(CarFeature.ELECTRICAL_MIRRORS);
		features.add(CarFeature.ABS);
		features.add(CarFeature.CLIMA);
		features.add(CarFeature.ELECTRICAL_WINDOWS);
		features.add(CarFeature.ALARM);
		features.add(CarFeature.HYDRAULIC_SUSPENSION);
		features.add(CarFeature.GPS);
		features.add(CarFeature.CAR_AUDIO);
		Car aCar = new Car(CarBrand.SKODA, "Octavia TDI", 2009., 120000., carType, 5., 55., 1.6, FuelType.DIESEL, 50000.0, 5., Transmission.MANUAL,features );
		return aCar;
	}
	
	public Car kiaRio() {
		LinkedHashSet<CarType> carType = new LinkedHashSet<CarType>();
		carType.add(CarType.SEDAN);
		Set<CarFeature> features = new LinkedHashSet<CarFeature>();
		features.add(CarFeature.ELECTRICAL_MIRRORS);
		features.add(CarFeature.ELECTRICAL_WINDOWS);
		features.add(CarFeature.ALARM);
		features.add(CarFeature.HYDRAULIC_SUSPENSION);
		features.add(CarFeature.GPS);
		features.add(CarFeature.CAR_AUDIO);
		Car aCar = new Car(CarBrand.KIA, "Rio", 2000., 150000., carType, 5., 30., 1.4, FuelType.GASOLINE, 20000.0, 4.2, Transmission.MANUAL,features );
		return aCar;
	}
	
	public Car citroenBerlingo() {
		LinkedHashSet<CarType> carType = new LinkedHashSet<CarType>();
		carType.add(CarType.CONVERTIBLE);
		Set<CarFeature> features = new LinkedHashSet<CarFeature>();
		features.add(CarFeature.ELECTRICAL_WINDOWS);
		features.add(CarFeature.ALARM);
		features.add(CarFeature.HYDRAULIC_SUSPENSION);
		features.add(CarFeature.CAR_AUDIO);
		Car aCar = new Car(CarBrand.CITROEN, "Berlingo", 1996., 250000., carType, 5., 40., 1.4, FuelType.GASOLINE, 15000.0, 9., Transmission.MANUAL,features );
		return aCar;
	}
	
	public Car volkswagenGolf() {
		LinkedHashSet<CarType> carType = new LinkedHashSet<CarType>();
		carType.add(CarType.HATCHBACK);
		Set<CarFeature> features = new LinkedHashSet<CarFeature>();
		features.add(CarFeature.ELECTRICAL_MIRRORS);
		features.add(CarFeature.ABS);
		features.add(CarFeature.CLIMA);
		features.add(CarFeature.ELECTRICAL_WINDOWS);
		features.add(CarFeature.ALARM);
		features.add(CarFeature.HYDRAULIC_SUSPENSION);
		features.add(CarFeature.GPS);
		Car aCar = new Car(CarBrand.VOLKSWAGEN, "Golf VII", 2012., 50000., carType, 3., 35., 1.6, FuelType.DIESEL, 40000.0, 3., Transmission.AUTOMATIC, features );
		return aCar;
	}
	

	
	


}
