/**
 * 
 */
package jdk.prim.util.function;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.LongBinaryOperator;
import java.util.function.ToDoubleBiFunction;
import java.util.function.ToIntBiFunction;
import java.util.function.ToLongBiFunction;

/**
 * It uses the following convention: <code>To*</code> refers to the return type, {@code Of*} refers to the first argument, {@code And*} refers to the second argument. When they are nested then the
 * convention remains mostly the same.
 * <p>
 * The point of this interface (and it's subsequent nested sub-interfaces) is to cover all use cases for {@code BiFunction} with Java's primitives, while providing
 * the opportunity for possible integration of with current JDK implementations such as:
 * <ul>
 * <li>{@link BinaryOperator}</li>
 * <li>{@link DoubleBinaryOperator}</li>
 * <li>{@link ToDoubleBiFunction}</li>
 * <li>{@link LongBinaryOperator}</li>
 * <li>{@link ToLongBiFunction}</li>
 * <li>{@link IntBinaryOperator}</li>
 * <li>{@link ToIntBiFunction}</li>
 * </ul>
 * @param <TO>
 * @param <AND>
 * @param <OF>
 */
@FunctionalInterface public interface PrimitiveBiFunction<TO, AND, OF/*, B extends PrimitiveBiFunction<T, U, R, B>*/> extends BiFunction<OF, AND, TO> {
	
	/**
	 * A {@code BiFunction} that returns a {@code double} as a result. It includes a generic implementation of {@link #apply}
	 * and a more specialised implementation of {@link #applyDouble} whereby the latter gets more specialised implementations with
	 * the nested sub-interfaces.
	 * <p>
	 * The purpose of this interface is to
	 * <ol>
	 * <li>make retrofitting the {@code BiFunction} with {@code double} based interfaces possible.
	 * <p>
	 * This is apparent by the fact that all similar interface(s) within the primitive-{@code double}-{@code BiFunction}
	 * are extended. For example this class extends {@code ToDoubleBiFunction} to provide legacy code with the option
	 * of retrofitting their implementation(s) with this one, for instance, the following snippet is from a library in which
	 * we had no control over how code was written:
	 * <pre>{@code
	 * public interface LegacyInterface {
	 *   ToDoubleBiFunction apiMethod();
	 * }
	 * }</pre>
	 * But we can re-implement the above, retrofitting it with our primitive {@code double} equivalent:
	 * <pre>{@code
	 * public interface MyInterface extends LegacyInterface {
	 * 	PrimitiveBiFunction apiMethod();
	 * }
	 * }</pre>
	 * </li>
	 * <li>use java's naming conventions to allow for familiarity when working with {@code double} functions and bi-functions.
	 * An Example of this is:
	 * <pre>{@code
	 * java.util.function.ToDoubleBiFunction<String, BigInteger> f = (s, i) -> useParamThenReturnDouble(s, i); //The JDK's interface for BiFunction that returns a double
	 * PrimitiveBiFunction.ToDouble<String, BigInteger> g = (s, i) -> useParamThenReturnDouble(s, i); // the same as the above but with improved naming and functionalities
	 * }</pre>
	 * Another example would be the {@code DoubleBinaryOperator} interface:
	 * <pre>{@code
	 * java.util.function.DoubleBinaryOperator f = Math::pow; //The JDK's interface
	 * PrimitiveBiFunction.ToDouble.OfDouble.AndDouble g = Math::pow; // the same as the above but with improved naming and functionalities
	 * }</pre>
	 * </li>
	 * <li>cover all areas where primitive {@code double} would be needed when working with {@code BiFunction}s to prevent programmers from deferring to
	 * the boxed version ({@code java.lang.Double}) when the primitive {@code double} was actually the required type, to avoid the performance
	 * penalty of auto-boxing. For example:
	 * <pre>{@code
	 * PrimitiveBiFunction.ToDouble.OfDouble.AndInt f = Math::scalb;
	 * PrimitiveConsumer.OfDouble c = System.out::println;
	 * c.acceptDouble(f.apply(25.0, 5));
	 * }</pre>
	 * The above has no JDK equivalent that extends the {@code BiFunction} interface to provide for returning a {@code double} and taking a {@code double} and an {@code int}.
	 * Hence all primitives are covered in the subsequent nested sub-interfaces.
	 * </li>
	 * </ol>
	 * Note that this is not meant to replace the primitive {@code double} {@code BiFunction} implementations, however, this is meant to complement them
	 * by subclassing both {@code BiFunction} and it's primitive {@code double} counterpart, providing an harmony (a sort of bridge) between the 2 apis.
	 * @param <OF> the type of the first argument to {@link #apply}
	 * @param <AND> the type of the second argument to {@link #apply}
	 * @implNote It is recommended that {@link #applyDouble} be used instead of {@link #apply} as the former is a specialised version of the latter
	 * and is a first class implementation, but the latter is composed by calling the former and casting {@code java.lang.Double} to the primitive
	 * {@code double} as it's return type.
	 */
	@FunctionalInterface interface ToDouble<AND, OF> extends PrimitiveBiFunction<java.lang.Double, AND, OF/*, OfDouble<U, R>*/>, ToDoubleBiFunction<OF, AND> {
		/*
		 * Date created: 29 May 2024
		 * Time created: 15:14:33
		 */
		/**
		 * Applies this function to the given arguments, returning a {@code double} result.
		 * <p>
		 * This is a specialised version of {@link #apply} that returns a {@code double}. It is recommended that this method be
		 * used instead of {@link #apply} as this is the first class implementation of this interface.
		 * @param x the first argument
		 * @param y the second argument
		 * @return a {@code double} result of applying both arguments
		 */
		double applyDouble(OF x, AND y);
		
		/*
		 * Date created: 29 May 2024
		 * Time created: 15:18:53
		 */
		/**
		 * {@inheritDoc}
		 * @param x {@inheritDoc}
		 * @param y {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation boxes the result of calling {@link #applyDouble}, and returns that boxed result.
		 */
		@Override default java.lang.Double apply(OF x, AND y) {return applyDouble(x, y);}
		/*
		 * Date created: 29 May 2024
		 * Time created: 15:36:09
		 */
		/**
		 * {@inheritDoc}
		 * @param x {@inheritDoc}
		 * @param y {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Semantically the same as calling {@link #applyDouble()}
		 */
		@Override default double applyAsDouble(OF x, AND y) {return applyDouble(x, y);}

