/**
 * @author Konrad Zdanowicz (zdanowicz.konrad@gmail.com)
 * 
 */
package softcomputing.task2.carpurchase.engine.rules;

import softcomputing.task2.carpurchase.engine.api.Rule;

/**
 * Returns input value multiplied by coefficient
 * 
 * This rule is notated as regular double in the rule string, which is ie. 2,4.2,0
 */
public class ProportionalRule implements Rule {

	private double param = 0;

	public ProportionalRule(double d) {
		this.param = d;
	}

	public ProportionalRule() {
	}

	@Override
	public double eval(double in) {
		return param * in;
	}

}
