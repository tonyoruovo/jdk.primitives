/**
 * 
 */
package jdk.prim.util.function;

import java.util.Objects;
import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoublePredicate;
import java.util.function.DoubleSupplier;
import java.util.function.DoubleUnaryOperator;
import java.util.function.IntToDoubleFunction;
import java.util.function.LongToDoubleFunction;
import java.util.function.ToDoubleBiFunction;
import java.util.function.ToDoubleFunction;
import java.util.function.UnaryOperator;

/**
 * Provides specialized functional interfaces for operations involving the
 * primitive type {@code double}.
 * <p>
 * The {@code Double} class is part of the
 * {@code mathaid.calculator.base.util.function} package, which extends the
 * capabilities of the standard {@code java.util.function} package by offering
 * specialized functional interfaces that handle primitive data types directly.
 * This class specifically focuses on the primitive type {@code double} and
 * includes a suite of functional interfaces designed to perform operations with
 * {@code double} values efficiently, avoiding the overhead associated with
 * autoboxing and unboxing of {@code Double} objects.
 * <p>
 * <b>Overview:</b>
 * <ul>
 * <li>Enhanced support for the {@code double} primitive type to avoid
 * performance penalties associated with autoboxing.</li>
 * <li>Interfaces that mirror those in {@code java.util.function} but are
 * tailored for direct operations on {@code double} types.</li>
 * <li>Optimized for high-performance computing scenarios where precision and
 * efficiency are crucial.</li>
 * </ul>
 *
 * <b>Functional Interfaces Provided:</b>
 * <ul>
 * <li><b>BiFunction</b>: Extends {@code java.util.function.BiFunction} and
 * returns a {@code java.lang.Double}. It includes sub-interfaces for operations
 * combining {@code double} with other primitives.</li>
 * <li><b>Function</b>: Extends {@code java.util.function.Function} and returns
 * a {@code java.lang.Double}. It is used for applying functions to
 * {@code double} values.</li>
 * <li><b>BiConsumer</b>: Extends {@code java.util.function.BiConsumer} for
 * consuming two values, where the first is a {@code double}.</li>
 * <li><b>BiPredicate</b>: Extends {@code java.util.function.BiPredicate} for
 * evaluating two values, the first of which is a {@code double}.</li>
 * <li><b>Supplier</b>: Extends {@code java.util.function.Supplier} and is
 * specialized to supply {@code Double} values.</li>
 * </ul>
 *
 * <b>Real-World Usage:</b>
 * <ul>
 * <li><b>Scientific Computing</b>: For precise computations necessary in
 * scientific applications.</li>
 * <li><b>Financial Calculations</b>: For processing large datasets of
 * floating-point numbers in financial analytics.</li>
 * <li><b>Graphics and Simulation</b>: For calculations in graphics rendering or
 * physical simulations where double precision is crucial.</li>
 * </ul>
 *
 * <b>Examples:</b>
 * 
 * <pre>
 * <code>
 * // Using Double.BiFunction to calculate power
 * Double.BiFunction.OfDouble.AndDouble powerFunction = Math::pow;
 * System.out.println(powerFunction.applyDouble(2.0, 3.0)); // Output will be 8.0
 *
 * // Using Double.Function to convert radians to degrees
 * Double.Function.OfDouble toDegrees = Math::toDegrees;
 * System.out.println(toDegrees.applyDouble(Math.PI)); // Output will be 180.0
 * </code>
 * </pre>
 *
 * <b>Conclusion:</b>
 * The {@code Double} class provides a robust framework for functional
 * programming with the {@code double} primitive type in Java, enhancing
 * performance by eliminating unnecessary boxing and offering a clear and
 * structured approach to implementing functional interfaces for {@code double}
 * operations.
 * 
 */
public final class Double {
	@FunctionalInterface
	public static interface BiFunction<T, U> extends java.util.function.BiFunction<T, U, java.lang.Double>, ToDoubleBiFunction<T, U> {

		@FunctionalInterface
		interface AndDouble<T> extends BiFunction<T, java.lang.Double> {
			double applyDouble(T x, double y);

			@Override
			default double applyObj(T x, java.lang.Double y) {
				return applyDouble(x, y);
			}
		}

		@FunctionalInterface
		interface AndLong<T> extends BiFunction<T, java.lang.Long> {
			double applyLong(T x, long y);

			@Override
			default double applyObj(T x, java.lang.Long y) {
				return applyLong(x, y);
			}
		}

		@FunctionalInterface
		interface AndInt<T> extends BiFunction<T, java.lang.Integer> {
			double applyInt(T x, int y);

			@Override
			default double applyObj(T x, java.lang.Integer y) {
				return applyInt(x, y);
			}
		}

		@FunctionalInterface
		interface AndFloat<T> extends BiFunction<T, java.lang.Float> {
			double applyFloat(T x, float y);

			@Override
			default double applyObj(T x, java.lang.Float y) {
				return applyFloat(x, y);
			}
		}

		@FunctionalInterface
		interface AndChar<T> extends BiFunction<T, java.lang.Character> {
			double applyChar(T x, char y);

			@Override
			default double applyObj(T x, java.lang.Character y) {
				return applyChar(x, y);
			}
		}

		@FunctionalInterface
		interface AndShort<T> extends BiFunction<T, java.lang.Short> {
			double applyShort(T x, short y);

			@Override
			default double applyObj(T x, java.lang.Short y) {
				return applyShort(x, y);
			}
		}

		@FunctionalInterface
		interface AndByte<T> extends BiFunction<T, java.lang.Byte> {
			double applyByte(T x, byte y);

			@Override
			default double applyObj(T x, java.lang.Byte y) {
				return applyByte(x, y);
			}
		}

		@FunctionalInterface
		interface AndBoolean<T> extends BiFunction<T, java.lang.Boolean> {
			double applyBoolean(T x, boolean y);

			@Override
			default double applyObj(T x, java.lang.Boolean y) {
				return applyBoolean(x, y);
			}
		}

