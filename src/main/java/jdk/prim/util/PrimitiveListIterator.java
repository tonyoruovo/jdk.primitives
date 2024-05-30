/**
 * 
 */
package jdk.prim.util;

import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.PrimitiveIterator;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

import java.util.function.Consumer;

/**
 * {@code PrimitiveListIterator} is an interface that extends both
 * {@code ListIterator} and {@code PrimitiveIterator}, providing bidirectional
 * iteration capabilities for collections. It supports generic types and has
 * specialized versions for primitive types.
 *
 * <h3>Summary</h3> This interface allows traversal of elements in both forward
 * and backward directions. It is designed to be used with collections that
 * require iteration without modification capabilities.
 *
 * <h3>Description</h3> The {@code PrimitiveListIterator} interface defines
 * methods for bidirectional iteration over a collection of elements. It
 * combines the functionality of {@code ListIterator} and
 * {@code PrimitiveIterator}. The interface also provides nested interfaces
 * specialized for primitive types, allowing efficient iteration without boxing
 * overhead.
 *
 * @param <T>      the type of elements returned by this iterator
 * @param <T_CONS> the type of the consumer for the elements
 * @implNote Default implementation does not support modification such as {@link #remove()}, {@link #add} and {@link #set}
 */
public interface PrimitiveListIterator<T, T_CONS> extends ListIterator<T>, PrimitiveIterator<T, T_CONS> {

	/**
	 * {@code OfDouble} is a specialized {@code PrimitiveListIterator} for iterating
	 * over {@code double} values.
	 *
	 * <h3>Examples</h3> Here is an example of how to use
	 * {@code PrimitiveListIterator.OfDouble}:
	 *
	 * <pre>
	 * <code>
	 * 	public class DoubleArrayIterator implements PrimitiveListIterator.OfDouble {
	 * 		private final double[] array;
	 * 		private int cursor;
	 *
	 * 		public DoubleArrayIterator(double[] array) {
	 * 			this.array = array;
	 * 			this.cursor = 0;
	 * 		}
	 *
	 * 		&#64;Override
	 * 		public boolean hasNext() {
	 * 			return cursor < array.length;
	 * 		}
	 *
	 * 		&#64;Override
	 * 		public double nextDouble() {
	 * 			if (!hasNext()) {
	 * 				throw new NoSuchElementException();
	 * 			}
	 * 			return array[cursor++];
	 * 		}
	 *
	 * 		&#64;Override
	 * 		public boolean hasPrevious() {
	 * 			return cursor > 0;
	 * 		}
	 *
	 * 		&#64;Override
	 * 		public double previousDouble() {
	 * 			if (!hasPrevious()) {
	 * 				throw new NoSuchElementException();
	 * 			}
	 * 			return array[--cursor];
	 * 		}
	 *
	 * 		&#64;Override
	 * 		public int nextIndex() {
	 * 			return cursor;
	 * 		}
	 *
	 * 		&#64;Override
	 * 		public int previousIndex() {
	 * 			return cursor - 1;
	 * 		}
	 * 	}
	 * </code>
	 * </pre>
	 * 
	 * @apiNote Calling {@link #nextDouble()} and then {@link #previousDouble()}
	 *          consecutively will return the same value, as will calling
	 *          {@link #previousDouble()} and then {@link #nextDouble()}
	 *          consecutively.
	 * @implNote The use of {@link #nextDouble()} is preferred over the use of
	 *           {@link #next()} because {@link #next()} is implemented by calling
	 *           and casting {@link #nextDouble()}.
	 * @implNote Default implementation does not support modification such as {@link #remove()}, {@link #add} and {@link #set}
	 */
	public static interface OfDouble extends PrimitiveListIterator<Double, DoubleConsumer> {

		/**
		 * Returns the next {@code double} element in the iteration.
		 *
		 * @return the next {@code double} element
		 * @throws NoSuchElementException if the iteration has no more elements
		 */
		double nextDouble() throws NoSuchElementException;

		/**
		 * Returns the next {@code Double} element in the iteration. This method wraps
		 * {@link #nextDouble()}.
		 *
		 * @return the next {@code Double} element
		 * @throws NoSuchElementException if the iteration has no more elements
		 */
		@Override
		default Double next() throws NoSuchElementException {
			return nextDouble();
		}

