package jdk.prim.util.function;

import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;
/**
 * An interface that provides primitive support for the {@code BiConsumer}
 * interface.
 * Support exists for a primitive for every parameter and every case.
 * 
 * <p>
 * It also defines primitive alternatives for {@link #andThen(Consumer)}.
 * <p>
 * It uses the following interface naming convention: {@code Of*} refers to the argument.
 * <p>
 * Note that no exception handling is done on any of the methods
 * ({@code default} or otherwise)
 * in these interfaces. If an exception is thrown in any method, the behaviour
 * of that method will
 * be similar to it's JDK equivalent.
 * <p>
 * The point of this interface (and it's subsequent nested sub-interfaces) is to
 * cover all use cases for {@code Consumer} with Java's primitives, while
 * providing
 * the opportunity for possible integration of with current JDK implementations
 * such as:
 * <ul>
 * <li>{@link DoubleConsumer}</li>
 * <li>{@link LongConsumer}</li>
 * <li>{@link IntConsumer}</li>
 * </ul>
 * 
 * @see Consumer
 * @param <OF> The type of the argument for {@link #accept(Object)}
 */
@FunctionalInterface
public interface PrimitiveConsumer<OF> extends Consumer<OF> {

    /**
     * A consumer that requires a {@code double} argument. This is the
     * {@code double} specialisation
     * of {@link PrimitiveConsumer}
     * 
     * @see PrimitiveConsumer
     * @see Consumer
     */
    @FunctionalInterface
    interface OfDouble extends PrimitiveConsumer<java.lang.Double>, DoubleConsumer {
        /**
         * Consumes the input, possibly with side-effects
         * 
         * @param x the input to be consumed
         * @apiNote This is the primitive specialisation of {@link #accept} hence it is
         *          recommended
         *          that this be used instead
         */
        void acceptDouble(double x);

        /**
         * {@inheritDoc}
         * @param x {@inheritDoc}
         * @implNote This is semantically equal to {@link #acceptDouble}
         */
        @Override default void accept(double x) { acceptDouble(x); }

        /**
         * {@inheritDoc}
         * 
         * @param x {@inheritDoc}
         * @implNote The default implementation calls {@link #acceptDouble}
         */
        @Override
        default void accept(java.lang.Double x) {
            acceptDouble(x);
        }

        /**
         * Composes a {@code OfDouble} using {@code this} and the argument. The
         * composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code double}
         * @return a {@code OfDouble} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfDouble andThenDouble(OfDouble after) {
            return x -> {
                acceptDouble(x);
                after.acceptDouble(x);
            };
        }

        /**
         * Composes a {@code OfDouble} using {@code this} and the argument. The
         * composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code long}
         * @return a {@code OfDouble} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfDouble andThenLong(OfLong after) {
            return x -> {
                acceptDouble(x);
                after.acceptLong((long) x);
            };
        }

        /**
         * Composes a {@code OfDouble} using {@code this} and the argument. The
         * composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code int}
         * @return a {@code OfDouble} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfDouble andThenInt(OfInt after) {
            return x -> {
                acceptDouble(x);
                after.acceptInt((int) x);
            };
        }

        /**
         * Composes a {@code OfDouble} using {@code this} and the argument. The
         * composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code float}
         * @return a {@code OfDouble} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfDouble andThenFloat(OfFloat after) {
            return x -> {
                acceptDouble(x);
                after.acceptFloat((float) x);
            };
        }

        /**
         * Composes a {@code OfDouble} using {@code this} and the argument. The
         * composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code char}
         * @return a {@code OfDouble} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfDouble andThenChar(OfChar after) {
            return x -> {
                acceptDouble(x);
                after.acceptChar((char) x);
            };
        }

        /**
         * Composes a {@code OfDouble} using {@code this} and the argument. The
         * composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code short}
         * @return a {@code OfDouble} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfDouble andThenShort(OfShort after) {
            return x -> {
                acceptDouble(x);
                after.acceptShort((short) x);
            };
        }

        /**
         * Composes a {@code OfDouble} using {@code this} and the argument. The
         * composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code byte}
         * @return a {@code OfDouble} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfDouble andThenByte(OfByte after) {
            return x -> {
                acceptDouble(x);
                after.acceptByte((byte) x);
            };
        }

        /**
         * Composes a {@code OfDouble} using {@code this} and the argument. The
         * composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code boolean}
         * @return a {@code OfDouble} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfDouble andThenBoolean(OfBoolean after) {
            return x -> {
                acceptDouble(x);
                after.acceptBoolean(x != 0);
            };
        }
    }

    /**
     * A consumer that requires a {@code long} argument. This is the {@code long}
     * specialisation
     * of {@link PrimitiveConsumer}
     * 
     * @see PrimitiveConsumer
     * @see Consumer
     */
    @FunctionalInterface
    interface OfLong extends PrimitiveConsumer<java.lang.Long>, LongConsumer {
        /**
         * Consumes the input, possibly with side-effects
         * 
         * @param x the input to be consumed
         * @apiNote This is the primitive specialisation of {@link #accept} hence it is
         *          recommended
         *          that this be used instead
         */
        void acceptLong(long x);

