/**
 * 
 */
package jdk.prim.util.function;

import java.util.function.ObjDoubleConsumer;
import java.util.function.ObjIntConsumer;
import java.util.function.ObjLongConsumer;

/**
 * 
 */
public final class Obj {
	@FunctionalInterface
	public static interface BiFunction<T, U, R> extends java.util.function.BiFunction<T, U, R> {

		@FunctionalInterface
		interface AndDouble<T, R> extends BiFunction<T, java.lang.Double, R> {
			R applyDouble(T x, double y);

			@Override
			default R apply(T x, java.lang.Double y) {
				return applyDouble(x, y);
			}
		}

		@FunctionalInterface
		interface AndLong<T, R> extends BiFunction<T, java.lang.Long, R> {
			R applyLong(T x, long y);

			@Override
			default R apply(T x, java.lang.Long y) {
				return applyLong(x, y);
			}
		}

		@FunctionalInterface
		interface AndInt<T, R> extends BiFunction<T, java.lang.Integer, R> {
			R applyInt(T x, int y);

			@Override
			default R apply(T x, java.lang.Integer y) {
				return applyInt(x, y);
			}
		}

		@FunctionalInterface
		interface AndFloat<T, R> extends BiFunction<T, java.lang.Float, R> {
			R applyFloat(T x, float y);

			@Override
			default R apply(T x, java.lang.Float y) {
				return applyFloat(x, y);
			}
		}

		@FunctionalInterface
		interface AndChar<T, R> extends BiFunction<T, java.lang.Character, R> {
			R applyChar(T x, char y);

			@Override
			default R apply(T x, java.lang.Character y) {
				return applyChar(x, y);
			}
		}

		@FunctionalInterface
		interface AndShort<T, R> extends BiFunction<T, java.lang.Short, R> {
			R applyShort(T x, short y);

			@Override
			default R apply(T x, java.lang.Short y) {
				return applyShort(x, y);
			}
		}

		@FunctionalInterface
		interface AndByte<T, R> extends BiFunction<T, java.lang.Byte, R> {
			R applyByte(T x, byte y);

			@Override
			default R apply(T x, java.lang.Byte y) {
				return applyByte(x, y);
			}
		}

		@FunctionalInterface
		interface AndBoolean<T, R> extends BiFunction<T, java.lang.Boolean, R> {
			R applyBoolean(T x, boolean y);

			@Override
			default R apply(T x, java.lang.Boolean y) {
				return applyBoolean(x, y);
			}
		}

		@FunctionalInterface
		interface OfDouble<T, R> extends BiFunction<java.lang.Double, T, R> {

			@FunctionalInterface
			interface AndDouble<R> extends OfDouble<java.lang.Double, R> {

				R applyDouble(double x, double y);

				@Override
				default R applyDouble(double x, java.lang.Double y) {
					return applyDouble(x, (double) y);
				}
			}

			@FunctionalInterface
			interface AndLong<R> extends OfDouble<java.lang.Long, R> {

				R applyLong(double x, long y);

				@Override
				default R applyDouble(double x, java.lang.Long y) {
					return applyLong(x, y);
				}
			}

			@FunctionalInterface
			interface AndFloat<R> extends OfDouble<java.lang.Float, R> {

				R applyFloat(double x, float y);

				@Override
				default R applyDouble(double x, java.lang.Float y) {
					return applyFloat(x, y);
				}
			}

			@FunctionalInterface
			interface AndChar<R> extends OfDouble<Character, R> {

				R applyChar(double x, char y);

				@Override
				default R applyDouble(double x, Character y) {
					return applyChar(x, y);
				}
			}

			@FunctionalInterface
			interface AndInt<R> extends OfDouble<java.lang.Integer, R> {
				R applyInt(double x, int y);

				@Override
				default R applyDouble(double x, java.lang.Integer y) {
					return applyInt(x, y);
				}
			}

			@FunctionalInterface
			interface AndShort<R> extends OfDouble<java.lang.Short, R> {

				R applyShort(double x, short y);

				@Override
				default R applyDouble(double x, java.lang.Short y) {
					return applyShort(x, y);
				}
			}

