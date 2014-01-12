/**
 * @author Konrad Zdanowicz (zdanowicz.konrad@gmail.com)
 * 
 */
package softcomputing.task2.carpurchase.engine;

import java.util.HashMap;
import java.util.Map;

import softcomputing.task2.carpurchase.engine.api.Attributes;

public class AttributesFactory {

	public static <T> Map<String, Double> create(String weights, Attributes<T>[] attributes) {
		Map<String, Double> toReturn = new HashMap<String, Double>();
		String[] exploder = weights.split(",");

		for (int i = 0; i < exploder.length; i++) {
			if (!exploder[i].equals("0")) {
				toReturn.put(attributes[i].toString(), Double.valueOf(exploder[i]));
			}
		}
		return toReturn;
	}

}
