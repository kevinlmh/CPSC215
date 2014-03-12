/**
 * File: EveryOtherElementIterator
 *
 * This class implements an every other element iterator for the ADT node list.
 * 
 * @author Max Le Merle
 * @author Yisheng Cai
 * @version 1.0.0 3/6/13
 */

public class EveryOtherElementIterator<E> implements Iterator<E> {

  protected PositionList<E> list;  // the underlying list
  protected Position<E> cursor;    // the next position
	protected Position<E> skipcursor; //the element being skipped

  /** Creates an element iterator over the given list. 
	 * @parameter PositionList<E>, takes PositionList<E> l that will be iterated.	
	 */
  public EveryOtherElementIterator(PositionList<E> L) {
    list = L;
    //cursor = (list.isEmpty())? null : list.first();
	//skipcursor = (list.isEmpty())? null : list.next(cursor);
	cursor = (list.isEmpty())? null : list.first();
  }

  /** Tests whether there are elements left in the iterator. 
	 * @return Boolean, true if there is a next value, false otherwise.
	 */
  public boolean hasNext() { //return ((cursor != null) && (skipcursor != null)); 
  							return (cursor != null) && (cursor != list.last()); }

  /** Returns the next element in the iterator. 
	 * @return E, returns the next element in the iterator.
	 */
  public E next() throws NoSuchElementException {
    /*if ((cursor == null) || (skipcursor == null))
      throw new NoSuchElementException("No next element");
    E toReturn = cursor.element();
    skipcursor = (cursor == list.last())? null : list.next(cursor);
	cursor = (skipcursor == list.last() || skipcursor == null)? null : list.next(skipcursor);
    return toReturn; */
    if (cursor == null || cursor == list.last()) 
    	throw new NoSuchElementException("No next element");
    E toReturn = cursor.element();
    cursor = (list.next(cursor) == list.last())? null : list.next(list.next(cursor));
    return toReturn;
  }

}
