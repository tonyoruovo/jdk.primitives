/**
 * 
 */
package jdk.prim.util;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

import jdk.prim.util.function.PrimitiveConsumer;

/**
 * An extension of {@link java.util.PrimitiveIterator} to allow for casting
 * in-between java's primitives.
 *
 * @param <T>      the type of elements returned by this PrimitiveIterator. The
 *                 type must be a wrapper type for a primitive type, such as
 *                 {@code Integer} for the primitive {@code int} type.
 * @param <T_CONS> the type of primitive consumer. The type must be a primitive
 *                 specialization of {@link java.util.function.Consumer} for
 *                 {@code T}, such as {@link java.util.function.IntConsumer} for
 *                 {@code Integer}.
 */
public interface PrimitiveIterator<T, T_CONS> extends java.util.PrimitiveIterator<T, T_CONS> {

	/**
	 * An Iterator specialized for {@code double} values.
	 * <p>
	 * Defines an interface for iterator specialized for {@code double} values. It
	 * extends the {@link java.uti.PrimitiveIterator.OfDouble} interface and
	 * provides
	 * additional methods specific to {@code double} values iteration.
	 * 
	 * @implNote The use of {@link #nextDouble()} is preferred over the use of
	 *           {@link #next()} because {@link #next()} is implemented by calling
	 *           and casting {@link #nextDouble()}.
	 * @implNote Default implementation does not support modification such as
	 *           {@link #remove()}
	 */
	interface OfDouble extends PrimitiveIterator<Double, DoubleConsumer>, java.util.PrimitiveIterator.OfDouble {

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 */
		@Override
		default PrimitiveIterator.OfDouble toDouble() {
			return this;
		}

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 */
		@Override
		default PrimitiveIterator.OfLong toLong() {
			return new PrimitiveIterator.OfLong() {

				@Override
				public long nextLong() {
					return (long) PrimitiveIterator.OfDouble.this.nextDouble();
				}

				@Override
				public boolean hasNext() {
					return PrimitiveIterator.OfDouble.this.hasNext();
				}
			};
		}

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 */
		@Override
		default PrimitiveIterator.OfInt toInt() {
			return new PrimitiveIterator.OfInt() {

				@Override
				public int nextInt() {
					return (int) PrimitiveIterator.OfDouble.this.nextDouble();
				}

				@Override
				public boolean hasNext() {
					return PrimitiveIterator.OfDouble.this.hasNext();
				}
			};
		}

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 */
		@Override
		default OfFloat toFloat() {
			return new OfFloat() {

				@Override
				public boolean hasNext() {
					return PrimitiveIterator.OfDouble.this.hasNext();
				}

				@Override
				public float nextFloat() {
					return (float) PrimitiveIterator.OfDouble.this.nextDouble();
				}
			};
		}

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 * 
		 * @implNote returns {@code this}
		 */
		@Override
		default OfChar toChar() {
			return new OfChar() {

				@Override
				public boolean hasNext() {
					return PrimitiveIterator.OfDouble.this.hasNext();
				}

				@Override
				public char nextChar() throws NoSuchElementException {
					return (char) PrimitiveIterator.OfDouble.this.nextDouble();
				}
			};
		}

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 */
		@Override
		default OfShort toShort() {
			return new OfShort() {

				@Override
				public boolean hasNext() {
					return PrimitiveIterator.OfDouble.this.hasNext();
				}

				@Override
				public short nextShort() {
					return (short) PrimitiveIterator.OfDouble.this.nextDouble();
				}
			};
		}

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 */
		@Override
		default OfByte toByte() {
			return new OfByte() {

				@Override
				public boolean hasNext() {
					return PrimitiveIterator.OfDouble.this.hasNext();
				}

				@Override
				public byte nextByte() {
					return (byte) PrimitiveIterator.OfDouble.this.nextDouble();
				}
			};
		}

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 */
		@Override
		default OfBoolean toBoolean() {
			return new OfBoolean() {

				@Override
				public boolean hasNext() {
					return PrimitiveIterator.OfDouble.this.hasNext();
				}

				@Override
				public boolean nextBoolean() {
					return PrimitiveIterator.OfDouble.this.nextDouble() != 0;
				}
			};
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @implSpec The default implementation boxes the result of calling
		 *           {@link #nextDouble()}, and returns that boxed result.
		 */
		@Override
		default Double next() throws NoSuchElementException {
			return nextDouble();
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @implSpec
		 *           <p>
		 *           The default implementation behaves as if:
		 * 
		 *           <pre>{@code
		 *     while (hasNext())
		 *         action.accept(nextDouble());
		 * }</pre>
		 */
		default void forEachRemaining(DoubleConsumer action) {
			Objects.requireNonNull(action);
			while (hasNext())
				action.accept(nextDouble());
		}
	}

	/**
	 * An Iterator specialized for {@code long} values.
	 * <p>
	 * Defines an interface for iterator specialized for {@code long} values. It
	 * extends the {@link java.uti.PrimitiveIterator.OfLong} interface and provides
	 * additional methods specific to {@code long} values iteration.
	 * 
	 * @implNote The use of {@link #nextLong()} is preferred over the use of
	 *           {@link #next()} because {@link #next()} is implemented by calling
	 *           and casting {@link #nextLong()}.
	 * @implNote Default implementation does not support modification such as
	 *           {@link #remove()}
	 */
	interface OfLong extends PrimitiveIterator<Long, LongConsumer>, java.util.PrimitiveIterator.OfLong {

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 */
		@Override
		default PrimitiveIterator.OfDouble toDouble() {
			return new PrimitiveIterator.OfDouble() {

				@Override
				public boolean hasNext() {
					return PrimitiveIterator.OfLong.this.hasNext();
				}

				@Override
				public double nextDouble() {
					return PrimitiveIterator.OfLong.this.nextLong();
				}
			};
		}

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 */
		@Override
		default PrimitiveIterator.OfLong toLong() {
			return this;
		}

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 */
		@Override
		default PrimitiveIterator.OfInt toInt() {
			return new PrimitiveIterator.OfInt() {

				@Override
				public int nextInt() {
					return (int) PrimitiveIterator.OfLong.this.nextLong();
				}

				@Override
				public boolean hasNext() {
					return PrimitiveIterator.OfLong.this.hasNext();
				}
			};
		}

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 */
		@Override
		default OfFloat toFloat() {
			return new OfFloat() {

				@Override
				public boolean hasNext() {
					return PrimitiveIterator.OfLong.this.hasNext();
				}

				@Override
				public float nextFloat() {
					return PrimitiveIterator.OfLong.this.nextLong();
				}
			};
		}

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 * 
		 * @implNote returns {@code this}
		 */
		@Override
		default OfChar toChar() {
			return new OfChar() {

				@Override
				public boolean hasNext() {
					return PrimitiveIterator.OfLong.this.hasNext();
				}

				@Override
				public char nextChar() throws NoSuchElementException {
					return (char) PrimitiveIterator.OfLong.this.nextLong();
				}
			};
		}

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 */
		@Override
		default OfShort toShort() {
			return new OfShort() {

				@Override
				public boolean hasNext() {
					return PrimitiveIterator.OfLong.this.hasNext();
				}

				@Override
				public short nextShort() {
					return (short) PrimitiveIterator.OfLong.this.nextLong();
				}
			};
		}

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 */
		@Override
		default OfByte toByte() {
			return new OfByte() {

				@Override
				public boolean hasNext() {
					return PrimitiveIterator.OfLong.this.hasNext();
				}

				@Override
				public byte nextByte() {
					return (byte) PrimitiveIterator.OfLong.this.nextLong();
				}
			};
		}

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 */
		@Override
		default OfBoolean toBoolean() {
			return new OfBoolean() {

				@Override
				public boolean hasNext() {
					return PrimitiveIterator.OfLong.this.hasNext();
				}

				@Override
				public boolean nextBoolean() {
					return PrimitiveIterator.OfLong.this.nextLong() != 0;
				}
			};
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @implSpec The default implementation boxes the result of calling
		 *           {@link #nextLong()}, and returns that boxed result.
		 */
		@Override
		default Long next() throws NoSuchElementException {
			return nextLong();
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @implSpec
		 *           <p>
		 *           The default implementation behaves as if:
		 * 
		 *           <pre>{@code
		 *     while (hasNext())
		 *         action.accept(nextLong());
		 * }</pre>
		 */
		default void forEachRemaining(LongConsumer action) {
			Objects.requireNonNull(action);
			while (hasNext())
				action.accept(nextLong());
		}
	}

	/**
	 * An Iterator specialized for {@code int} values.
	 * <p>
	 * Defines an interface for iterator specialized for {@code int} values. It
	 * extends the {@link java.uti.PrimitiveIterator.OfInt} interface and provides
	 * additional methods specific to {@code int} values iteration.
	 * 
	 * @implNote The use of {@link #nextInt()} is preferred over the use of
	 *           {@link #next()} because {@link #next()} is implemented by calling
	 *           and casting {@link #nextInt()}.
	 * @implNote Default implementation does not support modification such as
	 *           {@link #remove()}
	 */
	interface OfInt extends PrimitiveIterator<Integer, IntConsumer>, java.util.PrimitiveIterator.OfInt {

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 */
		@Override
		default PrimitiveIterator.OfDouble toDouble() {
			return new PrimitiveIterator.OfDouble() {

				@Override
				public boolean hasNext() {
					return PrimitiveIterator.OfInt.this.hasNext();
				}

				@Override
				public double nextDouble() {
					return PrimitiveIterator.OfInt.this.nextInt();
				}
			};
		}

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 */
		@Override
		default PrimitiveIterator.OfLong toLong() {
			return new PrimitiveIterator.OfLong() {

				@Override
				public boolean hasNext() {
					return PrimitiveIterator.OfInt.this.hasNext();
				}

				@Override
				public long nextLong() {
					return PrimitiveIterator.OfInt.this.nextInt();
				}
			};
		}

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 */
		@Override
		default PrimitiveIterator.OfInt toInt() {
			return this;
		}

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 */
		@Override
		default OfFloat toFloat() {
			return new OfFloat() {

				@Override
				public boolean hasNext() {
					return PrimitiveIterator.OfInt.this.hasNext();
				}

				@Override
				public float nextFloat() {
					return PrimitiveIterator.OfInt.this.nextInt();
				}
			};
		}

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 * 
		 * @implNote returns {@code this}
		 */
		@Override
		default OfChar toChar() {
			return new OfChar() {

				@Override
				public boolean hasNext() {
					return PrimitiveIterator.OfInt.this.hasNext();
				}

				@Override
				public char nextChar() throws NoSuchElementException {
					return (char) PrimitiveIterator.OfInt.this.nextInt();
				}
			};
		}

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 */
		@Override
		default OfShort toShort() {
			return new OfShort() {

				@Override
				public boolean hasNext() {
					return PrimitiveIterator.OfInt.this.hasNext();
				}

				@Override
				public short nextShort() {
					return (short) PrimitiveIterator.OfInt.this.nextInt();
				}
			};
		}

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 */
		@Override
		default OfByte toByte() {
			return new OfByte() {

				@Override
				public boolean hasNext() {
					return PrimitiveIterator.OfInt.this.hasNext();
				}

				@Override
				public byte nextByte() {
					return (byte) PrimitiveIterator.OfInt.this.nextInt();
				}
			};
		}

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 */
		@Override
		default OfBoolean toBoolean() {
			return new OfBoolean() {

				@Override
				public boolean hasNext() {
					return PrimitiveIterator.OfInt.this.hasNext();
				}

				@Override
				public boolean nextBoolean() {
					return PrimitiveIterator.OfInt.this.nextInt() != 0;
				}
			};
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @implSpec
		 *           <p>
		 *           The default implementation behaves as if:
		 * 
		 *           <pre>{@code
		 *     while (hasNext())
		 *         action.accept(nextInt());
		 * }</pre>
		 */
		default void forEachRemaining(IntConsumer action) {
			Objects.requireNonNull(action);
			while (hasNext())
				action.accept(nextInt());
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @implSpec The default implementation boxes the result of calling
		 *           {@link #nextInt()}, and returns that boxed result.
		 */
		@Override
		default Integer next() throws NoSuchElementException {
			return nextInt();
		}
	}

	/**
	 * An Iterator specialized for {@code char} values.
	 * <p>
	 * Defines an interface for iterator specialized for {@code char} values. It
	 * extends the PrimitiveIterator interface for characters and provides
	 * additional methods specific to character iteration.
	 * 
	 * @implNote The use of {@link #nextChar()} is preferred over the use of
	 *           {@link #next()} because {@link #next()} is implemented by calling
	 *           and casting {@link #nextChar()}.
	 * @implNote Default implementation does not support modification such as
	 *           {@link #remove()}
	 */
	interface OfChar
			extends PrimitiveIterator<Character, PrimitiveConsumer.OfChar> {

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 */
		@Override
		default PrimitiveIterator.OfDouble toDouble() {
			return new PrimitiveIterator.OfDouble() {

				@Override
				public boolean hasNext() {
					return OfChar.this.hasNext();
				}

				@Override
				public double nextDouble() {
					return OfChar.this.nextChar();
				}
			};
		}

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 */
		@Override
		default PrimitiveIterator.OfLong toLong() {
			return new PrimitiveIterator.OfLong() {

				@Override
				public boolean hasNext() {
					return OfChar.this.hasNext();
				}

				@Override
				public long nextLong() {
					return OfChar.this.nextChar();
				}
			};
		}

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 */
		@Override
		default PrimitiveIterator.OfInt toInt() {
			return new PrimitiveIterator.OfInt() {

				@Override
				public boolean hasNext() {
					return OfChar.this.hasNext();
				}

				@Override
				public int nextInt() {
					return OfChar.this.nextChar();
				}
			};
		}

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 */
		@Override
		default OfFloat toFloat() {
			return new OfFloat() {

				@Override
				public boolean hasNext() {
					return OfChar.this.hasNext();
				}

				@Override
				public float nextFloat() {
					return OfChar.this.nextChar();
				}
			};
		}

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 * 
		 * @implNote returns {@code this}
		 */
		@Override
		default OfChar toChar() {
			return this;
		}

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 */
		@Override
		default OfShort toShort() {
			return new OfShort() {

				@Override
				public boolean hasNext() {
					return OfChar.this.hasNext();
				}

				@Override
				public short nextShort() {
					return (short) OfChar.this.nextChar();
				}
			};
		}

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 */
		@Override
		default OfByte toByte() {
			return new OfByte() {

				@Override
				public boolean hasNext() {
					return OfChar.this.hasNext();
				}

				@Override
				public byte nextByte() {
					return (byte) OfChar.this.nextChar();
				}
			};
		}

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 */
		@Override
		default OfBoolean toBoolean() {
			return new OfBoolean() {

				@Override
				public boolean hasNext() {
					return OfChar.this.hasNext();
				}

				@Override
				public boolean nextBoolean() {
					return OfChar.this.nextChar() != '\u0000';
				}
			};
		}

		/**
		 * Returns the next {@code char} element in the iteration.
		 *
		 * @return the next {@code char} element in the iteration
		 * @throws NoSuchElementException if the iteration has no more elements
		 */
		char nextChar() throws NoSuchElementException;

		/**
		 * {@inheritDoc}
		 * 
		 * @implSpec
		 *           <p>
		 *           The default implementation behaves as if:
		 * 
		 *           <pre>{@code
		 *     while (hasNext())
		 *         action.accept(nextChar());
		 * }</pre>
		 */
		default void forEachRemaining(PrimitiveConsumer.OfChar action) {
			Objects.requireNonNull(action);
			while (hasNext())
				action.acceptChar(nextChar());
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @implSpec The default implementation boxes the result of calling
		 *           {@link #nextChar()}, and returns that boxed result.
		 */
		@Override
		default Character next() throws NoSuchElementException {
			return nextChar();
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @implSpec If the action is an instance of {@code CharConsumer} then it is
		 *           cast to {@code CharConsumer} and passed to
		 *           {@link #forEachRemaining}; otherwise the action is adapted to an
		 *           instance of {@code CharConsumer}, by boxing the argument of
		 *           {@code CharConsumer}, and then passed to {@link #forEachRemaining}.
		 */
		@Override
		default void forEachRemaining(Consumer<? super Character> action) {
			if (action instanceof PrimitiveConsumer.OfChar) {
				forEachRemaining((PrimitiveConsumer.OfChar) action);
				return;
			}
			Objects.requireNonNull(action);
			forEachRemaining((PrimitiveConsumer.OfChar) action::accept);
		}
	}

	/**
	 * An Iterator specialized for {@code float} values.
	 * <p>
	 * Defines an interface for iterator specialized for {@code float} values. It
	 * extends the PrimitiveIterator interface and provides
	 * additional methods specific to {@code float} values iteration.
	 * 
	 * @implNote The use of {@link #nextFloat()} is preferred over the use of
	 *           {@link #next()} because {@link #next()} is implemented by calling
	 *           and casting {@link #nextFloat()}.
	 * @implNote Default implementation does not support modification such as
	 *           {@link #remove()}
	 */
	interface OfFloat
			extends PrimitiveIterator<Float, PrimitiveConsumer.OfFloat> {

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 */
		@Override
		default OfDouble toDouble() {
			return new OfDouble() {

				@Override
				public boolean hasNext() {
					return OfFloat.this.hasNext();
				}

				@Override
				public double nextDouble() {
					return OfFloat.this.nextFloat();
				}
			};
		}

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 */
		@Override
		default PrimitiveIterator.OfLong toLong() {
			return new PrimitiveIterator.OfLong() {

				@Override
				public boolean hasNext() {
					return OfFloat.this.hasNext();
				}

				@Override
				public long nextLong() {
					return (long) OfFloat.this.nextFloat();
				}
			};
		}

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 */
		@Override
		default PrimitiveIterator.OfInt toInt() {
			return new PrimitiveIterator.OfInt() {

				@Override
				public boolean hasNext() {
					return OfFloat.this.hasNext();
				}

				@Override
				public int nextInt() {
					return (int) OfFloat.this.nextFloat();
				}
			};
		}

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 * 
		 * @implNote returns {@code this}
		 */
		@Override
		default OfFloat toFloat() {
			return this;
		}

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 */
		@Override
		default OfChar toChar() {
			return new OfChar() {

				@Override
				public boolean hasNext() {
					return OfFloat.this.hasNext();
				}

				@Override
				public char nextChar() throws NoSuchElementException {
					return (char) OfFloat.this.nextFloat();
				}
			};
		}

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 */
		@Override
		default OfShort toShort() {
			return new OfShort() {

				@Override
				public boolean hasNext() {
					return OfFloat.this.hasNext();
				}

				@Override
				public short nextShort() {
					return (short) OfFloat.this.nextFloat();
				}
			};
		}

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 */
		@Override
		default OfByte toByte() {
			return new OfByte() {

				@Override
				public boolean hasNext() {
					return OfFloat.this.hasNext();
				}

				@Override
				public byte nextByte() {
					return (byte) OfFloat.this.nextFloat();
				}
			};
		}

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 */
		@Override
		default OfBoolean toBoolean() {
			return new OfBoolean() {

				@Override
				public boolean hasNext() {
					return OfFloat.this.hasNext();
				}

				@Override
				public boolean nextBoolean() {
					return OfFloat.this.nextFloat() != 0;
				}
			};
		}

		/**
		 * Returns the next {@code float} element in the iteration.
		 *
		 * @return the next {@code float} element in the iteration
		 * @throws NoSuchElementException if the iteration has no more elements
		 */
		float nextFloat() throws NoSuchElementException;

		/**
		 * {@inheritDoc}
		 * 
		 * @implSpec
		 *           <p>
		 *           The default implementation behaves as if:
		 * 
		 *           <pre>{@code
		 *     while (hasNext())
		 *         action.accept(nextFloat());
		 * }</pre>
		 */
		default void forEachRemaining(PrimitiveConsumer.OfFloat action) {
			Objects.requireNonNull(action);
			while (hasNext())
				action.acceptFloat(nextFloat());
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @implSpec The default implementation boxes the result of calling
		 *           {@link #nextFloat()}, and returns that boxed result.
		 */
		@Override
		default Float next() throws NoSuchElementException {
			return nextFloat();
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @implSpec If the action is an instance of
		 *           {@code jdk.prim.util.function.Float.Consumer} then
		 *           it is cast to
		 *           {@code jdk.prim.util.function.Float.Consumer} and
		 *           passed to {@link #forEachRemaining}; otherwise the action is
		 *           adapted to an instance of
		 *           {@code jdk.prim.util.function.Float.Consumer}, by
		 *           boxing the argument of
		 *           {@code jdk.prim.util.function.Float.Consumer}, and
		 *           then passed to {@link #forEachRemaining}.
		 */
		@Override
		default void forEachRemaining(Consumer<? super Float> action) {
			if (action instanceof PrimitiveConsumer.OfFloat) {
				forEachRemaining((PrimitiveConsumer.OfFloat) action);
				return;
			}
			Objects.requireNonNull(action);
			forEachRemaining((PrimitiveConsumer.OfFloat) action::accept);
		}

	}

	/**
	 * An Iterator specialized for {@code short} values.
	 * <p>
	 * Defines an interface for iterator specialized for {@code short} values. It
	 * extends the PrimitiveIterator interface and provides
	 * additional methods specific to {@code short} values iteration.
	 * 
	 * @implNote The use of {@link #nextShort()} is preferred over the use of
	 *           {@link #next()} because {@link #next()} is implemented by calling
	 *           and casting {@link #nextShort()}.
	 * @implNote Default implementation does not support modification such as
	 *           {@link #remove()}
	 */
	interface OfShort
			extends PrimitiveIterator<Short, PrimitiveConsumer.OfShort> {

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 */
		@Override
		default OfDouble toDouble() {
			return new OfDouble() {

				@Override
				public boolean hasNext() {
					return OfShort.this.hasNext();
				}

				@Override
				public double nextDouble() {
					return OfShort.this.nextShort();
				}
			};
		}

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 */
		@Override
		default PrimitiveIterator.OfLong toLong() {
			return new PrimitiveIterator.OfLong() {

				@Override
				public boolean hasNext() {
					return OfShort.this.hasNext();
				}

				@Override
				public long nextLong() {
					return OfShort.this.nextShort();
				}
			};
		}

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 */
		@Override
		default PrimitiveIterator.OfInt toInt() {
			return new PrimitiveIterator.OfInt() {

				@Override
				public boolean hasNext() {
					return OfShort.this.hasNext();
				}

				@Override
				public int nextInt() {
					return OfShort.this.nextShort();
				}
			};
		}

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 */
		@Override
		default OfFloat toFloat() {
			return new OfFloat() {

				@Override
				public boolean hasNext() {
					return OfShort.this.hasNext();
				}

				@Override
				public float nextFloat() throws NoSuchElementException {
					return OfShort.this.nextShort();
				}
			};
		}

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 */
		@Override
		default OfChar toChar() {
			return new OfChar() {

				@Override
				public boolean hasNext() {
					return OfShort.this.hasNext();
				}

				@Override
				public char nextChar() throws NoSuchElementException {
					return (char) OfShort.this.nextShort();
				}
			};
		}

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 * 
		 * @implNote returns {@code this}
		 */
		@Override
		default OfShort toShort() {
			return this;
		}

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 */
		@Override
		default OfByte toByte() {
			return new OfByte() {

				@Override
				public boolean hasNext() {
					return OfShort.this.hasNext();
				}

				@Override
				public byte nextByte() {
					return (byte) OfShort.this.nextShort();
				}
			};
		}

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 */
		@Override
		default OfBoolean toBoolean() {
			return new OfBoolean() {

				@Override
				public boolean hasNext() {
					return OfShort.this.hasNext();
				}

				@Override
				public boolean nextBoolean() {
					return OfShort.this.nextShort() != 0;
				}
			};
		}

		/**
		 * Returns the next {@code short} element in the iteration.
		 *
		 * @return the next {@code short} element in the iteration
		 * @throws NoSuchElementException if the iteration has no more elements
		 */
		short nextShort() throws NoSuchElementException;

		/**
		 * {@inheritDoc}
		 * 
		 * @implSpec
		 *           <p>
		 *           The default implementation behaves as if:
		 * 
		 *           <pre>{@code
		 *     while (hasNext())
		 *         action.accept(nextShort());
		 * }</pre>
		 */
		default void forEachRemaining(PrimitiveConsumer.OfShort action) {
			Objects.requireNonNull(action);
			while (hasNext())
				action.acceptShort(nextShort());
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @implSpec The default implementation boxes the result of calling
		 *           {@link #nextShort()}, and returns that boxed result.
		 */
		@Override
		default Short next() throws NoSuchElementException {
			return nextShort();
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @implSpec If the action is an instance of
		 *           {@code jdk.prim.util.function.Short.Consumer} then
		 *           it is cast to
		 *           {@code jdk.prim.util.function.Short.Consumer} and
		 *           passed to {@link #forEachRemaining}; otherwise the action is
		 *           adapted to an instance of
		 *           {@code jdk.prim.util.function.Short.Consumer}, by
		 *           boxing the argument of
		 *           {@code jdk.prim.util.function.Short.Consumer}, and
		 *           then passed to {@link #forEachRemaining}.
		 */
		@Override
		default void forEachRemaining(Consumer<? super Short> action) {
			if (action instanceof PrimitiveConsumer.OfShort) {
				forEachRemaining((PrimitiveConsumer.OfShort) action);
				return;
			}
			Objects.requireNonNull(action);
			forEachRemaining((PrimitiveConsumer.OfShort) action::accept);
		}

	}

	/**
	 * An Iterator specialized for {@code byte} values.
	 * <p>
	 * Defines an interface for iterator specialized for {@code byte} values. It
	 * extends the PrimitiveIterator interface and provides
	 * additional methods specific to {@code byte} values iteration.
	 * 
	 * @implNote The use of {@link #nextByte()} is preferred over the use of
	 *           {@link #next()} because {@link #next()} is implemented by calling
	 *           and casting {@link #nextByte()}.
	 * @implNote Default implementation does not support modification such as
	 *           {@link #remove()}
	 */
	interface OfByte
			extends PrimitiveIterator<Byte, PrimitiveConsumer.OfByte> {

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 */
		@Override
		default OfDouble toDouble() {
			return new OfDouble() {

				@Override
				public boolean hasNext() {
					return OfByte.this.hasNext();
				}

				@Override
				public double nextDouble() {
					return OfByte.this.nextByte();
				}
			};
		}

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 */
		@Override
		default PrimitiveIterator.OfLong toLong() {
			return new PrimitiveIterator.OfLong() {

				@Override
				public boolean hasNext() {
					return OfByte.this.hasNext();
				}

				@Override
				public long nextLong() {
					return OfByte.this.nextByte();
				}
			};
		}

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 */
		@Override
		default PrimitiveIterator.OfInt toInt() {
			return new PrimitiveIterator.OfInt() {

				@Override
				public boolean hasNext() {
					return OfByte.this.hasNext();
				}

				@Override
				public int nextInt() {
					return OfByte.this.nextByte();
				}
			};
		}

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 */
		@Override
		default OfFloat toFloat() {
			return new OfFloat() {

				@Override
				public boolean hasNext() {
					return OfByte.this.hasNext();
				}

				@Override
				public float nextFloat() throws NoSuchElementException {
					return OfByte.this.nextByte();
				}
			};
		}

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 */
		@Override
		default OfChar toChar() {
			return new OfChar() {

				@Override
				public boolean hasNext() {
					return OfByte.this.hasNext();
				}

				@Override
				public char nextChar() throws NoSuchElementException {
					return (char) OfByte.this.nextByte();
				}
			};
		}

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 */
		@Override
		default OfShort toShort() {
			return new OfShort() {

				@Override
				public boolean hasNext() {
					return OfByte.this.hasNext();
				}

				@Override
				public short nextShort() throws NoSuchElementException {
					return OfByte.this.nextByte();
				}
			};
		}

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 * 
		 * @implNote returns {@code this}
		 */
		@Override
		default OfByte toByte() {
			return this;
		}

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 */
		@Override
		default OfBoolean toBoolean() {
			return new OfBoolean() {

				@Override
				public boolean hasNext() {
					return OfByte.this.hasNext();
				}

				@Override
				public boolean nextBoolean() {
					return OfByte.this.nextByte() != 0;
				}
			};
		}

		/**
		 * Returns the next {@code byte} element in the iteration.
		 *
		 * @return the next {@code byte} element in the iteration
		 * @throws NoSuchElementException if the iteration has no more elements
		 */
		byte nextByte() throws NoSuchElementException;

		/**
		 * {@inheritDoc}
		 * 
		 * @implSpec
		 *           <p>
		 *           The default implementation behaves as if:
		 * 
		 *           <pre>{@code
		 *     while (hasNext())
		 *         action.accept(nextByte());
		 * }</pre>
		 */
		default void forEachRemaining(PrimitiveConsumer.OfByte action) {
			Objects.requireNonNull(action);
			while (hasNext())
				action.acceptByte(nextByte());
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @implSpec The default implementation boxes the result of calling
		 *           {@link #nextByte()}, and returns that boxed result.
		 */
		@Override
		default Byte next() throws NoSuchElementException {
			return nextByte();
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @implSpec If the action is an instance of
		 *           {@code jdk.prim.util.function.Byte.Consumer} then it
		 *           is cast to
		 *           {@code jdk.prim.util.function.Byte.Consumer} and
		 *           passed to {@link #forEachRemaining}; otherwise the action is
		 *           adapted to an instance of
		 *           {@code jdk.prim.util.function.Byte.Consumer}, by
		 *           boxing the argument of
		 *           {@code jdk.prim.util.function.Byte.Consumer}, and
		 *           then passed to {@link #forEachRemaining}.
		 */
		@Override
		default void forEachRemaining(Consumer<? super Byte> action) {
			if (action instanceof PrimitiveConsumer.OfByte) {
				forEachRemaining((PrimitiveConsumer.OfByte) action);
				return;
			}
			Objects.requireNonNull(action);
			forEachRemaining((PrimitiveConsumer.OfByte) action::accept);
		}

	}

	/**
	 * An Iterator specialized for {@code boolean} values.
	 * <p>
	 * Defines an interface for iterator specialized for {@code boolean} values. It
	 * extends the PrimitiveIterator interface and provides
	 * additional methods specific to {@code boolean} values iteration.
	 * 
	 * @implNote The use of {@link #nextBoolean()} is preferred over the use of
	 *           {@link #next()} because {@link #next()} is implemented by calling
	 *           and casting {@link #nextBoolean()}.
	 * @implNote Default implementation does not support modification such as
	 *           {@link #remove()}
	 */
	interface OfBoolean
			extends PrimitiveIterator<Boolean, PrimitiveConsumer.OfBoolean> {

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 */
		@Override
		default OfDouble toDouble() {
			return new OfDouble() {

				@Override
				public boolean hasNext() {
					return OfBoolean.this.hasNext();
				}

				@Override
				public double nextDouble() {
					return OfBoolean.this.nextBoolean() ? 1 : 0;
				}
			};
		}

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 */
		@Override
		default PrimitiveIterator.OfLong toLong() {
			return new PrimitiveIterator.OfLong() {

				@Override
				public boolean hasNext() {
					return OfBoolean.this.hasNext();
				}

				@Override
				public long nextLong() {
					return OfBoolean.this.nextBoolean() ? 1 : 0;
				}
			};
		}

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 */
		@Override
		default PrimitiveIterator.OfInt toInt() {
			return new PrimitiveIterator.OfInt() {

				@Override
				public boolean hasNext() {
					return OfBoolean.this.hasNext();
				}

				@Override
				public int nextInt() {
					return OfBoolean.this.nextBoolean() ? 1 : 0;
				}
			};
		}

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 */
		@Override
		default OfFloat toFloat() {
			return new OfFloat() {

				@Override
				public boolean hasNext() {
					return OfBoolean.this.hasNext();
				}

				@Override
				public float nextFloat() throws NoSuchElementException {
					return OfBoolean.this.nextBoolean() ? 1.0f : 0.0f;
				}
			};
		}

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 */
		@Override
		default OfChar toChar() {
			return new OfChar() {

				@Override
				public boolean hasNext() {
					return OfBoolean.this.hasNext();
				}

				@Override
				public char nextChar() throws NoSuchElementException {
					return OfBoolean.this.nextBoolean() ? '\u0001' : 0;
				}
			};
		}

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 */
		@Override
		default OfShort toShort() {
			return new OfShort() {

				@Override
				public boolean hasNext() {
					return OfBoolean.this.hasNext();
				}

				@Override
				public short nextShort() throws NoSuchElementException {
					return OfBoolean.this.nextBoolean() ? (short) 1 : 0;
				}
			};
		}

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 */
		@Override
		default OfByte toByte() {
			return new OfByte() {

				@Override
				public boolean hasNext() {
					return OfBoolean.this.hasNext();
				}

				@Override
				public byte nextByte() throws NoSuchElementException {
					return OfBoolean.this.nextBoolean() ? (byte) 1 : 0;
				}
			};
		}

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 * 
		 * @implNote returns {@code this}
		 */
		@Override
		default OfBoolean toBoolean() {
			return this;
		}

		/**
		 * Returns the next {@code boolean} element in the iteration.
		 *
		 * @return the next {@code boolean} element in the iteration
		 * @throws NoSuchElementException if the iteration has no more elements
		 */
		boolean nextBoolean() throws NoSuchElementException;

		/**
		 * {@inheritDoc}
		 * 
		 * @implSpec
		 *           <p>
		 *           The default implementation behaves as if:
		 * 
		 *           <pre>{@code
		 *     while (hasNext())
		 *         action.accept(nextBoolean());
		 * }</pre>
		 */
		default void forEachRemaining(PrimitiveConsumer.OfBoolean action) {
			Objects.requireNonNull(action);
			while (hasNext())
				action.acceptBoolean(nextBoolean());
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @implSpec The default implementation boxes the result of calling
		 *           {@link #nextBoolean()}, and returns that boxed result.
		 */
		@Override
		default Boolean next() throws NoSuchElementException {
			return nextBoolean();
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @implSpec If the action is an instance of
		 *           {@code jdk.prim.util.function.Boolean.Consumer} then
		 *           it is cast to
		 *           {@code jdk.prim.util.function.Boolean.Consumer} and
		 *           passed to {@link #forEachRemaining}; otherwise the action is
		 *           adapted to an instance of
		 *           {@code jdk.prim.util.function.Boolean.Consumer}, by
		 *           boxing the argument of
		 *           {@code jdk.prim.util.function.Boolean.Consumer}, and
		 *           then passed to {@link #forEachRemaining}.
		 */
		@Override
		default void forEachRemaining(Consumer<? super Boolean> action) {
			if (action instanceof PrimitiveConsumer.OfBoolean) {
				forEachRemaining((PrimitiveConsumer.OfBoolean) action);
				return;
			}
			Objects.requireNonNull(action);
			forEachRemaining((PrimitiveConsumer.OfBoolean) action::accept);
		}

	}

	/*
	 * Date created: 27 May 2024 Time created: 14:07:48
	 */
	/**
	 * Casts this iterator to a double iterator. This may cause a widening/narrowing
	 * primitive conversion to take place.
	 * 
	 * @return an iterator of {@code double} whereby each element returned is cast
	 *         to a {@code double}.
	 * @apiNote The returned iterator contains a reference to {@code this}. Hence
	 *          any changes to the returned iterator affects {@code this} and
	 *          vice-versa.
	 */
	OfDouble toDouble();

	/*
	 * Date created: 27 May 2024 Time created: 14:07:48
	 */
	/**
	 * Casts this iterator to a long iterator. This may cause a widening/narrowing
	 * primitive conversion to take place.
	 * 
	 * @return an iterator of {@code long} whereby each element returned is cast to
	 *         a {@code long}.
	 * @apiNote The returned iterator contains a reference to {@code this}. Hence
	 *          any changes to the returned iterator affects {@code this} and
	 *          vice-versa.
	 */
	OfLong toLong();

	/*
	 * Date created: 27 May 2024 Time created: 14:07:48
	 */
	/**
	 * Casts this iterator to an int iterator. This may cause a widening/narrowing
	 * primitive conversion to take place.
	 * 
	 * @return an iterator of {@code int} whereby each element returned is cast to a
	 *         {@code int}.
	 * @apiNote The returned iterator contains a reference to {@code this}. Hence
	 *          any changes to the returned iterator affects {@code this} and
	 *          vice-versa.
	 */
	OfInt toInt();

	/*
	 * Date created: 27 May 2024 Time created: 14:07:48
	 */
	/**
	 * Casts this iterator to a float iterator. This may cause a widening/narrowing
	 * primitive conversion to take place.
	 * 
	 * @return an iterator of {@code float} whereby each element returned is cast to
	 *         a {@code float}.
	 * @apiNote The returned iterator contains a reference to {@code this}. Hence
	 *          any changes to the returned iterator affects {@code this} and
	 *          vice-versa.
	 */
	OfFloat toFloat();

	/*
	 * Date created: 27 May 2024 Time created: 14:07:48
	 */
	/**
	 * Casts this iterator to a char iterator. This may cause a widening/narrowing
	 * primitive conversion to take place.
	 * 
	 * @return an iterator of {@code char} cast of each element returned.
	 * @apiNote The returned iterator contains a reference to {@code this}. Hence
	 *          any changes to the returned iterator affects {@code this} and
	 *          vice-versa.
	 */
	OfChar toChar();

	/*
	 * Date created: 27 May 2024 Time created: 14:07:48
	 */
	/**
	 * Casts this iterator to a short iterator. This may cause a widening/narrowing
	 * primitive conversion to take place.
	 * 
	 * @return an iterator of {@code short} whereby each element returned is cast to
	 *         a {@code short}.
	 * @apiNote The returned iterator contains a reference to {@code this}. Hence
	 *          any changes to the returned iterator affects {@code this} and
	 *          vice-versa.
	 */
	OfShort toShort();

	/*
	 * Date created: 27 May 2024 Time created: 14:07:48
	 */
	/**
	 * Casts this iterator to a byte iterator. This may cause a widening/narrowing
	 * primitive conversion to take place.
	 * 
	 * @return an iterator of {@code byte} whereby each element returned is cast to
	 *         a {@code byte}.
	 * @apiNote The returned iterator contains a reference to {@code this}. Hence
	 *          any changes to the returned iterator affects {@code this} and
	 *          vice-versa.
	 */
	OfByte toByte();

	/*
	 * Date created: 27 May 2024 Time created: 14:07:48
	 */
	/**
	 * Casts this iterator to a boolean iterator. This may cause a
	 * widening/narrowing primitive conversion to take place.
	 * 
	 * @return an iterator of {@code boolean} whereby each element returned is cast
	 *         to a {@code boolean}.
	 * @apiNote The returned iterator contains a reference to {@code this}. Hence
	 *          any changes to the returned iterator affects {@code this} and
	 *          vice-versa.
	 */
	OfBoolean toBoolean();
}
