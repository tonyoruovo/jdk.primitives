package jdk.prim;

import java.io.Serializable;
import java.util.Comparator;
import jdk.prim.util.function.PrimitiveFunction;

/**
 * An interface that provides primitive support for the {@code Comparator} interface.
 * Support exists for a primitive for every parameter and every case.
 * 
 * <p>
 * It also defines primitive alternatives for {@link #thenComparing(Function)}.
 * <p>
 * It uses the following interface naming convention: {@code Of*} refers to the first and second argument
 * as a primitive.
 * <p>
 * Note that no exception handling is done on any of the methods ({@code default} or otherwise)
 * in these interfaces. If an exception is thrown in any method, the behaviour of that method will
 * be similar to it's JDK super interface.
 * 
 * @param <OF> the first argument to {@link #compare(Object)}
 * 
 * @see Comparator
 */
@FunctionalInterface
public interface PrimitiveComparator<OF> extends Comparator<OF> {

    /**
     * A comparator for {@code double} values. This is the comparator for {@code double} specialisations.
     * @see PrimitiveComparator
     */
    @FunctionalInterface
    interface OfDouble extends PrimitiveComparator<java.lang.Double> {
        /**
         * Compares the {@code double} arguments for order
         * @param x the input to be compared
         * @param y the second input to be compared
         * @return a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.
         * @see Comparator#compare(Object, Object)
         * @apiNote This is recommended over the {@link #compare} as this is the specialised form
         */
        int compareDouble(double x, double y);
        /**
         * {@inheritDoc}
         * @param x {@inheritDoc}
         * @param y {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote The default implementation calls and returns the value of {@link #compareDouble}
         */
        @Override default int compare(java.lang.Double x, java.lang.Double y) { return compareDouble(x, y); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code double} sort key.
         * @param keyExtractor a function with a {@code double} parameter which returns a {@code double}. This
         * is used to extract the {@code double} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code double} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         * @see Comparator#thenComparingDouble(java.util.function.ToDoubleFunction)
         */
        default OfDouble thenComparingDouble(PrimitiveFunction.ToDouble.OfDouble keyExtractor) { return (OfDouble & Serializable) (x, y) -> java.lang.Double.compare(keyExtractor.applyDouble(x), keyExtractor.applyDouble(y)); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code long} sort key.
         * @param keyExtractor a function with a {@code double} parameter which returns a {@code long}. This
         * is used to extract the {@code long} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code long} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         * @see Comparator#thenComparingLong(java.util.function.ToLongFunction)
         */
        default OfDouble thenComparingLong(PrimitiveFunction.ToLong.OfDouble keyExtractor) { return (OfDouble & Serializable) (x, y) -> java.lang.Long.compare(keyExtractor.applyLong(x), keyExtractor.applyLong(y)); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code int} sort key.
         * @param keyExtractor a function with a {@code double} parameter which returns a {@code int}. This
         * is used to extract the {@code int} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code int} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         * @see Comparator#thenComparingInt(java.util.function.ToIntFunction)
         */
        default OfDouble thenComparingInt(PrimitiveFunction.ToInt.OfDouble keyExtractor) { return (OfDouble & Serializable) (x, y) -> java.lang.Integer.compare(keyExtractor.applyInt(x), keyExtractor.applyInt(y)); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code float} sort key.
         * @param keyExtractor a function with a {@code double} parameter which returns a {@code float}. This
         * is used to extract the {@code float} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code float} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfDouble thenComparingFloat(PrimitiveFunction.ToFloat.OfDouble keyExtractor) { return (OfDouble & Serializable) (x, y) -> java.lang.Float.compare(keyExtractor.applyFloat(x), keyExtractor.applyFloat(y)); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code char} sort key.
         * @param keyExtractor a function with a {@code double} parameter which returns a {@code char}. This
         * is used to extract the {@code char} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code char} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfDouble thenComparingChar(PrimitiveFunction.ToChar.OfDouble keyExtractor) { return (OfDouble & Serializable) (x, y) -> java.lang.Character.compare(keyExtractor.applyChar(x), keyExtractor.applyChar(y)); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code short} sort key.
         * @param keyExtractor a function with a {@code double} parameter which returns a {@code short}. This
         * is used to extract the {@code short} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code float} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfDouble thenComparingShort(PrimitiveFunction.ToShort.OfDouble keyExtractor) { return (OfDouble & Serializable) (x, y) -> java.lang.Short.compare(keyExtractor.applyShort(x), keyExtractor.applyShort(y)); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code byte} sort key.
         * @param keyExtractor a function with a {@code double} parameter which returns a {@code byte}. This
         * is used to extract the {@code byte} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code byte} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfDouble thenComparingByte(PrimitiveFunction.ToByte.OfDouble keyExtractor) { return (OfDouble & Serializable) (x, y) -> java.lang.Byte.compare(keyExtractor.applyByte(x), keyExtractor.applyByte(y)); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code boolean} sort key.
         * @param keyExtractor a function with a {@code double} parameter which returns a {@code boolean}. This
         * is used to extract the {@code boolean} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code boolean} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfDouble thenComparingBoolean(PrimitiveFunction.ToBoolean.OfDouble keyExtractor) { return (OfDouble & Serializable) (x, y) -> java.lang.Boolean.compare(keyExtractor.applyBoolean(x), keyExtractor.applyBoolean(y)); }
    }
    /**
     * A comparator for {@code long} values. This is the comparator for {@code long} specialisations.
     * @see PrimitiveComparator
     */
    @FunctionalInterface
    interface OfLong extends PrimitiveComparator<java.lang.Long> {
        /**
         * Compares the {@code long} arguments for order
         * @param x the input to be compared
         * @param y the second input to be compared
         * @return a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.
         * @see Comparator#compare(Object, Object)
         * @apiNote This is recommended over the {@link #compare} as this is the specialised form
         */
        int compareLong(long x, long y);
        /**
         * {@inheritDoc}
         * @param x {@inheritDoc}
         * @param y {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote The default implementation calls and returns the value of {@link #compareLong}
         */
        @Override default int compare(java.lang.Long x, java.lang.Long y) { return compareLong(x, y); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code long} sort key.
         * @param keyExtractor a function with a {@code long} parameter which returns a {@code long}. This
         * is used to extract the {@code double} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code long} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         * @see Comparator#thenComparingDouble(java.util.function.ToDoubleFunction)
         */
        default OfLong thenComparingDouble(PrimitiveFunction.ToDouble.OfLong keyExtractor) { return (OfLong & Serializable) (x, y) -> java.lang.Double.compare(keyExtractor.applyDouble(x), keyExtractor.applyDouble(y)); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code long} sort key.
         * @param keyExtractor a function with a {@code long} parameter which returns a {@code long}. This
         * is used to extract the {@code long} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code long} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         * @see Comparator#thenComparingLong(java.util.function.ToLongFunction)
         */
        default OfLong thenComparingLong(PrimitiveFunction.ToLong.OfLong keyExtractor) { return (OfLong & Serializable) (x, y) -> java.lang.Long.compare(keyExtractor.applyLong(x), keyExtractor.applyLong(y)); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code int} sort key.
         * @param keyExtractor a function with a {@code long} parameter which returns a {@code int}. This
         * is used to extract the {@code int} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code int} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         * @see Comparator#thenComparingInt(java.util.function.ToIntFunction)
         */
        default OfLong thenComparingInt(PrimitiveFunction.ToInt.OfLong keyExtractor) { return (OfLong & Serializable) (x, y) -> java.lang.Integer.compare(keyExtractor.applyInt(x), keyExtractor.applyInt(y)); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code float} sort key.
         * @param keyExtractor a function with a {@code long} parameter which returns a {@code float}. This
         * is used to extract the {@code float} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code float} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfLong thenComparingFloat(PrimitiveFunction.ToFloat.OfLong keyExtractor) { return (OfLong & Serializable) (x, y) -> java.lang.Float.compare(keyExtractor.applyFloat(x), keyExtractor.applyFloat(y)); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code char} sort key.
         * @param keyExtractor a function with a {@code long} parameter which returns a {@code char}. This
         * is used to extract the {@code char} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code char} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfLong thenComparingChar(PrimitiveFunction.ToChar.OfLong keyExtractor) { return (OfLong & Serializable) (x, y) -> java.lang.Character.compare(keyExtractor.applyChar(x), keyExtractor.applyChar(y)); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code short} sort key.
         * @param keyExtractor a function with a {@code long} parameter which returns a {@code short}. This
         * is used to extract the {@code short} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code float} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfLong thenComparingShort(PrimitiveFunction.ToShort.OfLong keyExtractor) { return (OfLong & Serializable) (x, y) -> java.lang.Short.compare(keyExtractor.applyShort(x), keyExtractor.applyShort(y)); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code byte} sort key.
         * @param keyExtractor a function with a {@code long} parameter which returns a {@code byte}. This
         * is used to extract the {@code byte} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code byte} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfLong thenComparingByte(PrimitiveFunction.ToByte.OfLong keyExtractor) { return (OfLong & Serializable) (x, y) -> java.lang.Byte.compare(keyExtractor.applyByte(x), keyExtractor.applyByte(y)); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code boolean} sort key.
         * @param keyExtractor a function with a {@code long} parameter which returns a {@code boolean}. This
         * is used to extract the {@code boolean} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code boolean} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfLong thenComparingBoolean(PrimitiveFunction.ToBoolean.OfLong keyExtractor) { return (OfLong & Serializable) (x, y) -> java.lang.Boolean.compare(keyExtractor.applyBoolean(x), keyExtractor.applyBoolean(y)); }
    }
    /**
     * A comparator for {@code int} values. This is the comparator for {@code int} specialisations.
     * @see PrimitiveComparator
     */
    @FunctionalInterface
    interface OfInt extends PrimitiveComparator<java.lang.Integer> {
        /**
         * Compares the {@code int} arguments for order
         * @param x the input to be compared
         * @param y the second input to be compared
         * @return a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.
         * @see Comparator#compare(Object, Object)
         * @apiNote This is recommended over the {@link #compare} as this is the specialised form
         */
        int compareInt(int x, int y);
        /**
         * {@inheritDoc}
         * @param x {@inheritDoc}
         * @param y {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote The default implementation calls and returns the value of {@link #compareInt}
         */
        @Override default int compare(java.lang.Integer x, java.lang.Integer y) { return compareInt(x, y); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code int} sort key.
         * @param keyExtractor a function with a {@code int} parameter which returns a {@code int}. This
         * is used to extract the {@code double} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code int} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         * @see Comparator#thenComparingDouble(java.util.function.ToDoubleFunction)
         */
        default OfInt thenComparingDouble(PrimitiveFunction.ToDouble.OfInt keyExtractor) { return (OfInt & Serializable) (x, y) -> java.lang.Double.compare(keyExtractor.applyDouble(x), keyExtractor.applyDouble(y)); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code long} sort key.
         * @param keyExtractor a function with a {@code int} parameter which returns a {@code long}. This
         * is used to extract the {@code long} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code long} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         * @see Comparator#thenComparingLong(java.util.function.ToLongFunction)
         */
        default OfInt thenComparingLong(PrimitiveFunction.ToLong.OfInt keyExtractor) { return (OfInt & Serializable) (x, y) -> java.lang.Long.compare(keyExtractor.applyLong(x), keyExtractor.applyLong(y)); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code int} sort key.
         * @param keyExtractor a function with a {@code int} parameter which returns a {@code int}. This
         * is used to extract the {@code int} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code int} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         * @see Comparator#thenComparingInt(java.util.function.ToIntFunction)
         */
        default OfInt thenComparingInt(PrimitiveFunction.ToInt.OfInt keyExtractor) { return (OfInt & Serializable) (x, y) -> java.lang.Integer.compare(keyExtractor.applyInt(x), keyExtractor.applyInt(y)); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code float} sort key.
         * @param keyExtractor a function with a {@code int} parameter which returns a {@code float}. This
         * is used to extract the {@code float} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code float} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfInt thenComparingFloat(PrimitiveFunction.ToFloat.OfInt keyExtractor) { return (OfInt & Serializable) (x, y) -> java.lang.Float.compare(keyExtractor.applyFloat(x), keyExtractor.applyFloat(y)); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code char} sort key.
         * @param keyExtractor a function with a {@code int} parameter which returns a {@code char}. This
         * is used to extract the {@code char} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code char} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfInt thenComparingChar(PrimitiveFunction.ToChar.OfInt keyExtractor) { return (OfInt & Serializable) (x, y) -> java.lang.Character.compare(keyExtractor.applyChar(x), keyExtractor.applyChar(y)); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code short} sort key.
         * @param keyExtractor a function with a {@code int} parameter which returns a {@code short}. This
         * is used to extract the {@code short} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code float} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfInt thenComparingShort(PrimitiveFunction.ToShort.OfInt keyExtractor) { return (OfInt & Serializable) (x, y) -> java.lang.Short.compare(keyExtractor.applyShort(x), keyExtractor.applyShort(y)); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code byte} sort key.
         * @param keyExtractor a function with a {@code int} parameter which returns a {@code byte}. This
         * is used to extract the {@code byte} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code byte} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfInt thenComparingByte(PrimitiveFunction.ToByte.OfInt keyExtractor) { return (OfInt & Serializable) (x, y) -> java.lang.Byte.compare(keyExtractor.applyByte(x), keyExtractor.applyByte(y)); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code boolean} sort key.
         * @param keyExtractor a function with a {@code int} parameter which returns a {@code boolean}. This
         * is used to extract the {@code boolean} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code boolean} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfInt thenComparingBoolean(PrimitiveFunction.ToBoolean.OfInt keyExtractor) { return (OfInt & Serializable) (x, y) -> java.lang.Boolean.compare(keyExtractor.applyBoolean(x), keyExtractor.applyBoolean(y)); }
    }
    /**
     * A comparator for {@code float} values. This is the comparator for {@code float} specialisations.
     * @see PrimitiveComparator
     */
    @FunctionalInterface
    interface OfFloat extends PrimitiveComparator<java.lang.Float> {
        /**
         * Compares the {@code float} arguments for order
         * @param x the input to be compared
         * @param y the second input to be compared
         * @return a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.
         * @see Comparator#compare(Object, Object)
         * @apiNote This is recommended over the {@link #compare} as this is the specialised form
         */
        int compareFloat(float x, float y);
        /**
         * {@inheritDoc}
         * @param x {@inheritDoc}
         * @param y {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote The default implementation calls and returns the value of {@link #compareFloat}
         */
        @Override default int compare(java.lang.Float x, java.lang.Float y) { return compareFloat(x, y); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code float} sort key.
         * @param keyExtractor a function with a {@code float} parameter which returns a {@code float}. This
         * is used to extract the {@code double} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code float} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         * @see Comparator#thenComparingDouble(java.util.function.ToDoubleFunction)
         */
        default OfFloat thenComparingDouble(PrimitiveFunction.ToDouble.OfFloat keyExtractor) { return (OfFloat & Serializable) (x, y) -> java.lang.Double.compare(keyExtractor.applyDouble(x), keyExtractor.applyDouble(y)); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code long} sort key.
         * @param keyExtractor a function with a {@code float} parameter which returns a {@code long}. This
         * is used to extract the {@code long} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code long} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         * @see Comparator#thenComparingLong(java.util.function.ToLongFunction)
         */
        default OfFloat thenComparingLong(PrimitiveFunction.ToLong.OfFloat keyExtractor) { return (OfFloat & Serializable) (x, y) -> java.lang.Long.compare(keyExtractor.applyLong(x), keyExtractor.applyLong(y)); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code int} sort key.
         * @param keyExtractor a function with a {@code float} parameter which returns a {@code int}. This
         * is used to extract the {@code int} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code int} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         * @see Comparator#thenComparingInt(java.util.function.ToIntFunction)
         */
        default OfFloat thenComparingInt(PrimitiveFunction.ToInt.OfFloat keyExtractor) { return (OfFloat & Serializable) (x, y) -> java.lang.Integer.compare(keyExtractor.applyInt(x), keyExtractor.applyInt(y)); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code float} sort key.
         * @param keyExtractor a function with a {@code float} parameter which returns a {@code float}. This
         * is used to extract the {@code float} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code float} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfFloat thenComparingFloat(PrimitiveFunction.ToFloat.OfFloat keyExtractor) { return (OfFloat & Serializable) (x, y) -> java.lang.Float.compare(keyExtractor.applyFloat(x), keyExtractor.applyFloat(y)); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code char} sort key.
         * @param keyExtractor a function with a {@code float} parameter which returns a {@code char}. This
         * is used to extract the {@code char} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code char} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfFloat thenComparingChar(PrimitiveFunction.ToChar.OfFloat keyExtractor) { return (OfFloat & Serializable) (x, y) -> java.lang.Character.compare(keyExtractor.applyChar(x), keyExtractor.applyChar(y)); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code short} sort key.
         * @param keyExtractor a function with a {@code float} parameter which returns a {@code short}. This
         * is used to extract the {@code short} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code float} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfFloat thenComparingShort(PrimitiveFunction.ToShort.OfFloat keyExtractor) { return (OfFloat & Serializable) (x, y) -> java.lang.Short.compare(keyExtractor.applyShort(x), keyExtractor.applyShort(y)); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code byte} sort key.
         * @param keyExtractor a function with a {@code float} parameter which returns a {@code byte}. This
         * is used to extract the {@code byte} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code byte} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfFloat thenComparingByte(PrimitiveFunction.ToByte.OfFloat keyExtractor) { return (OfFloat & Serializable) (x, y) -> java.lang.Byte.compare(keyExtractor.applyByte(x), keyExtractor.applyByte(y)); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code boolean} sort key.
         * @param keyExtractor a function with a {@code float} parameter which returns a {@code boolean}. This
         * is used to extract the {@code boolean} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code boolean} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfFloat thenComparingBoolean(PrimitiveFunction.ToBoolean.OfFloat keyExtractor) { return (OfFloat & Serializable) (x, y) -> java.lang.Boolean.compare(keyExtractor.applyBoolean(x), keyExtractor.applyBoolean(y)); }
    }
    /**
     * A comparator for {@code char} values. This is the comparator for {@code char} specialisations.
     * @see PrimitiveComparator
     */
    @FunctionalInterface
    interface OfChar extends PrimitiveComparator<java.lang.Character> {
        /**
         * Compares the {@code char} arguments for order
         * @param x the input to be compared
         * @param y the second input to be compared
         * @return a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.
         * @see Comparator#compare(Object, Object)
         * @apiNote This is recommended over the {@link #compare} as this is the specialised form
         */
        int compareChar(char x, char y);
        /**
         * {@inheritDoc}
         * @param x {@inheritDoc}
         * @param y {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote The default implementation calls and returns the value of {@link #compareChar}
         */
        @Override default int compare(java.lang.Character x, java.lang.Character y) { return compareChar(x, y); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code char} sort key.
         * @param keyExtractor a function with a {@code char} parameter which returns a {@code char}. This
         * is used to extract the {@code double} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code char} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         * @see Comparator#thenComparingDouble(java.util.function.ToDoubleFunction)
         */
        default OfChar thenComparingDouble(PrimitiveFunction.ToDouble.OfChar keyExtractor) { return (OfChar & Serializable) (x, y) -> java.lang.Double.compare(keyExtractor.applyDouble(x), keyExtractor.applyDouble(y)); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code long} sort key.
         * @param keyExtractor a function with a {@code char} parameter which returns a {@code long}. This
         * is used to extract the {@code long} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code long} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         * @see Comparator#thenComparingLong(java.util.function.ToLongFunction)
         */
        default OfChar thenComparingLong(PrimitiveFunction.ToLong.OfChar keyExtractor) { return (OfChar & Serializable) (x, y) -> java.lang.Long.compare(keyExtractor.applyLong(x), keyExtractor.applyLong(y)); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code int} sort key.
         * @param keyExtractor a function with a {@code char} parameter which returns a {@code int}. This
         * is used to extract the {@code int} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code int} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         * @see Comparator#thenComparingInt(java.util.function.ToIntFunction)
         */
        default OfChar thenComparingInt(PrimitiveFunction.ToInt.OfChar keyExtractor) { return (OfChar & Serializable) (x, y) -> java.lang.Integer.compare(keyExtractor.applyInt(x), keyExtractor.applyInt(y)); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code float} sort key.
         * @param keyExtractor a function with a {@code char} parameter which returns a {@code float}. This
         * is used to extract the {@code float} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code float} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfChar thenComparingFloat(PrimitiveFunction.ToFloat.OfChar keyExtractor) { return (OfChar & Serializable) (x, y) -> java.lang.Float.compare(keyExtractor.applyFloat(x), keyExtractor.applyFloat(y)); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code char} sort key.
         * @param keyExtractor a function with a {@code char} parameter which returns a {@code char}. This
         * is used to extract the {@code char} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code char} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfChar thenComparingChar(PrimitiveFunction.ToChar.OfChar keyExtractor) { return (OfChar & Serializable) (x, y) -> java.lang.Character.compare(keyExtractor.applyChar(x), keyExtractor.applyChar(y)); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code short} sort key.
         * @param keyExtractor a function with a {@code char} parameter which returns a {@code short}. This
         * is used to extract the {@code short} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code float} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfChar thenComparingShort(PrimitiveFunction.ToShort.OfChar keyExtractor) { return (OfChar & Serializable) (x, y) -> java.lang.Short.compare(keyExtractor.applyShort(x), keyExtractor.applyShort(y)); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code byte} sort key.
         * @param keyExtractor a function with a {@code char} parameter which returns a {@code byte}. This
         * is used to extract the {@code byte} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code byte} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfChar thenComparingByte(PrimitiveFunction.ToByte.OfChar keyExtractor) { return (OfChar & Serializable) (x, y) -> java.lang.Byte.compare(keyExtractor.applyByte(x), keyExtractor.applyByte(y)); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code boolean} sort key.
         * @param keyExtractor a function with a {@code char} parameter which returns a {@code boolean}. This
         * is used to extract the {@code boolean} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code boolean} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfChar thenComparingBoolean(PrimitiveFunction.ToBoolean.OfChar keyExtractor) { return (OfChar & Serializable) (x, y) -> java.lang.Boolean.compare(keyExtractor.applyBoolean(x), keyExtractor.applyBoolean(y)); }
    }
    /**
     * A comparator for {@code short} values. This is the comparator for {@code short} specialisations.
     * @see PrimitiveComparator
     */
    @FunctionalInterface
    interface OfShort extends PrimitiveComparator<java.lang.Short> {
        /**
         * Compares the {@code short} arguments for order
         * @param x the input to be compared
         * @param y the second input to be compared
         * @return a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.
         * @see Comparator#compare(Object, Object)
         * @apiNote This is recommended over the {@link #compare} as this is the specialised form
         */
        int compareShort(short x, short y);
        /**
         * {@inheritDoc}
         * @param x {@inheritDoc}
         * @param y {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote The default implementation calls and returns the value of {@link #compareShort}
         */
        @Override default int compare(java.lang.Short x, java.lang.Short y) { return compareShort(x, y); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code short} sort key.
         * @param keyExtractor a function with a {@code short} parameter which returns a {@code short}. This
         * is used to extract the {@code double} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code short} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         * @see Comparator#thenComparingDouble(java.util.function.ToDoubleFunction)
         */
        default OfShort thenComparingDouble(PrimitiveFunction.ToDouble.OfShort keyExtractor) { return (OfShort & Serializable) (x, y) -> java.lang.Double.compare(keyExtractor.applyDouble(x), keyExtractor.applyDouble(y)); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code long} sort key.
         * @param keyExtractor a function with a {@code short} parameter which returns a {@code long}. This
         * is used to extract the {@code long} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code long} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         * @see Comparator#thenComparingLong(java.util.function.ToLongFunction)
         */
        default OfShort thenComparingLong(PrimitiveFunction.ToLong.OfShort keyExtractor) { return (OfShort & Serializable) (x, y) -> java.lang.Long.compare(keyExtractor.applyLong(x), keyExtractor.applyLong(y)); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code int} sort key.
         * @param keyExtractor a function with a {@code short} parameter which returns a {@code int}. This
         * is used to extract the {@code int} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code int} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         * @see Comparator#thenComparingInt(java.util.function.ToIntFunction)
         */
        default OfShort thenComparingInt(PrimitiveFunction.ToInt.OfShort keyExtractor) { return (OfShort & Serializable) (x, y) -> java.lang.Integer.compare(keyExtractor.applyInt(x), keyExtractor.applyInt(y)); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code float} sort key.
         * @param keyExtractor a function with a {@code short} parameter which returns a {@code float}. This
         * is used to extract the {@code float} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code float} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfShort thenComparingFloat(PrimitiveFunction.ToFloat.OfShort keyExtractor) { return (OfShort & Serializable) (x, y) -> java.lang.Float.compare(keyExtractor.applyFloat(x), keyExtractor.applyFloat(y)); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code char} sort key.
         * @param keyExtractor a function with a {@code short} parameter which returns a {@code char}. This
         * is used to extract the {@code char} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code char} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfShort thenComparingChar(PrimitiveFunction.ToChar.OfShort keyExtractor) { return (OfShort & Serializable) (x, y) -> java.lang.Character.compare(keyExtractor.applyChar(x), keyExtractor.applyChar(y)); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code short} sort key.
         * @param keyExtractor a function with a {@code short} parameter which returns a {@code short}. This
         * is used to extract the {@code short} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code float} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfShort thenComparingShort(PrimitiveFunction.ToShort.OfShort keyExtractor) { return (OfShort & Serializable) (x, y) -> java.lang.Short.compare(keyExtractor.applyShort(x), keyExtractor.applyShort(y)); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code byte} sort key.
         * @param keyExtractor a function with a {@code short} parameter which returns a {@code byte}. This
         * is used to extract the {@code byte} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code byte} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfShort thenComparingByte(PrimitiveFunction.ToByte.OfShort keyExtractor) { return (OfShort & Serializable) (x, y) -> java.lang.Byte.compare(keyExtractor.applyByte(x), keyExtractor.applyByte(y)); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code boolean} sort key.
         * @param keyExtractor a function with a {@code short} parameter which returns a {@code boolean}. This
         * is used to extract the {@code boolean} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code boolean} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfShort thenComparingBoolean(PrimitiveFunction.ToBoolean.OfShort keyExtractor) { return (OfShort & Serializable) (x, y) -> java.lang.Boolean.compare(keyExtractor.applyBoolean(x), keyExtractor.applyBoolean(y)); }
    }
    /**
     * A comparator for {@code byte} values. This is the comparator for {@code byte} specialisations.
     * @see PrimitiveComparator
     */
    @FunctionalInterface
    interface OfByte extends PrimitiveComparator<java.lang.Byte> {
        /**
         * Compares the {@code byte} arguments for order
         * @param x the input to be compared
         * @param y the second input to be compared
         * @return a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.
         * @see Comparator#compare(Object, Object)
         * @apiNote This is recommended over the {@link #compare} as this is the specialised form
         */
        int compareByte(byte x, byte y);
        /**
         * {@inheritDoc}
         * @param x {@inheritDoc}
         * @param y {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote The default implementation calls and returns the value of {@link #compareByte}
         */
        @Override default int compare(java.lang.Byte x, java.lang.Byte y) { return compareByte(x, y); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code byte} sort key.
         * @param keyExtractor a function with a {@code byte} parameter which returns a {@code byte}. This
         * is used to extract the {@code double} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code byte} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         * @see Comparator#thenComparingDouble(java.util.function.ToDoubleFunction)
         */
        default OfByte thenComparingDouble(PrimitiveFunction.ToDouble.OfByte keyExtractor) { return (OfByte & Serializable) (x, y) -> java.lang.Double.compare(keyExtractor.applyDouble(x), keyExtractor.applyDouble(y)); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code long} sort key.
         * @param keyExtractor a function with a {@code byte} parameter which returns a {@code long}. This
         * is used to extract the {@code long} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code long} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         * @see Comparator#thenComparingLong(java.util.function.ToLongFunction)
         */
        default OfByte thenComparingLong(PrimitiveFunction.ToLong.OfByte keyExtractor) { return (OfByte & Serializable) (x, y) -> java.lang.Long.compare(keyExtractor.applyLong(x), keyExtractor.applyLong(y)); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code int} sort key.
         * @param keyExtractor a function with a {@code byte} parameter which returns a {@code int}. This
         * is used to extract the {@code int} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code int} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         * @see Comparator#thenComparingInt(java.util.function.ToIntFunction)
         */
        default OfByte thenComparingInt(PrimitiveFunction.ToInt.OfByte keyExtractor) { return (OfByte & Serializable) (x, y) -> java.lang.Integer.compare(keyExtractor.applyInt(x), keyExtractor.applyInt(y)); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code float} sort key.
         * @param keyExtractor a function with a {@code byte} parameter which returns a {@code float}. This
         * is used to extract the {@code float} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code float} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfByte thenComparingFloat(PrimitiveFunction.ToFloat.OfByte keyExtractor) { return (OfByte & Serializable) (x, y) -> java.lang.Float.compare(keyExtractor.applyFloat(x), keyExtractor.applyFloat(y)); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code char} sort key.
         * @param keyExtractor a function with a {@code byte} parameter which returns a {@code char}. This
         * is used to extract the {@code char} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code char} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfByte thenComparingChar(PrimitiveFunction.ToChar.OfByte keyExtractor) { return (OfByte & Serializable) (x, y) -> java.lang.Character.compare(keyExtractor.applyChar(x), keyExtractor.applyChar(y)); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code short} sort key.
         * @param keyExtractor a function with a {@code byte} parameter which returns a {@code short}. This
         * is used to extract the {@code short} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code float} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfByte thenComparingShort(PrimitiveFunction.ToShort.OfByte keyExtractor) { return (OfByte & Serializable) (x, y) -> java.lang.Short.compare(keyExtractor.applyShort(x), keyExtractor.applyShort(y)); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code byte} sort key.
         * @param keyExtractor a function with a {@code byte} parameter which returns a {@code byte}. This
         * is used to extract the {@code byte} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code byte} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfByte thenComparingByte(PrimitiveFunction.ToByte.OfByte keyExtractor) { return (OfByte & Serializable) (x, y) -> java.lang.Byte.compare(keyExtractor.applyByte(x), keyExtractor.applyByte(y)); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code boolean} sort key.
         * @param keyExtractor a function with a {@code byte} parameter which returns a {@code boolean}. This
         * is used to extract the {@code boolean} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code boolean} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfByte thenComparingBoolean(PrimitiveFunction.ToBoolean.OfByte keyExtractor) { return (OfByte & Serializable) (x, y) -> java.lang.Boolean.compare(keyExtractor.applyBoolean(x), keyExtractor.applyBoolean(y)); }
    }
    /**
     * A comparator for {@code boolean} values. This is the comparator for {@code boolean} specialisations.
     * @see PrimitiveComparator
     */
    @FunctionalInterface
    interface OfBoolean extends PrimitiveComparator<java.lang.Boolean> {
        /**
         * Compares the {@code boolean} arguments for order
         * @param x the input to be compared
         * @param y the second input to be compared
         * @return a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.
         * @see Comparator#compare(Object, Object)
         * @apiNote This is recommended over the {@link #compare} as this is the specialised form
         */
        int compareBoolean(boolean x, boolean y);
        /**
         * {@inheritDoc}
         * @param x {@inheritDoc}
         * @param y {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote The default implementation calls and returns the value of {@link #compareBoolean}
         */
        @Override default int compare(java.lang.Boolean x, java.lang.Boolean y) { return compareBoolean(x, y); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code boolean} sort key.
         * @param keyExtractor a function with a {@code boolean} parameter which returns a {@code boolean}. This
         * is used to extract the {@code double} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code boolean} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         * @see Comparator#thenComparingDouble(java.util.function.ToDoubleFunction)
         */
        default OfBoolean thenComparingDouble(PrimitiveFunction.ToDouble.OfBoolean keyExtractor) { return (OfBoolean & Serializable) (x, y) -> java.lang.Double.compare(keyExtractor.applyDouble(x), keyExtractor.applyDouble(y)); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code long} sort key.
         * @param keyExtractor a function with a {@code boolean} parameter which returns a {@code long}. This
         * is used to extract the {@code long} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code long} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         * @see Comparator#thenComparingLong(java.util.function.ToLongFunction)
         */
        default OfBoolean thenComparingLong(PrimitiveFunction.ToLong.OfBoolean keyExtractor) { return (OfBoolean & Serializable) (x, y) -> java.lang.Long.compare(keyExtractor.applyLong(x), keyExtractor.applyLong(y)); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code int} sort key.
         * @param keyExtractor a function with a {@code boolean} parameter which returns a {@code int}. This
         * is used to extract the {@code int} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code int} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         * @see Comparator#thenComparingInt(java.util.function.ToIntFunction)
         */
        default OfBoolean thenComparingInt(PrimitiveFunction.ToInt.OfBoolean keyExtractor) { return (OfBoolean & Serializable) (x, y) -> java.lang.Integer.compare(keyExtractor.applyInt(x), keyExtractor.applyInt(y)); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code float} sort key.
         * @param keyExtractor a function with a {@code boolean} parameter which returns a {@code float}. This
         * is used to extract the {@code float} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code float} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfBoolean thenComparingFloat(PrimitiveFunction.ToFloat.OfBoolean keyExtractor) { return (OfBoolean & Serializable) (x, y) -> java.lang.Float.compare(keyExtractor.applyFloat(x), keyExtractor.applyFloat(y)); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code char} sort key.
         * @param keyExtractor a function with a {@code boolean} parameter which returns a {@code char}. This
         * is used to extract the {@code char} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code char} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfBoolean thenComparingChar(PrimitiveFunction.ToChar.OfBoolean keyExtractor) { return (OfBoolean & Serializable) (x, y) -> java.lang.Character.compare(keyExtractor.applyChar(x), keyExtractor.applyChar(y)); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code short} sort key.
         * @param keyExtractor a function with a {@code boolean} parameter which returns a {@code short}. This
         * is used to extract the {@code short} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code float} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfBoolean thenComparingShort(PrimitiveFunction.ToShort.OfBoolean keyExtractor) { return (OfBoolean & Serializable) (x, y) -> java.lang.Short.compare(keyExtractor.applyShort(x), keyExtractor.applyShort(y)); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code byte} sort key.
         * @param keyExtractor a function with a {@code boolean} parameter which returns a {@code byte}. This
         * is used to extract the {@code byte} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code byte} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfBoolean thenComparingByte(PrimitiveFunction.ToByte.OfBoolean keyExtractor) { return (OfBoolean & Serializable) (x, y) -> java.lang.Byte.compare(keyExtractor.applyByte(x), keyExtractor.applyByte(y)); }
        /**
         * Returns a lexicographic-order comparator with a function that extracts a {@code boolean} sort key.
         * @param keyExtractor a function with a {@code boolean} parameter which returns a {@code boolean}. This
         * is used to extract the {@code boolean} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code boolean} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         */
        default OfBoolean thenComparingBoolean(PrimitiveFunction.ToBoolean.OfBoolean keyExtractor) { return (OfBoolean & Serializable) (x, y) -> java.lang.Boolean.compare(keyExtractor.applyBoolean(x), keyExtractor.applyBoolean(y)); }
    }
