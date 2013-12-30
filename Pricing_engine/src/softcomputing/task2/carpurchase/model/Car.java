/**
 * @author Konrad Zdanowicz (zdanowicz.konrad@gmail.com)
 * 
 */
package softcomputing.task2.carpurchase.model;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * Model class for the car entity
 * </p>
 * 
 * 
 * 
 */
public class Car {

	// car identification
	private CarBrand brand;
	private String name;
	private int yearOfProduction;	
	private int kilometersOnTheGauge;
	
	// car properties
	private Set<CarType> type;
	private Integer doorCount;
	private Double averageBurning;
	private Double engineCapacity;
	private FuelType fuel;
	private Double price;
	private Double luggageCapacity;
	private Transmission transmission;
	
	//car features
	private Set<CarFeature> features;

	public Car(CarBrand brand, String name, int yearOfProduction, int kilometersOnTheGauge, Set<CarType> type, Integer doorCount,
			Double averageBurning, Double engineCapacity, FuelType fuel, Double price, Double luggageCapacity,
			Transmission transmission, Set<CarFeature> features) {
		this.brand = brand;
		this.name = name;
		this.yearOfProduction = yearOfProduction;
		this.kilometersOnTheGauge = kilometersOnTheGauge;
		this.type = type;
		this.doorCount = doorCount;
		this.averageBurning = averageBurning;
		this.engineCapacity = engineCapacity;
		this.fuel = fuel;
		this.price = price;
		this.luggageCapacity = luggageCapacity;
		this.transmission = transmission;
		this.features = features;
	}
	
	
}
