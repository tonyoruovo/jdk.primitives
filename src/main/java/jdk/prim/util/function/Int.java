package jdk.prim.util.function;

import java.util.Objects;
import java.util.function.BinaryOperator;
import java.util.function.DoubleToIntFunction;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.IntUnaryOperator;
import java.util.function.LongToIntFunction;
import java.util.function.ToIntBiFunction;
import java.util.function.ToIntFunction;
import java.util.function.UnaryOperator;

/**
 * This class provides utility interfaces that complement
 * {@code java.util.function} for primitive types with {@code int} return types.
 */
public final class Int {
	@FunctionalInterface
	public static interface BiFunction<T, U> extends java.util.function.BiFunction<T, U, Integer>, ToIntBiFunction<T, U> {

		@FunctionalInterface
		interface AndDouble<T> extends BiFunction<T, java.lang.Double> {
			int applyDouble(T x, double y);

			@Override
			default int applyObj(T x, java.lang.Double y) {
				return applyDouble(x, y);
			}
		}

		@FunctionalInterface
		interface AndLong<T> extends BiFunction<T, java.lang.Long> {
			int applyLong(T x, long y);

			@Override
			default int applyObj(T x, java.lang.Long y) {
				return applyLong(x, y);
			}
		}

		@FunctionalInterface
		interface AndInt<T> extends BiFunction<T, java.lang.Integer> {
			int applyInt(T x, int y);

			@Override
			default int applyObj(T x, java.lang.Integer y) {
				return applyInt(x, y);
			}
		}

		@FunctionalInterface
		interface AndFloat<T> extends BiFunction<T, java.lang.Float> {
			int applyFloat(T x, float y);

			@Override
			default int applyObj(T x, java.lang.Float y) {
				return applyFloat(x, y);
			}
		}

		@FunctionalInterface
		interface AndChar<T> extends BiFunction<T, java.lang.Character> {
			int applyChar(T x, char y);

			@Override
			default int applyObj(T x, java.lang.Character y) {
				return applyChar(x, y);
			}
		}

		@FunctionalInterface
		interface AndShort<T> extends BiFunction<T, java.lang.Short> {
			int applyShort(T x, short y);

			@Override
			default int applyObj(T x, java.lang.Short y) {
				return applyShort(x, y);
			}
		}

		@FunctionalInterface
		interface AndByte<T> extends BiFunction<T, java.lang.Byte> {
			int applyByte(T x, byte y);

			@Override
			default int applyObj(T x, java.lang.Byte y) {
				return applyByte(x, y);
			}
		}

		@FunctionalInterface
		interface AndBoolean<T> extends BiFunction<T, java.lang.Boolean> {
			int applyBoolean(T x, boolean y);

			@Override
			default int applyObj(T x, java.lang.Boolean y) {
				return applyBoolean(x, y);
			}
		}

		@FunctionalInterface
		interface OfDouble<T> extends BiFunction<java.lang.Double, T> {

			@FunctionalInterface
			interface AndDouble extends OfDouble<java.lang.Double> {

				int applyDouble(double x, double y);

				@Override
				default int applyDouble(double x, java.lang.Double y) {
					return applyDouble(x, (double) y);
				}
			}

			@FunctionalInterface
			interface AndLong extends OfDouble<java.lang.Long> {

				int applyLong(double x, long y);

				@Override
				default int applyDouble(double x, java.lang.Long y) {
					return applyLong(x, y);
				}
			}

			@FunctionalInterface
			interface AndFloat extends OfDouble<java.lang.Float> {

				int applyFloat(double x, float y);

				@Override
				default int applyDouble(double x, java.lang.Float y) {
					return applyFloat(x, y);
				}
			}

			@FunctionalInterface
			interface AndChar extends OfDouble<Character> {

				int applyChar(double x, char y);

				@Override
				default int applyDouble(double x, Character y) {
					return applyChar(x, y);
				}
			}

			@FunctionalInterface
			interface AndInt extends OfDouble<Integer> {
				int applyInt(double x, int y);

