/**
 * @author Konrad Zdanowicz (zdanowicz.konrad@gmail.com)
 * 
 */
package softcomputing.task2.carpurchase.model;

import softcomputing.task2.carpurchase.rules.Evaluator;
import softcomputing.task2.carpurchase.rules.FamilyEvaluator;

/**
 * 
 */
public enum CarDomainType {
	FAMILY(new FamilyEvaluator()), SPORT(new SportEvaluator()), CASUAL(new CasualEvaluator()), EXTREME(new ExtremeEvaluator()), BUSINESS(
			new BusinessEvaluator()), LUXURY(new LuxuryEvaluator());
	private Evaluator evaluator;

	CarDomainType(Evaluator evaluator) {
		this.evaluator = evaluator;
	}
	
	public Evaluator getEvaluator() {
		return evaluator;
	}
}
