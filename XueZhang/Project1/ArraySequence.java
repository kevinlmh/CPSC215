/** 
 * File: ArraySequence.java
 *
 * Realization of an sequence by means of an array, which is doubled 
 * when the size of the sequence exceeds the capacity of the array.
 *
 * @author Yisheng Cai
 * @see IndexOutOfBoundsException
 * @see EmptyDequeException
 * @see InvalidPositionException 
 */

public class ArraySequence<E> implements Sequence<E> {

	private PositionObject<E>[] S;   // array storing the elements of the sequence
  private int capacity = 16;  // initial length of array A
  private int size = 0;       // number of elements stored in the sequence

  /** Creates the indexed list with initial capacity 16. 
	* An instance of object of size 16 is instantiated.
	*/
  public ArraySequence() {
  	S = (PositionObject<E>[]) new PositionObject[capacity];
	}

  /** Returns the size of the list. 
	* @return an integer indicating the size of the array
	*/
  public int size() {
    return size;
  }

  /** Checks whether the list is empty. 
	* @return boolean true if the array is empty, false if it is not.
	*/
  public boolean isEmpty() {
    return (size() == 0);
  }

  /** Checks whether the index r is in the range between 0 and n - 1. 
	* @param integer r indicating the index and n indicating the upperbound to test if the index is in range
	*/
  public void checkIndex(int r, int n) throws IndexOutOfBoundsException {
    if ((r < 0) || (r >= n))
      throw new IndexOutOfBoundsException("Given index is out of bounds.");
  }

	

  /** Inserts an element at the given index. 
	* @param integer r indicating the index and type E e indicating the the element inserted into the array at this index
	*/
  public void add(int r, E e) throws IndexOutOfBoundsException {
    checkIndex(r, size() + 1);
    if (size == capacity) {        // an overflow
      capacity *= 2;
      PositionObject<E>[] B =(PositionObject<E>[]) new PositionObject[capacity];
    for (int i=0; i<size; i++) 
	B[i] = S[i];
      S = B;
    }
    for (int i=size-1; i>=r; i--){  // shift elements up
      S[i+1]=S[i];
			S[i].setIndex(i+1);
		}
    S[r]=new PositionObject<E>(r,e);
    size++;
  }

  /** Returns the element at index r, without removing it. 
	* @return element type E indicating the element being accessed
	* @param integer r which is the index of the element to be accessed
	*/
  public E get(int r) throws IndexOutOfBoundsException {
    checkIndex(r, size());
    return S[r].element();
  }

  /** Removes the element stored at the given index. 
	* @return element type E indicating the element being removed
	* @param integer r which is the index of the element to be removed
	*/
  public E remove(int r) throws IndexOutOfBoundsException {
    checkIndex(r, size());
    E temp = S[r].element();
    for (int i=r; i<size-1; i++)   // shift elements down
      S[i] = S[i+1];
    size--;
    return temp;
  }

  /** Replaces the element f at index r with e, returning f. 
	* @return type E indicating the element being replaced
	* @param integer r which is the index of the element e type E that is replacing the element at r	
	*/
  public E set(int r, E e) throws IndexOutOfBoundsException {
    checkIndex(r, size());
    E temp = S[r].element();
    S[r].setElement(e);
    return temp;
  }

	/** Gets the element e from the first position object in the list. 
	* @return type E which is the element at the beginning of the array
	*/
	public E getFirst() throws EmptyDequeException {
		if (isEmpty())
			throw new EmptyDequeException("The list is empty.");
		return S[0].element();
	}

	/** Gets the element e from the last position object in the list. 
	*	@return type E which is the element at the end of the array
	*/
	public E getLast() throws EmptyDequeException {
		if (isEmpty())
			throw new EmptyDequeException("The list is empty.");
		return S[size-1].element();
	}
	
	/** Adds an element to the beginning of the list. 
	* @param type E element added to the beginning of the array
	*/
	public void addFirst (E element) {
		add(0, element);
	}

	/** Adds an element to the end of the list. 
	* @param type E element added to the end of the array
	*/
	public void addLast(E element) {
		add(size, element);
	}

	/** Removes and returns the first element; an exception is thrown if deque 		*is empty. 
	* @return type E element which is the first element that is removed
	*/
	public E removeFirst() throws EmptyDequeException {
		if (isEmpty())
			throw new EmptyDequeException("The list is empty. ");

		return remove(0);
	}

	/** Removes and returns the last element; an exception is thrown if deque 		*is empty. 
  * @return type E element which is the first element that is removed
	*/
	public E removeLast() throws EmptyDequeException {
		if (isEmpty())
			throw new EmptyDequeException("The list is empty. ");
		return remove(size-1);
	}

