package jdk.prim.util;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Utility class to provide support for general utility
 * operations on arrays. Unless otherwise stated, all
 * implemented operations uses naive brute force algorithms.
 * <p>
 * Passing {@code null} to any of the methods here will result in a runtime
 * {@link NullPointerException}
 */
public final class PrimitiveArrays {
    /** Uninstatiable */
    private PrimitiveArrays() {
    }

    /**
     * Sequentially traverses the given array to search whether
     * all elements contained within matches the given predicate.
     * 
     * @param <T>     the type of array to be traversed, whose elements the predicate
     *                will be applied to
     * @param array   the array to be searched
     * @param matcher the predicate to be applied to each element of the given array
     * @return {@code true} if all elements of the given array matches the supplied
     *         predicate else returns {@code false}.
     *         <p>
     *         Note that if the array is empty, then {@code false} will be returned
     *         regardless
     */
    public static <T> boolean allMatch(T[] array, Predicate<? super T> matcher) {
        for (int i = 0; i < array.length; i++) {
            T e = array[i];
            if (!matcher.test(e))
                return false;
        }
        return array.length != 0;
    }

    /**
     * Sequentially traverses the given array to search whether
     * all elements contained within matches the given predicate.
     * 
     * @param array   the array to be searched
     * @param matcher the predicate to be applied to each element of the given array
     * @return {@code true} if all elements of the given array matches the supplied
     *         predicate else returns {@code false}.
     *         <p>
     *         Note that if the array is empty, then {@code false} will be returned
     *         regardless
     */
    public static boolean allMatch(double[] array, jdk.prim.util.function.PrimitivePredicate.OfDouble matcher) {
        for (int i = 0; i < array.length; i++) {
            double e = array[i];
            if (!matcher.testDouble(e))
                return false;
        }
        return array.length != 0;
    }

    /**
     * Sequentially traverses the given array to search whether
     * all elements contained within matches the given predicate.
     * 
     * @param array   the array to be searched
     * @param matcher the predicate to be applied to each element of the given array
     * @return {@code true} if all elements of the given array matches the supplied
     *         predicate else returns {@code false}.
     *         <p>
     *         Note that if the array is empty, then {@code false} will be returned
     *         regardless
     */
    public static boolean allMatch(long[] array, jdk.prim.util.function.PrimitivePredicate.OfLong matcher) {
        for (int i = 0; i < array.length; i++) {
            long e = array[i];
            if (!matcher.testLong(e))
                return false;
        }
        return array.length != 0;
    }

    /**
     * Sequentially traverses the given array to search whether
     * all elements contained within matches the given predicate.
     * 
     * @param array   the array to be searched
     * @param matcher the predicate to be applied to each element of the given array
     * @return {@code true} if all elements of the given array matches the supplied
     *         predicate else returns {@code false}.
     *         <p>
     *         Note that if the array is empty, then {@code false} will be returned
     *         regardless
     */
    public static boolean allMatch(int[] array, jdk.prim.util.function.PrimitivePredicate.OfInt matcher) {
        for (int i = 0; i < array.length; i++) {
            int e = array[i];
            if (!matcher.testInt(e))
                return false;
        }
        return array.length != 0;
    }

    /**
     * Sequentially traverses the given array to search whether
     * all elements contained within matches the given predicate.
     * 
     * @param array   the array to be searched
     * @param matcher the predicate to be applied to each element of the given array
     * @return {@code true} if all elements of the given array matches the supplied
     *         predicate else returns {@code false}.
     *         <p>
     *         Note that if the array is empty, then {@code false} will be returned
     *         regardless
     */
    public static boolean allMatch(float[] array, jdk.prim.util.function.PrimitivePredicate.OfFloat matcher) {
        for (int i = 0; i < array.length; i++) {
            float e = array[i];
            if (!matcher.testFloat(e))
                return false;
        }
        return array.length != 0;
    }

    /**
     * Sequentially traverses the given array to search whether
     * all elements contained within matches the given predicate.
     * 
     * @param array   the array to be searched
     * @param matcher the predicate to be applied to each element of the given array
     * @return {@code true} if all elements of the given array matches the supplied
     *         predicate else returns {@code false}.
     *         <p>
     *         Note that if the array is empty, then {@code false} will be returned
     *         regardless
     */
    public static boolean allMatch(char[] array, jdk.prim.util.function.PrimitivePredicate.OfChar matcher) {
        for (int i = 0; i < array.length; i++) {
            char e = array[i];
            if (!matcher.testChar(e))
                return false;
        }
        return array.length != 0;
    }

    /**
     * Sequentially traverses the given array to search whether
     * all elements contained within matches the given predicate.
     * 
     * @param array   the array to be searched
     * @param matcher the predicate to be applied to each element of the given array
     * @return {@code true} if all elements of the given array matches the supplied
     *         predicate else returns {@code false}.
     *         <p>
     *         Note that if the array is empty, then {@code false} will be returned
     *         regardless
     */
    public static boolean allMatch(short[] array, jdk.prim.util.function.PrimitivePredicate.OfShort matcher) {
        for (int i = 0; i < array.length; i++) {
            short e = array[i];
            if (!matcher.testShort(e))
                return false;
        }
        return array.length != 0;
    }

    /**
     * Sequentially traverses the given array to search whether
     * all elements contained within matches the given predicate.
     * 
     * @param array   the array to be searched
     * @param matcher the predicate to be applied to each element of the given array
     * @return {@code true} if all elements of the given array matches the supplied
     *         predicate else returns {@code false}.
     *         <p>
     *         Note that if the array is empty, then {@code false} will be returned
     *         regardless
     */
    public static boolean allMatch(byte[] array, jdk.prim.util.function.PrimitivePredicate.OfByte matcher) {
        for (int i = 0; i < array.length; i++) {
            byte e = array[i];
            if (!matcher.testByte(e))
                return false;
        }
        return array.length != 0;
    }

    /**
     * Sequentially traverses the given array to search whether
     * all elements contained within matches the given predicate.
     * 
     * @param array   the array to be searched
     * @param matcher the predicate to be applied to each element of the given array
     * @return {@code true} if all elements of the given array matches the supplied
     *         predicate else returns {@code false}.
     *         <p>
     *         Note that if the array is empty, then {@code false} will be returned
     *         regardless
     */
    public static boolean allMatch(boolean[] array, jdk.prim.util.function.PrimitivePredicate.OfBoolean matcher) {
        for (int i = 0; i < array.length; i++) {
            boolean e = array[i];
            if (!matcher.testBoolean(e))
                return false;
        }
        return array.length != 0;
    }

    /**
     * Sequentially traverses the given array to search whether
     * any element contained within matches the given predicate.
     * 
     * @param <T>     the type of array to be traversed, whose elements the predicate
     *                will be applied to
     * @param array   the array to be searched
     * @param matcher the predicate to be applied to the elements of the given array
     * @return {@code true} if any element of the given array matches the supplied
     *         predicate else returns {@code false}.
     *         <p>
     *         Note that if the array is empty, then {@code false} will be returned
     *         regardless
     */
    public static <T> boolean anyMatch(T[] array, Predicate<? super T> matcher) {
        for (int i = 0; i < array.length; i++) {
            T e = array[i];
            if (matcher.test(e))
                return true;
        }
        return false;
    }

    /**
     * Sequentially traverses the given array to search whether
     * any element contained within matches the given predicate.
     * 
     * @param array   the array to be searched
     * @param matcher the predicate to be applied to the elements of the given array
     * @return {@code true} if any element of the given array matches the supplied
     *         predicate else returns {@code false}.
     *         <p>
     *         Note that if the array is empty, then {@code false} will be returned
     *         regardless
     */
    public static boolean anyMatch(double[] array, jdk.prim.util.function.PrimitivePredicate.OfDouble matcher) {
        for (int i = 0; i < array.length; i++) {
            double e = array[i];
            if (matcher.testDouble(e))
                return true;
        }
        return false;
    }

    /**
     * Sequentially traverses the given array to search whether
     * any element contained within matches the given predicate.
     * 
     * @param array   the array to be searched
     * @param matcher the predicate to be applied to the elements of the given array
     * @return {@code true} if any element of the given array matches the supplied
     *         predicate else returns {@code false}.
     *         <p>
     *         Note that if the array is empty, then {@code false} will be returned
     *         regardless
     */
    public static boolean anyMatch(long[] array, jdk.prim.util.function.PrimitivePredicate.OfLong matcher) {
        for (int i = 0; i < array.length; i++) {
            long e = array[i];
            if (matcher.testLong(e))
                return true;
        }
        return false;
    }

    /**
     * Sequentially traverses the given array to search whether
     * any element contained within matches the given predicate.
     * 
     * @param array   the array to be searched
     * @param matcher the predicate to be applied to the elements of the given array
     * @return {@code true} if any element of the given array matches the supplied
     *         predicate else returns {@code false}.
     *         <p>
     *         Note that if the array is empty, then {@code false} will be returned
     *         regardless
     */
    public static boolean anyMatch(int[] array, jdk.prim.util.function.PrimitivePredicate.OfInt matcher) {
        for (int i = 0; i < array.length; i++) {
            int e = array[i];
            if (matcher.testInt(e))
                return true;
        }
        return false;
    }

    /**
     * Sequentially traverses the given array to search whether
     * any element contained within matches the given predicate.
     * 
     * @param array   the array to be searched
     * @param matcher the predicate to be applied to the elements of the given array
     * @return {@code true} if any element of the given array matches the supplied
     *         predicate else returns {@code false}.
     *         <p>
     *         Note that if the array is empty, then {@code false} will be returned
     *         regardless
     */
    public static boolean anyMatch(float[] array, jdk.prim.util.function.PrimitivePredicate.OfFloat matcher) {
        for (int i = 0; i < array.length; i++) {
            float e = array[i];
            if (matcher.testFloat(e))
                return true;
        }
        return false;
    }

    /**
     * Sequentially traverses the given array to search whether
     * any element contained within matches the given predicate.
     * 
     * @param array   the array to be searched
     * @param matcher the predicate to be applied to the elements of the given array
     * @return {@code true} if any element of the given array matches the supplied
     *         predicate else returns {@code false}.
     *         <p>
     *         Note that if the array is empty, then {@code false} will be returned
     *         regardless
     */
    public static boolean anyMatch(char[] array, jdk.prim.util.function.PrimitivePredicate.OfChar matcher) {
        for (int i = 0; i < array.length; i++) {
            char e = array[i];
            if (matcher.testChar(e))
                return true;
        }
        return false;
    }

    /**
     * Sequentially traverses the given array to search whether
     * any element contained within matches the given predicate.
     * 
     * @param array   the array to be searched
     * @param matcher the predicate to be applied to the elements of the given array
     * @return {@code true} if any element of the given array matches the supplied
     *         predicate else returns {@code false}.
     *         <p>
     *         Note that if the array is empty, then {@code false} will be returned
     *         regardless
     */
    public static boolean anyMatch(short[] array, jdk.prim.util.function.PrimitivePredicate.OfShort matcher) {
        for (int i = 0; i < array.length; i++) {
            short e = array[i];
            if (matcher.testShort(e))
                return true;
        }
        return false;
    }

    /**
     * Sequentially traverses the given array to search whether
     * any element contained within matches the given predicate.
     * 
     * @param array   the array to be searched
     * @param matcher the predicate to be applied to the elements of the given array
     * @return {@code true} if any element of the given array matches the supplied
     *         predicate else returns {@code false}.
     *         <p>
     *         Note that if the array is empty, then {@code false} will be returned
     *         regardless
     */
    public static boolean anyMatch(byte[] array, jdk.prim.util.function.PrimitivePredicate.OfByte matcher) {
        for (int i = 0; i < array.length; i++) {
            byte e = array[i];
            if (matcher.testByte(e))
                return true;
        }
        return false;
    }

    /**
     * Sequentially traverses the given array to search whether
     * any element contained within matches the given predicate.
     * 
     * @param array   the array to be searched
     * @param matcher the predicate to be applied to the elements of the given array
     * @return {@code true} if any element of the given array matches the supplied
     *         predicate else returns {@code false}.
     *         <p>
     *         Note that if the array is empty, then {@code false} will be returned
     *         regardless
     */
    public static boolean anyMatch(boolean[] array, jdk.prim.util.function.PrimitivePredicate.OfBoolean matcher) {
        for (int i = 0; i < array.length; i++) {
            boolean e = array[i];
            if (matcher.testBoolean(e))
                return true;
        }
        return false;
    }

    /**
     * Sequentially traverses the given array to search whether
     * all elements contained within mismatches the given predicate.
     * 
     * @param <T>     the type of array to be traversed, whose elements the predicate
     *                will be applied to
     * @param array   the array to be searched
     * @param matcher the predicate to be applied to the elements of the given array
     * @return {@code true} if all elements of the given array mismatches the
     *         supplied
     *         predicate else returns {@code false}.
     *         <p>
     *         Note that if the array is empty, then {@code true} will be returned
     *         regardless
     */
    public static <T> boolean noneMatch(T[] array, Predicate<? super T> matcher) {
        for (int i = 0; i < array.length; i++) {
            T e = array[i];
            if (matcher.test(e))
                return false;
        }
        return true;
    }

