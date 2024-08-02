package jdk.prim.util;

import java.io.Serializable;
import java.util.Comparator;
import jdk.prim.util.function.PrimitiveFunction;

/**
 * An interface that provides primitive support for the {@code Comparator}
 * interface.
 * Support exists for a primitive for every parameter and every case.
 * 
 * <p>
 * It also defines primitive alternatives for {@link #thenComparing(Function)}.
 * <p>
 * It uses the following interface naming convention: {@code Of*} refers to the
 * first and second argument
 * as a primitive.
 * <p>
 * Note that no exception handling is done on any of the methods
 * ({@code default} or otherwise)
 * in these interfaces. If an exception is thrown in any method, the behaviour
 * of that method will
 * be similar to it's JDK super interface.
 * 
 * @param <OF> the first argument to {@link #compare(Object)}
 * 
 * @see Comparator
 */
@FunctionalInterface
public interface PrimitiveComparator<OF> extends Comparator<OF> {

    /**
     * A comparator for {@code double} values. This is the comparator for
     * {@code double} specialisations.
     * 
     * @see PrimitiveComparator
     */
    @FunctionalInterface
    interface OfDouble extends PrimitiveComparator<java.lang.Double> {
        /**
         * Compares the {@code double} arguments for order
         * 
         * @param x the input to be compared
         * @param y the second input to be compared
         * @return a negative integer, zero, or a positive integer as the first argument
         *         is less than, equal to, or greater than the second.
         * @see Comparator#compare(Object, Object)
         * @apiNote This is recommended over the {@link #compare} as this is the
         *          specialised form
         */
        int compareDouble(double x, double y);

        /**
         * The {@code double} specialisation for {@link #reversed()}
         * @return the reversed order for this {@code OfDouble} comparator
         * 
         * @see Comparator#reversed()
         */
        default OfDouble reversedDouble() {
            return reverseOrderDouble(this);
        }

        @Override
        default Comparator<java.lang.Double> reversed() {
            return reversedDouble();
        }

