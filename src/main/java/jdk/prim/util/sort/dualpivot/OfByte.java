package jdk.prim.util.sort.dualpivot;

import static jdk.prim.util.sort.dualpivot.Constants.DELTA;
import static jdk.prim.util.sort.dualpivot.Constants.MAX_INSERTION_SORT_SIZE;
import static jdk.prim.util.sort.dualpivot.Constants.MAX_MIXED_INSERTION_SORT_SIZE;
import static jdk.prim.util.sort.dualpivot.Constants.MAX_RECURSION_DEPTH;
import static jdk.prim.util.sort.dualpivot.Constants.MAX_RUN_CAPACITY;
import static jdk.prim.util.sort.dualpivot.Constants.MIN_FIRST_RUNS_FACTOR;
import static jdk.prim.util.sort.dualpivot.Constants.MIN_FIRST_RUN_SIZE;
import static jdk.prim.util.sort.dualpivot.Constants.MIN_PARALLEL_MERGE_PARTS_SIZE;
import static jdk.prim.util.sort.dualpivot.Constants.MIN_PARALLEL_SORT_SIZE;
import static jdk.prim.util.sort.dualpivot.Constants.MIN_RUN_COUNT;
import static jdk.prim.util.sort.dualpivot.Constants.MIN_TRY_MERGE_SIZE;
import static jdk.prim.util.sort.dualpivot.Constants.getDepth;
import static jdk.prim.util.sort.dualpivot.Constants.partition;

import java.util.Arrays;
import java.util.concurrent.CountedCompleter;
import java.util.concurrent.RecursiveTask;

import jdk.prim.util.PrimitiveComparator;

/**
 * A {@code byte} implementation of {@link java.util.DualPivotQuicksort}
 */
public final class OfByte {

    private OfByte() {}

    public static void sort(byte[] a, PrimitiveComparator.OfByte comparator, int parallelism, int low, int high) {

        /*
         * Sort everything except NaNs,
         * which are already in place.
         */
        int size = high - low;

        if (parallelism > 1 && size > MIN_PARALLEL_SORT_SIZE) {
            int depth = getDepth(parallelism, size >> 12);
            byte[] b = depth == 0 ? null : new byte[size];
            new Sorter(null, a, b, low, size, low, depth, comparator).invoke();
        } else {
            sort(null, a, comparator, 0, low, high);
        }

    }

