package jdk.prim.util.function;

import java.util.function.BiConsumer;

/**
 * 
 * An interface that provides primitive support for the {@code BiConsumer}
 * interface.
 * Support exists for a primitive for every parameter and every case - from
 * those where
 * only one of the parameters is a primitive ({@code OFXxx} and {@code AndXxx})
 * to those
 * where all parameters are primitives.
 * 
 * <p>
 * It also defines primitive alternatives for {@link #andThen(BiConsumer)}.
 * <p>
 * It uses the following interface naming convention: {@code Of*} refers to the
 * first argument,
 * {@code And*} refers to the second argument. When they are nested, then the
 * convention remains mostly the same.
 * <p>
 * Note that no exception handling is done on any of the methods
 * ({@code default} or otherwise)
 * in these interfaces. If an exception is thrown in any method, the behaviour
 * of that method will
 * be similar to it's JDK equivalent.
 * 
 * @param <OF>  the first argument to {@link #accept(Object, Object)}
 * @param <AND> the second argument to {@link #accept(Object, Object)}
 * 
 * @see BiConsumer
 */
@FunctionalInterface
public interface PrimitiveBiConsumer<OF, AND> extends BiConsumer<OF, AND> {

    /**
     * A {@code PrimitiveBiConsumer} that requires a {@code double} and a
     * value of type {@code <AND>}.
     * 
     * @param <AND> the type of the second argument to {@link #acceptDouble}
     * @see PrimitiveBiConsumer
     */
    @FunctionalInterface
    interface OfDouble<AND> extends PrimitiveBiConsumer<java.lang.Double, AND> {
        /**
         * Consumes the arguments (with possible side-effects) returning no result.
         * 
         * @param x the first {@code double} input
         * @param y the second input
         * @apiNote This is the {@code double} specialisation of
         *          {@link #accept(Double, Object)} and
         *          is recommended over the same.
         */
        void acceptDouble(double x, AND y);

        /**
         * {@inheritDoc}
         * 
         * @param x {@inheritDoc}
         * @param y {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote This calls {@link #acceptDouble} unboxing the wrapper
         *           {@code Double}
         *           (first argument) to a primitive
         */
        @Override
        default void accept(java.lang.Double x, AND y) {
            acceptDouble(x, y);
        }

