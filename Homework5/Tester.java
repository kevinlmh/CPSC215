import java.util.*;

/** Test program for the NodeDeque class 
 * @author Kevin Liu
 * @version 1.0 Feb 25 2014
 * @see NodeDeque
 */

public class Tester {

	public static void main(String args[]) {
		String s = "BOS";
		String t = "JFK";
		   
		NodeDeque A = new NodeDeque();

		System.out.println("Adding 'BOS' to the front of Deque A ...");
		A.addFirst(s);      // The string s is added to A so that 
				            // A = { "BOS" }.
				            
		System.out.print("The Deque A = "); 
		A.print();

		System.out.println("Adding 'JFK' to the rear of Deque A ...");
		A.addLast(t);       // The string t is added to A so that
				            // A = { "BOS", "JFK" }.
				            
		System.out.print("The Deque A = "); 
		A.print();		         

		System.out.println("Add 'BDL' to the front of Deque A ...");
		A.addFirst("BDL");  // The string "BDL" is added to A so that
				            // A = { "BDL", "BOS", "JFK"}.

		System.out.print("The Deque A = ");
		A.print();

		System.out.println("A now has " + A.size() + " elements");

		System.out.println("The first element of Deque A is: " + A.getFirst());
		System.out.println("The last element of Deque A is: " + A.getLast());

		System.out.println("Removing the first element of Deque A ...");
		A.removeFirst();    // The string "BDL" is removed from A so that 
				            // A = {"BOS", "JFK"}.
				            
		System.out.print("The Deque A = ");
		A.print();

		System.out.println("Removing the last element of Deque A ...");
		A.removeLast();    // The string "JFK" is removed from A so that 
				            // A = {"BOS"}.
				            
		System.out.print("The Deque A = ");
		A.print();

		System.out.println("A now has " + A.size() + " element");

		System.out.println("Deque A is empty = " + A.isEmpty());

		System.out.println("Removing the First element of Deque A ...");
		A.removeFirst();    // The string "BOS" is removed from A so that 
				            // A is empty
		System.out.print("The Deque A = ");
		A.print();      

		System.out.println("Deque A is empty = " + A.isEmpty());
	}
  

}