        /**
         * {@inheritDoc}
         * @param x {@inheritDoc}
         * @implNote This is semantically equal to {@link #acceptLong}
         */
        @Override default void accept(long x) { acceptLong(x); }

        /**
         * {@inheritDoc}
         * 
         * @param x {@inheritDoc}
         * @implNote The default implementation calls {@link #acceptLong}
         */
        @Override
        default void accept(java.lang.Long x) {
            acceptLong(x);
        }

        /**
         * Composes a {@code OfLong} using {@code this} and the argument. The
         * composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code double}
         * @return a {@code OfLong} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfLong andThenDouble(OfDouble after) {
            return x -> {
                acceptLong(x);
                after.acceptDouble(x);
            };
        }

        /**
         * Composes a {@code OfLong} using {@code this} and the argument. The
         * composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code long}
         * @return a {@code OfLong} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfLong andThenLong(OfLong after) {
            return x -> {
                acceptLong(x);
                after.acceptLong(x);
            };
        }

        /**
         * Composes a {@code OfLong} using {@code this} and the argument. The
         * composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code int}
         * @return a {@code OfLong} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfLong andThenInt(OfInt after) {
            return x -> {
                acceptLong(x);
                after.acceptInt((int) x);
            };
        }

        /**
         * Composes a {@code OfLong} using {@code this} and the argument. The
         * composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code float}
         * @return a {@code OfLong} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfLong andThenFloat(OfFloat after) {
            return x -> {
                acceptLong(x);
                after.acceptFloat(x);
            };
        }

        /**
         * Composes a {@code OfLong} using {@code this} and the argument. The
         * composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code char}
         * @return a {@code OfLong} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfLong andThenChar(OfChar after) {
            return x -> {
                acceptLong(x);
                after.acceptChar((char) x);
            };
        }

        /**
         * Composes a {@code OfLong} using {@code this} and the argument. The
         * composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code short}
         * @return a {@code OfLong} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfLong andThenShort(OfShort after) {
            return x -> {
                acceptLong(x);
                after.acceptShort((short) x);
            };
        }

        /**
         * Composes a {@code OfLong} using {@code this} and the argument. The
         * composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code byte}
         * @return a {@code OfLong} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfLong andThenByte(OfByte after) {
            return x -> {
                acceptLong(x);
                after.acceptByte((byte) x);
            };
        }

        /**
         * Composes a {@code OfLong} using {@code this} and the argument. The
         * composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code boolean}
         * @return a {@code OfLong} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfLong andThenBoolean(OfBoolean after) {
            return x -> {
                acceptLong(x);
                after.acceptBoolean(x != 0);
            };
        }
    }

    /**
     * A consumer that requires a {@code int} argument. This is the {@code int}
     * specialisation
     * of {@link PrimitiveConsumer}
     * 
     * @see PrimitiveConsumer
     * @see Consumer
     */
    @FunctionalInterface
    interface OfInt extends PrimitiveConsumer<java.lang.Integer>, IntConsumer {
        /**
         * Consumes the input, possibly with side-effects
         * 
         * @param x the input to be consumed
         * @apiNote This is the primitive specialisation of {@link #accept} hence it is
         *          recommended
         *          that this be used instead
         */
        void acceptInt(int x);

        /**
         * {@inheritDoc}
         * @param x {@inheritDoc}
         * @implNote This is semantically equal to {@link #acceptInt}
         */
        @Override default void accept(int x) { acceptInt(x); }

        /**
         * {@inheritDoc}
         * 
         * @param x {@inheritDoc}
         * @implNote The default implementation calls {@link #acceptInt}
         */
        @Override
        default void accept(java.lang.Integer x) {
            acceptInt(x);
        }

