package jdk.prim.util;

import java.util.NoSuchElementException;
import java.util.function.Supplier;

import jdk.prim.util.function.PrimitiveConsumer;
import jdk.prim.util.function.PrimitiveSupplier;

public final class OptionalByte {
    /**
     * Common instance for {@code empty()}.
     */
    private static final OptionalByte EMPTY = new OptionalByte();

    /**
     * If true then the value is present, otherwise indicates no value is present
     */
    private final boolean isPresent;
    /**The intrinsic value */
    private final byte b;

    private OptionalByte() {
        isPresent = false;
        b = 0;
    }

    /**
     * Returns an empty {@code OptionalByte} instance.  No value is present
     * for this {@code OptionalByte}.
     *
     * @apiNote
     * Though it may be tempting to do so, avoid testing if an object is empty
     * by comparing with {@code ==} or {@code !=} against instances returned by
     * {@code OptionalByte.empty()}.  There is no guarantee that it is a singleton.
     * Instead, use {@link #isEmpty()} or {@link #isPresent()}.
     *
     *  @return an empty {@code OptionalByte}.
     */
    public static OptionalByte empty() {
        return EMPTY;
    }

    private OptionalByte(byte b) {
        isPresent = true;
        this.b = b;
    }

    /**
     * Returns an {@code OptionalByte} describing the given value.
     *
     * @param value the value to describe
     * @return an {@code OptionalByte} with the value present
     */
    public static OptionalByte of(byte value) {
        return new OptionalByte(value);
    }
    
    /**
     * If a value is present, returns the value, otherwise throws
     * {@code NoSuchElementException}.
     *
     * @apiNote
     * The preferred alternative to this method is {@link #orElseThrow()}.
     *
     * @return the value described by this {@code OptionalByte}
     * @throws NoSuchElementException if no value is present
     */
    public byte getAsByte() throws NoSuchElementException {
        if (!isPresent) {
            throw new NoSuchElementException("No value present");
        }
        return b;
    }

    /**
     * Semantically equal to {@link #getAsByte()}
     * @return the value described by {@code this}
     * @throws NoSuchElementException if no value is present
     * @see #getAsByte()
     */
    public byte getByte() throws NoSuchElementException {
        return getAsByte();
    }

    /**
     * If a value is present, returns {@code true}, otherwise {@code false}.
     *
     * @return {@code true} if a value is present, otherwise {@code false}
     */
    public boolean isPresent() {
        return isPresent;
    }

    /**
     * If a value is not present, returns {@code true}, otherwise
     * {@code false}.
     *
     * @return  {@code true} if a value is not present, otherwise {@code false}
     */
    public boolean isEmpty() {
        return !isPresent;
    }

    /**
     * If a value is present, performs the given action with the value,
     * otherwise does nothing.
     *
     * @param action the action to be performed, if a value is present
     * @throws NullPointerException if value is present and the given action is
     *         {@code null}
     */
    public void ifPresent(PrimitiveConsumer.OfByte action) {
        if (isPresent) {
            action.acceptByte(b);
        }
    }

    /**
     * If a value is present, performs the given action with the value,
     * otherwise performs the given empty-based action.
     *
     * @param action the action to be performed, if a value is present
     * @param emptyAction the empty-based action to be performed, if no value is
     * present
     * @throws NullPointerException if a value is present and the given action
     *         is {@code null}, or no value is present and the given empty-based
     *         action is {@code null}.
     */
    public void ifPresentOrElse(PrimitiveConsumer.OfByte action, Runnable emptyAction) {
        if (isPresent) {
            action.acceptByte(b);
        } else {
            emptyAction.run();
        }
    }

    /**
     * If a value is present, returns a sequential {@link ByteStream}
     * containing only that value, otherwise returns an empty
     * {@code ByteStream}.
     *
     * @apiNote
     * This method can be used to transform a {@code Stream} of optional chars
     * to a {@code ByteStream} of present chars:
     * <pre>{@code
     *     Stream<OptionalByte> os = ..
     *     ByteStream b = flatMapToByte(os, OptionalByte::stream)
     * }</pre>
     *
     * @return the optional value as a {@code ByteStream}
     */
    /*public ByteStream stream() {
        if (isPresent) {
            return ByteStream.of(b);
        } else {
            return ByteStream.empty();
        }
    }*/

    /**
     * If a value is present, returns the value, otherwise returns
     * {@code other}.
     *
     * @param other the value to be returned, if no value is present
     * @return the value, if present, otherwise {@code other}
     */
    public byte orElse(byte other) {
        return isPresent ? b : other;
    }

    /**
     * If a value is present, returns the value, otherwise returns the result
     * produced by the supplying function.
     *
     * @param supplier the supplying function that produces a value to be returned
     * @return the value, if present, otherwise the result produced by the
     *         supplying function
     * @throws NullPointerException if no value is present and the supplying
     *         function is {@code null}
     */
    public byte orElseGet(PrimitiveSupplier.ToByte supplier) {
        return isPresent ? b : supplier.getByte();
    }

    /**
     * If a value is present, returns the value, otherwise throws
     * {@code NoSuchElementException}.
     *
     * @return the value described by this {@code OptionalByte}
     * @throws NoSuchElementException if no value is present
     */
    public byte orElseThrow() throws NoSuchElementException {
        if (!isPresent) {
            throw new NoSuchElementException("No value present");
        }
        return b;
    }

    /**
     * If a value is present, returns the value, otherwise throws an exception
     * produced by the exception supplying function.
     *
     * @apiNote
     * A method reference to the exception constructor with an empty argument
     * list can be used as the supplier. For example,
     * {@code IllegalStateException::new}
     *
     * @param <X> Type of the exception to be thrown
     * @param exceptionSupplier the supplying function that produces an
     *        exception to be thrown
     * @return the value, if present
     * @throws X if no value is present
     * @throws NullPointerException if no value is present and the exception
     *         supplying function is {@code null}
     */
    public<X extends Throwable> byte orElseThrow(Supplier<? extends X> exceptionSupplier) throws X {
        if (isPresent) {
            return b;
        } else {
            throw exceptionSupplier.get();
        }
    }

    /**
     * Indicates whether some other object is "equal to" this
     * {@code OptionalByte}. The other object is considered equal if:
     * <ul>
     * <li>it is also an {@code OptionalByte} and;
     * <li>both instances have no value present or;
     * <li>the present values are "equal to" each other via
     * {@code Byte.compare() == 0}.
     * </ul>
     *
     * @param obj an object to be tested for equality
     * @return {@code true} if the other object is "equal to" this object
     *         otherwise {@code false}
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        return obj instanceof OptionalByte other
                && (isPresent && other.isPresent
                ? Byte.compare(b, other.b) == 0
                : isPresent == other.isPresent);
    }

    /**
     * Returns the hash code of the value, if present, otherwise {@code 0}
     * (zero) if no value is present.
     *
     * @return hash code value of the present value or {@code 0} if no value is
     *         present
     */
    @Override
    public int hashCode() {
        return isPresent ? Byte.hashCode(b) : 0;
    }

    /**
     * Returns a non-empty string representation of this {@code OptionalByte}
     * suitable for debugging.  The exact presentation format is unspecified and
     * may vary between implementations and versions.
     *
     * @implSpec
     * If a value is present the result must include its string representation
     * in the result.  Empty and present {@code OptionalByte} must be
     * unambiguously differentiable.
     *
     * @return the string representation of this instance
     */
    @Override
    public String toString() {
        return isPresent
                ? ("OptionalByte[" + b + "]")
                : "OptionalByte.empty";
    }

}
