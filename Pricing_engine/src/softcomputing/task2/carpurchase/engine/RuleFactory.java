/**
 * @author Konrad Zdanowicz (zdanowicz.konrad@gmail.com)
 * 
 */
package softcomputing.task2.carpurchase.engine;

import java.util.ArrayList;
import java.util.List;

import softcomputing.task2.carpurchase.engine.api.Rule;
import softcomputing.task2.carpurchase.engine.rules.CustomRule;
import softcomputing.task2.carpurchase.engine.rules.ProportionalRule;
import softcomputing.task2.carpurchase.engine.rules.ReverseRule;
import softcomputing.task2.carpurchase.engine.rules.ZeroRule;

/**
 * Simple rule parser
 */
public class RuleFactory {
	/**
	 *	Return list of appropriate rules based on 
	 * @param rules
	 * csv representation of rules, ie.
	 * 3,/5,custom:{(1->2)},-,0
	 * @return vector of rules
	 */
	public static List<Rule> create(String rules) {
		String[] ruleArray = rules.split(",");
		List<Rule> parsedRules = new ArrayList<Rule>();
		for (int i = 0; i < ruleArray.length; i++) {
			Rule rule = getRule(ruleArray[i]);
			parsedRules.add(rule);
		}
		return parsedRules;
	}

	/**
 * 
 */
	private static Rule getRule(String attr) {
		attr=attr.trim().toLowerCase();
		if (attr.startsWith("custom:")) {
			String customRules = attr.substring(attr.indexOf("{") + 1, attr.indexOf("}"));
			return new CustomRule(customRules);
		}
		else if (attr.equals("-"))
			return new ZeroRule();
		else if (attr.substring(0, 1).equals("/"))
			return new ReverseRule(Double.parseDouble(attr.substring(1)));
		else
			return new ProportionalRule(Double.parseDouble(attr));
	}

}
