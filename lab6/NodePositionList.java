/**
 * File: NodePositionList.java
 * 
 * This class implements the ADT node list using a doubly-linked list.
 *
 * @author Roberto Tamassia
 * @author Michael Goodrich
 * @author Kevin Liu
 * @author Courtney Driscoll
 * @version 1.0
 * @see BoundaryViolationException
 * @see EmptyListException
 * @see InvalidPositionException
 * @see PositionList 
 */

public class NodePositionList<E> implements PositionList<E> {

  protected int numElts;            	// Number of elements in the list
  protected DNode<E> header, trailer;	// Special sentinels

  /** 
   * Constructor that creates an empty list - O(1) time
   */
  public NodePositionList() {
    numElts = 0;
    header = new DNode<E>(null, null, null);
    trailer = new DNode<E>(header, null, null);
    header.setNext(trailer);
  }

  /** 
   * Checks if position is valid for this list and converts it to DNode if it
   * is valid - O(1) time
   * @param p The position being checked
   * @return a DNode at position p
   */
  protected DNode<E> checkPosition(Position<E> p)
    throws InvalidPositionException {
    if (p == null)
      throw new InvalidPositionException
	("Null position passed to NodeList");
    if (p == header)
	throw new InvalidPositionException
	  ("The header node is not a valid position");
    if (p == trailer)
	throw new InvalidPositionException
	  ("The trailer node is not a valid position");
    try {
      DNode<E> temp = (DNode<E>) p;
      if ((temp.getPrev() == null) || (temp.getNext() == null))
	throw new InvalidPositionException
	  ("Position does not belong to a valid NodeList");
      return temp;
    } catch (ClassCastException e) {
      throw new InvalidPositionException
	("Position is of wrong type for this list");
    }
  }

  /**
   * Returns the number of elements in the list - O(1) time
   * @return the number of elements in the list
   */
  public int size() { return numElts; }

  /**
   * Returns whether the list is empty - O(1) time
   * @return true if the list is empty, false otherwise
   */
  public boolean isEmpty() { return (numElts == 0); }

  /**
   * Returns the first position in the list - O(1) time
   * @return the position of the first element in the list
   */
  public Position<E> first() throws EmptyListException {
    if (isEmpty())
      throw new EmptyListException("List is empty");
    return header.getNext();
  }

  /**
   * Returns the last position in the list - O(1) time
   * @return the position of the last element in the list
   */
  public Position<E> last() throws EmptyListException {
		if (isEmpty())
			throw new EmptyListException("List is empty");
		return trailer.getPrev();
  }

  /**
   * Returns the position after the given one - O(1) time
   * @param p the position of an element
   * @return the position after p
   */
  public Position<E> next(Position<E> p)
    throws InvalidPositionException, BoundaryViolationException {
		DNode<E> v = checkPosition(p);
		DNode<E> next = v.getNext();
		if (next == trailer)
			throw new BoundaryViolationException("Cannot advance past the end of the list");
		return next;
  }

  /**
   * Returns the position before the given one - O(1) time
   * @param p the position of an element
   * @return the position before p
   */
  public Position<E> prev(Position<E> p)
    throws InvalidPositionException, BoundaryViolationException {
    DNode<E> v = checkPosition(p);
    DNode<E> prev = v.getPrev();
    if (prev == header)
      throw new BoundaryViolationException
	("Cannot advance past the beginning of the list");
    return prev;
  }

  /**
   * Inserts the given element at the beginning of the list, returning the new
   * position - O(1) time
   * @param element the element you want to add to insert
   */
  public void addFirst(E element) {
    numElts++;
    DNode<E> newNode = new DNode<E>(header, header.getNext(), element);
    header.getNext().setPrev(newNode);
    header.setNext(newNode);
  }

  /**
   * Inserts the given element at the end of the list, returning the new 
   * position - O(1) time
   * @param element the element you want to insert
   */
  public void addLast(E element) {
		numElts++;
		DNode<E> newNode = new DNode<E>(trailer, trailer.getPrev(), element);
		trailer.getPrev().setNext(newNode);
		trailer.setPrev(newNode);
  }

  /** 
   * Inserts the given element after the given position, returning the new
   * position - O(1) time
   * @param p the position after which the element will be added
   * @param element the element you want to insert
   */
  public void addAfter(Position<E> p, E element) 
      throws InvalidPositionException {
		DNode<E> v = checkPosition(p);
		numElts++;
		DNode<E> newNode = new DNode<E>(v, v.getNext(), element);
		v.getNext().setPrev(newNode);
		v.setNext(newNode);
  }

  /** 
   * Inserts the given element before the given position, returning the new
   * position - O(1) time
   * @param p the position before which the element will be added
   * @param element the element you want to insert
   */
  public void addBefore(Position<E> p, E element) 
      throws InvalidPositionException {
    DNode<E> v = checkPosition(p);
    numElts++;
    DNode<E> newNode = new DNode<E>(v.getPrev(), v, element);
    v.getPrev().setNext(newNode);
    v.setPrev(newNode);
  }

  /**
   * Removes the given position from the list - O(1) time
   * @param p the position you want to remove
   * @return the element at the position removed
   */
  public E remove(Position<E> p) throws InvalidPositionException {
    DNode<E> v = checkPosition(p);
    numElts--;
    DNode<E> vPrev = v.getPrev();
    DNode<E> vNext = v.getNext();
    vPrev.setNext(vNext);
    vNext.setPrev(vPrev);
    E vElem = v.element();
    v.setNext(null);
    v.setPrev(null);
    return vElem;
  }

  /**
   * Replaces the element at the given position with the new element
   * and return the old element - O(1) time
   * @param p the position you want to rewrite
   * @param element the element you want to write to position p
   * @return the old element
   */
  public E set(Position<E> p, E element)
      throws InvalidPositionException {
    DNode<E> v = checkPosition(p);
    E oldElt = v.element();
    v.setElement(element);
    return oldElt;
  }

  /**
   * Returns an iterator of all the elements.
   * @return an iterator
   */
  public Iterator<E> iterator() {
    return new ElementIterator<E>(this);
  }
	
  /**
   * Returns a reverse iterator of all the elements.
   * @return a reverse iterator
   */
	public Iterator<E> reverseIterator() {
		return new ReverseElementIterator<E>(this);
	} 

  /**
   * Returns an EveryOtherElementIterator of all the elements.
   * @return an every-other-element iterator
   */
	public Iterator<E> everyOtherIterator() {
		return new EveryOtherElementIterator<E>(this);
	} 

}
