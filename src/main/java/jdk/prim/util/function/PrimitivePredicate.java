package jdk.prim.util.function;

import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

/**
 * An interface that provides primitive support for the {@code Predicate} interface.
 * Support exists for a primitive for every parameter and every case.
 * 
 * <p>
 * It also defines primitive alternatives for {@link #or(Predicate)}, {@link #negate()}
 * and {@link #and(Predicate)}.
 * <p>
 * It uses the following interface naming convention: {@code Of*} refers to the first argument
 * as a primitive.
 * <p>
 * Note that no exception handling is done on any of the methods ({@code default} or otherwise)
 * in these interfaces. If an exception is thrown in any method, the behaviour of that method will
 * be similar to it's JDK super interface.
 * <p>
 * The point of this interface (and it's subsequent nested sub-interfaces) is to
 * cover all use cases for {@code Predicate} with Java's primitives, while
 * providing
 * the opportunity for possible integration of with current JDK implementations
 * such as:
 * <ul>
 * <li>{@link DoublePredicate}</li>
 * <li>{@link LongPredicate}</li>
 * <li>{@link IntPredicate}</li>
 * </ul>
 * 
 * @param <OF> the first argument to {@link #test(Object)}
 * 
 * @see Predicate
 */
@FunctionalInterface
public interface PrimitivePredicate<OF> extends Predicate<OF> {