		/**
		 * Returns the previous {@code double} element in the iteration.
		 *
		 * @return the previous {@code double} element
		 * @throws NoSuchElementException if the iteration has no previous elements
		 */
		double previousDouble() throws NoSuchElementException;

		/**
		 * Returns the previous {@code Double} element in the iteration. This method
		 * wraps {@link #previousDouble()}.
		 *
		 * @return the previous {@code Double} element
		 * @throws NoSuchElementException if the iteration has no previous elements
		 */
		@Override
		default Double previous() throws NoSuchElementException {
			return previousDouble();
		}

		/**
		 * Performs the given action for each remaining element until all elements have
		 * been processed or the action throws an exception.
		 *
		 * @param action the action to be performed for each element
		 */
		default void forEachRemaining(DoubleConsumer action) {
			Objects.requireNonNull(action);
			while (hasNext()) {
				action.accept(nextDouble());
			}
		}

		/**
		 * Performs the given action for each remaining element until all elements have
		 * been processed or the action throws an exception.
		 *
		 * @param action the action to be performed for each element
		 */
		@Override
		default void forEachRemaining(Consumer<? super Double> action) {
			if (action instanceof DoubleConsumer) {
				forEachRemaining((DoubleConsumer) action);
				return;
			}
			Objects.requireNonNull(action);
			forEachRemaining((DoubleConsumer) action::accept);
		}

	}

	/**
	 * {@code OfLong} is a specialized {@code PrimitiveListIterator} for iterating
	 * over {@code long} values.
	 * 
	 * @apiNote Calling {@link #nextLong()} and then {@link #previousLong()}
	 *          consecutively will return the same value, as will calling
	 *          {@link #previousLong()} and then {@link #nextLong()} consecutively.
	 * @implNote The use of {@link #nextLong()} is preferred over the use of
	 *           {@link #next()} because {@link #next()} is implemented by calling
	 *           and casting {@link #nextLong()}.
	 * @implNote Default implementation does not support modification such as {@link #remove()}, {@link #add} and {@link #set}
	 */
	public static interface OfLong extends PrimitiveListIterator<Long, LongConsumer> {

		/**
		 * Returns the next {@code long} element in the iteration.
		 *
		 * @return the next {@code long} element
		 * @throws NoSuchElementException if the iteration has no more elements
		 */
		long nextLong() throws NoSuchElementException;

		/**
		 * Returns the next {@code Long} element in the iteration. This method wraps
		 * {@link #nextLong()}.
		 *
		 * @return the next {@code Long} element
		 * @throws NoSuchElementException if the iteration has no more elements
		 */
		@Override
		default Long next() throws NoSuchElementException {
			return nextLong();
		}

		/**
		 * Returns the previous {@code long} element in the iteration.
		 *
		 * @return the previous {@code long} element
		 * @throws NoSuchElementException if the iteration has no previous elements
		 */
		long previousLong() throws NoSuchElementException;

		/**
		 * Returns the previous {@code Long} element in the iteration. This method wraps
		 * {@link #previousLong()}.
		 *
		 * @return the previous {@code Long} element
		 * @throws NoSuchElementException if the iteration has no previous elements
		 */
		@Override
		default Long previous() throws NoSuchElementException {
			return previousLong();
		}

		/**
		 * Performs the given action for each remaining element until all elements have
		 * been processed or the action throws an exception.
		 *
		 * @param action the action to be performed for each element
		 */
		default void forEachRemaining(LongConsumer action) {
			Objects.requireNonNull(action);
			while (hasNext()) {
				action.accept(nextLong());
			}
		}

		/**
		 * Performs the given action for each remaining element until all elements have
		 * been processed or the action throws an exception.
		 *
		 * @param action the action to be performed for each element
		 */
		@Override
		default void forEachRemaining(Consumer<? super Long> action) {
			if (action instanceof LongConsumer) {
				forEachRemaining((LongConsumer) action);
				return;
			}
			Objects.requireNonNull(action);
			forEachRemaining((LongConsumer) action::accept);
		}

	}

	/**
	 * {@code OfInt} is a specialized {@code PrimitiveListIterator} for iterating
	 * over {@code int} values.
	 * 
	 * @apiNote Calling {@link #nextInt()} and then {@link #previousInt()}
	 *          consecutively will return the same value, as will calling
	 *          {@link #previousInt()} and then {@link #nextInt()} consecutively.
	 * @implNote The use of {@link #nextInt()} is preferred over the use of
	 *           {@link #next()} because {@link #next()} is implemented by calling
	 *           and casting {@link #nextInt()}.
	 * @implNote Default implementation does not support modification such as {@link #remove()}, {@link #add} and {@link #set}
	 */
	public static interface OfInt extends PrimitiveListIterator<Integer, IntConsumer> {