        /**
         * {@inheritDoc}
         * 
         * @param x {@inheritDoc}
         * @param y {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote The default implementation calls and returns the value of
         *           {@link #compareDouble}
         */
        @Override
        default int compare(java.lang.Double x, java.lang.Double y) {
            return compareDouble(x, y);
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code double} sort key.
         * 
         * @param keyExtractor a function with a {@code double} parameter which returns
         *                     a {@code double}. This
         *                     is used to extract the {@code double} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code double} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         * @see Comparator#thenComparingDouble(java.util.function.ToDoubleFunction)
         */
        default OfDouble thenComparingDouble(PrimitiveFunction.ToDouble.OfDouble keyExtractor) {
            return (OfDouble & Serializable) (x, y) -> java.lang.Double.compare(keyExtractor.applyDouble(x),
                    keyExtractor.applyDouble(y));
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code long} sort key.
         * 
         * @param keyExtractor a function with a {@code double} parameter which returns
         *                     a {@code long}. This
         *                     is used to extract the {@code long} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code long} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         * @see Comparator#thenComparingLong(java.util.function.ToLongFunction)
         */
        default OfDouble thenComparingLong(PrimitiveFunction.ToLong.OfDouble keyExtractor) {
            return (OfDouble & Serializable) (x, y) -> java.lang.Long.compare(keyExtractor.applyLong(x),
                    keyExtractor.applyLong(y));
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code int} sort key.
         * 
         * @param keyExtractor a function with a {@code double} parameter which returns
         *                     a {@code int}. This
         *                     is used to extract the {@code int} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code int} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         * @see Comparator#thenComparingInt(java.util.function.ToIntFunction)
         */
        default OfDouble thenComparingInt(PrimitiveFunction.ToInt.OfDouble keyExtractor) {
            return (OfDouble & Serializable) (x, y) -> java.lang.Integer.compare(keyExtractor.applyInt(x),
                    keyExtractor.applyInt(y));
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code float} sort key.
         * 
         * @param keyExtractor a function with a {@code double} parameter which returns
         *                     a {@code float}. This
         *                     is used to extract the {@code float} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code float} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfDouble thenComparingFloat(PrimitiveFunction.ToFloat.OfDouble keyExtractor) {
            return (OfDouble & Serializable) (x, y) -> java.lang.Float.compare(keyExtractor.applyFloat(x),
                    keyExtractor.applyFloat(y));
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code char} sort key.
         * 
         * @param keyExtractor a function with a {@code double} parameter which returns
         *                     a {@code char}. This
         *                     is used to extract the {@code char} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code char} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfDouble thenComparingChar(PrimitiveFunction.ToChar.OfDouble keyExtractor) {
            return (OfDouble & Serializable) (x, y) -> java.lang.Character.compare(keyExtractor.applyChar(x),
                    keyExtractor.applyChar(y));
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code short} sort key.
         * 
         * @param keyExtractor a function with a {@code double} parameter which returns
         *                     a {@code short}. This
         *                     is used to extract the {@code short} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code float} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfDouble thenComparingShort(PrimitiveFunction.ToShort.OfDouble keyExtractor) {
            return (OfDouble & Serializable) (x, y) -> java.lang.Short.compare(keyExtractor.applyShort(x),
                    keyExtractor.applyShort(y));
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code byte} sort key.
         * 
         * @param keyExtractor a function with a {@code double} parameter which returns
         *                     a {@code byte}. This
         *                     is used to extract the {@code byte} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code byte} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfDouble thenComparingByte(PrimitiveFunction.ToByte.OfDouble keyExtractor) {
            return (OfDouble & Serializable) (x, y) -> java.lang.Byte.compare(keyExtractor.applyByte(x),
                    keyExtractor.applyByte(y));
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code boolean} sort key.
         * 
         * @param keyExtractor a function with a {@code double} parameter which returns
         *                     a {@code boolean}. This
         *                     is used to extract the {@code boolean} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code boolean} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfDouble thenComparingBoolean(PrimitiveFunction.ToBoolean.OfDouble keyExtractor) {
            return (OfDouble & Serializable) (x, y) -> java.lang.Boolean.compare(keyExtractor.applyBoolean(x),
                    keyExtractor.applyBoolean(y));
        }
    }

    /**
     * A comparator for {@code long} values. This is the comparator for {@code long}
     * specialisations.
     * 
     * @see PrimitiveComparator
     */
    @FunctionalInterface
    interface OfLong extends PrimitiveComparator<java.lang.Long> {
        /**
         * Compares the {@code long} arguments for order
         * 
         * @param x the input to be compared
         * @param y the second input to be compared
         * @return a negative integer, zero, or a positive integer as the first argument
         *         is less than, equal to, or greater than the second.
         * @see Comparator#compare(Object, Object)
         * @apiNote This is recommended over the {@link #compare} as this is the
         *          specialised form
         */
        int compareLong(long x, long y);

        /**
         * The {@code long} specialisation for {@link #reversed()}
         * @return the reversed order for this {@code OfLong} comparator
         * 
         * @see Comparator#reversed()
         */
        default OfLong reversedLong() {
            return reverseOrderLong(this);
        }

        @Override
        default Comparator<java.lang.Long> reversed() {
            return reversedLong();
        }

        /**
         * {@inheritDoc}
         * 
         * @param x {@inheritDoc}
         * @param y {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote The default implementation calls and returns the value of
         *           {@link #compareLong}
         */
        @Override
        default int compare(java.lang.Long x, java.lang.Long y) {
            return compareLong(x, y);
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code long} sort key.
         * 
         * @param keyExtractor a function with a {@code long} parameter which returns a
         *                     {@code long}. This
         *                     is used to extract the {@code double} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code long} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         * @see Comparator#thenComparingDouble(java.util.function.ToDoubleFunction)
         */
        default OfLong thenComparingDouble(PrimitiveFunction.ToDouble.OfLong keyExtractor) {
            return (OfLong & Serializable) (x, y) -> java.lang.Double.compare(keyExtractor.applyDouble(x),
                    keyExtractor.applyDouble(y));
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code long} sort key.
         * 
         * @param keyExtractor a function with a {@code long} parameter which returns a
         *                     {@code long}. This
         *                     is used to extract the {@code long} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code long} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         * @see Comparator#thenComparingLong(java.util.function.ToLongFunction)
         */
        default OfLong thenComparingLong(PrimitiveFunction.ToLong.OfLong keyExtractor) {
            return (OfLong & Serializable) (x, y) -> java.lang.Long.compare(keyExtractor.applyLong(x),
                    keyExtractor.applyLong(y));
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code int} sort key.
         * 
         * @param keyExtractor a function with a {@code long} parameter which returns a
         *                     {@code int}. This
         *                     is used to extract the {@code int} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code int} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         * @see Comparator#thenComparingInt(java.util.function.ToIntFunction)
         */
        default OfLong thenComparingInt(PrimitiveFunction.ToInt.OfLong keyExtractor) {
            return (OfLong & Serializable) (x, y) -> java.lang.Integer.compare(keyExtractor.applyInt(x),
                    keyExtractor.applyInt(y));
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code float} sort key.
         * 
         * @param keyExtractor a function with a {@code long} parameter which returns a
         *                     {@code float}. This
         *                     is used to extract the {@code float} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code float} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfLong thenComparingFloat(PrimitiveFunction.ToFloat.OfLong keyExtractor) {
            return (OfLong & Serializable) (x, y) -> java.lang.Float.compare(keyExtractor.applyFloat(x),
                    keyExtractor.applyFloat(y));
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code char} sort key.
         * 
         * @param keyExtractor a function with a {@code long} parameter which returns a
         *                     {@code char}. This
         *                     is used to extract the {@code char} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code char} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfLong thenComparingChar(PrimitiveFunction.ToChar.OfLong keyExtractor) {
            return (OfLong & Serializable) (x, y) -> java.lang.Character.compare(keyExtractor.applyChar(x),
                    keyExtractor.applyChar(y));
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code short} sort key.
         * 
         * @param keyExtractor a function with a {@code long} parameter which returns a
         *                     {@code short}. This
         *                     is used to extract the {@code short} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code float} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfLong thenComparingShort(PrimitiveFunction.ToShort.OfLong keyExtractor) {
            return (OfLong & Serializable) (x, y) -> java.lang.Short.compare(keyExtractor.applyShort(x),
                    keyExtractor.applyShort(y));
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code byte} sort key.
         * 
         * @param keyExtractor a function with a {@code long} parameter which returns a
         *                     {@code byte}. This
         *                     is used to extract the {@code byte} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code byte} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfLong thenComparingByte(PrimitiveFunction.ToByte.OfLong keyExtractor) {
            return (OfLong & Serializable) (x, y) -> java.lang.Byte.compare(keyExtractor.applyByte(x),
                    keyExtractor.applyByte(y));
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code boolean} sort key.
         * 
         * @param keyExtractor a function with a {@code long} parameter which returns a
         *                     {@code boolean}. This
         *                     is used to extract the {@code boolean} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code boolean} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfLong thenComparingBoolean(PrimitiveFunction.ToBoolean.OfLong keyExtractor) {
            return (OfLong & Serializable) (x, y) -> java.lang.Boolean.compare(keyExtractor.applyBoolean(x),
                    keyExtractor.applyBoolean(y));
        }
    }

    /**
     * A comparator for {@code int} values. This is the comparator for {@code int}
     * specialisations.
     * 
     * @see PrimitiveComparator
     */
    @FunctionalInterface
    interface OfInt extends PrimitiveComparator<java.lang.Integer> {
        /**
         * Compares the {@code int} arguments for order
         * 
         * @param x the input to be compared
         * @param y the second input to be compared
         * @return a negative integer, zero, or a positive integer as the first argument
         *         is less than, equal to, or greater than the second.
         * @see Comparator#compare(Object, Object)
         * @apiNote This is recommended over the {@link #compare} as this is the
         *          specialised form
         */
        int compareInt(int x, int y);

        /**
         * The {@code int} specialisation for {@link #reversed()}
         * @return the reversed order for this {@code OfInt} comparator
         * 
         * @see Comparator#reversed()
         */
        default OfInt reversedInt() {
            return reverseOrderInt(this);
        }

        @Override
        default Comparator<java.lang.Integer> reversed() {
            return reversedInt();
        }

        /**
         * {@inheritDoc}
         * 
         * @param x {@inheritDoc}
         * @param y {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote The default implementation calls and returns the value of
         *           {@link #compareInt}
         */
        @Override
        default int compare(java.lang.Integer x, java.lang.Integer y) {
            return compareInt(x, y);
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code int} sort key.
         * 
         * @param keyExtractor a function with a {@code int} parameter which returns a
         *                     {@code int}. This
         *                     is used to extract the {@code double} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code int} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         * @see Comparator#thenComparingDouble(java.util.function.ToDoubleFunction)
         */
        default OfInt thenComparingDouble(PrimitiveFunction.ToDouble.OfInt keyExtractor) {
            return (OfInt & Serializable) (x, y) -> java.lang.Double.compare(keyExtractor.applyDouble(x),
                    keyExtractor.applyDouble(y));
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code long} sort key.
         * 
         * @param keyExtractor a function with a {@code int} parameter which returns a
         *                     {@code long}. This
         *                     is used to extract the {@code long} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code long} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         * @see Comparator#thenComparingLong(java.util.function.ToLongFunction)
         */
        default OfInt thenComparingLong(PrimitiveFunction.ToLong.OfInt keyExtractor) {
            return (OfInt & Serializable) (x, y) -> java.lang.Long.compare(keyExtractor.applyLong(x),
                    keyExtractor.applyLong(y));
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code int} sort key.
         * 
         * @param keyExtractor a function with a {@code int} parameter which returns a
         *                     {@code int}. This
         *                     is used to extract the {@code int} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code int} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         * @see Comparator#thenComparingInt(java.util.function.ToIntFunction)
         */
        default OfInt thenComparingInt(PrimitiveFunction.ToInt.OfInt keyExtractor) {
            return (OfInt & Serializable) (x, y) -> java.lang.Integer.compare(keyExtractor.applyInt(x),
                    keyExtractor.applyInt(y));
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code float} sort key.
         * 
         * @param keyExtractor a function with a {@code int} parameter which returns a
         *                     {@code float}. This
         *                     is used to extract the {@code float} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code float} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfInt thenComparingFloat(PrimitiveFunction.ToFloat.OfInt keyExtractor) {
            return (OfInt & Serializable) (x, y) -> java.lang.Float.compare(keyExtractor.applyFloat(x),
                    keyExtractor.applyFloat(y));
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code char} sort key.
         * 
         * @param keyExtractor a function with a {@code int} parameter which returns a
         *                     {@code char}. This
         *                     is used to extract the {@code char} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code char} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfInt thenComparingChar(PrimitiveFunction.ToChar.OfInt keyExtractor) {
            return (OfInt & Serializable) (x, y) -> java.lang.Character.compare(keyExtractor.applyChar(x),
                    keyExtractor.applyChar(y));
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code short} sort key.
         * 
         * @param keyExtractor a function with a {@code int} parameter which returns a
         *                     {@code short}. This
         *                     is used to extract the {@code short} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code float} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfInt thenComparingShort(PrimitiveFunction.ToShort.OfInt keyExtractor) {
            return (OfInt & Serializable) (x, y) -> java.lang.Short.compare(keyExtractor.applyShort(x),
                    keyExtractor.applyShort(y));
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code byte} sort key.
         * 
         * @param keyExtractor a function with a {@code int} parameter which returns a
         *                     {@code byte}. This
         *                     is used to extract the {@code byte} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code byte} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfInt thenComparingByte(PrimitiveFunction.ToByte.OfInt keyExtractor) {
            return (OfInt & Serializable) (x, y) -> java.lang.Byte.compare(keyExtractor.applyByte(x),
                    keyExtractor.applyByte(y));
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code boolean} sort key.
         * 
         * @param keyExtractor a function with a {@code int} parameter which returns a
         *                     {@code boolean}. This
         *                     is used to extract the {@code boolean} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code boolean} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfInt thenComparingBoolean(PrimitiveFunction.ToBoolean.OfInt keyExtractor) {
            return (OfInt & Serializable) (x, y) -> java.lang.Boolean.compare(keyExtractor.applyBoolean(x),
                    keyExtractor.applyBoolean(y));
        }
    }

    /**
     * A comparator for {@code float} values. This is the comparator for
     * {@code float} specialisations.
     * 
     * @see PrimitiveComparator
     */
    @FunctionalInterface
    interface OfFloat extends PrimitiveComparator<java.lang.Float> {
        /**
         * Compares the {@code float} arguments for order
         * 
         * @param x the input to be compared
         * @param y the second input to be compared
         * @return a negative integer, zero, or a positive integer as the first argument
         *         is less than, equal to, or greater than the second.
         * @see Comparator#compare(Object, Object)
         * @apiNote This is recommended over the {@link #compare} as this is the
         *          specialised form
         */
        int compareFloat(float x, float y);

        /**
         * The {@code float} specialisation for {@link #reversed()}
         * @return the reversed order for this {@code OfFloat} comparator
         * 
         * @see Comparator#reversed()
         */
        default OfFloat reversedFloat() {
            return reverseOrderFloat(this);
        }

        @Override
        default Comparator<java.lang.Float> reversed() {
            return reversedFloat();
        }

        /**
         * {@inheritDoc}
         * 
         * @param x {@inheritDoc}
         * @param y {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote The default implementation calls and returns the value of
         *           {@link #compareFloat}
         */
        @Override
        default int compare(java.lang.Float x, java.lang.Float y) {
            return compareFloat(x, y);
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code float} sort key.
         * 
         * @param keyExtractor a function with a {@code float} parameter which returns a
         *                     {@code float}. This
         *                     is used to extract the {@code double} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code float} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         * @see Comparator#thenComparingDouble(java.util.function.ToDoubleFunction)
         */
        default OfFloat thenComparingDouble(PrimitiveFunction.ToDouble.OfFloat keyExtractor) {
            return (OfFloat & Serializable) (x, y) -> java.lang.Double.compare(keyExtractor.applyDouble(x),
                    keyExtractor.applyDouble(y));
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code long} sort key.
         * 
         * @param keyExtractor a function with a {@code float} parameter which returns a
         *                     {@code long}. This
         *                     is used to extract the {@code long} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code long} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         * @see Comparator#thenComparingLong(java.util.function.ToLongFunction)
         */
        default OfFloat thenComparingLong(PrimitiveFunction.ToLong.OfFloat keyExtractor) {
            return (OfFloat & Serializable) (x, y) -> java.lang.Long.compare(keyExtractor.applyLong(x),
                    keyExtractor.applyLong(y));
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code int} sort key.
         * 
         * @param keyExtractor a function with a {@code float} parameter which returns a
         *                     {@code int}. This
         *                     is used to extract the {@code int} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code int} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         * @see Comparator#thenComparingInt(java.util.function.ToIntFunction)
         */
        default OfFloat thenComparingInt(PrimitiveFunction.ToInt.OfFloat keyExtractor) {
            return (OfFloat & Serializable) (x, y) -> java.lang.Integer.compare(keyExtractor.applyInt(x),
                    keyExtractor.applyInt(y));
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code float} sort key.
         * 
         * @param keyExtractor a function with a {@code float} parameter which returns a
         *                     {@code float}. This
         *                     is used to extract the {@code float} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code float} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfFloat thenComparingFloat(PrimitiveFunction.ToFloat.OfFloat keyExtractor) {
            return (OfFloat & Serializable) (x, y) -> java.lang.Float.compare(keyExtractor.applyFloat(x),
                    keyExtractor.applyFloat(y));
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code char} sort key.
         * 
         * @param keyExtractor a function with a {@code float} parameter which returns a
         *                     {@code char}. This
         *                     is used to extract the {@code char} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code char} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfFloat thenComparingChar(PrimitiveFunction.ToChar.OfFloat keyExtractor) {
            return (OfFloat & Serializable) (x, y) -> java.lang.Character.compare(keyExtractor.applyChar(x),
                    keyExtractor.applyChar(y));
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code short} sort key.
         * 
         * @param keyExtractor a function with a {@code float} parameter which returns a
         *                     {@code short}. This
         *                     is used to extract the {@code short} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code float} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfFloat thenComparingShort(PrimitiveFunction.ToShort.OfFloat keyExtractor) {
            return (OfFloat & Serializable) (x, y) -> java.lang.Short.compare(keyExtractor.applyShort(x),
                    keyExtractor.applyShort(y));
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code byte} sort key.
         * 
         * @param keyExtractor a function with a {@code float} parameter which returns a
         *                     {@code byte}. This
         *                     is used to extract the {@code byte} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code byte} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfFloat thenComparingByte(PrimitiveFunction.ToByte.OfFloat keyExtractor) {
            return (OfFloat & Serializable) (x, y) -> java.lang.Byte.compare(keyExtractor.applyByte(x),
                    keyExtractor.applyByte(y));
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code boolean} sort key.
         * 
         * @param keyExtractor a function with a {@code float} parameter which returns a
         *                     {@code boolean}. This
         *                     is used to extract the {@code boolean} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code boolean} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfFloat thenComparingBoolean(PrimitiveFunction.ToBoolean.OfFloat keyExtractor) {
            return (OfFloat & Serializable) (x, y) -> java.lang.Boolean.compare(keyExtractor.applyBoolean(x),
                    keyExtractor.applyBoolean(y));
        }
    }

    /**
     * A comparator for {@code char} values. This is the comparator for {@code char}
     * specialisations.
     * 
     * @see PrimitiveComparator
     */
    @FunctionalInterface
    interface OfChar extends PrimitiveComparator<java.lang.Character> {
        /**
         * Compares the {@code char} arguments for order
         * 
         * @param x the input to be compared
         * @param y the second input to be compared
         * @return a negative integer, zero, or a positive integer as the first argument
         *         is less than, equal to, or greater than the second.
         * @see Comparator#compare(Object, Object)
         * @apiNote This is recommended over the {@link #compare} as this is the
         *          specialised form
         */
        int compareChar(char x, char y);

        /**
         * The {@code char} specialisation for {@link #reversed()}
         * @return the reversed order for this {@code OfChar} comparator
         * 
         * @see Comparator#reversed()
         */
        default OfChar reversedChar() {
            return reverseOrderChar(this);
        }

        @Override
        default Comparator<java.lang.Character> reversed() {
            return reversedChar();
        }

        /**
         * {@inheritDoc}
         * 
         * @param x {@inheritDoc}
         * @param y {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote The default implementation calls and returns the value of
         *           {@link #compareChar}
         */
        @Override
        default int compare(java.lang.Character x, java.lang.Character y) {
            return compareChar(x, y);
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code char} sort key.
         * 
         * @param keyExtractor a function with a {@code char} parameter which returns a
         *                     {@code char}. This
         *                     is used to extract the {@code double} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code char} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         * @see Comparator#thenComparingDouble(java.util.function.ToDoubleFunction)
         */
        default OfChar thenComparingDouble(PrimitiveFunction.ToDouble.OfChar keyExtractor) {
            return (OfChar & Serializable) (x, y) -> java.lang.Double.compare(keyExtractor.applyDouble(x),
                    keyExtractor.applyDouble(y));
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code long} sort key.
         * 
         * @param keyExtractor a function with a {@code char} parameter which returns a
         *                     {@code long}. This
         *                     is used to extract the {@code long} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code long} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         * @see Comparator#thenComparingLong(java.util.function.ToLongFunction)
         */
        default OfChar thenComparingLong(PrimitiveFunction.ToLong.OfChar keyExtractor) {
            return (OfChar & Serializable) (x, y) -> java.lang.Long.compare(keyExtractor.applyLong(x),
                    keyExtractor.applyLong(y));
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code int} sort key.
         * 
         * @param keyExtractor a function with a {@code char} parameter which returns a
         *                     {@code int}. This
         *                     is used to extract the {@code int} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code int} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         * @see Comparator#thenComparingInt(java.util.function.ToIntFunction)
         */
        default OfChar thenComparingInt(PrimitiveFunction.ToInt.OfChar keyExtractor) {
            return (OfChar & Serializable) (x, y) -> java.lang.Integer.compare(keyExtractor.applyInt(x),
                    keyExtractor.applyInt(y));
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code float} sort key.
         * 
         * @param keyExtractor a function with a {@code char} parameter which returns a
         *                     {@code float}. This
         *                     is used to extract the {@code float} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code float} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfChar thenComparingFloat(PrimitiveFunction.ToFloat.OfChar keyExtractor) {
            return (OfChar & Serializable) (x, y) -> java.lang.Float.compare(keyExtractor.applyFloat(x),
                    keyExtractor.applyFloat(y));
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code char} sort key.
         * 
         * @param keyExtractor a function with a {@code char} parameter which returns a
         *                     {@code char}. This
         *                     is used to extract the {@code char} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code char} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfChar thenComparingChar(PrimitiveFunction.ToChar.OfChar keyExtractor) {
            return (OfChar & Serializable) (x, y) -> java.lang.Character.compare(keyExtractor.applyChar(x),
                    keyExtractor.applyChar(y));
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code short} sort key.
         * 
         * @param keyExtractor a function with a {@code char} parameter which returns a
         *                     {@code short}. This
         *                     is used to extract the {@code short} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code float} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfChar thenComparingShort(PrimitiveFunction.ToShort.OfChar keyExtractor) {
            return (OfChar & Serializable) (x, y) -> java.lang.Short.compare(keyExtractor.applyShort(x),
                    keyExtractor.applyShort(y));
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code byte} sort key.
         * 
         * @param keyExtractor a function with a {@code char} parameter which returns a
         *                     {@code byte}. This
         *                     is used to extract the {@code byte} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code byte} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfChar thenComparingByte(PrimitiveFunction.ToByte.OfChar keyExtractor) {
            return (OfChar & Serializable) (x, y) -> java.lang.Byte.compare(keyExtractor.applyByte(x),
                    keyExtractor.applyByte(y));
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code boolean} sort key.
         * 
         * @param keyExtractor a function with a {@code char} parameter which returns a
         *                     {@code boolean}. This
         *                     is used to extract the {@code boolean} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code boolean} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfChar thenComparingBoolean(PrimitiveFunction.ToBoolean.OfChar keyExtractor) {
            return (OfChar & Serializable) (x, y) -> java.lang.Boolean.compare(keyExtractor.applyBoolean(x),
                    keyExtractor.applyBoolean(y));
        }
    }

    /**
     * A comparator for {@code short} values. This is the comparator for
     * {@code short} specialisations.
     * 
     * @see PrimitiveComparator
     */
    @FunctionalInterface
    interface OfShort extends PrimitiveComparator<java.lang.Short> {
        /**
         * Compares the {@code short} arguments for order
         * 
         * @param x the input to be compared
         * @param y the second input to be compared
         * @return a negative integer, zero, or a positive integer as the first argument
         *         is less than, equal to, or greater than the second.
         * @see Comparator#compare(Object, Object)
         * @apiNote This is recommended over the {@link #compare} as this is the
         *          specialised form
         */
        int compareShort(short x, short y);

        /**
         * The {@code short} specialisation for {@link #reversed()}
         * @return the reversed order for this {@code OfShort} comparator
         * 
         * @see Comparator#reversed()
         */
        default OfShort reversedShort() {
            return reverseOrderShort(this);
        }

        @Override
        default Comparator<java.lang.Short> reversed() {
            return reversedShort();
        }

        /**
         * {@inheritDoc}
         * 
         * @param x {@inheritDoc}
         * @param y {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote The default implementation calls and returns the value of
         *           {@link #compareShort}
         */
        @Override
        default int compare(java.lang.Short x, java.lang.Short y) {
            return compareShort(x, y);
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code short} sort key.
         * 
         * @param keyExtractor a function with a {@code short} parameter which returns a
         *                     {@code short}. This
         *                     is used to extract the {@code double} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code short} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         * @see Comparator#thenComparingDouble(java.util.function.ToDoubleFunction)
         */
        default OfShort thenComparingDouble(PrimitiveFunction.ToDouble.OfShort keyExtractor) {
            return (OfShort & Serializable) (x, y) -> java.lang.Double.compare(keyExtractor.applyDouble(x),
                    keyExtractor.applyDouble(y));
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code long} sort key.
         * 
         * @param keyExtractor a function with a {@code short} parameter which returns a
         *                     {@code long}. This
         *                     is used to extract the {@code long} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code long} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         * @see Comparator#thenComparingLong(java.util.function.ToLongFunction)
         */
        default OfShort thenComparingLong(PrimitiveFunction.ToLong.OfShort keyExtractor) {
            return (OfShort & Serializable) (x, y) -> java.lang.Long.compare(keyExtractor.applyLong(x),
                    keyExtractor.applyLong(y));
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code int} sort key.
         * 
         * @param keyExtractor a function with a {@code short} parameter which returns a
         *                     {@code int}. This
         *                     is used to extract the {@code int} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code int} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         * @see Comparator#thenComparingInt(java.util.function.ToIntFunction)
         */
        default OfShort thenComparingInt(PrimitiveFunction.ToInt.OfShort keyExtractor) {
            return (OfShort & Serializable) (x, y) -> java.lang.Integer.compare(keyExtractor.applyInt(x),
                    keyExtractor.applyInt(y));
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code float} sort key.
         * 
         * @param keyExtractor a function with a {@code short} parameter which returns a
         *                     {@code float}. This
         *                     is used to extract the {@code float} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code float} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfShort thenComparingFloat(PrimitiveFunction.ToFloat.OfShort keyExtractor) {
            return (OfShort & Serializable) (x, y) -> java.lang.Float.compare(keyExtractor.applyFloat(x),
                    keyExtractor.applyFloat(y));
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code char} sort key.
         * 
         * @param keyExtractor a function with a {@code short} parameter which returns a
         *                     {@code char}. This
         *                     is used to extract the {@code char} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code char} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfShort thenComparingChar(PrimitiveFunction.ToChar.OfShort keyExtractor) {
            return (OfShort & Serializable) (x, y) -> java.lang.Character.compare(keyExtractor.applyChar(x),
                    keyExtractor.applyChar(y));
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code short} sort key.
         * 
         * @param keyExtractor a function with a {@code short} parameter which returns a
         *                     {@code short}. This
         *                     is used to extract the {@code short} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code float} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfShort thenComparingShort(PrimitiveFunction.ToShort.OfShort keyExtractor) {
            return (OfShort & Serializable) (x, y) -> java.lang.Short.compare(keyExtractor.applyShort(x),
                    keyExtractor.applyShort(y));
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code byte} sort key.
         * 
         * @param keyExtractor a function with a {@code short} parameter which returns a
         *                     {@code byte}. This
         *                     is used to extract the {@code byte} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code byte} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfShort thenComparingByte(PrimitiveFunction.ToByte.OfShort keyExtractor) {
            return (OfShort & Serializable) (x, y) -> java.lang.Byte.compare(keyExtractor.applyByte(x),
                    keyExtractor.applyByte(y));
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code boolean} sort key.
         * 
         * @param keyExtractor a function with a {@code short} parameter which returns a
         *                     {@code boolean}. This
         *                     is used to extract the {@code boolean} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code boolean} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfShort thenComparingBoolean(PrimitiveFunction.ToBoolean.OfShort keyExtractor) {
            return (OfShort & Serializable) (x, y) -> java.lang.Boolean.compare(keyExtractor.applyBoolean(x),
                    keyExtractor.applyBoolean(y));
        }
    }

    /**
     * A comparator for {@code byte} values. This is the comparator for {@code byte}
     * specialisations.
     * 
     * @see PrimitiveComparator
     */
    @FunctionalInterface
    interface OfByte extends PrimitiveComparator<java.lang.Byte> {
        /**
         * Compares the {@code byte} arguments for order
         * 
         * @param x the input to be compared
         * @param y the second input to be compared
         * @return a negative integer, zero, or a positive integer as the first argument
         *         is less than, equal to, or greater than the second.
         * @see Comparator#compare(Object, Object)
         * @apiNote This is recommended over the {@link #compare} as this is the
         *          specialised form
         */
        int compareByte(byte x, byte y);

        /**
         * The {@code byte} specialisation for {@link #reversed()}
         * @return the reversed order for this {@code OfByte} comparator
         * 
         * @see Comparator#reversed()
         */
        default OfByte reversedByte() {
            return reverseOrderByte(this);
        }

        @Override
        default Comparator<java.lang.Byte> reversed() {
            return reversedByte();
        }

        /**
         * {@inheritDoc}
         * 
         * @param x {@inheritDoc}
         * @param y {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote The default implementation calls and returns the value of
         *           {@link #compareByte}
         */
        @Override
        default int compare(java.lang.Byte x, java.lang.Byte y) {
            return compareByte(x, y);
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code byte} sort key.
         * 
         * @param keyExtractor a function with a {@code byte} parameter which returns a
         *                     {@code byte}. This
         *                     is used to extract the {@code double} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code byte} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         * @see Comparator#thenComparingDouble(java.util.function.ToDoubleFunction)
         */
        default OfByte thenComparingDouble(PrimitiveFunction.ToDouble.OfByte keyExtractor) {
            return (OfByte & Serializable) (x, y) -> java.lang.Double.compare(keyExtractor.applyDouble(x),
                    keyExtractor.applyDouble(y));
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code long} sort key.
         * 
         * @param keyExtractor a function with a {@code byte} parameter which returns a
         *                     {@code long}. This
         *                     is used to extract the {@code long} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code long} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         * @see Comparator#thenComparingLong(java.util.function.ToLongFunction)
         */
        default OfByte thenComparingLong(PrimitiveFunction.ToLong.OfByte keyExtractor) {
            return (OfByte & Serializable) (x, y) -> java.lang.Long.compare(keyExtractor.applyLong(x),
                    keyExtractor.applyLong(y));
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code int} sort key.
         * 
         * @param keyExtractor a function with a {@code byte} parameter which returns a
         *                     {@code int}. This
         *                     is used to extract the {@code int} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code int} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         * @see Comparator#thenComparingInt(java.util.function.ToIntFunction)
         */
        default OfByte thenComparingInt(PrimitiveFunction.ToInt.OfByte keyExtractor) {
            return (OfByte & Serializable) (x, y) -> java.lang.Integer.compare(keyExtractor.applyInt(x),
                    keyExtractor.applyInt(y));
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code float} sort key.
         * 
         * @param keyExtractor a function with a {@code byte} parameter which returns a
         *                     {@code float}. This
         *                     is used to extract the {@code float} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code float} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfByte thenComparingFloat(PrimitiveFunction.ToFloat.OfByte keyExtractor) {
            return (OfByte & Serializable) (x, y) -> java.lang.Float.compare(keyExtractor.applyFloat(x),
                    keyExtractor.applyFloat(y));
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code char} sort key.
         * 
         * @param keyExtractor a function with a {@code byte} parameter which returns a
         *                     {@code char}. This
         *                     is used to extract the {@code char} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code char} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfByte thenComparingChar(PrimitiveFunction.ToChar.OfByte keyExtractor) {
            return (OfByte & Serializable) (x, y) -> java.lang.Character.compare(keyExtractor.applyChar(x),
                    keyExtractor.applyChar(y));
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code short} sort key.
         * 
         * @param keyExtractor a function with a {@code byte} parameter which returns a
         *                     {@code short}. This
         *                     is used to extract the {@code short} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code float} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfByte thenComparingShort(PrimitiveFunction.ToShort.OfByte keyExtractor) {
            return (OfByte & Serializable) (x, y) -> java.lang.Short.compare(keyExtractor.applyShort(x),
                    keyExtractor.applyShort(y));
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code byte} sort key.
         * 
         * @param keyExtractor a function with a {@code byte} parameter which returns a
         *                     {@code byte}. This
         *                     is used to extract the {@code byte} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code byte} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfByte thenComparingByte(PrimitiveFunction.ToByte.OfByte keyExtractor) {
            return (OfByte & Serializable) (x, y) -> java.lang.Byte.compare(keyExtractor.applyByte(x),
                    keyExtractor.applyByte(y));
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code boolean} sort key.
         * 
         * @param keyExtractor a function with a {@code byte} parameter which returns a
         *                     {@code boolean}. This
         *                     is used to extract the {@code boolean} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code boolean} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfByte thenComparingBoolean(PrimitiveFunction.ToBoolean.OfByte keyExtractor) {
            return (OfByte & Serializable) (x, y) -> java.lang.Boolean.compare(keyExtractor.applyBoolean(x),
                    keyExtractor.applyBoolean(y));
        }
    }

    /**
     * A comparator for {@code boolean} values. This is the comparator for
     * {@code boolean} specialisations.
     * 
     * @see PrimitiveComparator
     */
    @FunctionalInterface
    interface OfBoolean extends PrimitiveComparator<java.lang.Boolean> {
        /**
         * Compares the {@code boolean} arguments for order
         * 
         * @param x the input to be compared
         * @param y the second input to be compared
         * @return a negative integer, zero, or a positive integer as the first argument
         *         is less than, equal to, or greater than the second.
         * @see Comparator#compare(Object, Object)
         * @apiNote This is recommended over the {@link #compare} as this is the
         *          specialised form
         */
        int compareBoolean(boolean x, boolean y);

        /**
         * The {@code boolean} specialisation for {@link #reversed()}
         * @return the reversed order for this {@code OfBoolean} comparator
         * 
         * @see Comparator#reversed()
         */
        default OfBoolean reversedBoolean() {
            return reverseOrderBoolean(this);
        }

        @Override
        default Comparator<java.lang.Boolean> reversed() {
            return reversedBoolean();
        }

        /**
         * {@inheritDoc}
         * 
         * @param x {@inheritDoc}
         * @param y {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote The default implementation calls and returns the value of
         *           {@link #compareBoolean}
         */
        @Override
        default int compare(java.lang.Boolean x, java.lang.Boolean y) {
            return compareBoolean(x, y);
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code boolean} sort key.
         * 
         * @param keyExtractor a function with a {@code boolean} parameter which returns
         *                     a {@code boolean}. This
         *                     is used to extract the {@code double} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code boolean} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         * @see Comparator#thenComparingDouble(java.util.function.ToDoubleFunction)
         */
        default OfBoolean thenComparingDouble(PrimitiveFunction.ToDouble.OfBoolean keyExtractor) {
            return (OfBoolean & Serializable) (x, y) -> java.lang.Double.compare(keyExtractor.applyDouble(x),
                    keyExtractor.applyDouble(y));
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code long} sort key.
         * 
         * @param keyExtractor a function with a {@code boolean} parameter which returns
         *                     a {@code long}. This
         *                     is used to extract the {@code long} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code long} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         * @see Comparator#thenComparingLong(java.util.function.ToLongFunction)
         */
        default OfBoolean thenComparingLong(PrimitiveFunction.ToLong.OfBoolean keyExtractor) {
            return (OfBoolean & Serializable) (x, y) -> java.lang.Long.compare(keyExtractor.applyLong(x),
                    keyExtractor.applyLong(y));
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code int} sort key.
         * 
         * @param keyExtractor a function with a {@code boolean} parameter which returns
         *                     a {@code int}. This
         *                     is used to extract the {@code int} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code int} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         * @see Comparator#thenComparingInt(java.util.function.ToIntFunction)
         */
        default OfBoolean thenComparingInt(PrimitiveFunction.ToInt.OfBoolean keyExtractor) {
            return (OfBoolean & Serializable) (x, y) -> java.lang.Integer.compare(keyExtractor.applyInt(x),
                    keyExtractor.applyInt(y));
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code float} sort key.
         * 
         * @param keyExtractor a function with a {@code boolean} parameter which returns
         *                     a {@code float}. This
         *                     is used to extract the {@code float} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code float} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfBoolean thenComparingFloat(PrimitiveFunction.ToFloat.OfBoolean keyExtractor) {
            return (OfBoolean & Serializable) (x, y) -> java.lang.Float.compare(keyExtractor.applyFloat(x),
                    keyExtractor.applyFloat(y));
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code char} sort key.
         * 
         * @param keyExtractor a function with a {@code boolean} parameter which returns
         *                     a {@code char}. This
         *                     is used to extract the {@code char} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code char} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfBoolean thenComparingChar(PrimitiveFunction.ToChar.OfBoolean keyExtractor) {
            return (OfBoolean & Serializable) (x, y) -> java.lang.Character.compare(keyExtractor.applyChar(x),
                    keyExtractor.applyChar(y));
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code short} sort key.
         * 
         * @param keyExtractor a function with a {@code boolean} parameter which returns
         *                     a {@code short}. This
         *                     is used to extract the {@code short} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code float} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfBoolean thenComparingShort(PrimitiveFunction.ToShort.OfBoolean keyExtractor) {
            return (OfBoolean & Serializable) (x, y) -> java.lang.Short.compare(keyExtractor.applyShort(x),
                    keyExtractor.applyShort(y));
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code byte} sort key.
         * 
         * @param keyExtractor a function with a {@code boolean} parameter which returns
         *                     a {@code byte}. This
         *                     is used to extract the {@code byte} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code byte} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfBoolean thenComparingByte(PrimitiveFunction.ToByte.OfBoolean keyExtractor) {
            return (OfBoolean & Serializable) (x, y) -> java.lang.Byte.compare(keyExtractor.applyByte(x),
                    keyExtractor.applyByte(y));
        }

        /**
         * Returns a lexicographic-order comparator with a function that extracts a
         * {@code boolean} sort key.
         * 
         * @param keyExtractor a function with a {@code boolean} parameter which returns
         *                     a {@code boolean}. This
         *                     is used to extract the {@code boolean} sort key
         * @return a lexicographic-order comparator composed of this and then the
         *         {@code boolean} sort key
         * @apiNote This part of a suite of methods that provide support for primitive
         *          forms
         *          of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfBoolean thenComparingBoolean(PrimitiveFunction.ToBoolean.OfBoolean keyExtractor) {
            return (OfBoolean & Serializable) (x, y) -> java.lang.Boolean.compare(keyExtractor.applyBoolean(x),
                    keyExtractor.applyBoolean(y));
        }
    }

    /**
     * Returns a lexicographic-order comparator with a function that extracts a
     * {@code double} sort key.
     * 
     * @param keyExtractor a function with a {@code <OF>} parameter which returns a
     *                     {@code double}. This
     *                     is used to extract the {@code double} sort key
     * @return a lexicographic-order comparator composed of this and then the
     *         {@code double} sort key
     * @apiNote This part of a suite of methods that provide support for primitive
     *          forms
     *          of {@link Comparator#thenComparing(java.util.function.Function)}
     * @see Comparator#thenComparing(java.util.function.Function)
     * @see Comparator#thenComparing(java.util.function.Function, Comparator)
     * @see Comparator#thenComparingDouble(java.util.function.ToDoubleFunction)
     */
    @SuppressWarnings("unchecked")
    default PrimitiveComparator<OF> thenComparingDouble(PrimitiveFunction.ToDouble<? super OF> keyExtractor) {
        return (PrimitiveComparator<OF> & Serializable) (x, y) -> java.lang.Double.compare(keyExtractor.applyDouble(x),
                keyExtractor.applyDouble(y));
    }

    /**
     * Returns a lexicographic-order comparator with a function that extracts a
     * {@code long} sort key.
     * 
     * @param keyExtractor a function with a {@code <OF>} parameter which returns a
     *                     {@code long}. This
     *                     is used to extract the {@code long} sort key
     * @return a lexicographic-order comparator composed of this and then the
     *         {@code long} sort key
     * @apiNote This part of a suite of methods that provide support for primitive
     *          forms
     *          of {@link Comparator#thenComparing(java.util.function.Function)}
     * @see Comparator#thenComparing(java.util.function.Function)
     * @see Comparator#thenComparing(java.util.function.Function, Comparator)
     * @see Comparator#thenComparingLong(java.util.function.ToLongFunction)
     */
    @SuppressWarnings("unchecked")
    default PrimitiveComparator<OF> thenComparingLong(PrimitiveFunction.ToLong<? super OF> keyExtractor) {
        return (PrimitiveComparator<OF> & Serializable) (x, y) -> java.lang.Long.compare(keyExtractor.applyLong(x),
                keyExtractor.applyLong(y));
    }

    /**
     * Returns a lexicographic-order comparator with a function that extracts an
     * {@code int} sort key.
     * 
     * @param keyExtractor a function with a {@code <OF>} parameter which returns an
     *                     {@code int}. This
     *                     is used to extract the {@code int} sort key
     * @return a lexicographic-order comparator composed of this and then the
     *         {@code int} sort key
     * @apiNote This part of a suite of methods that provide support for primitive
     *          forms
     *          of {@link Comparator#thenComparing(java.util.function.Function)}
     * @see Comparator#thenComparing(java.util.function.Function)
     * @see Comparator#thenComparing(java.util.function.Function, Comparator)
     * @see Comparator#thenComparingInt(java.util.function.ToIntFunction)
     */
    @SuppressWarnings("unchecked")
    default PrimitiveComparator<OF> thenComparingInt(PrimitiveFunction.ToInt<? super OF> keyExtractor) {
        return (PrimitiveComparator<OF> & Serializable) (x, y) -> java.lang.Integer.compare(keyExtractor.applyInt(x),
                keyExtractor.applyInt(y));
    }

    /**
     * Returns a lexicographic-order comparator with a function that extracts a
     * {@code float} sort key.
     * 
     * @param keyExtractor a function with a {@code <OF>} parameter which returns a
     *                     {@code float}. This
     *                     is used to extract the {@code float} sort key
     * @return a lexicographic-order comparator composed of this and then the
     *         {@code float} sort key
     * @apiNote This part of a suite of methods that provide support for primitive
     *          forms
     *          of {@link Comparator#thenComparing(java.util.function.Function)}
     * @see Comparator#thenComparing(java.util.function.Function)
     * @see Comparator#thenComparing(java.util.function.Function, Comparator)
     */
    @SuppressWarnings("unchecked")
    default PrimitiveComparator<OF> thenComparingFloat(PrimitiveFunction.ToFloat<? super OF> keyExtractor) {
        return (PrimitiveComparator<OF> & Serializable) (x, y) -> java.lang.Float.compare(keyExtractor.applyFloat(x),
                keyExtractor.applyFloat(y));
    }

    /**
     * Returns a lexicographic-order comparator with a function that extracts a
     * {@code char} sort key.
     * 
     * @param keyExtractor a function with a {@code <OF>} parameter which returns a
     *                     {@code char}. This
     *                     is used to extract the {@code char} sort key
     * @return a lexicographic-order comparator composed of this and then the
     *         {@code char} sort key
     * @apiNote This part of a suite of methods that provide support for primitive
     *          forms
     *          of {@link Comparator#thenComparing(java.util.function.Function)}
     * @see Comparator#thenComparing(java.util.function.Function)
     * @see Comparator#thenComparing(java.util.function.Function, Comparator)
     */
    @SuppressWarnings("unchecked")
    default PrimitiveComparator<OF> thenComparingChar(PrimitiveFunction.ToChar<? super OF> keyExtractor) {
        return (PrimitiveComparator<OF> & Serializable) (x, y) -> java.lang.Character.compare(keyExtractor.applyChar(x),
                keyExtractor.applyChar(y));
    }

    /**
     * Returns a lexicographic-order comparator with a function that extracts a
     * {@code short} sort key.
     * 
     * @param keyExtractor a function with a {@code <OF>} parameter which returns a
     *                     {@code short}. This
     *                     is used to extract the {@code short} sort key
     * @return a lexicographic-order comparator composed of this and then the
     *         {@code short} sort key
     * @apiNote This part of a suite of methods that provide support for primitive
     *          forms
     *          of {@link Comparator#thenComparing(java.util.function.Function)}
     * @see Comparator#thenComparing(java.util.function.Function)
     * @see Comparator#thenComparing(java.util.function.Function, Comparator)
     */
    @SuppressWarnings("unchecked")
    default PrimitiveComparator<OF> thenComparingShort(PrimitiveFunction.ToShort<? super OF> keyExtractor) {
        return (PrimitiveComparator<OF> & Serializable) (x, y) -> java.lang.Short.compare(keyExtractor.applyShort(x),
                keyExtractor.applyShort(y));
    }

    /**
     * Returns a lexicographic-order comparator with a function that extracts a
     * {@code byte} sort key.
     * 
     * @param keyExtractor a function with a {@code <OF>} parameter which returns a
     *                     {@code byte}. This
     *                     is used to extract the {@code byte} sort key
     * @return a lexicographic-order comparator composed of this and then the
     *         {@code byte} sort key
     * @apiNote This part of a suite of methods that provide support for primitive
     *          forms
     *          of {@link Comparator#thenComparing(java.util.function.Function)}
     * @see Comparator#thenComparing(java.util.function.Function)
     * @see Comparator#thenComparing(java.util.function.Function, Comparator)
     */
    @SuppressWarnings("unchecked")
    default PrimitiveComparator<OF> thenComparingByte(PrimitiveFunction.ToByte<? super OF> keyExtractor) {
        return (PrimitiveComparator<OF> & Serializable) (x, y) -> java.lang.Byte.compare(keyExtractor.applyByte(x),
                keyExtractor.applyByte(y));
    }

    /**
     * Returns a lexicographic-order comparator with a function that extracts a
     * {@code boolean} sort key.
     * 
     * @param keyExtractor a function with a {@code <OF>} parameter which returns a
     *                     {@code boolean}. This
     *                     is used to extract the {@code boolean} sort key
     * @return a lexicographic-order comparator composed of this and then the
     *         {@code boolean} sort key
     * @apiNote This part of a suite of methods that provide support for primitive
     *          forms
     *          of {@link Comparator#thenComparing(java.util.function.Function)}
     * @see Comparator#thenComparing(java.util.function.Function)
     * @see Comparator#thenComparing(java.util.function.Function, Comparator)
     */
    @SuppressWarnings("unchecked")
    default PrimitiveComparator<OF> thenComparingBoolean(PrimitiveFunction.ToBoolean<? super OF> keyExtractor) {
        return (PrimitiveComparator<OF> & Serializable) (x, y) -> java.lang.Boolean
                .compare(keyExtractor.applyBoolean(x), keyExtractor.applyBoolean(y));
    }

    /**
     * Returns the naturally occuring comparator for {@code double} values
     * whereby {@link java.lang.Double#compare(double, double)} is used
     * @return a {@link OfDouble} comparator that imposes <i>natural ordering</i>
     * on {@code double} values.
     * @see java.lang.Double#compare(double, double)
     * @see Comparator#naturalOrder()
     */
    static OfDouble naturalOrderDouble() {
        return NaturalDouble.INSTANCE;
    }
    /**
     * Returns the naturally occuring comparator for {@code long} values
     * whereby {@link java.lang.Long#compare(long, long)} is used
     * @return a {@link OfLong} comparator that imposes <i>natural ordering</i>
     * on {@code long} values.
     * @see java.lang.Long#compare(long, long)
     * @see Comparator#naturalOrder()
     */
    static OfLong naturalOrderLong() {
        return NaturalLong.INSTANCE;
    }
    /**
     * Returns the naturally occuring comparator for {@code int} values
     * whereby {@link java.lang.Integer#compare(int, int)} is used
     * @return a {@link OfInt} comparator that imposes <i>natural ordering</i>
     * on {@code int} values.
     * @see java.lang.Int#compare(int, int)
     * @see Comparator#naturalOrder()
     */
    static OfInt naturalOrderInt() {
        return NaturalInt.INSTANCE;
    }
    /**
     * Returns the naturally occuring comparator for {@code float} values
     * whereby {@link java.lang.Float#compare(float, float)} is used
     * @return a {@link OfFloat} comparator that imposes <i>natural ordering</i>
     * on {@code float} values.
     * @see java.lang.Float#compare(float, float)
     * @see Comparator#naturalOrder()
     */
    static OfFloat naturalOrderFloat() {
        return NaturalFloat.INSTANCE;
    }
    /**
     * Returns the naturally occuring comparator for {@code char} values
     * whereby {@link java.lang.Character#compare(char, char)} is used
     * @return a {@link OfChar} comparator that imposes <i>natural ordering</i>
     * on {@code char} values.
     * @see java.lang.Char#compare(char, char)
     * @see Comparator#naturalOrder()
     */
    static OfChar naturalOrderChar() {
        return NaturalChar.INSTANCE;
    }
    /**
     * Returns the naturally occuring comparator for {@code short} values
     * whereby {@link java.lang.Short#compare(short, short)} is used
     * @return a {@link OfShort} comparator that imposes <i>natural ordering</i>
     * on {@code short} values.
     * @see java.lang.Short#compare(short, short)
     * @see Comparator#naturalOrder()
     */
    static OfShort naturalOrderShort() {
        return NaturalShort.INSTANCE;
    }
    /**
     * Returns the naturally occuring comparator for {@code byte} values
     * whereby {@link java.lang.Byte#compare(byte, byte)} is used
     * @return a {@link OfByte} comparator that imposes <i>natural ordering</i>
     * on {@code byte} values.
     * @see java.lang.Byte#compare(byte, byte)
     * @see Comparator#naturalOrder()
     */
    static OfByte naturalOrderByte() {
        return NaturalByte.INSTANCE;
    }
    /**
     * Returns the naturally occuring comparator for {@code boolean} values
     * whereby {@link java.lang.Boolean#compare(boolean, boolean)} is used
     * @return a {@link OfBoolean} comparator that imposes <i>natural ordering</i>
     * on {@code boolean} values.
     * @see java.lang.Boolean#compare(boolean, boolean)
     * @see Comparator#naturalOrder()
     */
    static OfBoolean naturalOrderBoolean() {
        return NaturalBoolean.INSTANCE;
    }

    /**
     * Returns a {@link OfDouble} comparator that imposes the reverse <i>natural ordering</i>.
     * @return a {@code OfDouble} comparator that imposes <i>reverse natural ordering</i> on
     * {@code double} values.
     * 
     * @see Comparator#reverseOrder()
     */
    static OfDouble reverseOrderDouble() {
        return RevDouble.REV_DOUBLE;
    }
    /**
     * Returns a {@link OfLong} comparator that imposes the reverse <i>natural ordering</i>.
     * @return a {@code OfLong} comparator that imposes <i>reverse natural ordering</i> on
     * {@code long} values.
     * 
     * @see Comparator#reverseOrder()
     */
    static OfLong reverseOrderLong() {
        return RevLong.REV_LONG;
    }
    /**
     * Returns a {@link OfInt} comparator that imposes the reverse <i>natural ordering</i>.
     * @return a {@code OfInt} comparator that imposes <i>reverse natural ordering</i> on
     * {@code int} values.
     * 
     * @see Comparator#reverseOrder()
     */
    static OfInt reverseOrderInt() {
        return RevInt.REV_INT;
    }
    /**
     * Returns a {@link OfFloat} comparator that imposes the reverse <i>natural ordering</i>.
     * @return a {@code OfFloat} comparator that imposes <i>reverse natural ordering</i> on
     * {@code float} values.
     * 
     * @see Comparator#reverseOrder()
     */
    static OfFloat reverseOrderFloat() {
        return RevFloat.REV_FLOAT;
    }
    /**
     * Returns a {@link OfChar} comparator that imposes the reverse <i>natural ordering</i>.
     * @return a {@code OfChar} comparator that imposes <i>reverse natural ordering</i> on
     * {@code char} values.
     * 
     * @see Comparator#reverseOrder()
     */
    static OfChar reverseOrderChar() {
        return RevChar.REV_CHAR;
    }
    /**
     * Returns a {@link OfShort} comparator that imposes the reverse <i>natural ordering</i>.
     * @return a {@code OfShort} comparator that imposes <i>reverse natural ordering</i> on
     * {@code short} values.
     * 
     * @see Comparator#reverseOrder()
     */
    static OfShort reverseOrderShort() {
        return RevShort.REV_SHORT;
    }
    /**
     * Returns a {@link OfByte} comparator that imposes the reverse <i>natural ordering</i>.
     * @return a {@code OfByte} comparator that imposes <i>reverse natural ordering</i> on
     * {@code byte} values.
     * 
     * @see Comparator#reverseOrder()
     */
    static OfByte reverseOrderByte() {
        return RevByte.REV_BYTE;
    }
    /**
     * Returns a {@link OfBoolean} comparator that imposes the reverse <i>natural ordering</i>.
     * @return a {@code OfBoolean} comparator that imposes <i>reverse natural ordering</i> on
     * {@code boolean} values.
     * 
     * @see Comparator#reverseOrder()
     */
    static OfBoolean reverseOrderBoolean() {
        return RevBoolean.REV_BOOLEAN;
    }
    /**
     * Reverses the order of the given {@link OfDouble} comparator and returns the result.
     * @param c the comparator whose reversal is to be computed
     * @return the reversal of the input comparator
     * 
     * @see java.util.Collections#reverseOrder(Comparator)
     */
    static OfDouble reverseOrderDouble(OfDouble c) {
        if(c == null || c == NaturalDouble.INSTANCE) return RevDouble.REV_DOUBLE;
        if(c == RevDouble.REV_DOUBLE) return NaturalDouble.INSTANCE;
        if(c instanceof ComposedRevDouble comp) return comp.imp;
        return new ComposedRevDouble(c);
    }
    /**
     * Reverses the order of the given {@link OfLong} comparator and returns the result.
     * @param c the comparator whose reversal is to be computed
     * @return the reversal of the input comparator
     * 
     * @see java.util.Collections#reverseOrder(Comparator)
     */
    static OfLong reverseOrderLong(OfLong c) {
        if(c == null || c == NaturalLong.INSTANCE) return RevLong.REV_LONG;
        if(c == RevLong.REV_LONG) return NaturalLong.INSTANCE;
        if(c instanceof ComposedRevLong comp) return comp.imp;
        return new ComposedRevLong(c);
    }
    /**
     * Reverses the order of the given {@link OfInt} comparator and returns the result.
     * @param c the comparator whose reversal is to be computed
     * @return the reversal of the input comparator
     * 
     * @see java.util.Collections#reverseOrder(Comparator)
     */
    static OfInt reverseOrderInt(OfInt c) {
        if(c == null || c == NaturalInt.INSTANCE) return RevInt.REV_INT;
        if(c == RevInt.REV_INT) return NaturalInt.INSTANCE;
        if(c instanceof ComposedRevInt comp) return comp.imp;
        return new ComposedRevInt(c);
    }
    /**
     * Reverses the order of the given {@link OfFloat} comparator and returns the result.
     * @param c the comparator whose reversal is to be computed
     * @return the reversal of the input comparator
     * 
     * @see java.util.Collections#reverseOrder(Comparator)
     */
    static OfFloat reverseOrderFloat(OfFloat c) {
        if(c == null || c == NaturalFloat.INSTANCE) return RevFloat.REV_FLOAT;
        if(c == RevFloat.REV_FLOAT) return NaturalFloat.INSTANCE;
        if(c instanceof ComposedRevFloat comp) return comp.imp;
        return new ComposedRevFloat(c);
    }
    /**
     * Reverses the order of the given {@link OfChar} comparator and returns the result.
     * @param c the comparator whose reversal is to be computed
     * @return the reversal of the input comparator
     * 
     * @see java.util.Collections#reverseOrder(Comparator)
     */
    static OfChar reverseOrderChar(OfChar c) {
        if(c == null || c == NaturalChar.INSTANCE) return RevChar.REV_CHAR;
        if(c == RevChar.REV_CHAR) return NaturalChar.INSTANCE;
        if(c instanceof ComposedRevChar comp) return comp.imp;
        return new ComposedRevChar(c);
    }
    /**
     * Reverses the order of the given {@link OfShort} comparator and returns the result.
     * @param c the comparator whose reversal is to be computed
     * @return the reversal of the input comparator
     * 
     * @see java.util.Collections#reverseOrder(Comparator)
     */
    static OfShort reverseOrderShort(OfShort c) {
        if(c == null || c == NaturalShort.INSTANCE) return RevShort.REV_SHORT;
        if(c == RevShort.REV_SHORT) return NaturalShort.INSTANCE;
        if(c instanceof ComposedRevShort comp) return comp.imp;
        return new ComposedRevShort(c);
    }
    /**
     * Reverses the order of the given {@link OfByte} comparator and returns the result.
     * @param c the comparator whose reversal is to be computed
     * @return the reversal of the input comparator
     * 
     * @see java.util.Collections#reverseOrder(Comparator)
     */
    static OfByte reverseOrderByte(OfByte c) {
        if(c == null || c == NaturalByte.INSTANCE) return RevByte.REV_BYTE;
        if(c == RevByte.REV_BYTE) return NaturalByte.INSTANCE;
        if(c instanceof ComposedRevByte comp) return comp.imp;
        return new ComposedRevByte(c);
    }
    /**
     * Reverses the order of the given {@link OfBoolean} comparator and returns the result.
     * @param c the comparator whose reversal is to be computed
     * @return the reversal of the input comparator
     * 
     * @see java.util.Collections#reverseOrder(Comparator)
     */
    static OfBoolean reverseOrderBoolean(OfBoolean c) {
        if(c == null || c == NaturalBoolean.INSTANCE) return RevBoolean.REV_BOOLEAN;
        if(c == RevBoolean.REV_BOOLEAN) return NaturalBoolean.INSTANCE;
        if(c instanceof ComposedRevBoolean comp) return comp.imp;
        return new ComposedRevBoolean(c);
    }
}
enum NaturalDouble implements PrimitiveComparator.OfDouble {
    INSTANCE;
    public int compareDouble(double x, double y) {
        return java.lang.Double.compare(x, y);
    }
    @Override
    public OfDouble reversedDouble() {
        return PrimitiveComparator.reverseOrderDouble();
    }
}
class RevDouble implements PrimitiveComparator.OfDouble, Serializable { 
    @java.io.Serial
    private static final long serialVersionUID = 1021274946291973279L;
    static final RevDouble REV_DOUBLE = new RevDouble();
    public int compareDouble(double x, double y) {
        return java.lang.Double.compare(y, x);
    }
    @java.io.Serial
    private Object readResolve() { return PrimitiveComparator.reverseOrderDouble(); }

