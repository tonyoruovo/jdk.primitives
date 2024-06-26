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

import java.util.Objects;
import java.util.function.Consumer;

import jdk.prim.util.PrimitiveIterator;
import jdk.prim.util.PrimitiveSpliterator;

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
 * An effort to support primitiveions and streams. Will be fleshed out
 * later.
 * 
 * @author Oruovo Etineakpopha Anthony
 */
public interface PrimitiveIterable<T, T_CONS> extends Iterable<T> {

	@FunctionalInterface
	interface OfDouble extends PrimitiveIterable<Double, jdk.prim.util.function.Double.Consumer> {

		@Override
		PrimitiveIterator.OfDouble iterator();

		@Override
		default PrimitiveSpliterator.OfDouble spliterator() {
			return null;
		}

		@Override
		default void forEach(jdk.prim.util.function.Double.Consumer action) {
			Objects.requireNonNull(action);
			PrimitiveIterator.OfDouble i = iterator();
			while (i.hasNext()) {
				action.acceptDouble(i.nextDouble());
			}
		}

		@Override
		default void forEach(Consumer<? super Double> action) {
			if (action instanceof jdk.prim.util.function.Double.Consumer) {
				forEach((jdk.prim.util.function.Double.Consumer) action);
				return;
			}
			Objects.requireNonNull(action);
			forEach((jdk.prim.util.function.Double.Consumer) action::accept);
		}
	}

	@FunctionalInterface
	interface OfLong extends PrimitiveIterable<Long, jdk.prim.util.function.Long.Consumer> {

		@Override
		PrimitiveIterator.OfLong iterator();

		@Override
		default PrimitiveSpliterator.OfLong spliterator() {
			return null;
		}

		@Override
		default void forEach(jdk.prim.util.function.Long.Consumer action) {
			Objects.requireNonNull(action);
			PrimitiveIterator.OfLong i = iterator();
			while (i.hasNext()) {
				action.acceptLong(i.nextLong());
			}
		}

		@Override
		default void forEach(Consumer<? super Long> action) {
			if (action instanceof jdk.prim.util.function.Long.Consumer) {
				forEach((jdk.prim.util.function.Long.Consumer) action);
				return;
			}
			Objects.requireNonNull(action);
			forEach((jdk.prim.util.function.Long.Consumer) action::accept);
		}
	}

	@FunctionalInterface
	interface OfInt extends PrimitiveIterable<Integer, jdk.prim.util.function.Int.Consumer> {

		@Override
		PrimitiveIterator.OfInt iterator();

		@Override
		default PrimitiveSpliterator.OfInt spliterator() {
			return null;
		}

		@Override
		default void forEach(jdk.prim.util.function.Int.Consumer action) {
			Objects.requireNonNull(action);
			PrimitiveIterator.OfInt i = iterator();
			while (i.hasNext()) {
				action.acceptInt(i.nextInt());
			}
		}

		@Override
		default void forEach(Consumer<? super Integer> action) {
			if (action instanceof jdk.prim.util.function.Int.Consumer) {
				forEach((jdk.prim.util.function.Int.Consumer) action);
				return;
			}
			Objects.requireNonNull(action);
			forEach((jdk.prim.util.function.Int.Consumer) action::accept);
		}
	}

	@FunctionalInterface
	interface OfFloat extends PrimitiveIterable<Float, jdk.prim.util.function.Float.Consumer> {

		@Override
		PrimitiveIterator.OfFloat iterator();

		@Override
		default jdk.prim.util.PrimitiveSpliterator.OfFloat spliterator() {
			return null;
		}

		@Override
		default void forEach(jdk.prim.util.function.Float.Consumer action) {
			Objects.requireNonNull(action);
			PrimitiveIterator.OfFloat i = iterator();
			while (i.hasNext()) {
				action.acceptFloat(i.nextFloat());
			}
		}

		@Override
		default void forEach(Consumer<? super Float> action) {
			if (action instanceof jdk.prim.util.function.Float.Consumer) {
				forEach((jdk.prim.util.function.Float.Consumer) action);
				return;
			}
			Objects.requireNonNull(action);
			forEach((jdk.prim.util.function.Float.Consumer) action::accept);
		}
	}

	@FunctionalInterface
	interface OfChar extends PrimitiveIterable<Character, jdk.prim.util.function.Char.Consumer> {

		@Override
		PrimitiveIterator.OfChar iterator();

		@Override
		default jdk.prim.util.PrimitiveSpliterator.OfChar spliterator() {
			return null;
		}

