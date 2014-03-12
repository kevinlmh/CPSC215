/** 
 * File: ArrayDeque.java
 *
 * ArrayDeque class implements methods in Deque class to 
 * 
 * @author Yisheng Cai
 * @version 1.0.0 03/03/13
 * @see EmptyDequeException
 */

public class ArrayDeque<E> implements Deque<E>{
  protected int N;
  public static final int CAPACITY = 1000;   //The default capacity is 1000
  protected int capacity;
  protected E D[];
  protected int front;
  protected int rear;
  
  ArrayDeque (int cap){
    capacity = cap;
    N = capacity + 1;
    D = (E []) new Object [N];  //creating an array with N elements
  }
  
  ArrayDeque (){
    this (CAPACITY);
  }
  
	/*This method returns the number of elements exist in the array
   * @return integer number that indicates the size of this list
   */
  public int size(){
    int s = 0;
    s= (rear - front + N)%N;
    return s;
  }
  
	/*This method returns boolean if the array is empty
   * @ return true if the array is empty, false if the array is not empty
	 */
  public boolean isEmpty(){
    return (front == rear);
  }
  
	/*This method gets the first element of the array 
	 * @return element type E, which is the first element of the array
	 */
  public E getFirst() throws EmptyDequeException{
    if (isEmpty()) 
      throw new EmptyDequeException("Deque is empty.");
    return D[front];
  }
  
	/*This method gets the last element of the array 
	 * @return element type E, which is the last element of the array
	 */
  public E getLast() throws EmptyDequeException{
    if (isEmpty()) 
      throw new EmptyDequeException("Deque is empty.");
    return D[rear-1];
  }
  
  
	/*This method adds an element to the beginning 
	 * @param element type E, which will be the first element of the array
	 */
  public void addFirst (E element) throws FullDequeException{
    if ((rear + 1) == front)
      throw new FullDequeException("The deque is full. ");
    front = (front-1+N)%N;
    D[front]=element;
  }
 
	/*This method adds an element to the end 
	 * @param element type E, which will be the last element of the array
	 */
  public void addLast (E element){
    if ((rear + 1) == front)
      throw new FullDequeException("The deque is full. ");
    rear = (rear+1+N)%N;
    D[rear-1]=element;
  }
  
	/*This method removes an element from the beginning 
	 * @return the element that is removed
	 */
  public E removeFirst() throws EmptyDequeException{
    if (isEmpty()) 
      throw new EmptyDequeException("Deque is empty.");
    E toReturn = D[front];
    D[front] = null;
    front = (front + 1)%N;
    return toReturn;
  }
  
	/*This method removes an element from the beginning 
	 * @return the element that is removed
	 */
  public E removeLast() throws EmptyDequeException{
    if (isEmpty()) 
      throw new EmptyDequeException("Deque is empty.");
    E toReturn = D[rear-1];
    D[rear-1] = null;
    rear = (rear - 1)%N;
    return toReturn;
  }
  

  //print statement that displays the whole array and the first and last element
  public void print(){
    for (int i = front; i < size(); i=(i+1)%N){
      System.out.print(D[i]+"; ");
    }
    System.out.println("The first element is "+D[front]+", and the last one is "+D[rear-1]+". ");
    
  }
}
  
  
  
