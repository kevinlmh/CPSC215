/**
 * File: MapEntry.java
 *
 * This class defines entries for the ADT map.
 *
 * @author Takunari Miyazaki
 * @see ClassCastException
 * @see Entry
 * @see String
 */

public class MapEntry<K,V> implements Entry<K,V> {

  protected K key;
  protected V value;

  // Constructor
  public MapEntry(K k, V v) { key = k; value = v; }

  // Accessor methods
  public V getValue() { return value; }
  public K getKey() { return key; }

  // An update method
  public V setValue(V v) {
    V oldValue = value;
    value = v;
    return oldValue;
  }

  // Auxiliary methods
  public boolean equals(Entry<K,V> e) {
    MapEntry<K,V> he;
    try { he = (MapEntry<K,V>) e; }
    catch (ClassCastException ex) { return false; }
    return (he.getKey() == key) && (he.getValue() == value);
  }
  public String toString() {
    return key.toString() + "=" + value.toString();
  }

}
