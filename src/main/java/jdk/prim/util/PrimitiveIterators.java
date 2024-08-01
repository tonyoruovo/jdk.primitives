/**
 * 
 */
package jdk.prim.util;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import jdk.prim.util.function.PrimitiveFunction;
import jdk.prim.util.function.PrimitivePredicate;

/**
 * This utility class provides various utility methods for working with
 * iterators, especially for handling primitive types efficiently. It contains
 * interfaces and implementations for iterators specialized for primitive types,
 * as well as methods for creating cyclic iterators and iterator instances for
 * primitive arrays and generic collections.
 * <p>
 * All methods expect non-null values, that contains at least one item.
 * 
 * @apiNote In the future I intend to implement the following
 *          <code>PrimitiveIterators</code>:
 *          <ul>
 *          <li>ConsumerIterator with the {@code PrimitiveIterators.consumer(int[] data)}
 *          and {@code PrimitiveIterators.asConsumer(PrimitiveIterator.OfInt iterator)}
 *          static methods. This {@code Iterator} will always call
 *          {@link Iterator#remove()} after every call. if the call throws an
 *          Exception, that exception is caught and the user never sees it.</li>
 *          <li>{@code Examiner} an iterator that supports examining an
 *          accessing an element without advancing the cursor
 *          </li>
 *          <li>PartitionedIterator with {@code PrimitiveIterators.partition(int[] data)}
 *          which will return an Iterator of IntList where each of the list
 *          contains equal int elements.</li>
 *          </ul>
 */
public final class PrimitiveIterators {

	/*
	 * Date created: 16 May 2024 Time created: 11:07:33
	 */
	/**
	 * Creates an {@code Iterator} for a {@code boolean} array.
	 *
	 * @param data the {@code boolean} array to iterate over
	 * @return an {@code Iterator} for the specified {@code boolean} array
	 */
	public static PrimitiveIterator.OfBoolean i(boolean[] data) {
		return new PrimitiveIterator.OfBoolean() {
			int cursor = 0;

			@Override
			public boolean hasNext() {
				return cursor < data.length;
			}

			@Override
			public boolean nextBoolean() {
				try {
					return data[cursor++];
				} catch (IndexOutOfBoundsException e) {
					throw new NoSuchElementException("No more elements in this iterator", e);
				}
			}
		};
	}

	/*
	 * Date created: 16 May 2024 Time created: 11:07:33
	 */
	/**
	 * Creates an {@code Iterator} for a {@code byte} array.
	 *
	 * @param data the {@code byte} array to iterate over
	 * @return an {@code Iterator} for the specified {@code byte} array
	 */
	public static PrimitiveIterator.OfByte i(byte[] data) {
		return new PrimitiveIterator.OfByte() {
			int cursor = 0;

			@Override
			public boolean hasNext() {
				return cursor < data.length;
			}

			@Override
			public byte nextByte() {
				try {
					return data[cursor++];
				} catch (IndexOutOfBoundsException e) {
					throw new NoSuchElementException("No more elements in this iterator", e);
				}
			}
		};
	}

	/*
	 * Date created: 16 May 2024 Time created: 11:07:33
	 */
	/**
	 * Creates an {@code Iterator} for a {@code short} array.
	 *
	 * @param data the {@code short} array to iterate over
	 * @return an {@code Iterator} for the specified {@code short} array
	 */
	public static PrimitiveIterator.OfShort i(short[] data) {
		return new PrimitiveIterator.OfShort() {
			int cursor = 0;

			@Override
			public boolean hasNext() {
				return cursor < data.length;
			}

			@Override
			public short nextShort() {
				try {
					return data[cursor++];
				} catch (IndexOutOfBoundsException e) {
					throw new NoSuchElementException("No more elements in this iterator", e);
				}
			}
		};
	}

	/*
	 * Date created: 16 May 2024 Time created: 11:07:33
	 */
	/**
	 * Creates an {@code Iterator} for a {@code float} array.
	 *
	 * @param data the {@code float} array to iterate over
	 * @return an {@code Iterator} for the specified {@code float} array
	 */
	public static PrimitiveIterator.OfFloat i(float[] data) {
		return new PrimitiveIterator.OfFloat() {
			int cursor = 0;

			@Override
			public boolean hasNext() {
				return cursor < data.length;
			}

			@Override
			public float nextFloat() {
				try {
					return data[cursor++];
				} catch (IndexOutOfBoundsException e) {
					throw new NoSuchElementException("No more elements in this iterator", e);
				}
			}
		};
	}

	/*
	 * Date created: 16 May 2024 Time created: 11:07:33
	 */
	/**
	 * Creates an {@code Iterator} for a {@code char} array.
	 *
	 * @param data the {@code char} array to iterate over
	 * @return an {@code Iterator} for the specified {@code char} array
	 */
	public static PrimitiveIterator.OfChar i(char[] data) {
		return new PrimitiveIterator.OfChar() {
			int cursor = 0;

			@Override
			public boolean hasNext() {
				return cursor < data.length;
			}

			@Override
			public char nextChar() {
				try {
					return data[cursor++];
				} catch (IndexOutOfBoundsException e) {
					throw new NoSuchElementException("No more elements in this iterator", e);
				}
			}
		};
	}

	/*
	 * Date created: 16 May 2024 Time created: 11:07:33
	 */
	/**
	 * Creates an {@code Iterator} for an {@code int} array.
	 *
	 * @param data the {@code int} array to iterate over
	 * @return an {@code Iterator} for the specified {@code int} array
	 */
	public static PrimitiveIterator.OfInt i(int[] data) {
		return new PrimitiveIterator.OfInt() {
			int cursor = 0;

			@Override
			public boolean hasNext() {
				return cursor < data.length;
			}

			@Override
			public int nextInt() {
				try {
					return data[cursor++];
				} catch (IndexOutOfBoundsException e) {
					throw new NoSuchElementException("No more elements in this iterator", e);
				}
			}
		};
	}

	/*
	 * Date created: 16 May 2024 Time created: 11:07:33
	 */
	/**
	 * Creates an {@code Iterator} for a {@code long} array.
	 *
	 * @param data the {@code long} array to iterate over
	 * @return an {@code Iterator} for the specified {@code long} array
	 */
	public static PrimitiveIterator.OfLong i(long[] data) {
		return new PrimitiveIterator.OfLong() {
			int cursor = 0;

			@Override
			public boolean hasNext() {
				return cursor < data.length;
			}

			@Override
			public long nextLong() {
				try {
					return data[cursor++];
				} catch (IndexOutOfBoundsException e) {
					throw new NoSuchElementException("No more elements in this iterator", e);
				}
			}
		};
	}

	/*
	 * Date created: 16 May 2024 Time created: 11:07:33
	 */
	/**
	 * Creates an {@code Iterator} for a {@code double} array.
	 *
	 * @param data the {@code double} array to iterate over
	 * @return an {@code Iterator} for the specified {@code double} array
	 */
	public static PrimitiveIterator.OfDouble i(double[] data) {
		return new PrimitiveIterator.OfDouble() {
			int cursor = 0;

			@Override
			public boolean hasNext() {
				return cursor < data.length;
			}

			@Override
			public double nextDouble() {
				try {
					return data[cursor++];
				} catch (IndexOutOfBoundsException e) {
					throw new NoSuchElementException("No more elements in this iterator", e);
				}
			}
		};
	}

	/*
	 * Date created: 16 May 2024 Time created: 11:07:33
	 */
	/**
	 * Creates an {@code Iterator} for an array of type {@code <T>}
	 *
	 * @param <T>  the type of the elements of this array
	 * @param data the array to iterate over
	 * @return an {@code Iterator} for the specified array
	 */
	public static <T> Iterator<T> i(T[] collection) {
		return new Iterator<>() {
			int cursor = 0;

			@Override
			public boolean hasNext() {
				return cursor < collection.length;
			}

			@Override
			public T next() throws NoSuchElementException {
				try {
					return collection[cursor++];
				} catch (IndexOutOfBoundsException e) {
					throw new NoSuchElementException("Iterator has no more Elements", e);
				}
			}
		};
	}

	/**
	 * Converts an iterator provided by the supplier into a cyclic iterator.
	 * 
	 * <p>
	 * This method converts the iterator returned by the supplier into a cyclic
	 * iterator, enabling cyclic iteration over the elements provided by the
	 * iterator.
	 * </p>
	 * 
	 * <p>
	 * <b>Note:</b> The provided iterator must have at least one element or a
	 * {@code NoSuchElementException} will be thrown when
	 * {@link PrimitiveCyclicIterator#next()} is called and the producer itself must be a
	 * pure function, ensuring that it returns a new iterator instance each time it
	 * is invoked or a {@code NoSuchElementException} will be thrown when
	 * {@link PrimitiveCyclicIterator#next()} is called.
	 * 
	 * <h4>Example Usage:</h4>
	 * 
	 * <pre>
	 * <code>
	 * // Define a list of integers
	 * List&lt;Integer> list = Arrays.asList(1, 2, 3, 4, 5);
	 * 
	 * // Create a supplier function to produce iterators from the list
	 * Supplier&lt;Iterator&lt;Integer>> producer = () -> list.iterator();
	 * 
	 * // Convert the iterator from the supplier into a cyclic iterator
	 * PrimitiveCyclicIterator&lt;Integer> cyclicIterator = PrimitiveIterators.asCyclic(producer);
	 * 
	 * // Use the cyclic iterator to iterate over the elements in a continuous loop
	 * while (true) {
	 *     Integer element = cyclicIterator.next();
	 *     System.out.println("Next Element: " + element);
	 * }
	 * </code>
	 * </pre>
	 * 
	 * <p>
	 * In this example, the {@code asCyclic} method is used to convert an iterator
	 * produced by the supplier into a cyclic iterator, allowing continuous
	 * iteration over the elements of the iterator.
	 * </p>
	 * 
	 * @param producer a supplier function that produces an iterator. An infinite
	 *                 {@code Iterator} can never be cycled.
	 * @param <T>      the type of elements in the iterator
	 * @return a cyclic iterator generated from the provided iterator
	 */
	public static <T> PrimitiveCyclicIterator<T> asCyclic(Supplier<? extends Iterator<? extends T>> producer) {
		return new PrimitiveCyclicIterator<>() {
			int rev = 0;// revolutions
			Iterator<? extends T> doppleganger = producer.get();

			@Override
			public T next() throws NoSuchElementException {
				T next = doppleganger.next();
				if (!doppleganger.hasNext()) {
					doppleganger = producer.get();
					rev++;
				}
				return next;
			}

			@Override
			public int getRevolutions() {
				return rev > -1 ? rev : Integer.MAX_VALUE;
			}
		};
	}

	/*
	 * Date created: 16 May 2024 Time created: 11:12:31
	 */
	/**
	 * Creates a {@code PrimitiveCyclicIterator} for a generic collection.
	 *
	 * @param <T>        the type of elements in the collection
	 * @param collection the collection to iterate over cyclically
	 * @return a cyclic iterator for the specified collection
	 */
	public static <T> PrimitiveCyclicIterator<T> c(Iterable<? extends T> collection) {
		return new PrimitiveCyclicIterator<>() {
			int rev = 0;// revolutions
			Iterator<? extends T> doppleganger = collection.iterator();

			@Override
			public T next() throws NoSuchElementException {
				T next = doppleganger.next();
				if (!doppleganger.hasNext()) {
					doppleganger = collection.iterator();
					rev++;
				}
				return next;
			}

			@Override
			public int getRevolutions() {
				return rev > -1 ? rev : Integer.MAX_VALUE;
			}
		};
	}

	/*
	 * Date created: 16 May 2024 Time created: 11:12:31
	 */
	/**
	 * Creates a {@code PrimitiveCyclicIterator} for a generic array.
	 *
	 * @param <T>        the type of elements in the array
	 * @param collection the array to iterate over cyclically
	 * @return a {@code PrimitiveCyclicIterator} for the specified array
	 */
	public static <T> PrimitiveCyclicIterator<T> c(T[] collection) {
		return new PrimitiveCyclicIterator<>() {
			int rev = 0;// revolutions
			Iterator<T> doppleganger = i(collection);

			@Override
			public T next() throws NoSuchElementException {
				T next = doppleganger.next();
				if (!doppleganger.hasNext()) {
					doppleganger = i(collection);
					rev++;
				}
				return next;
			}

			@Override
			public int getRevolutions() {
				return rev > -1 ? rev : Integer.MAX_VALUE;
			}
		};
	}

	/*
	 * Date created: 16 May 2024 Time created: 11:12:31
	 */
	/**
	 * Creates a {@code PrimitiveCyclicIterator.OfDouble} for a {@code double} array.
	 *
	 * @param data the {@code double} array to iterate over cyclically
	 * @return a {@code PrimitiveCyclicIterator.OfDouble} for the specified array
	 */
	public static PrimitiveCyclicIterator.OfDouble c(double[] data) {
		return new PrimitiveCyclicIterator.OfDouble() {
			int rev = 0;// revolutions
			PrimitiveIterator.OfDouble doppleganger = i(data);

			@Override
			public int getRevolutions() {
				return rev > -1 ? rev : Integer.MAX_VALUE;
			}

			@Override
			public double nextDouble() {
				double next = doppleganger.next();
				if (!doppleganger.hasNext()) {
					doppleganger = i(data);
					rev++;
				}
				return next;
			}
		};
	}

	/*
	 * Date created: 16 May 2024 Time created: 11:12:31
	 */
	/**
	 * Creates a {@code PrimitiveCyclicIterator.OfLong} for a {@code long} array.
	 *
	 * @param data the {@code long} array to iterate over cyclically
	 * @return a {@code PrimitiveCyclicIterator.OfLong} for the specified array
	 */
	public static PrimitiveCyclicIterator.OfLong c(long[] data) {
		return new PrimitiveCyclicIterator.OfLong() {
			int rev = 0;// revolutions
			PrimitiveIterator.OfLong doppleganger = i(data);

			@Override
			public int getRevolutions() {
				return rev > -1 ? rev : Integer.MAX_VALUE;
			}

			@Override
			public long nextLong() {
				long next = doppleganger.next();
				if (!doppleganger.hasNext()) {
					doppleganger = i(data);
					rev++;
				}
				return next;
//				if (doppleganger.hasNext())
//					return doppleganger.next();
//				rev++;
//				doppleganger = i(data);
//				return next();
			}
		};
	}

	/*
	 * Date created: 16 May 2024 Time created: 11:12:31
	 */
	/**
	 * Creates a {@code PrimitiveCyclicIterator.OfInt} for a {@code int} array.
	 *
	 * @param data the {@code int} array to iterate over cyclically
	 * @return a {@code PrimitiveCyclicIterator.OfInt} for the specified array
	 */
	public static PrimitiveCyclicIterator.OfInt c(int[] data) {
		return new PrimitiveCyclicIterator.OfInt() {
			int rev = 0;// revolutions
			PrimitiveIterator.OfInt doppleganger = i(data);

			@Override
			public int getRevolutions() {
				return rev > -1 ? rev : Integer.MAX_VALUE;
			}

			@Override
			public int nextInt() {
				int next = doppleganger.next();
				if (!doppleganger.hasNext()) {
					doppleganger = i(data);
					rev++;
				}
				return next;
			}
		};
	}

	/*
	 * Date created: 16 May 2024 Time created: 11:12:31
	 */
	/**
	 * Creates a {@code PrimitiveCyclicIterator.OfChar} for a {@code char} array.
	 *
	 * @param data the {@code char} array to iterate over cyclically
	 * @return a {@code PrimitiveCyclicIterator.OfChar} for the specified array
	 */
	public static PrimitiveCyclicIterator.OfChar c(char[] data) {
		return new PrimitiveCyclicIterator.OfChar() {
			int rev = 0;// revolutions
			PrimitiveIterator.OfChar doppleganger = i(data);

			@Override
			public int getRevolutions() {
				return rev > -1 ? rev : Integer.MAX_VALUE;
			}

			@Override
			public char nextChar() {
				char next = doppleganger.next();
				if (!doppleganger.hasNext()) {
					doppleganger = i(data);
					rev++;
				}
				return next;
			}
		};
	}

	/*
	 * Date created: 16 May 2024 Time created: 11:12:31
	 */
	/**
	 * Creates a {@code PrimitiveCyclicIterator.OfShort} for a {@code short} array.
	 *
	 * @param data the {@code short} array to iterate over cyclically
	 * @return a {@code PrimitiveCyclicIterator.OfShort} for the specified array
	 */
	public static PrimitiveCyclicIterator.OfShort c(short[] data) {
		return new PrimitiveCyclicIterator.OfShort() {
			int rev = 0;// revolutions
			PrimitiveIterator.OfShort doppleganger = i(data);

			@Override
			public int getRevolutions() {
				return rev > -1 ? rev : Integer.MAX_VALUE;
			}

			@Override
			public short nextShort() {
				short next = doppleganger.next();
				if (!doppleganger.hasNext()) {
					doppleganger = i(data);
					rev++;
				}
				return next;
			}
		};
	}

	/*
	 * Date created: 16 May 2024 Time created: 11:12:31
	 */
	/**
	 * Creates a {@code PrimitiveCyclicIterator.OfByte} for a {@code byte} array.
	 *
	 * @param data the {@code byte} array to iterate over cyclically
	 * @return a {@code PrimitiveCyclicIterator.OfByte} for the specified array
	 */
	public static PrimitiveCyclicIterator.OfByte c(byte[] data) {
		return new PrimitiveCyclicIterator.OfByte() {
			int rev = 0;// revolutions
			PrimitiveIterator.OfByte doppleganger = i(data);

			@Override
			public int getRevolutions() {
				return rev > -1 ? rev : Integer.MAX_VALUE;
			}

			@Override
			public byte nextByte() {
				byte next = doppleganger.next();
				if (!doppleganger.hasNext()) {
					doppleganger = i(data);
					rev++;
				}
				return next;
			}
		};
	}

	/*
	 * Date created: 16 May 2024 Time created: 11:12:31
	 */
	/**
	 * Creates a {@code PrimitiveCyclicIterator.OfBoolean} for a {@code boolean} array.
	 *
	 * @param data the {@code boolean} array to iterate over cyclically
	 * @return a {@code PrimitiveCyclicIterator.OfBoolean} for the specified array
	 */
	public static PrimitiveCyclicIterator.OfBoolean c(boolean[] data) {
		return new PrimitiveCyclicIterator.OfBoolean() {
			int rev = 0;// revolutions
			PrimitiveIterator.OfBoolean doppleganger = i(data);

			@Override
			public int getRevolutions() {
				return rev > -1 ? rev : Integer.MAX_VALUE;
			}

			@Override
			public boolean nextBoolean() {
				boolean next = doppleganger.next();
				if (!doppleganger.hasNext()) {
					doppleganger = i(data);
					rev++;
				}
				return next;
			}
		};
	}

