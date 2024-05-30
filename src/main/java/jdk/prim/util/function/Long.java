/**
 * 
 */
package jdk.prim.util.function;

import java.util.Objects;
import java.util.function.BinaryOperator;
import java.util.function.DoubleToLongFunction;
import java.util.function.IntToLongFunction;
import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;
import java.util.function.LongPredicate;
import java.util.function.LongSupplier;
import java.util.function.LongUnaryOperator;
import java.util.function.ToLongBiFunction;
import java.util.function.ToLongFunction;
import java.util.function.UnaryOperator;

/**
 * 
 */
public final class Long {
	@FunctionalInterface
	public static interface BiFunction<T, U> extends java.util.function.BiFunction<T, U, java.lang.Long>, ToLongBiFunction<T, U> {

		@FunctionalInterface
		interface AndDouble<T> extends BiFunction<T, java.lang.Double> {
			long applyDouble(T x, double y);

			@Override
			default long applyObj(T x, java.lang.Double y) {
				return applyDouble(x, y);
			}
		}

		@FunctionalInterface
		interface AndLong<T> extends BiFunction<T, java.lang.Long> {
			long applyLong(T x, long y);

			@Override
			default long applyObj(T x, java.lang.Long y) {
				return applyLong(x, y);
			}
		}

		@FunctionalInterface
		interface AndInt<T> extends BiFunction<T, java.lang.Integer> {
			long applyInt(T x, int y);

			@Override
			default long applyObj(T x, java.lang.Integer y) {
				return applyInt(x, y);
			}
		}

		@FunctionalInterface
		interface AndFloat<T> extends BiFunction<T, java.lang.Float> {
			long applyFloat(T x, float y);

			@Override
			default long applyObj(T x, java.lang.Float y) {
				return applyFloat(x, y);
			}
		}

		@FunctionalInterface
		interface AndChar<T> extends BiFunction<T, java.lang.Character> {
			long applyChar(T x, char y);

			@Override
			default long applyObj(T x, java.lang.Character y) {
				return applyChar(x, y);
			}
		}

		@FunctionalInterface
		interface AndShort<T> extends BiFunction<T, java.lang.Short> {
			long applyShort(T x, short y);

			@Override
			default long applyObj(T x, java.lang.Short y) {
				return applyShort(x, y);
			}
		}

		@FunctionalInterface
		interface AndByte<T> extends BiFunction<T, java.lang.Byte> {
			long applyByte(T x, byte y);

			@Override
			default long applyObj(T x, java.lang.Byte y) {
				return applyByte(x, y);
			}
		}

		@FunctionalInterface
		interface AndBoolean<T> extends BiFunction<T, java.lang.Boolean> {
			long applyBoolean(T x, boolean y);

			@Override
			default long applyObj(T x, java.lang.Boolean y) {
				return applyBoolean(x, y);
			}
		}

		@FunctionalInterface
		interface OfDouble<T> extends BiFunction<java.lang.Double, T> {

			@FunctionalInterface
			interface AndDouble extends OfDouble<java.lang.Double> {

				long applyDouble(double x, double y);

				@Override
				default long applyDouble(double x, java.lang.Double y) {
					return applyDouble(x, (double) y);
				}
			}

			@FunctionalInterface
			interface AndLong extends OfDouble<java.lang.Long> {

				long applyLong(double x, long y);

				@Override
				default long applyDouble(double x, java.lang.Long y) {
					return applyLong(x, y);
				}
			}

			@FunctionalInterface
			interface AndFloat extends OfDouble<java.lang.Float> {

				long applyFloat(double x, float y);

				@Override
				default long applyDouble(double x, java.lang.Float y) {
					return applyFloat(x, y);
				}
			}

			@FunctionalInterface
			interface AndChar extends OfDouble<Character> {

				long applyChar(double x, char y);

				@Override
				default long applyDouble(double x, Character y) {
					return applyChar(x, y);
				}
			}

			@FunctionalInterface
			interface AndInt extends OfDouble<java.lang.Integer> {
				long applyInt(double x, int y);

				@Override
				default long applyDouble(double x, java.lang.Integer y) {
					return applyInt(x, y);
				}
			}

			@FunctionalInterface
			interface AndShort extends OfDouble<java.lang.Short> {

				long applyShort(double x, short y);

				@Override
				default long applyDouble(double x, java.lang.Short y) {
					return applyShort(x, y);
				}
			}

			@FunctionalInterface
			interface AndByte extends OfDouble<java.lang.Byte> {

				long applyByte(double x, byte y);

