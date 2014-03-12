/**
 * File: DequeQueue.java
 *
 * An implementation of the ADT queue Using the class NodeDeque.
 * The methods addLast() and removeFirst() of the class NodeDeque are used 
 * to implement the methods enqueue() and dequeue()).
 *
 * @author: Kevin Liu
 * @version: 1.0 Feb 25 2014
 * @see Queue
 * @see NodeDeque
 * @see EmptyQueueException
 */

public class DequeQueue<E> implements Queue<E> {
	
	private NodeDeque deque;	//a NodeDeque to implement Queue
	
	public DequeQueue() {
		//instantiate the NodeDeque declared earlier
		deque = new NodeDeque();
	}
	
	/** 
	* Returns the number of elements in the queue.
	* @return number of elements in the queue.
	*/
	public int size() {
		return deque.size();
	}  

	/** 
	* Returns whether the queue is empty.
	* @return true if the queue is empty, false otherwise.
	*/
	public boolean isEmpty() {
		return deque.isEmpty();
	}

	/**
	* Inspects the element at the front of the queue.
	* @return element at the front of the queue.
	* @exception EmptyQueueException if the queue is empty.
	*/
	public E front() throws EmptyQueueException {
		return (E) deque.getFirst();
	}

	/** 
	* Inserts an element at the rear of the queue.
	* @param element new element to be inserted.
	*/
	public void enqueue (E element) {
		deque.addLast(element);
	}

	/** 
	* Removes the element at the front of the queue.
	* @return element removed.
	* @exception EmptyQueueException if the queue is empty.
	*/
	public E dequeue() throws EmptyQueueException {
		return (E) deque.removeFirst();
	}

}
