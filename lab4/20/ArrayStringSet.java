/**
 * This class implements a set of strings using an array to support five 
 * operations, namely, testing emptiness, membership, addition, removal, and 
 * printing.
 */

public class ArrayStringSet {

  public static final int MAX_SIZE = 1000; // Maximum capacity

  private String elements[];
  private int size;                       // The actual size

  /**
   * Creates an array of MAX_SIZE capacity and initializes the set's size to
   * 0 (i.e., it creates an empty set).
   */
  public ArrayStringSet() {
    elements = new String[MAX_SIZE];
    size = 0;
  } 

  /**
   * Returns true if the set has no element.
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Returns the index of a given string s if it exists or -1 if it does not.
   */
  private int find(String s) {
  
    // Fill in the blank here.

  }

  /**
   * Returns true if the set has a string s.
   */
  public boolean has(String s) {

    // Fill in the blank here.

  }

  /**
   * Adds a string s to the array and increments size by 1, keeping the 
   * elements sorted.
   */
  public void add(String s) {
    if (!has(s)) {

      // Fill in the blank here.

      System.out.println("Adding " + s + "...");
    }
    else
      System.out.println("Adding " + s + "..., but " + s + 
                         " already exists.");
  }

  /**
   * Removes a string s from the array and decrements size by 1, keeping
   * the elements sorted.
   */
  public void remove(String s) {
    int i = find(s);
    if (i == -1) 
      System.out.println("Removing " + s + "..., but " + s +
		         " does not exist.");
    else {

      // Fill in the blank here.

      System.out.println("Removing " + s + "...");
    }
  }

  /**
   * Prints all the strings in the array.
   */
  public void print() {    
    System.out.print("{ ");
    for (int i = 0; i < size - 1; i++)
      System.out.print(elements[i] + ", ");
    if (!isEmpty())
      System.out.print(elements[size - 1]);
    System.out.println(" }");
  }

}
