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

import jdk.prim.PrimitiveIterable;
import jdk.prim.util.function.PrimitiveConsumer;

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
 * An effort to support primitive collections and streams. Will be fleshed out later.
 * @author Oruovo Etineakpopha Anthony
 */
public interface PrimitiveCollection<T, T_CONS> extends PrimitiveIterable<T, T_CONS>, Collection<T> {
	interface OfDouble extends PrimitiveCollection<Double, PrimitiveConsumer.OfDouble>, PrimitiveIterable.OfDouble {
		boolean addDouble(double d);
		boolean addAllDoubles(PrimitiveCollection.OfDouble data);
		boolean containsDouble(double d);
		boolean containsAll(PrimitiveCollection.OfDouble data);
		PrimitiveIterator.OfDouble iterator();
		
		default boolean add(Double d) {
			return addDouble(d);
		}
		@Override
		default boolean contains(Object o) {
			try {
			return containsDouble((Double) o);
			} catch(ClassCastException e) { return false; }
		}
		/*
		 * Date created: 27 May 2024
		 * Time created: 18:57:08
		 */
		/**
		 * Overrides {@code spliterator} to provide extra functionalities for {@code PrimitiveCollection.OfDouble}
		 * @return
		 * @see mathaid.calculator.base.util.collect.PrimitiveIterable.OfDouble#spliterator()
		 */
		@Override
		PrimitiveSpliterator.OfDouble spliterator();
	}

	PrimitiveSpliterator<T, ?, ?> spliterator();
}