	/** Returns the first position object in the list. 
	* @return PositionObject that is at the beginning of the array	
	*/
	public PositionObject<E> first() {
		if (isEmpty())
			throw new InvalidPositionException("The list is empty. ");
		return S[0];
	}

	/** Returns the last position object in the list. 
	* @return PositionObject that is at the end of the array	
	*/
	public PositionObject<E> last() {
		if (isEmpty())
			throw new InvalidPositionException("The list is empty. ");
		return S[size-1];
	}
	
	/** Returns the position object after the given one in the list. 
	* @param Position<E> indicating a position 
	* @return PositionObject<E> indicating a position object after the given position
  * @exception InvalidPositionException, BoundaryViolationException when cursor reaches boundary
	*/
	public PositionObject<E> next(Position<E> p) 
		throws InvalidPositionException, BoundaryViolationException {
		if ((((PositionObject<E>) p).index() < 0) || (((PositionObject<E>) p).index() >= size()))
			throw new InvalidPositionException("Index of this position is out of bounds. ");
		int i = ((PositionObject<E>) p).index();
		if (i>=size-1)
			throw new BoundaryViolationException("The next position does not exist. ");
		return S[i+1];
	}

	/** Returns the position object previous to the given one in the list. 
	* @param Position<E> indicating a position 
	* @return PositionObject<E> indicating a position object before the given position
  * @exception InvalidPositionException, BoundaryViolationException when cursor reaches boundary
	*/
	public PositionObject<E> prev(Position<E> p) 
		throws InvalidPositionException, BoundaryViolationException {
		if ((((PositionObject<E>) p).index() < 0) || (((PositionObject<E>) p).index() >= size()))
			throw new InvalidPositionException("Index of this position is out of bounds. ");
		int i = ((PositionObject<E>) p).index();
		if (i<1)
			throw new BoundaryViolationException("The previous position does not exist. ");
		return S[i-1];
	}

	/** Inserts an element after the given position in the list. 
	* @param Position<E> indicating a position and type E element that's added after the indicated position 
	* 
	*/
	public void addAfter(Position<E> p, E e) 
		throws InvalidPositionException{
		if ((((PositionObject<E>) p).index() < 0) || (((PositionObject<E>) p).index() >= size()))
			throw new InvalidPositionException("Index of this position is out of bounds. ");
		int r = ((PositionObject<E>) p).index();
		add(r+1, e);
	}

	/** Inserts an element before the given position in the list. 
	* @param Position<E> indicating a position and type E element that's added before the indicated position
	*/
	public void addBefore(Position<E> p, E e) 
		throws InvalidPositionException{
		if ((((PositionObject<E>) p).index() < 0) || (((PositionObject<E>) p).index() >= size()))
			throw new InvalidPositionException("Index of this position is out of bounds. ");
		int r = ((PositionObject<E>) p).index();
		add(r-1, e);
	}

	/** Removes a position from the list, returning the element stored there. 
	* @param Position<E> p indicating a position being removed
	* @return type E element that's stored at indecated position
	*/
	public E remove(Position<E> p) 
		throws InvalidPositionException {
		if ((((PositionObject<E>) p).index() < 0) || (((PositionObject<E>) p).index() >= size()))
			throw new InvalidPositionException("Index of this position is out of bounds. ");
		int r = ((PositionObject<E>) p).index();
		E temp = S[r].element();
		for (int i=r; i<size-1; i++)   // shift elements down
      S[i] = S[i+1];
    size--;
    return temp;
  }

	/** Replaces the element stored at the given position, returning the old element. 
	* @param Position<E> p indicating a position being removed
	* @return type E element that's stored at indecated position
	*/
	public E set(Position<E> p, E e) throws InvalidPositionException {
		
		if ((((PositionObject<E>) p).index() < 0) || (((PositionObject<E>) p).index() >= size()))
			throw new InvalidPositionException("Index of this position is out of bounds. ");
		int r= ((PositionObject<E>) p).index();
		E temp = S[r].element();
		S[r].setElement(e);
		return temp;
	}
	
	/** Returns the position containing the element at the given index. 
	* @param integer r indicating the index of position desired to access
	* @return Position<E> S[r] that is the position object at index r
  * @exception BoundaryViolationException when cursor reaches boundary
	*/
  public Position<E> atIndex(int r) throws BoundaryViolationException {
    if ((r < 0) || (r >= size()))
      throw new BoundaryViolationException("Given index is out of bounds.");
		return S[r];
	}
	

  /** Returns the index of the element stored at the given position. 
	* @param Position<E> S[r] that is the position object at index r
	* @return integer indicating the index of the position
	*/
  public int indexOf(Position<E> p) throws InvalidPositionException {
    int x=(((PositionObject<E>) p).index());
		if ((x < 0) || (x>= size()))
      throw new InvalidPositionException("Given index is out of bounds.");
		return x;
	}


	
}