    /**
     * Sequentially traverses the given array to search whether
     * all elements contained within mismatches the given predicate.
     * 
     * @param <T>     the type of array to be traversed, whose elements the predicate
     *                will be applied to
     * @param array   the array to be searched
     * @param matcher the predicate to be applied to the elements of the given array
     * @return {@code true} if all elements of the given array mismatches the
     *         supplied
     *         predicate else returns {@code false}.
     *         <p>
     *         Note that if the array is empty, then {@code true} will be returned
     *         regardless
     */
    public static boolean noneMatch(double[] array, jdk.prim.util.function.PrimitivePredicate.OfDouble matcher) {
        for (int i = 0; i < array.length; i++) {
            double e = array[i];
            if (matcher.testDouble(e))
                return false;
        }
        return true;
    }

    /**
     * Sequentially traverses the given array to search whether
     * all elements contained within mismatches the given predicate.
     * 
     * @param <T>     the type of array to be traversed, whose elements the predicate
     *                will be applied to
     * @param array   the array to be searched
     * @param matcher the predicate to be applied to the elements of the given array
     * @return {@code true} if all elements of the given array mismatches the
     *         supplied
     *         predicate else returns {@code false}.
     *         <p>
     *         Note that if the array is empty, then {@code true} will be returned
     *         regardless
     */
    public static boolean noneMatch(long[] array, jdk.prim.util.function.PrimitivePredicate.OfLong matcher) {
        for (int i = 0; i < array.length; i++) {
            long e = array[i];
            if (matcher.testLong(e))
                return false;
        }
        return true;
    }

    /**
     * Sequentially traverses the given array to search whether
     * all elements contained within mismatches the given predicate.
     * 
     * @param <T>     the type of array to be traversed, whose elements the predicate
     *                will be applied to
     * @param array   the array to be searched
     * @param matcher the predicate to be applied to the elements of the given array
     * @return {@code true} if all elements of the given array mismatches the
     *         supplied
     *         predicate else returns {@code false}.
     *         <p>
     *         Note that if the array is empty, then {@code true} will be returned
     *         regardless
     */
    public static boolean noneMatch(int[] array, jdk.prim.util.function.PrimitivePredicate.OfInt matcher) {
        for (int i = 0; i < array.length; i++) {
            int e = array[i];
            if (matcher.testInt(e))
                return false;
        }
        return true;
    }

    /**
     * Sequentially traverses the given array to search whether
     * all elements contained within mismatches the given predicate.
     * 
     * @param <T>     the type of array to be traversed, whose elements the predicate
     *                will be applied to
     * @param array   the array to be searched
     * @param matcher the predicate to be applied to the elements of the given array
     * @return {@code true} if all elements of the given array mismatches the
     *         supplied
     *         predicate else returns {@code false}.
     *         <p>
     *         Note that if the array is empty, then {@code true} will be returned
     *         regardless
     */
    public static boolean noneMatch(float[] array, jdk.prim.util.function.PrimitivePredicate.OfFloat matcher) {
        for (int i = 0; i < array.length; i++) {
            float e = array[i];
            if (matcher.testFloat(e))
                return false;
        }
        return true;
    }

    /**
     * Sequentially traverses the given array to search whether
     * all elements contained within mismatches the given predicate.
     * 
     * @param <T>     the type of array to be traversed, whose elements the predicate
     *                will be applied to
     * @param array   the array to be searched
     * @param matcher the predicate to be applied to the elements of the given array
     * @return {@code true} if all elements of the given array mismatches the
     *         supplied
     *         predicate else returns {@code false}.
     *         <p>
     *         Note that if the array is empty, then {@code true} will be returned
     *         regardless
     */
    public static boolean noneMatch(char[] array, jdk.prim.util.function.PrimitivePredicate.OfChar matcher) {
        for (int i = 0; i < array.length; i++) {
            char e = array[i];
            if (matcher.testChar(e))
                return false;
        }
        return true;
    }

    /**
     * Sequentially traverses the given array to search whether
     * all elements contained within mismatches the given predicate.
     * 
     * @param <T>     the type of array to be traversed, whose elements the predicate
     *                will be applied to
     * @param array   the array to be searched
     * @param matcher the predicate to be applied to the elements of the given array
     * @return {@code true} if all elements of the given array mismatches the
     *         supplied
     *         predicate else returns {@code false}.
     *         <p>
     *         Note that if the array is empty, then {@code true} will be returned
     *         regardless
     */
    public static boolean noneMatch(short[] array, jdk.prim.util.function.PrimitivePredicate.OfShort matcher) {
        for (int i = 0; i < array.length; i++) {
            short e = array[i];
            if (matcher.testShort(e))
                return false;
        }
        return true;
    }

    /**
     * Sequentially traverses the given array to search whether
     * all elements contained within mismatches the given predicate.
     * 
     * @param <T>     the type of array to be traversed, whose elements the predicate
     *                will be applied to
     * @param array   the array to be searched
     * @param matcher the predicate to be applied to the elements of the given array
     * @return {@code true} if all elements of the given array mismatches the
     *         supplied
     *         predicate else returns {@code false}.
     *         <p>
     *         Note that if the array is empty, then {@code true} will be returned
     *         regardless
     */
    public static boolean noneMatch(byte[] array, jdk.prim.util.function.PrimitivePredicate.OfByte matcher) {
        for (int i = 0; i < array.length; i++) {
            byte e = array[i];
            if (matcher.testByte(e))
                return false;
        }
        return true;
    }

    /**
     * Sequentially traverses the given array to search whether
     * all elements contained within mismatches the given predicate.
     * 
     * @param <T>     the type of array to be traversed, whose elements the predicate
     *                will be applied to
     * @param array   the array to be searched
     * @param matcher the predicate to be applied to the elements of the given array
     * @return {@code true} if all elements of the given array mismatches the
     *         supplied
     *         predicate else returns {@code false}.
     *         <p>
     *         Note that if the array is empty, then {@code true} will be returned
     *         regardless
     */
    public static boolean noneMatch(boolean[] array, jdk.prim.util.function.PrimitivePredicate.OfBoolean matcher) {
        for (int i = 0; i < array.length; i++) {
            boolean e = array[i];
            if (matcher.testBoolean(e))
                return false;
        }
        return true;
    }

    /**
     * Filters the given array, returning only the elements that match the given
     * predicate.
     * <p>
     * Programmers should endeavour to cover {@code null} element cases
     * 
     * @param <T>     the type of the array to be filtered
     * @param array   the array to be filtered
     * @param matcher the predicate to be used for the filtering
     * @return a new array of the same type as the input whereby all
     *         elements matches the supplied predicate, i.e the return array
     *         contains
     *         as many elements from the source array as matches the given
     *         predicate.
     *         <p>
     *         Note that an empty array argument will cause an empty array to be
     *         returned.
     */
    public static <T> T[] filter(T[] array, Predicate<? super T> matcher) {
        @SuppressWarnings("unchecked")
        T[] filtered = (T[]) new Object[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            T e = array[i];
            if (matcher.test(e))
                filtered[index++] = e;
        }
        System.arraycopy(filtered, 0, filtered, 0, index);
        return filtered;
    }

    /**
     * Filters the given array, returning only the elements that match the given
     * predicate.
     * 
     * @param array   the array to be filtered
     * @param matcher the predicate to be used for the filtering
     * @return a new {@code double} array whereby all
     *         elements matches the supplied predicate, i.e the return array
     *         contains
     *         as many elements from the source array as matches the given
     *         predicate.
     *         <p>
     *         Note that an empty array argument will cause an empty array to be
     *         returned.
     */
    public static double[] filter(double[] array, jdk.prim.util.function.PrimitivePredicate.OfDouble matcher) {
        double[] filtered = new double[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            double e = array[i];
            if (matcher.testDouble(e))
                filtered[index++] = e;
        }
        System.arraycopy(filtered, 0, filtered, 0, index);
        return filtered;
    }

    /**
     * Filters the given array, returning only the elements that match the given
     * predicate.
     * 
     * @param array   the array to be filtered
     * @param matcher the predicate to be used for the filtering
     * @return a new {@code long} array whereby all
     *         elements matches the supplied predicate, i.e the return array
     *         contains
     *         as many elements from the source array as matches the given
     *         predicate.
     *         <p>
     *         Note that an empty array argument will cause an empty array to be
     *         returned.
     */
    public static long[] filter(long[] array, jdk.prim.util.function.PrimitivePredicate.OfLong matcher) {
        long[] filtered = new long[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            long e = array[i];
            if (matcher.testLong(e))
                filtered[index++] = e;
        }
        System.arraycopy(filtered, 0, filtered, 0, index);
        return filtered;
    }

    /**
     * Filters the given array, returning only the elements that match the given
     * predicate.
     * 
     * @param array   the array to be filtered
     * @param matcher the predicate to be used for the filtering
     * @return a new {@code int} array whereby all
     *         elements matches the supplied predicate, i.e the return array
     *         contains
     *         as many elements from the source array as matches the given
     *         predicate.
     *         <p>
     *         Note that an empty array argument will cause an empty array to be
     *         returned.
     */
    public static int[] filter(int[] array, jdk.prim.util.function.PrimitivePredicate.OfInt matcher) {
        int[] filtered = new int[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            int e = array[i];
            if (matcher.testInt(e))
                filtered[index++] = e;
        }
        System.arraycopy(filtered, 0, filtered, 0, index);
        return filtered;
    }

    /**
     * Filters the given array, returning only the elements that match the given
     * predicate.
     * 
     * @param array   the array to be filtered
     * @param matcher the predicate to be used for the filtering
     * @return a new {@code float} array whereby all
     *         elements matches the supplied predicate, i.e the return array
     *         contains
     *         as many elements from the source array as matches the given
     *         predicate.
     *         <p>
     *         Note that an empty array argument will cause an empty array to be
     *         returned.
     */
    public static float[] filter(float[] array, jdk.prim.util.function.PrimitivePredicate.OfFloat matcher) {
        float[] filtered = new float[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            float e = array[i];
            if (matcher.testFloat(e))
                filtered[index++] = e;
        }
        System.arraycopy(filtered, 0, filtered, 0, index);
        return filtered;
    }

    /**
     * Filters the given array, returning only the elements that match the given
     * predicate.
     * 
     * @param array   the array to be filtered
     * @param matcher the predicate to be used for the filtering
     * @return a new {@code char} array whereby all
     *         elements matches the supplied predicate, i.e the return array
     *         contains
     *         as many elements from the source array as matches the given
     *         predicate.
     *         <p>
     *         Note that an empty array argument will cause an empty array to be
     *         returned.
     */
    public static char[] filter(char[] array, jdk.prim.util.function.PrimitivePredicate.OfChar matcher) {
        char[] filtered = new char[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            char e = array[i];
            if (matcher.testChar(e))
                filtered[index++] = e;
        }
        System.arraycopy(filtered, 0, filtered, 0, index);
        return filtered;
    }

    /**
     * Filters the given array, returning only the elements that match the given
     * predicate.
     * 
     * @param array   the array to be filtered
     * @param matcher the predicate to be used for the filtering
     * @return a new {@code short} array whereby all
     *         elements matches the supplied predicate, i.e the return array
     *         contains
     *         as many elements from the source array as matches the given
     *         predicate.
     *         <p>
     *         Note that an empty array argument will cause an empty array to be
     *         returned.
     */
    public static short[] filter(short[] array, jdk.prim.util.function.PrimitivePredicate.OfShort matcher) {
        short[] filtered = new short[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            short e = array[i];
            if (matcher.testShort(e))
                filtered[index++] = e;
        }
        System.arraycopy(filtered, 0, filtered, 0, index);
        return filtered;
    }

    /**
     * Filters the given array, returning only the elements that match the given
     * predicate.
     * 
     * @param array   the array to be filtered
     * @param matcher the predicate to be used for the filtering
     * @return a new {@code byte} array whereby all
     *         elements matches the supplied predicate, i.e the return array
     *         contains
     *         as many elements from the source array as matches the given
     *         predicate.
     *         <p>
     *         Note that an empty array argument will cause an empty array to be
     *         returned.
     */
    public static byte[] filter(byte[] array, jdk.prim.util.function.PrimitivePredicate.OfByte matcher) {
        byte[] filtered = new byte[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            byte e = array[i];
            if (matcher.testByte(e))
                filtered[index++] = e;
        }
        System.arraycopy(filtered, 0, filtered, 0, index);
        return filtered;
    }

    /**
     * Filters the given array, returning only the elements that match the given
     * predicate.
     * 
     * @param array   the array to be filtered
     * @param matcher the predicate to be used for the filtering
     * @return a new {@code boolean} array whereby all
     *         elements matches the supplied predicate, i.e the return array
     *         contains
     *         as many elements from the source array as matches the given
     *         predicate.
     *         <p>
     *         Note that an empty array argument will cause an empty array to be
     *         returned.
     */
    public static boolean[] filter(boolean[] array, jdk.prim.util.function.PrimitivePredicate.OfBoolean matcher) {
        boolean[] filtered = new boolean[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            boolean e = array[i];
            if (matcher.testBoolean(e))
                filtered[index++] = e;
        }
        System.arraycopy(filtered, 0, filtered, 0, index);
        return filtered;
    }

