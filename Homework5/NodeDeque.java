/**
 * File: NodeDeque.java
 *
 * This is an implementation of a Deque using DLNode.
 *
 * @author: Kevin Liu
 * @version: 1.0 Feb 25 2014
 * @see DLNode
 * @see Deque
 * @see EmptyDequeException
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
	* Returns the number of elements in the deque.
	* @return number of elements in the deque.
	*/
	public int size() {   
		return size;
	}

	/** 
	* Returns whether the deque is empty.
	* @return true if the deque is empty, false otherwise.
	*/
	public boolean isEmpty() {    
		if (size == 0)
			return true;
		return false;
	}
	
	/** 
	* Get the first element of the deque.
	* @return the first element
	* @exception EmptyDequeException if the deque is empty.
	*/
	public E getFirst() throws EmptyDequeException {  
		if (isEmpty())	
	  		throw new EmptyDequeException("Deque is empty.");
		return header.getNext().getElement();
	}

	/** 
	* Get the last element of the deque.
	* @return the last element
	* @exception EmptyDequeException if the deque is empty.
	*/
	public E getLast() throws EmptyDequeException {
		if (isEmpty())
	  		throw new EmptyDequeException("Deque is empty.");
		return trailer.getPrev().getElement();	  
	}
	
	/** 
	* Inserts an element at the front of the deque.
	* @param o new element to be inserted.
	*/
	public void addFirst(E o) {  
		DLNode<E> second = header.getNext();
		DLNode<E> first = new DLNode<E>(o, header, second);
		second.setPrev(first);
		header.setNext(first);
		size++;
	}

	/** 
	* Inserts an element at the rear of the deque.
	* @param o new element to be inserted.
	*/
	public void addLast(E o) {
		DLNode<E> secondtolast = trailer.getPrev();
		DLNode<E> last = new DLNode<E>(o, secondtolast, trailer);
		secondtolast.setNext(last);
		trailer.setPrev(last);
		size++;
	}
	
	/** 
	* Removes the first element of the deque.
	* @return element removed.
	* @exception EmptyDequeException if the deque is empty.
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
	* Removes the last element of the deque.
	* @return element removed.
	* @exception EmptyDequeException if the deque is empty.
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
	
	/**
	 * Prints all the elements in the deque.
	 */
	public void print() {
		DLNode n = header.getNext();
		System.out.print("{ ");
		while (n != trailer) {
			System.out.print(n.getElement());
			if (n.getNext() != trailer) 
				System.out.print(", ");
			n = n.getNext();
		}
		System.out.println(" }");
	}

}
