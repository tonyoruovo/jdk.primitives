/**
 * 
 */
package jdk.prim.util.function;

import java.util.Objects;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

/**
 * 
 */
public final class Byte {
	@FunctionalInterface
	public static interface BiFunction<T, U> extends java.util.function.BiFunction<T, U, java.lang.Byte> {

		@FunctionalInterface
		interface AndDouble<T> extends BiFunction<T, java.lang.Double> {
			byte applyDouble(T x, double y);

			@Override
			default byte applyObj(T x, java.lang.Double y) {
				return applyDouble(x, y);
			}
		}

		@FunctionalInterface
		interface AndLong<T> extends BiFunction<T, java.lang.Long> {
			byte applyLong(T x, long y);

			@Override
			default byte applyObj(T x, java.lang.Long y) {
				return applyLong(x, y);
			}
		}

		@FunctionalInterface
		interface AndInt<T> extends BiFunction<T, java.lang.Integer> {
			byte applyInt(T x, int y);

			@Override
			default byte applyObj(T x, java.lang.Integer y) {
				return applyInt(x, y);
			}
		}

		@FunctionalInterface
		interface AndFloat<T> extends BiFunction<T, java.lang.Float> {
			byte applyFloat(T x, float y);

			@Override
			default byte applyObj(T x, java.lang.Float y) {
				return applyFloat(x, y);
			}
		}

		@FunctionalInterface
		interface AndChar<T> extends BiFunction<T, java.lang.Character> {
			byte applyChar(T x, char y);

			@Override
			default byte applyObj(T x, java.lang.Character y) {
				return applyChar(x, y);
			}
		}

		@FunctionalInterface
		interface AndShort<T> extends BiFunction<T, java.lang.Short> {
			byte applyShort(T x, short y);

			@Override
			default byte applyObj(T x, java.lang.Short y) {
				return applyShort(x, y);
			}
		}

		@FunctionalInterface
		interface AndByte<T> extends BiFunction<T, java.lang.Byte> {
			byte applyByte(T x, byte y);

			@Override
			default byte applyObj(T x, java.lang.Byte y) {
				return applyByte(x, y);
			}
		}

		@FunctionalInterface
		interface AndBoolean<T> extends BiFunction<T, java.lang.Boolean> {
			byte applyBoolean(T x, boolean y);

			@Override
			default byte applyObj(T x, java.lang.Boolean y) {
				return applyBoolean(x, y);
			}
		}

		@FunctionalInterface
		interface OfDouble<T> extends BiFunction<java.lang.Double, T> {

			@FunctionalInterface
			interface AndDouble extends OfDouble<java.lang.Double> {

				byte applyDouble(double x, double y);

				@Override
				default byte applyDouble(double x, java.lang.Double y) {
					return applyDouble(x, (double) y);
				}
			}

			@FunctionalInterface
			interface AndLong extends OfDouble<java.lang.Long> {

				byte applyLong(double x, long y);

				@Override
				default byte applyDouble(double x, java.lang.Long y) {
					return applyLong(x, y);
				}
			}

			@FunctionalInterface
			interface AndFloat extends OfDouble<java.lang.Float> {

				byte applyFloat(double x, float y);

				@Override
				default byte applyDouble(double x, java.lang.Float y) {
					return applyFloat(x, y);
				}
			}

			@FunctionalInterface
			interface AndChar extends OfDouble<Character> {

				byte applyChar(double x, char y);

				@Override
				default byte applyDouble(double x, Character y) {
					return applyChar(x, y);
				}
			}

			@FunctionalInterface
			interface AndInt extends OfDouble<java.lang.Integer> {
				byte applyInt(double x, int y);

				@Override
				default byte applyDouble(double x, java.lang.Integer y) {
					return applyInt(x, y);
				}
			}

			@FunctionalInterface
			interface AndShort extends OfDouble<java.lang.Short> {

				byte applyShort(double x, short y);

