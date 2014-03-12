/**
 * File: ReverseElementIterator.java
 *
 * This class implements an iterator for the ADT node list.
 *
 * @author Kevin Liu
 * @author Courtney Driscoll
 * @version 1.0
 * @see Iterator
 * @see NoSuchElementException
 */

public class ReverseElementIterator<E> implements Iterator<E> {

  protected PositionList<E> list;  // the underlying list
  protected Position<E> cursor;    // the next position

  /** 
   * Creates an element iterator over the given list. 
   * @param L a list to iterate through
   */
  public ReverseElementIterator(PositionList<E> L) {
    list = L;
    cursor = (list.isEmpty())? null : list.last();
  }

  /** 
   * Tests whether there are elements left in the iterator. 
   * @return true if there is a next element, false otherwise
   */
  public boolean hasNext() { return (cursor != null); }

  /**
   * Returns the next element in the iterator. 
   * @return the next element
   */
  public E next() throws NoSuchElementException {
    if (cursor == null)
      throw new NoSuchElementException("No next element");
    E toReturn = cursor.element();
    cursor = (cursor == list.first())? null : list.prev(cursor);
    return toReturn;
  }

}
