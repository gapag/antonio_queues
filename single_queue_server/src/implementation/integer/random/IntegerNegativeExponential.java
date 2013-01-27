package implementation.integer.random;

import java.util.Random;

import random.RandomNumber;

/**
 * Implementation of a random number generator drawing values from an integer negative exponential 
 * @author gapag
 *
 */
public class IntegerNegativeExponential implements RandomNumber<Integer> {

	int mean;
	
	public IntegerNegativeExponential(int mean){
		this.mean = mean;
	}
	
	// XXX The argument to the logarithm might be zero! --> result is - infinity.
	// You need to fix this somehow
	@Override
	public Integer draw() {
		return (int)Math.ceil(-Math.log(new Random().nextInt()))*mean;
	}

}
