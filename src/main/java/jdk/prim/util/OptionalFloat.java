package jdk.prim.util;

import java.util.NoSuchElementException;
import java.util.function.Supplier;

import jdk.prim.util.function.PrimitiveConsumer;
import jdk.prim.util.function.PrimitiveSupplier;

/**
 * A container object which may or may not contain a {@code float} value.
 * If a value is present, {@code isPresent()} returns {@code true}. If no
 * value is present, the object is considered <i>empty</i> and
 * {@code isPresent()} returns {@code false}.
 *
 * <p>Additional methods that depend on the presence or absence of a contained
 * value are provided, such as {@link #orElse(float) orElse()}
 * (returns a default value if no value is present) and
 * {@link #ifPresent(PrimitiveConsumer.OfFloat) ifPresent()} (performs an
 * action if a value is present).
 *
 * @apiNote
 * {@code OptionalFloat} is primarily intended for use as a method return type where
 * there is a clear need to represent "no result." A variable whose type is
 * {@code OptionalFloat} should never itself be {@code null}; it should always point
 * to an {@code OptionalFloat} instance.
 */
public final class OptionalFloat {
    /**
     * Common instance for {@code empty()}.
     */
    private static final OptionalFloat EMPTY = new OptionalFloat();

    /**
     * If true then the value is present, otherwise indicates no value is present
     */
    private final boolean isPresent;
    /**The intrinsic value */
    private final float f;

    private OptionalFloat() {
        isPresent = false;
        f = Float.NaN;
    }

    /**
     * Returns an empty {@code OptionalFloat} instance.  No value is present
     * for this {@code OptionalFloat}.
     *
     * @apiNote
     * Though it may be tempting to do so, avoid testing if an object is empty
     * by comparing with {@code ==} or {@code !=} against instances returned by
     * {@code OptionalFloat.empty()}.  There is no guarantee that it is a singleton.
     * Instead, use {@link #isEmpty()} or {@link #isPresent()}.
     *
     *  @return an empty {@code OptionalFloat}.
     */
    public static OptionalFloat empty() {
        return EMPTY;
    }

    private OptionalFloat(float f) {
        isPresent = true;
        this.f = f;
    }

    /**
     * Returns an {@code OptionalFloat} describing the given value.
     *
     * @param value the value to describe
     * @return an {@code OptionalFloat} with the value present
     */
    public static OptionalFloat of(float value) {
        return new OptionalFloat(value);
    }
    
    /**
     * If a value is present, returns the value, otherwise throws
     * {@code NoSuchElementException}.
     *
     * @apiNote
     * The preferred alternative to this method is {@link #orElseThrow()}.
     *
     * @return the value described by this {@code OptionalFloat}
     * @throws NoSuchElementException if no value is present
     */
    public float getAsFloat() throws NoSuchElementException {
        if (!isPresent) {
            throw new NoSuchElementException("No value present");
        }
        return f;
    }

    /**
     * Semantically equal to {@link #getAsFloat()}
     * @return the value described by {@code this}
     * @throws NoSuchElementException if no value is present
     * @see #getAsFloat()
     */
    public float getFloat() throws NoSuchElementException {
        return getAsFloat();
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
    public void ifPresent(PrimitiveConsumer.OfFloat action) {
        if (isPresent) {
            action.acceptFloat(f);
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
    public void ifPresentOrElse(PrimitiveConsumer.OfFloat action, Runnable emptyAction) {
        if (isPresent) {
            action.acceptFloat(f);
        } else {
            emptyAction.run();
        }
    }

    /**
     * If a value is present, returns a sequential {@link FloatStream}
     * containing only that value, otherwise returns an empty
     * {@code FloatStream}.
     *
     * @apiNote
     * This method can be used to transform a {@code Stream} of optional floats
     * to a {@code FloatStream} of present floats:
     * <pre>{@code
     *     Stream<OptionalFloat> os = ..
     *     FloatStream s = flatMapToFloat(os, OptionalFloat::stream)
     * }</pre>
     *
     * @return the optional value as a {@code FloatStream}
     */
    /*public FloatStream stream() {
        if (isPresent) {
            return FloatStream.of(f);
        } else {
            return FloatStream.empty();
        }
    }*/

    /**
     * If a value is present, returns the value, otherwise returns
     * {@code other}.
     *
     * @param other the value to be returned, if no value is present
     * @return the value, if present, otherwise {@code other}
     */
    public float orElse(float other) {
        return isPresent ? f : other;
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
    public float orElseGet(PrimitiveSupplier.ToFloat supplier) {
        return isPresent ? f : supplier.getFloat();
    }

    /**
     * If a value is present, returns the value, otherwise throws
     * {@code NoSuchElementException}.
     *
     * @return the value described by this {@code OptionalFloat}
     * @throws NoSuchElementException if no value is present
     */
    public float orElseThrow() throws NoSuchElementException {
        if (!isPresent) {
            throw new NoSuchElementException("No value present");
        }
        return f;
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
    public<X extends Throwable> float orElseThrow(Supplier<? extends X> exceptionSupplier) throws X {
        if (isPresent) {
            return f;
        } else {
            throw exceptionSupplier.get();
        }
    }

    /**
     * Indicates whether some other object is "equal to" this
     * {@code OptionalFloat}. The other object is considered equal if:
     * <ul>
     * <li>it is also an {@code OptionalFloat} and;
     * <li>both instances have no value present or;
     * <li>the present values are "equal to" each other via
     * {@code Float.compare() == 0}.
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

        return obj instanceof OptionalFloat other
                && (isPresent && other.isPresent
                ? Float.compare(f, other.f) == 0
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
        return isPresent ? Float.hashCode(f) : 0;
    }

    /**
     * Returns a non-empty string representation of this {@code OptionalFloat}
     * suitable for debugging.  The exact presentation format is unspecified and
     * may vary between implementations and versions.
     *
     * @implSpec
     * If a value is present the result must include its string representation
     * in the result.  Empty and present {@code OptionalFloat}s must be
     * unambiguously differentiable.
     *
     * @return the string representation of this instance
     */
    @Override
    public String toString() {
        return isPresent
                ? ("OptionalFloat[" + f + "]")
                : "OptionalFloat.empty";
    }

}
