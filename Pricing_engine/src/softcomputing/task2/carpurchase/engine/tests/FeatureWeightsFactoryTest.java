/**
 * @author Konrad Zdanowicz (zdanowicz.konrad@gmail.com)
 * 
 */
package softcomputing.task2.carpurchase.engine.tests;

import java.util.Map;

import softcomputing.task2.carpurchase.engine.FeatureWeightsFactory;
import softcomputing.task2.carpurchase.model.CarFeature;

/**
 * 
 */
public class FeatureWeightsFactoryTest {
	public static void main(String[] args) {
		Map<String, Double> weights = FeatureWeightsFactory.<CarFeature>create("1,0.5,-1,0,1", CarFeature.values());
		System.out.println(weights);
	}
}
