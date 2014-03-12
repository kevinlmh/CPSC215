/**
 * File: Cai.java
 * main program of phonebook directory using Binary Search Tree Map
 * @author Yisheng Cai
 * @version 1.0.0 4/28/2013
 * @see BinarySearchTreeMap
 * @see java.io
 * @see java util scanner
 */

import java.io.*; //I/O classes
import java.util.Scanner; // Scanner class

public class Cai{
 public static boolean isNumeric(String input) {
  try {
    Integer.parseInt(input);
    return true;
  }
  catch (NumberFormatException e) {
    return false;
  }
 }
  
 public static void printEntry(BinarySearchTreeMap<String, Integer> L){
  System.out.println("\n======phonebook directory=======\n");

  Iterator<Entry<String, Integer>> i = L.entrySet().iterator();
   Entry<String, Integer> temp;
   while (i.hasNext()) {
    temp = i.next();
    if ((temp.getKey() != null) && (temp.getValue() != null))
    System.out.println("["+temp.getKey()+"\t\t-\t"+ temp.getValue()+"]");
   }
  System.out.println("\n");

 }


 public static void printKey(BinarySearchTreeMap<String, Integer> L){
 
 System.out.println("\n======phonebook directory=======\n");
 
 Iterator<String> i = L.keySet().iterator();
  String key;
  while (i.hasNext()) {
   key = i.next();
   if (key != null)
    System.out.println(key);
  }
  System.out.println("\n");

}


 public static void printValue(BinarySearchTreeMap<String, Integer> L){
 
 System.out.println("\n======phonebook directory=======\n");

 Iterator<Integer> v = L.values().iterator();
  Integer value;
  while (v.hasNext()) {
   value = v.next();
   if (value != null)
    System.out.println(value);
  }

  System.out.println("\n");

 }



 public static void main(String argv[]) throws IOException {
  BinarySearchTreeMap<String, Integer> directory 
      = new BinarySearchTreeMap<String, Integer>();
  Scanner s = new Scanner(System.in);
  String input = "1";
 

 
  while (!(input.equals("7"))){
   System.out.println("");
   System.out.println("=============Choice for directory operations===========\n");
   
   System.out.println("(1)\tSearch for a name =>");
   System.out.println("(2)\tAdd a new entry =>");
   System.out.println("(3)\tRemove an exsiting entry =>");
   System.out.println("(4)\tList all entries in directory =>(alphabetical by lastname)");
   System.out.println("(5)\tList names in directory =>");
   System.out.println("(6)\tList all phone numbers in directory =>");
   System.out.println("(7)\tTerminate =>");
     
   System.out.print("\nPlease enter a number between 1-7 for options: ");   
   input = s.nextLine();

   //Option 1: Search an entry in the directory; given a name as input from the user and output the name and a number if the entry exists.
   if (input.equals("1")){
    
    System.out.print("\n\tPlease enter the name (Last name followed by first name) in lower case: ");
    Scanner search = new Scanner(System.in);
    String name = search.nextLine().toLowerCase();
    while ((directory.get(name) == null) && !(name.equals("0"))){
     System.out.print("\tError: name does not exist. Please enter a valid name:  ");
     name = search.nextLine().toLowerCase();
    }
    System.out.println("");
    if (!(name.equals("0")))
     System.out.println("\t"+name+" ---extension: "+directory.get(name)+"\n\tEnter 0 to return to menu: ") ;
    
   }

   //Option 2: Add a new entry for a given name and telephone number to the directory
 
   else if (input.equals("2")){
    System.out.print("\tPlease enter a name to be added (last name followed by first name) in lowercase: ");
    Scanner str = new Scanner(System.in);
    String name = str.nextLine().toLowerCase();
    System.out.print("\tPlease enter the 5-digit extension: ");
    Scanner n = new Scanner(System.in);
    String number = n.nextLine();
    while ((!(isNumeric(number)) || (number.length() != 5)) && !(number.equals("0"))){
     System.out.print("\tError: Please enter a valid 5-digit number or 0 to exit:  ");
     number = n.nextLine().toLowerCase();
    }
    if (!(number.equals("0"))){
     int number2 = Integer.parseInt(number);
     directory.put(name, number2);   
     System.out.println("Entry added. Return to menu =>");
    }
   }


   //Option 3: Remove an entry from the direcctory
   else if (input.equals("3")){
    System.out.print("\tPlease enter the name at the entry wanted to be removed (first name followed by last name) in lower case: ");
    Scanner remove = new Scanner(System.in);
    String name = remove.nextLine();
    name = name.toLowerCase();
    while ((directory.get(name) == null) && !(name.equals("0"))){
     System.out.print("\tError: Entry does not exist. Please enter valid name or enter 0 to quit: ");
     name = remove.nextLine().toUpperCase();
    }
    if (!(name.equals("0"))){
     directory.remove(name);
     System.out.println("");
     System.out.println("\t Entry removed. Enter 0 to return to menu.");
    }

   }

   //Option 4: List all entries from the directory in the alphabetical order by las names
   else if (input.equals("4")){
    System.out.println("Entry List");
    System.out.print("\t");
    if (!(directory.isEmpty()))
     printEntry(directory);
    else
     System.out.println("directory is empty. Enter 0 to return to menu.");
   }

   //Option 5: List all names from the directory
   else if (input.equals("5")){
    System.out.println("Name List");
    System.out.print("\t");
    if (!(directory.isEmpty())){
      printKey(directory);
     System.out.println("Enter 0 to return to menu.");
    }
    else
     System.out.println("directory is empty. Enter 0 to return to menu.");
   }

   //Option 6:  List all the numbers from the directory
   else if (input.equals("6")){
    System.out.println("Number List");
    System.out.print("\t");
    if (!(directory.isEmpty())){
      printValue(directory);
      System.out.println("Enter 0 to return to menu.");
    }
    
    else
     System.out.println("directory is empty. Enter 0 to return to menu.");
   }

   //Option 7: Terminate the session
   else if (input.equals("7")){ 
     System.out.println("7.\tThank you for using this phonebook directory!");
     break;  
    }

   //Invalid Input
   else{
   
   System.out.println("\n\tInvalid Option Input: Please enter again.");
   }

  }
 }
}

