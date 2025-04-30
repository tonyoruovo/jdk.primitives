package jdk.prim.util.sort;

import java.util.List;

import jdk.prim.util.PrimitiveArrays;
import jdk.prim.util.PrimitiveComparator;

/**A class that contains primitive implementations of a very basic single threaded quick sort algorithm. It's main purpose is to serve as a fallback for code on environments where multi-threading isn't possible */
public final class PrimitiveNaiveQuickSort {
    /**Cannot be instantiated*/
    private PrimitiveNaiveQuickSort() {}
    
    /**
     * Returns a basic quick sort implementation to work with {@code double} arrays
     * @param midPivot check for using the mid index as the the pivot index as opposed to the last value
     * @return a sorter of {@code double} arrays using the quick sort method
     */
    public static PrimitiveSorter.OfDouble ofDouble(boolean midPivot) {
        return new OfDouble(midPivot);
    }
    /**
     * Returns a basic quick sort implementation to work with {@code long} arrays
     * @param midPivot check for using the mid index as the the pivot index as opposed to the last value
     * @return a sorter of {@code long} arrays using the quick sort method
     */
    public static PrimitiveSorter.OfLong ofLong(boolean midPivot) {
        return new OfLong(midPivot);
    }
    /**
     * Returns a basic quick sort implementation to work with {@code int} arrays
     * @param midPivot check for using the mid index as the the pivot index as opposed to the last value
     * @return a sorter of {@code int} arrays using the quick sort method
     */
    public static PrimitiveSorter.OfInt ofInt(boolean midPivot) {
        return new OfInt(midPivot);
    }
    /**
     * Returns a basic quick sort implementation to work with {@code float} arrays
     * @param midPivot check for using the mid index as the the pivot index as opposed to the last value
     * @return a sorter of {@code float} arrays using the quick sort method
     */
    public static PrimitiveSorter.OfFloat ofFloat(boolean midPivot) {
        return new OfFloat(midPivot);
    }
    /**
     * Returns a basic quick sort implementation to work with {@code char} arrays
     * @param midPivot check for using the mid index as the the pivot index as opposed to the last value
     * @return a sorter of {@code char} arrays using the quick sort method
     */
    public static PrimitiveSorter.OfChar ofChar(boolean midPivot) {
        return new OfChar(midPivot);
    }
    /**
     * Returns a basic quick sort implementation to work with {@code short} arrays
     * @param midPivot check for using the mid index as the the pivot index as opposed to the last value
     * @return a sorter of {@code short} arrays using the quick sort method
     */
    public static PrimitiveSorter.OfShort ofShort(boolean midPivot) {
        return new OfShort(midPivot);
    }
    /**
     * Returns a basic quick sort implementation to work with {@code byte} arrays
     * @param midPivot check for using the mid index as the the pivot index as opposed to the last value
     * @return a sorter of {@code byte} arrays using the quick sort method
     */
    public static PrimitiveSorter.OfByte ofByte(boolean midPivot) {
        return new OfByte(midPivot);
    }
    /**
     * Returns a basic quick sort implementation to work with {@code boolean} arrays
     * @param midPivot check for using the mid index as the the pivot index as opposed to the last value
     * @return a sorter of {@code boolean} arrays using the quick sort method
     */
    public static PrimitiveSorter.OfBoolean ofBoolean(boolean midPivot) {
        return new OfBoolean(midPivot);
    }

