/**
 * File: Tester.java
 *
 * This is a driver program to test your implementation of the class 
 * LinkedBinaryTree.
 *
 * @author Takunari Miyazaki
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
   */
  public static <E> void preorderPrint(LinkedBinaryTree<E> T) {

    // Complete this blank.

  }

  /**
   * This method returns the indented parenthetic string representation of 
   * the tree T.
   */
  public static <E> String IPSR(Tree<E> T) {

    // Complete this blank.

  }

  /**
   * This main method tests the class LinkedBinaryTree using the example 
   * from Figure 7.11, p. 301, of our main textbook.
   */
  public static void main(String[] args) {
    LinkedBinaryTree<Character> bt = new LinkedBinaryTree<Character>();
    preorderAET(bt, "- / * + 3 1 3 + - 9 5 2 + * 3 - 7 4 6");
    
    // Test preorderPrint() with bt.
    // Test IPSR() with bt.

  }

}