    /**
     * A predicate that requires a {@code double} argument
     */
    @FunctionalInterface
    interface OfDouble extends PrimitivePredicate<java.lang.Double>, DoublePredicate {
        /**
         * Tests the given argument whether it doth match this predicate
         * @param x the {@code double} input
         * @return {@code true} if the argument matches the predicate else returns {@code false}
         * @apiNote This is the {@code double} specialisation of {@link #test} hence it is
         * recommended that this be used as opposed to the alternative
         * @see Predicate#test(Object)
         */
        boolean testDouble(double x);
        /**
         * {@inheritDoc}
         * @param x {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote The default implementation is semantically equal to {@link #testDouble(double)}
         */
        @Override
        default boolean test(double x) {
            return testDouble(x);
        }
        /**
         * {@inheritDoc}
         * @param x {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote The default implementation calls {@link #testDouble} and casts the argument
         * from a {@code Double} to a {@code double}
         */
        @Override default boolean test(java.lang.Double x) { return testDouble((double) x); }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote Overridden to ensure the {@code double} specialisation
         * is used for the negation
         */
        @Override default OfDouble negate() { return x -> !testDouble(x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code double} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfDouble orDouble(OfDouble other) { return x -> testDouble(x) || other.testDouble(x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code long} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfDouble orLong(OfLong other) { return x -> testDouble(x) || other.testLong((long) x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires an {@code int} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfDouble orInt(OfInt other) { return x -> testDouble(x) || other.testInt((int) x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code float} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfDouble orFloat(OfFloat other) { return x -> testDouble(x) || other.testFloat((float)x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code char} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfDouble orChar(OfChar other) { return x -> testDouble(x) || other.testChar((char) x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code short} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfDouble orShort(OfShort other) { return x -> testDouble(x) || other.testShort((short) x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code byte} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfDouble orByte(OfByte other) { return x -> testDouble(x) || other.testByte((byte) x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code boolean} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfDouble orBoolean(OfBoolean other) { return x -> testDouble(x) || other.testBoolean(x != 0); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code double} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfDouble andDouble(OfDouble other) { return x -> testDouble(x) && other.testDouble(x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code long} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfDouble andLong(OfLong other) { return x -> testDouble(x) && other.testLong((long) x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires an {@code int} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfDouble andInt(OfInt other) { return x -> testDouble(x) && other.testInt((int) x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code float} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfDouble andFloat(OfFloat other) { return x -> testDouble(x) && other.testFloat((float)x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code char} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfDouble andChar(OfChar other) { return x -> testDouble(x) && other.testChar((char) x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code short} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfDouble andShort(OfShort other) { return x -> testDouble(x) && other.testShort((short) x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code byte} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfDouble andByte(OfByte other) { return x -> testDouble(x) && other.testByte((byte) x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code boolean} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfDouble andBoolean(OfBoolean other) { return x -> testDouble(x) && other.testBoolean(x != 0); }
    
    /**
     * A predicate that requires a {@code long} argument */}
    @FunctionalInterface
    interface OfLong extends PrimitivePredicate<java.lang.Long>, LongPredicate {
        boolean testLong(long x);
        /**
         * {@inheritDoc}
         * @param x {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote The default implementation is semantically equal to {@link #testLong(long)}
         */
        @Override
        default boolean test(long x) {
            return testLong(x);
        }
        /**
         * Tests the given argument whether it doth match this predicate
         * @param x the {@code long} input
         * @return {@code true} if the argument matches the predicate else returns {@code false}
         * @apiNote This is the {@code long} specialisation of {@link #test} hence it is
         * recommended that this be used as opposed to the alternative
         * @see Predicate#test(Object)
         */
        @Override default boolean test(java.lang.Long x) { return testLong((long) x); }
        /**
         * {@inheritDoc}
         * @param x {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote The default implementation calls {@link #testLong} and casts the argument
         * from a {@code Long} to a {@code long}
         */
        @Override default OfLong negate() { return x -> !testLong(x); }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote Overridden to ensure the {@code long} specialisation
         * is used for the negation
         */
        default OfLong orDouble(OfDouble other) { return x -> testLong(x) || other.testDouble(x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code double} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfLong orLong(OfLong other) { return x -> testLong(x) || other.testLong(x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code long} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfLong orInt(OfInt other) { return x -> testLong(x) || other.testInt((int) x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires an {@code int} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfLong orFloat(OfFloat other) { return x -> testLong(x) || other.testFloat(x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code float} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfLong orChar(OfChar other) { return x -> testLong(x) || other.testChar((char) x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code char} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfLong orShort(OfShort other) { return x -> testLong(x) || other.testShort((short) x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code short} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfLong orByte(OfByte other) { return x -> testLong(x) || other.testByte((byte) x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code byte} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfLong orBoolean(OfBoolean other) { return x -> testLong(x) || other.testBoolean(x != 0); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code boolean} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfLong andDouble(OfDouble other) { return x -> testLong(x) && other.testDouble(x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code double} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfLong andLong(OfLong other) { return x -> testLong(x) && other.testLong(x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code long} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfLong andInt(OfInt other) { return x -> testLong(x) && other.testInt((int) x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires an {@code int} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfLong andFloat(OfFloat other) { return x -> testLong(x) && other.testFloat(x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code float} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfLong andChar(OfChar other) { return x -> testLong(x) && other.testChar((char) x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code char} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfLong andShort(OfShort other) { return x -> testLong(x) && other.testShort((short) x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code short} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfLong andByte(OfByte other) { return x -> testLong(x) && other.testByte((byte) x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code byte} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfLong andBoolean(OfBoolean other) { return x -> testLong(x) && other.testBoolean(x != 0); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code boolean} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
    
    /**
     * A predicate that requires a {@code int} argument */}
    @FunctionalInterface
    interface OfInt extends PrimitivePredicate<java.lang.Integer>, IntPredicate {
        boolean testInt(int x);
        /**
         * {@inheritDoc}
         * @param x {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote The default implementation is semantically equal to {@link #testInt(int)}
         */
        @Override
        default boolean test(int x) {
            return testInt(x);
        }
        /**
         * Tests the given argument whether it doth match this predicate
         * @param x the {@code int} input
         * @return {@code true} if the argument matches the predicate else returns {@code false}
         * @apiNote This is the {@code int} specialisation of {@link #test} hence it is
         * recommended that this be used as opposed to the alternative
         * @see Predicate#test(Object)
         */
        @Override default boolean test(java.lang.Integer x) { return testInt((int) x); }
        /**
         * {@inheritDoc}
         * @param x {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote The default implementation calls {@link #testInt} and casts the argument
         * from a {@code Int} to a {@code int}
         */
        @Override default OfInt negate() { return x -> !testInt(x); }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote Overridden to ensure the {@code int} specialisation
         * is used for the negation
         */
        default OfInt orDouble(OfDouble other) { return x -> testInt(x) || other.testDouble(x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code double} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfInt orLong(OfLong other) { return x -> testInt(x) || other.testLong(x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code long} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfInt orInt(OfInt other) { return x -> testInt(x) || other.testInt(x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires an {@code int} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfInt orFloat(OfFloat other) { return x -> testInt(x) || other.testFloat(x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code float} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfInt orChar(OfChar other) { return x -> testInt(x) || other.testChar((char) x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code char} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfInt orShort(OfShort other) { return x -> testInt(x) || other.testShort((short) x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code short} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfInt orByte(OfByte other) { return x -> testInt(x) || other.testByte((byte) x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code byte} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfInt orBoolean(OfBoolean other) { return x -> testInt(x) || other.testBoolean(x != 0); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code boolean} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfInt andDouble(OfDouble other) { return x -> testInt(x) && other.testDouble(x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code double} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfInt andLong(OfLong other) { return x -> testInt(x) && other.testLong(x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code long} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfInt andInt(OfInt other) { return x -> testInt(x) && other.testInt(x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires an {@code int} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfInt andFloat(OfFloat other) { return x -> testInt(x) && other.testFloat(x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code float} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfInt andChar(OfChar other) { return x -> testInt(x) && other.testChar((char) x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code char} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfInt andShort(OfShort other) { return x -> testInt(x) && other.testShort((short) x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code short} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfInt andByte(OfByte other) { return x -> testInt(x) && other.testByte((byte) x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code byte} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfInt andBoolean(OfBoolean other) { return x -> testInt(x) && other.testBoolean(x != 0); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code boolean} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
    
    /**
     * A predicate that requires a {@code float} argument */}
    @FunctionalInterface
    interface OfFloat extends PrimitivePredicate<java.lang.Float> {
        boolean testFloat(float x);
        /**
         * Tests the given argument whether it doth match this predicate
         * @param x the {@code float} input
         * @return {@code true} if the argument matches the predicate else returns {@code false}
         * @apiNote This is the {@code float} specialisation of {@link #test} hence it is
         * recommended that this be used as opposed to the alternative
         * @see Predicate#test(Object)
         */
        @Override default boolean test(java.lang.Float x) { return testFloat((float) x); }
        /**
         * {@inheritDoc}
         * @param x {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote The default implementation calls {@link #testFloat} and casts the argument
         * from a {@code Float} to a {@code float}
         */
        @Override default OfFloat negate() { return x -> !testFloat(x); }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote Overridden to ensure the {@code float} specialisation
         * is used for the negation
         */
        default OfFloat orDouble(OfDouble other) { return x -> testFloat(x) || other.testDouble(x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code double} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfFloat orLong(OfLong other) { return x -> testFloat(x) || other.testLong((long) x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code long} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfFloat orInt(OfInt other) { return x -> testFloat(x) || other.testInt((int) x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires an {@code int} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfFloat orFloat(OfFloat other) { return x -> testFloat(x) || other.testFloat(x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code float} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfFloat orChar(OfChar other) { return x -> testFloat(x) || other.testChar((char) x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code char} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfFloat orShort(OfShort other) { return x -> testFloat(x) || other.testShort((short) x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code short} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfFloat orByte(OfByte other) { return x -> testFloat(x) || other.testByte((byte) x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code byte} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfFloat orBoolean(OfBoolean other) { return x -> testFloat(x) || other.testBoolean(x != 0); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code boolean} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfFloat andDouble(OfDouble other) { return x -> testFloat(x) && other.testDouble(x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code double} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfFloat andLong(OfLong other) { return x -> testFloat(x) && other.testLong((long) x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code long} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfFloat andInt(OfInt other) { return x -> testFloat(x) && other.testInt((int) x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires an {@code int} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfFloat andFloat(OfFloat other) { return x -> testFloat(x) && other.testFloat(x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code float} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfFloat andChar(OfChar other) { return x -> testFloat(x) && other.testChar((char) x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code char} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfFloat andShort(OfShort other) { return x -> testFloat(x) && other.testShort((short) x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code short} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfFloat andByte(OfByte other) { return x -> testFloat(x) && other.testByte((byte) x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code byte} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfFloat andBoolean(OfBoolean other) { return x -> testFloat(x) && other.testBoolean(x != 0); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code boolean} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
    
    /**
     * A predicate that requires a {@code char} argument */}
    @FunctionalInterface
    interface OfChar extends PrimitivePredicate<java.lang.Character> {
        boolean testChar(char x);
        /**
         * Tests the given argument whether it doth match this predicate
         * @param x the {@code char} input
         * @return {@code true} if the argument matches the predicate else returns {@code false}
         * @apiNote This is the {@code char} specialisation of {@link #test} hence it is
         * recommended that this be used as opposed to the alternative
         * @see Predicate#test(Object)
         */
        @Override default boolean test(java.lang.Character x) { return testChar((char) x); }
        /**
         * {@inheritDoc}
         * @param x {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote The default implementation calls {@link #testChar} and casts the argument
         * from a {@code Char} to a {@code char}
         */
        @Override default OfChar negate() { return x -> !testChar(x); }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote Overridden to ensure the {@code char} specialisation
         * is used for the negation
         */
        default OfChar orDouble(OfDouble other) { return x -> testChar(x) || other.testDouble(x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code double} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfChar orLong(OfLong other) { return x -> testChar(x) || other.testLong(x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code long} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfChar orInt(OfInt other) { return x -> testChar(x) || other.testInt(x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires an {@code int} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfChar orFloat(OfFloat other) { return x -> testChar(x) || other.testFloat(x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code float} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfChar orChar(OfChar other) { return x -> testChar(x) || other.testChar(x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code char} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfChar orShort(OfShort other) { return x -> testChar(x) || other.testShort((short) x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code short} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfChar orByte(OfByte other) { return x -> testChar(x) || other.testByte((byte) x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code byte} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfChar orBoolean(OfBoolean other) { return x -> testChar(x) || other.testBoolean(x != 0); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code boolean} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfChar andDouble(OfDouble other) { return x -> testChar(x) && other.testDouble(x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code double} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfChar andLong(OfLong other) { return x -> testChar(x) && other.testLong(x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code long} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfChar andInt(OfInt other) { return x -> testChar(x) && other.testInt(x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires an {@code int} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfChar andFloat(OfFloat other) { return x -> testChar(x) && other.testFloat(x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code float} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfChar andChar(OfChar other) { return x -> testChar(x) && other.testChar(x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code char} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfChar andShort(OfShort other) { return x -> testChar(x) && other.testShort((short) x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code short} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfChar andByte(OfByte other) { return x -> testChar(x) && other.testByte((byte) x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code byte} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfChar andBoolean(OfBoolean other) { return x -> testChar(x) && other.testBoolean(x != 0); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code boolean} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
    
    /**
     * A predicate that requires a {@code short} argument */}
    @FunctionalInterface
    interface OfShort extends PrimitivePredicate<java.lang.Short> {
        boolean testShort(short x);
        /**
         * Tests the given argument whether it doth match this predicate
         * @param x the {@code short} input
         * @return {@code true} if the argument matches the predicate else returns {@code false}
         * @apiNote This is the {@code short} specialisation of {@link #test} hence it is
         * recommended that this be used as opposed to the alternative
         * @see Predicate#test(Object)
         */
        @Override default boolean test(java.lang.Short x) { return testShort((short) x); }
        /**
         * {@inheritDoc}
         * @param x {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote The default implementation calls {@link #testShort} and casts the argument
         * from a {@code Short} to a {@code short}
         */
        @Override default OfShort negate() { return x -> !testShort(x); }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote Overridden to ensure the {@code short} specialisation
         * is used for the negation
         */
        default OfShort orDouble(OfDouble other) { return x -> testShort(x) || other.testDouble(x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code double} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfShort orLong(OfLong other) { return x -> testShort(x) || other.testLong(x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code long} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfShort orInt(OfInt other) { return x -> testShort(x) || other.testInt(x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires an {@code int} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfShort orFloat(OfFloat other) { return x -> testShort(x) || other.testFloat(x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code float} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfShort orChar(OfChar other) { return x -> testShort(x) || other.testChar((char) x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code char} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfShort orShort(OfShort other) { return x -> testShort(x) || other.testShort((short) x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code short} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfShort orByte(OfByte other) { return x -> testShort(x) || other.testByte((byte) x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code byte} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfShort orBoolean(OfBoolean other) { return x -> testShort(x) || other.testBoolean(x != 0); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code boolean} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfShort andDouble(OfDouble other) { return x -> testShort(x) && other.testDouble(x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code double} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfShort andLong(OfLong other) { return x -> testShort(x) && other.testLong(x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code long} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfShort andInt(OfInt other) { return x -> testShort(x) && other.testInt(x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires an {@code int} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfShort andFloat(OfFloat other) { return x -> testShort(x) && other.testFloat(x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code float} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfShort andChar(OfChar other) { return x -> testShort(x) && other.testChar((char) x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code char} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfShort andShort(OfShort other) { return x -> testShort(x) && other.testShort((short) x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code short} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfShort andByte(OfByte other) { return x -> testShort(x) && other.testByte((byte) x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code byte} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfShort andBoolean(OfBoolean other) { return x -> testShort(x) && other.testBoolean(x != 0); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code boolean} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
    
    /**
     * A predicate that requires a {@code byte} argument */}
    @FunctionalInterface
    interface OfByte extends PrimitivePredicate<java.lang.Byte> {
        boolean testByte(byte x);
        /**
         * Tests the given argument whether it doth match this predicate
         * @param x the {@code byte} input
         * @return {@code true} if the argument matches the predicate else returns {@code false}
         * @apiNote This is the {@code byte} specialisation of {@link #test} hence it is
         * recommended that this be used as opposed to the alternative
         * @see Predicate#test(Object)
         */
        @Override default boolean test(java.lang.Byte x) { return testByte((byte) x); }
        /**
         * {@inheritDoc}
         * @param x {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote The default implementation calls {@link #testByte} and casts the argument
         * from a {@code Byte} to a {@code byte}
         */
        @Override default OfByte negate() { return x -> !testByte(x); }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote Overridden to ensure the {@code byte} specialisation
         * is used for the negation
         */
        default OfByte orDouble(OfDouble other) { return x -> testByte(x) || other.testDouble(x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code double} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfByte orLong(OfLong other) { return x -> testByte(x) || other.testLong(x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code long} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfByte orInt(OfInt other) { return x -> testByte(x) || other.testInt(x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires an {@code int} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfByte orFloat(OfFloat other) { return x -> testByte(x) || other.testFloat(x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code float} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfByte orChar(OfChar other) { return x -> testByte(x) || other.testChar((char) x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code char} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfByte orShort(OfShort other) { return x -> testByte(x) || other.testShort((short) x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code short} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfByte orByte(OfByte other) { return x -> testByte(x) || other.testByte((byte) x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code byte} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfByte orBoolean(OfBoolean other) { return x -> testByte(x) || other.testBoolean(x != 0); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code boolean} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfByte andDouble(OfDouble other) { return x -> testByte(x) && other.testDouble(x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code double} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfByte andLong(OfLong other) { return x -> testByte(x) && other.testLong(x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code long} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfByte andInt(OfInt other) { return x -> testByte(x) && other.testInt(x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires an {@code int} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfByte andFloat(OfFloat other) { return x -> testByte(x) && other.testFloat(x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code float} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfByte andChar(OfChar other) { return x -> testByte(x) && other.testChar((char) x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code char} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfByte andShort(OfShort other) { return x -> testByte(x) && other.testShort((short) x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code short} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfByte andByte(OfByte other) { return x -> testByte(x) && other.testByte((byte) x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code byte} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfByte andBoolean(OfBoolean other) { return x -> testByte(x) && other.testBoolean(x != 0); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code boolean} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
    
    /**
     * A predicate that requires a {@code boolean} argument */}
    @FunctionalInterface
    interface OfBoolean extends PrimitivePredicate<java.lang.Boolean> {
        boolean testBoolean(boolean x);
        /**
         * Tests the given argument whether it doth match this predicate
         * @param x the {@code boolean} input
         * @return {@code true} if the argument matches the predicate else returns {@code false}
         * @apiNote This is the {@code boolean} specialisation of {@link #test} hence it is
         * recommended that this be used as opposed to the alternative
         * @see Predicate#test(Object)
         */
        @Override default boolean test(java.lang.Boolean x) { return testBoolean((boolean) x); }
        /**
         * {@inheritDoc}
         * @param x {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote The default implementation calls {@link #testBoolean} and casts the argument
         * from a {@code Boolean} to a {@code boolean}
         */
        @Override default OfBoolean negate() { return x -> !testBoolean(x); }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote Overridden to ensure the {@code boolean} specialisation
         * is used for the negation
         */
        default OfBoolean orDouble(OfDouble other) { return x -> testBoolean(x) || other.testDouble(x ? 1 : 0); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code double} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfBoolean orLong(OfLong other) { return x -> testBoolean(x) || other.testLong(x ? 1 : 0); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code long} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfBoolean orInt(OfInt other) { return x -> testBoolean(x) || other.testInt(x ? 1 : 0); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires an {@code int} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfBoolean orFloat(OfFloat other) { return x -> testBoolean(x) || other.testFloat(x ? 1 : 0); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code float} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfBoolean orChar(OfChar other) { return x -> testBoolean(x) || other.testChar((char) (x ? 1 : 0)); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code char} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfBoolean orShort(OfShort other) { return x -> testBoolean(x) || other.testShort((short) (x ? 1 : 0)); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code short} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfBoolean orByte(OfByte other) { return x -> testBoolean(x) || other.testByte((byte) (x ? 1 : 0)); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code byte} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfBoolean orBoolean(OfBoolean other) { return x -> testBoolean(x) || other.testBoolean(x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code OR} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code boolean} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfBoolean andDouble(OfDouble other) { return x -> testBoolean(x) && other.testDouble(x ? 1 : 0); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code double} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfBoolean andLong(OfLong other) { return x -> testBoolean(x) && other.testLong(x ? 1 : 0); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code long} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfBoolean andInt(OfInt other) { return x -> testBoolean(x) && other.testInt(x ? 1 : 0); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires an {@code int} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfBoolean andFloat(OfFloat other) { return x -> testBoolean(x) && other.testFloat(x ? 1 : 0); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code float} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfBoolean andChar(OfChar other) { return x -> testBoolean(x) && other.testChar((char) (x ? 1 : 0)); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code char} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfBoolean andShort(OfShort other) { return x -> testBoolean(x) && other.testShort((short) (x ? 1 : 0)); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code short} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfBoolean andByte(OfByte other) { return x -> testBoolean(x) && other.testByte((byte) (x ? 1 : 0)); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code byte} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
        default OfBoolean andBoolean(OfBoolean other) { return x -> testBoolean(x) && other.testBoolean(x); }
        /**
         * Composes a predicate that comprises of performing a logical {@code AND} using
         * {@code this} as the lhs and the argument as the rhs of the operation.
         * @param other a predicate that requires a {@code boolean} as it's argument
         * @return a predicate that requires a {@code double} as it's argument
         * @apiNote This is part of a suite of methods that implement primitive
         * alternatives for {@link Predicate#or(Predicate)}
         */
    }
}
