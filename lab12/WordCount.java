/*
 * File: WordCount.java
 * Description: This class counts the words in a text file.
 *
 * To compile: javac WordCount.java
 * To run: java WordCount filename
 * @author Kevin Liu
 * @version 1.0 04/23/2014
 * @see ListMap
 * @see SCHashTableMap
 * @see StringTokenizer
 */

import java.io.*;
import java.util.*;

public class WordCount {

  // This method prints the content of an iterable collection
  public static <E> void print(Iterable<E> collection) {
    Iterator<E> i = collection.iterator();
    System.out.print("[");
    boolean first = true;
    while (i.hasNext()) {
      if (first) {
	System.out.print(i.next());
        first = false;
      }
      else
        System.out.print(", " + i.next());
    }
    System.out.println("]");
  }

  public static void main(String args[]) {
    String inString = null;
    if (args.length < 1) {
      System.out.println("Usage: java WordCount sourcefile");
      return;
    }

    // Read the file named as the command-line argument
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
      System.out.println("Testing ListMap...");
      // Complete this blank to test ListMap.
			ListMap<String,Integer> listmap = new ListMap<String,Integer>();
			while (st.hasMoreTokens()) {
				String current = st.nextToken();
				if (listmap.get(current) == null)
					listmap.put(current, 1);
				else
					listmap.put(current, listmap.get(current)+1);
			}
			print(listmap.entrySet());
			System.out.println("There are "+((NodePositionList<Entry<String,Integer>>)listmap.entrySet()).size()+" distinct words.");
			System.out.println("The word \"the\" appears "+listmap.get("the")+" times.");
			System.out.println("The word \"of\" appears "+listmap.get("of")+" times.");
			System.out.println("The word \"was\" appears "+listmap.get("was")+" times.\n");


      st = new StringTokenizer(inString, "`~?!*:;,.()- '\"\n");
      System.out.println("Testing SCHashTableMap...");
      // Complete this blank to test SCHashtTableMap.
			SCHashTableMap<String,Integer> hashmap = new SCHashTableMap<String,Integer>();
			while (st.hasMoreTokens()) {
				String current = st.nextToken();
				if (hashmap.get(current) == null)
					hashmap.put(current, 1);
				else
					hashmap.put(current, hashmap.get(current)+1);
			}
			print(hashmap.entrySet());
			System.out.println("There are "+((NodePositionList<Entry<String,Integer>>)hashmap.entrySet()).size()+" distinct words.");
			System.out.println("The word \"the\" appears "+hashmap.get("the")+" times.");
			System.out.println("The word \"of\" appears "+hashmap.get("of")+" times.");
			System.out.println("The word \"was\" appears "+hashmap.get("was")+" times.\n");


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