				@Override
				default int applyDouble(double x, Integer y) {
					return applyInt(x, y);
				}
			}

			@FunctionalInterface
			interface AndShort extends OfDouble<java.lang.Short> {

				int applyShort(double x, short y);

				@Override
				default int applyDouble(double x, java.lang.Short y) {
					return applyShort(x, y);
				}
			}

			@FunctionalInterface
			interface AndByte extends OfDouble<java.lang.Byte> {

				int applyByte(double x, byte y);

				@Override
				default int applyDouble(double x, java.lang.Byte y) {
					return applyByte(x, y);
				}
			}

			@FunctionalInterface
			interface AndBoolean extends OfDouble<java.lang.Boolean> {

				int applyBoolean(double x, boolean y);

				@Override
				default int applyDouble(double x, java.lang.Boolean y) {
					return applyBoolean(x, y);
				}
			}

			int applyDouble(double x, T y);

			@Override
			default int applyObj(java.lang.Double x, T y) {
				return applyDouble(x, y);
			}
		}

		@FunctionalInterface
		interface OfLong<T> extends BiFunction<java.lang.Long, T> {

			@FunctionalInterface
			interface AndDouble extends OfLong<java.lang.Double> {

				int applyDouble(long x, double y);

				@Override
				default int applyLong(long x, java.lang.Double y) {
					return applyDouble(x, y);
				}
			}

			@FunctionalInterface
			interface AndLong extends OfLong<java.lang.Long> {

				int applyLong(long x, long y);

				@Override
				default int applyLong(long x, java.lang.Long y) {
					return applyLong(x, (long) y);
				}
			}

			@FunctionalInterface
			interface AndFloat extends OfLong<java.lang.Float> {

				int applyFloat(long x, float y);

				@Override
				default int applyLong(long x, java.lang.Float y) {
					return applyFloat(x, y);
				}
			}

			@FunctionalInterface
			interface AndChar extends OfLong<Character> {

				int applyChar(long x, char y);

				@Override
				default int applyLong(long x, Character y) {
					return applyChar(x, y);
				}
			}

			@FunctionalInterface
			interface AndInt extends OfLong<Integer> {
				int applyInt(long x, int y);

				@Override
				default int applyLong(long x, Integer y) {
					return applyInt(x, y);
				}
			}

			@FunctionalInterface
			interface AndShort extends OfLong<java.lang.Short> {

				int applyShort(long x, short y);

				@Override
				default int applyLong(long x, java.lang.Short y) {
					return applyShort(x, y);
				}
			}

			@FunctionalInterface
			interface AndByte extends OfLong<java.lang.Byte> {

				int applyByte(long x, byte y);

				@Override
				default int applyLong(long x, java.lang.Byte y) {
					return applyByte(x, y);
				}
			}

			@FunctionalInterface
			interface AndBoolean extends OfLong<java.lang.Boolean> {

				int applyBoolean(long x, boolean y);

				@Override
				default int applyLong(long x, java.lang.Boolean y) {
					return applyBoolean(x, y);
				}
			}

			int applyLong(long x, T y);

			@Override
			default int applyObj(java.lang.Long x, T y) {
				return applyLong(x, y);
			}
		}

		@FunctionalInterface
		interface OfInt<T> extends BiFunction<java.lang.Integer, T> {

			@FunctionalInterface
			interface AndDouble extends OfInt<java.lang.Double> {

				int applyDouble(int x, double y);

				@Override
				default int applyInt(int x, java.lang.Double y) {
					return applyDouble(x, y);
				}
			}

			@FunctionalInterface
			interface AndLong extends OfInt<java.lang.Long> {

				int applyLong(int x, long y);

				@Override
				default int applyInt(int x, java.lang.Long y) {
					return applyLong(x, y);
				}
			}

			@FunctionalInterface
			interface AndFloat extends OfInt<java.lang.Float> {

				int applyFloat(int x, float y);

				@Override
				default int applyInt(int x, java.lang.Float y) {
					return applyFloat(x, y);
				}
			}

			@FunctionalInterface
			interface AndChar extends OfInt<Character> {