    /**
     * Traverse the input array and then computes and returns an array consisting of
     * elements
     * whose {@link Object#equals(Object) equals} always returns {@code false}.
     * 
     * @param <T>   the type of the input array
     * @param array the input array
     * @return a new array whose elements are perculiar according to
     *         {@link Object#equals(Object)}.
     *         <p>
     *         An empty array is returned if the input is empty
     */
    public static <T> T[] unique(T[] array) {
        @SuppressWarnings("unchecked")
        T[] distinct = (T[]) new Object[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            T e = array[i];
            if (anyMatch(distinct, x -> (x != null ? x.equals(e) : (x == null && e == null))))
                continue;
            else
                distinct[index++] = e;
        }
        System.arraycopy(distinct, 0, distinct, 0, index);
        return distinct;
    }

    /**
     * Traverse the input array and then computes and returns a new array consisting
     * of elements
     * where {@code element1 == element2} is always {@code false}.
     * 
     * @param array the input array
     * @return a new array whose elements are perculiar according to {@code ==}.
     *         <p>
     *         An empty array is returned if the input is empty
     */
    public static double[] unique(double[] array) {
        double[] distinct = new double[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            double e = array[i];
            if (anyMatch(distinct, x -> x == e))
                continue;
            else
                distinct[index++] = e;
        }
        System.arraycopy(distinct, 0, distinct, 0, index);
        return distinct;
    }

    /**
     * Traverse the input array and then computes and returns a new array consisting
     * of elements
     * where {@code element1 == element2} is always {@code false}.
     * 
     * @param array the input array
     * @return a new array whose elements are perculiar according to {@code ==}.
     *         <p>
     *         An empty array is returned if the input is empty
     */
    public static long[] unique(long[] array) {
        long[] distinct = new long[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            long e = array[i];
            if (anyMatch(distinct, x -> x == e))
                continue;
            else
                distinct[index++] = e;
        }
        System.arraycopy(distinct, 0, distinct, 0, index);
        return distinct;
    }

    /**
     * Traverse the input array and then computes and returns a new array consisting
     * of elements
     * where {@code element1 == element2} is always {@code false}.
     * 
     * @param array the input array
     * @return a new array whose elements are perculiar according to {@code ==}.
     *         <p>
     *         An empty array is returned if the input is empty
     */
    public static int[] unique(int[] array) {
        int[] distinct = new int[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            int e = array[i];
            if (anyMatch(distinct, x -> x == e))
                continue;
            else
                distinct[index++] = e;
        }
        System.arraycopy(distinct, 0, distinct, 0, index);
        return distinct;
    }

    /**
     * Traverse the input array and then computes and returns a new array consisting
     * of elements
     * where {@code element1 == element2} is always {@code false}.
     * 
     * @param array the input array
     * @return a new array whose elements are perculiar according to {@code ==}.
     *         <p>
     *         An empty array is returned if the input is empty
     */
    public static float[] unique(float[] array) {
        float[] distinct = new float[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            float e = array[i];
            if (anyMatch(distinct, x -> x == e))
                continue;
            else
                distinct[index++] = e;
        }
        System.arraycopy(distinct, 0, distinct, 0, index);
        return distinct;
    }

    /**
     * Traverse the input array and then computes and returns a new array consisting
     * of elements
     * where {@code element1 == element2} is always {@code false}.
     * 
     * @param array the input array
     * @return a new array whose elements are perculiar according to {@code ==}.
     *         <p>
     *         An empty array is returned if the input is empty
     */
    public static char[] unique(char[] array) {
        char[] distinct = new char[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            char e = array[i];
            if (anyMatch(distinct, x -> x == e))
                continue;
            else
                distinct[index++] = e;
        }
        System.arraycopy(distinct, 0, distinct, 0, index);
        return distinct;
    }

    /**
     * Traverse the input array and then computes and returns a new array consisting
     * of elements
     * where {@code element1 == element2} is always {@code false}.
     * 
     * @param array the input array
     * @return a new array whose elements are perculiar according to {@code ==}.
     *         <p>
     *         An empty array is returned if the input is empty
     */
    public static short[] unique(short[] array) {
        short[] distinct = new short[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            short e = array[i];
            if (anyMatch(distinct, x -> x == e))
                continue;
            else
                distinct[index++] = e;
        }
        System.arraycopy(distinct, 0, distinct, 0, index);
        return distinct;
    }

    /**
     * Traverse the input array and then computes and returns a new array consisting
     * of elements
     * where {@code element1 == element2} is always {@code false}.
     * 
     * @param array the input array
     * @return a new array whose elements are perculiar according to {@code ==}.
     *         <p>
     *         An empty array is returned if the input is empty
     */
    public static byte[] unique(byte[] array) {
        byte[] distinct = new byte[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            byte e = array[i];
            if (anyMatch(distinct, x -> x == e))
                continue;
            else
                distinct[index++] = e;
        }
        System.arraycopy(distinct, 0, distinct, 0, index);
        return distinct;
    }

    /**
     * Traverse the input array and then computes and returns a new array consisting
     * of elements
     * where {@code element1 == element2} is always {@code false}.
     * 
     * @param array the input array
     * @return a new array whose elements are perculiar according to {@code ==}.
     *         <p>
     *         An empty array is returned if the input is empty
     */
    public static boolean[] unique(boolean[] array) {
        boolean[] distinct = new boolean[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            boolean e = array[i];
            if (anyMatch(distinct, x -> x == e))
                continue;
            else
                distinct[index++] = e;
        }
        System.arraycopy(distinct, 0, distinct, 0, index);
        return distinct;
    }

    /**
     * Utility method to convert the elements of the input array from {@code <T>} to
     * {@code <U>} preserving
     * the encounter order.
     * 
     * @param <T>    the type of the input array
     * @param <U>    the type of the output array
     * @param array  the input array
     * @param mapper a mapping function which requires a value of type {@code <T>}
     *               and return a value of type {@code <U>}.
     * @return a new array generated by mapping the result of applying the given
     *         function to
     *         each element from the input array to the output array.
     *         <p>
     *         Note that the returned array is the same length as the input
     */
    public static <T, U> U[] map(T[] array, Function<? super T, ? extends U> mapper) {
        @SuppressWarnings("unchecked")
        U[] u = (U[]) new Object[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            T e = array[i];
            u[index++] = mapper.apply(e);
        }
        return u;
    }

    /**
     * Utility method to convert the elements of the input array from {@code double}
     * to {@code <T>} preserving
     * the encounter order.
     * 
     * @param <T>    the type of the output array
     * @param array  the input array
     * @param mapper a mapping function which requires a {@code double} value
     *               and has a return value of type {@code <T>}.
     * @return a new array generated by mapping the result of applying the given
     *         function to
     *         each element from the input array to the output array.
     *         <p>
     *         Note that the returned array is the same length as the input
     */
    public static <T> T[] map(double[] array, jdk.prim.util.function.PrimitiveFunction.OfDouble<T> mapper) {
        @SuppressWarnings("unchecked")
        T[] mapped = (T[]) new Object[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            double e = array[i];
            mapped[index++] = mapper.apply(e);
        }
        return mapped;
    }

    /**
     * Utility method to convert the elements of the input array from {@code long}
     * to {@code <T>} preserving
     * the encounter order.
     * 
     * @param <T>    the type of the output array
     * @param array  the input array
     * @param mapper a mapping function which requires a {@code long} value
     *               and has a return value of type {@code <T>}.
     * @return a new array generated by mapping the result of applying the given
     *         function to
     *         each element from the input array to the output array.
     *         <p>
     *         Note that the returned array is the same length as the input
     */
    public static <T> T[] map(long[] array, jdk.prim.util.function.PrimitiveFunction.OfLong<T> mapper) {
        @SuppressWarnings("unchecked")
        T[] mapped = (T[]) new Object[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            long e = array[i];
            mapped[index++] = mapper.apply(e);
        }
        return mapped;
    }

    /**
     * Utility method to convert the elements of the input array from {@code int} to
     * {@code <T>} preserving
     * the encounter order.
     * 
     * @param <T>    the type of the output array
     * @param array  the input array
     * @param mapper a mapping function which requires a {@code int} value
     *               and has a return value of type {@code <T>}.
     * @return a new array generated by mapping the result of applying the given
     *         function to
     *         each element from the input array to the output array.
     *         <p>
     *         Note that the returned array is the same length as the input
     */
    public static <T> T[] map(int[] array, jdk.prim.util.function.PrimitiveFunction.OfInt<T> mapper) {
        @SuppressWarnings("unchecked")
        T[] mapped = (T[]) new Object[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            int e = array[i];
            mapped[index++] = mapper.apply(e);
        }
        return mapped;
    }

    /**
     * Utility method to convert the elements of the input array from {@code float}
     * to {@code <T>} preserving
     * the encounter order.
     * 
     * @param <T>    the type of the output array
     * @param array  the input array
     * @param mapper a mapping function which requires a {@code float} value
     *               and has a return value of type {@code <T>}.
     * @return a new array generated by mapping the result of applying the given
     *         function to
     *         each element from the input array to the output array.
     *         <p>
     *         Note that the returned array is the same length as the input
     */
    public static <T> T[] map(float[] array, jdk.prim.util.function.PrimitiveFunction.OfFloat<T> mapper) {
        @SuppressWarnings("unchecked")
        T[] mapped = (T[]) new Object[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            float e = array[i];
            mapped[index++] = mapper.apply(e);
        }
        return mapped;
    }

    /**
     * Utility method to convert the elements of the input array from {@code char}
     * to {@code <T>} preserving
     * the encounter order.
     * 
     * @param <T>    the type of the output array
     * @param array  the input array
     * @param mapper a mapping function which requires a {@code char} value
     *               and has a return value of type {@code <T>}.
     * @return a new array generated by mapping the result of applying the given
     *         function to
     *         each element from the input array to the output array.
     *         <p>
     *         Note that the returned array is the same length as the input
     */
    public static <T> T[] map(char[] array, jdk.prim.util.function.PrimitiveFunction.OfChar<T> mapper) {
        @SuppressWarnings("unchecked")
        T[] mapped = (T[]) new Object[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            char e = array[i];
            mapped[index++] = mapper.apply(e);
        }
        return mapped;
    }

    /**
     * Utility method to convert the elements of the input array from {@code short}
     * to {@code <T>} preserving
     * the encounter order.
     * 
     * @param <T>    the type of the output array
     * @param array  the input array
     * @param mapper a mapping function which requires a {@code short} value
     *               and has a return value of type {@code <T>}.
     * @return a new array generated by mapping the result of applying the given
     *         function to
     *         each element from the input array to the output array.
     *         <p>
     *         Note that the returned array is the same length as the input
     */
    public static <T> T[] map(short[] array, jdk.prim.util.function.PrimitiveFunction.OfShort<T> mapper) {
        @SuppressWarnings("unchecked")
        T[] mapped = (T[]) new Object[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            short e = array[i];
            mapped[index++] = mapper.apply(e);
        }
        return mapped;
    }

    /**
     * Utility method to convert the elements of the input array from {@code byte}
     * to {@code <T>} preserving
     * the encounter order.
     * 
     * @param <T>    the type of the output array
     * @param array  the input array
     * @param mapper a mapping function which requires a {@code byte} value
     *               and has a return value of type {@code <T>}.
     * @return a new array generated by mapping the result of applying the given
     *         function to
     *         each element from the input array to the output array.
     *         <p>
     *         Note that the returned array is the same length as the input
     */
    public static <T> T[] map(byte[] array, jdk.prim.util.function.PrimitiveFunction.OfByte<T> mapper) {
        @SuppressWarnings("unchecked")
        T[] mapped = (T[]) new Object[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            byte e = array[i];
            mapped[index++] = mapper.apply(e);
        }
        return mapped;
    }

    /**
     * Utility method to convert the elements of the input array from
     * {@code boolean} to {@code <T>} preserving
     * the encounter order.
     * 
     * @param <T>    the type of the output array
     * @param array  the input array
     * @param mapper a mapping function which requires a {@code boolean} value
     *               and has a return value of type {@code <T>}.
     * @return a new array generated by mapping the result of applying the given
     *         function to
     *         each element from the input array to the output array.
     *         <p>
     *         Note that the returned array is the same length as the input
     */
    public static <T> T[] map(boolean[] array, jdk.prim.util.function.PrimitiveFunction.OfBoolean<T> mapper) {
        @SuppressWarnings("unchecked")
        T[] mapped = (T[]) new Object[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            boolean e = array[i];
            mapped[index++] = mapper.apply(e);
        }
        return mapped;
    }

    /**
     * Utility method to convert the elements of the input array from {@code <T>} to
     * {@code double} preserving
     * the encounter order.
     * 
     * @param <T>    the type of the output array
     * @param array  the input array
     * @param mapper a mapping function which requires a value of type {@code <T>}
     *               and has a return {@code double} value.
     * @return a new array generated by mapping the result of applying the given
     *         function to
     *         each element from the input array to the output array.
     *         <p>
     *         Note that the returned array is the same length as the input
     */
    public static <T> double[] map(T[] array, jdk.prim.util.function.PrimitiveFunction.ToDouble<T> mapper) {
        double[] mapped = new double[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            T e = array[i];
            mapped[index++] = mapper.applyDouble(e);
        }
        return mapped;
    }

