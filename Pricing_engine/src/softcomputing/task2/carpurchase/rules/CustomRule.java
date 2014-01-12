/**
 * @author Konrad Zdanowicz (zdanowicz.konrad@gmail.com)
 * 
 */
package softcomputing.task2.carpurchase.rules;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomRule implements Rule {

	Map<Double, Double> valueMap = new HashMap<Double, Double>();

	public CustomRule(String customRules) {
		Pattern pattern = Pattern.compile("([\\d.]+)->([\\d.]+)");
		Matcher m = pattern.matcher(customRules);

		while (m.find()) {
			valueMap.put(Double.parseDouble(m.group(1)), Double.parseDouble(m.group(2)));
		}
	}

	@Override
	public double eval(double in) {
		if(valueMap.containsKey(in)) return valueMap.get(in);
		return 0;
	}

}