				@Override
				default byte applyDouble(double x, java.lang.Short y) {
					return applyShort(x, y);
				}
			}

			@FunctionalInterface
			interface AndByte extends OfDouble<java.lang.Byte> {

				byte applyByte(double x, byte y);

				@Override
				default byte applyDouble(double x, java.lang.Byte y) {
					return applyByte(x, y);
				}
			}

			@FunctionalInterface
			interface AndBoolean extends OfDouble<java.lang.Boolean> {

				byte applyBoolean(double x, boolean y);

				@Override
				default byte applyDouble(double x, java.lang.Boolean y) {
					return applyBoolean(x, y);
				}
			}

			byte applyDouble(double x, T y);

			@Override
			default byte applyObj(java.lang.Double x, T y) {
				return applyDouble(x, y);
			}
		}

		@FunctionalInterface
		interface OfLong<T> extends BiFunction<java.lang.Long, T> {

			@FunctionalInterface
			interface AndDouble extends OfLong<java.lang.Double> {

				byte applyDouble(long x, double y);

				@Override
				default byte applyLong(long x, java.lang.Double y) {
					return applyDouble(x, y);
				}
			}

			@FunctionalInterface
			interface AndLong extends OfLong<java.lang.Long> {

				byte applyLong(long x, long y);

				@Override
				default byte applyLong(long x, java.lang.Long y) {
					return applyLong(x, (long) y);
				}
			}

			@FunctionalInterface
			interface AndFloat extends OfLong<java.lang.Float> {

				byte applyFloat(long x, float y);

				@Override
				default byte applyLong(long x, java.lang.Float y) {
					return applyFloat(x, y);
				}
			}

			@FunctionalInterface
			interface AndChar extends OfLong<Character> {

				byte applyChar(long x, char y);

				@Override
				default byte applyLong(long x, Character y) {
					return applyChar(x, y);
				}
			}

			@FunctionalInterface
			interface AndInt extends OfLong<java.lang.Integer> {
				byte applyInt(long x, int y);

				@Override
				default byte applyLong(long x, java.lang.Integer y) {
					return applyInt(x, y);
				}
			}

			@FunctionalInterface
			interface AndShort extends OfLong<java.lang.Short> {

				byte applyShort(long x, short y);

				@Override
				default byte applyLong(long x, java.lang.Short y) {
					return applyShort(x, y);
				}
			}

			@FunctionalInterface
			interface AndByte extends OfLong<java.lang.Byte> {

				byte applyByte(long x, byte y);

				@Override
				default byte applyLong(long x, java.lang.Byte y) {
					return applyByte(x, y);
				}
			}

			@FunctionalInterface
			interface AndBoolean extends OfLong<java.lang.Boolean> {

				byte applyBoolean(long x, boolean y);

				@Override
				default byte applyLong(long x, java.lang.Boolean y) {
					return applyBoolean(x, y);
				}
			}

			byte applyLong(long x, T y);

			@Override
			default byte applyObj(java.lang.Long x, T y) {
				return applyLong(x, y);
			}
		}

		@FunctionalInterface
		interface OfInt<T> extends BiFunction<java.lang.Integer, T> {

			@FunctionalInterface
			interface AndDouble extends OfInt<java.lang.Double> {

				byte applyDouble(int x, double y);

				@Override
				default byte applyInt(int x, java.lang.Double y) {
					return applyDouble(x, y);
				}
			}

			@FunctionalInterface
			interface AndLong extends OfInt<java.lang.Long> {

				byte applyLong(int x, long y);

				@Override
				default byte applyInt(int x, java.lang.Long y) {
					return applyLong(x, y);
				}
			}

			@FunctionalInterface
			interface AndFloat extends OfInt<java.lang.Float> {

				byte applyFloat(int x, float y);

				@Override
				default byte applyInt(int x, java.lang.Float y) {
					return applyFloat(x, y);
				}
			}

			@FunctionalInterface
			interface AndChar extends OfInt<Character> {

				byte applyChar(int x, char y);

