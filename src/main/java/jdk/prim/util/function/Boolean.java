/**
 * 
 */
package jdk.prim.util.function;

import java.util.Objects;
import java.util.function.BinaryOperator;
import java.util.function.BooleanSupplier;
import java.util.function.UnaryOperator;

/**
 * 
 */
public final class Boolean {
	@FunctionalInterface
	public static interface BiFunction<T, U> extends java.util.function.BiFunction<T, U, java.lang.Boolean> {

		@FunctionalInterface
		interface AndDouble<T> extends BiFunction<T, java.lang.Double> {
			boolean applyDouble(T x, double y);

			@Override
			default boolean applyObj(T x, java.lang.Double y) {
				return applyDouble(x, y);
			}
		}

		@FunctionalInterface
		interface AndLong<T> extends BiFunction<T, java.lang.Long> {
			boolean applyLong(T x, long y);

			@Override
			default boolean applyObj(T x, java.lang.Long y) {
				return applyLong(x, y);
			}
		}

		@FunctionalInterface
		interface AndInt<T> extends BiFunction<T, java.lang.Integer> {
			boolean applyInt(T x, int y);

			@Override
			default boolean applyObj(T x, java.lang.Integer y) {
				return applyInt(x, y);
			}
		}

		@FunctionalInterface
		interface AndFloat<T> extends BiFunction<T, java.lang.Float> {
			boolean applyFloat(T x, float y);

			@Override
			default boolean applyObj(T x, java.lang.Float y) {
				return applyFloat(x, y);
			}
		}

		@FunctionalInterface
		interface AndChar<T> extends BiFunction<T, java.lang.Character> {
			boolean applyChar(T x, char y);

			@Override
			default boolean applyObj(T x, java.lang.Character y) {
				return applyChar(x, y);
			}
		}

		@FunctionalInterface
		interface AndShort<T> extends BiFunction<T, java.lang.Short> {
			boolean applyShort(T x, short y);

			@Override
			default boolean applyObj(T x, java.lang.Short y) {
				return applyShort(x, y);
			}
		}

		@FunctionalInterface
		interface AndByte<T> extends BiFunction<T, java.lang.Byte> {
			boolean applyByte(T x, byte y);

			@Override
			default boolean applyObj(T x, java.lang.Byte y) {
				return applyByte(x, y);
			}
		}

		@FunctionalInterface
		interface AndBoolean<T> extends BiFunction<T, java.lang.Boolean> {
			boolean applyBoolean(T x, boolean y);

			@Override
			default boolean applyObj(T x, java.lang.Boolean y) {
				return applyBoolean(x, y);
			}
		}

		@FunctionalInterface
		interface OfDouble<T> extends BiFunction<java.lang.Double, T> {

			@FunctionalInterface
			interface AndDouble extends OfDouble<java.lang.Double> {

				boolean applyDouble(double x, double y);

				@Override
				default boolean applyDouble(double x, java.lang.Double y) {
					return applyDouble(x, (double) y);
				}
			}

			@FunctionalInterface
			interface AndLong extends OfDouble<java.lang.Long> {

				boolean applyLong(double x, long y);

				@Override
				default boolean applyDouble(double x, java.lang.Long y) {
					return applyLong(x, y);
				}
			}

			@FunctionalInterface
			interface AndFloat extends OfDouble<java.lang.Float> {

				boolean applyFloat(double x, float y);

				@Override
				default boolean applyDouble(double x, java.lang.Float y) {
					return applyFloat(x, y);
				}
			}

			@FunctionalInterface
			interface AndChar extends OfDouble<Character> {

				boolean applyChar(double x, char y);

				@Override
				default boolean applyDouble(double x, Character y) {
					return applyChar(x, y);
				}
			}

			@FunctionalInterface
			interface AndInt extends OfDouble<java.lang.Integer> {
				boolean applyInt(double x, int y);

				@Override
				default boolean applyDouble(double x, java.lang.Integer y) {
					return applyInt(x, y);
				}
			}

