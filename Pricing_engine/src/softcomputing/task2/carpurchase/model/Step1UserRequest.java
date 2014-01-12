/**
 * @author Konrad Zdanowicz (zdanowicz.konrad@gmail.com)
 * 
 */
package softcomputing.task2.carpurchase.model;

/**
 * Model for user request on the 1st step
 * 
 * Note that the second and third criterions are optional
 */
public class Step1UserRequest {
	CarCriterion firstCriterion;
	CarCriterion secondCriterion;
	CarCriterion thirdCriterion;
	CarDomainType carDomainType;
	Double priceMin;
	Double priceMax;
	public Step1UserRequest(CarCriterion firstCriterion, CarCriterion secondCriterion, CarCriterion thirdCriterion, CarDomainType carDomainType,Double priceMin,Double priceMax) {
		this.firstCriterion = firstCriterion;
		this.secondCriterion = secondCriterion;
		this.thirdCriterion = thirdCriterion;
		this.carDomainType = carDomainType;
		this.priceMin = priceMin;
		this.priceMax = priceMax;
	}

	public Double getPriceMin() {
		return priceMin;
	}

	public void setPriceMin(Double priceMin) {
		this.priceMin = priceMin;
	}

	public Double getPriceMax() {
		return priceMax;
	}

	public void setPriceMax(Double priceMax) {
		this.priceMax = priceMax;
	}

	public CarCriterion getFirstCriterion() {
		return firstCriterion;
	}

	@Override
	public String toString() {
		return "UserRequest [firstCriterion=" + firstCriterion + ", secondCriterion=" + secondCriterion + ", thirdCriterion=" + thirdCriterion + ", carDomainType=" + carDomainType + "]";
	}

	public CarCriterion getSecondCriterion() {
		return secondCriterion;
	}

	public CarCriterion getThirdCriterion() {
		return thirdCriterion;
	}

	public CarDomainType getCarDomainType() {
		return carDomainType;
	}

}
