/**
 * 
 */
package jdk.prim.util;

import java.util.NoSuchElementException;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;

import jdk.prim.util.function.PrimitiveConsumer;
import jdk.prim.util.function.PrimitiveSupplier;

/**
 * An effort to support primitive collections and streams. Will be fleshed out later.
 * 
 */
public interface PrimitiveOptional<T_CONS, T_Stream> {
	
	interface OfDouble extends PrimitiveOptional<PrimitiveConsumer.OfDouble, DoubleStream> {
		double getDouble() throws NoSuchElementException;
		default double orElse(double d) {
			return isPresent() ? getDouble() : d;
		}
		default double orElseGet(PrimitiveSupplier.ToDouble supplier) {
			return isPresent() ? getDouble() : supplier.getDouble();
		}
		default double orElseThrow() {
			if(isPresent()) return getDouble();
			throw new NoSuchElementException();
		}
		default <X extends Throwable> double orElseThrow(Supplier<X> exceptionFactory) throws X {
			if(isPresent()) return getDouble();
			throw exceptionFactory.get();
		}
		@Override
		default void ifPresent(PrimitiveConsumer.OfDouble action) {
			if(isPresent()) action.acceptDouble(getDouble());
		}
		@Override
		default void ifPresentElse(PrimitiveConsumer.OfDouble ifAction, Runnable elseAction) {
			if(isPresent()) ifAction.acceptDouble(getDouble());
			else elseAction.run();			
		}
		@Override
		default DoubleStream stream() {
			return DoubleStream.of(getDouble());
		}
	}
	
	void ifPresent(T_CONS action);
	void ifPresentElse(T_CONS ifAction, Runnable elseAction);
	boolean isEmpty();
	boolean isPresent();
	T_Stream stream();
	@Override
	boolean equals(Object other);
	@Override
	int hashCode();
}
