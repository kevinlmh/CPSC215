/**
 * File: ExpressionTree.java
 *
 * A subclass of ArrayBinaryTree to represent simple arithmetic expressions.
 *
 * @author Takunari Miyazaki
 * @author Yisheng Cai
 * @see ArrayBinaryTree
 * @see EmptyTreeException
 * @verision 1.0.0 04/24/2013
 */

public class ExpressionTree extends ArrayBinaryTree<String> {
	public int k=0;
  /** Returns the value of the entire expression tree. 
	* @param the node that is the root of the tree
  * @return integer value of the equation
	*/
  public int evaluate() throws EmptyTreeException {
    if (isEmpty()) throw new EmptyTreeException("Tree is empty");
		//BTPos<String> v=new BTPos<String>(null,0);
		Position<String> v=root();
		return evaluate(v);
		
  }

  /** Recursively evaluates the value of the subtree rooted at v. 
	* @param the node that is the root of the tree
  * @return integer value of the equation
  */
  protected int evaluate(Position<String> v) {

			k= new Integer(v.element());
		
		//}
		return k;
  }

  /** Returns a String represention of the entire expression tree. 
  * @return String of representation of the tree
  */
  public String toString() throws EmptyTreeException{
		if (isEmpty()) throw new EmptyTreeException("Tree is empty");
		Position<String> v=root();
		return toString(v);
  }

  /** Recursively forms a String representation of the subtree rooted at v. 
  * @return String of representation of the tree
	*/
  protected String toString(Position<String> v) {
		String s="";	
		if (isInternal(v))
			s+="(";
		if (hasLeft(v))
			s+=toString(left(v));
		if (isInternal(v))
			s+=" "+v.element()+" ";
		else
			s+=new Integer(v.element());
		if (hasRight(v))
			s+=toString(right(v));
		if (isInternal(v))
			s+=")";
		return s;
  }

}
