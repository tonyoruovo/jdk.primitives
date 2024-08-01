package jdk.prim.util;

/**
 * A state object for collecting statistics such as count, min, max, sum, and
 * average.
 *
 * <p>This implementation does not check for overflow of the count or the sum.
 * @see java.util.IntSummaryStatistics
 */
public class ByteSummaryStatistics implements jdk.prim.util.function.PrimitiveConsumer.OfByte {
    private long count;
    private int sum;
    private byte min = Byte.MAX_VALUE;
    private byte max = Byte.MIN_VALUE;

    /**
     * Constructs an empty instance with zero count, zero sum,
     * {@code Byte.MAX_VALUE} min, {@code Byte.MIN_VALUE} max and zero
     * average.
     */
    public ByteSummaryStatistics() { }

    /**
     * Constructs a non-empty instance with the specified {@code count},
     * {@code min}, {@code max}, and {@code sum}.
     *
     * @param count the count of values
     * @param min the minimum value
     * @param max the maximum value
     * @param sum the sum of all values
     * @throws IllegalArgumentException if the arguments are inconsistent
     * 
     * @see java.util.IntSummaryStatistics#IntSummaryStatistics(long, int, int, long)
     */
    public ByteSummaryStatistics(long count, byte min, byte max, int sum)
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
    public void acceptByte(byte value) {
        ++count;
        sum += value;
        min = (byte) Math.min(min, value);
        max = (byte) Math.max(max, value);
    }

    /**
     * Combines the state of another {@code ByteSummaryStatistics} into this one.
     *
     * @param other another {@code ByteSummaryStatistics}
     * @throws NullPointerException if {@code other} is null
     */
    public void combine(ByteSummaryStatistics other) {
        count += other.count;
        sum += other.sum;
        min = (byte) Math.min(min, other.min);
        max = (byte) Math.max(max, other.max);
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
     * Returns the minimum value recorded, or {@code Byte.MAX_VALUE} if no
     * values have been recorded.
     *
     * @return the minimum value, or {@code Byte.MAX_VALUE} if none
     */
    public final byte getMin() {
        return min;
    }

    /**
     * Returns the maximum value recorded, or {@code Byte.MIN_VALUE} if no
     * values have been recorded.
     *
     * @return the maximum value, or {@code Byte.MIN_VALUE} if none
     */
    public final byte getMax() {
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
