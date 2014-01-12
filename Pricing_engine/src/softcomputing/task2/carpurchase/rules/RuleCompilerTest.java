/**
 * @author Konrad Zdanowicz (zdanowicz.konrad@gmail.com)
 * 
 */
package softcomputing.task2.carpurchase.rules;

import java.util.ArrayList;
import java.util.List;

public class RuleCompilerTest {
	
	public static void main(String[] args) {
		
		//simpleTest();
	
		enumRuleTest();
	}

	private static void enumRuleTest() {
		List<Rule> rules=RuleFactory.create("custom:{(1->1)(0.75->1)(0.4->0.1)}");
		List<Double> values=new ArrayList<Double>();
		values.add(0.75);
		System.out.println(RuleCompiler.compile(rules, values));
	}

	private static void simpleTest() {
		List<Rule> rules=RuleFactory.create("1,/2,-");
		
		List<Double> values=new ArrayList<Double>();
		values.add(0.5);
		values.add(0.2);
		values.add(1000.);
		System.out.println(RuleCompiler.compile(rules, values));
	}
}
