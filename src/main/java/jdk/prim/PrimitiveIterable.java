/*
 * Date created: 19 May 2024
 * Time created: 01:13:42
 * File: PrimitiveIterable.java
 * Created at: 
 */
/**
 * @author Oruovo Etineakpopha Anthony
 */
package jdk.prim;

import java.util.Iterator;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;

import jdk.prim.util.PrimitiveIterator;
import jdk.prim.util.PrimitiveSpliterator;
import jdk.prim.util.PrimitiveSpliterators;
import jdk.prim.util.function.PrimitiveConsumer;
import jdk.prim.util.function.PrimitiveFunction;

/*
 * Date created: 19 May 2024
 * Time created: 01:13:42
 * File: PrimitiveIterable.java
 * Git: 
 * Package: prim
 * Project: jdk.primitives
 * Type: PrimitiveIterable
 * Created at: 
 * Enclosing Type: 
 */
/**
 * An effort to support primitive collections and streams.
 * 
 * @param <T>      the wrapper type for the primitive type being iterated.
 * @param <T_CONS> the type of the {@link PrimitiveConsumer primitive consumer}
 * @param <T_ITR>  the type of {@link PrimitiveIterator primitive iterator}
 * @param <T_SPTR> the type of {@link PrimitiveSpliterator primitive
 *                 spliterator}
 * 
 * @author Oruovo Etineakpopha Anthony
 */
public interface PrimitiveIterable<T, T_CONS> extends Iterable<T>, BoxedPrimitive<Iterable<T>, T> {

	/**
	 * An {@code Iterable} of {@code double} values
	 */
	@FunctionalInterface
	interface OfDouble extends PrimitiveIterable<Double, PrimitiveConsumer.OfDouble> {

		default Iterable<java.lang.Double> boxed() { return this; }

		/**
		 * Creates and return a new iterable of {@code double} using the provided mapper as a processor to map elements from
		 * {@code double} to {@code double}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToDouble} and accept {@code double} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code double} values into {@code double} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfDouble} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToDouble<? super java.lang.Double>, RM extends PrimitiveFunction<? extends java.lang.Double, ? super java.lang.Double>> PrimitiveIterable.OfDouble mapToDouble(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorDouble().mapToDouble(mapper, rm);
		}
		/**
		 * Creates and return a new iterable of {@code long} using the provided mapper as a processor to map elements from
		 * {@code double} to {@code long}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToLong} and accept {@code double} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code double} values into {@code long} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfLong} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToLong<? super java.lang.Double>, RM extends PrimitiveFunction<? extends java.lang.Double, ? super java.lang.Long>> PrimitiveIterable.OfLong mapToLong(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorDouble().mapToLong(mapper, rm);
		}
		/**
		 * Creates and return a new iterable of {@code int} using the provided mapper as a processor to map elements from
		 * {@code double} to {@code int}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToInt} and accept {@code double} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code double} values into {@code int} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfInt} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToInt<? super java.lang.Double>, RM extends PrimitiveFunction<? extends java.lang.Double, ? super java.lang.Integer>> PrimitiveIterable.OfInt mapToInt(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorDouble().mapToInt(mapper, rm);
		}
		/**
		 * Creates and return a new iterable of {@code float} using the provided mapper as a processor to map elements from
		 * {@code double} to {@code float}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToFloat} and accept {@code double} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code double} values into {@code float} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfFloat} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToFloat<? super java.lang.Double>, RM extends PrimitiveFunction<? extends java.lang.Double, ? super java.lang.Float>> PrimitiveIterable.OfFloat mapToFloat(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorDouble().mapToFloat(mapper, rm);
		}
		/**
		 * Creates and return a new iterable of {@code char} using the provided mapper as a processor to map elements from
		 * {@code double} to {@code char}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToChar} and accept {@code double} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code double} values into {@code char} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfChar} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToChar<? super java.lang.Double>, RM extends PrimitiveFunction<? extends java.lang.Double, ? super java.lang.Character>> PrimitiveIterable.OfChar mapToChar(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorDouble().mapToChar(mapper, rm);
		}
		/**
		 * Creates and return a new iterable of {@code short} using the provided mapper as a processor to map elements from
		 * {@code double} to {@code short}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToShort} and accept {@code double} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code double} values into {@code short} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfShort} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToShort<? super java.lang.Double>, RM extends PrimitiveFunction<? extends java.lang.Double, ? super java.lang.Short>> PrimitiveIterable.OfShort mapToShort(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorDouble().mapToShort(mapper, rm);
		}
		/**
		 * Creates and return a new iterable of {@code byte} using the provided mapper as a processor to map elements from
		 * {@code double} to {@code byte}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToByte} and accept {@code double} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code double} values into {@code byte} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfByte} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToByte<? super java.lang.Double>, RM extends PrimitiveFunction<? extends java.lang.Double, ? super java.lang.Byte>> PrimitiveIterable.OfByte mapToByte(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorDouble().mapToByte(mapper, rm);
		}
		/**
		 * Creates and return a new iterable of {@code boolean} using the provided mapper as a processor to map elements from
		 * {@code double} to {@code boolean}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToBoolean} and accept {@code double} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code double} values into {@code boolean} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfBoolean} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToBoolean<? super java.lang.Double>, RM extends PrimitiveFunction<? extends java.lang.Double, ? super java.lang.Boolean>> PrimitiveIterable.OfBoolean mapToBoolean(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorDouble().mapToBoolean(mapper, rm);
		}

		/**
		 * The {@code double} specialisation of {@link #iterator}
		 * 
		 * @return a specialised iterator of {@code double} values
		 */
		PrimitiveIterator.OfDouble iteratorDouble();

		@Override
		default Iterator<java.lang.Double> iterator() {
			return iteratorDouble();
		}

		/**
		 * The {@code double} specialisation of {@link #spliterator}
		 * 
		 * @return a specialised spliterator of {@code double} values
		 */
		default PrimitiveSpliterator.OfDouble spliteratorDouble() {
			return PrimitiveSpliterators.spliteratorUnknownSize(iteratorDouble(), 0);
		}

