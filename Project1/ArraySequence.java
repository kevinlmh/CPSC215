/** 
 * File: ArraySequence.java
 *
 * Realization of a sequence by means of an array, which is doubled 
 * when the size of the sequence exceeds the capacity of the array.
 *
 * @author Kevin Liu
 * @version 1.0 March-13-2014
 * @see Sequence
 * @see IndexOutOfBoundsException
 * @see BoundaryViolationException
 * @see InvalidPositionException
 * @see EmptyDequeException
 */

public class ArraySequence<E> implements Sequence<E> {

  private PositionObject<E>[] A;	// array storing the elements of the sequence
  private int capacity = 16;  		// initial length of array A
  private int size = 0;       		// number of elements stored in the sequence

  /** Creates the indexed array with initial capacity 16. */
  public ArraySequence() { 
    A = (PositionObject<E>[]) new PositionObject[capacity]; // initialize the array of Positon Objects 
  }
	
	// Sequence methods

	/** 
	 * Returns the position containing the element at the given index. 
	 * @param r an index
	 * @return the PositionObject at index r
	 */
  public Position<E> atIndex(int r) throws BoundaryViolationException {
		checkBoundary(r, size());
		return (PositionObject<E>)A[r];	
	}

  /** 
   * Returns the index of the element stored at the given position. 
   * @param p a PositionObject
   * @return the index of the Position
   */
  public int indexOf(Position<E> p) throws InvalidPositionException {
		checkPosition(p, size());
		return ((PositionObject<E>)p).index();
	}
	
	// ArrayIndexList methods
	
  /** 
   * Returns the size of the sequence. 
   * @return the size of the sequence
   */
  public int size() {
    return size;
  }

  /**
   * Checks whether the sequence is empty. 
   * @return true if the sequence is empty, false otherwise
   */
  public boolean isEmpty() {
    return (size() == 0);
  }

  /** 
   * Checks whether the index r is in the range between 0 and n - 1. 
   * @param r the index you want to check
   * @param the upper bound of the range
   * @return true if 0 < r <n, false otherwise
   */
  public void checkIndex(int r, int n) throws IndexOutOfBoundsException {
    if ((r < 0) || (r >= n))
      throw new IndexOutOfBoundsException("Given index is out of bounds.");
  }

	/**
	 * Checks whether the position p is in the valid range 
	 * @param p the position you want to check
	 * @param n the upper bound of the range
	 */
	public void checkPosition(Position<E> p, int n) 
		throws InvalidPositionException {
		if (((PositionObject<E>)p).index() < 0 || ((PositionObject<E>)p).index() >= n)
			throw new InvalidPositionException("Invalid Positon!");
	}

	/** 
	 * Checks whether the index r is out of bound 
	 * @param r the index you want o check
	 * @param n the upper bound
	 */	
	public void checkBoundary(int r, int n) throws BoundaryViolationException {
		if (r < 0 || r >= n)
			throw new BoundaryViolationException("Boundary Violation!");
	}

	/** 
	 * Checks wheter the sequence is empty 	 
	 */
	public void checkEmpty() throws EmptyDequeException {
		if (isEmpty())
			throw new EmptyDequeException("Sequence is empty!");
	}

  /**
   * Inserts an element at the given index. 
   * @param r the index where you want to add an element
   * @param e the element you want to add at index 
   */
  public void add(int r, E e) throws IndexOutOfBoundsException {
    checkIndex(r, size() + 1);
    if (size == capacity) {        // an overflow
      capacity *= 2;
      PositionObject<E>[] B =(PositionObject<E>[]) new PositionObject[capacity];
      for (int i=0; i<size; i++) 
				B[i] = A[i];
      A = B;
    }
    for (int i=size-1; i>=r; i--)  // shift elements up
      A[i+1] = A[i];
		A[r] = new PositionObject<E>(e,r);
    size++;
  }

  /**
   * Returns the element at index r, without removing it. 
   * @param r the index of the element
   * @return the element at index r
   */
  public E get(int r) throws IndexOutOfBoundsException {
    checkIndex(r, size());
    return ((PositionObject<E>)A[r]).element();
  }