				@Override
				default byte applyInt(int x, Character y) {
					return applyChar(x, y);
				}
			}

			@FunctionalInterface
			interface AndInt extends OfInt<java.lang.Integer> {
				byte applyInt(int x, int y);

				@Override
				default byte applyInt(int x, java.lang.Integer y) {
					return applyInt(x, (int) y);
				}
			}

			@FunctionalInterface
			interface AndShort extends OfInt<java.lang.Short> {

				byte applyShort(int x, short y);

				@Override
				default byte applyInt(int x, java.lang.Short y) {
					return applyShort(x, y);
				}
			}

			@FunctionalInterface
			interface AndByte extends OfInt<java.lang.Byte> {

				byte applyByte(int x, byte y);

				@Override
				default byte applyInt(int x, java.lang.Byte y) {
					return applyByte(x, y);
				}
			}

			@FunctionalInterface
			interface AndBoolean extends OfInt<java.lang.Boolean> {

				byte applyBoolean(int x, boolean y);

				@Override
				default byte applyInt(int x, java.lang.Boolean y) {
					return applyBoolean(x, y);
				}
			}

			byte applyInt(int x, T y);

			@Override
			default byte applyObj(java.lang.Integer x, T y) {
				return applyInt(x, y);
			}
		}

		@FunctionalInterface
		interface OfFloat<T> extends BiFunction<java.lang.Float, T> {

			@FunctionalInterface
			interface AndDouble extends OfFloat<java.lang.Double> {

				byte applyDouble(float x, double y);

				@Override
				default byte applyFloat(float x, java.lang.Double y) {
					return applyDouble(x, y);
				}
			}

			@FunctionalInterface
			interface AndLong extends OfFloat<java.lang.Long> {

				byte applyLong(float x, long y);

				@Override
				default byte applyFloat(float x, java.lang.Long y) {
					return applyLong(x, y);
				}
			}

			@FunctionalInterface
			interface AndFloat extends OfFloat<java.lang.Float> {

				byte applyFloat(float x, float y);

				@Override
				default byte applyFloat(float x, java.lang.Float y) {
					return applyFloat(x, (float) y);
				}
			}

			@FunctionalInterface
			interface AndChar extends OfFloat<Character> {

				byte applyChar(float x, char y);

				@Override
				default byte applyFloat(float x, Character y) {
					return applyChar(x, y);
				}
			}

			@FunctionalInterface
			interface AndInt extends OfFloat<java.lang.Integer> {
				byte applyInt(float x, int y);

				@Override
				default byte applyFloat(float x, java.lang.Integer y) {
					return applyInt(x, (int) y);
				}
			}

			@FunctionalInterface
			interface AndShort extends OfFloat<java.lang.Short> {

				byte applyShort(float x, short y);

				@Override
				default byte applyFloat(float x, java.lang.Short y) {
					return applyShort(x, y);
				}
			}

			@FunctionalInterface
			interface AndByte extends OfFloat<java.lang.Byte> {

				byte applyByte(float x, byte y);

				@Override
				default byte applyFloat(float x, java.lang.Byte y) {
					return applyByte(x, y);
				}
			}

			@FunctionalInterface
			interface AndBoolean extends OfFloat<java.lang.Boolean> {

				byte applyBoolean(float x, boolean y);

				@Override
				default byte applyFloat(float x, java.lang.Boolean y) {
					return applyBoolean(x, y);
				}
			}

			byte applyFloat(float x, T y);

			@Override
			default byte applyObj(java.lang.Float x, T y) {
				return applyFloat(x, y);
			}
		}

		@FunctionalInterface
		interface OfChar<T> extends BiFunction<java.lang.Character, T> {

			@FunctionalInterface
			interface AndDouble extends OfChar<java.lang.Double> {

				byte applyDouble(char x, double y);

				@Override
				default byte applyChar(char x, java.lang.Double y) {
					return applyDouble(x, y);
				}
			}