			@FunctionalInterface
			interface AndByte<R> extends OfDouble<java.lang.Byte, R> {

				R applyByte(double x, byte y);

				@Override
				default R applyDouble(double x, java.lang.Byte y) {
					return applyByte(x, y);
				}
			}

			@FunctionalInterface
			interface AndBoolean<R> extends OfDouble<java.lang.Boolean, R> {

				R applyBoolean(double x, boolean y);

				@Override
				default R applyDouble(double x, java.lang.Boolean y) {
					return applyBoolean(x, y);
				}
			}

			R applyDouble(double x, T y);

			@Override
			default R apply(java.lang.Double x, T y) {
				return applyDouble(x, y);
			}
		}

		@FunctionalInterface
		interface OfLong<T, R> extends BiFunction<java.lang.Long, T, R> {

			@FunctionalInterface
			interface AndDouble<R> extends OfLong<java.lang.Double, R> {

				R applyDouble(long x, double y);

				@Override
				default R applyLong(long x, java.lang.Double y) {
					return applyDouble(x, y);
				}
			}

			@FunctionalInterface
			interface AndLong<R> extends OfLong<java.lang.Long, R> {

				R applyLong(long x, long y);

				@Override
				default R applyLong(long x, java.lang.Long y) {
					return applyLong(x, (long) y);
				}
			}

			@FunctionalInterface
			interface AndFloat<R> extends OfLong<java.lang.Float, R> {

				R applyFloat(long x, float y);

				@Override
				default R applyLong(long x, java.lang.Float y) {
					return applyFloat(x, y);
				}
			}

			@FunctionalInterface
			interface AndChar<R> extends OfLong<Character, R> {

				R applyChar(long x, char y);

				@Override
				default R applyLong(long x, Character y) {
					return applyChar(x, y);
				}
			}

			@FunctionalInterface
			interface AndInt<R> extends OfLong<java.lang.Integer, R> {
				R applyInt(long x, int y);

				@Override
				default R applyLong(long x, java.lang.Integer y) {
					return applyInt(x, y);
				}
			}

			@FunctionalInterface
			interface AndShort<R> extends OfLong<java.lang.Short, R> {

				R applyShort(long x, short y);

				@Override
				default R applyLong(long x, java.lang.Short y) {
					return applyShort(x, y);
				}
			}

			@FunctionalInterface
			interface AndByte<R> extends OfLong<java.lang.Byte, R> {

				R applyByte(long x, byte y);

				@Override
				default R applyLong(long x, java.lang.Byte y) {
					return applyByte(x, y);
				}
			}

			@FunctionalInterface
			interface AndBoolean<R> extends OfLong<java.lang.Boolean, R> {

				R applyBoolean(long x, boolean y);

				@Override
				default R applyLong(long x, java.lang.Boolean y) {
					return applyBoolean(x, y);
				}
			}

			R applyLong(long x, T y);

			@Override
			default R apply(java.lang.Long x, T y) {
				return applyLong(x, y);
			}
		}

		@FunctionalInterface
		interface OfInt<T, R> extends BiFunction<java.lang.Integer, T, R> {

			@FunctionalInterface
			interface AndDouble<R> extends OfInt<java.lang.Double, R> {

				R applyDouble(int x, double y);

				@Override
				default R applyInt(int x, java.lang.Double y) {
					return applyDouble(x, y);
				}
			}

			@FunctionalInterface
			interface AndLong<R> extends OfInt<java.lang.Long, R> {

				R applyLong(int x, long y);

				@Override
				default R applyInt(int x, java.lang.Long y) {
					return applyLong(x, y);
				}
			}

			@FunctionalInterface
			interface AndFloat<R> extends OfInt<java.lang.Float, R> {

				R applyFloat(int x, float y);

				@Override
				default R applyInt(int x, java.lang.Float y) {
					return applyFloat(x, y);
				}
			}

			@FunctionalInterface
			interface AndChar<R> extends OfInt<Character, R> {

				R applyChar(int x, char y);

				@Override
				default R applyInt(int x, Character y) {
					return applyChar(x, y);
				}
			}

