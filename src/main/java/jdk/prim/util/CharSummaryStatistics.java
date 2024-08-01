package jdk.prim.util;

import java.util.function.BiConsumer;

/**
 * A state object for collecting statistics such as count, min, max, sum, and
 * average.
 *
 * <p>This implementation does not check for overflow of the count or the sum.
 * @see java.util.IntSummaryStatistics
 */
public class CharSummaryStatistics implements jdk.prim.util.function.PrimitiveConsumer.OfChar {
    private StringBuilder sum;
    private char min = Character.MAX_VALUE;
    private char max = Character.MIN_VALUE;
    private final jdk.prim.util.function.PrimitiveBiFunction.ToChar.OfChar.AndChar minimizer;
    private final jdk.prim.util.function.PrimitiveBiFunction.ToChar.OfChar.AndChar maximizer;
    private final jdk.prim.util.function.PrimitiveBiConsumer.AndChar<StringBuilder> op;
    private final BiConsumer<StringBuilder, StringBuilder> combiner;

    /**
     * Constructs an empty instance with zero sum,
     * {@code Character.MAX_VALUE} min, {@code Character.MIN_VALUE} max and zero
     * average.
     * <p>The operator function applies java's plus ({@code +}) operator on new values
     * to concatenate a string
     */
    public CharSummaryStatistics() {
        op = (x, y) -> x.append(y);
        combiner = StringBuilder::append;
        minimizer = (x, y) -> Character.compare(x, y) <= 0 ? x : y;
        maximizer = (x, y) -> Character.compare(x, y) >= 0 ? x : y;
    }

    /**
     * Constructs a non-empty instance with the specified {@code count},
     * {@code min}, {@code max}, and {@code sum}.
     *
     * @param min the minimum value
     * @param max the maximum value
     * @param sum the sum of all values
     * @param operator the operator for incorporating new values
     * @param combiner the operator for integrating a {@code CharSummaryStatistics}
     * @param minimizer computes the minimum value
     * @param maximizer computes the maximum value
     * @throws IllegalArgumentException if the arguments are inconsistent
     * @see java.util.IntSummaryStatistics#IntSummaryStatistics(long, int, int, long)
     */
    public CharSummaryStatistics(char min, char max, StringBuilder sum,
    jdk.prim.util.function.PrimitiveBiConsumer.AndChar<StringBuilder> operator,
    BiConsumer<StringBuilder, StringBuilder> combiner,
    jdk.prim.util.function.PrimitiveBiFunction.ToChar.OfChar.AndChar minimizer,
    jdk.prim.util.function.PrimitiveBiFunction.ToChar.OfChar.AndChar maximizer)
            throws IllegalArgumentException {
        if (min > max) throw new IllegalArgumentException("Minimum greater than maximum");

        this.sum = sum;
        this.min = min;
        this.max = max;
        this.op = operator;
        this.combiner = combiner;
        this.minimizer = minimizer;
        this.maximizer = maximizer;
    }

    /**
     * Records a new value into the summary information
     *
     * @param value the input value
     */
    @Override
    public void acceptChar(char value) {
        // ++count;
        // sum += value;
        op.accept(sum, value);
        min = minimizer.applyChar(min, value);
        max = maximizer.applyChar(max, value);
    }

    /**
     * Combines the state of another {@code CharSummaryStatistics} into this one.
     *
     * @param other another {@code CharSummaryStatistics}
     * @throws NullPointerException if {@code other} is null
     */
    public void combine(CharSummaryStatistics other) {
        // count += other.count;
        combiner.accept(sum, other.sum);
        // sum += other.sum;
        min = minimizer.applyChar(min, other.min);
        max = maximizer.applyChar(max, other.max);
    }

    /**
     * Returns the count of values recorded.
     *
     * @return the count of values
     */
    public final int getCount() {
        return sum.length();
    }

    /**
     * Returns the sum of values recorded.
     *
     * @return the sum of values
     */
    public final StringBuilder getSum() {
        return sum;
    }

    /**
     * Returns the minimum value recorded, or {@code Character.MAX_VALUE} if no
     * values have been recorded.
     *
     * @return the minimum value, or {@code Character.MAX_VALUE} if none
     */
    public final char getMin() {
        return min;
    }

    /**
     * Returns the maximum value recorded, or {@code Character.MIN_VALUE} if no
     * values have been recorded.
     *
     * @return the maximum value, or {@code Character.MIN_VALUE} if none
     */
    public final char getMax() {
        return max;
    }

    /**
     * Returns the arithmetic mean of values recorded, or zero if no values have been
     * recorded.
     *
     * @return the arithmetic mean of values, or zero if none
     */
    // public final double getAverage() {
    //     return getCount() > 0 ? (double) getSum() / getCount() : 0.0d;
    // }

    /**
     * Returns a non-empty string representation of this object suitable for
     * debugging. The exact presentation format is unspecified and may vary
     * between implementations and versions.
     */
    @Override
    public String toString() {
        return String.format(
            "%s{count=%d, sum=%d, min=%d, max=%d}",
            this.getClass().getSimpleName(),
            getCount(),
            getSum(),
            getMin(),
            getMax());
    }
}
