/**
 * File: NodeDeque.java
 * @author: Yisheng Cai
 * @author: Jason Katz
 * @version: 1.0.0  2/27/13 
 * This is a partial implementation of the class NodeDeque.  You are to 
 * complete the implementation in Laboratory 6.
 */

public class NodeDeque<E> implements Deque<E> {

  protected DLNode<E> header, trailer;  // sentinels
  protected int size;                   // number of elements

  public NodeDeque() {
    header = new DLNode<E>();
    trailer = new DLNode<E>();
    header.setNext(trailer);
    trailer.setPrev(header);
    size = 0;
  }
  


  /**
   * This is a method shows the size of the list
   * @return an integer as the size of the list
   */
  public int size() {   
    return size;
  }



  /**
   * This is a method checks if the list is empty or not
   *
   * @return true if the list is empty, false if the list has element 
   */
  public boolean isEmpty() {    
    if (size == 0)
      return true;
    return false;
  }

  /**
   * This method gets the first element of the list 
   * @return the element in the second node
   */

  public E getFirst() throws EmptyDequeException {  
    if (isEmpty())
      throw new EmptyDequeException("Deque is empty.");
    return header.getNext().getElement();
  }

  /**
   * This method gets the last element of the list 
   * @return the element in the second to the last node
   */
  public E getLast() throws EmptyDequeException {  
    if (isEmpty())
      throw new EmptyDequeException("Deque is empty.");
    return trailer.getPrev().getElement();
  }

  /**
   * This method adds an element to the front of the list 
   * @param an type E element o
   */
  public void addFirst(E o) {  
    DLNode<E> second = header.getNext();
    DLNode<E> first = new DLNode<E>(o, header, second);
    second.setPrev(first);
    header.setNext(first);
    size++;
  }


  /**
   * This method adds an element to the end of the list 
   * @param an type E element o
   */
  public void addLast(E o) {  
    DLNode<E> first = trailer.getPrev();
    DLNode<E> last = new DLNode<E>(o,first,trailer); 
    first.setNext(last);
	trailer.setPrev(last);
    size++;
  }
  
  /**
   * This method removes an element from the front of the list 
   * @return the element that is removed
   */
  public E removeFirst() throws EmptyDequeException {
    if (isEmpty())
      throw new EmptyDequeException("Deque is empty.");
    DLNode<E> first = header.getNext();
    E o = first.getElement();
    DLNode<E> second = first.getNext();
    header.setNext(second);
    second.setPrev(header);
    size--; 
    return o;
  }

  /**
   * This method removes an element from the end of the list 
   * @return the element that is removed
   */
  public E removeLast() throws EmptyDequeException {
    if (isEmpty())
      throw new EmptyDequeException("Deque is empty.");
    DLNode<E> last = trailer.getPrev();
    E o = last.getElement();
    DLNode<E> secondtolast = last.getPrev();
    trailer.setPrev(secondtolast);
    secondtolast.setNext(trailer);
    size--; 
    return o;
  }

}
