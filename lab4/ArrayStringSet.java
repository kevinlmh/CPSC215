/**
 * This class implements a set of strings using an array to support five 
 * operations, namely, testing emptiness, membership, addition, removal, and 
 * printing.
 *
 * @author: Kevin Liu
 * @version: 1.0 12-Feb-2014
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
	 *
	 * @return true if the set is empty, false if the set is not empty
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Returns the index of a given string s if it exists or -1 if it does not.
	 *
	 * @param s the String you want to find
	 * @return the index of string s if s exists, -1 if it does not
	 */
	private int find(String s) {
  		for (int i=0; i<size; i++)
  			if (elements[i].equals(s))
  				return i;	// we found s, return its index
  		return -1;		// if s does not exists, return -1
	}

	/**
	 * Returns true if the set has a string s.
	 *
	 * @param s the string you want to test if it exist
	 * @return true if s exists, false otherwise
	 */
	public boolean has(String s) {
		return find(s) != -1;
	}

	/**
	 * Adds a string s to the array and increments size by 1, keeping the 
	 * elements sorted.
	 *
	 * @param s the string you want to add
	 */
	public void add(String s) {
		if (!has(s)) {
			System.out.println("Adding " + s + "...");
			// index start from the end of the array
			int i = size-1;
			// if the previous one lexicographically follows s, 
			// then move it one place forward
			for (; i >= 0 && elements[i].compareTo(s) > 0; i--){
				elements[i+1] = elements[i];
			}
			// put s in
			elements[i+1] = s;
			size++;
		}
    	else
			System.out.println("Adding " + s + "..., but " + s + 
                         " already exists.");
  }

	/**
	 * Removes a string s from the array and decrements size by 1, keeping
	 * the elements sorted.
	 *
	 * @param s the string you want to remove
	 */
	public void remove(String s) {
		int i = find(s);
		if (i == -1) 
			System.out.println("Removing " + s + "..., but " + s +
		         				" does not exist.");
		else {
			System.out.println("Removing " + s + "...");
			for (; i < size-1; i++)
				// move every element after s one place backward
				elements[i] = elements[i+1];
			// null out the last element
			elements[i+1] = null;
			size--;
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
