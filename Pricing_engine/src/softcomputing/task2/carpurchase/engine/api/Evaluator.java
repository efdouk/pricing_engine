/**
 * @author Konrad Zdanowicz (zdanowicz.konrad@gmail.com)
 * 
 */
package softcomputing.task2.carpurchase.engine.api;

import softcomputing.task2.carpurchase.model.Car;
/**
 * returns evaluation value for the car and the evaluation power
 */
public interface Evaluator {
	double evaluate(Car car,Double power);
}
