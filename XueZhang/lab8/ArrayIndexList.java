/** 
 * File: ArrayIndexList.java
 *
 * Realization of an indexed list by means of an array, which is doubled 
 * when the size of the indexed list exceeds the capacity of the array.
 *
 * @author Yisheng Cai
 * @version 1.0.0 3/13/13
 * @see IndexOutOfBoundsException
 * @see EmptyListException
 */

public class ArrayIndexList<E> implements IndexList<E> {

  protected E[] A;              // array storing the elements of the list
  protected int capacity = 16;  // initial length of array A
  protected int size = 0;       // number of elements stored in the list
	protected int dup = 0;

  /** Creates the indexed list with initial capacity 16. 	
	*/
  public ArrayIndexList() { 
    A = (E[]) new Object[capacity]; // the compiler may warn, but this is ok
  }

  /** Returns the size of the list. 
	* @return integer indicating the size of the list
	*/
  public int size() {
    return size;
  }

  /** Checks whether the list is empty. 
	* @return boolean true if the list is empty, false if not.
	*/
  public boolean isEmpty() {
    return (size() == 0);
  }

  /** Checks whether the index r is in the range between 0 and n - 1. 
	* 	
	*/
  public void checkIndex(int r, int n) throws IndexOutOfBoundsException {
    if ((r < 0) || (r >= n))
      throw new IndexOutOfBoundsException("Given index is out of bounds.");
  }

  /** Inserts an element at the given index. 
	* @param an integer and an element type E to be added
	*/
  public void add(int r, E e) throws IndexOutOfBoundsException {
    checkIndex(r, size() + 1);
    if (size == capacity) {        // an overflow
      capacity *= 2;
      E[] B =(E[]) new Object[capacity];
      for (int i=0; i<size; i++) 
	B[i] = A[i];
      A = B;
    }
    for (int i=size-1; i>=r; i--)  // shift elements up
      A[i+1] = A[i];
    A[r] = e;
    size++;
  }

  /** Returns the element at index r, without removing it. 
	* @param integer r indicating the index of element to be accessed 
	* @return element type E which is stored in index r
	*/
  public E get(int r) throws IndexOutOfBoundsException {
    checkIndex(r, size());
    return A[r];
  }

  /** Removes the element stored at the given index. 
	* @param integer r indicating the index of element to be removed 
	* @return element type E which is removed
	*/
  public E remove(int r) throws IndexOutOfBoundsException {
    checkIndex(r, size());
    E temp = A[r];
    for (int i=r; i<size-1; i++)   // shift elements down
      A[i] = A[i+1];
    size--;
    return temp;
  }

  /** Replaces the element f at index r with e, returning f. 
  * @param integer r indicating the index of element to be replaced
	*  and an element type E, replacing element at index r 
	* @return element type E which is replaced
  */
  public E set(int r, E e) throws IndexOutOfBoundsException {
    checkIndex(r, size());
    E temp = A[r];
    A[r] = e;
    return temp;
  }

  /** Returns an iterator of all elements. */
  public Iterator<E> iterator() {
    return new MyElementIterator<E>(this);
  }

  /** Returns true if the list has any duplicates. 
	* @return boolean true if any element has duplicates in the list
	*/
  public boolean hasDuplicates() throws EmptyListException {
		if (isEmpty())
			throw new EmptyListException ("The list is empty.");
		for (int x=0; x<size(); x++){
			for (int y=x+1; y<size(); y++){
				if ((A[x]).equals(A[y])){
					return true;
				}
			}
		}
		return false;
  }

  /** Removes all duplicates from the list. */
  public void removeDuplicates() {
		if (hasDuplicates()){
			for (int x=0; x<size(); x++){
				for (int y=x+1; y<size(); y++){
					if ((A[x]).equals(A[y])){
						remove(y);
						y=x+1;
					}
					if (y==size()-1){
						if ((A[x]).equals(A[y])){
							remove(y);
						}
					}
				}
			}
		}
	}

}
