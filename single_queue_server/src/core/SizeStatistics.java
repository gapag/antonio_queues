package core;
import datatypes.OperationSemantics;

/**
 * This generic class keeps track of the mean size of the queue.
 * @author gapag
 *
 * @param <E>
 */
public class SizeStatistics<E extends Number> {
	
	E weightedSum;
	E elapsed;
	double mean;
	OperationSemantics<E> ops;
	
	public SizeStatistics(OperationSemantics<E> op){
		this.ops = op;
		this.weightedSum = op.zero();
		this.elapsed = op.zero();
	}
	
	public void addToStats(E time, int size){
		weightedSum = ops.add(weightedSum, ops.multiply(time, ops.cast(size)));
		elapsed = ops.add(elapsed, time);
		mean = weightedSum.doubleValue()/elapsed.doubleValue();
	}
	
	public double getMeanQueueLength(){
		return mean;
	}
}