  /**
   * Removes the element stored at the given index. 
   * @param r the index of the element
   * @return the element removed
   */
  public E remove(int r) throws IndexOutOfBoundsException {
    checkIndex(r, size());
    E temp = A[r].element();
    for (int i=r; i<size-1; i++)   // shift elements down
      A[i] = A[i+1];
    size--;
    return temp;
  }

  /**
   * Replaces the element f at index r with e, returning f. 
   * @param r the index of the element you want to replace
   * @param e the new element
   * @return the old element
   */
  public E set(int r, E e) throws IndexOutOfBoundsException {
    checkIndex(r, size());
    E temp = A[r].element();
    A[r] = new PositionObject<E>(e,r);
    return temp;
  }

	// Deque methods

	/** 
	 * Returns the first element; an exception is thrown if sequence is empty. 
	 * @return the first element in the Sequence
	 */
  public E getFirst() throws EmptyDequeException {
		checkEmpty();
		return get(0); 
	}

  /**
   * Returns the last element; an exception is thrown if sequence is empty. 
   * @return the last element in the sequence
   */
  public E getLast() throws EmptyDequeException {
		checkEmpty();
		return get(size()-1);
	}

  /** 
   * Inserts an element to be the first in the sequence. 
   * @param element the element to be added at the front of the sequence
   */
  public void addFirst (E element) {
		add(0, element);
	} 

  /** 
   * Inserts an element to be the last in the sequence. 
   * @param element the element to be added at the rear of the sequence
   */
  public void addLast (E element) {
		add(size()-1, element);
	}

  /** 
   * Removes the first element; an exception is thrown if deque is empty. 
   * @return the element removed i.e. the first element
   */
  public E removeFirst() throws EmptyDequeException {
		checkEmpty();
		return remove(0);		
	}

  /** 
   * Removes the last element; an exception is thrown if deque is empty. 
   * @return the element removed i.e. the last element
   */
  public E removeLast() throws EmptyDequeException {
		checkEmpty();
		return remove(size()-1);
	}
	
	// ArrayPositionList methods 
	
	/** 
	 * Returns the first node in the list. 
	 * @return the Position of the first element
	 */
  public Position<E> first() {
		return A[0];
	}

  /** 
   * Returns the last node in the list. 
   * @return the Position of the last element
   */
  public Position<E> last() {
		return A[size()-1];
	}

  /** 
   * Returns the position object after a given position object in the list. 
   * @param p a Position
   * @return the next Position
   */
  public Position<E> next(Position<E> p) 
    throws InvalidPositionException, BoundaryViolationException {
		checkPosition(p, size());
		checkBoundary(((PositionObject<E>)p).index() + 1, size());
		return (PositionObject<E>)A[((PositionObject<E>)p).index() + 1];
	}

  /** 
   * Returns the position object before a given position object in the list. 
   * @param p a Position
   * @return the previous Position
   */
  public Position<E> prev(Position<E> p) 
    throws InvalidPositionException, BoundaryViolationException {
		checkPosition(p, size());
		checkBoundary(((PositionObject<E>)p).index() -1, size());
		return A[((PositionObject<E>)p).index()-1];
	}

  /** 
   * Inserts an element after the given node in the list. 
   * @param p the Position you want to insert after
   * @param e the element you want to insert after p
   */
  public void addAfter(Position<E> p, E e) throws InvalidPositionException {
		checkPosition(p, size());
		add(((PositionObject<E>)p).index() + 1, e);
	}

  /** 
   * Inserts an element before the given element in the sequence. 
   * @param p the Position you want to insert before
   * @param e the element you want to insert before p
   */
  public void addBefore(Position<E> p, E e) throws InvalidPositionException {
		checkPosition(p, size());
		add(((PositionObject<E>)p).index() - 1, e);
	}

  /** 
   * Removes a node from the list, returning the element stored there. 
   * @param p the Position of the element you want to remove
   * @return the element removed
   */
  public E remove(Position<E> p) throws InvalidPositionException {
		checkPosition(p, size());
	  return remove(((PositionObject<E>)p).index());
	}

  /** 
   * Replaces the element stored at the given node, returning old element. 
   * @param p the Position you want to set
   * @param e the new element
   * @return the old element
   */
  public E set(Position<E> p, E e) throws InvalidPositionException {
		checkPosition(p, size());
		E temp = set(((PositionObject<E>)p).index(), e);
		return temp;
	}

}