				@Override
				default long applyDouble(double x, java.lang.Byte y) {
					return applyByte(x, y);
				}
			}

			@FunctionalInterface
			interface AndBoolean extends OfDouble<java.lang.Boolean> {

				long applyBoolean(double x, boolean y);

				@Override
				default long applyDouble(double x, java.lang.Boolean y) {
					return applyBoolean(x, y);
				}
			}

			long applyDouble(double x, T y);

			@Override
			default long applyObj(java.lang.Double x, T y) {
				return applyDouble(x, y);
			}
		}

		@FunctionalInterface
		interface OfLong<T> extends BiFunction<java.lang.Long, T> {

			@FunctionalInterface
			interface AndDouble extends OfLong<java.lang.Double> {

				long applyDouble(long x, double y);

				@Override
				default long applyLong(long x, java.lang.Double y) {
					return applyDouble(x, y);
				}
			}

			@FunctionalInterface
			interface AndLong extends OfLong<java.lang.Long>, LongBinaryOperator, BinaryOperator<java.lang.Long> {

				long applyLong(long x, long y);

				/**
				 * {@inheritDoc}
				 * @param left {@inheritDoc}
				 * @param right {@inheritDoc}
				 * @return {@inheritDoc}
				 */
				@Override default long applyAsLong(long left, long right) { return applyLong(left, right); }

				@Override
				default long applyLong(long x, java.lang.Long y) {
					return applyLong(x, (long) y);
				}
			}

			@FunctionalInterface
			interface AndFloat extends OfLong<java.lang.Float> {

				long applyFloat(long x, float y);

				@Override
				default long applyLong(long x, java.lang.Float y) {
					return applyFloat(x, y);
				}
			}

			@FunctionalInterface
			interface AndChar extends OfLong<Character> {

				long applyChar(long x, char y);

				@Override
				default long applyLong(long x, Character y) {
					return applyChar(x, y);
				}
			}

			@FunctionalInterface
			interface AndInt extends OfLong<java.lang.Integer> {
				long applyInt(long x, int y);

				@Override
				default long applyLong(long x, java.lang.Integer y) {
					return applyInt(x, y);
				}
			}

			@FunctionalInterface
			interface AndShort extends OfLong<java.lang.Short> {

				long applyShort(long x, short y);

				@Override
				default long applyLong(long x, java.lang.Short y) {
					return applyShort(x, y);
				}
			}

			@FunctionalInterface
			interface AndByte extends OfLong<java.lang.Byte> {

				long applyByte(long x, byte y);

				@Override
				default long applyLong(long x, java.lang.Byte y) {
					return applyByte(x, y);
				}
			}

			@FunctionalInterface
			interface AndBoolean extends OfLong<java.lang.Boolean> {

				long applyBoolean(long x, boolean y);

				@Override
				default long applyLong(long x, java.lang.Boolean y) {
					return applyBoolean(x, y);
				}
			}

			long applyLong(long x, T y);

			@Override
			default long applyObj(java.lang.Long x, T y) {
				return applyLong(x, y);
			}
		}

		@FunctionalInterface
		interface OfInt<T> extends BiFunction<java.lang.Integer, T> {

			@FunctionalInterface
			interface AndDouble extends OfInt<java.lang.Double> {

				long applyDouble(int x, double y);

				@Override
				default long applyInt(int x, java.lang.Double y) {
					return applyDouble(x, y);
				}
			}

			@FunctionalInterface
			interface AndLong extends OfInt<java.lang.Long> {

				long applyLong(int x, long y);

				@Override
				default long applyInt(int x, java.lang.Long y) {
					return applyLong(x, y);
				}
			}

			@FunctionalInterface
			interface AndFloat extends OfInt<java.lang.Float> {

				long applyFloat(int x, float y);

				@Override
				default long applyInt(int x, java.lang.Float y) {
					return applyFloat(x, y);
				}
			}

			@FunctionalInterface
			interface AndChar extends OfInt<Character> {

				long applyChar(int x, char y);

				@Override
				default long applyInt(int x, Character y) {
					return applyChar(x, y);
				}
			}

			@FunctionalInterface
			interface AndInt extends OfInt<java.lang.Integer> {
				long applyInt(int x, int y);

				@Override
				default long applyInt(int x, java.lang.Integer y) {
					return applyInt(x, (int) y);
				}
			}

			@FunctionalInterface
			interface AndShort extends OfInt<java.lang.Short> {

				long applyShort(int x, short y);

				@Override
				default long applyInt(int x, java.lang.Short y) {
					return applyShort(x, y);
				}
			}