    private static void sort(Sorter sorter, byte[] a, PrimitiveComparator.OfByte comparator, int bits, int low, int high) {
        while (true) {
            int end = high - 1, size = high - low;
            /*
             * Run mixed insertion sort on small non-leftmost parts.
             */
            if (size < MAX_MIXED_INSERTION_SORT_SIZE + bits && (bits & 1) > 0) {
                Constants.sort(a, low, high, comparator, OfByte::mixedInsertionSort);
                return;
            }

            /*
             * Invoke insertion sort on small leftmost part.
             */
            if (size < MAX_INSERTION_SORT_SIZE) {
                Constants.sort(a, low, high, comparator, OfByte::insertionSort);
                return;
            }

            /*
             * Check if the whole array or large non-leftmost
             * parts are nearly sorted and then merge runs.
             */
            if ((bits == 0 || size > MIN_TRY_MERGE_SIZE && (bits & 1) > 0)
                    && tryMergeRuns(sorter, a, comparator, low, size)) {
                return;
            }

            /*
             * Switch to heap sort if execution
             * time is becoming quadratic.
             */
            if ((bits += DELTA) > MAX_RECURSION_DEPTH) {
                heapSort(a, low, high, comparator);
                return;
            }

            /*
             * Use an inexpensive approximation of the golden ratio
             * to select five sample elements and determine pivots.
             */
            int step = (size >> 3) * 3 + 3;

            /*
             * Five elements around (and including) the central element
             * will be used for pivot selection as described below. The
             * unequal choice of spacing these elements was empirically
             * determined to work well on a wide variety of inputs.
             */
            int e1 = low + step;
            int e5 = end - step;
            int e3 = (e1 + e5) >>> 1;
            int e2 = (e1 + e3) >>> 1;
            int e4 = (e3 + e5) >>> 1;
            byte a3 = a[e3];

            /*
             * Sort these elements in place by the combination
             * of 4-element sorting network and insertion sort.
             *
             *    5 ------o-----------o------------
             *            |           |
             *    4 ------|-----o-----o-----o------
             *            |     |           |
             *    2 ------o-----|-----o-----o------
             *                  |     |
             *    1 ------------o-----o------------
             */
            if (comparator.compareByte(a[e5], a[e2]) < 0) { byte t = a[e5]; a[e5] = a[e2]; a[e2] = t; }
            if (comparator.compareByte(a[e4], a[e1]) < 0) { byte t = a[e4]; a[e4] = a[e1]; a[e1] = t; }
            if (comparator.compareByte(a[e5], a[e4]) < 0) { byte t = a[e5]; a[e5] = a[e4]; a[e4] = t; }
            if (comparator.compareByte(a[e2], a[e1]) < 0) { byte t = a[e2]; a[e2] = a[e1]; a[e1] = t; }
            if (comparator.compareByte(a[e4], a[e2]) < 0) { byte t = a[e4]; a[e4] = a[e2]; a[e2] = t; }

            if (comparator.compareByte(a3, a[e2]) < 0) {
                if (comparator.compareByte(a3, a[e1]) < 0) {
                    a[e3] = a[e2]; a[e2] = a[e1]; a[e1] = a3;
                } else {
                    a[e3] = a[e2]; a[e2] = a3;
                }
            } else if (comparator.compareByte(a3, a[e4]) > 0) {
                if (comparator.compareByte(a3, a[e5]) > 0) {
                    a[e3] = a[e4]; a[e4] = a[e5]; a[e5] = a3;
                } else {
                    a[e3] = a[e4]; a[e4] = a3;
                }
            }

            // Pointers
            int lower; // The index of the last element of the left part
            int upper; // The index of the first element of the right part

            /*
             * Partitioning with 2 pivots in case of different elements.
             */
            if (comparator.compareByte(a[e1], a[e2]) < 0 && comparator.compareByte(a[e2], a[e3]) < 0 && comparator.compareByte(a[e3], a[e4]) < 0 && comparator.compareByte(a[e4], a[e5]) < 0) {

                /*
                * Use the first and fifth of the five sorted elements as
                * the pivots. These values are inexpensive approximation
                * of tertiles. Note, that pivot1 < pivot2.
                */
                int[] pivotIndices = partition(a, low, high, e1, e5, comparator, OfByte::partitionDualPivot);
                lower = pivotIndices[0];
                upper = pivotIndices[1];
                /*
                 * Sort non-left parts recursively (possibly in parallel),
                 * excluding known pivots.
                 */
                if (size > MIN_PARALLEL_SORT_SIZE && sorter != null) {
                    sorter.forkSorter(bits | 1, lower + 1, upper);
                    sorter.forkSorter(bits | 1, upper + 1, high);
                } else {
                    sort(sorter, a, comparator, bits | 1, lower + 1, upper);
                    sort(sorter, a, comparator, bits | 1, upper + 1, high);
                }

            } else { // Use single pivot in case of many equal elements

                /*
                 * Use the third of the five sorted elements as the pivot.
                 * This value is inexpensive approximation of the median.
                 */
                int[] pivotIndices = partition(a, low, high, e3, e3, comparator, OfByte::partitionSinglePivot);
                lower = pivotIndices[0];
                upper = pivotIndices[1];

                /*
                 * Sort the right part (possibly in parallel), excluding
                 * known pivot. All elements from the central part are
                 * equal and therefore already sorted.
                 */
                if (size > MIN_PARALLEL_SORT_SIZE && sorter != null) {
                    sorter.forkSorter(bits | 1, upper, high);
                } else {
                    sort(sorter, a, comparator, bits | 1, upper, high);
                }
            }
            high = lower; // Iterate along the left part
        }
    }