				int applyChar(int x, char y);

				@Override
				default int applyInt(int x, Character y) {
					return applyChar(x, y);
				}
			}

			@FunctionalInterface
			interface AndInt extends OfInt<Integer>, IntBinaryOperator, BinaryOperator<Integer> {
				int applyInt(int x, int y);

				/**
				 * {@inheritDoc}
				 * @param left {@inheritDoc}
				 * @param right {@inheritDoc}
				 * @return {@inheritDoc}
				 */
				@Override default int applyAsInt(int left, int right) { return applyInt(left, right); }

				@Override
				default int applyInt(int x, Integer y) {
					return applyInt(x, (int) y);
				}
			}

			@FunctionalInterface
			interface AndShort extends OfInt<java.lang.Short> {

				int applyShort(int x, short y);

				@Override
				default int applyInt(int x, java.lang.Short y) {
					return applyShort(x, y);
				}
			}

			@FunctionalInterface
			interface AndByte extends OfInt<java.lang.Byte> {

				int applyByte(int x, byte y);

				@Override
				default int applyInt(int x, java.lang.Byte y) {
					return applyByte(x, y);
				}
			}

			@FunctionalInterface
			interface AndBoolean extends OfInt<java.lang.Boolean> {

				int applyBoolean(int x, boolean y);

				@Override
				default int applyInt(int x, java.lang.Boolean y) {
					return applyBoolean(x, y);
				}
			}

			int applyInt(int x, T y);

			@Override
			default int applyObj(java.lang.Integer x, T y) {
				return applyInt(x, y);
			}
		}

		@FunctionalInterface
		interface OfFloat<T> extends BiFunction<java.lang.Float, T> {

			@FunctionalInterface
			interface AndDouble extends OfFloat<java.lang.Double> {

				int applyDouble(float x, double y);

				@Override
				default int applyFloat(float x, java.lang.Double y) {
					return applyDouble(x, y);
				}
			}

			@FunctionalInterface
			interface AndLong extends OfFloat<java.lang.Long> {

				int applyLong(float x, long y);

				@Override
				default int applyFloat(float x, java.lang.Long y) {
					return applyLong(x, y);
				}
			}

			@FunctionalInterface
			interface AndFloat extends OfFloat<java.lang.Float> {

				int applyFloat(float x, float y);

				@Override
				default int applyFloat(float x, java.lang.Float y) {
					return applyFloat(x, (float) y);
				}
			}

			@FunctionalInterface
			interface AndChar extends OfFloat<Character> {

				int applyChar(float x, char y);

				@Override
				default int applyFloat(float x, Character y) {
					return applyChar(x, y);
				}
			}

			@FunctionalInterface
			interface AndInt extends OfFloat<Integer> {
				int applyInt(float x, int y);

				@Override
				default int applyFloat(float x, Integer y) {
					return applyInt(x, (int) y);
				}
			}

			@FunctionalInterface
			interface AndShort extends OfFloat<java.lang.Short> {

				int applyShort(float x, short y);

				@Override
				default int applyFloat(float x, java.lang.Short y) {
					return applyShort(x, y);
				}
			}

			@FunctionalInterface
			interface AndByte extends OfFloat<java.lang.Byte> {

				int applyByte(float x, byte y);

				@Override
				default int applyFloat(float x, java.lang.Byte y) {
					return applyByte(x, y);
				}
			}

			@FunctionalInterface
			interface AndBoolean extends OfFloat<java.lang.Boolean> {

				int applyBoolean(float x, boolean y);

				@Override
				default int applyFloat(float x, java.lang.Boolean y) {
					return applyBoolean(x, y);
				}
			}

			int applyFloat(float x, T y);

			@Override
			default int applyObj(java.lang.Float x, T y) {
				return applyFloat(x, y);
			}
		}

		@FunctionalInterface
		interface OfChar<T> extends BiFunction<java.lang.Character, T> {

			@FunctionalInterface
			interface AndDouble extends OfChar<java.lang.Double> {

				int applyDouble(char x, double y);

