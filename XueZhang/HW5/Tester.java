import java.util.*;
/**
 * File: Tester.java
 * @author: Yisheng Cai
 * @version: 1.0.0  03/03/13 
 *Test program for the NodeDeque class
 */

public class Tester {

  public static void main(String args[]) {
 
    String s = "BOS";
    String t = "JFK";
    
 
       
    ArrayDeque A = new ArrayDeque();
    
    //Checks if the list is empty
    //At this point the list has no element, therefore, displays it's empty
    if (A.isEmpty()){
   System.out.println("This list is empty.");
    }

 System.out.println("Adding element BOS to last...");
    A.addLast(s);        // The string s is inserted into A so that 
                        // A = {"BOS"}.
    
    System.out.print("The size of set A = "); 
    System.out.println(A.size());

    A.print();
    
    System.out.println("Adding element JFK to first...");
    A.addFirst(t);        // The string t is inserted into A so that
                        // A = {"JFK", "BOS"}.
    System.out.println("Adding element BDL to last...");
    A.addLast("BDL");    // The string "BDL" is inserted into A so that
                        // A = {"JFK", "BOS", "BDL"}.
 
    
    System.out.print("The first element in A = ");
    System.out.println(A.getFirst());

    System.out.print("The last element in A = ");
    System.out.println(A.getLast());
    System.out.println("The current size is "+A.size());
    A.addFirst("CYS");
    A.addFirst("PRE");
    System.out.println("The current size is "+A.size());
    A.print();
    
    System.out.println("Removing the first element...");
    System.out.print("The element removed is:  ");    
    System.out.println(A.removeFirst());    
    System.out.print("Removing the last element:  ");
    System.out.println(A.removeLast());     //A = {"BOS"}.
    A.print();
    ArrayDeque B = new ArrayDeque();
    
    for (int i = 0; i < 26; i++) {
      String u = "" + (char)('A' + i);
      B.addLast(u);
    }
    
    B.print();
    
    //The list has characters from A to Z by alphabetical order
    //so the first element is A and the last one is Z
    System.out.print("The last element of set B = ");
    System.out.println(B.getLast());
    
    
    System.out.print("The first element of set B = ");
    System.out.println(B.getFirst());
    
  }
  
}
