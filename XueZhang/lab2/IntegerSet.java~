/**
 * Integer Set
 * This class implements an integer set that supports six operations, namely, 
 * testing emptiness, membership, insertion, removal, sorting and printing.
 * 
 * @author Yisheng Cai
 * @author Vishal Bharam
 * @version 1.0  1/30/13
 *
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
   * @return "true" if the set is empty and "false" if the set contains any elements.
   * 
   */
  public boolean isEmpty() {
    if (size == 0){
	return true;
    }
    else{
	return false;
    }
  }

  /**
   * Returns true if this set contains the integer n.
   * @param any integer "n"
   * @return "true" if the set contains the integer and "false" if the set does not contain n.
   */
  public boolean contains(int n) {
     for (int i=0; i<size; i++){
	if (elements[i]==n){
	    return true;
	}
      }
     return false;
  }

  /**
   * Inserts an integer n into the array elements[] and increments size by 1.
   * @param any integer "n"
   *
   *
   */
  public void insert(int n) {

    // Fill in the blank here.
    
    if (!contains(n)){
    elements[size]=n;
    size++;
    System.out.println("Inserting " + n + "...");
    }

  }
  /**
   * Removes an integer n from the array elements[] and decrements size by 1.
   * @param any integer "n"
   *
   */
  public void remove(int n) {
    int j=0;
    // Fill in the blank here.    
    for (int i=0; i<size; i++){
	if (elements[i]==n){
	    j=i;
	}
    }
    for (int k=j; k<elements.length-1;k++){
	elements[k]=elements[k+1];
    }
    size=size-1;
    System.out.println("Removing " + n + "...");
  }

  /**
   * Sorts the integer of the array elements[] in the increasing order.
   * 
   *
   *
   */
  public void sort() {

    // Fill in the blank here.
    int i=0; int k=0;
    for (i=0; i<size-1; i++){
	int minIndex=i;
	for (int j=i+1; j<size; j++){
	    if (elements[j]<elements[minIndex]){
		minIndex=j;
	    }
	}
	if (minIndex!=i){
		k = elements [i];
		elements[i]=elements[minIndex];
		elements[minIndex] = k;
	    }
     }
    System.out.println("Sorting...");
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
