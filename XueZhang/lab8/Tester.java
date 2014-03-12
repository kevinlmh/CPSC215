/* Test driver
 * @author Yisheng Cai
 * @version 1.0.0 3/13/13
*/

import java.util.*;

public class Tester {

  /** Prints all elements of a given array list using an iterator. */
  public static <E> void print(IndexList<E> l) {
    Iterator<E> i = l.iterator();
    System.out.print("[");
    while (i.hasNext()) {
      System.out.print(i.next());
      if (i.hasNext())
				System.out.print(", ");
    }
    System.out.println("]");
  }

  public static void main(String args[]) {

    ArrayIndexList<String> A = new ArrayIndexList<String>();
    A.add(A.size(), "T");
    A.add(A.size(), "R");
    A.add(A.size(), "I");
    A.add(A.size(), "N");
    A.add(A.size(), "I");
    A.add(A.size(), "T");
    A.add(A.size(), "Y");
    System.out.println("Testing with a list of strings...");
    print(A);


    if (A.hasDuplicates())
      System.out.println("This list has duplicates.");
    else
      System.out.println("This list has no duplicates.");
    A.removeDuplicates();
    System.out.println("Removing duplicates...");
    print(A);
    System.out.println();

    // Testing with another list of strings.
    ArrayIndexList<String> B = new ArrayIndexList<String>(); 
    Random r = new Random();
    int j;
    for (int i = 0; i < 26; i++) {
      j = r.nextInt(26);
      String u = "" + (char)('A' + j);
      B.add(0, u);
    }
    System.out.println("Testing with another list of strings...");
    print(B);
    if (B.hasDuplicates())
      System.out.println("This list has duplicates.");
    else
      System.out.println("This list has no duplicates.");
    B.removeDuplicates();
    System.out.println("Removing duplicates...");
    print(B);

    // Testing with a list of integers.
    ArrayIndexList<Integer> C = new ArrayIndexList<Integer>();
    System.out.println();
    System.out.println("Testing with a list of integers...");
    for (int i = 0; i < 10; i++)
      C.add(0, 1823);
    print(C);
    if (C.hasDuplicates())
      System.out.println("This list has duplicates.");
    else
      System.out.println("This list has no duplicates.");
    C.removeDuplicates();
    System.out.println("Removing duplicates...");
    print(C);

  }

}
