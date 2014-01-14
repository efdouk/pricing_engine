/**
 * @author Konrad Zdanowicz (zdanowicz.konrad@gmail.com)
 * 
 */
package softcomputing.task2.carpurchase.model;

import softcomputing.task2.carpurchase.CarEvaluator;
import softcomputing.task2.carpurchase.engine.api.Evaluable;
import softcomputing.task2.carpurchase.engine.api.Evaluator;

/**
 * Car type in domain language
 * 
 * Note that each value implements evaluable, so it has a corresponding
 * evaluator attached in the constructor.
 */
public enum CarDomainType implements Evaluable {
	
	UNKNOWN(null),

	FAMILY(new CarEvaluator("40,/20,/10,custom:{(1->1)(0.75->1)(0.4->0.1)},/5,50,1,/1,/10", "1,0,0,0,1,1,1,1,1", "0,1,0,0,0,1,0,0,1", 1., 5., 10.)),

	SPORT(new CarEvaluator("/10,/1,100,custom:{(1->1)(0.2->1)}			,/1,/50,-,1,/10", "0,0,0,0,0,0,0,0,1", "0,1,1,0,1,0,0,1,0", 1., 5., 10.)),

	CASUAL(new CarEvaluator("10,/20,1,custom:{(1->1)(0.75->1)(0.4->0.1)},/2,5,1,5,/10", "1,0,1,1,1,1,0,1,1", "1,1,0,0,0,0,0,1,0", 1., 5., 10.)),

	EXTREME(new CarEvaluator("-,/1,10,1,								/1,1,1,1,/10", "0,1,0,0,0,0,0,0,0", "0,0,0,0,1,1,0,0,1", 1., 5., 10.)),

	BUSINESS(new CarEvaluator("1,/20,/20,custom:{(1->1)(0.75->1)(0.4->0.1)},/2,10,1,4,/10", "1,0,1,1,1,1,1,1,0", "1,1,0,0,0,1,1,1,0", 1., 5., 10.)),

	LUXURY(new CarEvaluator("10,/1,50,custom:{(0.2->1)(0.1->1)},		-,5,1,10,/10", "1,0,1,1,0,0,1,0,1", "0,0,1,1,1,0,0,0,1", 1., 5., 10.));

	private Evaluator evaluator;

	CarDomainType(Evaluator evaluator) {
		this.evaluator = evaluator;
	}

	@Override
	public Evaluator getEvaluator() {
		return evaluator;
	}
}
