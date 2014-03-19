/**
 * File: PositionObject.java
 *
 * A class that implements the Position interface
 * Supports two operations: to return the 
 * element stored at the given position and 
 * to return the index of a given position.
 * 
 * @author Kevin Liu
 * @version 1.0 03/18/2014
 * @see Position
 */

public class PositionObject<E> implements Position<E> {
	protected int index;
	protected E element;
  
	/**	
	 * Constructs a Position Object with index i and element e
	 * @param e the element to be stored in this position
	 * @param i the index of this position
	 */
	public PositionObject(E e, int i) {
		index = i;
		element = e;
	}

	/** 
	 * Returns the element stored at this position. 
	 * @return the element stored at this position
	 */
  public E element() {
		return element;		
	}

	/**
	 * Returns the index of this position
	 * @return the index of this position
	 */
	public int index() {
		return index;
	}
	
	/**
	 * Sets the element stored at this position
	 * @param e the element to be stored at this position
	 */
	public void setElement(E e) {
		element = e;
	}

	/**
	 * Sets the index of this position
	 * @param i the index of this position
	 */
	public void setIndex(int i) {
		index = i;
	}

}
