package jdk.prim.util.function;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;
import java.util.function.Supplier;

/**
 * An interface that provides primitive support for the {@code Supplier}
 * interface.
 * Support exists for a primitive for every parameter and every case.
 * <p>
 * It uses the following interface naming convention: {@code To*} refers to the argument.
 * <p>
 * Note that no exception handling is done on any of the methods
 * ({@code default} or otherwise)
 * in these interfaces. If an exception is thrown in any method, the behaviour
 * of that method will
 * be similar to it's JDK equivalent.
 * <p>
 * The point of this interface (and it's subsequent nested sub-interfaces) is to
 * cover all use cases for {@code Supplier} with Java's primitives, while
 * providing
 * the opportunity for possible integration of with current JDK implementations
 * such as:
 * <ul>
 * <li>{@link DoubleSupplier}</li>
 * <li>{@link LongSupplier}</li>
 * <li>{@link IntSupplier}</li>
 * </ul>
 * 
 * @see Supplier
 * @param <TO> The type of the argument for {@link #accept(Object)}
 */
@FunctionalInterface
public interface PrimitiveSupplier<TO> extends Supplier<TO> {

    /**
     * A supplier of {@code double} results.
     * 
     * @see Supplier
     */
    @FunctionalInterface
    interface ToDouble extends PrimitiveSupplier<java.lang.Double>, DoubleSupplier {
        /**
         * Gets a {@code double} result.
         * @return a {@code double} value. May be a different value with each call.
         * @apiNote This is the {@code double} specialisation of {@link #get}, hence
         * it is recommended instead.
         */
        double getDouble();
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote The default implementation is semantically equal to {@link #getDouble}
         */
        @Override default double getAsDouble() { return getDouble(); }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote The default implementation ca7lls and returns the result of {@link #getDouble}
         */
        @Override default java.lang.Double get() { return getDouble(); }
    }
    /**
     * A supplier of {@code long} results.
     * 
     * @see Supplier
     */
    @FunctionalInterface
    interface ToLong extends PrimitiveSupplier<java.lang.Long>, LongSupplier {
        /**
         * Gets a {@code long} result.
         * @return a {@code long} value. May be a different value with each call.
         * @apiNote This is the {@code long} specialisation of {@link #get}, hence
         * it is recommended instead.
         */
        long getLong();
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote The default implementation is semantically equal to {@link #getLong}
         */
        @Override default long getAsLong() { return getLong(); }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote The default implementation ca7lls and returns the result of {@link #getLong}
         */
        @Override default java.lang.Long get() { return getLong(); }
    }
    /**
     * A supplier of {@code int} results.
     * 
     * @see Supplier
     */
    @FunctionalInterface
    interface ToInt extends PrimitiveSupplier<java.lang.Integer>, IntSupplier {
        /**
         * Gets a {@code int} result.
         * @return a {@code int} value. May be a different value with each call.
         * @apiNote This is the {@code int} specialisation of {@link #get}, hence
         * it is recommended instead.
         */
        int getInt();
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote The default implementation is semantically equal to {@link #getInt}
         */
        @Override default int getAsInt() { return getInt(); }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote The default implementation ca7lls and returns the result of {@link #getInt}
         */
        @Override default java.lang.Integer get() { return getInt(); }
    }
    /**
     * A supplier of {@code float} results.
     * 
     * @see Supplier
     */
    @FunctionalInterface
    interface ToFloat extends PrimitiveSupplier<java.lang.Float> {
        /**
         * Gets a {@code float} result.
         * @return a {@code float} value. May be a different value with each call.
         * @apiNote This is the {@code float} specialisation of {@link #get}, hence
         * it is recommended instead.
         */
        float getFloat();
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote The default implementation ca7lls and returns the result of {@link #getFloat}
         */
        @Override default java.lang.Float get() { return getFloat(); }
    }
    /**
     * A supplier of {@code char} results.
     * 
     * @see Supplier
     */
    @FunctionalInterface
    interface ToChar extends PrimitiveSupplier<java.lang.Character> {
        /**
         * Gets a {@code char} result.
         * @return a {@code char} value. May be a different value with each call.
         * @apiNote This is the {@code char} specialisation of {@link #get}, hence
         * it is recommended instead.
         */
        char getChar();
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote The default implementation ca7lls and returns the result of {@link #getChar}
         */
        @Override default java.lang.Character get() { return getChar(); }
    }
    /**
     * A supplier of {@code short} results.
     * 
     * @see Supplier
     */
    @FunctionalInterface
    interface ToShort extends PrimitiveSupplier<java.lang.Short> {
        /**
         * Gets a {@code short} result.
         * @return a {@code short} value. May be a different value with each call.
         * @apiNote This is the {@code short} specialisation of {@link #get}, hence
         * it is recommended instead.
         */
        short getShort();
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote The default implementation ca7lls and returns the result of {@link #getShort}
         */
        @Override default java.lang.Short get() { return getShort(); }
    }
    /**
     * A supplier of {@code byte} results.
     * 
     * @see Supplier
     */
    @FunctionalInterface
    interface ToByte extends PrimitiveSupplier<java.lang.Byte> {
        /**
         * Gets a {@code byte} result.
         * @return a {@code byte} value. May be a different value with each call.
         * @apiNote This is the {@code byte} specialisation of {@link #get}, hence
         * it is recommended instead.
         */
        byte getByte();
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote The default implementation ca7lls and returns the result of {@link #getByte}
         */
        @Override default java.lang.Byte get() { return getByte(); }
    }
    /**
     * A supplier of {@code boolean} results.
     * 
     * @see Supplier
     */
    @FunctionalInterface
    interface ToBoolean extends PrimitiveSupplier<java.lang.Boolean>, BooleanSupplier {
        /**
         * Gets a {@code boolean} result.
         * @return a {@code boolean} value. May be a different value with each call.
         * @apiNote This is the {@code boolean} specialisation of {@link #get}, hence
         * it is recommended instead.
         */
        boolean getBoolean();
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote The default implementation is semantically equal to {@link #getBoolean}
         */
        @Override default boolean getAsBoolean() { return getBoolean(); }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote The default implementation ca7lls and returns the result of {@link #getBoolean}
         */
        @Override default java.lang.Boolean get() { return getBoolean(); }
    }
}