			@FunctionalInterface
			interface AndInt<R> extends OfInt<java.lang.Integer, R> {
				R applyInt(int x, int y);

				@Override
				default R applyInt(int x, java.lang.Integer y) {
					return applyInt(x, (int) y);
				}
			}

			@FunctionalInterface
			interface AndShort<R> extends OfInt<java.lang.Short, R> {

				R applyShort(int x, short y);

				@Override
				default R applyInt(int x, java.lang.Short y) {
					return applyShort(x, y);
				}
			}

			@FunctionalInterface
			interface AndByte<R> extends OfInt<java.lang.Byte, R> {

				R applyByte(int x, byte y);

				@Override
				default R applyInt(int x, java.lang.Byte y) {
					return applyByte(x, y);
				}
			}

			@FunctionalInterface
			interface AndBoolean<R> extends OfInt<java.lang.Boolean, R> {

				R applyBoolean(int x, boolean y);

				@Override
				default R applyInt(int x, java.lang.Boolean y) {
					return applyBoolean(x, y);
				}
			}

			R applyInt(int x, T y);

			@Override
			default R apply(java.lang.Integer x, T y) {
				return applyInt(x, y);
			}
		}

		@FunctionalInterface
		interface OfFloat<T, R> extends BiFunction<java.lang.Float, T, R> {

			@FunctionalInterface
			interface AndDouble<R> extends OfFloat<java.lang.Double, R> {

				R applyDouble(float x, double y);

				@Override
				default R applyFloat(float x, java.lang.Double y) {
					return applyDouble(x, y);
				}
			}

			@FunctionalInterface
			interface AndLong<R> extends OfFloat<java.lang.Long, R> {

				R applyLong(float x, long y);

				@Override
				default R applyFloat(float x, java.lang.Long y) {
					return applyLong(x, y);
				}
			}

			@FunctionalInterface
			interface AndFloat<R> extends OfFloat<java.lang.Float, R> {

				R applyFloat(float x, float y);

				@Override
				default R applyFloat(float x, java.lang.Float y) {
					return applyFloat(x, (float) y);
				}
			}

			@FunctionalInterface
			interface AndChar<R> extends OfFloat<Character, R> {

				R applyChar(float x, char y);

				@Override
				default R applyFloat(float x, Character y) {
					return applyChar(x, y);
				}
			}

			@FunctionalInterface
			interface AndInt<R> extends OfFloat<java.lang.Integer, R> {
				R applyInt(float x, int y);

				@Override
				default R applyFloat(float x, java.lang.Integer y) {
					return applyInt(x, (int) y);
				}
			}

			@FunctionalInterface
			interface AndShort<R> extends OfFloat<java.lang.Short, R> {

				R applyShort(float x, short y);

				@Override
				default R applyFloat(float x, java.lang.Short y) {
					return applyShort(x, y);
				}
			}

			@FunctionalInterface
			interface AndByte<R> extends OfFloat<java.lang.Byte, R> {

				R applyByte(float x, byte y);

				@Override
				default R applyFloat(float x, java.lang.Byte y) {
					return applyByte(x, y);
				}
			}

			@FunctionalInterface
			interface AndBoolean<R> extends OfFloat<java.lang.Boolean, R> {

				R applyBoolean(float x, boolean y);

				@Override
				default R applyFloat(float x, java.lang.Boolean y) {
					return applyBoolean(x, y);
				}
			}

			R applyFloat(float x, T y);

			@Override
			default R apply(java.lang.Float x, T y) {
				return applyFloat(x, y);
			}
		}

		@FunctionalInterface
		interface OfChar<T, R> extends BiFunction<java.lang.Character, T, R> {

			@FunctionalInterface
			interface AndDouble<R> extends OfChar<java.lang.Double, R> {

				R applyDouble(char x, double y);

				@Override
				default R applyChar(char x, java.lang.Double y) {
					return applyDouble(x, y);
				}
			}

			@FunctionalInterface
			interface AndLong<R> extends OfChar<java.lang.Long, R> {

				R applyLong(char x, long y);

				@Override
				default R applyChar(char x, java.lang.Long y) {
					return applyLong(x, y);
				}
			}