		/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
		default ToDouble<AND, OF> andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
		/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
		@Override default ToDouble<AND, OF> andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
		@Override default ToLong<AND, OF> andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x, y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
		@Override default ToInt<AND, OF> andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x, y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
		@Override default ToFloat<AND, OF> andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x, y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
		@Override default ToChar<AND, OF> andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x, y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
		@Override default ToShort<AND, OF> andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x, y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
		@Override default ToByte<AND, OF> andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x, y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
		@Override default ToBoolean<AND, OF> andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x, y));}
		
		/**
		 * A {@code BiFunction} that takes in a {@code double} value as it's second argument and returns a {@code double}.
		 * @param <OF> the type of the first argument to {@link #applyDouble}
		 */
		@FunctionalInterface interface AndDouble<OF> extends ToDouble<java.lang.Double, OF> {
			/*
			 * Date created: 29 May 2024
			 * Time created: 15:39:43
			 */
			/**
			 * Applies this function to the given {@code Object} and {@code double} arguments, returning a {@code double} result.
			 * <p>
			 * This is a specialised version of {@link #applyDouble(Object, java.lang.Double)}. It is recommended that this method be
			 * used instead of {@link #applyDouble(Object, java.lang.Double)} as this is the first class implementation of this interface.
			 * @param x the first argument
			 * @param y the second argument
			 * @return a {@code double} result of applying both arguments
			 */
			double applyDouble(OF x, double y);
			/*
			 * Date created: 29 May 2024
			 * Time created: 15:42:10
			 */
			/**
			 * Applies this function to the given arguments, returning a {@code double} result.
			 * @param x {@inheritDoc}
			 * @param y {@inheritDoc}
			 * @return {@inheritDoc}
			 * @implNote The default implementation calls {@link #applyDouble(Object, double)}, consequentially casting the second argument.
			 */
			@Override default double applyDouble(OF x, java.lang.Double y) {return applyDouble(x, (double) y);}

			/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
			@Override default ToDouble.AndDouble<OF> andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToDouble.AndDouble<OF> andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToLong.AndDouble<OF> andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x, y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToInt.AndDouble<OF> andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x, y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToFloat.AndDouble<OF> andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x, y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToChar.AndDouble<OF> andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x, y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToShort.AndDouble<OF> andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x, y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToByte.AndDouble<OF> andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x, y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToBoolean.AndDouble<OF> andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x, y));}
		}
		
		/**
		 * A {@code BiFunction} that takes in a {@code long} value as it's second argument and returns a {@code double}.
		 * @param <OF> the type of the first argument to {@link #applyDouble}
		 */@FunctionalInterface interface AndLong<OF> extends ToDouble<java.lang.Long, OF> {
			/*
			 * Date created: 29 May 2024
			 * Time created: 15:39:43
			 */
			/**
			 * Applies this function to the given {@code Object} and {@code long} arguments, returning a {@code double} result.
			 * <p>
			 * This is a specialised version of {@link #applyDouble(Object, java.lang.Long)}. It is recommended that this method be
			 * used instead of {@link #applyDouble(Object, java.lang.Long)} as this is the first class implementation of this interface.
			 * @param x the first argument
			 * @param y the second argument
			 * @return a {@code double} result of applying both arguments
			 */
			double applyDouble(OF x, long y);
			/*
			 * Date created: 29 May 2024
			 * Time created: 15:42:10
			 */
			/**
			 * Applies this function to the given arguments, returning a {@code double} result.
			 * @param x {@inheritDoc}
			 * @param y {@inheritDoc}
			 * @return {@inheritDoc}
			 * @implNote The default implementation calls {@link #applyDouble(Object, long)}, consequentially casting the second argument.
			 */
			@Override default double applyDouble(OF x, java.lang.Long y) {return applyDouble(x, (long) y);}

			/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
			@Override default ToDouble.AndLong<OF> andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToDouble.AndLong<OF> andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToLong.AndLong<OF> andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x, y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToInt.AndLong<OF> andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x, y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToFloat.AndLong<OF> andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x, y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToChar.AndLong<OF> andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x, y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToShort.AndLong<OF> andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x, y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToByte.AndLong<OF> andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x, y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToBoolean.AndLong<OF> andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x, y));}
		}
		
		/**
		 * A {@code BiFunction} that takes in an {@code int} value as it's second argument and returns a {@code double}.
		 * @param <OF> the type of the first argument to {@link #applyDouble}
		 */@FunctionalInterface interface AndInt<OF> extends ToDouble<java.lang.Integer, OF> {
			
			/**
			 * Applies this function to the given {@code Object} and {@code int} arguments, returning a {@code double} result.
			 * <p>
			 * This is a specialised version of {@link #applyDouble(Object, java.lang.Integer)}. It is recommended that this method be
			 * used instead of {@link #applyDouble(Object, java.lang.Integer)} as this is the first class implementation of this interface.
			 * @param x the first argument
			 * @param y the second argument
			 * @return a {@code double} result of applying both arguments
			 */double applyDouble(OF x, int y);
			 
			/*
			 * Date created: 29 May 2024
			 * Time created: 15:42:10
			 */
			/**
			 * Applies this function to the given arguments, returning a {@code double} result.
			 * @param x {@inheritDoc}
			 * @param y {@inheritDoc}
			 * @return {@inheritDoc}
			 * @implNote The default implementation calls {@link #applyDouble(Object, int)}, consequentially casting the second argument.
			 */
			@Override default double applyDouble(OF x, java.lang.Integer y) {return applyDouble(x, (int) y);}

			/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
			@Override default ToDouble.AndInt<OF> andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToDouble.AndInt<OF> andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToLong.AndInt<OF> andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x, y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToInt.AndInt<OF> andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x, y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToFloat.AndInt<OF> andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x, y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToChar.AndInt<OF> andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x, y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToShort.AndInt<OF> andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x, y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToByte.AndInt<OF> andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x, y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToBoolean.AndInt<OF> andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x, y));}
		}
		
		/**
		 * A {@code BiFunction} that takes in a {@code float} value as it's second argument and returns a {@code double}.
		 * @param <OF> the type of the first argument to {@link #applyDouble}
		 */@FunctionalInterface interface AndFloat<OF> extends ToDouble<java.lang.Float, OF> {
			
			/**
			 * Applies this function to the given {@code Object} and {@code float} arguments, returning a {@code double} result.
			 * <p>
			 * This is a specialised version of {@link #applyDouble(Object, java.lang.Float)}. It is recommended that this method be
			 * used instead of {@link #applyDouble(Object, java.lang.Float)} as this is the first class implementation of this interface.
			 * @param x the first argument
			 * @param y the second argument
			 * @return a {@code double} result of applying both arguments
			 */double applyDouble(OF x, float y);
			 
			/*
			 * Date created: 29 May 2024
			 * Time created: 15:42:10
			 */
			/**
			 * Applies this function to the given arguments, returning a {@code double} result.
			 * @param x {@inheritDoc}
			 * @param y {@inheritDoc}
			 * @return {@inheritDoc}
			 * @implNote The default implementation calls {@link #applyDouble(Object, float)}, consequentially casting the second argument.
			 */
			@Override default double applyDouble(OF x, java.lang.Float y) {return applyDouble(x, (float) y);}

			/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
			@Override default ToDouble.AndFloat<OF> andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToDouble.AndFloat<OF> andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToLong.AndFloat<OF> andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x, y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToInt.AndFloat<OF> andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x, y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToFloat.AndFloat<OF> andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x, y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToChar.AndFloat<OF> andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x, y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToShort.AndFloat<OF> andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x, y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToByte.AndFloat<OF> andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x, y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToBoolean.AndFloat<OF> andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x, y));}
		}
		
		/**
		 * A {@code BiFunction} that takes in a {@code char} value as it's second argument and returns a {@code double}.
		 * @param <OF> the type of the first argument to {@link #applyDouble}
		 */@FunctionalInterface interface AndChar<OF> extends ToDouble<java.lang.Character, OF> {
			
			/**
			 * Applies this function to the given {@code Object} and {@code char} arguments, returning a {@code double} result.
			 * <p>
			 * This is a specialised version of {@link #applyDouble(Object, java.lang.Character)}. It is recommended that this method be
			 * used instead of {@link #applyDouble(Object, java.lang.Character)} as this is the first class implementation of this interface.
			 * @param x the first argument
			 * @param y the second argument
			 * @return a {@code double} result of applying both arguments
			 */double applyDouble(OF x, char y);
			 
			/*
			 * Date created: 29 May 2024
			 * Time created: 15:42:10
			 */
			/**
			 * Applies this function to the given arguments, returning a {@code double} result.
			 * @param x {@inheritDoc}
			 * @param y {@inheritDoc}
			 * @return {@inheritDoc}
			 * @implNote The default implementation calls {@link #applyDouble(Object, char)}, consequentially casting the second argument.
			 */
			@Override default double applyDouble(OF x, java.lang.Character y) {return applyDouble(x, (char) y);}

			/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
			@Override default ToDouble.AndChar<OF> andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToDouble.AndChar<OF> andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToLong.AndChar<OF> andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x, y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToInt.AndChar<OF> andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x, y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToFloat.AndChar<OF> andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x, y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToChar.AndChar<OF> andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x, y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToShort.AndChar<OF> andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x, y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToByte.AndChar<OF> andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x, y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToBoolean.AndChar<OF> andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x, y));}
		}
		
		/**
		 * A {@code BiFunction} that takes in a {@code short} value as it's second argument and returns a {@code double}.
		 * @param <OF> the type of the first argument to {@link #applyDouble}
		 */@FunctionalInterface interface AndShort<OF> extends ToDouble<java.lang.Short, OF> {
			
			/**
			 * Applies this function to the given {@code Object} and {@code short} arguments, returning a {@code double} result.
			 * <p>
			 * This is a specialised version of {@link #applyDouble(Object, java.lang.Short)}. It is recommended that this method be
			 * used instead of {@link #applyDouble(Object, java.lang.Short)} as this is the first class implementation of this interface.
			 * @param x the first argument
			 * @param y the second argument
			 * @return a {@code double} result of applying both arguments
			 */double applyDouble(OF x, short y);
			 
			/*
			 * Date created: 29 May 2024
			 * Time created: 15:42:10
			 */
			/**
			 * Applies this function to the given arguments, returning a {@code double} result.
			 * @param x {@inheritDoc}
			 * @param y {@inheritDoc}
			 * @return {@inheritDoc}
			 * @implNote The default implementation calls {@link #applyDouble(Object, short)}, consequentially casting the second argument.
			 */
			@Override default double applyDouble(OF x, java.lang.Short y) {return applyDouble(x, (short) y);}

			/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
			@Override default ToDouble.AndShort<OF> andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToDouble.AndShort<OF> andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToLong.AndShort<OF> andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x, y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToInt.AndShort<OF> andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x, y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToFloat.AndShort<OF> andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x, y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToChar.AndShort<OF> andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x, y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToShort.AndShort<OF> andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x, y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToByte.AndShort<OF> andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x, y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToBoolean.AndShort<OF> andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x, y));}
		}
		
		/**
		 * A {@code BiFunction} that takes in a {@code byte} value as it's second argument and returns a {@code double}.
		 * @param <OF> the type of the first argument to {@link #applyDouble}
		 */@FunctionalInterface interface AndByte<OF> extends ToDouble<java.lang.Byte, OF> {
			
			/**
			 * Applies this function to the given {@code Object} and {@code long} arguments, returning a {@code double} result.
			 * <p>
			 * This is a specialised version of {@link #applyDouble(Object, java.lang.Byte)}. It is recommended that this method be
			 * used instead of {@link #applyDouble(Object, java.lang.Byte)} as this is the first class implementation of this interface.
			 * @param x the first argument
			 * @param y the second argument
			 * @return a {@code double} result of applying both arguments
			 */double applyDouble(OF x, byte y);
			 
			/*
			 * Date created: 29 May 2024
			 * Time created: 15:42:10
			 */
			/**
			 * Applies this function to the given arguments, returning a {@code double} result.
			 * @param x {@inheritDoc}
			 * @param y {@inheritDoc}
			 * @return {@inheritDoc}
			 * @implNote The default implementation calls {@link #applyDouble(Object, byte)}, consequentially casting the second argument.
			 */
			@Override default double applyDouble(OF x, java.lang.Byte y) {return applyDouble(x, (byte) y);}

			/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
			@Override default ToDouble.AndByte<OF> andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToDouble.AndByte<OF> andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToLong.AndByte<OF> andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x, y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToInt.AndByte<OF> andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x, y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToFloat.AndByte<OF> andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x, y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToChar.AndByte<OF> andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x, y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToShort.AndByte<OF> andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x, y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToByte.AndByte<OF> andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x, y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToBoolean.AndByte<OF> andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x, y));}
		}
		
		/**
		 * A {@code BiFunction} that takes in a {@code boolean} value as it's second argument and returns a {@code double}.
		 * @param <OF> the type of the first argument to {@link #applyDouble}
		 */@FunctionalInterface interface AndBoolean<OF> extends ToDouble<java.lang.Boolean, OF> {
			
			/**
			 * Applies this function to the given {@code Object} and {@code boolean} arguments, returning a {@code double} result.
			 * <p>
			 * This is a specialised version of {@link #applyDouble(Object, java.lang.Boolean)}. It is recommended that this method be
			 * used instead of {@link #applyDouble(Object, java.lang.Boolean)} as this is the first class implementation of this interface.
			 * @param x the first argument
			 * @param y the second argument
			 * @return a {@code double} result of applying both arguments
			 */double applyDouble(OF x, boolean y);
			 
			/*
			 * Date created: 29 May 2024
			 * Time created: 15:42:10
			 */
			/**
			 * Applies this function to the given arguments, returning a {@code double} result.
			 * @param x {@inheritDoc}
			 * @param y {@inheritDoc}
			 * @return {@inheritDoc}
			 * @implNote The default implementation calls {@link #applyDouble(Object, boolean)}, consequentially casting the second argument.
			 */
			@Override default double applyDouble(OF x, java.lang.Boolean y) {return applyDouble(x, (boolean) y);}

			/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
			@Override default ToDouble.AndBoolean<OF> andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToDouble.AndBoolean<OF> andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToLong.AndBoolean<OF> andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x, y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToInt.AndBoolean<OF> andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x, y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToFloat.AndBoolean<OF> andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x, y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToChar.AndBoolean<OF> andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x, y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToShort.AndBoolean<OF> andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x, y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToByte.AndBoolean<OF> andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x, y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToBoolean.AndBoolean<OF> andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x, y));}
		}

		@FunctionalInterface interface OfDouble<AND> extends ToDouble<AND, java.lang.Double>{
			double applyDouble(double x, AND y);
			@Override default double applyDouble(java.lang.Double x, AND y) {return applyDouble((double) x, y);}

			/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
			@Override default ToDouble.OfDouble<AND> andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToDouble.OfDouble<AND> andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToLong.OfDouble<AND> andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToInt.OfDouble<AND> andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToFloat.OfDouble<AND> andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToChar.OfDouble<AND> andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToShort.OfDouble<AND> andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToByte.OfDouble<AND> andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToBoolean.OfDouble<AND> andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			@FunctionalInterface interface AndDouble extends OfDouble<java.lang.Double>, BinaryOperator<java.lang.Double>, DoubleBinaryOperator {
				double applyDouble(double x, double y);
				@Override default double applyDouble(double x, java.lang.Double y) {return applyDouble(x, (double) y);}
				@Override default double applyAsDouble(double x, double y) {return applyDouble(x, (double) y);}

				/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
				@Override default ToDouble.OfDouble.AndDouble andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToDouble.OfDouble.AndDouble andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToLong.OfDouble.AndDouble andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToInt.OfDouble.AndDouble andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToFloat.OfDouble.AndDouble andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToChar.OfDouble.AndDouble andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToShort.OfDouble.AndDouble andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToByte.OfDouble.AndDouble andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToBoolean.OfDouble.AndDouble andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			}
			@FunctionalInterface interface AndLong extends OfDouble<java.lang.Long> {
				double applyDouble(double x, long y);
				@Override default double applyDouble(double x, java.lang.Long y) {return applyDouble(x, (long) y);}

				/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
				@Override default ToDouble.OfDouble.AndLong andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToDouble.OfDouble.AndLong andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToLong.OfDouble.AndLong andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToInt.OfDouble.AndLong andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToFloat.OfDouble.AndLong andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToChar.OfDouble.AndLong andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToShort.OfDouble.AndLong andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToByte.OfDouble.AndLong andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToBoolean.OfDouble.AndLong andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			}
			@FunctionalInterface interface AndInt extends OfDouble<java.lang.Integer> {
				double applyDouble(double x, int y);
				@Override default double applyDouble(double x, java.lang.Integer y) {return applyDouble(x, (int) y);}

				/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
				@Override default ToDouble.OfDouble.AndInt andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToDouble.OfDouble.AndInt andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToLong.OfDouble.AndInt andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToInt.OfDouble.AndInt andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToFloat.OfDouble.AndInt andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToChar.OfDouble.AndInt andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToShort.OfDouble.AndInt andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToByte.OfDouble.AndInt andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToBoolean.OfDouble.AndInt andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			}
			@FunctionalInterface interface AndFloat extends OfDouble<java.lang.Float> {
				double applyDouble(double x, float y);
				@Override default double applyDouble(double x, java.lang.Float y) {return applyDouble(x, (float) y);}

				/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
				@Override default ToDouble.OfDouble.AndFloat andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToDouble.OfDouble.AndFloat andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToLong.OfDouble.AndFloat andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToInt.OfDouble.AndFloat andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToFloat.OfDouble.AndFloat andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToChar.OfDouble.AndFloat andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToShort.OfDouble.AndFloat andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToByte.OfDouble.AndFloat andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToBoolean.OfDouble.AndFloat andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			}
			@FunctionalInterface interface AndChar extends OfDouble<java.lang.Character> {
				double applyDouble(double x, char y);
				@Override default double applyDouble(double x, java.lang.Character y) {return applyDouble(x, (char) y);}

				/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
				@Override default ToDouble.OfDouble.AndChar andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToDouble.OfDouble.AndChar andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToLong.OfDouble.AndChar andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToInt.OfDouble.AndChar andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToFloat.OfDouble.AndChar andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToChar.OfDouble.AndChar andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToShort.OfDouble.AndChar andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToByte.OfDouble.AndChar andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToBoolean.OfDouble.AndChar andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			}
			@FunctionalInterface interface AndShort extends OfDouble<java.lang.Short> {
				double applyDouble(double x, short y);
				@Override default double applyDouble(double x, java.lang.Short y) {return applyDouble(x, (short) y);}

				/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
				@Override default ToDouble.OfDouble.AndShort andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToDouble.OfDouble.AndShort andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToLong.OfDouble.AndShort andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToInt.OfDouble.AndShort andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToFloat.OfDouble.AndShort andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToChar.OfDouble.AndShort andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToShort.OfDouble.AndShort andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToByte.OfDouble.AndShort andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToBoolean.OfDouble.AndShort andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			}
			@FunctionalInterface interface AndByte extends OfDouble<java.lang.Byte> {
				double applyDouble(double x, byte y);
				@Override default double applyDouble(double x, java.lang.Byte y) {return applyDouble(x, (byte) y);}

				/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
				@Override default ToDouble.OfDouble.AndByte andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToDouble.OfDouble.AndByte andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToLong.OfDouble.AndByte andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToInt.OfDouble.AndByte andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToFloat.OfDouble.AndByte andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToChar.OfDouble.AndByte andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToShort.OfDouble.AndByte andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToByte.OfDouble.AndByte andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToBoolean.OfDouble.AndByte andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,(byte)y));}
			}
			@FunctionalInterface interface AndBoolean extends OfDouble<java.lang.Boolean> {
				double applyDouble(double x, boolean y);
				@Override default double applyDouble(double x, java.lang.Boolean y) {return applyDouble(x, (boolean) y);}

				/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
				@Override default ToDouble.OfDouble.AndBoolean andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToDouble.OfDouble.AndBoolean andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToLong.OfDouble.AndBoolean andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToInt.OfDouble.AndBoolean andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToFloat.OfDouble.AndBoolean andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToChar.OfDouble.AndBoolean andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble((double)(int) x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToShort.OfDouble.AndBoolean andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToByte.OfDouble.AndBoolean andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToBoolean.OfDouble.AndBoolean andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			}
		}
		@FunctionalInterface interface OfLong<AND> extends ToDouble<AND, java.lang.Long>{
			double applyDouble(long x, AND y);
			@Override default double applyDouble(java.lang.Long x, AND y) {return applyDouble((long) x, y);}

			/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
			@Override default ToDouble.OfLong<AND> andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToDouble.OfLong<AND> andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToLong.OfLong<AND> andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToInt.OfLong<AND> andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToFloat.OfLong<AND> andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToChar.OfLong<AND> andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToShort.OfLong<AND> andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToByte.OfLong<AND> andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToBoolean.OfLong<AND> andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			@FunctionalInterface interface AndDouble extends OfLong<java.lang.Double> {
				double applyDouble(long x, double y);
				@Override default double applyDouble(long x, java.lang.Double y) {return applyDouble(x, (double) y);}

				/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
				@Override default ToDouble.OfLong.AndDouble andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToDouble.OfLong.AndDouble andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToLong.OfLong.AndDouble andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToInt.OfLong.AndDouble andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToFloat.OfLong.AndDouble andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToChar.OfLong.AndDouble andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToShort.OfLong.AndDouble andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToByte.OfLong.AndDouble andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToBoolean.OfLong.AndDouble andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			}
			@FunctionalInterface interface AndLong extends OfLong<java.lang.Long> {
				double applyDouble(long x, long y);
				@Override default double applyDouble(long x, java.lang.Long y) {return applyDouble(x, (long) y);}

				/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
				@Override default ToDouble.OfLong.AndLong andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToDouble.OfLong.AndLong andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToLong.OfLong.AndLong andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToInt.OfLong.AndLong andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToFloat.OfLong.AndLong andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToChar.OfLong.AndLong andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToShort.OfLong.AndLong andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToByte.OfLong.AndLong andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToBoolean.OfLong.AndLong andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			}
			@FunctionalInterface interface AndInt extends OfLong<java.lang.Integer> {
				double applyDouble(long x, int y);
				@Override default double applyDouble(long x, java.lang.Integer y) {return applyDouble(x, (int) y);}

				/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
				@Override default ToDouble.OfLong.AndInt andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToDouble.OfLong.AndInt andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToLong.OfLong.AndInt andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToInt.OfLong.AndInt andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToFloat.OfLong.AndInt andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToChar.OfLong.AndInt andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToShort.OfLong.AndInt andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToByte.OfLong.AndInt andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToBoolean.OfLong.AndInt andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			}
			@FunctionalInterface interface AndFloat extends OfLong<java.lang.Float> {
				double applyDouble(long x, float y);
				@Override default double applyDouble(long x, java.lang.Float y) {return applyDouble(x, (float) y);}

				/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
				@Override default ToDouble.OfLong.AndFloat andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToDouble.OfLong.AndFloat andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToLong.OfLong.AndFloat andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToInt.OfLong.AndFloat andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToFloat.OfLong.AndFloat andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToChar.OfLong.AndFloat andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToShort.OfLong.AndFloat andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToByte.OfLong.AndFloat andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToBoolean.OfLong.AndFloat andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			}
			@FunctionalInterface interface AndChar extends OfLong<java.lang.Character> {
				double applyDouble(long x, char y);
				@Override default double applyDouble(long x, java.lang.Character y) {return applyDouble(x, (char) y);}

				/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
				@Override default ToDouble.OfLong.AndChar andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToDouble.OfLong.AndChar andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToLong.OfLong.AndChar andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToInt.OfLong.AndChar andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToFloat.OfLong.AndChar andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToChar.OfLong.AndChar andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToShort.OfLong.AndChar andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToByte.OfLong.AndChar andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToBoolean.OfLong.AndChar andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			}
			@FunctionalInterface interface AndShort extends OfLong<java.lang.Short> {
				double applyDouble(long x, short y);
				@Override default double applyDouble(long x, java.lang.Short y) {return applyDouble(x, (short) y);}

				/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
				@Override default ToDouble.OfLong.AndShort andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToDouble.OfLong.AndShort andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToLong.OfLong.AndShort andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToInt.OfLong.AndShort andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToFloat.OfLong.AndShort andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToChar.OfLong.AndShort andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToShort.OfLong.AndShort andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToByte.OfLong.AndShort andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToBoolean.OfLong.AndShort andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			}
			@FunctionalInterface interface AndByte extends OfLong<java.lang.Byte> {
				double applyDouble(long x, byte y);
				@Override default double applyDouble(long x, java.lang.Byte y) {return applyDouble(x, (byte) y);}

				/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
				@Override default ToDouble.OfLong.AndByte andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToDouble.OfLong.AndByte andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToLong.OfLong.AndByte andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToInt.OfLong.AndByte andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToFloat.OfLong.AndByte andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToChar.OfLong.AndByte andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToShort.OfLong.AndByte andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToByte.OfLong.AndByte andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToBoolean.OfLong.AndByte andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			}
			@FunctionalInterface interface AndBoolean extends OfLong<java.lang.Boolean> {
				double applyDouble(long x, boolean y);
				@Override default double applyDouble(long x, java.lang.Boolean y) {return applyDouble(x, (boolean) y);}

				/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
				@Override default ToDouble.OfLong.AndBoolean andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToDouble.OfLong.AndBoolean andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToLong.OfLong.AndBoolean andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToInt.OfLong.AndBoolean andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToFloat.OfLong.AndBoolean andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToChar.OfLong.AndBoolean andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToShort.OfLong.AndBoolean andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToByte.OfLong.AndBoolean andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToBoolean.OfLong.AndBoolean andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			}
		}
		@FunctionalInterface interface OfInt<AND> extends ToDouble<AND, java.lang.Integer>{
			double applyDouble(int x, AND y);
			@Override default double applyDouble(java.lang.Integer x, AND y) {return applyDouble((int) x, y);}

			/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
			@Override default ToDouble.OfInt<AND> andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToDouble.OfInt<AND> andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToLong.OfInt<AND> andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToInt.OfInt<AND> andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToFloat.OfInt<AND> andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToChar.OfInt<AND> andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToShort.OfInt<AND> andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToByte.OfInt<AND> andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToBoolean.OfInt<AND> andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			@FunctionalInterface interface AndDouble extends OfInt<java.lang.Double> {
				double applyDouble(int x, double y);
				@Override default double applyDouble(int x, java.lang.Double y) {return applyDouble(x, (double) y);}

				/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
				@Override default ToDouble.OfInt.AndDouble andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToDouble.OfInt.AndDouble andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToLong.OfInt.AndDouble andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToInt.OfInt.AndDouble andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToFloat.OfInt.AndDouble andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToChar.OfInt.AndDouble andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToShort.OfInt.AndDouble andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToByte.OfInt.AndDouble andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToBoolean.OfInt.AndDouble andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			}
			@FunctionalInterface interface AndLong extends OfInt<java.lang.Long> {
				double applyDouble(int x, long y);
				@Override default double applyDouble(int x, java.lang.Long y) {return applyDouble(x, (long) y);}

				/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
				@Override default ToDouble.OfInt.AndLong andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToDouble.OfInt.AndLong andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToLong.OfInt.AndLong andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToInt.OfInt.AndLong andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToFloat.OfInt.AndLong andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToChar.OfInt.AndLong andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToShort.OfInt.AndLong andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToByte.OfInt.AndLong andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToBoolean.OfInt.AndLong andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			}
			@FunctionalInterface interface AndInt extends OfInt<java.lang.Integer> {
				double applyDouble(int x, int y);
				@Override default double applyDouble(int x, java.lang.Integer y) {return applyDouble(x, (int) y);}

				/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
				@Override default ToDouble.OfInt.AndInt andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToDouble.OfInt.AndInt andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToLong.OfInt.AndInt andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToInt.OfInt.AndInt andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToFloat.OfInt.AndInt andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToChar.OfInt.AndInt andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToShort.OfInt.AndInt andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToByte.OfInt.AndInt andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToBoolean.OfInt.AndInt andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			}
			@FunctionalInterface interface AndFloat extends OfInt<java.lang.Float> {
				double applyDouble(int x, float y);
				@Override default double applyDouble(int x, java.lang.Float y) {return applyDouble(x, (float) y);}

				/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
				@Override default ToDouble.OfInt.AndFloat andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToDouble.OfInt.AndFloat andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToLong.OfInt.AndFloat andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToInt.OfInt.AndFloat andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToFloat.OfInt.AndFloat andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToChar.OfInt.AndFloat andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToShort.OfInt.AndFloat andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToByte.OfInt.AndFloat andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToBoolean.OfInt.AndFloat andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			}
			@FunctionalInterface interface AndChar extends OfInt<java.lang.Character> {
				double applyDouble(int x, char y);
				@Override default double applyDouble(int x, java.lang.Character y) {return applyDouble(x, (char) y);}

				/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
				@Override default ToDouble.OfInt.AndChar andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToDouble.OfInt.AndChar andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToLong.OfInt.AndChar andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToInt.OfInt.AndChar andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToFloat.OfInt.AndChar andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToChar.OfInt.AndChar andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToShort.OfInt.AndChar andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToByte.OfInt.AndChar andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToBoolean.OfInt.AndChar andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			}
			@FunctionalInterface interface AndShort extends OfInt<java.lang.Short> {
				double applyDouble(int x, short y);
				@Override default double applyDouble(int x, java.lang.Short y) {return applyDouble(x, (short) y);}

				/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
				@Override default ToDouble.OfInt.AndShort andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToDouble.OfInt.AndShort andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToLong.OfInt.AndShort andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToInt.OfInt.AndShort andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToFloat.OfInt.AndShort andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToChar.OfInt.AndShort andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToShort.OfInt.AndShort andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToByte.OfInt.AndShort andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToBoolean.OfInt.AndShort andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			}
			@FunctionalInterface interface AndByte extends OfInt<java.lang.Byte> {
				double applyDouble(int x, byte y);
				@Override default double applyDouble(int x, java.lang.Byte y) {return applyDouble(x, (byte) y);}

				/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
				@Override default ToDouble.OfInt.AndByte andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToDouble.OfInt.AndByte andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToLong.OfInt.AndByte andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToInt.OfInt.AndByte andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToFloat.OfInt.AndByte andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToChar.OfInt.AndByte andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToShort.OfInt.AndByte andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToByte.OfInt.AndByte andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToBoolean.OfInt.AndByte andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			}
			@FunctionalInterface interface AndBoolean extends OfInt<java.lang.Boolean> {
				double applyDouble(int x, boolean y);
				@Override default double applyDouble(int x, java.lang.Boolean y) {return applyDouble(x, (boolean) y);}

				/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
				@Override default ToDouble.OfInt.AndBoolean andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToDouble.OfInt.AndBoolean andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToLong.OfInt.AndBoolean andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToInt.OfInt.AndBoolean andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToFloat.OfInt.AndBoolean andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToChar.OfInt.AndBoolean andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToShort.OfInt.AndBoolean andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToByte.OfInt.AndBoolean andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToBoolean.OfInt.AndBoolean andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			}
		}
		@FunctionalInterface interface OfFloat<AND> extends ToDouble<AND, java.lang.Float>{
			double applyDouble(float x, AND y);
			@Override default double applyDouble(java.lang.Float x, AND y) {return applyDouble((float) x, y);}

			/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
			@Override default ToDouble.OfFloat<AND> andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToDouble.OfFloat<AND> andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToLong.OfFloat<AND> andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToInt.OfFloat<AND> andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToFloat.OfFloat<AND> andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToChar.OfFloat<AND> andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToShort.OfFloat<AND> andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToByte.OfFloat<AND> andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToBoolean.OfFloat<AND> andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			@FunctionalInterface interface AndDouble extends OfFloat<java.lang.Double> {
				double applyDouble(float x, double y);
				@Override default double applyDouble(float x, java.lang.Double y) {return applyDouble(x, (double) y);}

				/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
				@Override default ToDouble.OfFloat.AndDouble andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToDouble.OfFloat.AndDouble andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToLong.OfFloat.AndDouble andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToInt.OfFloat.AndDouble andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToFloat.OfFloat.AndDouble andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToChar.OfFloat.AndDouble andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToShort.OfFloat.AndDouble andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToByte.OfFloat.AndDouble andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToBoolean.OfFloat.AndDouble andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			}
			@FunctionalInterface interface AndLong extends OfFloat<java.lang.Long> {
				double applyDouble(float x, long y);
				@Override default double applyDouble(float x, java.lang.Long y) {return applyDouble(x, (long) y);}

				/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
				@Override default ToDouble.OfFloat.AndLong andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToDouble.OfFloat.AndLong andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToLong.OfFloat.AndLong andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToInt.OfFloat.AndLong andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToFloat.OfFloat.AndLong andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToChar.OfFloat.AndLong andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToShort.OfFloat.AndLong andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToByte.OfFloat.AndLong andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToBoolean.OfFloat.AndLong andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			}
			@FunctionalInterface interface AndInt extends OfFloat<java.lang.Integer> {
				double applyDouble(float x, int y);
				@Override default double applyDouble(float x, java.lang.Integer y) {return applyDouble(x, (int) y);}

				/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
				@Override default ToDouble.OfFloat.AndInt andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToDouble.OfFloat.AndInt andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToLong.OfFloat.AndInt andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToInt.OfFloat.AndInt andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToFloat.OfFloat.AndInt andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToChar.OfFloat.AndInt andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToShort.OfFloat.AndInt andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToByte.OfFloat.AndInt andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToBoolean.OfFloat.AndInt andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			}
			@FunctionalInterface interface AndFloat extends OfFloat<java.lang.Float> {
				double applyDouble(float x, float y);
				@Override default double applyDouble(float x, java.lang.Float y) {return applyDouble(x, (float) y);}

				/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
				@Override default ToDouble.OfFloat.AndFloat andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToDouble.OfFloat.AndFloat andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToLong.OfFloat.AndFloat andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToInt.OfFloat.AndFloat andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToFloat.OfFloat.AndFloat andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToChar.OfFloat.AndFloat andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToShort.OfFloat.AndFloat andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToByte.OfFloat.AndFloat andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToBoolean.OfFloat.AndFloat andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			}
			@FunctionalInterface interface AndChar extends OfFloat<java.lang.Character> {
				double applyDouble(float x, char y);
				@Override default double applyDouble(float x, java.lang.Character y) {return applyDouble(x, (char) y);}

				/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
				@Override default ToDouble.OfFloat.AndChar andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToDouble.OfFloat.AndChar andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToLong.OfFloat.AndChar andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToInt.OfFloat.AndChar andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToFloat.OfFloat.AndChar andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToChar.OfFloat.AndChar andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToShort.OfFloat.AndChar andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToByte.OfFloat.AndChar andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToBoolean.OfFloat.AndChar andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			}
			@FunctionalInterface interface AndShort extends OfFloat<java.lang.Short> {
				double applyDouble(float x, short y);
				@Override default double applyDouble(float x, java.lang.Short y) {return applyDouble(x, (short) y);}

				/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
				@Override default ToDouble.OfFloat.AndShort andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToDouble.OfFloat.AndShort andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToLong.OfFloat.AndShort andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToInt.OfFloat.AndShort andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToFloat.OfFloat.AndShort andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToChar.OfFloat.AndShort andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToShort.OfFloat.AndShort andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToByte.OfFloat.AndShort andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToBoolean.OfFloat.AndShort andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			}
			@FunctionalInterface interface AndByte extends OfFloat<java.lang.Byte> {
				double applyDouble(float x, byte y);
				@Override default double applyDouble(float x, java.lang.Byte y) {return applyDouble(x, (byte) y);}

				/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
				@Override default ToDouble.OfFloat.AndByte andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToDouble.OfFloat.AndByte andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToLong.OfFloat.AndByte andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToInt.OfFloat.AndByte andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToFloat.OfFloat.AndByte andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToChar.OfFloat.AndByte andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToShort.OfFloat.AndByte andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToByte.OfFloat.AndByte andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToBoolean.OfFloat.AndByte andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			}
			@FunctionalInterface interface AndBoolean extends OfFloat<java.lang.Boolean> {
				double applyDouble(float x, boolean y);
				@Override default double applyDouble(float x, java.lang.Boolean y) {return applyDouble(x, (boolean) y);}

				/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
				@Override default ToDouble.OfFloat.AndBoolean andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToDouble.OfFloat.AndBoolean andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToLong.OfFloat.AndBoolean andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToInt.OfFloat.AndBoolean andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToFloat.OfFloat.AndBoolean andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToChar.OfFloat.AndBoolean andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToShort.OfFloat.AndBoolean andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToByte.OfFloat.AndBoolean andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToBoolean.OfFloat.AndBoolean andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			}
		}
		@FunctionalInterface interface OfShort<AND> extends ToDouble<AND, java.lang.Short>{
			double applyDouble(short x, AND y);
			@Override default double applyDouble(java.lang.Short x, AND y) {return applyDouble((short) x, y);}

			/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
			@Override default ToDouble.OfShort<AND> andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToDouble.OfShort<AND> andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToLong.OfShort<AND> andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToInt.OfShort<AND> andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToFloat.OfShort<AND> andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToChar.OfShort<AND> andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToShort.OfShort<AND> andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToByte.OfShort<AND> andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToBoolean.OfShort<AND> andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			@FunctionalInterface interface AndDouble extends OfShort<java.lang.Double> {
				double applyDouble(short x, double y);
				@Override default double applyDouble(short x, java.lang.Double y) {return applyDouble(x, (double) y);}

				/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
				@Override default ToDouble.OfShort.AndDouble andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToDouble.OfShort.AndDouble andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToLong.OfShort.AndDouble andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToInt.OfShort.AndDouble andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToFloat.OfShort.AndDouble andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToChar.OfShort.AndDouble andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToShort.OfShort.AndDouble andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToByte.OfShort.AndDouble andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToBoolean.OfShort.AndDouble andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			}
			@FunctionalInterface interface AndLong extends OfShort<java.lang.Long> {
				double applyDouble(short x, long y);
				@Override default double applyDouble(short x, java.lang.Long y) {return applyDouble(x, (long) y);}

				/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
				@Override default ToDouble.OfShort.AndLong andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToDouble.OfShort.AndLong andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToLong.OfShort.AndLong andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToInt.OfShort.AndLong andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToFloat.OfShort.AndLong andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToChar.OfShort.AndLong andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToShort.OfShort.AndLong andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToByte.OfShort.AndLong andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToBoolean.OfShort.AndLong andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			}
			@FunctionalInterface interface AndInt extends OfShort<java.lang.Integer> {
				double applyDouble(short x, int y);
				@Override default double applyDouble(short x, java.lang.Integer y) {return applyDouble(x, (int) y);}

				/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
				@Override default ToDouble.OfShort.AndInt andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToDouble.OfShort.AndInt andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToLong.OfShort.AndInt andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToInt.OfShort.AndInt andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToFloat.OfShort.AndInt andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToChar.OfShort.AndInt andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToShort.OfShort.AndInt andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToByte.OfShort.AndInt andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToBoolean.OfShort.AndInt andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			}
			@FunctionalInterface interface AndFloat extends OfShort<java.lang.Float> {
				double applyDouble(short x, float y);
				@Override default double applyDouble(short x, java.lang.Float y) {return applyDouble(x, (float) y);}

				/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
				@Override default ToDouble.OfShort.AndFloat andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToDouble.OfShort.AndFloat andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToLong.OfShort.AndFloat andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToInt.OfShort.AndFloat andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToFloat.OfShort.AndFloat andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToChar.OfShort.AndFloat andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToShort.OfShort.AndFloat andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToByte.OfShort.AndFloat andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToBoolean.OfShort.AndFloat andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			}
			@FunctionalInterface interface AndChar extends OfShort<java.lang.Character> {
				double applyDouble(short x, char y);
				@Override default double applyDouble(short x, java.lang.Character y) {return applyDouble(x, (char) y);}

				/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
				@Override default ToDouble.OfShort.AndChar andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToDouble.OfShort.AndChar andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToLong.OfShort.AndChar andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToInt.OfShort.AndChar andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToFloat.OfShort.AndChar andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToChar.OfShort.AndChar andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToShort.OfShort.AndChar andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToByte.OfShort.AndChar andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToBoolean.OfShort.AndChar andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			}
			@FunctionalInterface interface AndShort extends OfShort<java.lang.Short> {
				double applyDouble(short x, short y);
				@Override default double applyDouble(short x, java.lang.Short y) {return applyDouble(x, (short) y);}

				/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
				@Override default ToDouble.OfShort.AndShort andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToDouble.OfShort.AndShort andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToLong.OfShort.AndShort andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToInt.OfShort.AndShort andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToFloat.OfShort.AndShort andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToChar.OfShort.AndShort andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToShort.OfShort.AndShort andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToByte.OfShort.AndShort andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToBoolean.OfShort.AndShort andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			}
			@FunctionalInterface interface AndByte extends OfShort<java.lang.Byte> {
				double applyDouble(short x, byte y);
				@Override default double applyDouble(short x, java.lang.Byte y) {return applyDouble(x, (byte) y);}

				/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
				@Override default ToDouble.OfShort.AndByte andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToDouble.OfShort.AndByte andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToLong.OfShort.AndByte andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToInt.OfShort.AndByte andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToFloat.OfShort.AndByte andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToChar.OfShort.AndByte andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToShort.OfShort.AndByte andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToByte.OfShort.AndByte andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToBoolean.OfShort.AndByte andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			}
			@FunctionalInterface interface AndBoolean extends OfShort<java.lang.Boolean> {
				double applyDouble(short x, boolean y);
				@Override default double applyDouble(short x, java.lang.Boolean y) {return applyDouble(x, (boolean) y);}

				/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
				@Override default ToDouble.OfShort.AndBoolean andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToDouble.OfShort.AndBoolean andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToLong.OfShort.AndBoolean andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToInt.OfShort.AndBoolean andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToFloat.OfShort.AndBoolean andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToChar.OfShort.AndBoolean andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToShort.OfShort.AndBoolean andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToByte.OfShort.AndBoolean andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToBoolean.OfShort.AndBoolean andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			}
		}
		@FunctionalInterface interface OfByte<AND> extends ToDouble<AND, java.lang.Byte>{
			double applyDouble(byte x, AND y);
			@Override default double applyDouble(java.lang.Byte x, AND y) {return applyDouble((byte) x, y);}

			/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
			@Override default ToDouble.OfByte<AND> andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToDouble.OfByte<AND> andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToLong.OfByte<AND> andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToInt.OfByte<AND> andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToFloat.OfByte<AND> andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToChar.OfByte<AND> andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToShort.OfByte<AND> andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToByte.OfByte<AND> andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToBoolean.OfByte<AND> andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			@FunctionalInterface interface AndDouble extends OfByte<java.lang.Double> {
				double applyDouble(byte x, double y);
				@Override default double applyDouble(byte x, java.lang.Double y) {return applyDouble(x, (double) y);}

				/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
				@Override default ToDouble.OfByte.AndDouble andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToDouble.OfByte.AndDouble andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToLong.OfByte.AndDouble andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToInt.OfByte.AndDouble andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToFloat.OfByte.AndDouble andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToChar.OfByte.AndDouble andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToShort.OfByte.AndDouble andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToByte.OfByte.AndDouble andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToBoolean.OfByte.AndDouble andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			}
			@FunctionalInterface interface AndLong extends OfByte<java.lang.Long> {
				double applyDouble(byte x, long y);
				@Override default double applyDouble(byte x, java.lang.Long y) {return applyDouble(x, (long) y);}

				/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
				@Override default ToDouble.OfByte.AndLong andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToDouble.OfByte.AndLong andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToLong.OfByte.AndLong andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToInt.OfByte.AndLong andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToFloat.OfByte.AndLong andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToChar.OfByte.AndLong andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToShort.OfByte.AndLong andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToByte.OfByte.AndLong andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToBoolean.OfByte.AndLong andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			}
			@FunctionalInterface interface AndInt extends OfByte<java.lang.Integer> {
				double applyDouble(byte x, int y);
				@Override default double applyDouble(byte x, java.lang.Integer y) {return applyDouble(x, (int) y);}

				/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
				@Override default ToDouble.OfByte.AndInt andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToDouble.OfByte.AndInt andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToLong.OfByte.AndInt andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToInt.OfByte.AndInt andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToFloat.OfByte.AndInt andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToChar.OfByte.AndInt andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToShort.OfByte.AndInt andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToByte.OfByte.AndInt andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToBoolean.OfByte.AndInt andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			}
			@FunctionalInterface interface AndFloat extends OfByte<java.lang.Float> {
				double applyDouble(byte x, float y);
				@Override default double applyDouble(byte x, java.lang.Float y) {return applyDouble(x, (float) y);}

				/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
				@Override default ToDouble.OfByte.AndFloat andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToDouble.OfByte.AndFloat andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToLong.OfByte.AndFloat andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToInt.OfByte.AndFloat andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToFloat.OfByte.AndFloat andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToChar.OfByte.AndFloat andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToShort.OfByte.AndFloat andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToByte.OfByte.AndFloat andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToBoolean.OfByte.AndFloat andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			}
			@FunctionalInterface interface AndChar extends OfByte<java.lang.Character> {
				double applyDouble(byte x, char y);
				@Override default double applyDouble(byte x, java.lang.Character y) {return applyDouble(x, (char) y);}

				/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
				@Override default ToDouble.OfByte.AndChar andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToDouble.OfByte.AndChar andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToLong.OfByte.AndChar andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToInt.OfByte.AndChar andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToFloat.OfByte.AndChar andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToChar.OfByte.AndChar andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToShort.OfByte.AndChar andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToByte.OfByte.AndChar andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToBoolean.OfByte.AndChar andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			}
			@FunctionalInterface interface AndShort extends OfByte<java.lang.Short> {
				double applyDouble(byte x, short y);
				@Override default double applyDouble(byte x, java.lang.Short y) {return applyDouble(x, (short) y);}

				/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
				@Override default ToDouble.OfByte.AndShort andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToDouble.OfByte.AndShort andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToLong.OfByte.AndShort andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToInt.OfByte.AndShort andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToFloat.OfByte.AndShort andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToChar.OfByte.AndShort andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToShort.OfByte.AndShort andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToByte.OfByte.AndShort andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToBoolean.OfByte.AndShort andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			}
			@FunctionalInterface interface AndByte extends OfByte<java.lang.Byte> {
				double applyDouble(byte x, byte y);
				@Override default double applyDouble(byte x, java.lang.Byte y) {return applyDouble(x, (byte) y);}

				/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
				@Override default ToDouble.OfByte.AndByte andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToDouble.OfByte.AndByte andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToLong.OfByte.AndByte andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToInt.OfByte.AndByte andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToFloat.OfByte.AndByte andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToChar.OfByte.AndByte andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToShort.OfByte.AndByte andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToByte.OfByte.AndByte andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToBoolean.OfByte.AndByte andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			}
			@FunctionalInterface interface AndBoolean extends OfByte<java.lang.Boolean> {
				double applyDouble(byte x, boolean y);
				@Override default double applyDouble(byte x, java.lang.Boolean y) {return applyDouble(x, (boolean) y);}

				/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
				@Override default ToDouble.OfByte.AndBoolean andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToDouble.OfByte.AndBoolean andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToLong.OfByte.AndBoolean andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToInt.OfByte.AndBoolean andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToFloat.OfByte.AndBoolean andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToChar.OfByte.AndBoolean andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToShort.OfByte.AndBoolean andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToByte.OfByte.AndBoolean andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToBoolean.OfByte.AndBoolean andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			}
		}
		@FunctionalInterface interface OfBoolean<AND> extends ToDouble<AND, java.lang.Boolean>{
			double applyDouble(boolean x, AND y);
			@Override default double applyDouble(java.lang.Boolean x, AND y) {return applyDouble((boolean) x, y);}

			/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
			@Override default ToDouble.OfBoolean<AND> andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToDouble.OfBoolean<AND> andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToLong.OfBoolean<AND> andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToInt.OfBoolean<AND> andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToFloat.OfBoolean<AND> andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToChar.OfBoolean<AND> andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToShort.OfBoolean<AND> andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToByte.OfBoolean<AND> andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
			@Override default ToBoolean.OfBoolean<AND> andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			@FunctionalInterface interface AndDouble extends OfBoolean<java.lang.Double> {
				double applyDouble(boolean x, double y);
				@Override default double applyDouble(boolean x, java.lang.Double y) {return applyDouble(x, (double) y);}

				/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
				@Override default ToDouble.OfBoolean.AndDouble andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToDouble.OfBoolean.AndDouble andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToLong.OfBoolean.AndDouble andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToInt.OfBoolean.AndDouble andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToFloat.OfBoolean.AndDouble andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToChar.OfBoolean.AndDouble andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToShort.OfBoolean.AndDouble andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToByte.OfBoolean.AndDouble andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToBoolean.OfBoolean.AndDouble andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			}
			@FunctionalInterface interface AndLong extends OfBoolean<java.lang.Long> {
				double applyDouble(boolean x, long y);
				@Override default double applyDouble(boolean x, java.lang.Long y) {return applyDouble(x, (long) y);}

				/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
				@Override default ToDouble.OfBoolean.AndLong andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToDouble.OfBoolean.AndLong andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToLong.OfBoolean.AndLong andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToInt.OfBoolean.AndLong andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToFloat.OfBoolean.AndLong andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToChar.OfBoolean.AndLong andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToShort.OfBoolean.AndLong andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToByte.OfBoolean.AndLong andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToBoolean.OfBoolean.AndLong andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			}
			@FunctionalInterface interface AndInt extends OfBoolean<java.lang.Integer> {
				double applyDouble(boolean x, int y);
				@Override default double applyDouble(boolean x, java.lang.Integer y) {return applyDouble(x, (int) y);}

				/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
				@Override default ToDouble.OfBoolean.AndInt andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToDouble.OfBoolean.AndInt andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToLong.OfBoolean.AndInt andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToInt.OfBoolean.AndInt andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToFloat.OfBoolean.AndInt andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToChar.OfBoolean.AndInt andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToShort.OfBoolean.AndInt andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToByte.OfBoolean.AndInt andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToBoolean.OfBoolean.AndInt andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			}
			@FunctionalInterface interface AndFloat extends OfBoolean<java.lang.Float> {
				double applyDouble(boolean x, float y);
				@Override default double applyDouble(boolean x, java.lang.Float y) {return applyDouble(x, (float) y);}

				/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
				@Override default ToDouble.OfBoolean.AndFloat andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToDouble.OfBoolean.AndFloat andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToLong.OfBoolean.AndFloat andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToInt.OfBoolean.AndFloat andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToFloat.OfBoolean.AndFloat andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToChar.OfBoolean.AndFloat andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToShort.OfBoolean.AndFloat andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToByte.OfBoolean.AndFloat andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToBoolean.OfBoolean.AndFloat andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			}
			@FunctionalInterface interface AndChar extends OfBoolean<java.lang.Character> {
				double applyDouble(boolean x, char y);
				@Override default double applyDouble(boolean x, java.lang.Character y) {return applyDouble(x, (char) y);}

				/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
				@Override default ToDouble.OfBoolean.AndChar andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToDouble.OfBoolean.AndChar andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToLong.OfBoolean.AndChar andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToInt.OfBoolean.AndChar andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToFloat.OfBoolean.AndChar andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToChar.OfBoolean.AndChar andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToShort.OfBoolean.AndChar andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToByte.OfBoolean.AndChar andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToBoolean.OfBoolean.AndChar andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			}
			@FunctionalInterface interface AndShort extends OfBoolean<java.lang.Short> {
				double applyDouble(boolean x, short y);
				@Override default double applyDouble(boolean x, java.lang.Short y) {return applyDouble(x, (short) y);}

				/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
				@Override default ToDouble.OfBoolean.AndShort andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToDouble.OfBoolean.AndShort andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToLong.OfBoolean.AndShort andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToInt.OfBoolean.AndShort andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToFloat.OfBoolean.AndShort andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToChar.OfBoolean.AndShort andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToShort.OfBoolean.AndShort andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToByte.OfBoolean.AndShort andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToBoolean.OfBoolean.AndShort andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			}
			@FunctionalInterface interface AndByte extends OfBoolean<java.lang.Byte> {
				double applyDouble(boolean x, byte y);
				@Override default double applyDouble(boolean x, java.lang.Byte y) {return applyDouble(x, (byte) y);}

				/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
				@Override default ToDouble.OfBoolean.AndByte andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToDouble.OfBoolean.AndByte andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToLong.OfBoolean.AndByte andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToInt.OfBoolean.AndByte andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToFloat.OfBoolean.AndByte andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToChar.OfBoolean.AndByte andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToShort.OfBoolean.AndByte andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToByte.OfBoolean.AndByte andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToBoolean.OfBoolean.AndByte andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			}
			@FunctionalInterface interface AndBoolean extends OfBoolean<java.lang.Boolean> {
				double applyDouble(boolean x, boolean y);
				@Override default double applyDouble(boolean x, java.lang.Boolean y) {return applyDouble(x, (boolean) y);}

				/**
		 * Composes a {@code ToDouble} from {@code this} and the argument, passing the result of {@link #applyDouble} as
		 * the argument for {@code after} and then returning the result of evaluating {@code after}.
		 * <p>
		 * This is a specialised form of {@link #andThenDouble(PrimitiveFunction.ToDouble)} and is recommended instead.
		 * @param after the function to apply after this function is applied
		 * @return a composed function that first applies this function and then
     	 * applies the {@code after} function
		 */
				@Override default ToDouble.OfBoolean.AndBoolean andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}
/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @implNote The default implementation calls {@link #andThenDouble(PrimitiveFunction.ToDouble.AndDouble)} and casts the argument to {@code PrimitiveFunction.ToDouble.AndDouble} parameter type
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToDouble.OfBoolean.AndBoolean andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToLong.OfBoolean.AndBoolean andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToInt.OfBoolean.AndBoolean andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToFloat.OfBoolean.AndBoolean andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToChar.OfBoolean.AndBoolean andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToShort.OfBoolean.AndBoolean andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToByte.OfBoolean.AndBoolean andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x,y));}/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 * @apiNote Although the ubiquitous/repetitive nature of the overriding of this method may seem redundant at first glance, it is
		 * overridden to provide a specialised return value that fit the convention and style of this API. Hence each overriden layer provide
		 * a more precise implementation for that nested sub-interface. 
		 */
				@Override default ToBoolean.OfBoolean.AndBoolean andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x,y));}
			}
		}
	}

	// Casting methods
	
	// Function compositions
	/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 */
	@Override default <R> PrimitiveBiFunction<R, AND, OF> andThen(Function<? super TO, ? extends R> after) {return (OF of, AND and) -> after.apply(apply(of, and));}
	/**
	 * Composes a {@code PrimitiveBiFunction} from {@code this} and the {@code after} argument. The default implementation calls
	 * {@link #apply} and then examine it's result. When the result type matches {@link java.lang.Double}, then it is passed to
	 * {@code after}, and the subsequent result of {@code after.applyDouble} is returned. If the result does not match {@link java.lang.Double}
	 * but matches any of java's primtive wrapper, then that wrapper is cast to a {@link java.lang.Double}.
	 * <p>
	 * All nested sub-interfaces override this method to provide precise implementation suitable for that interface's primtitve.
	 * @param after  the function to apply after this function is applied
	 * @return a composed function from this and the argument
	 * @throws ClassCastException if the return value of {@link #apply} is not a primtive wrapper. Note that {@code String} is not
	 * considered a primtive wrapper in this case.
	 */
	default ToDouble<AND, OF> andThenDouble(PrimitiveFunction.ToDouble<? super TO> after) throws AbstractMethodError {throw new AbstractMethodError();}
	/**
	 * Composes a {@code PrimitiveBiFunction} from {@code this} and the {@code after} argument. The default implementation calls
	 * {@link #apply} and then examine it's result. When the result type matches {@link java.lang.Long}, then it is passed to
	 * {@code after}, and the subsequent result of {@code after.applyLong} is returned. If the result does not match {@link java.lang.Long}
	 * but matches any of java's primtive wrapper, then that wrapper is cast to a {@link java.lang.Long}.
	 * <p>
	 * All nested sub-interfaces override this method to provide precise implementation suitable for that interface's primtitve.
	 * @param after  the function to apply after this function is applied
	 * @return a composed function from this and the argument
	 * @throws ClassCastException if the return value of {@link #apply} is not a primtive wrapper. Note that {@code String} is not
	 * considered a primtive wrapper in this case.
	 */
	default ToLong<AND, OF> andThenLong(PrimitiveFunction.ToLong<? super TO> after) throws AbstractMethodError {throw new AbstractMethodError();}
	/**
	 * Composes a {@code PrimitiveBiFunction} from {@code this} and the {@code after} argument. The default implementation calls
	 * {@link #apply} and then examine it's result. When the result type matches {@link java.lang.Integer}, then it is passed to
	 * {@code after}, and the subsequent result of {@code after.applyInt} is returned. If the result does not match {@link java.lang.Integer}
	 * but matches any of java's primtive wrapper, then that wrapper is cast to a {@link java.lang.Integer}.
	 * <p>
	 * All nested sub-interfaces override this method to provide precise implementation suitable for that interface's primtitve.
	 * @param after  the function to apply after this function is applied
	 * @return a composed function from this and the argument
	 * @throws ClassCastException if the return value of {@link #apply} is not a primtive wrapper. Note that {@code String} is not
	 * considered a primtive wrapper in this case.
	 */
	default ToInt<AND, OF> andThenInt(PrimitiveFunction.ToInt<? super TO> after) throws AbstractMethodError {throw new AbstractMethodError();}
	/**
	 * Composes a {@code PrimitiveBiFunction} from {@code this} and the {@code after} argument. The default implementation calls
	 * {@link #apply} and then examine it's result. When the result type matches {@link java.lang.Float}, then it is passed to
	 * {@code after}, and the subsequent result of {@code after.applyFloat} is returned. If the result does not match {@link java.lang.Float}
	 * but matches any of java's primtive wrapper, then that wrapper is cast to a {@link java.lang.Float}.
	 * <p>
	 * All nested sub-interfaces override this method to provide precise implementation suitable for that interface's primtitve.
	 * @param after  the function to apply after this function is applied
	 * @return a composed function from this and the argument
	 * @throws ClassCastException if the return value of {@link #apply} is not a primtive wrapper. Note that {@code String} is not
	 * considered a primtive wrapper in this case.
	 */
	default ToFloat<AND, OF> andThenFloat(PrimitiveFunction.ToFloat<? super TO> after) throws AbstractMethodError {throw new AbstractMethodError();}
	/**
	 * Composes a {@code PrimitiveBiFunction} from {@code this} and the {@code after} argument. The default implementation calls
	 * {@link #apply} and then examine it's result. When the result type matches {@link java.lang.Character}, then it is passed to
	 * {@code after}, and the subsequent result of {@code after.applyChar} is returned. If the result does not match {@link java.lang.Character}
	 * but matches any of java's primtive wrapper, then that wrapper is cast to a {@link java.lang.Character}.
	 * <p>
	 * All nested sub-interfaces override this method to provide precise implementation suitable for that interface's primtitve.
	 * @param after  the function to apply after this function is applied
	 * @return a composed function from this and the argument
	 * @throws ClassCastException if the return value of {@link #apply} is not a primtive wrapper. Note that {@code String} is not
	 * considered a primtive wrapper in this case.
	 */
	default ToChar<AND, OF> andThenChar(PrimitiveFunction.ToChar<? super TO> after) throws AbstractMethodError {throw new AbstractMethodError();}
	/**
	 * Composes a {@code PrimitiveBiFunction} from {@code this} and the {@code after} argument. The default implementation calls
	 * {@link #apply} and then examine it's result. When the result type matches {@link java.lang.Short}, then it is passed to
	 * {@code after}, and the subsequent result of {@code after.applyShort} is returned. If the result does not match {@link java.lang.Short}
	 * but matches any of java's primtive wrapper, then that wrapper is cast to a {@link java.lang.Short}.
	 * <p>
	 * All nested sub-interfaces override this method to provide precise implementation suitable for that interface's primtitve.
	 * @param after  the function to apply after this function is applied
	 * @return a composed function from this and the argument
	 * @throws ClassCastException if the return value of {@link #apply} is not a primtive wrapper. Note that {@code String} is not
	 * considered a primtive wrapper in this case.
	 */
	default ToShort<AND, OF> andThenShort(PrimitiveFunction.ToShort<? super TO> after) throws AbstractMethodError {throw new AbstractMethodError();}
	/**
	 * Composes a {@code PrimitiveBiFunction} from {@code this} and the {@code after} argument. The default implementation calls
	 * {@link #apply} and then examine it's result. When the result type matches {@link java.lang.Byte}, then it is passed to
	 * {@code after}, and the subsequent result of {@code after.applyByte} is returned. If the result does not match {@link java.lang.Byte}
	 * but matches any of java's primtive wrapper, then that wrapper is cast to a {@link java.lang.Byte}.
	 * <p>
	 * All nested sub-interfaces override this method to provide precise implementation suitable for that interface's primtitve.
	 * @param after  the function to apply after this function is applied
	 * @return a composed function from this and the argument
	 * @throws ClassCastException if the return value of {@link #apply} is not a primtive wrapper. Note that {@code String} is not
	 * considered a primtive wrapper in this case.
	 */
	default ToByte<AND, OF> andThenByte(PrimitiveFunction.ToByte<? super TO> after) throws AbstractMethodError {throw new AbstractMethodError();}
	/**
	 * Composes a {@code PrimitiveBiFunction} from {@code this} and the {@code after} argument. The default implementation calls
	 * {@link #apply} and then examine it's result. When the result type matches {@link java.lang.Boolean}, then it is passed to
	 * {@code after}, and the subsequent result of {@code after.applyBoolean} is returned. If the result does not match {@link java.lang.Boolean}
	 * but matches any of java's primtive wrapper, then that wrapper is cast to a {@link java.lang.Boolean}.
	 * <p>
	 * All nested sub-interfaces override this method to provide precise implementation suitable for that interface's primtitve.
	 * @param after  the function to apply after this function is applied
	 * @return a composed function from this and the argument
	 * @throws ClassCastException if the return value of {@link #apply} is not a primtive wrapper. Note that {@code String} is not
	 * considered a primtive wrapper in this case.
	 */
	default ToBoolean<AND, OF> andThenBoolean(PrimitiveFunction.ToBoolean<? super TO> after) throws AbstractMethodError {throw new AbstractMethodError();}
}