        /**
         * Composes a {@code OfInt} using {@code this} and the argument. The composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code double}
         * @return a {@code OfInt} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfInt andThenDouble(OfDouble after) {
            return x -> {
                acceptInt(x);
                after.acceptDouble(x);
            };
        }

        /**
         * Composes a {@code OfInt} using {@code this} and the argument. The composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code long}
         * @return a {@code OfInt} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfInt andThenLong(OfLong after) {
            return x -> {
                acceptInt(x);
                after.acceptLong(x);
            };
        }

        /**
         * Composes a {@code OfInt} using {@code this} and the argument. The composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code int}
         * @return a {@code OfInt} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfInt andThenInt(OfInt after) {
            return x -> {
                acceptInt(x);
                after.acceptInt(x);
            };
        }

        /**
         * Composes a {@code OfInt} using {@code this} and the argument. The composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code float}
         * @return a {@code OfInt} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfInt andThenFloat(OfFloat after) {
            return x -> {
                acceptInt(x);
                after.acceptFloat(x);
            };
        }

        /**
         * Composes a {@code OfInt} using {@code this} and the argument. The composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code char}
         * @return a {@code OfInt} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfInt andThenChar(OfChar after) {
            return x -> {
                acceptInt(x);
                after.acceptChar((char) x);
            };
        }

        /**
         * Composes a {@code OfInt} using {@code this} and the argument. The composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code short}
         * @return a {@code OfInt} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfInt andThenShort(OfShort after) {
            return x -> {
                acceptInt(x);
                after.acceptShort((short) x);
            };
        }

        /**
         * Composes a {@code OfInt} using {@code this} and the argument. The composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code byte}
         * @return a {@code OfInt} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfInt andThenByte(OfByte after) {
            return x -> {
                acceptInt(x);
                after.acceptByte((byte) x);
            };
        }

        /**
         * Composes a {@code OfInt} using {@code this} and the argument. The composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code boolean}
         * @return a {@code OfInt} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfInt andThenBoolean(OfBoolean after) {
            return x -> {
                acceptInt(x);
                after.acceptBoolean(x != 0);
            };
        }
    }

    /**
     * A consumer that requires a {@code float} argument. This is the {@code float}
     * specialisation
     * of {@link PrimitiveConsumer}
     * 
     * @see PrimitiveConsumer
     * @see Consumer
     */
    @FunctionalInterface
    interface OfFloat extends PrimitiveConsumer<java.lang.Float> {
        /**
         * Consumes the input, possibly with side-effects
         * 
         * @param x the input to be consumed
         * @apiNote This is the primitive specialisation of {@link #accept} hence it is
         *          recommended
         *          that this be used instead
         */
        void acceptFloat(float x);

        /**
         * {@inheritDoc}
         * 
         * @param x {@inheritDoc}
         * @implNote The default implementation calls {@link #acceptFloat}
         */
        @Override
        default void accept(java.lang.Float x) {
            acceptFloat(x);
        }

        /**
         * Composes a {@code OfFloat} using {@code this} and the argument. The
         * composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code double}
         * @return a {@code OfFloat} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfFloat andThenDouble(OfDouble after) {
            return x -> {
                acceptFloat(x);
                after.acceptDouble(x);
            };
        }

        /**
         * Composes a {@code OfFloat} using {@code this} and the argument. The
         * composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code long}
         * @return a {@code OfFloat} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfFloat andThenLong(OfLong after) {
            return x -> {
                acceptFloat(x);
                after.acceptLong((long) x);
            };
        }

        /**
         * Composes a {@code OfFloat} using {@code this} and the argument. The
         * composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code int}
         * @return a {@code OfFloat} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfFloat andThenInt(OfInt after) {
            return x -> {
                acceptFloat(x);
                after.acceptInt((int) x);
            };
        }

        /**
         * Composes a {@code OfFloat} using {@code this} and the argument. The
         * composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code float}
         * @return a {@code OfFloat} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfFloat andThenFloat(OfFloat after) {
            return x -> {
                acceptFloat(x);
                after.acceptFloat(x);
            };
        }

        /**
         * Composes a {@code OfFloat} using {@code this} and the argument. The
         * composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code char}
         * @return a {@code OfFloat} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfFloat andThenChar(OfChar after) {
            return x -> {
                acceptFloat(x);
                after.acceptChar((char) x);
            };
        }

        /**
         * Composes a {@code OfFloat} using {@code this} and the argument. The
         * composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code short}
         * @return a {@code OfFloat} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfFloat andThenShort(OfShort after) {
            return x -> {
                acceptFloat(x);
                after.acceptShort((short) x);
            };
        }

        /**
         * Composes a {@code OfFloat} using {@code this} and the argument. The
         * composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code byte}
         * @return a {@code OfFloat} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfFloat andThenByte(OfByte after) {
            return x -> {
                acceptFloat(x);
                after.acceptByte((byte) x);
            };
        }

        /**
         * Composes a {@code OfFloat} using {@code this} and the argument. The
         * composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code boolean}
         * @return a {@code OfFloat} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfFloat andThenBoolean(OfBoolean after) {
            return x -> {
                acceptFloat(x);
                after.acceptBoolean(x != 0);
            };
        }
    }

    /**
     * A consumer that requires a {@code char} argument. This is the {@code char}
     * specialisation
     * of {@link PrimitiveConsumer}
     * 
     * @see PrimitiveConsumer
     * @see Consumer
     */
    @FunctionalInterface
    interface OfChar extends PrimitiveConsumer<java.lang.Character> {
        /**
         * Consumes the input, possibly with side-effects
         * 
         * @param x the input to be consumed
         * @apiNote This is the primitive specialisation of {@link #accept} hence it is
         *          recommended
         *          that this be used instead
         */
        void acceptChar(char x);