		/**
		 * Returns the next {@code int} element in the iteration.
		 *
		 * @return the next {@code int} element
		 * @throws NoSuchElementException if the iteration has no more elements
		 */
		int nextInt() throws NoSuchElementException;

		/**
		 * Returns the next {@code Integer} element in the iteration. This method wraps
		 * {@link #nextInt()}.
		 *
		 * @return the next {@code Integer} element
		 * @throws NoSuchElementException if the iteration has no more elements
		 */
		@Override
		default Integer next() throws NoSuchElementException {
			return nextInt();
		}

		/**
		 * Returns the previous {@code int} element in the iteration.
		 *
		 * @return the previous {@code int} element
		 * @throws NoSuchElementException if the iteration has no previous elements
		 */
		int previousInt() throws NoSuchElementException;

		/**
		 * Returns the previous {@code Integer} element in the iteration. This method
		 * wraps {@link #previousInt()}.
		 *
		 * @return the previous {@code Integer} element
		 * @throws NoSuchElementException if the iteration has no previous elements
		 */
		@Override
		default Integer previous() throws NoSuchElementException {
			return previousInt();
		}

		/**
		 * Performs the given action for each remaining element until all elements have
		 * been processed or the action throws an exception.
		 *
		 * @param action the action to be performed for each element
		 */
		default void forEachRemaining(IntConsumer action) {
			Objects.requireNonNull(action);
			while (hasNext()) {
				action.accept(nextInt());
			}
		}

		/**
		 * Performs the given action for each remaining element until all elements have
		 * been processed or the action throws an exception.
		 *
		 * @param action the action to be performed for each element
		 */
		@Override
		default void forEachRemaining(Consumer<? super Integer> action) {
			if (action instanceof IntConsumer) {
				forEachRemaining((IntConsumer) action);
				return;
			}
			Objects.requireNonNull(action);
			forEachRemaining((IntConsumer) action::accept);
		}

	}

	/**
	 * {@code OfChar} is a specialized {@code PrimitiveListIterator} for iterating
	 * over {@code char} values.
	 * 
	 * @apiNote Calling {@link #nextChar()} and then {@link #previousChar()}
	 *          consecutively will return the same value, as will calling
	 *          {@link #previousChar()} and then {@link #nextChar()} consecutively.
	 * @implNote The use of {@link #nextChar()} is preferred over the use of
	 *           {@link #next()} because {@link #next()} is implemented by calling
	 *           and casting {@link #nextChar()}.
	 * @implNote Default implementation does not support modification such as {@link #remove()}, {@link #add} and {@link #set}
	 */
	public static interface OfChar
			extends PrimitiveListIterator<Character, jdk.prim.util.function.Char.Consumer> {

		/**
		 * Returns the next {@code char} element in the iteration.
		 *
		 * @return the next {@code char} element
		 * @throws NoSuchElementException if the iteration has no more elements
		 */
		char nextChar() throws NoSuchElementException;

		/**
		 * Returns the next {@code Character} element in the iteration. This method
		 * wraps {@link #nextChar()}.
		 *
		 * @return the next {@code Character} element
		 * @throws NoSuchElementException if the iteration has no more elements
		 */
		@Override
		default Character next() throws NoSuchElementException {
			return nextChar();
		}

		/**
		 * Returns the previous {@code char} element in the iteration.
		 *
		 * @return the previous {@code char} element
		 * @throws NoSuchElementException if the iteration has no previous elements
		 */
		char previousChar() throws NoSuchElementException;

		/**
		 * Returns the previous {@code Character} element in the iteration. This method
		 * wraps {@link #previousChar()}.
		 *
		 * @return the previous {@code Character} element
		 * @throws NoSuchElementException if the iteration has no previous elements
		 */
		@Override
		default Character previous() throws NoSuchElementException {
			return previousChar();
		}

		/**
		 * Performs the given action for each remaining element until all elements have
		 * been processed or the action throws an exception.
		 *
		 * @param action the action to be performed for each element
		 */
		default void forEachRemaining(jdk.prim.util.function.Char.Consumer action) {
			Objects.requireNonNull(action);
			while (hasNext()) {
				action.accept(nextChar());
			}
		}

		/**
		 * Performs the given action for each remaining element until all elements have
		 * been processed or the action throws an exception.
		 *
		 * @param action the action to be performed for each element
		 */
		@Override
		default void forEachRemaining(Consumer<? super Character> action) {
			if (action instanceof jdk.prim.util.function.Char.Consumer) {
				forEachRemaining((jdk.prim.util.function.Char.Consumer) action);
				return;
			}
			Objects.requireNonNull(action);
			forEachRemaining((jdk.prim.util.function.Char.Consumer) action::accept);
		}

	}