/**
         * Returns a lexicographic-order comparator with a function that extracts a {@code double} sort key.
         * @param keyExtractor a function with a {@code <OF>} parameter which returns a {@code double}. This
         * is used to extract the {@code double} sort key
         * @return a lexicographic-order comparator composed of this and then the {@code double} sort key
         * @apiNote This part of a suite of methods that provide support for primitive forms
         * of {@link Comparator#thenComparing(java.util.function.Function)}
         * @see Comparator#thenComparing(java.util.function.Function)
         * @see Comparator#thenComparing(java.util.function.Function, Comparator)
         * @see Comparator#thenComparingDouble(java.util.function.ToDoubleFunction)
         */
    @SuppressWarnings("unchecked")
    default PrimitiveComparator<OF> thenComparingDouble(PrimitiveFunction.ToDouble<? super OF> keyExtractor) { return (PrimitiveComparator<OF> & Serializable) (x, y) -> java.lang.Double.compare(keyExtractor.applyDouble(x), keyExtractor.applyDouble(y)); }
    /**
             * Returns a lexicographic-order comparator with a function that extracts a {@code long} sort key.
             * @param keyExtractor a function with a {@code <OF>} parameter which returns a {@code long}. This
             * is used to extract the {@code long} sort key
             * @return a lexicographic-order comparator composed of this and then the {@code long} sort key
             * @apiNote This part of a suite of methods that provide support for primitive forms
             * of {@link Comparator#thenComparing(java.util.function.Function)}
             * @see Comparator#thenComparing(java.util.function.Function)
             * @see Comparator#thenComparing(java.util.function.Function, Comparator)
             * @see Comparator#thenComparingLong(java.util.function.ToLongFunction)
             */
    @SuppressWarnings("unchecked")
    default PrimitiveComparator<OF> thenComparingLong(PrimitiveFunction.ToLong<? super OF> keyExtractor) { return (PrimitiveComparator<OF> & Serializable) (x, y) -> java.lang.Long.compare(keyExtractor.applyLong(x), keyExtractor.applyLong(y)); }
    /**
             * Returns a lexicographic-order comparator with a function that extracts an {@code int} sort key.
             * @param keyExtractor a function with a {@code <OF>} parameter which returns an {@code int}. This
             * is used to extract the {@code int} sort key
             * @return a lexicographic-order comparator composed of this and then the {@code int} sort key
             * @apiNote This part of a suite of methods that provide support for primitive forms
             * of {@link Comparator#thenComparing(java.util.function.Function)}
             * @see Comparator#thenComparing(java.util.function.Function)
             * @see Comparator#thenComparing(java.util.function.Function, Comparator)
             * @see Comparator#thenComparingInt(java.util.function.ToIntFunction)
             */
    @SuppressWarnings("unchecked")
    default PrimitiveComparator<OF> thenComparingInt(PrimitiveFunction.ToInt<? super OF> keyExtractor) { return (PrimitiveComparator<OF> & Serializable) (x, y) -> java.lang.Integer.compare(keyExtractor.applyInt(x), keyExtractor.applyInt(y)); }
    /**
             * Returns a lexicographic-order comparator with a function that extracts a {@code float} sort key.
             * @param keyExtractor a function with a {@code <OF>} parameter which returns a {@code float}. This
             * is used to extract the {@code float} sort key
             * @return a lexicographic-order comparator composed of this and then the {@code float} sort key
             * @apiNote This part of a suite of methods that provide support for primitive forms
             * of {@link Comparator#thenComparing(java.util.function.Function)}
             * @see Comparator#thenComparing(java.util.function.Function)
             * @see Comparator#thenComparing(java.util.function.Function, Comparator)
             */
    @SuppressWarnings("unchecked")
    default PrimitiveComparator<OF> thenComparingFloat(PrimitiveFunction.ToFloat<? super OF> keyExtractor) { return (PrimitiveComparator<OF> & Serializable) (x, y) -> java.lang.Float.compare(keyExtractor.applyFloat(x), keyExtractor.applyFloat(y)); }
    /**
             * Returns a lexicographic-order comparator with a function that extracts a {@code char} sort key.
             * @param keyExtractor a function with a {@code <OF>} parameter which returns a {@code char}. This
             * is used to extract the {@code char} sort key
             * @return a lexicographic-order comparator composed of this and then the {@code char} sort key
             * @apiNote This part of a suite of methods that provide support for primitive forms
             * of {@link Comparator#thenComparing(java.util.function.Function)}
             * @see Comparator#thenComparing(java.util.function.Function)
             * @see Comparator#thenComparing(java.util.function.Function, Comparator)
             */
    @SuppressWarnings("unchecked")
    default PrimitiveComparator<OF> thenComparingChar(PrimitiveFunction.ToChar<? super OF> keyExtractor) { return (PrimitiveComparator<OF> & Serializable) (x, y) -> java.lang.Character.compare(keyExtractor.applyChar(x), keyExtractor.applyChar(y)); }
    /**
             * Returns a lexicographic-order comparator with a function that extracts a {@code short} sort key.
             * @param keyExtractor a function with a {@code <OF>} parameter which returns a {@code short}. This
             * is used to extract the {@code short} sort key
             * @return a lexicographic-order comparator composed of this and then the {@code short} sort key
             * @apiNote This part of a suite of methods that provide support for primitive forms
             * of {@link Comparator#thenComparing(java.util.function.Function)}
             * @see Comparator#thenComparing(java.util.function.Function)
             * @see Comparator#thenComparing(java.util.function.Function, Comparator)
             */
    @SuppressWarnings("unchecked")
    default PrimitiveComparator<OF> thenComparingShort(PrimitiveFunction.ToShort<? super OF> keyExtractor) { return (PrimitiveComparator<OF> & Serializable) (x, y) -> java.lang.Short.compare(keyExtractor.applyShort(x), keyExtractor.applyShort(y)); }
    /**
             * Returns a lexicographic-order comparator with a function that extracts a {@code byte} sort key.
             * @param keyExtractor a function with a {@code <OF>} parameter which returns a {@code byte}. This
             * is used to extract the {@code byte} sort key
             * @return a lexicographic-order comparator composed of this and then the {@code byte} sort key
             * @apiNote This part of a suite of methods that provide support for primitive forms
             * of {@link Comparator#thenComparing(java.util.function.Function)}
             * @see Comparator#thenComparing(java.util.function.Function)
             * @see Comparator#thenComparing(java.util.function.Function, Comparator)
             */
    @SuppressWarnings("unchecked")
    default PrimitiveComparator<OF> thenComparingByte(PrimitiveFunction.ToByte<? super OF> keyExtractor) { return (PrimitiveComparator<OF> & Serializable) (x, y) -> java.lang.Byte.compare(keyExtractor.applyByte(x), keyExtractor.applyByte(y)); }
    /**
             * Returns a lexicographic-order comparator with a function that extracts a {@code boolean} sort key.
             * @param keyExtractor a function with a {@code <OF>} parameter which returns a {@code boolean}. This
             * is used to extract the {@code boolean} sort key
             * @return a lexicographic-order comparator composed of this and then the {@code boolean} sort key
             * @apiNote This part of a suite of methods that provide support for primitive forms
             * of {@link Comparator#thenComparing(java.util.function.Function)}
             * @see Comparator#thenComparing(java.util.function.Function)
             * @see Comparator#thenComparing(java.util.function.Function, Comparator)
             */
    @SuppressWarnings("unchecked")
    default PrimitiveComparator<OF> thenComparingBoolean(PrimitiveFunction.ToBoolean<? super OF> keyExtractor) { return (PrimitiveComparator<OF> & Serializable) (x, y) -> java.lang.Boolean.compare(keyExtractor.applyBoolean(x), keyExtractor.applyBoolean(y)); }
}
