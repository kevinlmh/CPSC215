// * @author Tony O'Rourke
// * @author Yisheng Cai

public class Tester {
  public static <E> void print(Iterable<E> L) {

		Iterator<E> i = L.iterator();
		System.out.print("[");
		while (i.hasNext()) {
			System.out.print(i.next());
			if (i.hasNext())
				System.out.print(", ");
		}
		System.out.println("]");

  }
  public static void main(String args[]) {

    Entry<String, String> e;
    HashTableDictionary<String,String> h = 
      new HashTableDictionary<String,String>();

    // We use city names as keys and airport codes as values.
    String keys[] = { "Boston", "Chicago", "Chicago", "Frankfurt am Main", 
      "Hartford", "London", "London", "London", "Newark", "New York", 
      "New York", "Paris", "Paris", "San Francisco", "Tokyo", "Tokyo" };
    String values[] = { "BOS", "MDW", "ORD", "FRA", "BDL", "LGW", "LHR", 
      "STN", "EWR", "JFK", "LGA", "CDG", "ORY", "SFO", "HND", "NRT" };

    // We print the input list first.
    System.out.println("Input list:");
    System.out.println();
    for (int i = 0; i < keys.length; i++)
      System.out.println(values[i] + " - " + keys[i]);

    // Insert the given items.
    for (int i = 0; i < keys.length; i++)
      h.put(keys[i], values[i]);

    e = h.get("London");
    System.out.println();
    System.out.println("There are three major airports in London, and ");
    System.out.println("get(London) gives the key-value pair (" + 
      e.getKey() + ", " + e.getValue() + ")");

    // Remove one airport in London.
    System.out.println();
    System.out.println("After removing the entry (" + e.getKey() + ", " + 
      e.getValue() + ")");                    
    e = h.remove(e);
    e = h.get("London");
    System.out.println("get(London) gives the key-value pair (" + 
      e.getKey() + ", " + e.getValue() + ")");
    
    // Add code segments to test the methods you implemented using iterators.
		System.out.println("Getting all entries with key London:");
		Iterator<Entry<String,String>> iterator = h.getAll("London").iterator();
		while(iterator.hasNext())
			System.out.println(iterator.next());			
		System.out.println();
		
		System.out.println("Printing the entry set: ");
		iterator = h.entrySet().iterator();
		while(iterator.hasNext())
			System.out.println(iterator.next());			
		System.out.println();

		System.out.println("Removing Entries with key New York:");		
		iterator = h.removeAll("New York").iterator();
		while(iterator.hasNext())
			System.out.println(iterator.next());			
		System.out.println();

		System.out.println("Printing the entry set: ");
		iterator = h.entrySet().iterator();
		while(iterator.hasNext())
			System.out.println(iterator.next());			
		System.out.println();
  }

}