			@FunctionalInterface
			interface AndShort extends OfDouble<java.lang.Short> {

				boolean applyShort(double x, short y);

				@Override
				default boolean applyDouble(double x, java.lang.Short y) {
					return applyShort(x, y);
				}
			}

			@FunctionalInterface
			interface AndByte extends OfDouble<java.lang.Byte> {

				boolean applyByte(double x, byte y);

				@Override
				default boolean applyDouble(double x, java.lang.Byte y) {
					return applyByte(x, y);
				}
			}

			@FunctionalInterface
			interface AndBoolean extends OfDouble<java.lang.Boolean> {

				boolean applyBoolean(double x, boolean y);

				@Override
				default boolean applyDouble(double x, java.lang.Boolean y) {
					return applyBoolean(x, y);
				}
			}

			boolean applyDouble(double x, T y);

			@Override
			default boolean applyObj(java.lang.Double x, T y) {
				return applyDouble(x, y);
			}
		}

		@FunctionalInterface
		interface OfLong<T> extends BiFunction<java.lang.Long, T> {

			@FunctionalInterface
			interface AndDouble extends OfLong<java.lang.Double> {

				boolean applyDouble(long x, double y);

				@Override
				default boolean applyLong(long x, java.lang.Double y) {
					return applyDouble(x, y);
				}
			}

			@FunctionalInterface
			interface AndLong extends OfLong<java.lang.Long> {

				boolean applyLong(long x, long y);

				@Override
				default boolean applyLong(long x, java.lang.Long y) {
					return applyLong(x, (long) y);
				}
			}

			@FunctionalInterface
			interface AndFloat extends OfLong<java.lang.Float> {

				boolean applyFloat(long x, float y);

				@Override
				default boolean applyLong(long x, java.lang.Float y) {
					return applyFloat(x, y);
				}
			}

			@FunctionalInterface
			interface AndChar extends OfLong<Character> {

				boolean applyChar(long x, char y);

				@Override
				default boolean applyLong(long x, Character y) {
					return applyChar(x, y);
				}
			}

			@FunctionalInterface
			interface AndInt extends OfLong<java.lang.Integer> {
				boolean applyInt(long x, int y);

				@Override
				default boolean applyLong(long x, java.lang.Integer y) {
					return applyInt(x, y);
				}
			}

			@FunctionalInterface
			interface AndShort extends OfLong<java.lang.Short> {

				boolean applyShort(long x, short y);

				@Override
				default boolean applyLong(long x, java.lang.Short y) {
					return applyShort(x, y);
				}
			}

			@FunctionalInterface
			interface AndByte extends OfLong<java.lang.Byte> {

				boolean applyByte(long x, byte y);

				@Override
				default boolean applyLong(long x, java.lang.Byte y) {
					return applyByte(x, y);
				}
			}

			@FunctionalInterface
			interface AndBoolean extends OfLong<java.lang.Boolean> {

				boolean applyBoolean(long x, boolean y);

				@Override
				default boolean applyLong(long x, java.lang.Boolean y) {
					return applyBoolean(x, y);
				}
			}

			boolean applyLong(long x, T y);

			@Override
			default boolean applyObj(java.lang.Long x, T y) {
				return applyLong(x, y);
			}
		}

		@FunctionalInterface
		interface OfInt<T> extends BiFunction<java.lang.Integer, T> {

			@FunctionalInterface
			interface AndDouble extends OfInt<java.lang.Double> {

				boolean applyDouble(int x, double y);

				@Override
				default boolean applyInt(int x, java.lang.Double y) {
					return applyDouble(x, y);
				}
			}

			@FunctionalInterface
			interface AndLong extends OfInt<java.lang.Long> {

				boolean applyLong(int x, long y);

				@Override
				default boolean applyInt(int x, java.lang.Long y) {
					return applyLong(x, y);
				}
			}

			@FunctionalInterface
			interface AndFloat extends OfInt<java.lang.Float> {

				boolean applyFloat(int x, float y);

