/**
 * File: SCHashTableMap.java
 * 
 * This is a hash-table-based implementation of the ADT map using separate 
 * chaining for collision handling.
 *
 * @author Takunari Miyazaki
 * @author Kevin Liu
 * @version 1.0 04/23/2014
 * @see BoundaryViolationException
 * @see Map
 * @see MapEntry
 * @see InvalidKeyException 
 * @see InvalidPositionException
 * @see Iterable
 * @see Iterator
 * @see ListMap
 * @see NodePositionList
 * @see PositionList
 */

public class SCHashTableMap<K,V> implements Map<K,V> {

  /** Bucket array */
  private ListMap<K,V>[] H;
  /** Capacity of the bucket array */
  private int capacity;
  /** Number of entries in the map */
  private int n;

  /** Creates a hash table with a given capacity cap. */
  public SCHashTableMap(int cap) {
    capacity = cap;
    n = 0;
    H = (ListMap<K,V>[]) new ListMap[capacity];
    for (int i = 0; i < capacity; i++)
      H[i] = new ListMap<K,V>();
  }

  /** Creates a hash table with capacity 4093. */
  public SCHashTableMap() {
    this(4093);
  }

  // Auxiliary methods
  protected void checkKey(K k) throws InvalidKeyException {
    if (k == null) throw new InvalidKeyException("Invalid key: null.");
  }
  public int hashValue(K k) {
    return Math.abs(k.hashCode()) % capacity;
  }

  /** Returns the number of entries in the map. */
  public int size() { return n; }

  /** Tests whether the map is empty. */
  public boolean isEmpty() { return (n == 0); }

  /** Returns a value whose associated key is k. */
  public V get(K k) throws BoundaryViolationException, 
    InvalidKeyException, InvalidPositionException {
    checkKey(k);
    int i = hashValue(k);
    return H[i].get(k);
  }

  /** Insert an entry with a given key k and value v into the map, returning 
   *  the old value whose associated key is k if it exists. 
	 * @param k key of entry
	 * @param v value of entry
	 * @return the old value
	 */
  public V put(K k, V v) throws BoundaryViolationException, 
    InvalidKeyException, InvalidPositionException {

    // Complete this blank.
		V t = H[hashValue(k)].put(k,v);
		if (t == null) {
			n++;
		}
		return t;
  }

  /** Removes from the map the entry whose key is k, returning the value of 
   *  the removed entry. */
  public V remove(K k) throws BoundaryViolationException, 
    InvalidKeyException, InvalidPositionException {
    checkKey(k);
    int i = hashValue(k);
    V w = H[i].remove(k);
    if (w != null) n--;
    return w;
  }

  /** Returns an iterable collection of all key-value entries in the 
   *  map. 
	 * @return an iterable collection of all key-value entries in the map
	 */
  public Iterable<Entry<K,V>> entrySet() {

    // Complete this blank.
		NodePositionList<Entry<K,V>> list = new NodePositionList<Entry<K,V>>();
		for (int i=0; i<H.length; i++) {
			Iterable<Entry<K,V>> l = H[i].entrySet();
			Iterator<Entry<K,V>> it = l.iterator();
			while (it.hasNext())
				list.addLast(it.next());
		}
		return list;
  }

}