			@FunctionalInterface
			interface AndByte extends OfInt<java.lang.Byte> {

				long applyByte(int x, byte y);

				@Override
				default long applyInt(int x, java.lang.Byte y) {
					return applyByte(x, y);
				}
			}

			@FunctionalInterface
			interface AndBoolean extends OfInt<java.lang.Boolean> {

				long applyBoolean(int x, boolean y);

				@Override
				default long applyInt(int x, java.lang.Boolean y) {
					return applyBoolean(x, y);
				}
			}

			long applyInt(int x, T y);

			@Override
			default long applyObj(java.lang.Integer x, T y) {
				return applyInt(x, y);
			}
		}

		@FunctionalInterface
		interface OfFloat<T> extends BiFunction<java.lang.Float, T> {

			@FunctionalInterface
			interface AndDouble extends OfFloat<java.lang.Double> {

				long applyDouble(float x, double y);

				@Override
				default long applyFloat(float x, java.lang.Double y) {
					return applyDouble(x, y);
				}
			}

			@FunctionalInterface
			interface AndLong extends OfFloat<java.lang.Long> {

				long applyLong(float x, long y);

				@Override
				default long applyFloat(float x, java.lang.Long y) {
					return applyLong(x, y);
				}
			}

			@FunctionalInterface
			interface AndFloat extends OfFloat<java.lang.Float> {

				long applyFloat(float x, float y);

				@Override
				default long applyFloat(float x, java.lang.Float y) {
					return applyFloat(x, (float) y);
				}
			}

			@FunctionalInterface
			interface AndChar extends OfFloat<Character> {

				long applyChar(float x, char y);

				@Override
				default long applyFloat(float x, Character y) {
					return applyChar(x, y);
				}
			}

			@FunctionalInterface
			interface AndInt extends OfFloat<java.lang.Integer> {
				long applyInt(float x, int y);

				@Override
				default long applyFloat(float x, java.lang.Integer y) {
					return applyInt(x, (int) y);
				}
			}

			@FunctionalInterface
			interface AndShort extends OfFloat<java.lang.Short> {

				long applyShort(float x, short y);

				@Override
				default long applyFloat(float x, java.lang.Short y) {
					return applyShort(x, y);
				}
			}

			@FunctionalInterface
			interface AndByte extends OfFloat<java.lang.Byte> {

				long applyByte(float x, byte y);

				@Override
				default long applyFloat(float x, java.lang.Byte y) {
					return applyByte(x, y);
				}
			}

			@FunctionalInterface
			interface AndBoolean extends OfFloat<java.lang.Boolean> {

				long applyBoolean(float x, boolean y);

				@Override
				default long applyFloat(float x, java.lang.Boolean y) {
					return applyBoolean(x, y);
				}
			}

			long applyFloat(float x, T y);

			@Override
			default long applyObj(java.lang.Float x, T y) {
				return applyFloat(x, y);
			}
		}

		@FunctionalInterface
		interface OfChar<T> extends BiFunction<java.lang.Character, T> {

			@FunctionalInterface
			interface AndDouble extends OfChar<java.lang.Double> {

				long applyDouble(char x, double y);

				@Override
				default long applyChar(char x, java.lang.Double y) {
					return applyDouble(x, y);
				}
			}

			@FunctionalInterface
			interface AndLong extends OfChar<java.lang.Long> {

				long applyLong(char x, long y);

				@Override
				default long applyChar(char x, java.lang.Long y) {
					return applyLong(x, y);
				}
			}

			@FunctionalInterface
			interface AndFloat extends OfChar<java.lang.Float> {

				long applyFloat(char x, float y);

				@Override
				default long applyChar(char x, java.lang.Float y) {
					return applyFloat(x, y);
				}
			}

			@FunctionalInterface
			interface AndChar extends OfChar<Character> {

				long applyChar(char x, char y);

				@Override
				default long applyChar(char x, Character y) {
					return applyChar(x, (char) y);
				}
			}

			@FunctionalInterface
			interface AndInt extends OfChar<java.lang.Integer> {
				long applyInt(char x, int y);

				@Override
				default long applyChar(char x, java.lang.Integer y) {
					return applyInt(x, (int) y);
				}
			}

			@FunctionalInterface
			interface AndShort extends OfChar<java.lang.Short> {

				long applyShort(char x, short y);

				@Override
				default long applyChar(char x, java.lang.Short y) {
					return applyShort(x, y);
				}
			}

			@FunctionalInterface
			interface AndByte extends OfChar<java.lang.Byte> {

