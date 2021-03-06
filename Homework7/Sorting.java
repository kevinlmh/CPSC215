/**
 * File: Sorting.java
 *
 * We compare the performances of sorting algorithms by counting the numbers 
 * of comparisons performed.
 *
 * @author Takunari Miyazaki
 * @author Kevin Liu
 * @see ArrayIndexList
 * @see IndexList
 * @see Integer
 * @see Iterator
 */

public class Sorting {

  /** This method prints the elements of an array list L. */
  public static <E> void printIndexList(IndexList<E> L) {
    Iterator<E> i = L.iterator();
    while (i.hasNext())
      System.out.print(i.next().toString() + " ");
    System.out.println();
  }

  /** This method swaps two elements of an array list L at indices i and j. */
  public static <E> void swap(IndexList<E> L, int i, int j) {
    E e = L.get(i);
    L.set(i, L.get(j));
    L.set(j, e);
  }

  /** This method bubble-sorts the elements of an array list L. 
	 * @param L the array list to be sorted
	 */
	public static <E> long bubblesort(IndexList<E> L) {
		long count = 0;
		int n = L.size();
		for (int i = 1; i < n-1; i++)
			for (int j = 0; j < n-i; j++) {
				if (((Comparable)L.get(j)).compareTo(L.get(j+1)) > 0)
					swap(L, j, j+1);
				count++;
			}
		return count;
	}

  /** This method selection-sorts the elements of an array list L. 
	 * @param L the array list to be sorted
	 */
	public static <E> long selectionsort(IndexList<E> L) {
		long count = 0;
		int n = L.size();
		for (int i = 0; i < n-1; i++) {
			int minIndex = i;
			for (int j = i+1; j < n; j++) {
				if (((Comparable)L.get(j)).compareTo(L.get(minIndex)) < 0)
					minIndex = j;
				count++;
			}
			if (minIndex != i)
				swap(L, i, minIndex);
			
		}
		return count;
	}


  /** This method heap-sorts (in place) the elements of an array list L. 
	 * @param L the array list to be sorted
	 */
  public static <E> long heapsort(IndexList<E> L) {
		long count = 0;
    int n = L.size();

    // The first phase builds a heap, one at a time, of heapsize.
    for (int heapsize = 0; heapsize < n; heapsize++) {
			int i = heapsize;
      while (i > 0) {
				int j = (i - 1)/2;
				count++;
				if (((Comparable) L.get(i)).compareTo(L.get(j)) > 0) {
	  			swap(L, i, j);
	  			i = j;
				} else  break;
      }
    }

    // Complete the second phase below.
		for (int heapsize = n-1; heapsize > 0; heapsize--) {
			int i = 0;
			swap(L, i, heapsize);
			while (i*2+1 < heapsize) {
					int bigger = i*2+1;
					count+=2;
					if (i*2+2 < heapsize && (((Comparable)L.get(i*2+2)).compareTo(L.get(i*2+1)) > 0)) 
						bigger = i*2+2;
					if (((Comparable)L.get(bigger)).compareTo(L.get(i)) > 0)
						swap(L, i, bigger);
					else break;
					i = bigger;
			} 
		}
		
		return count;	
	}

  /** This method compares the performaces of sorting algorithms. */
  public static void main(String args[]) {

    java.util.Random r = new java.util.Random();

    // Instantiate a list of 20 random integers between 0 and 19.
    IndexList<Integer> L20 = new ArrayIndexList<Integer>();
    for (int i = 0; i < 20; i++)
      L20.add(i, new Integer(Math.abs(r.nextInt()) % 20));
		
    // Test heap sort.
    System.out.println("Testing heap sort...");
    System.out.print("Input:  ");
    printIndexList(L20);
    heapsort(L20);
    System.out.print("Output: ");
    printIndexList(L20);
		
		// Test bubble sort.
		for (int i = 0; i < 20; i++)
      L20.set(i, new Integer(Math.abs(r.nextInt()) % 20));
		System.out.println("Testing bubble sort...");
		System.out.print("Input: ");
		printIndexList(L20);
		bubblesort(L20);
		System.out.print("Output: ");
		printIndexList(L20);
		    
		// Test selection sort.
		for (int i = 0; i < 20; i++)
      L20.set(i, new Integer(Math.abs(r.nextInt()) % 20));
		System.out.println("Testing selection sort...");
		System.out.print("Input: ");
		printIndexList(L20);
		selectionsort(L20);
		System.out.print("Output: ");
		printIndexList(L20);
		
		// Print comparision
		for (int n = 10; n <= 100000; n*=10) {
			IndexList<Integer> Lb = new ArrayIndexList<Integer>();
			IndexList<Integer> Ls = new ArrayIndexList<Integer>();
			IndexList<Integer> Lh = new ArrayIndexList<Integer>();
			for (int i = 0; i < n; i++) {
				Lb.add(i, new Integer(Math.abs(r.nextInt()) % n));
				Ls.add(i, new Integer(Math.abs(r.nextInt()) % n));
				Lh.add(i, new Integer(Math.abs(r.nextInt()) % n));
			}
			long count_b = bubblesort(Lb);
			long count_s = selectionsort(Ls);
			long count_h = heapsort(Lh);
			System.out.println("For n = "+n+", bubble sort performs "+count_b+" comparisions.");
			System.out.println("For n = "+n+", selection sort performs "+count_s+" comparisions.");
			System.out.println("For n = "+n+", heap sort performs "+count_h+" comparisions.");
		}

  }

}	