	/**
	 * {@code OfFloat} is a specialized {@code PrimitiveListIterator} for iterating
	 * over {@code float} values.
	 * 
	 * @apiNote Calling {@link #nextFloat()} and then {@link #previousFloat()}
	 *          consecutively will return the same value, as will calling
	 *          {@link #previousFloat()} and then {@link #nextFloat()}
	 *          consecutively.
	 * @implNote The use of {@link #nextFloat()} is preferred over the use of
	 *           {@link #next()} because {@link #next()} is implemented by calling
	 *           and casting {@link #nextFloat()}.
	 * @implNote Default implementation does not support modification such as {@link #remove()}, {@link #add} and {@link #set}
	 */
	public static interface OfFloat
			extends PrimitiveListIterator<Float, jdk.prim.util.function.Float.Consumer> {

		/**
		 * Returns the next {@code float} element in the iteration.
		 *
		 * @return the next {@code float} element
		 * @throws NoSuchElementException if the iteration has no more elements
		 */
		float nextFloat() throws NoSuchElementException;

		/**
		 * Returns the next {@code Float} element in the iteration. This method wraps
		 * {@link #nextFloat()}.
		 *
		 * @return the next {@code Float} element
		 * @throws NoSuchElementException if the iteration has no more elements
		 */
		@Override
		default Float next() throws NoSuchElementException {
			return nextFloat();
		}

		/**
		 * Returns the previous {@code float} element in the iteration.
		 *
		 * @return the previous {@code float} element
		 * @throws NoSuchElementException if the iteration has no previous elements
		 */
		float previousFloat() throws NoSuchElementException;

		/**
		 * Returns the previous {@code Float} element in the iteration. This method
		 * wraps {@link #previousFloat()}.
		 *
		 * @return the previous {@code Float} element
		 * @throws NoSuchElementException if the iteration has no previous elements
		 */
		@Override
		default Float previous() throws NoSuchElementException {
			return previousFloat();
		}

		/**
		 * Performs the given action for each remaining element until all elements have
		 * been processed or the action throws an exception.
		 *
		 * @param action the action to be performed for each element
		 */
		default void forEachRemaining(jdk.prim.util.function.Float.Consumer action) {
			Objects.requireNonNull(action);
			while (hasNext()) {
				action.accept(nextFloat());
			}
		}

		/**
		 * Performs the given action for each remaining element until all elements have
		 * been processed or the action throws an exception.
		 *
		 * @param action the action to be performed for each element
		 */
		@Override
		default void forEachRemaining(Consumer<? super Float> action) {
			if (action instanceof jdk.prim.util.function.Float.Consumer) {
				forEachRemaining((jdk.prim.util.function.Float.Consumer) action);
				return;
			}
			Objects.requireNonNull(action);
			forEachRemaining((jdk.prim.util.function.Float.Consumer) action::accept);
		}

	}

