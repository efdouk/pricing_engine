/**
 * @author Konrad Zdanowicz (zdanowicz.konrad@gmail.com)
 * 
 */
package softcomputing.task2.carpurchase.engine;

import java.util.Map;
import java.util.Set;

public class FeatureCompiler {

	public static <T>double compile(Map<String, Double> weights, Set<T> features) {
		double evaluation = 0;
		for (T feature : features) {
			evaluation+=weights.containsKey(feature.toString())?weights.get(feature.toString()):0;
		}
		return evaluation;
	}

}
