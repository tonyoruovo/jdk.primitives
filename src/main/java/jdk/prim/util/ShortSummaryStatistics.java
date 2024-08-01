package jdk.prim.util;

/**
 * A state object for collecting statistics such as count, min, max, sum, and
 * average.
 *
 * <p>This implementation does not check for overflow of the count or the sum.
 * @see java.util.IntSummaryStatistics
 */
public class ShortSummaryStatistics implements jdk.prim.util.function.PrimitiveConsumer.OfShort {
    private long count;
    private int sum;
    private short min = Short.MAX_VALUE;
    private short max = Short.MIN_VALUE;

    /**
     * Constructs an empty instance with zero count, zero sum,
     * {@code Short.MAX_VALUE} min, {@code Short.MIN_VALUE} max and zero
     * average.
     */
    public ShortSummaryStatistics() { }

    /**
     * Constructs a non-empty instance with the specified {@code count},
     * {@code min}, {@code max}, and {@code sum}.
     *
     * <p>If {@code count} is zero then the remaining arguments are ignored and
     * an empty instance is constructed.
     *
     * <p>If the arguments are inconsistent then an {@code IllegalArgumentException}
     * is thrown.  The necessary consistent argument conditions are:
     * <ul>
     *   <li>{@code count >= 0}</li>
     *   <li>{@code min <= max}</li>
     * </ul>
     * @apiNote
     * The enforcement of argument correctness means that the retrieved set of
     * recorded values obtained from a {@code ShortSummaryStatistics} source
     * instance may not be a legal set of arguments for this constructor due to
     * arithmetic overflow of the source's recorded count of values.
     * The consistent argument conditions are not sufficient to prevent the
     * creation of an internally inconsistent instance.  An example of such a
     * state would be an instance with: {@code count} = 2, {@code min} = 1,
     * {@code max} = 2, and {@code sum} = 0.
     *
     * @param count the count of values
     * @param min the minimum value
     * @param max the maximum value
     * @param sum the sum of all values
     * @throws IllegalArgumentException if the arguments are inconsistent
     */
    public ShortSummaryStatistics(long count, short min, short max, int sum)
            throws IllegalArgumentException {
        if (count < 0L) {
            throw new IllegalArgumentException("Negative count value");
        } else if (count > 0L) {
            if (min > max) throw new IllegalArgumentException("Minimum greater than maximum");

            this.count = count;
            this.sum = sum;
            this.min = min;
            this.max = max;
        }
    }

    /**
     * Records a new value into the summary information
     *
     * @param value the input value
     */
    @Override
    public void acceptShort(short value) {
        ++count;
        sum += value;
        min = (short) Math.min(min, value);
        max = (short) Math.max(max, value);
    }

    /**
     * Combines the state of another {@code ShortSummaryStatistics} into this one.
     *
     * @param other another {@code ShortSummaryStatistics}
     * @throws NullPointerException if {@code other} is null
     */
    public void combine(ShortSummaryStatistics other) {
        count += other.count;
        sum += other.sum;
        min = (short) Math.min(min, other.min);
        max = (short) Math.max(max, other.max);
    }

    /**
     * Returns the count of values recorded.
     *
     * @return the count of values
     */
    public final long getCount() {
        return count;
    }

    /**
     * Returns the sum of values recorded, or zero if no values have been
     * recorded.
     *
     * @return the sum of values, or zero if none
     */
    public final int getSum() {
        return sum;
    }

    /**
     * Returns the minimum value recorded, or {@code Short.MAX_VALUE} if no
     * values have been recorded.
     *
     * @return the minimum value, or {@code Short.MAX_VALUE} if none
     */
    public final short getMin() {
        return min;
    }

    /**
     * Returns the maximum value recorded, or {@code Short.MIN_VALUE} if no
     * values have been recorded.
     *
     * @return the maximum value, or {@code Short.MIN_VALUE} if none
     */
    public final short getMax() {
        return max;
    }

    /**
     * Returns the arithmetic mean of values recorded, or zero if no values have been
     * recorded.
     *
     * @return the arithmetic mean of values, or zero if none
     */
    public final float getAverage() {
        return getCount() > 0 ? (float) getSum() / getCount() : 0.0f;
    }

    /**
     * Returns a non-empty string representation of this object suitable for
     * debugging. The exact presentation format is unspecified and may vary
     * between implementations and versions.
     */
    @Override
    public String toString() {
        return String.format(
            "%s{count=%d, sum=%d, min=%d, average=%f, max=%d}",
            this.getClass().getSimpleName(),
            getCount(),
            getSum(),
            getMin(),
            getAverage(),
            getMax());
    }
}
