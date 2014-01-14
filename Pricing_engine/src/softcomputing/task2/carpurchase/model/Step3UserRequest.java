/**
 * @author Konrad Zdanowicz (zdanowicz.konrad@gmail.com)
 * 
 */
package softcomputing.task2.carpurchase.model;

import java.util.Set;

/**
 * Third user request step
 */
public class Step3UserRequest {

	private Set<CarFeature> features;
	private CarBrand brand;
	private Double minyearOfProduction;
	private Double maxyearOfProduction;
	

	public Step3UserRequest(Set<CarFeature> features, CarBrand brand, Double minyearOfProduction, Double maxyearOfProduction) {
		this.features = features;
		this.setBrand(brand);
		this.minyearOfProduction = minyearOfProduction;
		this.maxyearOfProduction = maxyearOfProduction;
	}

	public Set<CarFeature> getFeatures() {
		return features;
	}

	public void setFeatures(Set<CarFeature> features) {
		this.features = features;
	}

	public CarBrand getBrand() {
		return brand;
	}

	public void setBrand(CarBrand brand) {
		this.brand = brand;
	}

	public Double getMinyearOfProduction() {
		return minyearOfProduction;
	}

	public void setMinyearOfProduction(Double minyearOfProduction) {
		this.minyearOfProduction = minyearOfProduction;
	}

	public Double getMaxyearOfProduction() {
		return maxyearOfProduction;
	}

	public void setMaxyearOfProduction(Double maxyearOfProduction) {
		this.maxyearOfProduction = maxyearOfProduction;
	}



}