			@FunctionalInterface
			interface AndFloat<R> extends OfChar<java.lang.Float, R> {

				R applyFloat(char x, float y);

				@Override
				default R applyChar(char x, java.lang.Float y) {
					return applyFloat(x, y);
				}
			}

			@FunctionalInterface
			interface AndChar<R> extends OfChar<Character, R> {

				R applyChar(char x, char y);

				@Override
				default R applyChar(char x, Character y) {
					return applyChar(x, (char) y);
				}
			}

			@FunctionalInterface
			interface AndInt<R> extends OfChar<java.lang.Integer, R> {
				R applyInt(char x, int y);

				@Override
				default R applyChar(char x, java.lang.Integer y) {
					return applyInt(x, (int) y);
				}
			}

			@FunctionalInterface
			interface AndShort<R> extends OfChar<java.lang.Short, R> {

				R applyShort(char x, short y);

				@Override
				default R applyChar(char x, java.lang.Short y) {
					return applyShort(x, y);
				}
			}

			@FunctionalInterface
			interface AndByte<R> extends OfChar<java.lang.Byte, R> {

				R applyByte(char x, byte y);

				@Override
				default R applyChar(char x, java.lang.Byte y) {
					return applyByte(x, y);
				}
			}

			@FunctionalInterface
			interface AndBoolean<R> extends OfChar<java.lang.Boolean, R> {

				R applyBoolean(char x, boolean y);

				@Override
				default R applyChar(char x, java.lang.Boolean y) {
					return applyBoolean(x, y);
				}
			}

			R applyChar(char x, T y);

			@Override
			default R apply(java.lang.Character x, T y) {
				return applyChar(x, y);
			}
		}

		@FunctionalInterface
		interface OfShort<T, R> extends BiFunction<java.lang.Short, T, R> {

			@FunctionalInterface
			interface AndDouble<R> extends OfShort<java.lang.Double, R> {

				R applyDouble(short x, double y);

				@Override
				default R applyShort(short x, java.lang.Double y) {
					return applyDouble(x, y);
				}
			}

			@FunctionalInterface
			interface AndLong<R> extends OfShort<java.lang.Long, R> {

				R applyLong(short x, long y);

				@Override
				default R applyShort(short x, java.lang.Long y) {
					return applyLong(x, y);
				}
			}

			@FunctionalInterface
			interface AndFloat<R> extends OfShort<java.lang.Float, R> {

				R applyFloat(short x, float y);

				@Override
				default R applyShort(short x, java.lang.Float y) {
					return applyFloat(x, y);
				}
			}

			@FunctionalInterface
			interface AndChar<R> extends OfShort<Character, R> {

				R applyChar(short x, char y);

				@Override
				default R applyShort(short x, Character y) {
					return applyChar(x, y);
				}
			}

			@FunctionalInterface
			interface AndInt<R> extends OfShort<java.lang.Integer, R> {
				R applyInt(short x, int y);

				@Override
				default R applyShort(short x, java.lang.Integer y) {
					return applyInt(x, y);
				}
			}

			@FunctionalInterface
			interface AndShort<R> extends OfShort<java.lang.Short, R> {

				R applyShort(short x, short y);

				@Override
				default R applyShort(short x, java.lang.Short y) {
					return applyShort(x, (short) y);
				}
			}

			@FunctionalInterface
			interface AndByte<R> extends OfShort<java.lang.Byte, R> {

				R applyByte(short x, byte y);

				@Override
				default R applyShort(short x, java.lang.Byte y) {
					return applyByte(x, y);
				}
			}

			@FunctionalInterface
			interface AndBoolean<R> extends OfShort<java.lang.Boolean, R> {

				R applyBoolean(short x, boolean y);

				@Override
				default R applyShort(short x, java.lang.Boolean y) {
					return applyBoolean(x, y);
				}
			}

			R applyShort(short x, T y);

			@Override
			default R apply(java.lang.Short x, T y) {
				return applyShort(x, y);
			}
		}

		@FunctionalInterface
		interface OfByte<T, R> extends BiFunction<java.lang.Byte, T, R> {

			@FunctionalInterface
			interface AndDouble<R> extends OfByte<java.lang.Double, R> {

