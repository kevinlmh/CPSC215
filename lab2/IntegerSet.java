/**
 * This class implements an integer set that supports six operations, namely, 
 * testing emptiness, membership, insertion, removal, sorting and printing.
 *
 * @author Kevin Liu and Aryaman Nichani
 * @version 2.0, 01/29/2014
 */

public class IntegerSet {
    
  public static final int MAX_SIZE = 1000; // Maximum capacity

  private int elements[];
  private int size;                       // The actual size

  /**
   * Creates an array of MAX_SIZE capacity and initializes the set's size to
   * 0 (i.e., it creates an empty set).
   */
  public IntegerSet() {
    elements = new int[MAX_SIZE];
    size = 0;
  } 

  /**
   * Returns true if the set contains no element.
   * @return Whether array is empty
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Returns true if this set contains the integer n.
   * @param n The integer that you are looking for.
   * @return Whether n is in the array or not. True if it is there, and False otherwise.
   */
  public boolean contains(int n) {

    // Fill in the blank here.
	for (int i = 0; i < size; i++) {
		if (elements[i] == n) {
			return true;
		}
	}
	return false;
  }

  /**
   * Inserts an integer n into the array elements[] and increments size by 1.
   * @param n The integer you want to insert.
   */
  public void insert(int n) {

    // Fill in the blank here.

    System.out.println("Inserting " + n + "...");
    // Insert n only if n is not in elements[].
    if (!contains(n)) {
    	elements[size] = n;
    	size++;
    }
  }

  /**
   * Removes an integer n from the array elements[] and decrements size by 1.
   * @param n The integer that you want to remove.
   */
  public void remove(int n) {

    // Fill in the blank here.

    System.out.println("Removing " + n + "...");
    int i = 0;
    // Finds the index of n.
    while (elements[i] != n) {
    	i++;
    }
    // Moves the rest of the elements one place back.
    for ( ;i < size-1 ; i++) {
    	elements[i] = elements[i+1];
    }
    // Manually sets the last element to zero
    elements[size-1] = 0;
    // Decrement size
    size--;
  }

  /**
   * Sorts the integer of the array elements[] in the increasing order using BubbleSort.
   */
  public void sort() {

    // Fill in the blank here.

    System.out.println("Sorting...");
    int temp;
    for (int i = 1; i < size; i++) {
    	for (int j = 0; j < size -1; j++) {
    		if (elements[j] > elements[j+1]) {
    			temp = elements[j];
    			elements[j] = elements[j+1];
    			elements[j+1] = temp;
    		}
    	}
    }
    			
  }

  /**
   * Prints all the elements of the array elements[].  Note that it uses 
   * the size as the loop bound.
   */
  public void print() {
    for (int i = 0; i < size; i++)
      System.out.print(elements[i] + " ");
    System.out.println();
  }

}