		@FunctionalInterface
		interface OfDouble<T> extends BiFunction<java.lang.Double, T> {

			@FunctionalInterface
			interface AndDouble extends OfDouble<java.lang.Double>, DoubleBinaryOperator, BinaryOperator<java.lang.Double> {

				double applyDouble(double x, double y);

				/**
				 * {@inheritDoc}
				 * @param left {@inheritDoc}
				 * @param right {@inheritDoc}
				 * @return {@inheritDoc}
				 */
				@Override default double applyAsDouble(double left, double right) { return applyDouble(left, right); }

				@Override
				default double applyDouble(double x, java.lang.Double y) {
					return applyDouble(x, (double) y);
				}
			}

			@FunctionalInterface
			interface AndLong extends OfDouble<java.lang.Long> {

				double applyLong(double x, long y);

				@Override
				default double applyDouble(double x, java.lang.Long y) {
					return applyLong(x, y);
				}
			}

			@FunctionalInterface
			interface AndFloat extends OfDouble<java.lang.Float> {

				double applyFloat(double x, float y);

				@Override
				default double applyDouble(double x, java.lang.Float y) {
					return applyFloat(x, y);
				}
			}

			@FunctionalInterface
			interface AndChar extends OfDouble<Character> {

				double applyChar(double x, char y);

				@Override
				default double applyDouble(double x, Character y) {
					return applyChar(x, y);
				}
			}

			@FunctionalInterface
			interface AndInt extends OfDouble<java.lang.Integer> {
				double applyInt(double x, int y);

				@Override
				default double applyDouble(double x, java.lang.Integer y) {
					return applyInt(x, y);
				}
			}

			@FunctionalInterface
			interface AndShort extends OfDouble<java.lang.Short> {

				double applyShort(double x, short y);

				@Override
				default double applyDouble(double x, java.lang.Short y) {
					return applyShort(x, y);
				}
			}

			@FunctionalInterface
			interface AndByte extends OfDouble<java.lang.Byte> {

				double applyByte(double x, byte y);

				@Override
				default double applyDouble(double x, java.lang.Byte y) {
					return applyByte(x, y);
				}
			}

			@FunctionalInterface
			interface AndBoolean extends OfDouble<java.lang.Boolean> {

				double applyBoolean(double x, boolean y);

				@Override
				default double applyDouble(double x, java.lang.Boolean y) {
					return applyBoolean(x, y);
				}
			}

			double applyDouble(double x, T y);

			@Override
			default double applyObj(java.lang.Double x, T y) {
				return applyDouble(x, y);
			}
		}

		@FunctionalInterface
		interface OfLong<T> extends BiFunction<java.lang.Long, T> {

			@FunctionalInterface
			interface AndDouble extends OfLong<java.lang.Double> {

				double applyDouble(long x, double y);

				@Override
				default double applyLong(long x, java.lang.Double y) {
					return applyDouble(x, y);
				}
			}

			@FunctionalInterface
			interface AndLong extends OfLong<java.lang.Long> {

				double applyLong(long x, long y);

				@Override
				default double applyLong(long x, java.lang.Long y) {
					return applyLong(x, (long) y);
				}
			}

			@FunctionalInterface
			interface AndFloat extends OfLong<java.lang.Float> {

				double applyFloat(long x, float y);

				@Override
				default double applyLong(long x, java.lang.Float y) {
					return applyFloat(x, y);
				}
			}

			@FunctionalInterface
			interface AndChar extends OfLong<Character> {

				double applyChar(long x, char y);

				@Override
				default double applyLong(long x, Character y) {
					return applyChar(x, y);
				}
			}

			@FunctionalInterface
			interface AndInt extends OfLong<java.lang.Integer> {
				double applyInt(long x, int y);

				@Override
				default double applyLong(long x, java.lang.Integer y) {
					return applyInt(x, y);
				}
			}

			@FunctionalInterface
			interface AndShort extends OfLong<java.lang.Short> {

				double applyShort(long x, short y);

				@Override
				default double applyLong(long x, java.lang.Short y) {
					return applyShort(x, y);
				}
			}

			@FunctionalInterface
			interface AndByte extends OfLong<java.lang.Byte> {

				double applyByte(long x, byte y);

				@Override
				default double applyLong(long x, java.lang.Byte y) {
					return applyByte(x, y);
				}
			}

			@FunctionalInterface
			interface AndBoolean extends OfLong<java.lang.Boolean> {

				double applyBoolean(long x, boolean y);

				@Override
				default double applyLong(long x, java.lang.Boolean y) {
					return applyBoolean(x, y);
				}
			}

			double applyLong(long x, T y);

			@Override
			default double applyObj(java.lang.Long x, T y) {
				return applyLong(x, y);
			}
		}

		@FunctionalInterface
		interface OfInt<T> extends BiFunction<java.lang.Integer, T> {

			@FunctionalInterface
			interface AndDouble extends OfInt<java.lang.Double> {

				double applyDouble(int x, double y);

				@Override
				default double applyInt(int x, java.lang.Double y) {
					return applyDouble(x, y);
				}
			}

			@FunctionalInterface
			interface AndLong extends OfInt<java.lang.Long> {

				double applyLong(int x, long y);

				@Override
				default double applyInt(int x, java.lang.Long y) {
					return applyLong(x, y);
				}
			}

			@FunctionalInterface
			interface AndFloat extends OfInt<java.lang.Float> {

				double applyFloat(int x, float y);

				@Override
				default double applyInt(int x, java.lang.Float y) {
					return applyFloat(x, y);
				}
			}

			@FunctionalInterface
			interface AndChar extends OfInt<Character> {

				double applyChar(int x, char y);

				@Override
				default double applyInt(int x, Character y) {
					return applyChar(x, y);
				}
			}

			@FunctionalInterface
			interface AndInt extends OfInt<java.lang.Integer> {
				double applyInt(int x, int y);