		@Override
		default void forEach(jdk.prim.util.function.Char.Consumer action) {
			Objects.requireNonNull(action);
			PrimitiveIterator.OfChar i = iterator();
			while (i.hasNext()) {
				action.acceptChar(i.nextChar());
			}
		}

		@Override
		default void forEach(Consumer<? super Character> action) {
			if (action instanceof jdk.prim.util.function.Char.Consumer) {
				forEach((jdk.prim.util.function.Char.Consumer) action);
				return;
			}
			Objects.requireNonNull(action);
			forEach((jdk.prim.util.function.Char.Consumer) action::accept);
		}
	}

	@FunctionalInterface
	interface OfShort extends PrimitiveIterable<Short, jdk.prim.util.function.Short.Consumer> {

		@Override
		PrimitiveIterator.OfShort iterator();

		@Override
		default jdk.prim.util.PrimitiveSpliterator.OfShort spliterator() {
			return null;
		}

		@Override
		default void forEach(jdk.prim.util.function.Short.Consumer action) {
			Objects.requireNonNull(action);
			PrimitiveIterator.OfShort i = iterator();
			while (i.hasNext()) {
				action.acceptShort(i.nextShort());
			}
		}

		@Override
		default void forEach(Consumer<? super Short> action) {
			if (action instanceof jdk.prim.util.function.Short.Consumer) {
				forEach((jdk.prim.util.function.Short.Consumer) action);
				return;
			}
			Objects.requireNonNull(action);
			forEach((jdk.prim.util.function.Short.Consumer) action::accept);
		}
	}

	@FunctionalInterface
	interface OfByte extends PrimitiveIterable<Byte, jdk.prim.util.function.Byte.Consumer> {

		@Override
		PrimitiveIterator.OfByte iterator();

		@Override
		default jdk.prim.util.PrimitiveSpliterator.OfByte spliterator() {
			return null;
		}

		@Override
		default void forEach(jdk.prim.util.function.Byte.Consumer action) {
			Objects.requireNonNull(action);
			PrimitiveIterator.OfByte i = iterator();
			while (i.hasNext()) {
				action.acceptByte(i.nextByte());
			}
		}

		@Override
		default void forEach(Consumer<? super Byte> action) {
			if (action instanceof jdk.prim.util.function.Byte.Consumer) {
				forEach((jdk.prim.util.function.Byte.Consumer) action);
				return;
			}
			Objects.requireNonNull(action);
			forEach((jdk.prim.util.function.Byte.Consumer) action::accept);
		}
	}

	@FunctionalInterface
	interface OfBoolean extends PrimitiveIterable<Boolean, jdk.prim.util.function.Boolean.Consumer> {

		@Override
		PrimitiveIterator.OfBoolean iterator();

		@Override
		default jdk.prim.util.PrimitiveSpliterator.OfBoolean spliterator() {
			return null;
		}

		@Override
		default void forEach(jdk.prim.util.function.Boolean.Consumer action) {
			Objects.requireNonNull(action);
			PrimitiveIterator.OfBoolean i = iterator();
			while (i.hasNext()) {
				action.acceptBoolean(i.nextBoolean());
			}
		}

		@Override
		default void forEach(Consumer<? super Boolean> action) {
			if (action instanceof jdk.prim.util.function.Boolean.Consumer) {
				forEach((jdk.prim.util.function.Boolean.Consumer) action);
				return;
			}
			Objects.requireNonNull(action);
			forEach((jdk.prim.util.function.Boolean.Consumer) action::accept);
		}
	}

	void forEach(T_CONS action);

	/*
	 * Date created: 27 May 2024 Time created: 11:21:12
	 */
	/**
	 * Creates and returns a {@link PrimitiveIterator} of the specified type
	 * 
	 * @return a {@code PrimitiveIterator}
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	PrimitiveIterator<T, ?> iterator();

	/*
	 * Date created: 27 May 2024
	 * Time created: 17:54:45
	 */
	/**
	 * Returns a {@link PrimitiveSpliterator} view over this {@code Iterable}.
	 * @return a {@code PrimitiveSpliterator}
	 * @see java.lang.Iterable#spliterator()
	 */
	@Override
	PrimitiveSpliterator<T, ?, ?> spliterator();

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
		return () -> iterator().toDouble();
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
		return () -> iterator().toLong();
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
		return () -> iterator().toInt();
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
		return () -> iterator().toFloat();
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
		return () -> iterator().toChar();
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
		return () -> iterator().toShort();
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
		return () -> iterator().toByte();
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
		return () -> iterator().toBoolean();
	}

}
