/**
 * File: Tester.java
 *
 * This is a driver program to test your implementation of the class HeapPQ.
 *
 * @author Takunari Miyazaki
 * @author Tanya Nongera
 * @author Yisheng Cai
 * @see ArrayIndexList

 * @see HeapPQ
 * @see IndexList
 * @see Integer
 * @see Iterator
 */

public class Tester {

  /** This method takes an array list L of objects and heapsorts the objects
   *  of L in the increasing order.
   *  @param L is the the array list being sorted
   */
  public static <E> void heapsort(IndexList<E> L) {
		HeapPQ<E,E> h = new HeapPQ<E,E>();
		int j = 0;
		while (!L.isEmpty()){
			h.insert(L.get(0), L.remove(0));
		}
		
		while (!h.isEmpty()){
			E a = h.removeMin().getValue();
			L.add(j, a);
			j++;
		}
		
	}

  /** This method prints the elements of a given array list L. */
  public static <E> void printIndexList(IndexList<E> L) {
    Iterator<E> i = L.iterator();
    while (i.hasNext())
      System.out.print(i.next().toString() + " ");
    System.out.println();
  }

  /** This method declares four index lists of Integer objects and calls the
   *  method heapsort() on each one of them. */
  public static void main(String args[]) {

    // Declares four array lists.
    java.util.Random r = new java.util.Random();
    IndexList<Integer> L1 = new ArrayIndexList<Integer>();
    IndexList<Integer> L2 = new ArrayIndexList<Integer>();
    IndexList<Integer> L3 = new ArrayIndexList<Integer>();
    IndexList<Integer> L4 = new ArrayIndexList<Integer>();
    for (int i = 0; i < 20; i++)
      L1.add(i, new Integer(i));
    for (int i = 0; i < 20; i++)
      L2.add(i, new Integer(19 - i));
    for (int i = 0; i < 20; i++)
      L3.add(i, new Integer(0));
    for (int i = 0; i < 20; i++)
      L4.add(i, new Integer(Math.abs(r.nextInt()) % 20));

    // The following performs four tests.
    System.out.println("Testing heapsort...");
    System.out.println();

    // Testing with L1.
    System.out.println("Test 1");
    System.out.print("Input:  ");
    printIndexList(L1);
    heapsort(L1);
    System.out.print("Output: ");
    printIndexList(L1);
    System.out.println();

    // Testing with L2.
    System.out.println("Test 2");
    System.out.print("Input:  ");
    printIndexList(L2);
    heapsort(L2);
    System.out.print("Output: ");
    printIndexList(L2);
    System.out.println();

    // Testing with L3.
    System.out.println("Test 3");
    System.out.print("Input:  ");
    printIndexList(L3);
    heapsort(L3);
    System.out.print("Output: ");
    printIndexList(L3);
    System.out.println();

    // Testing with L4.
    System.out.println("Test 4");
    System.out.print("Input:  ");
    printIndexList(L4);
    heapsort(L4);
    System.out.print("Output: ");
    printIndexList(L4);

  }

}
