/**
 * @author Konrad Zdanowicz (zdanowicz.konrad@gmail.com)
 * 
 */
package softcomputing.task2.carpurchase.engine.rules;

import softcomputing.task2.carpurchase.engine.api.Rule;

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