				R applyDouble(byte x, double y);

				@Override
				default R applyByte(byte x, java.lang.Double y) {
					return applyDouble(x, y);
				}
			}

			@FunctionalInterface
			interface AndLong<R> extends OfByte<java.lang.Long, R> {

				R applyLong(byte x, long y);

				@Override
				default R applyByte(byte x, java.lang.Long y) {
					return applyLong(x, y);
				}
			}

			@FunctionalInterface
			interface AndFloat<R> extends OfByte<java.lang.Float, R> {

				R applyFloat(byte x, float y);

				@Override
				default R applyByte(byte x, java.lang.Float y) {
					return applyFloat(x, y);
				}
			}

			@FunctionalInterface
			interface AndChar<R> extends OfByte<Character, R> {

				R applyChar(byte x, char y);

				@Override
				default R applyByte(byte x, Character y) {
					return applyChar(x, y);
				}
			}

			@FunctionalInterface
			interface AndInt<R> extends OfByte<java.lang.Integer, R> {
				R applyInt(byte x, int y);

				@Override
				default R applyByte(byte x, java.lang.Integer y) {
					return applyInt(x, y);
				}
			}

			@FunctionalInterface
			interface AndShort<R> extends OfByte<java.lang.Short, R> {

				R applyShort(byte x, short y);

				@Override
				default R applyByte(byte x, java.lang.Short y) {
					return applyShort(x, y);
				}
			}

			@FunctionalInterface
			interface AndByte<R> extends OfByte<java.lang.Byte, R> {

				R applyByte(byte x, byte y);

				@Override
				default R applyByte(byte x, java.lang.Byte y) {
					return applyByte(x, (byte) y);
				}
			}

			@FunctionalInterface
			interface AndBoolean<R> extends OfByte<java.lang.Boolean, R> {

				R applyBoolean(byte x, boolean y);

				@Override
				default R applyByte(byte x, java.lang.Boolean y) {
					return applyBoolean(x, y);
				}
			}

			R applyByte(byte x, T y);

			@Override
			default R apply(java.lang.Byte x, T y) {
				return applyByte(x, y);
			}
		}

		@FunctionalInterface
		interface OfBoolean<T, R> extends BiFunction<java.lang.Boolean, T, R> {

			@FunctionalInterface
			interface AndDouble<R> extends OfBoolean<java.lang.Double, R> {

				R applyDouble(boolean x, double y);

				@Override
				default R applyBoolean(boolean x, java.lang.Double y) {
					return applyDouble(x, y);
				}
			}

			@FunctionalInterface
			interface AndLong<R> extends OfBoolean<java.lang.Long, R> {

				R applyLong(boolean x, long y);

				@Override
				default R applyBoolean(boolean x, java.lang.Long y) {
					return applyLong(x, y);
				}
			}

			@FunctionalInterface
			interface AndFloat<R> extends OfBoolean<java.lang.Float, R> {

				R applyFloat(boolean x, float y);

				@Override
				default R applyBoolean(boolean x, java.lang.Float y) {
					return applyFloat(x, y);
				}
			}

			@FunctionalInterface
			interface AndChar<R> extends OfBoolean<Character, R> {

				R applyChar(boolean x, char y);

				@Override
				default R applyBoolean(boolean x, Character y) {
					return applyChar(x, y);
				}
			}

			@FunctionalInterface
			interface AndInt<R> extends OfBoolean<java.lang.Integer, R> {
				R applyInt(boolean x, int y);

				@Override
				default R applyBoolean(boolean x, java.lang.Integer y) {
					return applyInt(x, y);
				}
			}

			@FunctionalInterface
			interface AndShort<R> extends OfBoolean<java.lang.Short, R> {

				R applyShort(boolean x, short y);

				@Override
				default R applyBoolean(boolean x, java.lang.Short y) {
					return applyShort(x, y);
				}
			}

			@FunctionalInterface
			interface AndByte<R> extends OfBoolean<java.lang.Byte, R> {

				R applyByte(boolean x, byte y);

				@Override
				default R applyBoolean(boolean x, java.lang.Byte y) {
					return applyByte(x, y);
				}
			}

