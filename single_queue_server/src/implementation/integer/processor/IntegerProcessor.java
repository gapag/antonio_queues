package implementation.integer.processor;
import implementation.integer.semantics.IntegerSemantics;

import java.util.LinkedList;
import java.util.Queue;

import core.Job;
import core.Processor;


/**
 * A queue processor on events with Integer datatype.
 * @author gapag
 *
 */
public class IntegerProcessor extends Processor<Integer> {

	public IntegerProcessor(Queue<Job<Integer>> inputs) {
		super(inputs,new IntegerSemantics());		
	}

}
