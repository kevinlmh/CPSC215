/** This is a class that tests MyTextEditor
 * @author Kevin Liu
 */

public class Liu {
	
	public static void main(String args[]) {
		ArraySequence<String> text = new ArraySequence<String>();
		for (int i=0; i<10; i++) {
			text.addFirst("A line");				
		}
		MyTextEditor editor = new MyTextEditor(text);
		editor.printText();	
	}


}