			@FunctionalInterface
			interface AndBoolean<R> extends OfBoolean<java.lang.Boolean, R> {

				R applyBoolean(boolean x, boolean y);

				@Override
				default R applyBoolean(boolean x, java.lang.Boolean y) {
					return applyBoolean(x, (boolean) y);
				}
			}

			R applyBoolean(boolean x, T y);

			@Override
			default R apply(java.lang.Boolean x, T y) {
				return applyBoolean(x, y);
			}
		}
	}

	@FunctionalInterface
	public static interface Function<T, R> extends java.util.function.Function<T, R> {
		@FunctionalInterface
		interface OfDouble<T> extends Function<java.lang.Double, T> {
			T applyDouble(double x);

			@Override
			default T apply(java.lang.Double x) {
				return applyDouble(x);
			}
		}

		@FunctionalInterface
		interface OfLong<T> extends Function<java.lang.Long, T> {
			T applyLong(long x);

			@Override
			default T apply(java.lang.Long x) {
				return applyLong(x);
			}
		}

		@FunctionalInterface
		interface OfFloat<T> extends Function<java.lang.Float, T> {
			T applyFloat(float x);

			@Override
			default T apply(java.lang.Float x) {
				return applyFloat(x);
			}
		}

		@FunctionalInterface
		interface OfInt<T> extends Function<java.lang.Integer, T> {
			T applyInt(int x);

			@Override
			default T apply(java.lang.Integer x) {
				return applyInt(x);
			}
		}

		@FunctionalInterface
		interface OfChar<T> extends Function<Character, T> {
			T applyChar(char x);

			@Override
			default T apply(Character x) {
				return applyChar(x);
			}
		}

		@FunctionalInterface
		interface OfShort<T> extends Function<java.lang.Short, T> {
			T applyShort(short x);

			@Override
			default T apply(java.lang.Short x) {
				return applyShort(x);
			}
		}

		@FunctionalInterface
		interface OfByte<T> extends Function<java.lang.Byte, T> {
			T applyByte(byte x);

			@Override
			default T apply(java.lang.Byte x) {
				return applyByte(x);
			}
		}

		@FunctionalInterface
		interface OfBoolean<T> extends Function<java.lang.Boolean, T> {
			T applyBoolean(boolean x);

			@Override
			default T apply(java.lang.Boolean x) {
				return applyBoolean(x);
			}
		}
	}

	/**
	 * Utility class that defines an interface that complements
	 * {@code java.util.function.Supplier} so that an {@code int} can be used as the
	 * argument.
	 */
	@FunctionalInterface
	public static interface Supplier<T> extends java.util.function.Supplier<T> {}

	@FunctionalInterface
	public static interface BiConsumer<T, U> extends java.util.function.BiConsumer<T, U> {

		@FunctionalInterface
		interface AndDouble<T> extends BiConsumer<T, java.lang.Double>, ObjDoubleConsumer<T> {

			void acceptDouble(T x, double y);
			
			/**
			 * {@inheritDoc}
			 * @param t {@inheritDoc}
			 * @param value {@inheritDoc}
			 */
			@Override default void accept(T t, double value) { acceptDouble(t, value); }

			@Override
			default void accept(T x, java.lang.Double y) {
				acceptDouble(x, y);
			}
		}

		@FunctionalInterface
		interface AndLong<T> extends BiConsumer<T, java.lang.Long>, ObjLongConsumer<T> {

			void acceptLong(T x, long y);

			/**
			 * {@inheritDoc}
			 * @param t {@inheritDoc}
			 * @param value {@inheritDoc}
			 */
			@Override default void accept(T t, long value) { acceptLong(t, value); }

			@Override
			default void accept(T x, java.lang.Long y) {
				acceptLong(x, y);
			}
		}

		@FunctionalInterface
		interface AndInt<T> extends BiConsumer<T, java.lang.Integer>, ObjIntConsumer<T> {

			void acceptInt(T x, int y);

			/**
			 * {@inheritDoc}
			 * @param t {@inheritDoc}
			 * @param value {@inheritDoc}
			 */
			@Override default void accept(T t, int value) { acceptInt(t, value); }

