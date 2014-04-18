/**
 * File: WordCount.java
 * 
 * This Java application counts the occurrence of each word in a given 
 * text file (specified as a command-line argument).
 * @author Takunari Miyazaki
 * @author Kevin Liu
 * @author Yaoqi Guo
 * @version 1.0 04/16/2014
 *
 * @see java.io.File
 * @see java.io.FileInputStream
 * @see java.io.FileNotFoundException
 * @see java.io.IOException
 * @see java.io.InputStreamReader
 * @see java.util.StringTokenizer
 */

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class WordCount {

  public static void main(String args[]) {
    String inString = null;
    if (args.length < 1) {
      System.out.println("Usage: java WordCount sourcefile");
      return;
    }

    // Reads the file named as the command-line argument
    try {
      File f = new File(args[0]);
      InputStreamReader iStream = 
        new InputStreamReader(new FileInputStream(f));
      int length = (int)f.length();
      char input[] = new char[length];
      iStream.read(input);
      inString = new String(input);
      StringTokenizer st = 
        new StringTokenizer(inString, "%^@#&$<>`~?!*:;,.()- '\"\n");

      // Complete this blank.
		TreeMap<String, Integer> treemap = new TreeMap<String, Integer>();
			while (st.hasMoreTokens()) {
				String current = st.nextToken();
				if (treemap.get(current) == null)
					treemap.put(current, 1);
				else
					treemap.put(current, treemap.get(current)+1);
			}
			ArrayList<Map.Entry<String, Integer>> entries 
				= new ArrayList(treemap.entrySet());
			MapEntryComparator<Map.Entry<String, Integer>> comp
				= new MapEntryComparator<Map.Entry<String, Integer>>();
			Iterator i = entries.iterator();
			System.out.print("[");
			while (i.hasNext()) {
				Map.Entry<String, Integer> e = (Map.Entry<String, Integer>)i.next();
				System.out.print(e.getKey() + "=" + e.getValue());
				if (i.hasNext())
					System.out.print(", ");
			}
			System.out.println("]");
			System.out.println();

			Collections.sort(entries, comp); 
			i = entries.iterator();
			System.out.print("[");
			while (i.hasNext()) {
				Map.Entry<String, Integer> e = (Map.Entry<String, Integer>)i.next();
				System.out.print(e.getKey() + "=" + e.getValue());
				if (i.hasNext())
					System.out.print(", ");
			}
			System.out.println("]");

    } 
    catch (FileNotFoundException e) {
      System.err.println("Error: File " + args[0] + " not found");
      e.printStackTrace();
    } 
    catch (IOException e) {
      System.err.println("Error: I/O exception");
      e.printStackTrace();
    }
  }

}