    @Override
    public OfDouble reversedDouble() {
        return PrimitiveComparator.naturalOrderDouble();
    }
}
class ComposedRevDouble implements PrimitiveComparator.OfDouble {
    OfDouble imp;
    ComposedRevDouble(OfDouble imp) {
        this.imp = imp;
    }
    public int compareDouble(double x, double y) {
        int c = imp.compareDouble(x, y);
        return c > 0 ? -1 : c < 0 ? 1 : 0;
    }
}
enum NaturalLong implements PrimitiveComparator.OfLong {
    INSTANCE;
    public int compareLong(long x, long y) {
        return java.lang.Long.compare(x, y);
    }
    @Override
    public OfLong reversedLong() {
        return PrimitiveComparator.reverseOrderLong();
    }
}
class RevLong implements PrimitiveComparator.OfLong, Serializable { 
    @java.io.Serial
    private static final long serialVersionUID = 1021274946291973279L;
    static final RevLong REV_LONG = new RevLong();
    public int compareLong(long x, long y) {
        return java.lang.Long.compare(y, x);
    }
    @java.io.Serial
    private Object readResolve() { return PrimitiveComparator.reverseOrderLong(); }

    @Override
    public OfLong reversedLong() {
        return PrimitiveComparator.naturalOrderLong();
    }
}
class ComposedRevLong implements PrimitiveComparator.OfLong {
    OfLong imp;
    ComposedRevLong(OfLong imp) {
        this.imp = imp;
    }
    public int compareLong(long x, long y) {
        int c = imp.compareLong(x, y);
        return c > 0 ? -1 : c < 0 ? 1 : 0;
    }
}
enum NaturalInt implements PrimitiveComparator.OfInt {
    INSTANCE;
    public int compareInt(int x, int y) {
        return java.lang.Integer.compare(x, y);
    }
    @Override
    public OfInt reversedInt() {
        return PrimitiveComparator.reverseOrderInt();
    }
}
class RevInt implements PrimitiveComparator.OfInt, Serializable {   
    @java.io.Serial
    private static final long serialVersionUID = 1021274946291973279L;
    static final RevInt REV_INT = new RevInt();
    public int compareInt(int x, int y) {
        return java.lang.Integer.compare(y, x);
    }
    @java.io.Serial
    private Object readResolve() { return PrimitiveComparator.reverseOrderInt(); }

