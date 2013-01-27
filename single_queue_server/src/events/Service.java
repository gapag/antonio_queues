package events;

/**
 * This class represents a service time.
 * @author gapag
 *
 * @param <E>
 */

public class Service<E extends Number> extends AbstractTimedEvent<E> {

	public Service(E interArrival) {
		super(interArrival);
	}

}