				@Override
				default boolean applyInt(int x, java.lang.Float y) {
					return applyFloat(x, y);
				}
			}

			@FunctionalInterface
			interface AndChar extends OfInt<Character> {

				boolean applyChar(int x, char y);

				@Override
				default boolean applyInt(int x, Character y) {
					return applyChar(x, y);
				}
			}

			@FunctionalInterface
			interface AndInt extends OfInt<java.lang.Integer> {
				boolean applyInt(int x, int y);

				@Override
				default boolean applyInt(int x, java.lang.Integer y) {
					return applyInt(x, (int) y);
				}
			}

			@FunctionalInterface
			interface AndShort extends OfInt<java.lang.Short> {

				boolean applyShort(int x, short y);

				@Override
				default boolean applyInt(int x, java.lang.Short y) {
					return applyShort(x, y);
				}
			}

			@FunctionalInterface
			interface AndByte extends OfInt<java.lang.Byte> {

				boolean applyByte(int x, byte y);

				@Override
				default boolean applyInt(int x, java.lang.Byte y) {
					return applyByte(x, y);
				}
			}

			@FunctionalInterface
			interface AndBoolean extends OfInt<java.lang.Boolean> {

				boolean applyBoolean(int x, boolean y);

				@Override
				default boolean applyInt(int x, java.lang.Boolean y) {
					return applyBoolean(x, y);
				}
			}

			boolean applyInt(int x, T y);

			@Override
			default boolean applyObj(java.lang.Integer x, T y) {
				return applyInt(x, y);
			}
		}

		@FunctionalInterface
		interface OfFloat<T> extends BiFunction<java.lang.Float, T> {

			@FunctionalInterface
			interface AndDouble extends OfFloat<java.lang.Double> {

				boolean applyDouble(float x, double y);

				@Override
				default boolean applyFloat(float x, java.lang.Double y) {
					return applyDouble(x, y);
				}
			}

			@FunctionalInterface
			interface AndLong extends OfFloat<java.lang.Long> {

				boolean applyLong(float x, long y);

				@Override
				default boolean applyFloat(float x, java.lang.Long y) {
					return applyLong(x, y);
				}
			}

			@FunctionalInterface
			interface AndFloat extends OfFloat<java.lang.Float> {

				boolean applyFloat(float x, float y);

				@Override
				default boolean applyFloat(float x, java.lang.Float y) {
					return applyFloat(x, (float) y);
				}
			}

			@FunctionalInterface
			interface AndChar extends OfFloat<Character> {

				boolean applyChar(float x, char y);

				@Override
				default boolean applyFloat(float x, Character y) {
					return applyChar(x, y);
				}
			}

			@FunctionalInterface
			interface AndInt extends OfFloat<java.lang.Integer> {
				boolean applyInt(float x, int y);

				@Override
				default boolean applyFloat(float x, java.lang.Integer y) {
					return applyInt(x, (int) y);
				}
			}

			@FunctionalInterface
			interface AndShort extends OfFloat<java.lang.Short> {

				boolean applyShort(float x, short y);

				@Override
				default boolean applyFloat(float x, java.lang.Short y) {
					return applyShort(x, y);
				}
			}

			@FunctionalInterface
			interface AndByte extends OfFloat<java.lang.Byte> {

				boolean applyByte(float x, byte y);

				@Override
				default boolean applyFloat(float x, java.lang.Byte y) {
					return applyByte(x, y);
				}
			}

			@FunctionalInterface
			interface AndBoolean extends OfFloat<java.lang.Boolean> {

				boolean applyBoolean(float x, boolean y);

				@Override
				default boolean applyFloat(float x, java.lang.Boolean y) {
					return applyBoolean(x, y);
				}
			}

			boolean applyFloat(float x, T y);

			@Override
			default boolean applyObj(java.lang.Float x, T y) {
				return applyFloat(x, y);
			}
		}

		@FunctionalInterface
		interface OfChar<T> extends BiFunction<java.lang.Character, T> {

