/**
 * File: EmptyListException.java
 *
 * Runtime exception thrown when one tries to access an empty list
 */

public class EmptyListException extends RuntimeException {  
  public EmptyListException(String err) {
    super(err);
  }
}
