package core;
import events.Arrival;
import events.Service;

/**
 * A job is a structure having two timed events: an arrival and a service time. It
 * models a schedulable object in the queue.
 */

public class Job<E extends Number> {

	Arrival<E> arrival;
	Service<E> service;
	
	public E getArrival() {
		return arrival.getTime();
	}

	public E getDuration() {
		return service.getTime();
	}
	
	
	public void setArrival(E newTime){
		arrival.setTime(newTime);
	}
	
	public void setDuration(E newTime) {
		service.setTime(newTime);
	}

	
	public Job(Arrival<E> arr, Service<E> ser){
		this.arrival = arr;
		this.service = ser;
	}
	
}
