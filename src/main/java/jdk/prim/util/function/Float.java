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
public final class Float {
	@FunctionalInterface
	public static interface BiFunction<T, U> extends java.util.function.BiFunction<T, U, java.lang.Float> {

		@FunctionalInterface
		interface AndDouble<T> extends BiFunction<T, java.lang.Double> {
			float applyDouble(T x, double y);

			@Override
			default float applyObj(T x, java.lang.Double y) {
				return applyDouble(x, y);
			}
		}

		@FunctionalInterface
		interface AndLong<T> extends BiFunction<T, java.lang.Long> {
			float applyLong(T x, long y);

			@Override
			default float applyObj(T x, java.lang.Long y) {
				return applyLong(x, y);
			}
		}

		@FunctionalInterface
		interface AndInt<T> extends BiFunction<T, java.lang.Integer> {
			float applyInt(T x, int y);

			@Override
			default float applyObj(T x, java.lang.Integer y) {
				return applyInt(x, y);
			}
		}

		@FunctionalInterface
		interface AndFloat<T> extends BiFunction<T, java.lang.Float> {
			float applyFloat(T x, float y);

			@Override
			default float applyObj(T x, java.lang.Float y) {
				return applyFloat(x, y);
			}
		}

		@FunctionalInterface
		interface AndChar<T> extends BiFunction<T, java.lang.Character> {
			float applyChar(T x, char y);

			@Override
			default float applyObj(T x, java.lang.Character y) {
				return applyChar(x, y);
			}
		}

		@FunctionalInterface
		interface AndShort<T> extends BiFunction<T, java.lang.Short> {
			float applyShort(T x, short y);

			@Override
			default float applyObj(T x, java.lang.Short y) {
				return applyShort(x, y);
			}
		}

		@FunctionalInterface
		interface AndByte<T> extends BiFunction<T, java.lang.Byte> {
			float applyByte(T x, byte y);

			@Override
			default float applyObj(T x, java.lang.Byte y) {
				return applyByte(x, y);
			}
		}

		@FunctionalInterface
		interface AndBoolean<T> extends BiFunction<T, java.lang.Boolean> {
			float applyBoolean(T x, boolean y);

			@Override
			default float applyObj(T x, java.lang.Boolean y) {
				return applyBoolean(x, y);
			}
		}

		@FunctionalInterface
		interface OfDouble<T> extends BiFunction<java.lang.Double, T> {

			@FunctionalInterface
			interface AndDouble extends OfDouble<java.lang.Double> {

				float applyDouble(double x, double y);

				@Override
				default float applyDouble(double x, java.lang.Double y) {
					return applyDouble(x, (double) y);
				}
			}

			@FunctionalInterface
			interface AndLong extends OfDouble<java.lang.Long> {

				float applyLong(double x, long y);

				@Override
				default float applyDouble(double x, java.lang.Long y) {
					return applyLong(x, y);
				}
			}

			@FunctionalInterface
			interface AndFloat extends OfDouble<java.lang.Float> {

				float applyFloat(double x, float y);

				@Override
				default float applyDouble(double x, java.lang.Float y) {
					return applyFloat(x, y);
				}
			}

			@FunctionalInterface
			interface AndChar extends OfDouble<Character> {

				float applyChar(double x, char y);

				@Override
				default float applyDouble(double x, Character y) {
					return applyChar(x, y);
				}
			}

			@FunctionalInterface
			interface AndInt extends OfDouble<java.lang.Integer> {
				float applyInt(double x, int y);

				@Override
				default float applyDouble(double x, java.lang.Integer y) {
					return applyInt(x, y);
				}
			}

			@FunctionalInterface
			interface AndShort extends OfDouble<java.lang.Short> {

				float applyShort(double x, short y);

				@Override
				default float applyDouble(double x, java.lang.Short y) {
					return applyShort(x, y);
				}
			}

			@FunctionalInterface
			interface AndByte extends OfDouble<java.lang.Byte> {

				float applyByte(double x, byte y);

				@Override
				default float applyDouble(double x, java.lang.Byte y) {
					return applyByte(x, y);
				}
			}

			@FunctionalInterface
			interface AndBoolean extends OfDouble<java.lang.Boolean> {

				float applyBoolean(double x, boolean y);

				@Override
				default float applyDouble(double x, java.lang.Boolean y) {
					return applyBoolean(x, y);
				}
			}

