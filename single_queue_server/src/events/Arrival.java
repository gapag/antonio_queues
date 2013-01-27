package events;

public class Arrival<E extends Number> extends AbstractTimedEvent<E> {

	public Arrival(E interArrival) {
		super(interArrival);
	}

}
