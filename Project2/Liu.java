/**
 * File: Liu.java
 *
 * Implementation of a campus phone book with 
 * BinarySearchTreeMap as underlying construct
 *
 * @author Kevin Liu
 * @version 1.0 04/23/2014
 * @see BinarySearchTreeMap
 * @see Scanner
 * @see InputMismatchException
 */

import java.util.Scanner;
import java.util.InputMismatchException;
public class Liu {


	/** Display Header message */
	public static void displayHeader() {
		System.out.println("\n=== Trinity Telephone Directory ===");
		System.out.println(" Author: Kevin Liu   Version: 1.0");
	}
	
	/** Display Menu */
	public static void displayMenu() {
		System.out.println("Main Menu:");
		System.out.println("1. Search");
		System.out.println("2. Add");
		System.out.println("3. Remove");
		System.out.println("4. List all names and numbers");
		System.out.println("5. List all names");
		System.out.println("6. List all numbers");
		System.out.println("7. Quit");
	}

	public static void main(String args[]) {
		BinarySearchTreeMap<String,Integer> phonebook =
			new BinarySearchTreeMap<String,Integer>();
		int choice = 0;
		displayHeader();
		Scanner scanner;
		while (true) {
			displayMenu();
			try {
				scanner = new Scanner(System.in).useDelimiter("\n");
				System.out.print(">");
				choice = scanner.nextInt();
				switch (choice) {
					case 1: System.out.print("Please enter name (Last First): ");
									String searchname = scanner.next();
									while (!searchname.matches("[A-Z]([a-z]*) [A-Z]([a-z]*)")) {
										System.out.print("Please enter name in \'Last First\' format: ");
										searchname = scanner.next();
									}
									Integer searchresult = phonebook.get(searchname);
									if (searchresult != null)
										System.out.println("Campusphone number: " + searchresult);
									else
										System.out.println("Name not found.");
									break;	
					case 2: System.out.print("Please enter name (Last First): ");
									String addname = scanner.next();
									while (!addname.matches("[A-Z]([a-z]*) [A-Z]([a-z]*)")) {
										System.out.print("Please enter name in \'Last First\' format: ");
										addname = scanner.next();
									}
									System.out.print("Please enter campus phone number: ");
									int addnumber = scanner.nextInt();
									while (String.valueOf(addnumber).length() != 5) {
										System.out.print("Please enter a 5-digit campus phone number: ");
										addnumber = scanner.nextInt();
									}
									phonebook.put(addname, addnumber);
									break;
					case 3: System.out.print("Please enter name to be removed (Last First): ");
									String removename = scanner.next();	
									while (!removename.matches("[A-Z]([a-z]*) [A-Z]([a-z]*)")) {
										System.out.print("Please enter name in \'Last First\' format: ");
										removename = scanner.next();
									}
									phonebook.remove(removename);
									System.out.println(removename+" has been removed.");
									break;
					case 4:	Iterator<Entry<String,Integer>> it = phonebook.entrySet().iterator();
									while (it.hasNext()) {
										Entry<String,Integer> current = it.next();
										System.out.println("\t"+current.getKey()+" - "+current.getValue());
									}
									break;
					case 5: Iterator<String> kit = phonebook.keySet().iterator();
									while (kit.hasNext()) {
										String current = kit.next();
										System.out.println("\t"+current);
									}
									break;
					case 6: Iterator<Integer> vit = phonebook.values().iterator();
									while (vit.hasNext()) {
										int currentnum = vit.next();
										System.out.println("\t"+currentnum);
									}
									break;
					case 7: scanner.close();
									System.exit(0);
									break;
					default: System.out.println("Please enter a number between 1 and 7.");
									break;
				}
			} catch (InputMismatchException e) {
				System.err.println("Invalid Input! Please enter an integer.");	
			}

		}


	}

}