				@Override
				default int applyChar(char x, java.lang.Double y) {
					return applyDouble(x, y);
				}
			}

			@FunctionalInterface
			interface AndLong extends OfChar<java.lang.Long> {

				int applyLong(char x, long y);

				@Override
				default int applyChar(char x, java.lang.Long y) {
					return applyLong(x, y);
				}
			}

			@FunctionalInterface
			interface AndFloat extends OfChar<java.lang.Float> {

				int applyFloat(char x, float y);

				@Override
				default int applyChar(char x, java.lang.Float y) {
					return applyFloat(x, y);
				}
			}

			@FunctionalInterface
			interface AndChar extends OfChar<Character> {

				int applyChar(char x, char y);

				@Override
				default int applyChar(char x, Character y) {
					return applyChar(x, (char) y);
				}
			}

			@FunctionalInterface
			interface AndInt extends OfChar<Integer> {
				int applyInt(char x, int y);

				@Override
				default int applyChar(char x, Integer y) {
					return applyInt(x, (int) y);
				}
			}

			@FunctionalInterface
			interface AndShort extends OfChar<java.lang.Short> {

				int applyShort(char x, short y);

				@Override
				default int applyChar(char x, java.lang.Short y) {
					return applyShort(x, y);
				}
			}

			@FunctionalInterface
			interface AndByte extends OfChar<java.lang.Byte> {

				int applyByte(char x, byte y);

				@Override
				default int applyChar(char x, java.lang.Byte y) {
					return applyByte(x, y);
				}
			}

			@FunctionalInterface
			interface AndBoolean extends OfChar<java.lang.Boolean> {

				int applyBoolean(char x, boolean y);

				@Override
				default int applyChar(char x, java.lang.Boolean y) {
					return applyBoolean(x, y);
				}
			}

			int applyChar(char x, T y);

			@Override
			default int applyObj(java.lang.Character x, T y) {
				return applyChar(x, y);
			}
		}

		@FunctionalInterface
		interface OfShort<T> extends BiFunction<java.lang.Short, T> {

			@FunctionalInterface
			interface AndDouble extends OfShort<java.lang.Double> {

				int applyDouble(short x, double y);

				@Override
				default int applyShort(short x, java.lang.Double y) {
					return applyDouble(x, y);
				}
			}

			@FunctionalInterface
			interface AndLong extends OfShort<java.lang.Long> {

				int applyLong(short x, long y);

				@Override
				default int applyShort(short x, java.lang.Long y) {
					return applyLong(x, y);
				}
			}

			@FunctionalInterface
			interface AndFloat extends OfShort<java.lang.Float> {

				int applyFloat(short x, float y);

				@Override
				default int applyShort(short x, java.lang.Float y) {
					return applyFloat(x, y);
				}
			}

			@FunctionalInterface
			interface AndChar extends OfShort<Character> {

				int applyChar(short x, char y);

				@Override
				default int applyShort(short x, Character y) {
					return applyChar(x, y);
				}
			}

			@FunctionalInterface
			interface AndInt extends OfShort<Integer> {
				int applyInt(short x, int y);

				@Override
				default int applyShort(short x, Integer y) {
					return applyInt(x, y);
				}
			}

			@FunctionalInterface
			interface AndShort extends OfShort<java.lang.Short> {

				int applyShort(short x, short y);

				@Override
				default int applyShort(short x, java.lang.Short y) {
					return applyShort(x, (short) y);
				}
			}

			@FunctionalInterface
			interface AndByte extends OfShort<java.lang.Byte> {

				int applyByte(short x, byte y);

				@Override
				default int applyShort(short x, java.lang.Byte y) {
					return applyByte(x, y);
				}
			}

			@FunctionalInterface
			interface AndBoolean extends OfShort<java.lang.Boolean> {

				int applyBoolean(short x, boolean y);

				@Override
				default int applyShort(short x, java.lang.Boolean y) {
					return applyBoolean(x, y);
				}
			}

			int applyShort(short x, T y);