			float applyDouble(double x, T y);

			@Override
			default float applyObj(java.lang.Double x, T y) {
				return applyDouble(x, y);
			}
		}

		@FunctionalInterface
		interface OfLong<T> extends BiFunction<java.lang.Long, T> {

			@FunctionalInterface
			interface AndDouble extends OfLong<java.lang.Double> {

				float applyDouble(long x, double y);

				@Override
				default float applyLong(long x, java.lang.Double y) {
					return applyDouble(x, y);
				}
			}

			@FunctionalInterface
			interface AndLong extends OfLong<java.lang.Long> {

				float applyLong(long x, long y);

				@Override
				default float applyLong(long x, java.lang.Long y) {
					return applyLong(x, (long) y);
				}
			}

			@FunctionalInterface
			interface AndFloat extends OfLong<java.lang.Float> {

				float applyFloat(long x, float y);

				@Override
				default float applyLong(long x, java.lang.Float y) {
					return applyFloat(x, y);
				}
			}

			@FunctionalInterface
			interface AndChar extends OfLong<Character> {

				float applyChar(long x, char y);

				@Override
				default float applyLong(long x, Character y) {
					return applyChar(x, y);
				}
			}

			@FunctionalInterface
			interface AndInt extends OfLong<java.lang.Integer> {
				float applyInt(long x, int y);

				@Override
				default float applyLong(long x, java.lang.Integer y) {
					return applyInt(x, y);
				}
			}

			@FunctionalInterface
			interface AndShort extends OfLong<java.lang.Short> {

				float applyShort(long x, short y);

				@Override
				default float applyLong(long x, java.lang.Short y) {
					return applyShort(x, y);
				}
			}

			@FunctionalInterface
			interface AndByte extends OfLong<java.lang.Byte> {

				float applyByte(long x, byte y);

				@Override
				default float applyLong(long x, java.lang.Byte y) {
					return applyByte(x, y);
				}
			}

			@FunctionalInterface
			interface AndBoolean extends OfLong<java.lang.Boolean> {

				float applyBoolean(long x, boolean y);

				@Override
				default float applyLong(long x, java.lang.Boolean y) {
					return applyBoolean(x, y);
				}
			}

			float applyLong(long x, T y);

			@Override
			default float applyObj(java.lang.Long x, T y) {
				return applyLong(x, y);
			}
		}

		@FunctionalInterface
		interface OfInt<T> extends BiFunction<java.lang.Integer, T> {

			@FunctionalInterface
			interface AndDouble extends OfInt<java.lang.Double> {

				float applyDouble(int x, double y);

				@Override
				default float applyInt(int x, java.lang.Double y) {
					return applyDouble(x, y);
				}
			}

			@FunctionalInterface
			interface AndLong extends OfInt<java.lang.Long> {

				float applyLong(int x, long y);

				@Override
				default float applyInt(int x, java.lang.Long y) {
					return applyLong(x, y);
				}
			}

			@FunctionalInterface
			interface AndFloat extends OfInt<java.lang.Float> {

				float applyFloat(int x, float y);

				@Override
				default float applyInt(int x, java.lang.Float y) {
					return applyFloat(x, y);
				}
			}

			@FunctionalInterface
			interface AndChar extends OfInt<Character> {

				float applyChar(int x, char y);

				@Override
				default float applyInt(int x, Character y) {
					return applyChar(x, y);
				}
			}

			@FunctionalInterface
			interface AndInt extends OfInt<java.lang.Integer> {
				float applyInt(int x, int y);

				@Override
				default float applyInt(int x, java.lang.Integer y) {
					return applyInt(x, (int) y);
				}
			}

			@FunctionalInterface
			interface AndShort extends OfInt<java.lang.Short> {

				float applyShort(int x, short y);

				@Override
				default float applyInt(int x, java.lang.Short y) {
					return applyShort(x, y);
				}
			}

			@FunctionalInterface
			interface AndByte extends OfInt<java.lang.Byte> {

				float applyByte(int x, byte y);

				@Override
				default float applyInt(int x, java.lang.Byte y) {
					return applyByte(x, y);
				}
			}

			@FunctionalInterface
			interface AndBoolean extends OfInt<java.lang.Boolean> {

				float applyBoolean(int x, boolean y);

				@Override
				default float applyInt(int x, java.lang.Boolean y) {
					return applyBoolean(x, y);
				}
			}

