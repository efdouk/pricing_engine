/**
 * @author Konrad Zdanowicz (zdanowicz.konrad@gmail.com)
 * 
 */
package softcomputing.task2.carpurchase.model;

import java.util.Set;

/**
 * 
 */
public class Step3UserRequest {

	private Set<CarFeature> features;

	public Step3UserRequest(Set<CarFeature> features) {
		this.features = features;
	}

	public Set<CarFeature> getFeatures() {
		return features;
	}

	public void setFeatures(Set<CarFeature> features) {
		this.features = features;
	}

}
