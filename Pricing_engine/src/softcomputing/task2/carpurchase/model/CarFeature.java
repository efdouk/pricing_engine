/**
 * @author Konrad Zdanowicz (zdanowicz.konrad@gmail.com)
 * 
 */
package softcomputing.task2.carpurchase.model;

import softcomputing.task2.carpurchase.engine.api.Attributes;


/**
 * Car features
 */
public enum CarFeature implements Attributes<CarFeature> {
	CLIMA, HYDRAULIC_SUSPENSION, ELECTRICAL_WINDOWS, ELECTRICAL_MIRRORS, ABS, COMPUTER, GPS, ALARM, CAR_AUDIO,;

	@Override
	public CarFeature[] getAttributes() {
		return values();
	}
}