			@FunctionalInterface
			interface AndLong extends OfChar<java.lang.Long> {

				byte applyLong(char x, long y);

				@Override
				default byte applyChar(char x, java.lang.Long y) {
					return applyLong(x, y);
				}
			}

			@FunctionalInterface
			interface AndFloat extends OfChar<java.lang.Float> {

				byte applyFloat(char x, float y);

				@Override
				default byte applyChar(char x, java.lang.Float y) {
					return applyFloat(x, y);
				}
			}

			@FunctionalInterface
			interface AndChar extends OfChar<Character> {

				byte applyChar(char x, char y);

				@Override
				default byte applyChar(char x, Character y) {
					return applyChar(x, (char) y);
				}
			}

			@FunctionalInterface
			interface AndInt extends OfChar<java.lang.Integer> {
				byte applyInt(char x, int y);

				@Override
				default byte applyChar(char x, java.lang.Integer y) {
					return applyInt(x, (int) y);
				}
			}

			@FunctionalInterface
			interface AndShort extends OfChar<java.lang.Short> {

				byte applyShort(char x, short y);

				@Override
				default byte applyChar(char x, java.lang.Short y) {
					return applyShort(x, y);
				}
			}

			@FunctionalInterface
			interface AndByte extends OfChar<java.lang.Byte> {

				byte applyByte(char x, byte y);

				@Override
				default byte applyChar(char x, java.lang.Byte y) {
					return applyByte(x, y);
				}
			}

			@FunctionalInterface
			interface AndBoolean extends OfChar<java.lang.Boolean> {

				byte applyBoolean(char x, boolean y);

				@Override
				default byte applyChar(char x, java.lang.Boolean y) {
					return applyBoolean(x, y);
				}
			}

			byte applyChar(char x, T y);

			@Override
			default byte applyObj(java.lang.Character x, T y) {
				return applyChar(x, y);
			}
		}

		@FunctionalInterface
		interface OfShort<T> extends BiFunction<java.lang.Short, T> {

			@FunctionalInterface
			interface AndDouble extends OfShort<java.lang.Double> {

				byte applyDouble(short x, double y);

				@Override
				default byte applyShort(short x, java.lang.Double y) {
					return applyDouble(x, y);
				}
			}

			@FunctionalInterface
			interface AndLong extends OfShort<java.lang.Long> {

				byte applyLong(short x, long y);

				@Override
				default byte applyShort(short x, java.lang.Long y) {
					return applyLong(x, y);
				}
			}

			@FunctionalInterface
			interface AndFloat extends OfShort<java.lang.Float> {

				byte applyFloat(short x, float y);

				@Override
				default byte applyShort(short x, java.lang.Float y) {
					return applyFloat(x, y);
				}
			}

			@FunctionalInterface
			interface AndChar extends OfShort<Character> {

				byte applyChar(short x, char y);

				@Override
				default byte applyShort(short x, Character y) {
					return applyChar(x, y);
				}
			}

			@FunctionalInterface
			interface AndInt extends OfShort<java.lang.Integer> {
				byte applyInt(short x, int y);

				@Override
				default byte applyShort(short x, java.lang.Integer y) {
					return applyInt(x, y);
				}
			}

			@FunctionalInterface
			interface AndShort extends OfShort<java.lang.Short> {

				byte applyShort(short x, short y);

				@Override
				default byte applyShort(short x, java.lang.Short y) {
					return applyShort(x, (short) y);
				}
			}

			@FunctionalInterface
			interface AndByte extends OfShort<java.lang.Byte> {

				byte applyByte(short x, byte y);

				@Override
				default byte applyShort(short x, java.lang.Byte y) {
					return applyByte(x, y);
				}
			}

			@FunctionalInterface
			interface AndBoolean extends OfShort<java.lang.Boolean> {

				byte applyBoolean(short x, boolean y);

				@Override
				default byte applyShort(short x, java.lang.Boolean y) {
					return applyBoolean(x, y);
				}
			}

