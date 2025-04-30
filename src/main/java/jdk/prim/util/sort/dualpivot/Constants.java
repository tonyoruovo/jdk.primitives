package jdk.prim.util.sort.dualpivot;

import jdk.prim.util.PrimitiveComparator;

interface Constants {

    int MAX_MIXED_INSERTION_SORT_SIZE = 65;

    int MAX_INSERTION_SORT_SIZE = 44;

    int MIN_PARALLEL_SORT_SIZE = 4 << 10;

    int MIN_TRY_MERGE_SIZE = 4 << 10;

    int MIN_FIRST_RUN_SIZE = 16;

    int MIN_FIRST_RUNS_FACTOR = 7;

    int MAX_RUN_CAPACITY = 5 << 10;

    int MIN_RUN_COUNT = 4;

    int MIN_PARALLEL_MERGE_PARTS_SIZE = 4 << 10;

    int MIN_BYTE_COUNTING_SORT_SIZE = 64;

    int MIN_SHORT_OR_CHAR_COUNTING_SORT_SIZE = 1750;

    int DELTA = 3 << 1;

    int MAX_RECURSION_DEPTH = 64 * DELTA;

    public static int getDepth(int pll, int size) {
        int depth = 0;

        while ((pll >>= 3) > 0 && (size >>= 2) > 0) {
            depth -= 2;
        }
        return depth;
    }

    /**
     * Represents a function that accepts the array and sorts the specified range
     * of the array into ascending order.
     */
    @FunctionalInterface
    interface SortOperation<A, OF, C extends PrimitiveComparator<OF>> {
        /**
         * Sorts the specified range of the array.
         *
         * @param a the array to be sorted
         * @param low the index of the first element, inclusive, to be sorted
         * @param high the index of the last element, exclusive, to be sorted
         */
        void sort(A a, int low, int high, C c);
    }

    /**
     * Sorts the specified range of the array into ascending numerical order.
     *
     * @param array the array to be sorted
     * @param low the index of the first element, inclusive, to be sorted
     * @param high the index of the last element, exclusive, to be sorted
     * @param so the method reference for the fallback implementation
     */
    static <A, OF, C extends PrimitiveComparator<OF>> void sort(A array, int low, int high, C c, SortOperation<A, OF, C> so) {
        so.sort(array, low, high, c);
    }

    /**
     * Represents a function that accepts the array and partitions the specified range
     * of the array using the pivots provided.
     */
    @FunctionalInterface
    interface PartitionOperation<A, OF, C extends PrimitiveComparator<OF>> {
        /**
         * Partitions the specified range of the array using the given pivots.
         *
         * @param a the array to be partitioned
         * @param low the index of the first element, inclusive, to be partitioned
         * @param high the index of the last element, exclusive, to be partitioned
         * @param pivotIndex1 the index of pivot1, the first pivot
         * @param pivotIndex2 the index of pivot2, the second pivot
         */
        int[] partition(A a, int low, int high, int pivotIndex1, int pivotIndex2, C c);
    }

    /**
     * Partitions the specified range of the array using the two pivots provided.
     *
     * @param array the array to be partitioned
     * @param low the index of the first element, inclusive, to be partitioned
     * @param high the index of the last element, exclusive, to be partitioned
     * @param pivotIndex1 the index of pivot1, the first pivot
     * @param pivotIndex2 the index of pivot2, the second pivot
     * @param po the method reference for the fallback implementation
     */
    static <A, OF, C extends PrimitiveComparator<OF>> int[] partition(A array, int low, int high, int pivotIndex1, int pivotIndex2, C c, PartitionOperation<A, OF, C> po) {
        return po.partition(array, low, high, pivotIndex1, pivotIndex2, c);
    }


}