			float applyInt(int x, T y);

			@Override
			default float applyObj(java.lang.Integer x, T y) {
				return applyInt(x, y);
			}
		}

		@FunctionalInterface
		interface OfFloat<T> extends BiFunction<java.lang.Float, T> {

			@FunctionalInterface
			interface AndDouble extends OfFloat<java.lang.Double> {

				float applyDouble(float x, double y);

				@Override
				default float applyFloat(float x, java.lang.Double y) {
					return applyDouble(x, y);
				}
			}

			@FunctionalInterface
			interface AndLong extends OfFloat<java.lang.Long> {

				float applyLong(float x, long y);

				@Override
				default float applyFloat(float x, java.lang.Long y) {
					return applyLong(x, y);
				}
			}

			@FunctionalInterface
			interface AndFloat extends OfFloat<java.lang.Float>, BinaryOperator<java.lang.Float> {

				float applyFloat(float x, float y);

				@Override
				default float applyFloat(float x, java.lang.Float y) {
					return applyFloat(x, (float) y);
				}
			}

			@FunctionalInterface
			interface AndChar extends OfFloat<Character> {

				float applyChar(float x, char y);

				@Override
				default float applyFloat(float x, Character y) {
					return applyChar(x, y);
				}
			}

			@FunctionalInterface
			interface AndInt extends OfFloat<java.lang.Integer> {
				float applyInt(float x, int y);

				@Override
				default float applyFloat(float x, java.lang.Integer y) {
					return applyInt(x, (int) y);
				}
			}

			@FunctionalInterface
			interface AndShort extends OfFloat<java.lang.Short> {

				float applyShort(float x, short y);

				@Override
				default float applyFloat(float x, java.lang.Short y) {
					return applyShort(x, y);
				}
			}

			@FunctionalInterface
			interface AndByte extends OfFloat<java.lang.Byte> {

				float applyByte(float x, byte y);

				@Override
				default float applyFloat(float x, java.lang.Byte y) {
					return applyByte(x, y);
				}
			}

			@FunctionalInterface
			interface AndBoolean extends OfFloat<java.lang.Boolean> {

				float applyBoolean(float x, boolean y);

				@Override
				default float applyFloat(float x, java.lang.Boolean y) {
					return applyBoolean(x, y);
				}
			}

			float applyFloat(float x, T y);

			@Override
			default float applyObj(java.lang.Float x, T y) {
				return applyFloat(x, y);
			}
		}

		@FunctionalInterface
		interface OfChar<T> extends BiFunction<java.lang.Character, T> {

			@FunctionalInterface
			interface AndDouble extends OfChar<java.lang.Double> {

				float applyDouble(char x, double y);

				@Override
				default float applyChar(char x, java.lang.Double y) {
					return applyDouble(x, y);
				}
			}

			@FunctionalInterface
			interface AndLong extends OfChar<java.lang.Long> {

				float applyLong(char x, long y);

				@Override
				default float applyChar(char x, java.lang.Long y) {
					return applyLong(x, y);
				}
			}

			@FunctionalInterface
			interface AndFloat extends OfChar<java.lang.Float> {

				float applyFloat(char x, float y);

				@Override
				default float applyChar(char x, java.lang.Float y) {
					return applyFloat(x, y);
				}
			}

			@FunctionalInterface
			interface AndChar extends OfChar<Character> {

				float applyChar(char x, char y);

				@Override
				default float applyChar(char x, Character y) {
					return applyChar(x, (char) y);
				}
			}

			@FunctionalInterface
			interface AndInt extends OfChar<java.lang.Integer> {
				float applyInt(char x, int y);

				@Override
				default float applyChar(char x, java.lang.Integer y) {
					return applyInt(x, (int) y);
				}
			}

			@FunctionalInterface
			interface AndShort extends OfChar<java.lang.Short> {

				float applyShort(char x, short y);

				@Override
				default float applyChar(char x, java.lang.Short y) {
					return applyShort(x, y);
				}
			}

			@FunctionalInterface
			interface AndByte extends OfChar<java.lang.Byte> {

				float applyByte(char x, byte y);

				@Override
				default float applyChar(char x, java.lang.Byte y) {
					return applyByte(x, y);
				}
			}

			@FunctionalInterface
			interface AndBoolean extends OfChar<java.lang.Boolean> {

				float applyBoolean(char x, boolean y);

