/**
 * @author Konrad Zdanowicz (zdanowicz.konrad@gmail.com)
 * 
 */
package softcomputing.task2.carpurchase.model;

/**
 * Type of fuel for a car
 * 
 * Note that each value has a corresponding value near it, which has following
 * information: the smaller the number, the less the car maintenance cost is
 * going to be.
 */
public enum FuelType {
	GASOLINE(1.), LPG(0.75), DIESEL(0.4), HYBRID(0.2), ELECTRIC(0.01);

	private double val;

	FuelType(double val) {
		this.val = val;
	}

	public Double getNormalized() {
		return val;
	}
}