    /**
     * Utility method to convert the elements of the input array from {@code <T>} to
     * {@code long} preserving
     * the encounter order.
     * 
     * @param <T>    the type of the output array
     * @param array  the input array
     * @param mapper a mapping function which requires a value of type {@code <T>}
     *               and has a return {@code long} value.
     * @return a new array generated by mapping the result of applying the given
     *         function to
     *         each element from the input array to the output array.
     *         <p>
     *         Note that the returned array is the same length as the input
     */
    public static <T> long[] map(T[] array, jdk.prim.util.function.PrimitiveFunction.ToLong<T> mapper) {
        long[] mapped = new long[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            T e = array[i];
            mapped[index++] = mapper.applyLong(e);
        }
        return mapped;
    }

    /**
     * Utility method to convert the elements of the input array from {@code <T>} to
     * {@code int} preserving
     * the encounter order.
     * 
     * @param <T>    the type of the output array
     * @param array  the input array
     * @param mapper a mapping function which requires a value of type {@code <T>}
     *               and has a return {@code int} value.
     * @return a new array generated by mapping the result of applying the given
     *         function to
     *         each element from the input array to the output array.
     *         <p>
     *         Note that the returned array is the same length as the input
     */
    public static <T> int[] map(T[] array, jdk.prim.util.function.PrimitiveFunction.ToInt<T> mapper) {
        int[] mapped = new int[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            T e = array[i];
            mapped[index++] = mapper.applyInt(e);
        }
        return mapped;
    }

    /**
     * Utility method to convert the elements of the input array from {@code <T>} to
     * {@code float} preserving
     * the encounter order.
     * 
     * @param <T>    the type of the output array
     * @param array  the input array
     * @param mapper a mapping function which requires a value of type {@code <T>}
     *               and has a return {@code float} value.
     * @return a new array generated by mapping the result of applying the given
     *         function to
     *         each element from the input array to the output array.
     *         <p>
     *         Note that the returned array is the same length as the input
     */
    public static <T> float[] map(T[] array, jdk.prim.util.function.PrimitiveFunction.ToFloat<T> mapper) {
        float[] mapped = new float[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            T e = array[i];
            mapped[index++] = mapper.applyFloat(e);
        }
        return mapped;
    }

    /**
     * Utility method to convert the elements of the input array from {@code <T>} to
     * {@code char} preserving
     * the encounter order.
     * 
     * @param <T>    the type of the output array
     * @param array  the input array
     * @param mapper a mapping function which requires a value of type {@code <T>}
     *               and has a return {@code char} value.
     * @return a new array generated by mapping the result of applying the given
     *         function to
     *         each element from the input array to the output array.
     *         <p>
     *         Note that the returned array is the same length as the input
     */
    public static <T> char[] map(T[] array, jdk.prim.util.function.PrimitiveFunction.ToChar<T> mapper) {
        char[] mapped = new char[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            T e = array[i];
            mapped[index++] = mapper.applyChar(e);
        }
        return mapped;
    }

    /**
     * Utility method to convert the elements of the input array from {@code <T>} to
     * {@code short} preserving
     * the encounter order.
     * 
     * @param <T>    the type of the output array
     * @param array  the input array
     * @param mapper a mapping function which requires a value of type {@code <T>}
     *               and has a return {@code short} value.
     * @return a new array generated by mapping the result of applying the given
     *         function to
     *         each element from the input array to the output array.
     *         <p>
     *         Note that the returned array is the same length as the input
     */
    public static <T> short[] map(T[] array, jdk.prim.util.function.PrimitiveFunction.ToShort<T> mapper) {
        short[] mapped = new short[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            T e = array[i];
            mapped[index++] = mapper.applyShort(e);
        }
        return mapped;
    }

    /**
     * Utility method to convert the elements of the input array from {@code <T>} to
     * {@code byte} preserving
     * the encounter order.
     * 
     * @param <T>    the type of the output array
     * @param array  the input array
     * @param mapper a mapping function which requires a value of type {@code <T>}
     *               and has a return {@code byte} value.
     * @return a new array generated by mapping the result of applying the given
     *         function to
     *         each element from the input array to the output array.
     *         <p>
     *         Note that the returned array is the same length as the input
     */
    public static <T> byte[] map(T[] array, jdk.prim.util.function.PrimitiveFunction.ToByte<T> mapper) {
        byte[] mapped = new byte[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            T e = array[i];
            mapped[index++] = mapper.applyByte(e);
        }
        return mapped;
    }