			@FunctionalInterface
			interface AndDouble extends OfChar<java.lang.Double> {

				boolean applyDouble(char x, double y);

				@Override
				default boolean applyChar(char x, java.lang.Double y) {
					return applyDouble(x, y);
				}
			}

			@FunctionalInterface
			interface AndLong extends OfChar<java.lang.Long> {

				boolean applyLong(char x, long y);

				@Override
				default boolean applyChar(char x, java.lang.Long y) {
					return applyLong(x, y);
				}
			}

			@FunctionalInterface
			interface AndFloat extends OfChar<java.lang.Float> {

				boolean applyFloat(char x, float y);

				@Override
				default boolean applyChar(char x, java.lang.Float y) {
					return applyFloat(x, y);
				}
			}

			@FunctionalInterface
			interface AndChar extends OfChar<Character> {

				boolean applyChar(char x, char y);

				@Override
				default boolean applyChar(char x, Character y) {
					return applyChar(x, (char) y);
				}
			}

			@FunctionalInterface
			interface AndInt extends OfChar<java.lang.Integer> {
				boolean applyInt(char x, int y);

				@Override
				default boolean applyChar(char x, java.lang.Integer y) {
					return applyInt(x, (int) y);
				}
			}

			@FunctionalInterface
			interface AndShort extends OfChar<java.lang.Short> {

				boolean applyShort(char x, short y);

				@Override
				default boolean applyChar(char x, java.lang.Short y) {
					return applyShort(x, y);
				}
			}

			@FunctionalInterface
			interface AndByte extends OfChar<java.lang.Byte> {

				boolean applyByte(char x, byte y);

				@Override
				default boolean applyChar(char x, java.lang.Byte y) {
					return applyByte(x, y);
				}
			}

			@FunctionalInterface
			interface AndBoolean extends OfChar<java.lang.Boolean> {

				boolean applyBoolean(char x, boolean y);

				@Override
				default boolean applyChar(char x, java.lang.Boolean y) {
					return applyBoolean(x, y);
				}
			}

			boolean applyChar(char x, T y);

			@Override
			default boolean applyObj(java.lang.Character x, T y) {
				return applyChar(x, y);
			}
		}

		@FunctionalInterface
		interface OfShort<T> extends BiFunction<java.lang.Short, T> {

			@FunctionalInterface
			interface AndDouble extends OfShort<java.lang.Double> {

				boolean applyDouble(short x, double y);

				@Override
				default boolean applyShort(short x, java.lang.Double y) {
					return applyDouble(x, y);
				}
			}

			@FunctionalInterface
			interface AndLong extends OfShort<java.lang.Long> {

				boolean applyLong(short x, long y);

				@Override
				default boolean applyShort(short x, java.lang.Long y) {
					return applyLong(x, y);
				}
			}

			@FunctionalInterface
			interface AndFloat extends OfShort<java.lang.Float> {

				boolean applyFloat(short x, float y);

				@Override
				default boolean applyShort(short x, java.lang.Float y) {
					return applyFloat(x, y);
				}
			}

			@FunctionalInterface
			interface AndChar extends OfShort<Character> {

				boolean applyChar(short x, char y);

				@Override
				default boolean applyShort(short x, Character y) {
					return applyChar(x, y);
				}
			}

			@FunctionalInterface
			interface AndInt extends OfShort<java.lang.Integer> {
				boolean applyInt(short x, int y);

				@Override
				default boolean applyShort(short x, java.lang.Integer y) {
					return applyInt(x, y);
				}
			}

			@FunctionalInterface
			interface AndShort extends OfShort<java.lang.Short> {

				boolean applyShort(short x, short y);

				@Override
				default boolean applyShort(short x, java.lang.Short y) {
					return applyShort(x, (short) y);
				}
			}

			@FunctionalInterface
			interface AndByte extends OfShort<java.lang.Byte> {

				boolean applyByte(short x, byte y);

				@Override
				default boolean applyShort(short x, java.lang.Byte y) {
					return applyByte(x, y);
				}
			}

