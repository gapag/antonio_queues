package core;
import implementation.integer.processor.IntegerProcessor;
import implementation.integer.random.IntegerNegativeExponential;

import java.util.LinkedList;
import java.util.Queue;

import events.TimeFactory;

import random.RandomNumber;


public class Main {
	public static void main(String [] args){
		 System.out.println("Mean queue length: " + process(setup(1,2,1000)));
	}
	
	public static Queue<Job<Integer>> setup(int meanArr, int meanSer, int inputSize){
		RandomNumber<Integer> randomArrivals = new IntegerNegativeExponential(meanArr);
		RandomNumber<Integer> randomDurations = new IntegerNegativeExponential(meanSer);
		TimeFactory<Integer> factory = new TimeFactory<>(randomArrivals, randomDurations);
		
		Queue<Job<Integer>> queue = new LinkedList<Job<Integer>>();
		while(inputSize>0){
			queue.add(new Job<Integer>(factory.createArrival(), factory.createService()));
			inputSize--;
		}
		return queue;
	}
	
	public static double process(Queue<Job<Integer>> inputs){
		IntegerProcessor proc = new IntegerProcessor(inputs);
		return proc.process();
	}
}
