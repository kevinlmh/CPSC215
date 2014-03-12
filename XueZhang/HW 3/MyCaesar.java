/** 
 * Caesar Cipher
 * This is a class encrypts and decrypts a string by using generalized Caesar Cipher.
 * 
 * @author Yisheng Cai
 * @version 1.0.0 2/11/2013
 * @See String, Character
 * Class for doing encryption and decryption using the Caesar Cipher.
 */
public class MyCaesar {

  public static final int ALPHASIZE = 26; // English alphabet (uppercase only)
  public static final char[] alpha = {'A','B','C','D','E','F','G','H', 'I',
    'J','K','L','M', 'N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
  public static char [] myalpha = {'A','B','C','D','E','F','G','H', 'I',           //dumy array created for identifying the characters exist in the keyword
    'J','K','L','M', 'N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
  protected char[] encrypt = new char[ALPHASIZE];  // Encryption array
  protected char[] decrypt = new char[ALPHASIZE];  // Decryption array

  /** 
   * Constructor that initializes the encryption and decryption arrays
   * 
   */
  public MyCaesar() {
    this("",24);
  }
  
  
  /**
   * Constructor that initializes the encryption and decryption arrays, along with all the exceptions 
   * @param A string s and a integer n, indicating the keyword and the starting position of the keyword.
   * 
   * 
   */
  public MyCaesar(String s, int n){
    System.out.println("Key: "+s+", "+n);
    if (s.length()>26){
      throw new KeywordException("The string entered is too long. Encryption failed.");
    }
    if (n<1 || n>26){
      throw new IntegerKeyException("Integer is greater or less than range of alphabet size. Encryption failed.");
    }
    for (int i=0; i<s.length(); i++){
      if (Character.isLowerCase(s.charAt(i))){
        throw new KeywordException("The string entered contains lowercase character.");
      }
    }
    for (int i=0; i<s.length(); i++){
      for (int j=i+1; j<s.length(); j++){
        if (s.charAt(i)==s.charAt(j)){
          throw new KeywordException("The characters in the string are not distinct.");
        }
      }
    }
          
    int place=0;
    char[]mess = s.toCharArray();
    for (int i=n-1; i<mess.length+n-1; i++){
      encrypt [i%ALPHASIZE] = mess[i-n+1];
    }
    
    place=((n-1)+s.length())%ALPHASIZE;
    for (int i=0; i<s.length(); i++){
      myalpha[Character. toUpperCase(s.charAt(i))-'A']=' ';
    }
      

    for (int i=0; i<ALPHASIZE; i++){
      if (myalpha[i]!=' '){
        encrypt[place]=myalpha[i];
        place=(place+1)%ALPHASIZE;
      }
    }
    
    for (int i=0; i<ALPHASIZE; i++)
      encrypt[i] = encrypt [(i)%ALPHASIZE];
    
    for (int i=0; i<ALPHASIZE; i++)
      decrypt[encrypt[i]-'A'] = Character.toLowerCase(alpha[i]);
    
  }
    


  /** Encryption method
    * @param passed string plaintext which creates base text array for encryption.
    * @return returns a string mess, which is a initialized instance of the string. 
    */
  public String encrypt(String plaintext) {
    char[] mess = plaintext.toCharArray();  // the message array
    for (int i=0; i<mess.length; i++)       // encryption loop
      if (Character.isLowerCase(mess[i]))   // we have a letter to change
        mess[i] = encrypt[mess[i] - 'a'];   // use letter as an index
    return new String(mess);
  }

  /** Decryption method
    * @param passed string ciphertext, which is the encrypted text of the plaintext.
    * @return returns an initialized array.
    */
  public String decrypt(String ciphertext) {
    char[] mess = ciphertext.toCharArray(); // the message array
    for (int i=0; i<mess.length; i++)       // decryption loop
      if (Character.isUpperCase(mess[i]))   // we have a letter to change
        mess[i] = Character.toLowerCase(decrypt[mess[i] - 'A']);   // use letter as an index
    
    return new String(mess);
  }

  /** Simple main method for testing the Caesar cipher */
  public static void main(String[] args) {
    MyCaesar cipher = new MyCaesar("HOUSE", 27);           // Create a Caesar cipher object
    System.out.println("Encryption order = " + new String(cipher.encrypt));
    System.out.println("Decryption order = " + new String(cipher.decrypt));
    String message = "the eagle is in play; meet at joe's.";
    message = cipher.encrypt(message);
    System.out.println(message);             // the ciphertext
    message = cipher.decrypt(message);
    System.out.println(message);             // should be plaintext again
  }

}
