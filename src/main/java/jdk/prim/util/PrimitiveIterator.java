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

import jdk.prim.BoxedPrimitive;
import jdk.prim.util.function.PrimitiveConsumer;
import jdk.prim.util.function.PrimitiveFunction;

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
public interface PrimitiveIterator<T, T_CONS> extends java.util.PrimitiveIterator<T, T_CONS>, BoxedPrimitive<java.util.PrimitiveIterator<T, T_CONS>, T> {

	/**
	 * An Iterator specialized for {@code double} values.
	 * <p>
	 * Defines an interface for iterator specialized for {@code double} values. It
	 * extends the {@link jdk.prim.util.PrimitiveIterator.OfDouble} interface and
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

		/**
		 * Creates and returns a boxed an iterator of {@link java.lang.Double Double} objects where each element is a boxed {@code double} value.
		 * 
		 * @return an iterator of boxed {@code Double}
		 */
		@Override
		default java.util.PrimitiveIterator<Double, DoubleConsumer> boxed() { return this; }

		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextDouble()} will
		 * be used as the argument to the given mapper.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code double} values
		 * are returned through a new {@link PrimitiveIterator.OfDouble} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToDouble}
		*            and accept elements of type {@code Double}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code double} value.
		*               Must not be {@code null}.
		* @param rm can be {@code null}
		* @return a new {@link PrimitiveIterator.OfDouble} instance that provides the mapped {@code double} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToDouble.OfDouble}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper.
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToDouble
		* @see PrimitiveFunction.ToDouble.OfDouble
		 */
		@Override
		default <M extends PrimitiveFunction.ToDouble<? super java.lang.Double>, RM extends PrimitiveFunction<? extends java.lang.Double, ? super java.lang.Double>> PrimitiveIterator.OfDouble mapToDouble(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			PrimitiveFunction.ToDouble.OfDouble f;
			if(mapper instanceof PrimitiveFunction.ToDouble.OfDouble) f = (PrimitiveFunction.ToDouble.OfDouble) mapper;
			else f = x -> mapper.applyDouble(x);
			PrimitiveIterator.OfDouble thisIt = this;
			return new PrimitiveIterator.OfDouble() {
				@Override public boolean hasNext() { return thisIt.hasNext(); }
				@Override public double nextDouble() { return f.applyDouble(thisIt.nextDouble()); }
			};
		}
		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextDouble()} will
		 * be used as the argument to the given mapper.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code long} values
		 * are returned through a new {@link PrimitiveIterator.OfLong} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToLong}
		*            and accept elements of type {@code Double}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code long} value.
		*               Must not be {@code null}.
		* @param rm can be {@code null}
		* @return a new {@link PrimitiveIterator.OfLong} instance that provides the mapped {@code long} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToLong.OfDouble}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper.
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToLong
		* @see PrimitiveFunction.ToLong.OfDouble
		 */
		@Override
		default <M extends PrimitiveFunction.ToLong<? super java.lang.Double>, RM extends PrimitiveFunction<? extends java.lang.Double, ? super java.lang.Long>> PrimitiveIterator.OfLong mapToLong(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			PrimitiveFunction.ToLong.OfDouble f;
			if(mapper instanceof PrimitiveFunction.ToLong.OfDouble) f = (PrimitiveFunction.ToLong.OfDouble) mapper;
			else f = x -> mapper.applyLong(x);
			return new PrimitiveIterator.OfLong() {
				@Override public boolean hasNext() { return PrimitiveIterator.OfDouble.this.hasNext(); }
				@Override public long nextLong() { return f.applyLong(PrimitiveIterator.OfDouble.this.nextDouble());}
			};
		}
		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextDouble()} will
		 * be used as the argument to the given mapper.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code int} values
		 * are returned through a new {@link PrimitiveIterator.OfInt} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToInt}
		*            and accept elements of type {@code Double}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code int} value.
		*               Must not be {@code null}.
		* @param rm can be {@code null}
		* @return a new {@link PrimitiveIterator.OfInt} instance that provides the mapped {@code int} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToInt.OfDouble}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper.
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToInt
		* @see PrimitiveFunction.ToInt.OfDouble
		 */
		@Override
		default <M extends PrimitiveFunction.ToInt<? super java.lang.Double>, RM extends PrimitiveFunction<? extends java.lang.Double, ? super java.lang.Integer>> PrimitiveIterator.OfInt mapToInt(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			PrimitiveFunction.ToInt.OfDouble f;
			if(mapper instanceof PrimitiveFunction.ToInt.OfDouble) f = (PrimitiveFunction.ToInt.OfDouble) mapper;
			else f = x -> mapper.applyInt(x);
			return new PrimitiveIterator.OfInt() {
				@Override public boolean hasNext() { return PrimitiveIterator.OfDouble.this.hasNext(); }
				@Override public int nextInt() { return f.applyInt(PrimitiveIterator.OfDouble.this.nextDouble());}
			};
		}
		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextDouble()} will
		 * be used as the argument to the given mapper.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code float} values
		 * are returned through a new {@link PrimitiveIterator.OfFloat} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToFloat}
		*            and accept elements of type {@code Double}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code float} value.
		*               Must not be {@code null}.
		* @param rm can be {@code null}
		* @return a new {@link PrimitiveIterator.OfFloat} instance that provides the mapped {@code float} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToFloat.OfDouble}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper.
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToFloat
		* @see PrimitiveFunction.ToFloat.OfDouble
		 */
		@Override
		default <M extends PrimitiveFunction.ToFloat<? super java.lang.Double>, RM extends PrimitiveFunction<? extends java.lang.Double, ? super java.lang.Float>> PrimitiveIterator.OfFloat mapToFloat(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			PrimitiveFunction.ToFloat.OfDouble f;
			if(mapper instanceof PrimitiveFunction.ToFloat.OfDouble) f = (PrimitiveFunction.ToFloat.OfDouble) mapper;
			else f = x -> mapper.applyFloat(x);
			return new PrimitiveIterator.OfFloat() {
				@Override public boolean hasNext() { return PrimitiveIterator.OfDouble.this.hasNext(); }
				@Override public float nextFloat() { return f.applyFloat(PrimitiveIterator.OfDouble.this.nextDouble());}
			};
		}
		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextDouble()} will
		 * be used as the argument to the given mapper.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code char} values
		 * are returned through a new {@link PrimitiveIterator.OfChar} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToChar}
		*            and accept elements of type {@code Double}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code char} value.
		*               Must not be {@code null}.
		* @param rm can be {@code null}
		* @return a new {@link PrimitiveIterator.OfChar} instance that provides the mapped {@code char} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToChar.OfDouble}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper.
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToChar
		* @see PrimitiveFunction.ToChar.OfDouble
		 */
		@Override
		default <M extends PrimitiveFunction.ToChar<? super java.lang.Double>, RM extends PrimitiveFunction<? extends java.lang.Double, ? super java.lang.Character>> PrimitiveIterator.OfChar mapToChar(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			PrimitiveFunction.ToChar.OfDouble f;
			if(mapper instanceof PrimitiveFunction.ToChar.OfDouble) f = (PrimitiveFunction.ToChar.OfDouble) mapper;
			else f = x -> mapper.applyChar(x);
			return new PrimitiveIterator.OfChar() {
				@Override public boolean hasNext() { return PrimitiveIterator.OfDouble.this.hasNext(); }
				@Override public char nextChar() { return f.applyChar(PrimitiveIterator.OfDouble.this.nextDouble());}
			};
		}
		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextDouble()} will
		 * be used as the argument to the given mapper.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code short} values
		 * are returned through a new {@link PrimitiveIterator.OfShort} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToShort}
		*            and accept elements of type {@code Double}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code short} value.
		*               Must not be {@code null}.
		* @param rm can be {@code null}
		* @return a new {@link PrimitiveIterator.OfShort} instance that provides the mapped {@code short} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToShort.OfDouble}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper.
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToShort
		* @see PrimitiveFunction.ToShort.OfDouble
		 */
		@Override
		default <M extends PrimitiveFunction.ToShort<? super java.lang.Double>, RM extends PrimitiveFunction<? extends java.lang.Double, ? super java.lang.Short>> PrimitiveIterator.OfShort mapToShort(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			PrimitiveFunction.ToShort.OfDouble f;
			if(mapper instanceof PrimitiveFunction.ToShort.OfDouble) f = (PrimitiveFunction.ToShort.OfDouble) mapper;
			else f = x -> mapper.applyShort(x);
			return new PrimitiveIterator.OfShort() {
				@Override public boolean hasNext() { return PrimitiveIterator.OfDouble.this.hasNext(); }
				@Override public short nextShort() { return f.applyShort(PrimitiveIterator.OfDouble.this.nextDouble());}
			};
		}
		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextDouble()} will
		 * be used as the argument to the given mapper.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code byte} values
		 * are returned through a new {@link PrimitiveIterator.OfByte} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToByte}
		*            and accept elements of type {@code Double}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code byte} value.
		*               Must not be {@code null}.
		* @param rm can be {@code null}
		* @return a new {@link PrimitiveIterator.OfByte} instance that provides the mapped {@code byte} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToByte.OfDouble}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper.
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToByte
		* @see PrimitiveFunction.ToByte.OfDouble
		 */
		@Override
		default <M extends PrimitiveFunction.ToByte<? super java.lang.Double>, RM extends PrimitiveFunction<? extends java.lang.Double, ? super java.lang.Byte>> PrimitiveIterator.OfByte mapToByte(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			PrimitiveFunction.ToByte.OfDouble f;
			if(mapper instanceof PrimitiveFunction.ToByte.OfDouble) f = (PrimitiveFunction.ToByte.OfDouble) mapper;
			else f = x -> mapper.applyByte(x);
			return new PrimitiveIterator.OfByte() {
				@Override public boolean hasNext() { return PrimitiveIterator.OfDouble.this.hasNext(); }
				@Override public byte nextByte() { return f.applyByte(PrimitiveIterator.OfDouble.this.nextDouble());}
			};
		}
		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextDouble()} will
		 * be used as the argument to the given mapper.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code boolean} values
		 * are returned through a new {@link PrimitiveIterator.OfBoolean} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToBoolean}
		*            and accept elements of type {@code Double}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code boolean} value.
		*               Must not be {@code null}.
		* @param rm can be {@code null}
		* @return a new {@link PrimitiveIterator.OfBoolean} instance that provides the mapped {@code boolean} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToBoolean.OfDouble}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper.
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToBoolean
		* @see PrimitiveFunction.ToBoolean.OfDouble
		 */
		@Override
		default <M extends PrimitiveFunction.ToBoolean<? super java.lang.Double>, RM extends PrimitiveFunction<? extends java.lang.Double, ? super java.lang.Boolean>> PrimitiveIterator.OfBoolean mapToBoolean(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			PrimitiveFunction.ToBoolean.OfDouble f;
			if(mapper instanceof PrimitiveFunction.ToBoolean.OfDouble) f = (PrimitiveFunction.ToBoolean.OfDouble) mapper;
			else f = x -> mapper.applyBoolean(x);
			return new PrimitiveIterator.OfBoolean() {
				@Override public boolean hasNext() { return PrimitiveIterator.OfDouble.this.hasNext(); }
				@Override public boolean nextBoolean() { return f.applyBoolean(PrimitiveIterator.OfDouble.this.nextDouble());}
			};
		}

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
		default void forEachRemaining(PrimitiveConsumer.OfDouble action) {
			Objects.requireNonNull(action);
			while(hasNext()) action.acceptDouble(nextDouble());
		}
	}

	/**
	 * An Iterator specialized for {@code long} values.
	 * <p>
	 * Defines an interface for iterator specialized for {@code long} values. It
	 * extends the {@link jdk.prim.util.PrimitiveIterator.OfLong} interface and provides
	 * additional methods specific to {@code long} values iteration.
	 * 
	 * @implNote The use of {@link #nextLong()} is preferred over the use of
	 *           {@link #next()} because {@link #next()} is implemented by calling
	 *           and casting {@link #nextLong()}.
	 * @implNote Default implementation does not support modification such as
	 *           {@link #remove()}
	 */
	interface OfLong extends PrimitiveIterator<Long, LongConsumer>, java.util.PrimitiveIterator.OfLong {

		/**
		 * Creates and returns a boxed an iterator of {@link java.lang.Long Double} objects where each element is a boxed {@code long} value.
		 * 
		 * @return an iterator of boxed {@code Long}
		 */
		@Override
		default java.util.PrimitiveIterator<Long, LongConsumer> boxed() { return this; }

		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextLong()} will
		 * be used as the argument to the given mapper.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code double} values
		 * are returned through a new {@link PrimitiveIterator.OfDouble} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToDouble}
		*            and accept elements of type {@code Long}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code double} value.
		*               Must not be {@code null}.
		* @param rm can be {@code null}
		* @return a new {@link PrimitiveIterator.OfDouble} instance that provides the mapped {@code double} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToDouble.OfLong}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper. The {@code rm} parameter is ignored in the default implementation
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToDouble
		* @see PrimitiveFunction.ToDouble.OfLong
		 */
		@Override
		default <M extends PrimitiveFunction.ToDouble<? super java.lang.Long>, RM extends PrimitiveFunction<? extends java.lang.Long, ? super java.lang.Double>> PrimitiveIterator.OfDouble mapToDouble(M mapper, RM rm) {
			PrimitiveFunction.ToDouble.OfLong f;
			if(mapper instanceof PrimitiveFunction.ToDouble.OfLong) f = (PrimitiveFunction.ToDouble.OfLong) mapper;
			else f = x -> mapper.applyDouble(x);
			return new PrimitiveIterator.OfDouble() {
				@Override public boolean hasNext() { return PrimitiveIterator.OfLong.this.hasNext(); }
				@Override public double nextDouble() { return f.applyDouble(PrimitiveIterator.OfLong.this.nextLong());}
			};
		}
		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextLong()} will
		 * be used as the argument to the given mapper.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code long} values
		 * are returned through a new {@link PrimitiveIterator.OfLong} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToLong}
		*            and accept elements of type {@code Long}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code long} value.
		*               Must not be {@code null}.
		* @param rm can be {@code null}
		* @return a new {@link PrimitiveIterator.OfLong} instance that provides the mapped {@code long} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToLong.OfLong}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper. The {@code rm} parameter is ignored in the default implementation
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToLong
		* @see PrimitiveFunction.ToLong.OfLong
		 */
		@Override
		default <M extends PrimitiveFunction.ToLong<? super java.lang.Long>, RM extends PrimitiveFunction<? extends java.lang.Long, ? super java.lang.Long>> PrimitiveIterator.OfLong mapToLong(M mapper, RM rm) {
			PrimitiveFunction.ToLong.OfLong f;
			if(mapper instanceof PrimitiveFunction.ToLong.OfLong) f = (PrimitiveFunction.ToLong.OfLong) mapper;
			else f = x -> mapper.applyLong(x);
			PrimitiveIterator.OfLong thisIt = this;
			return new PrimitiveIterator.OfLong() {
				@Override public boolean hasNext() { return thisIt.hasNext(); }
				@Override public long nextLong() { return f.applyLong(thisIt.nextLong());}
			};
		}
		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextLong()} will
		 * be used as the argument to the given mapper.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code int} values
		 * are returned through a new {@link PrimitiveIterator.OfInt} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToInt}
		*            and accept elements of type {@code Long}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code int} value.
		*               Must not be {@code null}.
		* @param rm can be {@code null}
		* @return a new {@link PrimitiveIterator.OfInt} instance that provides the mapped {@code int} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToInt.OfLong}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper. The {@code rm} parameter is ignored in the default implementation
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToInt
		* @see PrimitiveFunction.ToInt.OfLong
		 */
		@Override
		default <M extends PrimitiveFunction.ToInt<? super java.lang.Long>, RM extends PrimitiveFunction<? extends java.lang.Long, ? super java.lang.Integer>> PrimitiveIterator.OfInt mapToInt(M mapper, RM rm) {
			PrimitiveFunction.ToInt.OfLong f;
			if(mapper instanceof PrimitiveFunction.ToInt.OfLong) f = (PrimitiveFunction.ToInt.OfLong) mapper;
			else f = x -> mapper.applyInt(x);
			return new PrimitiveIterator.OfInt() {
				@Override public boolean hasNext() { return PrimitiveIterator.OfLong.this.hasNext(); }
				@Override public int nextInt() { return f.applyInt(PrimitiveIterator.OfLong.this.nextLong());}
			};
		}
		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextLong()} will
		 * be used as the argument to the given mapper.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code float} values
		 * are returned through a new {@link PrimitiveIterator.OfFloat} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToFloat}
		*            and accept elements of type {@code Long}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code float} value.
		*               Must not be {@code null}.
		* @param rm can be {@code null}
		* @return a new {@link PrimitiveIterator.OfFloat} instance that provides the mapped {@code float} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToFloat.OfLong}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper. The {@code rm} parameter is ignored in the default implementation
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToFloat
		* @see PrimitiveFunction.ToFloat.OfLong
		 */
		@Override
		default <M extends PrimitiveFunction.ToFloat<? super java.lang.Long>, RM extends PrimitiveFunction<? extends java.lang.Long, ? super java.lang.Float>> PrimitiveIterator.OfFloat mapToFloat(M mapper, RM rm) {
			PrimitiveFunction.ToFloat.OfLong f;
			if(mapper instanceof PrimitiveFunction.ToFloat.OfLong) f = (PrimitiveFunction.ToFloat.OfLong) mapper;
			else f = x -> mapper.applyFloat(x);
			return new PrimitiveIterator.OfFloat() {
				@Override public boolean hasNext() { return PrimitiveIterator.OfLong.this.hasNext(); }
				@Override public float nextFloat() { return f.applyFloat(PrimitiveIterator.OfLong.this.nextLong());}
			};
		}
		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextLong()} will
		 * be used as the argument to the given mapper.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code char} values
		 * are returned through a new {@link PrimitiveIterator.OfChar} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToChar}
		*            and accept elements of type {@code Long}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code char} value.
		*               Must not be {@code null}.
		* @param rm can be {@code null}
		* @return a new {@link PrimitiveIterator.OfChar} instance that provides the mapped {@code char} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToChar.OfLong}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper. The {@code rm} parameter is ignored in the default implementation
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToChar
		* @see PrimitiveFunction.ToChar.OfLong
		 */
		@Override
		default <M extends PrimitiveFunction.ToChar<? super java.lang.Long>, RM extends PrimitiveFunction<? extends java.lang.Long, ? super java.lang.Character>> PrimitiveIterator.OfChar mapToChar(M mapper, RM rm) {
			PrimitiveFunction.ToChar.OfLong f;
			if(mapper instanceof PrimitiveFunction.ToChar.OfLong) f = (PrimitiveFunction.ToChar.OfLong) mapper;
			else f = x -> mapper.applyChar(x);
			return new PrimitiveIterator.OfChar() {
				@Override public boolean hasNext() { return PrimitiveIterator.OfLong.this.hasNext(); }
				@Override public char nextChar() { return f.applyChar(PrimitiveIterator.OfLong.this.nextLong());}
			};
		}
		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextLong()} will
		 * be used as the argument to the given mapper.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code short} values
		 * are returned through a new {@link PrimitiveIterator.OfShort} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToShort}
		*            and accept elements of type {@code Long}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code short} value.
		*               Must not be {@code null}.
		* @param rm can be {@code null}
		* @return a new {@link PrimitiveIterator.OfShort} instance that provides the mapped {@code short} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToShort.OfLong}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper. The {@code rm} parameter is ignored in the default implementation
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToShort
		* @see PrimitiveFunction.ToShort.OfLong
		 */
		@Override
		default <M extends PrimitiveFunction.ToShort<? super java.lang.Long>, RM extends PrimitiveFunction<? extends java.lang.Long, ? super java.lang.Short>> PrimitiveIterator.OfShort mapToShort(M mapper, RM rm) {
			PrimitiveFunction.ToShort.OfLong f;
			if(mapper instanceof PrimitiveFunction.ToShort.OfLong) f = (PrimitiveFunction.ToShort.OfLong) mapper;
			else f = x -> mapper.applyShort(x);
			return new PrimitiveIterator.OfShort() {
				@Override public boolean hasNext() { return PrimitiveIterator.OfLong.this.hasNext(); }
				@Override public short nextShort() { return f.applyShort(PrimitiveIterator.OfLong.this.nextLong());}
			};
		}
		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextLong()} will
		 * be used as the argument to the given mapper.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code byte} values
		 * are returned through a new {@link PrimitiveIterator.OfByte} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToByte}
		*            and accept elements of type {@code Long}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code byte} value.
		*               Must not be {@code null}.
		* @param rm can be {@code null}
		* @return a new {@link PrimitiveIterator.OfByte} instance that provides the mapped {@code byte} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToByte.OfLong}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper. The {@code rm} parameter is ignored in the default implementation
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToByte
		* @see PrimitiveFunction.ToByte.OfLong
		 */
		@Override
		default <M extends PrimitiveFunction.ToByte<? super java.lang.Long>, RM extends PrimitiveFunction<? extends java.lang.Long, ? super java.lang.Byte>> PrimitiveIterator.OfByte mapToByte(M mapper, RM rm) {
			PrimitiveFunction.ToByte.OfLong f;
			if(mapper instanceof PrimitiveFunction.ToByte.OfLong) f = (PrimitiveFunction.ToByte.OfLong) mapper;
			else f = x -> mapper.applyByte(x);
			return new PrimitiveIterator.OfByte() {
				@Override public boolean hasNext() { return PrimitiveIterator.OfLong.this.hasNext(); }
				@Override public byte nextByte() { return f.applyByte(PrimitiveIterator.OfLong.this.nextLong());}
			};
		}
		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextLong()} will
		 * be used as the argument to the given mapper.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code boolean} values
		 * are returned through a new {@link PrimitiveIterator.OfBoolean} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToBoolean}
		*            and accept elements of type {@code Long}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code boolean} value.
		*               Must not be {@code null}.
		* @param rm can be {@code null}
		* @return a new {@link PrimitiveIterator.OfBoolean} instance that provides the mapped {@code boolean} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToBoolean.OfLong}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper. The {@code rm} parameter is ignored in the default implementation
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToBoolean
		* @see PrimitiveFunction.ToBoolean.OfLong
		 */
		@Override
		default <M extends PrimitiveFunction.ToBoolean<? super java.lang.Long>, RM extends PrimitiveFunction<? extends java.lang.Long, ? super java.lang.Boolean>> PrimitiveIterator.OfBoolean mapToBoolean(M mapper, RM rm) {
			PrimitiveFunction.ToBoolean.OfLong f;
			if(mapper instanceof PrimitiveFunction.ToBoolean.OfLong) f = (PrimitiveFunction.ToBoolean.OfLong) mapper;
			else f = x -> mapper.applyBoolean(x);
			return new PrimitiveIterator.OfBoolean() {
				@Override public boolean hasNext() { return PrimitiveIterator.OfLong.this.hasNext(); }
				@Override public boolean nextBoolean() { return f.applyBoolean(PrimitiveIterator.OfLong.this.nextLong());}
			};
		}

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
		default void forEachRemaining(PrimitiveConsumer.OfLong action) {
			Objects.requireNonNull(action);
			while(hasNext()) action.acceptLong(nextLong());
		}
	}

	/**
	 * An Iterator specialized for {@code int} values.
	 * <p>
	 * Defines an interface for iterator specialized for {@code int} values. It
	 * extends the {@link jdk.prim.util.PrimitiveIterator.OfInt} interface and provides
	 * additional methods specific to {@code int} values iteration.
	 * 
	 * @implNote The use of {@link #nextInt()} is preferred over the use of
	 *           {@link #next()} because {@link #next()} is implemented by calling
	 *           and casting {@link #nextInt()}.
	 * @implNote Default implementation does not support modification such as
	 *           {@link #remove()}
	 */
	interface OfInt extends PrimitiveIterator<Integer, IntConsumer>, java.util.PrimitiveIterator.OfInt {

		/**
		 * Creates and returns a boxed an iterator of {@link java.lang.Integer Double} objects where each element is a boxed {@code int} value.
		 * 
		 * @return an iterator of boxed {@code Integer}
		 */
		@Override
		default java.util.PrimitiveIterator<Integer, IntConsumer> boxed() { return this; }

		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextInt()} will
		 * be used as the argument to the given mapper whenever {@link PrimitiveIterator.OfDouble#nextDouble()} is called.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code double} values
		 * are returned through a new {@link PrimitiveIterator.OfDouble} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToDouble}
		*            and accept elements of type {@code Integer}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code double} value.
		*               Must not be {@code null}.
		* @param rm can be {@code null}
		* @return a new {@link PrimitiveIterator.OfDouble} instance that provides the mapped {@code double} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToDouble.OfInt}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper. The {@code rm} parameter is ignored in the default implementation
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToDouble
		* @see PrimitiveFunction.ToDouble.OfInt
		 */
		@Override
		default <M extends PrimitiveFunction.ToDouble<? super java.lang.Integer>, RM extends PrimitiveFunction<? extends java.lang.Integer, ? super java.lang.Double>> PrimitiveIterator.OfDouble mapToDouble(M mapper, RM rm) {
			PrimitiveFunction.ToDouble.OfInt f;
			if(mapper instanceof PrimitiveFunction.ToDouble.OfInt) f = (PrimitiveFunction.ToDouble.OfInt) mapper;
			else f = x -> mapper.applyDouble(x);
			return new PrimitiveIterator.OfDouble() {
				@Override public boolean hasNext() { return PrimitiveIterator.OfInt.this.hasNext(); }
				@Override public double nextDouble() { return f.applyDouble(PrimitiveIterator.OfInt.this.nextInt());}
			};
		}
		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextInt()} will
		 * be used as the argument to the given mapper whenever {@link PrimitiveIterator.OfLong#nextLong()} is called.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code long} values
		 * are returned through a new {@link PrimitiveIterator.OfLong} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToLong}
		*            and accept elements of type {@code Integer}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code long} value.
		*               Must not be {@code null}.
		* @param rm can be {@code null}
		* @return a new {@link PrimitiveIterator.OfLong} instance that provides the mapped {@code long} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToLong.OfInt}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper. The {@code rm} parameter is ignored in the default implementation
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToLong
		* @see PrimitiveFunction.ToLong.OfInt
		 */
		@Override
		default <M extends PrimitiveFunction.ToLong<? super java.lang.Integer>, RM extends PrimitiveFunction<? extends java.lang.Integer, ? super java.lang.Long>> PrimitiveIterator.OfLong mapToLong(M mapper, RM rm) {
			PrimitiveFunction.ToLong.OfInt f;
			if(mapper instanceof PrimitiveFunction.ToLong.OfInt) f = (PrimitiveFunction.ToLong.OfInt) mapper;
			else f = x -> mapper.applyLong(x);
			return new PrimitiveIterator.OfLong() {
				@Override public boolean hasNext() { return  PrimitiveIterator.OfInt.this.hasNext(); }
				@Override public long nextLong() { return f.applyLong( PrimitiveIterator.OfInt.this.nextInt());}
			};
		}
		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextInt()} will
		 * be used as the argument to the given mapper whenever {@link PrimitiveIterator.OfInt#nextInt()} is called.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code int} values
		 * are returned through a new {@link PrimitiveIterator.OfInt} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToInt}
		*            and accept elements of type {@code Integer}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code int} value.
		*               Must not be {@code null}.
		* @param rm can be {@code null}
		* @return a new {@link PrimitiveIterator.OfInt} instance that provides the mapped {@code int} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToInt.OfInt}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper. The {@code rm} parameter is ignored in the default implementation
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToInt
		* @see PrimitiveFunction.ToInt.OfInt
		 */
		@Override
		default <M extends PrimitiveFunction.ToInt<? super java.lang.Integer>, RM extends PrimitiveFunction<? extends java.lang.Integer, ? super java.lang.Integer>> PrimitiveIterator.OfInt mapToInt(M mapper, RM rm) {
			PrimitiveFunction.ToInt.OfInt f;
			if(mapper instanceof PrimitiveFunction.ToInt.OfInt) f = (PrimitiveFunction.ToInt.OfInt) mapper;
			else f = x -> mapper.applyInt(x);
			PrimitiveIterator.OfInt thisIt = this;
			return new PrimitiveIterator.OfInt() {
				@Override public boolean hasNext() { return thisIt.hasNext(); }
				@Override public int nextInt() { return f.applyInt(thisIt.nextInt());}
			};
		}
		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextInt()} will
		 * be used as the argument to the given mapper whenever {@link PrimitiveIterator.OfFloat#nextFloat()} is called.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code float} values
		 * are returned through a new {@link PrimitiveIterator.OfFloat} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToFloat}
		*            and accept elements of type {@code Integer}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code float} value.
		*               Must not be {@code null}.
		* @param rm can be {@code null}
		* @return a new {@link PrimitiveIterator.OfFloat} instance that provides the mapped {@code float} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToFloat.OfInt}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper. The {@code rm} parameter is ignored in the default implementation
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToFloat
		* @see PrimitiveFunction.ToFloat.OfInt
		 */
		@Override
		default <M extends PrimitiveFunction.ToFloat<? super java.lang.Integer>, RM extends PrimitiveFunction<? extends java.lang.Integer, ? super java.lang.Float>> PrimitiveIterator.OfFloat mapToFloat(M mapper, RM rm) {
			PrimitiveFunction.ToFloat.OfInt f;
			if(mapper instanceof PrimitiveFunction.ToFloat.OfInt) f = (PrimitiveFunction.ToFloat.OfInt) mapper;
			else f = x -> mapper.applyFloat(x);
			return new PrimitiveIterator.OfFloat() {
				@Override public boolean hasNext() { return PrimitiveIterator.OfInt.this.hasNext(); }
				@Override public float nextFloat() { return f.applyFloat(PrimitiveIterator.OfInt.this.nextInt());}
			};
		}
		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextInt()} will
		 * be used as the argument to the given mapper whenever {@link PrimitiveIterator.OfChar#nextChar()} is called.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code char} values
		 * are returned through a new {@link PrimitiveIterator.OfChar} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToChar}
		*            and accept elements of type {@code Integer}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code char} value.
		*               Must not be {@code null}.
		* @param rm can be {@code null}
		* @return a new {@link PrimitiveIterator.OfChar} instance that provides the mapped {@code char} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToChar.OfInt}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper. The {@code rm} parameter is ignored in the default implementation
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToChar
		* @see PrimitiveFunction.ToChar.OfInt
		 */
		@Override
		default <M extends PrimitiveFunction.ToChar<? super java.lang.Integer>, RM extends PrimitiveFunction<? extends java.lang.Integer, ? super java.lang.Character>> PrimitiveIterator.OfChar mapToChar(M mapper, RM rm) {
			PrimitiveFunction.ToChar.OfInt f;
			if(mapper instanceof PrimitiveFunction.ToChar.OfInt) f = (PrimitiveFunction.ToChar.OfInt) mapper;
			else f = x -> mapper.applyChar(x);
			return new PrimitiveIterator.OfChar() {
				@Override public boolean hasNext() { return PrimitiveIterator.OfInt.this.hasNext(); }
				@Override public char nextChar() { return f.applyChar(PrimitiveIterator.OfInt.this.nextInt());}
			};
		}
		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextInt()} will
		 * be used as the argument to the given mapper whenever {@link PrimitiveIterator.OfShort#nextShort()} is called.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code short} values
		 * are returned through a new {@link PrimitiveIterator.OfShort} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToShort}
		*            and accept elements of type {@code Integer}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code short} value.
		*               Must not be {@code null}.
		* @param rm can be {@code null}
		* @return a new {@link PrimitiveIterator.OfShort} instance that provides the mapped {@code short} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToShort.OfInt}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper. The {@code rm} parameter is ignored in the default implementation
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToShort
		* @see PrimitiveFunction.ToShort.OfInt
		 */
		@Override
		default <M extends PrimitiveFunction.ToShort<? super java.lang.Integer>, RM extends PrimitiveFunction<? extends java.lang.Integer, ? super java.lang.Short>> PrimitiveIterator.OfShort mapToShort(M mapper, RM rm) {
			PrimitiveFunction.ToShort.OfInt f;
			if(mapper instanceof PrimitiveFunction.ToShort.OfInt) f = (PrimitiveFunction.ToShort.OfInt) mapper;
			else f = x -> mapper.applyShort(x);
			return new PrimitiveIterator.OfShort() {
				@Override public boolean hasNext() { return PrimitiveIterator.OfInt.this.hasNext(); }
				@Override public short nextShort() { return f.applyShort(PrimitiveIterator.OfInt.this.nextInt());}
			};
		}
		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextInt()} will
		 * be used as the argument to the given mapper whenever {@link PrimitiveIterator.OfByte#nextByte()} is called.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code byte} values
		 * are returned through a new {@link PrimitiveIterator.OfByte} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToByte}
		*            and accept elements of type {@code Integer}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code byte} value.
		*               Must not be {@code null}.
		* @param rm can be {@code null}
		* @return a new {@link PrimitiveIterator.OfByte} instance that provides the mapped {@code byte} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToByte.OfInt}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper. The {@code rm} parameter is ignored in the default implementation
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToByte
		* @see PrimitiveFunction.ToByte.OfInt
		 */
		@Override
		default <M extends PrimitiveFunction.ToByte<? super java.lang.Integer>, RM extends PrimitiveFunction<? extends java.lang.Integer, ? super java.lang.Byte>> PrimitiveIterator.OfByte mapToByte(M mapper, RM rm) {
			PrimitiveFunction.ToByte.OfInt f;
			if(mapper instanceof PrimitiveFunction.ToByte.OfInt) f = (PrimitiveFunction.ToByte.OfInt) mapper;
			else f = x -> mapper.applyByte(x);
			return new PrimitiveIterator.OfByte() {
				@Override public boolean hasNext() { return PrimitiveIterator.OfInt.this.hasNext(); }
				@Override public byte nextByte() { return f.applyByte(PrimitiveIterator.OfInt.this.nextInt());}
			};
		}
		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextInt()} will
		 * be used as the argument to the given mapper whenever {@link PrimitiveIterator.OfBoolean#nextBoolean()} is called.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code boolean} values
		 * are returned through a new {@link PrimitiveIterator.OfBoolean} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToBoolean}
		*            and accept elements of type {@code Integer}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code boolean} value.
		*               Must not be {@code null}.
		* @param rm can be {@code null}
		* @return a new {@link PrimitiveIterator.OfBoolean} instance that provides the mapped {@code boolean} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToBoolean.OfInt}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper. The {@code rm} parameter is ignored in the default implementation
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToBoolean
		* @see PrimitiveFunction.ToBoolean.OfInt
		 */
		@Override
		default <M extends PrimitiveFunction.ToBoolean<? super java.lang.Integer>, RM extends PrimitiveFunction<? extends java.lang.Integer, ? super java.lang.Boolean>> PrimitiveIterator.OfBoolean mapToBoolean(M mapper, RM rm) {
			PrimitiveFunction.ToBoolean.OfInt f;
			if(mapper instanceof PrimitiveFunction.ToBoolean.OfInt) f = (PrimitiveFunction.ToBoolean.OfInt) mapper;
			else f = x -> mapper.applyBoolean(x);
			return new PrimitiveIterator.OfBoolean() {
				@Override public boolean hasNext() { return PrimitiveIterator.OfInt.this.hasNext(); }
				@Override public boolean nextBoolean() { return f.applyBoolean(PrimitiveIterator.OfInt.this.nextInt());}
			};
		}

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
		default void forEachRemaining(PrimitiveConsumer.OfInt action) {
			Objects.requireNonNull(action);
			while(hasNext()) action.acceptInt(nextInt());
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
	interface OfFloat extends PrimitiveIterator<Float, PrimitiveConsumer.OfFloat> {
		

		/**
		 * Creates and returns a boxed an iterator of {@link java.lang.Float Double} objects where each element is a boxed {@code float} value.
		 * 
		 * @return an iterator of boxed {@code Float}
		 */
		@Override
		default java.util.PrimitiveIterator<Float, PrimitiveConsumer.OfFloat> boxed() { return this; }

		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextFloat()} will
		 * be used as the argument to the given mapper whenever {@link PrimitiveIterator.OfDouble#nextDouble()} is called.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code double} values
		 * are returned through a new {@link PrimitiveIterator.OfDouble} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToDouble}
		*            and accept elements of type {@code Float}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code double} value.
		*               Must not be {@code null}.
		* @param rm can be {@code null}
		* @return a new {@link PrimitiveIterator.OfDouble} instance that provides the mapped {@code double} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToDouble.OfFloat}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper. The parameter {@code rm} is ignored in the default implementation
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToDouble
		* @see PrimitiveFunction.ToDouble.OfFloat
		 */
		@Override
		default <M extends PrimitiveFunction.ToDouble<? super java.lang.Float>, RM extends PrimitiveFunction<? extends java.lang.Float, ? super java.lang.Double>> PrimitiveIterator.OfDouble mapToDouble(M mapper, RM rm) {
			PrimitiveFunction.ToDouble.OfFloat f;
			if(mapper instanceof PrimitiveFunction.ToDouble.OfFloat) f = (PrimitiveFunction.ToDouble.OfFloat) mapper;
			else f = x -> mapper.applyDouble(x);
			return new PrimitiveIterator.OfDouble() {
				@Override public boolean hasNext() { return PrimitiveIterator.OfFloat.this.hasNext(); }
				@Override public double nextDouble() { return f.applyDouble(PrimitiveIterator.OfFloat.this.nextFloat()); }
			};
		}
		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextFloat()} will
		 * be used as the argument to the given mapper whenever {@link PrimitiveIterator.OfLong#nextLong()} is called.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code long} values
		 * are returned through a new {@link PrimitiveIterator.OfLong} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToLong}
		*            and accept elements of type {@code Float}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code long} value.
		*               Must not be {@code null}.
		* @param rm can be {@code null}
		* @return a new {@link PrimitiveIterator.OfLong} instance that provides the mapped {@code long} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToLong.OfFloat}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper. The parameter {@code rm} is ignored in the default implementation
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToLong
		* @see PrimitiveFunction.ToLong.OfFloat
		 */
		@Override
		default <M extends PrimitiveFunction.ToLong<? super java.lang.Float>, RM extends PrimitiveFunction<? extends java.lang.Float, ? super java.lang.Long>> PrimitiveIterator.OfLong mapToLong(M mapper, RM rm) {
			PrimitiveFunction.ToLong.OfFloat f;
			if(mapper instanceof PrimitiveFunction.ToLong.OfFloat) f = (PrimitiveFunction.ToLong.OfFloat) mapper;
			else f = x -> mapper.applyLong(x);
			return new PrimitiveIterator.OfLong() {
				@Override public boolean hasNext() { return  PrimitiveIterator.OfFloat.this.hasNext(); }
				@Override public long nextLong() { return f.applyLong( PrimitiveIterator.OfFloat.this.nextFloat()); }
			};
		}
		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextFloat()} will
		 * be used as the argument to the given mapper whenever {@link PrimitiveIterator.OfInt#nextInt()} is called.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code int} values
		 * are returned through a new {@link PrimitiveIterator.OfInt} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToInt}
		*            and accept elements of type {@code Float}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code int} value.
		*               Must not be {@code null}.
		* @param rm can be {@code null}
		* @return a new {@link PrimitiveIterator.OfInt} instance that provides the mapped {@code int} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToInt.OfFloat}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper. The parameter {@code rm} is ignored in the default implementation
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToInt
		* @see PrimitiveFunction.ToInt.OfFloat
		 */
		@Override
		default <M extends PrimitiveFunction.ToInt<? super java.lang.Float>, RM extends PrimitiveFunction<? extends java.lang.Float, ? super java.lang.Integer>> PrimitiveIterator.OfInt mapToInt(M mapper, RM rm) {
			PrimitiveFunction.ToInt.OfFloat f;
			if(mapper instanceof PrimitiveFunction.ToInt.OfFloat) f = (PrimitiveFunction.ToInt.OfFloat) mapper;
			else f = x -> mapper.applyInt(x);
			return new PrimitiveIterator.OfInt() {
				@Override public boolean hasNext() { return PrimitiveIterator.OfFloat.this.hasNext(); }
				@Override public int nextInt() { return f.applyInt(PrimitiveIterator.OfFloat.this.nextFloat()); }
			};
		}
		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextFloat()} will
		 * be used as the argument to the given mapper whenever {@link PrimitiveIterator.OfFloat#nextFloat()} is called.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code float} values
		 * are returned through a new {@link PrimitiveIterator.OfFloat} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToFloat}
		*            and accept elements of type {@code Float}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code float} value.
		*               Must not be {@code null}.
		* @param rm can be {@code null}
		* @return a new {@link PrimitiveIterator.OfFloat} instance that provides the mapped {@code float} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToFloat.OfFloat}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper. The parameter {@code rm} is ignored in the default implementation
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToFloat
		* @see PrimitiveFunction.ToFloat.OfFloat
		 */
		@Override
		default <M extends PrimitiveFunction.ToFloat<? super java.lang.Float>, RM extends PrimitiveFunction<? extends java.lang.Float, ? super java.lang.Float>> PrimitiveIterator.OfFloat mapToFloat(M mapper, RM rm) {
			PrimitiveFunction.ToFloat.OfFloat f;
			if(mapper instanceof PrimitiveFunction.ToFloat.OfFloat) f = (PrimitiveFunction.ToFloat.OfFloat) mapper;
			else f = x -> mapper.applyFloat(x);
			PrimitiveIterator.OfFloat thisIt = this;
			return new PrimitiveIterator.OfFloat() {
				@Override public boolean hasNext() { return thisIt.hasNext(); }
				@Override public float nextFloat() { return f.applyFloat(thisIt.nextFloat()); }
			};
		}
		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextFloat()} will
		 * be used as the argument to the given mapper whenever {@link PrimitiveIterator.OfChar#nextChar()} is called.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code char} values
		 * are returned through a new {@link PrimitiveIterator.OfChar} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToChar}
		*            and accept elements of type {@code Float}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code char} value.
		*               Must not be {@code null}.
		* @param rm can be {@code null}
		* @return a new {@link PrimitiveIterator.OfChar} instance that provides the mapped {@code char} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToChar.OfFloat}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper. The parameter {@code rm} is ignored in the default implementation
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToChar
		* @see PrimitiveFunction.ToChar.OfFloat
		 */
		@Override
		default <M extends PrimitiveFunction.ToChar<? super java.lang.Float>, RM extends PrimitiveFunction<? extends java.lang.Float, ? super java.lang.Character>> PrimitiveIterator.OfChar mapToChar(M mapper, RM rm) {
			PrimitiveFunction.ToChar.OfFloat f;
			if(mapper instanceof PrimitiveFunction.ToChar.OfFloat) f = (PrimitiveFunction.ToChar.OfFloat) mapper;
			else f = x -> mapper.applyChar(x);
			return new PrimitiveIterator.OfChar() {
				@Override public boolean hasNext() { return PrimitiveIterator.OfFloat.this.hasNext(); }
				@Override public char nextChar() { return f.applyChar(PrimitiveIterator.OfFloat.this.nextFloat()); }
			};
		}
		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextFloat()} will
		 * be used as the argument to the given mapper whenever {@link PrimitiveIterator.OfShort#nextShort()} is called.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code short} values
		 * are returned through a new {@link PrimitiveIterator.OfShort} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToShort}
		*            and accept elements of type {@code Float}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code short} value.
		*               Must not be {@code null}.
		* @param rm can be {@code null}
		* @return a new {@link PrimitiveIterator.OfShort} instance that provides the mapped {@code short} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToShort.OfFloat}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper. The parameter {@code rm} is ignored in the default implementation
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToShort
		* @see PrimitiveFunction.ToShort.OfFloat
		 */
		@Override
		default <M extends PrimitiveFunction.ToShort<? super java.lang.Float>, RM extends PrimitiveFunction<? extends java.lang.Float, ? super java.lang.Short>> PrimitiveIterator.OfShort mapToShort(M mapper, RM rm) {
			PrimitiveFunction.ToShort.OfFloat f;
			if(mapper instanceof PrimitiveFunction.ToShort.OfFloat) f = (PrimitiveFunction.ToShort.OfFloat) mapper;
			else f = x -> mapper.applyShort(x);
			return new PrimitiveIterator.OfShort() {
				@Override public boolean hasNext() { return PrimitiveIterator.OfFloat.this.hasNext(); }
				@Override public short nextShort() { return f.applyShort(PrimitiveIterator.OfFloat.this.nextFloat()); }
			};
		}
		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextFloat()} will
		 * be used as the argument to the given mapper whenever {@link PrimitiveIterator.OfByte#nextByte()} is called.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code byte} values
		 * are returned through a new {@link PrimitiveIterator.OfByte} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToByte}
		*            and accept elements of type {@code Float}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code byte} value.
		*               Must not be {@code null}.
		* @param rm can be {@code null}
		* @return a new {@link PrimitiveIterator.OfByte} instance that provides the mapped {@code byte} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToByte.OfFloat}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper. The parameter {@code rm} is ignored in the default implementation
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToByte
		* @see PrimitiveFunction.ToByte.OfFloat
		 */
		@Override
		default <M extends PrimitiveFunction.ToByte<? super java.lang.Float>, RM extends PrimitiveFunction<? extends java.lang.Float, ? super java.lang.Byte>> PrimitiveIterator.OfByte mapToByte(M mapper, RM rm) {
			PrimitiveFunction.ToByte.OfFloat f;
			if(mapper instanceof PrimitiveFunction.ToByte.OfFloat) f = (PrimitiveFunction.ToByte.OfFloat) mapper;
			else f = x -> mapper.applyByte(x);
			return new PrimitiveIterator.OfByte() {
				@Override public boolean hasNext() { return PrimitiveIterator.OfFloat.this.hasNext(); }
				@Override public byte nextByte() { return f.applyByte(PrimitiveIterator.OfFloat.this.nextFloat()); }
			};
		}
		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextFloat()} will
		 * be used as the argument to the given mapper whenever {@link PrimitiveIterator.OfBoolean#nextBoolean()} is called.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code boolean} values
		 * are returned through a new {@link PrimitiveIterator.OfBoolean} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToBoolean}
		*            and accept elements of type {@code Float}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code boolean} value.
		*               Must not be {@code null}.
		* @param rm can be {@code null}
		* @return a new {@link PrimitiveIterator.OfBoolean} instance that provides the mapped {@code boolean} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToBoolean.OfFloat}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper. The parameter {@code rm} is ignored in the default implementation
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToBoolean
		* @see PrimitiveFunction.ToBoolean.OfFloat
		 */
		@Override
		default <M extends PrimitiveFunction.ToBoolean<? super java.lang.Float>, RM extends PrimitiveFunction<? extends java.lang.Float, ? super java.lang.Boolean>> PrimitiveIterator.OfBoolean mapToBoolean(M mapper, RM rm) {
			PrimitiveFunction.ToBoolean.OfFloat f;
			if(mapper instanceof PrimitiveFunction.ToBoolean.OfFloat) f = (PrimitiveFunction.ToBoolean.OfFloat) mapper;
			else f = x -> mapper.applyBoolean(x);
			return new PrimitiveIterator.OfBoolean() {
				@Override public boolean hasNext() { return PrimitiveIterator.OfFloat.this.hasNext(); }
				@Override public boolean nextBoolean() { return f.applyBoolean(PrimitiveIterator.OfFloat.this.nextFloat()); }
			};
		}

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 */
		@Override
		default jdk.prim.util.PrimitiveIterator.OfDouble toDouble() {
			return new jdk.prim.util.PrimitiveIterator.OfDouble() {

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
	interface OfChar extends PrimitiveIterator<Character, PrimitiveConsumer.OfChar> {

		/**
		 * Creates and returns a boxed an iterator of {@link java.lang.Character Double} objects where each element is a boxed {@code char} value.
		 * 
		 * @return an iterator of boxed {@code Character}
		 */
		@Override
		default java.util.PrimitiveIterator<Character, PrimitiveConsumer.OfChar> boxed() { return this; }

		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextChar()} will
		 * be used as the argument to the given mapper whenever {@link PrimitiveIterator.OfDouble#nextDouble()} is called.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code double} values
		 * are returned through a new {@link PrimitiveIterator.OfDouble} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToDouble}
		*            and accept elements of type {@code Character}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code double} value.
		*               Must not be {@code null}.
		* @return a new {@link PrimitiveIterator.OfDouble} instance that provides the mapped {@code double} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToDouble.OfChar}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper. The parameter {@code rm} is ignored in the default implementation
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToDouble
		* @see PrimitiveFunction.ToDouble.OfChar
		 */
		@Override
		default <M extends PrimitiveFunction.ToDouble<? super java.lang.Character>, RM extends PrimitiveFunction<? extends java.lang.Character, ? super java.lang.Double>> PrimitiveIterator.OfDouble mapToDouble(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			PrimitiveFunction.ToDouble.OfChar f;
			if(mapper instanceof PrimitiveFunction.ToDouble.OfChar) f = (PrimitiveFunction.ToDouble.OfChar) mapper;
			else f = x -> mapper.applyDouble(x);
			return new PrimitiveIterator.OfDouble() {
				@Override public boolean hasNext() { return PrimitiveIterator.OfChar.this.hasNext(); }
				@Override public double nextDouble() { return f.applyDouble(PrimitiveIterator.OfChar.this.nextChar());}
			};
		}
		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextChar()} will
		 * be used as the argument to the given mapper whenever {@link PrimitiveIterator.OfLong#nextLong()} is called.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code long} values
		 * are returned through a new {@link PrimitiveIterator.OfLong} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToLong}
		*            and accept elements of type {@code Character}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code long} value.
		*               Must not be {@code null}.
		* @return a new {@link PrimitiveIterator.OfLong} instance that provides the mapped {@code long} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToLong.OfChar}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper. The parameter {@code rm} is ignored in the default implementation
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToLong
		* @see PrimitiveFunction.ToLong.OfChar
		 */
		@Override
		default <M extends PrimitiveFunction.ToLong<? super java.lang.Character>, RM extends PrimitiveFunction<? extends java.lang.Character, ? super java.lang.Long>> PrimitiveIterator.OfLong mapToLong(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			PrimitiveFunction.ToLong.OfChar f;
			if(mapper instanceof PrimitiveFunction.ToLong.OfChar) f = (PrimitiveFunction.ToLong.OfChar) mapper;
			else f = x -> mapper.applyLong(x);
			return new PrimitiveIterator.OfLong() {
				@Override public boolean hasNext() { return  PrimitiveIterator.OfChar.this.hasNext(); }
				@Override public long nextLong() { return f.applyLong( PrimitiveIterator.OfChar.this.nextChar());}
			};
		}
		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextChar()} will
		 * be used as the argument to the given mapper whenever {@link PrimitiveIterator.OfInt#nextInt()} is called.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code int} values
		 * are returned through a new {@link PrimitiveIterator.OfInt} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToInt}
		*            and accept elements of type {@code Character}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code int} value.
		*               Must not be {@code null}.
		* @return a new {@link PrimitiveIterator.OfInt} instance that provides the mapped {@code int} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToInt.OfChar}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper. The parameter {@code rm} is ignored in the default implementation
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToInt
		* @see PrimitiveFunction.ToInt.OfChar
		 */
		@Override
		default <M extends PrimitiveFunction.ToInt<? super java.lang.Character>, RM extends PrimitiveFunction<? extends java.lang.Character, ? super java.lang.Integer>> PrimitiveIterator.OfInt mapToInt(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			PrimitiveFunction.ToInt.OfChar f;
			if(mapper instanceof PrimitiveFunction.ToInt.OfChar) f = (PrimitiveFunction.ToInt.OfChar) mapper;
			else f = x -> mapper.applyInt(x);
			return new PrimitiveIterator.OfInt() {
				@Override public boolean hasNext() { return PrimitiveIterator.OfChar.this.hasNext(); }
				@Override public int nextInt() { return f.applyInt(PrimitiveIterator.OfChar.this.nextChar());}
			};
		}
		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextChar()} will
		 * be used as the argument to the given mapper whenever {@link PrimitiveIterator.OfFloat#nextFloat()} is called.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code float} values
		 * are returned through a new {@link PrimitiveIterator.OfFloat} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToFloat}
		*            and accept elements of type {@code Character}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code float} value.
		*               Must not be {@code null}.
		* @return a new {@link PrimitiveIterator.OfFloat} instance that provides the mapped {@code float} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToFloat.OfChar}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper. The parameter {@code rm} is ignored in the default implementation
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToFloat
		* @see PrimitiveFunction.ToFloat.OfChar
		 */
		@Override
		default <M extends PrimitiveFunction.ToFloat<? super java.lang.Character>, RM extends PrimitiveFunction<? extends java.lang.Character, ? super java.lang.Float>> PrimitiveIterator.OfFloat mapToFloat(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			PrimitiveFunction.ToFloat.OfChar f;
			if(mapper instanceof PrimitiveFunction.ToFloat.OfChar) f = (PrimitiveFunction.ToFloat.OfChar) mapper;
			else f = x -> mapper.applyFloat(x);
			return new PrimitiveIterator.OfFloat() {
				@Override public boolean hasNext() { return PrimitiveIterator.OfChar.this.hasNext(); }
				@Override public float nextFloat() { return f.applyFloat(PrimitiveIterator.OfChar.this.nextChar());}
			};
		}
		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextChar()} will
		 * be used as the argument to the given mapper whenever {@link PrimitiveIterator.OfChar#nextChar()} is called.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code char} values
		 * are returned through a new {@link PrimitiveIterator.OfChar} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToChar}
		*            and accept elements of type {@code Character}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code char} value.
		*               Must not be {@code null}.
		* @return a new {@link PrimitiveIterator.OfChar} instance that provides the mapped {@code char} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToChar.OfChar}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper. The parameter {@code rm} is ignored in the default implementation
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToChar
		* @see PrimitiveFunction.ToChar.OfChar
		 */
		@Override
		default <M extends PrimitiveFunction.ToChar<? super java.lang.Character>, RM extends PrimitiveFunction<? extends java.lang.Character, ? super java.lang.Character>> PrimitiveIterator.OfChar mapToChar(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			PrimitiveFunction.ToChar.OfChar f;
			if(mapper instanceof PrimitiveFunction.ToChar.OfChar) f = (PrimitiveFunction.ToChar.OfChar) mapper;
			else f = x -> mapper.applyChar(x);
			PrimitiveIterator.OfChar thisIt = this;
			return new PrimitiveIterator.OfChar() {
				@Override public boolean hasNext() { return thisIt.hasNext(); }
				@Override public char nextChar() { return f.applyChar(thisIt.nextChar());}
			};
		}
		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextChar()} will
		 * be used as the argument to the given mapper whenever {@link PrimitiveIterator.OfShort#nextShort()} is called.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code short} values
		 * are returned through a new {@link PrimitiveIterator.OfShort} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToShort}
		*            and accept elements of type {@code Character}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code short} value.
		*               Must not be {@code null}.
		* @return a new {@link PrimitiveIterator.OfShort} instance that provides the mapped {@code short} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToShort.OfChar}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper. The parameter {@code rm} is ignored in the default implementation
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToShort
		* @see PrimitiveFunction.ToShort.OfChar
		 */
		@Override
		default <M extends PrimitiveFunction.ToShort<? super java.lang.Character>, RM extends PrimitiveFunction<? extends java.lang.Character, ? super java.lang.Short>> PrimitiveIterator.OfShort mapToShort(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			PrimitiveFunction.ToShort.OfChar f;
			if(mapper instanceof PrimitiveFunction.ToShort.OfChar) f = (PrimitiveFunction.ToShort.OfChar) mapper;
			else f = x -> mapper.applyShort(x);
			return new PrimitiveIterator.OfShort() {
				@Override public boolean hasNext() { return PrimitiveIterator.OfChar.this.hasNext(); }
				@Override public short nextShort() { return f.applyShort(PrimitiveIterator.OfChar.this.nextChar());}
			};
		}
		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextChar()} will
		 * be used as the argument to the given mapper whenever {@link PrimitiveIterator.OfByte#nextByte()} is called.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code byte} values
		 * are returned through a new {@link PrimitiveIterator.OfByte} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToByte}
		*            and accept elements of type {@code Character}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code byte} value.
		*               Must not be {@code null}.
		* @return a new {@link PrimitiveIterator.OfByte} instance that provides the mapped {@code byte} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToByte.OfChar}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper. The parameter {@code rm} is ignored in the default implementation
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToByte
		* @see PrimitiveFunction.ToByte.OfChar
		 */
		@Override
		default <M extends PrimitiveFunction.ToByte<? super java.lang.Character>, RM extends PrimitiveFunction<? extends java.lang.Character, ? super java.lang.Byte>> PrimitiveIterator.OfByte mapToByte(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			PrimitiveFunction.ToByte.OfChar f;
			if(mapper instanceof PrimitiveFunction.ToByte.OfChar) f = (PrimitiveFunction.ToByte.OfChar) mapper;
			else f = x -> mapper.applyByte(x);
			return new PrimitiveIterator.OfByte() {
				@Override public boolean hasNext() { return PrimitiveIterator.OfChar.this.hasNext(); }
				@Override public byte nextByte() { return f.applyByte(PrimitiveIterator.OfChar.this.nextChar());}
			};
		}
		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextChar()} will
		 * be used as the argument to the given mapper whenever {@link PrimitiveIterator.OfBoolean#nextBoolean()} is called.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code boolean} values
		 * are returned through a new {@link PrimitiveIterator.OfBoolean} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToBoolean}
		*            and accept elements of type {@code Character}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code boolean} value.
		*               Must not be {@code null}.
		* @return a new {@link PrimitiveIterator.OfBoolean} instance that provides the mapped {@code boolean} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToBoolean.OfChar}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper. The parameter {@code rm} is ignored in the default implementation
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToBoolean
		* @see PrimitiveFunction.ToBoolean.OfChar
		 */
		@Override
		default <M extends PrimitiveFunction.ToBoolean<? super java.lang.Character>, RM extends PrimitiveFunction<? extends java.lang.Character, ? super java.lang.Boolean>> PrimitiveIterator.OfBoolean mapToBoolean(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			PrimitiveFunction.ToBoolean.OfChar f;
			if(mapper instanceof PrimitiveFunction.ToBoolean.OfChar) f = (PrimitiveFunction.ToBoolean.OfChar) mapper;
			else f = x -> mapper.applyBoolean(x);
			return new PrimitiveIterator.OfBoolean() {
				@Override public boolean hasNext() { return PrimitiveIterator.OfChar.this.hasNext(); }
				@Override public boolean nextBoolean() { return f.applyBoolean(PrimitiveIterator.OfChar.this.nextChar());}
			};
		}

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
	interface OfShort extends PrimitiveIterator<Short, PrimitiveConsumer.OfShort> {

		/**
		 * Creates and returns a boxed an iterator of {@link java.lang.Short Double} objects where each element is a boxed {@code short} value.
		 * 
		 * @return an iterator of boxed {@code Short}
		 */
		@Override
		default java.util.PrimitiveIterator<Short, PrimitiveConsumer.OfShort> boxed() { return this; }

		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextShort()} will
		 * be used as the argument to the given mapper whenever {@link PrimitiveIterator.OfDouble#nextDouble()} is called.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code double} values
		 * are returned through a new {@link PrimitiveIterator.OfDouble} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToDouble}
		*            and accept elements of type {@code Short}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code double} value.
		*               Must not be {@code null}.
		* @param rm can be {@code null}
		* @return a new {@link PrimitiveIterator.OfDouble} instance that provides the mapped {@code double} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToDouble.OfShort}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper. The parameter {@code rm} is ignored in the default implementation
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToDouble
		* @see PrimitiveFunction.ToDouble.OfShort
		 */
		@Override
		default <M extends PrimitiveFunction.ToDouble<? super java.lang.Short>, RM extends PrimitiveFunction<? extends java.lang.Short, ? super java.lang.Double>> PrimitiveIterator.OfDouble mapToDouble(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			PrimitiveFunction.ToDouble.OfShort f;
			if(mapper instanceof PrimitiveFunction.ToDouble.OfShort) f = (PrimitiveFunction.ToDouble.OfShort) mapper;
			else f = x -> mapper.applyDouble(x);
			return new PrimitiveIterator.OfDouble() {
				@Override public boolean hasNext() { return PrimitiveIterator.OfShort.this.hasNext(); }
				@Override public double nextDouble() { return f.applyDouble(PrimitiveIterator.OfShort.this.nextShort()); }
			};
		}
		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextShort()} will
		 * be used as the argument to the given mapper whenever {@link PrimitiveIterator.OfLong#nextLong()} is called.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code long} values
		 * are returned through a new {@link PrimitiveIterator.OfLong} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToLong}
		*            and accept elements of type {@code Short}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code long} value.
		*               Must not be {@code null}.
		* @param rm can be {@code null}
		* @return a new {@link PrimitiveIterator.OfLong} instance that provides the mapped {@code long} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToLong.OfShort}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper. The parameter {@code rm} is ignored in the default implementation
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToLong
		* @see PrimitiveFunction.ToLong.OfShort
		 */
		@Override
		default <M extends PrimitiveFunction.ToLong<? super java.lang.Short>, RM extends PrimitiveFunction<? extends java.lang.Short, ? super java.lang.Long>> PrimitiveIterator.OfLong mapToLong(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			PrimitiveFunction.ToLong.OfShort f;
			if(mapper instanceof PrimitiveFunction.ToLong.OfShort) f = (PrimitiveFunction.ToLong.OfShort) mapper;
			else f = x -> mapper.applyLong(x);
			return new PrimitiveIterator.OfLong() {
				@Override public boolean hasNext() { return  PrimitiveIterator.OfShort.this.hasNext(); }
				@Override public long nextLong() { return f.applyLong( PrimitiveIterator.OfShort.this.nextShort()); }
			};
		}
		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextShort()} will
		 * be used as the argument to the given mapper whenever {@link PrimitiveIterator.OfInt#nextInt()} is called.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code int} values
		 * are returned through a new {@link PrimitiveIterator.OfInt} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToInt}
		*            and accept elements of type {@code Short}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code int} value.
		*               Must not be {@code null}.
		* @param rm can be {@code null}
		* @return a new {@link PrimitiveIterator.OfInt} instance that provides the mapped {@code int} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToInt.OfShort}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper. The parameter {@code rm} is ignored in the default implementation
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToInt
		* @see PrimitiveFunction.ToInt.OfShort
		 */
		@Override
		default <M extends PrimitiveFunction.ToInt<? super java.lang.Short>, RM extends PrimitiveFunction<? extends java.lang.Short, ? super java.lang.Integer>> PrimitiveIterator.OfInt mapToInt(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			PrimitiveFunction.ToInt.OfShort f;
			if(mapper instanceof PrimitiveFunction.ToInt.OfShort) f = (PrimitiveFunction.ToInt.OfShort) mapper;
			else f = x -> mapper.applyInt(x);
			return new PrimitiveIterator.OfInt() {
				@Override public boolean hasNext() { return PrimitiveIterator.OfShort.this.hasNext(); }
				@Override public int nextInt() { return f.applyInt(PrimitiveIterator.OfShort.this.nextShort()); }
			};
		}
		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextShort()} will
		 * be used as the argument to the given mapper whenever {@link PrimitiveIterator.OfFloat#nextFloat()} is called.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code float} values
		 * are returned through a new {@link PrimitiveIterator.OfFloat} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToFloat}
		*            and accept elements of type {@code Short}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code float} value.
		*               Must not be {@code null}.
		* @param rm can be {@code null}
		* @return a new {@link PrimitiveIterator.OfFloat} instance that provides the mapped {@code float} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToFloat.OfShort}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper. The parameter {@code rm} is ignored in the default implementation
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToFloat
		* @see PrimitiveFunction.ToFloat.OfShort
		 */
		@Override
		default <M extends PrimitiveFunction.ToFloat<? super java.lang.Short>, RM extends PrimitiveFunction<? extends java.lang.Short, ? super java.lang.Float>> PrimitiveIterator.OfFloat mapToFloat(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			PrimitiveFunction.ToFloat.OfShort f;
			if(mapper instanceof PrimitiveFunction.ToFloat.OfShort) f = (PrimitiveFunction.ToFloat.OfShort) mapper;
			else f = x -> mapper.applyFloat(x);
			return new PrimitiveIterator.OfFloat() {
				@Override public boolean hasNext() { return PrimitiveIterator.OfShort.this.hasNext(); }
				@Override public float nextFloat() { return f.applyFloat(PrimitiveIterator.OfShort.this.nextShort()); }
			};
		}
		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextShort()} will
		 * be used as the argument to the given mapper whenever {@link PrimitiveIterator.OfChar#nextChar()} is called.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code char} values
		 * are returned through a new {@link PrimitiveIterator.OfChar} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToChar}
		*            and accept elements of type {@code Short}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code char} value.
		*               Must not be {@code null}.
		* @param rm can be {@code null}
		* @return a new {@link PrimitiveIterator.OfChar} instance that provides the mapped {@code char} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToChar.OfShort}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper. The parameter {@code rm} is ignored in the default implementation
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToChar
		* @see PrimitiveFunction.ToChar.OfShort
		 */
		@Override
		default <M extends PrimitiveFunction.ToChar<? super java.lang.Short>, RM extends PrimitiveFunction<? extends java.lang.Short, ? super java.lang.Character>> PrimitiveIterator.OfChar mapToChar(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			PrimitiveFunction.ToChar.OfShort f;
			if(mapper instanceof PrimitiveFunction.ToChar.OfShort) f = (PrimitiveFunction.ToChar.OfShort) mapper;
			else f = x -> mapper.applyChar(x);
			return new PrimitiveIterator.OfChar() {
				@Override public boolean hasNext() { return PrimitiveIterator.OfShort.this.hasNext(); }
				@Override public char nextChar() { return f.applyChar(PrimitiveIterator.OfShort.this.nextShort()); }
			};
		}
		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextShort()} will
		 * be used as the argument to the given mapper whenever {@link PrimitiveIterator.OfShort#nextShort()} is called.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code short} values
		 * are returned through a new {@link PrimitiveIterator.OfShort} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToShort}
		*            and accept elements of type {@code Short}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code short} value.
		*               Must not be {@code null}.
		* @param rm can be {@code null}
		* @return a new {@link PrimitiveIterator.OfShort} instance that provides the mapped {@code short} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToShort.OfShort}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper. The parameter {@code rm} is ignored in the default implementation
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToShort
		* @see PrimitiveFunction.ToShort.OfShort
		 */
		@Override
		default <M extends PrimitiveFunction.ToShort<? super java.lang.Short>, RM extends PrimitiveFunction<? extends java.lang.Short, ? super java.lang.Short>> PrimitiveIterator.OfShort mapToShort(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			PrimitiveFunction.ToShort.OfShort f;
			if(mapper instanceof PrimitiveFunction.ToShort.OfShort) f = (PrimitiveFunction.ToShort.OfShort) mapper;
			else f = x -> mapper.applyShort(x);
			PrimitiveIterator.OfShort thisIt = this;
			return new PrimitiveIterator.OfShort() {
				@Override public boolean hasNext() { return thisIt.hasNext(); }
				@Override public short nextShort() { return f.applyShort(thisIt.nextShort()); }
			};
		}
		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextShort()} will
		 * be used as the argument to the given mapper whenever {@link PrimitiveIterator.OfByte#nextByte()} is called.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code byte} values
		 * are returned through a new {@link PrimitiveIterator.OfByte} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToByte}
		*            and accept elements of type {@code Short}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code byte} value.
		*               Must not be {@code null}.
		* @param rm can be {@code null}
		* @return a new {@link PrimitiveIterator.OfByte} instance that provides the mapped {@code byte} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToByte.OfShort}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper. The parameter {@code rm} is ignored in the default implementation
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToByte
		* @see PrimitiveFunction.ToByte.OfShort
		 */
		@Override
		default <M extends PrimitiveFunction.ToByte<? super java.lang.Short>, RM extends PrimitiveFunction<? extends java.lang.Short, ? super java.lang.Byte>> PrimitiveIterator.OfByte mapToByte(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			PrimitiveFunction.ToByte.OfShort f;
			if(mapper instanceof PrimitiveFunction.ToByte.OfShort) f = (PrimitiveFunction.ToByte.OfShort) mapper;
			else f = x -> mapper.applyByte(x);
			return new PrimitiveIterator.OfByte() {
				@Override public boolean hasNext() { return PrimitiveIterator.OfShort.this.hasNext(); }
				@Override public byte nextByte() { return f.applyByte(PrimitiveIterator.OfShort.this.nextShort()); }
			};
		}
		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextShort()} will
		 * be used as the argument to the given mapper whenever {@link PrimitiveIterator.OfBoolean#nextBoolean()} is called.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code boolean} values
		 * are returned through a new {@link PrimitiveIterator.OfBoolean} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToBoolean}
		*            and accept elements of type {@code Short}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code boolean} value.
		*               Must not be {@code null}.
		* @param rm can be {@code null}
		* @return a new {@link PrimitiveIterator.OfBoolean} instance that provides the mapped {@code boolean} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToBoolean.OfShort}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper. The parameter {@code rm} is ignored in the default implementation
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToBoolean
		* @see PrimitiveFunction.ToBoolean.OfShort
		 */
		@Override
		default <M extends PrimitiveFunction.ToBoolean<? super java.lang.Short>, RM extends PrimitiveFunction<? extends java.lang.Short, ? super java.lang.Boolean>> PrimitiveIterator.OfBoolean mapToBoolean(M mapper, RM rm) {
			if(mapper == null) throw new NullPointerException();
			PrimitiveFunction.ToBoolean.OfShort f;
			if(mapper instanceof PrimitiveFunction.ToBoolean.OfShort) f = (PrimitiveFunction.ToBoolean.OfShort) mapper;
			else f = x -> mapper.applyBoolean(x);
			return new PrimitiveIterator.OfBoolean() {
				@Override public boolean hasNext() { return PrimitiveIterator.OfShort.this.hasNext(); }
				@Override public boolean nextBoolean() { return f.applyBoolean(PrimitiveIterator.OfShort.this.nextShort()); }
			};
		}

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 */
		@Override
		default jdk.prim.util.PrimitiveIterator.OfDouble toDouble() {
			return new jdk.prim.util.PrimitiveIterator.OfDouble() {

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
	interface OfByte extends PrimitiveIterator<Byte, PrimitiveConsumer.OfByte> {

		/**
		 * Creates and returns a boxed an iterator of {@link java.lang.Byte Double} objects where each element is a boxed {@code byte} value.
		 * 
		 * @return an iterator of boxed {@code Byte}
		 */
		@Override
		default java.util.PrimitiveIterator<Byte, PrimitiveConsumer.OfByte> boxed() { return this; }

		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextByte()} will
		 * be used as the argument to the given mapper whenever {@link PrimitiveIterator.OfDouble#nextDouble()} is called.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code double} values
		 * are returned through a new {@link PrimitiveIterator.OfDouble} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToDouble}
		*            and accept elements of type {@code Byte}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code double} value.
		*               Must not be {@code null}.
		* @param rm can be {@code null}
		* @return a new {@link PrimitiveIterator.OfDouble} instance that provides the mapped {@code double} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToDouble.OfByte}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper. The parameter {@code rm} is ignored in the default implementation
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToDouble
		* @see PrimitiveFunction.ToDouble.OfByte
		 */
		@Override
		default <M extends PrimitiveFunction.ToDouble<? super java.lang.Byte>, RM extends PrimitiveFunction<? extends java.lang.Byte, ? super java.lang.Double>> PrimitiveIterator.OfDouble mapToDouble(M mapper, RM rm) {
			PrimitiveFunction.ToDouble.OfByte f;
			if(mapper instanceof PrimitiveFunction.ToDouble.OfByte) f = (PrimitiveFunction.ToDouble.OfByte) mapper;
			else f = x -> mapper.applyDouble(x);
			return new PrimitiveIterator.OfDouble() {
				@Override public boolean hasNext() { return PrimitiveIterator.OfByte.this.hasNext(); }
				@Override public double nextDouble() { return f.applyDouble(PrimitiveIterator.OfByte.this.nextByte()); }
			};
		}
		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextByte()} will
		 * be used as the argument to the given mapper whenever {@link PrimitiveIterator.OfLong#nextLong()} is called.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code long} values
		 * are returned through a new {@link PrimitiveIterator.OfLong} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToLong}
		*            and accept elements of type {@code Byte}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code long} value.
		*               Must not be {@code null}.
		* @param rm can be {@code null}
		* @return a new {@link PrimitiveIterator.OfLong} instance that provides the mapped {@code long} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToLong.OfByte}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper. The parameter {@code rm} is ignored in the default implementation
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToLong
		* @see PrimitiveFunction.ToLong.OfByte
		 */
		@Override
		default <M extends PrimitiveFunction.ToLong<? super java.lang.Byte>, RM extends PrimitiveFunction<? extends java.lang.Byte, ? super java.lang.Long>> PrimitiveIterator.OfLong mapToLong(M mapper, RM rm) {
			PrimitiveFunction.ToLong.OfByte f;
			if(mapper instanceof PrimitiveFunction.ToLong.OfByte) f = (PrimitiveFunction.ToLong.OfByte) mapper;
			else f = x -> mapper.applyLong(x);
			return new PrimitiveIterator.OfLong() {
				@Override public boolean hasNext() { return  PrimitiveIterator.OfByte.this.hasNext(); }
				@Override public long nextLong() { return f.applyLong( PrimitiveIterator.OfByte.this.nextByte()); }
			};
		}
		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextByte()} will
		 * be used as the argument to the given mapper whenever {@link PrimitiveIterator.OfInt#nextInt()} is called.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code int} values
		 * are returned through a new {@link PrimitiveIterator.OfInt} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToInt}
		*            and accept elements of type {@code Byte}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code int} value.
		*               Must not be {@code null}.
		* @param rm can be {@code null}
		* @return a new {@link PrimitiveIterator.OfInt} instance that provides the mapped {@code int} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToInt.OfByte}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper. The parameter {@code rm} is ignored in the default implementation
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToInt
		* @see PrimitiveFunction.ToInt.OfByte
		 */
		@Override
		default <M extends PrimitiveFunction.ToInt<? super java.lang.Byte>, RM extends PrimitiveFunction<? extends java.lang.Byte, ? super java.lang.Integer>> PrimitiveIterator.OfInt mapToInt(M mapper, RM rm) {
			PrimitiveFunction.ToInt.OfByte f;
			if(mapper instanceof PrimitiveFunction.ToInt.OfByte) f = (PrimitiveFunction.ToInt.OfByte) mapper;
			else f = x -> mapper.applyInt(x);
			return new PrimitiveIterator.OfInt() {
				@Override public boolean hasNext() { return PrimitiveIterator.OfByte.this.hasNext(); }
				@Override public int nextInt() { return f.applyInt(PrimitiveIterator.OfByte.this.nextByte()); }
			};
		}
		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextByte()} will
		 * be used as the argument to the given mapper whenever {@link PrimitiveIterator.OfFloat#nextFloat()} is called.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code float} values
		 * are returned through a new {@link PrimitiveIterator.OfFloat} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToFloat}
		*            and accept elements of type {@code Byte}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code float} value.
		*               Must not be {@code null}.
		* @param rm can be {@code null}
		* @return a new {@link PrimitiveIterator.OfFloat} instance that provides the mapped {@code float} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToFloat.OfByte}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper. The parameter {@code rm} is ignored in the default implementation
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToFloat
		* @see PrimitiveFunction.ToFloat.OfByte
		 */
		@Override
		default <M extends PrimitiveFunction.ToFloat<? super java.lang.Byte>, RM extends PrimitiveFunction<? extends java.lang.Byte, ? super java.lang.Float>> PrimitiveIterator.OfFloat mapToFloat(M mapper, RM rm) {
			PrimitiveFunction.ToFloat.OfByte f;
			if(mapper instanceof PrimitiveFunction.ToFloat.OfByte) f = (PrimitiveFunction.ToFloat.OfByte) mapper;
			else f = x -> mapper.applyFloat(x);
			return new PrimitiveIterator.OfFloat() {
				@Override public boolean hasNext() { return PrimitiveIterator.OfByte.this.hasNext(); }
				@Override public float nextFloat() { return f.applyFloat(PrimitiveIterator.OfByte.this.nextByte()); }
			};
		}
		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextByte()} will
		 * be used as the argument to the given mapper whenever {@link PrimitiveIterator.OfChar#nextChar()} is called.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code char} values
		 * are returned through a new {@link PrimitiveIterator.OfChar} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToChar}
		*            and accept elements of type {@code Byte}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code char} value.
		*               Must not be {@code null}.
		* @param rm can be {@code null}
		* @return a new {@link PrimitiveIterator.OfChar} instance that provides the mapped {@code char} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToChar.OfByte}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper. The parameter {@code rm} is ignored in the default implementation
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToChar
		* @see PrimitiveFunction.ToChar.OfByte
		 */
		@Override
		default <M extends PrimitiveFunction.ToChar<? super java.lang.Byte>, RM extends PrimitiveFunction<? extends java.lang.Byte, ? super java.lang.Character>> PrimitiveIterator.OfChar mapToChar(M mapper, RM rm) {
			PrimitiveFunction.ToChar.OfByte f;
			if(mapper instanceof PrimitiveFunction.ToChar.OfByte) f = (PrimitiveFunction.ToChar.OfByte) mapper;
			else f = x -> mapper.applyChar(x);
			return new PrimitiveIterator.OfChar() {
				@Override public boolean hasNext() { return PrimitiveIterator.OfByte.this.hasNext(); }
				@Override public char nextChar() { return f.applyChar(PrimitiveIterator.OfByte.this.nextByte()); }
			};
		}
		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextByte()} will
		 * be used as the argument to the given mapper whenever {@link PrimitiveIterator.OfShort#nextShort()} is called.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code short} values
		 * are returned through a new {@link PrimitiveIterator.OfShort} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToShort}
		*            and accept elements of type {@code Byte}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code short} value.
		*               Must not be {@code null}.
		* @param rm can be {@code null}
		* @return a new {@link PrimitiveIterator.OfShort} instance that provides the mapped {@code short} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToShort.OfByte}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper. The parameter {@code rm} is ignored in the default implementation
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToShort
		* @see PrimitiveFunction.ToShort.OfByte
		 */
		@Override
		default <M extends PrimitiveFunction.ToShort<? super java.lang.Byte>, RM extends PrimitiveFunction<? extends java.lang.Byte, ? super java.lang.Short>> PrimitiveIterator.OfShort mapToShort(M mapper, RM rm) {
			PrimitiveFunction.ToShort.OfByte f;
			if(mapper instanceof PrimitiveFunction.ToShort.OfByte) f = (PrimitiveFunction.ToShort.OfByte) mapper;
			else f = x -> mapper.applyShort(x);
			return new PrimitiveIterator.OfShort() {
				@Override public boolean hasNext() { return PrimitiveIterator.OfByte.this.hasNext(); }
				@Override public short nextShort() { return f.applyShort(PrimitiveIterator.OfByte.this.nextByte()); }
			};
		}
		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextByte()} will
		 * be used as the argument to the given mapper whenever {@link PrimitiveIterator.OfByte#nextByte()} is called.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code byte} values
		 * are returned through a new {@link PrimitiveIterator.OfByte} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToByte}
		*            and accept elements of type {@code Byte}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code byte} value.
		*               Must not be {@code null}.
		* @param rm can be {@code null}
		* @return a new {@link PrimitiveIterator.OfByte} instance that provides the mapped {@code byte} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToByte.OfByte}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper. The parameter {@code rm} is ignored in the default implementation
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToByte
		* @see PrimitiveFunction.ToByte.OfByte
		 */
		@Override
		default <M extends PrimitiveFunction.ToByte<? super java.lang.Byte>, RM extends PrimitiveFunction<? extends java.lang.Byte, ? super java.lang.Byte>> PrimitiveIterator.OfByte mapToByte(M mapper, RM rm) {
			PrimitiveFunction.ToByte.OfByte f;
			if(mapper instanceof PrimitiveFunction.ToByte.OfByte) f = (PrimitiveFunction.ToByte.OfByte) mapper;
			else f = x -> mapper.applyByte(x);
			PrimitiveIterator.OfByte thisIt = this;
			return new PrimitiveIterator.OfByte() {
				@Override public boolean hasNext() { return thisIt.hasNext(); }
				@Override public byte nextByte() { return f.applyByte(thisIt.nextByte()); }
			};
		}
		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextByte()} will
		 * be used as the argument to the given mapper whenever {@link PrimitiveIterator.OfBoolean#nextBoolean()} is called.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code boolean} values
		 * are returned through a new {@link PrimitiveIterator.OfBoolean} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToBoolean}
		*            and accept elements of type {@code Byte}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code boolean} value.
		*               Must not be {@code null}.
		* @param rm can be {@code null}
		* @return a new {@link PrimitiveIterator.OfBoolean} instance that provides the mapped {@code boolean} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToBoolean.OfByte}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper. The parameter {@code rm} is ignored in the default implementation
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToBoolean
		* @see PrimitiveFunction.ToBoolean.OfByte
		 */
		@Override
		default <M extends PrimitiveFunction.ToBoolean<? super java.lang.Byte>, RM extends PrimitiveFunction<? extends java.lang.Byte, ? super java.lang.Boolean>> PrimitiveIterator.OfBoolean mapToBoolean(M mapper, RM rm) {
			PrimitiveFunction.ToBoolean.OfByte f;
			if(mapper instanceof PrimitiveFunction.ToBoolean.OfByte) f = (PrimitiveFunction.ToBoolean.OfByte) mapper;
			else f = x -> mapper.applyBoolean(x);
			return new PrimitiveIterator.OfBoolean() {
				@Override public boolean hasNext() { return PrimitiveIterator.OfByte.this.hasNext(); }
				@Override public boolean nextBoolean() { return f.applyBoolean(PrimitiveIterator.OfByte.this.nextByte()); }
			};
		}

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 */
		@Override
		default jdk.prim.util.PrimitiveIterator.OfDouble toDouble() {
			return new jdk.prim.util.PrimitiveIterator.OfDouble() {

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
	interface OfBoolean extends PrimitiveIterator<Boolean, PrimitiveConsumer.OfBoolean> {

		/**
		 * Creates and returns a boxed an iterator of {@link java.lang.Boolean Double} objects where each element is a boxed {@code boolean} value.
		 * 
		 * @return an iterator of boxed {@code Boolean}
		 */
		@Override
		default java.util.PrimitiveIterator<Boolean, PrimitiveConsumer.OfBoolean> boxed() { return this; }

		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextBoolean()} will
		 * be used as the argument to the given mapper whenever {@link PrimitiveIterator.OfDouble#nextDouble()} is called.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code double} values
		 * are returned through a new {@link PrimitiveIterator.OfDouble} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToDouble}
		*            and accept elements of type {@code Boolean}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code double} value.
		*               Must not be {@code null}.
		* @param rm can be {@code null}
		* @return a new {@link PrimitiveIterator.OfDouble} instance that provides the mapped {@code double} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToDouble.OfBoolean}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper. The parameter {@code rm} is ignored in the default implementation
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToDouble
		* @see PrimitiveFunction.ToDouble.OfBoolean
		 */
		@Override
		default <M extends PrimitiveFunction.ToDouble<? super java.lang.Boolean>, RM extends PrimitiveFunction<? extends java.lang.Boolean, ? super java.lang.Double>> PrimitiveIterator.OfDouble mapToDouble(M mapper, RM rm) {
			PrimitiveFunction.ToDouble.OfBoolean f;
			if(mapper instanceof PrimitiveFunction.ToDouble.OfBoolean) f = (PrimitiveFunction.ToDouble.OfBoolean) mapper;
			else f = x -> mapper.applyDouble(x);
			return new PrimitiveIterator.OfDouble() {
				@Override public boolean hasNext() { return PrimitiveIterator.OfBoolean.this.hasNext(); }
				@Override public double nextDouble() { return f.applyDouble(PrimitiveIterator.OfBoolean.this.nextBoolean()); }
			};
		}
		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextBoolean()} will
		 * be used as the argument to the given mapper whenever {@link PrimitiveIterator.OfLong#nextLong()} is called.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code long} values
		 * are returned through a new {@link PrimitiveIterator.OfLong} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToLong}
		*            and accept elements of type {@code Boolean}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code long} value.
		*               Must not be {@code null}.
		* @param rm can be {@code null}
		* @return a new {@link PrimitiveIterator.OfLong} instance that provides the mapped {@code long} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToLong.OfBoolean}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper. The parameter {@code rm} is ignored in the default implementation
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToLong
		* @see PrimitiveFunction.ToLong.OfBoolean
		 */
		@Override
		default <M extends PrimitiveFunction.ToLong<? super java.lang.Boolean>, RM extends PrimitiveFunction<? extends java.lang.Boolean, ? super java.lang.Long>> PrimitiveIterator.OfLong mapToLong(M mapper, RM rm) {
			PrimitiveFunction.ToLong.OfBoolean f;
			if(mapper instanceof PrimitiveFunction.ToLong.OfBoolean) f = (PrimitiveFunction.ToLong.OfBoolean) mapper;
			else f = x -> mapper.applyLong(x);
			return new PrimitiveIterator.OfLong() {
				@Override public boolean hasNext() { return  PrimitiveIterator.OfBoolean.this.hasNext(); }
				@Override public long nextLong() { return f.applyLong( PrimitiveIterator.OfBoolean.this.nextBoolean()); }
			};
		}
		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextBoolean()} will
		 * be used as the argument to the given mapper whenever {@link PrimitiveIterator.OfInt#nextInt()} is called.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code int} values
		 * are returned through a new {@link PrimitiveIterator.OfInt} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToInt}
		*            and accept elements of type {@code Boolean}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code int} value.
		*               Must not be {@code null}.
		* @param rm can be {@code null}
		* @return a new {@link PrimitiveIterator.OfInt} instance that provides the mapped {@code int} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToInt.OfBoolean}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper. The parameter {@code rm} is ignored in the default implementation
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToInt
		* @see PrimitiveFunction.ToInt.OfBoolean
		 */
		@Override
		default <M extends PrimitiveFunction.ToInt<? super java.lang.Boolean>, RM extends PrimitiveFunction<? extends java.lang.Boolean, ? super java.lang.Integer>> PrimitiveIterator.OfInt mapToInt(M mapper, RM rm) {
			PrimitiveFunction.ToInt.OfBoolean f;
			if(mapper instanceof PrimitiveFunction.ToInt.OfBoolean) f = (PrimitiveFunction.ToInt.OfBoolean) mapper;
			else f = x -> mapper.applyInt(x);
			return new PrimitiveIterator.OfInt() {
				@Override public boolean hasNext() { return PrimitiveIterator.OfBoolean.this.hasNext(); }
				@Override public int nextInt() { return f.applyInt(PrimitiveIterator.OfBoolean.this.nextBoolean()); }
			};
		}
		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextBoolean()} will
		 * be used as the argument to the given mapper whenever {@link PrimitiveIterator.OfFloat#nextFloat()} is called.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code float} values
		 * are returned through a new {@link PrimitiveIterator.OfFloat} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToFloat}
		*            and accept elements of type {@code Boolean}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code float} value.
		*               Must not be {@code null}.
		* @param rm can be {@code null}
		* @return a new {@link PrimitiveIterator.OfFloat} instance that provides the mapped {@code float} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToFloat.OfBoolean}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper. The parameter {@code rm} is ignored in the default implementation
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToFloat
		* @see PrimitiveFunction.ToFloat.OfBoolean
		 */
		@Override
		default <M extends PrimitiveFunction.ToFloat<? super java.lang.Boolean>, RM extends PrimitiveFunction<? extends java.lang.Boolean, ? super java.lang.Float>> PrimitiveIterator.OfFloat mapToFloat(M mapper, RM rm) {
			PrimitiveFunction.ToFloat.OfBoolean f;
			if(mapper instanceof PrimitiveFunction.ToFloat.OfBoolean) f = (PrimitiveFunction.ToFloat.OfBoolean) mapper;
			else f = x -> mapper.applyFloat(x);
			return new PrimitiveIterator.OfFloat() {
				@Override public boolean hasNext() { return PrimitiveIterator.OfBoolean.this.hasNext(); }
				@Override public float nextFloat() { return f.applyFloat(PrimitiveIterator.OfBoolean.this.nextBoolean()); }
			};
		}
		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextBoolean()} will
		 * be used as the argument to the given mapper whenever {@link PrimitiveIterator.OfChar#nextChar()} is called.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code char} values
		 * are returned through a new {@link PrimitiveIterator.OfChar} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToChar}
		*            and accept elements of type {@code Boolean}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code char} value.
		*               Must not be {@code null}.
		* @param rm can be {@code null}
		* @return a new {@link PrimitiveIterator.OfChar} instance that provides the mapped {@code char} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToChar.OfBoolean}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper. The parameter {@code rm} is ignored in the default implementation
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToChar
		* @see PrimitiveFunction.ToChar.OfBoolean
		 */
		@Override
		default <M extends PrimitiveFunction.ToChar<? super java.lang.Boolean>, RM extends PrimitiveFunction<? extends java.lang.Boolean, ? super java.lang.Character>> PrimitiveIterator.OfChar mapToChar(M mapper, RM rm) {
			PrimitiveFunction.ToChar.OfBoolean f;
			if(mapper instanceof PrimitiveFunction.ToChar.OfBoolean) f = (PrimitiveFunction.ToChar.OfBoolean) mapper;
			else f = x -> mapper.applyChar(x);
			return new PrimitiveIterator.OfChar() {
				@Override public boolean hasNext() { return PrimitiveIterator.OfBoolean.this.hasNext(); }
				@Override public char nextChar() { return f.applyChar(PrimitiveIterator.OfBoolean.this.nextBoolean()); }
			};
		}
		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextBoolean()} will
		 * be used as the argument to the given mapper whenever {@link PrimitiveIterator.OfShort#nextShort()} is called.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code short} values
		 * are returned through a new {@link PrimitiveIterator.OfShort} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToShort}
		*            and accept elements of type {@code Boolean}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code short} value.
		*               Must not be {@code null}.
		* @param rm can be {@code null}
		* @return a new {@link PrimitiveIterator.OfShort} instance that provides the mapped {@code short} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToShort.OfBoolean}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper. The parameter {@code rm} is ignored in the default implementation
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToShort
		* @see PrimitiveFunction.ToShort.OfBoolean
		 */
		@Override
		default <M extends PrimitiveFunction.ToShort<? super java.lang.Boolean>, RM extends PrimitiveFunction<? extends java.lang.Boolean, ? super java.lang.Short>> PrimitiveIterator.OfShort mapToShort(M mapper, RM rm) {
			PrimitiveFunction.ToShort.OfBoolean f;
			if(mapper instanceof PrimitiveFunction.ToShort.OfBoolean) f = (PrimitiveFunction.ToShort.OfBoolean) mapper;
			else f = x -> mapper.applyShort(x);
			return new PrimitiveIterator.OfShort() {
				@Override public boolean hasNext() { return PrimitiveIterator.OfBoolean.this.hasNext(); }
				@Override public short nextShort() { return f.applyShort(PrimitiveIterator.OfBoolean.this.nextBoolean()); }
			};
		}
		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextBoolean()} will
		 * be used as the argument to the given mapper whenever {@link PrimitiveIterator.OfByte#nextByte()} is called.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code byte} values
		 * are returned through a new {@link PrimitiveIterator.OfByte} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToByte}
		*            and accept elements of type {@code Boolean}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code byte} value.
		*               Must not be {@code null}.
		* @param rm can be {@code null}
		* @return a new {@link PrimitiveIterator.OfByte} instance that provides the mapped {@code byte} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToByte.OfBoolean}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper. The parameter {@code rm} is ignored in the default implementation
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToByte
		* @see PrimitiveFunction.ToByte.OfBoolean
		 */
		@Override
		default <M extends PrimitiveFunction.ToByte<? super java.lang.Boolean>, RM extends PrimitiveFunction<? extends java.lang.Boolean, ? super java.lang.Byte>> PrimitiveIterator.OfByte mapToByte(M mapper, RM rm) {
			PrimitiveFunction.ToByte.OfBoolean f;
			if(mapper instanceof PrimitiveFunction.ToByte.OfBoolean) f = (PrimitiveFunction.ToByte.OfBoolean) mapper;
			else f = x -> mapper.applyByte(x);
			return new PrimitiveIterator.OfByte() {
				@Override public boolean hasNext() { return PrimitiveIterator.OfBoolean.this.hasNext(); }
				@Override public byte nextByte() { return f.applyByte(PrimitiveIterator.OfBoolean.this.nextBoolean()); }
			};
		}
		/**
		 * Composes a new iterator from {@code this} where all subsequent values retrieved via {@link #nextBoolean()} will
		 * be used as the argument to the given mapper whenever {@link PrimitiveIterator.OfBoolean#nextBoolean()} is called.
		 * <p>
		 * The mapper function is applied to each element of the iterator, and the resulting {@code boolean} values
		 * are returned through a new {@link PrimitiveIterator.OfBoolean} instance. The original iterator remains
		 * unmodified. This new iterator contains all the state of the previous one, this means that if this
		 * iterator was exhausted, the composed one will etc.
		 * @param <M> the type of the mapper function, which must extend {@link PrimitiveFunction.ToBoolean}
		*            and accept elements of type {@code Boolean}.
		* @param <RM> the reverse mapper which is never used as no iterator methods declare a primitive parameter
		* @param mapper the function to apply to each element of this iterator to produce a {@code boolean} value.
		*               Must not be {@code null}.
		* @param rm can be {@code null}
		* @return a new {@link PrimitiveIterator.OfBoolean} instance that provides the mapped {@code boolean} values.
		 * @throws NullPointerException if the provided {@code mapper} is {@code null}.
		* @implSpec The default implementation checks if the provided mapper is an instance of
		*           {@link PrimitiveFunction.ToBoolean.OfBoolean}. If so, it is cast directly; otherwise, a lambda
		*           is used to adapt the mapper. The parameter {@code rm} is ignored in the default implementation
		* @implNote The returned iterator is backed by this iterator, meaning that changes to this iterator
		*           (e.g., advancing its position) will affect the returned iterator and vice versa.
		* @see PrimitiveFunction.ToBoolean
		* @see PrimitiveFunction.ToBoolean.OfBoolean
		 */
		@Override
		default <M extends PrimitiveFunction.ToBoolean<? super java.lang.Boolean>, RM extends PrimitiveFunction<? extends java.lang.Boolean, ? super java.lang.Boolean>> PrimitiveIterator.OfBoolean mapToBoolean(M mapper, RM rm) {
			PrimitiveFunction.ToBoolean.OfBoolean f;
			if(mapper instanceof PrimitiveFunction.ToBoolean.OfBoolean) f = (PrimitiveFunction.ToBoolean.OfBoolean) mapper;
			else f = x -> mapper.applyBoolean(x);
			PrimitiveIterator.OfBoolean thisIt = this;
			return new PrimitiveIterator.OfBoolean() {
				@Override public boolean hasNext() { return thisIt.hasNext(); }
				@Override public boolean nextBoolean() { return f.applyBoolean(thisIt.nextBoolean()); }
			};
		}

		/*
		 * Date created: 27 May 2024 Time created: 13:36:33
		 */
		/**
		 * {@inheritDoc}
		 */
		@Override
		default jdk.prim.util.PrimitiveIterator.OfDouble toDouble() {
			return new jdk.prim.util.PrimitiveIterator.OfDouble() {

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

	@Override
	java.util.PrimitiveIterator<T, T_CONS> boxed();

	/*
	 * Date created: 27 May 2024 Time created: 14:07:48
	 */
	/**
	 * Casts this iterator to a double iterator. This may cause a widening/narrowing
	 * primitive conversion to take place.
	 * 
	 * @return an iterator of {@code double} whereby each element returned is cast
	 *         to a {@code double}.
	 * @apiNote The returned iterator contains a reference to {@code this}. Hence,
	 *          any changes to the returned iterator affects {@code this} and
	 *          vice versa.
	 */
	PrimitiveIterator<Double, DoubleConsumer> toDouble();

	/*
	 * Date created: 27 May 2024 Time created: 14:07:48
	 */
	/**
	 * Casts this iterator to a long iterator. This may cause a widening/narrowing
	 * primitive conversion to take place.
	 * 
	 * @return an iterator of {@code long} whereby each element returned is cast to
	 *         a {@code long}.
	 * @apiNote The returned iterator contains a reference to {@code this}. Hence,
	 *          any changes to the returned iterator affects {@code this} and
	 *          vice versa.
	 */
	PrimitiveIterator<Long, LongConsumer> toLong();

	/*
	 * Date created: 27 May 2024 Time created: 14:07:48
	 */
	/**
	 * Casts this iterator to an int iterator. This may cause a widening/narrowing
	 * primitive conversion to take place.
	 * 
	 * @return an iterator of {@code int} whereby each element returned is cast to a
	 *         {@code int}.
	 * @apiNote The returned iterator contains a reference to {@code this}. Hence,
	 *          any changes to the returned iterator affects {@code this} and
	 *          vice versa.
	 */
	PrimitiveIterator<Integer, IntConsumer> toInt();

	/*
	 * Date created: 27 May 2024 Time created: 14:07:48
	 */
	/**
	 * Casts this iterator to a float iterator. This may cause a widening/narrowing
	 * primitive conversion to take place.
	 * 
	 * @return an iterator of {@code float} whereby each element returned is cast to
	 *         a {@code float}.
	 * @apiNote The returned iterator contains a reference to {@code this}. Hence,
	 *          any changes to the returned iterator affects {@code this} and
	 *          vice versa.
	 */
	PrimitiveIterator<Float, PrimitiveConsumer.OfFloat> toFloat();

	/*
	 * Date created: 27 May 2024 Time created: 14:07:48
	 */
	/**
	 * Casts this iterator to a char iterator. This may cause a widening/narrowing
	 * primitive conversion to take place.
	 * 
	 * @return an iterator of {@code char} cast of each element returned.
	 * @apiNote The returned iterator contains a reference to {@code this}. Hence,
	 *          any changes to the returned iterator affects {@code this} and
	 *          vice versa.
	 */
	PrimitiveIterator<Character, PrimitiveConsumer.OfChar> toChar();

	/*
	 * Date created: 27 May 2024 Time created: 14:07:48
	 */
	/**
	 * Casts this iterator to a short iterator. This may cause a widening/narrowing
	 * primitive conversion to take place.
	 * 
	 * @return an iterator of {@code short} whereby each element returned is cast to
	 *         a {@code short}.
	 * @apiNote The returned iterator contains a reference to {@code this}. Hence,
	 *          any changes to the returned iterator affects {@code this} and
	 *          vice versa.
	 */
	PrimitiveIterator<Short, PrimitiveConsumer.OfShort> toShort();

	/*
	 * Date created: 27 May 2024 Time created: 14:07:48
	 */
	/**
	 * Casts this iterator to a byte iterator. This may cause a widening/narrowing
	 * primitive conversion to take place.
	 * 
	 * @return an iterator of {@code byte} whereby each element returned is cast to
	 *         a {@code byte}.
	 * @apiNote The returned iterator contains a reference to {@code this}. Hence,
	 *          any changes to the returned iterator affects {@code this} and
	 *          vice versa.
	 */
	PrimitiveIterator<Byte, PrimitiveConsumer.OfByte> toByte();

	/*
	 * Date created: 27 May 2024 Time created: 14:07:48
	 */
	/**
	 * Casts this iterator to a boolean iterator. This may cause a
	 * widening/narrowing primitive conversion to take place.
	 * 
	 * @return an iterator of {@code boolean} whereby each element returned is cast
	 *         to a {@code boolean}.
	 * @apiNote The returned iterator contains a reference to {@code this}. Hence,
	 *          any changes to the returned iterator affects {@code this} and
	 *          vice versa.
	 */
	PrimitiveIterator<Boolean, PrimitiveConsumer.OfBoolean> toBoolean();
}
