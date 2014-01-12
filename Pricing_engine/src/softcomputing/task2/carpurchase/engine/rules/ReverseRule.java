/**
 * @author Konrad Zdanowicz (zdanowicz.konrad@gmail.com)
 * 
 */
package softcomputing.task2.carpurchase.engine.rules;

import softcomputing.task2.carpurchase.engine.api.Rule;

public class ReverseRule implements Rule {

	private double param = 1;

	public ReverseRule() {

	}

	public ReverseRule(double d) {
		param = d;
	}

	@Override
	public double eval(double in) {
		return param * (1. - in);
	}

}