				@Override
				default double applyInt(int x, java.lang.Integer y) {
					return applyInt(x, (int) y);
				}
			}

			@FunctionalInterface
			interface AndShort extends OfInt<java.lang.Short> {

				double applyShort(int x, short y);

				@Override
				default double applyInt(int x, java.lang.Short y) {
					return applyShort(x, y);
				}
			}

			@FunctionalInterface
			interface AndByte extends OfInt<java.lang.Byte> {

				double applyByte(int x, byte y);

				@Override
				default double applyInt(int x, java.lang.Byte y) {
					return applyByte(x, y);
				}
			}

			@FunctionalInterface
			interface AndBoolean extends OfInt<java.lang.Boolean> {

				double applyBoolean(int x, boolean y);

				@Override
				default double applyInt(int x, java.lang.Boolean y) {
					return applyBoolean(x, y);
				}
			}

			double applyInt(int x, T y);

			@Override
			default double applyObj(java.lang.Integer x, T y) {
				return applyInt(x, y);
			}
		}

		@FunctionalInterface
		interface OfFloat<T> extends BiFunction<java.lang.Float, T> {

			@FunctionalInterface
			interface AndDouble extends OfFloat<java.lang.Double> {

				double applyDouble(float x, double y);

				@Override
				default double applyFloat(float x, java.lang.Double y) {
					return applyDouble(x, y);
				}
			}

			@FunctionalInterface
			interface AndLong extends OfFloat<java.lang.Long> {

				double applyLong(float x, long y);

				@Override
				default double applyFloat(float x, java.lang.Long y) {
					return applyLong(x, y);
				}
			}

			@FunctionalInterface
			interface AndFloat extends OfFloat<java.lang.Float> {

				double applyFloat(float x, float y);

				@Override
				default double applyFloat(float x, java.lang.Float y) {
					return applyFloat(x, (float) y);
				}
			}

			@FunctionalInterface
			interface AndChar extends OfFloat<Character> {

				double applyChar(float x, char y);

				@Override
				default double applyFloat(float x, Character y) {
					return applyChar(x, y);
				}
			}

			@FunctionalInterface
			interface AndInt extends OfFloat<java.lang.Integer> {
				double applyInt(float x, int y);

				@Override
				default double applyFloat(float x, java.lang.Integer y) {
					return applyInt(x, (int) y);
				}
			}

			@FunctionalInterface
			interface AndShort extends OfFloat<java.lang.Short> {

				double applyShort(float x, short y);

				@Override
				default double applyFloat(float x, java.lang.Short y) {
					return applyShort(x, y);
				}
			}

			@FunctionalInterface
			interface AndByte extends OfFloat<java.lang.Byte> {

				double applyByte(float x, byte y);

				@Override
				default double applyFloat(float x, java.lang.Byte y) {
					return applyByte(x, y);
				}
			}

			@FunctionalInterface
			interface AndBoolean extends OfFloat<java.lang.Boolean> {

				double applyBoolean(float x, boolean y);

				@Override
				default double applyFloat(float x, java.lang.Boolean y) {
					return applyBoolean(x, y);
				}
			}

			double applyFloat(float x, T y);

			@Override
			default double applyObj(java.lang.Float x, T y) {
				return applyFloat(x, y);
			}
		}

		@FunctionalInterface
		interface OfChar<T> extends BiFunction<java.lang.Character, T> {

			@FunctionalInterface
			interface AndDouble extends OfChar<java.lang.Double> {

				double applyDouble(char x, double y);

				@Override
				default double applyChar(char x, java.lang.Double y) {
					return applyDouble(x, y);
				}
			}

			@FunctionalInterface
			interface AndLong extends OfChar<java.lang.Long> {

				double applyLong(char x, long y);

				@Override
				default double applyChar(char x, java.lang.Long y) {
					return applyLong(x, y);
				}
			}

			@FunctionalInterface
			interface AndFloat extends OfChar<java.lang.Float> {

				double applyFloat(char x, float y);

				@Override
				default double applyChar(char x, java.lang.Float y) {
					return applyFloat(x, y);
				}
			}

			@FunctionalInterface
			interface AndChar extends OfChar<Character> {

				double applyChar(char x, char y);

				@Override
				default double applyChar(char x, Character y) {
					return applyChar(x, (char) y);
				}
			}

			@FunctionalInterface
			interface AndInt extends OfChar<java.lang.Integer> {
				double applyInt(char x, int y);

				@Override
				default double applyChar(char x, java.lang.Integer y) {
					return applyInt(x, (int) y);
				}
			}

			@FunctionalInterface
			interface AndShort extends OfChar<java.lang.Short> {

				double applyShort(char x, short y);

				@Override
				default double applyChar(char x, java.lang.Short y) {
					return applyShort(x, y);
				}
			}

			@FunctionalInterface
			interface AndByte extends OfChar<java.lang.Byte> {

				double applyByte(char x, byte y);

				@Override
				default double applyChar(char x, java.lang.Byte y) {
					return applyByte(x, y);
				}
			}

			@FunctionalInterface
			interface AndBoolean extends OfChar<java.lang.Boolean> {

				double applyBoolean(char x, boolean y);

				@Override
				default double applyChar(char x, java.lang.Boolean y) {
					return applyBoolean(x, y);
				}
			}

			double applyChar(char x, T y);

			@Override
			default double applyObj(java.lang.Character x, T y) {
				return applyChar(x, y);
			}
		}

		@FunctionalInterface
		interface OfShort<T> extends BiFunction<java.lang.Short, T> {

			@FunctionalInterface
			interface AndDouble extends OfShort<java.lang.Double> {

				double applyDouble(short x, double y);

				@Override
				default double applyShort(short x, java.lang.Double y) {
					return applyDouble(x, y);
				}
			}

			@FunctionalInterface
			interface AndLong extends OfShort<java.lang.Long> {

				double applyLong(short x, long y);

