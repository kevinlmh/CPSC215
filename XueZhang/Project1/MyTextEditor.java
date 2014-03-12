/**
 * File: MyTextEditor.java
 *
 * This is a simple text editor interface, which assumes a text editor 
 * is built for lines of text.  Each line of text is to be viewed as a 
 * separate string.  In addition, this editor has a cursor associated 
 * with some line in the text.  Initially, the cursor is set to the the 
 * line -1 just before the first line in the text.  The methods of the 
 * text editor are designed to update and print the text file using the 
 * cursor.
 *
 * @author Yisheng Cai
 * @version 1.0.0, 03/24/2013
 * @see BoundaryViolationException
 * @see String
 */

public class MyTextEditor implements SimpleTextEditor {
	protected Sequence<String> D;
	protected int cursor=-1;
	protected int size;

	//Constructor 
	//creating a new arraysequence, casting type string to type E
	public MyTextEditor(){
		D = new ArraySequence<String>();
	}

  /** 
   * Returns true if the text is completely empty (and cursor is at line -1).
	 * @return true if the text is completely empty.
   */
  public boolean isEmpty() {
		return ((size() == 0) && (cursor == -1));
	}

  /** 
   * Returns the current number of lines of text. 
	 * @return integer that is the current number of lines of text. 
   */
  public int size() {
		return D.size();
	}

  /** 
   * Returns true if the cursor is at the last line in the text or the text 
   * @return true if the cursor is at the last line in the text or the text 
   * is empty.
   */
  public boolean isCursorAtLastLine() {
		return (cursor == D.size());
	}
		

  /** 
   * Sets the cursor to be the text line after its current position.
   * @exception BoundaryViolationException when cursor reaches boundary
   */
  public void cursorDown() throws BoundaryViolationException {
		if (isCursorAtLastLine())
			throw new BoundaryViolationException("Cursor position invalid.");
		cursor++;
	}

  /** 
   * Sets the cursor to be the text line before its current position.
	 * @exception BoundaryViolationException when cursor reaches boundary
   */
  public void cursorUp() throws BoundaryViolationException {
		if (cursor == 0)
			throw new BoundaryViolationException("Cursor position invalid.");
		cursor--;
	}

  /** 
   * Sets the cursor to be the line ranked i (the first line is line 0).
	 * @return integer i which is the index of the line desired to move the cursor to
   */
  public void moveCursorToLine(int i) 
		throws BoundaryViolationException {
		if ((i<0) || (i>D.size()))
			throw new BoundaryViolationException("Line does not exist. ");
		cursor = i;
	}

  /**
   * Returns the line number (rank) of the current cursor line.
	 * @return integer which is the current line number of the cursor 
   */
  public int cursorLineNum() {
		return cursor;
	}

  /**
   * Inserts a string s in the line after the current cursor, moving the
	 * @param string s that is inserted after the cursor
   * cursor to the line inserted.
   */
  public void insertAfterCursor(String s) {
		D.add(cursor+1, s);
		cursor++;
		size++;
	}
		

  /**
   * Inserts a string s in the line before the current cursor, moving the
   * @param string s that is inserted before the cursor
   * cursor to the line inserted.
	 * @exception BoundaryViolationException when cursor reaches boundary
   */
  public void insertBeforeCursor(String s) throws BoundaryViolationException {
		if (cursor == -1)
			throw new BoundaryViolationException("Cursor is before first line. ");
		D.add(cursor-1, s);
		
		size++;
	}
		
			

  /**
   * Replaces the string at the current cursor with the String s, keeping
	 * @param string s that is replacing the current string at the cursor
   * the cursor at this line.
   * @exception BoundaryViolationException when cursor reaches boundary
   */
  public void replaceAtCursor(String s) throws BoundaryViolationException {
		if ((cursor<0) || (cursor>=D.size()))
			throw new BoundaryViolationException("The cursor is out of boundary.");
		D.set(cursor, s);
	}

  /**
   * Removes the entire line at the current cursor, setting the cursor to now
   * be the position of the next line, unless the cursor was the last line, 
   * in which case the cursor should move to the new last line.
   * @exception BoundaryViolationException when cursor reaches boundary
   */
  public void removeAtCursor() throws BoundaryViolationException {
		if ((cursor<0) || (cursor>=D.size()))
			throw new BoundaryViolationException("The cursor is out of boundary.");
		D.remove(cursor);
		if (isCursorAtLastLine())
			cursor--;
		size--;
	}


  /**
   * Prints the entire text to the console.
   */
  public void print() {
		for (int i=0; i<size(); i++){
			System.out.println(D.atIndex(i).element());
		}
	}

}
