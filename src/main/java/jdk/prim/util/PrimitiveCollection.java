/*
 * Date created: 19 May 2024
 * Time created: 01:07:42
 * File: DoubleCollection.java
 * Created at: 
 */
/**
 * @author Oruovo Etineakpopha Anthony
 */
package jdk.prim.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Predicate;
import java.util.stream.Stream;

import jdk.prim.PrimitiveIterable;
import jdk.prim.util.function.PrimitiveConsumer;
import jdk.prim.util.function.PrimitivePredicate;
import jdk.prim.util.stream.PrimitiveStream;

/*
 * Date created: 19 May 2024
 * Time created: 01:07:42
 * File: PrimitiveCollection.java
 * Git: 
 * Package: mathaid.calculator.base.util.collect
 * Project: javafxcalculator
 * Type: PrimitiveCollection
 * Created at: 
 * Enclosing Type: 
 */
/**
 * An effort to support primitive collections and streams.
 * 
 * @param <T> the type of the wrapper for the primitive elements in this collection
 * @param <T_CONS> the type of the consumer
 * @param <T_ITR> the type of iterator returned by {@link #iterator()}
 * @see Collection
 * @author Oruovo Etineakpopha Anthony
 */
public interface PrimitiveCollection<
T,
T_CONS> extends PrimitiveIterable<T, T_CONS>, Collection<T> {

	/**
	 * A collection containing only {@code double} elements
	 * <p>
	 * Apart from {@link #iterator()} and {@link #spliterator()}, all
	 * other methods have their corresponding {@code double} specialization
	 * where logically applicable such that if a give {@link Collection} method
	 * is {@link #addAll(Collection)}, then the specialized form will be {@link #addAllDouble}
	 */
	interface OfDouble extends PrimitiveCollection<java.lang.Double, PrimitiveConsumer.OfDouble>, PrimitiveIterable.OfDouble {
		/**
		 * The {@code double} specialisation of {@link #add}
		 * @param element the {@code double} to be added to this collection
		 * @return {@code true} if the argument was successfully added to this collection else returns {@code false}
		 */
		boolean addDouble(double element);
		/**
		 * {@inheritDoc}
		 * @param e {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		default boolean add(java.lang.Double e) { return addDouble(e); }
		/**
		 * Adds all the elements of the given {@code double} collection to
		 * this {@code OfDouble}
		 * @param c the collection to be added
		 * @return {@code true} if all elements were added successfully
		 */
		boolean addAllDouble(PrimitiveCollection.OfDouble c);
		/**
		 * Checks if the argument is present in this (probably using the {@code ==} operator)
		 * collection
		 * @param element the value to be checked
		 * @return {@code true} if the {@code double} value is present in this
		 * collection else returns {@code false}
		 */
		boolean containsDouble(double element);
		@Override
		default boolean contains(Object o) { return (o instanceof java.lang.Double d) ? containsDouble(d) : false; }
		/**
		 * Checks if this collection contains all the elements of the argument collection
		 * @param c the collection to be checked
		 * @return {@code true} if all the {@code double} values in the argument collection
		 * are also present in this collection. Returns {@code false} otherwise.
		 */
		boolean containsAllDouble(PrimitiveCollection.OfDouble c);
		@Override
		default Iterator<java.lang.Double> iterator() { return iteratorDouble(); }
		/**
		 * The {@code double} specialisation of {@link #parallelStream()}
		 * @return a possibly parallel {@code PrimitiveStream.OfDouble} over
		 * the elements of this collection
		 */
		PrimitiveStream.OfDouble parallelStreamDouble();
		/**
		 * {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		default Stream<java.lang.Double> parallelStream() { return parallelStreamDouble().boxed(); }
		/**
		 * Removes the given {@code double} value from this collection
		 * @param element the element to be removed
		 * @return {@code true} if the removal was successful, otherwise
		 * returns {@code false}
		 */
		boolean removeDouble(double element);
		/**
		 * {@inheritDoc}
		 * @param e {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		default boolean remove(java.lang.Double e) { return removeDouble(e); }
		/**
		 * Removes all values present in the argument collection from this collection
		 * 
		 * @param c the collection containing the {@code double} values
		 * to be removed
		 * @return {@code true} if any value was removed as a result of this call.
		 * Returns {@code false} if otherwise.
		 */
		boolean removeAllDouble(PrimitiveCollection.OfDouble c);
		/**
		 * Traverses this collection and removes any element matching the given predicate
		 * @param filter a predicate that accepts a {@code double}, called fo each
		 * element
		 * @return {@code true} if and only if any value was removed
		 */
		default boolean removeIfDouble(PrimitivePredicate.OfDouble filter) {
			PrimitiveIterator.OfDouble it = iteratorDouble();
			boolean rem = false;
			while(it.hasNext()) if(filter.testDouble(it.nextDouble())) {
				it.remove();
				rem = true;
			}
			return rem;
		}
		/**
		 * {@inheritDoc}
		 * @param filter {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		default boolean removeIf(Predicate<? super java.lang.Double> filter) { return removeIfDouble((PrimitivePredicate.OfDouble) filter::test); }
		/**
		 * Removes all elements from this collection except those
		 * matching the ones in the argument collection
		 * @param c the collection containing elements to be retained
		 * @return {@code true} if any value was retained
		 */
		boolean retainAllDouble(PrimitiveCollection.OfDouble c);
		/**
		 * {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		default Spliterator<java.lang.Double> spliterator() { return spliteratorDouble(); }
		/**
		 * The {@code double} specialization of {@link #stream()}
		 * @return a {@code PrimitiveStream.OfDouble} (sequential or otherwise)
		 */
		PrimitiveStream.OfDouble streamDouble();
		/**
		 * {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		default Stream<java.lang.Double> stream() { return streamDouble().boxed(); }
		/**
		 * The {@code double} specialization of {@link #toArray()}
		 * @return a {@code double} array
		 */
		double[] toArrayDouble();
		/**
		 * {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		default java.lang.Double[] toArray() { return PrimitiveArrays.map(toArrayDouble(), (jdk.prim.util.function.PrimitiveFunction.OfDouble<java.lang.Double>)e -> java.lang.Double.valueOf(e)); }
	}
	/**
	 * A collection containing only {@code long} elements
	 * <p>
	 * Apart from {@link #iterator()} and {@link #spliterator()}, all
	 * other methods have their corresponding {@code long} specialization
	 * where logically applicable such that if a give {@link Collection} method
	 * is {@link #addAll(Collection)}, then the specialized form will be {@link #addAllLong}
	 */
	interface OfLong extends PrimitiveCollection<java.lang.Long, PrimitiveConsumer.OfLong>, PrimitiveIterable.OfLong {
		/**
		 * The {@code long} specialisation of {@link #add}
		 * @param element the {@code long} to be added to this collection
		 * @return {@code true} if the argument was successfully added to this collection else returns {@code false}
		 */
		boolean addLong(long element);
		/**
		 * {@inheritDoc}
		 * @param e {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		default boolean add(java.lang.Long e) { return addLong(e); }
		/**
		 * Adds all the elements of the given {@code long} collection to
		 * this {@code OfLong}
		 * @param c the collection to be added
		 * @return {@code true} if all elements were added successfully
		 */
		boolean addAllLong(PrimitiveCollection.OfLong c);
		/**
		 * Checks if the argument is present in this (probably using the {@code ==} operator)
		 * collection
		 * @param element the value to be checked
		 * @return {@code true} if the {@code long} value is present in this
		 * collection else returns {@code false}
		 */
		boolean containsLong(long element);
		@Override
		default boolean contains(Object o) { return (o instanceof java.lang.Long l) ? containsLong(l) : false; }
		/**
		 * Checks if this collection contains all the elements of the argument collection
		 * @param c the collection to be checked
		 * @return {@code true} if all the {@code long} values in the argument collection
		 * are also present in this collection. Returns {@code false} otherwise.
		 */
		boolean containsAllLong(PrimitiveCollection.OfLong c);
		@Override
		default Iterator<java.lang.Long> iterator() { return iteratorLong(); }
		/**
		 * The {@code long} specialisation of {@link #parallelStream()}
		 * @return a possibly parallel {@code PrimitiveStream.OfLong} over
		 * the elements of this collection
		 */
		PrimitiveStream.OfLong parallelStreamLong();
		/**
		 * {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		default Stream<java.lang.Long> parallelStream() { return parallelStreamLong().boxed(); }
		/**
		 * Removes the given {@code long} value from this collection
		 * @param element the element to be removed
		 * @return {@code true} if the removal was successful, otherwise
		 * returns {@code false}
		 */
		boolean removeLong(long element);
		/**
		 * {@inheritDoc}
		 * @param e {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		default boolean remove(java.lang.Long e) { return removeLong(e); }
		/**
		 * Removes all values present in the argument collection from this collection
		 * 
		 * @param c the collection containing the {@code long} values
		 * to be removed
		 * @return {@code true} if any value was removed as a result of this call.
		 * Returns {@code false} if otherwise.
		 */
		boolean removeAllLong(PrimitiveCollection.OfLong c);
		/**
		 * Traverses this collection and removes any element matching the given predicate
		 * @param filter a predicate that accepts a {@code long}, called fo each
		 * element
		 * @return {@code true} if and only if any value was removed
		 */
		default boolean removeIfLong(PrimitivePredicate.OfLong filter) {
			PrimitiveIterator.OfLong it = iteratorLong();
			boolean rem = false;
			while(it.hasNext()) if(filter.testLong(it.nextLong())) {
				it.remove();
				rem = true;
			}
			return rem;
		}
		/**
		 * {@inheritDoc}
		 * @param filter {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		default boolean removeIf(Predicate<? super java.lang.Long> filter) { return removeIfLong((PrimitivePredicate.OfLong) filter::test); }
		/**
		 * Removes all elements from this collection except those
		 * matching the ones in the argument collection
		 * @param c the collection containing elements to be retained
		 * @return {@code true} if any value was retained
		 */
		boolean retainAllLong(PrimitiveCollection.OfLong c);
		/**
		 * {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		default Spliterator<java.lang.Long> spliterator() { return spliteratorLong(); }
		/**
		 * The {@code long} specialization of {@link #stream()}
		 * @return a {@code PrimitiveStream.OfLong} (sequential or otherwise)
		 */
		PrimitiveStream.OfLong streamLong();
		/**
		 * {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		default Stream<java.lang.Long> stream() { return streamLong().boxed(); }
		/**
		 * The {@code long} specialization of {@link #toArray()}
		 * @return a {@code long} array
		 */
		long[] toArrayLong();
		/**
		 * {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		default java.lang.Long[] toArray() { return PrimitiveArrays.map(toArrayLong(), (jdk.prim.util.function.PrimitiveFunction.OfLong<java.lang.Long>)e -> java.lang.Long.valueOf(e)); }
	}
	/**
	 * A collection containing only {@code int} elements
	 * <p>
	 * Apart from {@link #iterator()} and {@link #spliterator()}, all
	 * other methods have their corresponding {@code int} specialization
	 * where logically applicable such that if a give {@link Collection} method
	 * is {@link #addAll(Collection)}, then the specialized form will be {@link #addAllInt}
	 */
	interface OfInt extends PrimitiveCollection<java.lang.Integer, PrimitiveConsumer.OfInt>, PrimitiveIterable.OfInt {
		/**
		 * The {@code int} specialisation of {@link #add}
		 * @param element the {@code int} to be added to this collection
		 * @return {@code true} if the argument was successfully added to this collection else returns {@code false}
		 */
		boolean addInt(int element);
		/**
		 * {@inheritDoc}
		 * @param e {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		default boolean add(java.lang.Integer e) { return addInt(e); }
		/**
		 * Adds all the elements of the given {@code int} collection to
		 * this {@code OfInt}
		 * @param c the collection to be added
		 * @return {@code true} if all elements were added successfully
		 */
		boolean addAllInt(PrimitiveCollection.OfInt c);
		/**
		 * Checks if the argument is present in this (probably using the {@code ==} operator)
		 * collection
		 * @param element the value to be checked
		 * @return {@code true} if the {@code int} value is present in this
		 * collection else returns {@code false}
		 */
		boolean containsInt(int element);
		@Override
		default boolean contains(Object o) { return (o instanceof java.lang.Integer i) ? containsInt(i) : false; }
		/**
		 * Checks if this collection contains all the elements of the argument collection
		 * @param c the collection to be checked
		 * @return {@code true} if all the {@code int} values in the argument collection
		 * are also present in this collection. Returns {@code false} otherwise.
		 */
		boolean containsAllInt(PrimitiveCollection.OfInt c);
		@Override
		default Iterator<java.lang.Integer> iterator() { return iteratorInt(); }
		/**
		 * The {@code int} specialisation of {@link #parallelStream()}
		 * @return a possibly parallel {@code PrimitiveStream.OfInt} over
		 * the elements of this collection
		 */
		PrimitiveStream.OfInt parallelStreamInt();
		/**
		 * {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		default Stream<java.lang.Integer> parallelStream() { return parallelStreamInt().boxed(); }
		/**
		 * Removes the given {@code int} value from this collection
		 * @param element the element to be removed
		 * @return {@code true} if the removal was successful, otherwise
		 * returns {@code false}
		 */
		boolean removeInt(int element);
		/**
		 * {@inheritDoc}
		 * @param e {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		default boolean remove(java.lang.Integer e) { return removeInt(e); }
		/**
		 * Removes all values present in the argument collection from this collection
		 * 
		 * @param c the collection containing the {@code int} values
		 * to be removed
		 * @return {@code true} if any value was removed as a result of this call.
		 * Returns {@code false} if otherwise.
		 */
		boolean removeAllInt(PrimitiveCollection.OfInt c);
		/**
		 * Traverses this collection and removes any element matching the given predicate
		 * @param filter a predicate that accepts a {@code int}, called fo each
		 * element
		 * @return {@code true} if and only if any value was removed
		 */
		default boolean removeIfInt(PrimitivePredicate.OfInt filter) {
			PrimitiveIterator.OfInt it = iteratorInt();
			boolean rem = false;
			while(it.hasNext()) if(filter.testInt(it.nextInt())) {
				it.remove();
				rem = true;
			}
			return rem;
		}
		/**
		 * {@inheritDoc}
		 * @param filter {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		default boolean removeIf(Predicate<? super java.lang.Integer> filter) { return removeIfInt((PrimitivePredicate.OfInt) filter::test); }
		/**
		 * Removes all elements from this collection except those
		 * matching the ones in the argument collection
		 * @param c the collection containing elements to be retained
		 * @return {@code true} if any value was retained
		 */
		boolean retainAllInt(PrimitiveCollection.OfInt c);
		/**
		 * {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		default Spliterator<java.lang.Integer> spliterator() { return spliteratorInt(); }
		/**
		 * The {@code int} specialization of {@link #stream()}
		 * @return a {@code PrimitiveStream.OfInt} (sequential or otherwise)
		 */
		PrimitiveStream.OfInt streamInt();
		/**
		 * {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		default Stream<java.lang.Integer> stream() { return streamInt().boxed(); }
		/**
		 * The {@code int} specialization of {@link #toArray()}
		 * @return a {@code int} array
		 */
		int[] toArrayInt();
		/**
		 * {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		default java.lang.Integer[] toArray() { return PrimitiveArrays.map(toArrayInt(), (jdk.prim.util.function.PrimitiveFunction.OfInt<java.lang.Integer>)e -> java.lang.Integer.valueOf(e)); }
	}
	/**
	 * A collection containing only {@code float} elements
	 * <p>
	 * Apart from {@link #iterator()} and {@link #spliterator()}, all
	 * other methods have their corresponding {@code float} specialization
	 * where logically applicable such that if a give {@link Collection} method
	 * is {@link #addAll(Collection)}, then the specialized form will be {@link #addAllFloat}
	 */
	interface OfFloat extends PrimitiveCollection<java.lang.Float, PrimitiveConsumer.OfFloat>, PrimitiveIterable.OfFloat {
		/**
		 * The {@code float} specialisation of {@link #add}
		 * @param element the {@code float} to be added to this collection
		 * @return {@code true} if the argument was successfully added to this collection else returns {@code false}
		 */
		boolean addFloat(float element);
		/**
		 * {@inheritDoc}
		 * @param e {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		default boolean add(java.lang.Float e) { return addFloat(e); }
		/**
		 * Adds all the elements of the given {@code float} collection to
		 * this {@code OfFloat}
		 * @param c the collection to be added
		 * @return {@code true} if all elements were added successfully
		 */
		boolean addAllFloat(PrimitiveCollection.OfFloat c);
		/**
		 * Checks if the argument is present in this (probably using the {@code ==} operator)
		 * collection
		 * @param element the value to be checked
		 * @return {@code true} if the {@code float} value is present in this
		 * collection else returns {@code false}
		 */
		boolean containsFloat(float element);
		@Override
		default boolean contains(Object o) { return (o instanceof java.lang.Float f) ? containsFloat(f) : false; }
		/**
		 * Checks if this collection contains all the elements of the argument collection
		 * @param c the collection to be checked
		 * @return {@code true} if all the {@code float} values in the argument collection
		 * are also present in this collection. Returns {@code false} otherwise.
		 */
		boolean containsAllFloat(PrimitiveCollection.OfFloat c);
		@Override
		default Iterator<java.lang.Float> iterator() { return iteratorFloat(); }
		/**
		 * The {@code float} specialisation of {@link #parallelStream()}
		 * @return a possibly parallel {@code PrimitiveStream.OfFloat} over
		 * the elements of this collection
		 */
		PrimitiveStream.OfFloat parallelStreamFloat();
		/**
		 * {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		default Stream<java.lang.Float> parallelStream() { return parallelStreamFloat().boxed(); }
		/**
		 * Removes the given {@code float} value from this collection
		 * @param element the element to be removed
		 * @return {@code true} if the removal was successful, otherwise
		 * returns {@code false}
		 */
		boolean removeFloat(float element);
		/**
		 * {@inheritDoc}
		 * @param e {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		default boolean remove(java.lang.Float e) { return removeFloat(e); }
		/**
		 * Removes all values present in the argument collection from this collection
		 * 
		 * @param c the collection containing the {@code float} values
		 * to be removed
		 * @return {@code true} if any value was removed as a result of this call.
		 * Returns {@code false} if otherwise.
		 */
		boolean removeAllFloat(PrimitiveCollection.OfFloat c);
		/**
		 * Traverses this collection and removes any element matching the given predicate
		 * @param filter a predicate that accepts a {@code float}, called fo each
		 * element
		 * @return {@code true} if and only if any value was removed
		 */
		default boolean removeIfFloat(PrimitivePredicate.OfFloat filter) {
			PrimitiveIterator.OfFloat it = iteratorFloat();
			boolean rem = false;
			while(it.hasNext()) if(filter.testFloat(it.nextFloat())) {
				it.remove();
				rem = true;
			}
			return rem;
		}
		/**
		 * {@inheritDoc}
		 * @param filter {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		default boolean removeIf(Predicate<? super java.lang.Float> filter) { return removeIfFloat((PrimitivePredicate.OfFloat) filter::test); }
		/**
		 * Removes all elements from this collection except those
		 * matching the ones in the argument collection
		 * @param c the collection containing elements to be retained
		 * @return {@code true} if any value was retained
		 */
		boolean retainAllFloat(PrimitiveCollection.OfFloat c);
		/**
		 * {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		default Spliterator<java.lang.Float> spliterator() { return spliteratorFloat(); }
		/**
		 * The {@code float} specialization of {@link #stream()}
		 * @return a {@code PrimitiveStream.OfFloat} (sequential or otherwise)
		 */
		PrimitiveStream.OfFloat streamFloat();
		/**
		 * {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		default Stream<java.lang.Float> stream() { return streamFloat().boxed(); }
		/**
		 * The {@code float} specialization of {@link #toArray()}
		 * @return a {@code float} array
		 */
		float[] toArrayFloat();
		/**
		 * {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		default java.lang.Float[] toArray() { return PrimitiveArrays.map(toArrayFloat(), (jdk.prim.util.function.PrimitiveFunction.OfFloat<java.lang.Float>)e -> java.lang.Float.valueOf(e)); }
	}
	/**
	 * A collection containing only {@code char} elements
	 * <p>
	 * Apart from {@link #iterator()} and {@link #spliterator()}, all
	 * other methods have their corresponding {@code char} specialization
	 * where logically applicable such that if a give {@link Collection} method
	 * is {@link #addAll(Collection)}, then the specialized form will be {@link #addAllChar}
	 */
	interface OfChar extends PrimitiveCollection<java.lang.Character, PrimitiveConsumer.OfChar>, PrimitiveIterable.OfChar {
		/**
		 * The {@code char} specialisation of {@link #add}
		 * @param element the {@code char} to be added to this collection
		 * @return {@code true} if the argument was successfully added to this collection else returns {@code false}
		 */
		boolean addChar(char element);
		/**
		 * {@inheritDoc}
		 * @param e {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		default boolean add(java.lang.Character e) { return addChar(e); }
		/**
		 * Adds all the elements of the given {@code char} collection to
		 * this {@code OfChar}
		 * @param c the collection to be added
		 * @return {@code true} if all elements were added successfully
		 */
		boolean addAllChar(PrimitiveCollection.OfChar c);
		/**
		 * Checks if the argument is present in this (probably using the {@code ==} operator)
		 * collection
		 * @param element the value to be checked
		 * @return {@code true} if the {@code char} value is present in this
		 * collection else returns {@code false}
		 */
		boolean containsChar(char element);
		@Override
		default boolean contains(Object o) { return (o instanceof java.lang.Character c) ? containsChar(c) : false; }
		/**
		 * Checks if this collection contains all the elements of the argument collection
		 * @param c the collection to be checked
		 * @return {@code true} if all the {@code char} values in the argument collection
		 * are also present in this collection. Returns {@code false} otherwise.
		 */
		boolean containsAllChar(PrimitiveCollection.OfChar c);
		@Override
		default Iterator<java.lang.Character> iterator() { return iteratorChar(); }
		/**
		 * The {@code char} specialisation of {@link #parallelStream()}
		 * @return a possibly parallel {@code PrimitiveStream.OfChar} over
		 * the elements of this collection
		 */
		PrimitiveStream.OfChar parallelStreamChar();
		/**
		 * {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		default Stream<java.lang.Character> parallelStream() { return parallelStreamChar().boxed(); }
		/**
		 * Removes the given {@code char} value from this collection
		 * @param element the element to be removed
		 * @return {@code true} if the removal was successful, otherwise
		 * returns {@code false}
		 */
		boolean removeChar(char element);
		/**
		 * {@inheritDoc}
		 * @param e {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		default boolean remove(java.lang.Character e) { return removeChar(e); }
		/**
		 * Removes all values present in the argument collection from this collection
		 * 
		 * @param c the collection containing the {@code char} values
		 * to be removed
		 * @return {@code true} if any value was removed as a result of this call.
		 * Returns {@code false} if otherwise.
		 */
		boolean removeAllChar(PrimitiveCollection.OfChar c);
		/**
		 * Traverses this collection and removes any element matching the given predicate
		 * @param filter a predicate that accepts a {@code char}, called fo each
		 * element
		 * @return {@code true} if and only if any value was removed
		 */
		default boolean removeIfChar(PrimitivePredicate.OfChar filter) {
			PrimitiveIterator.OfChar it = iteratorChar();
			boolean rem = false;
			while(it.hasNext()) if(filter.testChar(it.nextChar())) {
				it.remove();
				rem = true;
			}
			return rem;
		}
		/**
		 * {@inheritDoc}
		 * @param filter {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		default boolean removeIf(Predicate<? super java.lang.Character> filter) { return removeIfChar((PrimitivePredicate.OfChar) filter::test); }
		/**
		 * Removes all elements from this collection except those
		 * matching the ones in the argument collection
		 * @param c the collection containing elements to be retained
		 * @return {@code true} if any value was retained
		 */
		boolean retainAllChar(PrimitiveCollection.OfChar c);
		/**
		 * {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		default Spliterator<java.lang.Character> spliterator() { return spliteratorChar(); }
		/**
		 * The {@code char} specialization of {@link #stream()}
		 * @return a {@code PrimitiveStream.OfChar} (sequential or otherwise)
		 */
		PrimitiveStream.OfChar streamChar();
		/**
		 * {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		default Stream<java.lang.Character> stream() { return streamChar().boxed(); }
		/**
		 * The {@code char} specialization of {@link #toArray()}
		 * @return a {@code char} array
		 */
		char[] toArrayChar();
		/**
		 * {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		default java.lang.Character[] toArray() { return PrimitiveArrays.map(toArrayChar(), (jdk.prim.util.function.PrimitiveFunction.OfChar<java.lang.Character>)e -> java.lang.Character.valueOf(e)); }
	}
	/**
	 * A collection containing only {@code short} elements
	 * <p>
	 * Apart from {@link #iterator()} and {@link #spliterator()}, all
	 * other methods have their corresponding {@code short} specialization
	 * where logically applicable such that if a give {@link Collection} method
	 * is {@link #addAll(Collection)}, then the specialized form will be {@link #addAllShort}
	 */
	interface OfShort extends PrimitiveCollection<java.lang.Short, PrimitiveConsumer.OfShort>, PrimitiveIterable.OfShort {
		/**
		 * The {@code short} specialisation of {@link #add}
		 * @param element the {@code short} to be added to this collection
		 * @return {@code true} if the argument was successfully added to this collection else returns {@code false}
		 */
		boolean addShort(short element);
		/**
		 * {@inheritDoc}
		 * @param e {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		default boolean add(java.lang.Short e) { return addShort(e); }
		/**
		 * Adds all the elements of the given {@code short} collection to
		 * this {@code OfShort}
		 * @param c the collection to be added
		 * @return {@code true} if all elements were added successfully
		 */
		boolean addAllShort(PrimitiveCollection.OfShort c);
		/**
		 * Checks if the argument is present in this (probably using the {@code ==} operator)
		 * collection
		 * @param element the value to be checked
		 * @return {@code true} if the {@code short} value is present in this
		 * collection else returns {@code false}
		 */
		boolean containsShort(short element);
		@Override
		default boolean contains(Object o) { return (o instanceof java.lang.Short s) ? containsShort(s) : false; }
		/**
		 * Checks if this collection contains all the elements of the argument collection
		 * @param c the collection to be checked
		 * @return {@code true} if all the {@code short} values in the argument collection
		 * are also present in this collection. Returns {@code false} otherwise.
		 */
		boolean containsAllShort(PrimitiveCollection.OfShort c);
		@Override
		default Iterator<java.lang.Short> iterator() { return iteratorShort(); }
		/**
		 * The {@code short} specialisation of {@link #parallelStream()}
		 * @return a possibly parallel {@code PrimitiveStream.OfShort} over
		 * the elements of this collection
		 */
		PrimitiveStream.OfShort parallelStreamShort();
		/**
		 * {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		default Stream<java.lang.Short> parallelStream() { return parallelStreamShort().boxed(); }
		/**
		 * Removes the given {@code short} value from this collection
		 * @param element the element to be removed
		 * @return {@code true} if the removal was successful, otherwise
		 * returns {@code false}
		 */
		boolean removeShort(short element);
		/**
		 * {@inheritDoc}
		 * @param e {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		default boolean remove(java.lang.Short e) { return removeShort(e); }
		/**
		 * Removes all values present in the argument collection from this collection
		 * 
		 * @param c the collection containing the {@code short} values
		 * to be removed
		 * @return {@code true} if any value was removed as a result of this call.
		 * Returns {@code false} if otherwise.
		 */
		boolean removeAllShort(PrimitiveCollection.OfShort c);
		/**
		 * Traverses this collection and removes any element matching the given predicate
		 * @param filter a predicate that accepts a {@code short}, called fo each
		 * element
		 * @return {@code true} if and only if any value was removed
		 */
		default boolean removeIfShort(PrimitivePredicate.OfShort filter) {
			PrimitiveIterator.OfShort it = iteratorShort();
			boolean rem = false;
			while(it.hasNext()) if(filter.testShort(it.nextShort())) {
				it.remove();
				rem = true;
			}
			return rem;
		}
		/**
		 * {@inheritDoc}
		 * @param filter {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		default boolean removeIf(Predicate<? super java.lang.Short> filter) { return removeIfShort((PrimitivePredicate.OfShort) filter::test); }
		/**
		 * Removes all elements from this collection except those
		 * matching the ones in the argument collection
		 * @param c the collection containing elements to be retained
		 * @return {@code true} if any value was retained
		 */
		boolean retainAllShort(PrimitiveCollection.OfShort c);
		/**
		 * {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		default Spliterator<java.lang.Short> spliterator() { return spliteratorShort(); }
		/**
		 * The {@code short} specialization of {@link #stream()}
		 * @return a {@code PrimitiveStream.OfShort} (sequential or otherwise)
		 */
		PrimitiveStream.OfShort streamShort();
		/**
		 * {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		default Stream<java.lang.Short> stream() { return streamShort().boxed(); }
		/**
		 * The {@code short} specialization of {@link #toArray()}
		 * @return a {@code short} array
		 */
		short[] toArrayShort();
		/**
		 * {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		default java.lang.Short[] toArray() { return PrimitiveArrays.map(toArrayShort(), (jdk.prim.util.function.PrimitiveFunction.OfShort<java.lang.Short>)e -> java.lang.Short.valueOf(e)); }
	}
	/**
	 * A collection containing only {@code byte} elements
	 * <p>
	 * Apart from {@link #iterator()} and {@link #spliterator()}, all
	 * other methods have their corresponding {@code byte} specialization
	 * where logically applicable such that if a give {@link Collection} method
	 * is {@link #addAll(Collection)}, then the specialized form will be {@link #addAllByte}
	 */
	interface OfByte extends PrimitiveCollection<java.lang.Byte, PrimitiveConsumer.OfByte>, PrimitiveIterable.OfByte {
		/**
		 * The {@code byte} specialisation of {@link #add}
		 * @param element the {@code byte} to be added to this collection
		 * @return {@code true} if the argument was successfully added to this collection else returns {@code false}
		 */
		boolean addByte(byte element);
		/**
		 * {@inheritDoc}
		 * @param e {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		default boolean add(java.lang.Byte e) { return addByte(e); }
		/**
		 * Adds all the elements of the given {@code byte} collection to
		 * this {@code OfByte}
		 * @param c the collection to be added
		 * @return {@code true} if all elements were added successfully
		 */
		boolean addAllByte(PrimitiveCollection.OfByte c);
		/**
		 * Checks if the argument is present in this (probably using the {@code ==} operator)
		 * collection
		 * @param element the value to be checked
		 * @return {@code true} if the {@code byte} value is present in this
		 * collection else returns {@code false}
		 */
		boolean containsByte(byte element);
		@Override
		default boolean contains(Object o) { return (o instanceof java.lang.Byte b) ? containsByte(b) : false; }
		/**
		 * Checks if this collection contains all the elements of the argument collection
		 * @param c the collection to be checked
		 * @return {@code true} if all the {@code byte} values in the argument collection
		 * are also present in this collection. Returns {@code false} otherwise.
		 */
		boolean containsAllByte(PrimitiveCollection.OfByte c);
		@Override
		default Iterator<java.lang.Byte> iterator() { return iteratorByte(); }
		/**
		 * The {@code byte} specialisation of {@link #parallelStream()}
		 * @return a possibly parallel {@code PrimitiveStream.OfByte} over
		 * the elements of this collection
		 */
		PrimitiveStream.OfByte parallelStreamByte();
		/**
		 * {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		default Stream<java.lang.Byte> parallelStream() { return parallelStreamByte().boxed(); }
		/**
		 * Removes the given {@code byte} value from this collection
		 * @param element the element to be removed
		 * @return {@code true} if the removal was successful, otherwise
		 * returns {@code false}
		 */
		boolean removeByte(byte element);
		/**
		 * {@inheritDoc}
		 * @param e {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		default boolean remove(java.lang.Byte e) { return removeByte(e); }
		/**
		 * Removes all values present in the argument collection from this collection
		 * 
		 * @param c the collection containing the {@code byte} values
		 * to be removed
		 * @return {@code true} if any value was removed as a result of this call.
		 * Returns {@code false} if otherwise.
		 */
		boolean removeAllByte(PrimitiveCollection.OfByte c);
		/**
		 * Traverses this collection and removes any element matching the given predicate
		 * @param filter a predicate that accepts a {@code byte}, called fo each
		 * element
		 * @return {@code true} if and only if any value was removed
		 */
		default boolean removeIfByte(PrimitivePredicate.OfByte filter) {
			PrimitiveIterator.OfByte it = iteratorByte();
			boolean rem = false;
			while(it.hasNext()) if(filter.testByte(it.nextByte())) {
				it.remove();
				rem = true;
			}
			return rem;
		}
		/**
		 * {@inheritDoc}
		 * @param filter {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		default boolean removeIf(Predicate<? super java.lang.Byte> filter) { return removeIfByte((PrimitivePredicate.OfByte) filter::test); }
		/**
		 * Removes all elements from this collection except those
		 * matching the ones in the argument collection
		 * @param c the collection containing elements to be retained
		 * @return {@code true} if any value was retained
		 */
		boolean retainAllByte(PrimitiveCollection.OfByte c);
		/**
		 * {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		default Spliterator<java.lang.Byte> spliterator() { return spliteratorByte(); }
		/**
		 * The {@code byte} specialization of {@link #stream()}
		 * @return a {@code PrimitiveStream.OfByte} (sequential or otherwise)
		 */
		PrimitiveStream.OfByte streamByte();
		/**
		 * {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		default Stream<java.lang.Byte> stream() { return streamByte().boxed(); }
		/**
		 * The {@code byte} specialization of {@link #toArray()}
		 * @return a {@code byte} array
		 */
		byte[] toArrayByte();
		/**
		 * {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		default java.lang.Byte[] toArray() { return PrimitiveArrays.map(toArrayByte(), (jdk.prim.util.function.PrimitiveFunction.OfByte<java.lang.Byte>)e -> java.lang.Byte.valueOf(e)); }
	}
	/**
	 * A collection containing only {@code boolean} elements
	 * <p>
	 * Apart from {@link #iterator()} and {@link #spliterator()}, all
	 * other methods have their corresponding {@code boolean} specialization
	 * where logically applicable such that if a give {@link Collection} method
	 * is {@link #addAll(Collection)}, then the specialized form will be {@link #addAllBoolean}
	 */
	interface OfBoolean extends PrimitiveCollection<java.lang.Boolean, PrimitiveConsumer.OfBoolean>, PrimitiveIterable.OfBoolean {
		/**
		 * The {@code boolean} specialisation of {@link #add}
		 * @param element the {@code boolean} to be added to this collection
		 * @return {@code true} if the argument was successfully added to this collection else returns {@code false}
		 */
		boolean addBoolean(boolean element);
		/**
		 * {@inheritDoc}
		 * @param e {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		default boolean add(java.lang.Boolean e) { return addBoolean(e); }
		/**
		 * Adds all the elements of the given {@code boolean} collection to
		 * this {@code OfBoolean}
		 * @param c the collection to be added
		 * @return {@code true} if all elements were added successfully
		 */
		boolean addAllBoolean(PrimitiveCollection.OfBoolean c);
		/**
		 * Checks if the argument is present in this (probably using the {@code ==} operator)
		 * collection
		 * @param element the value to be checked
		 * @return {@code true} if the {@code boolean} value is present in this
		 * collection else returns {@code false}
		 */
		boolean containsBoolean(boolean element);
		@Override
		default boolean contains(Object o) { return (o instanceof java.lang.Boolean b) ? containsBoolean(b) : false; }
		/**
		 * Checks if this collection contains all the elements of the argument collection
		 * @param c the collection to be checked
		 * @return {@code true} if all the {@code boolean} values in the argument collection
		 * are also present in this collection. Returns {@code false} otherwise.
		 */
		boolean containsAllBoolean(PrimitiveCollection.OfBoolean c);
		@Override
		default Iterator<java.lang.Boolean> iterator() { return iteratorBoolean(); }
		/**
		 * The {@code boolean} specialisation of {@link #parallelStream()}
		 * @return a possibly parallel {@code PrimitiveStream.OfBoolean} over
		 * the elements of this collection
		 */
		PrimitiveStream.OfBoolean parallelStreamBoolean();
		/**
		 * {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		default Stream<java.lang.Boolean> parallelStream() { return parallelStreamBoolean().boxed(); }
		/**
		 * Removes the given {@code boolean} value from this collection
		 * @param element the element to be removed
		 * @return {@code true} if the removal was successful, otherwise
		 * returns {@code false}
		 */
		boolean removeBoolean(boolean element);
		/**
		 * {@inheritDoc}
		 * @param e {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		default boolean remove(java.lang.Boolean e) { return removeBoolean(e); }
		/**
		 * Removes all values present in the argument collection from this collection
		 * 
		 * @param c the collection containing the {@code boolean} values
		 * to be removed
		 * @return {@code true} if any value was removed as a result of this call.
		 * Returns {@code false} if otherwise.
		 */
		boolean removeAllBoolean(PrimitiveCollection.OfBoolean c);
		/**
		 * Traverses this collection and removes any element matching the given predicate
		 * @param filter a predicate that accepts a {@code boolean}, called fo each
		 * element
		 * @return {@code true} if and only if any value was removed
		 */
		default boolean removeIfBoolean(PrimitivePredicate.OfBoolean filter) {
			PrimitiveIterator.OfBoolean it = iteratorBoolean();
			boolean rem = false;
			while(it.hasNext()) if(filter.testBoolean(it.nextBoolean())) {
				it.remove();
				rem = true;
			}
			return rem;
		}
		/**
		 * {@inheritDoc}
		 * @param filter {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		default boolean removeIf(Predicate<? super java.lang.Boolean> filter) { return removeIfBoolean((PrimitivePredicate.OfBoolean) filter::test); }
		/**
		 * Removes all elements from this collection except those
		 * matching the ones in the argument collection
		 * @param c the collection containing elements to be retained
		 * @return {@code true} if any value was retained
		 */
		boolean retainAllBoolean(PrimitiveCollection.OfBoolean c);
		/**
		 * {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		default Spliterator<java.lang.Boolean> spliterator() { return spliteratorBoolean(); }
		/**
		 * The {@code boolean} specialization of {@link #stream()}
		 * @return a {@code PrimitiveStream.OfBoolean} (sequential or otherwise)
		 */
		PrimitiveStream.OfBoolean streamBoolean();
		/**
		 * {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		default Stream<java.lang.Boolean> stream() { return streamBoolean().boxed(); }
		/**
		 * The {@code boolean} specialization of {@link #toArray()}
		 * @return a {@code boolean} array
		 */
		boolean[] toArrayBoolean();
		/**
		 * {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		default java.lang.Boolean[] toArray() { return PrimitiveArrays.map(toArrayBoolean(), (jdk.prim.util.function.PrimitiveFunction.OfBoolean<java.lang.Boolean>)e -> java.lang.Boolean.valueOf(e)); }
	}

}
