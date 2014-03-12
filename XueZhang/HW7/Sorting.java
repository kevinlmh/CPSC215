/**
 * File: Sorting.java
 *
 * We compare the performances of sorting algorithms by counting the numbers 
 * of comparisons performed.
 *
 * @author Takunari Miyazaki
 * @autor Yisheng Cai
 * @version 1.1, 04/15/13
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

  /** This method heap-sorts (in place) the elements of an array list L. 
	* @param a list L to be sorted	
	* @return a counter that counts the number of comparisons made in the sorting 
	*/
  public static <E> long heapsort(IndexList<E> L) {
		long count=0;
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
				}
				else
    			break;
  		}
    }
		
		int heapsize = n-1;

		while (heapsize>=0){
			swap(L, 0, heapsize);
			int j=0;
			int left=j*2+1;
			int right=j*2+2;
			int max;
			while (left<heapsize){
				max=left;
				if (right<heapsize){
					count++;
					if (((Comparable) L.get(right)).compareTo(L.get(left))>0)
						
						max=right;
						
				}
				count++;
				if (((Comparable) L.get(j)).compareTo(L.get(max))<0){
					
					swap(L, max, j);
					j=max;
					left=j*2+1;
					right=j*2+2;
				}
				else
					break;				
			}
			heapsize--;
		}
		return count;
  }

  /** This method bubble-sorts the elements of an array list L. 
	* @param a list L to be sorted	
	* @return a counter that counts the number of comparisons made in the sorting 
	*/
	public static <E> long bubblesort(IndexList<E> L) {
		int n=L.size();
		long count=0;
		for (int i =1; i<n; i++){
			for (int j=0; j<n-i; j++){
				count++;
				if (((Comparable) L.get(j)).compareTo(L.get(j+1)) > 0){
					swap(L,j,j+1);
				}
			}
		}
		return count;
	}
			
  /** This method selection-sorts the elements of an array list L. 
	* @param a list L to be sorted	
	* @return a counter that counts the number of comparisons made in the sorting 
	*/
	public static <E> long selectionsort(IndexList<E> L) {
    int n = L.size();
		long count = 0;
		for (int i = 0; i < n-1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < n-1; j++){
				count++;
				if (((Comparable) L.get(j)).compareTo(L.get(j+1)) < 0)
					minIndex = j;
					
			}
			count++;
			if (minIndex != i)
				swap(L, i, minIndex);
		}		
		return count;
	}

	/*This method generates lists and uses different sorting methods to compare the efficiency of them
	* @param integer n which is the number of sortions made in each run. 
	*/
	public static void test(int n) { 
		java.util.Random r = new java.util.Random();

    IndexList<Integer> B = new ArrayIndexList<Integer>();
    for (int i = 0; i < n; i++)
      B.add(i, new Integer(Math.abs(r.nextInt()) % n));
    bubblesort(B);
		System.out.println("For n = "+n+", bubble sort performs "+bubblesort(B)+" comparisons.");

    IndexList<Integer> S = new ArrayIndexList<Integer>();
    for (int i = 0; i < n; i++)
      S.add(i, new Integer(Math.abs(r.nextInt()) % n));
    selectionsort(S);
		System.out.println("For n = "+n+", selection sort performs "+selectionsort(S)+" comparisons.");

    IndexList<Integer> L = new ArrayIndexList<Integer>();
    for (int i = 0; i < n; i++)
      L.add(i, new Integer(Math.abs(r.nextInt()) % n));
    heapsort(L);
		System.out.println("For n = "+n+", heap sort performs "+heapsort(L)+" comparisons.");
	}

	
  /** This method compares the performaces of sorting algorithms. */
  public static void main(String args[]) {
    java.util.Random r = new java.util.Random();

    // Instantiate a list of 20 random integers between 0 and 19.
    IndexList<Integer> B20 = new ArrayIndexList<Integer>();
    for (int i = 0; i < 20; i++)
      B20.add(i, new Integer(Math.abs(r.nextInt()) % 20));
		
    // Test bubble sort.
    System.out.println("Testing bubble sort...");
    System.out.print("Input:  ");
    printIndexList(B20);
    bubblesort(B20);
    System.out.print("Output: ");
    printIndexList(B20);
		System.out.println("");

    // Instantiate a list of 20 random integers between 0 and 19.
    IndexList<Integer> S20 = new ArrayIndexList<Integer>();
    for (int i = 0; i < 20; i++)
      S20.add(i, new Integer(Math.abs(r.nextInt()) % 20));
		
    // Test selection sort.
    System.out.println("Testing selection sort...");
    System.out.print("Input:  ");
    printIndexList(S20);
    bubblesort(S20);
    System.out.print("Output: ");
    printIndexList(S20);
		System.out.println("");

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
		System.out.println("");

		test(10);
		System.out.println("");
		test(100);
		System.out.println("");
		test(1000);
		System.out.println("");
		test(10000);
		System.out.println("");
		test(100000);
		System.out.println("");

  }

}