			@Override
			default int applyObj(java.lang.Short x, T y) {
				return applyShort(x, y);
			}
		}

		@FunctionalInterface
		interface OfByte<T> extends BiFunction<java.lang.Byte, T> {

			@FunctionalInterface
			interface AndDouble extends OfByte<java.lang.Double> {

				int applyDouble(byte x, double y);

				@Override
				default int applyByte(byte x, java.lang.Double y) {
					return applyDouble(x, y);
				}
			}

			@FunctionalInterface
			interface AndLong extends OfByte<java.lang.Long> {

				int applyLong(byte x, long y);

				@Override
				default int applyByte(byte x, java.lang.Long y) {
					return applyLong(x, y);
				}
			}

			@FunctionalInterface
			interface AndFloat extends OfByte<java.lang.Float> {

				int applyFloat(byte x, float y);

				@Override
				default int applyByte(byte x, java.lang.Float y) {
					return applyFloat(x, y);
				}
			}

			@FunctionalInterface
			interface AndChar extends OfByte<Character> {

				int applyChar(byte x, char y);

				@Override
				default int applyByte(byte x, Character y) {
					return applyChar(x, y);
				}
			}

			@FunctionalInterface
			interface AndInt extends OfByte<Integer> {
				int applyInt(byte x, int y);

				@Override
				default int applyByte(byte x, Integer y) {
					return applyInt(x, y);
				}
			}

			@FunctionalInterface
			interface AndShort extends OfByte<java.lang.Short> {

				int applyShort(byte x, short y);

				@Override
				default int applyByte(byte x, java.lang.Short y) {
					return applyShort(x, y);
				}
			}

			@FunctionalInterface
			interface AndByte extends OfByte<java.lang.Byte> {

				int applyByte(byte x, byte y);

				@Override
				default int applyByte(byte x, java.lang.Byte y) {
					return applyByte(x, (byte) y);
				}
			}

			@FunctionalInterface
			interface AndBoolean extends OfByte<java.lang.Boolean> {

				int applyBoolean(byte x, boolean y);

				@Override
				default int applyByte(byte x, java.lang.Boolean y) {
					return applyBoolean(x, y);
				}
			}

			int applyByte(byte x, T y);

			@Override
			default int applyObj(java.lang.Byte x, T y) {
				return applyByte(x, y);
			}
		}

		@FunctionalInterface
		interface OfBoolean<T> extends BiFunction<java.lang.Boolean, T> {

			@FunctionalInterface
			interface AndDouble extends OfBoolean<java.lang.Double> {

				int applyDouble(boolean x, double y);

				@Override
				default int applyBoolean(boolean x, java.lang.Double y) {
					return applyDouble(x, y);
				}
			}

			@FunctionalInterface
			interface AndLong extends OfBoolean<java.lang.Long> {

				int applyLong(boolean x, long y);

				@Override
				default int applyBoolean(boolean x, java.lang.Long y) {
					return applyLong(x, y);
				}
			}

			@FunctionalInterface
			interface AndFloat extends OfBoolean<java.lang.Float> {

				int applyFloat(boolean x, float y);

				@Override
				default int applyBoolean(boolean x, java.lang.Float y) {
					return applyFloat(x, y);
				}
			}

			@FunctionalInterface
			interface AndChar extends OfBoolean<Character> {

				int applyChar(boolean x, char y);

				@Override
				default int applyBoolean(boolean x, Character y) {
					return applyChar(x, y);
				}
			}

			@FunctionalInterface
			interface AndInt extends OfBoolean<Integer> {
				int applyInt(boolean x, int y);

				@Override
				default int applyBoolean(boolean x, Integer y) {
					return applyInt(x, y);
				}
			}

			@FunctionalInterface
			interface AndShort extends OfBoolean<java.lang.Short> {

				int applyShort(boolean x, short y);

				@Override
				default int applyBoolean(boolean x, java.lang.Short y) {
					return applyShort(x, y);
				}
			}

			@FunctionalInterface
			interface AndByte extends OfBoolean<java.lang.Byte> {

				int applyByte(boolean x, byte y);

