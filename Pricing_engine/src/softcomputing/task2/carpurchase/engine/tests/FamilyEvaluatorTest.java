/**
 * @author Konrad Zdanowicz (zdanowicz.konrad@gmail.com)
 * 
 */
package softcomputing.task2.carpurchase.engine.tests;

import softcomputing.task2.carpurchase.FamilyEvaluator;
import softcomputing.task2.carpurchase.datasource.CarFactory;



/**
 * 
 */
public class FamilyEvaluatorTest {

	public static void main(String args[]) {
		FamilyEvaluator ev = new FamilyEvaluator();
		CarFactory CarFactory=new CarFactory();
		System.out.println(ev.evaluate(CarFactory.opelCorsa()));
		System.out.println(ev.evaluate(CarFactory.ferrariTestarossa()));
		System.out.println(ev.evaluate(CarFactory.mercedesSClass()));
		
	}
}
