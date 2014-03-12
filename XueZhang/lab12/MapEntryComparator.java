/**
 * File: MapEntryComparator.java
 * 
 * This class defines a comparator for Map.Entry<String, Integer> objects.
 *
 * @author Takunari Miyazaki
 * @author Niranjana Pokharel and Yisheng Cai
 * @version 1.0, 17/4/2013
 *
 * @see java.util.Comparator
 * @see java.util.Map.Entry
 */

import java.util.*;

public class MapEntryComparator<E> implements Comparator<E> {


  /**
   * Returns a negative integer, zero, or a positive integer as the first 
   * argument is less than, equal to, or greater than the second.
   * @param a and b takes the element of type E for comparision
   * @return z returns the variable of type int 
   */
  public int compare(E a, E b) {
	
	int x=((Map.Entry<String,Integer>)a).getValue();
	int y=((Map.Entry<String,Integer>)b).getValue();
    int z=y-x;
	return z;
  }

}
