package datatypes;
import java.util.Comparator;

/**
 * This class allows to generalize the operations for each numeric data type.
 * 
 * @author gapag
 *
 * @param <T> subclass of Number
 */
public abstract class OperationSemantics<T extends Number> implements Comparator<T>{
	public abstract T zero();
	public abstract T subtract(T t1, T t2);
	public abstract T add(T t1, T t2);
	public abstract T divide(T t1, T t2);
	public abstract T multiply(T t1, T t2);
	public abstract T cast(int t);
	@Override
	public abstract int compare(T o1, T o2);

}
	
