/**
 * 
 */
package jdk.prim.util;

import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

import jdk.prim.PrimitiveComparator;
import jdk.prim.util.function.PrimitiveConsumer;

/**
 * 
 */
public interface PrimitiveSpliterator<T, T_CONS, T_SPLITR extends Spliterator.OfPrimitive<T, T_CONS, T_SPLITR>>
		extends Spliterator.OfPrimitive<T, T_CONS, T_SPLITR> {

	/**
	 * A spliterator for {@code double} values
	 */
	interface OfDouble
			extends PrimitiveSpliterator<Double, DoubleConsumer, Spliterator.OfDouble>, Spliterator.OfDouble {
		/**
		 * {@inheritDoc}
		 * 
		 * @return {@inheritDoc}
		 */
		@Override
		PrimitiveSpliterator.OfDouble trySplit();

		/**
		 * 
		 * If a remaining element exists: performs the given action on it,
		 * returning {@code true}; else returns {@code false}. If this
		 * Spliterator is {@link #ORDERED} the action is performed on the
		 * next element in encounter order. Exceptions thrown by the
		 * action are relayed to the caller.
		 * <p>
		 * Subsequent behavior of a spliterator is unspecified if the action throws
		 * an exception.
		 *
		 * @param action The action whose operation is performed at-most once
		 * @return {@code false} if no remaining elements existed
		 *         upon entry to this method, else {@code true}.
		 * @throws NullPointerException if the specified action is null
		 */
		boolean tryAdvance(PrimitiveConsumer.OfDouble action);

		/**
		 * {@inheritDoc}
		 * 
		 * @param action {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		@Override
		default boolean tryAdvance(DoubleConsumer action) {
			if (action instanceof PrimitiveConsumer.OfDouble)
				return tryAdvance((PrimitiveConsumer.OfDouble) action);
			else
				return tryAdvance((PrimitiveConsumer.OfDouble) action::accept);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @param action {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		@Override
		default boolean tryAdvance(Consumer<? super java.lang.Double> action) {
			if (action instanceof PrimitiveConsumer.OfDouble)
				return tryAdvance((PrimitiveConsumer.OfDouble) action);
			else
				return tryAdvance((PrimitiveConsumer.OfDouble) action::accept);
		}

		/**
		 * 
		 * Performs the given action for each remaining element, sequentially in
		 * the current thread, until all elements have been processed or the action
		 * throws an exception. If this Spliterator is {@link #ORDERED}, actions
		 * are performed in encounter order. Exceptions thrown by the action
		 * are relayed to the caller.
		 * <p>
		 * Subsequent behavior of a spliterator is unspecified if the action throws
		 * an exception.
		 *
		 * @implSpec
		 *           The default implementation repeatedly invokes {@link #tryAdvance}
		 *           until
		 *           it returns {@code false}. It should be overridden whenever
		 *           possible.
		 *
		 * @param action The action
		 * @throws NullPointerException if the specified action is null
		 */
		default void forEachRemaining(PrimitiveConsumer.OfDouble action) {
			do {
			} while (tryAdvance(action));
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @param action {@inheritDoc}
		 */
		@Override
		default void forEachRemaining(DoubleConsumer action) {
			if (action instanceof PrimitiveConsumer.OfDouble)
				forEachRemaining((PrimitiveConsumer.OfDouble) action);
			else
				forEachRemaining((PrimitiveConsumer.OfDouble) action::accept);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @param action {@inheritDoc}
		 */
		@Override
		default void forEachRemaining(Consumer<? super java.lang.Double> action) {
			if (action instanceof PrimitiveConsumer.OfDouble)
				forEachRemaining((PrimitiveConsumer.OfDouble) action);
			else
				forEachRemaining((PrimitiveConsumer.OfDouble) action::accept);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @return {@inheritDoc}
		 */
		@Override
		PrimitiveComparator.OfDouble getComparator();
	}

	/**
	 * A spliterator for {@code long} values
	 */
	interface OfLong extends PrimitiveSpliterator<Long, LongConsumer, Spliterator.OfLong>, Spliterator.OfLong {
		/**
		 * {@inheritDoc}
		 * 
		 * @return {@inheritDoc}
		 */
		@Override
		PrimitiveSpliterator.OfLong trySplit();

		/**
		 * 
		 * If a remaining element exists: performs the given action on it,
		 * returning {@code true}; else returns {@code false}. If this
		 * Spliterator is {@link #ORDERED} the action is performed on the
		 * next element in encounter order. Exceptions thrown by the
		 * action are relayed to the caller.
		 * <p>
		 * Subsequent behavior of a spliterator is unspecified if the action throws
		 * an exception.
		 *
		 * @param action The action whose operation is performed at-most once
		 * @return {@code false} if no remaining elements existed
		 *         upon entry to this method, else {@code true}.
		 * @throws NullPointerException if the specified action is null
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
		 * 
		 * Performs the given action for each remaining element, sequentially in
		 * the current thread, until all elements have been processed or the action
		 * throws an exception. If this Spliterator is {@link #ORDERED}, actions
		 * are performed in encounter order. Exceptions thrown by the action
		 * are relayed to the caller.
		 * <p>
		 * Subsequent behavior of a spliterator is unspecified if the action throws
		 * an exception.
		 *
		 * @implSpec
		 *           The default implementation repeatedly invokes {@link #tryAdvance}
		 *           until
		 *           it returns {@code false}. It should be overridden whenever
		 *           possible.
		 *
		 * @param action The action
		 * @throws NullPointerException if the specified action is null
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
		PrimitiveComparator.OfLong getComparator();
	}

	/**
	 * A spliterator for {@code int} values
	 */
	interface OfInt extends PrimitiveSpliterator<Integer, IntConsumer, Spliterator.OfInt>, Spliterator.OfInt {
		/**
		 * {@inheritDoc}
		 * 
		 * @return {@inheritDoc}
		 */
		@Override
		PrimitiveSpliterator.OfInt trySplit();

		/**
		 * 
		 * If a remaining element exists: performs the given action on it,
		 * returning {@code true}; else returns {@code false}. If this
		 * Spliterator is {@link #ORDERED} the action is performed on the
		 * next element in encounter order. Exceptions thrown by the
		 * action are relayed to the caller.
		 * <p>
		 * Subsequent behavior of a spliterator is unspecified if the action throws
		 * an exception.
		 *
		 * @param action The action whose operation is performed at-most once
		 * @return {@code false} if no remaining elements existed
		 *         upon entry to this method, else {@code true}.
		 * @throws NullPointerException if the specified action is null
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
		 * 
		 * Performs the given action for each remaining element, sequentially in
		 * the current thread, until all elements have been processed or the action
		 * throws an exception. If this Spliterator is {@link #ORDERED}, actions
		 * are performed in encounter order. Exceptions thrown by the action
		 * are relayed to the caller.
		 * <p>
		 * Subsequent behavior of a spliterator is unspecified if the action throws
		 * an exception.
		 *
		 * @implSpec
		 *           The default implementation repeatedly invokes {@link #tryAdvance}
		 *           until
		 *           it returns {@code false}. It should be overridden whenever
		 *           possible.
		 *
		 * @param action The action
		 * @throws NullPointerException if the specified action is null
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
		PrimitiveComparator.OfInt getComparator();
	}

	/**
	 * A spliterator for {@code float} values
	 */
	interface OfFloat extends PrimitiveSpliterator<Float, PrimitiveConsumer.OfFloat, OfFloat> {
		/**
		 * {@inheritDoc}
		 * 
		 * @return {@inheritDoc}
		 */
		@Override
		OfFloat trySplit();

		/**
		 * {@inheritDoc}
		 * 
		 * @param action {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		@Override
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
		 * {@inheritDoc}
		 * 
		 * @param action {@inheritDoc}
		 */
		@Override
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
		PrimitiveComparator.OfFloat getComparator();
	}

	/**
	 * A spliterator for {@code char} values
	 */
	interface OfChar extends PrimitiveSpliterator<Character, PrimitiveConsumer.OfChar, OfChar> {
		/**
		 * {@inheritDoc}
		 * 
		 * @return {@inheritDoc}
		 */
		@Override
		OfChar trySplit();

		/**
		 * {@inheritDoc}
		 * 
		 * @param action {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		@Override
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
		 * {@inheritDoc}
		 * 
		 * @param action {@inheritDoc}
		 */
		@Override
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
		PrimitiveComparator.OfChar getComparator();
	}

	/**
	 * A spliterator for {@code short} values
	 */
	interface OfShort extends PrimitiveSpliterator<Short, PrimitiveConsumer.OfShort, OfShort> {
		/**
		 * {@inheritDoc}
		 * 
		 * @return {@inheritDoc}
		 */
		@Override
		OfShort trySplit();

		/**
		 * {@inheritDoc}
		 * 
		 * @param action {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		@Override
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
		 * {@inheritDoc}
		 * 
		 * @param action {@inheritDoc}
		 */
		@Override
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
		PrimitiveComparator.OfShort getComparator();
	}

	/**
	 * A spliterator for {@code byte} values
	 */
	interface OfByte extends PrimitiveSpliterator<Byte, PrimitiveConsumer.OfByte, OfByte> {
		/**
		 * {@inheritDoc}
		 * 
		 * @return {@inheritDoc}
		 */
		@Override
		OfByte trySplit();

		/**
		 * {@inheritDoc}
		 * 
		 * @param action {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		@Override
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
		 * {@inheritDoc}
		 * 
		 * @param action {@inheritDoc}
		 */
		@Override
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
		PrimitiveComparator.OfByte getComparator();
	}

	/**
	 * A spliterator for {@code boolean} values
	 */
	interface OfBoolean extends PrimitiveSpliterator<Boolean, PrimitiveConsumer.OfBoolean, OfBoolean> {
		/**
		 * {@inheritDoc}
		 * 
		 * @return {@inheritDoc}
		 */
		@Override
		OfBoolean trySplit();

		/**
		 * {@inheritDoc}
		 * 
		 * @param action {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		@Override
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
		 * {@inheritDoc}
		 * 
		 * @param action {@inheritDoc}
		 */
		@Override
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
		PrimitiveComparator.OfBoolean getComparator();
	}
}
