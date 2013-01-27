package random;
/**
 * Random number generator, of type E.
 * @author gapag
 *
 * @param <E>
 */
public interface RandomNumber<E extends Number> {
	public E draw();
}
