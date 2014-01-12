/**
 * @author Konrad Zdanowicz (zdanowicz.konrad@gmail.com)
 * 
 */
package softcomputing.task2.carpurchase;

import java.util.Iterator;

import jess.Filter;
import jess.JessException;
import jess.Rete;
import jess.WorkingMemoryMarker;
import softcomputing.task2.carpurchase.datasource.Database;
import softcomputing.task2.carpurchase.datasource.MockDatabase;
import softcomputing.task2.carpurchase.model.Car;
import softcomputing.task2.carpurchase.model.CarCriterion;
import softcomputing.task2.carpurchase.model.CarDomainType;
import softcomputing.task2.carpurchase.model.CarEvaluation;
import softcomputing.task2.carpurchase.model.UserRequest;

/**
 * Sample implementation for car expert system
 */
public class CarPurchase {

	public static final Database db = new MockDatabase();
	public static final Rete engine = new Rete();

	public static void masin(String args[]) {
		try { 
			//initialize engine 
			prepareEngine();
			engine.run();
			
			//display results 
			Iterator<?> carsSuggested = engine.getObjects(new Filter.ByClass(CarEvaluation.class));
			System.out.println("The system suggests you the following cars:");
			
			while(carsSuggested.hasNext())
			{
				System.out.println(carsSuggested.next().toString());
			}
			
			// debug info
			
			Iterator<?> messages = engine.getObjects(new Filter.ByClass(String.class));
			System.out.println("------DEBUG INFO ------"
					+ "\n"
					+ "The engine had following String messages:");
			while(messages.hasNext())
			{
				System.out.println(messages.next().toString());
			}
			
		} catch (JessException e) {
			System.out.println("There was an exception while running engine.");
			e.printStackTrace();
		}
	}

	private static void prepareEngine() throws JessException {
		engine.reset();  
		engine.batch("carpurchase.clp");
		engine.addAll(db.getCars()); 
		WorkingMemoryMarker marker = engine.mark();
		engine.resetToMark(marker);
		
		//input request
		engine.add(new UserRequest(CarCriterion.COMFORT, CarCriterion.QUALITY, null, CarDomainType.FAMILY));
	}
}
