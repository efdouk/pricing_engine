/**
 * @author Konrad Zdanowicz (zdanowicz.konrad@gmail.com)
 * 
 */
package softcomputing.task2.carpurchase.rules;

/**
 * 
 */
public class ProportionalRule implements Rule {

	private double param=0;
	public ProportionalRule(double d) {
		this.param=d;
	}
	public ProportionalRule() {
	}
	@Override
	public double eval(double in) {
		return param*in;
	}

}