				@Override
				default int applyBoolean(boolean x, java.lang.Byte y) {
					return applyByte(x, y);
				}
			}

			@FunctionalInterface
			interface AndBoolean extends OfBoolean<java.lang.Boolean> {

				int applyBoolean(boolean x, boolean y);

				@Override
				default int applyBoolean(boolean x, java.lang.Boolean y) {
					return applyBoolean(x, (boolean) y);
				}
			}

			int applyBoolean(boolean x, T y);

			@Override
			default int applyObj(java.lang.Boolean x, T y) {
				return applyBoolean(x, y);
			}
		}

		int applyObj(T x, U y);

		/**
		 * {@inheritDoc}
		 * @param t {@inheritDoc}
		 * @param u {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		@Override default int applyAsInt(T t, U u) { return applyObj(t, u); }

		@Override
		default Integer apply(T x, U y) {
			return applyObj(x, y);
		}
	}

	@FunctionalInterface
	public static interface Function<T> extends java.util.function.Function<T, Integer>, ToIntFunction<T> {
		@FunctionalInterface
		interface OfDouble extends Function<java.lang.Double>, DoubleToIntFunction {
			int applyDouble(double x);
			
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
			default int applyAsInt(double value) {
				return applyDouble(value);
			}

			@Override
			default int applyObj(java.lang.Double x) {
				return applyDouble(x);
			}
		}

		@FunctionalInterface
		interface OfLong extends Function<java.lang.Long>, LongToIntFunction {
			int applyLong(long x);
			
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
			default int applyAsInt(long value) {
				return applyLong(value);
			}

			@Override
			default int applyObj(java.lang.Long x) {
				return applyLong(x);
			}
		}

		@FunctionalInterface
		interface OfFloat extends Function<java.lang.Float> {
			int applyFloat(float x);

			@Override
			default int applyObj(java.lang.Float x) {
				return applyFloat(x);
			}
		}

		@FunctionalInterface
		interface OfInt extends Function<Integer>, IntUnaryOperator, UnaryOperator<Integer> {
			int applyInt(int x);

			@Override
			default int applyObj(Integer x) {
				return applyInt(x);
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
			default int applyAsInt(int value) {
				return applyInt(value);
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
			default OfInt compose(IntUnaryOperator before) {
				return t -> applyInt(before.applyAsInt(t));
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
			default OfInt andThen(IntUnaryOperator after) {
				return t -> after.applyAsInt(applyInt(t));
			}
			/**
		     * Returns a unary operator that always returns its input argument.
		     *
		     * @return a unary operator that always returns its input argument
		     */
			static OfInt identity() {
				return t -> t;
			}
		}

		@FunctionalInterface
		interface OfChar extends Function<Character> {
			int applyChar(char x);

			@Override
			default int applyObj(Character x) {
				return applyChar(x);
			}
		}

		@FunctionalInterface
		interface OfShort extends Function<java.lang.Short> {
			int applyShort(short x);

			@Override
			default int applyObj(java.lang.Short x) {
				return applyShort(x);
			}
		}

		@FunctionalInterface
		interface OfByte extends Function<java.lang.Byte> {
			int applyByte(byte x);

			@Override
			default int applyObj(java.lang.Byte x) {
				return applyByte(x);
			}
		}

		@FunctionalInterface
		interface OfBoolean extends Function<java.lang.Boolean> {
			int applyBoolean(boolean x);

			@Override
			default int applyObj(java.lang.Boolean x) {
				return applyBoolean(x);
			}
		}

		int applyObj(T x);
		
		/*
		 * Date created: 28 May 2024
		 * Time created: 09:25:48
		 */
		/**
		 * {@inheritDoc}
		 * @param value {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		@Override default int applyAsInt(T value) { return applyObj(value); }

		@Override
		default Integer apply(T x) {
			return applyObj(x);
		}
	}

	/**
	 * Utility class that defines an interface that complements
	 * {@code java.util.function.Supplier} so that an {@code int} can be used as the
	 * argument.
	 */
	@FunctionalInterface
	public static interface Supplier extends java.util.function.Supplier<Integer>, IntSupplier {
		/*
		 * Date created: 17 May 2024 Time created: 11:06:46
		 */
		/**
		 * Gets an {@code int} result.
		 *
		 * @return an {@code int} result
		 */
		int getInt();
		