	/*
	 * Date created: 16 May 2024 Time created: 23:49:36
	 */
	/**
	 * Returns a {@code PrimitiveListIterator.OfBoolean} for the given
	 * {@code boolean} array.
	 *
	 * <p>
	 * This method provides a way to iterate over the elements of the specified
	 * {@code boolean} array in both forward and backward directions. The iterator
	 * allows access to each element as a {@code boolean} value and supports
	 * bidirectional iteration, meaning you can move both forward and backward
	 * through the array.
	 *
	 * <h3>Example Usage:</h3>
	 * 
	 * <pre>{@code
	 * boolean[] data = { true, false, true, false };
	 * PrimitiveListIterator.OfBoolean iterator = li(data);
	 * 
	 * while (iterator.hasNext()) {
	 * 	System.out.println(iterator.nextBoolean());
	 * }
	 * 
	 * while (iterator.hasPrevious()) {
	 * 	System.out.println(iterator.previousBoolean());
	 * }
	 * }</pre>
	 *
	 * @param data the {@code boolean} array to be iterated over
	 * @return a {@code PrimitiveListIterator.OfBoolean} for the specified
	 *         {@code boolean} array
	 * @throws NullPointerException if the specified array is null
	 */
	public static PrimitiveListIterator.OfBoolean li(boolean[] data) {
		return new PrimitiveListIterator.OfBoolean() {

			int cursor = 0;

			@Override
			public int previousIndex() {
				return cursor - 1;
			}

			@Override
			public int nextIndex() {
				return cursor;
			}

			@Override
			public boolean hasPrevious() {
				return cursor > 0;
			}

			@Override
			public boolean hasNext() {
				return cursor < data.length;
			}

			@Override
			public boolean previousBoolean() throws NoSuchElementException {
				try {
					return data[--cursor];
				} catch (IndexOutOfBoundsException e) {
					throw new NoSuchElementException("ListIterator has no elements backwards", e);
				}
			}

			@Override
			public boolean nextBoolean() throws NoSuchElementException {
				try {
					return data[cursor++];
				} catch (IndexOutOfBoundsException e) {
					throw new NoSuchElementException("ListIterator has no elements forwards", e);
				}
			}
		};
	}

	/*
	 * Date created: 16 May 2024 Time created: 23:49:36
	 */
	/**
	 * Returns a {@code PrimitiveListIterator.OfByte} for the given {@code byte}
	 * array.
	 *
	 * <p>
	 * This method provides a way to iterate over the elements of the specified
	 * {@code byte} array in both forward and backward directions. The iterator
	 * allows access to each element as a {@code byte} value and supports
	 * bidirectional iteration, meaning you can move both forward and backward
	 * through the array.
	 *
	 * <h3>Example Usage:</h3>
	 * 
	 * <pre>{@code
	 * byte[] data = { 0, 1, 0, 1 };
	 * PrimitiveListIterator.OfByte iterator = li(data);
	 * 
	 * while (iterator.hasNext()) {
	 * 	System.out.println(iterator.nextByte());
	 * }
	 * 
	 * while (iterator.hasPrevious()) {
	 * 	System.out.println(iterator.previousByte());
	 * }
	 * }</pre>
	 *
	 * @param data the {@code byte} array to be iterated over
	 * @return a {@code PrimitiveListIterator.OfByte} for the specified {@code byte}
	 *         array
	 * @throws NullPointerException if the specified array is null
	 */
	public static PrimitiveListIterator.OfByte li(byte[] data) {
		return new PrimitiveListIterator.OfByte() {

			int cursor = 0;

			@Override
			public int previousIndex() {
				return cursor - 1;
			}

			@Override
			public int nextIndex() {
				return cursor;
			}

			@Override
			public boolean hasPrevious() {
				return cursor > 0;
			}

			@Override
			public boolean hasNext() {
				return cursor < data.length;
			}

			@Override
			public byte previousByte() throws NoSuchElementException {
				try {
					return data[--cursor];
				} catch (IndexOutOfBoundsException e) {
					throw new NoSuchElementException("ListIterator has no elements backwards", e);
				}
			}

			@Override
			public byte nextByte() throws NoSuchElementException {
				try {
					return data[cursor++];
				} catch (IndexOutOfBoundsException e) {
					throw new NoSuchElementException("ListIterator has no elements forwards", e);
				}
			}
		};
	}

	/*
	 * Date created: 16 May 2024 Time created: 23:49:36
	 */
	/**
	 * Returns a {@code PrimitiveListIterator.OfShort} for the given {@code short}
	 * array.
	 *
	 * <p>
	 * This method provides a way to iterate over the elements of the specified
	 * {@code short} array in both forward and backward directions. The iterator
	 * allows access to each element as a {@code short} value and supports
	 * bidirectional iteration, meaning you can move both forward and backward
	 * through the array.
	 *
	 * <h3>Example Usage:</h3>
	 * 
	 * <pre>{@code
	 * short[] data = { 1, 2, 3, 4 };
	 * PrimitiveListIterator.OfShort iterator = li(data);
	 * 
	 * while (iterator.hasNext()) {
	 * 	System.out.println(iterator.nextShort());
	 * }
	 * 
	 * while (iterator.hasPrevious()) {
	 * 	System.out.println(iterator.previousShort());
	 * }
	 * }</pre>
	 *
	 * @param data the {@code short} array to be iterated over
	 * @return a {@code PrimitiveListIterator.OfShort} for the specified
	 *         {@code short} array
	 * @throws NullPointerException if the specified array is null
	 */
	public static PrimitiveListIterator.OfShort li(short[] data) {
		return new PrimitiveListIterator.OfShort() {

			int cursor = 0;

			@Override
			public int previousIndex() {
				return cursor - 1;
			}

			@Override
			public int nextIndex() {
				return cursor;
			}

			@Override
			public boolean hasPrevious() {
				return cursor > 0;
			}

			@Override
			public boolean hasNext() {
				return cursor < data.length;
			}

			@Override
			public short previousShort() throws NoSuchElementException {
				try {
					return data[--cursor];
				} catch (IndexOutOfBoundsException e) {
					throw new NoSuchElementException("ListIterator has no elements backwards", e);
				}
			}

			@Override
			public short nextShort() throws NoSuchElementException {
				try {
					return data[cursor++];
				} catch (IndexOutOfBoundsException e) {
					throw new NoSuchElementException("ListIterator has no elements forwards", e);
				}
			}
		};
	}

	/*
	 * Date created: 16 May 2024 Time created: 23:49:36
	 */
	/**
	 * Returns a {@code PrimitiveListIterator.OfChar} for the given {@code char}
	 * array.
	 *
	 * <p>
	 * This method provides a way to iterate over the elements of the specified
	 * {@code char} array in both forward and backward directions. The iterator
	 * allows access to each element as a {@code char} value and supports
	 * bidirectional iteration, meaning you can move both forward and backward
	 * through the array.
	 *
	 * <h3>Example Usage:</h3>
	 * 
	 * <pre>{@code
	 * char[] data = { '*', ',', '/', '+' };
	 * PrimitiveListIterator.OfChar iterator = li(data);
	 * 
	 * while (iterator.hasNext()) {
	 * 	System.out.println(iterator.nextChar());
	 * }
	 * 
	 * while (iterator.hasPrevious()) {
	 * 	System.out.println(iterator.previousChar());
	 * }
	 * }</pre>
	 *
	 * @param data the {@code char} array to be iterated over
	 * @return a {@code PrimitiveListIterator.OfChar} for the specified {@code char}
	 *         array
	 * @throws NullPointerException if the specified array is null
	 */
	public static PrimitiveListIterator.OfChar li(char[] data) {
		return new PrimitiveListIterator.OfChar() {

			int cursor = 0;

			@Override
			public int previousIndex() {
				return cursor - 1;
			}

			@Override
			public int nextIndex() {
				return cursor;
			}

			@Override
			public boolean hasPrevious() {
				return cursor > 0;
			}

			@Override
			public boolean hasNext() {
				return cursor < data.length;
			}

			@Override
			public char previousChar() throws NoSuchElementException {
				try {
					return data[--cursor];
				} catch (IndexOutOfBoundsException e) {
					throw new NoSuchElementException("ListIterator has no elements backwards", e);
				}
			}

			@Override
			public char nextChar() throws NoSuchElementException {
				try {
					return data[cursor++];
				} catch (IndexOutOfBoundsException e) {
					throw new NoSuchElementException("ListIterator has no elements forwards", e);
				}
			}
		};
	}

	/*
	 * Date created: 16 May 2024 Time created: 23:49:36
	 */
	/**
	 * Returns a {@code PrimitiveListIterator.OfFloat} for the given {@code float}
	 * array.
	 *
	 * <p>
	 * This method provides a way to iterate over the elements of the specified
	 * {@code float} array in both forward and backward directions. The iterator
	 * allows access to each element as a {@code float} value and supports
	 * bidirectional iteration, meaning you can move both forward and backward
	 * through the array.
	 *
	 * <h3>Example Usage:</h3>
	 * 
	 * <pre>{@code
	 * float[] data = { 0.1f, 0.2f, 0.3f, 0.4f };
	 * PrimitiveListIterator.OfFloat iterator = li(data);
	 * 
	 * while (iterator.hasNext()) {
	 * 	System.out.println(iterator.nextFloat());
	 * }
	 * 
	 * while (iterator.hasPrevious()) {
	 * 	System.out.println(iterator.previousFloat());
	 * }
	 * }</pre>
	 *
	 * @param data the {@code float} array to be iterated over
	 * @return a {@code PrimitiveListIterator.OfFloat} for the specified
	 *         {@code float} array
	 * @throws NullPointerException if the specified array is null
	 */
	public static PrimitiveListIterator.OfFloat li(float[] data) {
		return new PrimitiveListIterator.OfFloat() {

			int cursor = 0;

			@Override
			public int previousIndex() {
				return cursor - 1;
			}

			@Override
			public int nextIndex() {
				return cursor;
			}

			@Override
			public boolean hasPrevious() {
				return cursor > 0;
			}

			@Override
			public boolean hasNext() {
				return cursor < data.length;
			}

			@Override
			public float previousFloat() throws NoSuchElementException {
				try {
					return data[--cursor];
				} catch (IndexOutOfBoundsException e) {
					throw new NoSuchElementException("ListIterator has no elements backwards", e);
				}
			}

			@Override
			public float nextFloat() throws NoSuchElementException {
				try {
					return data[cursor++];
				} catch (IndexOutOfBoundsException e) {
					throw new NoSuchElementException("ListIterator has no elements forwards", e);
				}
			}
		};
	}

	/*
	 * Date created: 16 May 2024 Time created: 23:49:36
	 */
	/**
	 * Returns a {@code PrimitiveListIterator.OfInt} for the given {@code int}
	 * array.
	 *
	 * <p>
	 * This method provides a way to iterate over the elements of the specified
	 * {@code int} array in both forward and backward directions. The iterator
	 * allows access to each element as a {@code int} value and supports
	 * bidirectional iteration, meaning you can move both forward and backward
	 * through the array.
	 *
	 * <h3>Example Usage:</h3>
	 * 
	 * <pre>{@code
	 * int[] data = { 1, 2, 3, 4 };
	 * PrimitiveListIterator.OfInt iterator = li(data);
	 * 
	 * while (iterator.hasNext()) {
	 * 	System.out.println(iterator.nextInt());
	 * }
	 * 
	 * while (iterator.hasPrevious()) {
	 * 	System.out.println(iterator.previousInt());
	 * }
	 * }</pre>
	 *
	 * @param data the {@code int} array to be iterated over
	 * @return a {@code PrimitiveListIterator.OfInt} for the specified {@code int}
	 *         array
	 * @throws NullPointerException if the specified array is null
	 */
	public static PrimitiveListIterator.OfInt li(int[] data) {
		return new PrimitiveListIterator.OfInt() {

			int cursor = 0;

			@Override
			public int previousIndex() {
				return cursor - 1;
			}

			@Override
			public int nextIndex() {
				return cursor;
			}

			@Override
			public boolean hasPrevious() {
				return cursor > 0;
			}

			@Override
			public boolean hasNext() {
				return cursor < data.length;
			}

			@Override
			public int previousInt() throws NoSuchElementException {
				try {
					return data[--cursor];
				} catch (IndexOutOfBoundsException e) {
					throw new NoSuchElementException("ListIterator has no elements backwards", e);
				}
			}

			@Override
			public int nextInt() throws NoSuchElementException {
				try {
					return data[cursor++];
				} catch (IndexOutOfBoundsException e) {
					throw new NoSuchElementException("ListIterator has no elements forwards", e);
				}
			}
		};
	}

	/*
	 * Date created: 16 May 2024 Time created: 23:49:36
	 */
	/**
	 * Returns a {@code PrimitiveListIterator.OfLong} for the given {@code long}
	 * array.
	 *
	 * <p>
	 * This method provides a way to iterate over the elements of the specified
	 * {@code long} array in both forward and backward directions. The iterator
	 * allows access to each element as a {@code long} value and supports
	 * bidirectional iteration, meaning you can move both forward and backward
	 * through the array.
	 *
	 * <h3>Example Usage:</h3>
	 * 
	 * <pre>{@code
	 * long[] data = { 1L, 2L, 3L, 4L };
	 * PrimitiveListIterator.OfLong iterator = li(data);
	 * 
	 * while (iterator.hasNext()) {
	 * 	System.out.prlongln(iterator.nextLong());
	 * }
	 * 
	 * while (iterator.hasPrevious()) {
	 * 	System.out.prlongln(iterator.previousLong());
	 * }
	 * }</pre>
	 *
	 * @param data the {@code long} array to be iterated over
	 * @return a {@code PrimitiveListIterator.OfLong} for the specified {@code long}
	 *         array
	 * @throws NullPolongerException if the specified array is null
	 */
	public static PrimitiveListIterator.OfLong li(long[] data) {
		return new PrimitiveListIterator.OfLong() {

			int cursor = 0;

			@Override
			public int previousIndex() {
				return cursor - 1;
			}

			@Override
			public int nextIndex() {
				return cursor;
			}

			@Override
			public boolean hasPrevious() {
				return cursor > 0;
			}

			@Override
			public boolean hasNext() {
				return cursor < data.length;
			}

			@Override
			public long previousLong() throws NoSuchElementException {
				try {
					return data[--cursor];
				} catch (IndexOutOfBoundsException e) {
					throw new NoSuchElementException("ListIterator has no elements backwards", e);
				}
			}

			@Override
			public long nextLong() throws NoSuchElementException {
				try {
					return data[cursor++];
				} catch (IndexOutOfBoundsException e) {
					throw new NoSuchElementException("ListIterator has no elements forwards", e);
				}
			}
		};
	}

	/*
	 * Date created: 16 May 2024 Time created: 23:49:36
	 */
	/**
	 * Returns a {@code PrimitiveListIterator.OfDouble} for the given {@code double}
	 * array.
	 *
	 * <p>
	 * This method provides a way to iterate over the elements of the specified
	 * {@code double} array in both forward and backward directions. The iterator
	 * allows access to each element as a {@code double} value and supports
	 * bidirectional iteration, meaning you can move both forward and backward
	 * through the array.
	 *
	 * <h3>Example Usage:</h3>
	 * 
	 * <pre>{@code
	 * double[] data = { 0.1, 0.2, 0.3, 0.4 };
	 * PrimitiveListIterator.OfDouble iterator = li(data);
	 * 
	 * while (iterator.hasNext()) {
	 * 	System.out.prdoubleln(iterator.nextDouble());
	 * }
	 * 
	 * while (iterator.hasPrevious()) {
	 * 	System.out.prdoubleln(iterator.previousDouble());
	 * }
	 * }</pre>
	 *
	 * @param data the {@code double} array to be iterated over
	 * @return a {@code PrimitiveListIterator.OfDouble} for the specified
	 *         {@code double} array
	 * @throws NullPodoubleerException if the specified array is null
	 */
	public static PrimitiveListIterator.OfDouble li(double[] data) {
		return new PrimitiveListIterator.OfDouble() {

			int cursor = 0;

			@Override
			public int previousIndex() {
				return cursor - 1;
			}

			@Override
			public int nextIndex() {
				return cursor;
			}

			@Override
			public boolean hasPrevious() {
				return cursor > 0;
			}

			@Override
			public boolean hasNext() {
				return cursor < data.length;
			}

			@Override
			public double previousDouble() throws NoSuchElementException {
				try {
					return data[--cursor];
				} catch (IndexOutOfBoundsException e) {
					throw new NoSuchElementException("ListIterator has no elements backwards", e);
				}
			}

			@Override
			public double nextDouble() throws NoSuchElementException {
				try {
					return data[cursor++];
				} catch (IndexOutOfBoundsException e) {
					throw new NoSuchElementException("ListIterator has no elements forwards", e);
				}
			}
		};
	}

	/*
	 * Date created: 16 May 2024 Time created: 14:50:39
	 */
	/**
	 * Creates a primitive iterator of {@code double} values using the specified
	 * start value, operator, and end predicate.
	 * 
	 * <p>
	 * This method creates a primitive iterator of {@code double} values starting
	 * from the specified start value (inclusive) and incrementing or decrementing
	 * based on the provided operator function until the end predicate is satisfied.
	 * </p>
	 * 
	 * <p>
	 * <b>Note:</b> The end predicate determines when to end the iteration. When the
	 * end predicate returns {@code true}, the iteration stops.
	 * </p>
	 * 
	 * <h4>Example Usage:</h4>
	 * 
	 * <pre>
	 * <code>
	 * // Create a primitive iterator starting from 1.0 and doubling the value until it reaches 100.0
	 * PrimitiveIterator.OfDouble iterator = PrimitiveIterators.d(1.0, x -> x * 2, x -> x >= 100.0);
	 * 
	 * // Iterate over the values and print each element
	 * while (iterator.hasNext()) {
	 *     double value = iterator.nextDouble();
	 *     System.out.println("Next Element: " + value);
	 * }
	 * </code>
	 * </pre>
	 * 
	 * <p>
	 * This example demonstrates how the {@code d} method can be used to create a
	 * primitive iterator starting from 1.0 and doubling the value until it reaches
	 * 100.0.
	 * </p>
	 *
	 * @param startInclusive the starting value of the iterator (inclusive)
	 * @param operator       the operator function to generate the next value based
	 *                       on the previous value
	 * @param end            the predicate function determining when to end the
	 *                       iteration
	 * @return a primitive iterator of {@code double} values
	 */
	public static PrimitiveIterator.OfDouble d(double startInclusive,
			PrimitiveFunction.ToDouble.OfDouble operator,
			PrimitivePredicate.OfDouble end) {
		return new PrimitiveIterator.OfDouble() {
			double current = startInclusive;

			@Override
			public boolean hasNext() {
				return end.testDouble(current);
			}

			@Override
			public double nextDouble() {
				double l = current;
				current = operator.applyDouble(current);
				return l;
			}
		};
	}