			@FunctionalInterface
			interface AndBoolean extends OfShort<java.lang.Boolean> {

				boolean applyBoolean(short x, boolean y);

				@Override
				default boolean applyShort(short x, java.lang.Boolean y) {
					return applyBoolean(x, y);
				}
			}

			boolean applyShort(short x, T y);

			@Override
			default boolean applyObj(java.lang.Short x, T y) {
				return applyShort(x, y);
			}
		}

		@FunctionalInterface
		interface OfByte<T> extends BiFunction<java.lang.Byte, T> {

			@FunctionalInterface
			interface AndDouble extends OfByte<java.lang.Double> {

				boolean applyDouble(byte x, double y);

				@Override
				default boolean applyByte(byte x, java.lang.Double y) {
					return applyDouble(x, y);
				}
			}

			@FunctionalInterface
			interface AndLong extends OfByte<java.lang.Long> {

				boolean applyLong(byte x, long y);

				@Override
				default boolean applyByte(byte x, java.lang.Long y) {
					return applyLong(x, y);
				}
			}

			@FunctionalInterface
			interface AndFloat extends OfByte<java.lang.Float> {

				boolean applyFloat(byte x, float y);

				@Override
				default boolean applyByte(byte x, java.lang.Float y) {
					return applyFloat(x, y);
				}
			}

			@FunctionalInterface
			interface AndChar extends OfByte<Character> {

				boolean applyChar(byte x, char y);

				@Override
				default boolean applyByte(byte x, Character y) {
					return applyChar(x, y);
				}
			}

			@FunctionalInterface
			interface AndInt extends OfByte<java.lang.Integer> {
				boolean applyInt(byte x, int y);

				@Override
				default boolean applyByte(byte x, java.lang.Integer y) {
					return applyInt(x, y);
				}
			}

			@FunctionalInterface
			interface AndShort extends OfByte<java.lang.Short> {

				boolean applyShort(byte x, short y);

				@Override
				default boolean applyByte(byte x, java.lang.Short y) {
					return applyShort(x, y);
				}
			}

			@FunctionalInterface
			interface AndByte extends OfByte<java.lang.Byte> {

				boolean applyByte(byte x, byte y);

				@Override
				default boolean applyByte(byte x, java.lang.Byte y) {
					return applyByte(x, (byte) y);
				}
			}

			@FunctionalInterface
			interface AndBoolean extends OfByte<java.lang.Boolean> {

				boolean applyBoolean(byte x, boolean y);

				@Override
				default boolean applyByte(byte x, java.lang.Boolean y) {
					return applyBoolean(x, y);
				}
			}

			boolean applyByte(byte x, T y);

			@Override
			default boolean applyObj(java.lang.Byte x, T y) {
				return applyByte(x, y);
			}
		}

		@FunctionalInterface
		interface OfBoolean<T> extends BiFunction<java.lang.Boolean, T> {

			@FunctionalInterface
			interface AndDouble extends OfBoolean<java.lang.Double> {

				boolean applyDouble(boolean x, double y);

				@Override
				default boolean applyBoolean(boolean x, java.lang.Double y) {
					return applyDouble(x, y);
				}
			}

			@FunctionalInterface
			interface AndLong extends OfBoolean<java.lang.Long> {

				boolean applyLong(boolean x, long y);

				@Override
				default boolean applyBoolean(boolean x, java.lang.Long y) {
					return applyLong(x, y);
				}
			}

			@FunctionalInterface
			interface AndFloat extends OfBoolean<java.lang.Float> {

				boolean applyFloat(boolean x, float y);

				@Override
				default boolean applyBoolean(boolean x, java.lang.Float y) {
					return applyFloat(x, y);
				}
			}

			@FunctionalInterface
			interface AndChar extends OfBoolean<Character> {

				boolean applyChar(boolean x, char y);

				@Override
				default boolean applyBoolean(boolean x, Character y) {
					return applyChar(x, y);
				}
			}

