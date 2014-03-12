/**
 * Array String Set
 * This class implements a set of strings using an array to support five 
 * operations, namely, testing emptiness, membership, addition, removal, and 
 * printing.
 * @author Yisheng Cai
 * @version 1.0.0 2/13/13
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
   *@return a boolean true if the array is empty, false if it is not empty
   */
  public boolean isEmpty() {
    if (size == 0){
	return true;
    }
    return false;
  }

  /**
   * Returns the index of a given string s if it exists or -1 if it does not.
   *@param a string s which user looks for in this array
   *@return an integer which is the index of string s, -1 means not exist
   */
  private int locate(String s) {
    int j=0;
    for (int i=0; i<MAX_SIZE; i++){
	if (s.equals(elements[i])){
	    j=i;
	    break;
	}
	else
          j = -1;
    }
    return j;
  }

  /**
   * Returns true if the set has a string s.
   *@param a string s that user want to find if the array has
   *@return boolean true if the array has s.
   */
  public boolean has(String s) {
    if (locate(s) == -1)
	return false;
    return true;
  }

  /**
   * Adds a string s to the array and increments size by 1, keeping the 
   *@param a string which user wants to insert at the end of an array. 
   * elements sorted.
   */
  public void add(String s) {
    if (!has(s)) {
      for (int i=0; i<MAX_SIZE; i++){
	if (elements[i]==null){
	  elements[i]=s;
	  break;
	else  
	}

      }
      size++;
      System.out.println("Adding " + s + "...");
    }
    else
      System.out.println("Adding " + s + "..., but " + s + 
                         " already exists.");
  }

  /**
   * Removes a string s from the array and decrements size by 1, keeping
   *@param a string which user wants to remove from the array
   * the elements sorted.
   */
  public void remove(String s) {
    int i = locate(s);
    if (i == -1) 
      System.out.println("Removing " + s + "..., but " + s +
		         " does not exist.");
    else {
      for (int j=i; j<=size; j++){
	elements[j]=elements[j+1];
      }
      size=size-1;

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