    @Override
    public OfInt reversedInt() {
        return PrimitiveComparator.naturalOrderInt();
    }
}
class ComposedRevInt implements PrimitiveComparator.OfInt {
    OfInt imp;
    ComposedRevInt(OfInt imp) {
        this.imp = imp;
    }
    public int compareInt(int x, int y) {
        int c = imp.compareInt(x, y);
        return c > 0 ? -1 : c < 0 ? 1 : 0;
    }
}
enum NaturalFloat implements PrimitiveComparator.OfFloat {
    INSTANCE;
    public int compareFloat(float x, float y) {
        return java.lang.Float.compare(x, y);
    }
    @Override
    public OfFloat reversedFloat() {
        return PrimitiveComparator.reverseOrderFloat();
    }
}
class RevFloat implements PrimitiveComparator.OfFloat, Serializable {   
    @java.io.Serial
    private static final long serialVersionUID = 1021274946291973279L;
    static final RevFloat REV_FLOAT = new RevFloat();
    public int compareFloat(float x, float y) {
        return java.lang.Float.compare(y, x);
    }
    @java.io.Serial
    private Object readResolve() { return PrimitiveComparator.reverseOrderFloat(); }

    @Override
    public OfFloat reversedFloat() {
        return PrimitiveComparator.naturalOrderFloat();
    }
}
class ComposedRevFloat implements PrimitiveComparator.OfFloat {
    OfFloat imp;
    ComposedRevFloat(OfFloat imp) {
        this.imp = imp;
    }
    public int compareFloat(float x, float y) {
        int c = imp.compareFloat(x, y);
        return c > 0 ? -1 : c < 0 ? 1 : 0;
    }
}
enum NaturalChar implements PrimitiveComparator.OfChar {
    INSTANCE;
    public int compareChar(char x, char y) {
        return java.lang.Character.compare(x, y);
    }
    @Override
    public OfChar reversedChar() {
        return PrimitiveComparator.reverseOrderChar();
    }
}
class RevChar implements PrimitiveComparator.OfChar, Serializable { 
    @java.io.Serial
    private static final long serialVersionUID = 1021274946291973279L;
    static final RevChar REV_CHAR = new RevChar();
    public int compareChar(char x, char y) {
        return java.lang.Character.compare(y, x);
    }
    @java.io.Serial
    private Object readResolve() { return PrimitiveComparator.reverseOrderChar(); }