				@Override
				default double applyShort(short x, java.lang.Long y) {
					return applyLong(x, y);
				}
			}

			@FunctionalInterface
			interface AndFloat extends OfShort<java.lang.Float> {

				double applyFloat(short x, float y);

				@Override
				default double applyShort(short x, java.lang.Float y) {
					return applyFloat(x, y);
				}
			}

			@FunctionalInterface
			interface AndChar extends OfShort<Character> {

				double applyChar(short x, char y);

				@Override
				default double applyShort(short x, Character y) {
					return applyChar(x, y);
				}
			}

			@FunctionalInterface
			interface AndInt extends OfShort<java.lang.Integer> {
				double applyInt(short x, int y);

				@Override
				default double applyShort(short x, java.lang.Integer y) {
					return applyInt(x, y);
				}
			}

			@FunctionalInterface
			interface AndShort extends OfShort<java.lang.Short> {

				double applyShort(short x, short y);

				@Override
				default double applyShort(short x, java.lang.Short y) {
					return applyShort(x, (short) y);
				}
			}

			@FunctionalInterface
			interface AndByte extends OfShort<java.lang.Byte> {

				double applyByte(short x, byte y);

				@Override
				default double applyShort(short x, java.lang.Byte y) {
					return applyByte(x, y);
				}
			}

			@FunctionalInterface
			interface AndBoolean extends OfShort<java.lang.Boolean> {

				double applyBoolean(short x, boolean y);

				@Override
				default double applyShort(short x, java.lang.Boolean y) {
					return applyBoolean(x, y);
				}
			}

			double applyShort(short x, T y);

			@Override
			default double applyObj(java.lang.Short x, T y) {
				return applyShort(x, y);
			}
		}

		@FunctionalInterface
		interface OfByte<T> extends BiFunction<java.lang.Byte, T> {

			@FunctionalInterface
			interface AndDouble extends OfByte<java.lang.Double> {

				double applyDouble(byte x, double y);

				@Override
				default double applyByte(byte x, java.lang.Double y) {
					return applyDouble(x, y);
				}
			}

			@FunctionalInterface
			interface AndLong extends OfByte<java.lang.Long> {

				double applyLong(byte x, long y);

				@Override
				default double applyByte(byte x, java.lang.Long y) {
					return applyLong(x, y);
				}
			}

			@FunctionalInterface
			interface AndFloat extends OfByte<java.lang.Float> {

				double applyFloat(byte x, float y);

				@Override
				default double applyByte(byte x, java.lang.Float y) {
					return applyFloat(x, y);
				}
			}

			@FunctionalInterface
			interface AndChar extends OfByte<Character> {

				double applyChar(byte x, char y);

				@Override
				default double applyByte(byte x, Character y) {
					return applyChar(x, y);
				}
			}

			@FunctionalInterface
			interface AndInt extends OfByte<java.lang.Integer> {
				double applyInt(byte x, int y);

				@Override
				default double applyByte(byte x, java.lang.Integer y) {
					return applyInt(x, y);
				}
			}

			@FunctionalInterface
			interface AndShort extends OfByte<java.lang.Short> {

				double applyShort(byte x, short y);

				@Override
				default double applyByte(byte x, java.lang.Short y) {
					return applyShort(x, y);
				}
			}

			@FunctionalInterface
			interface AndByte extends OfByte<java.lang.Byte> {

				double applyByte(byte x, byte y);

				@Override
				default double applyByte(byte x, java.lang.Byte y) {
					return applyByte(x, (byte) y);
				}
			}

			@FunctionalInterface
			interface AndBoolean extends OfByte<java.lang.Boolean> {

				double applyBoolean(byte x, boolean y);

				@Override
				default double applyByte(byte x, java.lang.Boolean y) {
					return applyBoolean(x, y);
				}
			}

			double applyByte(byte x, T y);

			@Override
			default double applyObj(java.lang.Byte x, T y) {
				return applyByte(x, y);
			}
		}

		@FunctionalInterface
		interface OfBoolean<T> extends BiFunction<java.lang.Boolean, T> {

			@FunctionalInterface
			interface AndDouble extends OfBoolean<java.lang.Double> {

				double applyDouble(boolean x, double y);

				@Override
				default double applyBoolean(boolean x, java.lang.Double y) {
					return applyDouble(x, y);
				}
			}

			@FunctionalInterface
			interface AndLong extends OfBoolean<java.lang.Long> {

				double applyLong(boolean x, long y);

				@Override
				default double applyBoolean(boolean x, java.lang.Long y) {
					return applyLong(x, y);
				}
			}

			@FunctionalInterface
			interface AndFloat extends OfBoolean<java.lang.Float> {

				double applyFloat(boolean x, float y);

				@Override
				default double applyBoolean(boolean x, java.lang.Float y) {
					return applyFloat(x, y);
				}
			}

			@FunctionalInterface
			interface AndChar extends OfBoolean<Character> {

				double applyChar(boolean x, char y);

				@Override
				default double applyBoolean(boolean x, Character y) {
					return applyChar(x, y);
				}
			}

			@FunctionalInterface
			interface AndInt extends OfBoolean<java.lang.Integer> {
				double applyInt(boolean x, int y);

				@Override
				default double applyBoolean(boolean x, java.lang.Integer y) {
					return applyInt(x, y);
				}
			}

			@FunctionalInterface
			interface AndShort extends OfBoolean<java.lang.Short> {

				double applyShort(boolean x, short y);

				@Override
				default double applyBoolean(boolean x, java.lang.Short y) {
					return applyShort(x, y);
				}
			}

			@FunctionalInterface
			interface AndByte extends OfBoolean<java.lang.Byte> {

				double applyByte(boolean x, byte y);

				@Override
				default double applyBoolean(boolean x, java.lang.Byte y) {
					return applyByte(x, y);
				}
			}

			@FunctionalInterface
			interface AndBoolean extends OfBoolean<java.lang.Boolean> {

				double applyBoolean(boolean x, boolean y);