				long applyByte(char x, byte y);

				@Override
				default long applyChar(char x, java.lang.Byte y) {
					return applyByte(x, y);
				}
			}

			@FunctionalInterface
			interface AndBoolean extends OfChar<java.lang.Boolean> {

				long applyBoolean(char x, boolean y);

				@Override
				default long applyChar(char x, java.lang.Boolean y) {
					return applyBoolean(x, y);
				}
			}

			long applyChar(char x, T y);

			@Override
			default long applyObj(java.lang.Character x, T y) {
				return applyChar(x, y);
			}
		}

		@FunctionalInterface
		interface OfShort<T> extends BiFunction<java.lang.Short, T> {

			@FunctionalInterface
			interface AndDouble extends OfShort<java.lang.Double> {

				long applyDouble(short x, double y);

				@Override
				default long applyShort(short x, java.lang.Double y) {
					return applyDouble(x, y);
				}
			}

			@FunctionalInterface
			interface AndLong extends OfShort<java.lang.Long> {

				long applyLong(short x, long y);

				@Override
				default long applyShort(short x, java.lang.Long y) {
					return applyLong(x, y);
				}
			}

			@FunctionalInterface
			interface AndFloat extends OfShort<java.lang.Float> {

				long applyFloat(short x, float y);

				@Override
				default long applyShort(short x, java.lang.Float y) {
					return applyFloat(x, y);
				}
			}

			@FunctionalInterface
			interface AndChar extends OfShort<Character> {

				long applyChar(short x, char y);

				@Override
				default long applyShort(short x, Character y) {
					return applyChar(x, y);
				}
			}

			@FunctionalInterface
			interface AndInt extends OfShort<java.lang.Integer> {
				long applyInt(short x, int y);

				@Override
				default long applyShort(short x, java.lang.Integer y) {
					return applyInt(x, y);
				}
			}

			@FunctionalInterface
			interface AndShort extends OfShort<java.lang.Short> {

				long applyShort(short x, short y);

				@Override
				default long applyShort(short x, java.lang.Short y) {
					return applyShort(x, (short) y);
				}
			}

			@FunctionalInterface
			interface AndByte extends OfShort<java.lang.Byte> {

				long applyByte(short x, byte y);

				@Override
				default long applyShort(short x, java.lang.Byte y) {
					return applyByte(x, y);
				}
			}

			@FunctionalInterface
			interface AndBoolean extends OfShort<java.lang.Boolean> {

				long applyBoolean(short x, boolean y);

				@Override
				default long applyShort(short x, java.lang.Boolean y) {
					return applyBoolean(x, y);
				}
			}

			long applyShort(short x, T y);

			@Override
			default long applyObj(java.lang.Short x, T y) {
				return applyShort(x, y);
			}
		}

		@FunctionalInterface
		interface OfByte<T> extends BiFunction<java.lang.Byte, T> {

			@FunctionalInterface
			interface AndDouble extends OfByte<java.lang.Double> {

				long applyDouble(byte x, double y);

				@Override
				default long applyByte(byte x, java.lang.Double y) {
					return applyDouble(x, y);
				}
			}

			@FunctionalInterface
			interface AndLong extends OfByte<java.lang.Long> {

				long applyLong(byte x, long y);

				@Override
				default long applyByte(byte x, java.lang.Long y) {
					return applyLong(x, y);
				}
			}

			@FunctionalInterface
			interface AndFloat extends OfByte<java.lang.Float> {

				long applyFloat(byte x, float y);

				@Override
				default long applyByte(byte x, java.lang.Float y) {
					return applyFloat(x, y);
				}
			}

			@FunctionalInterface
			interface AndChar extends OfByte<Character> {

				long applyChar(byte x, char y);

				@Override
				default long applyByte(byte x, Character y) {
					return applyChar(x, y);
				}
			}

			@FunctionalInterface
			interface AndInt extends OfByte<java.lang.Integer> {
				long applyInt(byte x, int y);

				@Override
				default long applyByte(byte x, java.lang.Integer y) {
					return applyInt(x, y);
				}
			}

			@FunctionalInterface
			interface AndShort extends OfByte<java.lang.Short> {

				long applyShort(byte x, short y);

				@Override
				default long applyByte(byte x, java.lang.Short y) {
					return applyShort(x, y);
				}
			}

			@FunctionalInterface
			interface AndByte extends OfByte<java.lang.Byte> {

				long applyByte(byte x, byte y);

				@Override
				default long applyByte(byte x, java.lang.Byte y) {
					return applyByte(x, (byte) y);
				}
			}

