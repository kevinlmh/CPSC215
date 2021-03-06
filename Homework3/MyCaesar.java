/** 
 * Class for doing encryption and decryption using the Caesar Cipher.
 *
 * @author: Kevin Liu
 * @version 1.0 Feb 9 2014
 */
public class MyCaesar {
	public static final int ALPHASIZE = 26; // English alphabet (uppercase only)
	public static final char[] alpha = {'A','B','C','D','E','F','G','H', 'I',
    'J','K','L','M', 'N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	protected char[] encrypt = new char[ALPHASIZE];  // Encryption array
	protected char[] decrypt = new char[ALPHASIZE];  // Decryption array

	/** Constructor that initializes the encryption and decryption arrays */
	public MyCaesar() {
		this("", 24);		// rotate alphabet by 24 places
	}
	
	/** 
	 * Constructor that initializes the encryption and decryption arrays
	 *
	 * @param s The keyword
	 * @param n The rotate amount
	 */
	public MyCaesar(String s, int n) throws KeywordException {
		// check if rotate amount n is valid
		if (n < 1 || n > ALPHASIZE)
			throw new IntegerKeyException("Invalid rotate amount "+ n);
			
		// convert String s to char array
		char[] keyword = s.toCharArray(); 			// the message array
		
		// check if keyword length is valid
		if (keyword.length < 1 || keyword.length > 26)
			throw new KeywordException("Invalid keyword length " + keyword.length);

		// an integer array to store letter occurance number
		int[] occurance = new int[ALPHASIZE];
		for (int h = 0; h < ALPHASIZE; h++)
			occurance[h] = 0;
			
		// check if keyword is all in uppercase alphabetic letters
		for (char c : keyword) {
			if (Character.isLowerCase(c))
				throw new KeywordException("Keyword must be in uppercase");
			if ( c < 'A' || c > 'Z')
				throw new KeywordException("Keyword must be in english letters");
			occurance[c-'A']++;
		}
		
		// check if letters in keyword are distinct
		for (int k = 0; k < ALPHASIZE; k++) {
			if (occurance[k] > 1)
				throw new KeywordException("Keyword has duplicate letter: " + (char)(k+'A'));
		}
		
		int i, j;		// indices
		for (i=(n-1); i<s.length()+(n-1); i++)
    		encrypt[i%ALPHASIZE] = keyword[i-(n-1)]; 	// insert the keyword
    		
    	// fill in the rest of the encrypt array
		for (j=0; j<ALPHASIZE; j++) {
			// if a letter is in keyword, skip it
			if (contains(keyword,alpha[j])) {
				continue;
			}else {
				encrypt[i%ALPHASIZE] = alpha[j];
				i++;
			}	
		}
		
		// fill in the decrypt array
    	for (int k=0; k<ALPHASIZE; k++) 
			decrypt[encrypt[k] - 'A'] = Character.toLowerCase(alpha[k]); // decrypt is reverse of encrypt
	}
	
	/**
	 * Check if a letter is in the keyword 
	 * 
	 * @param keyword The keyword
	 * @param letter The letter you want to check
	 * @return True if letter is in keyword, false other wise
	 */
	private Boolean contains(char[] keyword,char letter) {
		for (char c : keyword) {
		    if (c == letter) {
		        return true;
		    }
		}
		return false;
	}

	/** 
	 * Encryption method 
	 *
	 * @param plaintext The text you want to encrypt
	 * @return The encrypted cipher
	 */
	public String encrypt(String plaintext) {
    char[] mess = plaintext.toCharArray();  // the message array
    for (int i=0; i<mess.length; i++)       // encryption loop
    	if (Character.isLowerCase(mess[i]))   // we have a letter to change
        	mess[i] = encrypt[mess[i] - 'a'];   // use letter as an index
    	return new String(mess);
	}

	/** 
	 * Decryption method 
	 *
	 * @param ciphertext The cipher you want to decrypt
	 * @return The decrypted plaintext
	 */
	public String decrypt(String ciphertext) {
		char[] mess = ciphertext.toCharArray(); // the message array
		for (int i=0; i<mess.length; i++)       // decryption loop
			if (Character.isUpperCase(mess[i]))   // we have a letter to change
		    	mess[i] = decrypt[mess[i] - 'A'];   // use letter as an index
		return new String(mess);
	}

	/** Simple main method for testing the Caesar cipher */
	public static void main(String[] args) {
		MyCaesar cipher = new MyCaesar("BLUE",5);           // Create a Caesar cipher object
		System.out.println("Encryption order = " + new String(cipher.encrypt));
		System.out.println("Decryption order = " + new String(cipher.decrypt));
		String message = "the eagle is in play; meet at joe's.";
		message = cipher.encrypt(message);
		System.out.println(message);             // the ciphertext
		message = cipher.decrypt(message);
		System.out.println(message);             // should be plaintext again
	}

}
