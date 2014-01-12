/**
 * @author Konrad Zdanowicz (zdanowicz.konrad@gmail.com)
 * 
 */
package softcomputing.task2.carpurchase.engine;

import java.util.List;

import softcomputing.task2.carpurchase.engine.api.Rule;
/**
 * Rule compiler
 */
public class RuleCompiler {
	/**
	 * @param list of rules
	 * @param values vector
	 * @return evaluation of rules with values
	 */
	public static double compile(List<Rule> rules, List<Double> values) {
		double evaluation = 0;
		for (int i = 0; i < rules.size(); i++) {
			evaluation += rules.get(i).eval(values.get(i));
		}
		return evaluation;
	}
}