			byte applyShort(short x, T y);

			@Override
			default byte applyObj(java.lang.Short x, T y) {
				return applyShort(x, y);
			}
		}

		@FunctionalInterface
		interface OfByte<T> extends BiFunction<java.lang.Byte, T> {

			@FunctionalInterface
			interface AndDouble extends OfByte<java.lang.Double> {

				byte applyDouble(byte x, double y);

				@Override
				default byte applyByte(byte x, java.lang.Double y) {
					return applyDouble(x, y);
				}
			}

			@FunctionalInterface
			interface AndLong extends OfByte<java.lang.Long> {

				byte applyLong(byte x, long y);

				@Override
				default byte applyByte(byte x, java.lang.Long y) {
					return applyLong(x, y);
				}
			}

			@FunctionalInterface
			interface AndFloat extends OfByte<java.lang.Float> {

				byte applyFloat(byte x, float y);

				@Override
				default byte applyByte(byte x, java.lang.Float y) {
					return applyFloat(x, y);
				}
			}

			@FunctionalInterface
			interface AndChar extends OfByte<Character> {

				byte applyChar(byte x, char y);

				@Override
				default byte applyByte(byte x, Character y) {
					return applyChar(x, y);
				}
			}

			@FunctionalInterface
			interface AndInt extends OfByte<java.lang.Integer> {
				byte applyInt(byte x, int y);

				@Override
				default byte applyByte(byte x, java.lang.Integer y) {
					return applyInt(x, y);
				}
			}

			@FunctionalInterface
			interface AndShort extends OfByte<java.lang.Short> {

				byte applyShort(byte x, short y);

				@Override
				default byte applyByte(byte x, java.lang.Short y) {
					return applyShort(x, y);
				}
			}

			@FunctionalInterface
			interface AndByte extends OfByte<java.lang.Byte>, BinaryOperator<java.lang.Byte> {

				byte applyByte(byte x, byte y);

				@Override
				default byte applyByte(byte x, java.lang.Byte y) {
					return applyByte(x, (byte) y);
				}
			}

			@FunctionalInterface
			interface AndBoolean extends OfByte<java.lang.Boolean> {

				byte applyBoolean(byte x, boolean y);

				@Override
				default byte applyByte(byte x, java.lang.Boolean y) {
					return applyBoolean(x, y);
				}
			}

			byte applyByte(byte x, T y);

			@Override
			default byte applyObj(java.lang.Byte x, T y) {
				return applyByte(x, y);
			}
		}

		@FunctionalInterface
		interface OfBoolean<T> extends BiFunction<java.lang.Boolean, T> {

			@FunctionalInterface
			interface AndDouble extends OfBoolean<java.lang.Double> {

				byte applyDouble(boolean x, double y);

				@Override
				default byte applyBoolean(boolean x, java.lang.Double y) {
					return applyDouble(x, y);
				}
			}

			@FunctionalInterface
			interface AndLong extends OfBoolean<java.lang.Long> {

				byte applyLong(boolean x, long y);

				@Override
				default byte applyBoolean(boolean x, java.lang.Long y) {
					return applyLong(x, y);
				}
			}

			@FunctionalInterface
			interface AndFloat extends OfBoolean<java.lang.Float> {

				byte applyFloat(boolean x, float y);

				@Override
				default byte applyBoolean(boolean x, java.lang.Float y) {
					return applyFloat(x, y);
				}
			}

			@FunctionalInterface
			interface AndChar extends OfBoolean<Character> {

				byte applyChar(boolean x, char y);

				@Override
				default byte applyBoolean(boolean x, Character y) {
					return applyChar(x, y);
				}
			}

			@FunctionalInterface
			interface AndInt extends OfBoolean<java.lang.Integer> {
				byte applyInt(boolean x, int y);

				@Override
				default byte applyBoolean(boolean x, java.lang.Integer y) {
					return applyInt(x, y);
				}
			}

			@FunctionalInterface
			interface AndShort extends OfBoolean<java.lang.Short> {