        /**
         * Composes and returns a {@code OfDouble} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires a {@code double} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code double} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfDouble<AND> andThenDouble(OfDouble<? super AND> after) {
            return (x, y) -> {
                acceptDouble(x, y);
                after.acceptDouble(x, y);
            };
        }

        /**
         * Composes and returns a {@code OfDouble} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires a {@code long} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code double} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfDouble<AND> andThenLong(OfLong<? super AND> after) {
            return (x, y) -> {
                acceptDouble(x, y);
                after.acceptLong((long) x, y);
            };
        }

        /**
         * Composes and returns a {@code OfDouble} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires an {@code int} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code double} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfDouble<AND> andThenInt(OfInt<? super AND> after) {
            return (x, y) -> {
                acceptDouble(x, y);
                after.acceptInt((int) x, y);
            };
        }

        /**
         * Composes and returns a {@code OfDouble} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires a {@code float} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code double} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfDouble<AND> andThenFloat(OfFloat<? super AND> after) {
            return (x, y) -> {
                acceptDouble(x, y);
                after.acceptFloat((float) x, y);
            };
        }

        /**
         * Composes and returns a {@code OfDouble} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires a {@code char} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code double} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfDouble<AND> andThenChar(OfChar<? super AND> after) {
            return (x, y) -> {
                acceptDouble(x, y);
                after.acceptChar((char) x, y);
            };
        }

        /**
         * Composes and returns a {@code OfDouble} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires a {@code short} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code double} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfDouble<AND> andThenShort(OfShort<? super AND> after) {
            return (x, y) -> {
                acceptDouble(x, y);
                after.acceptShort((short) x, y);
            };
        }

        /**
         * Composes and returns a {@code OfDouble} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires a {@code byte} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code double} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfDouble<AND> andThenByte(OfByte<? super AND> after) {
            return (x, y) -> {
                acceptDouble(x, y);
                after.acceptByte((byte) x, y);
            };
        }

        /**
         * Composes and returns a {@code OfDouble} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires a {@code boolean} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code double} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfDouble<AND> andThenBoolean(OfBoolean<? super AND> after) {
            return (x, y) -> {
                acceptDouble(x, y);
                after.acceptBoolean(x != 0, y);
            };
        }

        /**
         * A {@code OfDouble} that requires a {@code double} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndDouble extends OfDouble<java.lang.Double> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptDouble(double, java.lang.Double)}
             *          and is recommended over that one.
             */
            void acceptDouble(double x, double y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptDouble(double x, java.lang.Double y) {
                acceptDouble(x, (double) y);
            }

            /**
             * Composes and returns a {@code OfDouble.AndDouble} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code double}
             *              value
             * @return a consumer that accepts a {@code double} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndDouble andThenDouble(OfDouble.AndDouble after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptDouble(x, y);
                };
            }

            /**
             * Composes and returns a {@code OfDouble.AndDouble} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code double}
             *              value
             * @return a consumer that accepts a {@code double} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndDouble andThenLong(OfLong.AndDouble after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptLong((long) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfDouble.AndDouble} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code double}
             *              value
             * @return a consumer that accepts a {@code double} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndDouble andThenInt(OfInt.AndDouble after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptInt((int) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfDouble.AndDouble} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code double}
             *              value
             * @return a consumer that accepts a {@code double} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndDouble andThenFloat(OfFloat.AndDouble after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptFloat((float) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfDouble.AndDouble} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code double}
             *              value
             * @return a consumer that accepts a {@code double} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndDouble andThenChar(OfChar.AndDouble after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptChar((char) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfDouble.AndDouble} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code double}
             *              value
             * @return a consumer that accepts a {@code double} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndDouble andThenShort(OfShort.AndDouble after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptShort((short) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfDouble.AndDouble} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code double}
             *              value
             * @return a consumer that accepts a {@code double} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndDouble andThenByte(OfByte.AndDouble after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptByte((byte) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfDouble.AndDouble} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code double}
             *              value
             * @return a consumer that accepts a {@code double} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndDouble andThenBoolean(OfBoolean.AndDouble after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptBoolean(x != 0, y);
                };
            }
        }

        /**
         * A {@code OfDouble} that requires a {@code long} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndLong extends OfDouble<java.lang.Long> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptDouble(double, java.lang.Long)}
             *          and is recommended over that one.
             */
            void acceptDouble(double x, long y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptDouble(double x, java.lang.Long y) {
                acceptDouble(x, (long) y);
            }

            /**
             * Composes and returns a {@code OfLong.AndLong} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code long}
             *              value
             * @return a consumer that accepts a {@code double} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndLong andThenDouble(OfDouble.AndLong after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptDouble(x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndLong} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code long} value
             * @return a consumer that accepts a {@code double} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndLong andThenLong(OfLong.AndLong after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptLong((long) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndLong} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code long} value
             * @return a consumer that accepts a {@code double} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndLong andThenInt(OfInt.AndLong after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptInt((int) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndLong} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code long}
             *              value
             * @return a consumer that accepts a {@code double} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndLong andThenFloat(OfFloat.AndLong after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptFloat((float) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndLong} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code long} value
             * @return a consumer that accepts a {@code double} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndLong andThenChar(OfChar.AndLong after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptChar((char) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndLong} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code long}
             *              value
             * @return a consumer that accepts a {@code double} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndLong andThenShort(OfShort.AndLong after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptShort((short) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndLong} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code long} value
             * @return a consumer that accepts a {@code double} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndLong andThenByte(OfByte.AndLong after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptByte((byte) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndLong} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code long}
             *              value
             * @return a consumer that accepts a {@code double} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndLong andThenBoolean(OfBoolean.AndLong after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptBoolean(x != 0, y);
                };
            }
        }

        /**
         * A {@code OfDouble} that requires a {@code int} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndInt extends OfDouble<java.lang.Integer> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptDouble(double, java.lang.Integer)}
             *          and is recommended over that one.
             */
            void acceptDouble(double x, int y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptDouble(double x, java.lang.Integer y) {
                acceptDouble(x, (int) y);
            }

            /**
             * Composes and returns a {@code OfInt.AndInt} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code int}
             *              value
             * @return a consumer that accepts a {@code double} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndInt andThenDouble(OfDouble.AndInt after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptDouble(x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndInt} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code int} value
             * @return a consumer that accepts a {@code double} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndInt andThenLong(OfLong.AndInt after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptLong((long) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndInt} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code int} value
             * @return a consumer that accepts a {@code double} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndInt andThenInt(OfInt.AndInt after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptInt((int) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndInt} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code int} value
             * @return a consumer that accepts a {@code double} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndInt andThenFloat(OfFloat.AndInt after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptFloat((float) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndInt} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code int} value
             * @return a consumer that accepts a {@code double} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndInt andThenChar(OfChar.AndInt after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptChar((char) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndInt} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code int} value
             * @return a consumer that accepts a {@code double} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndInt andThenShort(OfShort.AndInt after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptShort((short) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndInt} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code int} value
             * @return a consumer that accepts a {@code double} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndInt andThenByte(OfByte.AndInt after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptByte((byte) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndInt} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code int}
             *              value
             * @return a consumer that accepts a {@code double} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndInt andThenBoolean(OfBoolean.AndInt after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptBoolean(x != 0, y);
                };
            }
        }

        /**
         * A {@code OfDouble} that requires a {@code float} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndFloat extends OfDouble<java.lang.Float> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptDouble(double, java.lang.Float)}
             *          and is recommended over that one.
             */
            void acceptDouble(double x, float y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptDouble(double x, java.lang.Float y) {
                acceptDouble(x, (float) y);
            }

            /**
             * Composes and returns a {@code OfFloat.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code float}
             *              value
             * @return a consumer that accepts a {@code double} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndFloat andThenDouble(OfDouble.AndFloat after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptDouble(x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code float}
             *              value
             * @return a consumer that accepts a {@code double} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndFloat andThenLong(OfLong.AndFloat after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptLong((long) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code float}
             *              value
             * @return a consumer that accepts a {@code double} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndFloat andThenInt(OfInt.AndFloat after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptInt((int) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code float}
             *              value
             * @return a consumer that accepts a {@code double} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndFloat andThenFloat(OfFloat.AndFloat after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptFloat((float) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code float}
             *              value
             * @return a consumer that accepts a {@code double} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndFloat andThenChar(OfChar.AndFloat after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptChar((char) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code float}
             *              value
             * @return a consumer that accepts a {@code double} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndFloat andThenShort(OfShort.AndFloat after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptShort((short) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code float}
             *              value
             * @return a consumer that accepts a {@code double} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndFloat andThenByte(OfByte.AndFloat after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptByte((byte) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code float}
             *              value
             * @return a consumer that accepts a {@code double} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndFloat andThenBoolean(OfBoolean.AndFloat after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptBoolean(x != 0, y);
                };
            }
        }

        /**
         * A {@code OfDouble} that requires a {@code char} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndChar extends OfDouble<java.lang.Character> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptDouble(double, java.lang.Character)}
             *          and is recommended over that one.
             */
            void acceptDouble(double x, char y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptDouble(double x, java.lang.Character y) {
                acceptDouble(x, (char) y);
            }

            /**
             * Composes and returns a {@code OfChar.AndChar} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code char}
             *              value
             * @return a consumer that accepts a {@code double} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndChar andThenDouble(OfDouble.AndChar after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptDouble(x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndChar} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code char} value
             * @return a consumer that accepts a {@code double} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndChar andThenLong(OfLong.AndChar after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptLong((long) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndChar} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code char} value
             * @return a consumer that accepts a {@code double} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndChar andThenInt(OfInt.AndChar after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptInt((int) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndChar} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code char}
             *              value
             * @return a consumer that accepts a {@code double} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndChar andThenFloat(OfFloat.AndChar after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptFloat((float) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndChar} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code char} value
             * @return a consumer that accepts a {@code double} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndChar andThenChar(OfChar.AndChar after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptChar((char) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndChar} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code char}
             *              value
             * @return a consumer that accepts a {@code double} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndChar andThenShort(OfShort.AndChar after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptShort((short) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndChar} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code char} value
             * @return a consumer that accepts a {@code double} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndChar andThenByte(OfByte.AndChar after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptByte((byte) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndChar} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code char}
             *              value
             * @return a consumer that accepts a {@code double} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndChar andThenBoolean(OfBoolean.AndChar after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptBoolean(x != 0, y);
                };
            }
        }

        /**
         * A {@code OfDouble} that requires a {@code short} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndShort extends OfDouble<java.lang.Short> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptDouble(double, java.lang.Short)}
             *          and is recommended over that one.
             */
            void acceptDouble(double x, short y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptDouble(double x, java.lang.Short y) {
                acceptDouble(x, (short) y);
            }

            /**
             * Composes and returns a {@code OfShort.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code short}
             *              value
             * @return a consumer that accepts a {@code double} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndShort andThenDouble(OfDouble.AndShort after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptDouble(x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code short}
             *              value
             * @return a consumer that accepts a {@code double} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndShort andThenLong(OfLong.AndShort after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptLong((long) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code short}
             *              value
             * @return a consumer that accepts a {@code double} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndShort andThenInt(OfInt.AndShort after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptInt((int) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code short}
             *              value
             * @return a consumer that accepts a {@code double} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndShort andThenFloat(OfFloat.AndShort after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptFloat((float) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code short}
             *              value
             * @return a consumer that accepts a {@code double} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndShort andThenChar(OfChar.AndShort after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptChar((char) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code short}
             *              value
             * @return a consumer that accepts a {@code double} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndShort andThenShort(OfShort.AndShort after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptShort((short) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code short}
             *              value
             * @return a consumer that accepts a {@code double} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndShort andThenByte(OfByte.AndShort after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptByte((byte) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code short}
             *              value
             * @return a consumer that accepts a {@code double} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndShort andThenBoolean(OfBoolean.AndShort after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptBoolean(x != 0, y);
                };
            }
        }

        /**
         * A {@code OfDouble} that requires a {@code byte} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndByte extends OfDouble<java.lang.Byte> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptDouble(double, java.lang.Byte)}
             *          and is recommended over that one.
             */
            void acceptDouble(double x, byte y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptDouble(double x, java.lang.Byte y) {
                acceptDouble(x, (byte) y);
            }

            /**
             * Composes and returns a {@code OfByte.AndByte} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code byte}
             *              value
             * @return a consumer that accepts a {@code double} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndByte andThenDouble(OfDouble.AndByte after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptDouble(x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndByte} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code byte} value
             * @return a consumer that accepts a {@code double} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndByte andThenLong(OfLong.AndByte after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptLong((long) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndByte} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code byte} value
             * @return a consumer that accepts a {@code double} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndByte andThenInt(OfInt.AndByte after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptInt((int) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndByte} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code byte}
             *              value
             * @return a consumer that accepts a {@code double} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndByte andThenFloat(OfFloat.AndByte after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptFloat((float) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndByte} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code byte} value
             * @return a consumer that accepts a {@code double} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndByte andThenChar(OfChar.AndByte after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptChar((char) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndByte} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code byte}
             *              value
             * @return a consumer that accepts a {@code double} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndByte andThenShort(OfShort.AndByte after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptShort((short) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndByte} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code byte} value
             * @return a consumer that accepts a {@code double} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndByte andThenByte(OfByte.AndByte after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptByte((byte) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndByte} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code byte}
             *              value
             * @return a consumer that accepts a {@code double} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndByte andThenBoolean(OfBoolean.AndByte after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptBoolean(x != 0, y);
                };
            }
        }

        /**
         * A {@code OfDouble} that requires a {@code boolean} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndBoolean extends OfDouble<java.lang.Boolean> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptDouble(double, java.lang.Boolean)}
             *          and is recommended over that one.
             */
            void acceptDouble(double x, boolean y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptDouble(double x, java.lang.Boolean y) {
                acceptDouble(x, (boolean) y);
            }

            /**
             * Composes and returns a {@code OfBoolean.AndBoolean} that performs, in
             * sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code boolean}
             *              value
             * @return a consumer that accepts a {@code double} and a {@code boolean} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndBoolean andThenDouble(OfDouble.AndBoolean after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptDouble(x, y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndBoolean} that performs, in
             * sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code boolean}
             *              value
             * @return a consumer that accepts a {@code double} and a {@code boolean} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndBoolean andThenLong(OfLong.AndBoolean after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptLong((long) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndBoolean} that performs, in
             * sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code boolean}
             *              value
             * @return a consumer that accepts a {@code double} and a {@code boolean} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndBoolean andThenInt(OfInt.AndBoolean after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptInt((int) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndBoolean} that performs, in
             * sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code boolean}
             *              value
             * @return a consumer that accepts a {@code double} and a {@code boolean} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndBoolean andThenFloat(OfFloat.AndBoolean after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptFloat((float) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndBoolean} that performs, in
             * sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code boolean}
             *              value
             * @return a consumer that accepts a {@code double} and a {@code boolean} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndBoolean andThenChar(OfChar.AndBoolean after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptChar((char) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndBoolean} that performs, in
             * sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code boolean}
             *              value
             * @return a consumer that accepts a {@code double} and a {@code boolean} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndBoolean andThenShort(OfShort.AndBoolean after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptShort((short) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndBoolean} that performs, in
             * sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code boolean}
             *              value
             * @return a consumer that accepts a {@code double} and a {@code boolean} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndBoolean andThenByte(OfByte.AndBoolean after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptByte((byte) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndBoolean} that performs, in
             * sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code boolean}
             *              value
             * @return a consumer that accepts a {@code double} and a {@code boolean} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfDouble.AndBoolean andThenBoolean(OfBoolean.AndBoolean after) {
                return (x, y) -> {
                    acceptDouble(x, y);
                    after.acceptBoolean(x != 0, y);
                };
            }
        }
    }

    /**
     * A {@code PrimitiveBiConsumer} that requires a {@code long} and a
     * value of type {@code <AND>}.
     * 
     * @param <AND> the type of the second argument to {@link #acceptLong}
     * @see PrimitiveBiConsumer
     */
    @FunctionalInterface
    interface OfLong<AND> extends PrimitiveBiConsumer<java.lang.Long, AND> {
        /**
         * Consumes the arguments (with possible side-effects) returning no result.
         * 
         * @param x the first {@code long} input
         * @param y the second input
         * @apiNote This is the {@code long} specialisation of
         *          {@link #accept(Double, Object)} and
         *          is recommended over the same.
         */
        void acceptLong(long x, AND y);

        /**
         * {@inheritDoc}
         * 
         * @param x {@inheritDoc}
         * @param y {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote This calls {@link #acceptLong} unboxing the wrapper {@code Long}
         *           (first argument) to a primitive
         */
        @Override
        default void accept(java.lang.Long x, AND y) {
            acceptLong(x, y);
        }

        /**
         * Composes and returns a {@code OfLong} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires a {@code double} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code long} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfLong<AND> andThenDouble(OfDouble<? super AND> after) {
            return (x, y) -> {
                acceptLong(x, y);
                after.acceptDouble(x, y);
            };
        }

        /**
         * Composes and returns a {@code OfLong} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires a {@code long} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code long} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfLong<AND> andThenLong(OfLong<? super AND> after) {
            return (x, y) -> {
                acceptLong(x, y);
                after.acceptLong(x, y);
            };
        }

        /**
         * Composes and returns a {@code OfLong} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires an {@code int} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code long} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfLong<AND> andThenInt(OfInt<? super AND> after) {
            return (x, y) -> {
                acceptLong(x, y);
                after.acceptInt((int) x, y);
            };
        }

        /**
         * Composes and returns a {@code OfLong} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires a {@code float} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code long} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfLong<AND> andThenFloat(OfFloat<? super AND> after) {
            return (x, y) -> {
                acceptLong(x, y);
                after.acceptFloat(x, y);
            };
        }

        /**
         * Composes and returns a {@code OfLong} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires a {@code char} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code long} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfLong<AND> andThenChar(OfChar<? super AND> after) {
            return (x, y) -> {
                acceptLong(x, y);
                after.acceptChar((char) x, y);
            };
        }

        /**
         * Composes and returns a {@code OfLong} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires a {@code short} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code long} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfLong<AND> andThenShort(OfShort<? super AND> after) {
            return (x, y) -> {
                acceptLong(x, y);
                after.acceptShort((short) x, y);
            };
        }

        /**
         * Composes and returns a {@code OfLong} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires a {@code byte} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code long} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfLong<AND> andThenByte(OfByte<? super AND> after) {
            return (x, y) -> {
                acceptLong(x, y);
                after.acceptByte((byte) x, y);
            };
        }

        /**
         * Composes and returns a {@code OfLong} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires a {@code boolean} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code long} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfLong<AND> andThenBoolean(OfBoolean<? super AND> after) {
            return (x, y) -> {
                acceptLong(x, y);
                after.acceptBoolean(x != 0, y);
            };
        }

        /**
         * A {@code OfLong} that requires a {@code double} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndDouble extends OfLong<java.lang.Double> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptLong(long, java.lang.Double)}
             *          and is recommended over that one.
             */
            void acceptLong(long x, double y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptLong(long x, java.lang.Double y) {
                acceptLong(x, (double) y);
            }

            /**
             * Composes and returns a {@code OfLong.AndDouble} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code double}
             *              value
             * @return a consumer that accepts a {@code long} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndDouble andThenDouble(OfDouble.AndDouble after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptDouble(x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndDouble} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code double}
             *              value
             * @return a consumer that accepts a {@code long} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndDouble andThenLong(OfLong.AndDouble after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptLong((long) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndDouble} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code double}
             *              value
             * @return a consumer that accepts a {@code long} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndDouble andThenInt(OfInt.AndDouble after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptInt((int) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndDouble} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code double}
             *              value
             * @return a consumer that accepts a {@code long} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndDouble andThenFloat(OfFloat.AndDouble after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptFloat((float) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndDouble} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code double}
             *              value
             * @return a consumer that accepts a {@code long} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndDouble andThenChar(OfChar.AndDouble after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptChar((char) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndDouble} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code double}
             *              value
             * @return a consumer that accepts a {@code long} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndDouble andThenShort(OfShort.AndDouble after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptShort((short) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndDouble} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code double}
             *              value
             * @return a consumer that accepts a {@code long} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndDouble andThenByte(OfByte.AndDouble after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptByte((byte) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndDouble} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code double}
             *              value
             * @return a consumer that accepts a {@code long} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndDouble andThenBoolean(OfBoolean.AndDouble after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptBoolean(x != 0, y);
                };
            }
        }

        /**
         * A {@code OfLong} that requires a {@code long} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndLong extends OfLong<java.lang.Long> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptLong(long, java.lang.Long)}
             *          and is recommended over that one.
             */
            void acceptLong(long x, long y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptLong(long x, java.lang.Long y) {
                acceptLong(x, (long) y);
            }

            /**
             * Composes and returns a {@code OfLong.AndLong} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code long}
             *              value
             * @return a consumer that accepts a {@code long} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndLong andThenDouble(OfDouble.AndLong after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptDouble(x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndLong} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code long} value
             * @return a consumer that accepts a {@code long} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndLong andThenLong(OfLong.AndLong after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptLong((long) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndLong} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code long} value
             * @return a consumer that accepts a {@code long} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndLong andThenInt(OfInt.AndLong after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptInt((int) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndLong} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code long}
             *              value
             * @return a consumer that accepts a {@code long} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndLong andThenFloat(OfFloat.AndLong after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptFloat((float) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndLong} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code long} value
             * @return a consumer that accepts a {@code long} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndLong andThenChar(OfChar.AndLong after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptChar((char) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndLong} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code long}
             *              value
             * @return a consumer that accepts a {@code long} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndLong andThenShort(OfShort.AndLong after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptShort((short) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndLong} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code long} value
             * @return a consumer that accepts a {@code long} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndLong andThenByte(OfByte.AndLong after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptByte((byte) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndLong} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code long}
             *              value
             * @return a consumer that accepts a {@code long} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndLong andThenBoolean(OfBoolean.AndLong after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptBoolean(x != 0, y);
                };
            }
        }

        /**
         * A {@code OfLong} that requires a {@code int} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndInt extends OfLong<java.lang.Integer> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptLong(long, java.lang.Integer)}
             *          and is recommended over that one.
             */
            void acceptLong(long x, int y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptLong(long x, java.lang.Integer y) {
                acceptLong(x, (int) y);
            }

            /**
             * Composes and returns a {@code OfLong.AndInt} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code int}
             *              value
             * @return a consumer that accepts a {@code long} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndInt andThenDouble(OfDouble.AndInt after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptDouble(x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndInt} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code int} value
             * @return a consumer that accepts a {@code long} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndInt andThenLong(OfLong.AndInt after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptLong((long) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndInt} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code int} value
             * @return a consumer that accepts a {@code long} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndInt andThenInt(OfInt.AndInt after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptInt((int) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndInt} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code int} value
             * @return a consumer that accepts a {@code long} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndInt andThenFloat(OfFloat.AndInt after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptFloat((float) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndInt} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code int} value
             * @return a consumer that accepts a {@code long} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndInt andThenChar(OfChar.AndInt after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptChar((char) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndInt} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code int} value
             * @return a consumer that accepts a {@code long} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndInt andThenShort(OfShort.AndInt after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptShort((short) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndInt} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code int} value
             * @return a consumer that accepts a {@code long} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndInt andThenByte(OfByte.AndInt after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptByte((byte) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndInt} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code int}
             *              value
             * @return a consumer that accepts a {@code long} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndInt andThenBoolean(OfBoolean.AndInt after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptBoolean(x != 0, y);
                };
            }
        }

        /**
         * A {@code OfLong} that requires a {@code float} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndFloat extends OfLong<java.lang.Float> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptLong(long, java.lang.Float)}
             *          and is recommended over that one.
             */
            void acceptLong(long x, float y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptLong(long x, java.lang.Float y) {
                acceptLong(x, (float) y);
            }

            /**
             * Composes and returns a {@code OfLong.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code float}
             *              value
             * @return a consumer that accepts a {@code long} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndFloat andThenDouble(OfDouble.AndFloat after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptDouble(x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code float}
             *              value
             * @return a consumer that accepts a {@code long} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndFloat andThenLong(OfLong.AndFloat after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptLong((long) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code float}
             *              value
             * @return a consumer that accepts a {@code long} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndFloat andThenInt(OfInt.AndFloat after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptInt((int) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code float}
             *              value
             * @return a consumer that accepts a {@code long} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndFloat andThenFloat(OfFloat.AndFloat after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptFloat((float) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code float}
             *              value
             * @return a consumer that accepts a {@code long} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndFloat andThenChar(OfChar.AndFloat after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptChar((char) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code float}
             *              value
             * @return a consumer that accepts a {@code long} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndFloat andThenShort(OfShort.AndFloat after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptShort((short) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code float}
             *              value
             * @return a consumer that accepts a {@code long} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndFloat andThenByte(OfByte.AndFloat after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptByte((byte) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code float}
             *              value
             * @return a consumer that accepts a {@code long} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndFloat andThenBoolean(OfBoolean.AndFloat after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptBoolean(x != 0, y);
                };
            }
        }

        /**
         * A {@code OfLong} that requires a {@code char} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndChar extends OfLong<java.lang.Character> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptLong(long, java.lang.Character)}
             *          and is recommended over that one.
             */
            void acceptLong(long x, char y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptLong(long x, java.lang.Character y) {
                acceptLong(x, (char) y);
            }

            /**
             * Composes and returns a {@code OfLong.AndChar} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code char}
             *              value
             * @return a consumer that accepts a {@code long} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndChar andThenDouble(OfDouble.AndChar after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptDouble(x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndChar} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code char} value
             * @return a consumer that accepts a {@code long} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndChar andThenLong(OfLong.AndChar after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptLong((long) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndChar} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code char} value
             * @return a consumer that accepts a {@code long} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndChar andThenInt(OfInt.AndChar after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptInt((int) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndChar} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code char}
             *              value
             * @return a consumer that accepts a {@code long} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndChar andThenFloat(OfFloat.AndChar after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptFloat((float) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndChar} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code char} value
             * @return a consumer that accepts a {@code long} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndChar andThenChar(OfChar.AndChar after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptChar((char) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndChar} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code char}
             *              value
             * @return a consumer that accepts a {@code long} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndChar andThenShort(OfShort.AndChar after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptShort((short) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndChar} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code char} value
             * @return a consumer that accepts a {@code long} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndChar andThenByte(OfByte.AndChar after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptByte((byte) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndChar} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code char}
             *              value
             * @return a consumer that accepts a {@code long} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndChar andThenBoolean(OfBoolean.AndChar after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptBoolean(x != 0, y);
                };
            }
        }

        /**
         * A {@code OfLong} that requires a {@code short} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndShort extends OfLong<java.lang.Short> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptLong(long, java.lang.Short)}
             *          and is recommended over that one.
             */
            void acceptLong(long x, short y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptLong(long x, java.lang.Short y) {
                acceptLong(x, (short) y);
            }

            /**
             * Composes and returns a {@code OfLong.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code short}
             *              value
             * @return a consumer that accepts a {@code long} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndShort andThenDouble(OfDouble.AndShort after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptDouble(x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code short}
             *              value
             * @return a consumer that accepts a {@code long} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndShort andThenLong(OfLong.AndShort after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptLong((long) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code short}
             *              value
             * @return a consumer that accepts a {@code long} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndShort andThenInt(OfInt.AndShort after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptInt((int) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code short}
             *              value
             * @return a consumer that accepts a {@code long} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndShort andThenFloat(OfFloat.AndShort after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptFloat((float) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code short}
             *              value
             * @return a consumer that accepts a {@code long} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndShort andThenChar(OfChar.AndShort after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptChar((char) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code short}
             *              value
             * @return a consumer that accepts a {@code long} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndShort andThenShort(OfShort.AndShort after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptShort((short) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code short}
             *              value
             * @return a consumer that accepts a {@code long} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndShort andThenByte(OfByte.AndShort after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptByte((byte) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code short}
             *              value
             * @return a consumer that accepts a {@code long} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndShort andThenBoolean(OfBoolean.AndShort after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptBoolean(x != 0, y);
                };
            }
        }

        /**
         * A {@code OfLong} that requires a {@code byte} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndByte extends OfLong<java.lang.Byte> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptLong(long, java.lang.Byte)}
             *          and is recommended over that one.
             */
            void acceptLong(long x, byte y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptLong(long x, java.lang.Byte y) {
                acceptLong(x, (byte) y);
            }

            /**
             * Composes and returns a {@code OfLong.AndByte} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code byte}
             *              value
             * @return a consumer that accepts a {@code long} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndByte andThenDouble(OfDouble.AndByte after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptDouble(x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndByte} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code byte} value
             * @return a consumer that accepts a {@code long} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndByte andThenLong(OfLong.AndByte after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptLong((long) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndByte} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code byte} value
             * @return a consumer that accepts a {@code long} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndByte andThenInt(OfInt.AndByte after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptInt((int) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndByte} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code byte}
             *              value
             * @return a consumer that accepts a {@code long} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndByte andThenFloat(OfFloat.AndByte after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptFloat((float) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndByte} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code byte} value
             * @return a consumer that accepts a {@code long} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndByte andThenChar(OfChar.AndByte after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptChar((char) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndByte} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code byte}
             *              value
             * @return a consumer that accepts a {@code long} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndByte andThenShort(OfShort.AndByte after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptShort((short) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndByte} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code byte} value
             * @return a consumer that accepts a {@code long} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndByte andThenByte(OfByte.AndByte after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptByte((byte) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndByte} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code byte}
             *              value
             * @return a consumer that accepts a {@code long} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndByte andThenBoolean(OfBoolean.AndByte after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptBoolean(x != 0, y);
                };
            }
        }

        /**
         * A {@code OfLong} that requires a {@code boolean} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndBoolean extends OfLong<java.lang.Boolean> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptLong(long, java.lang.Boolean)}
             *          and is recommended over that one.
             */
            void acceptLong(long x, boolean y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptLong(long x, java.lang.Boolean y) {
                acceptLong(x, (boolean) y);
            }

            /**
             * Composes and returns a {@code OfLong.AndBoolean} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code boolean}
             *              value
             * @return a consumer that accepts a {@code long} and a {@code boolean} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndBoolean andThenDouble(OfDouble.AndBoolean after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptDouble(x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndBoolean} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code boolean}
             *              value
             * @return a consumer that accepts a {@code long} and a {@code boolean} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndBoolean andThenLong(OfLong.AndBoolean after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptLong((long) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndBoolean} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code boolean}
             *              value
             * @return a consumer that accepts a {@code long} and a {@code boolean} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndBoolean andThenInt(OfInt.AndBoolean after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptInt((int) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndBoolean} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code boolean}
             *              value
             * @return a consumer that accepts a {@code long} and a {@code boolean} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndBoolean andThenFloat(OfFloat.AndBoolean after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptFloat((float) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndBoolean} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code boolean}
             *              value
             * @return a consumer that accepts a {@code long} and a {@code boolean} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndBoolean andThenChar(OfChar.AndBoolean after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptChar((char) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndBoolean} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code boolean}
             *              value
             * @return a consumer that accepts a {@code long} and a {@code boolean} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndBoolean andThenShort(OfShort.AndBoolean after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptShort((short) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndBoolean} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code boolean}
             *              value
             * @return a consumer that accepts a {@code long} and a {@code boolean} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndBoolean andThenByte(OfByte.AndBoolean after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptByte((byte) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfLong.AndBoolean} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code boolean}
             *              value
             * @return a consumer that accepts a {@code long} and a {@code boolean} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfLong.AndBoolean andThenBoolean(OfBoolean.AndBoolean after) {
                return (x, y) -> {
                    acceptLong(x, y);
                    after.acceptBoolean(x != 0, y);
                };
            }
        }

    }

    /**
     * A {@code PrimitiveBiConsumer} that requires a {@code int} and a
     * value of type {@code <AND>}.
     * 
     * @param <AND> the type of the second argument to {@link #acceptInt}
     * @see PrimitiveBiConsumer
     */
    @FunctionalInterface
    interface OfInt<AND> extends PrimitiveBiConsumer<java.lang.Integer, AND> {
        /**
         * Consumes the arguments (with possible side-effects) returning no result.
         * 
         * @param x the first {@code int} input
         * @param y the second input
         * @apiNote This is the {@code int} specialisation of
         *          {@link #accept(Double, Object)} and
         *          is recommended over the same.
         */
        void acceptInt(int x, AND y);

        /**
         * {@inheritDoc}
         * 
         * @param x {@inheritDoc}
         * @param y {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote This calls {@link #acceptInt} unboxing the wrapper {@code Int}
         *           (first argument) to a primitive
         */
        @Override
        default void accept(java.lang.Integer x, AND y) {
            acceptInt(x, y);
        }

        /**
         * Composes and returns a {@code OfInt} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires a {@code double} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code double} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfInt<AND> andThenDouble(OfDouble<? super AND> after) {
            return (x, y) -> {
                acceptInt(x, y);
                after.acceptDouble(x, y);
            };
        }

        /**
         * Composes and returns a {@code OfInt} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires a {@code long} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code double} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfInt<AND> andThenLong(OfLong<? super AND> after) {
            return (x, y) -> {
                acceptInt(x, y);
                after.acceptLong(x, y);
            };
        }

        /**
         * Composes and returns a {@code OfInt} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires an {@code int} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code double} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfInt<AND> andThenInt(OfInt<? super AND> after) {
            return (x, y) -> {
                acceptInt(x, y);
                after.acceptInt(x, y);
            };
        }

        /**
         * Composes and returns a {@code OfInt} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires a {@code float} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code double} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfInt<AND> andThenFloat(OfFloat<? super AND> after) {
            return (x, y) -> {
                acceptInt(x, y);
                after.acceptFloat(x, y);
            };
        }

        /**
         * Composes and returns a {@code OfInt} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires a {@code char} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code double} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfInt<AND> andThenChar(OfChar<? super AND> after) {
            return (x, y) -> {
                acceptInt(x, y);
                after.acceptChar((char) x, y);
            };
        }

        /**
         * Composes and returns a {@code OfInt} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires a {@code short} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code double} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfInt<AND> andThenShort(OfShort<? super AND> after) {
            return (x, y) -> {
                acceptInt(x, y);
                after.acceptShort((short) x, y);
            };
        }

        /**
         * Composes and returns a {@code OfInt} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires a {@code byte} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code double} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfInt<AND> andThenByte(OfByte<? super AND> after) {
            return (x, y) -> {
                acceptInt(x, y);
                after.acceptByte((byte) x, y);
            };
        }

        /**
         * Composes and returns a {@code OfInt} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires a {@code boolean} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code double} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfInt<AND> andThenBoolean(OfBoolean<? super AND> after) {
            return (x, y) -> {
                acceptInt(x, y);
                after.acceptBoolean(x != 0, y);
            };
        }

        /**
         * A {@code OfInt} that requires a {@code double} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndDouble extends OfInt<java.lang.Double> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptInt(int, java.lang.Double)}
             *          and is recommended over that one.
             */
            void acceptInt(int x, double y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptInt(int x, java.lang.Double y) {
                acceptInt(x, (double) y);
            }

            /**
             * Composes and returns a {@code OfInt.AndDouble} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code double}
             *              value
             * @return a consumer that accepts an {@code int} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndDouble andThenDouble(OfDouble.AndDouble after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptDouble(x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndDouble} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code double}
             *              value
             * @return a consumer that accepts an {@code int} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndDouble andThenLong(OfLong.AndDouble after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptLong((long) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndDouble} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code double}
             *              value
             * @return a consumer that accepts an {@code int} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndDouble andThenInt(OfInt.AndDouble after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptInt((int) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndDouble} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code double}
             *              value
             * @return a consumer that accepts an {@code int} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndDouble andThenFloat(OfFloat.AndDouble after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptFloat((float) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndDouble} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code double}
             *              value
             * @return a consumer that accepts an {@code int} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndDouble andThenChar(OfChar.AndDouble after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptChar((char) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndDouble} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code double}
             *              value
             * @return a consumer that accepts an {@code int} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndDouble andThenShort(OfShort.AndDouble after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptShort((short) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndDouble} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code double}
             *              value
             * @return a consumer that accepts an {@code int} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndDouble andThenByte(OfByte.AndDouble after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptByte((byte) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndDouble} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code double}
             *              value
             * @return a consumer that accepts an {@code int} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndDouble andThenBoolean(OfBoolean.AndDouble after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptBoolean(x != 0, y);
                };
            }
        }

        /**
         * A {@code OfInt} that requires a {@code long} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndLong extends OfInt<java.lang.Long> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptInt(int, java.lang.Long)}
             *          and is recommended over that one.
             */
            void acceptInt(int x, long y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptInt(int x, java.lang.Long y) {
                acceptInt(x, (long) y);
            }

            /**
             * Composes and returns a {@code OfInt.AndLong} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code long}
             *              value
             * @return a consumer that accepts an {@code int} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndLong andThenDouble(OfDouble.AndLong after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptDouble(x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndLong} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code long} value
             * @return a consumer that accepts an {@code int} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndLong andThenLong(OfLong.AndLong after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptLong((long) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndLong} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code long} value
             * @return a consumer that accepts an {@code int} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndLong andThenInt(OfInt.AndLong after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptInt((int) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndLong} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code long}
             *              value
             * @return a consumer that accepts an {@code int} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndLong andThenFloat(OfFloat.AndLong after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptFloat((float) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndLong} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code long} value
             * @return a consumer that accepts an {@code int} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndLong andThenChar(OfChar.AndLong after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptChar((char) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndLong} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code long}
             *              value
             * @return a consumer that accepts an {@code int} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndLong andThenShort(OfShort.AndLong after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptShort((short) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndLong} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code long} value
             * @return a consumer that accepts an {@code int} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndLong andThenByte(OfByte.AndLong after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptByte((byte) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndLong} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code long}
             *              value
             * @return a consumer that accepts an {@code int} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndLong andThenBoolean(OfBoolean.AndLong after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptBoolean(x != 0, y);
                };
            }
        }

        /**
         * A {@code OfInt} that requires a {@code int} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndInt extends OfInt<java.lang.Integer> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptInt(int, java.lang.Integer)}
             *          and is recommended over that one.
             */
            void acceptInt(int x, int y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptInt(int x, java.lang.Integer y) {
                acceptInt(x, (int) y);
            }

            /**
             * Composes and returns a {@code OfInt.AndInt} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code int}
             *              value
             * @return a consumer that accepts an {@code int} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndInt andThenDouble(OfDouble.AndInt after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptDouble(x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndInt} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code int} value
             * @return a consumer that accepts an {@code int} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndInt andThenLong(OfLong.AndInt after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptLong((long) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndInt} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code int} value
             * @return a consumer that accepts an {@code int} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndInt andThenInt(OfInt.AndInt after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptInt((int) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndInt} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code int} value
             * @return a consumer that accepts an {@code int} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndInt andThenFloat(OfFloat.AndInt after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptFloat((float) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndInt} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code int} value
             * @return a consumer that accepts an {@code int} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndInt andThenChar(OfChar.AndInt after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptChar((char) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndInt} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code int} value
             * @return a consumer that accepts an {@code int} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndInt andThenShort(OfShort.AndInt after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptShort((short) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndInt} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code int} value
             * @return a consumer that accepts an {@code int} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndInt andThenByte(OfByte.AndInt after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptByte((byte) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndInt} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code int}
             *              value
             * @return a consumer that accepts an {@code int} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndInt andThenBoolean(OfBoolean.AndInt after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptBoolean(x != 0, y);
                };
            }
        }

        /**
         * A {@code OfInt} that requires a {@code float} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndFloat extends OfInt<java.lang.Float> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptInt(int, java.lang.Float)}
             *          and is recommended over that one.
             */
            void acceptInt(int x, float y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptInt(int x, java.lang.Float y) {
                acceptInt(x, (float) y);
            }

            /**
             * Composes and returns a {@code OfInt.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code float}
             *              value
             * @return a consumer that accepts an {@code int} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndFloat andThenDouble(OfDouble.AndFloat after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptDouble(x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code float}
             *              value
             * @return a consumer that accepts an {@code int} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndFloat andThenLong(OfLong.AndFloat after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptLong((long) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code float}
             *              value
             * @return a consumer that accepts an {@code int} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndFloat andThenInt(OfInt.AndFloat after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptInt((int) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code float}
             *              value
             * @return a consumer that accepts an {@code int} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndFloat andThenFloat(OfFloat.AndFloat after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptFloat((float) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code float}
             *              value
             * @return a consumer that accepts an {@code int} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndFloat andThenChar(OfChar.AndFloat after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptChar((char) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code float}
             *              value
             * @return a consumer that accepts an {@code int} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndFloat andThenShort(OfShort.AndFloat after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptShort((short) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code float}
             *              value
             * @return a consumer that accepts an {@code int} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndFloat andThenByte(OfByte.AndFloat after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptByte((byte) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code float}
             *              value
             * @return a consumer that accepts an {@code int} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndFloat andThenBoolean(OfBoolean.AndFloat after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptBoolean(x != 0, y);
                };
            }
        }

        /**
         * A {@code OfInt} that requires a {@code char} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndChar extends OfInt<java.lang.Character> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptInt(int, java.lang.Character)}
             *          and is recommended over that one.
             */
            void acceptInt(int x, char y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptInt(int x, java.lang.Character y) {
                acceptInt(x, (char) y);
            }

            /**
             * Composes and returns a {@code OfInt.AndChar} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code char}
             *              value
             * @return a consumer that accepts an {@code int} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndChar andThenDouble(OfDouble.AndChar after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptDouble(x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndChar} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code char} value
             * @return a consumer that accepts an {@code int} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndChar andThenLong(OfLong.AndChar after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptLong((long) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndChar} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code char} value
             * @return a consumer that accepts an {@code int} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndChar andThenInt(OfInt.AndChar after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptInt((int) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndChar} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code char}
             *              value
             * @return a consumer that accepts an {@code int} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndChar andThenFloat(OfFloat.AndChar after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptFloat((float) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndChar} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code char} value
             * @return a consumer that accepts an {@code int} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndChar andThenChar(OfChar.AndChar after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptChar((char) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndChar} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code char}
             *              value
             * @return a consumer that accepts an {@code int} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndChar andThenShort(OfShort.AndChar after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptShort((short) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndChar} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code char} value
             * @return a consumer that accepts an {@code int} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndChar andThenByte(OfByte.AndChar after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptByte((byte) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndChar} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code char}
             *              value
             * @return a consumer that accepts an {@code int} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndChar andThenBoolean(OfBoolean.AndChar after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptBoolean(x != 0, y);
                };
            }
        }

        /**
         * A {@code OfInt} that requires a {@code short} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndShort extends OfInt<java.lang.Short> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptInt(int, java.lang.Short)}
             *          and is recommended over that one.
             */
            void acceptInt(int x, short y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptInt(int x, java.lang.Short y) {
                acceptInt(x, (short) y);
            }

            /**
             * Composes and returns a {@code OfInt.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code short}
             *              value
             * @return a consumer that accepts an {@code int} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndShort andThenDouble(OfDouble.AndShort after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptDouble(x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code short}
             *              value
             * @return a consumer that accepts an {@code int} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndShort andThenLong(OfLong.AndShort after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptLong((long) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code short}
             *              value
             * @return a consumer that accepts an {@code int} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndShort andThenInt(OfInt.AndShort after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptInt((int) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code short}
             *              value
             * @return a consumer that accepts an {@code int} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndShort andThenFloat(OfFloat.AndShort after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptFloat((float) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code short}
             *              value
             * @return a consumer that accepts an {@code int} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndShort andThenChar(OfChar.AndShort after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptChar((char) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code short}
             *              value
             * @return a consumer that accepts an {@code int} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndShort andThenShort(OfShort.AndShort after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptShort((short) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code short}
             *              value
             * @return a consumer that accepts an {@code int} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndShort andThenByte(OfByte.AndShort after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptByte((byte) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code short}
             *              value
             * @return a consumer that accepts an {@code int} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndShort andThenBoolean(OfBoolean.AndShort after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptBoolean(x != 0, y);
                };
            }
        }

        /**
         * A {@code OfInt} that requires a {@code byte} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndByte extends OfInt<java.lang.Byte> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptInt(int, java.lang.Byte)}
             *          and is recommended over that one.
             */
            void acceptInt(int x, byte y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptInt(int x, java.lang.Byte y) {
                acceptInt(x, (byte) y);
            }

            /**
             * Composes and returns a {@code OfInt.AndByte} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code byte}
             *              value
             * @return a consumer that accepts an {@code int} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndByte andThenDouble(OfDouble.AndByte after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptDouble(x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndByte} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code byte} value
             * @return a consumer that accepts an {@code int} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndByte andThenLong(OfLong.AndByte after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptLong((long) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndByte} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code byte} value
             * @return a consumer that accepts an {@code int} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndByte andThenInt(OfInt.AndByte after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptInt((int) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndByte} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code byte}
             *              value
             * @return a consumer that accepts an {@code int} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndByte andThenFloat(OfFloat.AndByte after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptFloat((float) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndByte} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code byte} value
             * @return a consumer that accepts an {@code int} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndByte andThenChar(OfChar.AndByte after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptChar((char) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndByte} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code byte}
             *              value
             * @return a consumer that accepts an {@code int} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndByte andThenShort(OfShort.AndByte after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptShort((short) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndByte} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code byte} value
             * @return a consumer that accepts an {@code int} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndByte andThenByte(OfByte.AndByte after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptByte((byte) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndByte} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code byte}
             *              value
             * @return a consumer that accepts an {@code int} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndByte andThenBoolean(OfBoolean.AndByte after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptBoolean(x != 0, y);
                };
            }
        }

        /**
         * A {@code OfInt} that requires a {@code boolean} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndBoolean extends OfInt<java.lang.Boolean> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptInt(int, java.lang.Boolean)}
             *          and is recommended over that one.
             */
            void acceptInt(int x, boolean y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptInt(int x, java.lang.Boolean y) {
                acceptInt(x, (boolean) y);
            }

            /**
             * Composes and returns a {@code OfInt.AndBoolean} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code boolean}
             *              value
             * @return a consumer that accepts an {@code int} and a {@code boolean} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndBoolean andThenDouble(OfDouble.AndBoolean after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptDouble(x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndBoolean} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code boolean}
             *              value
             * @return a consumer that accepts an {@code int} and a {@code boolean} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndBoolean andThenLong(OfLong.AndBoolean after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptLong((long) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndBoolean} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code boolean}
             *              value
             * @return a consumer that accepts an {@code int} and a {@code boolean} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndBoolean andThenInt(OfInt.AndBoolean after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptInt((int) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndBoolean} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code boolean}
             *              value
             * @return a consumer that accepts an {@code int} and a {@code boolean} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndBoolean andThenFloat(OfFloat.AndBoolean after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptFloat((float) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndBoolean} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code boolean}
             *              value
             * @return a consumer that accepts an {@code int} and a {@code boolean} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndBoolean andThenChar(OfChar.AndBoolean after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptChar((char) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndBoolean} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code boolean}
             *              value
             * @return a consumer that accepts an {@code int} and a {@code boolean} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndBoolean andThenShort(OfShort.AndBoolean after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptShort((short) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndBoolean} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code boolean}
             *              value
             * @return a consumer that accepts an {@code int} and a {@code boolean} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndBoolean andThenByte(OfByte.AndBoolean after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptByte((byte) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfInt.AndBoolean} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code boolean}
             *              value
             * @return a consumer that accepts an {@code int} and a {@code boolean} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfInt.AndBoolean andThenBoolean(OfBoolean.AndBoolean after) {
                return (x, y) -> {
                    acceptInt(x, y);
                    after.acceptBoolean(x != 0, y);
                };
            }
        }

    }

    /**
     * A {@code PrimitiveBiConsumer} that requires a {@code float} and a
     * value of type {@code <AND>}.
     * 
     * @param <AND> the type of the second argument to {@link #acceptFloat}
     * @see PrimitiveBiConsumer
     */
    @FunctionalInterface
    interface OfFloat<AND> extends PrimitiveBiConsumer<java.lang.Float, AND> {
        /**
         * Consumes the arguments (with possible side-effects) returning no result.
         * 
         * @param x the first {@code float} input
         * @param y the second input
         * @apiNote This is the {@code float} specialisation of
         *          {@link #accept(Double, Object)} and
         *          is recommended over the same.
         */
        void acceptFloat(float x, AND y);

        /**
         * {@inheritDoc}
         * 
         * @param x {@inheritDoc}
         * @param y {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote This calls {@link #acceptFloat} unboxing the wrapper {@code Float}
         *           (first argument) to a primitive
         */
        @Override
        default void accept(java.lang.Float x, AND y) {
            acceptFloat(x, y);
        }

        /**
         * Composes and returns a {@code OfFloat} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires a {@code double} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code double} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfFloat<AND> andThenDouble(OfDouble<? super AND> after) {
            return (x, y) -> {
                acceptFloat(x, y);
                after.acceptDouble(x, y);
            };
        }

        /**
         * Composes and returns a {@code OfFloat} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires a {@code long} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code double} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfFloat<AND> andThenLong(OfLong<? super AND> after) {
            return (x, y) -> {
                acceptFloat(x, y);
                after.acceptLong((long) x, y);
            };
        }

        /**
         * Composes and returns a {@code OfFloat} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires an {@code int} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code double} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfFloat<AND> andThenInt(OfInt<? super AND> after) {
            return (x, y) -> {
                acceptFloat(x, y);
                after.acceptInt((int) x, y);
            };
        }

        /**
         * Composes and returns a {@code OfFloat} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires a {@code float} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code double} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfFloat<AND> andThenFloat(OfFloat<? super AND> after) {
            return (x, y) -> {
                acceptFloat(x, y);
                after.acceptFloat(x, y);
            };
        }

        /**
         * Composes and returns a {@code OfFloat} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires a {@code char} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code double} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfFloat<AND> andThenChar(OfChar<? super AND> after) {
            return (x, y) -> {
                acceptFloat(x, y);
                after.acceptChar((char) x, y);
            };
        }

        /**
         * Composes and returns a {@code OfFloat} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires a {@code short} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code double} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfFloat<AND> andThenShort(OfShort<? super AND> after) {
            return (x, y) -> {
                acceptFloat(x, y);
                after.acceptShort((short) x, y);
            };
        }

        /**
         * Composes and returns a {@code OfFloat} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires a {@code byte} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code double} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfFloat<AND> andThenByte(OfByte<? super AND> after) {
            return (x, y) -> {
                acceptFloat(x, y);
                after.acceptByte((byte) x, y);
            };
        }

        /**
         * Composes and returns a {@code OfFloat} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires a {@code boolean} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code double} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfFloat<AND> andThenBoolean(OfBoolean<? super AND> after) {
            return (x, y) -> {
                acceptFloat(x, y);
                after.acceptBoolean(x != 0, y);
            };
        }

        /**
         * A {@code OfFloat} that requires a {@code double} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndDouble extends OfFloat<java.lang.Double> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptFloat(float, java.lang.Double)}
             *          and is recommended over that one.
             */
            void acceptFloat(float x, double y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptFloat(float x, java.lang.Double y) {
                acceptFloat(x, (double) y);
            }

            /**
             * Composes and returns a {@code OfFloat.AndDouble} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code double}
             *              value
             * @return a consumer that accepts an {@code float} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndDouble andThenDouble(OfDouble.AndDouble after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptDouble(x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndDouble} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code double}
             *              value
             * @return a consumer that accepts an {@code float} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndDouble andThenLong(OfLong.AndDouble after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptLong((long) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndDouble} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code double}
             *              value
             * @return a consumer that accepts an {@code float} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndDouble andThenInt(OfInt.AndDouble after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptInt((int) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndDouble} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code double}
             *              value
             * @return a consumer that accepts an {@code float} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndDouble andThenFloat(OfFloat.AndDouble after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptFloat((float) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndDouble} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code double}
             *              value
             * @return a consumer that accepts an {@code float} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndDouble andThenChar(OfChar.AndDouble after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptChar((char) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndDouble} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code double}
             *              value
             * @return a consumer that accepts an {@code float} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndDouble andThenShort(OfShort.AndDouble after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptShort((short) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndDouble} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code double}
             *              value
             * @return a consumer that accepts an {@code float} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndDouble andThenByte(OfByte.AndDouble after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptByte((byte) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndDouble} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code double}
             *              value
             * @return a consumer that accepts an {@code float} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndDouble andThenBoolean(OfBoolean.AndDouble after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptBoolean(x != 0, y);
                };
            }
        }

        /**
         * A {@code OfFloat} that requires a {@code long} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndLong extends OfFloat<java.lang.Long> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptFloat(float, java.lang.Long)}
             *          and is recommended over that one.
             */
            void acceptFloat(float x, long y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptFloat(float x, java.lang.Long y) {
                acceptFloat(x, (long) y);
            }

            /**
             * Composes and returns a {@code OfFloat.AndLong} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code long}
             *              value
             * @return a consumer that accepts an {@code float} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndLong andThenDouble(OfDouble.AndLong after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptDouble(x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndLong} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code long} value
             * @return a consumer that accepts an {@code float} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndLong andThenLong(OfLong.AndLong after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptLong((long) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndLong} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code long} value
             * @return a consumer that accepts an {@code float} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndLong andThenInt(OfInt.AndLong after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptInt((int) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndLong} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code long}
             *              value
             * @return a consumer that accepts an {@code float} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndLong andThenFloat(OfFloat.AndLong after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptFloat((float) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndLong} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code long} value
             * @return a consumer that accepts an {@code float} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndLong andThenChar(OfChar.AndLong after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptChar((char) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndLong} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code long}
             *              value
             * @return a consumer that accepts an {@code float} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndLong andThenShort(OfShort.AndLong after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptShort((short) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndLong} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code long} value
             * @return a consumer that accepts an {@code float} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndLong andThenByte(OfByte.AndLong after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptByte((byte) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndLong} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code long}
             *              value
             * @return a consumer that accepts an {@code float} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndLong andThenBoolean(OfBoolean.AndLong after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptBoolean(x != 0, y);
                };
            }
        }

        /**
         * A {@code OfFloat} that requires a {@code int} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndInt extends OfFloat<java.lang.Integer> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptFloat(float, java.lang.Integer)}
             *          and is recommended over that one.
             */
            void acceptFloat(float x, int y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptFloat(float x, java.lang.Integer y) {
                acceptFloat(x, (int) y);
            }

            /**
             * Composes and returns a {@code OfFloat.AndInt} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code int}
             *              value
             * @return a consumer that accepts an {@code float} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndInt andThenDouble(OfDouble.AndInt after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptDouble(x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndInt} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code int} value
             * @return a consumer that accepts an {@code float} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndInt andThenLong(OfLong.AndInt after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptLong((long) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndInt} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code int} value
             * @return a consumer that accepts an {@code float} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndInt andThenInt(OfInt.AndInt after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptInt((int) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndInt} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code int} value
             * @return a consumer that accepts an {@code float} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndInt andThenFloat(OfFloat.AndInt after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptFloat((float) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndInt} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code int} value
             * @return a consumer that accepts an {@code float} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndInt andThenChar(OfChar.AndInt after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptChar((char) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndInt} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code int} value
             * @return a consumer that accepts an {@code float} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndInt andThenShort(OfShort.AndInt after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptShort((short) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndInt} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code int} value
             * @return a consumer that accepts an {@code float} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndInt andThenByte(OfByte.AndInt after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptByte((byte) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndInt} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code int}
             *              value
             * @return a consumer that accepts an {@code float} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndInt andThenBoolean(OfBoolean.AndInt after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptBoolean(x != 0, y);
                };
            }
        }

        /**
         * A {@code OfFloat} that requires a {@code float} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndFloat extends OfFloat<java.lang.Float> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptFloat(float, java.lang.Float)}
             *          and is recommended over that one.
             */
            void acceptFloat(float x, float y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptFloat(float x, java.lang.Float y) {
                acceptFloat(x, (float) y);
            }

            /**
             * Composes and returns a {@code OfFloat.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code float}
             *              value
             * @return a consumer that accepts an {@code float} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndFloat andThenDouble(OfDouble.AndFloat after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptDouble(x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code float}
             *              value
             * @return a consumer that accepts an {@code float} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndFloat andThenLong(OfLong.AndFloat after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptLong((long) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code float}
             *              value
             * @return a consumer that accepts an {@code float} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndFloat andThenInt(OfInt.AndFloat after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptInt((int) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code float}
             *              value
             * @return a consumer that accepts an {@code float} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndFloat andThenFloat(OfFloat.AndFloat after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptFloat((float) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code float}
             *              value
             * @return a consumer that accepts an {@code float} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndFloat andThenChar(OfChar.AndFloat after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptChar((char) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code float}
             *              value
             * @return a consumer that accepts an {@code float} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndFloat andThenShort(OfShort.AndFloat after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptShort((short) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code float}
             *              value
             * @return a consumer that accepts an {@code float} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndFloat andThenByte(OfByte.AndFloat after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptByte((byte) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code float}
             *              value
             * @return a consumer that accepts an {@code float} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndFloat andThenBoolean(OfBoolean.AndFloat after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptBoolean(x != 0, y);
                };
            }
        }

        /**
         * A {@code OfFloat} that requires a {@code char} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndChar extends OfFloat<java.lang.Character> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptFloat(float, java.lang.Character)}
             *          and is recommended over that one.
             */
            void acceptFloat(float x, char y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptFloat(float x, java.lang.Character y) {
                acceptFloat(x, (char) y);
            }

            /**
             * Composes and returns a {@code OfFloat.AndChar} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code char}
             *              value
             * @return a consumer that accepts an {@code float} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndChar andThenDouble(OfDouble.AndChar after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptDouble(x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndChar} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code char} value
             * @return a consumer that accepts an {@code float} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndChar andThenLong(OfLong.AndChar after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptLong((long) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndChar} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code char} value
             * @return a consumer that accepts an {@code float} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndChar andThenInt(OfInt.AndChar after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptInt((int) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndChar} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code char}
             *              value
             * @return a consumer that accepts an {@code float} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndChar andThenFloat(OfFloat.AndChar after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptFloat((float) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndChar} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code char} value
             * @return a consumer that accepts an {@code float} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndChar andThenChar(OfChar.AndChar after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptChar((char) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndChar} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code char}
             *              value
             * @return a consumer that accepts an {@code float} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndChar andThenShort(OfShort.AndChar after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptShort((short) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndChar} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code char} value
             * @return a consumer that accepts an {@code float} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndChar andThenByte(OfByte.AndChar after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptByte((byte) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndChar} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code char}
             *              value
             * @return a consumer that accepts an {@code float} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndChar andThenBoolean(OfBoolean.AndChar after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptBoolean(x != 0, y);
                };
            }
        }

        /**
         * A {@code OfFloat} that requires a {@code short} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndShort extends OfFloat<java.lang.Short> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptFloat(float, java.lang.Short)}
             *          and is recommended over that one.
             */
            void acceptFloat(float x, short y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptFloat(float x, java.lang.Short y) {
                acceptFloat(x, (short) y);
            }

            /**
             * Composes and returns a {@code OfFloat.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code short}
             *              value
             * @return a consumer that accepts an {@code float} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndShort andThenDouble(OfDouble.AndShort after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptDouble(x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code short}
             *              value
             * @return a consumer that accepts an {@code float} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndShort andThenLong(OfLong.AndShort after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptLong((long) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code short}
             *              value
             * @return a consumer that accepts an {@code float} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndShort andThenInt(OfInt.AndShort after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptInt((int) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code short}
             *              value
             * @return a consumer that accepts an {@code float} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndShort andThenFloat(OfFloat.AndShort after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptFloat((float) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code short}
             *              value
             * @return a consumer that accepts an {@code float} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndShort andThenChar(OfChar.AndShort after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptChar((char) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code short}
             *              value
             * @return a consumer that accepts an {@code float} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndShort andThenShort(OfShort.AndShort after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptShort((short) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code short}
             *              value
             * @return a consumer that accepts an {@code float} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndShort andThenByte(OfByte.AndShort after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptByte((byte) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code short}
             *              value
             * @return a consumer that accepts an {@code float} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndShort andThenBoolean(OfBoolean.AndShort after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptBoolean(x != 0, y);
                };
            }
        }

        /**
         * A {@code OfFloat} that requires a {@code byte} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndByte extends OfFloat<java.lang.Byte> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptFloat(float, java.lang.Byte)}
             *          and is recommended over that one.
             */
            void acceptFloat(float x, byte y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptFloat(float x, java.lang.Byte y) {
                acceptFloat(x, (byte) y);
            }

            /**
             * Composes and returns a {@code OfFloat.AndByte} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code byte}
             *              value
             * @return a consumer that accepts an {@code float} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndByte andThenDouble(OfDouble.AndByte after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptDouble(x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndByte} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code byte} value
             * @return a consumer that accepts an {@code float} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndByte andThenLong(OfLong.AndByte after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptLong((long) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndByte} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code byte} value
             * @return a consumer that accepts an {@code float} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndByte andThenInt(OfInt.AndByte after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptInt((int) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndByte} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code byte}
             *              value
             * @return a consumer that accepts an {@code float} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndByte andThenFloat(OfFloat.AndByte after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptFloat((float) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndByte} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code byte} value
             * @return a consumer that accepts an {@code float} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndByte andThenChar(OfChar.AndByte after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptChar((char) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndByte} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code byte}
             *              value
             * @return a consumer that accepts an {@code float} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndByte andThenShort(OfShort.AndByte after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptShort((short) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndByte} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code byte} value
             * @return a consumer that accepts an {@code float} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndByte andThenByte(OfByte.AndByte after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptByte((byte) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndByte} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code byte}
             *              value
             * @return a consumer that accepts an {@code float} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndByte andThenBoolean(OfBoolean.AndByte after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptBoolean(x != 0, y);
                };
            }
        }

        /**
         * A {@code OfFloat} that requires a {@code boolean} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndBoolean extends OfFloat<java.lang.Boolean> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptFloat(float, java.lang.Boolean)}
             *          and is recommended over that one.
             */
            void acceptFloat(float x, boolean y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptFloat(float x, java.lang.Boolean y) {
                acceptFloat(x, (boolean) y);
            }

            /**
             * Composes and returns a {@code OfFloat.AndBoolean} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code boolean}
             *              value
             * @return a consumer that accepts an {@code float} and a {@code boolean} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndBoolean andThenDouble(OfDouble.AndBoolean after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptDouble(x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndBoolean} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code boolean}
             *              value
             * @return a consumer that accepts an {@code float} and a {@code boolean} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndBoolean andThenLong(OfLong.AndBoolean after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptLong((long) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndBoolean} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code boolean}
             *              value
             * @return a consumer that accepts an {@code float} and a {@code boolean} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndBoolean andThenInt(OfInt.AndBoolean after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptInt((int) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndBoolean} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code boolean}
             *              value
             * @return a consumer that accepts an {@code float} and a {@code boolean} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndBoolean andThenFloat(OfFloat.AndBoolean after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptFloat((float) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndBoolean} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code boolean}
             *              value
             * @return a consumer that accepts an {@code float} and a {@code boolean} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndBoolean andThenChar(OfChar.AndBoolean after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptChar((char) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndBoolean} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code boolean}
             *              value
             * @return a consumer that accepts an {@code float} and a {@code boolean} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndBoolean andThenShort(OfShort.AndBoolean after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptShort((short) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndBoolean} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code boolean}
             *              value
             * @return a consumer that accepts an {@code float} and a {@code boolean} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndBoolean andThenByte(OfByte.AndBoolean after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptByte((byte) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfFloat.AndBoolean} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code boolean}
             *              value
             * @return a consumer that accepts an {@code float} and a {@code boolean} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfFloat.AndBoolean andThenBoolean(OfBoolean.AndBoolean after) {
                return (x, y) -> {
                    acceptFloat(x, y);
                    after.acceptBoolean(x != 0, y);
                };
            }
        }
    }

    /**
     * A {@code PrimitiveBiConsumer} that requires a {@code char} and a
     * value of type {@code <AND>}.
     * 
     * @param <AND> the type of the second argument to {@link #acceptChar}
     * @see PrimitiveBiConsumer
     */
    @FunctionalInterface
    interface OfChar<AND> extends PrimitiveBiConsumer<java.lang.Character, AND> {
        /**
         * Consumes the arguments (with possible side-effects) returning no result.
         * 
         * @param x the first {@code char} input
         * @param y the second input
         * @apiNote This is the {@code char} specialisation of
         *          {@link #accept(Double, Object)} and
         *          is recommended over the same.
         */
        void acceptChar(char x, AND y);

        /**
         * {@inheritDoc}
         * 
         * @param x {@inheritDoc}
         * @param y {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote This calls {@link #acceptChar} unboxing the wrapper {@code Char}
         *           (first argument) to a primitive
         */
        @Override
        default void accept(java.lang.Character x, AND y) {
            acceptChar(x, y);
        }

        /**
         * Composes and returns a {@code OfChar} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires a {@code double} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code double} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfChar<AND> andThenDouble(OfDouble<? super AND> after) {
            return (x, y) -> {
                acceptChar(x, y);
                after.acceptDouble(x, y);
            };
        }

        /**
         * Composes and returns a {@code OfChar} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires a {@code long} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code double} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfChar<AND> andThenLong(OfLong<? super AND> after) {
            return (x, y) -> {
                acceptChar(x, y);
                after.acceptLong(x, y);
            };
        }

        /**
         * Composes and returns a {@code OfChar} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires an {@code int} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code double} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfChar<AND> andThenInt(OfInt<? super AND> after) {
            return (x, y) -> {
                acceptChar(x, y);
                after.acceptInt(x, y);
            };
        }

        /**
         * Composes and returns a {@code OfChar} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires a {@code float} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code double} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfChar<AND> andThenFloat(OfFloat<? super AND> after) {
            return (x, y) -> {
                acceptChar(x, y);
                after.acceptFloat(x, y);
            };
        }

        /**
         * Composes and returns a {@code OfChar} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires a {@code char} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code double} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfChar<AND> andThenChar(OfChar<? super AND> after) {
            return (x, y) -> {
                acceptChar(x, y);
                after.acceptChar(x, y);
            };
        }

        /**
         * Composes and returns a {@code OfChar} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires a {@code short} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code double} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfChar<AND> andThenShort(OfShort<? super AND> after) {
            return (x, y) -> {
                acceptChar(x, y);
                after.acceptShort((short) x, y);
            };
        }

        /**
         * Composes and returns a {@code OfChar} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires a {@code byte} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code double} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfChar<AND> andThenByte(OfByte<? super AND> after) {
            return (x, y) -> {
                acceptChar(x, y);
                after.acceptByte((byte) x, y);
            };
        }

        /**
         * Composes and returns a {@code OfChar} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires a {@code boolean} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code double} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfChar<AND> andThenBoolean(OfBoolean<? super AND> after) {
            return (x, y) -> {
                acceptChar(x, y);
                after.acceptBoolean(x != 0, y);
            };
        }

        /**
         * A {@code OfChar} that requires a {@code double} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndDouble extends OfChar<java.lang.Double> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptChar(char, java.lang.Double)}
             *          and is recommended over that one.
             */
            void acceptChar(char x, double y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptChar(char x, java.lang.Double y) {
                acceptChar(x, (double) y);
            }

            /**
             * Composes and returns a {@code OfChar.AndDouble} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code double}
             *              value
             * @return a consumer that accepts an {@code char} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndDouble andThenDouble(OfDouble.AndDouble after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptDouble(x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndDouble} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code double}
             *              value
             * @return a consumer that accepts an {@code char} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndDouble andThenLong(OfLong.AndDouble after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptLong((long) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndDouble} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code double}
             *              value
             * @return a consumer that accepts an {@code char} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndDouble andThenInt(OfInt.AndDouble after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptInt((int) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndDouble} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code double}
             *              value
             * @return a consumer that accepts an {@code char} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndDouble andThenFloat(OfFloat.AndDouble after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptFloat((float) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndDouble} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code double}
             *              value
             * @return a consumer that accepts an {@code char} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndDouble andThenChar(OfChar.AndDouble after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptChar((char) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndDouble} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code double}
             *              value
             * @return a consumer that accepts an {@code char} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndDouble andThenShort(OfShort.AndDouble after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptShort((short) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndDouble} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code double}
             *              value
             * @return a consumer that accepts an {@code char} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndDouble andThenByte(OfByte.AndDouble after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptByte((byte) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndDouble} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code double}
             *              value
             * @return a consumer that accepts an {@code char} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndDouble andThenBoolean(OfBoolean.AndDouble after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptBoolean(x != 0, y);
                };
            }
        }

        /**
         * A {@code OfChar} that requires a {@code long} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndLong extends OfChar<java.lang.Long> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptChar(char, java.lang.Long)}
             *          and is recommended over that one.
             */
            void acceptChar(char x, long y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptChar(char x, java.lang.Long y) {
                acceptChar(x, (long) y);
            }

            /**
             * Composes and returns a {@code OfChar.AndLong} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code long}
             *              value
             * @return a consumer that accepts an {@code char} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndLong andThenDouble(OfDouble.AndLong after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptDouble(x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndLong} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code long} value
             * @return a consumer that accepts an {@code char} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndLong andThenLong(OfLong.AndLong after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptLong((long) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndLong} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code long} value
             * @return a consumer that accepts an {@code char} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndLong andThenInt(OfInt.AndLong after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptInt((int) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndLong} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code long}
             *              value
             * @return a consumer that accepts an {@code char} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndLong andThenFloat(OfFloat.AndLong after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptFloat((float) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndLong} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code long} value
             * @return a consumer that accepts an {@code char} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndLong andThenChar(OfChar.AndLong after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptChar((char) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndLong} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code long}
             *              value
             * @return a consumer that accepts an {@code char} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndLong andThenShort(OfShort.AndLong after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptShort((short) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndLong} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code long} value
             * @return a consumer that accepts an {@code char} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndLong andThenByte(OfByte.AndLong after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptByte((byte) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndLong} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code long}
             *              value
             * @return a consumer that accepts an {@code char} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndLong andThenBoolean(OfBoolean.AndLong after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptBoolean(x != 0, y);
                };
            }
        }

        /**
         * A {@code OfChar} that requires a {@code int} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndInt extends OfChar<java.lang.Integer> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptChar(char, java.lang.Integer)}
             *          and is recommended over that one.
             */
            void acceptChar(char x, int y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptChar(char x, java.lang.Integer y) {
                acceptChar(x, (int) y);
            }

            /**
             * Composes and returns a {@code OfChar.AndInt} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code int}
             *              value
             * @return a consumer that accepts an {@code char} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndInt andThenDouble(OfDouble.AndInt after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptDouble(x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndInt} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code int} value
             * @return a consumer that accepts an {@code char} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndInt andThenLong(OfLong.AndInt after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptLong((long) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndInt} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code int} value
             * @return a consumer that accepts an {@code char} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndInt andThenInt(OfInt.AndInt after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptInt((int) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndInt} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code int} value
             * @return a consumer that accepts an {@code char} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndInt andThenFloat(OfFloat.AndInt after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptFloat((float) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndInt} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code int} value
             * @return a consumer that accepts an {@code char} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndInt andThenChar(OfChar.AndInt after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptChar((char) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndInt} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code int} value
             * @return a consumer that accepts an {@code char} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndInt andThenShort(OfShort.AndInt after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptShort((short) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndInt} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code int} value
             * @return a consumer that accepts an {@code char} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndInt andThenByte(OfByte.AndInt after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptByte((byte) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndInt} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code int}
             *              value
             * @return a consumer that accepts an {@code char} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndInt andThenBoolean(OfBoolean.AndInt after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptBoolean(x != 0, y);
                };
            }
        }

        /**
         * A {@code OfChar} that requires a {@code float} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndFloat extends OfChar<java.lang.Float> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptChar(char, java.lang.Float)}
             *          and is recommended over that one.
             */
            void acceptChar(char x, float y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptChar(char x, java.lang.Float y) {
                acceptChar(x, (float) y);
            }

            /**
             * Composes and returns a {@code OfChar.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code float}
             *              value
             * @return a consumer that accepts an {@code char} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndFloat andThenDouble(OfDouble.AndFloat after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptDouble(x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code float}
             *              value
             * @return a consumer that accepts an {@code char} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndFloat andThenLong(OfLong.AndFloat after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptLong((long) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code float}
             *              value
             * @return a consumer that accepts an {@code char} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndFloat andThenInt(OfInt.AndFloat after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptInt((int) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code float}
             *              value
             * @return a consumer that accepts an {@code char} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndFloat andThenFloat(OfFloat.AndFloat after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptFloat((float) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code float}
             *              value
             * @return a consumer that accepts an {@code char} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndFloat andThenChar(OfChar.AndFloat after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptChar((char) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code float}
             *              value
             * @return a consumer that accepts an {@code char} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndFloat andThenShort(OfShort.AndFloat after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptShort((short) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code float}
             *              value
             * @return a consumer that accepts an {@code char} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndFloat andThenByte(OfByte.AndFloat after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptByte((byte) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code float}
             *              value
             * @return a consumer that accepts an {@code char} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndFloat andThenBoolean(OfBoolean.AndFloat after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptBoolean(x != 0, y);
                };
            }
        }

        /**
         * A {@code OfChar} that requires a {@code char} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndChar extends OfChar<java.lang.Character> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptChar(char, java.lang.Character)}
             *          and is recommended over that one.
             */
            void acceptChar(char x, char y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptChar(char x, java.lang.Character y) {
                acceptChar(x, (char) y);
            }

            /**
             * Composes and returns a {@code OfChar.AndChar} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code char}
             *              value
             * @return a consumer that accepts an {@code char} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndChar andThenDouble(OfDouble.AndChar after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptDouble(x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndChar} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code char} value
             * @return a consumer that accepts an {@code char} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndChar andThenLong(OfLong.AndChar after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptLong((long) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndChar} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code char} value
             * @return a consumer that accepts an {@code char} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndChar andThenInt(OfInt.AndChar after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptInt((int) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndChar} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code char}
             *              value
             * @return a consumer that accepts an {@code char} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndChar andThenFloat(OfFloat.AndChar after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptFloat((float) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndChar} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code char} value
             * @return a consumer that accepts an {@code char} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndChar andThenChar(OfChar.AndChar after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptChar((char) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndChar} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code char}
             *              value
             * @return a consumer that accepts an {@code char} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndChar andThenShort(OfShort.AndChar after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptShort((short) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndChar} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code char} value
             * @return a consumer that accepts an {@code char} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndChar andThenByte(OfByte.AndChar after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptByte((byte) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndChar} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code char}
             *              value
             * @return a consumer that accepts an {@code char} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndChar andThenBoolean(OfBoolean.AndChar after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptBoolean(x != 0, y);
                };
            }
        }

        /**
         * A {@code OfChar} that requires a {@code short} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndShort extends OfChar<java.lang.Short> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptChar(char, java.lang.Short)}
             *          and is recommended over that one.
             */
            void acceptChar(char x, short y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptChar(char x, java.lang.Short y) {
                acceptChar(x, (short) y);
            }

            /**
             * Composes and returns a {@code OfChar.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code short}
             *              value
             * @return a consumer that accepts an {@code char} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndShort andThenDouble(OfDouble.AndShort after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptDouble(x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code short}
             *              value
             * @return a consumer that accepts an {@code char} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndShort andThenLong(OfLong.AndShort after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptLong((long) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code short}
             *              value
             * @return a consumer that accepts an {@code char} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndShort andThenInt(OfInt.AndShort after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptInt((int) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code short}
             *              value
             * @return a consumer that accepts an {@code char} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndShort andThenFloat(OfFloat.AndShort after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptFloat((float) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code short}
             *              value
             * @return a consumer that accepts an {@code char} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndShort andThenChar(OfChar.AndShort after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptChar((char) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code short}
             *              value
             * @return a consumer that accepts an {@code char} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndShort andThenShort(OfShort.AndShort after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptShort((short) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code short}
             *              value
             * @return a consumer that accepts an {@code char} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndShort andThenByte(OfByte.AndShort after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptByte((byte) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code short}
             *              value
             * @return a consumer that accepts an {@code char} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndShort andThenBoolean(OfBoolean.AndShort after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptBoolean(x != 0, y);
                };
            }
        }

        /**
         * A {@code OfChar} that requires a {@code byte} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndByte extends OfChar<java.lang.Byte> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptChar(char, java.lang.Byte)}
             *          and is recommended over that one.
             */
            void acceptChar(char x, byte y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptChar(char x, java.lang.Byte y) {
                acceptChar(x, (byte) y);
            }

            /**
             * Composes and returns a {@code OfChar.AndByte} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code byte}
             *              value
             * @return a consumer that accepts an {@code char} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndByte andThenDouble(OfDouble.AndByte after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptDouble(x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndByte} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code byte} value
             * @return a consumer that accepts an {@code char} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndByte andThenLong(OfLong.AndByte after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptLong((long) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndByte} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code byte} value
             * @return a consumer that accepts an {@code char} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndByte andThenInt(OfInt.AndByte after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptInt((int) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndByte} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code byte}
             *              value
             * @return a consumer that accepts an {@code char} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndByte andThenFloat(OfFloat.AndByte after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptFloat((float) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndByte} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code byte} value
             * @return a consumer that accepts an {@code char} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndByte andThenChar(OfChar.AndByte after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptChar((char) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndByte} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code byte}
             *              value
             * @return a consumer that accepts an {@code char} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndByte andThenShort(OfShort.AndByte after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptShort((short) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndByte} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code byte} value
             * @return a consumer that accepts an {@code char} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndByte andThenByte(OfByte.AndByte after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptByte((byte) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndByte} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code byte}
             *              value
             * @return a consumer that accepts an {@code char} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndByte andThenBoolean(OfBoolean.AndByte after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptBoolean(x != 0, y);
                };
            }
        }

        /**
         * A {@code OfChar} that requires a {@code boolean} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndBoolean extends OfChar<java.lang.Boolean> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptChar(char, java.lang.Boolean)}
             *          and is recommended over that one.
             */
            void acceptChar(char x, boolean y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptChar(char x, java.lang.Boolean y) {
                acceptChar(x, (boolean) y);
            }

            /**
             * Composes and returns a {@code OfChar.AndBoolean} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code boolean}
             *              value
             * @return a consumer that accepts an {@code char} and a {@code boolean} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndBoolean andThenDouble(OfDouble.AndBoolean after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptDouble(x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndBoolean} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code boolean}
             *              value
             * @return a consumer that accepts an {@code char} and a {@code boolean} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndBoolean andThenLong(OfLong.AndBoolean after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptLong((long) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndBoolean} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code boolean}
             *              value
             * @return a consumer that accepts an {@code char} and a {@code boolean} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndBoolean andThenInt(OfInt.AndBoolean after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptInt((int) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndBoolean} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code boolean}
             *              value
             * @return a consumer that accepts an {@code char} and a {@code boolean} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndBoolean andThenFloat(OfFloat.AndBoolean after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptFloat((float) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndBoolean} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code boolean}
             *              value
             * @return a consumer that accepts an {@code char} and a {@code boolean} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndBoolean andThenChar(OfChar.AndBoolean after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptChar((char) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndBoolean} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code boolean}
             *              value
             * @return a consumer that accepts an {@code char} and a {@code boolean} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndBoolean andThenShort(OfShort.AndBoolean after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptShort((short) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndBoolean} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code boolean}
             *              value
             * @return a consumer that accepts an {@code char} and a {@code boolean} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndBoolean andThenByte(OfByte.AndBoolean after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptByte((byte) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfChar.AndBoolean} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code boolean}
             *              value
             * @return a consumer that accepts an {@code char} and a {@code boolean} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfChar.AndBoolean andThenBoolean(OfBoolean.AndBoolean after) {
                return (x, y) -> {
                    acceptChar(x, y);
                    after.acceptBoolean(x != 0, y);
                };
            }
        }

    }

    /**
     * A {@code PrimitiveBiConsumer} that requires a {@code short} and a
     * value of type {@code <AND>}.
     * 
     * @param <AND> the type of the second argument to {@link #acceptShort}
     * @see PrimitiveBiConsumer
     */
    @FunctionalInterface
    interface OfShort<AND> extends PrimitiveBiConsumer<java.lang.Short, AND> {
        /**
         * Consumes the arguments (with possible side-effects) returning no result.
         * 
         * @param x the first {@code short} input
         * @param y the second input
         * @apiNote This is the {@code short} specialisation of
         *          {@link #accept(Double, Object)} and
         *          is recommended over the same.
         */
        void acceptShort(short x, AND y);

        /**
         * {@inheritDoc}
         * 
         * @param x {@inheritDoc}
         * @param y {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote This calls {@link #acceptShort} unboxing the wrapper {@code Short}
         *           (first argument) to a primitive
         */
        @Override
        default void accept(java.lang.Short x, AND y) {
            acceptShort(x, y);
        }

        /**
         * Composes and returns a {@code OfShort} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires a {@code double} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code double} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfShort<AND> andThenDouble(OfDouble<? super AND> after) {
            return (x, y) -> {
                acceptShort(x, y);
                after.acceptDouble(x, y);
            };
        }

        /**
         * Composes and returns a {@code OfShort} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires a {@code long} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code double} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfShort<AND> andThenLong(OfLong<? super AND> after) {
            return (x, y) -> {
                acceptShort(x, y);
                after.acceptLong(x, y);
            };
        }

        /**
         * Composes and returns a {@code OfShort} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires an {@code int} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code double} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfShort<AND> andThenInt(OfInt<? super AND> after) {
            return (x, y) -> {
                acceptShort(x, y);
                after.acceptInt(x, y);
            };
        }

        /**
         * Composes and returns a {@code OfShort} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires a {@code float} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code double} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfShort<AND> andThenFloat(OfFloat<? super AND> after) {
            return (x, y) -> {
                acceptShort(x, y);
                after.acceptFloat(x, y);
            };
        }

        /**
         * Composes and returns a {@code OfShort} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires a {@code char} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code double} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfShort<AND> andThenChar(OfChar<? super AND> after) {
            return (x, y) -> {
                acceptShort(x, y);
                after.acceptChar((char) x, y);
            };
        }

        /**
         * Composes and returns a {@code OfShort} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires a {@code short} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code double} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfShort<AND> andThenShort(OfShort<? super AND> after) {
            return (x, y) -> {
                acceptShort(x, y);
                after.acceptShort(x, y);
            };
        }

        /**
         * Composes and returns a {@code OfShort} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires a {@code byte} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code double} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfShort<AND> andThenByte(OfByte<? super AND> after) {
            return (x, y) -> {
                acceptShort(x, y);
                after.acceptByte((byte) x, y);
            };
        }

        /**
         * Composes and returns a {@code OfShort} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires a {@code boolean} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code double} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfShort<AND> andThenBoolean(OfBoolean<? super AND> after) {
            return (x, y) -> {
                acceptShort(x, y);
                after.acceptBoolean(x != 0, y);
            };
        }

        /**
         * A {@code OfShort} that requires a {@code double} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndDouble extends OfShort<java.lang.Double> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptShort(short, java.lang.Double)}
             *          and is recommended over that one.
             */
            void acceptShort(short x, double y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptShort(short x, java.lang.Double y) {
                acceptShort(x, (double) y);
            }

            /**
             * Composes and returns a {@code OfShort.AndDouble} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code double}
             *              value
             * @return a consumer that accepts an {@code short} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndDouble andThenDouble(OfDouble.AndDouble after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptDouble(x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndDouble} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code double}
             *              value
             * @return a consumer that accepts an {@code short} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndDouble andThenLong(OfLong.AndDouble after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptLong((long) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndDouble} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code double}
             *              value
             * @return a consumer that accepts an {@code short} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndDouble andThenInt(OfInt.AndDouble after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptInt((int) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndDouble} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code double}
             *              value
             * @return a consumer that accepts an {@code short} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndDouble andThenFloat(OfFloat.AndDouble after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptFloat((float) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndDouble} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code double}
             *              value
             * @return a consumer that accepts an {@code short} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndDouble andThenChar(OfChar.AndDouble after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptChar((char) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndDouble} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code double}
             *              value
             * @return a consumer that accepts an {@code short} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndDouble andThenShort(OfShort.AndDouble after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptShort((short) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndDouble} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code double}
             *              value
             * @return a consumer that accepts an {@code short} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndDouble andThenByte(OfByte.AndDouble after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptByte((byte) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndDouble} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code double}
             *              value
             * @return a consumer that accepts an {@code short} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndDouble andThenBoolean(OfBoolean.AndDouble after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptBoolean(x != 0, y);
                };
            }
        }

        /**
         * A {@code OfShort} that requires a {@code long} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndLong extends OfShort<java.lang.Long> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptShort(short, java.lang.Long)}
             *          and is recommended over that one.
             */
            void acceptShort(short x, long y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptShort(short x, java.lang.Long y) {
                acceptShort(x, (long) y);
            }

            /**
             * Composes and returns a {@code OfShort.AndLong} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code long}
             *              value
             * @return a consumer that accepts an {@code short} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndLong andThenDouble(OfDouble.AndLong after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptDouble(x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndLong} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code long} value
             * @return a consumer that accepts an {@code short} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndLong andThenLong(OfLong.AndLong after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptLong((long) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndLong} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code long} value
             * @return a consumer that accepts an {@code short} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndLong andThenInt(OfInt.AndLong after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptInt((int) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndLong} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code long}
             *              value
             * @return a consumer that accepts an {@code short} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndLong andThenFloat(OfFloat.AndLong after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptFloat((float) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndLong} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code long} value
             * @return a consumer that accepts an {@code short} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndLong andThenChar(OfChar.AndLong after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptChar((char) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndLong} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code long}
             *              value
             * @return a consumer that accepts an {@code short} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndLong andThenShort(OfShort.AndLong after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptShort((short) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndLong} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code long} value
             * @return a consumer that accepts an {@code short} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndLong andThenByte(OfByte.AndLong after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptByte((byte) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndLong} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code long}
             *              value
             * @return a consumer that accepts an {@code short} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndLong andThenBoolean(OfBoolean.AndLong after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptBoolean(x != 0, y);
                };
            }
        }

        /**
         * A {@code OfShort} that requires a {@code int} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndInt extends OfShort<java.lang.Integer> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptShort(short, java.lang.Integer)}
             *          and is recommended over that one.
             */
            void acceptShort(short x, int y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptShort(short x, java.lang.Integer y) {
                acceptShort(x, (int) y);
            }

            /**
             * Composes and returns a {@code OfShort.AndInt} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code int}
             *              value
             * @return a consumer that accepts an {@code short} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndInt andThenDouble(OfDouble.AndInt after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptDouble(x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndInt} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code int} value
             * @return a consumer that accepts an {@code short} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndInt andThenLong(OfLong.AndInt after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptLong((long) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndInt} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code int} value
             * @return a consumer that accepts an {@code short} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndInt andThenInt(OfInt.AndInt after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptInt((int) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndInt} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code int} value
             * @return a consumer that accepts an {@code short} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndInt andThenFloat(OfFloat.AndInt after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptFloat((float) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndInt} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code int} value
             * @return a consumer that accepts an {@code short} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndInt andThenChar(OfChar.AndInt after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptChar((char) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndInt} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code int} value
             * @return a consumer that accepts an {@code short} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndInt andThenShort(OfShort.AndInt after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptShort((short) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndInt} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code int} value
             * @return a consumer that accepts an {@code short} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndInt andThenByte(OfByte.AndInt after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptByte((byte) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndInt} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code int}
             *              value
             * @return a consumer that accepts an {@code short} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndInt andThenBoolean(OfBoolean.AndInt after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptBoolean(x != 0, y);
                };
            }
        }

        /**
         * A {@code OfShort} that requires a {@code float} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndFloat extends OfShort<java.lang.Float> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptShort(short, java.lang.Float)}
             *          and is recommended over that one.
             */
            void acceptShort(short x, float y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptShort(short x, java.lang.Float y) {
                acceptShort(x, (float) y);
            }

            /**
             * Composes and returns a {@code OfShort.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code float}
             *              value
             * @return a consumer that accepts an {@code short} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndFloat andThenDouble(OfDouble.AndFloat after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptDouble(x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code float}
             *              value
             * @return a consumer that accepts an {@code short} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndFloat andThenLong(OfLong.AndFloat after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptLong((long) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code float}
             *              value
             * @return a consumer that accepts an {@code short} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndFloat andThenInt(OfInt.AndFloat after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptInt((int) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code float}
             *              value
             * @return a consumer that accepts an {@code short} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndFloat andThenFloat(OfFloat.AndFloat after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptFloat((float) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code float}
             *              value
             * @return a consumer that accepts an {@code short} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndFloat andThenChar(OfChar.AndFloat after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptChar((char) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code float}
             *              value
             * @return a consumer that accepts an {@code short} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndFloat andThenShort(OfShort.AndFloat after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptShort((short) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code float}
             *              value
             * @return a consumer that accepts an {@code short} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndFloat andThenByte(OfByte.AndFloat after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptByte((byte) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code float}
             *              value
             * @return a consumer that accepts an {@code short} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndFloat andThenBoolean(OfBoolean.AndFloat after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptBoolean(x != 0, y);
                };
            }
        }

        /**
         * A {@code OfShort} that requires a {@code char} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndChar extends OfShort<java.lang.Character> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptShort(short, java.lang.Character)}
             *          and is recommended over that one.
             */
            void acceptShort(short x, char y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptShort(short x, java.lang.Character y) {
                acceptShort(x, (char) y);
            }

            /**
             * Composes and returns a {@code OfShort.AndChar} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code char}
             *              value
             * @return a consumer that accepts an {@code short} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndChar andThenDouble(OfDouble.AndChar after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptDouble(x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndChar} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code char} value
             * @return a consumer that accepts an {@code short} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndChar andThenLong(OfLong.AndChar after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptLong((long) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndChar} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code char} value
             * @return a consumer that accepts an {@code short} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndChar andThenInt(OfInt.AndChar after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptInt((int) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndChar} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code char}
             *              value
             * @return a consumer that accepts an {@code short} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndChar andThenFloat(OfFloat.AndChar after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptFloat((float) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndChar} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code char} value
             * @return a consumer that accepts an {@code short} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndChar andThenChar(OfChar.AndChar after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptChar((char) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndChar} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code char}
             *              value
             * @return a consumer that accepts an {@code short} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndChar andThenShort(OfShort.AndChar after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptShort((short) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndChar} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code char} value
             * @return a consumer that accepts an {@code short} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndChar andThenByte(OfByte.AndChar after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptByte((byte) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndChar} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code char}
             *              value
             * @return a consumer that accepts an {@code short} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndChar andThenBoolean(OfBoolean.AndChar after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptBoolean(x != 0, y);
                };
            }
        }

        /**
         * A {@code OfShort} that requires a {@code short} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndShort extends OfShort<java.lang.Short> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptShort(short, java.lang.Short)}
             *          and is recommended over that one.
             */
            void acceptShort(short x, short y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptShort(short x, java.lang.Short y) {
                acceptShort(x, (short) y);
            }

            /**
             * Composes and returns a {@code OfShort.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code short}
             *              value
             * @return a consumer that accepts an {@code short} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndShort andThenDouble(OfDouble.AndShort after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptDouble(x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code short}
             *              value
             * @return a consumer that accepts an {@code short} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndShort andThenLong(OfLong.AndShort after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptLong((long) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code short}
             *              value
             * @return a consumer that accepts an {@code short} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndShort andThenInt(OfInt.AndShort after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptInt((int) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code short}
             *              value
             * @return a consumer that accepts an {@code short} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndShort andThenFloat(OfFloat.AndShort after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptFloat((float) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code short}
             *              value
             * @return a consumer that accepts an {@code short} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndShort andThenChar(OfChar.AndShort after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptChar((char) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code short}
             *              value
             * @return a consumer that accepts an {@code short} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndShort andThenShort(OfShort.AndShort after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptShort((short) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code short}
             *              value
             * @return a consumer that accepts an {@code short} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndShort andThenByte(OfByte.AndShort after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptByte((byte) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code short}
             *              value
             * @return a consumer that accepts an {@code short} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndShort andThenBoolean(OfBoolean.AndShort after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptBoolean(x != 0, y);
                };
            }
        }

        /**
         * A {@code OfShort} that requires a {@code byte} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndByte extends OfShort<java.lang.Byte> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptShort(short, java.lang.Byte)}
             *          and is recommended over that one.
             */
            void acceptShort(short x, byte y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptShort(short x, java.lang.Byte y) {
                acceptShort(x, (byte) y);
            }

            /**
             * Composes and returns a {@code OfShort.AndByte} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code byte}
             *              value
             * @return a consumer that accepts an {@code short} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndByte andThenDouble(OfDouble.AndByte after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptDouble(x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndByte} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code byte} value
             * @return a consumer that accepts an {@code short} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndByte andThenLong(OfLong.AndByte after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptLong((long) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndByte} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code byte} value
             * @return a consumer that accepts an {@code short} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndByte andThenInt(OfInt.AndByte after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptInt((int) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndByte} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code byte}
             *              value
             * @return a consumer that accepts an {@code short} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndByte andThenFloat(OfFloat.AndByte after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptFloat((float) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndByte} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code byte} value
             * @return a consumer that accepts an {@code short} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndByte andThenChar(OfChar.AndByte after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptChar((char) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndByte} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code byte}
             *              value
             * @return a consumer that accepts an {@code short} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndByte andThenShort(OfShort.AndByte after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptShort((short) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndByte} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code byte} value
             * @return a consumer that accepts an {@code short} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndByte andThenByte(OfByte.AndByte after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptByte((byte) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndByte} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code byte}
             *              value
             * @return a consumer that accepts an {@code short} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndByte andThenBoolean(OfBoolean.AndByte after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptBoolean(x != 0, y);
                };
            }
        }

        /**
         * A {@code OfShort} that requires a {@code boolean} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndBoolean extends OfShort<java.lang.Boolean> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptShort(short, java.lang.Boolean)}
             *          and is recommended over that one.
             */
            void acceptShort(short x, boolean y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptShort(short x, java.lang.Boolean y) {
                acceptShort(x, (boolean) y);
            }

            /**
             * Composes and returns a {@code OfShort.AndBoolean} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code boolean}
             *              value
             * @return a consumer that accepts an {@code short} and a {@code boolean} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndBoolean andThenDouble(OfDouble.AndBoolean after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptDouble(x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndBoolean} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code boolean}
             *              value
             * @return a consumer that accepts an {@code short} and a {@code boolean} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndBoolean andThenLong(OfLong.AndBoolean after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptLong((long) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndBoolean} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code boolean}
             *              value
             * @return a consumer that accepts an {@code short} and a {@code boolean} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndBoolean andThenInt(OfInt.AndBoolean after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptInt((int) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndBoolean} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code boolean}
             *              value
             * @return a consumer that accepts an {@code short} and a {@code boolean} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndBoolean andThenFloat(OfFloat.AndBoolean after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptFloat((float) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndBoolean} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code boolean}
             *              value
             * @return a consumer that accepts an {@code short} and a {@code boolean} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndBoolean andThenChar(OfChar.AndBoolean after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptChar((char) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndBoolean} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code boolean}
             *              value
             * @return a consumer that accepts an {@code short} and a {@code boolean} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndBoolean andThenShort(OfShort.AndBoolean after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptShort((short) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndBoolean} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code boolean}
             *              value
             * @return a consumer that accepts an {@code short} and a {@code boolean} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndBoolean andThenByte(OfByte.AndBoolean after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptByte((byte) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfShort.AndBoolean} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code boolean}
             *              value
             * @return a consumer that accepts an {@code short} and a {@code boolean} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfShort.AndBoolean andThenBoolean(OfBoolean.AndBoolean after) {
                return (x, y) -> {
                    acceptShort(x, y);
                    after.acceptBoolean(x != 0, y);
                };
            }
        }

    }

    /**
     * A {@code PrimitiveBiConsumer} that requires a {@code byte} and a
     * value of type {@code <AND>}.
     * 
     * @param <AND> the type of the second argument to {@link #acceptByte}
     * @see PrimitiveBiConsumer
     */
    @FunctionalInterface
    interface OfByte<AND> extends PrimitiveBiConsumer<java.lang.Byte, AND> {
        /**
         * Consumes the arguments (with possible side-effects) returning no result.
         * 
         * @param x the first {@code byte} input
         * @param y the second input
         * @apiNote This is the {@code byte} specialisation of
         *          {@link #accept(Double, Object)} and
         *          is recommended over the same.
         */
        void acceptByte(byte x, AND y);

        /**
         * {@inheritDoc}
         * 
         * @param x {@inheritDoc}
         * @param y {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote This calls {@link #acceptByte} unboxing the wrapper {@code Byte}
         *           (first argument) to a primitive
         */
        @Override
        default void accept(java.lang.Byte x, AND y) {
            acceptByte(x, y);
        }

        /**
         * Composes and returns a {@code OfByte} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires a {@code double} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code double} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfByte<AND> andThenDouble(OfDouble<? super AND> after) {
            return (x, y) -> {
                acceptByte(x, y);
                after.acceptDouble(x, y);
            };
        }

        /**
         * Composes and returns a {@code OfByte} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires a {@code long} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code double} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfByte<AND> andThenLong(OfLong<? super AND> after) {
            return (x, y) -> {
                acceptByte(x, y);
                after.acceptLong(x, y);
            };
        }

        /**
         * Composes and returns a {@code OfByte} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires an {@code int} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code double} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfByte<AND> andThenInt(OfInt<? super AND> after) {
            return (x, y) -> {
                acceptByte(x, y);
                after.acceptInt(x, y);
            };
        }

        /**
         * Composes and returns a {@code OfByte} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires a {@code float} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code double} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfByte<AND> andThenFloat(OfFloat<? super AND> after) {
            return (x, y) -> {
                acceptByte(x, y);
                after.acceptFloat(x, y);
            };
        }

        /**
         * Composes and returns a {@code OfByte} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires a {@code char} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code double} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfByte<AND> andThenChar(OfChar<? super AND> after) {
            return (x, y) -> {
                acceptByte(x, y);
                after.acceptChar((char) x, y);
            };
        }

        /**
         * Composes and returns a {@code OfByte} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires a {@code short} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code double} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfByte<AND> andThenShort(OfShort<? super AND> after) {
            return (x, y) -> {
                acceptByte(x, y);
                after.acceptShort(x, y);
            };
        }

        /**
         * Composes and returns a {@code OfByte} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires a {@code byte} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code double} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfByte<AND> andThenByte(OfByte<? super AND> after) {
            return (x, y) -> {
                acceptByte(x, y);
                after.acceptByte(x, y);
            };
        }

        /**
         * Composes and returns a {@code OfByte} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires a {@code boolean} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code double} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfByte<AND> andThenBoolean(OfBoolean<? super AND> after) {
            return (x, y) -> {
                acceptByte(x, y);
                after.acceptBoolean(x != 0, y);
            };
        }

        /**
         * A {@code OfByte} that requires a {@code double} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndDouble extends OfByte<java.lang.Double> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptByte(byte, java.lang.Double)}
             *          and is recommended over that one.
             */
            void acceptByte(byte x, double y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptByte(byte x, java.lang.Double y) {
                acceptByte(x, (double) y);
            }

            /**
             * Composes and returns a {@code OfByte.AndDouble} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code double}
             *              value
             * @return a consumer that accepts an {@code byte} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndDouble andThenDouble(OfDouble.AndDouble after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptDouble(x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndDouble} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code double}
             *              value
             * @return a consumer that accepts an {@code byte} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndDouble andThenLong(OfLong.AndDouble after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptLong((long) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndDouble} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code double}
             *              value
             * @return a consumer that accepts an {@code byte} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndDouble andThenInt(OfInt.AndDouble after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptInt((int) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndDouble} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code double}
             *              value
             * @return a consumer that accepts an {@code byte} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndDouble andThenFloat(OfFloat.AndDouble after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptFloat((float) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndDouble} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code double}
             *              value
             * @return a consumer that accepts an {@code byte} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndDouble andThenChar(OfChar.AndDouble after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptChar((char) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndDouble} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code double}
             *              value
             * @return a consumer that accepts an {@code byte} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndDouble andThenShort(OfShort.AndDouble after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptShort((short) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndDouble} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code double}
             *              value
             * @return a consumer that accepts an {@code byte} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndDouble andThenByte(OfByte.AndDouble after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptByte((byte) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndDouble} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code double}
             *              value
             * @return a consumer that accepts an {@code byte} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndDouble andThenBoolean(OfBoolean.AndDouble after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptBoolean(x != 0, y);
                };
            }
        }

        /**
         * A {@code OfByte} that requires a {@code long} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndLong extends OfByte<java.lang.Long> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptByte(byte, java.lang.Long)}
             *          and is recommended over that one.
             */
            void acceptByte(byte x, long y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptByte(byte x, java.lang.Long y) {
                acceptByte(x, (long) y);
            }

            /**
             * Composes and returns a {@code OfByte.AndLong} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code long}
             *              value
             * @return a consumer that accepts an {@code byte} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndLong andThenDouble(OfDouble.AndLong after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptDouble(x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndLong} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code long} value
             * @return a consumer that accepts an {@code byte} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndLong andThenLong(OfLong.AndLong after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptLong((long) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndLong} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code long} value
             * @return a consumer that accepts an {@code byte} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndLong andThenInt(OfInt.AndLong after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptInt((int) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndLong} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code long}
             *              value
             * @return a consumer that accepts an {@code byte} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndLong andThenFloat(OfFloat.AndLong after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptFloat((float) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndLong} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code long} value
             * @return a consumer that accepts an {@code byte} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndLong andThenChar(OfChar.AndLong after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptChar((char) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndLong} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code long}
             *              value
             * @return a consumer that accepts an {@code byte} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndLong andThenShort(OfShort.AndLong after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptShort((short) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndLong} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code long} value
             * @return a consumer that accepts an {@code byte} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndLong andThenByte(OfByte.AndLong after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptByte((byte) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndLong} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code long}
             *              value
             * @return a consumer that accepts an {@code byte} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndLong andThenBoolean(OfBoolean.AndLong after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptBoolean(x != 0, y);
                };
            }
        }

        /**
         * A {@code OfByte} that requires a {@code int} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndInt extends OfByte<java.lang.Integer> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptByte(byte, java.lang.Integer)}
             *          and is recommended over that one.
             */
            void acceptByte(byte x, int y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptByte(byte x, java.lang.Integer y) {
                acceptByte(x, (int) y);
            }

            /**
             * Composes and returns a {@code OfByte.AndInt} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code int}
             *              value
             * @return a consumer that accepts an {@code byte} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndInt andThenDouble(OfDouble.AndInt after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptDouble(x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndInt} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code int} value
             * @return a consumer that accepts an {@code byte} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndInt andThenLong(OfLong.AndInt after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptLong((long) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndInt} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code int} value
             * @return a consumer that accepts an {@code byte} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndInt andThenInt(OfInt.AndInt after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptInt((int) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndInt} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code int} value
             * @return a consumer that accepts an {@code byte} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndInt andThenFloat(OfFloat.AndInt after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptFloat((float) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndInt} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code int} value
             * @return a consumer that accepts an {@code byte} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndInt andThenChar(OfChar.AndInt after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptChar((char) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndInt} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code int} value
             * @return a consumer that accepts an {@code byte} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndInt andThenShort(OfShort.AndInt after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptShort((short) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndInt} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code int} value
             * @return a consumer that accepts an {@code byte} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndInt andThenByte(OfByte.AndInt after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptByte((byte) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndInt} that performs, in sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code int}
             *              value
             * @return a consumer that accepts an {@code byte} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndInt andThenBoolean(OfBoolean.AndInt after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptBoolean(x != 0, y);
                };
            }
        }

        /**
         * A {@code OfByte} that requires a {@code float} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndFloat extends OfByte<java.lang.Float> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptByte(byte, java.lang.Float)}
             *          and is recommended over that one.
             */
            void acceptByte(byte x, float y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptByte(byte x, java.lang.Float y) {
                acceptByte(x, (float) y);
            }

            /**
             * Composes and returns a {@code OfByte.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code float}
             *              value
             * @return a consumer that accepts an {@code byte} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndFloat andThenDouble(OfDouble.AndFloat after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptDouble(x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code float}
             *              value
             * @return a consumer that accepts an {@code byte} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndFloat andThenLong(OfLong.AndFloat after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptLong((long) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code float}
             *              value
             * @return a consumer that accepts an {@code byte} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndFloat andThenInt(OfInt.AndFloat after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptInt((int) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code float}
             *              value
             * @return a consumer that accepts an {@code byte} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndFloat andThenFloat(OfFloat.AndFloat after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptFloat((float) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code float}
             *              value
             * @return a consumer that accepts an {@code byte} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndFloat andThenChar(OfChar.AndFloat after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptChar((char) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code float}
             *              value
             * @return a consumer that accepts an {@code byte} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndFloat andThenShort(OfShort.AndFloat after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptShort((short) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code float}
             *              value
             * @return a consumer that accepts an {@code byte} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndFloat andThenByte(OfByte.AndFloat after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptByte((byte) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code float}
             *              value
             * @return a consumer that accepts an {@code byte} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndFloat andThenBoolean(OfBoolean.AndFloat after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptBoolean(x != 0, y);
                };
            }
        }

        /**
         * A {@code OfByte} that requires a {@code char} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndChar extends OfByte<java.lang.Character> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptByte(byte, java.lang.Character)}
             *          and is recommended over that one.
             */
            void acceptByte(byte x, char y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptByte(byte x, java.lang.Character y) {
                acceptByte(x, (char) y);
            }

            /**
             * Composes and returns a {@code OfByte.AndChar} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code char}
             *              value
             * @return a consumer that accepts an {@code byte} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndChar andThenDouble(OfDouble.AndChar after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptDouble(x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndChar} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code char} value
             * @return a consumer that accepts an {@code byte} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndChar andThenLong(OfLong.AndChar after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptLong((long) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndChar} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code char} value
             * @return a consumer that accepts an {@code byte} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndChar andThenInt(OfInt.AndChar after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptInt((int) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndChar} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code char}
             *              value
             * @return a consumer that accepts an {@code byte} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndChar andThenFloat(OfFloat.AndChar after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptFloat((float) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndChar} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code char} value
             * @return a consumer that accepts an {@code byte} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndChar andThenChar(OfChar.AndChar after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptChar((char) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndChar} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code char}
             *              value
             * @return a consumer that accepts an {@code byte} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndChar andThenShort(OfShort.AndChar after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptShort((short) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndChar} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code char} value
             * @return a consumer that accepts an {@code byte} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndChar andThenByte(OfByte.AndChar after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptByte((byte) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndChar} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code char}
             *              value
             * @return a consumer that accepts an {@code byte} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndChar andThenBoolean(OfBoolean.AndChar after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptBoolean(x != 0, y);
                };
            }
        }

        /**
         * A {@code OfByte} that requires a {@code short} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndShort extends OfByte<java.lang.Short> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptByte(byte, java.lang.Short)}
             *          and is recommended over that one.
             */
            void acceptByte(byte x, short y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptByte(byte x, java.lang.Short y) {
                acceptByte(x, (short) y);
            }

            /**
             * Composes and returns a {@code OfByte.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code short}
             *              value
             * @return a consumer that accepts an {@code byte} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndShort andThenDouble(OfDouble.AndShort after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptDouble(x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code short}
             *              value
             * @return a consumer that accepts an {@code byte} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndShort andThenLong(OfLong.AndShort after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptLong((long) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code short}
             *              value
             * @return a consumer that accepts an {@code byte} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndShort andThenInt(OfInt.AndShort after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptInt((int) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code short}
             *              value
             * @return a consumer that accepts an {@code byte} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndShort andThenFloat(OfFloat.AndShort after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptFloat((float) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code short}
             *              value
             * @return a consumer that accepts an {@code byte} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndShort andThenChar(OfChar.AndShort after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptChar((char) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code short}
             *              value
             * @return a consumer that accepts an {@code byte} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndShort andThenShort(OfShort.AndShort after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptShort((short) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code short}
             *              value
             * @return a consumer that accepts an {@code byte} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndShort andThenByte(OfByte.AndShort after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptByte((byte) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code short}
             *              value
             * @return a consumer that accepts an {@code byte} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndShort andThenBoolean(OfBoolean.AndShort after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptBoolean(x != 0, y);
                };
            }
        }

        /**
         * A {@code OfByte} that requires a {@code byte} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndByte extends OfByte<java.lang.Byte> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptByte(byte, java.lang.Byte)}
             *          and is recommended over that one.
             */
            void acceptByte(byte x, byte y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptByte(byte x, java.lang.Byte y) {
                acceptByte(x, (byte) y);
            }

            /**
             * Composes and returns a {@code OfByte.AndByte} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code byte}
             *              value
             * @return a consumer that accepts an {@code byte} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndByte andThenDouble(OfDouble.AndByte after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptDouble(x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndByte} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code byte} value
             * @return a consumer that accepts an {@code byte} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndByte andThenLong(OfLong.AndByte after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptLong((long) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndByte} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code byte} value
             * @return a consumer that accepts an {@code byte} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndByte andThenInt(OfInt.AndByte after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptInt((int) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndByte} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code byte}
             *              value
             * @return a consumer that accepts an {@code byte} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndByte andThenFloat(OfFloat.AndByte after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptFloat((float) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndByte} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code byte} value
             * @return a consumer that accepts an {@code byte} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndByte andThenChar(OfChar.AndByte after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptChar((char) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndByte} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code byte}
             *              value
             * @return a consumer that accepts an {@code byte} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndByte andThenShort(OfShort.AndByte after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptShort((short) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndByte} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code byte} value
             * @return a consumer that accepts an {@code byte} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndByte andThenByte(OfByte.AndByte after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptByte((byte) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndByte} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code byte}
             *              value
             * @return a consumer that accepts an {@code byte} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndByte andThenBoolean(OfBoolean.AndByte after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptBoolean(x != 0, y);
                };
            }
        }

        /**
         * A {@code OfByte} that requires a {@code boolean} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndBoolean extends OfByte<java.lang.Boolean> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptByte(byte, java.lang.Boolean)}
             *          and is recommended over that one.
             */
            void acceptByte(byte x, boolean y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptByte(byte x, java.lang.Boolean y) {
                acceptByte(x, (boolean) y);
            }

            /**
             * Composes and returns a {@code OfByte.AndBoolean} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code boolean}
             *              value
             * @return a consumer that accepts an {@code byte} and a {@code boolean} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndBoolean andThenDouble(OfDouble.AndBoolean after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptDouble(x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndBoolean} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code boolean}
             *              value
             * @return a consumer that accepts an {@code byte} and a {@code boolean} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndBoolean andThenLong(OfLong.AndBoolean after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptLong((long) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndBoolean} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code boolean}
             *              value
             * @return a consumer that accepts an {@code byte} and a {@code boolean} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndBoolean andThenInt(OfInt.AndBoolean after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptInt((int) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndBoolean} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code boolean}
             *              value
             * @return a consumer that accepts an {@code byte} and a {@code boolean} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndBoolean andThenFloat(OfFloat.AndBoolean after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptFloat((float) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndBoolean} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code boolean}
             *              value
             * @return a consumer that accepts an {@code byte} and a {@code boolean} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndBoolean andThenChar(OfChar.AndBoolean after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptChar((char) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndBoolean} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code boolean}
             *              value
             * @return a consumer that accepts an {@code byte} and a {@code boolean} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndBoolean andThenShort(OfShort.AndBoolean after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptShort((short) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndBoolean} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code boolean}
             *              value
             * @return a consumer that accepts an {@code byte} and a {@code boolean} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndBoolean andThenByte(OfByte.AndBoolean after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptByte((byte) x, y);
                };
            }

            /**
             * Composes and returns a {@code OfByte.AndBoolean} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code boolean}
             *              value
             * @return a consumer that accepts an {@code byte} and a {@code boolean} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfByte.AndBoolean andThenBoolean(OfBoolean.AndBoolean after) {
                return (x, y) -> {
                    acceptByte(x, y);
                    after.acceptBoolean(x != 0, y);
                };
            }
        }

    }

    /**
     * A {@code PrimitiveBiConsumer} that requires a {@code boolean} and a
     * value of type {@code <AND>}.
     * 
     * @param <AND> the type of the second argument to {@link #acceptBoolean}
     * @see PrimitiveBiConsumer
     */
    @FunctionalInterface
    interface OfBoolean<AND> extends PrimitiveBiConsumer<java.lang.Boolean, AND> {
        /**
         * Consumes the arguments (with possible side-effects) returning no result.
         * 
         * @param x the first {@code boolean} input
         * @param y the second input
         * @apiNote This is the {@code boolean} specialisation of
         *          {@link #accept(Double, Object)} and
         *          is recommended over the same.
         */
        void acceptBoolean(boolean x, AND y);

        /**
         * {@inheritDoc}
         * 
         * @param x {@inheritDoc}
         * @param y {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote This calls {@link #acceptBoolean} unboxing the wrapper
         *           {@code Boolean}
         *           (first argument) to a primitive
         */
        @Override
        default void accept(java.lang.Boolean x, AND y) {
            acceptBoolean(x, y);
        }

        /**
         * Composes and returns a {@code OfBoolean} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires a {@code double} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code double} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfBoolean<AND> andThenDouble(OfDouble<? super AND> after) {
            return (x, y) -> {
                acceptBoolean(x, y);
                after.acceptDouble(x ? 1 : 0, y);
            };
        }

        /**
         * Composes and returns a {@code OfBoolean} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires a {@code long} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code double} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfBoolean<AND> andThenLong(OfLong<? super AND> after) {
            return (x, y) -> {
                acceptBoolean(x, y);
                after.acceptLong(x ? 1 : 0, y);
            };
        }

        /**
         * Composes and returns a {@code OfBoolean} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires an {@code int} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code double} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfBoolean<AND> andThenInt(OfInt<? super AND> after) {
            return (x, y) -> {
                acceptBoolean(x, y);
                after.acceptInt(x ? 1 : 0, y);
            };
        }

        /**
         * Composes and returns a {@code OfBoolean} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires a {@code float} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code double} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfBoolean<AND> andThenFloat(OfFloat<? super AND> after) {
            return (x, y) -> {
                acceptBoolean(x, y);
                after.acceptFloat(x ? 1 : 0, y);
            };
        }

        /**
         * Composes and returns a {@code OfBoolean} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires a {@code char} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code double} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfBoolean<AND> andThenChar(OfChar<? super AND> after) {
            return (x, y) -> {
                acceptBoolean(x, y);
                after.acceptChar((char) (x ? 1 : 0), y);
            };
        }

        /**
         * Composes and returns a {@code OfBoolean} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires a {@code short} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code double} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfBoolean<AND> andThenShort(OfShort<? super AND> after) {
            return (x, y) -> {
                acceptBoolean(x, y);
                after.acceptShort((short) (x ? 1 : 0), y);
            };
        }

        /**
         * Composes and returns a {@code OfBoolean} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires a {@code byte} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code double} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfBoolean<AND> andThenByte(OfByte<? super AND> after) {
            return (x, y) -> {
                acceptBoolean(x, y);
                after.acceptByte((byte) (x ? 1 : 0), y);
            };
        }

        /**
         * Composes and returns a {@code OfBoolean} that performs, in sequence, this
         * operation followed by the {@code after} operation.
         * 
         * @param after a consumer that requires a {@code boolean} and a {@code <AND>}
         *              value
         * @return a consumer that accepts a {@code double} and a {@code <AND>} value
         * @apiNote This is part of a suite of methods that provide primitive support
         *          for {@link #andThen(BiConsumer)}.
         */
        default OfBoolean<AND> andThenBoolean(OfBoolean<? super AND> after) {
            return (x, y) -> {
                acceptBoolean(x, y);
                after.acceptBoolean(x, y);
            };
        }

        /**
         * A {@code OfBoolean} that requires a {@code double} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndDouble extends OfBoolean<java.lang.Double> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptBoolean(boolean, java.lang.Double)}
             *          and is recommended over that one.
             */
            void acceptBoolean(boolean x, double y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptBoolean(boolean x, java.lang.Double y) {
                acceptBoolean(x, (double) y);
            }

            /**
             * Composes and returns a {@code OfBoolean.AndDouble} that performs, in
             * sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code double}
             *              value
             * @return a consumer that accepts an {@code boolean} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndDouble andThenDouble(OfDouble.AndDouble after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptDouble((x ? 1 : 0), y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndDouble} that performs, in
             * sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code double}
             *              value
             * @return a consumer that accepts an {@code boolean} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndDouble andThenLong(OfLong.AndDouble after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptLong((long) (x ? 1 : 0), y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndDouble} that performs, in
             * sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code double}
             *              value
             * @return a consumer that accepts an {@code boolean} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndDouble andThenInt(OfInt.AndDouble after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptInt((int) (x ? 1 : 0), y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndDouble} that performs, in
             * sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code double}
             *              value
             * @return a consumer that accepts an {@code boolean} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndDouble andThenFloat(OfFloat.AndDouble after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptFloat((float) (x ? 1 : 0), y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndDouble} that performs, in
             * sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code double}
             *              value
             * @return a consumer that accepts an {@code boolean} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndDouble andThenChar(OfChar.AndDouble after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptChar((char) (x ? 1 : 0), y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndDouble} that performs, in
             * sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code double}
             *              value
             * @return a consumer that accepts an {@code boolean} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndDouble andThenShort(OfShort.AndDouble after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptShort((short) (x ? 1 : 0), y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndDouble} that performs, in
             * sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code double}
             *              value
             * @return a consumer that accepts an {@code boolean} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndDouble andThenByte(OfByte.AndDouble after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptByte((byte) (x ? 1 : 0), y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndDouble} that performs, in
             * sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code double}
             *              value
             * @return a consumer that accepts an {@code boolean} and a {@code double} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndDouble andThenBoolean(OfBoolean.AndDouble after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptBoolean(x, y);
                };
            }
        }

        /**
         * A {@code OfBoolean} that requires a {@code long} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndLong extends OfBoolean<java.lang.Long> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptBoolean(boolean, java.lang.Long)}
             *          and is recommended over that one.
             */
            void acceptBoolean(boolean x, long y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptBoolean(boolean x, java.lang.Long y) {
                acceptBoolean(x, (long) y);
            }

            /**
             * Composes and returns a {@code OfBoolean.AndLong} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code long}
             *              value
             * @return a consumer that accepts an {@code boolean} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndLong andThenDouble(OfDouble.AndLong after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptDouble((x ? 1 : 0), y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndLong} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code long} value
             * @return a consumer that accepts an {@code boolean} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndLong andThenLong(OfLong.AndLong after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptLong((long) (x ? 1 : 0), y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndLong} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code long} value
             * @return a consumer that accepts an {@code boolean} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndLong andThenInt(OfInt.AndLong after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptInt((int) (x ? 1 : 0), y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndLong} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code long}
             *              value
             * @return a consumer that accepts an {@code boolean} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndLong andThenFloat(OfFloat.AndLong after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptFloat((float) (x ? 1 : 0), y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndLong} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code long} value
             * @return a consumer that accepts an {@code boolean} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndLong andThenChar(OfChar.AndLong after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptChar((char) (x ? 1 : 0), y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndLong} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code long}
             *              value
             * @return a consumer that accepts an {@code boolean} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndLong andThenShort(OfShort.AndLong after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptShort((short) (x ? 1 : 0), y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndLong} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code long} value
             * @return a consumer that accepts an {@code boolean} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndLong andThenByte(OfByte.AndLong after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptByte((byte) (x ? 1 : 0), y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndLong} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code long}
             *              value
             * @return a consumer that accepts an {@code boolean} and a {@code long} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndLong andThenBoolean(OfBoolean.AndLong after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptBoolean(x, y);
                };
            }
        }

        /**
         * A {@code OfBoolean} that requires a {@code int} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndInt extends OfBoolean<java.lang.Integer> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptBoolean(boolean, java.lang.Integer)}
             *          and is recommended over that one.
             */
            void acceptBoolean(boolean x, int y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptBoolean(boolean x, java.lang.Integer y) {
                acceptBoolean(x, (int) y);
            }

            /**
             * Composes and returns a {@code OfBoolean.AndInt} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code int}
             *              value
             * @return a consumer that accepts an {@code boolean} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndInt andThenDouble(OfDouble.AndInt after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptDouble((x ? 1 : 0), y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndInt} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code int} value
             * @return a consumer that accepts an {@code boolean} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndInt andThenLong(OfLong.AndInt after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptLong((long) (x ? 1 : 0), y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndInt} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code int} value
             * @return a consumer that accepts an {@code boolean} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndInt andThenInt(OfInt.AndInt after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptInt((int) (x ? 1 : 0), y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndInt} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code int} value
             * @return a consumer that accepts an {@code boolean} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndInt andThenFloat(OfFloat.AndInt after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptFloat((float) (x ? 1 : 0), y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndInt} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code int} value
             * @return a consumer that accepts an {@code boolean} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndInt andThenChar(OfChar.AndInt after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptChar((char) (x ? 1 : 0), y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndInt} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code int} value
             * @return a consumer that accepts an {@code boolean} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndInt andThenShort(OfShort.AndInt after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptShort((short) (x ? 1 : 0), y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndInt} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code int} value
             * @return a consumer that accepts an {@code boolean} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndInt andThenByte(OfByte.AndInt after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptByte((byte) (x ? 1 : 0), y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndInt} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code int}
             *              value
             * @return a consumer that accepts an {@code boolean} and a {@code int} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndInt andThenBoolean(OfBoolean.AndInt after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptBoolean(x, y);
                };
            }
        }

        /**
         * A {@code OfBoolean} that requires a {@code float} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndFloat extends OfBoolean<java.lang.Float> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptBoolean(boolean, java.lang.Float)}
             *          and is recommended over that one.
             */
            void acceptBoolean(boolean x, float y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptBoolean(boolean x, java.lang.Float y) {
                acceptBoolean(x, (float) y);
            }

            /**
             * Composes and returns a {@code OfBoolean.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code float}
             *              value
             * @return a consumer that accepts an {@code boolean} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndFloat andThenDouble(OfDouble.AndFloat after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptDouble((x ? 1 : 0), y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code float}
             *              value
             * @return a consumer that accepts an {@code boolean} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndFloat andThenLong(OfLong.AndFloat after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptLong((long) (x ? 1 : 0), y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code float}
             *              value
             * @return a consumer that accepts an {@code boolean} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndFloat andThenInt(OfInt.AndFloat after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptInt((int) (x ? 1 : 0), y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code float}
             *              value
             * @return a consumer that accepts an {@code boolean} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndFloat andThenFloat(OfFloat.AndFloat after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptFloat((float) (x ? 1 : 0), y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code float}
             *              value
             * @return a consumer that accepts an {@code boolean} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndFloat andThenChar(OfChar.AndFloat after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptChar((char) (x ? 1 : 0), y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code float}
             *              value
             * @return a consumer that accepts an {@code boolean} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndFloat andThenShort(OfShort.AndFloat after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptShort((short) (x ? 1 : 0), y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code float}
             *              value
             * @return a consumer that accepts an {@code boolean} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndFloat andThenByte(OfByte.AndFloat after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptByte((byte) (x ? 1 : 0), y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndFloat} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code float}
             *              value
             * @return a consumer that accepts an {@code boolean} and a {@code float} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndFloat andThenBoolean(OfBoolean.AndFloat after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptBoolean(x, y);
                };
            }
        }

        /**
         * A {@code OfBoolean} that requires a {@code char} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndChar extends OfBoolean<java.lang.Character> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptBoolean(boolean, java.lang.Character)}
             *          and is recommended over that one.
             */
            void acceptBoolean(boolean x, char y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptBoolean(boolean x, java.lang.Character y) {
                acceptBoolean(x, (char) y);
            }

            /**
             * Composes and returns a {@code OfBoolean.AndChar} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code char}
             *              value
             * @return a consumer that accepts an {@code boolean} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndChar andThenDouble(OfDouble.AndChar after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptDouble((x ? 1 : 0), y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndChar} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code char} value
             * @return a consumer that accepts an {@code boolean} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndChar andThenLong(OfLong.AndChar after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptLong((long) (x ? 1 : 0), y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndChar} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code char} value
             * @return a consumer that accepts an {@code boolean} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndChar andThenInt(OfInt.AndChar after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptInt((int) (x ? 1 : 0), y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndChar} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code char}
             *              value
             * @return a consumer that accepts an {@code boolean} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndChar andThenFloat(OfFloat.AndChar after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptFloat((float) (x ? 1 : 0), y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndChar} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code char} value
             * @return a consumer that accepts an {@code boolean} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndChar andThenChar(OfChar.AndChar after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptChar((char) (x ? 1 : 0), y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndChar} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code char}
             *              value
             * @return a consumer that accepts an {@code boolean} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndChar andThenShort(OfShort.AndChar after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptShort((short) (x ? 1 : 0), y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndChar} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code char} value
             * @return a consumer that accepts an {@code boolean} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndChar andThenByte(OfByte.AndChar after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptByte((byte) (x ? 1 : 0), y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndChar} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code char}
             *              value
             * @return a consumer that accepts an {@code boolean} and a {@code char} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndChar andThenBoolean(OfBoolean.AndChar after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptBoolean(x, y);
                };
            }
        }

        /**
         * A {@code OfBoolean} that requires a {@code short} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndShort extends OfBoolean<java.lang.Short> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptBoolean(boolean, java.lang.Short)}
             *          and is recommended over that one.
             */
            void acceptBoolean(boolean x, short y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptBoolean(boolean x, java.lang.Short y) {
                acceptBoolean(x, (short) y);
            }

            /**
             * Composes and returns a {@code OfBoolean.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code short}
             *              value
             * @return a consumer that accepts an {@code boolean} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndShort andThenDouble(OfDouble.AndShort after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptDouble((x ? 1 : 0), y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code short}
             *              value
             * @return a consumer that accepts an {@code boolean} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndShort andThenLong(OfLong.AndShort after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptLong((long) (x ? 1 : 0), y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code short}
             *              value
             * @return a consumer that accepts an {@code boolean} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndShort andThenInt(OfInt.AndShort after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptInt((int) (x ? 1 : 0), y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code short}
             *              value
             * @return a consumer that accepts an {@code boolean} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndShort andThenFloat(OfFloat.AndShort after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptFloat((float) (x ? 1 : 0), y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code short}
             *              value
             * @return a consumer that accepts an {@code boolean} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndShort andThenChar(OfChar.AndShort after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptChar((char) (x ? 1 : 0), y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code short}
             *              value
             * @return a consumer that accepts an {@code boolean} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndShort andThenShort(OfShort.AndShort after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptShort((short) (x ? 1 : 0), y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code short}
             *              value
             * @return a consumer that accepts an {@code boolean} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndShort andThenByte(OfByte.AndShort after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptByte((byte) (x ? 1 : 0), y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndShort} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code short}
             *              value
             * @return a consumer that accepts an {@code boolean} and a {@code short} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndShort andThenBoolean(OfBoolean.AndShort after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptBoolean(x, y);
                };
            }
        }

        /**
         * A {@code OfBoolean} that requires a {@code byte} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndByte extends OfBoolean<java.lang.Byte> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptBoolean(boolean, java.lang.Byte)}
             *          and is recommended over that one.
             */
            void acceptBoolean(boolean x, byte y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptBoolean(boolean x, java.lang.Byte y) {
                acceptBoolean(x, (byte) y);
            }

            /**
             * Composes and returns a {@code OfBoolean.AndByte} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code byte}
             *              value
             * @return a consumer that accepts an {@code boolean} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndByte andThenDouble(OfDouble.AndByte after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptDouble((x ? 1 : 0), y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndByte} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code byte} value
             * @return a consumer that accepts an {@code boolean} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndByte andThenLong(OfLong.AndByte after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptLong((long) (x ? 1 : 0), y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndByte} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code byte} value
             * @return a consumer that accepts an {@code boolean} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndByte andThenInt(OfInt.AndByte after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptInt((int) (x ? 1 : 0), y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndByte} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code byte}
             *              value
             * @return a consumer that accepts an {@code boolean} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndByte andThenFloat(OfFloat.AndByte after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptFloat((float) (x ? 1 : 0), y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndByte} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code byte} value
             * @return a consumer that accepts an {@code boolean} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndByte andThenChar(OfChar.AndByte after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptChar((char) (x ? 1 : 0), y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndByte} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code byte}
             *              value
             * @return a consumer that accepts an {@code boolean} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndByte andThenShort(OfShort.AndByte after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptShort((short) (x ? 1 : 0), y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndByte} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code byte} value
             * @return a consumer that accepts an {@code boolean} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndByte andThenByte(OfByte.AndByte after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptByte((byte) (x ? 1 : 0), y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndByte} that performs, in sequence,
             * this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code byte}
             *              value
             * @return a consumer that accepts an {@code boolean} and a {@code byte} value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndByte andThenBoolean(OfBoolean.AndByte after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptBoolean(x, y);
                };
            }
        }

        /**
         * A {@code OfBoolean} that requires a {@code boolean} as the second
         * argument.
         */
        @FunctionalInterface
        interface AndBoolean extends OfBoolean<java.lang.Boolean> {
            /**
             * Consumes the argument, possibly with side-effects.
             * 
             * @param x the first input
             * @param y the second input
             * @apiNote This is the most specialised form of
             *          {@link #acceptBoolean(boolean, java.lang.Boolean)}
             *          and is recommended over that one.
             */
            void acceptBoolean(boolean x, boolean y);

            /**
             * {@inheritDoc}
             * 
             * @param x {@inheritDoc}
             * @param y {@inheritDoc}
             * @implNote The default implementation unboxes the value of the second argument
             *           to it's
             *           primitive peer.
             */
            @Override
            default void acceptBoolean(boolean x, java.lang.Boolean y) {
                acceptBoolean(x, (boolean) y);
            }

            /**
             * Composes and returns a {@code OfBoolean.AndBoolean} that performs, in
             * sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code double} and a {@code boolean}
             *              value
             * @return a consumer that accepts an {@code boolean} and a {@code boolean}
             *         value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndBoolean andThenDouble(OfDouble.AndBoolean after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptDouble((x ? 1 : 0), y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndBoolean} that performs, in
             * sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code long} and a {@code boolean}
             *              value
             * @return a consumer that accepts an {@code boolean} and a {@code boolean}
             *         value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndBoolean andThenLong(OfLong.AndBoolean after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptLong((long) (x ? 1 : 0), y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndBoolean} that performs, in
             * sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires an {@code int} and a {@code boolean}
             *              value
             * @return a consumer that accepts an {@code boolean} and a {@code boolean}
             *         value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndBoolean andThenInt(OfInt.AndBoolean after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptInt((int) (x ? 1 : 0), y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndBoolean} that performs, in
             * sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code float} and a {@code boolean}
             *              value
             * @return a consumer that accepts an {@code boolean} and a {@code boolean}
             *         value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndBoolean andThenFloat(OfFloat.AndBoolean after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptFloat((float) (x ? 1 : 0), y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndBoolean} that performs, in
             * sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code char} and a {@code boolean}
             *              value
             * @return a consumer that accepts an {@code boolean} and a {@code boolean}
             *         value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndBoolean andThenChar(OfChar.AndBoolean after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptChar((char) (x ? 1 : 0), y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndBoolean} that performs, in
             * sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code short} and a {@code boolean}
             *              value
             * @return a consumer that accepts an {@code boolean} and a {@code boolean}
             *         value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndBoolean andThenShort(OfShort.AndBoolean after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptShort((short) (x ? 1 : 0), y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndBoolean} that performs, in
             * sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code byte} and a {@code boolean}
             *              value
             * @return a consumer that accepts an {@code boolean} and a {@code boolean}
             *         value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndBoolean andThenByte(OfByte.AndBoolean after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptByte((byte) (x ? 1 : 0), y);
                };
            }

            /**
             * Composes and returns a {@code OfBoolean.AndBoolean} that performs, in
             * sequence, this
             * operation followed by the {@code after} operation.
             * 
             * @param after a consumer that requires a {@code boolean} and a {@code boolean}
             *              value
             * @return a consumer that accepts an {@code boolean} and a {@code boolean}
             *         value
             * @apiNote This is part of a suite of methods that provide primitive support
             *          for {@link #andThen(BiConsumer)}.
             */
            default OfBoolean.AndBoolean andThenBoolean(OfBoolean.AndBoolean after) {
                return (x, y) -> {
                    acceptBoolean(x, y);
                    after.acceptBoolean((boolean) x, y);
                };
            }
        }

    }
}
