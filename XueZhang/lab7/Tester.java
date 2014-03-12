/**
 * File: Tester.java
 *
 * Tester for NodePositionList using Iterator, reverseIterator, and eoeIterator
 * 
 * @author Max Le Merle
 * @author Yisheng Cai
 * @version 1.0.0 3/6/13
 */


public class Tester {

  /**
   * Prints all the elements of a given node list using an iterator.
   */
  public static <E> void print(PositionList<E> l) {
    Iterator<E> i = l.iterator();
    System.out.print("[");
    while (i.hasNext()) {
      System.out.print(i.next());
      if (i.hasNext())
	System.out.print(", ");
    }
    System.out.println("]");
  }

  /**
   * Prints all the elements of a given node list in reverse using an iterator.
   */
  public static <E> void print2(NodePositionList<E> l) {
    Iterator<E> i = l.reverseIterator();
    System.out.print("[");
    while (i.hasNext()) {
      System.out.print(i.next());
      if (i.hasNext())
	System.out.print(", ");
    }
    System.out.println("]");
  }

  /**
   * Prints every other element of a given node list using an iterator.
   */

  public static <E> void print3(NodePositionList<E> l) {
    Iterator<E> i = l.eoeIterator();
    System.out.print("[");
    while (i.hasNext()) {
      System.out.print(i.next());
      if (i.hasNext())
	System.out.print(", ");
    }
    System.out.println("]");
  }


  public static void main(String args[]) {
	NodePositionList<Integer> tester = new NodePositionList<Integer>();
    	System.out.println("");
	tester.addFirst(8);
	Position<Integer> p1 = tester.first();
	System.out.println("p1("+p1+")");
	print(tester);
	tester.addAfter(p1,5);
	Position<Integer> p2 = tester.next(p1);
	System.out.println("p2("+p2+")");		
	print(tester);
	tester.addBefore(p2,3);
	Position<Integer> p3 = tester.prev(p2);
	System.out.println("p3("+p3+")");
	System.out.println("Iterator/ Reverse Element Iterator/ Every Other Element Iterator: "); 
	print(tester);	
	print2(tester);
	print3(tester);
	tester.addFirst(9);
	tester.last();
	System.out.println("p2("+p2+")");
	System.out.println("Iterator/ Reverse Element Iterator/ Every Other Element Iterator: "); 
	print(tester);	
	print2(tester);
	print3(tester);
	System.out.println("Removing first element: "+tester.remove(tester.first()));
	print(tester);
	System.out.println("Replacing "+tester.set(p3,7)+" with 7");
	System.out.println("Iterator/ Reverse Element Iterator/ Every Other Element Iterator: "); 
	print(tester);	
	print2(tester);
	print3(tester);
	System.out.println("Adding 2 after first element...");
	tester.addAfter(tester.first(),2);
	System.out.println("Iterator/ Reverse Element Iterator/ Every Other Element Iterator: "); 
	print(tester);
	print2(tester);
	print3(tester);


  }

}
