/**
 * File: PositionObject.java
 *
 * A class that implements the Position interface
 * Supports two operations: to return the 
 * element stored at the given position and 
 * to return the index of a given position.
 * @author Kevin Liu
 */

public class PositionObject<E> implements Position<E> {
	protected int index;
	protected E element;
  
	/**	Constructor				*/
	public PositionObject(E e, int i) {
		index = i;
		element = e;
	}

	/** Return the element stored at this position. */
  public E element() {
		return element;		
	}

	public int index() {
		return index;
	}

}