        /**
         * {@inheritDoc}
         * 
         * @param x {@inheritDoc}
         * @implNote The default implementation calls {@link #acceptChar}
         */
        @Override
        default void accept(java.lang.Character x) {
            acceptChar(x);
        }

        /**
         * Composes a {@code OfChar} using {@code this} and the argument. The
         * composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code double}
         * @return a {@code OfChar} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfChar andThenDouble(OfDouble after) {
            return x -> {
                acceptChar(x);
                after.acceptDouble(x);
            };
        }

        /**
         * Composes a {@code OfChar} using {@code this} and the argument. The
         * composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code long}
         * @return a {@code OfChar} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfChar andThenLong(OfLong after) {
            return x -> {
                acceptChar(x);
                after.acceptLong(x);
            };
        }

        /**
         * Composes a {@code OfChar} using {@code this} and the argument. The
         * composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code int}
         * @return a {@code OfChar} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfChar andThenInt(OfInt after) {
            return x -> {
                acceptChar(x);
                after.acceptInt(x);
            };
        }

        /**
         * Composes a {@code OfChar} using {@code this} and the argument. The
         * composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code float}
         * @return a {@code OfChar} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfChar andThenFloat(OfFloat after) {
            return x -> {
                acceptChar(x);
                after.acceptFloat(x);
            };
        }

        /**
         * Composes a {@code OfChar} using {@code this} and the argument. The
         * composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code char}
         * @return a {@code OfChar} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfChar andThenChar(OfChar after) {
            return x -> {
                acceptChar(x);
                after.acceptChar(x);
            };
        }

        /**
         * Composes a {@code OfChar} using {@code this} and the argument. The
         * composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code short}
         * @return a {@code OfChar} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfChar andThenShort(OfShort after) {
            return x -> {
                acceptChar(x);
                after.acceptShort((short) x);
            };
        }

        /**
         * Composes a {@code OfChar} using {@code this} and the argument. The
         * composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code byte}
         * @return a {@code OfChar} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfChar andThenByte(OfByte after) {
            return x -> {
                acceptChar(x);
                after.acceptByte((byte) x);
            };
        }

        /**
         * Composes a {@code OfChar} using {@code this} and the argument. The
         * composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code boolean}
         * @return a {@code OfChar} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfChar andThenBoolean(OfBoolean after) {
            return x -> {
                acceptChar(x);
                after.acceptBoolean(x != 0);
            };
        }
    }

    /**
     * A consumer that requires a {@code short} argument. This is the {@code short}
     * specialisation
     * of {@link PrimitiveConsumer}
     * 
     * @see PrimitiveConsumer
     * @see Consumer
     */
    @FunctionalInterface
    interface OfShort extends PrimitiveConsumer<java.lang.Short> {
        /**
         * Consumes the input, possibly with side-effects
         * 
         * @param x the input to be consumed
         * @apiNote This is the primitive specialisation of {@link #accept} hence it is
         *          recommended
         *          that this be used instead
         */
        void acceptShort(short x);