    /**
     * Partitions the specified range of the array using the two pivots provided.
     *
     * @param array the array to be partitioned
     * @param low the index of the first element, inclusive, for partitioning
     * @param high the index of the last element, exclusive, for partitioning
     * @param pivotIndex1 the index of pivot1, the first pivot
     * @param pivotIndex2 the index of pivot2, the second pivot
     *
     */
    @SuppressWarnings("unused")
    private static int[] partitionDualPivot(byte[] a, int low, int high, int pivotIndex1, int pivotIndex2, PrimitiveComparator.OfByte comparator) {
        int end = high - 1;
        int lower = low;
        int upper = end;

        int e1 = pivotIndex1;
        int e5 = pivotIndex2;
        byte pivot1 = a[e1];
        byte pivot2 = a[e5];

        /*
        * The first and the last elements to be sorted are moved
        * to the locations formerly occupied by the pivots. When
        * partitioning is completed, the pivots are swapped back
        * into their final positions, and excluded from the next
        * subsequent sorting.
        */
        a[e1] = a[lower];
        a[e5] = a[upper];

        /*
        * Skip elements, which are less or greater than the pivots.
        */
        while (comparator.compareByte(a[++lower], pivot1) < 0);
        while (comparator.compareByte(a[--upper], pivot2) > 0);

        /*
         * Backward 3-interval partitioning
         *
         *   left part                 central part          right part
         * +------------------------------------------------------------+
                  * |  < pivot1  |   ?   |  pivot1 <= && <= pivot2  |  > pivot2  |
         * +------------------------------------------------------------+
         *             ^       ^                            ^
         *             |       |                            |
         *           lower     k                          upper
         *
         * Invariants:
         *
         *              all in (low, lower] < pivot1
         *    pivot1 <= all in (k, upper)  <= pivot2
         *              all in [upper, end) > pivot2
         *
         * Pointer k is the last index of ?-part
         */
        for (int unused = --lower, k = ++upper; --k > lower; ) {
            byte ak = a[k];

            if (comparator.compareByte(ak, pivot1) < 0) { // Move a[k] to the left side
                while (lower < k) {
                    if (comparator.compareByte(a[++lower], pivot1) >= 0) {
                        if (comparator.compareByte(a[lower], pivot2) > 0) {
                            a[k] = a[--upper];
                            a[upper] = a[lower];
                        } else {
                            a[k] = a[lower];
                        }
                        a[lower] = ak;
                        break;
                    }
                }
            } else if (comparator.compareByte(ak, pivot2) > 0) { // Move a[k] to the right side
                a[k] = a[--upper];
                a[upper] = ak;
            }
        }

        /*
         * Swap the pivots into their final positions.
         */
        a[low] = a[lower]; a[lower] = pivot1;
        a[end] = a[upper]; a[upper] = pivot2;

        return new int[] {lower, upper};
    }

    /**
     * Partitions the specified range of the array using a single pivot provided.
     *
     * @param array the array to be partitioned
     * @param low the index of the first element, inclusive, for partitioning
     * @param high the index of the last element, exclusive, for partitioning
     * @param pivotIndex1 the index of pivot1, the first pivot
     * @param pivotIndex2 the index of pivot2, the second pivot
     */
    private static int[] partitionSinglePivot(byte[] a, int low, int high, int pivotIndex1, int pivotIndex2, PrimitiveComparator.OfByte comparator) {

        int end = high - 1;
        int lower = low;
        int upper = end;

        int e3 = pivotIndex1;
        byte pivot = a[e3];

        /*
        * The first element to be sorted is moved to the
        * location formerly occupied by the pivot. After
        * completion of partitioning the pivot is swapped
        * back into its final position, and excluded from
        * the next subsequent sorting.
        */
        a[e3] = a[lower];

        /*
         * Traditional 3-way (Dutch National Flag) partitioning
         *
         *   left part                 central part    right part
         * +------------------------------------------------------+
         * |   < pivot   |     ?     |   == pivot   |   > pivot   |
         * +------------------------------------------------------+
         *              ^           ^                ^
         *              |           |                |
         *            lower         k              upper
         *
         * Invariants:
         *
         *   all in (low, lower] < pivot
         *   all in (k, upper)  == pivot
         *   all in [upper, end] > pivot
         *
         * Pointer k is the last index of ?-part
         */
        for (int k = ++upper; --k > lower; ) {
            byte ak = a[k];

            if (comparator.compareByte(ak, pivot) != 0) {
                a[k] = pivot;

                if (comparator.compareByte(ak, pivot) < 0) { // Move a[k] to the left side
                    while (comparator.compareByte(a[++lower], pivot) < 0);

                    if (comparator.compareByte(a[lower], pivot) > 0) {
                        a[--upper] = a[lower];
                    }
                    a[lower] = ak;
                } else { // ak > pivot - Move a[k] to the right side
                    a[--upper] = ak;
                }
            }
        }

        /*
         * Swap the pivot into its final position.
         */
        a[low] = a[lower]; a[lower] = pivot;
        return new int[] {lower, upper};
    }