			@FunctionalInterface
			interface AndBoolean extends OfByte<java.lang.Boolean> {

				long applyBoolean(byte x, boolean y);

				@Override
				default long applyByte(byte x, java.lang.Boolean y) {
					return applyBoolean(x, y);
				}
			}

			long applyByte(byte x, T y);

			@Override
			default long applyObj(java.lang.Byte x, T y) {
				return applyByte(x, y);
			}
		}

		@FunctionalInterface
		interface OfBoolean<T> extends BiFunction<java.lang.Boolean, T> {

			@FunctionalInterface
			interface AndDouble extends OfBoolean<java.lang.Double> {

				long applyDouble(boolean x, double y);

				@Override
				default long applyBoolean(boolean x, java.lang.Double y) {
					return applyDouble(x, y);
				}
			}

			@FunctionalInterface
			interface AndLong extends OfBoolean<java.lang.Long> {

				long applyLong(boolean x, long y);

				@Override
				default long applyBoolean(boolean x, java.lang.Long y) {
					return applyLong(x, y);
				}
			}

			@FunctionalInterface
			interface AndFloat extends OfBoolean<java.lang.Float> {

				long applyFloat(boolean x, float y);

				@Override
				default long applyBoolean(boolean x, java.lang.Float y) {
					return applyFloat(x, y);
				}
			}

			@FunctionalInterface
			interface AndChar extends OfBoolean<Character> {

				long applyChar(boolean x, char y);

				@Override
				default long applyBoolean(boolean x, Character y) {
					return applyChar(x, y);
				}
			}

			@FunctionalInterface
			interface AndInt extends OfBoolean<java.lang.Integer> {
				long applyInt(boolean x, int y);

				@Override
				default long applyBoolean(boolean x, java.lang.Integer y) {
					return applyInt(x, y);
				}
			}

			@FunctionalInterface
			interface AndShort extends OfBoolean<java.lang.Short> {

				long applyShort(boolean x, short y);

				@Override
				default long applyBoolean(boolean x, java.lang.Short y) {
					return applyShort(x, y);
				}
			}

			@FunctionalInterface
			interface AndByte extends OfBoolean<java.lang.Byte> {

				long applyByte(boolean x, byte y);

				@Override
				default long applyBoolean(boolean x, java.lang.Byte y) {
					return applyByte(x, y);
				}
			}

			@FunctionalInterface
			interface AndBoolean extends OfBoolean<java.lang.Boolean> {

				long applyBoolean(boolean x, boolean y);

				@Override
				default long applyBoolean(boolean x, java.lang.Boolean y) {
					return applyBoolean(x, (boolean) y);
				}
			}

			long applyBoolean(boolean x, T y);

			@Override
			default long applyObj(java.lang.Boolean x, T y) {
				return applyBoolean(x, y);
			}
		}

		long applyObj(T x, U y);

		/**
		 * {@inheritDoc}
		 * @param t {@inheritDoc}
		 * @param u {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		@Override default long applyAsLong(T t, U u) { return applyObj(t, u); }

		@Override
		default java.lang.Long apply(T x, U y) {
			return applyObj(x, y);
		}
	}

	@FunctionalInterface
	public static interface Function<T> extends java.util.function.Function<T, java.lang.Long>, ToLongFunction<T> {
		@FunctionalInterface
		interface OfDouble extends Function<java.lang.Double>, DoubleToLongFunction {
			long applyDouble(double x);
			
			/*
			 * Date created: 28 May 2024
			 * Time created: 09:21:03
			 */
			/**
			 * {@inheritDoc}
			 * @param value {@inheritDoc}
			 * @return {@inheritDoc}
			 */
			@Override
			default long applyAsLong(double value) {
				return applyDouble(value);
			}

			@Override
			default long applyObj(java.lang.Double x) {
				return applyDouble(x);
			}
		}

		@FunctionalInterface
		interface OfLong extends Function<java.lang.Long>, LongUnaryOperator, UnaryOperator<java.lang.Long> {
			long applyLong(long x);

			@Override
			default long applyObj(java.lang.Long x) {
				return applyLong(x);
			}
			
			/*
			 * Date created: 28 May 2024
			 * Time created: 10:12:41
			 */
			/**
			 * {@inheritDoc}
			 * @param value {@inheritDoc}
			 * @return {@inheritDoc}
			 */
			@Override
			default long applyAsLong(long value) {
				return applyLong(value);
			}
			
