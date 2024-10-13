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
import jdk.prim.util.function.PrimitiveConsumer;

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
 * An effort to support primitiveions and streams.
 * 
 * @param <T>      the wrapper type for the primitive type being iterated.
 * @param <T_CONS> the type of the {@link PrimitiveConsumer primitive consumer}
 * @param <T_ITR>  the type of {@link PrimitiveIterator primitive iterator}
 * @param <T_SPTR> the type of {@link PrimitiveSpliterator primitive
 *                 spliterator}
 * 
 * @author Oruovo Etineakpopha Anthony
 */
public interface PrimitiveIterable<T, T_CONS> extends Iterable<T> {

	/**
	 * An {@code Iterable} of {@code double} values
	 */
	@FunctionalInterface
	interface OfDouble extends PrimitiveIterable<Double, PrimitiveConsumer.OfDouble> {

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
			return null;
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
			return null;
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
			return null;
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
			return null;
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
			return null;
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
			return null;
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
			return null;
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
			return null;
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
	 * Casts this {@code Iterable} to {@link OfDouble} where all calls to
	 * {@link #iterator} and {@link #spliterator} will return their {@code double}
	 * versions.
	 * 
	 * @return {@link PrimitiveIterator.OfDouble} whereby the iterator and
	 *         spliterator contained within will be one {@code double} elements.
	 */
	OfDouble toDouble();

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
	OfLong toLong();

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
	OfInt toInt();

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
	OfFloat toFloat();

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
	OfChar toChar();

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
	OfShort toShort();

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
	OfByte toByte();

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
	OfBoolean toBoolean();

}