    /**
     * Sorts the specified range of the array using mixed insertion sort.
     *
     * Mixed insertion sort is combination of simple insertion sort,
     * pin insertion sort and pair insertion sort.
     *
     * In the context of Dual-Pivot Quicksort, the pivot element
     * from the left part plays the role of sentinel, because it
     * is less than any elements from the given part. Therefore,
     * expensive check of the left range can be skipped on each
     * iteration unless it is the leftmost call.
     *
     * @param a the array to be sorted
     * @param low the index of the first element, inclusive, to be sorted
     * @param high the index of the last element, exclusive, to be sorted
     */
    private static void mixedInsertionSort(byte[] a, int low, int high, PrimitiveComparator.OfByte comparator) {
        int size = high - low;
        int end = high - 3 * ((size >> 5) << 3);
        if (end == high) {

            /*
             * Invoke simple insertion sort on tiny array.
             */
            for (int i; ++low < end; ) {
                byte ai = a[i = low];

                while (comparator.compareByte(ai, a[--i]) < 0) {
                    a[i + 1] = a[i];
                }
                a[i + 1] = ai;
            }
        } else {

            /*
             * Start with pin insertion sort on small part.
             *
             * Pin insertion sort is extended simple insertion sort.
             * The main idea of this sort is to put elements larger
             * than an element called pin to the end of array (the
             * proper area for such elements). It avoids expensive
             * movements of these elements through the whole array.
             */
            byte pin = a[end];

            for (int i, p = high; ++low < end; ) {
                byte ai = a[i = low];

                if (comparator.compareByte(ai, a[i - 1]) < 0) { // Small element

                    /*
                     * Insert small element into sorted part.
                     */
                    a[i] = a[--i];

                    while (comparator.compareByte(ai, a[--i]) < 0) {
                        a[i + 1] = a[i];
                    }
                    a[i + 1] = ai;

                } else if (p > i && comparator.compareByte(ai, pin) > 0) { // Large element

                    /*
                     * Find element smaller than pin.
                     */
                    while (comparator.compareByte(a[--p], pin) > 0);

                    /*
                     * Swap it with large element.
                     */
                    if (p > i) {
                        ai = a[p];
                        a[p] = a[i];
                    }

                    /*
                     * Insert small element into sorted part.
                     */
                    while (comparator.compareByte(ai, a[--i]) < 0) {
                        a[i + 1] = a[i];
                    }
                    a[i + 1] = ai;
                }
            }

            /*
             * Continue with pair insertion sort on remain part.
             */
            for (int i; low < high; ++low) {
                byte a1 = a[i = low], a2 = a[++low];

                /*
                 * Insert two elements per iteration: at first, insert the
                 * larger element and then insert the smaller element, but
                 * from the position where the larger element was inserted.
                 */
                if (comparator.compareByte(a1, a2) > 0) {

                    while (comparator.compareByte(a1, a[--i]) < 0) {
                        a[i + 2] = a[i];
                    }
                    a[++i + 1] = a1;

                    while (comparator.compareByte(a2, a[--i]) < 0) {
                        a[i + 1] = a[i];
                    }
                    a[i + 1] = a2;

                } else if (comparator.compareByte(a1, a[i - 1]) < 0) {

                    while (comparator.compareByte(a2, a[--i]) < 0) {
                        a[i + 2] = a[i];
                    }
                    a[++i + 1] = a2;

                    while (comparator.compareByte(a1, a[--i]) < 0) {
                        a[i + 1] = a[i];
                    }
                    a[i + 1] = a1;
                }
            }
        }
    }

    /**
     * Sorts the specified range of the array using insertion sort.
     *
     * @param a the array to be sorted
     * @param low the index of the first element, inclusive, to be sorted
     * @param high the index of the last element, exclusive, to be sorted
     */
    private static void insertionSort(byte[] a, int low, int high, PrimitiveComparator.OfByte comparator) {
        for (int i, k = low; ++k < high; ) {
            byte ai = a[i = k];

            if (comparator.compareByte(ai, a[i - 1]) < 0) {
                while (--i >= low && comparator.compareByte(ai, a[i]) < 0) {
                    a[i + 1] = a[i];
                }
                a[i + 1] = ai;
            }
        }
    }

