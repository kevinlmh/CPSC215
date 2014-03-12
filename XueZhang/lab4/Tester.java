import java.util.*;

/** Test program for the ArrayStringSet class */

public class Tester {

  public static void main(String args[]) {
 
    String s = "BOS";
    String t = "JFK";
       
    ArrayStringSet A = new ArrayStringSet();
    A.add(s);           // The string s is added to A so that 
                        // A = { "BOS" }.

    System.out.print("The set A = "); 
    A.print();

    A.add(t);           // The string t is added to A so that
                        // A = { "BOS", "JFK" }.
    System.out.print("The set A = ");
    A.print();

    A.add("BDL");       // The string "BDL" is added to A so that
                        // A = { "BDL", "BOS", "JFK"}.

    System.out.print("The set A = ");
    A.print();

    A.add("BOS");       // The string "BOS" is added to A but A should
                        // remain unchanged.

    System.out.print("The set A = "); 
    A.print();

    System.out.println("A.has(\"JFK\") = " + A.has("JFK"));

    A.remove("BOS");    // The string "BOS" is removed from A so that 
                        // A = {"BDL", "JFK"}.

    System.out.print("The set A = ");
    A.print();

    System.out.println("A.has(\"BOS\") = " + A.has("BOS"));

    ArrayStringSet B = new ArrayStringSet();

    Random r = new Random();
    int j;
    for (int i = 0; i < 26; i++) {
      j = r.nextInt(26);
      String u = "" + (char)('A' + j);
      B.add(u);
    }

    System.out.print("The set B = ");
    B.print();

    B.remove("K");
    B.add("T");

    System.out.print("The set B = ");
    B.print();

  }

}