	/**
	 * Creates a primitive iterator of {@code double} values with the specified
	 * start value, step, and end value (exclusive).
	 * 
	 * <p>
	 * This method creates a primitive iterator of {@code double} values starting
	 * from the specified start value (inclusive), incrementing or decrementing by
	 * the specified step value until the end value (exclusive) is reached.
	 * </p>
	 * 
	 * <h4>Example Usage:</h4>
	 * 
	 * <pre>
	 * <code>
	 * // Create a primitive iterator starting from 1.0, incrementing by 0.5, and ending at 5.0 (exclusive)
	 * PrimitiveIterator.OfDouble iterator = PrimitiveIterators.d(1.0, 0.5, 5.0);
	 * 
	 * // Iterate over the values and print each element
	 * while (iterator.hasNext()) {
	 *     double value = iterator.nextDouble();
	 *     System.out.println("Next Element: " + value);
	 * }
	 * </code>
	 * </pre>
	 * 
	 * <p>
	 * This example demonstrates how the {@code d} method can be used to create a
	 * primitive iterator starting from 1.0, incrementing by 0.5, and ending at 5.0
	 * (exclusive).
	 * </p>
	 *
	 * @param startInclusive the starting value of the iterator (inclusive)
	 * @param step           the step by which the iterator increments or decrements
	 * @param endExclusive   the end value of the iterator (exclusive)
	 * @return a primitive iterator of {@code double} values
	 */
	public static PrimitiveIterator.OfDouble d(double startInclusive, double step, double endExclusive) {
		return d(startInclusive, l -> l + step, l -> Math.abs(l + step) < Math.abs(endExclusive));
	}

	/*
	 * Date created: 18 May 2024 Time created: 13:47:55
	 */
	/**
	 * Creates a primitive iterator of {@code long} values using the specified start
	 * value, operator, and end predicate.
	 * 
	 * <p>
	 * This method creates a primitive iterator of {@code long} values starting from
	 * the specified start value (inclusive) and incrementing or decrementing based
	 * on the provided operator function until the end predicate is satisfied.
	 * </p>
	 * 
	 * <p>
	 * <b>Note:</b> The end predicate determines when to end the iteration. When the
	 * end predicate returns {@code true}, the iteration stops.
	 * </p>
	 * 
	 * <h4>Example Usage:</h4>
	 * 
	 * <pre>
	 * <code>
	 * // Create a primitive iterator starting from 1000 and tripling the value until it reaches 1000000000
	 * PrimitiveIterator.OfLong iterator = PrimitiveIterators.l(1000L, x -> x * 3L, x -> x >= 1000000000L);
	 * 
	 * // Iterate over the values and print each element
	 * while (iterator.hasNext()) {
	 *     long value = iterator.nextLong();
	 *     System.out.println("Next Element: " + value);
	 * }
	 * </code>
	 * </pre>
	 * 
	 * <p>
	 * This example demonstrates how the {@code l} method can be used to create a
	 * primitive iterator starting from 1000 and tripling the value until it reaches
	 * 1000000000.
	 * </p>
	 *
	 * @param startInclusive the starting value of the iterator (inclusive)
	 * @param operator       the operator function to generate the next value based
	 *                       on the previous value
	 * @param end            the predicate function determining when to end the
	 *                       iteration
	 * @return a primitive iterator of {@code long} values
	 */
	public static PrimitiveIterator.OfLong l(long startInclusive,
			PrimitiveFunction.ToLong.OfLong operator,
			PrimitivePredicate.OfLong end) {
		return new PrimitiveIterator.OfLong() {
			long current = startInclusive;

			@Override
			public boolean hasNext() {
				return end.testLong(current);
			}

			@Override
			public long nextLong() {
				long l = current;
				current = operator.applyLong(current);
				return l;
			}
		};
	}

	/*
	 * Date created: 18 May 2024 Time created: 14:01:17
	 */
	/**
	 * Creates a primitive iterator of {@code long} values with the specified start
	 * value, step, and end value (exclusive).
	 * 
	 * <p>
	 * This method creates a primitive iterator of {@code long} values starting from
	 * the specified start value (inclusive), incrementing or decrementing by the
	 * specified step value until the end value (exclusive) is reached.
	 * </p>
	 * 
	 * <h4>Example Usage:</h4>
	 * 
	 * <pre>
	 * <code>
	 * // Create a primitive iterator starting from 1, incrementing by 200, and ending at 90000 (exclusive)
	 * PrimitiveIterator.OfLong iterator = PrimitiveIterators.l(1L, 2000L, 90000L);
	 * 
	 * // Iterate over the values and print each element
	 * while (iterator.hasNext()) {
	 *     long value = iterator.nextLong();
	 *     System.out.println("Next Element: " + value);
	 * }
	 * </code>
	 * </pre>
	 * 
	 * <p>
	 * This example demonstrates how the {@code l} method can be used to create a
	 * primitive iterator starting from 1, incrementing by 200, and ending at 90000
	 * (exclusive).
	 * </p>
	 *
	 * @param startInclusive the starting value of the iterator (inclusive)
	 * @param step           the step by which the iterator increments or decrements
	 * @param endExclusive   the end value of the iterator (exclusive)
	 * @return a primitive iterator of {@code long} values
	 */
	public static PrimitiveIterator.OfLong l(long startInclusive, long step, long endExlusive) {
		return l(startInclusive, l -> l + step, l -> Math.abs(l + step) < Math.abs(endExlusive));
	}

	/*
	 * Date created: 18 May 2024 Time created: 13:51:16
	 */
	/**
	 * Creates a primitive iterator of {@code int} values using the specified start
	 * value, operator, and end predicate.
	 * 
	 * <p>
	 * This method creates a primitive iterator of {@code int} values starting from
	 * the specified start value (inclusive) and incrementing or decrementing based
	 * on the provided operator function until the end predicate is satisfied.
	 * </p>
	 * 
	 * <p>
	 * <b>Note:</b> The end predicate determines when to end the iteration. When the
	 * end predicate returns {@code true}, the iteration stops.
	 * </p>
	 * 
	 * <h4>Example Usage:</h4>
	 * 
	 * <pre>
	 * <code>
	 * // Create a primitive iterator starting from 100 and decrementing the value until it reaches 1
	 * PrimitiveIterator.OfInt iterator = PrimitiveIterators.i(100, x -> --x, x -> x <= 100);
	 * 
	 * // Iterate over the values and print each element
	 * while (iterator.hasNext()) {
	 *     int value = iterator.nextInt();
	 *     System.out.println("Next Element: " + value);
	 * }
	 * </code>
	 * </pre>
	 * 
	 * <p>
	 * This example demonstrates how the {@code i} method can be used to create a
	 * primitive iterator starting from 100 and decrementing the value until it
	 * reaches 1
	 * </p>
	 *
	 * @param startInclusive the starting value of the iterator (inclusive)
	 * @param operator       the operator function to generate the next value based
	 *                       on the previous value
	 * @param end            the predicate function determining when to end the
	 *                       iteration
	 * @return a primitive iterator of {@code int} values
	 */
	public static PrimitiveIterator.OfInt i(int startInclusive,
			PrimitiveFunction.ToInt.OfInt operator,
			PrimitivePredicate.OfInt end) {
		return new PrimitiveIterator.OfInt() {
			int current = startInclusive;

			@Override
			public boolean hasNext() {
				return end.testInt(current);
			}

			@Override
			public int nextInt() {
				int l = current;
				current = operator.applyInt(current);
				return l;
			}
		};
	}

	/*
	 * Date created: 18 May 2024 Time created: 14:04:01
	 */
	/**
	 * Creates a primitive iterator of {@code int} values with the specified start
	 * value, step, and end value (exclusive).
	 * 
	 * <p>
	 * This method creates a primitive iterator of {@code int} values starting from
	 * the specified start value (inclusive), incrementing or decrementing by the
	 * specified step value until the end value (exclusive) is reached.
	 * </p>
	 * 
	 * <h4>Example Usage:</h4>
	 * 
	 * <pre>
	 * <code>
	 * // Create a primitive iterator starting from 1, incrementing by 2, and ending at 1000 (exclusive)
	 * PrimitiveIterator.OfInt iterator = PrimitiveIterators.i(1, 2, 1000);
	 * 
	 * // Iterate over the values and print each element
	 * while (iterator.hasNext()) {
	 *     int value = iterator.nextInt();
	 *     System.out.println("Next Element: " + value);
	 * }
	 * </code>
	 * </pre>
	 * 
	 * <p>
	 * This example demonstrates how the {@code i} method can be used to create a
	 * primitive iterator starting from 1, incrementing by 2, and ending at 1000
	 * (exclusive).
	 * </p>
	 *
	 * @param startInclusive the starting value of the iterator (inclusive)
	 * @param step           the step by which the iterator increments or decrements
	 * @param endExclusive   the end value of the iterator (exclusive)
	 * @return a primitive iterator of {@code int} values
	 */
	public static PrimitiveIterator.OfInt i(int startInclusive, int step, int endExlusive) {
		return i(startInclusive, l -> l + step, l -> Math.abs(l) < Math.abs(endExlusive));
	}

	/*
	 * Date created: 18 May 2024 Time created: 13:55:14
	 */
	/**
	 * Creates a primitive iterator of {@code float} values using the specified
	 * start value, operator, and end predicate.
	 * 
	 * <p>
	 * This method creates a primitive iterator of {@code float} values starting
	 * from the specified start value (inclusive) and incrementing or decrementing
	 * based on the provided operator function until the end predicate is satisfied.
	 * </p>
	 * 
	 * <p>
	 * <b>Note:</b> The end predicate determines when to end the iteration. When the
	 * end predicate returns {@code true}, the iteration stops.
	 * </p>
	 * 
	 * <h4>Example Usage:</h4>
	 * 
	 * <pre>
	 * <code>
	 * // Create a primitive iterator starting from 1.0f and doubling the value until it reaches 100.0f
	 * PrimitiveIterator.OfFloat iterator = PrimitiveIterators.f(1.0f, x -> x * 2f, x -> x >= 100.0f);
	 * 
	 * // Iterate over the values and print each element
	 * while (iterator.hasNext()) {
	 *     float value = iterator.nextFloat();
	 *     System.out.println("Next Element: " + value);
	 * }
	 * </code>
	 * </pre>
	 * 
	 * <p>
	 * This example demonstrates how the {@code f} method can be used to create a
	 * primitive iterator starting from 1.0f and doubling the value until it reaches
	 * 100.0f.
	 * </p>
	 *
	 * @param startInclusive the starting value of the iterator (inclusive)
	 * @param operator       the operator function to generate the next value based
	 *                       on the previous value
	 * @param end            the predicate function determining when to end the
	 *                       iteration
	 * @return a primitive iterator of {@code float} values
	 */
	public static PrimitiveIterator.OfFloat f(float startInclusive,
			PrimitiveFunction.ToFloat.OfFloat operator,
			PrimitivePredicate.OfFloat end) {
		return new PrimitiveIterator.OfFloat() {
			float current = startInclusive;

			@Override
			public boolean hasNext() {
				return end.testFloat(current);
			}

			@Override
			public float nextFloat() {
				float l = current;
				current = operator.applyFloat(current);
				return l;
			}
		};
	}

	/*
	 * Date created: 18 May 2024 Time created: 14:05:50
	 */
	/**
	 * Creates a primitive iterator of {@code float} values with the specified start
	 * value, step, and end value (exclusive).
	 * 
	 * <p>
	 * This method creates a primitive iterator of {@code float} values starting
	 * from the specified start value (inclusive), incrementing or decrementing by
	 * the specified step value until the end value (exclusive) is reached.
	 * </p>
	 *
	 * @param startInclusive the starting value of the iterator (inclusive)
	 * @param step           the step by which the iterator increments or decrements
	 * @param endExclusive   the end value of the iterator (exclusive)
	 * @return a primitive iterator of {@code float} values
	 */
	public static PrimitiveIterator.OfFloat f(float startInclusive, float step, float endExlusive) {
		return f(startInclusive, l -> l + step, l -> Math.abs(l) < Math.abs(endExlusive));
	}

	/*
	 * Date created: 18 May 2024 Time created: 13:57:02
	 */
	/**
	 * Creates a primitive iterator of {@code short} values using the specified
	 * start value, operator, and end predicate.
	 * 
	 * <p>
	 * This method creates a primitive iterator of {@code short} values starting
	 * from the specified start value (inclusive) and incrementing or decrementing
	 * based on the provided operator function until the end predicate is satisfied.
	 * </p>
	 * 
	 * <p>
	 * <b>Note:</b> The end predicate determines when to end the iteration. When the
	 * end predicate returns {@code true}, the iteration stops.
	 * </p>
	 *
	 * @param startInclusive the starting value of the iterator (inclusive)
	 * @param operator       the operator function to generate the next value based
	 *                       on the previous value
	 * @param end            the predicate function determining when to end the
	 *                       iteration
	 * @return a primitive iterator of {@code short} values
	 */
	public static PrimitiveIterator.OfShort s(short startInclusive,
			PrimitiveFunction.ToShort.OfShort operator,
			PrimitivePredicate.OfShort end) {
		return new PrimitiveIterator.OfShort() {
			short current = startInclusive;

			@Override
			public boolean hasNext() {
				return end.testShort(current);
			}

			@Override
			public short nextShort() {
				short l = current;
				current = operator.applyShort(current);
				return l;
			}
		};
	}

	/*
	 * Date created: 18 May 2024 Time created: 14:06:33
	 */
	/**
	 * Creates a primitive iterator of {@code short} values with the specified start
	 * value, step, and end value (exclusive).
	 * 
	 * <p>
	 * This method creates a primitive iterator of {@code short} values starting
	 * from the specified start value (inclusive), incrementing or decrementing by
	 * the specified step value until the end value (exclusive) is reached.
	 * </p>
	 *
	 * @param startInclusive the starting value of the iterator (inclusive)
	 * @param step           the step by which the iterator increments or decrements
	 * @param endExclusive   the end value of the iterator (exclusive)
	 * @return a primitive iterator of {@code short} values
	 */
	public static PrimitiveIterator.OfShort s(short startInclusive, short step, short endExlusive) {
		return s(startInclusive, l -> (short) (l + step), l -> Math.abs(l) < Math.abs(endExlusive));
	}

	/*
	 * Date created: 18 May 2024 Time created: 13:57:56
	 */
	/**
	 * Creates a primitive iterator of {@code byte} values using the specified start
	 * value, operator, and end predicate.
	 * 
	 * <p>
	 * This method creates a primitive iterator of {@code byte} values starting from
	 * the specified start value (inclusive) and incrementing or decrementing based
	 * on the provided operator function until the end predicate is satisfied.
	 * </p>
	 * 
	 * <p>
	 * <b>Note:</b> The end predicate determines when to end the iteration. When the
	 * end predicate returns {@code true}, the iteration stops.
	 * </p>
	 *
	 * @param startInclusive the starting value of the iterator (inclusive)
	 * @param operator       the operator function to generate the next value based
	 *                       on the previous value
	 * @param end            the predicate function determining when to end the
	 *                       iteration
	 * @return a primitive iterator of {@code byte} values
	 */
	public static PrimitiveIterator.OfByte b(byte startInclusive,
			PrimitiveFunction.ToByte.OfByte operator,
			PrimitivePredicate.OfByte end) {
		return new PrimitiveIterator.OfByte() {
			byte current = startInclusive;

			@Override
			public boolean hasNext() {
				return end.testByte(current);
			}

			@Override
			public byte nextByte() {
				byte l = current;
				current = operator.applyByte(current);
				return l;
			}
		};
	}

	/*
	 * Date created: 18 May 2024 Time created: 14:06:53
	 */
	/**
	 * Creates a primitive iterator of {@code byte} values with the specified start
	 * value, step, and end value (exclusive).
	 * 
	 * <p>
	 * This method creates a primitive iterator of {@code byte} values starting from
	 * the specified start value (inclusive), incrementing or decrementing by the
	 * specified step value until the end value (exclusive) is reached.
	 * </p>
	 *
	 * @param startInclusive the starting value of the iterator (inclusive)
	 * @param step           the step by which the iterator increments or decrements
	 * @param endExclusive   the end value of the iterator (exclusive)
	 * @return a primitive iterator of {@code byte} values
	 */
	public static PrimitiveIterator.OfByte b(byte startInclusive, byte step, byte endExlusive) {
		return b(startInclusive, l -> (byte) (l + step), l -> Math.abs(l) < Math.abs(endExlusive));
	}

	/*
	 * Date created: 18 May 2024 Time created: 13:58:36
	 */
	/**
	 * Creates a primitive iterator of {@code char} values using the specified start
	 * value, operator, and end predicate.
	 * 
	 * <p>
	 * <b>Note:</b> The end predicate determines when to end the iteration. When the
	 * end predicate returns {@code true}, the iteration stops.
	 * </p>
	 *
	 * @param startInclusive the starting value of the iterator (inclusive)
	 * @param operator       the operator function to generate the next value based
	 *                       on the previous value
	 * @param end            the predicate function determining when to end the
	 *                       iteration
	 * @return a primitive iterator of {@code char} values
	 */
	public static PrimitiveIterator.OfChar c(char startInclusive,
			PrimitiveFunction.ToChar.OfChar operator,
			PrimitivePredicate.OfChar end) {
		return new PrimitiveIterator.OfChar() {
			char current = startInclusive;

			@Override
			public boolean hasNext() {
				return end.testChar(current);
			}

			@Override
			public char nextChar() {
				char l = current;
				current = operator.applyChar(current);
				return l;
			}
		};
	}

	/*
	 * Date created: 18 May 2024 Time created: 13:59:08
	 */
	/**
	 * Creates a primitive iterator of {@code char} values using the specified start
	 * value, operator, and end predicate.
	 * 
	 * <p>
	 * <b>Note:</b> The end predicate determines when to end the iteration. When the
	 * end predicate returns {@code true}, the iteration stops.
	 * </p>
	 *
	 * @param startInclusive the starting value of the iterator (inclusive)
	 * @param operator       the operator function to generate the next value based
	 *                       on the previous value
	 * @param end            the predicate function determining when to end the
	 *                       iteration
	 * @return a primitive iterator of {@code boolean} values
	 */
	public static PrimitiveIterator.OfBoolean b(boolean startInclusive,
			PrimitiveFunction.ToBoolean.OfBoolean operator,
			PrimitivePredicate.OfBoolean end) {
		return new PrimitiveIterator.OfBoolean() {
			boolean current = startInclusive;

			@Override
			public boolean hasNext() {
				return end.testBoolean(current);
			}

			@Override
			public boolean nextBoolean() {
				boolean l = current;
				current = operator.applyBoolean(current);
				return l;
			}
		};
	}

