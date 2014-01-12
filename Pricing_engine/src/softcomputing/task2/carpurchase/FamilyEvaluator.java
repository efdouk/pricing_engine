/**
 * @author Konrad Zdanowicz (zdanowicz.konrad@gmail.com)
 * 
 */
package softcomputing.task2.carpurchase;

import java.util.List;
import java.util.Map;

import softcomputing.task2.carpurchase.engine.FeatureCompiler;
import softcomputing.task2.carpurchase.engine.FeatureWeightsFactory;
import softcomputing.task2.carpurchase.engine.RuleCompiler;
import softcomputing.task2.carpurchase.engine.api.Evaluator;
import softcomputing.task2.carpurchase.engine.api.Rule;
import softcomputing.task2.carpurchase.engine.rules.RuleFactory;
import softcomputing.task2.carpurchase.model.Car;
import softcomputing.task2.carpurchase.model.CarFeature;
import softcomputing.task2.carpurchase.model.CarType;

public class FamilyEvaluator implements Evaluator {

	@Override
	public double evaluate(Car car) {
		List<Double> normalizedValues = car.getNormalizedValues();
		List<Rule> rules = RuleFactory.create("10,/10,/10,custom:{(1->1)(0.75->1)(0.4->0.1)},/2,50,1,/1,/10");
		double parametersEvaluation = RuleCompiler.compile(rules, normalizedValues);

		Map<String,Double> weights = FeatureWeightsFactory.<CarFeature>create("1,0,0,0,1,1,1,1,1",CarFeature.values());
		double featureEvaluation=FeatureCompiler.compile(weights,car.getFeatures());
		
		weights = FeatureWeightsFactory.<CarType>create("0,1,0,0,0,1,0,0,1",CarType.values());
		double carTypeEvaluation=FeatureCompiler.compile(weights, car.getType());
		return 10*parametersEvaluation+5*featureEvaluation+1*carTypeEvaluation;
	} 

}
