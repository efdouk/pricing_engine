/**
 * @author Konrad Zdanowicz (zdanowicz.konrad@gmail.com)
 * 
 */
package softcomputing.task2.carpurchase.model;

import java.util.Set;

/**
 * 
 */
public class Step2UserRequest {
	Double burningMin;
	Double burningMax;
	CarType carType;
	Double kilometersMin;
	Double kilometersMax;
	Double capacityMin;
	Double capacityMax;
	Set<FuelType> fuelType;
	public Step2UserRequest(Double burningMin, Double burningMax, CarType carType, Double kilometersMin, Double kilometersMax, Double capacityMin, Double capacityMax, Set<FuelType> fuelType) {
		this.burningMin = burningMin;
		this.burningMax = burningMax;
		this.carType = carType;
		this.kilometersMin = kilometersMin;
		this.kilometersMax = kilometersMax;
		this.capacityMin = capacityMin;
		this.capacityMax = capacityMax;
		this.fuelType = fuelType;
	}
	public Double getBurningMin() {
		return burningMin;
	}
	public void setBurningMin(Double burningMin) {
		this.burningMin = burningMin;
	}
	public Double getBurningMax() {
		return burningMax;
	}
	public void setBurningMax(Double burningMax) {
		this.burningMax = burningMax;
	}
	public CarType getCarType() {
		return carType;
	}
	public void setCarType(CarType carType) {
		this.carType = carType;
	}
	public Double getKilometersMin() {
		return kilometersMin;
	}
	public void setKilometersMin(Double kilometersMin) {
		this.kilometersMin = kilometersMin;
	}
	public Double getKilometersMax() {
		return kilometersMax;
	}
	public void setKilometersMax(Double kilometersMax) {
		this.kilometersMax = kilometersMax;
	}
	public Double getCapacityMin() {
		return capacityMin;
	}
	public void setCapacityMin(Double capacityMin) {
		this.capacityMin = capacityMin;
	}
	public Double getCapacityMax() {
		return capacityMax;
	}
	public void setCapacityMax(Double capacityMax) {
		this.capacityMax = capacityMax;
	}
	public Set<FuelType> getFuelType() {
		return fuelType;
	}
	public void setFuelType(Set<FuelType> fuelType) {
		this.fuelType = fuelType;
	}
	
	
}
