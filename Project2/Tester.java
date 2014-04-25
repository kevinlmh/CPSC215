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
 *
 * @author Kevin Liu
 * @version 1.0 04/23/2014
 */

public class Tester {

  public static void main(String args[]) {
    BinarySearchTreeMap<String, Integer> bst 
      = new BinarySearchTreeMap<String, Integer>();
    String S[] = {"gamma", "phi", "beta", "alpha", "delta", "lambda", 
      "epsilon", "zeta" };

    // Complete the blank here to perform 1, 2, 3, 4 and 5.
		
		// 1.Insert all strings
		for (int i=0; i<S.length; i++)
			bst.put(S[i], 1000+i);
		
		// 2.Print all entries
		Iterator<Entry<String,Integer>> it = bst.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String,Integer> current = it.next();
			System.out.println(current.getKey()+" - "+current.getValue());
		}
		
		// 3.Test get(), put() and remove()
		System.out.println("Inserting new entry kevin - 9999...");
		bst.put("kevin",9999);
		it = bst.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String,Integer> current = it.next();
			System.out.println(current.getKey()+" - "+current.getValue());
		}
		System.out.println("Getting the entry with key lambda...");
		System.out.println("lambda"+" - "+bst.get("lambda"));
		System.out.println("Removing the entry kevin - 9999...");
		bst.remove("kevin");
		it = bst.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String,Integer> current = it.next();
			System.out.println(current.getKey()+" - "+current.getValue());
		}

		// 4.Print all values
		System.out.println("Printing all values...");
		Iterator<Integer> vit = bst.values().iterator();
		while (vit.hasNext()) {
			int current = vit.next();
			System.out.println(current);
		}

		// 5.Print all keys
		System.out.println("Printing all keys...");
		Iterator<String> sit = bst.keySet().iterator();
		while (sit.hasNext()) {
			String current = sit.next();
			System.out.println(current);
		}

  }

}