    /**
     * Sorts the specified range of the array using heap sort.
     *
     * @param a the array to be sorted
     * @param low the index of the first element, inclusive, to be sorted
     * @param high the index of the last element, exclusive, to be sorted
     */
    private static void heapSort(byte[] a, int low, int high, PrimitiveComparator.OfByte comparator) {
        for (int k = (low + high) >>> 1; k > low; ) {
            pushDown(a, --k, a[k], low, high, comparator);
        }
        while (--high > low) {
            byte max = a[low];
            pushDown(a, low, a[high], low, high, comparator);
            a[high] = max;
        }
    }

    /**
     * Pushes specified element down during heap sort.
     *
     * @param a the given array
     * @param p the start index
     * @param value the given element
     * @param low the index of the first element, inclusive, to be sorted
     * @param high the index of the last element, exclusive, to be sorted
     */
    private static void pushDown(byte[] a, int p, byte value, int low, int high, PrimitiveComparator.OfByte comparator) {
        for (int k ;; a[p] = a[p = k]) {
            k = (p << 1) - low + 2; // Index of the right child

            if (k > high) {
                break;
            }
            if (k == high || comparator.compareByte(a[k], a[k - 1]) < 0) {
                --k;
            }
            if (comparator.compareByte(a[k], value) <= 0) {
                break;
            }
        }
        a[p] = value;
    }

    /**
     * Tries to sort the specified range of the array.
     *
     * @param sorter parallel context
     * @param a the array to be sorted
     * @param low the index of the first element to be sorted
     * @param size the array size
     * @return true if finally sorted, false otherwise
     */
    private static boolean tryMergeRuns(Sorter sorter, byte[] a, PrimitiveComparator.OfByte comparator, int low, int size) {

        /*
         * The run array is constructed only if initial runs are
         * long enough to continue, run[i] then holds start index
         * of the i-th sequence of elements in non-descending order.
         */
        int[] run = null;
        int high = low + size;
        int count = 1, last = low;

        /*
         * Identify all possible runs.
         */
        for (int k = low + 1; k < high; ) {

            /*
             * Find the end index of the current run.
             */
            if (comparator.compareByte(a[k - 1], a[k]) < 0) {

                // Identify ascending sequence
                while (++k < high && comparator.compareByte(a[k - 1], a[k]) <= 0);

            } else if (comparator.compareByte(a[k - 1], a[k]) > 0) {

                // Identify descending sequence
                while (++k < high && comparator.compareByte(a[k - 1], a[k]) >= 0);

                // Reverse into ascending order
                for (int i = last - 1, j = k; ++i < --j && comparator.compareByte(a[i], a[j]) > 0; ) {
                    byte ai = a[i]; a[i] = a[j]; a[j] = ai;
                }
            } else { // Identify constant sequence
                for (byte ak = a[k]; ++k < high && comparator.compareByte(ak, a[k]) == 0; );

                if (k < high) {
                    continue;
                }
            }

            /*
             * Check special cases.
             */
            if (run == null) {
                if (k == high) {

                    /*
                     * The array is monotonous sequence,
                     * and therefore already sorted.
                     */
                    return true;
                }

                if (k - low < MIN_FIRST_RUN_SIZE) {

                    /*
                     * The first run is too small
                     * to proceed with scanning.
                     */
                    return false;
                }

                run = new int[((size >> 10) | 0x7F) & 0x3FF];
                run[0] = low;

            } else if (comparator.compareByte(a[last - 1], a[last]) > 0) {

                if (count > (k - low) >> MIN_FIRST_RUNS_FACTOR) {

                    /*
                     * The first runs are not long
                     * enough to continue scanning.
                     */
                    return false;
                }

                if (++count == MAX_RUN_CAPACITY) {

                    /*
                     * Array is not highly structured.
                     */
                    return false;
                }

                if (count == run.length) {

                    /*
                     * Increase capacity of index array.
                     */
                    run = Arrays.copyOf(run, count << 1);
                }
            }
            run[count] = (last = k);
        }

        /*
         * Merge runs of highly structured array.
         */
        if (count > 1) {
            byte[] b; int offset = low;

            if (sorter == null || (b = sorter.b) == null) {
                b = new byte[size];
            } else {
                offset = sorter.offset;
            }
            mergeRuns(a, b, comparator, offset, 1, sorter != null, run, 0, count);
        }
        return true;
    }

