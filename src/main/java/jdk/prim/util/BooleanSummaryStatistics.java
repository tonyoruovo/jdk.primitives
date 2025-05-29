package jdk.prim.util;

import java.util.BitSet;

/**
 * A state object for collecting statistics such as count, min, max, sum, and
 * average.
 *
 * <p>This implementation does not check for overflow of the count or the sum.
 * @see java.util.IntSummaryStatistics
 */
public class BooleanSummaryStatistics implements jdk.prim.util.function.PrimitiveConsumer.OfBoolean {
    private long count;
    private final BitSet sum;
    private boolean min = Boolean.FALSE;
    private boolean max = Boolean.TRUE;

    /**
     * Constructs an empty instance with zero count,
     * {@code Boolean.TRUE} min, {@code Boolean.FALSE} max and zero
     * average.
     */
    public BooleanSummaryStatistics() { sum = new BitSet(); }

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
     * @see jdk.prim.util.CharSummaryStatistics#CharSummaryStatistics(char, char, StringBuilder, jdk.prim.util.function.PrimitiveBiConsumer.AndChar, java.util.function.BiConsumer, jdk.prim.util.function.PrimitiveBiFunction.ToChar.OfChar.AndChar, jdk.prim.util.function.PrimitiveBiFunction.ToChar.OfChar.AndChar)
     */
    public BooleanSummaryStatistics(long count, boolean min, boolean max, BitSet sum)
            throws IllegalArgumentException {
        if (count < 0L) {
            throw new IllegalArgumentException("Negative count value");
        } else if (count > 0L) {

            this.count = count;
            this.min = min;
            this.max = max;
        }
        this.sum = sum;
    }

    /**
     * Records a new value into the summary information
     *
     * @param value the input value
     */
    @Override
    public void acceptBoolean(boolean value) {
        ++count;
        // sum += value;
        sum.set(0, value);
        min = value ? min : value;
        max = value ? value : max;
    }

    /**
     * Combines the state of another {@code BooleanSummaryStatistics} into this one.
     *
     * @param other another {@code BooleanSummaryStatistics}
     * @throws NullPointerException if {@code other} is null
     */
    public void combine(BooleanSummaryStatistics other) {
        count += other.count;
        sum.set(sum.length());
        sum.and(other.sum);
        min = other.min ? min : other.min;
        max = other.max ? other.max : max;
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
    public final byte[] getSum() {
        return sum.toByteArray();
    }

    /**
     * Returns the minimum value recorded, or {@link Boolean#FALSE} if no
     * values have been recorded.
     *
     * @return the minimum value, or {@link Boolean#FALSE} if none
     */
    public final boolean getMin() {
        return min;
    }

    /**
     * Returns the maximum value recorded, or {@code Boolean#TRUE} if no
     * values have been recorded.
     *
     * @return the maximum value, or {@code Boolean#TRUE} if none
     */
    public final boolean getMax() {
        return max;
    }

    /**
     * Returns the arithmetic mean of values recorded, or zero if no values have been
     * recorded.
     *
     * @return the arithmetic mean of values, or zero if none
     */
    public final double getAverage() {
        return getCount() > 0 ? (double) getSum().length / getCount() : 0.0d;
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