				@Override
				default float applyChar(char x, java.lang.Boolean y) {
					return applyBoolean(x, y);
				}
			}

			float applyChar(char x, T y);

			@Override
			default float applyObj(java.lang.Character x, T y) {
				return applyChar(x, y);
			}
		}

		@FunctionalInterface
		interface OfShort<T> extends BiFunction<java.lang.Short, T> {

			@FunctionalInterface
			interface AndDouble extends OfShort<java.lang.Double> {

				float applyDouble(short x, double y);

				@Override
				default float applyShort(short x, java.lang.Double y) {
					return applyDouble(x, y);
				}
			}

			@FunctionalInterface
			interface AndLong extends OfShort<java.lang.Long> {

				float applyLong(short x, long y);

				@Override
				default float applyShort(short x, java.lang.Long y) {
					return applyLong(x, y);
				}
			}

			@FunctionalInterface
			interface AndFloat extends OfShort<java.lang.Float> {

				float applyFloat(short x, float y);

				@Override
				default float applyShort(short x, java.lang.Float y) {
					return applyFloat(x, y);
				}
			}

			@FunctionalInterface
			interface AndChar extends OfShort<Character> {

				float applyChar(short x, char y);

				@Override
				default float applyShort(short x, Character y) {
					return applyChar(x, y);
				}
			}

			@FunctionalInterface
			interface AndInt extends OfShort<java.lang.Integer> {
				float applyInt(short x, int y);

				@Override
				default float applyShort(short x, java.lang.Integer y) {
					return applyInt(x, y);
				}
			}

			@FunctionalInterface
			interface AndShort extends OfShort<java.lang.Short> {

				float applyShort(short x, short y);

				@Override
				default float applyShort(short x, java.lang.Short y) {
					return applyShort(x, (short) y);
				}
			}

			@FunctionalInterface
			interface AndByte extends OfShort<java.lang.Byte> {

				float applyByte(short x, byte y);

				@Override
				default float applyShort(short x, java.lang.Byte y) {
					return applyByte(x, y);
				}
			}

			@FunctionalInterface
			interface AndBoolean extends OfShort<java.lang.Boolean> {

				float applyBoolean(short x, boolean y);

				@Override
				default float applyShort(short x, java.lang.Boolean y) {
					return applyBoolean(x, y);
				}
			}

			float applyShort(short x, T y);

			@Override
			default float applyObj(java.lang.Short x, T y) {
				return applyShort(x, y);
			}
		}

		@FunctionalInterface
		interface OfByte<T> extends BiFunction<java.lang.Byte, T> {

			@FunctionalInterface
			interface AndDouble extends OfByte<java.lang.Double> {

				float applyDouble(byte x, double y);

				@Override
				default float applyByte(byte x, java.lang.Double y) {
					return applyDouble(x, y);
				}
			}

			@FunctionalInterface
			interface AndLong extends OfByte<java.lang.Long> {

				float applyLong(byte x, long y);

				@Override
				default float applyByte(byte x, java.lang.Long y) {
					return applyLong(x, y);
				}
			}

			@FunctionalInterface
			interface AndFloat extends OfByte<java.lang.Float> {

				float applyFloat(byte x, float y);

				@Override
				default float applyByte(byte x, java.lang.Float y) {
					return applyFloat(x, y);
				}
			}

			@FunctionalInterface
			interface AndChar extends OfByte<Character> {

				float applyChar(byte x, char y);

				@Override
				default float applyByte(byte x, Character y) {
					return applyChar(x, y);
				}
			}

			@FunctionalInterface
			interface AndInt extends OfByte<java.lang.Integer> {
				float applyInt(byte x, int y);

				@Override
				default float applyByte(byte x, java.lang.Integer y) {
					return applyInt(x, y);
				}
			}

			@FunctionalInterface
			interface AndShort extends OfByte<java.lang.Short> {

				float applyShort(byte x, short y);

				@Override
				default float applyByte(byte x, java.lang.Short y) {
					return applyShort(x, y);
				}
			}

			@FunctionalInterface
			interface AndByte extends OfByte<java.lang.Byte> {

				float applyByte(byte x, byte y);

				@Override
				default float applyByte(byte x, java.lang.Byte y) {
					return applyByte(x, (byte) y);
				}
			}

			@FunctionalInterface
			interface AndBoolean extends OfByte<java.lang.Boolean> {