    /**
     * Merges the specified runs.
     *
     * @param a the source array
     * @param b the temporary buffer used in merging
     * @param offset the start index in the source, inclusive
     * @param aim specifies merging: to source ( > 0), buffer ( < 0) or any ( == 0)
     * @param parallel indicates whether merging is performed in parallel
     * @param run the start indexes of the runs, inclusive
     * @param lo the start index of the first run, inclusive
     * @param hi the start index of the last run, inclusive
     * @return the destination where runs are merged
     */
    private static byte[] mergeRuns(byte[] a, byte[] b, PrimitiveComparator.OfByte comparator, int offset,
            int aim, boolean parallel, int[] run, int lo, int hi) {

        if (hi - lo == 1) {
            if (aim >= 0) {
                return a;
            }
            for (int i = run[hi], j = i - offset, low = run[lo]; i > low;
                b[--j] = a[--i]
            );
            return b;
        }

        /*
         * Split into approximately equal parts.
         */
        int mi = lo, rmi = (run[lo] + run[hi]) >>> 1;
        while (run[++mi + 1] <= rmi);

        /*
         * Merge the left and right parts.
         */
        byte[] a1, a2;

        if (parallel && hi - lo > MIN_RUN_COUNT) {
            RunMerger merger = new RunMerger(a, b, comparator, offset, 0, run, mi, hi).forkMe();
            a1 = mergeRuns(a, b, comparator, offset, -aim, true, run, lo, mi);
            a2 = merger.getDestination();
        } else {
            a1 = mergeRuns(a, b, comparator, offset, -aim, false, run, lo, mi);
            a2 = mergeRuns(a, b, comparator, offset,    0, false, run, mi, hi);
        }

        byte[] dst = a1 == a ? b : a;

        int k   = a1 == a ? run[lo] - offset : run[lo];
        int lo1 = a1 == b ? run[lo] - offset : run[lo];
        int hi1 = a1 == b ? run[mi] - offset : run[mi];
        int lo2 = a2 == b ? run[mi] - offset : run[mi];
        int hi2 = a2 == b ? run[hi] - offset : run[hi];

        if (parallel) {
            new Merger(null, dst, k, a1, lo1, hi1, a2, lo2, hi2, comparator).invoke();
        } else {
            mergeParts(null, dst, k, a1, lo1, hi1, a2, lo2, hi2, comparator);
        }
        return dst;
    }

    /**
     * Merges the sorted parts.
     *
     * @param merger parallel context
     * @param dst the destination where parts are merged
     * @param k the start index of the destination, inclusive
     * @param a1 the first part
     * @param lo1 the start index of the first part, inclusive
     * @param hi1 the end index of the first part, exclusive
     * @param a2 the second part
     * @param lo2 the start index of the second part, inclusive
     * @param hi2 the end index of the second part, exclusive
     */
    private static void mergeParts(Merger merger, byte[] dst, int k,
            byte[] a1, int lo1, int hi1, byte[] a2, int lo2, int hi2, PrimitiveComparator.OfByte comparator) {

        if (merger != null && a1 == a2) {

            while (true) {

                /*
                 * The first part must be larger.
                 */
                if (hi1 - lo1 < hi2 - lo2) {
                    int lo = lo1; lo1 = lo2; lo2 = lo;
                    int hi = hi1; hi1 = hi2; hi2 = hi;
                }

                /*
                 * Small parts will be merged sequentially.
                 */
                if (hi1 - lo1 < MIN_PARALLEL_MERGE_PARTS_SIZE) {
                    break;
                }

                /*
                 * Find the median of the larger part.
                 */
                int mi1 = (lo1 + hi1) >>> 1;
                byte key = a1[mi1];
                int mi2 = hi2;

                /*
                 * Partition the smaller part.
                 */
                for (int loo = lo2; loo < mi2; ) {
                    int t = (loo + mi2) >>> 1;

                    if (comparator.compareByte(key, a2[t]) > 0) {
                        loo = t + 1;
                    } else {
                        mi2 = t;
                    }
                }

                int d = mi2 - lo2 + mi1 - lo1;

                /*
                 * Merge the right sub-parts in parallel.
                 */
                merger.forkMerger(dst, k + d, a1, mi1, hi1, a2, mi2, hi2);

                /*
                 * Process the sub-left parts.
                 */
                hi1 = mi1;
                hi2 = mi2;
            }
        }

        /*
         * Merge small parts sequentially.
         */
        while (lo1 < hi1 && lo2 < hi2) {
            dst[k++] = comparator.compareByte(a1[lo1], a2[lo2]) < 0 ? a1[lo1++] : a2[lo2++];
        }
        if (dst != a1 || k < lo1) {
            while (lo1 < hi1) {
                dst[k++] = a1[lo1++];
            }
        }
        if (dst != a2 || k < lo2) {
            while (lo2 < hi2) {
                dst[k++] = a2[lo2++];
            }
        }
    }

