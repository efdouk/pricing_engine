/**
 * @author Konrad Zdanowicz (zdanowicz.konrad@gmail.com)
 * 
 */
package softcomputing.task2.carpurchase.engine.tests;

import java.util.Map;

import softcomputing.task2.carpurchase.engine.AttributesFactory;
import softcomputing.task2.carpurchase.model.CarFeature;

/**
 * 
 */
public class AttributesFactoryTest {
	public static void main(String[] args) {
		Map<String, Double> weights = AttributesFactory.<CarFeature>create("1,0.5,-1,0,1", CarFeature.values());
		System.out.println(weights);
	}
}