				float applyBoolean(byte x, boolean y);

				@Override
				default float applyByte(byte x, java.lang.Boolean y) {
					return applyBoolean(x, y);
				}
			}

			float applyByte(byte x, T y);

			@Override
			default float applyObj(java.lang.Byte x, T y) {
				return applyByte(x, y);
			}
		}

		@FunctionalInterface
		interface OfBoolean<T> extends BiFunction<java.lang.Boolean, T> {

			@FunctionalInterface
			interface AndDouble extends OfBoolean<java.lang.Double> {

				float applyDouble(boolean x, double y);

				@Override
				default float applyBoolean(boolean x, java.lang.Double y) {
					return applyDouble(x, y);
				}
			}

			@FunctionalInterface
			interface AndLong extends OfBoolean<java.lang.Long> {

				float applyLong(boolean x, long y);

				@Override
				default float applyBoolean(boolean x, java.lang.Long y) {
					return applyLong(x, y);
				}
			}

			@FunctionalInterface
			interface AndFloat extends OfBoolean<java.lang.Float> {

				float applyFloat(boolean x, float y);

				@Override
				default float applyBoolean(boolean x, java.lang.Float y) {
					return applyFloat(x, y);
				}
			}

			@FunctionalInterface
			interface AndChar extends OfBoolean<Character> {

				float applyChar(boolean x, char y);

				@Override
				default float applyBoolean(boolean x, Character y) {
					return applyChar(x, y);
				}
			}

			@FunctionalInterface
			interface AndInt extends OfBoolean<java.lang.Integer> {
				float applyInt(boolean x, int y);

				@Override
				default float applyBoolean(boolean x, java.lang.Integer y) {
					return applyInt(x, y);
				}
			}

			@FunctionalInterface
			interface AndShort extends OfBoolean<java.lang.Short> {

				float applyShort(boolean x, short y);

				@Override
				default float applyBoolean(boolean x, java.lang.Short y) {
					return applyShort(x, y);
				}
			}

			@FunctionalInterface
			interface AndByte extends OfBoolean<java.lang.Byte> {

				float applyByte(boolean x, byte y);

				@Override
				default float applyBoolean(boolean x, java.lang.Byte y) {
					return applyByte(x, y);
				}
			}

			@FunctionalInterface
			interface AndBoolean extends OfBoolean<java.lang.Boolean> {

				float applyBoolean(boolean x, boolean y);

				@Override
				default float applyBoolean(boolean x, java.lang.Boolean y) {
					return applyBoolean(x, (boolean) y);
				}
			}

			float applyBoolean(boolean x, T y);

			@Override
			default float applyObj(java.lang.Boolean x, T y) {
				return applyBoolean(x, y);
			}
		}

		float applyObj(T x, U y);

		@Override
		default java.lang.Float apply(T x, U y) {
			return applyObj(x, y);
		}
	}

	@FunctionalInterface
	public static interface Function<T> extends java.util.function.Function<T, java.lang.Float> {
		@FunctionalInterface
		interface OfDouble extends Function<java.lang.Double> {
			float applyDouble(double x);

			@Override
			default float applyObj(java.lang.Double x) {
				return applyDouble(x);
			}
		}

		@FunctionalInterface
		interface OfLong extends Function<java.lang.Long> {
			float applyLong(long x);

			@Override
			default float applyObj(java.lang.Long x) {
				return applyLong(x);
			}
		}

		@FunctionalInterface
		interface OfFloat extends Function<java.lang.Float>, UnaryOperator<java.lang.Float> {
			float applyFloat(float x);

			@Override
			default float applyObj(java.lang.Float x) {
				return applyFloat(x);
			}
		}

		@FunctionalInterface
		interface OfInt extends Function<java.lang.Integer> {
			float applyInt(int x);

			@Override
			default float applyObj(java.lang.Integer x) {
				return applyInt(x);
			}
		}

		@FunctionalInterface
		interface OfChar extends Function<Character> {
			float applyChar(char x);

			@Override
			default float applyObj(Character x) {
				return applyChar(x);
			}
		}

		@FunctionalInterface
		interface OfShort extends Function<java.lang.Short> {
			float applyShort(short x);

			@Override
			default float applyObj(java.lang.Short x) {
				return applyShort(x);
			}
		}

		@FunctionalInterface
		interface OfByte extends Function<java.lang.Byte> {
			float applyByte(byte x);

