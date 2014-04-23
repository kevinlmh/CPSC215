/**
 * File: ListMap.java
 * 
 * This class implements the ADT map using a doubly-linked list.
 *
 * @author Takunari Miyazaki
 * @author Kevin Liu
 * @version 1.0 04/23/2014
 * @see BoundaryViolationException
 * @see Entry
 * @see Map
 * @see MapEntry
 * @see InvalidKeyException
 * @see InvalidPositionException
 * @see Iterable
 * @see NodePositionList
 * @see Position
 * @see PositionList
 */

public class ListMap<K,V> implements Map<K,V> {

  /** Underlying list */
  private PositionList<Entry<K,V>> S;

  /** Creates an empty map */
  public ListMap() {
    S = new NodePositionList<Entry<K,V>>();
  }

  // Auxiliary methods
  protected K key(Position<Entry<K,V>> p) { return p.element().getKey(); } 
  protected V value(Position<Entry<K,V>> p) { return p.element().getValue(); }
  protected void checkKey(K k) throws InvalidKeyException {
    if (k == null) throw new InvalidKeyException("Invalid key: null.");
  }

  /** Returns the number of entries in the map. */
  public int size() { return S.size(); }

  /** Tests whether the map is empty. */
  public boolean isEmpty() { return S.isEmpty(); }

  /** Returns a value whose associated key is k. */
  public V get(K k) throws BoundaryViolationException, InvalidKeyException, 
    InvalidPositionException {
    checkKey(k);
    if (isEmpty()) return null;
    Position<Entry<K,V>> p = S.first();
    do {
      if (k.equals(key(p)))
	return value(p);
      else if (p == S.last())
	return null;
      else
	p = S.next(p);
    } while (true);
  }

  /** Insert an entry with a given key k and value v into the map, returning 
   *  the old value whose associated key is k if it exists. 
	 * @param k key of entry
	 * @param v value of entry
	 * @return the old value whose associated key is k
	 */
  public V put(K k, V v) throws BoundaryViolationException, 
    InvalidKeyException, InvalidPositionException {

    // Complete this blank.
    Iterator<Entry<K,V>> i = S.iterator();
		while (i.hasNext()) {
			MapEntry<K,V> p = (MapEntry<K,V>)i.next();
      if (k.equals(p.getKey())) {
				V temp = p.setValue(v);
				return temp;
			}		
    } 
		S.addLast(new MapEntry<K,V>(k,v));
		return null;
	
	}

  /** Removes from the map the entry whose key is k, returning the value of 
   *  the removed entry. */
  public V remove(K k) throws BoundaryViolationException, 
    InvalidKeyException, InvalidPositionException {
    checkKey(k);
    V w;
    if (isEmpty()) return null;
    Position<Entry<K,V>> p = S.first();
    do {
      if (k.equals(key(p))) {
	w = value(p);
	S.remove(p);
        return w;
      }
      else if (p == S.last()) {
	return null;
      }
      else
	p = S.next(p);
    } while (true);
  }

  /** Returns an iterable collection of all key-value entries in the 
   *  map.
	 * @return an iterable colletion of all key-value entries in the map
	 */
  public Iterable<Entry<K,V>> entrySet() {

    // Complete this blank.
		NodePositionList list = new NodePositionList<Entry<K,V>>();
		Iterator<Entry<K,V>> i = S.iterator();
		while (i.hasNext())
			list.addLast(i.next());
		return list;
  }

}
