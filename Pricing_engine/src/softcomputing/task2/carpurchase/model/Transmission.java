/**
 * @author Konrad Zdanowicz (zdanowicz.konrad@gmail.com)
 * 
 */
package softcomputing.task2.carpurchase.model;

/**
 * Transmission type
 */
public enum Transmission {
	MANUAL(0.1), HYBRID(0.5),  AUTOMATIC(1.);

	private double val;
	
	Transmission(double val) {
		this.val=val;
	}
	public Double getNormalized() {
		return val;
	}
}
