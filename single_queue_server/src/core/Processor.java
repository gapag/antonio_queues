package core;
import implementation.integer.processor.IntegerProcessor;

import java.util.LinkedList;
import java.util.Queue;

import datatypes.OperationSemantics;

import events.Service;

/**
 * Processes the events. This class is generic, and child classes need only to implement a constructor (calling the super ) setting an appropriate 
 * operation semantics. See {@link IntegerProcessor}  
 * @author gapag
 *
 * @param <E> the data type representing times
 */

public abstract class Processor<E extends Number> {
	
	SizeStatistics<E> sz;	
	Queue<Job<E>> inputs;	
	Queue<Service<E>> eventQueue;	
	OperationSemantics<E> ops;
	
	public E subtract(E t1, E t2) {
		return ops.subtract(t1, t2);
	}

	public E add(E t1, E t2) {
		return ops.add(t1, t2);
	}

	public int compare(E o1, E o2) {
		return ops.compare(o1, o2);
	}

	public Processor(Queue<Job<E>> inputs, OperationSemantics<E> sem){
		this.inputs = inputs;		
		this.eventQueue = new LinkedList<Service<E>>();
		this.ops = sem;
		this.sz = new SizeStatistics<E>(sem);
	}
	
	private void idle(Job<E> job){
		// if the events are empty,
		// annotate lengths 0
		sz.addToStats(job.getArrival(), 0);
		inputs.remove();
		// add in event queue
		eventQueue.add(new Service<E>(job.getDuration()));		
	}
	
	private void enqueueWhileServingProcess(Job<E> job, E diff){
		Service<E> peek = eventQueue.peek();
		// annotate length for time equal to diff
		sz.addToStats(diff, eventQueue.size());
		// update head of eventqueue
		eventQueue.peek().setTime(subtract(peek.getTime(),diff));
		// enqueue the new event
		eventQueue.add(new Service<E>(job.getDuration()));
	}
	
	private void enqueueImmediatelyAfterProcessServed(Job<E> job, E diff){
		Service<E> peek = eventQueue.peek();
		// difference same as zero:
		// annotate length of time equal to diff
		sz.addToStats(peek.getTime(), eventQueue.size());
		// remove head of eventqueue
		eventQueue.remove();
		// enqueue new event
		eventQueue.add(new Service<E>(job.getDuration()));
	}


	private void enqueueDuringNextActiveProcess(Job<E> job, E diff) {
		Service<E> peek = eventQueue.peek();
		// the job being worked out finishes before the enqueuing of 
		// the next input
		// annotate length for the service duration of the head of eventlist
		sz.addToStats(peek.getTime(), eventQueue.size());
		// modify head of inputlist by decrementing it of the length of the service
		job.setArrival(add(job.getArrival(), diff));
		// remove event
		eventQueue.remove();
		// 
	}
	
	public double process(){
		int time;
		int size;
		while(inputs.size() > 0){
			
			// read the input
			Job<E> job = inputs.poll();
			
			if(eventQueue.size() == 0){
				idle(job);
			}else{
				Service<E> peek = eventQueue.peek();
				E diff = subtract(peek.getTime(), job.getArrival());
				if(compareTo(diff,ops.zero()) > 0){
					enqueueWhileServingProcess(job, diff);					
				}else if (compareTo(diff, ops.zero()) == 0){
					enqueueImmediatelyAfterProcessServed(job, diff);
				}else {
					enqueueDuringNextActiveProcess(job, diff);
				}
			}
			
		}
		
		while(eventQueue.size() > 0){ // empties the event queue.
			Service<E> serv = eventQueue.peek();
			sz.addToStats(serv.getTime(), eventQueue.size());
			eventQueue.remove();	
		}
		return sz.getMeanQueueLength();
	}

	private int compareTo(E diff, E zero) {
		return ops.compare(diff, zero);
	}
	

	
}
 