			/*
			 * Date created: 28 May 2024
			 * Time created: 09:11:46
			 */
			/**
			 * {@inheritDoc}
			 * @param before {@inheritDoc}
			 * @return {@inheritDoc}
			 */
			@Override
			default OfLong compose(LongUnaryOperator before) {
				return t -> applyLong(before.applyAsLong(t));
			}
			/*
			 * Date created: 28 May 2024
			 * Time created: 09:02:15
			 */
			/**
			 * {@inheritDoc}
			 * @param after {@inheritDoc}
			 * @return {@inheritDoc}
			 */
			@Override
			default OfLong andThen(LongUnaryOperator after) {
				return t -> after.applyAsLong(applyLong(t));
			}
			/**
		     * Returns a unary operator that always returns its input argument.
		     *
		     * @return a unary operator that always returns its input argument
		     */
			static OfLong identity() {
				return t -> t;
			}
		}

		@FunctionalInterface
		interface OfFloat extends Function<java.lang.Float> {
			long applyFloat(float x);

			@Override
			default long applyObj(java.lang.Float x) {
				return applyFloat(x);
			}
		}

		@FunctionalInterface
		interface OfInt extends Function<java.lang.Integer>, IntToLongFunction {
			long applyInt(int x);
			
			/*
			 * Date created: 28 May 2024
			 * Time created: 09:23:43
			 */
			/**
			 * {@inheritDoc}
			 * @param value {@inheritDoc}
			 * @return {@inheritDoc}
			 */
			@Override default long applyAsLong(int value) { return applyInt(value); }

			@Override
			default long applyObj(java.lang.Integer x) {
				return applyInt(x);
			}
		}

		@FunctionalInterface
		interface OfChar extends Function<Character> {
			long applyChar(char x);

			@Override
			default long applyObj(Character x) {
				return applyChar(x);
			}
		}

		@FunctionalInterface
		interface OfShort extends Function<java.lang.Short> {
			long applyShort(short x);

			@Override
			default long applyObj(java.lang.Short x) {
				return applyShort(x);
			}
		}

		@FunctionalInterface
		interface OfByte extends Function<java.lang.Byte> {
			long applyByte(byte x);

			@Override
			default long applyObj(java.lang.Byte x) {
				return applyByte(x);
			}
		}

		@FunctionalInterface
		interface OfBoolean extends Function<java.lang.Boolean> {
			long applyBoolean(boolean x);

			@Override
			default long applyObj(java.lang.Boolean x) {
				return applyBoolean(x);
			}
		}

		long applyObj(T x);
		
		/*
		 * Date created: 28 May 2024
		 * Time created: 09:25:48
		 */
		/**
		 * {@inheritDoc}
		 * @param value {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		@Override default long applyAsLong(T value) { return applyObj(value); }

		@Override
		default java.lang.Long apply(T x) {
			return applyObj(x);
		}
	}

	/**
	 * Utility class that defines an interface that complements
	 * {@code java.util.function.Supplier} so that an {@code int} can be used as the
	 * argument.
	 */
	@FunctionalInterface
	public static interface Supplier extends java.util.function.Supplier<java.lang.Long>, LongSupplier {
		/*
		 * Date created: 17 May 2024 Time created: 11:06:46
		 */
		/**
		 * Gets an {@code int} result.
		 *
		 * @return an {@code int} result
		 */
		long getLong();
		
		/*
		 * Date created: 28 May 2024
		 * Time created: 08:40:06
		 */
		/**
		 * {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		@Override
		default long getAsLong() {
			return getLong();
		}


		/*
		 * Date created: 17 May 2024 Time created: 10:56:01
		 */
		/**
		 * {@inheritDoc}
		 * 
		 * @return {@inheritDoc}
		 */
		@Override
		default java.lang.Long get() {
			return getLong();
		}
	}

	@FunctionalInterface
	public static interface BiConsumer<T> extends java.util.function.BiConsumer<java.lang.Long, T> {

		@FunctionalInterface
		interface AndDouble extends BiConsumer<java.lang.Double> {

			void acceptDouble(long x, double y);

			@Override
			default void acceptObj(long x, java.lang.Double y) {
				acceptDouble(x, y);
			}
		}

		@FunctionalInterface
		interface AndLong extends BiConsumer<java.lang.Long> {

			void acceptLong(long x, long y);

			@Override
			default void acceptObj(long x, java.lang.Long y) {
				acceptLong(x, y);
			}
		}

		@FunctionalInterface
		interface AndInt extends BiConsumer<java.lang.Integer> {

			void acceptInt(long x, int y);

			@Override
			default void acceptObj(long x, java.lang.Integer y) {
				acceptInt(x, y);
			}
		}