        /**
         * {@inheritDoc}
         * 
         * @param x {@inheritDoc}
         * @implNote The default implementation calls {@link #acceptShort}
         */
        @Override
        default void accept(java.lang.Short x) {
            acceptShort(x);
        }

        /**
         * Composes a {@code OfShort} using {@code this} and the argument. The
         * composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code double}
         * @return a {@code OfShort} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfShort andThenDouble(OfDouble after) {
            return x -> {
                acceptShort(x);
                after.acceptDouble(x);
            };
        }

        /**
         * Composes a {@code OfShort} using {@code this} and the argument. The
         * composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code long}
         * @return a {@code OfShort} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfShort andThenLong(OfLong after) {
            return x -> {
                acceptShort(x);
                after.acceptLong(x);
            };
        }

        /**
         * Composes a {@code OfShort} using {@code this} and the argument. The
         * composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code int}
         * @return a {@code OfShort} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfShort andThenInt(OfInt after) {
            return x -> {
                acceptShort(x);
                after.acceptInt(x);
            };
        }

        /**
         * Composes a {@code OfShort} using {@code this} and the argument. The
         * composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code float}
         * @return a {@code OfShort} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfShort andThenFloat(OfFloat after) {
            return x -> {
                acceptShort(x);
                after.acceptFloat(x);
            };
        }

        /**
         * Composes a {@code OfShort} using {@code this} and the argument. The
         * composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code char}
         * @return a {@code OfShort} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfShort andThenChar(OfChar after) {
            return x -> {
                acceptShort(x);
                after.acceptChar((char) x);
            };
        }

        /**
         * Composes a {@code OfShort} using {@code this} and the argument. The
         * composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code short}
         * @return a {@code OfShort} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfShort andThenShort(OfShort after) {
            return x -> {
                acceptShort(x);
                after.acceptShort(x);
            };
        }

        /**
         * Composes a {@code OfShort} using {@code this} and the argument. The
         * composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code byte}
         * @return a {@code OfShort} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfShort andThenByte(OfByte after) {
            return x -> {
                acceptShort(x);
                after.acceptByte((byte) x);
            };
        }

        /**
         * Composes a {@code OfShort} using {@code this} and the argument. The
         * composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code boolean}
         * @return a {@code OfShort} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfShort andThenBoolean(OfBoolean after) {
            return x -> {
                acceptShort(x);
                after.acceptBoolean(x != 0);
            };
        }
    }

    /**
     * A consumer that requires a {@code byte} argument. This is the {@code byte}
     * specialisation
     * of {@link PrimitiveConsumer}
     * 
     * @see PrimitiveConsumer
     * @see Consumer
     */
    @FunctionalInterface
    interface OfByte extends PrimitiveConsumer<java.lang.Byte> {
        /**
         * Consumes the input, possibly with side-effects
         * 
         * @param x the input to be consumed
         * @apiNote This is the primitive specialisation of {@link #accept} hence it is
         *          recommended
         *          that this be used instead
         */
        void acceptByte(byte x);

        /**
         * {@inheritDoc}
         * 
         * @param x {@inheritDoc}
         * @implNote The default implementation calls {@link #acceptByte}
         */
        @Override
        default void accept(java.lang.Byte x) {
            acceptByte(x);
        }