			@Override
			default float applyObj(java.lang.Byte x) {
				return applyByte(x);
			}
		}

		@FunctionalInterface
		interface OfBoolean extends Function<java.lang.Boolean> {
			float applyBoolean(boolean x);

			@Override
			default float applyObj(java.lang.Boolean x) {
				return applyBoolean(x);
			}
		}

		float applyObj(T x);

		@Override
		default java.lang.Float apply(T x) {
			return applyObj(x);
		}
	}

	/**
	 * Utility class that defines an interface that complements
	 * {@code java.util.function.Supplier} so that an {@code int} can be used as the
	 * argument.
	 */
	@FunctionalInterface
	public static interface Supplier extends java.util.function.Supplier<java.lang.Float> {
		/*
		 * Date created: 17 May 2024 Time created: 11:06:46
		 */
		/**
		 * Gets an {@code int} result.
		 *
		 * @return an {@code int} result
		 */
		float getFloat();

		/*
		 * Date created: 17 May 2024 Time created: 10:56:01
		 */
		/**
		 * {@inheritDoc}
		 * 
		 * @return {@inheritDoc}
		 */
		@Override
		default java.lang.Float get() {
			return getFloat();
		}
	
		default java.util.function.DoubleSupplier asDoubleSupplier(){
			return this::getFloat;
		}
	}

	@FunctionalInterface
	public static interface BiConsumer<T> extends java.util.function.BiConsumer<java.lang.Float, T> {

		@FunctionalInterface
		interface AndDouble extends BiConsumer<java.lang.Double> {

			void acceptDouble(float x, double y);

			@Override
			default void acceptObj(float x, java.lang.Double y) {
				acceptDouble(x, y);
			}
		}

		@FunctionalInterface
		interface AndLong extends BiConsumer<java.lang.Long> {

			void acceptLong(float x, long y);

			@Override
			default void acceptObj(float x, java.lang.Long y) {
				acceptLong(x, y);
			}
		}

		@FunctionalInterface
		interface AndInt extends BiConsumer<java.lang.Integer> {

			void acceptInt(float x, int y);

			@Override
			default void acceptObj(float x, java.lang.Integer y) {
				acceptInt(x, y);
			}
		}

		@FunctionalInterface
		interface AndFloat extends BiConsumer<java.lang.Float> {

			void acceptFloat(float x, float y);

			@Override
			default void acceptObj(float x, java.lang.Float y) {
				acceptFloat(x, y);
			}
		}

		@FunctionalInterface
		interface AndChar extends BiConsumer<Character> {

			void acceptChar(float x, char y);

			@Override
			default void acceptObj(float x, Character y) {
				acceptChar(x, y);
			}
		}

		@FunctionalInterface
		interface AndShort extends BiConsumer<java.lang.Short> {

			void acceptShort(float x, short y);

			@Override
			default void acceptObj(float x, java.lang.Short y) {
				acceptShort(x, y);
			}
		}

		@FunctionalInterface
		interface AndByte extends BiConsumer<java.lang.Byte> {

			void acceptByte(float x, byte y);

			@Override
			default void acceptObj(float x, java.lang.Byte y) {
				acceptByte(x, y);
			}
		}

		@FunctionalInterface
		interface AndBoolean extends BiConsumer<java.lang.Boolean> {

			void acceptBoolean(float x, boolean y);

			@Override
			default void acceptObj(float x, java.lang.Boolean y) {
				acceptBoolean(x, y);
			}
		}

		void acceptObj(float x, T y);

		@Override
		default void accept(java.lang.Float x, T y) {
			acceptObj(x, y);
		}
	}

	/**
	 * Utility class that defines an interface that complements
	 * {@code java.util.function.Consumer} so that an {@code int} can be used as the
	 * argument.
	 */
	@FunctionalInterface
	public static interface Consumer extends java.util.function.Consumer<java.lang.Float> {
		/**
		 * Performs this operation on the given {@code int} argument.
		 *
		 * @param i the input {@code int} argument
		 */
		void acceptFloat(float i);

