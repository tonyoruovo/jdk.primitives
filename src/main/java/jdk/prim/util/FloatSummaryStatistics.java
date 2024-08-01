package jdk.prim.util;

import static jdk.prim.util.PrimitiveArrays.filter;

/**
 * A state object for collecting statistics such as count, min, max, sum, and
 * average.
 *
 * <p>This implementation does not check for overflow of the count.
 * @see java.util.DoubleSummaryStatistics
 */
public class FloatSummaryStatistics implements jdk.prim.util.function.PrimitiveConsumer.OfFloat {
    private long count;
    private float sum;
    private float sumCompensation; // Low order bits of sum
    private float simpleSum; // Used to compute right sum for non-finite inputs
    private float min = Float.POSITIVE_INFINITY;
    private float max = Float.NEGATIVE_INFINITY;

    /**
     * Constructs an empty instance with zero count, zero sum,
     * {@code Float.POSITIVE_INFINITY} min, {@code Float.NEGATIVE_INFINITY}
     * max and zero average.
     */
    public FloatSummaryStatistics() { }

    /**
     * Constructs a non-empty instance with the specified {@code count},
     * {@code min}, {@code max}, and {@code sum}.
     *
     * @param count the count of values
     * @param min the minimum value
     * @param max the maximum value
     * @param sum the sum of all values
     * @throws IllegalArgumentException if the arguments are inconsistent
     * @see java.util.DoubleSummaryStatistics#DoubleSummaryStatistics(long, double, double, double)
     */
    public FloatSummaryStatistics(long count, float min, float max, float sum)
            throws IllegalArgumentException {
        if (count < 0L) {
            throw new IllegalArgumentException("Negative count value");
        } else if (count > 0L) {
            if (min > max)
                throw new IllegalArgumentException("Minimum greater than maximum");

            int nlen = filter(new float[]{min, max, sum}, Float::isNaN).length;
            if (nlen > 0 && nlen < 3)
                throw new IllegalArgumentException("Some, not all, of the minimum, maximum, or sum is NaN");

            this.count = count;
            this.sum = sum;
            this.simpleSum = sum;
            this.sumCompensation = 0.0f;
            this.min = min;
            this.max = max;
        }
    }

    /**
     * Records another value into the summary information.
     *
     * @param value the input value
     */
    @Override
    public void acceptFloat(float value) {
        ++count;
        simpleSum += value;
        sumWithCompensation(value);
        min = Math.min(min, value);
        max = Math.max(max, value);
    }

    /**
     * Combines the state of another {@code FloatSummaryStatistics} into this
     * one.
     *
     * @param other another {@code FloatSummaryStatistics}
     * @throws NullPointerException if {@code other} is null
     */
    public void combine(FloatSummaryStatistics other) {
        count += other.count;
        simpleSum += other.simpleSum;
        sumWithCompensation(other.sum);

        sumWithCompensation(-other.sumCompensation);
        min = Math.min(min, other.min);
        max = Math.max(max, other.max);
    }

    /**
     * Incorporate a new float value using Kahan summation /
     * compensated summation.
     */
    private void sumWithCompensation(float value) {
        float tmp = value - sumCompensation;
        float velvel = sum + tmp;
        sumCompensation = (velvel - sum) - tmp;
        sum = velvel;
    }

    /**
     * Return the count of values recorded.
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
     * 
     * @see java.util.DoubleSummaryStatistics#getSum()
     */
    public final float getSum() {
        float tmp =  sum - sumCompensation;
        if (Float.isNaN(tmp) && Float.isInfinite(simpleSum))
            return simpleSum;
        else
            return tmp;
    }

    /**
     * Returns the minimum recorded value, {@code Float.NaN} if any recorded
     * value was NaN or {@code Float.POSITIVE_INFINITY} if no values were
     * recorded. Unlike the numerical comparison operators, this method
     * considers negative zero to be strictly smaller than positive zero.
     *
     * @return the minimum recorded value, {@code Float.NaN} if any recorded
     * value was NaN or {@code Float.POSITIVE_INFINITY} if no values were
     * recorded
     */
    public final float getMin() {
        return min;
    }

    /**
     * Returns the maximum recorded value, {@code Float.NaN} if any recorded
     * value was NaN or {@code Float.NEGATIVE_INFINITY} if no values were
     * recorded. Unlike the numerical comparison operators, this method
     * considers negative zero to be strictly smaller than positive zero.
     *
     * @return the maximum recorded value, {@code Float.NaN} if any recorded
     * value was NaN or {@code Float.NEGATIVE_INFINITY} if no values were
     * recorded
     */
    public final float getMax() {
        return max;
    }

    /**
     * Returns the arithmetic mean of values recorded, or zero if no
     * values have been recorded.
     *
     * <p> The computed average can vary numerically and have the
     * special case behavior as computing the sum; see {@link #getSum}
     * for details.
     *
     * @apiNote Values sorted by increasing absolute magnitude tend to yield
     * more accurate results.
     *
     * @return the arithmetic mean of values, or zero if none
     */
    public final float getAverage() {
        return getCount() > 0 ? getSum() / getCount() : 0.0f;
    }

    /**
     * Returns a non-empty string representation of this object suitable for
     * debugging. The exact presentation format is unspecified and may vary
     * between implementations and versions.
     */
    @Override
    public String toString() {
        return String.format(
            "%s{count=%d, sum=%f, min=%f, average=%f, max=%f}",
            this.getClass().getSimpleName(),
            getCount(),
            getSum(),
            getMin(),
            getAverage(),
            getMax());
    }
}
