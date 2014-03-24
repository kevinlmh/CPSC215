/**
 * File: MyTextEditor.java
 *
 * This is a simple text editor built for lines of text.  
 * Each line of text is to be viewed as a separate string.  
 * In addition, this editor has a cursor associated 
 * with some line in the text.  Initially, the cursor is set to the the
 * line -1 just before the first line in the text.  The methods of the 
 * text editor are designed to update and print the text file using the
 * cursor.
 *
 * @author Kevin Liu 
 * @version 1.0, 03/12/2014
 * @see BoundaryViolationException
 * @see String
 * @see ArraySequence
 */

public class MyTextEditor implements SimpleTextEditor {
	
	private ArraySequence<String> text = new ArraySequence<String>();
	private int cursor;

	public MyTextEditor() {
		this.text = text;
		cursor = -1;	
	}
	
  /** 
   * Returns true if the text is completely empty (and cursor is at line -1).
	 * @return ture if the text is empty and cursor = -1, false other wise
   */
  public boolean isEmpty() {
		return text.isEmpty() && (cursor == -1);
	}

  /** 
   * Returns the current number of lines of text. 
   * @return the size of the text
	 */
  public int size() {
		return text.size();
	}

  /** 
   * Returns true if the cursor is at the last line in the text or the text 
   * is empty.
	 * @return true if the cursor is at the last line or the text is empty, false otherwise
   */
  public boolean isCursorAtLastLine() {
		return cursor == text.indexOf(text.last()) || isEmpty();
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
   * @param i the line number to move the cursor to
	 */
  public void moveCursorToLine(int i) throws BoundaryViolationException {
		text.checkBoundary(i, size());
		cursor = i;
	}

  /**
   * Returns the line number (rank) of the current cursor line.
	 * @return the rank of the current cursor line
   */
  public int cursorLineNum() {
		return cursor;
	}

	/**
	 * Inserts a new line after current line.
	 * @param s the string to be inserted 
	 */
	public void insertAfterCursor(String s) throws BoundaryViolationException {
		if (cursor < -1 || cursor >= size())
			throw new BoundaryViolationException("Boundary Violation!");
		text.add(cursor+1, s);
		cursor++;
	}

	/**
	 * Inserts a new line before current line.
	 * @param s the string to be inserted
	 */
	public void insertBeforeCursor(String s) throws BoundaryViolationException {
		if (cursor < 0 || cursor >= size())
			throw new BoundaryViolationException("Boundary Violation!");	
		text.add(cursor, s);
	}
	
	/**
   * Replaces the string at the current cursor with the String s, keeping
   * the cursor at this line.
	 * @param s the new string
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

	/** Prints the text */
	public void print() {
		cursor = -1;
		for (int i=0; i<size(); i++) {
			cursorDown();
			System.out.println(text.get(cursor));
		}
		System.out.print("--- Is text empty: " + isEmpty());
		System.out.print(" --- Text size: " + size());
		System.out.print(" --- Cursor position: " + cursorLineNum());
		System.out.println(" ---");
	}
}
