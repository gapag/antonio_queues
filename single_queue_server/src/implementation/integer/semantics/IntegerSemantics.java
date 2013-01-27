package implementation.integer.semantics;

import datatypes.OperationSemantics;

/**
 * defines the operation semantics for integers
 * @author gapag
 *
 */
public class IntegerSemantics extends OperationSemantics<Integer> {

	@Override
	public Integer zero() {
		return 0;
	}

	@Override
	public Integer subtract(Integer t1, Integer t2) {
		return t1 - t2;
	}

	@Override
	public Integer add(Integer t1, Integer t2) {
		return t1 + t2;
	}

	@Override
	public Integer divide(Integer t1, Integer t2) {
		return t1 / t2;
	}

	@Override
	public Integer multiply(Integer t1, Integer t2) {
		return t1 * t2;
	}

	@Override
	public int compare(Integer o1, Integer o2) {
		return o1.compareTo(o2);
	}
	
	public Integer cast(int t){
		return t;
	}

}
