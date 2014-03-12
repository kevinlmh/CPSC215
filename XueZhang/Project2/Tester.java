/**
 * File: Tester.java
 *
 * This is a simple test driver application to test your BinarySearchTreeMap 
 * class.  It should perform the following operations.
 * 1. Insert all strings contained in the array S into the binary search 
 *    tree bst using the strings as keys and arbitrary integers as values.
 * 2. Print all entries as legible key-value pairs using the method 
 *    entrySet().
 * 3. Test the methods get(), put() and remove().
 * 4. Print all values using the method values().
 * 5. Print all keys using the method keys().
 */

public class Tester {

  //Print method for printing out an iterable set of elements
  public static <E> void print(Iterable<E> L) {
    Iterator<E> i = L.iterator();
    while (i.hasNext())
      System.out.print(i.next() + " ");
    System.out.println();
  
  }


  public static void main(String args[]) {
    BinarySearchTreeMap<String, Integer> bst 
      = new BinarySearchTreeMap<String, Integer>();
    String S[] = {"gamma", "phi", "beta", "alpha", "delta", "lambda", 
      "epsilon", "zeta" };
    
    
    for(int i=0; i<8;i++){
      bst.put(S[i], (i+100));                  //Testing put method and adding 8 entries to the tree
   System.out.println("Adding: "+S[i]+"  "+(i+100));
    }
    //Print out the set of all keys in the tree
    System.out.print("Key set:  ");
    print(bst.keySet());
    //Print out the set of all values in the tree
    System.out.print("Values:  ");
    print(bst.values());
    //Print out the set of all entries in the tree
    System.out.print("Entry Set:  ");
    Iterator<Entry<String,Integer>> i = bst.entrySet().iterator();
    while (i.hasNext()){
   Entry<String,Integer> n=i.next();
      System.out.print("["+n.getKey() + ","+n.getValue()+"]");
   }
    System.out.println();

    
  System.out.print("Get key of zeta:  ");
  System.out.println(bst.get("zeta"));  
  if (bst.put("Yisheng",163)==null)
    System.out.println("Entry does not exist. Adding [Yisheng, 163]");
  System.out.print("\nKey set:  ");
  Iterator<Entry<String,Integer>> i2 = bst.entrySet().iterator();
  while (i2.hasNext()){
    Entry<String,Integer> n=i2.next();
    System.out.print("["+n.getKey() + ","+n.getValue()+"]");
   }
  
  bst.remove("phi");
  bst.remove("delta");
  System.out.println("\nRemoving phi and delta......");
  System.out.print("\nKey set:  ");
  Iterator<Entry<String,Integer>> i3 = bst.entrySet().iterator();
  while (i3.hasNext()){
    Entry<String,Integer> n=i3.next();
    System.out.print("["+n.getKey() + ","+n.getValue()+"]");
   }



  }


}