		/*
		 * Date created: 28 May 2024
		 * Time created: 08:40:06
		 */
		/**
		 * {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		@Override
		default int getAsInt() {
			return getInt();
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
		default Integer get() {
			return getInt();
		}
	}

	@FunctionalInterface
	public static interface BiConsumer<T> extends java.util.function.BiConsumer<Integer, T> {

		@FunctionalInterface
		interface AndDouble extends BiConsumer<java.lang.Double> {

			void acceptDouble(int x, double y);

			@Override
			default void acceptObj(int x, java.lang.Double y) {
				acceptDouble(x, y);
			}
		}

		@FunctionalInterface
		interface AndLong extends BiConsumer<java.lang.Long> {

			void acceptLong(int x, long y);

			@Override
			default void acceptObj(int x, java.lang.Long y) {
				acceptLong(x, y);
			}
		}

		@FunctionalInterface
		interface AndInt extends BiConsumer<Integer> {

			void acceptInt(int x, int y);

			@Override
			default void acceptObj(int x, Integer y) {
				acceptInt(x, y);
			}
		}

		@FunctionalInterface
		interface AndFloat extends BiConsumer<java.lang.Float> {

			void acceptFloat(int x, float y);

			@Override
			default void acceptObj(int x, java.lang.Float y) {
				acceptFloat(x, y);
			}
		}

		@FunctionalInterface
		interface AndChar extends BiConsumer<Character> {

			void acceptChar(int x, char y);

			@Override
			default void acceptObj(int x, Character y) {
				acceptChar(x, y);
			}
		}

		@FunctionalInterface
		interface AndShort extends BiConsumer<java.lang.Short> {

			void acceptShort(int x, short y);

			@Override
			default void acceptObj(int x, java.lang.Short y) {
				acceptShort(x, y);
			}
		}

		@FunctionalInterface
		interface AndByte extends BiConsumer<java.lang.Byte> {

			void acceptByte(int x, byte y);

			@Override
			default void acceptObj(int x, java.lang.Byte y) {
				acceptByte(x, y);
			}
		}

		@FunctionalInterface
		interface AndBoolean extends BiConsumer<java.lang.Boolean> {

			void acceptBoolean(int x, boolean y);

			@Override
			default void acceptObj(int x, java.lang.Boolean y) {
				acceptBoolean(x, y);
			}
		}

		void acceptObj(int x, T y);

		@Override
		default void accept(Integer x, T y) {
			acceptObj(x, y);
		}
	}

	/**
	 * Utility class that defines an interface that complements
	 * {@code java.util.function.Consumer} so that an {@code int} can be used as the
	 * argument.
	 */
	@FunctionalInterface
	public static interface Consumer extends java.util.function.Consumer<Integer>, IntConsumer {
		/**
		 * Performs this operation on the given {@code int} argument.
		 *
		 * @param i the input {@code int} argument
		 */
		void acceptInt(int i);
		
