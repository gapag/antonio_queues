package events;
import random.RandomNumber;
/**
 * This class creates timed events of type {@link Arrival} or {@link Service}, 
 * according to the random number generators passed as arguments. 
 * @author gapag
 *
 * @param <E>
 */
public class TimeFactory<E extends Number> {

	RandomNumber<E> interArrivalDistro;
	RandomNumber<E> durationDistro;
	
	public TimeFactory(RandomNumber<E> arr, RandomNumber<E> dur ){
		interArrivalDistro = arr;
		durationDistro = dur;
	}
	
	public Arrival<E> createArrival(){
		return new Arrival<E>(interArrivalDistro.draw());
	}
	
	public Service<E> createService(){
		return new Service<E>(durationDistro.draw());
	}
	
}
