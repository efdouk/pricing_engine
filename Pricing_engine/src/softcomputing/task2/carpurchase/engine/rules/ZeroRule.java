/**
 * @author Konrad Zdanowicz (zdanowicz.konrad@gmail.com)
 * 
 */
package softcomputing.task2.carpurchase.engine.rules;

import softcomputing.task2.carpurchase.engine.api.Rule;

/**
 * Default rule - always return zero. can be notated as
 * 
 * - or 0
 */
public class ZeroRule implements Rule {

	@Override
	public double eval(double in) {
		return 0;
	}

}