			@Override
			default void accept(T x, java.lang.Integer y) {
				acceptInt(x, y);
			}
		}

		@FunctionalInterface
		interface AndFloat<T> extends BiConsumer<T, java.lang.Float> {

			void acceptFloat(T x, float y);

			@Override
			default void accept(T x, java.lang.Float y) {
				acceptFloat(x, y);
			}
		}

		@FunctionalInterface
		interface AndChar<T> extends BiConsumer<T, Character> {

			void acceptChar(T x, char y);

			@Override
			default void accept(T x, Character y) {
				acceptChar(x, y);
			}
		}

		@FunctionalInterface
		interface AndShort<T> extends BiConsumer<T, java.lang.Short> {

			void acceptShort(T x, short y);

			@Override
			default void accept(T x, java.lang.Short y) {
				acceptShort(x, y);
			}
		}

		@FunctionalInterface
		interface AndByte<T> extends BiConsumer<T, java.lang.Byte> {

			void acceptByte(T x, byte y);

			@Override
			default void accept(T x, java.lang.Byte y) {
				acceptByte(x, y);
			}
		}

		@FunctionalInterface
		interface AndBoolean<T> extends BiConsumer<T, java.lang.Boolean> {

			void acceptBoolean(T x, boolean y);

			@Override
			default void accept(T x, java.lang.Boolean y) {
				acceptBoolean(x, y);
			}
		}
	}

	/**
	 * Utility class that defines an interface that complements
	 * {@code java.util.function.Consumer} so that an {@code int} can be used as the
	 * argument.
	 */
	@FunctionalInterface
	public static interface Consumer<T> extends java.util.function.Consumer<T> {}

	@FunctionalInterface
	public static interface BiPredicate<T, U> extends java.util.function.BiPredicate<T, U> {

		@FunctionalInterface
		interface AndDouble<T> extends BiPredicate<T, java.lang.Double> {

			boolean testDouble(T x, double y);

			@Override
			default boolean test(T x, java.lang.Double y) {
				return testDouble(x, y);
			}
		}

		@FunctionalInterface
		interface AndLong<T> extends BiPredicate<T, java.lang.Long> {

			boolean testLong(T x, long y);

			@Override
			default boolean test(T x, java.lang.Long y) {
				return testLong(x, y);
			}
		}

		@FunctionalInterface
		interface AndInt<T> extends BiPredicate<T, java.lang.Integer> {

			boolean testInt(T x, int y);

			@Override
			default boolean test(T x, java.lang.Integer y) {
				return testInt(x, y);
			}
		}

		@FunctionalInterface
		interface AndFloat<T> extends BiPredicate<T, java.lang.Float> {

			boolean testFloat(T x, float y);

			@Override
			default boolean test(T x, java.lang.Float y) {
				return testFloat(x, y);
			}
		}

		@FunctionalInterface
		interface AndChar<T> extends BiPredicate<T, Character> {

			boolean testChar(T x, char y);

			@Override
			default boolean test(T x, Character y) {
				return testChar(x, y);
			}
		}

		@FunctionalInterface
		interface AndShort<T> extends BiPredicate<T, java.lang.Short> {

			boolean testShort(T x, short y);

			@Override
			default boolean test(T x, java.lang.Short y) {
				return testShort(x, y);
			}
		}

		@FunctionalInterface
		interface AndByte<T> extends BiPredicate<T, java.lang.Byte> {

			boolean testByte(T x, byte y);

			@Override
			default boolean test(T x, java.lang.Byte y) {
				return testByte(x, y);
			}
		}

		@FunctionalInterface
		interface AndBoolean<T> extends BiPredicate<T, java.lang.Boolean> {

			boolean testBoolean(T x, boolean y);

			@Override
			default boolean test(T x, java.lang.Boolean y) {
				return testBoolean(x, y);
			}
		}
	}

	/**
	 * Interface that extends {@code java.util.function.Predicate} so that an
	 * {@code int} can be used as the argument.
	 */
	@FunctionalInterface
	public static interface Predicate<T> extends java.util.function.Predicate<T> {}

	// Private constructor to prevent instantiation
	private Obj() {
	}

}
