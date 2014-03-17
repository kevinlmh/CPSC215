/**
 * File: MyTextEditor.java
 *
 * This is a simple text editor built for lines of text.  
 * Each line of text is to be viewed as a 
 * separate string.  In addition, this editor has a cursor associated 
 * with some line in the text.  Initially, the cursor is set to the the
 * line -1 just before the first line in the text.  The methods of the 
 * text editor are designed to update and print the text file using the
 * cursor.
 *
 * @author Kevin Liu 
 * @version 1.0, 03/12/2014
 * @see BoundaryViolationException
 * @see String
 */

public class MyTextEditor {
	
	private ArraySequence<String> text = new ArraySequence<String>();
	private int cursor;

	public MyTextEditor() {
		this.text = text;
		cursor = -1;	
	}
	
  /** 
   * Returns true if the text is completely empty (and cursor is at line -1).
   */
  public boolean isEmpty() {
		return text.isEmpty();
	}

  /** 
   * Returns the current number of lines of text. 
   */
  public int size() {
		return text.size();
	}

  /** 
   * Returns true if the cursor is at the last line in the text or the text 
   * is empty.
   */
  public boolean isCursorAtLastLine() {
		return cursor == text.indexOf(text.last()) || isEmpty();
	}

	// mine 
	/**
	 * Returns true if the cursor is at the first line in the text or the text 
	 * is empty
	 */
	public boolean isCursorAtFirstLine() {
		return cursor == text.indexOf(text.first()) || isEmpty();
	}

  /** 
   * Sets the cursor to be the text line after its current position.
   */
  public void cursorDown() throws BoundaryViolationException {
		text.checkBoundary(cursor + 1, size());
		cursor++;
	}

  /** 
   * Sets the cursor to be the text line before its current position.
   */
  public void cursorUp() throws BoundaryViolationException {
		text.checkBoundary(cursor - 1, size());
		cursor--;
	}

  /** 
   * Sets the cursor to be the line ranked i (the first line is line 0).
   */
  public void moveCursorToLine(int i) throws BoundaryViolationException {
		text.checkBoundary(i, size());
		cursor = i;
	}

	/**
	 * Inserts a new line after current line.
	 */
	public void insertAfterCursor(String s) throws BoundaryViolationException {
		if (cursor < -1 || cursor >= size())
			throw new BoundaryViolationException("Boundary Violation!");
		text.add(cursor+1, s);
		cursor++;
	}

	/**
	 * Inserts a new line before current line.
	 */
	public void insertBeforeCursor(String s) throws BoundaryViolationException {
		if (cursor < 0 || cursor >= size())
			throw new BoundaryViolationException("Boundary Violation!");	
		text.add(cursor, s);
	}
	
	/**
   * Replaces the string at the current cursor with the String s, keeping
   * the cursor at this line.
   */
  public void replaceAtCursor(String s) throws BoundaryViolationException {
		text.checkBoundary(cursor, size());
		text.set(cursor, s);
	}

  /**
   * Removes the entire line at the current cursor, setting the cursor to now
   * be the position of the next line, unless the cursor was the last line, 
   * in which case the cursor should move to the new last line.
   */
  public void removeAtCursor() throws BoundaryViolationException {
		text.checkBoundary(cursor, size());
		text.remove(cursor);
		cursor--;
	}

	/** Prints current line */	
	public void printCurrentLine() throws BoundaryViolationException {
		text.checkBoundary(cursor, text.size());
		System.out.println(text.get(cursor));
	}

	/** Prints the text */
	public void printText() {
		cursor = -1;
		for (int i=0; i<size(); i++) {
			cursorDown();
			printCurrentLine();
		}
	}
}
