package events;

/**
 * Abstract class representing a timed event
 * @author gapag
 *
 * @param <E>
 */
public class AbstractTimedEvent<E extends Number> {

	protected E time;
	
	public AbstractTimedEvent(E interArrival) {
		super();
		this.time = interArrival;
	}

	public E getTime() {
		return time;
	}

	public void setTime(E time) {
		this.time = time;
	}
}