    private static class OfDouble implements PrimitiveSorter.OfDouble {
        private final boolean optimize;
        OfDouble(boolean optimise) {
            this.optimize = optimise;
        }
        @Override
        public List<Algorithm> getAlgorithms() {
            return List.of(Algorithm.QUICK);
        }
        @Override
        public void sort(double[] src, PrimitiveComparator.OfDouble comparator, double[] dst) {
            if(dst == null) dst = src;
            else {
                if(dst.length != src.length) dst = new double[src.length];
                System.arraycopy(src, 0, dst, 0, src.length);
            }

            if(!optimize) applySort(dst, comparator, 0, dst.length - 1);
            else applyOptimizedSort(dst, comparator, 0, dst.length - 1);
        }
        @Override
        public void sort(double[] src, double[] dst) {
            if(dst == null) dst = src;
            else {
                if(dst.length != src.length) dst = new double[src.length];
                System.arraycopy(src, 0, dst, 0, src.length);
            }

            if(dst.length < 500 || !optimize) applySort(dst, 0, dst.length - 1);
            else applyOptimizedSort(dst, 0, dst.length - 1);
        }
        private void applyOptimizedSort(double[] a, PrimitiveComparator.OfDouble c, int l, int h) {
            if(l >= h) return;
            int p = partitionOptimized(a, c, l, h);

            applyOptimizedSort(a, c, l, p - 1);
            applyOptimizedSort(a, c, p + 1, h);
        }
        private void applyOptimizedSort(double[] a, int l, int h) {
            if(l >= h) return;
            int p = partitionOptimized(a, l, h);

            applyOptimizedSort(a, l, p - 1);
            applyOptimizedSort(a, p + 1, h);
        }
        private void applySort(double[] a, PrimitiveComparator.OfDouble c, int lowestIndex, int highestIndex) {
            if(lowestIndex > highestIndex) return;
            int partitionIndex = partition(a, c, lowestIndex, highestIndex);

            applySort(a, c, lowestIndex, partitionIndex - 1); // left
            applySort(a, c, partitionIndex + 1, highestIndex); // right
        }
        private int partitionOptimized(double[] a, PrimitiveComparator.OfDouble c, int l, int h) {
            int mid = (l + h) / 2;

            double pivot = a[mid];

            PrimitiveArrays.swap(a, mid, h);
            
            int prev = l - 1;

            for (int current = l; current < h; current++) {
                if(c.compareDouble(a[current], pivot) <= 0) {
                    prev++;
                    PrimitiveArrays.swap(a, prev, current);
                }
            }

            PrimitiveArrays.swap(a, prev + 1, h);

            return prev + 1;
        }
        private int partitionOptimized(double[] a, int l, int h) {
            int mid = (l + h) / 2;
            double pivot = a[mid];

            PrimitiveArrays.swap(a, mid, h);

            int prev = l - 1;

            for (int current = l; current < h; current++) {
                if(a[current] <= pivot) {
                    prev++;
                    PrimitiveArrays.swap(a, prev, current);
                }
            }

            PrimitiveArrays.swap(a, prev + 1, h);

            return prev + 1;
        }
        private void applySort(double[] a, int lowestIndex, int highestIndex) {
            if(lowestIndex > highestIndex) return;
            int partitionIndex = partition(a, lowestIndex, highestIndex);

            applySort(a, lowestIndex, partitionIndex - 1); // left
            applySort(a, partitionIndex + 1, highestIndex); // right
        }
        private int partition(double[] a, PrimitiveComparator.OfDouble c, int l, int h) {
            double pivot = a[h];

            int next = l - 1;

            for (int current = l; current < h; current++) {
                if(c.compareDouble(a[current], pivot) <= 0) {
                    next++;
                    PrimitiveArrays.swap(a, next, current);
                }
            }

            PrimitiveArrays.swap(a, next + 1, h);

            return next + 1;
        }
        private int partition(double[] a, int l, int h) {
            double pivot = a[h];

            int next = l - 1;

            for (int current = l; current < h; current++) {
                if(a[current] <= pivot) {
                    next++;
                    PrimitiveArrays.swap(a, next, current);
                }
            }

            PrimitiveArrays.swap(a, next + 1, h);

            return next + 1;
        }
    }
    private static class OfLong implements PrimitiveSorter.OfLong {
        private final boolean optimize;
        OfLong(boolean optimise) {
            this.optimize = optimise;
        }
        @Override
        public List<Algorithm> getAlgorithms() {
            return List.of(Algorithm.QUICK);
        }
        @Override
        public void sort(long[] src, PrimitiveComparator.OfLong comparator, long[] dst) {
            if(dst == null) dst = src;
            else {
                if(dst.length != src.length) dst = new long[src.length];
                System.arraycopy(src, 0, dst, 0, src.length);
            }

            if(!optimize) applySort(dst, comparator, 0, dst.length - 1);
            else applyOptimizedSort(dst, comparator, 0, dst.length - 1);
        }
        @Override
        public void sort(long[] src, long[] dst) {
            if(dst == null) dst = src;
            else {
                if(dst.length != src.length) dst = new long[src.length];
                System.arraycopy(src, 0, dst, 0, src.length);
            }

            if(dst.length < 500 || !optimize) applySort(dst, 0, dst.length - 1);
            else applyOptimizedSort(dst, 0, dst.length - 1);
        }
        private void applyOptimizedSort(long[] a, PrimitiveComparator.OfLong c, int l, int h) {
            if(l >= h) return;
            int p = partitionOptimized(a, c, l, h);

            applyOptimizedSort(a, c, l, p - 1);
            applyOptimizedSort(a, c, p + 1, h);
        }
        private void applyOptimizedSort(long[] a, int l, int h) {
            if(l >= h) return;
            int p = partitionOptimized(a, l, h);

            applyOptimizedSort(a, l, p - 1);
            applyOptimizedSort(a, p + 1, h);
        }
        private void applySort(long[] a, PrimitiveComparator.OfLong c, int lowestIndex, int highestIndex) {
            if(lowestIndex > highestIndex) return;
            int partitionIndex = partition(a, c, lowestIndex, highestIndex);

            applySort(a, c, lowestIndex, partitionIndex - 1); // left
            applySort(a, c, partitionIndex + 1, highestIndex); // right
        }
        private int partitionOptimized(long[] a, PrimitiveComparator.OfLong c, int l, int h) {
            int mid = (l + h) / 2;

            long pivot = a[mid];

            PrimitiveArrays.swap(a, mid, h);
            
            int prev = l - 1;

            for (int current = l; current < h; current++) {
                if(c.compareLong(a[current], pivot) <= 0) {
                    prev++;
                    PrimitiveArrays.swap(a, prev, current);
                }
            }

            PrimitiveArrays.swap(a, prev + 1, h);

            return prev + 1;
        }
        private int partitionOptimized(long[] a, int l, int h) {
            int mid = (l + h) / 2;
            long pivot = a[mid];

            PrimitiveArrays.swap(a, mid, h);

            int prev = l - 1;

            for (int current = l; current < h; current++) {
                if(a[current] <= pivot) {
                    prev++;
                    PrimitiveArrays.swap(a, prev, current);
                }
            }

            PrimitiveArrays.swap(a, prev + 1, h);

            return prev + 1;
        }
        private void applySort(long[] a, int lowestIndex, int highestIndex) {
            if(lowestIndex > highestIndex) return;
            int partitionIndex = partition(a, lowestIndex, highestIndex);

            applySort(a, lowestIndex, partitionIndex - 1); // left
            applySort(a, partitionIndex + 1, highestIndex); // right
        }
        private int partition(long[] a, PrimitiveComparator.OfLong c, int l, int h) {
            long pivot = a[h];

            int next = l - 1;

            for (int current = l; current < h; current++) {
                if(c.compareLong(a[current], pivot) <= 0) {
                    next++;
                    PrimitiveArrays.swap(a, next, current);
                }
            }

            PrimitiveArrays.swap(a, next + 1, h);

            return next + 1;
        }
        private int partition(long[] a, int l, int h) {
            long pivot = a[h];

            int next = l - 1;

            for (int current = l; current < h; current++) {
                if(a[current] <= pivot) {
                    next++;
                    PrimitiveArrays.swap(a, next, current);
                }
            }

            PrimitiveArrays.swap(a, next + 1, h);

            return next + 1;
        }
    }
    private static class OfInt implements PrimitiveSorter.OfInt {
        private final boolean optimize;
        OfInt(boolean optimise) {
            this.optimize = optimise;
        }
        @Override
        public List<Algorithm> getAlgorithms() {
            return List.of(Algorithm.QUICK);
        }
        @Override
        public void sort(int[] src, PrimitiveComparator.OfInt comparator, int[] dst) {
            if(dst == null) dst = src;
            else {
                if(dst.length != src.length) dst = new int[src.length];
                System.arraycopy(src, 0, dst, 0, src.length);
            }

            if(!optimize) applySort(dst, comparator, 0, dst.length - 1);
            else applyOptimizedSort(dst, comparator, 0, dst.length - 1);
        }
        @Override
        public void sort(int[] src, int[] dst) {
            if(dst == null) dst = src;
            else {
                if(dst.length != src.length) dst = new int[src.length];
                System.arraycopy(src, 0, dst, 0, src.length);
            }

            if(dst.length < 500 || !optimize) applySort(dst, 0, dst.length - 1);
            else applyOptimizedSort(dst, 0, dst.length - 1);
        }
        private void applyOptimizedSort(int[] a, PrimitiveComparator.OfInt c, int l, int h) {
            if(l >= h) return;
            int p = partitionOptimized(a, c, l, h);

            applyOptimizedSort(a, c, l, p - 1);
            applyOptimizedSort(a, c, p + 1, h);
        }
        private void applyOptimizedSort(int[] a, int l, int h) {
            if(l >= h) return;
            int p = partitionOptimized(a, l, h);

            applyOptimizedSort(a, l, p - 1);
            applyOptimizedSort(a, p + 1, h);
        }
        private void applySort(int[] a, PrimitiveComparator.OfInt c, int lowestIndex, int highestIndex) {
            if(lowestIndex > highestIndex) return;
            int partitionIndex = partition(a, c, lowestIndex, highestIndex);

            applySort(a, c, lowestIndex, partitionIndex - 1); // left
            applySort(a, c, partitionIndex + 1, highestIndex); // right
        }
        private int partitionOptimized(int[] a, PrimitiveComparator.OfInt c, int l, int h) {
            int mid = (l + h) / 2;

            int pivot = a[mid];

            PrimitiveArrays.swap(a, mid, h);
            
            int prev = l - 1;

            for (int current = l; current < h; current++) {
                if(c.compareInt(a[current], pivot) <= 0) {
                    prev++;
                    PrimitiveArrays.swap(a, prev, current);
                }
            }

            PrimitiveArrays.swap(a, prev + 1, h);

            return prev + 1;
        }
        private int partitionOptimized(int[] a, int l, int h) {
            int mid = (l + h) / 2;
            int pivot = a[mid];

            PrimitiveArrays.swap(a, mid, h);

            int prev = l - 1;

            for (int current = l; current < h; current++) {
                if(a[current] <= pivot) {
                    prev++;
                    PrimitiveArrays.swap(a, prev, current);
                }
            }

            PrimitiveArrays.swap(a, prev + 1, h);

            return prev + 1;
        }
        private void applySort(int[] a, int lowestIndex, int highestIndex) {
            if(lowestIndex > highestIndex) return;
            int partitionIndex = partition(a, lowestIndex, highestIndex);

            applySort(a, lowestIndex, partitionIndex - 1); // left
            applySort(a, partitionIndex + 1, highestIndex); // right
        }
        private int partition(int[] a, PrimitiveComparator.OfInt c, int l, int h) {
            int pivot = a[h];

            int next = l - 1;

            for (int current = l; current < h; current++) {
                if(c.compareInt(a[current], pivot) <= 0) {
                    next++;
                    PrimitiveArrays.swap(a, next, current);
                }
            }

            PrimitiveArrays.swap(a, next + 1, h);

            return next + 1;
        }
        private int partition(int[] a, int l, int h) {
            int pivot = a[h];

            int next = l - 1;

            for (int current = l; current < h; current++) {
                if(a[current] <= pivot) {
                    next++;
                    PrimitiveArrays.swap(a, next, current);
                }
            }

            PrimitiveArrays.swap(a, next + 1, h);

            return next + 1;
        }
    }
    private static class OfFloat implements PrimitiveSorter.OfFloat {
        private final boolean optimize;
        OfFloat(boolean optimise) {
            this.optimize = optimise;
        }
        @Override
        public List<Algorithm> getAlgorithms() {
            return List.of(Algorithm.QUICK);
        }
        @Override
        public void sort(float[] src, PrimitiveComparator.OfFloat comparator, float[] dst) {
            if(dst == null) dst = src;
            else {
                if(dst.length != src.length) dst = new float[src.length];
                System.arraycopy(src, 0, dst, 0, src.length);
            }

            if(!optimize) applySort(dst, comparator, 0, dst.length - 1);
            else applyOptimizedSort(dst, comparator, 0, dst.length - 1);
        }
        @Override
        public void sort(float[] src, float[] dst) {
            if(dst == null) dst = src;
            else {
                if(dst.length != src.length) dst = new float[src.length];
                System.arraycopy(src, 0, dst, 0, src.length);
            }

            if(dst.length < 500 || !optimize) applySort(dst, 0, dst.length - 1);
            else applyOptimizedSort(dst, 0, dst.length - 1);
        }
        private void applyOptimizedSort(float[] a, PrimitiveComparator.OfFloat c, int l, int h) {
            if(l >= h) return;
            int p = partitionOptimized(a, c, l, h);

            applyOptimizedSort(a, c, l, p - 1);
            applyOptimizedSort(a, c, p + 1, h);
        }
        private void applyOptimizedSort(float[] a, int l, int h) {
            if(l >= h) return;
            int p = partitionOptimized(a, l, h);

            applyOptimizedSort(a, l, p - 1);
            applyOptimizedSort(a, p + 1, h);
        }
        private void applySort(float[] a, PrimitiveComparator.OfFloat c, int lowestIndex, int highestIndex) {
            if(lowestIndex > highestIndex) return;
            int partitionIndex = partition(a, c, lowestIndex, highestIndex);

            applySort(a, c, lowestIndex, partitionIndex - 1); // left
            applySort(a, c, partitionIndex + 1, highestIndex); // right
        }
        private int partitionOptimized(float[] a, PrimitiveComparator.OfFloat c, int l, int h) {
            int mid = (l + h) / 2;

            float pivot = a[mid];

            PrimitiveArrays.swap(a, mid, h);
            
            int prev = l - 1;

            for (int current = l; current < h; current++) {
                if(c.compareFloat(a[current], pivot) <= 0) {
                    prev++;
                    PrimitiveArrays.swap(a, prev, current);
                }
            }

            PrimitiveArrays.swap(a, prev + 1, h);

            return prev + 1;
        }
        private int partitionOptimized(float[] a, int l, int h) {
            int mid = (l + h) / 2;
            float pivot = a[mid];

            PrimitiveArrays.swap(a, mid, h);

            int prev = l - 1;

            for (int current = l; current < h; current++) {
                if(a[current] <= pivot) {
                    prev++;
                    PrimitiveArrays.swap(a, prev, current);
                }
            }

            PrimitiveArrays.swap(a, prev + 1, h);

            return prev + 1;
        }
        private void applySort(float[] a, int lowestIndex, int highestIndex) {
            if(lowestIndex > highestIndex) return;
            int partitionIndex = partition(a, lowestIndex, highestIndex);

            applySort(a, lowestIndex, partitionIndex - 1); // left
            applySort(a, partitionIndex + 1, highestIndex); // right
        }
        private int partition(float[] a, PrimitiveComparator.OfFloat c, int l, int h) {
            float pivot = a[h];

            int next = l - 1;

            for (int current = l; current < h; current++) {
                if(c.compareFloat(a[current], pivot) <= 0) {
                    next++;
                    PrimitiveArrays.swap(a, next, current);
                }
            }

            PrimitiveArrays.swap(a, next + 1, h);

            return next + 1;
        }
        private int partition(float[] a, int l, int h) {
            float pivot = a[h];

            int next = l - 1;

            for (int current = l; current < h; current++) {
                if(a[current] <= pivot) {
                    next++;
                    PrimitiveArrays.swap(a, next, current);
                }
            }

            PrimitiveArrays.swap(a, next + 1, h);

            return next + 1;
        }
    }
    private static class OfChar implements PrimitiveSorter.OfChar {
        private final boolean optimize;
        OfChar(boolean optimise) {
            this.optimize = optimise;
        }
        @Override
        public List<Algorithm> getAlgorithms() {
            return List.of(Algorithm.QUICK);
        }
        @Override
        public void sort(char[] src, PrimitiveComparator.OfChar comparator, char[] dst) {
            if(dst == null) dst = src;
            else {
                if(dst.length != src.length) dst = new char[src.length];
                System.arraycopy(src, 0, dst, 0, src.length);
            }

            if(!optimize) applySort(dst, comparator, 0, dst.length - 1);
            else applyOptimizedSort(dst, comparator, 0, dst.length - 1);
        }
        @Override
        public void sort(char[] src, char[] dst) {
            if(dst == null) dst = src;
            else {
                if(dst.length != src.length) dst = new char[src.length];
                System.arraycopy(src, 0, dst, 0, src.length);
            }

            if(dst.length < 500 || !optimize) applySort(dst, 0, dst.length - 1);
            else applyOptimizedSort(dst, 0, dst.length - 1);
        }
        private void applyOptimizedSort(char[] a, PrimitiveComparator.OfChar c, int l, int h) {
            if(l >= h) return;
            int p = partitionOptimized(a, c, l, h);

            applyOptimizedSort(a, c, l, p - 1);
            applyOptimizedSort(a, c, p + 1, h);
        }
        private void applyOptimizedSort(char[] a, int l, int h) {
            if(l >= h) return;
            int p = partitionOptimized(a, l, h);

            applyOptimizedSort(a, l, p - 1);
            applyOptimizedSort(a, p + 1, h);
        }
        private void applySort(char[] a, PrimitiveComparator.OfChar c, int lowestIndex, int highestIndex) {
            if(lowestIndex > highestIndex) return;
            int partitionIndex = partition(a, c, lowestIndex, highestIndex);

            applySort(a, c, lowestIndex, partitionIndex - 1); // left
            applySort(a, c, partitionIndex + 1, highestIndex); // right
        }
        private int partitionOptimized(char[] a, PrimitiveComparator.OfChar c, int l, int h) {
            int mid = (l + h) / 2;

            char pivot = a[mid];

            PrimitiveArrays.swap(a, mid, h);
            
            int prev = l - 1;

            for (int current = l; current < h; current++) {
                if(c.compareChar(a[current], pivot) <= 0) {
                    prev++;
                    PrimitiveArrays.swap(a, prev, current);
                }
            }

            PrimitiveArrays.swap(a, prev + 1, h);

            return prev + 1;
        }
        private int partitionOptimized(char[] a, int l, int h) {
            int mid = (l + h) / 2;
            char pivot = a[mid];

            PrimitiveArrays.swap(a, mid, h);

            int prev = l - 1;

            for (int current = l; current < h; current++) {
                if(a[current] <= pivot) {
                    prev++;
                    PrimitiveArrays.swap(a, prev, current);
                }
            }

            PrimitiveArrays.swap(a, prev + 1, h);

            return prev + 1;
        }
        private void applySort(char[] a, int lowestIndex, int highestIndex) {
            if(lowestIndex > highestIndex) return;
            int partitionIndex = partition(a, lowestIndex, highestIndex);

            applySort(a, lowestIndex, partitionIndex - 1); // left
            applySort(a, partitionIndex + 1, highestIndex); // right
        }
        private int partition(char[] a, PrimitiveComparator.OfChar c, int l, int h) {
            char pivot = a[h];

            int next = l - 1;

            for (int current = l; current < h; current++) {
                if(c.compareChar(a[current], pivot) <= 0) {
                    next++;
                    PrimitiveArrays.swap(a, next, current);
                }
            }

            PrimitiveArrays.swap(a, next + 1, h);

            return next + 1;
        }
        private int partition(char[] a, int l, int h) {
            char pivot = a[h];

            int next = l - 1;

            for (int current = l; current < h; current++) {
                if(a[current] <= pivot) {
                    next++;
                    PrimitiveArrays.swap(a, next, current);
                }
            }

            PrimitiveArrays.swap(a, next + 1, h);

            return next + 1;
        }
    }
    private static class OfShort implements PrimitiveSorter.OfShort {
        private final boolean optimize;
        OfShort(boolean optimise) {
            this.optimize = optimise;
        }
        @Override
        public List<Algorithm> getAlgorithms() {
            return List.of(Algorithm.QUICK);
        }
        @Override
        public void sort(short[] src, PrimitiveComparator.OfShort comparator, short[] dst) {
            if(dst == null) dst = src;
            else {
                if(dst.length != src.length) dst = new short[src.length];
                System.arraycopy(src, 0, dst, 0, src.length);
            }

            if(!optimize) applySort(dst, comparator, 0, dst.length - 1);
            else applyOptimizedSort(dst, comparator, 0, dst.length - 1);
        }
        @Override
        public void sort(short[] src, short[] dst) {
            if(dst == null) dst = src;
            else {
                if(dst.length != src.length) dst = new short[src.length];
                System.arraycopy(src, 0, dst, 0, src.length);
            }

            if(dst.length < 500 || !optimize) applySort(dst, 0, dst.length - 1);
            else applyOptimizedSort(dst, 0, dst.length - 1);
        }
        private void applyOptimizedSort(short[] a, PrimitiveComparator.OfShort c, int l, int h) {
            if(l >= h) return;
            int p = partitionOptimized(a, c, l, h);

            applyOptimizedSort(a, c, l, p - 1);
            applyOptimizedSort(a, c, p + 1, h);
        }
        private void applyOptimizedSort(short[] a, int l, int h) {
            if(l >= h) return;
            int p = partitionOptimized(a, l, h);

            applyOptimizedSort(a, l, p - 1);
            applyOptimizedSort(a, p + 1, h);
        }
        private void applySort(short[] a, PrimitiveComparator.OfShort c, int lowestIndex, int highestIndex) {
            if(lowestIndex > highestIndex) return;
            int partitionIndex = partition(a, c, lowestIndex, highestIndex);

            applySort(a, c, lowestIndex, partitionIndex - 1); // left
            applySort(a, c, partitionIndex + 1, highestIndex); // right
        }
        private int partitionOptimized(short[] a, PrimitiveComparator.OfShort c, int l, int h) {
            int mid = (l + h) / 2;

            short pivot = a[mid];

            PrimitiveArrays.swap(a, mid, h);
            
            int prev = l - 1;

            for (int current = l; current < h; current++) {
                if(c.compareShort(a[current], pivot) <= 0) {
                    prev++;
                    PrimitiveArrays.swap(a, prev, current);
                }
            }

            PrimitiveArrays.swap(a, prev + 1, h);

            return prev + 1;
        }
        private int partitionOptimized(short[] a, int l, int h) {
            int mid = (l + h) / 2;
            short pivot = a[mid];

            PrimitiveArrays.swap(a, mid, h);

            int prev = l - 1;

            for (int current = l; current < h; current++) {
                if(a[current] <= pivot) {
                    prev++;
                    PrimitiveArrays.swap(a, prev, current);
                }
            }

            PrimitiveArrays.swap(a, prev + 1, h);

            return prev + 1;
        }
        private void applySort(short[] a, int lowestIndex, int highestIndex) {
            if(lowestIndex > highestIndex) return;
            int partitionIndex = partition(a, lowestIndex, highestIndex);

            applySort(a, lowestIndex, partitionIndex - 1); // left
            applySort(a, partitionIndex + 1, highestIndex); // right
        }
        private int partition(short[] a, PrimitiveComparator.OfShort c, int l, int h) {
            short pivot = a[h];

            int next = l - 1;

            for (int current = l; current < h; current++) {
                if(c.compareShort(a[current], pivot) <= 0) {
                    next++;
                    PrimitiveArrays.swap(a, next, current);
                }
            }

            PrimitiveArrays.swap(a, next + 1, h);

            return next + 1;
        }
        private int partition(short[] a, int l, int h) {
            short pivot = a[h];

            int next = l - 1;

            for (int current = l; current < h; current++) {
                if(a[current] <= pivot) {
                    next++;
                    PrimitiveArrays.swap(a, next, current);
                }
            }

            PrimitiveArrays.swap(a, next + 1, h);

            return next + 1;
        }
    }
    private static class OfByte implements PrimitiveSorter.OfByte     {
        private final boolean optimize;
        OfByte(boolean optimise) {
            this.optimize = optimise;
        }
        @Override
        public List<Algorithm> getAlgorithms() {
            return List.of(Algorithm.QUICK);
        }
        @Override
        public void sort(byte[] src, PrimitiveComparator.OfByte comparator, byte[] dst) {
            if(dst == null) dst = src;
            else {
                if(dst.length != src.length) dst = new byte[src.length];
                System.arraycopy(src, 0, dst, 0, src.length);
            }

            if(!optimize) applySort(dst, comparator, 0, dst.length - 1);
            else applyOptimizedSort(dst, comparator, 0, dst.length - 1);
        }
        @Override
        public void sort(byte[] src, byte[] dst) {
            if(dst == null) dst = src;
            else {
                if(dst.length != src.length) dst = new byte[src.length];
                System.arraycopy(src, 0, dst, 0, src.length);
            }

            if(dst.length < 500 || !optimize) applySort(dst, 0, dst.length - 1);
            else applyOptimizedSort(dst, 0, dst.length - 1);
        }
        private void applyOptimizedSort(byte[] a, PrimitiveComparator.OfByte c, int l, int h) {
            if(l >= h) return;
            int p = partitionOptimized(a, c, l, h);

            applyOptimizedSort(a, c, l, p - 1);
            applyOptimizedSort(a, c, p + 1, h);
        }
        private void applyOptimizedSort(byte[] a, int l, int h) {
            if(l >= h) return;
            int p = partitionOptimized(a, l, h);

            applyOptimizedSort(a, l, p - 1);
            applyOptimizedSort(a, p + 1, h);
        }
        private void applySort(byte[] a, PrimitiveComparator.OfByte c, int lowestIndex, int highestIndex) {
            if(lowestIndex > highestIndex) return;
            int partitionIndex = partition(a, c, lowestIndex, highestIndex);

            applySort(a, c, lowestIndex, partitionIndex - 1); // left
            applySort(a, c, partitionIndex + 1, highestIndex); // right
        }
        private int partitionOptimized(byte[] a, PrimitiveComparator.OfByte c, int l, int h) {
            int mid = (l + h) / 2;

            byte pivot = a[mid];

            PrimitiveArrays.swap(a, mid, h);
            
            int prev = l - 1;

            for (int current = l; current < h; current++) {
                if(c.compareByte(a[current], pivot) <= 0) {
                    prev++;
                    PrimitiveArrays.swap(a, prev, current);
                }
            }

            PrimitiveArrays.swap(a, prev + 1, h);

            return prev + 1;
        }
        private int partitionOptimized(byte[] a, int l, int h) {
            int mid = (l + h) / 2;
            byte pivot = a[mid];

            PrimitiveArrays.swap(a, mid, h);

            int prev = l - 1;

            for (int current = l; current < h; current++) {
                if(a[current] <= pivot) {
                    prev++;
                    PrimitiveArrays.swap(a, prev, current);
                }
            }

            PrimitiveArrays.swap(a, prev + 1, h);

            return prev + 1;
        }
        private void applySort(byte[] a, int lowestIndex, int highestIndex) {
            if(lowestIndex > highestIndex) return;
            int partitionIndex = partition(a, lowestIndex, highestIndex);

            applySort(a, lowestIndex, partitionIndex - 1); // left
            applySort(a, partitionIndex + 1, highestIndex); // right
        }
        private int partition(byte[] a, PrimitiveComparator.OfByte c, int l, int h) {
            byte pivot = a[h];

            int next = l - 1;

            for (int current = l; current < h; current++) {
                if(c.compareByte(a[current], pivot) <= 0) {
                    next++;
                    PrimitiveArrays.swap(a, next, current);
                }
            }

            PrimitiveArrays.swap(a, next + 1, h);

            return next + 1;
        }
        private int partition(byte[] a, int l, int h) {
            byte pivot = a[h];

            int next = l - 1;

            for (int current = l; current < h; current++) {
                if(a[current] <= pivot) {
                    next++;
                    PrimitiveArrays.swap(a, next, current);
                }
            }

            PrimitiveArrays.swap(a, next + 1, h);

            return next + 1;
        }
    }
    private static class OfBoolean implements PrimitiveSorter.OfBoolean     {
        private final boolean optimize;
        OfBoolean(boolean optimise) {
            this.optimize = optimise;
        }
        @Override
        public List<Algorithm> getAlgorithms() {
            return List.of(Algorithm.QUICK);
        }
        @Override
        public void sort(boolean[] src, PrimitiveComparator.OfBoolean comparator, boolean[] dst) {
            if(dst == null) dst = src;
            else {
                if(dst.length != src.length) dst = new boolean[src.length];
                System.arraycopy(src, 0, dst, 0, src.length);
            }

            if(!optimize) applySort(dst, comparator, 0, dst.length - 1);
            else applyOptimizedSort(dst, comparator, 0, dst.length - 1);
        }
        @Override
        public void sort(boolean[] src, boolean[] dst) {
            if(dst == null) dst = src;
            else {
                if(dst.length != src.length) dst = new boolean[src.length];
                System.arraycopy(src, 0, dst, 0, src.length);
            }

            if(dst.length < 500 || !optimize) applySort(dst, 0, dst.length - 1);
            else applyOptimizedSort(dst, 0, dst.length - 1);
        }
        private void applyOptimizedSort(boolean[] a, PrimitiveComparator.OfBoolean c, int l, int h) {
            if(l >= h) return;
            int p = partitionOptimized(a, c, l, h);

            applyOptimizedSort(a, c, l, p - 1);
            applyOptimizedSort(a, c, p + 1, h);
        }
        private void applyOptimizedSort(boolean[] a, int l, int h) {
            if(l >= h) return;
            int p = partitionOptimized(a, l, h);

            applyOptimizedSort(a, l, p - 1);
            applyOptimizedSort(a, p + 1, h);
        }
        private void applySort(boolean[] a, PrimitiveComparator.OfBoolean c, int lowestIndex, int highestIndex) {
            if(lowestIndex > highestIndex) return;
            int partitionIndex = partition(a, c, lowestIndex, highestIndex);

            applySort(a, c, lowestIndex, partitionIndex - 1); // left
            applySort(a, c, partitionIndex + 1, highestIndex); // right
        }
        private int partitionOptimized(boolean[] a, PrimitiveComparator.OfBoolean c, int l, int h) {
            int mid = (l + h) / 2;

            boolean pivot = a[mid];

            PrimitiveArrays.swap(a, mid, h);
            
            int prev = l - 1;

            for (int current = l; current < h; current++) {
                if(c.compareBoolean(a[current], pivot) <= 0) {
                    prev++;
                    PrimitiveArrays.swap(a, prev, current);
                }
            }

            PrimitiveArrays.swap(a, prev + 1, h);

            return prev + 1;
        }
        private int partitionOptimized(boolean[] a, int l, int h) {
            int mid = (l + h) / 2;
            boolean pivot = a[mid];

            PrimitiveArrays.swap(a, mid, h);

            int prev = l - 1;

            for (int current = l; current < h; current++) {
                if(Boolean.compare(a[current], pivot) <= 0) {
                    prev++;
                    PrimitiveArrays.swap(a, prev, current);
                }
            }

            PrimitiveArrays.swap(a, prev + 1, h);

            return prev + 1;
        }
        private void applySort(boolean[] a, int lowestIndex, int highestIndex) {
            if(lowestIndex > highestIndex) return;
            int partitionIndex = partition(a, lowestIndex, highestIndex);

            applySort(a, lowestIndex, partitionIndex - 1); // left
            applySort(a, partitionIndex + 1, highestIndex); // right
        }
        private int partition(boolean[] a, PrimitiveComparator.OfBoolean c, int l, int h) {
            boolean pivot = a[h];

            int next = l - 1;

            for (int current = l; current < h; current++) {
                if(c.compareBoolean(a[current], pivot) <= 0) {
                    next++;
                    PrimitiveArrays.swap(a, next, current);
                }
            }

            PrimitiveArrays.swap(a, next + 1, h);

            return next + 1;
        }
        private int partition(boolean[] a, int l, int h) {
            boolean pivot = a[h];

            int next = l - 1;

            for (int current = l; current < h; current++) {
                if(Boolean.compare(a[current], pivot) <= 0) {
                    next++;
                    PrimitiveArrays.swap(a, next, current);
                }
            }

            PrimitiveArrays.swap(a, next + 1, h);

            return next + 1;
        }
    }

}
