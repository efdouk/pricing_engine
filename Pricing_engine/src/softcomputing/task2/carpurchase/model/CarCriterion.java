/**
 * @author Konrad Zdanowicz (zdanowicz.konrad@gmail.com)
 * 
 */
package softcomputing.task2.carpurchase.model;

import softcomputing.task2.carpurchase.CarEvaluator;
import softcomputing.task2.carpurchase.engine.api.Evaluable;
import softcomputing.task2.carpurchase.engine.api.Evaluator;

/**
 * Enumeration for car criterions
 * 
 * note that this class is evaluable, which means that each carCriterion has own
 * evaluator, which parameters are defined in the constructor
 */
public enum CarCriterion implements Evaluable {	
	
	select(null) ,
	
	COMFORT(new CarEvaluator("custom:{(5->5)},-,1,-,-,1,1,1,-", "1,0,1,1,0,0,1,0,1", "0,0,0,1,0,1,1,0,1", 1., 5., 10.)),

	PERFORMANCE(new CarEvaluator("-,1,10,-,-,-,1,1,1", "0,0,0,0,0,1,0,0,0", "0,0,1,0,1,0,0,0,1", 1., 5., 10.)),

	HANDLING(new CarEvaluator("-,-,2,custom:{(0.2->1)},-,-,5,4,5", "0,1,0,0,1,0,0,0,0", "0,1,0,0,0,0,1,1,1", 1., 5., 10.)),

	ECONOMY(new CarEvaluator("-,/200,/20,custom:{(0.1->1)(0.2->1)(0.75->0.7)},/10,-,-,-,-", "0,0,0,0,0,0,0,0,0", "1,0,0,0,0,0,0,1,0", 1., 5., 10.)),

	QUALITY(new CarEvaluator("-,-,2,1,-,-,-,10,/10", "1,0,1,1,1,1,0,1,0", "0,1,0,1,0,0,0,0,1", 1., 5., 10.));

	private Evaluator evaluator;

	CarCriterion(Evaluator evaluator) {
		this.evaluator = evaluator;
	}

	@Override
	public Evaluator getEvaluator() {
		return evaluator;
	}
}
