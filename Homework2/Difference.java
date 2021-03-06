/**
 * Difference Progression
 *
 * @author: Kevin Liu
 * @see Progression
 * @see java.lang.Math
 */

import java.lang.Math;
class Difference extends Progression {

  /** Previous value. */
  long prev;

  // Inherits variables first and cur.

  /** Default constructor setting 1 and 100 as the first two values. */
  Difference() {
    this(1, 100);
  }

  /** Parametric constructor providing the first and second values.
   *
   * @param value1 first value.
   * @param value2 second value.
   */
  Difference(long value1, long value2) {
    first = value1;
	prev = value2 + value1; // fictitious value preceding the first
  }

  /** Next value equals the absolute value of the difference of previous two values
   *
   * @return next value of the progression
   */
  protected long nextValue() {
    long temp = prev;
    prev = cur;
    cur = Math.abs(temp-prev);
    return cur;
  }
  
  // Inherits methods firstValue() and printProgression(int).
}