        /**
         * Composes a {@code OfByte} using {@code this} and the argument. The
         * composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code double}
         * @return a {@code OfByte} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfByte andThenDouble(OfDouble after) {
            return x -> {
                acceptByte(x);
                after.acceptDouble(x);
            };
        }

        /**
         * Composes a {@code OfByte} using {@code this} and the argument. The
         * composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code long}
         * @return a {@code OfByte} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfByte andThenLong(OfLong after) {
            return x -> {
                acceptByte(x);
                after.acceptLong(x);
            };
        }

        /**
         * Composes a {@code OfByte} using {@code this} and the argument. The
         * composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code int}
         * @return a {@code OfByte} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfByte andThenInt(OfInt after) {
            return x -> {
                acceptByte(x);
                after.acceptInt(x);
            };
        }

        /**
         * Composes a {@code OfByte} using {@code this} and the argument. The
         * composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code float}
         * @return a {@code OfByte} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfByte andThenFloat(OfFloat after) {
            return x -> {
                acceptByte(x);
                after.acceptFloat(x);
            };
        }

        /**
         * Composes a {@code OfByte} using {@code this} and the argument. The
         * composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code char}
         * @return a {@code OfByte} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfByte andThenChar(OfChar after) {
            return x -> {
                acceptByte(x);
                after.acceptChar((char) x);
            };
        }

        /**
         * Composes a {@code OfByte} using {@code this} and the argument. The
         * composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code short}
         * @return a {@code OfByte} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfByte andThenShort(OfShort after) {
            return x -> {
                acceptByte(x);
                after.acceptShort(x);
            };
        }

        /**
         * Composes a {@code OfByte} using {@code this} and the argument. The
         * composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code byte}
         * @return a {@code OfByte} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfByte andThenByte(OfByte after) {
            return x -> {
                acceptByte(x);
                after.acceptByte(x);
            };
        }

        /**
         * Composes a {@code OfByte} using {@code this} and the argument. The
         * composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code boolean}
         * @return a {@code OfByte} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfByte andThenBoolean(OfBoolean after) {
            return x -> {
                acceptByte(x);
                after.acceptBoolean(x != 0);
            };
        }
    }

    /**
     * A consumer that requires a {@code boolean} argument. This is the
     * {@code boolean} specialisation
     * of {@link PrimitiveConsumer}
     * 
     * @see PrimitiveConsumer
     * @see Consumer
     */
    @FunctionalInterface
    interface OfBoolean extends PrimitiveConsumer<java.lang.Boolean> {
        /**
         * Consumes the input, possibly with side-effects
         * 
         * @param x the input to be consumed
         * @apiNote This is the primitive specialisation of {@link #accept} hence it is
         *          recommended
         *          that this be used instead
         */
        void acceptBoolean(boolean x);

        /**
         * {@inheritDoc}
         * 
         * @param x {@inheritDoc}
         * @implNote The default implementation calls {@link #acceptBoolean}
         */
        @Override
        default void accept(java.lang.Boolean x) {
            acceptBoolean(x);
        }

        /**
         * Composes a {@code OfBoolean} using {@code this} and the argument. The
         * composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code double}
         * @return a {@code OfBoolean} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfBoolean andThenDouble(OfDouble after) {
            return x -> {
                acceptBoolean(x);
                after.acceptDouble(x ? 1 : 0);
            };
        }

        /**
         * Composes a {@code OfBoolean} using {@code this} and the argument. The
         * composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code long}
         * @return a {@code OfBoolean} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfBoolean andThenLong(OfLong after) {
            return x -> {
                acceptBoolean(x);
                after.acceptLong(x ? 1 : 0);
            };
        }

        /**
         * Composes a {@code OfBoolean} using {@code this} and the argument. The
         * composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code int}
         * @return a {@code OfBoolean} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfBoolean andThenInt(OfInt after) {
            return x -> {
                acceptBoolean(x);
                after.acceptInt(x ? 1 : 0);
            };
        }

        /**
         * Composes a {@code OfBoolean} using {@code this} and the argument. The
         * composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code float}
         * @return a {@code OfBoolean} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfBoolean andThenFloat(OfFloat after) {
            return x -> {
                acceptBoolean(x);
                after.acceptFloat(x ? 1 : 0);
            };
        }

        /**
         * Composes a {@code OfBoolean} using {@code this} and the argument. The
         * composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code char}
         * @return a {@code OfBoolean} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfBoolean andThenChar(OfChar after) {
            return x -> {
                acceptBoolean(x);
                after.acceptChar((char) (x ? 1 : 0));
            };
        }

        /**
         * Composes a {@code OfBoolean} using {@code this} and the argument. The
         * composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code short}
         * @return a {@code OfBoolean} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfBoolean andThenShort(OfShort after) {
            return x -> {
                acceptBoolean(x);
                after.acceptShort((short) (x ? 1 : 0));
            };
        }

        /**
         * Composes a {@code OfBoolean} using {@code this} and the argument. The
         * composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code byte}
         * @return a {@code OfBoolean} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfBoolean andThenByte(OfByte after) {
            return x -> {
                acceptBoolean(x);
                after.acceptByte((byte) (x ? 1 : 0));
            };
        }

        /**
         * Composes a {@code OfBoolean} using {@code this} and the argument. The
         * composition
         * itself comprises of performing, in sequence, this operation and that of the
         * argument.
         * 
         * @param after a consumer that expects a {@code boolean}
         * @return a {@code OfBoolean} consumer
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(Consumer)}
         * @see Consumer#andThen(Consumer)
         */
        default OfBoolean andThenBoolean(OfBoolean after) {
            return x -> {
                acceptBoolean(x);
                after.acceptBoolean(x);
            };
        }
    }
}