	/*
	 * Date created: 18 May 2024 Time created: 13:59:08
	 */
	/**
	 * Creates an iterator of {@code <T>} values using the specified start value,
	 * operator, and end predicate.
	 * 
	 * <p>
	 * <b>Note:</b> The end predicate determines when to end the iteration. When the
	 * end predicate returns {@code true}, the iteration stops.
	 * </p>
	 *
	 * @param startInclusive the starting value of the iterator (inclusive)
	 * @param operator       the operator function to generate the next value based
	 *                       on the previous value
	 * @param end            the predicate function determining when to end the
	 *                       iteration
	 * @return an iterator of {@code <T>} values
	 */
	public static <T> Iterator<T> i(T startInclusive, UnaryOperator<T> operator, Predicate<T> end) {
		return new Iterator<>() {
			T current = startInclusive;

			@Override
			public boolean hasNext() {
				return end.test(current);
			}

			@Override
			public T next() {
				T l = current;
				current = operator.apply(current);
				return l;
			}
		};
	}

	/**
	 * Converts an {@code Iterator<T>} to an array of type {@code T}. This method
	 * uses {@code 10} as the default estimated size.
	 * 
	 * @param <T>      the type of elements returned by the iterator
	 * @param iterator the iterator providing the elements
	 * @return an array containing all elements provided by the iterator
	 * 
	 * @throws NullPointerException if the specified iterator is null
	 * 
	 * @see #toArray(Iterator, int)
	 */
	public static <T> T[] toArray(Iterator<T> iterator) {
		return toArray(iterator, 10); // Use a smaller default estimated size
	}

	/**
	 * Converts an {@code Iterator<T>} to an array of type {@code T}. This method
	 * allows for an estimated size of the array to be specified to optimize
	 * performance.
	 * 
	 * <p>
	 * This method will create an array of the specified estimated size and populate
	 * it with elements from the iterator. If the iterator provides more elements
	 * than the estimated size, the array will be resized dynamically. If the
	 * iterator provides fewer elements than the estimated size, the resulting array
	 * will be trimmed to fit the actual number of elements.
	 * </p>
	 * 
	 * <p>
	 * Usage Example:
	 * </p>
	 * 
	 * <pre>
	 * <code>
	 * List&lt;String&gt; stringList = Arrays.asList("apple", "banana", "cherry");
	 * Iterator&lt;String&gt; stringIterator = stringList.iterator();
	 * String[] stringArray = Utility.toArray(stringIterator, 3);
	 * 
	 * // Output: [apple, banana, cherry]
	 * System.out.println(Arrays.toString(stringArray));
	 * </code>
	 * </pre>
	 * 
	 * @param <T>           the type of elements returned by the iterator
	 * @param iterator      the iterator providing the elements
	 * @param estimatedSize an estimate of the number of elements the iterator will
	 *                      provide
	 * @return an array containing all elements provided by the iterator
	 * 
	 * @throws NullPointerException if the specified iterator is null
	 */
	@SuppressWarnings("unchecked")
	public static <T> T[] toArray(Iterator<T> iterator, int estimatedSize) {
		if (!iterator.hasNext())
			return (T[]) Array.newInstance(Object.class, 0);

		T[] array = (T[]) Array.newInstance(Object.class, estimatedSize);
		int i = 0;

		while (iterator.hasNext()) {
			if (i >= array.length) {
				array = Arrays.copyOf(array, array.length * 2); // Double the size
			}
			array[i++] = iterator.next();
			if (i < 0)
				return array; // We are at Integer.MAX_VALUE
		}

		return Arrays.copyOfRange(array, 0, i);
	}

	/**
	 * Converts a {@code PrimitiveIterator.OfDouble} to an array of {@code double}.
	 * This method uses {@code 10} as the default estimated size.
	 * 
	 * @param iterator the iterator providing the double values
	 * @return an array containing all double values provided by the iterator
	 * 
	 * @throws NullPointerException if the specified iterator is null
	 * 
	 * @see #toArray(PrimitiveIterator.OfDouble, int)
	 */
	public static <T> double[] toArray(PrimitiveIterator.OfDouble iterator) {
		return toArray(iterator, 10);
	}

	/**
	 * Converts a {@code PrimitiveIterator.OfDouble} to an array of {@code double}.
	 * This method allows for an estimated size of the array to be specified to
	 * optimize performance.
	 * 
	 * <p>
	 * This method will create an array of the specified estimated size and populate
	 * it with elements from the iterator. If the iterator provides more elements
	 * than the estimated size, the array will be resized dynamically. If the
	 * iterator provides fewer elements than the estimated size, the resulting array
	 * will be trimmed to fit the actual number of elements.
	 * </p>
	 * 
	 * <p>
	 * Usage Example:
	 * </p>
	 * 
	 * <pre>
	 * <code>
	 * PrimitiveIterator.OfDouble doubleIterator = Arrays.asList(1.0, 2.0, 3.0).stream().mapToDouble(Double::doubleValue).iterator();
	 * double[] doubleArray = Utility.toArray(doubleIterator, 3);
	 * 
	 * // Output: [1.0, 2.0, 3.0]
	 * System.out.println(Arrays.toString(doubleArray));
	 * </code>
	 * </pre>
	 * 
	 * @param iterator      the iterator providing the double values
	 * @param estimatedSize an estimate of the number of elements the iterator will
	 *                      provide
	 * @return an array containing all double values provided by the iterator
	 * 
	 * @throws NullPointerException if the specified iterator is null
	 */
	public static double[] toArray(PrimitiveIterator.OfDouble iterator, int estimatedSize) {
		if (!iterator.hasNext())
			return new double[]{};
		double[] array = new double[estimatedSize];
		int i = 0;
		while (iterator.hasNext()) {
			if (i >= array.length)
				array = Arrays.copyOf(array, array.length * 2);
			array[i++] = iterator.nextDouble();
			if (i < 0)
				return array;// We are at Integer.MAX_VALUE
		}
		return Arrays.copyOfRange(array, 0, i);
	}

	/**
	 * Converts a {@code PrimitiveIterator.OfLong} to an array of {@code long}. This
	 * method uses a default estimated size of 10.
	 * 
	 * <p>
	 * This method will create an array with a default estimated size of 10 and
	 * populate it with elements from the iterator. If the iterator provides more
	 * elements than the default estimated size, the array will be resized
	 * dynamically. If the iterator provides fewer elements, the resulting array
	 * will be trimmed to fit the actual number of elements.
	 * </p>
	 * 
	 * <p>
	 * Usage Example:
	 * </p>
	 * 
	 * <pre>
	 * <code>
	 * PrimitiveIterator.OfLong longIterator = Arrays.asList(1L, 2L, 3L).stream().mapToLong(Long::longValue).iterator();
	 * long[] longArray = Utility.toArray(longIterator);
	 * 
	 * // Output: [1, 2, 3]
	 * System.out.println(Arrays.toString(longArray));
	 * </code>
	 * </pre>
	 * 
	 * @param iterator the iterator providing the long values
	 * @return an array containing all long values provided by the iterator
	 * @throws NullPointerException if the specified iterator is null
	 * @see #toArray(PrimitiveIterator.OfLong, int)
	 */
	public static <T> long[] toArray(PrimitiveIterator.OfLong iterator) {
		return toArray(iterator, 10);
	}

	/**
	 * Converts a {@code PrimitiveIterator.OfLong} to an array of {@code long}. This
	 * method allows for an estimated size of the array to be specified to optimize
	 * performance.
	 * 
	 * <p>
	 * This method will create an array of the specified estimated size and populate
	 * it with elements from the iterator. If the iterator provides more elements
	 * than the estimated size, the array will be resized dynamically. If the
	 * iterator provides fewer elements than the estimated size, the resulting array
	 * will be trimmed to fit the actual number of elements.
	 * </p>
	 * 
	 * <p>
	 * Usage Example:
	 * </p>
	 * 
	 * <pre>
	 * <code>
	 * PrimitiveIterator.OfLong longIterator = Arrays.asList(1L, 2L, 3L).stream().mapToLong(Long::longValue).iterator();
	 * long[] longArray = Utility.toArray(longIterator, 3);
	 * 
	 * // Output: [1, 2, 3]
	 * System.out.println(Arrays.toString(longArray));
	 * </code>
	 * </pre>
	 * 
	 * @param iterator      the iterator providing the long values
	 * @param estimatedSize an estimate of the number of elements the iterator will
	 *                      provide
	 * @return an array containing all long values provided by the iterator
	 * @throws NullPointerException if the specified iterator is null
	 */
	public static long[] toArray(PrimitiveIterator.OfLong iterator, int estimatedSize) {
		if (!iterator.hasNext())
			return new long[]{};
		long[] array = new long[estimatedSize];
		int i = 0;
		while (iterator.hasNext()) {
			if (i >= array.length)
				array = Arrays.copyOf(array, array.length * 2);
			array[i++] = iterator.nextLong();
			if (i < 0)
				return array;// We are at Integer.MAX_VALUE
		}
		return Arrays.copyOfRange(array, 0, i);
	}

	/**
	 * Converts a {@code PrimitiveIterator.OfInt} to an array of {@code int}. This
	 * method uses a default estimated size of 10.
	 * 
	 * <p>
	 * This method will create an array with a default estimated size of 10 and
	 * populate it with elements from the iterator. If the iterator provides more
	 * elements than the default estimated size, the array will be resized
	 * dynamically. If the iterator provides fewer elements, the resulting array
	 * will be trimmed to fit the actual number of elements.
	 * </p>
	 * 
	 * <p>
	 * Usage Example:
	 * </p>
	 * 
	 * <pre>
	 * <code>
	 * PrimitiveIterator.OfInt intIterator = Arrays.asList(1, 2, 3).stream().mapToInt(Integer::intValue).iterator();
	 * int[] intArray = Utility.toArray(intIterator);
	 * 
	 * // Output: [1, 2, 3]
	 * System.out.println(Arrays.toString(intArray));
	 * </code>
	 * </pre>
	 * 
	 * @param iterator the iterator providing the int values
	 * @return an array containing all int values provided by the iterator
	 * @throws NullPointerException if the specified iterator is null
	 * @see #toArray(PrimitiveIterator.OfInt, int)
	 */
	public static <T> int[] toArray(PrimitiveIterator.OfInt iterator) {
		return toArray(iterator, 10);
	}

	/**
	 * Converts a {@code PrimitiveIterator.OfInt} to an array of {@code int}. This
	 * method allows for an estimated size of the array to be specified to optimize
	 * performance.
	 * 
	 * <p>
	 * This method will create an array of the specified estimated size and populate
	 * it with elements from the iterator. If the iterator provides more elements
	 * than the estimated size, the array will be resized dynamically. If the
	 * iterator provides fewer elements than the estimated size, the resulting array
	 * will be trimmed to fit the actual number of elements.
	 * </p>
	 * 
	 * <p>
	 * Usage Example:
	 * </p>
	 * 
	 * <pre>
	 * <code>
	 * PrimitiveIterator.OfInt intIterator = Arrays.asList(1, 2, 3).stream().mapToInt(Integer::intValue).iterator();
	 * int[] intArray = Utility.toArray(intIterator, 3);
	 * 
	 * // Output: [1, 2, 3]
	 * System.out.println(Arrays.toString(intArray));
	 * </code>
	 * </pre>
	 * 
	 * @param iterator      the iterator providing the int values
	 * @param estimatedSize an estimate of the number of elements the iterator will
	 *                      provide
	 * @return an array containing all int values provided by the iterator
	 * @throws NullPointerException if the specified iterator is null
	 */
	public static int[] toArray(PrimitiveIterator.OfInt iterator, int estimatedSize) {
		if (!iterator.hasNext())
			return new int[]{};
		int[] array = new int[estimatedSize];
		int i = 0;
		while (iterator.hasNext()) {
			if (i >= array.length)
				array = Arrays.copyOf(array, array.length * 2);
			array[i++] = iterator.nextInt();
			if (i < 0)
				return array;// We are at Integer.MAX_VALUE
		}
		return i >= estimatedSize ? array : Arrays.copyOfRange(array, 0, i);
	}

	/**
	 * Converts a {@code PrimitiveIterator.OfFloat} to an array of {@code float}.
	 * This method uses a default estimated size of 10.
	 * 
	 * <p>
	 * This method will create an array with a default estimated size of 10 and
	 * populate it with elements from the iterator. If the iterator provides more
	 * elements than the default estimated size, the array will be resized
	 * dynamically. If the iterator provides fewer elements, the resulting array
	 * will be trimmed to fit the actual number of elements.
	 * </p>
	 * 
	 * @param iterator the iterator providing the float values
	 * @return an array containing all float values provided by the iterator
	 * @throws NullPointerException if the specified iterator is null
	 * @see #toArray(PrimitiveIterator.OfFloat, int)
	 */
	public static <T> float[] toArray(PrimitiveIterator.OfFloat iterator) {
		return toArray(iterator, 10);
	}

	/**
	 * Converts a {@code PrimitiveIterator.OfFloat} to an array of {@code float}.
	 * This method allows for an estimated size of the array to be specified to
	 * optimize performance.
	 * 
	 * <p>
	 * This method will create an array of the specified estimated size and populate
	 * it with elements from the iterator. If the iterator provides more elements
	 * than the estimated size, the array will be resized dynamically. If the
	 * iterator provides fewer elements than the estimated size, the resulting array
	 * will be trimmed to fit the actual number of elements.
	 * </p>
	 * 
	 * @param iterator      the iterator providing the float values
	 * @param estimatedSize an estimate of the number of elements the iterator will
	 *                      provide
	 * @return an array containing all float values provided by the iterator
	 * @throws NullPointerException if the specified iterator is null
	 */
	public static float[] toArray(PrimitiveIterator.OfFloat iterator, int estimatedSize) {
		if (!iterator.hasNext())
			return new float[] {};
		float[] array = new float[estimatedSize];
		int i = 0;
		while (iterator.hasNext()) {
			if (i >= array.length)
				array = Arrays.copyOf(array, array.length * 2);
			array[i++] = iterator.nextFloat();
			if (i < 0)
				return array;// We are at Floateger.MAX_VALUE
		}
		return Arrays.copyOfRange(array, 0, i);
	}

	/**
	 * Converts a {@code PrimitiveIterator.OfShort} to an array of {@code short}.
	 * This method uses a default estimated size of 10.
	 * 
	 * <p>
	 * This method will create an array with a default estimated size of 10 and
	 * populate it with elements from the iterator. If the iterator provides more
	 * elements than the default estimated size, the array will be resized
	 * dynamically. If the iterator provides fewer elements, the resulting array
	 * will be trimmed to fit the actual number of elements.
	 * </p>
	 * 
	 * @param iterator the iterator providing the {@code short} values
	 * @return an array containing all {@code short} values provided by the iterator
	 * @throws NullPointerException if the specified iterator is null
	 * @see #toArray(PrimitiveIterator.OfShort, int)
	 */
	public static <T> short[] toArray(PrimitiveIterator.OfShort iterator) {
		return toArray(iterator, 10);
	}

	/**
	 * Converts a {@code PrimitiveIterator.OfShort} to an array of {@code short}.
	 * This method allows for an estimated size of the array to be specified to
	 * optimize performance.
	 * 
	 * <p>
	 * This method will create an array of the specified estimated size and populate
	 * it with elements from the iterator. If the iterator provides more elements
	 * than the estimated size, the array will be resized dynamically. If the
	 * iterator provides fewer elements than the estimated size, the resulting array
	 * will be trimmed to fit the actual number of elements.
	 * </p>
	 * 
	 * @param iterator      the iterator providing the {@code short} values
	 * @param estimatedSize an estimate of the number of elements the iterator will
	 *                      provide
	 * @return an array containing all {@code short} values provided by the iterator
	 * @throws NullPointerException if the specified iterator is null
	 */
	public static short[] toArray(PrimitiveIterator.OfShort iterator, int estimatedSize) {
		if (!iterator.hasNext())
			return new short[] {};
		short[] array = new short[estimatedSize];
		int i = 0;
		while (iterator.hasNext()) {
			if (i >= array.length)
				array = Arrays.copyOf(array, array.length * 2);
			array[i++] = iterator.nextShort();
			if (i < 0)
				return array;// We are at Shorteger.MAX_VALUE
		}
		return Arrays.copyOfRange(array, 0, i);
	}

	/**
	 * Converts a {@code PrimitiveIterator.OfChar} to an array of {@code char}. This
	 * method uses a default estimated size of 10.
	 * 
	 * <p>
	 * This method will create an array with a default estimated size of 10 and
	 * populate it with elements from the iterator. If the iterator provides more
	 * elements than the default estimated size, the array will be resized
	 * dynamically. If the iterator provides fewer elements, the resulting array
	 * will be trimmed to fit the actual number of elements.
	 * </p>
	 * 
	 * @param iterator the iterator providing the {@code char} values
	 * @return an array containing all {@code char} values provided by the iterator
	 * @throws NullPointerException if the specified iterator is null
	 * @see #toArray(PrimitiveIterator.OfChar, int)
	 */
	public static <T> char[] toArray(PrimitiveIterator.OfChar iterator) {
		return toArray(iterator, 10);
	}

	/**
	 * Converts a {@code PrimitiveIterator.OfChar} to an array of {@code char}. This
	 * method allows for an estimated size of the array to be specified to optimize
	 * performance.
	 * 
	 * <p>
	 * This method will create an array of the specified estimated size and populate
	 * it with elements from the iterator. If the iterator provides more elements
	 * than the estimated size, the array will be resized dynamically. If the
	 * iterator provides fewer elements than the estimated size, the resulting array
	 * will be trimmed to fit the actual number of elements.
	 * </p>
	 * 
	 * @param iterator      the iterator providing the {@code char} values
	 * @param estimatedSize an estimate of the number of elements the iterator will
	 *                      provide
	 * @return an array containing all {@code char} values provided by the iterator
	 * @throws NullPointerException if the specified iterator is null
	 */
	public static char[] toArray(PrimitiveIterator.OfChar iterator, int estimatedSize) {
		if (!iterator.hasNext())
			return new char[] {};
		char[] array = new char[estimatedSize];
		int i = 0;
		while (iterator.hasNext()) {
			if (i >= array.length)
				array = Arrays.copyOf(array, array.length * 2);
			array[i++] = iterator.nextChar();
			if (i < 0)
				return array;// We are at Chareger.MAX_VALUE
		}
		return Arrays.copyOfRange(array, 0, i);
	}