    @Override
    public OfChar reversedChar() {
        return PrimitiveComparator.naturalOrderChar();
    }
}
class ComposedRevChar implements PrimitiveComparator.OfChar {
    OfChar imp;
    ComposedRevChar(OfChar imp) {
        this.imp = imp;
    }
    public int compareChar(char x, char y) {
        int c = imp.compareChar(x, y);
        return c > 0 ? -1 : c < 0 ? 1 : 0;
    }
}
enum NaturalShort implements PrimitiveComparator.OfShort {
    INSTANCE;
    public int compareShort(short x, short y) {
        return java.lang.Short.compare(x, y);
    }
    @Override
    public OfShort reversedShort() {
        return PrimitiveComparator.reverseOrderShort();
    }
}
class RevShort implements PrimitiveComparator.OfShort, Serializable {   
    @java.io.Serial
    private static final long serialVersionUID = 1021274946291973279L;
    static final RevShort REV_SHORT = new RevShort();
    public int compareShort(short x, short y) {
        return java.lang.Short.compare(y, x);
    }
    @java.io.Serial
    private Object readResolve() { return PrimitiveComparator.reverseOrderShort(); }

    @Override
    public OfShort reversedShort() {
        return PrimitiveComparator.naturalOrderShort();
    }
}
class ComposedRevShort implements PrimitiveComparator.OfShort {
    OfShort imp;
    ComposedRevShort(OfShort imp) {
        this.imp = imp;
    }
    public int compareShort(short x, short y) {
        int c = imp.compareShort(x, y);
        return c > 0 ? -1 : c < 0 ? 1 : 0;
    }
}
enum NaturalByte implements PrimitiveComparator.OfByte {
    INSTANCE;
    public int compareByte(byte x, byte y) {
        return java.lang.Byte.compare(x, y);
    }
    @Override
    public OfByte reversedByte() {
        return PrimitiveComparator.reverseOrderByte();
    }
}
class RevByte implements PrimitiveComparator.OfByte, Serializable { 
    @java.io.Serial
    private static final long serialVersionUID = 1021274946291973279L;
    static final RevByte REV_BYTE = new RevByte();
    public int compareByte(byte x, byte y) {
        return java.lang.Byte.compare(y, x);
    }
    @java.io.Serial
    private Object readResolve() { return PrimitiveComparator.reverseOrderByte(); }

