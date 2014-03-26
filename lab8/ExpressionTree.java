/**
 * File: ExpressionTree.java
 *
 * A subclass of LinkedBinaryTree to represent simple arithmetic expressions.
 *
 * @author Takunari Miyazaki
 * @author Kevin Liu
 * @version 1.0 03/26/2014
 * @see LinkedBinaryTree
 * @see EmptyTreeException
 */

public class ExpressionTree extends LinkedBinaryTree<String> {

  /** Evaluates the value of the entire expression tree. */
  public int evaluate() throws EmptyTreeException {
		return evaluate(root());	
    // Complete this blank.

  }

  /** 
	 * Recursively evaluates the value of the subtree rooted at v. 
	 * @param v the root of current subtree
	 */
  protected int evaluate(Position<String> v) {
		BTPosition<String> vv = checkPosition(v);
		if (isExternal(vv))
			return new Integer(vv.element());
		else {
			String s = vv.element();
			if (s.equals("+"))
				return evaluate(left(vv)) + evaluate(right(vv));
			else if (s.equals("-"))
				return evaluate(left(vv)) - evaluate(right(vv));
			else if (s.equals("*"))
				return evaluate(left(vv)) * evaluate(right(vv));
			else
				return evaluate(left(vv)) / evaluate(right(vv));
		}
  }

}
