/** This is a class that tests MyTextEditor
 * @author Kevin Liu
 */

public class Liu {
	
	public static void main(String args[]) {
		MyTextEditor editor = new MyTextEditor();
		// initialize text
		editor.insertAfterCursor("Narnia...where the woods are thick and cool, where Talking Beasts are called to");
		editor.insertAfterCursor("life, the land beyond the wardrobe, the secret country known only to Peter,");	
		editor.insertAfterCursor("Susan, Edmund, and Lucy. Narnia...where horses talk and hermits like company,");
		editor.insertAfterCursor("where evil men turn into donkeys, where boys go into battle.");
		editor.insertAfterCursor("Narnia...the land between the lamp-post and the castle of Cair Paravel,");
		editor.insertAfterCursor("where animals talk, where magical things happen,the world of wicked dragons");
		editor.insertAfterCursor("and magic spells, where the very best is brought out of even the worst people,");
		editor.insertAfterCursor("where anything can happen(and most oftan does).");
		editor.insertAfterCursor("Narnia...where owls are wise, where some of the giants like to");
		editor.insertAfterCursor("snack on humans (and, if carefully cooked, on Marsh-wiggles, too),");
		editor.insertAfterCursor("where a prince is put under an evil spell.");
		editor.insertAfterCursor("Narnia...where dwarfs are loyal and tough and strong-or are they?");
		// print text
		System.out.println("Initial:");
		editor.printText();	

		// modify text to match with middle.txt
		editor.moveCursorToLine(1);
		editor.cursorUp();
		editor.replaceAtCursor("Narnia... where the woods are thick and cool, where Talking Beasts are called to");
		editor.moveCursorToLine(3);
		editor.replaceAtCursor("where evil men turn into donkeys, where boys and girls go into battle.");
		editor.insertAfterCursor("");
		editor.cursorDown();
		editor.replaceAtCursor("Narnia... the land between the lamp-post and the castle of Cair Paravel,");
		editor.cursorDown();
		editor.replaceAtCursor("where animals talk, where magical things happen, the world of wicked deans");
		editor.moveCursorToLine(9);
		editor.insertBeforeCursor("");
		editor.cursorDown();
		editor.replaceAtCursor("Narnia... where professors are wise, where some of the giants like to");
		editor.cursorDown();
		editor.replaceAtCursor("snack on students (and, if carefully cooked, on Marsh-wiggles, too),");
		editor.moveCursorToLine(13);
		editor.removeAtCursor();
		editor.insertAfterCursor("Narnia... where dwarfs are loyal and tough and strong-or are they?");
		editor.cursorUp();
		editor.insertAfterCursor("");
		// print text
		System.out.println("\nMiddle:");
		editor.printText();
	}


}