    /**
     * This class implements parallel sorting.
     */
    private static final class Sorter extends CountedCompleter<Void> {
        private static final long serialVersionUID = 20180818L;
        private final byte[] a, b;
        private final int low, size, offset, depth;
        private final PrimitiveComparator.OfByte comp;

        private Sorter(CountedCompleter<?> parent,
                byte[] a, byte[] b, int low, int size, int offset, int depth, PrimitiveComparator.OfByte comp) {
            super(parent);
            this.a = a;
            this.b = b;
            this.low = low;
            this.size = size;
            this.offset = offset;
            this.depth = depth;
            this.comp = comp;
        }

        @Override
        public final void compute() {
            if (depth < 0) {
                setPendingCount(2);
                int half = size >> 1;
                new Sorter(this, b, a, low, half, offset, depth + 1, comp).fork();
                new Sorter(this, b, a, low + half, size - half, offset, depth + 1, comp).compute();
            } else {
                sort(a, comp, depth, low, low + size);
            }
            tryComplete();
        }

        @Override
        public final void onCompletion(CountedCompleter<?> caller) {
            if (depth < 0) {
                int mi = low + (size >> 1);
                boolean src = (depth & 1) == 0;

                new Merger(null,
                    a,
                    src ? low : low - offset,
                    b,
                    src ? low - offset : low,
                    src ? mi - offset : mi,
                    b,
                    src ? mi - offset : mi,
                    src ? low + size - offset : low + size,
                    comp
                ).invoke();
            }
        }

        private void forkSorter(int depth, int low, int high) {
            addToPendingCount(1);
            byte[] a = this.a; // Use local variable for performance
            new Sorter(this, a, b, low, high - low, offset, depth, comp).fork();
        }
    }

    /**
     * This class implements parallel merging.
     */
    private static final class Merger extends CountedCompleter<Void> {
        private static final long serialVersionUID = 20180818L;
        private final byte[] dst, a1, a2;
        private final int k, lo1, hi1, lo2, hi2;
        private final PrimitiveComparator.OfByte comparator;

        private Merger(CountedCompleter<?> parent, byte[] dst, int k,
                byte[] a1, int lo1, int hi1, byte[] a2, int lo2, int hi2, PrimitiveComparator.OfByte comparator) {
            super(parent);
            this.dst = dst;
            this.k = k;
            this.a1 = a1;
            this.lo1 = lo1;
            this.hi1 = hi1;
            this.a2 = a2;
            this.lo2 = lo2;
            this.hi2 = hi2;
            this.comparator = comparator;
        }

        @Override
        public final void compute() {
            mergeParts(this, dst, k,
                a1, lo1, hi1, a2, lo2, hi2, comparator);
            propagateCompletion();
        }

        private void forkMerger(byte[] dst, int k,
                byte[] a1, int lo1, int hi1, byte[] a2, int lo2, int hi2) {
            addToPendingCount(1);
            new Merger(this, dst, k, a1, lo1, hi1, a2, lo2, hi2, comparator).fork();
        }
    }

    /**
     * This class implements parallel merging of runs.
     */
    private static final class RunMerger extends RecursiveTask<byte[]> {
        private static final long serialVersionUID = 20180818L;
        private final byte[] a, b;
        private final PrimitiveComparator.OfByte comparator;
        private final int[] run;
        private final int offset, aim, lo, hi;

        private RunMerger(byte[] a, byte[] b, PrimitiveComparator.OfByte comparator, int offset,
                int aim, int[] run, int lo, int hi) {
            this.a = a;
            this.b = b;
            this.offset = offset;
            this.aim = aim;
            this.run = run;
            this.lo = lo;
            this.hi = hi;
            this.comparator = comparator;
        }

        @Override
        protected final byte[] compute() {
            return mergeRuns(a, b, comparator, offset, aim, true, run, lo, hi);
        }

        private RunMerger forkMe() {
            fork();
            return this;
        }

        private byte[] getDestination() {
            join();
            return getRawResult();
        }
    }

}
