/**
 * File: CreditCard.java
 *
 * Class implementing very simple credit cards.
 * 
 * @author Roberto Tamassia
 * @author Michael Goodrich
 * @author Kevin Liu
 * @see String
 */

public class CreditCard {

  // Instance variables:
  private String number;
  private String name;
  private String bank;
  private double balance;
  private int limit;

  /**
   * Constructor
   * @param no Credit card number
   * @param nm Name of card holder
   * @param bk Name of bank
   * @param bal Balance on card
   * @param lim Limit of card
   */
  CreditCard(String no, String nm, String bk, double bal, int lim) {
    number = no;
    name = nm;
    bank = bk;
    balance = bal;
    limit = lim;
  }

  // Accessor methods:
  /** 
   * Get card number
   * @return Card number
   */
  public String getNumber() { return number; }
  /**
   * Get name of card holder
   * @return Name of card holer
   */
  public String getName() { return name; }
  /**
   * Get name of bank
   * @return Name of bank
   */
  public String getBank() { return bank; }
  /**
   * Get current balance on card
   * @return Balance on card
   */
  public double getBalance() { return balance; }
  /**
   * Get limit of card
   * @return Limit of card
   */
  public int getLimit() { return limit; }

  // Add modifier methods here.
  /**
   * Set the name of card holder
   * @param name Name of card holer
   */
  public void setName(String name) {
	  this.name = name;
  }
  
  /**
   * Set the limit of card
   * @param limit Limit of card
   */
  public void setLimit(int limit) {
	  this.limit = limit;
  }

  // Action methods:
  /**
   * Charge the card an amount of money
   * @param price The amount to be charged
   * @return Whether the charge was successful
   */
  public boolean chargeIt(double price) { // Make a charge 
    if (price + balance > (double) limit) 
      return false; // There is not enough money left to charge it
    balance = balance + price;
    return true; // The charge goes through in this case
  }

  // Add applyInterest() here.
  /**
   * Apply an interest rate to the balance on card
   * @param i Interest rate in decimal
   */
  public void applyInterest(double i) {
	  balance = balance * (1 + i);
  }
  
  /**
   * Make a payment to the card
   * @param payment The amount of money to be payed
   */
  public void makePayment(double payment) { // Make a payment
    balance = balance - payment; 
	if (balance > 0) {
		applyInterest(0.1);
	}
  }
  
  /**
   * Print information of a card
   * @param c The card whose information is to be printed
   */
  public static void printCard(CreditCard c) { // Print a card's information 
    System.out.println();
    System.out.println("Number = " + c.getNumber());
    System.out.println("Name = " + c.getName());
    System.out.println("Bank = " + c.getBank());
    System.out.println("Balance = " + c.getBalance()); // Implicit cast
    System.out.println("Limit = " + c.getLimit()); // Implicit cast
    System.out.println();
  }

}