    /**
     * Utility method to convert the elements of the input array from {@code <T>} to
     * {@code boolean} preserving
     * the encounter order.
     * 
     * @param <T>    the type of the output array
     * @param array  the input array
     * @param mapper a mapping function which requires a value of type {@code <T>}
     *               and has a return {@code boolean} value.
     * @return a new array generated by mapping the result of applying the given
     *         function to
     *         each element from the input array to the output array.
     *         <p>
     *         Note that the returned array is the same length as the input
     */
    public static <T> boolean[] map(T[] array, jdk.prim.util.function.PrimitiveFunction.ToBoolean<T> mapper) {
        boolean[] mapped = new boolean[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            T e = array[i];
            mapped[index++] = mapper.applyBoolean(e);
        }
        return mapped;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns a {@code double} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns a {@code double} and accepts a
     *               {@code double}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static double[] map(double[] array, jdk.prim.util.function.PrimitiveFunction.ToDouble.OfDouble mapper) {
        double[] d = new double[array.length];
        for (int i = 0; i < array.length; i++)
            d[i] = mapper.applyDouble(array[i]);
        return d;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns a {@code double} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns a {@code double} and accepts a
     *               {@code long}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static double[] map(long[] array, jdk.prim.util.function.PrimitiveFunction.ToDouble.OfLong mapper) {
        double[] d = new double[array.length];
        for (int i = 0; i < array.length; i++)
            d[i] = mapper.applyDouble(array[i]);
        return d;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns a {@code double} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns a {@code double} and accepts a
     *               {@code int}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static double[] map(int[] array, jdk.prim.util.function.PrimitiveFunction.ToDouble.OfInt mapper) {
        double[] d = new double[array.length];
        for (int i = 0; i < array.length; i++)
            d[i] = mapper.applyDouble(array[i]);
        return d;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns a {@code double} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns a {@code double} and accepts a
     *               {@code float}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static double[] map(float[] array, jdk.prim.util.function.PrimitiveFunction.ToDouble.OfFloat mapper) {
        double[] d = new double[array.length];
        for (int i = 0; i < array.length; i++)
            d[i] = mapper.applyDouble(array[i]);
        return d;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns a {@code double} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns a {@code double} and accepts a
     *               {@code char}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static double[] map(char[] array, jdk.prim.util.function.PrimitiveFunction.ToDouble.OfChar mapper) {
        double[] d = new double[array.length];
        for (int i = 0; i < array.length; i++)
            d[i] = mapper.applyDouble(array[i]);
        return d;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns a {@code double} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns a {@code double} and accepts a
     *               {@code short}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static double[] map(short[] array, jdk.prim.util.function.PrimitiveFunction.ToDouble.OfShort mapper) {
        double[] d = new double[array.length];
        for (int i = 0; i < array.length; i++)
            d[i] = mapper.applyDouble(array[i]);
        return d;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns a {@code double} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns a {@code double} and accepts a
     *               {@code byte}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static double[] map(byte[] array, jdk.prim.util.function.PrimitiveFunction.ToDouble.OfByte mapper) {
        double[] d = new double[array.length];
        for (int i = 0; i < array.length; i++)
            d[i] = mapper.applyDouble(array[i]);
        return d;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns a {@code double} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns a {@code double} and accepts a
     *               {@code boolean}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static double[] map(boolean[] array, jdk.prim.util.function.PrimitiveFunction.ToDouble.OfBoolean mapper) {
        double[] d = new double[array.length];
        for (int i = 0; i < array.length; i++)
            d[i] = mapper.applyDouble(array[i]);
        return d;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns a {@code long} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns a {@code long} and accepts a
     *               {@code double}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static long[] map(double[] array, jdk.prim.util.function.PrimitiveFunction.ToLong.OfDouble mapper) {
        long[] l = new long[array.length];
        for (int i = 0; i < array.length; i++) {
            l[i] = mapper.applyLong(array[i]);
        }
        return l;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns a {@code long} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns a {@code long} and accepts a
     *               {@code long}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static long[] map(long[] array, jdk.prim.util.function.PrimitiveFunction.ToLong.OfLong mapper) {
        long[] l = new long[array.length];
        for (int i = 0; i < array.length; i++) {
            l[i] = mapper.applyLong(array[i]);
        }
        return l;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns a {@code long} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns a {@code long} and accepts a
     *               {@code int}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static long[] map(int[] array, jdk.prim.util.function.PrimitiveFunction.ToLong.OfInt mapper) {
        long[] l = new long[array.length];
        for (int i = 0; i < array.length; i++) {
            l[i] = mapper.applyLong(array[i]);
        }
        return l;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns a {@code long} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns a {@code long} and accepts a
     *               {@code float}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static long[] map(float[] array, jdk.prim.util.function.PrimitiveFunction.ToLong.OfFloat mapper) {
        long[] l = new long[array.length];
        for (int i = 0; i < array.length; i++) {
            l[i] = mapper.applyLong(array[i]);
        }
        return l;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns a {@code long} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns a {@code long} and accepts a
     *               {@code char}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static long[] map(char[] array, jdk.prim.util.function.PrimitiveFunction.ToLong.OfChar mapper) {
        long[] l = new long[array.length];
        for (int i = 0; i < array.length; i++) {
            l[i] = mapper.applyLong(array[i]);
        }
        return l;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns a {@code long} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns a {@code long} and accepts a
     *               {@code short}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static long[] map(short[] array, jdk.prim.util.function.PrimitiveFunction.ToLong.OfShort mapper) {
        long[] l = new long[array.length];
        for (int i = 0; i < array.length; i++) {
            l[i] = mapper.applyLong(array[i]);
        }
        return l;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns a {@code long} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns a {@code long} and accepts a
     *               {@code byte}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static long[] map(byte[] array, jdk.prim.util.function.PrimitiveFunction.ToLong.OfByte mapper) {
        long[] l = new long[array.length];
        for (int i = 0; i < array.length; i++) {
            l[i] = mapper.applyLong(array[i]);
        }
        return l;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns a {@code long} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns a {@code long} and accepts a
     *               {@code boolean}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static long[] map(boolean[] array, jdk.prim.util.function.PrimitiveFunction.ToLong.OfBoolean mapper) {
        long[] l = new long[array.length];
        for (int i = 0; i < array.length; i++) {
            l[i] = mapper.applyLong(array[i]);
        }
        return l;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns an {@code int} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns an {@code int} and accepts a
     *               {@code double}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static int[] map(double[] array, jdk.prim.util.function.PrimitiveFunction.ToInt.OfDouble mapper) {
        int[] mapped = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            mapped[i] = mapper.applyInt(array[i]);
        }
        return mapped;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns an {@code int} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns an {@code int} and accepts a
     *               {@code long}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static int[] map(long[] array, jdk.prim.util.function.PrimitiveFunction.ToInt.OfLong mapper) {
        int[] mapped = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            mapped[i] = mapper.applyInt(array[i]);
        }
        return mapped;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns an {@code int} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns an {@code int} and accepts a
     *               {@code int}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static int[] map(int[] array, jdk.prim.util.function.PrimitiveFunction.ToInt.OfInt mapper) {
        int[] mapped = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            mapped[i] = mapper.applyInt(array[i]);
        }
        return mapped;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns an {@code int} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns an {@code int} and accepts a
     *               {@code float}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static int[] map(float[] array, jdk.prim.util.function.PrimitiveFunction.ToInt.OfFloat mapper) {
        int[] mapped = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            mapped[i] = mapper.applyInt(array[i]);
        }
        return mapped;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns an {@code int} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns an {@code int} and accepts a
     *               {@code char}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static int[] map(char[] array, jdk.prim.util.function.PrimitiveFunction.ToInt.OfChar mapper) {
        int[] mapped = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            mapped[i] = mapper.applyInt(array[i]);
        }
        return mapped;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns an {@code int} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns an {@code int} and accepts a
     *               {@code short}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static int[] map(short[] array, jdk.prim.util.function.PrimitiveFunction.ToInt.OfShort mapper) {
        int[] mapped = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            mapped[i] = mapper.applyInt(array[i]);
        }
        return mapped;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns an {@code int} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns an {@code int} and accepts a
     *               {@code byte}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static int[] map(byte[] array, jdk.prim.util.function.PrimitiveFunction.ToInt.OfByte mapper) {
        int[] mapped = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            mapped[i] = mapper.applyInt(array[i]);
        }
        return mapped;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns an {@code int} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns an {@code int} and accepts a
     *               {@code boolean}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static int[] map(boolean[] array, jdk.prim.util.function.PrimitiveFunction.ToInt.OfBoolean mapper) {
        int[] mapped = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            mapped[i] = mapper.applyInt(array[i]);
        }
        return mapped;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns a {@code float} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns a {@code float} and accepts a
     *               {@code double}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static float[] map(double[] array, jdk.prim.util.function.PrimitiveFunction.ToFloat.OfDouble mapper) {
        float[] mapped = new float[array.length];
        for (int i = 0; i < array.length; i++) {
            mapped[i] = mapper.applyFloat(array[i]);
        }
        return mapped;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns a {@code float} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns a {@code float} and accepts a
     *               {@code long}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static float[] map(long[] array, jdk.prim.util.function.PrimitiveFunction.ToFloat.OfLong mapper) {
        float[] mapped = new float[array.length];
        for (int i = 0; i < array.length; i++) {
            mapped[i] = mapper.applyFloat(array[i]);
        }
        return mapped;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns a {@code float} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns a {@code float} and accepts a
     *               {@code int}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static float[] map(int[] array, jdk.prim.util.function.PrimitiveFunction.ToFloat.OfInt mapper) {
        float[] mapped = new float[array.length];
        for (int i = 0; i < array.length; i++) {
            mapped[i] = mapper.applyFloat(array[i]);
        }
        return mapped;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns a {@code float} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns a {@code float} and accepts a
     *               {@code float}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static float[] map(float[] array, jdk.prim.util.function.PrimitiveFunction.ToFloat.OfFloat mapper) {
        float[] mapped = new float[array.length];
        for (int i = 0; i < array.length; i++) {
            mapped[i] = mapper.applyFloat(array[i]);
        }
        return mapped;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns a {@code float} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns a {@code float} and accepts a
     *               {@code char}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static float[] map(char[] array, jdk.prim.util.function.PrimitiveFunction.ToFloat.OfChar mapper) {
        float[] mapped = new float[array.length];
        for (int i = 0; i < array.length; i++) {
            mapped[i] = mapper.applyFloat(array[i]);
        }
        return mapped;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns a {@code float} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns a {@code float} and accepts a
     *               {@code short}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static float[] map(short[] array, jdk.prim.util.function.PrimitiveFunction.ToFloat.OfShort mapper) {
        float[] mapped = new float[array.length];
        for (int i = 0; i < array.length; i++) {
            mapped[i] = mapper.applyFloat(array[i]);
        }
        return mapped;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns a {@code float} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns a {@code float} and accepts a
     *               {@code byte}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static float[] map(byte[] array, jdk.prim.util.function.PrimitiveFunction.ToFloat.OfByte mapper) {
        float[] mapped = new float[array.length];
        for (int i = 0; i < array.length; i++) {
            mapped[i] = mapper.applyFloat(array[i]);
        }
        return mapped;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns a {@code float} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns a {@code float} and accepts a
     *               {@code boolean}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static float[] map(boolean[] array, jdk.prim.util.function.PrimitiveFunction.ToFloat.OfBoolean mapper) {
        float[] mapped = new float[array.length];
        for (int i = 0; i < array.length; i++) {
            mapped[i] = mapper.applyFloat(array[i]);
        }
        return mapped;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns a {@code char} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns a {@code char} and accepts a
     *               {@code double}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static char[] map(double[] array, jdk.prim.util.function.PrimitiveFunction.ToChar.OfDouble mapper) {
        char[] mapped = new char[array.length];
        for (int i = 0; i < array.length; i++) {
            mapped[i] = mapper.applyChar(array[i]);
        }
        return mapped;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns a {@code char} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns a {@code char} and accepts a
     *               {@code long}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static char[] map(long[] array, jdk.prim.util.function.PrimitiveFunction.ToChar.OfLong mapper) {
        char[] mapped = new char[array.length];
        for (int i = 0; i < array.length; i++) {
            mapped[i] = mapper.applyChar(array[i]);
        }
        return mapped;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns a {@code char} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns a {@code char} and accepts a
     *               {@code int}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static char[] map(int[] array, jdk.prim.util.function.PrimitiveFunction.ToChar.OfInt mapper) {
        char[] mapped = new char[array.length];
        for (int i = 0; i < array.length; i++) {
            mapped[i] = mapper.applyChar(array[i]);
        }
        return mapped;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns a {@code char} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns a {@code char} and accepts a
     *               {@code float}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static char[] map(float[] array, jdk.prim.util.function.PrimitiveFunction.ToChar.OfFloat mapper) {
        char[] mapped = new char[array.length];
        for (int i = 0; i < array.length; i++) {
            mapped[i] = mapper.applyChar(array[i]);
        }
        return mapped;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns a {@code char} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns a {@code char} and accepts a
     *               {@code char}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static char[] map(char[] array, jdk.prim.util.function.PrimitiveFunction.ToChar.OfChar mapper) {
        char[] mapped = new char[array.length];
        for (int i = 0; i < array.length; i++) {
            mapped[i] = mapper.applyChar(array[i]);
        }
        return mapped;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns a {@code char} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns a {@code char} and accepts a
     *               {@code short}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static char[] map(short[] array, jdk.prim.util.function.PrimitiveFunction.ToChar.OfShort mapper) {
        char[] mapped = new char[array.length];
        for (int i = 0; i < array.length; i++) {
            mapped[i] = mapper.applyChar(array[i]);
        }
        return mapped;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns a {@code char} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns a {@code char} and accepts a
     *               {@code byte}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static char[] map(byte[] array, jdk.prim.util.function.PrimitiveFunction.ToChar.OfByte mapper) {
        char[] mapped = new char[array.length];
        for (int i = 0; i < array.length; i++) {
            mapped[i] = mapper.applyChar(array[i]);
        }
        return mapped;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns a {@code char} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns a {@code char} and accepts a
     *               {@code boolean}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static char[] map(boolean[] array, jdk.prim.util.function.PrimitiveFunction.ToChar.OfBoolean mapper) {
        char[] mapped = new char[array.length];
        for (int i = 0; i < array.length; i++) {
            mapped[i] = mapper.applyChar(array[i]);
        }
        return mapped;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns a {@code short} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns a {@code short} and accepts a
     *               {@code double}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static short[] map(double[] array, jdk.prim.util.function.PrimitiveFunction.ToShort.OfDouble mapper) {
        short[] mapped = new short[array.length];
        for (int i = 0; i < array.length; i++) {
            mapped[i] = mapper.applyShort(array[i]);
        }
        return mapped;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns a {@code short} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns a {@code short} and accepts a
     *               {@code long}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static short[] map(long[] array, jdk.prim.util.function.PrimitiveFunction.ToShort.OfLong mapper) {
        short[] mapped = new short[array.length];
        for (int i = 0; i < array.length; i++) {
            mapped[i] = mapper.applyShort(array[i]);
        }
        return mapped;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns a {@code short} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns a {@code short} and accepts a
     *               {@code int}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static short[] map(int[] array, jdk.prim.util.function.PrimitiveFunction.ToShort.OfInt mapper) {
        short[] mapped = new short[array.length];
        for (int i = 0; i < array.length; i++) {
            mapped[i] = mapper.applyShort(array[i]);
        }
        return mapped;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns a {@code short} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns a {@code short} and accepts a
     *               {@code float}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static short[] map(float[] array, jdk.prim.util.function.PrimitiveFunction.ToShort.OfFloat mapper) {
        short[] mapped = new short[array.length];
        for (int i = 0; i < array.length; i++) {
            mapped[i] = mapper.applyShort(array[i]);
        }
        return mapped;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns a {@code short} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns a {@code short} and accepts a
     *               {@code char}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static short[] map(char[] array, jdk.prim.util.function.PrimitiveFunction.ToShort.OfChar mapper) {
        short[] mapped = new short[array.length];
        for (int i = 0; i < array.length; i++) {
            mapped[i] = mapper.applyShort(array[i]);
        }
        return mapped;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns a {@code short} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns a {@code short} and accepts a
     *               {@code short}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static short[] map(short[] array, jdk.prim.util.function.PrimitiveFunction.ToShort.OfShort mapper) {
        short[] mapped = new short[array.length];
        for (int i = 0; i < array.length; i++) {
            mapped[i] = mapper.applyShort(array[i]);
        }
        return mapped;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns a {@code short} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns a {@code short} and accepts a
     *               {@code byte}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static short[] map(byte[] array, jdk.prim.util.function.PrimitiveFunction.ToShort.OfByte mapper) {
        short[] mapped = new short[array.length];
        for (int i = 0; i < array.length; i++) {
            mapped[i] = mapper.applyShort(array[i]);
        }
        return mapped;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns a {@code short} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns a {@code short} and accepts a
     *               {@code boolean}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static short[] map(boolean[] array, jdk.prim.util.function.PrimitiveFunction.ToShort.OfBoolean mapper) {
        short[] mapped = new short[array.length];
        for (int i = 0; i < array.length; i++) {
            mapped[i] = mapper.applyShort(array[i]);
        }
        return mapped;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns a {@code byte} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns a {@code byte} and accepts a
     *               {@code double}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static byte[] map(double[] array, jdk.prim.util.function.PrimitiveFunction.ToByte.OfDouble mapper) {
        byte[] mapped = new byte[array.length];
        for (int i = 0; i < array.length; i++) {
            mapped[i] = mapper.applyByte(array[i]);
        }
        return mapped;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns a {@code byte} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns a {@code byte} and accepts a
     *               {@code long}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static byte[] map(long[] array, jdk.prim.util.function.PrimitiveFunction.ToByte.OfLong mapper) {
        byte[] mapped = new byte[array.length];
        for (int i = 0; i < array.length; i++) {
            mapped[i] = mapper.applyByte(array[i]);
        }
        return mapped;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns a {@code byte} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns a {@code byte} and accepts a
     *               {@code int}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static byte[] map(int[] array, jdk.prim.util.function.PrimitiveFunction.ToByte.OfInt mapper) {
        byte[] mapped = new byte[array.length];
        for (int i = 0; i < array.length; i++) {
            mapped[i] = mapper.applyByte(array[i]);
        }
        return mapped;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns a {@code byte} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns a {@code byte} and accepts a
     *               {@code float}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static byte[] map(float[] array, jdk.prim.util.function.PrimitiveFunction.ToByte.OfFloat mapper) {
        byte[] mapped = new byte[array.length];
        for (int i = 0; i < array.length; i++) {
            mapped[i] = mapper.applyByte(array[i]);
        }
        return mapped;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns a {@code byte} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns a {@code byte} and accepts a
     *               {@code char}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static byte[] map(char[] array, jdk.prim.util.function.PrimitiveFunction.ToByte.OfChar mapper) {
        byte[] mapped = new byte[array.length];
        for (int i = 0; i < array.length; i++) {
            mapped[i] = mapper.applyByte(array[i]);
        }
        return mapped;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns a {@code byte} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns a {@code byte} and accepts a
     *               {@code short}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static byte[] map(short[] array, jdk.prim.util.function.PrimitiveFunction.ToByte.OfShort mapper) {
        byte[] mapped = new byte[array.length];
        for (int i = 0; i < array.length; i++) {
            mapped[i] = mapper.applyByte(array[i]);
        }
        return mapped;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns a {@code byte} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns a {@code byte} and accepts a
     *               {@code byte}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static byte[] map(byte[] array, jdk.prim.util.function.PrimitiveFunction.ToByte.OfByte mapper) {
        byte[] mapped = new byte[array.length];
        for (int i = 0; i < array.length; i++) {
            mapped[i] = mapper.applyByte(array[i]);
        }
        return mapped;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns a {@code byte} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns a {@code byte} and accepts a
     *               {@code boolean}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static byte[] map(boolean[] array, jdk.prim.util.function.PrimitiveFunction.ToByte.OfBoolean mapper) {
        byte[] mapped = new byte[array.length];
        for (int i = 0; i < array.length; i++) {
            mapped[i] = mapper.applyByte(array[i]);
        }
        return mapped;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns a {@code boolean} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns a {@code boolean} and accepts a
     *               {@code double}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static boolean[] map(double[] array, jdk.prim.util.function.PrimitiveFunction.ToBoolean.OfDouble mapper) {
        boolean[] mapped = new boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            mapped[i] = mapper.applyBoolean(array[i]);
        }
        return mapped;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns a {@code boolean} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns a {@code boolean} and accepts a
     *               {@code long}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static boolean[] map(long[] array, jdk.prim.util.function.PrimitiveFunction.ToBoolean.OfLong mapper) {
        boolean[] mapped = new boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            mapped[i] = mapper.applyBoolean(array[i]);
        }
        return mapped;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns a {@code boolean} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns a {@code boolean} and accepts a
     *               {@code int}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static boolean[] map(int[] array, jdk.prim.util.function.PrimitiveFunction.ToBoolean.OfInt mapper) {
        boolean[] mapped = new boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            mapped[i] = mapper.applyBoolean(array[i]);
        }
        return mapped;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns a {@code boolean} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns a {@code boolean} and accepts a
     *               {@code float}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static boolean[] map(float[] array, jdk.prim.util.function.PrimitiveFunction.ToBoolean.OfFloat mapper) {
        boolean[] mapped = new boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            mapped[i] = mapper.applyBoolean(array[i]);
        }
        return mapped;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns a {@code boolean} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns a {@code boolean} and accepts a
     *               {@code char}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static boolean[] map(char[] array, jdk.prim.util.function.PrimitiveFunction.ToBoolean.OfChar mapper) {
        boolean[] mapped = new boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            mapped[i] = mapper.applyBoolean(array[i]);
        }
        return mapped;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns a {@code boolean} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns a {@code boolean} and accepts a
     *               {@code short}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static boolean[] map(short[] array, jdk.prim.util.function.PrimitiveFunction.ToBoolean.OfShort mapper) {
        boolean[] mapped = new boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            mapped[i] = mapper.applyBoolean(array[i]);
        }
        return mapped;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns a {@code boolean} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns a {@code boolean} and accepts a
     *               {@code byte}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static boolean[] map(byte[] array, jdk.prim.util.function.PrimitiveFunction.ToBoolean.OfByte mapper) {
        boolean[] mapped = new boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            mapped[i] = mapper.applyBoolean(array[i]);
        }
        return mapped;
    }

    /**
     * Applies the given mapper to each element of the given input array
     * and returns a {@code boolean} array which is the result of the
     * mapping function
     * 
     * @param array  the input array
     * @param mapper a function that returns a {@code boolean} and accepts a
     *               {@code boolean}
     * @return a new array which is the result of applying the given function
     *         to each of the elements of the input array.
     *         <p>
     *         Note that the returned array is the same length as the input even if
     *         the input
     *         is an empty array.
     */
    public static boolean[] map(boolean[] array, jdk.prim.util.function.PrimitiveFunction.ToBoolean.OfBoolean mapper) {
        boolean[] mapped = new boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            mapped[i] = mapper.applyBoolean(array[i]);
        }
        return mapped;
    }

    /**
     * Performs a (possibly stateless) reduction on every element in the
     * input array and returns the result.
     * 
     * @param <T>         the type of the input array
     * @param <U>         the type of the return value for this method
     * @param array       the input array
     * @param accumulator the binary operation taking in the accuated result and the
     *                    current
     *                    iterated value as argument
     * @param initial     the starting value to used with the accumulator function
     * @return the result of the reduction. Will simply return {@code initial} if
     *         the
     *         input array is {@code null}.
     */
    public static <T, U> U reduce(T[] array, BiFunction<U, ? super T, U> accumulator, U initial) {
        for (int i = 0; i < array.length; i++) {
            initial = accumulator.apply(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction for a {@code double} array, returning
     * an object of the specified type
     * 
     * @param <T>         the return type
     * @param array       the input array
     * @param accumulator the function that combines the elements
     *                    of the input array into a single value
     * @param initial     the value with which to integrate the first element
     * @return the accumulated result. Will return {@code initial} if
     *         the input array is empty
     */
    public static <T> T reduce(double[] array, jdk.prim.util.function.PrimitiveBiFunction.AndDouble<T, T> accumulator, T initial) {
        for (int i = 0; i < array.length; i++) {
            initial = accumulator.apply(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction for a {@code long} array, returning
     * an object of the specified type
     * 
     * @param <T>         the return type
     * @param array       the input array
     * @param accumulator the function that combines the elements
     *                    of the input array into a single value
     * @param initial     the value with which to integrate the first element
     * @return the accumulated result. Will return {@code initial} if
     *         the input array is empty
     */
    public static <T> T reduce(long[] array, jdk.prim.util.function.PrimitiveBiFunction.AndLong<T, T> accumulator, T initial) {
        for (int i = 0; i < array.length; i++) {
            initial = accumulator.apply(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction for a {@code int} array, returning
     * an object of the specified type
     * 
     * @param <T>         the return type
     * @param array       the input array
     * @param accumulator the function that combines the elements
     *                    of the input array into a single value
     * @param initial     the value with which to integrate the first element
     * @return the accumulated result. Will return {@code initial} if
     *         the input array is empty
     */
    public static <T> T reduce(int[] array, jdk.prim.util.function.PrimitiveBiFunction.AndInt<T, T> accumulator, T initial) {
        for (int i = 0; i < array.length; i++) {
            initial = accumulator.apply(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction for a {@code float} array, returning
     * an object of the specified type
     * 
     * @param <T>         the return type
     * @param array       the input array
     * @param accumulator the function that combines the elements
     *                    of the input array into a single value
     * @param initial     the value with which to integrate the first element
     * @return the accumulated result. Will return {@code initial} if
     *         the input array is empty
     */
    public static <T> T reduce(float[] array, jdk.prim.util.function.PrimitiveBiFunction.AndFloat<T, T> accumulator, T initial) {
        for (int i = 0; i < array.length; i++) {
            initial = accumulator.apply(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction for a {@code char} array, returning
     * an object of the specified type
     * 
     * @param <T>         the return type
     * @param array       the input array
     * @param accumulator the function that combines the elements
     *                    of the input array into a single value
     * @param initial     the value with which to integrate the first element
     * @return the accumulated result. Will return {@code initial} if
     *         the input array is empty
     */
    public static <T> T reduce(char[] array, jdk.prim.util.function.PrimitiveBiFunction.AndChar<T, T> accumulator, T initial) {
        for (int i = 0; i < array.length; i++) {
            initial = accumulator.apply(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction for a {@code short} array, returning
     * an object of the specified type
     * 
     * @param <T>         the return type
     * @param array       the input array
     * @param accumulator the function that combines the elements
     *                    of the input array into a single value
     * @param initial     the value with which to integrate the first element
     * @return the accumulated result. Will return {@code initial} if
     *         the input array is empty
     */
    public static <T> T reduce(short[] array, jdk.prim.util.function.PrimitiveBiFunction.AndShort<T, T> accumulator, T initial) {
        for (int i = 0; i < array.length; i++) {
            initial = accumulator.apply(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction for a {@code byte} array, returning
     * an object of the specified type
     * 
     * @param <T>         the return type
     * @param array       the input array
     * @param accumulator the function that combines the elements
     *                    of the input array into a single value
     * @param initial     the value with which to integrate the first element
     * @return the accumulated result. Will return {@code initial} if
     *         the input array is empty
     */
    public static <T> T reduce(byte[] array, jdk.prim.util.function.PrimitiveBiFunction.AndByte<T, T> accumulator, T initial) {
        for (int i = 0; i < array.length; i++) {
            initial = accumulator.apply(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction for a {@code boolean} array, returning
     * an object of the specified type
     * 
     * @param <T>         the return type
     * @param array       the input array
     * @param accumulator the function that combines the elements
     *                    of the input array into a single value
     * @param initial     the value with which to integrate the first element
     * @return the accumulated result. Will return {@code initial} if
     *         the input array is empty
     */
    public static <T> T reduce(boolean[] array, jdk.prim.util.function.PrimitiveBiFunction.AndBoolean<T, T> accumulator, T initial) {
        for (int i = 0; i < array.length; i++) {
            initial = accumulator.apply(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given input array whereby all elements
     * are accumulated to a {@code double} result.
     * 
     * @param <T>     the type of the input array
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code double} value with which to incorporate the
     *                first element, meging them as one {@code double} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static <T> double reduce(T[] array, jdk.prim.util.function.PrimitiveBiFunction.ToDouble.OfDouble<T> acc, double initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyDouble(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given {@code double} array whereby all elements
     * are accumulated to a {@code double} result.
     * 
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code double} value with which to incorporate the
     *                first element, meging them as one {@code double} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static double reduce(double[] array, jdk.prim.util.function.PrimitiveBiFunction.ToDouble.OfDouble.AndDouble acc, double initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyDouble(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given {@code long} array whereby all elements
     * are accumulated to a {@code double} result.
     * 
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code double} value with which to incorporate the
     *                first element, meging them as one {@code double} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static double reduce(long[] array, jdk.prim.util.function.PrimitiveBiFunction.ToDouble.OfDouble.AndLong acc, double initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyDouble(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given {@code int} array whereby all elements
     * are accumulated to a {@code double} result.
     * 
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code double} value with which to incorporate the
     *                first element, meging them as one {@code double} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static double reduce(int[] array, jdk.prim.util.function.PrimitiveBiFunction.ToDouble.OfDouble.AndInt acc, double initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyDouble(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given {@code float} array whereby all elements
     * are accumulated to a {@code double} result.
     * 
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code double} value with which to incorporate the
     *                first element, meging them as one {@code double} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static double reduce(float[] array, jdk.prim.util.function.PrimitiveBiFunction.ToDouble.OfDouble.AndFloat acc, double initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyDouble(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given {@code char} array whereby all elements
     * are accumulated to a {@code double} result.
     * 
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code double} value with which to incorporate the
     *                first element, meging them as one {@code double} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static double reduce(char[] array, jdk.prim.util.function.PrimitiveBiFunction.ToDouble.OfDouble.AndChar acc, double initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyDouble(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given {@code short} array whereby all elements
     * are accumulated to a {@code double} result.
     * 
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code double} value with which to incorporate the
     *                first element, meging them as one {@code double} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static double reduce(short[] array, jdk.prim.util.function.PrimitiveBiFunction.ToDouble.OfDouble.AndShort acc, double initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyDouble(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given {@code byte} array whereby all elements
     * are accumulated to a {@code double} result.
     * 
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code double} value with which to incorporate the
     *                first element, meging them as one {@code double} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static double reduce(byte[] array, jdk.prim.util.function.PrimitiveBiFunction.ToDouble.OfDouble.AndByte acc, double initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyDouble(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given {@code boolean} array whereby all elements
     * are accumulated to a {@code double} result.
     * 
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code double} value with which to incorporate the
     *                first element, meging them as one {@code double} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static double reduce(boolean[] array, jdk.prim.util.function.PrimitiveBiFunction.ToDouble.OfDouble.AndBoolean acc, double initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyDouble(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given input array whereby all elements
     * are accumulated to a {@code long} result.
     * 
     * @param <T>     the type of the input array
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code long} value with which to incorporate the
     *                first element, meging them as one {@code long} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static <T> long reduce(T[] array, jdk.prim.util.function.PrimitiveBiFunction.ToLong.OfLong<T> acc, long initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyLong(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given {@code double} array whereby all elements
     * are accumulated to a {@code long} result.
     * 
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code long} value with which to incorporate the
     *                first element, meging them as one {@code long} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static long reduce(double[] array, jdk.prim.util.function.PrimitiveBiFunction.ToLong.OfLong.AndDouble acc, long initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyLong(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given {@code long} array whereby all elements
     * are accumulated to a {@code long} result.
     * 
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code long} value with which to incorporate the
     *                first element, meging them as one {@code long} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static long reduce(long[] array, jdk.prim.util.function.PrimitiveBiFunction.ToLong.OfLong.AndLong acc, long initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyLong(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given {@code int} array whereby all elements
     * are accumulated to a {@code long} result.
     * 
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code long} value with which to incorporate the
     *                first element, meging them as one {@code long} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static long reduce(int[] array, jdk.prim.util.function.PrimitiveBiFunction.ToLong.OfLong.AndInt acc, long initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyLong(initial, array[i]);
        }
        return initial;
    }
    /*
      * Performs a reduction on the given {@code float} array whereby all elements
      * are accumulated to a {@code long} result.
      * 
      * @param array the input array
      * 
      * @param acc the function that combines the elements of the input
      * array into a sinle result.
      * 
      * @param initial a {@code long} value with which to incorporate the
      * first element, meging them as one {@code long} value.
      * 
      * @return the accumulated result. Will return {@code initial} is the
      * input array is empty.
      */

    public static long reduce(float[] array, jdk.prim.util.function.PrimitiveBiFunction.ToLong.OfLong.AndFloat acc, long initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyLong(initial, array[i]);
        }
        return initial;
    }

    /*
     * Performs a reduction on the given {@code char} array whereby all elements
     * are accumulated to a {@code long} result.
     * 
     * @param array the input array
     * 
     * @param acc the function that combines the elements of the input
     * array into a sinle result.
     * 
     * @param initial a {@code long} value with which to incorporate the
     * first element, meging them as one {@code long} value.
     * 
     * @return the accumulated result. Will return {@code initial} is the
     * input array is empty.
     */
    public static long reduce(char[] array, jdk.prim.util.function.PrimitiveBiFunction.ToLong.OfLong.AndChar acc, long initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyLong(initial, array[i]);
        }
        return initial;
    }

    /*
     * Performs a reduction on the given {@code short} array whereby all elements
     * are accumulated to a {@code long} result.
     * 
     * @param array the input array
     * 
     * @param acc the function that combines the elements of the input
     * array into a sinle result.
     * 
     * @param initial a {@code long} value with which to incorporate the
     * first element, meging them as one {@code long} value.
     * 
     * @return the accumulated result. Will return {@code initial} is the
     * input array is empty.
     */
    public static long reduce(short[] array, jdk.prim.util.function.PrimitiveBiFunction.ToLong.OfLong.AndShort acc, long initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyLong(initial, array[i]);
        }
        return initial;
    }

    /*
     * Performs a reduction on the given {@code byte} array whereby all elements
     * are accumulated to a {@code long} result.
     * 
     * @param array the input array
     * 
     * @param acc the function that combines the elements of the input
     * array into a sinle result.
     * 
     * @param initial a {@code long} value with which to incorporate the
     * first element, meging them as one {@code long} value.
     * 
     * @return the accumulated result. Will return {@code initial} is the
     * input array is empty.
     */
    public static long reduce(byte[] array, jdk.prim.util.function.PrimitiveBiFunction.ToLong.OfLong.AndByte acc, long initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyLong(initial, array[i]);
        }
        return initial;
    }

    /*
     * Performs a reduction on the given {@code boolean} array whereby all elements
     * are accumulated to a {@code long} result.
     * 
     * @param array the input array
     * 
     * @param acc the function that combines the elements of the input
     * array into a sinle result.
     * 
     * @param initial a {@code long} value with which to incorporate the
     * first element, meging them as one {@code long} value.
     * 
     * @return the accumulated result. Will return {@code initial} is the
     * input array is empty.
     */
    public static long reduce(boolean[] array, jdk.prim.util.function.PrimitiveBiFunction.ToLong.OfLong.AndBoolean acc, long initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyLong(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given input array whereby all elements
     * are accumulated to a {@code int} result.
     * 
     * @param <T>     the type of the input array
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code int} value with which to incorporate the
     *                first element, meging them as one {@code int} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static <T> int reduce(T[] array, jdk.prim.util.function.PrimitiveBiFunction.ToInt.OfInt<T> acc, int initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyInt(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given {@code double} array whereby all elements
     * are accumulated to a {@code int} result.
     * 
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code int} value with which to incorporate the
     *                first element, meging them as one {@code int} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static int reduce(double[] array, jdk.prim.util.function.PrimitiveBiFunction.ToInt.OfInt.AndDouble acc, int initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyInt(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given {@code long} array whereby all elements
     * are accumulated to a {@code int} result.
     * 
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code int} value with which to incorporate the
     *                first element, meging them as one {@code int} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static int reduce(long[] array, jdk.prim.util.function.PrimitiveBiFunction.ToInt.OfInt.AndLong acc, int initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyInt(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given {@code int} array whereby all elements
     * are accumulated to a {@code int} result.
     * 
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code int} value with which to incorporate the
     *                first element, meging them as one {@code int} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static int reduce(int[] array, jdk.prim.util.function.PrimitiveBiFunction.ToInt.OfInt.AndInt acc, int initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyInt(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given {@code float} array whereby all elements
     * are accumulated to a {@code int} result.
     * 
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code int} value with which to incorporate the
     *                first element, meging them as one {@code int} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static int reduce(float[] array, jdk.prim.util.function.PrimitiveBiFunction.ToInt.OfInt.AndFloat acc, int initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyInt(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given {@code char} array whereby all elements
     * are accumulated to a {@code int} result.
     * 
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code int} value with which to incorporate the
     *                first element, meging them as one {@code int} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static int reduce(char[] array, jdk.prim.util.function.PrimitiveBiFunction.ToInt.OfInt.AndChar acc, int initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyInt(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given {@code short} array whereby all elements
     * are accumulated to a {@code int} result.
     * 
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code int} value with which to incorporate the
     *                first element, meging them as one {@code int} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static int reduce(short[] array, jdk.prim.util.function.PrimitiveBiFunction.ToInt.OfInt.AndShort acc, int initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyInt(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given {@code byte} array whereby all elements
     * are accumulated to a {@code int} result.
     * 
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code int} value with which to incorporate the
     *                first element, meging them as one {@code int} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static int reduce(byte[] array, jdk.prim.util.function.PrimitiveBiFunction.ToInt.OfInt.AndByte acc, int initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyInt(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given {@code boolean} array whereby all elements
     * are accumulated to a {@code int} result.
     * 
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code int} value with which to incorporate the
     *                first element, meging them as one {@code int} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static int reduce(boolean[] array, jdk.prim.util.function.PrimitiveBiFunction.ToInt.OfInt.AndBoolean acc, int initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyInt(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given input array whereby all elements
     * are accumulated to a {@code float} result.
     * 
     * @param <T>     the type of the input array
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code float} value with which to incorporate the
     *                first element, meging them as one {@code float} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static <T> float reduce(T[] array, jdk.prim.util.function.PrimitiveBiFunction.ToFloat.OfFloat<T> acc, float initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyFloat(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given {@code double} array whereby all elements
     * are accumulated to a {@code float} result.
     * 
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code float} value with which to incorporate the
     *                first element, meging them as one {@code float} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static float reduce(double[] array, jdk.prim.util.function.PrimitiveBiFunction.ToFloat.OfFloat.AndDouble acc, float initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyFloat(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given {@code long} array whereby all elements
     * are accumulated to a {@code float} result.
     * 
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code float} value with which to incorporate the
     *                first element, meging them as one {@code float} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static float reduce(long[] array, jdk.prim.util.function.PrimitiveBiFunction.ToFloat.OfFloat.AndLong acc, float initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyFloat(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given {@code int} array whereby all elements
     * are accumulated to a {@code float} result.
     * 
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code float} value with which to incorporate the
     *                first element, meging them as one {@code float} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static float reduce(int[] array, jdk.prim.util.function.PrimitiveBiFunction.ToFloat.OfFloat.AndInt acc, float initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyFloat(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given {@code float} array whereby all elements
     * are accumulated to a {@code float} result.
     * 
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code float} value with which to incorporate the
     *                first element, meging them as one {@code float} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static float reduce(float[] array, jdk.prim.util.function.PrimitiveBiFunction.ToFloat.OfFloat.AndFloat acc, float initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyFloat(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given {@code char} array whereby all elements
     * are accumulated to a {@code float} result.
     * 
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code float} value with which to incorporate the
     *                first element, meging them as one {@code float} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static float reduce(char[] array, jdk.prim.util.function.PrimitiveBiFunction.ToFloat.OfFloat.AndChar acc, float initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyFloat(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given {@code short} array whereby all elements
     * are accumulated to a {@code float} result.
     * 
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code float} value with which to incorporate the
     *                first element, meging them as one {@code float} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static float reduce(short[] array, jdk.prim.util.function.PrimitiveBiFunction.ToFloat.OfFloat.AndShort acc, float initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyFloat(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given {@code byte} array whereby all elements
     * are accumulated to a {@code float} result.
     * 
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code float} value with which to incorporate the
     *                first element, meging them as one {@code float} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static float reduce(byte[] array, jdk.prim.util.function.PrimitiveBiFunction.ToFloat.OfFloat.AndByte acc, float initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyFloat(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given {@code boolean} array whereby all elements
     * are accumulated to a {@code float} result.
     * 
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code float} value with which to incorporate the
     *                first element, meging them as one {@code float} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static float reduce(boolean[] array, jdk.prim.util.function.PrimitiveBiFunction.ToFloat.OfFloat.AndBoolean acc, float initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyFloat(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given input array whereby all elements
     * are accumulated to a {@code char} result.
     * 
     * @param <T>     the type of the input array
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code char} value with which to incorporate the
     *                first element, meging them as one {@code char} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static <T> char reduce(T[] array, jdk.prim.util.function.PrimitiveBiFunction.ToChar.OfChar<T> acc, char initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyChar(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given {@code double} array whereby all elements
     * are accumulated to a {@code char} result.
     * 
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code char} value with which to incorporate the
     *                first element, meging them as one {@code char} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static char reduce(double[] array, jdk.prim.util.function.PrimitiveBiFunction.ToChar.OfChar.AndDouble acc, char initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyChar(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given {@code long} array whereby all elements
     * are accumulated to a {@code char} result.
     * 
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code char} value with which to incorporate the
     *                first element, meging them as one {@code char} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static char reduce(long[] array, jdk.prim.util.function.PrimitiveBiFunction.ToChar.OfChar.AndLong acc, char initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyChar(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given {@code int} array whereby all elements
     * are accumulated to a {@code char} result.
     * 
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code char} value with which to incorporate the
     *                first element, meging them as one {@code char} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static char reduce(int[] array, jdk.prim.util.function.PrimitiveBiFunction.ToChar.OfChar.AndInt acc, char initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyChar(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given {@code float} array whereby all elements
     * are accumulated to a {@code char} result.
     * 
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code char} value with which to incorporate the
     *                first element, meging them as one {@code char} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static char reduce(float[] array, jdk.prim.util.function.PrimitiveBiFunction.ToChar.OfChar.AndFloat acc, char initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyChar(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given {@code char} array whereby all elements
     * are accumulated to a {@code char} result.
     * 
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code char} value with which to incorporate the
     *                first element, meging them as one {@code char} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static char reduce(char[] array, jdk.prim.util.function.PrimitiveBiFunction.ToChar.OfChar.AndChar acc, char initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyChar(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given {@code short} array whereby all elements
     * are accumulated to a {@code char} result.
     * 
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code char} value with which to incorporate the
     *                first element, meging them as one {@code char} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static char reduce(short[] array, jdk.prim.util.function.PrimitiveBiFunction.ToChar.OfChar.AndShort acc, char initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyChar(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given {@code byte} array whereby all elements
     * are accumulated to a {@code char} result.
     * 
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code char} value with which to incorporate the
     *                first element, meging them as one {@code char} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static char reduce(byte[] array, jdk.prim.util.function.PrimitiveBiFunction.ToChar.OfChar.AndByte acc, char initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyChar(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given {@code boolean} array whereby all elements
     * are accumulated to a {@code char} result.
     * 
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code char} value with which to incorporate the
     *                first element, meging them as one {@code char} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static char reduce(boolean[] array, jdk.prim.util.function.PrimitiveBiFunction.ToChar.OfChar.AndBoolean acc, char initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyChar(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given input array whereby all elements
     * are accumulated to a {@code short} result.
     * 
     * @param <T>     the type of the input array
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code short} value with which to incorporate the
     *                first element, meging them as one {@code short} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static <T> short reduce(T[] array, jdk.prim.util.function.PrimitiveBiFunction.ToShort.OfShort<T> acc, short initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyShort(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given {@code double} array whereby all elements
     * are accumulated to a {@code short} result.
     * 
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code short} value with which to incorporate the
     *                first element, meging them as one {@code short} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static short reduce(double[] array, jdk.prim.util.function.PrimitiveBiFunction.ToShort.OfShort.AndDouble acc, short initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyShort(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given {@code long} array whereby all elements
     * are accumulated to a {@code short} result.
     * 
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code short} value with which to incorporate the
     *                first element, meging them as one {@code short} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static short reduce(long[] array, jdk.prim.util.function.PrimitiveBiFunction.ToShort.OfShort.AndLong acc, short initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyShort(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given {@code int} array whereby all elements
     * are accumulated to a {@code short} result.
     * 
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code short} value with which to incorporate the
     *                first element, meging them as one {@code short} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static short reduce(int[] array, jdk.prim.util.function.PrimitiveBiFunction.ToShort.OfShort.AndInt acc, short initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyShort(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given {@code float} array whereby all elements
     * are accumulated to a {@code short} result.
     * 
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code short} value with which to incorporate the
     *                first element, meging them as one {@code short} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static short reduce(float[] array, jdk.prim.util.function.PrimitiveBiFunction.ToShort.OfShort.AndFloat acc, short initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyShort(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given {@code char} array whereby all elements
     * are accumulated to a {@code short} result.
     * 
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code short} value with which to incorporate the
     *                first element, meging them as one {@code short} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static short reduce(char[] array, jdk.prim.util.function.PrimitiveBiFunction.ToShort.OfShort.AndChar acc, short initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyShort(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given {@code short} array whereby all elements
     * are accumulated to a {@code short} result.
     * 
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code short} value with which to incorporate the
     *                first element, meging them as one {@code short} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static short reduce(short[] array, jdk.prim.util.function.PrimitiveBiFunction.ToShort.OfShort.AndShort acc, short initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyShort(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given {@code byte} array whereby all elements
     * are accumulated to a {@code short} result.
     * 
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code short} value with which to incorporate the
     *                first element, meging them as one {@code short} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static short reduce(byte[] array, jdk.prim.util.function.PrimitiveBiFunction.ToShort.OfShort.AndByte acc, short initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyShort(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given {@code boolean} array whereby all elements
     * are accumulated to a {@code short} result.
     * 
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code short} value with which to incorporate the
     *                first element, meging them as one {@code short} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static short reduce(boolean[] array, jdk.prim.util.function.PrimitiveBiFunction.ToShort.OfShort.AndBoolean acc, short initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyShort(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given input array whereby all elements
     * are accumulated to a {@code byte} result.
     * 
     * @param <T>     the type of the input array
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code byte} value with which to incorporate the
     *                first element, meging them as one {@code byte} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static <T> byte reduce(T[] array, jdk.prim.util.function.PrimitiveBiFunction.ToByte.OfByte<T> acc, byte initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyByte(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given {@code double} array whereby all elements
     * are accumulated to a {@code byte} result.
     * 
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code byte} value with which to incorporate the
     *                first element, meging them as one {@code byte} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static byte reduce(double[] array, jdk.prim.util.function.PrimitiveBiFunction.ToByte.OfByte.AndDouble acc, byte initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyByte(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given {@code long} array whereby all elements
     * are accumulated to a {@code byte} result.
     * 
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code byte} value with which to incorporate the
     *                first element, meging them as one {@code byte} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static byte reduce(long[] array, jdk.prim.util.function.PrimitiveBiFunction.ToByte.OfByte.AndLong acc, byte initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyByte(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given {@code int} array whereby all elements
     * are accumulated to a {@code byte} result.
     * 
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code byte} value with which to incorporate the
     *                first element, meging them as one {@code byte} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static byte reduce(int[] array, jdk.prim.util.function.PrimitiveBiFunction.ToByte.OfByte.AndInt acc, byte initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyByte(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given {@code float} array whereby all elements
     * are accumulated to a {@code byte} result.
     * 
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code byte} value with which to incorporate the
     *                first element, meging them as one {@code byte} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static byte reduce(float[] array, jdk.prim.util.function.PrimitiveBiFunction.ToByte.OfByte.AndFloat acc, byte initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyByte(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given {@code char} array whereby all elements
     * are accumulated to a {@code byte} result.
     * 
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code byte} value with which to incorporate the
     *                first element, meging them as one {@code byte} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static byte reduce(char[] array, jdk.prim.util.function.PrimitiveBiFunction.ToByte.OfByte.AndChar acc, byte initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyByte(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given {@code short} array whereby all elements
     * are accumulated to a {@code byte} result.
     * 
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code byte} value with which to incorporate the
     *                first element, meging them as one {@code byte} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static byte reduce(short[] array, jdk.prim.util.function.PrimitiveBiFunction.ToByte.OfByte.AndShort acc, byte initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyByte(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given {@code byte} array whereby all elements
     * are accumulated to a {@code byte} result.
     * 
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code byte} value with which to incorporate the
     *                first element, meging them as one {@code byte} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static byte reduce(byte[] array, jdk.prim.util.function.PrimitiveBiFunction.ToByte.OfByte.AndByte acc, byte initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyByte(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given {@code boolean} array whereby all elements
     * are accumulated to a {@code byte} result.
     * 
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code byte} value with which to incorporate the
     *                first element, meging them as one {@code byte} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static byte reduce(boolean[] array, jdk.prim.util.function.PrimitiveBiFunction.ToByte.OfByte.AndBoolean acc, byte initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyByte(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given input array whereby all elements
     * are accumulated to a {@code boolean} result.
     * 
     * @param <T>     the type of the input array
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code boolean} value with which to incorporate the
     *                first element, meging them as one {@code boolean} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static <T> boolean reduce(T[] array, jdk.prim.util.function.PrimitiveBiFunction.ToBoolean.OfBoolean<T> acc, boolean initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyBoolean(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given {@code double} array whereby all elements
     * are accumulated to a {@code boolean} result.
     * 
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code boolean} value with which to incorporate the
     *                first element, meging them as one {@code boolean} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static boolean reduce(double[] array, jdk.prim.util.function.PrimitiveBiFunction.ToBoolean.OfBoolean.AndDouble acc,
            boolean initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyBoolean(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given {@code long} array whereby all elements
     * are accumulated to a {@code boolean} result.
     * 
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code boolean} value with which to incorporate the
     *                first element, meging them as one {@code boolean} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static boolean reduce(long[] array, jdk.prim.util.function.PrimitiveBiFunction.ToBoolean.OfBoolean.AndLong acc, boolean initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyBoolean(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given {@code int} array whereby all elements
     * are accumulated to a {@code boolean} result.
     * 
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code boolean} value with which to incorporate the
     *                first element, meging them as one {@code boolean} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static boolean reduce(int[] array, jdk.prim.util.function.PrimitiveBiFunction.ToBoolean.OfBoolean.AndInt acc, boolean initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyBoolean(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given {@code float} array whereby all elements
     * are accumulated to a {@code boolean} result.
     * 
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code boolean} value with which to incorporate the
     *                first element, meging them as one {@code boolean} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static boolean reduce(float[] array, jdk.prim.util.function.PrimitiveBiFunction.ToBoolean.OfBoolean.AndFloat acc, boolean initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyBoolean(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given {@code char} array whereby all elements
     * are accumulated to a {@code boolean} result.
     * 
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code boolean} value with which to incorporate the
     *                first element, meging them as one {@code boolean} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static boolean reduce(char[] array, jdk.prim.util.function.PrimitiveBiFunction.ToBoolean.OfBoolean.AndChar acc, boolean initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyBoolean(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given {@code short} array whereby all elements
     * are accumulated to a {@code boolean} result.
     * 
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code boolean} value with which to incorporate the
     *                first element, meging them as one {@code boolean} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static boolean reduce(short[] array, jdk.prim.util.function.PrimitiveBiFunction.ToBoolean.OfBoolean.AndShort acc, boolean initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyBoolean(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given {@code byte} array whereby all elements
     * are accumulated to a {@code boolean} result.
     * 
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code boolean} value with which to incorporate the
     *                first element, meging them as one {@code boolean} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static boolean reduce(byte[] array, jdk.prim.util.function.PrimitiveBiFunction.ToBoolean.OfBoolean.AndByte acc, boolean initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyBoolean(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs a reduction on the given {@code boolean} array whereby all elements
     * are accumulated to a {@code boolean} result.
     * 
     * @param array   the input array
     * @param acc     the function that combines the elements of the input
     *                array into a sinle result.
     * @param initial a {@code boolean} value with which to incorporate the
     *                first element, meging them as one {@code boolean} value.
     * @return the accumulated result. Will return {@code initial} is the
     *         input array is empty.
     */
    public static boolean reduce(boolean[] array, jdk.prim.util.function.PrimitiveBiFunction.ToBoolean.OfBoolean.AndBoolean acc,
            boolean initial) {
        for (int i = 0; i < array.length; i++) {
            initial = acc.applyBoolean(initial, array[i]);
        }
        return initial;
    }

    /**
     * Performs the given action on each element of the input array
     * 
     * @param <T>    the type of the input array
     * @param array  the input array
     * @param action the action to be performed
     */
    public static <T> void forEach(T[] array, Consumer<? super T> action) {
        for (T e : array) {
            action.accept(e);
        }
    }

    /**
     * Performs the given action on each element of the {@code double} array
     * 
     * @param array  the input array
     * @param action the action to be performed
     */
    public static void forEach(double[] array, jdk.prim.util.function.PrimitiveConsumer.OfDouble action) {
        for (double d : array)
            action.acceptDouble(d);
    }

    /**
     * Performs the given action on each element of the {@code long} array
     * 
     * @param array  the input array
     * @param action the action to be performed
     */
    public static void forEach(long[] array, jdk.prim.util.function.PrimitiveConsumer.OfLong action) {
        for (long l : array)
            action.acceptLong(l);
    }

    /**
     * Performs the given action on each element of the {@code int} array
     * 
     * @param array  the input array
     * @param action the action to be performed
     */
    public static void forEach(int[] array, jdk.prim.util.function.PrimitiveConsumer.OfInt action) {
        for (int i : array)
            action.acceptInt(i);
    }

    /**
     * Performs the given action on each element of the {@code float} array
     * 
     * @param array  the input array
     * @param action the action to be performed
     */
    public static void forEach(float[] array, jdk.prim.util.function.PrimitiveConsumer.OfFloat action) {
        for (float f : array)
            action.acceptFloat(f);
    }

    /**
     * Performs the given action on each element of the {@code char} array
     * 
     * @param array  the input array
     * @param action the action to be performed
     */
    public static void forEach(char[] array, jdk.prim.util.function.PrimitiveConsumer.OfChar action) {
        for (char c : array)
            action.acceptChar(c);
    }

    /**
     * Performs the given action on each element of the {@code short} array
     * 
     * @param array  the input array
     * @param action the action to be performed
     */
    public static void forEach(short[] array, jdk.prim.util.function.PrimitiveConsumer.OfShort action) {
        for (short s : array)
            action.acceptShort(s);
    }

    /**
     * Performs the given action on each element of the {@code byte} array
     * 
     * @param array  the input array
     * @param action the action to be performed
     */
    public static void forEach(byte[] array, jdk.prim.util.function.PrimitiveConsumer.OfByte action) {
        for (byte b : array)
            action.acceptByte(b);
    }

    /**
     * Performs the given action on each element of the {@code boolean} array
     * 
     * @param array  the input array
     * @param action the action to be performed
     */
    public static void forEach(boolean[] array, jdk.prim.util.function.PrimitiveConsumer.OfBoolean action) {
        for (boolean b : array)
            action.acceptBoolean(b);
    }
    /**
     * Reverses the encounter order of the elements in the given array and returns it.
     * <p>Note that this is a mutative operation so that when this method returns,
     * the input array will be reversed
     * @param <T> the type of the given array
     * @param array the array to be reversed
     * @return the argument
     */
    public static <T> T[] reverse(T[] array) {
        int halfLength = array.length / 2;
        for(int i = 0, j = array.length - 1; i < halfLength; i++, j--) {
            T e = array[i];
            array[i] = array[j];
            array[j] = e;
        }
        return array;
    }
    /**
     * Reverses the encounter order of the {@code double} elements in the given array and returns it.
     * <p>Note that this is a mutative operation so that when this method returns,
     * the input array will be reversed
     * @param array the array to be reversed
     * @return the argument
     */
    public static double[] reverse(double[] array) {
        int halfLength = array.length / 2;
        for(int i = 0, j = array.length - 1; i < halfLength; i++, j--) {
            double e = array[i];
            array[i] = array[j];
            array[j] = e;
        }
        return array;
    }
    /**
     * Reverses the encounter order of the {@code long} elements in the given array and returns it.
     * <p>Note that this is a mutative operation so that when this method returns,
     * the input array will be reversed
     * @param array the array to be reversed
     * @return the argument
     */
    public static long[] reverse(long[] array) {
        int halfLength = array.length / 2;
        for(int i = 0, j = array.length - 1; i < halfLength; i++, j--) {
            long e = array[i];
            array[i] = array[j];
            array[j] = e;
        }
        return array;
    }
    /**
     * Reverses the encounter order of the {@code int} elements in the given array and returns it.
     * <p>Note that this is a mutative operation so that when this method returns,
     * the input array will be reversed
     * @param array the array to be reversed
     * @return the argument
     */
    public static int[] reverse(int[] array) {
        int halfLength = array.length / 2;
        for(int i = 0, j = array.length - 1; i < halfLength; i++, j--) {
            int e = array[i];
            array[i] = array[j];
            array[j] = e;
        }
        return array;
    }
    /**
     * Reverses the encounter order of the {@code float} elements in the given array and returns it.
     * <p>Note that this is a mutative operation so that when this method returns,
     * the input array will be reversed
     * @param array the array to be reversed
     * @return the argument
     */
    public static float[] reverse(float[] array) {
        int halfLength = array.length / 2;
        for(int i = 0, j = array.length - 1; i < halfLength; i++, j--) {
            float e = array[i];
            array[i] = array[j];
            array[j] = e;
        }
        return array;
    }
    /**
     * Reverses the encounter order of the {@code char} elements in the given array and returns it.
     * <p>Note that this is a mutative operation so that when this method returns,
     * the input array will be reversed
     * @param array the array to be reversed
     * @return the argument
     */
    public static char[] reverse(char[] array) {
        int halfLength = array.length / 2;
        for(int i = 0, j = array.length - 1; i < halfLength; i++, j--) {
            char e = array[i];
            array[i] = array[j];
            array[j] = e;
        }
        return array;
    }
    /**
     * Reverses the encounter order of the {@code short} elements in the given array and returns it.
     * <p>Note that this is a mutative operation so that when this method returns,
     * the input array will be reversed
     * @param array the array to be reversed
     * @return the argument
     */
    public static short[] reverse(short[] array) {
        int halfLength = array.length / 2;
        for(int i = 0, j = array.length - 1; i < halfLength; i++, j--) {
            short e = array[i];
            array[i] = array[j];
            array[j] = e;
        }
        return array;
    }
    /**
     * Reverses the encounter order of the {@code byte} elements in the given array and returns it.
     * <p>Note that this is a mutative operation so that when this method returns,
     * the input array will be reversed
     * @param array the array to be reversed
     * @return the argument
     */
    public static byte[] reverse(byte[] array) {
        int halfLength = array.length / 2;
        for(int i = 0, j = array.length - 1; i < halfLength; i++, j--) {
            byte e = array[i];
            array[i] = array[j];
            array[j] = e;
        }
        return array;
    }
    /**
     * Reverses the encounter order of the {@code boolean} elements in the given array and returns it.
     * <p>Note that this is a mutative operation so that when this method returns,
     * the input array will be reversed
     * @param array the array to be reversed
     * @return the argument
     */
    public static boolean[] reverse(boolean[] array) {
        int halfLength = array.length / 2;
        for(int i = 0, j = array.length - 1; i < halfLength; i++, j--) {
            boolean e = array[i];
            array[i] = array[j];
            array[j] = e;
        }
        return array;
    }
    
}
