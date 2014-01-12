/**
 * @author Konrad Zdanowicz (zdanowicz.konrad@gmail.com)
 * 
 */
package softcomputing.task2.carpurchase.engine.rules;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import softcomputing.task2.carpurchase.engine.api.Rule;

public class CustomRule implements Rule {

	Map<Double, Double> valueMap = new HashMap<Double, Double>();

	public CustomRule(String customRules) {
		parseValueMap(customRules);
	}

	private void parseValueMap(String customRules) {
		Pattern pattern = Pattern.compile("([\\d.]+)->([\\d.]+)");
		Matcher m = pattern.matcher(customRules);

		while (m.find()) {
			valueMap.put(Double.parseDouble(m.group(1)), Double.parseDouble(m.group(2)));
		}
	}

	@Override
	public double eval(double in) {
		if (valueMap.containsKey(in))
			return valueMap.get(in);
		return 0;
	}
}
