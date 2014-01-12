/**
 * @author Konrad Zdanowicz (zdanowicz.konrad@gmail.com)
 * 
 */
package softcomputing.task2.carpurchase.engine.rules;

import softcomputing.task2.carpurchase.engine.api.Rule;

public class ZeroRule implements Rule {

	@Override
	public double eval(double in) {
		return 0;
	}

}
