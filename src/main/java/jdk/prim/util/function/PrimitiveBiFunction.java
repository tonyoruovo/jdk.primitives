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

		default ToDouble<AND, OF> andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}

		@Override default ToDouble<AND, OF> andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}
		@Override default ToLong<AND, OF> andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x, y));}
		@Override default ToInt<AND, OF> andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x, y));}
		@Override default ToFloat<AND, OF> andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x, y));}
		@Override default ToChar<AND, OF> andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x, y));}
		@Override default ToShort<AND, OF> andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x, y));}
		@Override default ToByte<AND, OF> andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x, y));}
		@Override default ToBoolean<AND, OF> andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x, y) != 0);}
		
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
			 * 
			 * Applies this function to the given arguments, returning a {@code double} result.
			 * @param x {@inheritDoc}
			 * @param y {@inheritDoc}
			 * @return {@inheritDoc}
			 * @implNote The default implementation calls {@link #applyDouble(Object, double)}, consequentially casting the second argument.
			 */
			@Override default double applyDouble(OF x, java.lang.Double y) {return applyDouble(x, (double) y);}

			@Override default ToDouble.AndDouble<OF> andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}

			@Override default ToDouble.AndDouble<OF> andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}
			@Override default ToLong.AndLong<OF> andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x, (double)y));}
			@Override default ToInt.AndInt<OF> andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x, (double)y));}
			@Override default ToFloat.AndFloat<OF> andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x, (double)y));}
			@Override default ToChar.AndChar<OF> andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x, (double)(int)y));}
			@Override default ToShort.AndShort<OF> andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x, (double)y));}
			@Override default ToByte.AndByte<OF> andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x, (double)y));}
			@Override default ToBoolean.AndBoolean<OF> andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x, (double)(y?1:0)) != 0);}
		}
		@FunctionalInterface interface AndLong<OF> extends ToDouble<java.lang.Long, OF> {
			double applyDouble(OF x, long y);
			@Override default double applyDouble(OF x, java.lang.Long y) {return applyDouble(x, (long) y);}

			@Override default ToDouble.AndLong<OF> andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}

			@Override default ToDouble.AndLong<OF> andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}
			@Override default ToLong.AndLong<OF> andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x, (long)y));}
			@Override default ToInt.AndInt<OF> andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x, (long)y));}
			@Override default ToFloat.AndFloat<OF> andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x, (long)y));}
			@Override default ToChar.AndChar<OF> andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x, (long)(int)y));}
			@Override default ToShort.AndShort<OF> andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x, (long)y));}
			@Override default ToByte.AndByte<OF> andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x, (long)y));}
			@Override default ToBoolean.AndBoolean<OF> andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x, (long)(y?1:0)) != 0);}
		}
		@FunctionalInterface interface AndInt<OF> extends ToDouble<java.lang.Integer, OF> {
			double applyDouble(OF x, int y);
			@Override default double applyDouble(OF x, java.lang.Integer y) {return applyDouble(x, (int) y);}

			@Override default ToDouble.AndInt<OF> andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}

			@Override default ToDouble.AndInt<OF> andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}
			@Override default ToLong.AndLong<OF> andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x, (int)y));}
			@Override default ToInt.AndInt<OF> andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x, (int)y));}
			@Override default ToFloat.AndFloat<OF> andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x, (int)y));}
			@Override default ToChar.AndChar<OF> andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x, (int)y));}
			@Override default ToShort.AndShort<OF> andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x, (int)y));}
			@Override default ToByte.AndByte<OF> andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x, (int)y));}
			@Override default ToBoolean.AndBoolean<OF> andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x, (int)(y?1:0)) != 0);}
		}
		@FunctionalInterface interface AndFloat<OF> extends ToDouble<java.lang.Float, OF> {
			double applyDouble(OF x, float y);
			@Override default double applyDouble(OF x, java.lang.Float y) {return applyDouble(x, (float) y);}

			@Override default ToDouble.AndFloat<OF> andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}

			@Override default ToDouble.AndFloat<OF> andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}
			@Override default ToLong.AndLong<OF> andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x, (float)y));}
			@Override default ToInt.AndInt<OF> andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x, (float)y));}
			@Override default ToFloat.AndFloat<OF> andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x, (float)y));}
			@Override default ToChar.AndChar<OF> andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x, (float)(int)y));}
			@Override default ToShort.AndShort<OF> andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x, (float)y));}
			@Override default ToByte.AndByte<OF> andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x, (float)y));}
			@Override default ToBoolean.AndBoolean<OF> andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x, (float)(y?1:0)) != 0);}
		}
		@FunctionalInterface interface AndChar<OF> extends ToDouble<java.lang.Character, OF> {
			double applyDouble(OF x, char y);
			@Override default double applyDouble(OF x, java.lang.Character y) {return applyDouble(x, (char) y);}

			@Override default ToDouble.AndChar<OF> andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}

			@Override default ToDouble.AndChar<OF> andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}
			@Override default ToLong.AndLong<OF> andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x, (char)(int)y));}
			@Override default ToInt.AndInt<OF> andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x, (char)(int)y));}
			@Override default ToFloat.AndFloat<OF> andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x, (char)(int)y));}
			@Override default ToChar.AndChar<OF> andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x, (char)y));}
			@Override default ToShort.AndShort<OF> andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x, (char)(int)y));}
			@Override default ToByte.AndByte<OF> andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x, (char)(int)y));}
			@Override default ToBoolean.AndBoolean<OF> andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x, (char)(int)(y?1:0)) != 0);}
		}
		@FunctionalInterface interface AndShort<OF> extends ToDouble<java.lang.Short, OF> {
			double applyDouble(OF x, short y);
			@Override default double applyDouble(OF x, java.lang.Short y) {return applyDouble(x, (short) y);}

			@Override default ToDouble.AndShort<OF> andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}

			@Override default ToDouble.AndShort<OF> andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}
			@Override default ToLong.AndLong<OF> andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x, (short)y));}
			@Override default ToInt.AndInt<OF> andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x, (short)y));}
			@Override default ToFloat.AndFloat<OF> andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x, (short)y));}
			@Override default ToChar.AndChar<OF> andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x, (short)(int)y));}
			@Override default ToShort.AndShort<OF> andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x, (short)y));}
			@Override default ToByte.AndByte<OF> andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x, (short)y));}
			@Override default ToBoolean.AndBoolean<OF> andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x, (short)(y?1:0)) != 0);}
		}
		@FunctionalInterface interface AndByte<OF> extends ToDouble<java.lang.Byte, OF> {
			double applyDouble(OF x, byte y);
			@Override default double applyDouble(OF x, java.lang.Byte y) {return applyDouble(x, (byte) y);}

			@Override default ToDouble.AndByte<OF> andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}

			@Override default ToDouble.AndByte<OF> andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}
			@Override default ToLong.AndLong<OF> andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x, (byte)y));}
			@Override default ToInt.AndInt<OF> andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x, (byte)y));}
			@Override default ToFloat.AndFloat<OF> andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x, (byte)y));}
			@Override default ToChar.AndChar<OF> andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x, (byte)(int)y));}
			@Override default ToShort.AndShort<OF> andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x, (byte)y));}
			@Override default ToByte.AndByte<OF> andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x, (byte)y));}
			@Override default ToBoolean.AndBoolean<OF> andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x, (byte)(y?1:0)) != 0);}
		}
		@FunctionalInterface interface AndBoolean<OF> extends ToDouble<java.lang.Boolean, OF> {
			double applyDouble(OF x, boolean y);
			@Override default double applyDouble(OF x, java.lang.Boolean y) {return applyDouble(x, (boolean) y);}

			@Override default ToDouble.AndBoolean<OF> andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}

			@Override default ToDouble.AndBoolean<OF> andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}
			@Override default ToLong.AndLong<OF> andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble(x, (boolean)y!=0));}
			@Override default ToInt.AndInt<OF> andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble(x, (boolean)y!=0));}
			@Override default ToFloat.AndFloat<OF> andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble(x, (boolean)y!=0));}
			@Override default ToChar.AndChar<OF> andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble(x, (boolean)y!=0));}
			@Override default ToShort.AndShort<OF> andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble(x, (boolean)y!=0));}
			@Override default ToByte.AndByte<OF> andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble(x, (boolean)y!=0));}
			@Override default ToBoolean.AndBoolean<OF> andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble(x, (boolean)y!=0) != 0);}
		}

		@FunctionalInterface interface OfDouble<AND> extends ToDouble<AND, java.lang.Double>{
			double applyDouble(double x, AND y);
			@Override default double applyDouble(java.lang.Double x, AND y) {return applyDouble((double) x, y);}

			@Override default ToDouble.OfDouble<AND> andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}

			@Override default ToDouble.OfDouble<AND> andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}
			@Override default ToLong.OfLong<AND> andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble((double) x,y));}
			@Override default ToInt.OfInt<AND> andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble((double) x,y));}
			@Override default ToFloat.OfFloat<AND> andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble((double) x,y));}
			@Override default ToChar.OfChar<AND> andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble((double)(int) x,y));}
			@Override default ToShort.OfShort<AND> andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble((double) x,y));}
			@Override default ToByte.OfByte<AND> andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble((double) x,y));}
			@Override default ToBoolean.OfBoolean<AND> andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble((double) x?1:0,y) != 0);}
			@FunctionalInterface interface AndDouble extends OfDouble<java.lang.Double>, BinaryOperator<java.lang.Double>, DoubleBinaryOperator {
				double applyDouble(double x, double y);
				@Override default double applyDouble(double x, java.lang.Double y) {return applyDouble(x, (double) y);}
				@Override default double applyAsDouble(double x, double y) {return applyDouble(x, (double) y);}

				@Override default ToDouble.OfDouble.AndDouble andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}

				@Override default ToDouble.OfDouble.AndDouble andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}
				@Override default ToLong.OfLong.AndLong andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble((double) x,(double)y));}
				@Override default ToInt.OfInt.AndInt andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble((double) x,(double)y));}
				@Override default ToFloat.OfFloat.AndFloat andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble((double) x,(double)y));}
				@Override default ToChar.OfChar.AndChar andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble((double)(int) x,(double)(int)y));}
				@Override default ToShort.OfShort.AndShort andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble((double) x,(double)y));}
				@Override default ToByte.OfByte.AndByte andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble((double) x,(double)y));}
				@Override default ToBoolean.OfBoolean.AndBoolean andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble((double) x?1:0,(double)y?1:0) != 0);}
			}
			@FunctionalInterface interface AndLong extends OfDouble<java.lang.Long> {
				double applyDouble(double x, long y);
				@Override default double applyDouble(double x, java.lang.Long y) {return applyDouble(x, (long) y);}

				@Override default ToDouble.OfDouble.AndLong andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}

				@Override default ToDouble.OfDouble.AndLong andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}
				@Override default ToLong.OfLong.AndLong andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble((double) x,(long)y));}
				@Override default ToInt.OfInt.AndInt andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble((double) x,(long)y));}
				@Override default ToFloat.OfFloat.AndFloat andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble((double) x,(long)y));}
				@Override default ToChar.OfChar.AndChar andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble((double)(int) x,(long)(int)y));}
				@Override default ToShort.OfShort.AndShort andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble((double) x,(long)y));}
				@Override default ToByte.OfByte.AndByte andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble((double) x,(long)y));}
				@Override default ToBoolean.OfBoolean.AndBoolean andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble((double) x?1:0,(long)y?1:0) != 0);}
			}
			@FunctionalInterface interface AndInt extends OfDouble<java.lang.Integer> {
				double applyDouble(double x, int y);
				@Override default double applyDouble(double x, java.lang.Integer y) {return applyDouble(x, (int) y);}

				@Override default ToDouble.OfDouble.AndInt andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}

				@Override default ToDouble.OfDouble.AndInt andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}
				@Override default ToLong.OfLong.AndLong andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble((double) x,(int)y));}
				@Override default ToInt.OfInt.AndInt andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble((double) x,(int)y));}
				@Override default ToFloat.OfFloat.AndFloat andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble((double) x,(int)y));}
				@Override default ToChar.OfChar.AndChar andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble((double)(int) x,(int)y));}
				@Override default ToShort.OfShort.AndShort andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble((double) x,(int)y));}
				@Override default ToByte.OfByte.AndByte andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble((double) x,(int)y));}
				@Override default ToBoolean.OfBoolean.AndBoolean andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble((double) x?1:0,(int)y?1:0) != 0);}
			}
			@FunctionalInterface interface AndFloat extends OfDouble<java.lang.Float> {
				double applyDouble(double x, float y);
				@Override default double applyDouble(double x, java.lang.Float y) {return applyDouble(x, (float) y);}

				@Override default ToDouble.OfDouble.AndFloat andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}

				@Override default ToDouble.OfDouble.AndFloat andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}
				@Override default ToLong.OfLong.AndLong andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble((double) x,(float)y));}
				@Override default ToInt.OfInt.AndInt andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble((double) x,(float)y));}
				@Override default ToFloat.OfFloat.AndFloat andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble((double) x,(float)y));}
				@Override default ToChar.OfChar.AndChar andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble((double)(int) x,(float)(int)y));}
				@Override default ToShort.OfShort.AndShort andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble((double) x,(float)y));}
				@Override default ToByte.OfByte.AndByte andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble((double) x,(float)y));}
				@Override default ToBoolean.OfBoolean.AndBoolean andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble((double) x?1:0,(float)y?1:0) != 0);}
			}
			@FunctionalInterface interface AndChar extends OfDouble<java.lang.Character> {
				double applyDouble(double x, char y);
				@Override default double applyDouble(double x, java.lang.Character y) {return applyDouble(x, (char) y);}

				@Override default ToDouble.OfDouble.AndChar andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}

				@Override default ToDouble.OfDouble.AndChar andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}
				@Override default ToLong.OfLong.AndLong andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble((double) x,(char)(int)y));}
				@Override default ToInt.OfInt.AndInt andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble((double) x,(char)(int)y));}
				@Override default ToFloat.OfFloat.AndFloat andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble((double) x,(char)(int)y));}
				@Override default ToChar.OfChar.AndChar andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble((double)(int) x,(char)(int)y));}
				@Override default ToShort.OfShort.AndShort andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble((double) x,(char)(int)y));}
				@Override default ToByte.OfByte.AndByte andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble((double) x,(char)(int)y));}
				@Override default ToBoolean.OfBoolean.AndBoolean andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble((double) x?1:0,(char)(int)y?1:0) != 0);}
			}
			@FunctionalInterface interface AndShort extends OfDouble<java.lang.Short> {
				double applyDouble(double x, short y);
				@Override default double applyDouble(double x, java.lang.Short y) {return applyDouble(x, (short) y);}

				@Override default ToDouble.OfDouble.AndShort andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}

				@Override default ToDouble.OfDouble.AndShort andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}
				@Override default ToLong.OfLong.AndLong andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble((double) x,(short)y));}
				@Override default ToInt.OfInt.AndInt andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble((double) x,(short)y));}
				@Override default ToFloat.OfFloat.AndFloat andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble((double) x,(short)y));}
				@Override default ToChar.OfChar.AndChar andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble((double)(int) x,(short)(int)y));}
				@Override default ToShort.OfShort.AndShort andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble((double) x,(short)y));}
				@Override default ToByte.OfByte.AndByte andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble((double) x,(short)y));}
				@Override default ToBoolean.OfBoolean.AndBoolean andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble((double) x?1:0,(short)y?1:0) != 0);}
			}
			@FunctionalInterface interface AndByte extends OfDouble<java.lang.Byte> {
				double applyDouble(double x, byte y);
				@Override default double applyDouble(double x, java.lang.Byte y) {return applyDouble(x, (byte) y);}

				@Override default ToDouble.OfDouble.AndByte andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}

				@Override default ToDouble.OfDouble.AndByte andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}
				@Override default ToLong.OfLong.AndLong andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble((double) x,(byte)y));}
				@Override default ToInt.OfInt.AndInt andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble((double) x,(byte)y));}
				@Override default ToFloat.OfFloat.AndFloat andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble((double) x,(byte)y));}
				@Override default ToChar.OfChar.AndChar andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble((double)(int) x,(byte)(int)y));}
				@Override default ToShort.OfShort.AndShort andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble((double) x,(byte)y));}
				@Override default ToByte.OfByte.AndByte andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble((double) x,(byte)y));}
				@Override default ToBoolean.OfBoolean.AndBoolean andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble((double) x?1:0,(byte)y?1:0) != 0);}
			}
			@FunctionalInterface interface AndBoolean extends OfDouble<java.lang.Boolean> {
				double applyDouble(double x, boolean y);
				@Override default double applyDouble(double x, java.lang.Boolean y) {return applyDouble(x, (boolean) y);}

				@Override default ToDouble.OfDouble.AndBoolean andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}

				@Override default ToDouble.OfDouble.AndBoolean andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}
				@Override default ToLong.OfLong.AndLong andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble((double) x,y!=0));}
				@Override default ToInt.OfInt.AndInt andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble((double) x,y!=0));}
				@Override default ToFloat.OfFloat.AndFloat andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble((double) x,y!=0));}
				@Override default ToChar.OfChar.AndChar andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble((double)(int) x,y!=0));}
				@Override default ToShort.OfShort.AndShort andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble((double) x,y!=0));}
				@Override default ToByte.OfByte.AndByte andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble((double) x,y!=0));}
				@Override default ToBoolean.OfBoolean.AndBoolean andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble((double) x?1:0,y) != 0);}
			}
		}
		@FunctionalInterface interface OfLong<AND> extends ToDouble<AND, java.lang.Long>{
			double applyDouble(long x, AND y);
			@Override default double applyDouble(java.lang.Long x, AND y) {return applyDouble((long) x, y);}

			@Override default ToDouble.OfLong<AND> andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}

			@Override default ToDouble.OfLong<AND> andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}
			@Override default ToLong.OfLong<AND> andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble((long) x,y));}
			@Override default ToInt.OfInt<AND> andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble((long) x,y));}
			@Override default ToFloat.OfFloat<AND> andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble((long) x,y));}
			@Override default ToChar.OfChar<AND> andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble((long)(int) x,y));}
			@Override default ToShort.OfShort<AND> andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble((long) x,y));}
			@Override default ToByte.OfByte<AND> andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble((long) x,y));}
			@Override default ToBoolean.OfBoolean<AND> andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble((long) x?1:0,y) != 0);}
			@FunctionalInterface interface AndDouble extends OfLong<java.lang.Double> {
				double applyDouble(long x, double y);
				@Override default double applyDouble(long x, java.lang.Double y) {return applyDouble(x, (double) y);}

				@Override default ToDouble.OfLong.AndDouble andThenDouble(PrimitiveFunction.ToDouble.AndDouble after) {return (x,y) -> after.applyDouble(applyDouble(x, y));}

				@Override default ToDouble.OfDouble.AndDouble andThenDouble(PrimitiveFunction.ToDouble<? super java.lang.Double> after) {if(after instanceof PrimitiveFunction.ToDouble.AndDouble) return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after); return andThenDouble((PrimitiveFunction.ToDouble.AndDouble) after::applyDouble);}
				@Override default ToLong.OfLong.AndLong andThenLong(PrimitiveFunction.ToLong<? super java.lang.Double> after) {return (x,y) -> after.applyLong(applyDouble((double) x,(double)y));}
				@Override default ToInt.OfInt.AndInt andThenInt(PrimitiveFunction.ToInt<? super java.lang.Double> after) {return (x,y) -> after.applyInt(applyDouble((double) x,(double)y));}
				@Override default ToFloat.OfFloat.AndFloat andThenFloat(PrimitiveFunction.ToFloat<? super java.lang.Double> after) {return (x,y) -> after.applyFloat(applyDouble((double) x,(double)y));}
				@Override default ToChar.OfChar.AndChar andThenChar(PrimitiveFunction.ToChar<? super java.lang.Double> after) {return (x,y) -> after.applyChar(applyDouble((double)(int) x,(double)(int)y));}
				@Override default ToShort.OfShort.AndShort andThenShort(PrimitiveFunction.ToShort<? super java.lang.Double> after) {return (x,y) -> after.applyShort(applyDouble((double) x,(double)y));}
				@Override default ToByte.OfByte.AndByte andThenByte(PrimitiveFunction.ToByte<? super java.lang.Double> after) {return (x,y) -> after.applyByte(applyDouble((double) x,(double)y));}
				@Override default ToBoolean.OfBoolean.AndBoolean andThenBoolean(PrimitiveFunction.ToBoolean<? super java.lang.Double> after) {return (x,y) -> after.applyBoolean(applyDouble((double) x?1:0,(double)y?1:0) != 0);}
			}
			@FunctionalInterface interface AndLong extends OfLong<java.lang.Long> {
				double applyDouble(long x, long y);
				@Override default double applyDouble(long x, java.lang.Long y) {return applyDouble(x, (long) y);}
			}
			@FunctionalInterface interface AndInt extends OfLong<java.lang.Integer> {
				double applyDouble(long x, int y);
				@Override default double applyDouble(long x, java.lang.Integer y) {return applyDouble(x, (int) y);}
			}
			@FunctionalInterface interface AndFloat extends OfLong<java.lang.Float> {
				double applyDouble(long x, float y);
				@Override default double applyDouble(long x, java.lang.Float y) {return applyDouble(x, (float) y);}
			}
			@FunctionalInterface interface AndChar extends OfLong<java.lang.Character> {
				double applyDouble(long x, char y);
				@Override default double applyDouble(long x, java.lang.Character y) {return applyDouble(x, (char) y);}
			}
			@FunctionalInterface interface AndShort extends OfLong<java.lang.Short> {
				double applyDouble(long x, short y);
				@Override default double applyDouble(long x, java.lang.Short y) {return applyDouble(x, (short) y);}
			}
			@FunctionalInterface interface AndByte extends OfLong<java.lang.Byte> {
				double applyDouble(long x, byte y);
				@Override default double applyDouble(long x, java.lang.Byte y) {return applyDouble(x, (byte) y);}
			}
			@FunctionalInterface interface AndBoolean extends OfLong<java.lang.Boolean> {
				double applyDouble(long x, boolean y);
				@Override default double applyDouble(long x, java.lang.Boolean y) {return applyDouble(x, (boolean) y);}
			}
		}
		@FunctionalInterface interface OfInt<AND> extends ToDouble<AND, java.lang.Integer>{
			double applyDouble(int x, AND y);
			@Override default double applyDouble(java.lang.Integer x, AND y) {return applyDouble((int) x, y);}
//			@Override default OfInt<AND> toDouble() {return this;}
			@FunctionalInterface interface AndDouble extends OfInt<java.lang.Double> {
				double applyDouble(int x, double y);
				@Override default double applyDouble(int x, java.lang.Double y) {return applyDouble(x, (double) y);}
//				@Override default AsDouble toDouble() {return this;}
			}
			@FunctionalInterface interface AndLong extends OfInt<java.lang.Long> {
				double applyDouble(int x, long y);
				@Override default double applyDouble(int x, java.lang.Long y) {return applyDouble(x, (long) y);}
			}
			@FunctionalInterface interface AndInt extends OfInt<java.lang.Integer> {
				double applyDouble(int x, int y);
				@Override default double applyDouble(int x, java.lang.Integer y) {return applyDouble(x, (int) y);}
			}
			@FunctionalInterface interface AndFloat extends OfInt<java.lang.Float> {
				double applyDouble(int x, float y);
				@Override default double applyDouble(int x, java.lang.Float y) {return applyDouble(x, (float) y);}
			}
			@FunctionalInterface interface AndChar extends OfInt<java.lang.Character> {
				double applyDouble(int x, char y);
				@Override default double applyDouble(int x, java.lang.Character y) {return applyDouble(x, (char) y);}
			}
			@FunctionalInterface interface AndShort extends OfInt<java.lang.Short> {
				double applyDouble(int x, short y);
				@Override default double applyDouble(int x, java.lang.Short y) {return applyDouble(x, (short) y);}
			}
			@FunctionalInterface interface AndByte extends OfInt<java.lang.Byte> {
				double applyDouble(int x, byte y);
				@Override default double applyDouble(int x, java.lang.Byte y) {return applyDouble(x, (byte) y);}
			}
			@FunctionalInterface interface AndBoolean extends OfInt<java.lang.Boolean> {
				double applyDouble(int x, boolean y);
				@Override default double applyDouble(int x, java.lang.Boolean y) {return applyDouble(x, (boolean) y);}
			}
		}
		@FunctionalInterface interface OfFloat<AND> extends ToDouble<AND, java.lang.Float>{
			double applyDouble(float x, AND y);
			@Override default double applyDouble(java.lang.Float x, AND y) {return applyDouble((float) x, y);}
//			@Override default OfFloat<AND> toDouble() {return this;}
			@FunctionalInterface interface AndDouble extends OfFloat<java.lang.Double> {
				double applyDouble(float x, double y);
				@Override default double applyDouble(float x, java.lang.Double y) {return applyDouble(x, (double) y);}
//				@Override default AsDouble toDouble() {return this;}
			}
			@FunctionalInterface interface AndLong extends OfFloat<java.lang.Long> {
				double applyDouble(float x, long y);
				@Override default double applyDouble(float x, java.lang.Long y) {return applyDouble(x, (long) y);}
			}
			@FunctionalInterface interface AndInt extends OfFloat<java.lang.Integer> {
				double applyDouble(float x, int y);
				@Override default double applyDouble(float x, java.lang.Integer y) {return applyDouble(x, (int) y);}
			}
			@FunctionalInterface interface AndFloat extends OfFloat<java.lang.Float> {
				double applyDouble(float x, float y);
				@Override default double applyDouble(float x, java.lang.Float y) {return applyDouble(x, (float) y);}
			}
			@FunctionalInterface interface AndChar extends OfFloat<java.lang.Character> {
				double applyDouble(float x, char y);
				@Override default double applyDouble(float x, java.lang.Character y) {return applyDouble(x, (char) y);}
			}
			@FunctionalInterface interface AndShort extends OfFloat<java.lang.Short> {
				double applyDouble(float x, short y);
				@Override default double applyDouble(float x, java.lang.Short y) {return applyDouble(x, (short) y);}
			}
			@FunctionalInterface interface AndByte extends OfFloat<java.lang.Byte> {
				double applyDouble(float x, byte y);
				@Override default double applyDouble(float x, java.lang.Byte y) {return applyDouble(x, (byte) y);}
			}
			@FunctionalInterface interface AndBoolean extends OfFloat<java.lang.Boolean> {
				double applyDouble(float x, boolean y);
				@Override default double applyDouble(float x, java.lang.Boolean y) {return applyDouble(x, (boolean) y);}
			}
		}
		@FunctionalInterface interface OfShort<AND> extends ToDouble<AND, java.lang.Short>{
			double applyDouble(short x, AND y);
			@Override default double applyDouble(java.lang.Short x, AND y) {return applyDouble((short) x, y);}
//			@Override default OfShort<AND> toDouble() {return this;}
			@FunctionalInterface interface AndDouble extends OfShort<java.lang.Double> {
				double applyDouble(short x, double y);
				@Override default double applyDouble(short x, java.lang.Double y) {return applyDouble(x, (double) y);}
//				@Override default AsDouble toDouble() {return this;}
			}
			@FunctionalInterface interface AndLong extends OfShort<java.lang.Long> {
				double applyDouble(short x, long y);
				@Override default double applyDouble(short x, java.lang.Long y) {return applyDouble(x, (long) y);}
			}
			@FunctionalInterface interface AndInt extends OfShort<java.lang.Integer> {
				double applyDouble(short x, int y);
				@Override default double applyDouble(short x, java.lang.Integer y) {return applyDouble(x, (int) y);}
			}
			@FunctionalInterface interface AndFloat extends OfShort<java.lang.Float> {
				double applyDouble(short x, float y);
				@Override default double applyDouble(short x, java.lang.Float y) {return applyDouble(x, (float) y);}
			}
			@FunctionalInterface interface AndChar extends OfShort<java.lang.Character> {
				double applyDouble(short x, char y);
				@Override default double applyDouble(short x, java.lang.Character y) {return applyDouble(x, (char) y);}
			}
			@FunctionalInterface interface AndShort extends OfShort<java.lang.Short> {
				double applyDouble(short x, short y);
				@Override default double applyDouble(short x, java.lang.Short y) {return applyDouble(x, (short) y);}
			}
			@FunctionalInterface interface AndByte extends OfShort<java.lang.Byte> {
				double applyDouble(short x, byte y);
				@Override default double applyDouble(short x, java.lang.Byte y) {return applyDouble(x, (byte) y);}
			}
			@FunctionalInterface interface AndBoolean extends OfShort<java.lang.Boolean> {
				double applyDouble(short x, boolean y);
				@Override default double applyDouble(short x, java.lang.Boolean y) {return applyDouble(x, (boolean) y);}
			}
		}
		@FunctionalInterface interface OfByte<AND> extends ToDouble<AND, java.lang.Byte>{
			double applyDouble(byte x, AND y);
			@Override default double applyDouble(java.lang.Byte x, AND y) {return applyDouble((byte) x, y);}
//			@Override default OfByte<AND> toDouble() {return this;}
			@FunctionalInterface interface AndDouble extends OfByte<java.lang.Double> {
				double applyDouble(byte x, double y);
				@Override default double applyDouble(byte x, java.lang.Double y) {return applyDouble(x, (double) y);}
//				@Ovjerride default AsDouble toDouble() {return this;}
			}
			@FunctionalInterface interface AndLong extends OfByte<java.lang.Long> {
				double applyDouble(byte x, long y);
				@Override default double applyDouble(byte x, java.lang.Long y) {return applyDouble(x, (long) y);}
			}
			@FunctionalInterface interface AndInt extends OfByte<java.lang.Integer> {
				double applyDouble(byte x, int y);
				@Override default double applyDouble(byte x, java.lang.Integer y) {return applyDouble(x, (int) y);}
			}
			@FunctionalInterface interface AndFloat extends OfByte<java.lang.Float> {
				double applyDouble(byte x, float y);
				@Override default double applyDouble(byte x, java.lang.Float y) {return applyDouble(x, (float) y);}
			}
			@FunctionalInterface interface AndChar extends OfByte<java.lang.Character> {
				double applyDouble(byte x, char y);
				@Override default double applyDouble(byte x, java.lang.Character y) {return applyDouble(x, (char) y);}
			}
			@FunctionalInterface interface AndShort extends OfByte<java.lang.Short> {
				double applyDouble(byte x, short y);
				@Override default double applyDouble(byte x, java.lang.Short y) {return applyDouble(x, (short) y);}
			}
			@FunctionalInterface interface AndByte extends OfByte<java.lang.Byte> {
				double applyDouble(byte x, byte y);
				@Override default double applyDouble(byte x, java.lang.Byte y) {return applyDouble(x, (byte) y);}
			}
			@FunctionalInterface interface AndBoolean extends OfByte<java.lang.Boolean> {
				double applyDouble(byte x, boolean y);
				@Override default double applyDouble(byte x, java.lang.Boolean y) {return applyDouble(x, (boolean) y);}
			}
		}
		@FunctionalInterface interface OfBoolean<AND> extends ToDouble<AND, java.lang.Boolean>{
			double applyDouble(boolean x, AND y);
			@Override default double applyDouble(java.lang.Boolean x, AND y) {return applyDouble((boolean) x, y);}
//			@Override default OfBoolean<AND> toDouble() {return this;}
			@FunctionalInterface interface AndDouble extends OfBoolean<java.lang.Double> {
				double applyDouble(boolean x, double y);
				@Override default double applyDouble(boolean x, java.lang.Double y) {return applyDouble(x, (double) y);}
//				@Override default AsDouble toDouble() {return this;}
			}
			@FunctionalInterface interface AndLong extends OfBoolean<java.lang.Long> {
				double applyDouble(boolean x, long y);
				@Override default double applyDouble(boolean x, java.lang.Long y) {return applyDouble(x, (long) y);}
			}
			@FunctionalInterface interface AndInt extends OfBoolean<java.lang.Integer> {
				double applyDouble(boolean x, int y);
				@Override default double applyDouble(boolean x, java.lang.Integer y) {return applyDouble(x, (int) y);}
			}
			@FunctionalInterface interface AndFloat extends OfBoolean<java.lang.Float> {
				double applyDouble(boolean x, float y);
				@Override default double applyDouble(boolean x, java.lang.Float y) {return applyDouble(x, (float) y);}
			}
			@FunctionalInterface interface AndChar extends OfBoolean<java.lang.Character> {
				double applyDouble(boolean x, char y);
				@Override default double applyDouble(boolean x, java.lang.Character y) {return applyDouble(x, (char) y);}
			}
			@FunctionalInterface interface AndShort extends OfBoolean<java.lang.Short> {
				double applyDouble(boolean x, short y);
				@Override default double applyDouble(boolean x, java.lang.Short y) {return applyDouble(x, (short) y);}
			}
			@FunctionalInterface interface AndByte extends OfBoolean<java.lang.Byte> {
				double applyDouble(boolean x, byte y);
				@Override default double applyDouble(boolean x, java.lang.Byte y) {return applyDouble(x, (byte) y);}
			}
			@FunctionalInterface interface AndBoolean extends OfBoolean<java.lang.Boolean> {
				double applyDouble(boolean x, boolean y);
				@Override default double applyDouble(boolean x, java.lang.Boolean y) {return applyDouble(x, (boolean) y);}
			}
		}
	}

	// Casting methods
	
	// Function compositions
	@Override default <R> PrimitiveBiFunction<R, AND, OF> andThen(Function<? super TO, ? extends R> after) {return (OF of, AND and) -> after.apply(apply(of, and));}
	default ToDouble<AND, OF> andThenDouble(PrimitiveFunction.ToDouble<? super TO> after) throws AbstractMethodError {throw new AbstractMethodError();}
	default ToLong<AND, OF> andThenLong(PrimitiveFunction.ToLong<? super TO> after) throws AbstractMethodError {throw new AbstractMethodError();}
	default ToInt<AND, OF> andThenInt(PrimitiveFunction.ToInt<? super TO> after) throws AbstractMethodError {throw new AbstractMethodError();}
	default ToFloat<AND, OF> andThenFloat(PrimitiveFunction.ToFloat<? super TO> after) throws AbstractMethodError {throw new AbstractMethodError();}
	default ToChar<AND, OF> andThenChar(PrimitiveFunction.ToChar<? super TO> after) throws AbstractMethodError {throw new AbstractMethodError();}
	default ToShort<AND, OF> andThenShort(PrimitiveFunction.ToShort<? super TO> after) throws AbstractMethodError {throw new AbstractMethodError();}
	default ToByte<AND, OF> andThenByte(PrimitiveFunction.ToByte<? super TO> after) throws AbstractMethodError {throw new AbstractMethodError();}
	default ToBoolean<AND, OF> andThenBoolean(PrimitiveFunction.ToBoolean<? super TO> after) throws AbstractMethodError {throw new AbstractMethodError();}
}
