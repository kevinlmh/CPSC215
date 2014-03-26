/**
 * File: Tester.java
 *
 * A driver program to test the classes LinkedBinaryTree and ExpressionTree.
 *
 * @author Takunari Miyazaki
 * @author Kevin Liu
 * @version 1.0 03/26/2014
 * @see LinkedBinaryTree
 * @see NumberFormatException
 * @see Position
 * @see String
 * @see StringTokenizer
 */

import java.util.*;

public class Tester {

  /**
	 * Inserts the prefix expression s into a tree T starting at the root. 
	 * @param T the tree you want to insert expression s into
	 * @param s the expression you want to insert in to tree T
	 */
  public static void preorderBuild(LinkedBinaryTree<String> T, String s) {
    StringTokenizer st = new StringTokenizer(s);
    preorderBuild(T, T.addRoot(null), st);
  }

  /**
	 * Recursively inserts the prefix expression s
	 * @param T the tree you want to insert into
	 * @param v the root of current subtree
	 * @param st the String Tokernizer
	 */
  protected static void preorderBuild(LinkedBinaryTree<String> T,
    Position<String> v, StringTokenizer st) {
    if (st.hasMoreTokens()) {
      String s = st.nextToken();
      try {
        Integer.parseInt(s);
        T.replace(v, s);
      }
      catch (NumberFormatException e) {
        T.replace(v, s);
        preorderBuild(T, T.insertLeft(v, null), st);
        preorderBuild(T, T.insertRight(v, null), st);
      }
    }
  }

  /** The main() method. */
  public static void main(String args[]) {

    LinkedBinaryTree<String> bt1 = new LinkedBinaryTree<String>();
    System.out.println("The first example.");
    System.out.println("Elements in preorder: " + 
                       bt1.preorderElements().toString());
    System.out.println("Inserting * as the root.");
    Position<String> p = bt1.addRoot("*");
    System.out.println("Elements in preorder: " + 
                       bt1.preorderElements().toString());
    System.out.println("Inserting 2 as the left child of *.");
    bt1.insertLeft(p, "2");
    System.out.println("Elements in preorder: " + 
                       bt1.preorderElements().toString());
    System.out.println("Inserting + as the right child of *.");
    p = bt1.insertRight(p, "+");
    System.out.println("Elements in preorder: " + 
                       bt1.preorderElements().toString());
    System.out.println("Inserting 6 as the left child of +.");
    bt1.insertLeft(p, "6");
    System.out.println("Elements in preorder: " + 
                       bt1.preorderElements().toString());
    System.out.println("Inserting 5 as the right child of +.");
    bt1.insertRight(p, "5");
    System.out.println("Elements in preorder: " + 
                       bt1.preorderElements().toString());

    LinkedBinaryTree<String> bt2 = new LinkedBinaryTree<String>();
    String exp1 = "- / * + 3 1 3 + - 9 5 2 + * 3 - 7 4 6";
    System.out.println();
    System.out.println("The second example.");
    System.out.println("Inserting in preorder: " + exp1);
    preorderBuild(bt2, exp1);
    System.out.println("Elements in preorder: " + 
                       bt2.preorderElements().toString());
    System.out.println("Elements in postorder: " +
                       bt2.postorderElements().toString());

    // Add a code segment to test the class ExpressionTree using the 
    // expression "- / * + 3 1 3 + - 9 5 2 + * 3 - 7 4 6".
		ExpressionTree bt3 = new ExpressionTree();
		String exp3 = "- / * + 3 1 3 + - 9 5 2 + * 3 - 7 4 6";
		System.out.println("\nTesting ExpressionTree with '- / * + 3 1 3 + - 9 5 2 + * 3 - 7 4 6'");
		preorderBuild(bt3, exp3);
		System.out.println("Evaluating expression tree...");
		System.out.println("Result: " + bt3.evaluate());
    
		// Add a code segment to test the class ExpressionTree using the 
    // expression "+ - 496 * 28 6 8128".
		ExpressionTree bt4 = new ExpressionTree();
		String exp4 = "+ - 496 * 28 6 8128";
		System.out.println("\nTesting ExpressionTree with '+ - 496 * 28 6 8128'");
		preorderBuild(bt4, exp4);
		System.out.println("Evaluating expression tree...");
		System.out.println("Result: " + bt4.evaluate());
  }

}