				byte applyShort(boolean x, short y);

				@Override
				default byte applyBoolean(boolean x, java.lang.Short y) {
					return applyShort(x, y);
				}
			}

			@FunctionalInterface
			interface AndByte extends OfBoolean<java.lang.Byte> {

				byte applyByte(boolean x, byte y);

				@Override
				default byte applyBoolean(boolean x, java.lang.Byte y) {
					return applyByte(x, y);
				}
			}

			@FunctionalInterface
			interface AndBoolean extends OfBoolean<java.lang.Boolean> {

				byte applyBoolean(boolean x, boolean y);

				@Override
				default byte applyBoolean(boolean x, java.lang.Boolean y) {
					return applyBoolean(x, (boolean) y);
				}
			}

			byte applyBoolean(boolean x, T y);

			@Override
			default byte applyObj(java.lang.Boolean x, T y) {
				return applyBoolean(x, y);
			}
		}

		byte applyObj(T x, U y);

		@Override
		default java.lang.Byte apply(T x, U y) {
			return applyObj(x, y);
		}
	}

	@FunctionalInterface
	public static interface Function<T> extends java.util.function.Function<T, java.lang.Byte> {
		@FunctionalInterface
		interface OfDouble extends Function<java.lang.Double> {
			byte applyDouble(double x);

			@Override
			default byte applyObj(java.lang.Double x) {
				return applyDouble(x);
			}
		}

		@FunctionalInterface
		interface OfLong extends Function<java.lang.Long> {
			byte applyLong(long x);

			@Override
			default byte applyObj(java.lang.Long x) {
				return applyLong(x);
			}
		}

		@FunctionalInterface
		interface OfFloat extends Function<java.lang.Float> {
			byte applyFloat(float x);

			@Override
			default byte applyObj(java.lang.Float x) {
				return applyFloat(x);
			}
		}

		@FunctionalInterface
		interface OfInt extends Function<java.lang.Integer> {
			byte applyInt(int x);

			@Override
			default byte applyObj(java.lang.Integer x) {
				return applyInt(x);
			}
		}

		@FunctionalInterface
		interface OfChar extends Function<Character> {
			byte applyChar(char x);

			@Override
			default byte applyObj(Character x) {
				return applyChar(x);
			}
		}

		@FunctionalInterface
		interface OfShort extends Function<java.lang.Short> {
			byte applyShort(short x);

			@Override
			default byte applyObj(java.lang.Short x) {
				return applyShort(x);
			}
		}

		@FunctionalInterface
		interface OfByte extends Function<java.lang.Byte>, UnaryOperator<java.lang.Byte> {
			byte applyByte(byte x);

			@Override
			default byte applyObj(java.lang.Byte x) {
				return applyByte(x);
			}
		}

		@FunctionalInterface
		interface OfBoolean extends Function<java.lang.Boolean> {
			byte applyBoolean(boolean x);

			@Override
			default byte applyObj(java.lang.Boolean x) {
				return applyBoolean(x);
			}
		}

		byte applyObj(T x);

		@Override
		default java.lang.Byte apply(T x) {
			return applyObj(x);
		}
	}

	/**
	 * Utility class that defines an interface that complements
	 * {@code java.util.function.Supplier} so that an {@code int} can be used as the
	 * argument.
	 */
	@FunctionalInterface
	public static interface Supplier extends java.util.function.Supplier<java.lang.Byte> {
		/*
		 * Date created: 17 May 2024 Time created: 11:06:46
		 */
		/**
		 * Gets an {@code int} result.
		 *
		 * @return an {@code int} result
		 */
		byte getByte();

		/*
		 * Date created: 17 May 2024 Time created: 10:56:01
		 */
		/**
		 * {@inheritDoc}
		 * 
		 * @return {@inheritDoc}
		 */
		@Override
		default java.lang.Byte get() {
			return getByte();
		}
	}

