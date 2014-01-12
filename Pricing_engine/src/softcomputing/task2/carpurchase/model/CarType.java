/**
 * @author Konrad Zdanowicz (zdanowicz.konrad@gmail.com)
 * 
 */
package softcomputing.task2.carpurchase.model;

import softcomputing.task2.carpurchase.engine.api.Attributes;

/**
 * Car type
 * 
 * Note that this enumeration is an attribute
 */
public enum CarType implements Attributes<CarType> {
	HATCHBACK, SEDAN, SPORT, LIMOUSINE, CONVERTIBLE, VAN, PICK_UP, COUPE, SUV;

	@Override
	public CarType[] getAttributes() {
		return values();
	}
}
