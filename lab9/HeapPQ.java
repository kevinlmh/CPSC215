/**
 * File: HeapPQ.java
 *
 * Realization of a priority queue by means of a heap.  The heap is directly 
 * built on the ADT array list.
 *
 * @author Takunari Miyazaki
 * @see ArrayIndexList
 * @see Comparator
 * @see DefaultComparator
 * @see Entry
 * @see IndexList
 */

public class HeapPQ<K,V> implements PriorityQueue<K,V> {

  protected IndexList<Entry<K,V>> heap;
  protected Comparator<K> comp;
  protected int size;

  /** Inner class for entries */
  protected static class MyEntry<K,V> implements Entry<K,V> {
    protected K k;
    protected V v;
    public MyEntry(K key, V value) {
      k = key;
      v = value;
    }
    public K getKey() { return k; }
    public V getValue() { return v; }
  }

  /** Creates an empty heap with the default comparator. */ 
  public HeapPQ() {
    heap = new ArrayIndexList<Entry<K,V>>();
    comp = new DefaultComparator<K>();
    heap.add(0, null);
    size = 0;
  }

  /** Creates an empty heap with the given comparator. */
  public HeapPQ(Comparator<K> c) {
    heap = new ArrayIndexList<Entry<K,V>>();
    comp = c;
    heap.add(0, null);
    size = 0;
  }

  /** Returns the size of the heap. */
  public int size() {
    return size;
  }

  /** Returns whether the heap is empty. */
  public boolean isEmpty() {
    return size() == 0;
  }

  /** Returns but does not remove an entry with minimum key. */
  public Entry<K,V> min() throws EmptyPriorityQueueException {
    if (isEmpty()) 
      throw new EmptyPriorityQueueException("Priority queue is empty.");
    return heap.get(1);
  }

  /** Inserts a key-value pair and return the entry created. */
  public Entry<K,V> insert(K k, V x) throws InvalidKeyException {
		checkKey(k);
		Entry<K, V> entry = new MyEntry<K, V>(k, x);
		heap.add(size()+1, entry);
		int i = size() + 1;
		while ( (i/2 >= 1) && (comp.compare(key(heap.get(i/2)), key(heap.get(i))) > 0) ) {
			swap(i, i/2);
			i = i/2;
		}
		size++;
		return entry;
    // Complete this method.

  }

  /** Removes and returns an entry with minimum key. */
  public Entry<K,V> removeMin() throws EmptyPriorityQueueException {
		Entry<K, V> temp = heap.get(1);
		heap.set(1, heap.get(size()));
		heap.remove(size());
		size--;
		int i = 1;
		int smaller;
		while ( i*2 <= size() ) {
			if( i*2+1 <= size() ) {
				smaller = (comp.compare(key(heap.get(i*2)), key(heap.get(i*2+1))) < 0)? i*2 : i*2+1;
				swap(i, smaller);
				i = smaller;
			} else {
					if(comp.compare(key(heap.get(i*2)), key(heap.get(i))) < 0 ) {
						swap(i, i*2);
						i = i*2;	
					}else break; 
			}
		}
		return temp;				 
    // Complete this method.

  }

  /** Returns the key stored in an entry. */
  protected K key(Entry<K,V> e) {
    return e.getKey();
  }

  /** Returns the value stored in an entry. */
  protected V value(Entry<K,V> e) {
    return e.getValue();
  }

  /** Determines whether a given key is valid. */
  protected void checkKey(K key) throws InvalidKeyException {
    try {
      comp.compare(key, key);
    }
    catch(Exception e) {
      throw new InvalidKeyException("Invalid key");
    }
  }

  /** Swaps the entries of the two given indices. */
  protected void swap(int i, int j) {
    Entry<K,V> temp = heap.get(i);
    heap.set(i, heap.get(j));
    heap.set(j, temp);
  }

}
