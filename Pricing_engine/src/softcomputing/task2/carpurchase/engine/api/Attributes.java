/**
 * @author Konrad Zdanowicz (zdanowicz.konrad@gmail.com)
 * 
 */
package softcomputing.task2.carpurchase.engine.api;

/**
 * Generic Attributes interface that should be implemented by each criterion
 * that is to be treated as attribute criterium
 */
public interface Attributes<T> {
	public T[] getAttributes();
}
