package jdk.prim.util.sort;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Semaphore;

import jdk.prim.util.PrimitiveArrays;
import jdk.prim.util.PrimitiveComparator;

/**
 * A class that contains primitive implementations of a very basic
 * multi-threaded quick sort algorithm. It's main purpose is to serve as a
 * fallback for code on environments where modern multi-threading isn't possible
 * <p>
 * This seems slower than {@link PrimitiveNaiveQuickSort} on multi-core processors
 */
public final class PrimitiveBasicQuickSort {
    private PrimitiveBasicQuickSort() {
    }

    private static void waitForThreads(List<Thread> threads, Semaphore semaphore) {
        for (int i = 0; i < threads.size(); i++) {
            Thread thread = threads.get(i);
            try {
                thread.join(1000);
                semaphore.release();
            } catch(InterruptedException e) {
                e.printStackTrace();
            } catch(ConcurrentModificationException e) {
                e.printStackTrace();
            }
        }
    }

    private static void runSortThread(Runnable task, List<Thread> threads, Semaphore semaphore) {
        try {
            semaphore.acquire();

            Thread t = new Thread(new Runnable() {
                @Override public void run() {
                    try {
                        task.run();
                    } finally {
                        semaphore.release();
                    }
                }
            });
            threads.add(t);
            t.start();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Retrieves a basic quick sort implementation which has limited multi-threading support
     * @return a sorter of {@code double} arrays using the quick sort method
     */
    public static PrimitiveSorter.OfDouble ofDouble() { return new OfDouble(); }
    /**
     * Retrieves a basic quick sort implementation which has limited multi-threading support
     * @return a sorter of {@code long} arrays using the quick sort method
     */
    public static PrimitiveSorter.OfLong ofLong() { return new OfLong(); }
    /**
     * Retrieves a basic quick sort implementation which has limited multi-threading support
     * @return a sorter of {@code int} arrays using the quick sort method
     */
    public static PrimitiveSorter.OfInt ofInt() { return new OfInt(); }
    /**
     * Retrieves a basic quick sort implementation which has limited multi-threading support
     * @return a sorter of {@code float} arrays using the quick sort method
     */
    public static PrimitiveSorter.OfFloat ofFloat() { return new OfFloat(); }
    /**
     * Retrieves a basic quick sort implementation which has limited multi-threading support
     * @return a sorter of {@code char} arrays using the quick sort method
     */
    public static PrimitiveSorter.OfChar ofChar() { return new OfChar(); }
    /**
     * Retrieves a basic quick sort implementation which has limited multi-threading support
     * @return a sorter of {@code short} arrays using the quick sort method
     */
    public static PrimitiveSorter.OfShort ofShort() { return new OfShort(); }
    /**
     * Retrieves a basic quick sort implementation which has limited multi-threading support
     * @return a sorter of {@code byte} arrays using the quick sort method
     */
    public static PrimitiveSorter.OfByte ofByte() { return new OfByte(); }
    /**
     * Retrieves a basic quick sort implementation which has limited multi-threading support
     * @return a sorter of {@code boolean} arrays using the quick sort method
     */
    public static PrimitiveSorter.OfBoolean ofBoolean() { return new OfBoolean(); }

    private static class OfDouble implements PrimitiveSorter.OfDouble {
        private final List<Thread> threads;
        private final Semaphore semaphore;

        OfDouble(int threads) {
            this.threads = Collections.synchronizedList(new ArrayList<>(threads));
            semaphore = new Semaphore(threads);
        }

        OfDouble() {
            this(Runtime.getRuntime().availableProcessors());
        }

        @Override
        public List<Algorithm> getAlgorithms() {
            return List.of(Algorithm.QUICK);
        }

        @Override
        public void sort(double[] src, PrimitiveComparator.OfDouble comparator, double[] dst) {
            if (dst == null)
                dst = src;
            else {
                if (dst.length != src.length) dst = new double[src.length];
                System.arraycopy(src, 0, dst, 0, src.length);
            }

            applySort(dst, comparator, 0, dst.length - 1);
            // System.out.println("Waiting for threads: ");
            waitForThreads(threads, semaphore);
        }

        @Override
        public void sort(double[] src, double[] dst) {
            if (dst == null)
                dst = src;
            else {
                if (dst.length != src.length) dst = new double[src.length];
                System.arraycopy(src, 0, dst, 0, src.length);
            }

            applySort(dst, 0, dst.length - 1);

            waitForThreads(threads, semaphore);

        }

        private void applySort(double[] a, PrimitiveComparator.OfDouble c, int l, int h) {
            if (l >= h)
                return;
            int p = partition(a, c, l, h);

            runSortThread(() -> applySort(a, c, l, p - 1), threads, semaphore);
            runSortThread(() -> applySort(a, c, p + 1, h), threads, semaphore);
        }

        private void applySort(double[] a, int l, int h) {
            if (l >= h)
                return;
            int p = partition(a, l, h);

            runSortThread(() -> applySort(a, l, p - 1), threads, semaphore);
            runSortThread(() -> applySort(a, p + 1, h), threads, semaphore);
        }

        private int partition(double[] a, PrimitiveComparator.OfDouble c, int l, int h) {
            int mid = (l + h) / 2;

            double pivot = a[mid];

            PrimitiveArrays.swap(a, mid, h);

            int prev = l - 1;

            for (int current = l; current < h; current++) {
                if (c.compareDouble(a[current], pivot) <= 0) {
                    prev++;
                    PrimitiveArrays.swap(a, prev, current);
                }
            }

            PrimitiveArrays.swap(a, prev + 1, h);

            return prev + 1;
        }

        private int partition(double[] a, int l, int h) {
            int mid = (l + h) / 2;
            double pivot = a[mid];
            PrimitiveArrays.swap(a, mid, h);
            int prev = l - 1;
            for (int current = l; current < h; current++) {
                if (a[current] <= pivot) {
                    prev++;
                    PrimitiveArrays.swap(a, prev, current);
                }
            }

            PrimitiveArrays.swap(a, prev + 1, h);

            return prev + 1;
        }
    }

    private static class OfLong implements PrimitiveSorter.OfLong {
        private final List<Thread> threads;
        private final Semaphore semaphore;

        OfLong(int threads) {
            this.threads = Collections.synchronizedList(new ArrayList<>(threads));
            semaphore = new Semaphore(threads);
        }

        OfLong() {
            this(Runtime.getRuntime().availableProcessors());
        }

        @Override
        public List<Algorithm> getAlgorithms() {
            return List.of(Algorithm.QUICK);
        }

        @Override
        public void sort(long[] src, PrimitiveComparator.OfLong comparator, long[] dst) {
            if (dst == null)
                dst = src;
            else {
                if (dst.length != src.length) dst = new long[src.length];
                System.arraycopy(src, 0, dst, 0, src.length);
            }

            applySort(dst, comparator, 0, dst.length - 1);

            waitForThreads(threads, semaphore);
        }

        @Override
        public void sort(long[] src, long[] dst) {
            if (dst == null)
                dst = src;
            else {
                if (dst.length != src.length) dst = new long[src.length];
                System.arraycopy(src, 0, dst, 0, src.length);
            }

            applySort(dst, 0, dst.length - 1);

            waitForThreads(threads, semaphore);

        }

        private void applySort(long[] a, PrimitiveComparator.OfLong c, int l, int h) {
            if (l >= h)
                return;
            int p = partition(a, c, l, h);

            runSortThread(() -> applySort(a, c, l, p - 1), threads, semaphore);
            runSortThread(() -> applySort(a, c, p + 1, h), threads, semaphore);
        }

        private void applySort(long[] a, int l, int h) {
            if (l >= h)
                return;
            int p = partition(a, l, h);

            runSortThread(() -> applySort(a, l, p - 1), threads, semaphore);
            runSortThread(() -> applySort(a, p + 1, h), threads, semaphore);
        }

        private int partition(long[] a, PrimitiveComparator.OfLong c, int l, int h) {
            int mid = (l + h) / 2;

            long pivot = a[mid];

            PrimitiveArrays.swap(a, mid, h);

            int prev = l - 1;

            for (int current = l; current < h; current++) {
                if (c.compareLong(a[current], pivot) <= 0) {
                    prev++;
                    PrimitiveArrays.swap(a, prev, current);
                }
            }

            PrimitiveArrays.swap(a, prev + 1, h);

            return prev + 1;
        }

        private int partition(long[] a, int l, int h) {
            int mid = (l + h) / 2;
            long pivot = a[mid];
            PrimitiveArrays.swap(a, mid, h);
            int prev = l - 1;
            for (int current = l; current < h; current++) {
                if (a[current] <= pivot) {
                    prev++;
                    PrimitiveArrays.swap(a, prev, current);
                }
            }

            PrimitiveArrays.swap(a, prev + 1, h);

            return prev + 1;
        }
    }

    private static class OfInt implements PrimitiveSorter.OfInt {
        private final List<Thread> threads;
        private final Semaphore semaphore;

        OfInt(int threads) {
            this.threads = Collections.synchronizedList(new ArrayList<>(threads));
            semaphore = new Semaphore(threads);
        }

        OfInt() {
            this(Runtime.getRuntime().availableProcessors());
        }

        @Override
        public List<Algorithm> getAlgorithms() {
            return List.of(Algorithm.QUICK);
        }

        @Override
        public void sort(int[] src, PrimitiveComparator.OfInt comparator, int[] dst) {
            if (dst == null)
                dst = src;
            else {
                if (dst.length != src.length) dst = new int[src.length];
                System.arraycopy(src, 0, dst, 0, src.length);
            }

            applySort(dst, comparator, 0, dst.length - 1);

            waitForThreads(threads, semaphore);
        }

        @Override
        public void sort(int[] src, int[] dst) {
            if (dst == null)
                dst = src;
            else {
                if (dst.length != src.length) dst = new int[src.length];
                System.arraycopy(src, 0, dst, 0, src.length);
            }

            applySort(dst, 0, dst.length - 1);

            waitForThreads(threads, semaphore);

        }

        private void applySort(int[] a, PrimitiveComparator.OfInt c, int l, int h) {
            if (l >= h)
                return;
            int p = partition(a, c, l, h);

            runSortThread(() -> applySort(a, c, l, p - 1), threads, semaphore);
            runSortThread(() -> applySort(a, c, p + 1, h), threads, semaphore);
        }

        private void applySort(int[] a, int l, int h) {
            if (l >= h)
                return;
            int p = partition(a, l, h);

            runSortThread(() -> applySort(a, l, p - 1), threads, semaphore);
            runSortThread(() -> applySort(a, p + 1, h), threads, semaphore);
        }

        private int partition(int[] a, PrimitiveComparator.OfInt c, int l, int h) {
            int mid = (l + h) / 2;

            int pivot = a[mid];

            PrimitiveArrays.swap(a, mid, h);

            int prev = l - 1;

            for (int current = l; current < h; current++) {
                if (c.compareInt(a[current], pivot) <= 0) {
                    prev++;
                    PrimitiveArrays.swap(a, prev, current);
                }
            }

            PrimitiveArrays.swap(a, prev + 1, h);

            return prev + 1;
        }

        private int partition(int[] a, int l, int h) {
            int mid = (l + h) / 2;
            int pivot = a[mid];
            PrimitiveArrays.swap(a, mid, h);
            int prev = l - 1;
            for (int current = l; current < h; current++) {
                if (a[current] <= pivot) {
                    prev++;
                    PrimitiveArrays.swap(a, prev, current);
                }
            }

            PrimitiveArrays.swap(a, prev + 1, h);

            return prev + 1;
        }
    }

    private static class OfFloat implements PrimitiveSorter.OfFloat {
        private final List<Thread> threads;
        private final Semaphore semaphore;

        OfFloat(int threads) {
            this.threads = Collections.synchronizedList(new ArrayList<>(threads));
            semaphore = new Semaphore(threads);
        }

        OfFloat() {
            this(Runtime.getRuntime().availableProcessors());
        }

        @Override
        public List<Algorithm> getAlgorithms() {
            return List.of(Algorithm.QUICK);
        }

        @Override
        public void sort(float[] src, PrimitiveComparator.OfFloat comparator, float[] dst) {
            if (dst == null)
                dst = src;
            else {
                if (dst.length != src.length) dst = new float[src.length];
                System.arraycopy(src, 0, dst, 0, src.length);
            }

            applySort(dst, comparator, 0, dst.length - 1);

            waitForThreads(threads, semaphore);
        }

        @Override
        public void sort(float[] src, float[] dst) {
            if (dst == null)
                dst = src;
            else {
                if (dst.length != src.length) dst = new float[src.length];
                System.arraycopy(src, 0, dst, 0, src.length);
            }

            applySort(dst, 0, dst.length - 1);

            waitForThreads(threads, semaphore);

        }

        private void applySort(float[] a, PrimitiveComparator.OfFloat c, int l, int h) {
            if (l >= h)
                return;
            int p = partition(a, c, l, h);

            runSortThread(() -> applySort(a, c, l, p - 1), threads, semaphore);
            runSortThread(() -> applySort(a, c, p + 1, h), threads, semaphore);
        }

        private void applySort(float[] a, int l, int h) {
            if (l >= h)
                return;
            int p = partition(a, l, h);

            runSortThread(() -> applySort(a, l, p - 1), threads, semaphore);
            runSortThread(() -> applySort(a, p + 1, h), threads, semaphore);
        }

        private int partition(float[] a, PrimitiveComparator.OfFloat c, int l, int h) {
            int mid = (l + h) / 2;

            float pivot = a[mid];

            PrimitiveArrays.swap(a, mid, h);

            int prev = l - 1;

            for (int current = l; current < h; current++) {
                if (c.compareFloat(a[current], pivot) <= 0) {
                    prev++;
                    PrimitiveArrays.swap(a, prev, current);
                }
            }

            PrimitiveArrays.swap(a, prev + 1, h);

            return prev + 1;
        }

        private int partition(float[] a, int l, int h) {
            int mid = (l + h) / 2;
            float pivot = a[mid];
            PrimitiveArrays.swap(a, mid, h);
            int prev = l - 1;
            for (int current = l; current < h; current++) {
                if (a[current] <= pivot) {
                    prev++;
                    PrimitiveArrays.swap(a, prev, current);
                }
            }

            PrimitiveArrays.swap(a, prev + 1, h);

            return prev + 1;
        }
    }

    private static class OfChar implements PrimitiveSorter.OfChar {
        private final List<Thread> threads;
        private final Semaphore semaphore;

        OfChar(int threads) {
            this.threads = Collections.synchronizedList(new ArrayList<>(threads));
            semaphore = new Semaphore(threads);
        }

        OfChar() {
            this(Runtime.getRuntime().availableProcessors());
        }

        @Override
        public List<Algorithm> getAlgorithms() {
            return List.of(Algorithm.QUICK);
        }

        @Override
        public void sort(char[] src, PrimitiveComparator.OfChar comparator, char[] dst) {
            if (dst == null)
                dst = src;
            else {
                if (dst.length != src.length) dst = new char[src.length];
                System.arraycopy(src, 0, dst, 0, src.length);
            }

            applySort(dst, comparator, 0, dst.length - 1);

            waitForThreads(threads, semaphore);
        }

        @Override
        public void sort(char[] src, char[] dst) {
            if (dst == null)
                dst = src;
            else {
                if (dst.length != src.length) dst = new char[src.length];
                System.arraycopy(src, 0, dst, 0, src.length);
            }

            applySort(dst, 0, dst.length - 1);

            waitForThreads(threads, semaphore);

        }

        private void applySort(char[] a, PrimitiveComparator.OfChar c, int l, int h) {
            if (l >= h)
                return;
            int p = partition(a, c, l, h);

            runSortThread(() -> applySort(a, c, l, p - 1), threads, semaphore);
            runSortThread(() -> applySort(a, c, p + 1, h), threads, semaphore);
        }

        private void applySort(char[] a, int l, int h) {
            if (l >= h)
                return;
            int p = partition(a, l, h);

            runSortThread(() -> applySort(a, l, p - 1), threads, semaphore);
            runSortThread(() -> applySort(a, p + 1, h), threads, semaphore);
        }

        private int partition(char[] a, PrimitiveComparator.OfChar c, int l, int h) {
            int mid = (l + h) / 2;

            char pivot = a[mid];

            PrimitiveArrays.swap(a, mid, h);

            int prev = l - 1;

            for (int current = l; current < h; current++) {
                if (c.compareChar(a[current], pivot) <= 0) {
                    prev++;
                    PrimitiveArrays.swap(a, prev, current);
                }
            }

            PrimitiveArrays.swap(a, prev + 1, h);

            return prev + 1;
        }

        private int partition(char[] a, int l, int h) {
            int mid = (l + h) / 2;
            char pivot = a[mid];
            PrimitiveArrays.swap(a, mid, h);
            int prev = l - 1;
            for (int current = l; current < h; current++) {
                if (a[current] <= pivot) {
                    prev++;
                    PrimitiveArrays.swap(a, prev, current);
                }
            }

            PrimitiveArrays.swap(a, prev + 1, h);

            return prev + 1;
        }
    }

    private static class OfShort implements PrimitiveSorter.OfShort {
        private final List<Thread> threads;
        private final Semaphore semaphore;

        OfShort(int threads) {
            this.threads = Collections.synchronizedList(new ArrayList<>(threads));
            semaphore = new Semaphore(threads);
        }

        OfShort() {
            this(Runtime.getRuntime().availableProcessors());
        }

        @Override
        public List<Algorithm> getAlgorithms() {
            return List.of(Algorithm.QUICK);
        }

        @Override
        public void sort(short[] src, PrimitiveComparator.OfShort comparator, short[] dst) {
            if (dst == null)
                dst = src;
            else {
                if (dst.length != src.length) dst = new short[src.length];
                System.arraycopy(src, 0, dst, 0, src.length);
            }

            applySort(dst, comparator, 0, dst.length - 1);

            waitForThreads(threads, semaphore);
        }

        @Override
        public void sort(short[] src, short[] dst) {
            if (dst == null)
                dst = src;
            else {
                if (dst.length != src.length) dst = new short[src.length];
                System.arraycopy(src, 0, dst, 0, src.length);
            }

            applySort(dst, 0, dst.length - 1);
            
            waitForThreads(threads, semaphore);

        }

        private void applySort(short[] a, PrimitiveComparator.OfShort c, int l, int h) {
            if (l >= h)
                return;
            int p = partition(a, c, l, h);

            runSortThread(() -> applySort(a, c, l, p - 1), threads, semaphore);
            runSortThread(() -> applySort(a, c, p + 1, h), threads, semaphore);
        }

        private void applySort(short[] a, int l, int h) {
            if (l >= h)
                return;
            int p = partition(a, l, h);

            runSortThread(() -> applySort(a, l, p - 1), threads, semaphore);
            runSortThread(() -> applySort(a, p + 1, h), threads, semaphore);
        }

        private int partition(short[] a, PrimitiveComparator.OfShort c, int l, int h) {
            int mid = (l + h) / 2;

            short pivot = a[mid];

            PrimitiveArrays.swap(a, mid, h);

            int prev = l - 1;

            for (int current = l; current < h; current++) {
                if (c.compareShort(a[current], pivot) <= 0) {
                    prev++;
                    PrimitiveArrays.swap(a, prev, current);
                }
            }

            PrimitiveArrays.swap(a, prev + 1, h);

            return prev + 1;
        }

        private int partition(short[] a, int l, int h) {
            int mid = (l + h) / 2;
            short pivot = a[mid];
            PrimitiveArrays.swap(a, mid, h);
            int prev = l - 1;
            for (int current = l; current < h; current++) {
                if (a[current] <= pivot) {
                    prev++;
                    PrimitiveArrays.swap(a, prev, current);
                }
            }

            PrimitiveArrays.swap(a, prev + 1, h);

            return prev + 1;
        }
    }

    private static class OfByte implements PrimitiveSorter.OfByte {
        private final List<Thread> threads;
        private final Semaphore semaphore;

        OfByte(int threads) {
            this.threads = Collections.synchronizedList(new ArrayList<>(threads));
            semaphore = new Semaphore(threads);
        }

        OfByte() {
            this(Runtime.getRuntime().availableProcessors());
        }

        @Override
        public List<Algorithm> getAlgorithms() {
            return List.of(Algorithm.QUICK);
        }

        @Override
        public void sort(byte[] src, PrimitiveComparator.OfByte comparator, byte[] dst) {
            if (dst == null)
                dst = src;
            else {
                if (dst.length != src.length) dst = new byte[src.length];
                System.arraycopy(src, 0, dst, 0, src.length);
            }

            applySort(dst, comparator, 0, dst.length - 1);

            waitForThreads(threads, semaphore);
        }

        @Override
        public void sort(byte[] src, byte[] dst) {
            if (dst == null)
                dst = src;
            else {
                if (dst.length != src.length) dst = new byte[src.length];
                System.arraycopy(src, 0, dst, 0, src.length);
            }

            applySort(dst, 0, dst.length - 1);

            waitForThreads(threads, semaphore);

        }

        private void applySort(byte[] a, PrimitiveComparator.OfByte c, int l, int h) {
            if (l >= h)
                return;
            int p = partition(a, c, l, h);

            runSortThread(() -> applySort(a, c, l, p - 1), threads, semaphore);
            runSortThread(() -> applySort(a, c, p + 1, h), threads, semaphore);
        }

        private void applySort(byte[] a, int l, int h) {
            if (l >= h)
                return;
            int p = partition(a, l, h);

            runSortThread(() -> applySort(a, l, p - 1), threads, semaphore);
            runSortThread(() -> applySort(a, p + 1, h), threads, semaphore);
        }

        private int partition(byte[] a, PrimitiveComparator.OfByte c, int l, int h) {
            int mid = (l + h) / 2;

            byte pivot = a[mid];

            PrimitiveArrays.swap(a, mid, h);

            int prev = l - 1;

            for (int current = l; current < h; current++) {
                if (c.compareByte(a[current], pivot) <= 0) {
                    prev++;
                    PrimitiveArrays.swap(a, prev, current);
                }
            }

            PrimitiveArrays.swap(a, prev + 1, h);

            return prev + 1;
        }

        private int partition(byte[] a, int l, int h) {
            int mid = (l + h) / 2;
            byte pivot = a[mid];
            PrimitiveArrays.swap(a, mid, h);
            int prev = l - 1;
            for (int current = l; current < h; current++) {
                if (a[current] <= pivot) {
                    prev++;
                    PrimitiveArrays.swap(a, prev, current);
                }
            }

            PrimitiveArrays.swap(a, prev + 1, h);

            return prev + 1;
        }
    }

    private static class OfBoolean implements PrimitiveSorter.OfBoolean {
        private final List<Thread> threads;
        private final Semaphore semaphore;

        OfBoolean(int threads) {
            this.threads = Collections.synchronizedList(new ArrayList<>(threads));
            semaphore = new Semaphore(threads);
        }

        OfBoolean() {
            this(Runtime.getRuntime().availableProcessors());
        }

        @Override
        public List<Algorithm> getAlgorithms() {
            return List.of(Algorithm.QUICK);
        }

        @Override
        public void sort(boolean[] src, PrimitiveComparator.OfBoolean comparator, boolean[] dst) {
            if (dst == null)
                dst = src;
            else {
                if (dst.length != src.length) dst = new boolean[src.length];
                System.arraycopy(src, 0, dst, 0, src.length);
            }

            applySort(dst, comparator, 0, dst.length - 1);

            waitForThreads(threads, semaphore);
        }

        @Override
        public void sort(boolean[] src, boolean[] dst) {
            if (dst == null)
                dst = src;
            else {
                if (dst.length != src.length) dst = new boolean[src.length];
                System.arraycopy(src, 0, dst, 0, src.length);
            }

            applySort(dst, 0, dst.length - 1);

            waitForThreads(threads, semaphore);

        }

        private void applySort(boolean[] a, PrimitiveComparator.OfBoolean c, int l, int h) {
            if (l >= h)
                return;
            int p = partition(a, c, l, h);

            runSortThread(() -> applySort(a, c, l, p - 1), threads, semaphore);
            runSortThread(() -> applySort(a, c, p + 1, h), threads, semaphore);
        }

        private void applySort(boolean[] a, int l, int h) {
            if (l >= h)
                return;
            int p = partition(a, l, h);

            runSortThread(() -> applySort(a, l, p - 1), threads, semaphore);
            runSortThread(() -> applySort(a, p + 1, h), threads, semaphore);
        }

        private int partition(boolean[] a, PrimitiveComparator.OfBoolean c, int l, int h) {
            int mid = (l + h) / 2;

            boolean pivot = a[mid];

            PrimitiveArrays.swap(a, mid, h);

            int prev = l - 1;

            for (int current = l; current < h; current++) {
                if (c.compareBoolean(a[current], pivot) <= 0) {
                    prev++;
                    PrimitiveArrays.swap(a, prev, current);
                }
            }

            PrimitiveArrays.swap(a, prev + 1, h);

            return prev + 1;
        }

        private int partition(boolean[] a, int l, int h) {
            int mid = (l + h) / 2;
            boolean pivot = a[mid];
            PrimitiveArrays.swap(a, mid, h);
            int prev = l - 1;
            for (int current = l; current < h; current++) {
                if (Boolean.compare(a[current], pivot) <= 0) {
                    prev++;
                    PrimitiveArrays.swap(a, prev, current);
                }
            }

            PrimitiveArrays.swap(a, prev + 1, h);

            return prev + 1;
        }
    }
}
