/**
 * This class implements a set of strings using a linked list to support five 
 * operations, namely, testing emptiness, membership, insertion, removal, and 
 * printing.
 *
 * @author Robbie Paine & Kevin Liu
 * @see Node
 *
 */

public class StringSet {
    
  private Node head;
  private int size;                       // The actual size

  /**
   * Creates an empty list and initializes the set's size to 0 (i.e., it 
   * creates an empty set).
   */
  public StringSet() {
    head = null;
    size = 0;
  } 

  /**
   * Returns true if the set contains no element.
   *
   * @return ture if set is empty, false otherwise
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Returns, if it exists, a node containing a string s.
   *
   * @param s The string you want to find
   * @return The node containing s, null if s doesn't exist
   */
  private Node find(String s) {
  
    // Fill in the blank here.
    Node v = head;
    while (v != null) {
    	if (v .getElement().equals(s)) {
    		return v;
    	}else {
    		v = v.getNext();
    	}
  	}
  	return null;
  }

  /**
   * Returns true if the set contains a string s.
   *
   * @param s The String you want to check
   * @return true if the set contains a string s, false if doesnt't
   */
  public boolean contains(String s) {

    // Fill in the blank here.
    Node r = find(s);
    if (r == null) {
    	return false;
    }else {
    	return true;
    }

  }

  /**
   * Inserts a string s into the list and increments size by 1.
   *
   * @param s The string you want to insert
   */
  public void insert(String s) {

    if (!contains(s)) {
    	Node ins = new Node(s,null);
    	if (head == null) {
    		head = ins;
    	}else {
			Node prev = null;
			Node cur = head;
			while (cur != null && s.compareTo(cur.getElement()) >= 0) {
				prev = cur;
				cur = cur.getNext();
			}
			if (prev == null) {
				ins.setNext(head);
				head = ins;
			}else {
				prev.setNext(ins);
				ins.setNext(cur);
			}
    	}	
			
		System.out.println("Inserting " + s + "...");
    }
    else
      System.out.println("Inserting " + s + "..., but " + s + 
                         " already exists.");
  }

  /**
   * Removes a string s from the list and decrements size by 1.
   * 
   * @param s The string you want to remove
   */
  public void remove(String s) {
    Node r = find(s);
    if (r == null) 
      System.out.println("Removing " + s + "..., but " + s +
		         " does not exist.");
    else {

      // Fill in the blank here.
      Node prev = head;
      while (prev != null && prev.getNext() != r) {
      	prev = prev.getNext();
      }
      prev.setNext(r.getNext());

      System.out.println("Removing " + s + "...");
    }
  }

  /**
   * Prints all the strings in the list.
   */
  public void print() {
    Node n = head;
    System.out.print("{ ");
    while (n != null) {
      System.out.print(n.getElement());
      if (n.getNext() != null) 
	System.out.print(", ");
      n = n.getNext();
    }
    System.out.println(" }");
  }

}
