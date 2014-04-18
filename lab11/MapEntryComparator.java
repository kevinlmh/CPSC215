/**
 * File: MapEntryComparator.java
 * 
 * This class defines a comparator for Map.Entry<String, Integer> objects.
 *
 * @author Takunari Miyazaki
 * @author Kevin Liu
 * @author Yaoqi Guo
 * @version 1.0 04/16/2014
 *
 * @see java.util.Comparator
 * @see java.util.Map.Entry
 */

import java.util.*;

public class MapEntryComparator<E> implements Comparator<E> {

  /**
   * Returns a negative integer, zero, or a positive integer as the first 
   * argument is less than, equal to, or greater than the second.
   *
	 * @param a the first entry to be compared.
	 * @param b the second entry to be compared.
	 * @return the integer indicating the result of comparison.
	 */
  public int compare(E a, E b) {

   	// Complete this method.
		return (((Map.Entry<String, Integer>)b).getValue() - ((Map.Entry<String, Integer>)a).getValue());
  }

}