		@Override
		default Spliterator<java.lang.Double> spliterator() {
			return spliteratorDouble();
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfDouble} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code double}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfDouble} whereby the iterator and
		 *         spliterator contained within will be one {@code double} elements.
		 */
		default OfDouble toDouble() {
			return this;
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfLong} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code long}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfLong} whereby the iterator and
		 *         spliterator contained within will be one {@code long} elements.
		 */
		default OfLong toLong() {
			return () -> iteratorDouble().toLong();
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfInt} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code int}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfInt} whereby the iterator and
		 *         spliterator contained within will be one {@code int} elements.
		 */
		default OfInt toInt() {
			return () -> iteratorDouble().toInt();
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfFloat} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code float}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfFloat} whereby the iterator and
		 *         spliterator contained within will be one {@code float} elements.
		 */
		default OfFloat toFloat() {
			return () -> iteratorDouble().toFloat();
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfChar} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code char}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfChar} whereby the iterator and
		 *         spliterator contained within will be one {@code char} elements.
		 */
		default OfChar toChar() {
			return () -> iteratorDouble().toChar();
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfShort} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code short}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfShort} whereby the iterator and
		 *         spliterator contained within will be one {@code short} elements.
		 */
		default OfShort toShort() {
			return () -> iteratorDouble().toShort();
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfByte} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code byte}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfByte} whereby the iterator and
		 *         spliterator contained within will be one {@code byte} elements.
		 */
		default OfByte toByte() {
			return () -> iteratorDouble().toByte();
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfBoolean} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code boolean}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfBoolean} whereby the iterator and
		 *         spliterator contained within will be one {@code boolean} elements.
		 */
		default OfBoolean toBoolean() {
			return () -> iteratorDouble().toBoolean();
		}

		@Override
		default void forEach(PrimitiveConsumer.OfDouble action) {
			Objects.requireNonNull(action);
			PrimitiveIterator.OfDouble i = iteratorDouble();
			while (i.hasNext()) {
				action.acceptDouble(i.nextDouble());
			}
		}

		@Override
		default void forEach(Consumer<? super Double> action) {
			if (action instanceof PrimitiveConsumer.OfDouble) {
				forEach((PrimitiveConsumer.OfDouble) action);
				return;
			}
			Objects.requireNonNull(action);
			forEach((PrimitiveConsumer.OfDouble) action::accept);
		}
	}

	/**
	 * An {@code Iterable} of {@code long} values
	 */
	@FunctionalInterface
	interface OfLong extends PrimitiveIterable<Long, PrimitiveConsumer.OfLong> {

		default Iterable<java.lang.Long> boxed() { return this; }

		/**
		 * Creates and return a new iterable of {@code double} using the provided mapper as a processor to map elements from
		 * {@code long} to {@code double}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToDouble} and accept {@code long} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code long} values into {@code double} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfDouble} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToDouble<? super java.lang.Long>, RM extends PrimitiveFunction<? extends java.lang.Long, ? super java.lang.Double>> PrimitiveIterable.OfDouble mapToDouble(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorLong().mapToDouble(mapper, rm);
		}
		/**
		 * Creates and return a new iterable of {@code long} using the provided mapper as a processor to map elements from
		 * {@code long} to {@code long}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToLong} and accept {@code long} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code long} values into {@code long} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfLong} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToLong<? super java.lang.Long>, RM extends PrimitiveFunction<? extends java.lang.Long, ? super java.lang.Long>> PrimitiveIterable.OfLong mapToLong(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorLong().mapToLong(mapper, rm);
		}
		/**
		 * Creates and return a new iterable of {@code int} using the provided mapper as a processor to map elements from
		 * {@code long} to {@code int}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToInt} and accept {@code long} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code long} values into {@code int} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfInt} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToInt<? super java.lang.Long>, RM extends PrimitiveFunction<? extends java.lang.Long, ? super java.lang.Integer>> PrimitiveIterable.OfInt mapToInt(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorLong().mapToInt(mapper, rm);
		}
		/**
		 * Creates and return a new iterable of {@code float} using the provided mapper as a processor to map elements from
		 * {@code long} to {@code float}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToFloat} and accept {@code long} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code long} values into {@code float} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfFloat} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToFloat<? super java.lang.Long>, RM extends PrimitiveFunction<? extends java.lang.Long, ? super java.lang.Float>> PrimitiveIterable.OfFloat mapToFloat(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorLong().mapToFloat(mapper, rm);
		}
		/**
		 * Creates and return a new iterable of {@code char} using the provided mapper as a processor to map elements from
		 * {@code long} to {@code char}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToChar} and accept {@code long} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code long} values into {@code char} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfChar} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToChar<? super java.lang.Long>, RM extends PrimitiveFunction<? extends java.lang.Long, ? super java.lang.Character>> PrimitiveIterable.OfChar mapToChar(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorLong().mapToChar(mapper, rm);
		}
		/**
		 * Creates and return a new iterable of {@code short} using the provided mapper as a processor to map elements from
		 * {@code long} to {@code short}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToShort} and accept {@code long} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code long} values into {@code short} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfShort} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToShort<? super java.lang.Long>, RM extends PrimitiveFunction<? extends java.lang.Long, ? super java.lang.Short>> PrimitiveIterable.OfShort mapToShort(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorLong().mapToShort(mapper, rm);
		}
		/**
		 * Creates and return a new iterable of {@code byte} using the provided mapper as a processor to map elements from
		 * {@code long} to {@code byte}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToByte} and accept {@code long} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code long} values into {@code byte} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfByte} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToByte<? super java.lang.Long>, RM extends PrimitiveFunction<? extends java.lang.Long, ? super java.lang.Byte>> PrimitiveIterable.OfByte mapToByte(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorLong().mapToByte(mapper, rm);
		}
		/**
		 * Creates and return a new iterable of {@code boolean} using the provided mapper as a processor to map elements from
		 * {@code long} to {@code boolean}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToBoolean} and accept {@code long} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code long} values into {@code boolean} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfBoolean} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToBoolean<? super java.lang.Long>, RM extends PrimitiveFunction<? extends java.lang.Long, ? super java.lang.Boolean>> PrimitiveIterable.OfBoolean mapToBoolean(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorLong().mapToBoolean(mapper, rm);
		}

		/**
		 * The {@code long} specialisation of {@link #iterator}
		 * 
		 * @return a specialised iterator of {@code long} values
		 */
		PrimitiveIterator.OfLong iteratorLong();

		@Override
		default Iterator<java.lang.Long> iterator() {
			return iteratorLong();
		}

		/**
		 * The {@code long} specialisation of {@link #spliterator}
		 * 
		 * @return a specialised spliterator of {@code long} values
		 */
		default PrimitiveSpliterator.OfLong spliteratorLong() {
			return PrimitiveSpliterators.spliteratorUnknownSize(iteratorLong(), 0);
		}

		@Override
		default Spliterator<java.lang.Long> spliterator() {
			return spliteratorLong();
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfDouble} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code double}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfDouble} whereby the iterator and
		 *         spliterator contained within will be one {@code double} elements.
		 */
		default OfDouble toDouble() {
			return () -> iteratorLong().toDouble();
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfLong} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code long}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfLong} whereby the iterator and
		 *         spliterator contained within will be one {@code long} elements.
		 */
		default OfLong toLong() {
			return this;
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfInt} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code int}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfInt} whereby the iterator and
		 *         spliterator contained within will be one {@code int} elements.
		 */
		default OfInt toInt() {
			return () -> iteratorLong().toInt();
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfFloat} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code float}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfFloat} whereby the iterator and
		 *         spliterator contained within will be one {@code float} elements.
		 */
		default OfFloat toFloat() {
			return () -> iteratorLong().toFloat();
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfChar} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code char}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfChar} whereby the iterator and
		 *         spliterator contained within will be one {@code char} elements.
		 */
		default OfChar toChar() {
			return () -> iteratorLong().toChar();
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfShort} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code short}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfShort} whereby the iterator and
		 *         spliterator contained within will be one {@code short} elements.
		 */
		default OfShort toShort() {
			return () -> iteratorLong().toShort();
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfByte} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code byte}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfByte} whereby the iterator and
		 *         spliterator contained within will be one {@code byte} elements.
		 */
		default OfByte toByte() {
			return () -> iteratorLong().toByte();
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfBoolean} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code boolean}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfBoolean} whereby the iterator and
		 *         spliterator contained within will be one {@code boolean} elements.
		 */
		default OfBoolean toBoolean() {
			return () -> iteratorLong().toBoolean();
		}

		@Override
		default void forEach(PrimitiveConsumer.OfLong action) {
			Objects.requireNonNull(action);
			PrimitiveIterator.OfLong i = iteratorLong();
			while (i.hasNext()) {
				action.acceptLong(i.nextLong());
			}
		}

		@Override
		default void forEach(Consumer<? super Long> action) {
			if (action instanceof PrimitiveConsumer.OfLong) {
				forEach((PrimitiveConsumer.OfLong) action);
				return;
			}
			Objects.requireNonNull(action);
			forEach((PrimitiveConsumer.OfLong) action::accept);
		}
	}

	/**
	 * An {@code Iterable} of {@code int} values
	 */
	@FunctionalInterface
	interface OfInt extends PrimitiveIterable<Integer, PrimitiveConsumer.OfInt> {

		default Iterable<java.lang.Integer> boxed() { return this; }

		/**
		 * Creates and return a new iterable of {@code double} using the provided mapper as a processor to map elements from
		 * {@code int} to {@code double}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToDouble} and accept {@code int} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code int} values into {@code double} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfDouble} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToDouble<? super java.lang.Integer>, RM extends PrimitiveFunction<? extends java.lang.Integer, ? super java.lang.Double>> PrimitiveIterable.OfDouble mapToDouble(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorInt().mapToDouble(mapper, rm);
		}
		/**
		 * Creates and return a new iterable of {@code long} using the provided mapper as a processor to map elements from
		 * {@code int} to {@code long}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToLong} and accept {@code int} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code int} values into {@code long} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfLong} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToLong<? super java.lang.Integer>, RM extends PrimitiveFunction<? extends java.lang.Integer, ? super java.lang.Long>> PrimitiveIterable.OfLong mapToLong(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorInt().mapToLong(mapper, rm);
		}
		/**
		 * Creates and return a new iterable of {@code int} using the provided mapper as a processor to map elements from
		 * {@code int} to {@code int}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToInt} and accept {@code int} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code int} values into {@code int} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfInt} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToInt<? super java.lang.Integer>, RM extends PrimitiveFunction<? extends java.lang.Integer, ? super java.lang.Integer>> PrimitiveIterable.OfInt mapToInt(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorInt().mapToInt(mapper, rm);
		}
		/**
		 * Creates and return a new iterable of {@code float} using the provided mapper as a processor to map elements from
		 * {@code int} to {@code float}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToFloat} and accept {@code int} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code int} values into {@code float} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfFloat} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToFloat<? super java.lang.Integer>, RM extends PrimitiveFunction<? extends java.lang.Integer, ? super java.lang.Float>> PrimitiveIterable.OfFloat mapToFloat(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorInt().mapToFloat(mapper, rm);
		}
		/**
		 * Creates and return a new iterable of {@code char} using the provided mapper as a processor to map elements from
		 * {@code int} to {@code char}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToChar} and accept {@code int} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code int} values into {@code char} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfChar} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToChar<? super java.lang.Integer>, RM extends PrimitiveFunction<? extends java.lang.Integer, ? super java.lang.Character>> PrimitiveIterable.OfChar mapToChar(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorInt().mapToChar(mapper, rm);
		}
		/**
		 * Creates and return a new iterable of {@code short} using the provided mapper as a processor to map elements from
		 * {@code int} to {@code short}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToShort} and accept {@code int} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code int} values into {@code short} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfShort} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToShort<? super java.lang.Integer>, RM extends PrimitiveFunction<? extends java.lang.Integer, ? super java.lang.Short>> PrimitiveIterable.OfShort mapToShort(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorInt().mapToShort(mapper, rm);
		}
		/**
		 * Creates and return a new iterable of {@code byte} using the provided mapper as a processor to map elements from
		 * {@code int} to {@code byte}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToByte} and accept {@code int} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code int} values into {@code byte} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfByte} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToByte<? super java.lang.Integer>, RM extends PrimitiveFunction<? extends java.lang.Integer, ? super java.lang.Byte>> PrimitiveIterable.OfByte mapToByte(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorInt().mapToByte(mapper, rm);
		}
		/**
		 * Creates and return a new iterable of {@code boolean} using the provided mapper as a processor to map elements from
		 * {@code int} to {@code boolean}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToBoolean} and accept {@code int} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code int} values into {@code boolean} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfBoolean} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToBoolean<? super java.lang.Integer>, RM extends PrimitiveFunction<? extends java.lang.Integer, ? super java.lang.Boolean>> PrimitiveIterable.OfBoolean mapToBoolean(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorInt().mapToBoolean(mapper, rm);
		}

		/**
		 * The {@code int} specialisation of {@link #iterator}
		 * 
		 * @return a specialised iterator of {@code int} values
		 */
		PrimitiveIterator.OfInt iteratorInt();

		@Override
		default Iterator<java.lang.Integer> iterator() {
			return iteratorInt();
		}

		/**
		 * The {@code int} specialisation of {@link #spliterator}
		 * 
		 * @return a specialised spliterator of {@code int} values
		 */
		default PrimitiveSpliterator.OfInt spliteratorInt() {
			return PrimitiveSpliterators.spliteratorUnknownSize(iteratorInt(), 0);
		}

		@Override
		default Spliterator<java.lang.Integer> spliterator() {
			return spliteratorInt();
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfDouble} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code double}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfDouble} whereby the iterator and
		 *         spliterator contained within will be one {@code double} elements.
		 */
		default OfDouble toDouble() {
			return () -> iteratorInt().toDouble();
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfLong} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code long}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfLong} whereby the iterator and
		 *         spliterator contained within will be one {@code long} elements.
		 */
		default OfLong toLong() {
			return () -> iteratorInt().toLong();
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfInt} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code int}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfInt} whereby the iterator and
		 *         spliterator contained within will be one {@code int} elements.
		 */
		default OfInt toInt() {
			return this;
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfFloat} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code float}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfFloat} whereby the iterator and
		 *         spliterator contained within will be one {@code float} elements.
		 */
		default OfFloat toFloat() {
			return () -> iteratorInt().toFloat();
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfChar} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code char}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfChar} whereby the iterator and
		 *         spliterator contained within will be one {@code char} elements.
		 */
		default OfChar toChar() {
			return () -> iteratorInt().toChar();
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfShort} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code short}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfShort} whereby the iterator and
		 *         spliterator contained within will be one {@code short} elements.
		 */
		default OfShort toShort() {
			return () -> iteratorInt().toShort();
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfByte} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code byte}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfByte} whereby the iterator and
		 *         spliterator contained within will be one {@code byte} elements.
		 */
		default OfByte toByte() {
			return () -> iteratorInt().toByte();
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfBoolean} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code boolean}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfBoolean} whereby the iterator and
		 *         spliterator contained within will be one {@code boolean} elements.
		 */
		default OfBoolean toBoolean() {
			return () -> iteratorInt().toBoolean();
		}

		@Override
		default void forEach(PrimitiveConsumer.OfInt action) {
			Objects.requireNonNull(action);
			PrimitiveIterator.OfInt i = iteratorInt();
			while (i.hasNext()) {
				action.acceptInt(i.nextInt());
			}
		}

		@Override
		default void forEach(Consumer<? super Integer> action) {
			if (action instanceof PrimitiveConsumer.OfInt) {
				forEach((PrimitiveConsumer.OfInt) action);
				return;
			}
			Objects.requireNonNull(action);
			forEach((PrimitiveConsumer.OfInt) action::accept);
		}
	}

	/**
	 * An {@code Iterable} of {@code float} values
	 */
	@FunctionalInterface
	interface OfFloat extends PrimitiveIterable<Float, PrimitiveConsumer.OfFloat> {

		default Iterable<java.lang.Float> boxed() { return this; }

		/**
		 * Creates and return a new iterable of {@code double} using the provided mapper as a processor to map elements from
		 * {@code float} to {@code double}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToDouble} and accept {@code float} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code float} values into {@code double} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfDouble} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToDouble<? super java.lang.Float>, RM extends PrimitiveFunction<? extends java.lang.Float, ? super java.lang.Double>> PrimitiveIterable.OfDouble mapToDouble(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorFloat().mapToDouble(mapper, rm);
		}
		/**
		 * Creates and return a new iterable of {@code long} using the provided mapper as a processor to map elements from
		 * {@code float} to {@code long}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToLong} and accept {@code float} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code float} values into {@code long} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfLong} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToLong<? super java.lang.Float>, RM extends PrimitiveFunction<? extends java.lang.Float, ? super java.lang.Long>> PrimitiveIterable.OfLong mapToLong(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorFloat().mapToLong(mapper, rm);
		}
		/**
		 * Creates and return a new iterable of {@code int} using the provided mapper as a processor to map elements from
		 * {@code float} to {@code int}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToInt} and accept {@code float} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code float} values into {@code int} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfInt} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToInt<? super java.lang.Float>, RM extends PrimitiveFunction<? extends java.lang.Float, ? super java.lang.Integer>> PrimitiveIterable.OfInt mapToInt(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorFloat().mapToInt(mapper, rm);
		}
		/**
		 * Creates and return a new iterable of {@code float} using the provided mapper as a processor to map elements from
		 * {@code float} to {@code float}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToFloat} and accept {@code float} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code float} values into {@code float} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfFloat} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToFloat<? super java.lang.Float>, RM extends PrimitiveFunction<? extends java.lang.Float, ? super java.lang.Float>> PrimitiveIterable.OfFloat mapToFloat(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorFloat().mapToFloat(mapper, rm);
		}
		/**
		 * Creates and return a new iterable of {@code char} using the provided mapper as a processor to map elements from
		 * {@code float} to {@code char}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToChar} and accept {@code float} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code float} values into {@code char} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfChar} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToChar<? super java.lang.Float>, RM extends PrimitiveFunction<? extends java.lang.Float, ? super java.lang.Character>> PrimitiveIterable.OfChar mapToChar(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorFloat().mapToChar(mapper, rm);
		}
		/**
		 * Creates and return a new iterable of {@code short} using the provided mapper as a processor to map elements from
		 * {@code float} to {@code short}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToShort} and accept {@code float} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code float} values into {@code short} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfShort} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToShort<? super java.lang.Float>, RM extends PrimitiveFunction<? extends java.lang.Float, ? super java.lang.Short>> PrimitiveIterable.OfShort mapToShort(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorFloat().mapToShort(mapper, rm);
		}
		/**
		 * Creates and return a new iterable of {@code byte} using the provided mapper as a processor to map elements from
		 * {@code float} to {@code byte}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToByte} and accept {@code float} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code float} values into {@code byte} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfByte} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToByte<? super java.lang.Float>, RM extends PrimitiveFunction<? extends java.lang.Float, ? super java.lang.Byte>> PrimitiveIterable.OfByte mapToByte(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorFloat().mapToByte(mapper, rm);
		}
		/**
		 * Creates and return a new iterable of {@code boolean} using the provided mapper as a processor to map elements from
		 * {@code float} to {@code boolean}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToBoolean} and accept {@code float} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code float} values into {@code boolean} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfBoolean} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToBoolean<? super java.lang.Float>, RM extends PrimitiveFunction<? extends java.lang.Float, ? super java.lang.Boolean>> PrimitiveIterable.OfBoolean mapToBoolean(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorFloat().mapToBoolean(mapper, rm);
		}

		/**
		 * The {@code float} specialisation of {@link #iterator}
		 * 
		 * @return a specialised iterator of {@code float} values
		 */
		PrimitiveIterator.OfFloat iteratorFloat();

		@Override
		default Iterator<java.lang.Float> iterator() {
			return iteratorFloat();
		}

		/**
		 * The {@code float} specialisation of {@link #spliterator}
		 * 
		 * @return a specialised spliterator of {@code float} values
		 */
		default PrimitiveSpliterator.OfFloat spliteratorFloat() {
			return PrimitiveSpliterators.spliteratorUnknownSize(iteratorFloat(), 0);
		}

		@Override
		default Spliterator<java.lang.Float> spliterator() {
			return spliteratorFloat();
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfDouble} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code double}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfDouble} whereby the iterator and
		 *         spliterator contained within will be one {@code double} elements.
		 */
		default OfDouble toDouble() {
			return () -> iteratorFloat().toDouble();
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfLong} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code long}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfLong} whereby the iterator and
		 *         spliterator contained within will be one {@code long} elements.
		 */
		default OfLong toLong() {
			return () -> iteratorFloat().toLong();
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfInt} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code int}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfInt} whereby the iterator and
		 *         spliterator contained within will be one {@code int} elements.
		 */
		default OfInt toInt() {
			return () -> iteratorFloat().toInt();
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfFloat} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code float}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfFloat} whereby the iterator and
		 *         spliterator contained within will be one {@code float} elements.
		 */
		default OfFloat toFloat() {
			return this;
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfChar} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code char}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfChar} whereby the iterator and
		 *         spliterator contained within will be one {@code char} elements.
		 */
		default OfChar toChar() {
			return () -> iteratorFloat().toChar();
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfShort} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code short}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfShort} whereby the iterator and
		 *         spliterator contained within will be one {@code short} elements.
		 */
		default OfShort toShort() {
			return () -> iteratorFloat().toShort();
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfByte} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code byte}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfByte} whereby the iterator and
		 *         spliterator contained within will be one {@code byte} elements.
		 */
		default OfByte toByte() {
			return () -> iteratorFloat().toByte();
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfBoolean} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code boolean}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfBoolean} whereby the iterator and
		 *         spliterator contained within will be one {@code boolean} elements.
		 */
		default OfBoolean toBoolean() {
			return () -> iteratorFloat().toBoolean();
		}

		@Override
		default void forEach(PrimitiveConsumer.OfFloat action) {
			Objects.requireNonNull(action);
			PrimitiveIterator.OfFloat i = iteratorFloat();
			while (i.hasNext()) {
				action.acceptFloat(i.nextFloat());
			}
		}

		@Override
		default void forEach(Consumer<? super Float> action) {
			if (action instanceof PrimitiveConsumer.OfFloat) {
				forEach((PrimitiveConsumer.OfFloat) action);
				return;
			}
			Objects.requireNonNull(action);
			forEach((PrimitiveConsumer.OfFloat) action::accept);
		}
	}

	/**
	 * An {@code Iterable} of {@code char} values
	 */
	@FunctionalInterface
	interface OfChar extends PrimitiveIterable<Character, PrimitiveConsumer.OfChar> {

		default Iterable<java.lang.Character> boxed() { return this; }

		/**
		 * Creates and return a new iterable of {@code double} using the provided mapper as a processor to map elements from
		 * {@code char} to {@code double}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToDouble} and accept {@code char} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code char} values into {@code double} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfDouble} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToDouble<? super java.lang.Character>, RM extends PrimitiveFunction<? extends java.lang.Character, ? super java.lang.Double>> PrimitiveIterable.OfDouble mapToDouble(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorChar().mapToDouble(mapper, rm);
		}
		/**
		 * Creates and return a new iterable of {@code long} using the provided mapper as a processor to map elements from
		 * {@code char} to {@code long}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToLong} and accept {@code char} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code char} values into {@code long} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfLong} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToLong<? super java.lang.Character>, RM extends PrimitiveFunction<? extends java.lang.Character, ? super java.lang.Long>> PrimitiveIterable.OfLong mapToLong(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorChar().mapToLong(mapper, rm);
		}
		/**
		 * Creates and return a new iterable of {@code int} using the provided mapper as a processor to map elements from
		 * {@code char} to {@code int}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToInt} and accept {@code char} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code char} values into {@code int} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfInt} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToInt<? super java.lang.Character>, RM extends PrimitiveFunction<? extends java.lang.Character, ? super java.lang.Integer>> PrimitiveIterable.OfInt mapToInt(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorChar().mapToInt(mapper, rm);
		}
		/**
		 * Creates and return a new iterable of {@code float} using the provided mapper as a processor to map elements from
		 * {@code char} to {@code float}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToFloat} and accept {@code char} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code char} values into {@code float} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfFloat} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToFloat<? super java.lang.Character>, RM extends PrimitiveFunction<? extends java.lang.Character, ? super java.lang.Float>> PrimitiveIterable.OfFloat mapToFloat(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorChar().mapToFloat(mapper, rm);
		}
		/**
		 * Creates and return a new iterable of {@code char} using the provided mapper as a processor to map elements from
		 * {@code char} to {@code char}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToChar} and accept {@code char} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code char} values into {@code char} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfChar} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToChar<? super java.lang.Character>, RM extends PrimitiveFunction<? extends java.lang.Character, ? super java.lang.Character>> PrimitiveIterable.OfChar mapToChar(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorChar().mapToChar(mapper, rm);
		}
		/**
		 * Creates and return a new iterable of {@code short} using the provided mapper as a processor to map elements from
		 * {@code char} to {@code short}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToShort} and accept {@code char} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code char} values into {@code short} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfShort} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToShort<? super java.lang.Character>, RM extends PrimitiveFunction<? extends java.lang.Character, ? super java.lang.Short>> PrimitiveIterable.OfShort mapToShort(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorChar().mapToShort(mapper, rm);
		}
		/**
		 * Creates and return a new iterable of {@code byte} using the provided mapper as a processor to map elements from
		 * {@code char} to {@code byte}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToByte} and accept {@code char} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code char} values into {@code byte} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfByte} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToByte<? super java.lang.Character>, RM extends PrimitiveFunction<? extends java.lang.Character, ? super java.lang.Byte>> PrimitiveIterable.OfByte mapToByte(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorChar().mapToByte(mapper, rm);
		}
		/**
		 * Creates and return a new iterable of {@code boolean} using the provided mapper as a processor to map elements from
		 * {@code char} to {@code boolean}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToBoolean} and accept {@code char} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code char} values into {@code boolean} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfBoolean} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToBoolean<? super java.lang.Character>, RM extends PrimitiveFunction<? extends java.lang.Character, ? super java.lang.Boolean>> PrimitiveIterable.OfBoolean mapToBoolean(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorChar().mapToBoolean(mapper, rm);
		}

		/**
		 * The {@code char} specialisation of {@link #iterator}
		 * 
		 * @return a specialised iterator of {@code char} values
		 */
		PrimitiveIterator.OfChar iteratorChar();

		@Override
		default Iterator<java.lang.Character> iterator() {
			return iteratorChar();
		}

		/**
		 * The {@code char} specialisation of {@link #spliterator}
		 * 
		 * @return a specialised spliterator of {@code char} values
		 */
		default PrimitiveSpliterator.OfChar spliteratorChar() {
			return PrimitiveSpliterators.spliteratorUnknownSize(iteratorChar(), 0);
		}

		@Override
		default Spliterator<java.lang.Character> spliterator() {
			return spliteratorChar();
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfDouble} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code double}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfDouble} whereby the iterator and
		 *         spliterator contained within will be one {@code double} elements.
		 */
		default OfDouble toDouble() {
			return () -> iteratorChar().toDouble();
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfLong} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code long}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfLong} whereby the iterator and
		 *         spliterator contained within will be one {@code long} elements.
		 */
		default OfLong toLong() {
			return () -> iteratorChar().toLong();
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfInt} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code int}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfInt} whereby the iterator and
		 *         spliterator contained within will be one {@code int} elements.
		 */
		default OfInt toInt() {
			return () -> iteratorChar().toInt();
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfFloat} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code float}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfFloat} whereby the iterator and
		 *         spliterator contained within will be one {@code float} elements.
		 */
		default OfFloat toFloat() {
			return () -> iteratorChar().toFloat();
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfChar} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code char}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfChar} whereby the iterator and
		 *         spliterator contained within will be one {@code char} elements.
		 */
		default OfChar toChar() {
			return this;
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfShort} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code short}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfShort} whereby the iterator and
		 *         spliterator contained within will be one {@code short} elements.
		 */
		default OfShort toShort() {
			return () -> iteratorChar().toShort();
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfByte} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code byte}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfByte} whereby the iterator and
		 *         spliterator contained within will be one {@code byte} elements.
		 */
		default OfByte toByte() {
			return () -> iteratorChar().toByte();
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfBoolean} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code boolean}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfBoolean} whereby the iterator and
		 *         spliterator contained within will be one {@code boolean} elements.
		 */
		default OfBoolean toBoolean() {
			return () -> iteratorChar().toBoolean();
		}

		@Override
		default void forEach(PrimitiveConsumer.OfChar action) {
			Objects.requireNonNull(action);
			PrimitiveIterator.OfChar i = iteratorChar();
			while (i.hasNext()) {
				action.acceptChar(i.nextChar());
			}
		}

		@Override
		default void forEach(Consumer<? super Character> action) {
			if (action instanceof PrimitiveConsumer.OfChar) {
				forEach((PrimitiveConsumer.OfChar) action);
				return;
			}
			Objects.requireNonNull(action);
			forEach((PrimitiveConsumer.OfChar) action::accept);
		}
	}

	/**
	 * An {@code Iterable} of {@code short} values
	 */
	@FunctionalInterface
	interface OfShort extends PrimitiveIterable<Short, PrimitiveConsumer.OfShort> {

		default Iterable<java.lang.Short> boxed() { return this; }

		/**
		 * Creates and return a new iterable of {@code double} using the provided mapper as a processor to map elements from
		 * {@code short} to {@code double}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToDouble} and accept {@code short} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code short} values into {@code double} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfDouble} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToDouble<? super java.lang.Short>, RM extends PrimitiveFunction<? extends java.lang.Short, ? super java.lang.Double>> PrimitiveIterable.OfDouble mapToDouble(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorShort().mapToDouble(mapper, rm);
		}
		/**
		 * Creates and return a new iterable of {@code long} using the provided mapper as a processor to map elements from
		 * {@code short} to {@code long}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToLong} and accept {@code short} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code short} values into {@code long} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfLong} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToLong<? super java.lang.Short>, RM extends PrimitiveFunction<? extends java.lang.Short, ? super java.lang.Long>> PrimitiveIterable.OfLong mapToLong(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorShort().mapToLong(mapper, rm);
		}
		/**
		 * Creates and return a new iterable of {@code int} using the provided mapper as a processor to map elements from
		 * {@code short} to {@code int}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToInt} and accept {@code short} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code short} values into {@code int} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfInt} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToInt<? super java.lang.Short>, RM extends PrimitiveFunction<? extends java.lang.Short, ? super java.lang.Integer>> PrimitiveIterable.OfInt mapToInt(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorShort().mapToInt(mapper, rm);
		}
		/**
		 * Creates and return a new iterable of {@code float} using the provided mapper as a processor to map elements from
		 * {@code short} to {@code float}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToFloat} and accept {@code short} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code short} values into {@code float} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfFloat} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToFloat<? super java.lang.Short>, RM extends PrimitiveFunction<? extends java.lang.Short, ? super java.lang.Float>> PrimitiveIterable.OfFloat mapToFloat(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorShort().mapToFloat(mapper, rm);
		}
		/**
		 * Creates and return a new iterable of {@code char} using the provided mapper as a processor to map elements from
		 * {@code short} to {@code char}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToChar} and accept {@code short} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code short} values into {@code char} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfChar} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToChar<? super java.lang.Short>, RM extends PrimitiveFunction<? extends java.lang.Short, ? super java.lang.Character>> PrimitiveIterable.OfChar mapToChar(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorShort().mapToChar(mapper, rm);
		}
		/**
		 * Creates and return a new iterable of {@code short} using the provided mapper as a processor to map elements from
		 * {@code short} to {@code short}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToShort} and accept {@code short} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code short} values into {@code short} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfShort} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToShort<? super java.lang.Short>, RM extends PrimitiveFunction<? extends java.lang.Short, ? super java.lang.Short>> PrimitiveIterable.OfShort mapToShort(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorShort().mapToShort(mapper, rm);
		}
		/**
		 * Creates and return a new iterable of {@code byte} using the provided mapper as a processor to map elements from
		 * {@code short} to {@code byte}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToByte} and accept {@code short} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code short} values into {@code byte} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfByte} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToByte<? super java.lang.Short>, RM extends PrimitiveFunction<? extends java.lang.Short, ? super java.lang.Byte>> PrimitiveIterable.OfByte mapToByte(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorShort().mapToByte(mapper, rm);
		}
		/**
		 * Creates and return a new iterable of {@code boolean} using the provided mapper as a processor to map elements from
		 * {@code short} to {@code boolean}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToBoolean} and accept {@code short} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code short} values into {@code boolean} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfBoolean} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToBoolean<? super java.lang.Short>, RM extends PrimitiveFunction<? extends java.lang.Short, ? super java.lang.Boolean>> PrimitiveIterable.OfBoolean mapToBoolean(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorShort().mapToBoolean(mapper, rm);
		}

		/**
		 * The {@code short} specialisation of {@link #iterator}
		 * 
		 * @return a specialised iterator of {@code short} values
		 */
		PrimitiveIterator.OfShort iteratorShort();

		@Override
		default Iterator<java.lang.Short> iterator() {
			return iteratorShort();
		}

		/**
		 * The {@code short} specialisation of {@link #spliterator}
		 * 
		 * @return a specialised spliterator of {@code short} values
		 */
		default PrimitiveSpliterator.OfShort spliteratorShort() {
			return PrimitiveSpliterators.spliteratorUnknownSize(iteratorShort(), 0);
		}

		@Override
		default Spliterator<java.lang.Short> spliterator() {
			return spliteratorShort();
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfDouble} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code double}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfDouble} whereby the iterator and
		 *         spliterator contained within will be one {@code double} elements.
		 */
		default OfDouble toDouble() {
			return () -> iteratorShort().toDouble();
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfLong} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code long}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfLong} whereby the iterator and
		 *         spliterator contained within will be one {@code long} elements.
		 */
		default OfLong toLong() {
			return () -> iteratorShort().toLong();
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfInt} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code int}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfInt} whereby the iterator and
		 *         spliterator contained within will be one {@code int} elements.
		 */
		default OfInt toInt() {
			return () -> iteratorShort().toInt();
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfFloat} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code float}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfFloat} whereby the iterator and
		 *         spliterator contained within will be one {@code float} elements.
		 */
		default OfFloat toFloat() {
			return () -> iteratorShort().toFloat();
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfChar} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code char}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfChar} whereby the iterator and
		 *         spliterator contained within will be one {@code char} elements.
		 */
		default OfChar toChar() {
			return () -> iteratorShort().toChar();
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfShort} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code short}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfShort} whereby the iterator and
		 *         spliterator contained within will be one {@code short} elements.
		 */
		default OfShort toShort() {
			return this;
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfByte} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code byte}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfByte} whereby the iterator and
		 *         spliterator contained within will be one {@code byte} elements.
		 */
		default OfByte toByte() {
			return () -> iteratorShort().toByte();
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfBoolean} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code boolean}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfBoolean} whereby the iterator and
		 *         spliterator contained within will be one {@code boolean} elements.
		 */
		default OfBoolean toBoolean() {
			return () -> iteratorShort().toBoolean();
		}

		@Override
		default void forEach(PrimitiveConsumer.OfShort action) {
			Objects.requireNonNull(action);
			PrimitiveIterator.OfShort i = iteratorShort();
			while (i.hasNext()) {
				action.acceptShort(i.nextShort());
			}
		}

		@Override
		default void forEach(Consumer<? super Short> action) {
			if (action instanceof PrimitiveConsumer.OfShort) {
				forEach((PrimitiveConsumer.OfShort) action);
				return;
			}
			Objects.requireNonNull(action);
			forEach((PrimitiveConsumer.OfShort) action::accept);
		}
	}

	/**
	 * An {@code Iterable} of {@code byte} values
	 */
	@FunctionalInterface
	interface OfByte extends PrimitiveIterable<Byte, PrimitiveConsumer.OfByte> {

		default Iterable<java.lang.Byte> boxed() { return this; }

		/**
		 * Creates and return a new iterable of {@code double} using the provided mapper as a processor to map elements from
		 * {@code byte} to {@code double}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToDouble} and accept {@code byte} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code byte} values into {@code double} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfDouble} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToDouble<? super java.lang.Byte>, RM extends PrimitiveFunction<? extends java.lang.Byte, ? super java.lang.Double>> PrimitiveIterable.OfDouble mapToDouble(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorByte().mapToDouble(mapper, rm);
		}
		/**
		 * Creates and return a new iterable of {@code long} using the provided mapper as a processor to map elements from
		 * {@code byte} to {@code long}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToLong} and accept {@code byte} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code byte} values into {@code long} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfLong} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToLong<? super java.lang.Byte>, RM extends PrimitiveFunction<? extends java.lang.Byte, ? super java.lang.Long>> PrimitiveIterable.OfLong mapToLong(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorByte().mapToLong(mapper, rm);
		}
		/**
		 * Creates and return a new iterable of {@code int} using the provided mapper as a processor to map elements from
		 * {@code byte} to {@code int}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToInt} and accept {@code byte} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code byte} values into {@code int} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfInt} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToInt<? super java.lang.Byte>, RM extends PrimitiveFunction<? extends java.lang.Byte, ? super java.lang.Integer>> PrimitiveIterable.OfInt mapToInt(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorByte().mapToInt(mapper, rm);
		}
		/**
		 * Creates and return a new iterable of {@code float} using the provided mapper as a processor to map elements from
		 * {@code byte} to {@code float}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToFloat} and accept {@code byte} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code byte} values into {@code float} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfFloat} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToFloat<? super java.lang.Byte>, RM extends PrimitiveFunction<? extends java.lang.Byte, ? super java.lang.Float>> PrimitiveIterable.OfFloat mapToFloat(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorByte().mapToFloat(mapper, rm);
		}
		/**
		 * Creates and return a new iterable of {@code char} using the provided mapper as a processor to map elements from
		 * {@code byte} to {@code char}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToChar} and accept {@code byte} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code byte} values into {@code char} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfChar} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToChar<? super java.lang.Byte>, RM extends PrimitiveFunction<? extends java.lang.Byte, ? super java.lang.Character>> PrimitiveIterable.OfChar mapToChar(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorByte().mapToChar(mapper, rm);
		}
		/**
		 * Creates and return a new iterable of {@code short} using the provided mapper as a processor to map elements from
		 * {@code byte} to {@code short}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToShort} and accept {@code byte} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code byte} values into {@code short} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfShort} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToShort<? super java.lang.Byte>, RM extends PrimitiveFunction<? extends java.lang.Byte, ? super java.lang.Short>> PrimitiveIterable.OfShort mapToShort(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorByte().mapToShort(mapper, rm);
		}
		/**
		 * Creates and return a new iterable of {@code byte} using the provided mapper as a processor to map elements from
		 * {@code byte} to {@code byte}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToByte} and accept {@code byte} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code byte} values into {@code byte} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfByte} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToByte<? super java.lang.Byte>, RM extends PrimitiveFunction<? extends java.lang.Byte, ? super java.lang.Byte>> PrimitiveIterable.OfByte mapToByte(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorByte().mapToByte(mapper, rm);
		}
		/**
		 * Creates and return a new iterable of {@code boolean} using the provided mapper as a processor to map elements from
		 * {@code byte} to {@code boolean}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToBoolean} and accept {@code byte} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code byte} values into {@code boolean} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfBoolean} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToBoolean<? super java.lang.Byte>, RM extends PrimitiveFunction<? extends java.lang.Byte, ? super java.lang.Boolean>> PrimitiveIterable.OfBoolean mapToBoolean(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorByte().mapToBoolean(mapper, rm);
		}

		/**
		 * The {@code byte} specialisation of {@link #iterator}
		 * 
		 * @return a specialised iterator of {@code byte} values
		 */
		PrimitiveIterator.OfByte iteratorByte();

		@Override
		default Iterator<java.lang.Byte> iterator() {
			return iteratorByte();
		}

		/**
		 * The {@code byte} specialisation of {@link #spliterator}
		 * 
		 * @return a specialised spliterator of {@code byte} values
		 */
		default PrimitiveSpliterator.OfByte spliteratorByte() {
			return PrimitiveSpliterators.spliteratorUnknownSize(iteratorByte(), 0);
		}

		@Override
		default Spliterator<java.lang.Byte> spliterator() {
			return spliteratorByte();
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfDouble} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code double}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfDouble} whereby the iterator and
		 *         spliterator contained within will be one {@code double} elements.
		 */
		default OfDouble toDouble() {
			return () -> iteratorByte().toDouble();
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfLong} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code long}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfLong} whereby the iterator and
		 *         spliterator contained within will be one {@code long} elements.
		 */
		default OfLong toLong() {
			return () -> iteratorByte().toLong();
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfInt} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code int}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfInt} whereby the iterator and
		 *         spliterator contained within will be one {@code int} elements.
		 */
		default OfInt toInt() {
			return () -> iteratorByte().toInt();
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfFloat} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code float}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfFloat} whereby the iterator and
		 *         spliterator contained within will be one {@code float} elements.
		 */
		default OfFloat toFloat() {
			return () -> iteratorByte().toFloat();
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfChar} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code char}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfChar} whereby the iterator and
		 *         spliterator contained within will be one {@code char} elements.
		 */
		default OfChar toChar() {
			return () -> iteratorByte().toChar();
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfShort} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code short}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfShort} whereby the iterator and
		 *         spliterator contained within will be one {@code short} elements.
		 */
		default OfShort toShort() {
			return () -> iteratorByte().toShort();
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfByte} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code byte}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfByte} whereby the iterator and
		 *         spliterator contained within will be one {@code byte} elements.
		 */
		default OfByte toByte() {
			return this;
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfBoolean} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code boolean}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfBoolean} whereby the iterator and
		 *         spliterator contained within will be one {@code boolean} elements.
		 */
		default OfBoolean toBoolean() {
			return () -> iteratorByte().toBoolean();
		}

		@Override
		default void forEach(PrimitiveConsumer.OfByte action) {
			Objects.requireNonNull(action);
			PrimitiveIterator.OfByte i = iteratorByte();
			while (i.hasNext()) {
				action.acceptByte(i.nextByte());
			}
		}

		@Override
		default void forEach(Consumer<? super Byte> action) {
			if (action instanceof PrimitiveConsumer.OfByte) {
				forEach((PrimitiveConsumer.OfByte) action);
				return;
			}
			Objects.requireNonNull(action);
			forEach((PrimitiveConsumer.OfByte) action::accept);
		}
	}

	/**
	 * An {@code Iterable} of {@code boolean} values
	 */
	@FunctionalInterface
	interface OfBoolean extends PrimitiveIterable<Boolean, PrimitiveConsumer.OfBoolean> {

		default Iterable<java.lang.Boolean> boxed() { return this; }

		/**
		 * Creates and return a new iterable of {@code double} using the provided mapper as a processor to map elements from
		 * {@code boolean} to {@code double}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToDouble} and accept {@code boolean} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code boolean} values into {@code double} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfDouble} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToDouble<? super java.lang.Boolean>, RM extends PrimitiveFunction<? extends java.lang.Boolean, ? super java.lang.Double>> PrimitiveIterable.OfDouble mapToDouble(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorBoolean().mapToDouble(mapper, rm);
		}
		/**
		 * Creates and return a new iterable of {@code long} using the provided mapper as a processor to map elements from
		 * {@code boolean} to {@code long}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToLong} and accept {@code boolean} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code boolean} values into {@code long} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfLong} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToLong<? super java.lang.Boolean>, RM extends PrimitiveFunction<? extends java.lang.Boolean, ? super java.lang.Long>> PrimitiveIterable.OfLong mapToLong(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorBoolean().mapToLong(mapper, rm);
		}
		/**
		 * Creates and return a new iterable of {@code int} using the provided mapper as a processor to map elements from
		 * {@code boolean} to {@code int}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToInt} and accept {@code boolean} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code boolean} values into {@code int} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfInt} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToInt<? super java.lang.Boolean>, RM extends PrimitiveFunction<? extends java.lang.Boolean, ? super java.lang.Integer>> PrimitiveIterable.OfInt mapToInt(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorBoolean().mapToInt(mapper, rm);
		}
		/**
		 * Creates and return a new iterable of {@code float} using the provided mapper as a processor to map elements from
		 * {@code boolean} to {@code float}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToFloat} and accept {@code boolean} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code boolean} values into {@code float} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfFloat} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToFloat<? super java.lang.Boolean>, RM extends PrimitiveFunction<? extends java.lang.Boolean, ? super java.lang.Float>> PrimitiveIterable.OfFloat mapToFloat(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorBoolean().mapToFloat(mapper, rm);
		}
		/**
		 * Creates and return a new iterable of {@code char} using the provided mapper as a processor to map elements from
		 * {@code boolean} to {@code char}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToChar} and accept {@code boolean} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code boolean} values into {@code char} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfChar} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToChar<? super java.lang.Boolean>, RM extends PrimitiveFunction<? extends java.lang.Boolean, ? super java.lang.Character>> PrimitiveIterable.OfChar mapToChar(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorBoolean().mapToChar(mapper, rm);
		}
		/**
		 * Creates and return a new iterable of {@code short} using the provided mapper as a processor to map elements from
		 * {@code boolean} to {@code short}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToShort} and accept {@code boolean} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code boolean} values into {@code short} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfShort} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToShort<? super java.lang.Boolean>, RM extends PrimitiveFunction<? extends java.lang.Boolean, ? super java.lang.Short>> PrimitiveIterable.OfShort mapToShort(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorBoolean().mapToShort(mapper, rm);
		}
		/**
		 * Creates and return a new iterable of {@code byte} using the provided mapper as a processor to map elements from
		 * {@code boolean} to {@code byte}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToByte} and accept {@code boolean} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code boolean} values into {@code byte} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfByte} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToByte<? super java.lang.Boolean>, RM extends PrimitiveFunction<? extends java.lang.Boolean, ? super java.lang.Byte>> PrimitiveIterable.OfByte mapToByte(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorBoolean().mapToByte(mapper, rm);
		}
		/**
		 * Creates and return a new iterable of {@code boolean} using the provided mapper as a processor to map elements from
		 * {@code boolean} to {@code boolean}
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToBoolean} and accept {@code boolean} values
		 * @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		 * @param mapper a mapper to which will be used to process {@code boolean} values into {@code boolean} values
		 * @param rm can be {@code null}
		 * @return a new {@link PrimitiveIterable.OfBoolean} instance
		 * @throws NullPointerException if {@code mapper} is {@code null}
		 * @implSpec The actual implementation leverages the underlying iterator. The parameter {@code rm} is ignored in the default implementation
		 */
		default <M extends PrimitiveFunction.ToBoolean<? super java.lang.Boolean>, RM extends PrimitiveFunction<? extends java.lang.Boolean, ? super java.lang.Boolean>> PrimitiveIterable.OfBoolean mapToBoolean(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			return () -> iteratorBoolean().mapToBoolean(mapper, rm);
		}

		/**
		 * The {@code boolean} specialisation of {@link #iterator}
		 * 
		 * @return a specialised iterator of {@code boolean} values
		 */
		PrimitiveIterator.OfBoolean iteratorBoolean();

		@Override
		default Iterator<java.lang.Boolean> iterator() {
			return iteratorBoolean();
		}

		/**
		 * The {@code boolean} specialisation of {@link #spliterator}
		 * 
		 * @return a specialised spliterator of {@code boolean} values
		 */
		default PrimitiveSpliterator.OfBoolean spliteratorBoolean() {
			return PrimitiveSpliterators.spliteratorUnknownSize(iteratorBoolean(), 0);
		}

		@Override
		default Spliterator<java.lang.Boolean> spliterator() {
			return spliteratorBoolean();
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfDouble} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code double}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfDouble} whereby the iterator and
		 *         spliterator contained within will be one {@code double} elements.
		 */
		default OfDouble toDouble() {
			return () -> iteratorBoolean().toDouble();
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfLong} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code long}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfLong} whereby the iterator and
		 *         spliterator contained within will be one {@code long} elements.
		 */
		default OfLong toLong() {
			return () -> iteratorBoolean().toLong();
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfInt} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code int}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfInt} whereby the iterator and
		 *         spliterator contained within will be one {@code int} elements.
		 */
		default OfInt toInt() {
			return () -> iteratorBoolean().toInt();
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfFloat} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code float}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfFloat} whereby the iterator and
		 *         spliterator contained within will be one {@code float} elements.
		 */
		default OfFloat toFloat() {
			return () -> iteratorBoolean().toFloat();
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfChar} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code char}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfChar} whereby the iterator and
		 *         spliterator contained within will be one {@code char} elements.
		 */
		default OfChar toChar() {
			return () -> iteratorBoolean().toChar();
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfShort} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code short}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfShort} whereby the iterator and
		 *         spliterator contained within will be one {@code short} elements.
		 */
		default OfShort toShort() {
			return () -> iteratorBoolean().toShort();
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfByte} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code byte}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfByte} whereby the iterator and
		 *         spliterator contained within will be one {@code byte} elements.
		 */
		default OfByte toByte() {
			return () -> iteratorBoolean().toByte();
		}

		/*
		 * Date created: 27 May 2024 Time created: 15:24:37
		 */
		/**
		 * Casts this {@code Iterable} to {@link OfBoolean} where all calls to
		 * {@link #iterator} and {@link #spliterator} will return their {@code boolean}
		 * versions.
		 * 
		 * @return {@link PrimitiveIterator.OfBoolean} whereby the iterator and
		 *         spliterator contained within will be one {@code boolean} elements.
		 */
		default OfBoolean toBoolean() {
			return this;
		}

		@Override
		default void forEach(PrimitiveConsumer.OfBoolean action) {
			Objects.requireNonNull(action);
			PrimitiveIterator.OfBoolean i = iteratorBoolean();
			while (i.hasNext()) {
				action.acceptBoolean(i.nextBoolean());
			}
		}

		@Override
		default void forEach(Consumer<? super Boolean> action) {
			if (action instanceof PrimitiveConsumer.OfBoolean) {
				forEach((PrimitiveConsumer.OfBoolean) action);
				return;
			}
			Objects.requireNonNull(action);
			forEach((PrimitiveConsumer.OfBoolean) action::accept);
		}
	}

	/**
	 * The primitive variant of {@link #forEach(Consumer)}
	 * 
	 * @param action the action to be performed
	 */
	void forEach(T_CONS action);

	/*
	 * Date created: 27 May 2024 Time created: 15:24:37
	 */
	/**
	 * Casts this {@code Iterable} to from the current primitive context to one that supports a {@link java.lang.Double} where all calls to
	 * {@link #iterator} and {@link #spliterator} will return their {@code Double}
	 * versions.
	 * 
	 * @return {@link PrimitiveIterable} whereby the iterator and
	 *         spliterator contained within will support {@code Double} elements.
	 */
	PrimitiveIterable<java.lang.Double, PrimitiveConsumer.OfDouble> toDouble();

	/*
	 * Date created: 27 May 2024 Time created: 15:24:37
	 */
	/**
	 * Casts this {@code Iterable} to from the current primitive context to one that supports a {@link java.lang.Long} where all calls to
	 * {@link #iterator} and {@link #spliterator} will return their {@code Long}
	 * versions.
	 * 
	 * @return {@link PrimitiveIterable} whereby the iterator and
	 *         spliterator contained within will support {@code Long} elements.
	 */
	PrimitiveIterable<java.lang.Long, PrimitiveConsumer.OfLong> toLong();

	/*
	 * Date created: 27 May 2024 Time created: 15:24:37
	 */
	/**
	 * Casts this {@code Iterable} to from the current primitive context to one that supports a {@link java.lang.Integer} where all calls to
	 * {@link #iterator} and {@link #spliterator} will return their {@code Integer}
	 * versions.
	 * 
	 * @return {@link PrimitiveIterable} whereby the iterator and
	 *         spliterator contained within will support {@code Int} elements.
	 */
	PrimitiveIterable<java.lang.Integer, PrimitiveConsumer.OfInt> toInt();

	/*
	 * Date created: 27 May 2024 Time created: 15:24:37
	 */
	/**
	 * Casts this {@code Iterable} to from the current primitive context to one that supports a {@link java.lang.Float} where all calls to
	 * {@link #iterator} and {@link #spliterator} will return their {@code Float}
	 * versions.
	 * 
	 * @return {@link PrimitiveIterable} whereby the iterator and
	 *         spliterator contained within will support {@code Float} elements.
	 */
	PrimitiveIterable<java.lang.Float, PrimitiveConsumer.OfFloat> toFloat();

	/*
	 * Date created: 27 May 2024 Time created: 15:24:37
	 */
	/**
	 * Casts this {@code Iterable} to from the current primitive context to one that supports a {@link java.lang.Character} where all calls to
	 * {@link #iterator} and {@link #spliterator} will return their {@code Character}
	 * versions.
	 * 
	 * @return {@link PrimitiveIterable} whereby the iterator and
	 *         spliterator contained within will support {@code Char} elements.
	 */
	PrimitiveIterable<java.lang.Character, PrimitiveConsumer.OfChar> toChar();

	/*
	 * Date created: 27 May 2024 Time created: 15:24:37
	 */
	/**
	 * Casts this {@code Iterable} to from the current primitive context to one that supports a {@link java.lang.Short} where all calls to
	 * {@link #iterator} and {@link #spliterator} will return their {@code Short}
	 * versions.
	 * 
	 * @return {@link PrimitiveIterable} whereby the iterator and
	 *         spliterator contained within will support {@code Short} elements.
	 */
	PrimitiveIterable<java.lang.Short, PrimitiveConsumer.OfShort> toShort();

	/*
	 * Date created: 27 May 2024 Time created: 15:24:37
	 */
	/**
	 * Casts this {@code Iterable} to from the current primitive context to one that supports a {@link java.lang.Byte} where all calls to
	 * {@link #iterator} and {@link #spliterator} will return their {@code Byte}
	 * versions.
	 * 
	 * @return {@link PrimitiveIterable} whereby the iterator and
	 *         spliterator contained within will support {@code Byte} elements.
	 */
	PrimitiveIterable<java.lang.Byte, PrimitiveConsumer.OfByte> toByte();

	/*
	 * Date created: 27 May 2024 Time created: 15:24:37
	 */
	/**
	 * Casts this {@code Iterable} to from the current primitive context to one that supports a {@link java.lang.Boolean} where all calls to
	 * {@link #iterator} and {@link #spliterator} will return their {@code Boolean}
	 * versions.
	 * 
	 * @return {@link PrimitiveIterable} whereby the iterator and
	 *         spliterator contained within will support {@code Boolean} elements.
	 */
	PrimitiveIterable<java.lang.Boolean, PrimitiveConsumer.OfBoolean> toBoolean();

}