	/**
	 * {@code OfShort} is a specialized {@code PrimitiveListIterator} for iterating
	 * over {@code short} values.
	 * 
	 * @apiNote Calling {@link #nextShort()} and then {@link #previousShort()}
	 *          consecutively will return the same value, as will calling
	 *          {@link #previousShort()} and then {@link #nextShort()}
	 *          consecutively.
	 * @implNote The use of {@link #nextShort()} is preferred over the use of
	 *           {@link #next()} because {@link #next()} is implemented by calling
	 *           and casting {@link #nextShort()}.
	 * @implNote Default implementation does not support modification such as {@link #remove()}, {@link #add} and {@link #set}
	 */
	public static interface OfShort
			extends PrimitiveListIterator<Short, jdk.prim.util.function.Short.Consumer> {

		/**
		 * Returns the next {@code short} element in the iteration.
		 *
		 * @return the next {@code short} element
		 * @throws NoSuchElementException if the iteration has no more elements
		 */
		short nextShort() throws NoSuchElementException;

		/**
		 * Returns the next {@code Short} element in the iteration. This method wraps
		 * {@link #nextShort()}.
		 *
		 * @return the next {@code Short} element
		 * @throws NoSuchElementException if the iteration has no more elements
		 */
		@Override
		default Short next() throws NoSuchElementException {
			return nextShort();
		}

		/**
		 * Returns the previous {@code short} element in the iteration.
		 *
		 * @return the previous {@code short} element
		 * @throws NoSuchElementException if the iteration has no previous elements
		 */
		short previousShort() throws NoSuchElementException;

		/**
		 * Returns the previous {@code Short} element in the iteration. This method
		 * wraps {@link #previousShort()}.
		 *
		 * @return the previous {@code Short} element
		 * @throws NoSuchElementException if the iteration has no previous elements
		 */
		@Override
		default Short previous() throws NoSuchElementException {
			return previousShort();
		}

		/**
		 * Performs the given action for each remaining element until all elements have
		 * been processed or the action throws an exception.
		 *
		 * @param action the action to be performed for each element
		 */
		default void forEachRemaining(jdk.prim.util.function.Short.Consumer action) {
			Objects.requireNonNull(action);
			while (hasNext()) {
				action.accept(nextShort());
			}
		}

		/**
		 * Performs the given action for each remaining element until all elements have
		 * been processed or the action throws an exception.
		 *
		 * @param action the action to be performed for each element
		 */
		@Override
		default void forEachRemaining(Consumer<? super Short> action) {
			if (action instanceof jdk.prim.util.function.Short.Consumer) {
				forEachRemaining((jdk.prim.util.function.Short.Consumer) action);
				return;
			}
			Objects.requireNonNull(action);
			forEachRemaining((jdk.prim.util.function.Short.Consumer) action::accept);
		}

	}

	/**
	 * {@code OfByte} is a specialized {@code PrimitiveListIterator} for iterating
	 * over {@code byte} values.
	 * 
	 * @apiNote Calling {@link #nextByte()} and then {@link #previousByte()}
	 *          consecutively will return the same value, as will calling
	 *          {@link #previousByte()} and then {@link #nextByte()} consecutively.
	 * @implNote The use of {@link #nextByte()} is preferred over the use of
	 *           {@link #next()} because {@link #next()} is implemented by calling
	 *           and casting {@link #nextByte()}.
	 * @implNote Default implementation does not support modification such as {@link #remove()}, {@link #add} and {@link #set}
	 */
	public static interface OfByte
			extends PrimitiveListIterator<Byte, jdk.prim.util.function.Byte.Consumer> {

		/**
		 * Returns the next {@code byte} element in the iteration.
		 *
		 * @return the next {@code byte} element
		 * @throws NoSuchElementException if the iteration has no more elements
		 */
		byte nextByte() throws NoSuchElementException;

		/**
		 * Returns the next {@code Byte} element in the iteration. This method wraps
		 * {@link #nextByte()}.
		 *
		 * @return the next {@code Byte} element
		 * @throws NoSuchElementException if the iteration has no more elements
		 */
		@Override
		default Byte next() throws NoSuchElementException {
			return nextByte();
		}

		/**
		 * Returns the previous {@code byte} element in the iteration.
		 *
		 * @return the previous {@code byte} element
		 * @throws NoSuchElementException if the iteration has no previous elements
		 */
		byte previousByte() throws NoSuchElementException;

		/**
		 * Returns the previous {@code Byte} element in the iteration. This method wraps
		 * {@link #previousByte()}.
		 *
		 * @return the previous {@code Byte} element
		 * @throws NoSuchElementException if the iteration has no previous elements
		 */
		@Override
		default Byte previous() throws NoSuchElementException {
			return previousByte();
		}

		/**
		 * Performs the given action for each remaining element until all elements have
		 * been processed or the action throws an exception.
		 *
		 * @param action the action to be performed for each element
		 */
		default void forEachRemaining(jdk.prim.util.function.Byte.Consumer action) {
			Objects.requireNonNull(action);
			while (hasNext()) {
				action.accept(nextByte());
			}
		}

		/**
		 * Performs the given action for each remaining element until all elements have
		 * been processed or the action throws an exception.
		 *
		 * @param action the action to be performed for each element
		 */
		@Override
		default void forEachRemaining(Consumer<? super Byte> action) {
			if (action instanceof jdk.prim.util.function.Byte.Consumer) {
				forEachRemaining((jdk.prim.util.function.Byte.Consumer) action);
				return;
			}
			Objects.requireNonNull(action);
			forEachRemaining((jdk.prim.util.function.Byte.Consumer) action::accept);
		}

	}

