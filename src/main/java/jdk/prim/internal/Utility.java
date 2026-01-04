package jdk.prim.internal;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Contains static methods for general utility methods
 */
public final class Utility {

    private static Unsafe US;
    private static Object IUS;

    /**
     * Gets an {@link sun.misc.Unsafe} object
     * @return a {@code sun.misc.Unsafe} object
     *
     * @throws RuntimeException with a simple message and a {@link java.util.NoSuchElementException}
     * or a {@link IllegalAccessException} object as the cause if {@link Unsafe#theUnsafe} retrieval fails
     */
    public static Unsafe getUnsafe() {
        if(US != null) return US;
        try {
            Field unsafe_field = Unsafe.class.getDeclaredField("theUnsafe");
            unsafe_field.setAccessible(true);
            US = (Unsafe) unsafe_field.get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException("Field signature mismatch", e);
        }
        return US;
    }
    /**
     * Gets an {@link jdk.internal.misc.Unsafe} object
     * @return a {@code jdk.internal.misc.Unsafe} object as a {@code java.lang.Object}
     *
     * @throws RuntimeException with a simple message and a {@link java.util.NoSuchElementException}
     * or a {@link IllegalAccessException} object as the cause if {@link Unsafe#theInternalUnsafe} retrieval fails
     */
    public static Object getInternalUnsafe() {
        if(IUS != null) return IUS;
        try {
            Field unsafe_field = Unsafe.class.getDeclaredField("theInternalUnsafe");
            unsafe_field.setAccessible(true);
            IUS = unsafe_field.get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException("Field signature mismatch", e);
        }
        return IUS;
    }

    /**
     * May not be instantiated
     * @throws InstantiationException When called
     */
    private Utility() throws InstantiationException {
        throw new InstantiationException("Cannot be instantiated");
    }
}