	@FunctionalInterface
	public static interface BiConsumer<T> extends java.util.function.BiConsumer<java.lang.Byte, T> {

		@FunctionalInterface
		interface AndDouble extends BiConsumer<java.lang.Double> {

			void acceptDouble(byte x, double y);

			@Override
			default void acceptObj(byte x, java.lang.Double y) {
				acceptDouble(x, y);
			}
		}

		@FunctionalInterface
		interface AndLong extends BiConsumer<java.lang.Long> {

			void acceptLong(byte x, long y);

			@Override
			default void acceptObj(byte x, java.lang.Long y) {
				acceptLong(x, y);
			}
		}

		@FunctionalInterface
		interface AndInt extends BiConsumer<java.lang.Integer> {

			void acceptInt(byte x, int y);

			@Override
			default void acceptObj(byte x, java.lang.Integer y) {
				acceptInt(x, y);
			}
		}

		@FunctionalInterface
		interface AndFloat extends BiConsumer<java.lang.Float> {

			void acceptFloat(byte x, float y);

			@Override
			default void acceptObj(byte x, java.lang.Float y) {
				acceptFloat(x, y);
			}
		}

		@FunctionalInterface
		interface AndChar extends BiConsumer<Character> {

			void acceptChar(byte x, char y);

			@Override
			default void acceptObj(byte x, Character y) {
				acceptChar(x, y);
			}
		}

		@FunctionalInterface
		interface AndShort extends BiConsumer<java.lang.Short> {

			void acceptShort(byte x, short y);

			@Override
			default void acceptObj(byte x, java.lang.Short y) {
				acceptShort(x, y);
			}
		}

		@FunctionalInterface
		interface AndByte extends BiConsumer<java.lang.Byte> {

			void acceptByte(byte x, byte y);

			@Override
			default void acceptObj(byte x, java.lang.Byte y) {
				acceptByte(x, y);
			}
		}

		@FunctionalInterface
		interface AndBoolean extends BiConsumer<java.lang.Boolean> {

			void acceptBoolean(byte x, boolean y);

			@Override
			default void acceptObj(byte x, java.lang.Boolean y) {
				acceptBoolean(x, y);
			}
		}

		void acceptObj(byte x, T y);

		@Override
		default void accept(java.lang.Byte x, T y) {
			acceptObj(x, y);
		}
	}

	/**
	 * Utility class that defines an interface that complements
	 * {@code java.util.function.Consumer} so that an {@code int} can be used as the
	 * argument.
	 */
	@FunctionalInterface
	public static interface Consumer extends java.util.function.Consumer<java.lang.Byte> {
		/**
		 * Performs this operation on the given {@code int} argument.
		 *
		 * @param i the input {@code int} argument
		 */
		void acceptByte(byte i);