	/**
	 * {@code OfBoolean} is a specialized {@code PrimitiveListIterator} for
	 * iterating over {@code boolean} values.
	 * 
	 * @apiNote Calling {@link #nextBoolean()} and then {@link #previousBoolean()}
	 *          consecutively will return the same value, as will calling
	 *          {@link #previousBoolean()} and then {@link #nextBoolean()}
	 *          consecutively.
	 * @implNote The use of {@link #nextBoolean()} is preferred over the use of
	 *           {@link #next()} because {@link #next()} is implemented by calling
	 *           and casting {@link #nextBoolean()}.
	 * @implNote Default implementation does not support modification such as {@link #remove()}, {@link #add} and {@link #set}
	 */
	public static interface OfBoolean
			extends PrimitiveListIterator<Boolean, jdk.prim.util.function.Boolean.Consumer> {

		/**
		 * Returns the next {@code boolean} element in the iteration.
		 *
		 * @return the next {@code boolean} element
		 * @throws NoSuchElementException if the iteration has no more elements
		 */
		boolean nextBoolean() throws NoSuchElementException;

		/**
		 * Returns the next {@code Boolean} element in the iteration. This method wraps
		 * {@link #nextBoolean()}.
		 *
		 * @return the next {@code Boolean} element
		 * @throws NoSuchElementException if the iteration has no more elements
		 */
		@Override
		default Boolean next() throws NoSuchElementException {
			return nextBoolean();
		}

		/**
		 * Returns the previous {@code boolean} element in the iteration.
		 *
		 * @return the previous {@code boolean} element
		 * @throws NoSuchElementException if the iteration has no previous elements
		 */
		boolean previousBoolean() throws NoSuchElementException;

		/**
		 * Returns the previous {@code Boolean} element in the iteration. This method
		 * wraps {@link #previousBoolean()}.
		 *
		 * @return the previous {@code Boolean} element
		 * @throws NoSuchElementException if the iteration has no previous elements
		 */
		@Override
		default Boolean previous() throws NoSuchElementException {
			return previousBoolean();
		}

		/**
		 * Performs the given action for each remaining element until all elements have
		 * been processed or the action throws an exception.
		 *
		 * @param action the action to be performed for each element
		 */
		default void forEachRemaining(jdk.prim.util.function.Boolean.Consumer action) {
			Objects.requireNonNull(action);
			while (hasNext()) {
				action.accept(nextBoolean());
			}
		}

		/**
		 * Performs the given action for each remaining element until all elements have
		 * been processed or the action throws an exception.
		 *
		 * @param action the action to be performed for each element
		 */
		@Override
		default void forEachRemaining(Consumer<? super Boolean> action) {
			if (action instanceof jdk.prim.util.function.Boolean.Consumer) {
				forEachRemaining((jdk.prim.util.function.Boolean.Consumer) action);
				return;
			}
			Objects.requireNonNull(action);
			forEachRemaining((jdk.prim.util.function.Boolean.Consumer) action::accept);
		}

	}

	/**
	 * Throws {@code UnsupportedOperationException} indicating that the add
	 * operation is not supported.
	 *
	 * @param e the element to add
	 * @throws UnsupportedOperationException always
	 */
	@Override
	default void add(T e) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("add");
	}

	/**
	 * Throws {@code UnsupportedOperationException} indicating that the set
	 * operation is not supported.
	 *
	 * @param e the element to set
	 * @throws UnsupportedOperationException always
	 */
	@Override
	default void set(T e) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("set");
	}

	/**
	 * Throws {@code UnsupportedOperationException} indicating that the remove
	 * operation is not supported.
	 *
	 * @throws UnsupportedOperationException always
	 */
	@Override
	default void remove() throws UnsupportedOperationException {
		throw new UnsupportedOperationException("remove");
	}
}