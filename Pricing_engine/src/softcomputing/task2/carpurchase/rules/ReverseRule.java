/**
 * @author Konrad Zdanowicz (zdanowicz.konrad@gmail.com)
 * 
 */
package softcomputing.task2.carpurchase.rules;

/**
 * 
 */
public class ReverseRule implements Rule {

	private double param=1;

	public ReverseRule() {
		
	}
	public ReverseRule(double d) {
		param = d;
	}

	@Override
	public double eval(double in) {
		return param*(1.-in);
	}

}
