public class Tester {
  /** Prints all elements of a given array list. */
	public static void main(String args[]){
		MyTextEditor<String> A = new MyTextEditor<String>();
		A.insertAfterCursor("Narnia...where the woods are thick and cool, where Talking Beasts are called to");
		A.insertAfterCursor("life, the land beyond the wardrobe, the secret country known only to Peter,");
		A.insertAfterCursor("Susan, Edmund, and Lucy. Narnia...where horses talk and hermits like company,");
		A.insertAfterCursor("where evil men turn into donkeys, where boys go into battle. ");
		A.insertAfterCursor("Narnia...the land between the lamp-post and the castle of Cair Paravel,";
		A.insertAfterCursor("where animals talk, where magical things happen,the world of wicked dragons ");
		A.insertAfterCursor("and magic spells, where the very best is brought out of even the worst people,");
		A.insertAfterCursor("where anything can happen(and most oftan does). ");
		A.insertAfterCursor("Narnia...where owls are wise, where some of the giants like to");
		A.insertAfterCursor("snack on humans (and, if carefully cooked, on Marsh-wiggles, too), ");
		A.insertAfterCursor("where a prince is put under an evil spell. ");
		A.insertAfterCursor("Narnia...where dwarfs are loyal and tough and strong-or are they?");
		A.print();
	}
}