	/**
	 * Converts a {@code PrimitiveIterator.OfByte} to an array of {@code byte}. This
	 * method uses a default estimated size of 10.
	 * 
	 * <p>
	 * This method will create an array with a default estimated size of 10 and
	 * populate it with elements from the iterator. If the iterator provides more
	 * elements than the default estimated size, the array will be resized
	 * dynamically. If the iterator provides fewer elements, the resulting array
	 * will be trimmed to fit the actual number of elements.
	 * </p>
	 * 
	 * @param iterator the iterator providing the {@code byte} values
	 * @return an array containing all {@code byte} values provided by the iterator
	 * @throws NullPointerException if the specified iterator is null
	 * @see #toArray(PrimitiveIterator.OfByte, int)
	 */
	public static <T> byte[] toArray(PrimitiveIterator.OfByte iterator) {
		return toArray(iterator, 10);
	}

	/**
	 * Converts a {@code PrimitiveIterator.OfByte} to an array of {@code byte}. This
	 * method allows for an estimated size of the array to be specified to optimize
	 * performance.
	 * 
	 * <p>
	 * This method will create an array of the specified estimated size and populate
	 * it with elements from the iterator. If the iterator provides more elements
	 * than the estimated size, the array will be resized dynamically. If the
	 * iterator provides fewer elements than the estimated size, the resulting array
	 * will be trimmed to fit the actual number of elements.
	 * </p>
	 * 
	 * @param iterator      the iterator providing the {@code byte} values
	 * @param estimatedSize an estimate of the number of elements the iterator will
	 *                      provide
	 * @return an array containing all {@code byte} values provided by the iterator
	 * @throws NullPointerException if the specified iterator is null
	 */
	public static byte[] toArray(PrimitiveIterator.OfByte iterator, int estimatedSize) {
		if (!iterator.hasNext())
			return new byte[] {};
		byte[] array = new byte[estimatedSize];
		int i = 0;
		while (iterator.hasNext()) {
			if (i >= array.length)
				array = Arrays.copyOf(array, array.length * 2);
			array[i++] = iterator.nextByte();
			if (i < 0)
				return array;// We are at Byteeger.MAX_VALUE
		}
		return Arrays.copyOfRange(array, 0, i);
	}

	/**
	 * Converts a {@code PrimitiveIterator.OfBoolean} to an array of
	 * {@code boolean}. This method uses a default estimated size of 10.
	 * 
	 * <p>
	 * This method will create an array with a default estimated size of 10 and
	 * populate it with elements from the iterator. If the iterator provides more
	 * elements than the default estimated size, the array will be resized
	 * dynamically. If the iterator provides fewer elements, the resulting array
	 * will be trimmed to fit the actual number of elements.
	 * </p>
	 * 
	 * @param iterator the iterator providing the {@code boolean} values
	 * @return an array containing all {@code boolean} values provided by the
	 *         iterator
	 * @throws NullPointerException if the specified iterator is null
	 * @see #toArray(PrimitiveIterator.OfBoolean, int)
	 */
	public static <T> boolean[] toArray(PrimitiveIterator.OfBoolean iterator) {
		return toArray(iterator, 10);
	}

	/**
	 * Converts a {@code PrimitiveIterator.OfBoolean} to an array of
	 * {@code boolean}. This method allows for an estimated size of the array to be
	 * specified to optimize performance.
	 * 
	 * <p>
	 * This method will create an array of the specified estimated size and populate
	 * it with elements from the iterator. If the iterator provides more elements
	 * than the estimated size, the array will be resized dynamically. If the
	 * iterator provides fewer elements than the estimated size, the resulting array
	 * will be trimmed to fit the actual number of elements.
	 * </p>
	 * 
	 * @param iterator      the iterator providing the {@code boolean} values
	 * @param estimatedSize an estimate of the number of elements the iterator will
	 *                      provide
	 * @return an array containing all {@code boolean} values provided by the
	 *         iterator
	 * @throws NullPointerException if the specified iterator is null
	 */
	public static boolean[] toArray(PrimitiveIterator.OfBoolean iterator, int estimatedSize) {
		if (!iterator.hasNext())
			return new boolean[] {};
		boolean[] array = new boolean[estimatedSize];
		int i = 0;
		while (iterator.hasNext()) {
			if (i >= array.length)
				array = Arrays.copyOf(array, array.length * 2);
			array[i++] = iterator.nextBoolean();
			if (i < 0)
				return array;// We are at Integer.MAX_VALUE
		}
		return Arrays.copyOfRange(array, 0, i);
	}

	/*
	 * Date created: 26 May 2024
	 * Time created: 17:36:59
	 */
	/**
	 * Creates a stream from an iterator of doubles.
	 * @param iterator the iterator that from which the stream is generated
	 * @return a stream of doubles from the given iterator. Will return an empty stream of no elements remain in the iterator.
	 */
	public static DoubleStream stream(java.util.PrimitiveIterator.OfDouble iterator) {
		try {
			return DoubleStream.iterate(iterator.nextDouble(), d -> iterator.hasNext(), d -> iterator.nextDouble());
		} catch (NoSuchElementException e) {
			return DoubleStream.empty();
		}
	}

	/*
	 * Date created: 26 May 2024
	 * Time created: 17:36:59
	 */
	/**
	 * Creates a stream from an iterator of longs.
	 * @param iterator the iterator that from which the stream is generated
	 * @return a stream of longs from the given iterator. Will return an empty stream of no elements remain in the iterator.
	 */
	public static LongStream stream(java.util.PrimitiveIterator.OfLong iterator) {
		try {
			return LongStream.iterate(iterator.nextLong(), d -> iterator.hasNext(), d -> iterator.nextLong());
		} catch (NoSuchElementException e) {
			return LongStream.empty();
		}
	}

