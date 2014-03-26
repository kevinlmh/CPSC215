/**
 * File: ArrayElementIterator.java
 *
 * This class implements an iterator for the ADT array list.
 *
 * @author Takunari Miyazaki
 * @see NoSuchElementException
 */

public class ArrayElementIterator<E> implements Iterator<E> {

  protected IndexList<E> list;
  protected int cursor;

  /** Creates an element iterator over the given list. */
  ArrayElementIterator(IndexList<E> l) {
    list = l;
    cursor = (list.isEmpty())? -1 : 0;
  }

  /** Tests whether there are elements left in the iterator. */
  public boolean hasNext() { return (cursor != -1); }

  /** Returns the next element in the iterator. */
  public E next() throws NoSuchElementException {
    if (cursor == -1)
      throw new NoSuchElementException("No next element");
    E toReturn = list.get(cursor);
    cursor = (cursor == list.size() - 1)? -1 : cursor + 1;
    return toReturn;
  }

}