		/*
		 * Date created: 28 May 2024
		 * Time created: 08:33:50
		 */
		/**
		 * {@inheritDoc}
		 * @param value {@inheritDoc}
		 */
		default void accept(int value) {
			acceptInt(value);
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
		default void accept(Integer i) {
			acceptInt(i);
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
		default Consumer andThenInt(Consumer after) {
			Objects.requireNonNull(after);
			return x -> {
				acceptInt(x);
				after.acceptInt(x);
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
		@Override default Consumer andThen(java.util.function.Consumer<? super java.lang.Integer> after) {
			if(after instanceof Consumer) return andThenInt((Consumer) after);
			Objects.requireNonNull(after);
			return x -> {
				acceptInt(x);
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
		@Override default Consumer andThen(IntConsumer after) {
			if(after instanceof Consumer) return andThenInt(after::accept);
			Objects.requireNonNull(after);
			return x -> {
				acceptInt(x);
				after.accept(x);
			};
		}
	}

	@FunctionalInterface
	public static interface BiPredicate<T> extends java.util.function.BiPredicate<Integer, T> {

		@FunctionalInterface
		interface AndDouble extends BiPredicate<java.lang.Double> {

			boolean testDouble(int x, double y);

			@Override
			default boolean testObj(int x, java.lang.Double y) {
				return testDouble(x, y);
			}
		}

		@FunctionalInterface
		interface AndLong extends BiPredicate<java.lang.Long> {

			boolean testLong(int x, long y);

			@Override
			default boolean testObj(int x, java.lang.Long y) {
				return testLong(x, y);
			}
		}

		@FunctionalInterface
		interface AndInt extends BiPredicate<Integer> {

			boolean testInt(int x, int y);

			@Override
			default boolean testObj(int x, Integer y) {
				return testInt(x, y);
			}
		}

		@FunctionalInterface
		interface AndFloat extends BiPredicate<java.lang.Float> {

			boolean testFloat(int x, float y);

			@Override
			default boolean testObj(int x, java.lang.Float y) {
				return testFloat(x, y);
			}
		}

		@FunctionalInterface
		interface AndChar extends BiPredicate<Character> {

			boolean testChar(int x, char y);

			@Override
			default boolean testObj(int x, Character y) {
				return testChar(x, y);
			}
		}

		@FunctionalInterface
		interface AndShort extends BiPredicate<java.lang.Short> {

			boolean testShort(int x, short y);

			@Override
			default boolean testObj(int x, java.lang.Short y) {
				return testShort(x, y);
			}
		}

		@FunctionalInterface
		interface AndByte extends BiPredicate<java.lang.Byte> {

			boolean testByte(int x, byte y);

			@Override
			default boolean testObj(int x, java.lang.Byte y) {
				return testByte(x, y);
			}
		}

		@FunctionalInterface
		interface AndBoolean extends BiPredicate<java.lang.Boolean> {

			boolean testBoolean(int x, boolean y);

			@Override
			default boolean testObj(int x, java.lang.Boolean y) {
				return testBoolean(x, y);
			}
		}

		boolean testObj(int x, T y);

		@Override
		default boolean test(Integer x, T y) {
			return testObj(x, y);
		}
	}

	/**
	 * Interface that extends {@code java.util.function.Predicate} so that an
	 * {@code int} can be used as the argument.
	 */
	@FunctionalInterface
	public static interface Predicate extends java.util.function.Predicate<Integer>, IntPredicate {
		/**
		 * Evaluates this predicate on the given {@code int} argument.
		 *
		 * @param i the {@code int} input argument
		 * @return {@code true} if the input argument matches the predicate, otherwise
		 *         {@code false}
		 */
		boolean testInt(int i);
		
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
		default boolean test(int value) {
			return testInt(value);
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
		default boolean test(Integer t) {
			return testInt(t);
		}

		default Predicate andInt(Predicate other) {
			Objects.requireNonNull(other);
			return x -> testInt(x) && other.testInt(x);
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
				java.util.function.Predicate<? super java.lang.Integer> other) {
			if(other instanceof Predicate) return andInt((Predicate) other);
			return andInt(other::test);
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
				IntPredicate other) {
			Objects.requireNonNull(other);
			return x -> testInt(x) && other.test(x);
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
			return t -> !testInt(t);
		}

		default Predicate negateInt() {
			return x -> !testInt(x);
		}

		default Predicate orInt(Predicate other) {
			Objects.requireNonNull(other);
			return x -> testInt(x) || other.testInt(x);
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
				java.util.function.Predicate<? super java.lang.Integer> other) {
			if(other instanceof Predicate) return orInt((Predicate) other);
			return orInt(other::test);
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
				IntPredicate other) {
			Objects.requireNonNull(other);
			return x -> testInt(x) || other.test(x);
		}
	}

	// Private constructor to prevent instantiation
	private Int() {
	}
}
