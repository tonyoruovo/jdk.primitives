package jdk.prim;

import jdk.prim.util.function.PrimitiveFunction;

/**
 * Gives you control over how a cast may be done for types extending a single primitive
 * 
 * @param <BOX> the wrapper. This is usually the extended interface
 * @param <P> the primitive wrapper (such as {@code Integer} for {@code int}, {@code Double} for {@code double} etc)
 */
public interface BoxedPrimitive<BOX, P> extends Boxed<BOX> {
    /**
     * Creates and returns a wrapper version of this primitive or the object that defines the generic that is the wrapper for this primitive.
     * <p>
     * This is analogous to {@link java.util.stream.DoubleStream#boxed() DoubleStream.boxed()}
     * @return the wrapper for this primitive or the object that defines the generic that is the wrapper for this primitive.
     * 
     * @see java.util.stream.DoubleStream#boxed
     * @see java.util.stream.LongStream#boxed
     * @see java.util.stream.IntStream#boxed
     */
    BOX boxed();
    /**
     * Casts this object to a {@code double} compatible one within the context of this type. This is analogous
     * to {@link java.util.stream.LongStream#asDoubleStream() LongStream.asDoubleStream()}
     * @return a {@link double} contextualised object
     * @see java.util.stream.LongStream#asDoubleStream
     * @see java.util.stream.IntStream#asDoubleStream
     * @see java.util.stream.IntStream#asLongStream
     */
    BoxedPrimitive<?, java.lang.Double> toDouble();
    /**
     * Maps this context to a {@code double} context. This is analogous to {@link java.util.stream.LongStream#mapToDouble(java.util.function.LongToDoubleFunction) LongStream.mapToDouble(LongToDoubleFunction)}
     * @param <M> the mapper to be used. This is usually a member of {@link jdk.prim.util.function.PrimitiveFunction} that
     * accepts a given primitive {@code T}, which is the same being used in this current context, and returns a {@code double}.
     * An example of this would be an iterator of {@code short} values converted to an iterator of {@code double}
     * values using the mapper: {@link jdk.prim.util.function.PrimitiveFunction.ToDouble.OfShort}. This will be used to map return values
     * @param <RM> the converse of {@code <M>} that is used to convert the {@code double} back to the primitive {@code <P>}. This will be used to map arguments
     * @param mapper a function that returns a {@code double} and accepts the primitive of the wrapper {@code <T>}
     * @return a completely different object in a {@code double} context
     * @see java.util.stream.DoubleStream#mapToInt
     * @see java.util.stream.DoubleStream#mapToLong
     * @see java.util.stream.LongStream#mapToDouble
     * @see java.util.stream.LongStream#mapToInt
     * @see java.util.stream.IntStream#mapToDouble
     * @see java.util.stream.IntStream#mapToLong
     */
    <M extends PrimitiveFunction.ToDouble<? super P>, RM extends PrimitiveFunction<? extends P, ? super java.lang.Double>> BoxedPrimitive<?, java.lang.Double> mapToDouble(M mapper, RM reverseMapper);
    /**
     * Casts this object to a {@code long} compatible one within the context of this type. This is analogous
     * to {@link java.util.stream.LongStream#asDoubleStream() LongStream.asDoubleStream()}
     * @return a {@link long} contextualised object
     * @see java.util.stream.LongStream#asDoubleStream
     * @see java.util.stream.IntStream#asDoubleStream
     * @see java.util.stream.IntStream#asLongStream
     */
    BoxedPrimitive<?, java.lang.Long> toLong();
    /**
     * Maps this context to a {@code long} context. This is analogous to {@link java.util.stream.LongStream#mapToDouble(java.util.function.LongToDoubleFunction) LongStream.mapToDouble(LongToDoubleFunction)}
     * @param <M> the mapper to be used. This is usually a member of {@link jdk.prim.util.function.PrimitiveFunction} that
     * accepts a given primitive {@code T}, which is the same being used in this current context, and returns a {@code long}.
     * An example of this would be an iterator of {@code short} values converted to an iterator of {@code long}
     * values using the mapper: {@link jdk.prim.util.function.PrimitiveFunction.ToLong.OfShort}. This will be used to map return values
     * @param <RM> the converse of {@code <M>} that is used to convert the {@code long} back to the primitive {@code <P>}. This will be used to map arguments
     * @param mapper a function that returns a {@code long} and accepts the primitive of the wrapper {@code <T>}
     * @return a completely different object in a {@code long} context
     * @see java.util.stream.DoubleStream#mapToInt
     * @see java.util.stream.DoubleStream#mapToLong
     * @see java.util.stream.LongStream#mapToDouble
     * @see java.util.stream.LongStream#mapToInt
     * @see java.util.stream.IntStream#mapToDouble
     * @see java.util.stream.IntStream#mapToLong
     */
    <M extends PrimitiveFunction.ToLong<? super P>, RM extends PrimitiveFunction<? extends P, ? super java.lang.Long>> BoxedPrimitive<?, java.lang.Long> mapToLong(M mapper, RM reverseMapper);
    /**
     * Casts this object to an {@code int} compatible one within the context of this type. This is analogous
     * to {@link java.util.stream.LongStream#asDoubleStream() LongStream.asDoubleStream()}
     * @return an {@link int} contextualised object
     * @see java.util.stream.LongStream#asDoubleStream
     * @see java.util.stream.IntStream#asDoubleStream
     * @see java.util.stream.IntStream#asLongStream
     */
    BoxedPrimitive<?, java.lang.Integer> toInt();
    /**
     * Maps this context to a {@code int} context. This is analogous to {@link java.util.stream.LongStream#mapToDouble(java.util.function.LongToDoubleFunction) LongStream.mapToDouble(LongToDoubleFunction)}
     * @param <M> the mapper to be used. This is usually a member of {@link jdk.prim.util.function.PrimitiveFunction} that
     * accepts a given primitive {@code T}, which is the same being used in this current context, and returns an {@code int}.
     * An example of this would be an iterator of {@code short} values converted to an iterator of {@code int}
     * values using the mapper: {@link jdk.prim.util.function.PrimitiveFunction.ToInt.OfShort}. This will be used to map return values
     * @param <RM> the converse of {@code <M>} that is used to convert the {@code int} back to the primitive {@code <P>}. This will be used to map arguments
     * @param mapper a function that returns an {@code int} and accepts the primitive of the wrapper {@code <T>}
     * @return a completely different object in an {@code int} context
     * @see java.util.stream.DoubleStream#mapToInt
     * @see java.util.stream.DoubleStream#mapToLong
     * @see java.util.stream.LongStream#mapToDouble
     * @see java.util.stream.LongStream#mapToInt
     * @see java.util.stream.IntStream#mapToDouble
     * @see java.util.stream.IntStream#mapToLong
     */
    <M extends PrimitiveFunction.ToInt<? super P>, RM extends PrimitiveFunction<? extends P, ? super java.lang.Integer>> BoxedPrimitive<?, java.lang.Integer> mapToInt(M mapper, RM reverseMapper);
    /**
     * Casts this object to a {@code float} compatible one within the context of this type. This is analogous
     * to {@link java.util.stream.LongStream#asDoubleStream() LongStream.asDoubleStream()}
     * @return a {@link float} contextualised object
     * @see java.util.stream.LongStream#asDoubleStream
     * @see java.util.stream.IntStream#asDoubleStream
     * @see java.util.stream.IntStream#asLongStream
     */
    BoxedPrimitive<?, java.lang.Float> toFloat();
    /**
     * Maps this context to a {@code float} context. This is analogous to {@link java.util.stream.LongStream#mapToDouble(java.util.function.LongToDoubleFunction) LongStream.mapToDouble(LongToDoubleFunction)}
     * @param <M> the mapper to be used. This is usually a member of {@link jdk.prim.util.function.PrimitiveFunction} that
     * accepts a given primitive {@code T}, which is the same being used in this current context, and returns a {@code float}.
     * An example of this would be an iterator of {@code short} values converted to an iterator of {@code float}
     * values using the mapper: {@link jdk.prim.util.function.PrimitiveFunction.ToFloat.OfShort}. This will be used to map return values
     * @param <RM> the converse of {@code <M>} that is used to convert the {@code float} back to the primitive {@code <P>}. This will be used to map arguments
     * @param mapper a function that returns a {@code float} and accepts the primitive of the wrapper {@code <T>}
     * @return a completely different object in a {@code float} context
     * @see java.util.stream.DoubleStream#mapToInt
     * @see java.util.stream.DoubleStream#mapToLong
     * @see java.util.stream.LongStream#mapToDouble
     * @see java.util.stream.LongStream#mapToInt
     * @see java.util.stream.IntStream#mapToDouble
     * @see java.util.stream.IntStream#mapToLong
     */
    <M extends PrimitiveFunction.ToFloat<? super P>, RM extends PrimitiveFunction<? extends P, ? super java.lang.Float>> BoxedPrimitive<?, java.lang.Float> mapToFloat(M mapper, RM reverseMapper);
    /**
     * Casts this object to a {@code char} compatible one within the context of this type. This is analogous
     * to {@link java.util.stream.LongStream#asDoubleStream() LongStream.asDoubleStream()}
     * @return a {@link char} contextualised object
     * @see java.util.stream.LongStream#asDoubleStream
     * @see java.util.stream.IntStream#asDoubleStream
     * @see java.util.stream.IntStream#asLongStream
     */
    BoxedPrimitive<?, java.lang.Character> toChar();
    /**
     * Maps this context to a {@code char} context. This is analogous to {@link java.util.stream.LongStream#mapToDouble(java.util.function.LongToDoubleFunction) LongStream.mapToDouble(LongToDoubleFunction)}
     * @param <M> the mapper to be used. This is usually a member of {@link jdk.prim.util.function.PrimitiveFunction} that
     * accepts a given primitive {@code T}, which is the same being used in this current context, and returns a {@code char}.
     * An example of this would be an iterator of {@code short} values converted to an iterator of {@code char}
     * values using the mapper: {@link jdk.prim.util.function.PrimitiveFunction.ToChar.OfShort}. This will be used to map return values
     * @param <RM> the converse of {@code <M>} that is used to convert the {@code char} back to the primitive {@code <P>}. This will be used to map arguments
     * @param mapper a function that returns a {@code char} and accepts the primitive of the wrapper {@code <T>}
     * @return a completely different object in a {@code char} context
     * @see java.util.stream.DoubleStream#mapToInt
     * @see java.util.stream.DoubleStream#mapToLong
     * @see java.util.stream.LongStream#mapToDouble
     * @see java.util.stream.LongStream#mapToInt
     * @see java.util.stream.IntStream#mapToDouble
     * @see java.util.stream.IntStream#mapToLong
     */
    <M extends PrimitiveFunction.ToChar<? super P>, RM extends PrimitiveFunction<? extends P, ? super java.lang.Character>> BoxedPrimitive<?, java.lang.Character> mapToChar(M mapper, RM reverseMapper);
    /**
     * Casts this object to a {@code short} compatible one within the context of this type. This is analogous
     * to {@link java.util.stream.LongStream#asDoubleStream() LongStream.asDoubleStream()}
     * @return a {@link short} contextualised object
     * @see java.util.stream.LongStream#asDoubleStream
     * @see java.util.stream.IntStream#asDoubleStream
     * @see java.util.stream.IntStream#asLongStream
     */
    BoxedPrimitive<?, java.lang.Short> toShort();
    /**
     * Maps this context to a {@code short} context. This is analogous to {@link java.util.stream.LongStream#mapToDouble(java.util.function.LongToDoubleFunction) LongStream.mapToDouble(LongToDoubleFunction)}
     * @param <M> the mapper to be used. This is usually a member of {@link jdk.prim.util.function.PrimitiveFunction} that
     * accepts a given primitive {@code T}, which is the same being used in this current context, and returns a {@code short}.
     * An example of this would be an iterator of {@code short} values converted to an iterator of {@code short}
     * values using the mapper: {@link jdk.prim.util.function.PrimitiveFunction.ToShort.OfShort}. This will be used to map return values
     * @param <RM> the converse of {@code <M>} that is used to convert the {@code short} back to the primitive {@code <P>}. This will be used to map arguments
     * @param mapper a function that returns a {@code short} and accepts the primitive of the wrapper {@code <T>}
     * @return a completely different object in a {@code short} context
     * @see java.util.stream.DoubleStream#mapToInt
     * @see java.util.stream.DoubleStream#mapToLong
     * @see java.util.stream.LongStream#mapToDouble
     * @see java.util.stream.LongStream#mapToInt
     * @see java.util.stream.IntStream#mapToDouble
     * @see java.util.stream.IntStream#mapToLong
     */
    <M extends PrimitiveFunction.ToShort<? super P>, RM extends PrimitiveFunction<? extends P, ? super java.lang.Short>> BoxedPrimitive<?, java.lang.Short> mapToShort(M mapper, RM reverseMapper);
    /**
     * Casts this object to a {@code byte} compatible one within the context of this type. This is analogous
     * to {@link java.util.stream.LongStream#asDoubleStream() LongStream.asDoubleStream()}
     * @return a {@link byte} contextualised object
     * @see java.util.stream.LongStream#asDoubleStream
     * @see java.util.stream.IntStream#asDoubleStream
     * @see java.util.stream.IntStream#asLongStream
     */
    BoxedPrimitive<?, java.lang.Byte> toByte();
    /**
     * Maps this context to a {@code byte} context. This is analogous to {@link java.util.stream.LongStream#mapToDouble(java.util.function.LongToDoubleFunction) LongStream.mapToDouble(LongToDoubleFunction)}
     * @param <M> the mapper to be used. This is usually a member of {@link jdk.prim.util.function.PrimitiveFunction} that
     * accepts a given primitive {@code T}, which is the same being used in this current context, and returns a {@code byte}.
     * An example of this would be an iterator of {@code short} values converted to an iterator of {@code byte}
     * values using the mapper: {@link jdk.prim.util.function.PrimitiveFunction.ToByte.OfShort}. This will be used to map return values
     * @param <RM> the converse of {@code <M>} that is used to convert the {@code byte} back to the primitive {@code <P>}. This will be used to map arguments
     * @param mapper a function that returns a {@code byte} and accepts the primitive of the wrapper {@code <T>}
     * @return a completely different object in a {@code byte} context
     * @see java.util.stream.DoubleStream#mapToInt
     * @see java.util.stream.DoubleStream#mapToLong
     * @see java.util.stream.LongStream#mapToDouble
     * @see java.util.stream.LongStream#mapToInt
     * @see java.util.stream.IntStream#mapToDouble
     * @see java.util.stream.IntStream#mapToLong
     */
    <M extends PrimitiveFunction.ToByte<? super P>, RM extends PrimitiveFunction<? extends P, ? super java.lang.Byte>> BoxedPrimitive<?, java.lang.Byte> mapToByte(M mapper, RM reverseMapper);
    /**
     * Casts this object to a {@code boolean} compatible one within the context of this type. This is analogous
     * to {@link java.util.stream.LongStream#asDoubleStream() LongStream.asDoubleStream()}
     * @return a {@link boolean} contextualised object
     * @see java.util.stream.LongStream#asDoubleStream
     * @see java.util.stream.IntStream#asDoubleStream
     * @see java.util.stream.IntStream#asLongStream
     */
    BoxedPrimitive<?, java.lang.Boolean> toBoolean();
    /**
     * Maps this context to a {@code boolean} context. This is analogous to {@link java.util.stream.LongStream#mapToDouble(java.util.function.LongToDoubleFunction) LongStream.mapToDouble(LongToDoubleFunction)}
     * @param <M> the mapper to be used. This is usually a member of {@link jdk.prim.util.function.PrimitiveFunction} that
     * accepts a given primitive {@code T}, which is the same being used in this current context, and returns a {@code boolean}.
     * An example of this would be an iterator of {@code short} values converted to an iterator of {@code boolean}
     * values using the mapper: {@link jdk.prim.util.function.PrimitiveFunction.ToBoolean.OfShort}. This will be used to map return values
     * @param <RM> the converse of {@code <M>} that is used to convert the {@code boolean} back to the primitive {@code <P>}. This will be used to map arguments
     * @param mapper a function that returns a {@code boolean} and accepts the primitive of the wrapper {@code <T>}
     * @return a completely different object in a {@code boolean} context
     * @see java.util.stream.DoubleStream#mapToInt
     * @see java.util.stream.DoubleStream#mapToLong
     * @see java.util.stream.LongStream#mapToDouble
     * @see java.util.stream.LongStream#mapToInt
     * @see java.util.stream.IntStream#mapToDouble
     * @see java.util.stream.IntStream#mapToLong
     */
    <M extends PrimitiveFunction.ToBoolean<? super P>, RM extends PrimitiveFunction<? extends P, ? super java.lang.Boolean>> BoxedPrimitive<?, java.lang.Boolean> mapToBoolean(M mapper, RM reverseMapper);
}