		/*
		 * Date created: 17 May 2024 Time created: 10:56:01
		 */
		/**
		 * {@inheritDoc}
		 * 
		 * @param i {@inheritDoc}
		 */
		@Override
		default void accept(java.lang.Float i) {
			acceptFloat(i);
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
		default Consumer andThenFloat(Consumer after) {
			Objects.requireNonNull(after);
			return x -> {
				acceptFloat(x);
				after.acceptFloat(x);
			};
		}
	
		default java.util.function.DoubleConsumer asDoubleConsumer(){
			return x -> acceptFloat((float) x);
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
				java.util.function.Consumer<? super java.lang.Float> after) {
			if(after instanceof Consumer) return andThenFloat((Consumer) after);
			Objects.requireNonNull(after);
			return x -> {
				acceptFloat(x);
				after.accept(x);
			};
		}
	}

	@FunctionalInterface
	public static interface BiPredicate<T> extends java.util.function.BiPredicate<java.lang.Float, T> {

		@FunctionalInterface
		interface AndDouble extends BiPredicate<java.lang.Double> {

			boolean testDouble(float x, double y);

			@Override
			default boolean testObj(float x, java.lang.Double y) {
				return testDouble(x, y);
			}
		}

		@FunctionalInterface
		interface AndLong extends BiPredicate<java.lang.Long> {

			boolean testLong(float x, long y);

			@Override
			default boolean testObj(float x, java.lang.Long y) {
				return testLong(x, y);
			}
		}

		@FunctionalInterface
		interface AndInt extends BiPredicate<java.lang.Integer> {

			boolean testInt(float x, int y);

			@Override
			default boolean testObj(float x, java.lang.Integer y) {
				return testInt(x, y);
			}
		}

		@FunctionalInterface
		interface AndFloat extends BiPredicate<java.lang.Float> {

			boolean testFloat(float x, float y);

			@Override
			default boolean testObj(float x, java.lang.Float y) {
				return testFloat(x, y);
			}
		}

		@FunctionalInterface
		interface AndChar extends BiPredicate<Character> {

			boolean testChar(float x, char y);

			@Override
			default boolean testObj(float x, Character y) {
				return testChar(x, y);
			}
		}

		@FunctionalInterface
		interface AndShort extends BiPredicate<java.lang.Short> {

			boolean testShort(float x, short y);

			@Override
			default boolean testObj(float x, java.lang.Short y) {
				return testShort(x, y);
			}
		}

		@FunctionalInterface
		interface AndByte extends BiPredicate<java.lang.Byte> {

			boolean testByte(float x, byte y);

			@Override
			default boolean testObj(float x, java.lang.Byte y) {
				return testByte(x, y);
			}
		}

		@FunctionalInterface
		interface AndBoolean extends BiPredicate<java.lang.Boolean> {

			boolean testBoolean(float x, boolean y);

			@Override
			default boolean testObj(float x, java.lang.Boolean y) {
				return testBoolean(x, y);
			}
		}

		boolean testObj(float x, T y);

		@Override
		default boolean test(java.lang.Float x, T y) {
			return testObj(x, y);
		}
	}

	/**
	 * Interface that extends {@code java.util.function.Predicate} so that an
	 * {@code int} can be used as the argument.
	 */
	@FunctionalInterface
	public static interface Predicate extends java.util.function.Predicate<java.lang.Float> {
		/**
		 * Evaluates this predicate on the given {@code int} argument.
		 *
		 * @param i the {@code int} input argument
		 * @return {@code true} if the input argument matches the predicate, otherwise
		 *         {@code false}
		 */
		boolean testFloat(float i);

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
		default boolean test(java.lang.Float t) {
			return testFloat(t);
		}

		default Predicate andFloat(Predicate other) {
			Objects.requireNonNull(other);
			return x -> testFloat(x) && other.testFloat(x);
		}
		
		default Predicate negateFloat() {
			return x -> !testFloat(x);
		}

		default Predicate orFloat(Predicate other) {
			Objects.requireNonNull(other);
			return x -> testFloat(x) || other.testFloat(x);
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
				java.util.function.Predicate<? super java.lang.Float> other) {
			if(other instanceof Predicate) return orFloat((Predicate) other);
			return orFloat(other::test);
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
				java.util.function.Predicate<? super java.lang.Float> other) {
			if(other instanceof Predicate) return andFloat((Predicate) other);
			return andFloat(other::test);
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
			return x -> !testFloat(x);
		}
	
		default java.util.function.DoublePredicate asDoublePredicate() {
			return x -> testFloat((float) x);
		}
	}

	// Private constructor to prevent instantiation
	private Float() {
	}

}
