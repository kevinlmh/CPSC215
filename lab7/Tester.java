/**
 * File: Tester.java
 *
 * This is a driver program to test your implementation of the class 
 * LinkedBinaryTree.
 *
 * @author Takunari Miyazaki
 * @author Rahul Chandrashekhar
 * @author Kevin Liu
 * @see Character
 * @see Iterable
 * @see Iterator
 * @see LinkedBinaryTree
 * @see Position
 * @see String
 * @see Tree
 */

public class Tester {

  /**
   * This method constructs an arithmetic expression tree of an infix 
   * arithmetic expression s by simply calling the recursive version of the 
   * same method.
	 * @param T Binary Tree to be implemented
	 * @param S String to be generated 
   */
  public static void preorderAET(LinkedBinaryTree<Character> T, String s) {
    preorderAET(T, T.addRoot(null), s);
  }

  /**
   * This method recursively constructs an arithmetic expression tree of an 
   * infix arithmetic expression s starting at a position v.
   */
  public static String preorderAET(LinkedBinaryTree<Character> T, 
    Position<Character> v, String s) {
    if (s.length() == 0)
      return "";
    if (s.charAt(0) == ' ')
      return preorderAET(T, v, s.substring(1));  // Skip spaces.
    else if (Character.isDigit(s.charAt(0))) {
      T.replace(v, (new Character(s.charAt(0))));
      return s.substring(1);
    }
    else {
      T.replace(v, (new Character(s.charAt(0))));
      T.insertLeft(v, null);
      T.insertRight(v, null);
      String t = preorderAET(T, T.left(v), s.substring(1));
      return preorderAET(T, T.right(v), t);
    }
  }

  /**
   * This method prints all the elements of the tree T in preorder.
   * @param T the binary tree to be printed out
   */
  public static <E> void preorderPrint(LinkedBinaryTree<E> T) {
		Iterator<E> i = T.iterator();
		while(i.hasNext()) {
			System.out.print(i.next()+" ");
		}
  }


	/**
   * This method returns the indented parenthetic string representation of 
   * the tree T.
   * @param T the tree to be printed
   */
  public static <E> String IPSR(Tree<E> T) {
	return	IPSR(T,T.root(),0);
	} 

	/**
   * This method returns the indented parenthetic string representation of 
   * the tree T.
   * @param T the tree to be printed
   * @param v the starting position
   * @param depth the depth of the tree
   */
  public static <E> String IPSR(Tree<E> T, Position<E> v, int depth) {
	String s = v.element().toString();
	if (T.isInternal(v)) {
		Boolean firstTime = true;
		Iterator<Position<E>> c = T.children(v).iterator();
		while (c.hasNext()) {
				Position<E> w = (Position<E>)c.next();
				if (firstTime) {
					s += "(" +"\n" + space(depth+1) + IPSR(T, w, ++depth);
					firstTime = false;
				}
				else s +="\n" + space(depth)  + IPSR(T, w, depth);
		}
		s += "\n" + space(depth-1) + ")";
	}		
	return s;
  }

  /**
   * Method to generate spaces
   * @param n the number of spaces to be generated
   * @return the string containing the required spaces
   */
	 public static String space(int n) {
			if (n == 0)
				return "";
			else
				return "    " + space(n-1);
	 }

  /**
   * This main method tests the class LinkedBinaryTree using the example 
   * from Figure 7.11, p. 301, of our main textbook.
   */
  public static void main(String[] args) {
    LinkedBinaryTree<Character> bt = new LinkedBinaryTree<Character>();
    preorderAET(bt, "- / * + 3 1 3 + - 9 5 2 + * 3 - 7 4 6");
    // Test preorderPrint() with bt.
		System.out.println("Preorder traversal: ");
    preorderPrint(bt);
		System.out.println("\nIndented parenthetic string representation: ");
		// Test IPSR() with bt.
		System.out.println(IPSR(bt));
  }

}
