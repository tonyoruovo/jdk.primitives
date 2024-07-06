package jdk.prim.util;

import java.util.NoSuchElementException;
import java.util.function.Supplier;

import jdk.prim.util.function.PrimitiveConsumer;
import jdk.prim.util.function.PrimitiveSupplier;

/**
 * A container object which may or may not contain a {@code char} value.
 * If a value is present, {@code isPresent()} returns {@code true}. If no
 * value is present, the object is considered <i>empty</i> and
 * {@code isPresent()} returns {@code false}.
 *
 * <p>Additional methods that depend on the presence or absence of a contained
 * value are provided, such as {@link #orElse(char) orElse()}
 * (returns a default value if no value is present) and
 * {@link #ifPresent(PrimitiveConsumer.OfChar) ifPresent()} (performs an
 * action if a value is present).
 *
 * @apiNote
 * {@code OptionalChar} is primarily intended for use as a method return type where
 * there is a clear need to represent "no result." A variable whose type is
 * {@code OptionalChar} should never itself be {@code null}; it should always point
 * to an {@code OptionalChar} instance.
 */
public final class OptionalChar {
    /**
     * Common instance for {@code empty()}.
     */
    private static final OptionalChar EMPTY = new OptionalChar();

    /**
     * If true then the value is present, otherwise indicates no value is present
     */
    private final boolean isPresent;
    /**The intrinsic value */
    private final char c;

    private OptionalChar() {
        isPresent = false;
        c = Character.valueOf((char) 0);
    }

    /**
     * Returns an empty {@code OptionalChar} instance.  No value is present
     * for this {@code OptionalChar}.
     *
     * @apiNote
     * Though it may be tempting to do so, avoid testing if an object is empty
     * by comparing with {@code ==} or {@code !=} against instances returned by
     * {@code OptionalChar.empty()}.  There is no guarantee that it is a singleton.
     * Instead, use {@link #isEmpty()} or {@link #isPresent()}.
     *
     *  @return an empty {@code OptionalChar}.
     */
    public static OptionalChar empty() {
        return EMPTY;
    }

    private OptionalChar(char c) {
        isPresent = true;
        this.c = c;
    }

    /**
     * Returns an {@code OptionalChar} describing the given value.
     *
     * @param value the value to describe
     * @return an {@code OptionalChar} with the value present
     */
    public static OptionalChar of(char value) {
        return new OptionalChar(value);
    }
    
    /**
     * If a value is present, returns the value, otherwise throws
     * {@code NoSuchElementException}.
     *
     * @apiNote
     * The preferred alternative to this method is {@link #orElseThrow()}.
     *
     * @return the value described by this {@code OptionalChar}
     * @throws NoSuchElementException if no value is present
     */
    public char getAsChar() throws NoSuchElementException {
        if (!isPresent) {
            throw new NoSuchElementException("No value present");
        }
        return c;
    }

    /**
     * Semantically equal to {@link #getAsChar()}
     * @return the value described by {@code this}
     * @throws NoSuchElementException if no value is present
     * @see #getAsChar()
     */
    public char getChar() throws NoSuchElementException {
        return getAsChar();
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
    public void ifPresent(PrimitiveConsumer.OfChar action) {
        if (isPresent) {
            action.acceptChar(c);
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
    public void ifPresentOrElse(PrimitiveConsumer.OfChar action, Runnable emptyAction) {
        if (isPresent) {
            action.acceptChar(c);
        } else {
            emptyAction.run();
        }
    }

    /**
     * If a value is present, returns a sequential {@link CharStream}
     * containing only that value, otherwise returns an empty
     * {@code CharStream}.
     *
     * @apiNote
     * This method can be used to transform a {@code Stream} of optional chars
     * to a {@code CharStream} of present chars:
     * <pre>{@code
     *     Stream<OptionalChar> os = ..
     *     CharStream s = flatMapToChar(os, OptionalChar::stream)
     * }</pre>
     *
     * @return the optional value as a {@code CharStream}
     */
    /*public CharStream stream() {
        if (isPresent) {
            return CharStream.of(c);
        } else {
            return CharStream.empty();
        }
    }*/

    /**
     * If a value is present, returns the value, otherwise returns
     * {@code other}.
     *
     * @param other the value to be returned, if no value is present
     * @return the value, if present, otherwise {@code other}
     */
    public char orElse(char other) {
        return isPresent ? c : other;
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
    public char orElseGet(PrimitiveSupplier.ToChar supplier) {
        return isPresent ? c : supplier.getChar();
    }

    /**
     * If a value is present, returns the value, otherwise throws
     * {@code NoSuchElementException}.
     *
     * @return the value described by this {@code OptionalChar}
     * @throws NoSuchElementException if no value is present
     */
    public char orElseThrow() throws NoSuchElementException {
        if (!isPresent) {
            throw new NoSuchElementException("No value present");
        }
        return c;
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
    public<X extends Throwable> char orElseThrow(Supplier<? extends X> exceptionSupplier) throws X {
        if (isPresent) {
            return c;
        } else {
            throw exceptionSupplier.get();
        }
    }

    /**
     * Indicates whether some other object is "equal to" this
     * {@code OptionalChar}. The other object is considered equal if:
     * <ul>
     * <li>it is also an {@code OptionalChar} and;
     * <li>both instances have no value present or;
     * <li>the present values are "equal to" each other via
     * {@code Character.compare() == 0}.
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

        return obj instanceof OptionalChar other
                && (isPresent && other.isPresent
                ? Character.compare(c, other.c) == 0
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
        return isPresent ? Character.hashCode(c) : 0;
    }

    /**
     * Returns a non-empty string representation of this {@code OptionalChar}
     * suitable for debugging.  The exact presentation format is unspecified and
     * may vary between implementations and versions.
     *
     * @implSpec
     * If a value is present the result must include its string representation
     * in the result.  Empty and present {@code OptionalChar}s must be
     * unambiguously differentiable.
     *
     * @return the string representation of this instance
     */
    @Override
    public String toString() {
        return isPresent
                ? ("OptionalChar[" + c + "]")
                : "OptionalChar.empty";
    }

}