				@Override
				default double applyBoolean(boolean x, java.lang.Boolean y) {
					return applyBoolean(x, (boolean) y);
				}
			}

			double applyBoolean(boolean x, T y);

			@Override
			default double applyObj(java.lang.Boolean x, T y) {
				return applyBoolean(x, y);
			}
		}

		double applyObj(T x, U y);

		/**
		 * {@inheritDoc}
		 * @param t {@inheritDoc}
		 * @param u {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		@Override default double applyAsDouble(T t, U u) { return applyObj(t, u); }

		@Override
		default java.lang.Double apply(T x, U y) {
			return applyObj(x, y);
		}
	}

	@FunctionalInterface
	public static interface Function<T> extends java.util.function.Function<T, java.lang.Double>, ToDoubleFunction<T> {
		@FunctionalInterface
		interface OfDouble extends Function<java.lang.Double>, DoubleUnaryOperator, UnaryOperator<java.lang.Double> {
			double applyDouble(double x);
			
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
			default double applyAsDouble(double value) {
				return applyDouble(value);
			}

			@Override
			default double applyObj(java.lang.Double x) {
				return applyDouble(x);
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
			default OfDouble compose(DoubleUnaryOperator before) {
				return t -> applyDouble(before.applyAsDouble(t));
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
			default OfDouble andThen(DoubleUnaryOperator after) {
				return t -> after.applyAsDouble(applyDouble(t));
			}
			/**
		     * Returns a unary operator that always returns its input argument.
		     *
		     * @return a unary operator that always returns its input argument
		     */
			static OfDouble identity() {
				return t -> t;
			}
		}

		@FunctionalInterface
		interface OfLong extends Function<java.lang.Long>, LongToDoubleFunction {
			double applyLong(long x);
			
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
			default double applyAsDouble(long value) {
				return applyLong(value);
			}

			@Override
			default double applyObj(java.lang.Long x) {
				return applyLong(x);
			}
		}

		@FunctionalInterface
		interface OfFloat extends Function<java.lang.Float> {
			double applyFloat(float x);

			@Override
			default double applyObj(java.lang.Float x) {
				return applyFloat(x);
			}
		}

		@FunctionalInterface
		interface OfInt extends Function<java.lang.Integer>, IntToDoubleFunction {
			double applyInt(int x);
			
			/*
			 * Date created: 28 May 2024
			 * Time created: 09:23:43
			 */
			/**
			 * {@inheritDoc}
			 * @param value {@inheritDoc}
			 * @return {@inheritDoc}
			 */
			@Override default double applyAsDouble(int value) { return applyInt(value); }

			@Override
			default double applyObj(java.lang.Integer x) {
				return applyInt(x);
			}
		}

		@FunctionalInterface
		interface OfChar extends Function<Character> {
			double applyChar(char x);

			@Override
			default double applyObj(Character x) {
				return applyChar(x);
			}
		}

		@FunctionalInterface
		interface OfShort extends Function<java.lang.Short> {
			double applyShort(short x);

			@Override
			default double applyObj(java.lang.Short x) {
				return applyShort(x);
			}
		}

		@FunctionalInterface
		interface OfByte extends Function<java.lang.Byte> {
			double applyByte(byte x);

			@Override
			default double applyObj(java.lang.Byte x) {
				return applyByte(x);
			}
		}

		@FunctionalInterface
		interface OfBoolean extends Function<java.lang.Boolean> {
			double applyBoolean(boolean x);

			@Override
			default double applyObj(java.lang.Boolean x) {
				return applyBoolean(x);
			}
		}

		double applyObj(T x);
		
		/*
		 * Date created: 28 May 2024
		 * Time created: 09:25:48
		 */
		/**
		 * {@inheritDoc}
		 * @param value {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		@Override default double applyAsDouble(T value) { return applyObj(value); }

		@Override
		default java.lang.Double apply(T x) {
			return applyObj(x);
		}
	}

	/**
	 * Utility class that defines an interface that complements
	 * {@code java.util.function.Supplier} so that a {@code double} can be used as the
	 * argument.
	 */
	@FunctionalInterface
	public static interface Supplier extends java.util.function.Supplier<java.lang.Double>, DoubleSupplier {
		/*
		 * Date created: 17 May 2024 Time created: 11:06:46
		 */
		/**
		 * Gets a {@code double} result.
		 *
		 * @return a {@code double} result
		 */
		double getDouble();
		
		/*
		 * Date created: 28 May 2024
		 * Time created: 08:40:06
		 */
		/**
		 * {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		@Override
		default double getAsDouble() {
			return getDouble();
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
		default java.lang.Double get() {
			return getDouble();
		}
	}

	@FunctionalInterface
	public static interface BiConsumer<T> extends java.util.function.BiConsumer<java.lang.Double, T> {

		@FunctionalInterface
		interface AndDouble extends BiConsumer<java.lang.Double> {

			void acceptDouble(double x, double y);

			@Override
			default void acceptObj(double x, java.lang.Double y) {
				acceptDouble(x, y);
			}
		}

		@FunctionalInterface
		interface AndLong extends BiConsumer<java.lang.Long> {

			void acceptLong(double x, long y);

			@Override
			default void acceptObj(double x, java.lang.Long y) {
				acceptLong(x, y);
			}
		}

		@FunctionalInterface
		interface AndInt extends BiConsumer<java.lang.Integer> {

			void acceptInt(double x, int y);

			@Override
			default void acceptObj(double x, java.lang.Integer y) {
				acceptInt(x, y);
			}
		}

		@FunctionalInterface
		interface AndFloat extends BiConsumer<java.lang.Float> {

			void acceptFloat(double x, float y);

			@Override
			default void acceptObj(double x, java.lang.Float y) {
				acceptFloat(x, y);
			}
		}

		@FunctionalInterface
		interface AndChar extends BiConsumer<Character> {

			void acceptChar(double x, char y);

			@Override
			default void acceptObj(double x, Character y) {
				acceptChar(x, y);
			}
		}

		@FunctionalInterface
		interface AndShort extends BiConsumer<java.lang.Short> {

			void acceptShort(double x, short y);

			@Override
			default void acceptObj(double x, java.lang.Short y) {
				acceptShort(x, y);
			}
		}

		@FunctionalInterface
		interface AndByte extends BiConsumer<java.lang.Byte> {

			void acceptByte(double x, byte y);

			@Override
			default void acceptObj(double x, java.lang.Byte y) {
				acceptByte(x, y);
			}
		}

		@FunctionalInterface
		interface AndBoolean extends BiConsumer<java.lang.Boolean> {

			void acceptBoolean(double x, boolean y);

			@Override
			default void acceptObj(double x, java.lang.Boolean y) {
				acceptBoolean(x, y);
			}
		}

		void acceptObj(double x, T y);

		@Override
		default void accept(java.lang.Double x, T y) {
			acceptObj(x, y);
		}
	}

	/**
	 * Utility class that defines an interface that complements
	 * {@code java.util.function.Consumer} so that an {@code double} can be used as the
	 * argument.
	 */
	@FunctionalInterface
	public static interface Consumer extends java.util.function.Consumer<java.lang.Double>, DoubleConsumer {
		/**
		 * Performs this operation on the given {@code double} argument.
		 *
		 * @param i the input {@code double} argument
		 */
		void acceptDouble(double i);
		
