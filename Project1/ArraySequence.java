/** 
 * File: ArraySequence.java
 *
 * Realization of a sequence by means of an array, which is doubled 
 * when the size of the sequence exceeds the capacity of the array.
 *
 * @author Kevin Liu
 * @see IndexOutOfBoundsException
 */

public class ArraySequence<E> implements Sequence<E> {

  private E[] A;              // array storing the elements of the sequence
  private int capacity = 16;  // initial length of array A
  private int size = 0;       // number of elements stored in the sequence

  /** Creates the indexed array with initial capacity 16. */
  public ArraySequence() { 
    A = (PositionObject<E>[]) new PositionObject[capacity]; // initialize the array of Positon Objects using the way I learned in class
  }
	
	// ArrayIndexList methods
	
  /** Returns the size of the sequence. */
  public int size() {
    return size;
  }

  /** Checks whether the sequence is empty. */
  public boolean isEmpty() {
    return (size() == 0);
  }

  /** Checks whether the index r is in the range between 0 and n - 1. */
  public void checkIndex(int r, int n) throws IndexOutOfBoundsException {
    if ((r < 0) || (r >= n))
      throw new IndexOutOfBoundsException("Given index is out of bounds.");
  }

	/** Checks whether the position p is in the valid range */
	public void checkPosition(PositionObject<E> p, int n) 
		throws InvalidPositionException {
		if (p.index() < 0 || p.index() >= n)
			throw new InvalidPositonException("Invalid Positon!");
	}
		
  /** Inserts an element at the given index. */
  public void add(int r, E e) throws IndexOutOfBoundsException {
    checkIndex(r, size() + 1);
    if (size == capacity) {        // an overflow
      capacity *= 2;
      E[] B =(PositionObject<E>[]) new PositionObject[capacity];
      for (int i=0; i<size; i++) 
				B[i] = A[i];
      A = B;
    }
    for (int i=size-1; i>=r; i--)  // shift elements up
      A[i+1] = A[i];
		A[r] = new PositionObject<E>(e,r);
    size++;
  }

  /** Returns the element at index r, without removing it. */
  public E get(int r) throws IndexOutOfBoundsException {
    checkIndex(r, size());
    return A[r].element();
  }

  /** Removes the element stored at the given index. */
  public E remove(int r) throws IndexOutOfBoundsException {
    checkIndex(r, size());
    E temp = A[r];
    for (int i=r; i<size-1; i++)   // shift elements down
      A[i] = A[i+1];
    size--;
    return temp.element();
  }

  /** Replaces the element f at index r with e, returning f. */
  public E set(int r, E e) throws IndexOutOfBoundsException {
    checkIndex(r, size());
    E temp = A[r];
    A[r] = new PositionObject<E>(e,r);
    return temp.element();
  }

	// Sequence methods

	/** Returns the position containing the element at the given index. */
  public PositionObject<E> atIndex(int r) throws BoundaryViolationException {
		if (p.index() < 0 || p.index() >= size())
			throw new BoundaryViolationException("Boundary Violation!");	
		return A[i];	
	}

  /** Returns the index of the element stored at the given position. */
  public int indexOf(PositionObject<E> p) throws InvalidPositionException {
		checkPosition(p, size());
		return p.index();
	}

	// Deque methods

	/** Returns the first element; an exception is thrown if deque is empty. */
  public E getFirst() throws EmptyDequeException {
		if (isEmpty())
			throw new EmptyDequeException("Sequence is empty!");
		return get(0).element(); 
	}

  /** Returns the last element; an exception is thrown if deque is empty. */
  public E getLast() throws EmptyDequeException {
		if (isEmpty())
			throw new EmptyDequeException("Sequence is empty");
		return get(size()-1).element() ;
	}

  /** Inserts an element to be the first in the deque. */
  public void addFirst (E element) {
		add(0, element);
	} 

  /** Inserts an element to be the last in the deque. */
  public void addLast (E element) {
		add(size()-1, element);
	}

  /** Removes the first element; an exception is thrown if deque is empty. */
  public E removeFirst() throws EmptyDequeException {
		if (isEmpty())
			throw new EmptyDequeException("Sequence is empty");
		remove(0);		
	}

  /** Removes the last element; an exception is thrown if deque is empty. */
  public E removeLast() throws EmptyDequeException {
		if (isEmpty())
			throw new EmptyDequeException("Sequence is empty");
		remove(size()-1);
	}
	
	// ArrayPositionList methods 
	/** Returns the first node in the list. */
  public PositionObject<E> first() {
		return get(0);
	}

  /** Returns the last node in the list. */
  public PositionObject<E> last() {
		return get(size()-1);
	}

  /** Returns the position object after a given position object in the list. */
  public PositionObejct<E> next(PositionObject<E> p) 
    throws InvalidPositionException, BoundaryViolationException {
		checkPosition(p, size());
		if (p.index() + 1 < 0 || p.index() + 1 >= size())
			throw new BoundaryViolationException("Boundary Violation!");
		return get(p.index() + 1);
	}

  /** Returns the position object before a given position object in the list. */
  public PositionObject<E> prev(PositionObject<E> p) 
    throws InvalidPositionException, BoundaryViolationException {
		checkPosition(p, size());
		if (p.index() - 1 < 0 || p.index() - 1 >= size())
			throw new BoundaryViolationException("Boundary Violation!");
		return get(p.index()-1);
	}

  /** Inserts an element after the given node in the list. */
  public void addAfter(Position<E> p, E e) throws InvalidPositionException {
		checkPosition(p, size());
		add(p.index() + 1, e);
	}

  /** Inserts an element before the given element in the sequence. */
  public void addBefore(Position<E> p, E e) throws InvalidPositionException {
		checkPosition(p, size());
		add(p.index() - 1, e);
	}

  /** Removes a node from the list, returning the element stored there. */
  public E remove(Position<E> p) throws InvalidPositionException {
		checkPosition(p, size());
	  return remove(p.index());
	}

  /** Replaces the element stored at the given node, returning old element. */
  public E set(Position<E> p, E e) throws InvalidPositionException {
		checkPosition(p, size());
		set(p.index(), e);
	}

}
