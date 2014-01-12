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

/**
 * Car evaluation implementation
 */
public class CarEvaluator implements Evaluator {

	private String defRules;
	private String defFeatures;
	private String defTypes;
	private double modRules;
	private double modFeatures;
	private double modTypes;

	/**
	 * Default constructor for car evaluator
	 * 
	 * @param defRules
	 *            rules definition in the CSV form, ie.
	 *            <code>1,-,custom:{(2->0.5)(1->1)},/2,-,0.4</code>
	 * @param defFeatures features weights in CSV form, ie. <code>1,0.9,0,-1</code>
	 * @param defTypes type weight in the CSV form (see example below)
	 * @param modRules power of car property rule evaluation
	 * @param modFeatures power of car features evaluation
	 * @param modTypes power of car type evaluation
	 */
	public CarEvaluator(String defRules, String defFeatures, String defTypes, double modRules, double modFeatures, double modTypes) {
		this.defRules = defRules;
		this.defFeatures = defFeatures;
		this.defTypes = defTypes;
		this.modRules = modRules;
		this.modFeatures = modFeatures;
		this.modTypes = modTypes;
	}

	/**
	 * Takes the car and the power of evaluation
	 * 
	 * @return evaluation value that comes from the compilation of car
	 *         parameters and attributes, and corresponding weight or rule
	 *         functions defined in the constructor
	 */
	@Override
	public double evaluate(Car car, Double power) {

		List<Double> normalizedValues = car.getNormalizedValues();
		List<Rule> rules = RuleFactory.create(defRules);

		double parametersEvaluation = RuleCompiler.compile(rules, normalizedValues);
		Map<String, Double> weights = AttributesFactory.<CarFeature> create(defFeatures, CarFeature.values());
		double featureEvaluation = AttributesCompiler.compile(weights, car.getFeatures());
		weights = AttributesFactory.<CarType> create(defTypes, CarType.values());
		double carTypeEvaluation = AttributesCompiler.compile(weights, car.getType());

		double evaluation = modRules * parametersEvaluation + modFeatures * featureEvaluation + modTypes * carTypeEvaluation;
		evaluation = evaluation * power;
		car.setEvaluation(car.getEvaluation() + evaluation);
		return evaluation;
	}

}