			@FunctionalInterface
			interface AndInt extends OfBoolean<java.lang.Integer> {
				boolean applyInt(boolean x, int y);

				@Override
				default boolean applyBoolean(boolean x, java.lang.Integer y) {
					return applyInt(x, y);
				}
			}

			@FunctionalInterface
			interface AndShort extends OfBoolean<java.lang.Short> {

				boolean applyShort(boolean x, short y);

				@Override
				default boolean applyBoolean(boolean x, java.lang.Short y) {
					return applyShort(x, y);
				}
			}

			@FunctionalInterface
			interface AndByte extends OfBoolean<java.lang.Byte> {

				boolean applyByte(boolean x, byte y);

				@Override
				default boolean applyBoolean(boolean x, java.lang.Byte y) {
					return applyByte(x, y);
				}
			}

			@FunctionalInterface
			interface AndBoolean extends OfBoolean<java.lang.Boolean>, BinaryOperator<java.lang.Boolean> {

				boolean applyBoolean(boolean x, boolean y);

				@Override
				default boolean applyBoolean(boolean x, java.lang.Boolean y) {
					return applyBoolean(x, (boolean) y);
				}
			}

			boolean applyBoolean(boolean x, T y);

			@Override
			default boolean applyObj(java.lang.Boolean x, T y) {
				return applyBoolean(x, y);
			}
		}

		boolean applyObj(T x, U y);

		@Override
		default java.lang.Boolean apply(T x, U y) {
			return applyObj(x, y);
		}
	}

	@FunctionalInterface
	public static interface Function<T> extends java.util.function.Function<T, java.lang.Boolean> {
		@FunctionalInterface
		interface OfDouble extends Function<java.lang.Double> {
			boolean applyDouble(double x);

			@Override
			default boolean applyObj(java.lang.Double x) {
				return applyDouble(x);
			}
		}

		@FunctionalInterface
		interface OfLong extends Function<java.lang.Long> {
			boolean applyLong(long x);

			@Override
			default boolean applyObj(java.lang.Long x) {
				return applyLong(x);
			}
		}

		@FunctionalInterface
		interface OfFloat extends Function<java.lang.Float> {
			boolean applyFloat(float x);

			@Override
			default boolean applyObj(java.lang.Float x) {
				return applyFloat(x);
			}
		}

		@FunctionalInterface
		interface OfInt extends Function<java.lang.Integer> {
			boolean applyInt(int x);

			@Override
			default boolean applyObj(java.lang.Integer x) {
				return applyInt(x);
			}
		}

		@FunctionalInterface
		interface OfChar extends Function<Character> {
			boolean applyChar(char x);

			@Override
			default boolean applyObj(Character x) {
				return applyChar(x);
			}
		}

		@FunctionalInterface
		interface OfShort extends Function<java.lang.Short> {
			boolean applyShort(short x);

			@Override
			default boolean applyObj(java.lang.Short x) {
				return applyShort(x);
			}
		}

		@FunctionalInterface
		interface OfByte extends Function<java.lang.Byte> {
			boolean applyByte(byte x);

			@Override
			default boolean applyObj(java.lang.Byte x) {
				return applyByte(x);
			}
		}

		@FunctionalInterface
		interface OfBoolean extends Function<java.lang.Boolean>, UnaryOperator<java.lang.Boolean> {
			boolean applyBoolean(boolean x);

			@Override
			default boolean applyObj(java.lang.Boolean x) {
				return applyBoolean(x);
			}
		}

		boolean applyObj(T x);

		@Override
		default java.lang.Boolean apply(T x) {
			return applyObj(x);
		}
	}

	/**
	 * Utility class that defines an interface that complements
	 * {@code java.util.function.Supplier} so that an {@code int} can be used as the
	 * argument.
	 */
	@FunctionalInterface
	public static interface Supplier extends java.util.function.Supplier<java.lang.Boolean>, BooleanSupplier {
		/*
		 * Date created: 17 May 2024 Time created: 11:06:46
		 */
		/**
		 * Gets an {@code int} result.
		 *
		 * @return an {@code int} result
		 */
		boolean getBoolean();