    @Override
    public OfByte reversedByte() {
        return PrimitiveComparator.naturalOrderByte();
    }
}
class ComposedRevByte implements PrimitiveComparator.OfByte {
    OfByte imp;
    ComposedRevByte(OfByte imp) {
        this.imp = imp;
    }
    public int compareByte(byte x, byte y) {
        int c = imp.compareByte(x, y);
        return c > 0 ? -1 : c < 0 ? 1 : 0;
    }
}
enum NaturalBoolean implements PrimitiveComparator.OfBoolean {
    INSTANCE;
    public int compareBoolean(boolean x, boolean y) {
        return java.lang.Boolean.compare(x, y);
    }
    @Override
    public OfBoolean reversedBoolean() {
        return PrimitiveComparator.reverseOrderBoolean();
    }
}
class RevBoolean implements PrimitiveComparator.OfBoolean, Serializable {   
    @java.io.Serial
    private static final long serialVersionUID = 1021274946291973279L;
    static final RevBoolean REV_BOOLEAN = new RevBoolean();
    public int compareBoolean(boolean x, boolean y) {
        return java.lang.Boolean.compare(y, x);
    }
    @java.io.Serial
    private Object readResolve() { return PrimitiveComparator.reverseOrderBoolean(); }

    @Override
    public OfBoolean reversedBoolean() {
        return PrimitiveComparator.naturalOrderBoolean();
    }
}
class ComposedRevBoolean implements PrimitiveComparator.OfBoolean {
    OfBoolean imp;
    ComposedRevBoolean(OfBoolean imp) {
        this.imp = imp;
    }
    public int compareBoolean(boolean x, boolean y) {
        int c = imp.compareBoolean(x, y);
        return c > 0 ? -1 : c < 0 ? 1 : 0;
    }
}
