/**
 * @author Konrad Zdanowicz (zdanowicz.konrad@gmail.com)
 * 
 */
package softcomputing.task2.carpurchase.engine;

import java.util.Map;
import java.util.Set;

/**
 * Generic util for compiling attributes with corresponding weights
 */
public class AttributesCompiler {

	/**
	 * Evaluate weights with attributes
	 * @param weights map of ATTR_NAME->VALUE
	 * @param list of attributes 
	 * @return evaluation for inputs
	 */
	public static <T> double compile(Map<String, Double> weights, Set<T> attributes) {
		double evaluation = 0;
		for (T attribute : attributes) {
			evaluation += weights.containsKey(attribute.toString()) ? weights.get(attribute.toString()) : 0;
		}
		return evaluation;
	}

}