		/*
		 * Date created: 28 May 2024
		 * Time created: 08:33:50
		 */
		/**
		 * {@inheritDoc}
		 * @param value {@inheritDoc}
		 * @see java.util.function.DoubleConsumer#accept(double)
		 */
		@Override
		default void accept(double value) {
			acceptDouble(value);
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
		default void accept(java.lang.Double i) {
			acceptDouble(i);
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
		default Consumer andThenDouble(Consumer after) {
			Objects.requireNonNull(after);
			return x -> {
				acceptDouble(x);
				after.acceptDouble(x);
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
		@Override default Consumer andThen(java.util.function.Consumer<? super java.lang.Double> after) {
			if(after instanceof Consumer) return andThenDouble((Consumer) after);
			Objects.requireNonNull(after);
			return x -> {
				acceptDouble(x);
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
		@Override default Consumer andThen(DoubleConsumer after) {
			if(after instanceof Consumer) return andThenDouble(after::accept);
			Objects.requireNonNull(after);
			return x -> {
				acceptDouble(x);
				after.accept(x);
			};
		}
	}

	@FunctionalInterface
	public static interface BiPredicate<T> extends java.util.function.BiPredicate<java.lang.Double, T> {

		@FunctionalInterface
		interface AndDouble extends BiPredicate<java.lang.Double> {

			boolean testDouble(double x, double y);

			@Override
			default boolean testObj(double x, java.lang.Double y) {
				return testDouble(x, y);
			}
		}

		@FunctionalInterface
		interface AndLong extends BiPredicate<java.lang.Long> {

			boolean testLong(double x, long y);

			@Override
			default boolean testObj(double x, java.lang.Long y) {
				return testLong(x, y);
			}
		}

		@FunctionalInterface
		interface AndInt extends BiPredicate<java.lang.Integer> {

			boolean testInt(double x, int y);

			@Override
			default boolean testObj(double x, java.lang.Integer y) {
				return testInt(x, y);
			}
		}

		@FunctionalInterface
		interface AndFloat extends BiPredicate<java.lang.Float> {

			boolean testFloat(double x, float y);

			@Override
			default boolean testObj(double x, java.lang.Float y) {
				return testFloat(x, y);
			}
		}

		@FunctionalInterface
		interface AndChar extends BiPredicate<Character> {

			boolean testChar(double x, char y);

			@Override
			default boolean testObj(double x, Character y) {
				return testChar(x, y);
			}
		}

		@FunctionalInterface
		interface AndShort extends BiPredicate<java.lang.Short> {

			boolean testShort(double x, short y);

			@Override
			default boolean testObj(double x, java.lang.Short y) {
				return testShort(x, y);
			}
		}

		@FunctionalInterface
		interface AndByte extends BiPredicate<java.lang.Byte> {

			boolean testByte(double x, byte y);

			@Override
			default boolean testObj(double x, java.lang.Byte y) {
				return testByte(x, y);
			}
		}

		@FunctionalInterface
		interface AndBoolean extends BiPredicate<java.lang.Boolean> {

			boolean testBoolean(double x, boolean y);

			@Override
			default boolean testObj(double x, java.lang.Boolean y) {
				return testBoolean(x, y);
			}
		}

		boolean testObj(double x, T y);

		@Override
		default boolean test(java.lang.Double x, T y) {
			return testObj(x, y);
		}
	}

	/**
	 * Provides a specialized functional interface for predicate operations
	 * involving the primitive type {@code double}.
	 * <p>
	 * The {@code Double.Predicate} interface is a part of the
	 * {@code mathaid.calculator.base.util.function.Double} class, designed
	 * specifically for evaluating boolean conditions based on operations with
	 * {@code double} values. This interface extends
	 * {@code java.util.function.Predicate} but is tailored to handle the primitive
	 * {@code double} type directly, thus optimizing performance by avoiding the
	 * overhead of autoboxing and unboxing.
	 * <p>
	 * <b>Overview:</b>
	 * <ul>
	 * <li>Direct support for the {@code double} primitive type to enhance
	 * performance in boolean evaluations.</li>
	 * <li>Designed to provide a clear and efficient way to implement predicates
	 * with {@code double} values in functional programming.</li>
	 * <li>Useful in scenarios where conditions based on floating-point calculations
	 * are frequently evaluated.</li>
	 * </ul>
	 *
	 * <b>Functional Interface:</b>
	 * <ul>
	 * <li><b>Predicate</b>: Represents a predicate (boolean-valued function) of one
	 * {@code double}-valued argument. This is primarily used for filtering or
	 * matching operations.</li>
	 * </ul>
	 *
	 * <b>Real-World Usage:</b>
	 * <ul>
	 * <li><b>Data Analysis</b>: For filtering datasets based on conditions
	 * evaluated using double values.</li>
	 * <li><b>Scientific Applications</b>: Where conditions based on precise
	 * calculations are necessary to determine the flow of computation.</li>
	 * <li><b>Real-time Monitoring Systems</b>: For triggering alerts based on
	 * threshold checks that involve floating-point comparisons.</li>
	 * </ul>
	 *
	 * <b>Examples:</b>
	 * 
	 * <pre>
	 * <code>
	 * // Using Double.Predicate to check if a number is positive
	 * Double.Predicate isPositive = x -> x > 0;
	 * System.out.println(isPositive.testDouble(3.5)); // Output will be true
	 * System.out.println(isPositive.testDouble(-1.2)); // Output will be false
	 *
	 * // Using Double.Predicate to check if a number is zero
	 * Double.Predicate isZero = x -> x == 0.0;
	 * System.out.println(isZero.testDouble(0.0)); // Output will be true
	 * System.out.println(isZero.testDouble(0.1)); // Output will be false
	 * </code>
	 * </pre>
	 *
	 * <b>Conclusion:</b>
	 * The {@code Double.Predicate} interface provides a powerful tool for creating
	 * concise and efficient predicate expressions for operations involving the
	 * {@code double} primitive type, enhancing both performance and readability in
	 * Java functional programming.
	 * 
	 */
	@FunctionalInterface
	public static interface Predicate extends java.util.function.Predicate<java.lang.Double>, DoublePredicate {
		/**
		 * Evaluates this predicate on the given {@code double} primitive, avoiding the
		 * overhead of autoboxing associated with {@code Double}.
		 * <p>
		 * The {@code testDouble} method is a specialized form of the {@code test}
		 * method in the {@code Double.Predicate} interface. It directly accepts a
		 * {@code double} primitive, providing a more efficient approach for evaluating
		 * conditions without the need for casting or boxing to {@code Double}. This
		 * method should be preferred when working with primitive {@code double} values
		 * to enhance performance.
		 * <p>
		 * <b>Overview:</b>
		 * <ul>
		 * <li>Directly handles the {@code double} primitive type, optimizing
		 * performance by eliminating unnecessary autoboxing.</li>
		 * <li>Provides a clear and efficient way to implement boolean conditions that
		 * involve floating-point calculations.</li>
		 * </ul>
		 *
		 * <b>Method Signature:</b>
		 * <ul>
		 * <li><b>boolean testDouble(double value)</b>: Evaluates this predicate on the
		 * specified {@code double} value.</li>
		 * </ul>
		 *
		 * <b>Real-World Usage:</b>
		 * <ul>
		 * <li><b>Financial Calculations</b>: Checking if financial ratios or
		 * percentages meet certain thresholds without the overhead of object
		 * creation.</li>
		 * <li><b>Scientific Computing</b>: Applying conditions in computational
		 * algorithms where precision and performance are critical.</li>
		 * <li><b>Real-time Systems</b>: Evaluating sensor data or measurements directly
		 * in primitive form for quick decision-making processes.</li>
		 * </ul>
		 *
		 * <b>Examples:</b>
		 * 
		 * <pre>
		 * <code>
		 * // Using testDouble to check if a temperature value is above freezing point
		 * Double.Predicate isAboveFreezing = temp -> temp > 0.0;
		 * System.out.println(isAboveFreezing.testDouble(-5.0)); // Output will be false
		 * System.out.println(isAboveFreezing.testDouble(3.2)); // Output will be true
		 *
		 * // Using testDouble to check if a calculated value falls within a specific range
		 * Double.Predicate isInTargetRange = value -> value >= 50.0 && value <= 100.0;
		 * System.out.println(isInTargetRange.testDouble(75.0)); // Output will be true
		 * System.out.println(isInTargetRange.testDouble(49.9)); // Output will be false
		 * </code>
		 * </pre>
		 *
		 * <b>Conclusion:</b>
		 * The {@code testDouble} method enhances the usability and performance of
		 * predicate evaluations involving {@code double} primitives in Java, making it
		 * an essential tool for high-performance and precision-dependent applications.
		 * 
		 * @param i the {@code double} input argument
		 * @return {@code true} if the input argument matches the predicate, otherwise
		 *         {@code false}
		 * 
		 */
		boolean testDouble(double i);
		
		/*
		 * Date created: 28 May 2024
		 * Time created: 08:38:45
		 */
		/**
		 * {@inheritDoc}
		 * @param value {@inheritDoc}
		 * @return {@inheritDoc}
		 * @see java.util.function.DoublePredicate#test(double)
		 */
		@Override
		default boolean test(double value) {
			return testDouble(value);
		}

		/**
		 * Evaluates this predicate on the given {@code Double} object.
		 * <p>
		 * The {@code test} method in the {@code Double.Predicate} interface is designed
		 * to accept a {@code Double} object, allowing it to be used in contexts where
		 * object instances are necessary or already present. However, it primarily acts
		 * as a wrapper that calls the {@code testDouble} method by extracting the
		 * primitive {@code double} value from the {@code Double} object. This method
		 * provides compatibility with the {@code java.util.function.Predicate<Double>}
		 * interface but introduces the overhead of autoboxing and unboxing.
		 * <p>
		 * <b>Overview:</b>
		 * <ul>
		 * <li>Accepts a {@code Double} object, providing compatibility with
		 * object-based functional interfaces.</li>
		 * <li>Internally calls {@code testDouble(double)} to perform the actual
		 * evaluation, ensuring that the logic remains consistent with the specialized
		 * primitive version.</li>
		 * <li>Useful when working with collections or APIs that operate on
		 * {@code Double} objects.</li>
		 * </ul>
		 *
		 * <b>Method Signature:</b>
		 * <ul>
		 * <li><b>boolean test(Double value)</b>: Evaluates this predicate on the
		 * specified {@code Double} object.</li>
		 * </ul>
		 *
		 * <b>Real-World Usage:</b>
		 * <ul>
		 * <li><b>Data Processing</b>: Filtering collections of {@code Double} objects
		 * based on certain conditions.</li>
		 * <li><b>API Integration</b>: Interfacing with APIs that require or return
		 * {@code Double} objects and where predicate conditions are needed.</li>
		 * <li><b>Legacy Systems</b>: Integrating with older Java codebases that use
		 * {@code Double} objects extensively.</li>
		 * </ul>
		 *
		 * <b>Examples:</b>
		 * 
		 * <pre>
		 * <code>
		 * // Using test to check if a list of Double objects contains a value above a certain threshold
		 * List<Double> temperatures = Arrays.asList(-10.0, 0.0, 5.5, 15.0);
		 * Double.Predicate isAboveZero = temp -> temp > 0.0;
		 * boolean hasWarmTemperatures = temperatures.stream().anyMatch(isAboveZero::test);
		 * System.out.println(hasWarmTemperatures); // Output will be true
		 *
		 * // Using test in a stream to filter and collect Double values
		 * List<Double> filteredValues = temperatures.stream()
		 * .filter(isAboveZero::test)
		 * .collect(Collectors.toList());
		 * System.out.println(filteredValues); // Output will be [5.5, 15.0]
		 * </code>
		 * </pre>
		 *
		 * <b>Conclusion:</b>
		 * While the {@code test} method provides necessary compatibility with the
		 * {@code Double} type, it is recommended to use {@code testDouble} when
		 * possible to avoid the performance cost associated with boxing. This method
		 * ensures that the {@code Double.Predicate} interface can seamlessly integrate
		 * into various Java environments and use cases.
		 * 
		 * @param t {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		@Override
		default boolean test(java.lang.Double t) {
			return testDouble(t);
		}

		/**
		 * <h4>Summary</h4>
		 * Returns a composed predicate that represents a short-circuiting logical AND
		 * of this predicate and another.
		 * <h4>Overview</h4>
		 * <p>
		 * This interface is part of the MathAid Calculator library, which provides
		 * additional functional interfaces for working
		 * with primitive types in Java. The interfaces are not intended to replace
		 * their counterparts in java.util.function,
		 * but to complement them by using Java naming conventions and providing full
		 * primitive support for the JDK's functional API.
		 *
		 * <h4>Description</h4>
		 * <p>
		 * The andDouble method returns a composed predicate that represents a
		 * short-circuiting logical AND of this predicate
		 * and another. The composed predicate evaluates both predicates in order, and
		 * returns true if and only if both
		 * predicates return true.
		 *
		 * <h4>Real-world scenarios</h4>
		 * <p>
		 * This interface can be used in any situation where you need to combine two
		 * Double predicates into a single predicate.
		 * For example, you might use it to filter a list of Double values based on two
		 * different criteria.
		 *
		 * <h4>Generic examples</h4>
		 * <p>
		 * Here's an example of how you might use the andDouble method to filter a list
		 * of Double values based on two criteria:
		 * 
		 * <pre>
		 * <code>
		 * Double.Predicate p1 = d -> d &gt; 0;
		 * Double.Predicate p2 = d -> d &lt; 10;
		 * Double.Predicate p3 = p1.andDouble(p2);
		 *
		 * List&lt;Double&gt; values = Arrays.asList(1.0, 5.0, 10.0, 15.0);
		 * List&lt;Double&gt; filteredValues = values.stream().filter(p3).collect(Collectors.toList());
		 *</code>
		 * </pre>
		 * 
		 * In this example, p1 and p2 are two different Double predicates that check
		 * whether a Double value is greater than 0
		 * and less than 10, respectively. The p3 predicate is a composed predicate that
		 * represents the logical AND of p1 and p2.
		 * Finally, the filteredValues list contains only the values from the original
		 * list that satisfy both predicates.
		 *
		 * <h4>Conclusion:</h4>
		 * <p>
		 * The andDouble method is a useful tool for combining two Double predicates
		 * into a single predicate. By using this
		 * method, you can easily filter a list of Double values based on multiple
		 * criteria.
		 *
		 * @param other the other predicate to be evaluated with this predicate
		 * @return a composed predicate that represents the short-circuiting logical AND
		 *         of this predicate and the other
		 * @throws NullPointerException if {@code other} is null
		 * @apiNote This is the {@code double} implementation of {@link #and}
		 */
		default Predicate andDouble(Predicate other) {
			Objects.requireNonNull(other);
			return x -> testDouble(x) && other.testDouble(x);
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
				java.util.function.Predicate<? super java.lang.Double> other) {
			if(other instanceof Predicate) return andDouble((Predicate) other);
			return andDouble(other::test);
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
				DoublePredicate other) {
			Objects.requireNonNull(other);
			return x -> testDouble(x) && other.test(x);
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
			return t -> !testDouble(t);
		}

		/**
		 * Calculates the negation of this {@code Predicate} and returns it.
		 * Note that calling this method does not negate this object.
		 * @return a {@code Predicate} that is the negation of {@code this}.
		 * @apiNote This is the {@code double} implementation of {@link #negate}
		 */
		default Predicate negateDouble() {
			return x -> !testDouble(x);
		}
		
		default Predicate orDouble(Predicate other) {
			Objects.requireNonNull(other);
			return x -> testDouble(x) || other.testDouble(x);
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
				java.util.function.Predicate<? super java.lang.Double> other) {
			if(other instanceof Predicate) return orDouble((Predicate) other);
			return orDouble(other::test);
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
				DoublePredicate other) {
			Objects.requireNonNull(other);
			return x -> testDouble(x) || other.test(x);
		}
	}

	// Private constructor to prevent instantiation
	private Double() {
	}

}
