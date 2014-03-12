/**
 * File: PositionObject.java
 *
 * A position object that has a single operation to return the 
 * element stored at the given position.
 * 
 * @author Yisheng cai
 * @version 1.0.0 03/23/13
 */

public class PositionObject<E> implements Position<E> {
	private int i;    // References to the indeces
	private E e;   // Element stored in this position
	
	// Constructor
  /**@param integer index and type E element that is in this position object
  */
	public PositionObject(int ind, E element){
		i = ind;
		e = element;
	}
	
	// Accessor methods
	/**@return type E element that is at this position object
  */
  public E element() throws InvalidPositionException {
    if (i<0)
      throw new InvalidPositionException("Position is not in the list!");
    return e;
  }

  /**@return an integer that is at this position object
  */
  public int index() throws InvalidPositionException {
    if (i<0)
      throw new InvalidPositionException("Position is not in the list!");
    return i;
  }

  // Update methods
  /**@param an integer that is at this position object desired to be set
  */
  public void setIndex(int index) { i = index; }

  /**@param type E element that will be set at this position object
  */
  public void setElement(E elt) { e = elt; }

}
