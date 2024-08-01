package jdk.prim.util.concurrent;

import java.util.concurrent.Flow.Processor;

/**
 * A {@code Flow.Processor} object that supports primitive values
 * 
 * @param <OF> the type of items to recieve as a subscriber
 * @param <AND> the type of items to produce as a publisher
 * 
 * @see Processor
 */
public interface PrimitiveProcessor<OF, AND> extends Processor<OF, AND>, PrimitivePublisher<AND>, PrimitiveSubscriber<OF> {
    /**
     * A {@code PrimitiveProcessor} that subscribe to {@code double} values and publishes {@code <AND>} values
     * 
     * @param <AND> the type of value it publishes
     */
    interface OfDouble<AND> extends PrimitiveProcessor<java.lang.Double, AND>, PrimitiveSubscriber.OfDouble {
        /**
         * A {@code PrimitiveProcessor.OfDouble} that subscribes to {@code double} items and publishes
         * {@code double} items
         */
        interface AndDouble extends PrimitiveProcessor.OfDouble<java.lang.Double>, PrimitivePublisher.OfDouble {}
        /**
         * A {@code PrimitiveProcessor.OfDouble} that subscribes to {@code double} items and publishes
         * {@code long} items
         */
        interface AndLong extends PrimitiveProcessor.OfDouble<java.lang.Long>, PrimitivePublisher.OfLong {}
        /**
         * A {@code PrimitiveProcessor.OfDouble} that subscribes to {@code double} items and publishes
         * {@code int} items
         */
        interface AndInt extends PrimitiveProcessor.OfDouble<java.lang.Integer>, PrimitivePublisher.OfInt {}
        /**
         * A {@code PrimitiveProcessor.OfDouble} that subscribes to {@code double} items and publishes
         * {@code float} items
         */
        interface AndFloat extends PrimitiveProcessor.OfDouble<java.lang.Float>, PrimitivePublisher.OfFloat {}
        /**
         * A {@code PrimitiveProcessor.OfDouble} that subscribes to {@code double} items and publishes
         * {@code char} items
         */
        interface AndChar extends PrimitiveProcessor.OfDouble<java.lang.Character>, PrimitivePublisher.OfChar {}
        /**
         * A {@code PrimitiveProcessor.OfDouble} that subscribes to {@code double} items and publishes
         * {@code short} items
         */
        interface AndShort extends PrimitiveProcessor.OfDouble<java.lang.Short>, PrimitivePublisher.OfShort {}
        /**
         * A {@code PrimitiveProcessor.OfDouble} that subscribes to {@code double} items and publishes
         * {@code byte} items
         */
        interface AndByte extends PrimitiveProcessor.OfDouble<java.lang.Byte>, PrimitivePublisher.OfByte {}
        /**
         * A {@code PrimitiveProcessor.OfDouble} that subscribes to {@code double} items and publishes
         * {@code boolean} items
         */
        interface AndBoolean extends PrimitiveProcessor.OfDouble<java.lang.Boolean>, PrimitivePublisher.OfBoolean {}
    }
    /**
     * A {@code PrimitiveProcessor} that subscribe to {@code long} values and publishes {@code <AND>} values
     * 
     * @param <AND> the type of value it publishes
     */
    interface OfLong<AND> extends PrimitiveProcessor<java.lang.Long, AND>, PrimitiveSubscriber.OfLong {
        /**
         * A {@code PrimitiveProcessor.OfLong} that subscribes to {@code long} items and publishes
         * {@code double} items
         */
        interface AndDouble extends PrimitiveProcessor.OfLong<java.lang.Double>, PrimitivePublisher.OfDouble {}
        /**
         * A {@code PrimitiveProcessor.OfLong} that subscribes to {@code long} items and publishes
         * {@code long} items
         */
        interface AndLong extends PrimitiveProcessor.OfLong<java.lang.Long>, PrimitivePublisher.OfLong {}
        /**
         * A {@code PrimitiveProcessor.OfLong} that subscribes to {@code long} items and publishes
         * {@code int} items
         */
        interface AndInt extends PrimitiveProcessor.OfLong<java.lang.Integer>, PrimitivePublisher.OfInt {}
        /**
         * A {@code PrimitiveProcessor.OfLong} that subscribes to {@code long} items and publishes
         * {@code float} items
         */
        interface AndFloat extends PrimitiveProcessor.OfLong<java.lang.Float>, PrimitivePublisher.OfFloat {}
        /**
         * A {@code PrimitiveProcessor.OfLong} that subscribes to {@code long} items and publishes
         * {@code char} items
         */
        interface AndChar extends PrimitiveProcessor.OfLong<java.lang.Character>, PrimitivePublisher.OfChar {}
        /**
         * A {@code PrimitiveProcessor.OfLong} that subscribes to {@code long} items and publishes
         * {@code short} items
         */
        interface AndShort extends PrimitiveProcessor.OfLong<java.lang.Short>, PrimitivePublisher.OfShort {}
        /**
         * A {@code PrimitiveProcessor.OfLong} that subscribes to {@code long} items and publishes
         * {@code byte} items
         */
        interface AndByte extends PrimitiveProcessor.OfLong<java.lang.Byte>, PrimitivePublisher.OfByte {}
        /**
         * A {@code PrimitiveProcessor.OfLong} that subscribes to {@code long} items and publishes
         * {@code boolean} items
         */
        interface AndBoolean extends PrimitiveProcessor.OfLong<java.lang.Boolean>, PrimitivePublisher.OfBoolean {}
    }
    /**
     * A {@code PrimitiveProcessor} that subscribe to {@code int} values and publishes {@code <AND>} values
     * 
     * @param <AND> the type of value it publishes
     */
    interface OfInt<AND> extends PrimitiveProcessor<java.lang.Integer, AND>, PrimitiveSubscriber.OfInt {
        /**
         * A {@code PrimitiveProcessor.OfInt} that subscribes to {@code int} items and publishes
         * {@code double} items
         */
        interface AndDouble extends PrimitiveProcessor.OfInt<java.lang.Double>, PrimitivePublisher.OfDouble {}
        /**
         * A {@code PrimitiveProcessor.OfInt} that subscribes to {@code int} items and publishes
         * {@code long} items
         */
        interface AndLong extends PrimitiveProcessor.OfInt<java.lang.Long>, PrimitivePublisher.OfLong {}
        /**
         * A {@code PrimitiveProcessor.OfInt} that subscribes to {@code int} items and publishes
         * {@code int} items
         */
        interface AndInt extends PrimitiveProcessor.OfInt<java.lang.Integer>, PrimitivePublisher.OfInt {}
        /**
         * A {@code PrimitiveProcessor.OfInt} that subscribes to {@code int} items and publishes
         * {@code float} items
         */
        interface AndFloat extends PrimitiveProcessor.OfInt<java.lang.Float>, PrimitivePublisher.OfFloat {}
        /**
         * A {@code PrimitiveProcessor.OfInt} that subscribes to {@code int} items and publishes
         * {@code char} items
         */
        interface AndChar extends PrimitiveProcessor.OfInt<java.lang.Character>, PrimitivePublisher.OfChar {}
        /**
         * A {@code PrimitiveProcessor.OfInt} that subscribes to {@code int} items and publishes
         * {@code short} items
         */
        interface AndShort extends PrimitiveProcessor.OfInt<java.lang.Short>, PrimitivePublisher.OfShort {}
        /**
         * A {@code PrimitiveProcessor.OfInt} that subscribes to {@code int} items and publishes
         * {@code byte} items
         */
        interface AndByte extends PrimitiveProcessor.OfInt<java.lang.Byte>, PrimitivePublisher.OfByte {}
        /**
         * A {@code PrimitiveProcessor.OfInt} that subscribes to {@code int} items and publishes
         * {@code boolean} items
         */
        interface AndBoolean extends PrimitiveProcessor.OfInt<java.lang.Boolean>, PrimitivePublisher.OfBoolean {}
    }
    /**
     * A {@code PrimitiveProcessor} that subscribe to {@code float} values and publishes {@code <AND>} values
     * 
     * @param <AND> the type of value it publishes
     */
    interface OfFloat<AND> extends PrimitiveProcessor<java.lang.Float, AND>, PrimitiveSubscriber.OfFloat {
        /**
         * A {@code PrimitiveProcessor.OfFloat} that subscribes to {@code float} items and publishes
         * {@code double} items
         */
        interface AndDouble extends PrimitiveProcessor.OfFloat<java.lang.Double>, PrimitivePublisher.OfDouble {}
        /**
         * A {@code PrimitiveProcessor.OfFloat} that subscribes to {@code float} items and publishes
         * {@code long} items
         */
        interface AndLong extends PrimitiveProcessor.OfFloat<java.lang.Long>, PrimitivePublisher.OfLong {}
        /**
         * A {@code PrimitiveProcessor.OfFloat} that subscribes to {@code float} items and publishes
         * {@code int} items
         */
        interface AndInt extends PrimitiveProcessor.OfFloat<java.lang.Integer>, PrimitivePublisher.OfInt {}
        /**
         * A {@code PrimitiveProcessor.OfFloat} that subscribes to {@code float} items and publishes
         * {@code float} items
         */
        interface AndFloat extends PrimitiveProcessor.OfFloat<java.lang.Float>, PrimitivePublisher.OfFloat {}
        /**
         * A {@code PrimitiveProcessor.OfFloat} that subscribes to {@code float} items and publishes
         * {@code char} items
         */
        interface AndChar extends PrimitiveProcessor.OfFloat<java.lang.Character>, PrimitivePublisher.OfChar {}
        /**
         * A {@code PrimitiveProcessor.OfFloat} that subscribes to {@code float} items and publishes
         * {@code short} items
         */
        interface AndShort extends PrimitiveProcessor.OfFloat<java.lang.Short>, PrimitivePublisher.OfShort {}
        /**
         * A {@code PrimitiveProcessor.OfFloat} that subscribes to {@code float} items and publishes
         * {@code byte} items
         */
        interface AndByte extends PrimitiveProcessor.OfFloat<java.lang.Byte>, PrimitivePublisher.OfByte {}
        /**
         * A {@code PrimitiveProcessor.OfFloat} that subscribes to {@code float} items and publishes
         * {@code boolean} items
         */
        interface AndBoolean extends PrimitiveProcessor.OfFloat<java.lang.Boolean>, PrimitivePublisher.OfBoolean {}
    }
    /**
     * A {@code PrimitiveProcessor} that subscribe to {@code char} values and publishes {@code <AND>} values
     * 
     * @param <AND> the type of value it publishes
     */
    interface OfChar<AND> extends PrimitiveProcessor<java.lang.Character, AND>, PrimitiveSubscriber.OfChar {
        /**
         * A {@code PrimitiveProcessor.OfChar} that subscribes to {@code char} items and publishes
         * {@code double} items
         */
        interface AndDouble extends PrimitiveProcessor.OfChar<java.lang.Double>, PrimitivePublisher.OfDouble {}
        /**
         * A {@code PrimitiveProcessor.OfChar} that subscribes to {@code char} items and publishes
         * {@code long} items
         */
        interface AndLong extends PrimitiveProcessor.OfChar<java.lang.Long>, PrimitivePublisher.OfLong {}
        /**
         * A {@code PrimitiveProcessor.OfChar} that subscribes to {@code char} items and publishes
         * {@code int} items
         */
        interface AndInt extends PrimitiveProcessor.OfChar<java.lang.Integer>, PrimitivePublisher.OfInt {}
        /**
         * A {@code PrimitiveProcessor.OfChar} that subscribes to {@code char} items and publishes
         * {@code float} items
         */
        interface AndFloat extends PrimitiveProcessor.OfChar<java.lang.Float>, PrimitivePublisher.OfFloat {}
        /**
         * A {@code PrimitiveProcessor.OfChar} that subscribes to {@code char} items and publishes
         * {@code char} items
         */
        interface AndChar extends PrimitiveProcessor.OfChar<java.lang.Character>, PrimitivePublisher.OfChar {}
        /**
         * A {@code PrimitiveProcessor.OfChar} that subscribes to {@code char} items and publishes
         * {@code short} items
         */
        interface AndShort extends PrimitiveProcessor.OfChar<java.lang.Short>, PrimitivePublisher.OfShort {}
        /**
         * A {@code PrimitiveProcessor.OfChar} that subscribes to {@code char} items and publishes
         * {@code byte} items
         */
        interface AndByte extends PrimitiveProcessor.OfChar<java.lang.Byte>, PrimitivePublisher.OfByte {}
        /**
         * A {@code PrimitiveProcessor.OfChar} that subscribes to {@code char} items and publishes
         * {@code boolean} items
         */
        interface AndBoolean extends PrimitiveProcessor.OfChar<java.lang.Boolean>, PrimitivePublisher.OfBoolean {}
    }
    /**
     * A {@code PrimitiveProcessor} that subscribe to {@code short} values and publishes {@code <AND>} values
     * 
     * @param <AND> the type of value it publishes
     */
    interface OfShort<AND> extends PrimitiveProcessor<java.lang.Short, AND>, PrimitiveSubscriber.OfShort {
        /**
         * A {@code PrimitiveProcessor.OfShort} that subscribes to {@code short} items and publishes
         * {@code double} items
         */
        interface AndDouble extends PrimitiveProcessor.OfShort<java.lang.Double>, PrimitivePublisher.OfDouble {}
        /**
         * A {@code PrimitiveProcessor.OfShort} that subscribes to {@code short} items and publishes
         * {@code long} items
         */
        interface AndLong extends PrimitiveProcessor.OfShort<java.lang.Long>, PrimitivePublisher.OfLong {}
        /**
         * A {@code PrimitiveProcessor.OfShort} that subscribes to {@code short} items and publishes
         * {@code int} items
         */
        interface AndInt extends PrimitiveProcessor.OfShort<java.lang.Integer>, PrimitivePublisher.OfInt {}
        /**
         * A {@code PrimitiveProcessor.OfShort} that subscribes to {@code short} items and publishes
         * {@code float} items
         */
        interface AndFloat extends PrimitiveProcessor.OfShort<java.lang.Float>, PrimitivePublisher.OfFloat {}
        /**
         * A {@code PrimitiveProcessor.OfShort} that subscribes to {@code short} items and publishes
         * {@code char} items
         */
        interface AndChar extends PrimitiveProcessor.OfShort<java.lang.Character>, PrimitivePublisher.OfChar {}
        /**
         * A {@code PrimitiveProcessor.OfShort} that subscribes to {@code short} items and publishes
         * {@code short} items
         */
        interface AndShort extends PrimitiveProcessor.OfShort<java.lang.Short>, PrimitivePublisher.OfShort {}
        /**
         * A {@code PrimitiveProcessor.OfShort} that subscribes to {@code short} items and publishes
         * {@code byte} items
         */
        interface AndByte extends PrimitiveProcessor.OfShort<java.lang.Byte>, PrimitivePublisher.OfByte {}
        /**
         * A {@code PrimitiveProcessor.OfShort} that subscribes to {@code short} items and publishes
         * {@code boolean} items
         */
        interface AndBoolean extends PrimitiveProcessor.OfShort<java.lang.Boolean>, PrimitivePublisher.OfBoolean {}
    }
    /**
     * A {@code PrimitiveProcessor} that subscribe to {@code byte} values and publishes {@code <AND>} values
     * 
     * @param <AND> the type of value it publishes
     */
    interface OfByte<AND> extends PrimitiveProcessor<java.lang.Byte, AND>, PrimitiveSubscriber.OfByte {
        /**
         * A {@code PrimitiveProcessor.OfByte} that subscribes to {@code byte} items and publishes
         * {@code double} items
         */
        interface AndDouble extends PrimitiveProcessor.OfByte<java.lang.Double>, PrimitivePublisher.OfDouble {}
        /**
         * A {@code PrimitiveProcessor.OfByte} that subscribes to {@code byte} items and publishes
         * {@code long} items
         */
        interface AndLong extends PrimitiveProcessor.OfByte<java.lang.Long>, PrimitivePublisher.OfLong {}
        /**
         * A {@code PrimitiveProcessor.OfByte} that subscribes to {@code byte} items and publishes
         * {@code int} items
         */
        interface AndInt extends PrimitiveProcessor.OfByte<java.lang.Integer>, PrimitivePublisher.OfInt {}
        /**
         * A {@code PrimitiveProcessor.OfByte} that subscribes to {@code byte} items and publishes
         * {@code float} items
         */
        interface AndFloat extends PrimitiveProcessor.OfByte<java.lang.Float>, PrimitivePublisher.OfFloat {}
        /**
         * A {@code PrimitiveProcessor.OfByte} that subscribes to {@code byte} items and publishes
         * {@code char} items
         */
        interface AndChar extends PrimitiveProcessor.OfByte<java.lang.Character>, PrimitivePublisher.OfChar {}
        /**
         * A {@code PrimitiveProcessor.OfByte} that subscribes to {@code byte} items and publishes
         * {@code short} items
         */
        interface AndShort extends PrimitiveProcessor.OfByte<java.lang.Short>, PrimitivePublisher.OfShort {}
        /**
         * A {@code PrimitiveProcessor.OfByte} that subscribes to {@code byte} items and publishes
         * {@code byte} items
         */
        interface AndByte extends PrimitiveProcessor.OfByte<java.lang.Byte>, PrimitivePublisher.OfByte {}
        /**
         * A {@code PrimitiveProcessor.OfByte} that subscribes to {@code byte} items and publishes
         * {@code boolean} items
         */
        interface AndBoolean extends PrimitiveProcessor.OfByte<java.lang.Boolean>, PrimitivePublisher.OfBoolean {}
    }
    /**
     * A {@code PrimitiveProcessor} that subscribe to {@code boolean} values and publishes {@code <AND>} values
     * 
     * @param <AND> the type of value it publishes
     */
    interface OfBoolean<AND> extends PrimitiveProcessor<java.lang.Boolean, AND>, PrimitiveSubscriber.OfBoolean {
        /**
         * A {@code PrimitiveProcessor.OfBoolean} that subscribes to {@code boolean} items and publishes
         * {@code double} items
         */
        interface AndDouble extends PrimitiveProcessor.OfBoolean<java.lang.Double>, PrimitivePublisher.OfDouble {}
        /**
         * A {@code PrimitiveProcessor.OfBoolean} that subscribes to {@code boolean} items and publishes
         * {@code long} items
         */
        interface AndLong extends PrimitiveProcessor.OfBoolean<java.lang.Long>, PrimitivePublisher.OfLong {}
        /**
         * A {@code PrimitiveProcessor.OfBoolean} that subscribes to {@code boolean} items and publishes
         * {@code int} items
         */
        interface AndInt extends PrimitiveProcessor.OfBoolean<java.lang.Integer>, PrimitivePublisher.OfInt {}
        /**
         * A {@code PrimitiveProcessor.OfBoolean} that subscribes to {@code boolean} items and publishes
         * {@code float} items
         */
        interface AndFloat extends PrimitiveProcessor.OfBoolean<java.lang.Float>, PrimitivePublisher.OfFloat {}
        /**
         * A {@code PrimitiveProcessor.OfBoolean} that subscribes to {@code boolean} items and publishes
         * {@code char} items
         */
        interface AndChar extends PrimitiveProcessor.OfBoolean<java.lang.Character>, PrimitivePublisher.OfChar {}
        /**
         * A {@code PrimitiveProcessor.OfBoolean} that subscribes to {@code boolean} items and publishes
         * {@code short} items
         */
        interface AndShort extends PrimitiveProcessor.OfBoolean<java.lang.Short>, PrimitivePublisher.OfShort {}
        /**
         * A {@code PrimitiveProcessor.OfBoolean} that subscribes to {@code boolean} items and publishes
         * {@code byte} items
         */
        interface AndByte extends PrimitiveProcessor.OfBoolean<java.lang.Byte>, PrimitivePublisher.OfByte {}
        /**
         * A {@code PrimitiveProcessor.OfBoolean} that subscribes to {@code boolean} items and publishes
         * {@code boolean} items
         */
        interface AndBoolean extends PrimitiveProcessor.OfBoolean<java.lang.Boolean>, PrimitivePublisher.OfBoolean {}
    }
    /**
     * A {@code PrimitiveProcessor} that is a subscriber of type {@code <OF>} and
     * a publisher of {@code double} values.
     * 
     * @param <OF> the type of items that this object recieves via {@link #onNext(Object)}
     */
    interface AndDouble<OF> extends PrimitiveProcessor<OF, java.lang.Double>, PrimitivePublisher.OfDouble {}
    /**
     * A {@code PrimitiveProcessor} that is a subscriber of type {@code <OF>} and
     * a publisher of {@code long} values.
     * 
     * @param <OF> the type of items that this object recieves via {@link #onNext(Object)}
     */
    interface AndLong<OF> extends PrimitiveProcessor<OF, java.lang.Long>, PrimitivePublisher.OfLong {}
    /**
     * A {@code PrimitiveProcessor} that is a subscriber of type {@code <OF>} and
     * a publisher of {@code int} values.
     * 
     * @param <OF> the type of items that this object recieves via {@link #onNext(Object)}
     */
    interface AndInt<OF> extends PrimitiveProcessor<OF, java.lang.Integer>, PrimitivePublisher.OfInt {}
    /**
     * A {@code PrimitiveProcessor} that is a subscriber of type {@code <OF>} and
     * a publisher of {@code float} values.
     * 
     * @param <OF> the type of items that this object recieves via {@link #onNext(Object)}
     */
    interface AndFloat<OF> extends PrimitiveProcessor<OF, java.lang.Float>, PrimitivePublisher.OfFloat {}
    /**
     * A {@code PrimitiveProcessor} that is a subscriber of type {@code <OF>} and
     * a publisher of {@code char} values.
     * 
     * @param <OF> the type of items that this object recieves via {@link #onNext(Object)}
     */
    interface AndChar<OF> extends PrimitiveProcessor<OF, java.lang.Character>, PrimitivePublisher.OfChar {}
    /**
     * A {@code PrimitiveProcessor} that is a subscriber of type {@code <OF>} and
     * a publisher of {@code short} values.
     * 
     * @param <OF> the type of items that this object recieves via {@link #onNext(Object)}
     */
    interface AndShort<OF> extends PrimitiveProcessor<OF, java.lang.Short>, PrimitivePublisher.OfShort {}
    /**
     * A {@code PrimitiveProcessor} that is a subscriber of type {@code <OF>} and
     * a publisher of {@code byte} values.
     * 
     * @param <OF> the type of items that this object recieves via {@link #onNext(Object)}
     */
    interface AndByte<OF> extends PrimitiveProcessor<OF, java.lang.Byte>, PrimitivePublisher.OfByte {}
    /**
     * A {@code PrimitiveProcessor} that is a subscriber of type {@code <OF>} and
     * a publisher of {@code boolean} values.
     * 
     * @param <OF> the type of items that this object recieves via {@link #onNext(Object)}
     */
    interface AndBoolean<OF> extends PrimitiveProcessor<OF, java.lang.Boolean>, PrimitivePublisher.OfBoolean {}
}
