/**
 * File: DequeQueue.java
 * @author: Yisheng Cai
 * @author: Jason Katz
 * @version: 1.0.0  2/27/13 
 * This is a implementation of the class DequeQueue.  
 */

public class DequeQueue<E> implements Queue<E> {
  protected NodeDeque<E> D;
  
	
  public DequeQueue(){
	D=new NodeDeque<E>();
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
    if (D.size() == 0)
      return true;
    return false;
  }


  /**
   * This method gets the first element of the list 
   * @return the element in the second node
   */
  public E front(){
	return D.getFirst();
  }



  /**
   * This method adds an element to the end of the list 
   * @param an type E element x
   */
  public void enqueue(E x){
	D.addLast(x);
  }

  /**
   * This method removes an element from the front of the list 
   * @return element that is removed.
   */
  public E dequeue(){
    return D.removeFirst();
  }
}

