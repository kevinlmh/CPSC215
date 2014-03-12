/**
 * File: Tester.java
 * 
 * This class tests NodePositionList, ReverseElementIterator
 * and EveryOtherElementIterator
 * @author Kevin Liu
 * @author Courtney Driscoll
 * @version 1.0
 * @see NodePositionList
 * @see ElementIterator
 * @see ReverseElementIterator
 * @see EveryOtherElementIterator
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
   * Prints all the elements of a given node list 
   * in reverse order using a reverse iterator.
   * @param l the list to iterate through
   */
  public static <E> void reversePrint(PositionList<E> l) {
    NodePositionList<E> list = (NodePositionList)l;
		Iterator<E> i = list.reverseIterator();
    System.out.print("[");
    while (i.hasNext()) {
      System.out.print(i.next());
      if (i.hasNext())
	System.out.print(", ");
    }
    System.out.println("]");
  }

  /**
   * Prints every other element of a given node list 
   * @param l the list to iterate through
   */
  public static <E> void everyOtherPrint(PositionList<E> l) {
    NodePositionList<E> list = (NodePositionList)l;
		Iterator<E> i = list.everyOtherIterator();
    System.out.print("[");
    while (i.hasNext()) {
      System.out.print(i.next());
      if (i.hasNext())
	System.out.print(", ");
    }
    System.out.println("]");
	}

  public static void main(String args[]) {
		NodePositionList<Integer> s = new NodePositionList<Integer>();
		System.out.println("Adding 8 to the beginning of the list..");
		s.addFirst(8);
		print(s);
		Position<Integer> p1 = s.first();	
		System.out.println("Adding 5 after p1");
		s.addAfter(p1,5);
		print(s);
		Position<Integer> p2 = s.next(p1);
		System.out.println("Adding 3 before p2");
		s.addBefore(p2,3);
		print(s);
		Position<Integer> p3 = s.prev(p2);
		System.out.println("Adding 9 to the beginning of the list...");
		s.addFirst(9);
		print(s);
		p2 = s.last();
		System.out.println("Removing the first element of the list...");
		s.remove(s.first());
		print(s);
		System.out.println("Setting p3 to 7");
		s.set(p3,7);
		print(s);
		System.out.println("Printing every other element in the list...");
		everyOtherPrint(s);
		System.out.println("Adding 2 after the first element...");
		s.addAfter(s.first(),2);	
		print(s);
		System.out.println("Printing the list in reverse order...");
		reversePrint(s);
		System.out.println("Printing every other element in the list...");
		everyOtherPrint(s);
  }

}
