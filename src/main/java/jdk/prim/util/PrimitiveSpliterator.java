/**
 * 
 */
package jdk.prim.util;

import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

import jdk.prim.util.function.PrimitiveConsumer;

/**
 * A spliterator of primitive elements
 * 
 * @see Spliterator
 */
public interface PrimitiveSpliterator<T, T_SPLITR extends Spliterator<T>>
		extends Spliterator<T> {

	/**
	 * A spliterator for {@code double} values
	 */
	interface OfDouble extends PrimitiveSpliterator<Double, PrimitiveSpliterator.OfDouble>, Spliterator.OfDouble {
		/**
		 * @see OfPrimitive#trySplit()
		 */
		@Override
		PrimitiveSpliterator.OfDouble trySplit();

		/**
		 * @see java.util.Spliterator.OfPrimitive#tryAdvance(Object)
		 */
		boolean tryAdvance(PrimitiveConsumer.OfDouble action);

		/**
		 * @see java.util.Spliterator.OfDouble#tryAdvance(DoubleConsumer)
		 */
		@Override
		default boolean tryAdvance(DoubleConsumer action) {
			if (action instanceof PrimitiveConsumer.OfDouble)
				return tryAdvance((PrimitiveConsumer.OfDouble) action);
			else
				return tryAdvance((PrimitiveConsumer.OfDouble) action::accept);
		}

		/**
		 * @see java.util.Spliterator#tryAdvance(Consumer)
		 */
		@Override
		default boolean tryAdvance(Consumer<? super java.lang.Double> action) {
			if (action instanceof PrimitiveConsumer.OfDouble)
				return tryAdvance((PrimitiveConsumer.OfDouble) action);
			else
				return tryAdvance((PrimitiveConsumer.OfDouble) action::accept);
		}

		/**
		 * @see java.util.Spliterator.OfPrimitive#forEachRemaining(Object)
		 */
		default void forEachRemaining(PrimitiveConsumer.OfDouble action) {
			do {
			} while (tryAdvance(action));
		}

		/**
		 * @see java.util.Spliterator.OfDouble#forEachRemaining(DoubleConsumer)
		 */
		@Override
		default void forEachRemaining(DoubleConsumer action) {
			if (action instanceof PrimitiveConsumer.OfDouble)
				forEachRemaining((PrimitiveConsumer.OfDouble) action);
			else
				forEachRemaining((PrimitiveConsumer.OfDouble) action::accept);
		}

		/**
		 * @see java.util.Spliterator#forEachRemaining(Consumer)
		 */
		@Override
		default void forEachRemaining(Consumer<? super java.lang.Double> action) {
			if (action instanceof PrimitiveConsumer.OfDouble)
				forEachRemaining((PrimitiveConsumer.OfDouble) action);
			else
				forEachRemaining((PrimitiveConsumer.OfDouble) action::accept);
		}

		/**
		 * @see Spliterator#getComparator()
		 */
		@Override
		default PrimitiveComparator.OfDouble getComparator() { throw new IllegalStateException(); }
	}

	/**
	 * A spliterator for {@code long} values
	 */
	interface OfLong extends PrimitiveSpliterator<Long, PrimitiveSpliterator.OfLong>, Spliterator.OfLong {
		/**
		 * {@inheritDoc}
		 * 
		 * @return {@inheritDoc}
		 */
		@Override
		PrimitiveSpliterator.OfLong trySplit();

		/**
		 * @see java.util.Spliterator.OfPrimitive#tryAdvance(Object)
		 */
		boolean tryAdvance(PrimitiveConsumer.OfLong action);

		/**
		 * {@inheritDoc}
		 * 
		 * @param action {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		@Override
		default boolean tryAdvance(LongConsumer action) {
			if (action instanceof PrimitiveConsumer.OfLong)
				return tryAdvance((PrimitiveConsumer.OfLong) action);
			else
				return tryAdvance((PrimitiveConsumer.OfLong) action::accept);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @param action {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		@Override
		default boolean tryAdvance(Consumer<? super java.lang.Long> action) {
			if (action instanceof PrimitiveConsumer.OfLong)
				return tryAdvance((PrimitiveConsumer.OfLong) action);
			else
				return tryAdvance((PrimitiveConsumer.OfLong) action::accept);
		}

		/**
		 * @see java.util.Spliterator.OfPrimitive#forEachRemaining(Object)
		 */
		default void forEachRemaining(PrimitiveConsumer.OfLong action) {
			do {
			} while (tryAdvance(action));
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @param action {@inheritDoc}
		 */
		@Override
		default void forEachRemaining(LongConsumer action) {
			if (action instanceof PrimitiveConsumer.OfLong)
				forEachRemaining((PrimitiveConsumer.OfLong) action);
			else
				forEachRemaining((PrimitiveConsumer.OfLong) action::accept);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @param action {@inheritDoc}
		 */
		@Override
		default void forEachRemaining(Consumer<? super java.lang.Long> action) {
			if (action instanceof PrimitiveConsumer.OfLong)
				forEachRemaining((PrimitiveConsumer.OfLong) action);
			else
				forEachRemaining((PrimitiveConsumer.OfLong) action::accept);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @return {@inheritDoc}
		 */
		@Override
		default PrimitiveComparator.OfLong getComparator() { throw new IllegalStateException(); }
	}

	/**
	 * A spliterator for {@code int} values
	 */
	interface OfInt extends PrimitiveSpliterator<Integer, PrimitiveSpliterator.OfInt>, Spliterator.OfInt {
		/**
		 * {@inheritDoc}
		 * 
		 * @return {@inheritDoc}
		 */
		@Override
		PrimitiveSpliterator.OfInt trySplit();

		/**
		 * @see java.util.Spliterator.OfPrimitive#tryAdvance(Object)
		 */
		boolean tryAdvance(PrimitiveConsumer.OfInt action);

		/**
		 * {@inheritDoc}
		 * 
		 * @param action {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		@Override
		default boolean tryAdvance(IntConsumer action) {
			if (action instanceof PrimitiveConsumer.OfInt)
				return tryAdvance((PrimitiveConsumer.OfInt) action);
			else
				return tryAdvance((PrimitiveConsumer.OfInt) action::accept);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @param action {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		@Override
		default boolean tryAdvance(Consumer<? super java.lang.Integer> action) {
			if (action instanceof PrimitiveConsumer.OfInt)
				return tryAdvance((PrimitiveConsumer.OfInt) action);
			else
				return tryAdvance((PrimitiveConsumer.OfInt) action::accept);
		}

		/**
		 * @see java.util.Spliterator.OfPrimitive#forEachRemaining(Object)
		 */
		default void forEachRemaining(PrimitiveConsumer.OfInt action) {
			do {
			} while (tryAdvance(action));
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @param action {@inheritDoc}
		 */
		@Override
		default void forEachRemaining(IntConsumer action) {
			if (action instanceof PrimitiveConsumer.OfInt)
				forEachRemaining((PrimitiveConsumer.OfInt) action);
			else
				forEachRemaining((PrimitiveConsumer.OfInt) action::accept);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @param action {@inheritDoc}
		 */
		@Override
		default void forEachRemaining(Consumer<? super java.lang.Integer> action) {
			if (action instanceof PrimitiveConsumer.OfInt)
				forEachRemaining((PrimitiveConsumer.OfInt) action);
			else
				forEachRemaining((PrimitiveConsumer.OfInt) action::accept);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @return {@inheritDoc}
		 */
		@Override
		default PrimitiveComparator.OfInt getComparator() { throw new IllegalStateException(); }
	}

	/**
	 * A spliterator for {@code float} values
	 */
	interface OfFloat extends PrimitiveSpliterator<Float, OfFloat> {
		/**
		 * {@inheritDoc}
		 * 
		 * @return {@inheritDoc}
		 */
		@Override
		OfFloat trySplit();

		/**
		 * @see java.util.Spliterator.OfPrimitive#tryAdvance(Object)
		 */
		boolean tryAdvance(PrimitiveConsumer.OfFloat action);

		/**
		 * {@inheritDoc}
		 * 
		 * @param action {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		@Override
		default boolean tryAdvance(Consumer<? super java.lang.Float> action) {
			if (action instanceof PrimitiveConsumer.OfFloat)
				return tryAdvance((PrimitiveConsumer.OfFloat) action);
			else
				return tryAdvance((PrimitiveConsumer.OfFloat) action::accept);
		}

		/**
		 * @see java.util.Spliterator.OfPrimitive#forEachRemaining(Object)
		 */
		default void forEachRemaining(PrimitiveConsumer.OfFloat action) {
			do {
			} while (tryAdvance(action));
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @param action {@inheritDoc}
		 */
		@Override
		default void forEachRemaining(Consumer<? super java.lang.Float> action) {
			if (action instanceof PrimitiveConsumer.OfFloat)
				forEachRemaining((PrimitiveConsumer.OfFloat) action);
			else
				forEachRemaining((PrimitiveConsumer.OfFloat) action::accept);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @return {@inheritDoc}
		 */
		@Override
		default PrimitiveComparator.OfFloat getComparator() { throw new IllegalStateException(); }
	}

	/**
	 * A spliterator for {@code char} values
	 */
	interface OfChar extends PrimitiveSpliterator<Character, OfChar> {
		/**
		 * {@inheritDoc}
		 * 
		 * @return {@inheritDoc}
		 */
		@Override
		OfChar trySplit();

		/**
		 * @see java.util.Spliterator.OfPrimitive#tryAdvance(Object)
		 */
		boolean tryAdvance(PrimitiveConsumer.OfChar action);

		/**
		 * {@inheritDoc}
		 * 
		 * @param action {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		@Override
		default boolean tryAdvance(Consumer<? super java.lang.Character> action) {
			if (action instanceof PrimitiveConsumer.OfChar)
				return tryAdvance((PrimitiveConsumer.OfChar) action);
			else
				return tryAdvance((PrimitiveConsumer.OfChar) action::accept);
		}

		/**
		 * @see java.util.Spliterator.OfPrimitive#forEachRemaining(Object)
		 */
		default void forEachRemaining(PrimitiveConsumer.OfChar action) {
			do {
			} while (tryAdvance(action));
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @param action {@inheritDoc}
		 */
		@Override
		default void forEachRemaining(Consumer<? super java.lang.Character> action) {
			if (action instanceof PrimitiveConsumer.OfChar)
				forEachRemaining((PrimitiveConsumer.OfChar) action);
			else
				forEachRemaining((PrimitiveConsumer.OfChar) action::accept);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @return {@inheritDoc}
		 */
		@Override
		default PrimitiveComparator.OfChar getComparator() { throw new IllegalStateException(); }
	}

	/**
	 * A spliterator for {@code short} values
	 */
	interface OfShort extends PrimitiveSpliterator<Short, OfShort> {
		/**
		 * {@inheritDoc}
		 * 
		 * @return {@inheritDoc}
		 */
		@Override
		OfShort trySplit();

		/**
		 * @see java.util.Spliterator.OfPrimitive#tryAdvance(Object)
		 */
		boolean tryAdvance(PrimitiveConsumer.OfShort action);

		/**
		 * {@inheritDoc}
		 * 
		 * @param action {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		@Override
		default boolean tryAdvance(Consumer<? super java.lang.Short> action) {
			if (action instanceof PrimitiveConsumer.OfShort)
				return tryAdvance((PrimitiveConsumer.OfShort) action);
			else
				return tryAdvance((PrimitiveConsumer.OfShort) action::accept);
		}

		/**
		 * @see java.util.Spliterator.OfPrimitive#forEachRemaining(Object)
		 */
		default void forEachRemaining(PrimitiveConsumer.OfShort action) {
			do {
			} while (tryAdvance(action));
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @param action {@inheritDoc}
		 */
		@Override
		default void forEachRemaining(Consumer<? super java.lang.Short> action) {
			if (action instanceof PrimitiveConsumer.OfShort)
				forEachRemaining((PrimitiveConsumer.OfShort) action);
			else
				forEachRemaining((PrimitiveConsumer.OfShort) action::accept);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @return {@inheritDoc}
		 */
		@Override
		default PrimitiveComparator.OfShort getComparator() { throw new IllegalStateException(); }
	}

	/**
	 * A spliterator for {@code byte} values
	 */
	interface OfByte extends PrimitiveSpliterator<Byte, OfByte> {
		/**
		 * {@inheritDoc}
		 * 
		 * @return {@inheritDoc}
		 */
		@Override
		OfByte trySplit();

		/**
		 * @see java.util.Spliterator.OfPrimitive#tryAdvance(Object)
		 */
		boolean tryAdvance(PrimitiveConsumer.OfByte action);

		/**
		 * {@inheritDoc}
		 * 
		 * @param action {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		@Override
		default boolean tryAdvance(Consumer<? super java.lang.Byte> action) {
			if (action instanceof PrimitiveConsumer.OfByte)
				return tryAdvance((PrimitiveConsumer.OfByte) action);
			else
				return tryAdvance((PrimitiveConsumer.OfByte) action::accept);
		}

		/**
		 * @see java.util.Spliterator.OfPrimitive#forEachRemaining(Object)
		 */
		default void forEachRemaining(PrimitiveConsumer.OfByte action) {
			do {
			} while (tryAdvance(action));
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @param action {@inheritDoc}
		 */
		@Override
		default void forEachRemaining(Consumer<? super java.lang.Byte> action) {
			if (action instanceof PrimitiveConsumer.OfByte)
				forEachRemaining((PrimitiveConsumer.OfByte) action);
			else
				forEachRemaining((PrimitiveConsumer.OfByte) action::accept);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @return {@inheritDoc}
		 */
		@Override
		default PrimitiveComparator.OfByte getComparator() { throw new IllegalStateException(); }
	}

	/**
	 * A spliterator for {@code boolean} values
	 */
	interface OfBoolean extends PrimitiveSpliterator<Boolean, OfBoolean> {
		/**
		 * {@inheritDoc}
		 * 
		 * @return {@inheritDoc}
		 */
		@Override
		OfBoolean trySplit();

		/**
		 * @see java.util.Spliterator.OfPrimitive#tryAdvance(Object)
		 */
		boolean tryAdvance(PrimitiveConsumer.OfBoolean action);

		/**
		 * {@inheritDoc}
		 * 
		 * @param action {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		@Override
		default boolean tryAdvance(Consumer<? super java.lang.Boolean> action) {
			if (action instanceof PrimitiveConsumer.OfBoolean)
				return tryAdvance((PrimitiveConsumer.OfBoolean) action);
			else
				return tryAdvance((PrimitiveConsumer.OfBoolean) action::accept);
		}

		/**
		 * @see java.util.Spliterator.OfPrimitive#forEachRemaining(Object)
		 */
		default void forEachRemaining(PrimitiveConsumer.OfBoolean action) {
			do {
			} while (tryAdvance(action));
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @param action {@inheritDoc}
		 */
		@Override
		default void forEachRemaining(Consumer<? super java.lang.Boolean> action) {
			if (action instanceof PrimitiveConsumer.OfBoolean)
				forEachRemaining((PrimitiveConsumer.OfBoolean) action);
			else
				forEachRemaining((PrimitiveConsumer.OfBoolean) action::accept);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @return {@inheritDoc}
		 */
		@Override
		default PrimitiveComparator.OfBoolean getComparator() { throw new IllegalStateException(); }
	}

	/**
	 * @see OfPrimitive#trySplit()
	 */
	T_SPLITR trySplit();

}