		@FunctionalInterface
		interface AndFloat extends BiConsumer<java.lang.Float> {

			void acceptFloat(long x, float y);

			@Override
			default void acceptObj(long x, java.lang.Float y) {
				acceptFloat(x, y);
			}
		}

		@FunctionalInterface
		interface AndChar extends BiConsumer<Character> {

			void acceptChar(long x, char y);

			@Override
			default void acceptObj(long x, Character y) {
				acceptChar(x, y);
			}
		}

		@FunctionalInterface
		interface AndShort extends BiConsumer<java.lang.Short> {

			void acceptShort(long x, short y);

			@Override
			default void acceptObj(long x, java.lang.Short y) {
				acceptShort(x, y);
			}
		}

		@FunctionalInterface
		interface AndByte extends BiConsumer<java.lang.Byte> {

			void acceptByte(long x, byte y);

			@Override
			default void acceptObj(long x, java.lang.Byte y) {
				acceptByte(x, y);
			}
		}

		@FunctionalInterface
		interface AndBoolean extends BiConsumer<java.lang.Boolean> {

			void acceptBoolean(long x, boolean y);

			@Override
			default void acceptObj(long x, java.lang.Boolean y) {
				acceptBoolean(x, y);
			}
		}

		void acceptObj(long x, T y);

		@Override
		default void accept(java.lang.Long x, T y) {
			acceptObj(x, y);
		}
	}

	/**
	 * Utility class that defines an interface that complements
	 * {@code java.util.function.Consumer} so that an {@code int} can be used as the
	 * argument.
	 */
	@FunctionalInterface
	public static interface Consumer extends java.util.function.Consumer<java.lang.Long>, LongConsumer {
		/**
		 * Performs this operation on the given {@code int} argument.
		 *
		 * @param i the input {@code int} argument
		 */
		void acceptLong(long i);
		
		/*
		 * Date created: 28 May 2024
		 * Time created: 08:33:50
		 */
		/**
		 * {@inheritDoc}
		 * @param value {@inheritDoc}
		 */
		@Override
		default void accept(long value) {
			acceptLong(value);
		}

		/*
		 * Date created: 17 May 2024 Time created: 10:56:01
		 */
		/**
		 * {@inheritDoc}
		 * 
		 * @param i {@inheritDoc}
		 */
		@Override
		default void accept(java.lang.Long i) {
			acceptLong(i);
		}

		/**
		 * Returns a composed {@code Consumer} that performs, in sequence, this
		 * operation followed by the {@code after} operation. If performing either
		 * operation throws an exception, it is relayed to the caller of the composed
		 * operation. If performing this operation throws an exception, the
		 * {@code after} operation will not be performed.
		 *
		 * @param after the operation to perform after this operation
		 * @return a composed {@code Consumer} that performs in sequence this operation
		 *         followed by the {@code after} operation
		 * @throws NullPointerException if {@code after} is null
		 */
		default Consumer andThenLong(Consumer after) {
			Objects.requireNonNull(after);
			return x -> {
				acceptLong(x);
				after.acceptLong(x);
			};
		}
		/*
		 * Date created: 28 May 2024
		 * Time created: 10:49:51
		 */
		/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		@Override default Consumer andThen(java.util.function.Consumer<? super java.lang.Long> after) {
			if(after instanceof Consumer) return andThenLong((Consumer) after);
			Objects.requireNonNull(after);
			return x -> {
				acceptLong(x);
				after.accept(x);
			};
		}
		/*
		 * Date created: 28 May 2024
		 * Time created: 10:50:09
		 */
		/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		@Override default Consumer andThen(LongConsumer after) {
			if(after instanceof Consumer) return andThenLong(after::accept);
			Objects.requireNonNull(after);
			return x -> {
				acceptLong(x);
				after.accept(x);
			};
		}
	}

	@FunctionalInterface
	public static interface BiPredicate<T> extends java.util.function.BiPredicate<java.lang.Long, T> {

		@FunctionalInterface
		interface AndDouble extends BiPredicate<java.lang.Double> {

			boolean testDouble(long x, double y);

			@Override
			default boolean testObj(long x, java.lang.Double y) {
				return testDouble(x, y);
			}
		}

		@FunctionalInterface
		interface AndLong extends BiPredicate<java.lang.Long> {

			boolean testLong(long x, long y);

			@Override
			default boolean testObj(long x, java.lang.Long y) {
				return testLong(x, y);
			}
		}

		@FunctionalInterface
		interface AndInt extends BiPredicate<java.lang.Integer> {

