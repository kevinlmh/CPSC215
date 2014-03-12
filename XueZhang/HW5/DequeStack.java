/**
 * File: DequeStack.java
 * @author: Yisheng Cai
 * @version: 1.0.0  03/03/13 
 * This is a implementation of the class DequeStack.  
 */

public class DequeStack<E> implements Stack<E> {
  protected ArrayDeque<E> D;
  
 
  public DequeStack(){
    D=new ArrayDeque<E>();
 }

  /**
   * This is a method shows the size of the list
   * @return an integer as the size of the list
   */  
  public int size(){
 return D.size();
  }
 
  /**
   * This is a method checks if the list is empty or not
   *
   * @return true if the list is empty, false if the list has element 
   */
  public boolean isEmpty() {    
    return (D.isEmpty());
  }


  /**
   * This method gets the first element of the list 
   * @return the element in the second node
   */
  public E top() throws EmptyStackException{
    return D.getLast();
  }



  /**
   * This method adds an element to the end of the list 
   * @param an type E element
   */
  public void push (E element){
    D.addLast(element);
  }

  /**
   * This method removes an element from the front of the list 
   * @return element that is removed.
   */
  public E pop() throws EmptyStackException{
    return D.removeLast();
  }
}
