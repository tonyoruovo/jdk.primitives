package jdk.prim.util.concurrent;

import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

/**
 * A {@code Publisher} of primitive values
 * 
 * @param <OF> the type of items it publishes
 * @see Publisher
 */
@FunctionalInterface
public interface PrimitivePublisher<OF> extends Publisher<OF> {
    /**
     * A {@code Publisher} of {@code double}s
     */
    @FunctionalInterface
    interface OfDouble extends PrimitivePublisher<java.lang.Double> {
        /**
         * The {@code double} specialisation for {@link #subscribe(Subscriber)}
         * 
         * @param subscriber the subscriber to registered/added by this
         *                   {@code Publisher}
         * @see Publisher#subscribe(Subscriber)
         */
        void subscribeDouble(PrimitiveSubscriber.OfDouble subscriber);

        /**
         * {@inheritDoc}
         * 
         * @param subscriber {@inheritDoc}
         * @implSpec The default implementation calls
         *           {@link #subscribeDouble(PrimitiveSubscriber.OfDouble)}
         *           triggering narrowing primitive conversions in the process
         */
        @Override
        default void subscribe(Subscriber<? super java.lang.Double> subscriber) {
            subscribeDouble(new PrimitiveSubscriber.OfDouble() {
                public void onComplete() {
                    subscriber.onComplete();
                }

                public void onError(Throwable t) {
                    subscriber.onError(t);
                }

                public void onNextDouble(double d) {
                    subscriber.onNext(d);
                }

                public void onSubscribe(Subscription sub) {
                    subscriber.onSubscribe(sub);
                }
            });
        }
    }

    /**
     * A {@code Publisher} of {@code long}s
     */
    @FunctionalInterface
    interface OfLong extends PrimitivePublisher<java.lang.Long> {
        /**
         * The {@code long} specialisation for {@link #subscribe(Subscriber)}
         * 
         * @param subscriber the subscriber to registered/added by this
         *                   {@code Publisher}
         * @see Publisher#subscribe(Subscriber)
         */
        void subscribeLong(PrimitiveSubscriber.OfLong subscriber);

        /**
         * {@inheritDoc}
         * 
         * @param subscriber {@inheritDoc}
         * @implSpec The default implementation calls
         *           {@link #subscribeLong(PrimitiveSubscriber.OfLong)}
         *           triggering narrowing primitive conversions in the process
         */
        @Override
        default void subscribe(Subscriber<? super java.lang.Long> subscriber) {
            subscribeLong(new PrimitiveSubscriber.OfLong() {
                public void onComplete() {
                    subscriber.onComplete();
                }

                public void onError(Throwable t) {
                    subscriber.onError(t);
                }

                public void onNextLong(long l) {
                    subscriber.onNext(l);
                }

                public void onSubscribe(Subscription sub) {
                    subscriber.onSubscribe(sub);
                }
            });
        }
    }

    /**
     * A {@code Publisher} of {@code int}s
     */
    @FunctionalInterface
    interface OfInt extends PrimitivePublisher<java.lang.Integer> {
        /**
         * The {@code int} specialisation for {@link #subscribe(Subscriber)}
         * 
         * @param subscriber the subscriber to registered/added by this
         *                   {@code Publisher}
         * @see Publisher#subscribe(Subscriber)
         */
        void subscribeInt(PrimitiveSubscriber.OfInt subscriber);

        /**
         * {@inheritDoc}
         * 
         * @param subscriber {@inheritDoc}
         * @implSpec The default implementation calls
         *           {@link #subscribeInt(PrimitiveSubscriber.OfInt)}
         *           triggering narrowing primitive conversions in the process
         */
        @Override
        default void subscribe(Subscriber<? super java.lang.Integer> subscriber) {
            subscribeInt(new PrimitiveSubscriber.OfInt() {
                public void onComplete() {
                    subscriber.onComplete();
                }

                public void onError(Throwable t) {
                    subscriber.onError(t);
                }

                public void onNextInt(int i) {
                    subscriber.onNext(i);
                }

                public void onSubscribe(Subscription sub) {
                    subscriber.onSubscribe(sub);
                }
            });
        }
    }

    /**
     * A {@code Publisher} of {@code float}s
     */
    @FunctionalInterface
    interface OfFloat extends PrimitivePublisher<java.lang.Float> {
        /**
         * The {@code float} specialisation for {@link #subscribe(Subscriber)}
         * 
         * @param subscriber the subscriber to registered/added by this
         *                   {@code Publisher}
         * @see Publisher#subscribe(Subscriber)
         */
        void subscribeFloat(PrimitiveSubscriber.OfFloat subscriber);

        /**
         * {@inheritDoc}
         * 
         * @param subscriber {@inheritDoc}
         * @implSpec The default implementation calls
         *           {@link #subscribeFloat(PrimitiveSubscriber.OfFloat)}
         *           triggering narrowing primitive conversions in the process
         */
        @Override
        default void subscribe(Subscriber<? super java.lang.Float> subscriber) {
            subscribeFloat(new PrimitiveSubscriber.OfFloat() {
                public void onComplete() {
                    subscriber.onComplete();
                }

                public void onError(Throwable t) {
                    subscriber.onError(t);
                }

                public void onNextFloat(float f) {
                    subscriber.onNext(f);
                }

                public void onSubscribe(Subscription sub) {
                    subscriber.onSubscribe(sub);
                }
            });
        }
    }