	/*
	 * Date created: 26 May 2024
	 * Time created: 17:36:59
	 */
	/**
	 * Creates a stream from an iterator of ints.
	 * @param iterator the iterator that from which the stream is generated
	 * @return a stream of ints from the given iterator. Will return an empty stream of no elements remain in the iterator.
	 */
	public static IntStream stream(java.util.PrimitiveIterator.OfInt iterator) {
		try {
			return IntStream.iterate(iterator.nextInt(), d -> iterator.hasNext(), d -> iterator.nextInt());
		} catch (NoSuchElementException e) {
			return IntStream.empty();
		}
	}
	/**
	 * Creates an array that removes and returns the first element on every
	 * successful {@link Iterator#next()}. After
	 * this method returns, the input array will be exhausted i.e will be empty.
	 * <p>
	 * An empty array will throw a {@link IllegalStateException} when an
	 * attempt to access an element is made from the returned iterator.
	 * @param <T> the type of elements in the given array
	 * @param array the array to be used to create the iterator
	 * @return an iterator that consumes it elements
	 * @alpa Not realeased to the public yet
	 */
	public static <T> Iterator<T> consume(T[] array) {
		return new Iterator<T>() {
			private T[] a = array;
			private boolean isExhausted = false;
			public boolean hasNext() { return a.length > 0; }
			@SuppressWarnings("unchecked")
			public T next() {
				if(!hasNext()) throw new IllegalStateException("No more elements remaining");
				T e = isExhausted ? ((T[]) new Object[]{})[0] : a[0];
				if(a.length > 1)
				System.arraycopy(a, 1, a, 0, a.length - 1);
				else isExhausted = true;
				System.err.println(a.length);
				return e;
			}
		};
	}
	/**
	 * Creates an array that removes and returns the first element on every
	 * successful {@link PrimtitiveIterator.OfDouble#nextDouble()}. After
	 * this method returns, the input array will be exhausted i.e will be empty.
	 * <p>
	 * An empty array will throw a {@link IllegalStateException} when an
	 * attempt to access an element is made from the returned iterator.
	 * @param array the array to be used to create the iterator
	 * @return an iterator that consumes it elements
	 * @alpha Not released to the public yet
	 */
	PrimitiveIterator.OfDouble consume(double[] array) {
		return new PrimitiveIterator.OfDouble() {
			private double[] a = array;
			public boolean hasNext() { return a.length > 0; }
			public double nextDouble() {
				if(!hasNext()) throw new IllegalStateException("No more elements remaining");
				double e = a[0];
				if(a.length > 1)
				System.arraycopy(a, 1, a, 0, a.length - 1);
				else a = new double[]{};
				return e;
			}
		};
	}
	/**
	 * Creates an array that removes and returns the first element on every
	 * successful {@link PrimtitiveIterator.OfLong#nextLong()}. After
	 * this method returns, the input array will be exhausted i.e will be empty.
	 * <p>
	 * An empty array will throw a {@link IllegalStateException} when an
	 * attempt to access an element is made from the returned iterator.
	 * @param array the array to be used to create the iterator
	 * @return an iterator that consumes it elements
	 * @alpha Not released to the public yet
	 */
	PrimitiveIterator.OfLong consume(long[] array) {
		return new PrimitiveIterator.OfLong() {
			private long[] a = array;
			public boolean hasNext() { return a.length > 0; }
			public long nextLong() {
				if(!hasNext()) throw new IllegalStateException("No more elements remaining");
				long e = a[0];
				if(a.length > 1)
				System.arraycopy(a, 1, a, 0, a.length - 1);
				else a = new long[]{};
				return e;
			}
		};
	}
	/**
	 * Creates an array that removes and returns the first element on every
	 * successful {@link PrimtitiveIterator.OfInt#nextInt()}. After
	 * this method returns, the input array will be exhausted i.e will be empty.
	 * <p>
	 * An empty array will throw a {@link IllegalStateException} when an
	 * attempt to access an element is made from the returned iterator.
	 * @param array the array to be used to create the iterator
	 * @return an iterator that consumes it elements
	 * @alpha Not released to the public yet
	 */
	PrimitiveIterator.OfInt consume(int[] array) {
		return new PrimitiveIterator.OfInt() {
			private int[] a = array;
			public boolean hasNext() { return a.length > 0; }
			public int nextInt() {
				if(!hasNext()) throw new IllegalStateException("No more elements remaining");
				int e = a[0];
				if(a.length > 1)
				System.arraycopy(a, 1, a, 0, a.length - 1);
				else a = new int[]{};
				return e;
			}
		};
	}
	/**
	 * Creates an array that removes and returns the first element on every
	 * successful {@link PrimtitiveIterator.OfFloat#nextFloat()}. After
	 * this method returns, the input array will be exhausted i.e will be empty.
	 * <p>
	 * An empty array will throw a {@link IllegalStateException} when an
	 * attempt to access an element is made from the returned iterator.
	 * @param array the array to be used to create the iterator
	 * @return an iterator that consumes it elements
	 * @alpha Not released to the public yet
	 */
	PrimitiveIterator.OfFloat consume(float[] array) {
		return new PrimitiveIterator.OfFloat() {
			private float[] a = array;
			public boolean hasNext() { return a.length > 0; }
			public float nextFloat() {
				if(!hasNext()) throw new IllegalStateException("No more elements remaining");
				float e = a[0];
				if(a.length > 1)
				System.arraycopy(a, 1, a, 0, a.length - 1);
				else a = new float[]{};
				return e;
			}
		};
	}
	/**
	 * Creates an array that removes and returns the first element on every
	 * successful {@link PrimtitiveIterator.OfChar#nextChar()}. After
	 * this method returns, the input array will be exhausted i.e will be empty.
	 * <p>
	 * An empty array will throw a {@link IllegalStateException} when an
	 * attempt to access an element is made from the returned iterator.
	 * @param array the array to be used to create the iterator
	 * @return an iterator that consumes it elements
	 * @alpha Not released to the public yet
	 */
	PrimitiveIterator.OfChar consume(char[] array) {
		return new PrimitiveIterator.OfChar() {
			private char[] a = array;
			public boolean hasNext() { return a.length > 0; }
			public char nextChar() {
				if(!hasNext()) throw new IllegalStateException("No more elements remaining");
				char e = a[0];
				if(a.length > 1)
				System.arraycopy(a, 1, a, 0, a.length - 1);
				else a = new char[]{};
				return e;
			}
		};
	}
	/**
	 * Creates an array that removes and returns the first element on every
	 * successful {@link PrimtitiveIterator.OfShort#nextShort()}. After
	 * this method returns, the input array will be exhausted i.e will be empty.
	 * <p>
	 * An empty array will throw a {@link IllegalStateException} when an
	 * attempt to access an element is made from the returned iterator.
	 * @param array the array to be used to create the iterator
	 * @return an iterator that consumes it elements
	 * @alpha Not released to the public yet
	 */
	PrimitiveIterator.OfShort consume(short[] array) {
		return new PrimitiveIterator.OfShort() {
			private short[] a = array;
			public boolean hasNext() { return a.length > 0; }
			public short nextShort() {
				if(!hasNext()) throw new IllegalStateException("No more elements remaining");
				short e = a[0];
				if(a.length > 1)
				System.arraycopy(a, 1, a, 0, a.length - 1);
				else a = new short[]{};
				return e;
			}
		};
	}
	/**
	 * Creates an array that removes and returns the first element on every
	 * successful {@link PrimtitiveIterator.OfByte#nextByte()}. After
	 * this method returns, the input array will be exhausted i.e will be empty.
	 * <p>
	 * An empty array will throw a {@link IllegalStateException} when an
	 * attempt to access an element is made from the returned iterator.
	 * @param array the array to be used to create the iterator
	 * @return an iterator that consumes it elements
	 * @alpha Not released to the public yet
	 */
	PrimitiveIterator.OfByte consume(byte[] array) {
		return new PrimitiveIterator.OfByte() {
			private byte[] a = array;
			public boolean hasNext() { return a.length > 0; }
			public byte nextByte() {
				if(!hasNext()) throw new IllegalStateException("No more elements remaining");
				byte e = a[0];
				if(a.length > 1)
				System.arraycopy(a, 1, a, 0, a.length - 1);
				else a = new byte[]{};
				return e;
			}
		};
	}
	/**
	 * Creates an array that removes and returns the first element on every
	 * successful {@link PrimtitiveIterator.OfBoolean#nextBoolean()}. After
	 * this method returns, the input array will be exhausted i.e will be empty.
	 * <p>
	 * An empty array will throw a {@link IllegalStateException} when an
	 * attempt to access an element is made from the returned iterator.
	 * @param array the array to be used to create the iterator
	 * @return an iterator that consumes it elements
	 * @alpha Not released to the public yet
	 */
	PrimitiveIterator.OfBoolean consume(boolean[] array) {
		return new PrimitiveIterator.OfBoolean() {
			private boolean[] a = array;
			public boolean hasNext() { return a.length > 0; }
			public boolean nextBoolean() {
				if(!hasNext()) throw new IllegalStateException("No more elements remaining");
				boolean e = a[0];
				if(a.length > 1)
				System.arraycopy(a, 1, a, 0, a.length - 1);
				else a = new boolean[]{};
				return e;
			}
		};
	}
	/**
	 * Performs the same operation as {@link #consume(T[])} but in reverse.
	 * @param <T> the type of elements in the given array
	 * @param array a {@code T} array
	 * @return an iterator that consumes it's elements in reverse
	 * @alpha Not released to the public yet
	 */
	static <T> Iterator<T> consumeReverse(T[] array) {
		return new Iterator<T>() {
			public boolean hasNext() { return array.length > 0; }
			public T next() {
				if(!hasNext()) throw new IllegalStateException("No more elements in this iterator");
				T e = array[array.length - 1];
				System.arraycopy(array, 0, array, 0, array.length - 1);
				return e;
			}
		};
	}
	/**
	 * Performs the same operation as {@link #consume(double[])} but in reverse.
	 * @param array a {@code double} array
	 * @return an iterator that consumes it's elements in reverse
	 * @alpha Not released to the public yet
	 */
	static PrimitiveIterator.OfDouble consumeReverse(double[] array) {
		return new PrimitiveIterator.OfDouble() {
			public boolean hasNext() { return array.length > 0; }
			public double nextDouble() {
				if(!hasNext()) throw new IllegalStateException("No more elements in this iterator");
				double e = array[array.length - 1];
				System.arraycopy(array, 0, array, 0, array.length - 1);
				return e;
			}
		};
	}
	/**
	 * Performs the same operation as {@link #consume(long[])} but in reverse.
	 * @param array a {@code long} array
	 * @return an iterator that consumes it's elements in reverse
	 * @alpha Not released to the public yet
	 */
	static PrimitiveIterator.OfLong consumeReverse(long[] array) {
		return new PrimitiveIterator.OfLong() {
			public boolean hasNext() { return array.length > 0; }
			public long nextLong() {
				if(!hasNext()) throw new IllegalStateException("No more elements in this iterator");
				long e = array[array.length - 1];
				System.arraycopy(array, 0, array, 0, array.length - 1);
				return e;
			}
		};
	}
	/**
	 * Performs the same operation as {@link #consume(int[])} but in reverse.
	 * @param array a {@code int} array
	 * @return an iterator that consumes it's elements in reverse
	 * @alpha Not released to the public yet
	 */
	static PrimitiveIterator.OfInt consumeReverse(int[] array) {
		return new PrimitiveIterator.OfInt() {
			public boolean hasNext() { return array.length > 0; }
			public int nextInt() {
				if(!hasNext()) throw new IllegalStateException("No more elements in this iterator");
				int e = array[array.length - 1];
				System.arraycopy(array, 0, array, 0, array.length - 1);
				return e;
			}
		};
	}
	/**
	 * Performs the same operation as {@link #consume(float[])} but in reverse.
	 * @param array a {@code float} array
	 * @return an iterator that consumes it's elements in reverse
	 * @alpha Not released to the public yet
	 */
	static PrimitiveIterator.OfFloat consumeReverse(float[] array) {
		return new PrimitiveIterator.OfFloat() {
			public boolean hasNext() { return array.length > 0; }
			public float nextFloat() {
				if(!hasNext()) throw new IllegalStateException("No more elements in this iterator");
				float e = array[array.length - 1];
				System.arraycopy(array, 0, array, 0, array.length - 1);
				return e;
			}
		};
	}
	/**
	 * Performs the same operation as {@link #consume(char[])} but in reverse.
	 * @param array a {@code char} array
	 * @return an iterator that consumes it's elements in reverse
	 * @alpha Not released to the public yet
	 */
	static PrimitiveIterator.OfChar consumeReverse(char[] array) {
		return new PrimitiveIterator.OfChar() {
			public boolean hasNext() { return array.length > 0; }
			public char nextChar() {
				if(!hasNext()) throw new IllegalStateException("No more elements in this iterator");
				char e = array[array.length - 1];
				System.arraycopy(array, 0, array, 0, array.length - 1);
				return e;
			}
		};
	}
	/**
	 * Performs the same operation as {@link #consume(short[])} but in reverse.
	 * @param array a {@code short} array
	 * @return an iterator that consumes it's elements in reverse
	 * @alpha Not released to the public yet
	 */
	static PrimitiveIterator.OfShort consumeReverse(short[] array) {
		return new PrimitiveIterator.OfShort() {
			public boolean hasNext() { return array.length > 0; }
			public short nextShort() {
				if(!hasNext()) throw new IllegalStateException("No more elements in this iterator");
				short e = array[array.length - 1];
				System.arraycopy(array, 0, array, 0, array.length - 1);
				return e;
			}
		};
	}
	/**
	 * Performs the same operation as {@link #consume(byte[])} but in reverse.
	 * @param array a {@code byte} array
	 * @return an iterator that consumes it's elements in reverse
	 * @alpha Not released to the public yet
	 */
	static PrimitiveIterator.OfByte consumeReverse(byte[] array) {
		return new PrimitiveIterator.OfByte() {
			public boolean hasNext() { return array.length > 0; }
			public byte nextByte() {
				if(!hasNext()) throw new IllegalStateException("No more elements in this iterator");
				byte e = array[array.length - 1];
				System.arraycopy(array, 0, array, 0, array.length - 1);
				return e;
			}
		};
	}
	/**
	 * Performs the same operation as {@link #consume(boolean[])} but in reverse.
	 * @param array a {@code boolean} array
	 * @return an iterator that consumes it's elements in reverse
	 * @alpha Not released to the public yet
	 */
	static PrimitiveIterator.OfBoolean consumeReverse(boolean[] array) {
		return new PrimitiveIterator.OfBoolean() {
			public boolean hasNext() { return array.length > 0; }
			public boolean nextBoolean() {
				if(!hasNext()) throw new IllegalStateException("No more elements in this iterator");
				boolean e = array[array.length - 1];
				System.arraycopy(array, 0, array, 0, array.length - 1);
				return e;
			}
		};
	}
	/**
	 * Performs the reverse of the {@link #i(T[])} operation.
	 * @param <T> the type of elements in the given array
	 * @param array the array to be transformed to an iterator
	 * @return an iterator that does a backward-only traversal on the elements in the argument
	 */
	public static <T> Iterator<T> reverseItr(T[] array) {
		return new Iterator<T>() {
			private int index = array.length - 1;
			public boolean hasNext() { return index >= 0; }
			public T next() {
				if(!hasNext()) throw new NoSuchElementException();
				T e = array[index--];
				return e;
			}
		};
	}
	/**
	 * Performs the reverse of the {@link #i(double[])} operation.
	 * @param array the array to be transformed to an iterator
	 * @return an iterator that does a backward-only traversal on the elements in the argument
	 */
	public static PrimitiveIterator.OfDouble reverseItr(double[] array) {
		return new PrimitiveIterator.OfDouble() {
			private int index = array.length - 1;
			public boolean hasNext() { return index >= 0; }
			public double nextDouble() {
				if(!hasNext()) throw new NoSuchElementException();
				double e = array[index--];
				return e;
			}
		};
	}
	/**
	 * Performs the reverse of the {@link #i(long[])} operation.
	 * @param array the array to be transformed to an iterator
	 * @return an iterator that does a backward-only traversal on the elements in the argument
	 */
	public static PrimitiveIterator.OfLong reverseItr(long[] array) {
		return new PrimitiveIterator.OfLong() {
			private int index = array.length - 1;
			public boolean hasNext() { return index >= 0; }
			public long nextLong() {
				if(!hasNext()) throw new NoSuchElementException();
				long e = array[index--];
				return e;
			}
		};
	}
	/**
	 * Performs the reverse of the {@link #i(int[])} operation.
	 * @param array the array to be transformed to an iterator
	 * @return an iterator that does a backward-only traversal on the elements in the argument
	 */
	public static PrimitiveIterator.OfInt reverseItr(int[] array) {
		return new PrimitiveIterator.OfInt() {
			private int index = array.length - 1;
			public boolean hasNext() { return index >= 0; }
			public int nextInt() {
				if(!hasNext()) throw new NoSuchElementException();
				int e = array[index--];
				return e;
			}
		};
	}
	/**
	 * Performs the reverse of the {@link #i(float[])} operation.
	 * @param array the array to be transformed to an iterator
	 * @return an iterator that does a backward-only traversal on the elements in the argument
	 */
	public static PrimitiveIterator.OfFloat reverseItr(float[] array) {
		return new PrimitiveIterator.OfFloat() {
			private int index = array.length - 1;
			public boolean hasNext() { return index >= 0; }
			public float nextFloat() {
				if(!hasNext()) throw new NoSuchElementException();
				float e = array[index--];
				return e;
			}
		};
	}
	/**
	 * Performs the reverse of the {@link #i(char[])} operation.
	 * @param array the array to be transformed to an iterator
	 * @return an iterator that does a backward-only traversal on the elements in the argument
	 */
	public static PrimitiveIterator.OfChar reverseItr(char[] array) {
		return new PrimitiveIterator.OfChar() {
			private int index = array.length - 1;
			public boolean hasNext() { return index >= 0; }
			public char nextChar() {
				if(!hasNext()) throw new NoSuchElementException();
				char e = array[index--];
				return e;
			}
		};
	}
	/**
	 * Performs the reverse of the {@link #i(short[])} operation.
	 * @param array the array to be transformed to an iterator
	 * @return an iterator that does a backward-only traversal on the elements in the argument
	 */
	public static PrimitiveIterator.OfShort reverseItr(short[] array) {
		return new PrimitiveIterator.OfShort() {
			private int index = array.length - 1;
			public boolean hasNext() { return index >= 0; }
			public short nextShort() {
				if(!hasNext()) throw new NoSuchElementException();
				short e = array[index--];
				return e;
			}
		};
	}
	/**
	 * Performs the reverse of the {@link #i(byte[])} operation.
	 * @param array the array to be transformed to an iterator
	 * @return an iterator that does a backward-only traversal on the elements in the argument
	 */
	public static PrimitiveIterator.OfByte reverseItr(byte[] array) {
		return new PrimitiveIterator.OfByte() {
			private int index = array.length - 1;
			public boolean hasNext() { return index >= 0; }
			public byte nextByte() {
				if(!hasNext()) throw new NoSuchElementException();
				byte e = array[index--];
				return e;
			}
		};
	}
	/**
	 * Performs the reverse of the {@link #i(boolean[])} operation.
	 * @param array the array to be transformed to an iterator
	 * @return an iterator that does a backward-only traversal on the elements in the argument
	 */
	public static PrimitiveIterator.OfBoolean reverseItr(boolean[] array) {
		return new PrimitiveIterator.OfBoolean() {
			private int index = array.length - 1;
			public boolean hasNext() { return index >= 0; }
			public boolean nextBoolean() {
				if(!hasNext()) throw new NoSuchElementException();
				boolean e = array[index--];
				return e;
			}
		};
	}
	/**
	 * Returns an {@code Iterator} whose {@link Iterator#remove() remove} method
	 * will attempt to remove an element from the underlying array according to
	 * the rules of iteration in java.
	 * @param <T> the type of the elements in the given array
	 * @param array the underlying (backing) array
	 * @return a mutable iterator whose mutable methods will not throw an
	 * exception when {@link Iterator#remove()} is called within the bounds
	 * of the {@code Iterator}'s rules.
	 * @see Iterator#remove()
	 * @throws IllegalStateException if {@code PrimitiveIterator.nextDouble()} was not called prior to {@code Iterator.remove()}
	 * @throws IllegalStateException if no elements remain in the backing array
	 * @alpha Since array lengths are immutable, it is not logical to have a mutableIterator over an array
	 */
	static <T> Iterator<T> mi(T[] array) {
		return new Iterator<T>() {
			private int i = 0;
			private boolean next = false;
			public boolean hasNext() { return i < array.length; }
			public T next() { next = true; return array[i++]; }
			public void remove() {
				if(!next) throw new IllegalStateException("next must precede this call");
				if(array.length < 1) throw new IllegalStateException("No more elements remaining");
				System.arraycopy(array, i, array, i - 1, array.length - i--);
				next = false;
			}
		};
	}
	/**
	 * Returns an {@code Iterator} whose {@link Iterator#remove() remove} method
	 * will attempt to remove an element from the underlying array according to
	 * the rules of iteration in java.
	 * @param array the underlying (backing) array
	 * @return a mutable iterator whose mutable methods will not throw an
	 * exception when {@link Iterator#remove()} is called within the bounds
	 * of the {@code Iterator}'s rules.
	 * @see Iterator#remove()
	 * @throws IllegalStateException if {@code PrimitiveIterator.nextDouble()} was not called prior to {@code Iterator.remove()}
	 * @throws IllegalStateException if no elements remain in the backing array
	 * @alpha Since array lengths are immutable, it is not logical to have a mutableIterator over an array
	 */
	static PrimitiveIterator.OfDouble mi(double[] array) {
		return new PrimitiveIterator.OfDouble() {
			private int i = 0;
			private boolean next = false;
			public boolean hasNext() { return i < array.length; }
			public double nextDouble() { next = true; return array[i++]; }
			public void remove() {
				if(!next) throw new IllegalStateException("next must precede this call");
				if(array.length < 1) throw new IllegalStateException("No more elements remaining");
				System.arraycopy(array, i, array, i - 1, array.length - i--);
				next = false;
			}
		};
	}
	/**
	 * Returns an {@code Iterator} whose {@link Iterator#remove() remove} method
	 * will attempt to remove an element from the underlying array according to
	 * the rules of iteration in java.
	 * @param array the underlying (backing) array
	 * @return a mutable iterator whose mutable methods will not throw an
	 * exception when {@link Iterator#remove()} is called within the bounds
	 * of the {@code Iterator}'s rules.
	 * @see Iterator#remove()
	 * @throws IllegalStateException if {@code PrimitiveIterator.nextLong()} was not called prior to {@code Iterator.remove()}
	 * @throws IllegalStateException if no elements remain in the backing array
	 * @alpha Since array lengths are immutable, it is not logical to have a mutableIterator over an array
	 */
	static PrimitiveIterator.OfLong mi(long[] array) {
		return new PrimitiveIterator.OfLong() {
			private int i = 0;
			private boolean next = false;
			public boolean hasNext() { return i < array.length; }
			public long nextLong() { next = true; return array[i++]; }
			public void remove() {
				if(!next) throw new IllegalStateException("next must precede this call");
				if(array.length < 1) throw new IllegalStateException("No more elements remaining");
				System.arraycopy(array, i, array, i - 1, array.length - i--);
				next = false;
			}
		};
	}
	/**
	 * Returns an {@code Iterator} whose {@link Iterator#remove() remove} method
	 * will attempt to remove an element from the underlying array according to
	 * the rules of iteration in java.
	 * @param array the underlying (backing) array
	 * @return a mutable iterator whose mutable methods will not throw an
	 * exception when {@link Iterator#remove()} is called within the bounds
	 * of the {@code Iterator}'s rules.
	 * @see Iterator#remove()
	 * @throws IllegalStateException if {@code PrimitiveIterator.nextInt()} was not called prior to {@code Iterator.remove()}
	 * @throws IllegalStateException if no elements remain in the backing array
	 * @alpha Since array lengths are immutable, it is not logical to have a mutableIterator over an array
	 */
	static PrimitiveIterator.OfInt mi(int[] array) {
		return new PrimitiveIterator.OfInt() {
			private int i = 0;
			private boolean next = false;
			public boolean hasNext() { return i < array.length; }
			public int nextInt() { next = true; return array[i++]; }
			public void remove() {
				if(!next) throw new IllegalStateException("next must precede this call");
				if(array.length < 1) throw new IllegalStateException("No more elements remaining");
				System.arraycopy(array, i, array, i - 1, array.length - i--);
				next = false;
			}
		};
	}
	/**
	 * Returns an {@code Iterator} whose {@link Iterator#remove() remove} method
	 * will attempt to remove an element from the underlying array according to
	 * the rules of iteration in java.
	 * @param array the underlying (backing) array
	 * @return a mutable iterator whose mutable methods will not throw an
	 * exception when {@link Iterator#remove()} is called within the bounds
	 * of the {@code Iterator}'s rules.
	 * @see Iterator#remove()
	 * @throws IllegalStateException if {@code PrimitiveIterator.nextFloat()} was not called prior to {@code Iterator.remove()}
	 * @throws IllegalStateException if no elements remain in the backing array
	 * @alpha Since array lengths are immutable, it is not logical to have a mutableIterator over an array
	 */
	static PrimitiveIterator.OfFloat mi(float[] array) {
		return new PrimitiveIterator.OfFloat() {
			private int i = 0;
			private boolean next = false;
			public boolean hasNext() { return i < array.length; }
			public float nextFloat() { next = true; return array[i++]; }
			public void remove() {
				if(!next) throw new IllegalStateException("next must precede this call");
				if(array.length < 1) throw new IllegalStateException("No more elements remaining");
				System.arraycopy(array, i, array, i - 1, array.length - i--);
				next = false;
			}
		};
	}
	/**
	 * Returns an {@code Iterator} whose {@link Iterator#remove() remove} method
	 * will attempt to remove an element from the underlying array according to
	 * the rules of iteration in java.
	 * @param array the underlying (backing) array
	 * @return a mutable iterator whose mutable methods will not throw an
	 * exception when {@link Iterator#remove()} is called within the bounds
	 * of the {@code Iterator}'s rules.
	 * @see Iterator#remove()
	 * @throws IllegalStateException if {@code PrimitiveIterator.nextChar()} was not called prior to {@code Iterator.remove()}
	 * @throws IllegalStateException if no elements remain in the backing array
	 * @alpha Since array lengths are immutable, it is not logical to have a mutableIterator over an array
	 */
	static PrimitiveIterator.OfChar mi(char[] array) {
		return new PrimitiveIterator.OfChar() {
			private int i = 0;
			private boolean next = false;
			public boolean hasNext() { return i < array.length; }
			public char nextChar() { next = true; return array[i++]; }
			public void remove() {
				if(!next) throw new IllegalStateException("next must precede this call");
				if(array.length < 1) throw new IllegalStateException("No more elements remaining");
				System.arraycopy(array, i, array, i - 1, array.length - i--);
				next = false;
			}
		};
	}
	/**
	 * Returns an {@code Iterator} whose {@link Iterator#remove() remove} method
	 * will attempt to remove an element from the underlying array according to
	 * the rules of iteration in java.
	 * @param array the underlying (backing) array
	 * @return a mutable iterator whose mutable methods will not throw an
	 * exception when {@link Iterator#remove()} is called within the bounds
	 * of the {@code Iterator}'s rules.
	 * @see Iterator#remove()
	 * @throws IllegalStateException if {@code PrimitiveIterator.nextShort()} was not called prior to {@code Iterator.remove()}
	 * @throws IllegalStateException if no elements remain in the backing array
	 * @alpha Since array lengths are immutable, it is not logical to have a mutableIterator over an array
	 */
	static PrimitiveIterator.OfShort mi(short[] array) {
		return new PrimitiveIterator.OfShort() {
			private int i = 0;
			private boolean next = false;
			public boolean hasNext() { return i < array.length; }
			public short nextShort() { next = true; return array[i++]; }
			public void remove() {
				if(!next) throw new IllegalStateException("next must precede this call");
				if(array.length < 1) throw new IllegalStateException("No more elements remaining");
				System.arraycopy(array, i, array, i - 1, array.length - i--);
				next = false;
			}
		};
	}
	/**
	 * Returns an {@code Iterator} whose {@link Iterator#remove() remove} method
	 * will attempt to remove an element from the underlying array according to
	 * the rules of iteration in java.
	 * @param array the underlying (backing) array
	 * @return a mutable iterator whose mutable methods will not throw an
	 * exception when {@link Iterator#remove()} is called within the bounds
	 * of the {@code Iterator}'s rules.
	 * @see Iterator#remove()
	 * @throws IllegalStateException if {@code PrimitiveIterator.nextByte()} was not called prior to {@code Iterator.remove()}
	 * @throws IllegalStateException if no elements remain in the backing array
	 * @alpha Since array lengths are immutable, it is not logical to have a mutableIterator over an array
	 */
	static PrimitiveIterator.OfByte mi(byte[] array) {
		return new PrimitiveIterator.OfByte() {
			private int i = 0;
			private boolean next = false;
			public boolean hasNext() { return i < array.length; }
			public byte nextByte() { next = true; return array[i++]; }
			public void remove() {
				if(!next) throw new IllegalStateException("next must precede this call");
				if(array.length < 1) throw new IllegalStateException("No more elements remaining");
				System.arraycopy(array, i, array, i - 1, array.length - i--);
				next = false;
			}
		};
	}
	/**
	 * Returns an {@code Iterator} whose {@link Iterator#remove() remove} method
	 * will attempt to remove an element from the underlying array according to
	 * the rules of iteration in java.
	 * @param array the underlying (backing) array
	 * @return a mutable iterator whose mutable methods will not throw an
	 * exception when {@link Iterator#remove()} is called within the bounds
	 * of the {@code Iterator}'s rules.
	 * @see Iterator#remove()
	 * @throws IllegalStateException if {@code PrimitiveIterator.nextBoolean()} was not called prior to {@code Iterator.remove()}
	 * @throws IllegalStateException if no elements remain in the backing array
	 * @alpha Since array lengths are immutable, it is not logical to have a mutableIterator over an array
	 */
	static PrimitiveIterator.OfBoolean mi(boolean[] array) {
		return new PrimitiveIterator.OfBoolean() {
			private int i = 0;
			private boolean next = false;
			public boolean hasNext() { return i < array.length; }
			public boolean nextBoolean() { next = true; return array[i++]; }
			public void remove() {
				if(!next) throw new IllegalStateException("next must precede this call");
				if(array.length < 1) throw new IllegalStateException("No more elements remaining");
				System.arraycopy(array, i, array, i - 1, array.length - i--);
				next = false;
			}
		};
	}
/**
	 * Returns an {@code Iterator} (with a reverse encounter order) whose {@link Iterator#remove() remove} method
	 * will attempt to remove an element from the underlying array according to
	 * the rules of iteration in java.
	 * @param <T> the type of the elements of the array
	 * @param array the underlying (backing) array
	 * @return a mutable iterator (with a reverse encounter order) whose mutable methods will not throw an
	 * exception when {@link Iterator#remove()} is called within the bounds
	 * of the {@code Iterator}'s rules.
	 * @see Iterator#remove()
	 * @throws IllegalStateException if {@code PrimitiveIterator.nextDouble()} was not called prior to {@code Iterator.remove()}
	 * @throws IllegalStateException if no elements remain in the backing array
	 */
	static <T> Iterator<T> mReverseItr(T[] array) {
		return new Iterator<T>() {
			private int i = array.length - 1;
			private boolean next = false;
			public boolean hasNext() { return i > -1; }
			public T next() { next = true; return array[i--]; }
			public void remove() {
				if(!next) throw new IllegalStateException("next must precede this call");
				if(array.length < 1) throw new IllegalStateException("No more elements remaining");
				System.arraycopy(array, i, array, i - 1, array.length - i--);
				next = false;
			}
		};
	}
/**
	 * Returns an {@code Iterator} (with a reverse encounter order) whose {@link Iterator#remove() remove} method
	 * will attempt to remove an element from the underlying array according to
	 * the rules of iteration in java.
	 * @param array the underlying (backing) array
	 * @return a mutable iterator (with a reverse encounter order) whose mutable methods will not throw an
	 * exception when {@link Iterator#remove()} is called within the bounds
	 * of the {@code Iterator}'s rules.
	 * @see Iterator#remove()
	 * @throws IllegalStateException if {@code PrimitiveIterator.nextDouble()} was not called prior to {@code Iterator.remove()}
	 * @throws IllegalStateException if no elements remain in the backing array
	 */
	static PrimitiveIterator.OfDouble mReverseItr(double[] array) {
		return new PrimitiveIterator.OfDouble() {
			private int i = array.length - 1;
			private boolean next = false;
			public boolean hasNext() { return i > -1; }
			public double nextDouble() { next = true; return array[i--]; }
			public void remove() {
				if(!next) throw new IllegalStateException("next must precede this call");
				if(array.length < 1) throw new IllegalStateException("No more elements remaining");
				System.arraycopy(array, i, array, i - 1, array.length - i--);
				next = false;
			}
		};
	}
/**
	 * Returns an {@code Iterator} (with a reverse encounter order) whose {@link Iterator#remove() remove} method
	 * will attempt to remove an element from the underlying array according to
	 * the rules of iteration in java.
	 * @param array the underlying (backing) array
	 * @return a mutable iterator (with a reverse encounter order) whose mutable methods will not throw an
	 * exception when {@link Iterator#remove()} is called within the bounds
	 * of the {@code Iterator}'s rules.
	 * @see Iterator#remove()
	 * @throws IllegalStateException if {@code PrimitiveIterator.nextLong()} was not called prior to {@code Iterator.remove()}
	 * @throws IllegalStateException if no elements remain in the backing array
	 */
	static PrimitiveIterator.OfLong mReverseItr(long[] array) {
		return new PrimitiveIterator.OfLong() {
			private int i = array.length - 1;
			private boolean next = false;
			public boolean hasNext() { return i > -1; }
			public long nextLong() { next = true; return array[i--]; }
			public void remove() {
				if(!next) throw new IllegalStateException("next must precede this call");
				if(array.length < 1) throw new IllegalStateException("No more elements remaining");
				System.arraycopy(array, i, array, i - 1, array.length - i--);
				next = false;
			}
		};
	}
/**
	 * Returns an {@code Iterator} (with a reverse encounter order) whose {@link Iterator#remove() remove} method
	 * will attempt to remove an element from the underlying array according to
	 * the rules of iteration in java.
	 * @param array the underlying (backing) array
	 * @return a mutable iterator (with a reverse encounter order) whose mutable methods will not throw an
	 * exception when {@link Iterator#remove()} is called within the bounds
	 * of the {@code Iterator}'s rules.
	 * @see Iterator#remove()
	 * @throws IllegalStateException if {@code PrimitiveIterator.nextInt()} was not called prior to {@code Iterator.remove()}
	 * @throws IllegalStateException if no elements remain in the backing array
	 */
	static PrimitiveIterator.OfInt mReverseItr(int[] array) {
		return new PrimitiveIterator.OfInt() {
			private int i = array.length - 1;
			private boolean next = false;
			public boolean hasNext() { return i > -1; }
			public int nextInt() { next = true; return array[i--]; }
			public void remove() {
				if(!next) throw new IllegalStateException("next must precede this call");
				if(array.length < 1) throw new IllegalStateException("No more elements remaining");
				System.arraycopy(array, i, array, i - 1, array.length - i--);
				next = false;
			}
		};
	}
/**
	 * Returns an {@code Iterator} (with a reverse encounter order) whose {@link Iterator#remove() remove} method
	 * will attempt to remove an element from the underlying array according to
	 * the rules of iteration in java.
	 * @param array the underlying (backing) array
	 * @return a mutable iterator (with a reverse encounter order) whose mutable methods will not throw an
	 * exception when {@link Iterator#remove()} is called within the bounds
	 * of the {@code Iterator}'s rules.
	 * @see Iterator#remove()
	 * @throws IllegalStateException if {@code PrimitiveIterator.nextFloat()} was not called prior to {@code Iterator.remove()}
	 * @throws IllegalStateException if no elements remain in the backing array
	 */
	static PrimitiveIterator.OfFloat mReverseItr(float[] array) {
		return new PrimitiveIterator.OfFloat() {
			private int i = array.length - 1;
			private boolean next = false;
			public boolean hasNext() { return i > -1; }
			public float nextFloat() { next = true; return array[i--]; }
			public void remove() {
				if(!next) throw new IllegalStateException("next must precede this call");
				if(array.length < 1) throw new IllegalStateException("No more elements remaining");
				System.arraycopy(array, i, array, i - 1, array.length - i--);
				next = false;
			}
		};
	}
/**
	 * Returns an {@code Iterator} (with a reverse encounter order) whose {@link Iterator#remove() remove} method
	 * will attempt to remove an element from the underlying array according to
	 * the rules of iteration in java.
	 * @param array the underlying (backing) array
	 * @return a mutable iterator (with a reverse encounter order) whose mutable methods will not throw an
	 * exception when {@link Iterator#remove()} is called within the bounds
	 * of the {@code Iterator}'s rules.
	 * @see Iterator#remove()
	 * @throws IllegalStateException if {@code PrimitiveIterator.nextChar()} was not called prior to {@code Iterator.remove()}
	 * @throws IllegalStateException if no elements remain in the backing array
	 */
	static PrimitiveIterator.OfChar mReverseItr(char[] array) {
		return new PrimitiveIterator.OfChar() {
			private int i = array.length - 1;
			private boolean next = false;
			public boolean hasNext() { return i > -1; }
			public char nextChar() { next = true; return array[i--]; }
			public void remove() {
				if(!next) throw new IllegalStateException("next must precede this call");
				if(array.length < 1) throw new IllegalStateException("No more elements remaining");
				System.arraycopy(array, i, array, i - 1, array.length - i--);
				next = false;
			}
		};
	}
/**
	 * Returns an {@code Iterator} (with a reverse encounter order) whose {@link Iterator#remove() remove} method
	 * will attempt to remove an element from the underlying array according to
	 * the rules of iteration in java.
	 * @param array the underlying (backing) array
	 * @return a mutable iterator (with a reverse encounter order) whose mutable methods will not throw an
	 * exception when {@link Iterator#remove()} is called within the bounds
	 * of the {@code Iterator}'s rules.
	 * @see Iterator#remove()
	 * @throws IllegalStateException if {@code PrimitiveIterator.nextShort()} was not called prior to {@code Iterator.remove()}
	 * @throws IllegalStateException if no elements remain in the backing array
	 */
	static PrimitiveIterator.OfShort mReverseItr(short[] array) {
		return new PrimitiveIterator.OfShort() {
			private int i = array.length - 1;
			private boolean next = false;
			public boolean hasNext() { return i > -1; }
			public short nextShort() { next = true; return array[i--]; }
			public void remove() {
				if(!next) throw new IllegalStateException("next must precede this call");
				if(array.length < 1) throw new IllegalStateException("No more elements remaining");
				System.arraycopy(array, i, array, i - 1, array.length - i--);
				next = false;
			}
		};
	}
/**
	 * Returns an {@code Iterator} (with a reverse encounter order) whose {@link Iterator#remove() remove} method
	 * will attempt to remove an element from the underlying array according to
	 * the rules of iteration in java.
	 * @param array the underlying (backing) array
	 * @return a mutable iterator (with a reverse encounter order) whose mutable methods will not throw an
	 * exception when {@link Iterator#remove()} is called within the bounds
	 * of the {@code Iterator}'s rules.
	 * @see Iterator#remove()
	 * @throws IllegalStateException if {@code PrimitiveIterator.nextByte()} was not called prior to {@code Iterator.remove()}
	 * @throws IllegalStateException if no elements remain in the backing array
	 */
	static PrimitiveIterator.OfByte mReverseItr(byte[] array) {
		return new PrimitiveIterator.OfByte() {
			private int i = array.length - 1;
			private boolean next = false;
			public boolean hasNext() { return i > -1; }
			public byte nextByte() { next = true; return array[i--]; }
			public void remove() {
				if(!next) throw new IllegalStateException("next must precede this call");
				if(array.length < 1) throw new IllegalStateException("No more elements remaining");
				System.arraycopy(array, i, array, i - 1, array.length - i--);
				next = false;
			}
		};
	}
/**
	 * Returns an {@code Iterator} (with a reverse encounter order) whose {@link Iterator#remove() remove} method
	 * will attempt to remove an element from the underlying array according to
	 * the rules of iteration in java.
	 * @param array the underlying (backing) array
	 * @return a mutable iterator whose (with a reverse encounter order) mutable methods will not throw an
	 * exception when {@link Iterator#remove()} is called within the bounds
	 * of the {@code Iterator}'s rules.
	 * @see Iterator#remove()
	 * @throws IllegalStateException if {@code PrimitiveIterator.nextBoolean()} was not called prior to {@code Iterator.remove()}
	 * @throws IllegalStateException if no elements remain in the backing array
	 */
	static PrimitiveIterator.OfBoolean mReverseItr(boolean[] array) {
		return new PrimitiveIterator.OfBoolean() {
			private int i = array.length - 1;
			private boolean next = false;
			public boolean hasNext() { return i > -1; }
			public boolean nextBoolean() { next = true; return array[i--]; }
			public void remove() {
				if(!next) throw new IllegalStateException("next must precede this call");
				if(array.length < 1) throw new IllegalStateException("No more elements remaining");
				System.arraycopy(array, i, array, i - 1, array.length - i--);
				next = false;
			}
		};
	}
	/**
	 * Returns a {@link PrimitiveListIterator.OfDouble} whose {@link ListIterator#remove() remove} and {@link PrimitiveListIterator#addDouble(double) addDouble} methods
	 * will attempt to mutate the underlying array according to
	 * the rules of iteration in java.
	 * @param array the underlying (backing) array
	 * @return a mutable list-iterator whose mutable methods will not throw an
	 * exception when called within the bounds of the {@code ListIterator}'s rules.
	 * @see ListIterator#remove()
	 * @see ListIterator#add(Object)
	 * @throws IllegalStateException if {@code PrimitiveIterator.nextDouble()} was not called prior to {@code Iterator.remove()}
	 * @throws IllegalStateException if no elements remain in the backing array
	 */
	static PrimitiveListIterator.OfDouble mli(double[] array) {
		return new PrimitiveListIterator.OfDouble() {
			private int i = 0;
			private int li = -1;
			private double[] a = array;
			private int size = a.length;
			public void setDouble(double e) {}
			public boolean hasNext() { return i < size; }
			public boolean hasPrevious() { return i > 0; }
			public double nextDouble() { if(!hasNext()) throw new NoSuchElementException(); li = i; return a[i++]; }
			public double previousDouble() { if(!hasPrevious()) throw new NoSuchElementException(); li = --i; return a[i];}
			public int nextIndex() { return i; }
			public int previousIndex() { return i - 1; }
			public void remove() {
				if(li < 0) throw new IllegalStateException("next or previous must precede this call");
				if(size < 1) throw new IllegalStateException("No more elements remaining");
				System.arraycopy(a, li + 1, a, li, size-- - li - 1);
				i = li;
				li = -1;
			}
			public void addDouble(double e) {
				if(size == a.length) a = Arrays.copyOf(a, size * 2);
				System.arraycopy(a, i, a, i + 1, size - i);
				a[i++] = e;
				size++;
				li = -1;
			}
		};
	}
	/**
	 * Returns a {@link PrimitiveListIterator.OfLong} whose {@link ListIterator#remove() remove} and {@link PrimitiveListIterator#addLong(long) addLong} methods
	 * will attempt to mutate the underlying array according to
	 * the rules of iteration in java.
	 * @param array the underlying (backing) array
	 * @return a mutable list-iterator whose mutable methods will not throw an
	 * exception when called within the bounds of the {@code ListIterator}'s rules.
	 * @see ListIterator#remove()
	 * @see ListIterator#add(Object)
	 * @throws IllegalStateException if {@code PrimitiveIterator.nextLong()} was not called prior to {@code Iterator.remove()}
	 * @throws IllegalStateException if no elements remain in the backing array
	 */
	static PrimitiveListIterator.OfLong mli(long[] array) {
		return new PrimitiveListIterator.OfLong() {
			private int i = 0;
			private int li = -1;
			private long[] a = array;
			private int size = a.length;
			public void setLong(long e) {}
			public boolean hasNext() { return i < size; }
			public boolean hasPrevious() { return i > 0; }
			public long nextLong() { if(!hasNext()) throw new NoSuchElementException(); li = i; return a[i++]; }
			public long previousLong() { if(!hasPrevious()) throw new NoSuchElementException(); li = --i; return a[i];}
			public int nextIndex() { return i; }
			public int previousIndex() { return i - 1; }
			public void remove() {
				if(li < 0) throw new IllegalStateException("next or previous must precede this call");
				if(size < 1) throw new IllegalStateException("No more elements remaining");
				System.arraycopy(a, li + 1, a, li, size-- - li - 1);
				i = li;
				li = -1;
			}
			public void addLong(long e) {
				if(size == a.length) a = Arrays.copyOf(a, size * 2);
				System.arraycopy(a, i, a, i + 1, size - i);
				a[i++] = e;
				size++;
				li = -1;
			}
		};
	}
	/**
	 * Returns a {@link PrimitiveListIterator.OfInt} whose {@link ListIterator#remove() remove} and {@link PrimitiveListIterator#addInt(int) addInt} methods
	 * will attempt to mutate the underlying array according to
	 * the rules of iteration in java.
	 * @param array the underlying (backing) array
	 * @return a mutable list-iterator whose mutable methods will not throw an
	 * exception when called within the bounds of the {@code ListIterator}'s rules.
	 * @see ListIterator#remove()
	 * @see ListIterator#add(Object)
	 * @throws IllegalStateException if {@code PrimitiveIterator.nextInt()} was not called prior to {@code Iterator.remove()}
	 * @throws IllegalStateException if no elements remain in the backing array
	 */
	static PrimitiveListIterator.OfInt mli(int[] array) {
		return new PrimitiveListIterator.OfInt() {
			private int i = 0;
			private int li = -1;
			private int[] a = array;
			private int size = a.length;
			public void setInt(int e) {}
			public boolean hasNext() { return i < size; }
			public boolean hasPrevious() { return i > 0; }
			public int nextInt() { if(!hasNext()) throw new NoSuchElementException(); li = i; return a[i++]; }
			public int previousInt() { if(!hasPrevious()) throw new NoSuchElementException(); li = --i; return a[i];}
			public int nextIndex() { return i; }
			public int previousIndex() { return i - 1; }
			public void remove() {
				if(li < 0) throw new IllegalStateException("next or previous must precede this call");
				if(size < 1) throw new IllegalStateException("No more elements remaining");
				System.arraycopy(a, li + 1, a, li, size-- - li - 1);
				i = li;
				li = -1;
			}
			public void addInt(int e) {
				if(size == a.length) a = Arrays.copyOf(a, size * 2);
				System.arraycopy(a, i, a, i + 1, size - i);
				a[i++] = e;
				size++;
				li = -1;
			}
		};
	}
	/**
	 * Returns a {@link PrimitiveListIterator.OfFloat} whose {@link ListIterator#remove() remove} and {@link PrimitiveListIterator#addFloat(float) addFloat} methods
	 * will attempt to mutate the underlying array according to
	 * the rules of iteration in java.
	 * @param array the underlying (backing) array
	 * @return a mutable list-iterator whose mutable methods will not throw an
	 * exception when called within the bounds of the {@code ListIterator}'s rules.
	 * @see ListIterator#remove()
	 * @see ListIterator#add(Object)
	 * @throws IllegalStateException if {@code PrimitiveIterator.nextFloat()} was not called prior to {@code Iterator.remove()}
	 * @throws IllegalStateException if no elements remain in the backing array
	 */
	static PrimitiveListIterator.OfFloat mli(float[] array) {
		return new PrimitiveListIterator.OfFloat() {
			private int i = 0;
			private int li = -1;
			private float[] a = array;
			private int size = a.length;
			public void setFloat(float e) {}
			public boolean hasNext() { return i < size; }
			public boolean hasPrevious() { return i > 0; }
			public float nextFloat() { if(!hasNext()) throw new NoSuchElementException(); li = i; return a[i++]; }
			public float previousFloat() { if(!hasPrevious()) throw new NoSuchElementException(); li = --i; return a[i];}
			public int nextIndex() { return i; }
			public int previousIndex() { return i - 1; }
			public void remove() {
				if(li < 0) throw new IllegalStateException("next or previous must precede this call");
				if(size < 1) throw new IllegalStateException("No more elements remaining");
				System.arraycopy(a, li + 1, a, li, size-- - li - 1);
				i = li;
				li = -1;
			}
			public void addFloat(float e) {
				if(size == a.length) a = Arrays.copyOf(a, size * 2);
				System.arraycopy(a, i, a, i + 1, size - i);
				a[i++] = e;
				size++;
				li = -1;
			}
		};
	}
	/**
	 * Returns a {@link PrimitiveListIterator.OfChar} whose {@link ListIterator#remove() remove} and {@link PrimitiveListIterator#addChar(char) addChar} methods
	 * will attempt to mutate the underlying array according to
	 * the rules of iteration in java.
	 * @param array the underlying (backing) array
	 * @return a mutable list-iterator whose mutable methods will not throw an
	 * exception when called within the bounds of the {@code ListIterator}'s rules.
	 * @see ListIterator#remove()
	 * @see ListIterator#add(Object)
	 * @throws IllegalStateException if {@code PrimitiveIterator.nextChar()} was not called prior to {@code Iterator.remove()}
	 * @throws IllegalStateException if no elements remain in the backing array
	 */
	static PrimitiveListIterator.OfChar mli(char[] array) {
		return new PrimitiveListIterator.OfChar() {
			private int i = 0;
			private int li = -1;
			private char[] a = array;
			private int size = a.length;
			public void setChar(char e) {}
			public boolean hasNext() { return i < size; }
			public boolean hasPrevious() { return i > 0; }
			public char nextChar() { if(!hasNext()) throw new NoSuchElementException(); li = i; return a[i++]; }
			public char previousChar() { if(!hasPrevious()) throw new NoSuchElementException(); li = --i; return a[i];}
			public int nextIndex() { return i; }
			public int previousIndex() { return i - 1; }
			public void remove() {
				if(li < 0) throw new IllegalStateException("next or previous must precede this call");
				if(size < 1) throw new IllegalStateException("No more elements remaining");
				System.arraycopy(a, li + 1, a, li, size-- - li - 1);
				i = li;
				li = -1;
			}
			public void addChar(char e) {
				if(size == a.length) a = Arrays.copyOf(a, size * 2);
				System.arraycopy(a, i, a, i + 1, size - i);
				a[i++] = e;
				size++;
				li = -1;
			}
		};
	}
	/**
	 * Returns a {@link PrimitiveListIterator.OfShort} whose {@link ListIterator#remove() remove} and {@link PrimitiveListIterator#addShort(short) addShort} methods
	 * will attempt to mutate the underlying array according to
	 * the rules of iteration in java.
	 * @param array the underlying (backing) array
	 * @return a mutable list-iterator whose mutable methods will not throw an
	 * exception when called within the bounds of the {@code ListIterator}'s rules.
	 * @see ListIterator#remove()
	 * @see ListIterator#add(Object)
	 * @throws IllegalStateException if {@code PrimitiveIterator.nextShort()} was not called prior to {@code Iterator.remove()}
	 * @throws IllegalStateException if no elements remain in the backing array
	 */
	static PrimitiveListIterator.OfShort mli(short[] array) {
		return new PrimitiveListIterator.OfShort() {
			private int i = 0;
			private int li = -1;
			private short[] a = array;
			private int size = a.length;
			public void setShort(short e) {}
			public boolean hasNext() { return i < size; }
			public boolean hasPrevious() { return i > 0; }
			public short nextShort() { if(!hasNext()) throw new NoSuchElementException(); li = i; return a[i++]; }
			public short previousShort() { if(!hasPrevious()) throw new NoSuchElementException(); li = --i; return a[i];}
			public int nextIndex() { return i; }
			public int previousIndex() { return i - 1; }
			public void remove() {
				if(li < 0) throw new IllegalStateException("next or previous must precede this call");
				if(size < 1) throw new IllegalStateException("No more elements remaining");
				System.arraycopy(a, li + 1, a, li, size-- - li - 1);
				i = li;
				li = -1;
			}
			public void addShort(short e) {
				if(size == a.length) a = Arrays.copyOf(a, size * 2);
				System.arraycopy(a, i, a, i + 1, size - i);
				a[i++] = e;
				size++;
				li = -1;
			}
		};
	}
	/**
	 * Returns a {@link PrimitiveListIterator.OfByte} whose {@link ListIterator#remove() remove} and {@link PrimitiveListIterator#addByte(byte) addByte} methods
	 * will attempt to mutate the underlying array according to
	 * the rules of iteration in java.
	 * @param array the underlying (backing) array
	 * @return a mutable list-iterator whose mutable methods will not throw an
	 * exception when called within the bounds of the {@code ListIterator}'s rules.
	 * @see ListIterator#remove()
	 * @see ListIterator#add(Object)
	 * @throws IllegalStateException if {@code PrimitiveIterator.nextByte()} was not called prior to {@code Iterator.remove()}
	 * @throws IllegalStateException if no elements remain in the backing array
	 */
	static PrimitiveListIterator.OfByte mli(byte[] array) {
		return new PrimitiveListIterator.OfByte() {
			private int i = 0;
			private int li = -1;
			private byte[] a = array;
			private int size = a.length;
			public void setByte(byte e) {}
			public boolean hasNext() { return i < size; }
			public boolean hasPrevious() { return i > 0; }
			public byte nextByte() { if(!hasNext()) throw new NoSuchElementException(); li = i; return a[i++]; }
			public byte previousByte() { if(!hasPrevious()) throw new NoSuchElementException(); li = --i; return a[i];}
			public int nextIndex() { return i; }
			public int previousIndex() { return i - 1; }
			public void remove() {
				if(li < 0) throw new IllegalStateException("next or previous must precede this call");
				if(size < 1) throw new IllegalStateException("No more elements remaining");
				System.arraycopy(a, li + 1, a, li, size-- - li - 1);
				i = li;
				li = -1;
			}
			public void addByte(byte e) {
				if(size == a.length) a = Arrays.copyOf(a, size * 2);
				System.arraycopy(a, i, a, i + 1, size - i);
				a[i++] = e;
				size++;
				li = -1;
			}
		};
	}
	/**
	 * Returns a {@link PrimitiveListIterator.OfBoolean} whose {@link ListIterator#remove() remove} and {@link PrimitiveListIterator#addBoolean(boolean) addBoolean} methods
	 * will attempt to mutate the underlying array according to
	 * the rules of iteration in java.
	 * @param array the underlying (backing) array
	 * @return a mutable list-iterator whose mutable methods will not throw an
	 * exception when called within the bounds of the {@code ListIterator}'s rules.
	 * @see ListIterator#remove()
	 * @see ListIterator#add(Object)
	 * @throws IllegalStateException if {@code PrimitiveIterator.nextBoolean()} was not called prior to {@code Iterator.remove()}
	 * @throws IllegalStateException if no elements remain in the backing array
	 */
	static PrimitiveListIterator.OfBoolean mli(boolean[] array) {
		return new PrimitiveListIterator.OfBoolean() {
			private int i = 0;
			private int li = -1;
			private boolean[] a = array;
			private int size = a.length;
			public void setBoolean(boolean e) {}
			public boolean hasNext() { return i < size; }
			public boolean hasPrevious() { return i > 0; }
			public boolean nextBoolean() { if(!hasNext()) throw new NoSuchElementException(); li = i; return a[i++]; }
			public boolean previousBoolean() { if(!hasPrevious()) throw new NoSuchElementException(); li = --i; return a[i];}
			public int nextIndex() { return i; }
			public int previousIndex() { return i - 1; }
			public void remove() {
				if(li < 0) throw new IllegalStateException("next or previous must precede this call");
				if(size < 1) throw new IllegalStateException("No more elements remaining");
				System.arraycopy(a, li + 1, a, li, size-- - li - 1);
				i = li;
				li = -1;
			}
			public void addBoolean(boolean e) {
				if(size == a.length) a = Arrays.copyOf(a, size * 2);
				System.arraycopy(a, i, a, i + 1, size - i);
				a[i++] = e;
				size++;
				li = -1;
			}
		};
	}
	/**
	 * Returns an {@code Iterator} whose {@link Iterator#remove() remove} method
	 * will attempt to remove an element from the underlying array according to
	 * the rules of iteration in java.
	 * @param <T> the type of the elements in the given array
	 * @param array the underlying (backing) array
	 * @return a mutable iterator whose mutable methods will not throw an
	 * exception when {@link Iterator#remove()} is called within the bounds
	 * of the {@code Iterator}'s rules.
	 * @see Iterator#remove()
	 * @throws IllegalStateException if {@code PrimitiveIterator.nextDouble()} was not called prior to {@code Iterator.remove()}
	 * @throws IllegalStateException if no elements remain in the backing array
	 */
	static <T> PrimitiveCyclicIterator<T> mc(T[] array) {
		return new PrimitiveCyclicIterator<T>() {
			private int r = 0;
			private int i = 0;
			private boolean next = false;
			public int getRevolutions() { return r >= 0 ? r : Integer.MAX_VALUE; }
			public boolean hasNext() { return i < array.length; }
			public T next() { next = true; return array[i++]; }
			public void remove() {
				if(!next) throw new IllegalStateException("next must precede this call");
				if(array.length < 1) throw new IllegalStateException("No more elements remaining");
				System.arraycopy(array, i, array, i - 1, array.length - i--);
				next = false;
			}
		};
	}
	/**
	 * Returns an {@code Iterator} whose {@link Iterator#remove() remove} method
	 * will attempt to remove an element from the underlying array according to
	 * the rules of iteration in java.
	 * @param array the underlying (backing) array
	 * @return a mutable iterator whose mutable methods will not throw an
	 * exception when {@link Iterator#remove()} is called within the bounds
	 * of the {@code Iterator}'s rules.
	 * @see Iterator#remove()
	 * @throws IllegalStateException if {@code PrimitiveIterator.nextDouble()} was not called prior to {@code Iterator.remove()}
	 * @throws IllegalStateException if no elements remain in the backing array
	 */
	static PrimitiveCyclicIterator.OfDouble mc(double[] array) {
		return new PrimitiveCyclicIterator.OfDouble() {
			private int r = 0;
			private int i = 0;
			private boolean next = false;
			public int getRevolutions() { return r >= 0 ? r : Integer.MAX_VALUE; }
			public boolean hasNext() { return i < array.length; }
			public double nextDouble() { next = true; return array[i++]; }
			public void remove() {
				if(!next) throw new IllegalStateException("next must precede this call");
				if(array.length < 1) throw new IllegalStateException("No more elements remaining");
				System.arraycopy(array, i, array, i - 1, array.length - i--);
				next = false;
			}
		};
	}
	/**
	 * Returns an {@code Iterator} whose {@link Iterator#remove() remove} method
	 * will attempt to remove an element from the underlying array according to
	 * the rules of iteration in java.
	 * @param array the underlying (backing) array
	 * @return a mutable iterator whose mutable methods will not throw an
	 * exception when {@link Iterator#remove()} is called within the bounds
	 * of the {@code Iterator}'s rules.
	 * @see Iterator#remove()
	 * @throws IllegalStateException if {@code PrimitiveIterator.nextLong()} was not called prior to {@code Iterator.remove()}
	 * @throws IllegalStateException if no elements remain in the backing array
	 */
	static PrimitiveCyclicIterator.OfLong mc(long[] array) {
		return new PrimitiveCyclicIterator.OfLong() {
			private int r = 0;
			private int i = 0;
			private boolean next = false;
			public int getRevolutions() { return r >= 0 ? r : Integer.MAX_VALUE; }
			public boolean hasNext() { return i < array.length; }
			public long nextLong() { next = true; return array[i++]; }
			public void remove() {
				if(!next) throw new IllegalStateException("next must precede this call");
				if(array.length < 1) throw new IllegalStateException("No more elements remaining");
				System.arraycopy(array, i, array, i - 1, array.length - i--);
				next = false;
			}
		};
	}
	/**
	 * Returns an {@code Iterator} whose {@link Iterator#remove() remove} method
	 * will attempt to remove an element from the underlying array according to
	 * the rules of iteration in java.
	 * @param array the underlying (backing) array
	 * @return a mutable iterator whose mutable methods will not throw an
	 * exception when {@link Iterator#remove()} is called within the bounds
	 * of the {@code Iterator}'s rules.
	 * @see Iterator#remove()
	 * @throws IllegalStateException if {@code PrimitiveIterator.nextInt()} was not called prior to {@code Iterator.remove()}
	 * @throws IllegalStateException if no elements remain in the backing array
	 */
	static PrimitiveCyclicIterator.OfInt mc(int[] array) {
		return new PrimitiveCyclicIterator.OfInt() {
			private int r = 0;
			private int i = 0;
			private boolean next = false;
			public int getRevolutions() { return r >= 0 ? r : Integer.MAX_VALUE; }
			public boolean hasNext() { return i < array.length; }
			public int nextInt() { next = true; return array[i++]; }
			public void remove() {
				if(!next) throw new IllegalStateException("next must precede this call");
				if(array.length < 1) throw new IllegalStateException("No more elements remaining");
				System.arraycopy(array, i, array, i - 1, array.length - i--);
				next = false;
			}
		};
	}
	/**
	 * Returns an {@code Iterator} whose {@link Iterator#remove() remove} method
	 * will attempt to remove an element from the underlying array according to
	 * the rules of iteration in java.
	 * @param array the underlying (backing) array
	 * @return a mutable iterator whose mutable methods will not throw an
	 * exception when {@link Iterator#remove()} is called within the bounds
	 * of the {@code Iterator}'s rules.
	 * @see Iterator#remove()
	 * @throws IllegalStateException if {@code PrimitiveIterator.nextFloat()} was not called prior to {@code Iterator.remove()}
	 * @throws IllegalStateException if no elements remain in the backing array
	 */
	static PrimitiveCyclicIterator.OfFloat mc(float[] array) {
		return new PrimitiveCyclicIterator.OfFloat() {
			private int r = 0;
			private int i = 0;
			private boolean next = false;
			public int getRevolutions() { return r >= 0 ? r : Integer.MAX_VALUE; }
			public boolean hasNext() { return i < array.length; }
			public float nextFloat() { next = true; return array[i++]; }
			public void remove() {
				if(!next) throw new IllegalStateException("next must precede this call");
				if(array.length < 1) throw new IllegalStateException("No more elements remaining");
				System.arraycopy(array, i, array, i - 1, array.length - i--);
				next = false;
			}
		};
	}
	/**
	 * Returns an {@code Iterator} whose {@link Iterator#remove() remove} method
	 * will attempt to remove an element from the underlying array according to
	 * the rules of iteration in java.
	 * @param array the underlying (backing) array
	 * @return a mutable iterator whose mutable methods will not throw an
	 * exception when {@link Iterator#remove()} is called within the bounds
	 * of the {@code Iterator}'s rules.
	 * @see Iterator#remove()
	 * @throws IllegalStateException if {@code PrimitiveIterator.nextChar()} was not called prior to {@code Iterator.remove()}
	 * @throws IllegalStateException if no elements remain in the backing array
	 */
	static PrimitiveCyclicIterator.OfChar mc(char[] array) {
		return new PrimitiveCyclicIterator.OfChar() {
			private int r = 0;
			private int i = 0;
			private boolean next = false;
			public int getRevolutions() { return r >= 0 ? r : Integer.MAX_VALUE; }
			public boolean hasNext() { return i < array.length; }
			public char nextChar() { next = true; return array[i++]; }
			public void remove() {
				if(!next) throw new IllegalStateException("next must precede this call");
				if(array.length < 1) throw new IllegalStateException("No more elements remaining");
				System.arraycopy(array, i, array, i - 1, array.length - i--);
				next = false;
			}
		};
	}
	/**
	 * Returns an {@code Iterator} whose {@link Iterator#remove() remove} method
	 * will attempt to remove an element from the underlying array according to
	 * the rules of iteration in java.
	 * @param array the underlying (backing) array
	 * @return a mutable iterator whose mutable methods will not throw an
	 * exception when {@link Iterator#remove()} is called within the bounds
	 * of the {@code Iterator}'s rules.
	 * @see Iterator#remove()
	 * @throws IllegalStateException if {@code PrimitiveIterator.nextShort()} was not called prior to {@code Iterator.remove()}
	 * @throws IllegalStateException if no elements remain in the backing array
	 */
	static PrimitiveCyclicIterator.OfShort mc(short[] array) {
		return new PrimitiveCyclicIterator.OfShort() {
			private int r = 0;
			private int i = 0;
			private boolean next = false;
			public int getRevolutions() { return r >= 0 ? r : Integer.MAX_VALUE; }
			public boolean hasNext() { return i < array.length; }
			public short nextShort() { next = true; return array[i++]; }
			public void remove() {
				if(!next) throw new IllegalStateException("next must precede this call");
				if(array.length < 1) throw new IllegalStateException("No more elements remaining");
				System.arraycopy(array, i, array, i - 1, array.length - i--);
				next = false;
			}
		};
	}
	/**
	 * Returns an {@code Iterator} whose {@link Iterator#remove() remove} method
	 * will attempt to remove an element from the underlying array according to
	 * the rules of iteration in java.
	 * @param array the underlying (backing) array
	 * @return a mutable iterator whose mutable methods will not throw an
	 * exception when {@link Iterator#remove()} is called within the bounds
	 * of the {@code Iterator}'s rules.
	 * @see Iterator#remove()
	 * @throws IllegalStateException if {@code PrimitiveIterator.nextByte()} was not called prior to {@code Iterator.remove()}
	 * @throws IllegalStateException if no elements remain in the backing array
	 */
	static PrimitiveCyclicIterator.OfByte mc(byte[] array) {
		return new PrimitiveCyclicIterator.OfByte() {
			private int r = 0;
			private int i = 0;
			private boolean next = false;
			public int getRevolutions() { return r >= 0 ? r : Integer.MAX_VALUE; }
			public boolean hasNext() { return i < array.length; }
			public byte nextByte() { next = true; return array[i++]; }
			public void remove() {
				if(!next) throw new IllegalStateException("next must precede this call");
				if(array.length < 1) throw new IllegalStateException("No more elements remaining");
				System.arraycopy(array, i, array, i - 1, array.length - i--);
				next = false;
			}
		};
	}
	/**
	 * Returns an {@code Iterator} whose {@link Iterator#remove() remove} method
	 * will attempt to remove an element from the underlying array according to
	 * the rules of iteration in java.
	 * @param array the underlying (backing) array
	 * @return a mutable iterator whose mutable methods will not throw an
	 * exception when {@link Iterator#remove()} is called within the bounds
	 * of the {@code Iterator}'s rules.
	 * @see Iterator#remove()
	 * @throws IllegalStateException if {@code PrimitiveIterator.nextBoolean()} was not called prior to {@code Iterator.remove()}
	 * @throws IllegalStateException if no elements remain in the backing array
	 */
	static PrimitiveCyclicIterator.OfBoolean mc(boolean[] array) {
		return new PrimitiveCyclicIterator.OfBoolean() {
			private int r = 0;
			private int i = 0;
			private boolean next = false;
			public int getRevolutions() { return r >= 0 ? r : Integer.MAX_VALUE; }
			public boolean hasNext() { return i < array.length; }
			public boolean nextBoolean() { next = true; return array[i++]; }
			public void remove() {
				if(!next) throw new IllegalStateException("next must precede this call");
				if(array.length < 1) throw new IllegalStateException("No more elements remaining");
				System.arraycopy(array, i, array, i - 1, array.length - i--);
				next = false;
			}
		};
	}

	/*
	 * Date created: 16 May 2024 Time created: 11:02:47
	 */
	/**
	 * Prevents runtime instantiation
	 * 
	 * @throws InstantiationError When called
	 */
	private PrimitiveIterators() throws InstantiationError {
		throw new InstantiationError();
	}
}
