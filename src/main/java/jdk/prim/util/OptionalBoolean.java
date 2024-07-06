package jdk.prim.util;

import java.util.NoSuchElementException;
import java.util.function.Supplier;

import jdk.prim.util.function.PrimitiveConsumer;
import jdk.prim.util.function.PrimitiveSupplier;

public final class OptionalBoolean {
    /**
     * Common instance for {@code empty()}.
     */
    private static final OptionalBoolean EMPTY = new OptionalBoolean();

    /**
     * If true then the value is present, otherwise indicates no value is present
     */
    private final boolean isPresent;
    /**The intrinsic value */
    private final boolean b;

    private OptionalBoolean() {
        isPresent = false;
        b = false;
    }

    /**
     * Returns an empty {@code OptionalBoolean} instance.  No value is present
     * for this {@code OptionalBoolean}.
     *
     * @apiNote
     * Though it may be tempting to do so, avoid testing if an object is empty
     * by comparing with {@code ==} or {@code !=} against instances returned by
     * {@code OptionalBoolean.empty()}.  There is no guarantee that it is a singleton.
     * Instead, use {@link #isEmpty()} or {@link #isPresent()}.
     *
     *  @return an empty {@code OptionalBoolean}.
     */
    public static OptionalBoolean empty() {
        return EMPTY;
    }

    private OptionalBoolean(boolean b) {
        isPresent = true;
        this.b = b;
    }

    /**
     * Returns an {@code OptionalBoolean} describing the given value.
     *
     * @param value the value to describe
     * @return an {@code OptionalBoolean} with the value present
     */
    public static OptionalBoolean of(boolean value) {
        return new OptionalBoolean(value);
    }
    
    /**
     * If a value is present, returns the value, otherwise throws
     * {@code NoSuchElementException}.
     *
     * @apiNote
     * The preferred alternative to this method is {@link #orElseThrow()}.
     *
     * @return the value described by this {@code OptionalBoolean}
     * @throws NoSuchElementException if no value is present
     */
    public boolean getAsBoolean() throws NoSuchElementException {
        if (!isPresent) {
            throw new NoSuchElementException("No value present");
        }
        return b;
    }

    /**
     * Semantically equal to {@link #getAsBoolean()}
     * @return the value described by {@code this}
     * @throws NoSuchElementException if no value is present
     * @see #getAsBoolean()
     */
    public boolean getBoolean() throws NoSuchElementException {
        return getAsBoolean();
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
    public void ifPresent(PrimitiveConsumer.OfBoolean action) {
        if (isPresent) {
            action.acceptBoolean(b);
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
    public void ifPresentOrElse(PrimitiveConsumer.OfBoolean action, Runnable emptyAction) {
        if (isPresent) {
            action.acceptBoolean(b);
        } else {
            emptyAction.run();
        }
    }

    /**
     * If a value is present, returns a sequential {@link BooleanStream}
     * containing only that value, otherwise returns an empty
     * {@code BooleanStream}.
     *
     * @apiNote
     * This method can be used to transform a {@code Stream} of optional chars
     * to a {@code BooleanStream} of present chars:
     * <pre>{@code
     *     Stream<OptionalBoolean> os = ..
     *     BooleanStream b = flatMapToBoolean(os, OptionalBoolean::stream)
     * }</pre>
     *
     * @return the optional value as a {@code BooleanStream}
     */
    /*public BooleanStream stream() {
        if (isPresent) {
            return BooleanStream.of(b);
        } else {
            return BooleanStream.empty();
        }
    }*/

    /**
     * If a value is present, returns the value, otherwise returns
     * {@code other}.
     *
     * @param other the value to be returned, if no value is present
     * @return the value, if present, otherwise {@code other}
     */
    public boolean orElse(boolean other) {
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
    public boolean orElseGet(PrimitiveSupplier.ToBoolean supplier) {
        return isPresent ? b : supplier.getBoolean();
    }

    /**
     * If a value is present, returns the value, otherwise throws
     * {@code NoSuchElementException}.
     *
     * @return the value described by this {@code OptionalBoolean}
     * @throws NoSuchElementException if no value is present
     */
    public boolean orElseThrow() throws NoSuchElementException {
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
    public<X extends Throwable> boolean orElseThrow(Supplier<? extends X> exceptionSupplier) throws X {
        if (isPresent) {
            return b;
        } else {
            throw exceptionSupplier.get();
        }
    }

    /**
     * Indicates whether some other object is "equal to" this
     * {@code OptionalBoolean}. The other object is considered equal if:
     * <ul>
     * <li>it is also an {@code OptionalBoolean} and;
     * <li>both instances have no value present or;
     * <li>the present values are "equal to" each other via
     * {@code Boolean.compare() == 0}.
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

        return obj instanceof OptionalBoolean other
                && (isPresent && other.isPresent
                ? Boolean.compare(b, other.b) == 0
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
        return isPresent ? Boolean.hashCode(b) : 0;
    }

    /**
     * Returns a non-empty string representation of this {@code OptionalBoolean}
     * suitable for debugging.  The exact presentation format is unspecified and
     * may vary between implementations and versions.
     *
     * @implSpec
     * If a value is present the result must include its string representation
     * in the result.  Empty and present {@code OptionalBoolean} must be
     * unambiguously differentiable.
     *
     * @return the string representation of this instance
     */
    @Override
    public String toString() {
        return isPresent
                ? ("OptionalBoolean[" + b + "]")
                : "OptionalBoolean.empty";
    }

}