		/*
		 * Date created: 17 May 2024 Time created: 10:56:01
		 */
		/**
		 * {@inheritDoc}
		 * 
		 * @param i {@inheritDoc}
		 */
		@Override
		default void accept(java.lang.Byte i) {
			acceptByte(i);
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
		default Consumer andThenByte(Consumer after) {
			Objects.requireNonNull(after);
			return x -> {
				acceptByte(x);
				after.acceptByte(x);
			};
		}
		
		/*
		 * Date created: 28 May 2024
		 * Time created: 13:19:50
		 */
		/**
		 * {@inheritDoc}
		 * @param after {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		@Override
		default Consumer andThen(
				java.util.function.Consumer<? super java.lang.Byte> after) {
			if(after instanceof Consumer) return andThenByte((Consumer) after);
			Objects.requireNonNull(after);
			return x -> {
				acceptByte(x);
				after.accept(x);
			};
		}
	}

	@FunctionalInterface
	public static interface BiPredicate<T> extends java.util.function.BiPredicate<java.lang.Byte, T> {

		@FunctionalInterface
		interface AndDouble extends BiPredicate<java.lang.Double> {

			boolean testDouble(byte x, double y);

			@Override
			default boolean testObj(byte x, java.lang.Double y) {
				return testDouble(x, y);
			}
		}

		@FunctionalInterface
		interface AndLong extends BiPredicate<java.lang.Long> {

			boolean testLong(byte x, long y);

			@Override
			default boolean testObj(byte x, java.lang.Long y) {
				return testLong(x, y);
			}
		}

		@FunctionalInterface
		interface AndInt extends BiPredicate<java.lang.Integer> {

			boolean testInt(byte x, int y);

			@Override
			default boolean testObj(byte x, java.lang.Integer y) {
				return testInt(x, y);
			}
		}

		@FunctionalInterface
		interface AndFloat extends BiPredicate<java.lang.Float> {

			boolean testFloat(byte x, float y);

			@Override
			default boolean testObj(byte x, java.lang.Float y) {
				return testFloat(x, y);
			}
		}

		@FunctionalInterface
		interface AndChar extends BiPredicate<Character> {

			boolean testChar(byte x, char y);

			@Override
			default boolean testObj(byte x, Character y) {
				return testChar(x, y);
			}
		}

		@FunctionalInterface
		interface AndShort extends BiPredicate<java.lang.Short> {

			boolean testShort(byte x, short y);

			@Override
			default boolean testObj(byte x, java.lang.Short y) {
				return testShort(x, y);
			}
		}

		@FunctionalInterface
		interface AndByte extends BiPredicate<java.lang.Byte> {

			boolean testByte(byte x, byte y);

			@Override
			default boolean testObj(byte x, java.lang.Byte y) {
				return testByte(x, y);
			}
		}

		@FunctionalInterface
		interface AndBoolean extends BiPredicate<java.lang.Boolean> {

			boolean testBoolean(byte x, boolean y);

			@Override
			default boolean testObj(byte x, java.lang.Boolean y) {
				return testBoolean(x, y);
			}
		}

		boolean testObj(byte x, T y);

		@Override
		default boolean test(java.lang.Byte x, T y) {
			return testObj(x, y);
		}
	}

	/**
	 * Interface that extends {@code java.util.function.Predicate} so that an
	 * {@code int} can be used as the argument.
	 */
	@FunctionalInterface
	public static interface Predicate extends java.util.function.Predicate<java.lang.Byte> {
		/**
		 * Evaluates this predicate on the given {@code int} argument.
		 *
		 * @param i the {@code int} input argument
		 * @return {@code true} if the input argument matches the predicate, otherwise
		 *         {@code false}
		 */
		boolean testByte(byte i);

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
		default boolean test(java.lang.Byte t) {
			return testByte(t);
		}

		default Predicate andByte(Predicate other) {
			Objects.requireNonNull(other);
			return x -> testByte(x) && other.testByte(x);
		}

		default Predicate negateByte() {
			return x -> !testByte(x);
		}

		default Predicate orByte(Predicate other) {
			Objects.requireNonNull(other);
			return x -> testByte(x) || other.testByte(x);
		}

		/*
		 * Date created: 28 May 2024
		 * Time created: 13:32:56
		 */
		/**
		 * {@inheritDoc}
		 * @param other {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		@Override
		default Predicate or(
				java.util.function.Predicate<? super java.lang.Byte> other) {
			if(other instanceof Predicate) return orByte((Predicate) other);
			return orByte(other::test);
		}

		/*
		 * Date created: 28 May 2024
		 * Time created: 13:32:56
		 */
		/**
		 * {@inheritDoc}
		 * @param other {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		@Override
		default Predicate and(
				java.util.function.Predicate<? super java.lang.Byte> other) {
			if(other instanceof Predicate) return andByte((Predicate) other);
			return andByte(other::test);
		}
		
		/*
		 * Date created: 28 May 2024
		 * Time created: 13:36:03
		 */
		/**
		 * {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		@Override
		default Predicate negate() {
			return x -> !testByte(x);
		}
	}

	// Private constructor to prevent instantiation
	private Byte() {
	}

}
