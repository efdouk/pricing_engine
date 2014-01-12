/**
 * @author Konrad Zdanowicz (zdanowicz.konrad@gmail.com)
 * 
 */
package softcomputing.task2.carpurchase.model;

import java.util.ArrayList;
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

	private double evaluation;

	// car identification
	private CarBrand brand;
	private String name;
	private Double yearOfProduction;
	private Double kilometersOnTheGauge;

	// car properties
	private Set<CarType> type;
	private Double doorCount;
	private Double averageBurningCostPer100km;
	private Double engineCapacity;
	private FuelType fuel;
	private Double price;
	private Double luggageCapacity;
	private Transmission transmission;

	// car features
	private Set<CarFeature> features;

	public Car(CarBrand brand, String name, Double yearOfProduction, Double kilometersOnTheGauge, Set<CarType> type, Double doorCount,
			Double averageBurning, Double engineCapacity, FuelType fuel, Double price, Double luggageCapacity,
			Transmission transmission, Set<CarFeature> features) {
		this.brand = brand;
		this.name = name;
		this.yearOfProduction = yearOfProduction;
		this.kilometersOnTheGauge = kilometersOnTheGauge;
		this.type = type;
		this.doorCount = doorCount;
		this.averageBurningCostPer100km = averageBurning;
		this.engineCapacity = engineCapacity;
		this.fuel = fuel;
		this.price = price;
		this.luggageCapacity = luggageCapacity;
		this.transmission = transmission;
		this.features = features;
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
		if (averageBurningCostPer100km == null) {
			if (other.averageBurningCostPer100km != null)
				return false;
		} else if (!averageBurningCostPer100km.equals(other.averageBurningCostPer100km))
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
				+ kilometersOnTheGauge + "km, type=" + type + ", doorCount=" + doorCount + ", averageBurningCostPer100km="
				+ averageBurningCostPer100km + "zl, engineCapacity=" + engineCapacity + "l, fuel=" + fuel + ", price=" + price
				+ "zl, luggageCapacity=" + luggageCapacity + "l, transmission=" + transmission + ", features=" + features + "]";
	}

	public CarBrand getBrand() {
		return brand;
	}

	public void setBrand(CarBrand brand) {
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getYearOfProduction() {
		return yearOfProduction;
	}

	public void setYearOfProduction(Double yearOfProduction) {
		this.yearOfProduction = yearOfProduction;
	}

	public Double getKilometersOnTheGauge() {
		return kilometersOnTheGauge;
	}

	public void setKilometersOnTheGauge(Double kilometersOnTheGauge) {
		this.kilometersOnTheGauge = kilometersOnTheGauge;
	}

	public Set<CarType> getType() {
		return type;
	}

	public void setType(Set<CarType> type) {
		this.type = type;
	}

	public Double getDoorCount() {
		return doorCount;
	}

	public void setDoorCount(Double doorCount) {
		this.doorCount = doorCount;
	}

	public Double getAverageBurningCostPer100km() {
		return averageBurningCostPer100km;
	}

	public void setAverageBurningCostPer100km(Double averageBurning) {
		this.averageBurningCostPer100km = averageBurning;
	}

	public Double getEngineCapacity() {
		return engineCapacity;
	}

	public void setEngineCapacity(Double engineCapacity) {
		this.engineCapacity = engineCapacity;
	}

	public FuelType getFuel() {
		return fuel;
	}

	public void setFuel(FuelType fuel) {
		this.fuel = fuel;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getLuggageCapacity() {
		return luggageCapacity;
	}

	public void setLuggageCapacity(Double luggageCapacity) {
		this.luggageCapacity = luggageCapacity;
	}

	public Transmission getTransmission() {
		return transmission;
	}

	public void setTransmission(Transmission transmission) {
		this.transmission = transmission;
	}

	public Set<CarFeature> getFeatures() {
		return features;
	}

	public void setFeatures(Set<CarFeature> features) {
		this.features = features;
	}

	public double getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(double evaluation) {
		this.evaluation = evaluation;
	}

	public List<Double> getNormalizedValues() {
		List<Double> values = new ArrayList<Double>();
		values.add(new Range(1,6).val(this.doorCount));
		values.add(new Range(0.1,200).val(averageBurningCostPer100km));
		values.add(new Range(0.5,10).val(this.engineCapacity));
		values.add(this.fuel.getNormalized());
		values.add(new Range(1000,200000).val(this.price));
		values.add(new Range(0.1,600).val(luggageCapacity));
		values.add(this.transmission.getNormalized());
		values.add(new Range(1960,2014).val(yearOfProduction));
		values.add(new Range(0,1000000).val(kilometersOnTheGauge));
		return values;
	}

	static class Range {
		private double from;
		private double to;
		public Range(double from,double to) {
			this.from = from;
			this.to = to;
			
		}
	
		
		public double val(double val) {
			return (val-from)/(to-from);
		}
	}
}