		/**
		 * {@inheritDoc}
		 * @return {@inheritDoc}
		 */
		@Override default boolean getAsBoolean() { return getBoolean(); }

		/*
		 * Date created: 17 May 2024 Time created: 10:56:01
		 */
		/**
		 * {@inheritDoc}
		 * 
		 * @return {@inheritDoc}
		 */
		@Override
		default java.lang.Boolean get() {
			return getBoolean();
		}
	}

	@FunctionalInterface
	public static interface BiConsumer<T> extends java.util.function.BiConsumer<java.lang.Boolean, T> {

		@FunctionalInterface
		interface AndDouble extends BiConsumer<java.lang.Double> {

			void acceptDouble(boolean x, double y);

			@Override
			default void acceptObj(boolean x, java.lang.Double y) {
				acceptDouble(x, y);
			}
		}

		@FunctionalInterface
		interface AndLong extends BiConsumer<java.lang.Long> {

			void acceptLong(boolean x, long y);

			@Override
			default void acceptObj(boolean x, java.lang.Long y) {
				acceptLong(x, y);
			}
		}

		@FunctionalInterface
		interface AndInt extends BiConsumer<java.lang.Integer> {

			void acceptInt(boolean x, int y);

			@Override
			default void acceptObj(boolean x, java.lang.Integer y) {
				acceptInt(x, y);
			}
		}

		@FunctionalInterface
		interface AndFloat extends BiConsumer<java.lang.Float> {

			void acceptFloat(boolean x, float y);

			@Override
			default void acceptObj(boolean x, java.lang.Float y) {
				acceptFloat(x, y);
			}
		}

		@FunctionalInterface
		interface AndChar extends BiConsumer<Character> {

			void acceptChar(boolean x, char y);

			@Override
			default void acceptObj(boolean x, Character y) {
				acceptChar(x, y);
			}
		}

		@FunctionalInterface
		interface AndShort extends BiConsumer<java.lang.Short> {

			void acceptShort(boolean x, short y);

			@Override
			default void acceptObj(boolean x, java.lang.Short y) {
				acceptShort(x, y);
			}
		}

		@FunctionalInterface
		interface AndByte extends BiConsumer<java.lang.Byte> {

			void acceptByte(boolean x, byte y);

			@Override
			default void acceptObj(boolean x, java.lang.Byte y) {
				acceptByte(x, y);
			}
		}

		@FunctionalInterface
		interface AndBoolean extends BiConsumer<java.lang.Boolean> {

			void acceptBoolean(boolean x, boolean y);

			@Override
			default void acceptObj(boolean x, java.lang.Boolean y) {
				acceptBoolean(x, y);
			}
		}

		void acceptObj(boolean x, T y);

		@Override
		default void accept(java.lang.Boolean x, T y) {
			acceptObj(x, y);
		}
	}

	/**
	 * Utility class that defines an interface that complements
	 * {@code java.util.function.Consumer} so that an {@code int} can be used as the
	 * argument.
	 */
	@FunctionalInterface
	public static interface Consumer extends java.util.function.Consumer<java.lang.Boolean> {
		/**
		 * Performs this operation on the given {@code int} argument.
		 *
		 * @param i the input {@code int} argument
		 */
		void acceptBoolean(boolean i);

