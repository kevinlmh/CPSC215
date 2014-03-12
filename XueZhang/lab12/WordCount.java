/**
 * File: WordCount.java
 * 
 * This Java application counts the occurrence of each word in a given 
 * text file (specified as a command-line argument).
 *
 * @author Takunari Miyazaki
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
        new StringTokenizer(inString, "`~?!*:;,.()- '\"\n");

      // Complete this blank.
    	TreeMap<String,Integer> M= new TreeMap<String,Integer>();
			while(st.hasMoreTokens()){
				String word=st.nextToken().toLowerCase();
     		int count;
    		if (M.get(word)==null)
					M.put(word,1);
				else{
					count=M.get(word)+1;
					M.put(word,count);
				}
			}
			
			ArrayList<Map.Entry<String,Integer>> L=new ArrayList<Map.Entry<String,Integer>>(M.entrySet());
			//L is the list of words in the text
    	Iterator<Map.Entry<String,Integer>> i = L.iterator();
			System.out.println("Before Sorting: ");    	
			System.out.print("[");
			
			while (i.hasNext())
      	System.out.print(i.next().toString() + ", ");
			System.out.print("]");
    	System.out.println();
			System.out.println();
			System.out.println();
			
			MapEntryComparator<Map.Entry<String,Integer>> c=new MapEntryComparator<Map.Entry<String,Integer>>();
			Collections.sort(L,c);
			i = L.iterator();
			System.out.println("After Sorting: ");
    	System.out.print("[");
			while (i.hasNext())
      	System.out.print(i.next().toString() + ", ");
			System.out.print("]");
    	System.out.println();
			System.out.println();
			
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
