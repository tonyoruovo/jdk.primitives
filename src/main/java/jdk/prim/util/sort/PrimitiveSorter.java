package jdk.prim.util.sort;

import java.util.List;

import jdk.prim.util.PrimitiveComparator;

/**
 * A base interface for all objects that sorts a primitive array/collection.
 * <p>
 * They provide a mutable and immutable sort operations
 * 
 * @param <A> the type of the array (or iterable/collection) to be sorted
 * @param <C> the type of primitive comparator that compare 2 primitives of the same type
 */
public interface PrimitiveSorter<A, C extends PrimitiveComparator<?>> {

    /**
     * A representation of a sorting algorithm
     */
    enum Algorithm {
        /**
         * Represents Quick sort algorithms
         * 
         * @see <a href="https://en.wikipedia.org/wiki/Quicksort">Wikipedia's Quick
         *      sort</a>
         * @see https://awdesh.medium.com/dual-pivot-quick-sort-javas-default-sorting-algorithm-for-primitive-types-77342e1df5e5#:~:text=When%20input%20size%20array%20is,three%20parts%20around%202%20pivots.
         * @see https://www.researchgate.net/publication/283532116_Why_Is_Dual-Pivot_Quicksort_Fast
         */
        QUICK,
        /**
         * Represents Merge sort algorithms
         * 
         * @see <a href="https://en.wikipedia.org/wiki/Merge_sort">Wikipedia's Merge
         *      sort</a>
         */
        MERGE,
        /**
         * Represents Insertion sort algorithms
         * 
         * @see <a href="https://en.wikipedia.org/wiki/Insertion_sort">Wikipedia's
         *      Insertion sort</a>
         */
        INSERTION,
        /**
         * Represents Bubble sort algorithms
         * 
         * @see <a href="https://en.wikipedia.org/wiki/Bubble_sort">Wikipedia's Bubble
         *      sort</a>
         */
        BUBBLE,
    }

    /**
     * A {@link PrimitiveSorter} that sorts {@code double} arrays
     */
    interface OfDouble extends PrimitiveSorter<double[], PrimitiveComparator.OfDouble> {
    }

    /**
     * A {@link PrimitiveSorter} that sorts {@code long} arrays
     */
    interface OfLong extends PrimitiveSorter<long[], PrimitiveComparator.OfLong> {
    }

    /**
     * A {@link PrimitiveSorter} that sorts {@code int} arrays
     */
    interface OfInt extends PrimitiveSorter<int[], PrimitiveComparator.OfInt> {
    }

    /**
     * A {@link PrimitiveSorter} that sorts {@code float} arrays
     */
    interface OfFloat extends PrimitiveSorter<float[], PrimitiveComparator.OfFloat> {
    }

    /**
     * A {@link PrimitiveSorter} that sorts {@code char} arrays
     */
    interface OfChar extends PrimitiveSorter<char[], PrimitiveComparator.OfChar> {
    }

    /**
     * A {@link PrimitiveSorter} that sorts {@code short} arrays
     */
    interface OfShort extends PrimitiveSorter<short[], PrimitiveComparator.OfShort> {
    }

    /**
     * A {@link PrimitiveSorter} that sorts {@code byte} arrays
     */
    interface OfByte extends PrimitiveSorter<byte[], PrimitiveComparator.OfByte> {
    }

    /**
     * A {@link PrimitiveSorter} that sorts {@code boolean} arrays
     */
    interface OfBoolean extends PrimitiveSorter<boolean[], PrimitiveComparator.OfBoolean> {
    }

    /**
     * Gets all the sorting algorithms used by this sorter
     * 
     * @return a list (probably unmodifiable) of algorithms of {@code this}
     */
    List<PrimitiveSorter.Algorithm> getAlgorithms();

    /**
     * Sorts and <span style="font-weight:bolder">mutates</span> the given array
     * using the given comparator
     * for defining the final ordering and stores the result in the provided
     * {@code dst}. The final
     * form of the provided {@code dst} will have the same length as the {@code src}
     * parameter.
     * <p>
     * The recommended implementation is:
     * <ul>
     * <li>If {@code dst} is {@code null}, then {@code src} will be mutated making
     * this operation mutable, else, this operation is immutable and the result can
     * be retrieved at {@code dst}</li>
     * <li>If {@code dst} is not {@code null} and the length of {@code dst} is not
     * equal to the length of {@code src}, then {@code dst} is adjusted accordingly
     * so as to be equal in size/length to {@code src}</li>
     * </ul>
     * 
     * @param src        the value to be sorted
     * @param comparator the comparator to be applied to provide ordering to the
     *                   sort operation
     * @param dst        the array in which to store the final results. If this is
     * not {@code null} it should be immune to garbage collection e.g don't do:
     * <pre>{@code
     * float[] a = getFloats(...);
     * PrimitiveSorter.FloatArraySorter fs = getFloatArraySorter();
     * PrimitiveComparator.OfFloat c = getFloatComparator();
     * fs.sort(a, c, new float[]{});//bad code, result is now lost
     * </pre>
     */
    void sort(A src, C comparator, A dst);

    /**
     * Sorts and <span style="font-weight:bolder">mutates</span> the given array
     * using the
     * <span style="font-style:italic">natural ordering</span> of the elements and
     * stores the result in the
     * provided {@code dst}. The final form of the provided {@code dst} will have
     * the same length as
     * the {@code src} parameter being sorted.
     * <p>
     * The recommended implementation is:
     * <ul>
     * <li>If {@code dst} is {@code null}, then {@code src} will be mutated making
     * this operation mutative, else, this operation is immutable and the result can
     * be retrieved at {@code dst}</li>
     * <li>If {@code dst} is not {@code null} and the length of {@code dst} is not
     * equal to the length of {@code src}, then {@code dst} is adjusted accordingly
     * so as to be equal in size/length to {@code src}</li>
     * </ul>
     * 
     * @param src the value to be sorted
     * @param dst the array in which to store the final results. If this is
     * not {@code null} it should be immune to garbage collection e.g don't do:
     * <pre>{@code
     * float[] a = getFloats(...);
     * PrimitiveSorter.FloatArraySorter fs = getFloatArraySorter();
     * fs.sort(a, new float[]{});//bad code, result is now lost
     * }</pre>
     */
    void sort(A src, A dst);

}