			boolean testInt(long x, int y);

			@Override
			default boolean testObj(long x, java.lang.Integer y) {
				return testInt(x, y);
			}
		}

		@FunctionalInterface
		interface AndFloat extends BiPredicate<java.lang.Float> {

			boolean testFloat(long x, float y);

			@Override
			default boolean testObj(long x, java.lang.Float y) {
				return testFloat(x, y);
			}
		}

		@FunctionalInterface
		interface AndChar extends BiPredicate<Character> {

			boolean testChar(long x, char y);

			@Override
			default boolean testObj(long x, Character y) {
				return testChar(x, y);
			}
		}

		@FunctionalInterface
		interface AndShort extends BiPredicate<java.lang.Short> {

			boolean testShort(long x, short y);

			@Override
			default boolean testObj(long x, java.lang.Short y) {
				return testShort(x, y);
			}
		}

		@FunctionalInterface
		interface AndByte extends BiPredicate<java.lang.Byte> {

			boolean testByte(long x, byte y);

			@Override
			default boolean testObj(long x, java.lang.Byte y) {
				return testByte(x, y);
			}
		}

		@FunctionalInterface
		interface AndBoolean extends BiPredicate<java.lang.Boolean> {

			boolean testBoolean(long x, boolean y);

			@Override
			default boolean testObj(long x, java.lang.Boolean y) {
				return testBoolean(x, y);
			}
		}

		boolean testObj(long x, T y);

		@Override
		default boolean test(java.lang.Long x, T y) {
			return testObj(x, y);
		}
	}

	/**
	 * Interface that extends {@code java.util.function.Predicate} so that an
	 * {@code int} can be used as the argument.
	 */
	@FunctionalInterface
	public static interface Predicate extends java.util.function.Predicate<java.lang.Long>, LongPredicate {
		/**
		 * Evaluates this predicate on the given {@code int} argument.
		 *
		 * @param i the {@code int} input argument
		 * @return {@code true} if the input argument matches the predicate, otherwise
		 *         {@code false}
		 */
		boolean testLong(long i);
		
		/*
		 * Date created: 28 May 2024
		 * Time created: 08:38:45
		 */
		/**
		 * {@inheritDoc}
		 * @param value {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		@Override
		default boolean test(long value) {
			return testLong(value);
		}

		/*
		 * Date created: 17 May 2024 Time created: 10:56:01
		 */
		/**
		 * {@inheritDoc}
		 * 
		 * @param t {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		@Override
		default boolean test(java.lang.Long t) {
			return testLong(t);
		}

		default Predicate andLong(Predicate other) {
			Objects.requireNonNull(other);
			return x -> testLong(x) && other.testLong(x);
		}
		
		/*
		 * Date created: 28 May 2024
		 * Time created: 10:55:57
		 */
		/**
		 * {@inheritDoc}
		 * @param other {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		@Override
		default Predicate and(
				java.util.function.Predicate<? super java.lang.Long> other) {
			if(other instanceof Predicate) return andLong((Predicate) other);
			return andLong(other::test);
		}
		
		/*
		 * Date created: 28 May 2024
		 * Time created: 10:55:57
		 */
		/**
		 * {@inheritDoc}
		 * @param other {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		@Override
		default Predicate and(
				LongPredicate other) {
			Objects.requireNonNull(other);
			return x -> testLong(x) && other.test(x);
		}
		
		/*
		 * Date created: 28 May 2024
		 * Time created: 08:37:57
		 */
		/**
		 * {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		@Override
		default Predicate negate() {
			return t -> !testLong(t);
		}

		default Predicate negateLong() {
			return x -> !testLong(x);
		}

		default Predicate orLong(Predicate other) {
			Objects.requireNonNull(other);
			return x -> testLong(x) || other.testLong(x);
		}
		
		/*
		 * Date created: 28 May 2024
		 * Time created: 10:55:57
		 */
		/**
		 * {@inheritDoc}
		 * @param other {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		@Override
		default Predicate or(
				java.util.function.Predicate<? super java.lang.Long> other) {
			if(other instanceof Predicate) return orLong((Predicate) other);
			return orLong(other::test);
		}
		
		/*
		 * Date created: 28 May 2024
		 * Time created: 10:55:57
		 */
		/**
		 * {@inheritDoc}
		 * @param other {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		@Override
		default Predicate or(
				LongPredicate other) {
			Objects.requireNonNull(other);
			return x -> testLong(x) || other.test(x);
		}
	}

	// Private constructor to prevent instantiation
	private Long() {
	}
}