		/*
		 * Date created: 17 May 2024 Time created: 10:56:01
		 */
		/**
		 * {@inheritDoc}
		 * 
		 * @param i {@inheritDoc}
		 */
		@Override
		default void accept(java.lang.Boolean i) {
			acceptBoolean(i);
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
		default Consumer andThenBoolean(Consumer after) {
			Objects.requireNonNull(after);
			return x -> {
				acceptBoolean(x);
				after.acceptBoolean(x);
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
				java.util.function.Consumer<? super java.lang.Boolean> after) {
			if(after instanceof Consumer) return andThenBoolean((Consumer) after);
			Objects.requireNonNull(after);
			return x -> {
				acceptBoolean(x);
				after.accept(x);
			};
		}
	}

	@FunctionalInterface
	public static interface BiPredicate<T> extends java.util.function.BiPredicate<java.lang.Boolean, T> {

		@FunctionalInterface
		interface AndDouble extends BiPredicate<java.lang.Double> {

			boolean testDouble(boolean x, double y);

			@Override
			default boolean testObj(boolean x, java.lang.Double y) {
				return testDouble(x, y);
			}
		}

		@FunctionalInterface
		interface AndLong extends BiPredicate<java.lang.Long> {

			boolean testLong(boolean x, long y);

			@Override
			default boolean testObj(boolean x, java.lang.Long y) {
				return testLong(x, y);
			}
		}

		@FunctionalInterface
		interface AndInt extends BiPredicate<java.lang.Integer> {

			boolean testInt(boolean x, int y);

			@Override
			default boolean testObj(boolean x, java.lang.Integer y) {
				return testInt(x, y);
			}
		}

		@FunctionalInterface
		interface AndFloat extends BiPredicate<java.lang.Float> {

			boolean testFloat(boolean x, float y);

			@Override
			default boolean testObj(boolean x, java.lang.Float y) {
				return testFloat(x, y);
			}
		}

		@FunctionalInterface
		interface AndChar extends BiPredicate<Character> {

			boolean testChar(boolean x, char y);

			@Override
			default boolean testObj(boolean x, Character y) {
				return testChar(x, y);
			}
		}

		@FunctionalInterface
		interface AndShort extends BiPredicate<java.lang.Short> {

			boolean testShort(boolean x, short y);

			@Override
			default boolean testObj(boolean x, java.lang.Short y) {
				return testShort(x, y);
			}
		}

		@FunctionalInterface
		interface AndByte extends BiPredicate<java.lang.Byte> {

			boolean testByte(boolean x, byte y);

			@Override
			default boolean testObj(boolean x, java.lang.Byte y) {
				return testByte(x, y);
			}
		}

		@FunctionalInterface
		interface AndBoolean extends BiPredicate<java.lang.Boolean> {

			boolean testBoolean(boolean x, boolean y);

			@Override
			default boolean testObj(boolean x, java.lang.Boolean y) {
				return testBoolean(x, y);
			}
		}

		boolean testObj(boolean x, T y);

		@Override
		default boolean test(java.lang.Boolean x, T y) {
			return testObj(x, y);
		}
	}

	/**
	 * Interface that extends {@code java.util.function.Predicate} so that an
	 * {@code int} can be used as the argument.
	 */
	@FunctionalInterface
	public static interface Predicate extends java.util.function.Predicate<java.lang.Boolean> {
		/**
		 * Evaluates this predicate on the given {@code int} argument.
		 *
		 * @param i the {@code int} input argument
		 * @return {@code true} if the input argument matches the predicate, otherwise
		 *         {@code false}
		 */
		boolean testBoolean(boolean i);

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
		default boolean test(java.lang.Boolean t) {
			return testBoolean(t);
		}

		default Predicate andBoolean(Predicate other) {
			Objects.requireNonNull(other);
			return x -> testBoolean(x) && other.testBoolean(x);
		}

		default Predicate negateBoolean() {
			return x -> !testBoolean(x);
		}

		default Predicate orBoolean(Predicate other) {
			Objects.requireNonNull(other);
			return x -> testBoolean(x) || other.testBoolean(x);
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
				java.util.function.Predicate<? super java.lang.Boolean> other) {
			if(other instanceof Predicate) return orBoolean((Predicate) other);
			return orBoolean(other::test);
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
				java.util.function.Predicate<? super java.lang.Boolean> other) {
			if(other instanceof Predicate) return andBoolean((Predicate) other);
			return andBoolean(other::test);
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
			return x -> !testBoolean(x);
		}
	}

	// Private constructor to prevent instantiation
	private Boolean() {
	}

}
