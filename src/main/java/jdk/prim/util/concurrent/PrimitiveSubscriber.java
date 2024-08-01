package jdk.prim.util.concurrent;

import java.util.concurrent.Flow.Subscriber;

/**
 * A {@code Subscriber} for primitive items.
 * 
 * @param <OF> the type of items it recieves
 * @see Subscriber
 */
public interface PrimitiveSubscriber<OF> extends Subscriber<OF> {
    /**
     * A {@code Subscriber} of {@code double} items.
     */
    interface OfDouble extends PrimitiveSubscriber<java.lang.Double> {
        /**
         * The {@code double} specialisation of {@link #onNext(java.lang.Double)}
         * @param item the next item in the reactive stream pipeline
         * @see Susbscriber#onNext(Object)
         */
        void onNextDouble(double item);
        /**
         * {@inheritDoc}
         * 
         * @param item {@inheritDoc}
         * @implNote This default implementation calls {@link #onNextDouble}
         * prompting a primitive conversion in the process.
         */
        @Override default void onNext(java.lang.Double item) { onNextDouble(item); }
    }
    /**
     * A {@code Subscriber} of {@code long} items.
     */
    interface OfLong extends PrimitiveSubscriber<java.lang.Long> {
        /**
         * The {@code long} specialisation of {@link #onNext(java.lang.Long)}
         * @param item the next item in the reactive stream pipeline
         * @see Susbscriber#onNext(Object)
         */
        void onNextLong(long item);
        /**
         * {@inheritDoc}
         * 
         * @param item {@inheritDoc}
         * @implNote This default implementation calls {@link #onNextLong}
         * prompting a primitive conversion in the process.
         */
        @Override default void onNext(java.lang.Long item) { onNextLong(item); }
    }
    /**
     * A {@code Subscriber} of {@code int} items.
     */
    interface OfInt extends PrimitiveSubscriber<java.lang.Integer> {
        /**
         * The {@code int} specialisation of {@link #onNext(java.lang.Integer)}
         * @param item the next item in the reactive stream pipeline
         * @see Susbscriber#onNext(Object)
         */
        void onNextInt(int item);
        /**
         * {@inheritDoc}
         * 
         * @param item {@inheritDoc}
         * @implNote This default implementation calls {@link #onNextInt}
         * prompting a primitive conversion in the process.
         */
        @Override default void onNext(java.lang.Integer item) { onNextInt(item); }
    }
    /**
     * A {@code Subscriber} of {@code float} items.
     */
    interface OfFloat extends PrimitiveSubscriber<java.lang.Float> {
        /**
         * The {@code float} specialisation of {@link #onNext(java.lang.Float)}
         * @param item the next item in the reactive stream pipeline
         * @see Susbscriber#onNext(Object)
         */
        void onNextFloat(float item);
        /**
         * {@inheritDoc}
         * 
         * @param item {@inheritDoc}
         * @implNote This default implementation calls {@link #onNextFloat}
         * prompting a primitive conversion in the process.
         */
        @Override default void onNext(java.lang.Float item) { onNextFloat(item); }
    }
    /**
     * A {@code Subscriber} of {@code char} items.
     */
    interface OfChar extends PrimitiveSubscriber<java.lang.Character> {
        /**
         * The {@code char} specialisation of {@link #onNext(java.lang.Character)}
         * @param item the next item in the reactive stream pipeline
         * @see Susbscriber#onNext(Object)
         */
        void onNextChar(char item);
        /**
         * {@inheritDoc}
         * 
         * @param item {@inheritDoc}
         * @implNote This default implementation calls {@link #onNextChar}
         * prompting a primitive conversion in the process.
         */
        @Override default void onNext(java.lang.Character item) { onNextChar(item); }
    }
    /**
     * A {@code Subscriber} of {@code short} items.
     */
    interface OfShort extends PrimitiveSubscriber<java.lang.Short> {
        /**
         * The {@code short} specialisation of {@link #onNext(java.lang.Short)}
         * @param item the next item in the reactive stream pipeline
         * @see Susbscriber#onNext(Object)
         */
        void onNextShort(short item);
        /**
         * {@inheritDoc}
         * 
         * @param item {@inheritDoc}
         * @implNote This default implementation calls {@link #onNextShort}
         * prompting a primitive conversion in the process.
         */
        @Override default void onNext(java.lang.Short item) { onNextShort(item); }
    }
    /**
     * A {@code Subscriber} of {@code byte} items.
     */
    interface OfByte extends PrimitiveSubscriber<java.lang.Byte> {
        /**
         * The {@code byte} specialisation of {@link #onNext(java.lang.Byte)}
         * @param item the next item in the reactive stream pipeline
         * @see Susbscriber#onNext(Object)
         */
        void onNextByte(byte item);
        /**
         * {@inheritDoc}
         * 
         * @param item {@inheritDoc}
         * @implNote This default implementation calls {@link #onNextByte}
         * prompting a primitive conversion in the process.
         */
        @Override default void onNext(java.lang.Byte item) { onNextByte(item); }
    }
    /**
     * A {@code Subscriber} of {@code boolean} items.
     */
    interface OfBoolean extends PrimitiveSubscriber<java.lang.Boolean> {
        /**
         * The {@code boolean} specialisation of {@link #onNext(java.lang.Boolean)}
         * @param item the next item in the reactive stream pipeline
         * @see Susbscriber#onNext(Object)
         */
        void onNextBoolean(boolean item);
        /**
         * {@inheritDoc}
         * 
         * @param item {@inheritDoc}
         * @implNote This default implementation calls {@link #onNextBoolean}
         * prompting a primitive conversion in the process.
         */
        @Override default void onNext(java.lang.Boolean item) { onNextBoolean(item); }
    }
}