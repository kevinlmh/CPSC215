/**
 * My progression.
 *
 * @author: Kevin Liu
 * @see Progression
 */

class MyProgression extends Progression {

  /** Previous value. */
  long prev;

  // Inherits variables first and cur.

  /** Default constructor setting 3 and 2 as the first value. */
  MyProgression() {
    this(2);
  }

  /** Parametric constructor providing the first value.
   *
   * @param value1 first value.
   * 
   */
   MyProgression(long value) {
    first = value;
  }

  /** next value equals previous value mod by two plus one.
   *
   * @return next value of the progression
   */
  protected long nextValue() {
    prev = cur;
    cur = prev%2 + 1;
    return cur;
  }
  
  // Inherits methods firstValue() and printProgression(int).
}
