/**
 * @author Konrad Zdanowicz (zdanowicz.konrad@gmail.com)
 * 
 */
package softcomputing.task2.carpurchase;

import java.util.List;
import java.util.Map;

import softcomputing.task2.carpurchase.engine.AttributesCompiler;
import softcomputing.task2.carpurchase.engine.AttributesFactory;
import softcomputing.task2.carpurchase.engine.RuleCompiler;
import softcomputing.task2.carpurchase.engine.RuleFactory;
import softcomputing.task2.carpurchase.engine.api.Evaluator;
import softcomputing.task2.carpurchase.engine.api.Rule;
import softcomputing.task2.carpurchase.model.Car;
import softcomputing.task2.carpurchase.model.CarFeature;
import softcomputing.task2.carpurchase.model.CarType;

public class CarEvaluator implements Evaluator {
	
	private String defRules;
	private String defFeatures;
	private String defTypes;
	private double modRules;
	private double modFeatures;
	private double modTypes;


	public CarEvaluator(String defRules, String defFeatures, String defTypes, double modRules, double modFeatures, double modTypes) {
		this.defRules = defRules;
		this.defFeatures = defFeatures;
		this.defTypes = defTypes;
		this.modRules = modRules;
		this.modFeatures = modFeatures;
		this.modTypes = modTypes;
	}

	@Override
	public double evaluate(Car car,Double power) {

		List<Double> normalizedValues = car.getNormalizedValues();
		List<Rule> rules = RuleFactory.create(defRules);

		double parametersEvaluation = RuleCompiler.compile(rules, normalizedValues);
		Map<String, Double> weights = AttributesFactory.<CarFeature> create(defFeatures, CarFeature.values());
		double featureEvaluation = AttributesCompiler.compile(weights, car.getFeatures());
		weights = AttributesFactory.<CarType> create(defTypes, CarType.values());
		double carTypeEvaluation = AttributesCompiler.compile(weights, car.getType());

		double evaluation = modRules * parametersEvaluation + modFeatures * featureEvaluation
				+ modTypes * carTypeEvaluation;
		evaluation = evaluation*power;
		car.setEvaluation(car.getEvaluation()+evaluation);
		return evaluation;
	}

}
