/**
 * @author Konrad Zdanowicz (zdanowicz.konrad@gmail.com)
 * 
 */
package softcomputing.task2.carpurchase.model;

/**
 * 
 */
public class CarEvaluation {

	private Car car;
	private double evaluation;

	public CarEvaluation(Car car, double evaluation) {
		this.car = car;
		this.evaluation = evaluation;
		
	}

	@Override
	public String toString() {
		return "CarSuggestion [car=" + car + ", evaluation=" + evaluation + "]";
	}
	
	
}