    /**
     * A {@code Publisher} of {@code char}s
     */
    @FunctionalInterface
    interface OfChar extends PrimitivePublisher<java.lang.Character> {
        /**
         * The {@code char} specialisation for {@link #subscribe(Subscriber)}
         * 
         * @param subscriber the subscriber to registered/added by this
         *                   {@code Publisher}
         * @see Publisher#subscribe(Subscriber)
         */
        void subscribeChar(PrimitiveSubscriber.OfChar subscriber);

        /**
         * {@inheritDoc}
         * 
         * @param subscriber {@inheritDoc}
         * @implSpec The default implementation calls
         *           {@link #subscribeChar(PrimitiveSubscriber.OfChar)}
         *           triggering narrowing primitive conversions in the process
         */
        @Override
        default void subscribe(Subscriber<? super java.lang.Character> subscriber) {
            subscribeChar(new PrimitiveSubscriber.OfChar() {
                public void onComplete() {
                    subscriber.onComplete();
                }

                public void onError(Throwable t) {
                    subscriber.onError(t);
                }

                public void onNextChar(char c) {
                    subscriber.onNext(c);
                }

                public void onSubscribe(Subscription sub) {
                    subscriber.onSubscribe(sub);
                }
            });
        }
    }

    /**
     * A {@code Publisher} of {@code short}s
     */
    @FunctionalInterface
    interface OfShort extends PrimitivePublisher<java.lang.Short> {
        /**
         * The {@code short} specialisation for {@link #subscribe(Subscriber)}
         * 
         * @param subscriber the subscriber to registered/added by this
         *                   {@code Publisher}
         * @see Publisher#subscribe(Subscriber)
         */
        void subscribeShort(PrimitiveSubscriber.OfShort subscriber);

        /**
         * {@inheritDoc}
         * 
         * @param subscriber {@inheritDoc}
         * @implSpec The default implementation calls
         *           {@link #subscribeShort(PrimitiveSubscriber.OfShort)}
         *           triggering narrowing primitive conversions in the process
         */
        @Override
        default void subscribe(Subscriber<? super java.lang.Short> subscriber) {
            subscribeShort(new PrimitiveSubscriber.OfShort() {
                public void onComplete() {
                    subscriber.onComplete();
                }

                public void onError(Throwable t) {
                    subscriber.onError(t);
                }

                public void onNextShort(short s) {
                    subscriber.onNext(s);
                }

                public void onSubscribe(Subscription sub) {
                    subscriber.onSubscribe(sub);
                }
            });
        }
    }

    /**
     * A {@code Publisher} of {@code byte}s
     */
    @FunctionalInterface
    interface OfByte extends PrimitivePublisher<java.lang.Byte> {
        /**
         * The {@code byte} specialisation for {@link #subscribe(Subscriber)}
         * 
         * @param subscriber the subscriber to registered/added by this
         *                   {@code Publisher}
         * @see Publisher#subscribe(Subscriber)
         */
        void subscribeByte(PrimitiveSubscriber.OfByte subscriber);

        /**
         * {@inheritDoc}
         * 
         * @param subscriber {@inheritDoc}
         * @implSpec The default implementation calls
         *           {@link #subscribeByte(PrimitiveSubscriber.OfByte)}
         *           triggering narrowing primitive conversions in the process
         */
        @Override
        default void subscribe(Subscriber<? super java.lang.Byte> subscriber) {
            subscribeByte(new PrimitiveSubscriber.OfByte() {
                public void onComplete() {
                    subscriber.onComplete();
                }

                public void onError(Throwable t) {
                    subscriber.onError(t);
                }

                public void onNextByte(byte b) {
                    subscriber.onNext(b);
                }

                public void onSubscribe(Subscription sub) {
                    subscriber.onSubscribe(sub);
                }
            });
        }
    }

    /**
     * A {@code Publisher} of {@code boolean}s
     */
    @FunctionalInterface
    interface OfBoolean extends PrimitivePublisher<java.lang.Boolean> {
        /**
         * The {@code boolean} specialisation for {@link #subscribe(Subscriber)}
         * 
         * @param subscriber the subscriber to registered/added by this
         *                   {@code Publisher}
         * @see Publisher#subscribe(Subscriber)
         */
        void subscribeBoolean(PrimitiveSubscriber.OfBoolean subscriber);

        /**
         * {@inheritDoc}
         * 
         * @param subscriber {@inheritDoc}
         * @implSpec The default implementation calls
         *           {@link #subscribeBoolean(PrimitiveSubscriber.OfBoolean)}
         *           triggering narrowing primitive conversions in the process
         */
        @Override
        default void subscribe(Subscriber<? super java.lang.Boolean> subscriber) {
            subscribeBoolean(new PrimitiveSubscriber.OfBoolean() {
                public void onComplete() {
                    subscriber.onComplete();
                }

                public void onError(Throwable t) {
                    subscriber.onError(t);
                }

                public void onNextBoolean(boolean b) {
                    subscriber.onNext(b);
                }

                public void onSubscribe(Subscription sub) {
                    subscriber.onSubscribe(sub);
                }
            });
        }
    }
}
