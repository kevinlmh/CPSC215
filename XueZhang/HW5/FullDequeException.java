/**
 * File: FullDequeException.java
 *
 * Runtime exception thrown when one tries to perform operation addFirst or
 * addLast on a full deque.
 */

public class FullDequeException extends RuntimeException {  
  public FullDequeException(String err) {
    super(err);
  }
}
