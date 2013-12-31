/**
 * @author Konrad Zdanowicz (zdanowicz.konrad@gmail.com)
 * 
 */
package softcomputing.task2.carpurchase.model;

<<<<<<< HEAD
=======
import java.util.List;
>>>>>>> 0a88908336f1f9db6e0f0bc2de8011197041ee21
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
<<<<<<< HEAD
	
=======

>>>>>>> 0a88908336f1f9db6e0f0bc2de8011197041ee21
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
	
<<<<<<< HEAD
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((averageBurning == null) ? 0 : averageBurning.hashCode());
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((doorCount == null) ? 0 : doorCount.hashCode());
		result = prime * result + ((engineCapacity == null) ? 0 : engineCapacity.hashCode());
		result = prime * result + ((features == null) ? 0 : features.hashCode());
		result = prime * result + ((fuel == null) ? 0 : fuel.hashCode());
		result = prime * result + kilometersOnTheGauge;
		result = prime * result + ((luggageCapacity == null) ? 0 : luggageCapacity.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((transmission == null) ? 0 : transmission.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + yearOfProduction;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (averageBurning == null) {
			if (other.averageBurning != null)
				return false;
		} else if (!averageBurning.equals(other.averageBurning))
			return false;
		if (brand != other.brand)
			return false;
		if (doorCount == null) {
			if (other.doorCount != null)
				return false;
		} else if (!doorCount.equals(other.doorCount))
			return false;
		if (engineCapacity == null) {
			if (other.engineCapacity != null)
				return false;
		} else if (!engineCapacity.equals(other.engineCapacity))
			return false;
		if (features == null) {
			if (other.features != null)
				return false;
		} else if (!features.equals(other.features))
			return false;
		if (fuel != other.fuel)
			return false;
		if (kilometersOnTheGauge != other.kilometersOnTheGauge)
			return false;
		if (luggageCapacity == null) {
			if (other.luggageCapacity != null)
				return false;
		} else if (!luggageCapacity.equals(other.luggageCapacity))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (transmission != other.transmission)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (yearOfProduction != other.yearOfProduction)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + ", name=" + name + ", yearOfProduction=" + yearOfProduction + ", kilometersOnTheGauge="
				+ kilometersOnTheGauge + "km, type=" + type + ", doorCount=" + doorCount + ", averageBurning=" + averageBurning
				+ "l/100km, engineCapacity=" + engineCapacity + "l, fuel=" + fuel + ", price=" + price + "zl, luggageCapacity="
				+ luggageCapacity + "l, transmission=" + transmission + ", features=" + features + "]";
	}

=======
>>>>>>> 0a88908336f1f9db6e0f0bc2de8011197041ee21
	
}
