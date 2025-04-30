package jdk.prim.util.sort;

import java.util.Arrays;
import java.util.List;

import jdk.prim.util.PrimitiveComparator;

public final class PrimitiveDualPivot {

    public static PrimitiveSorter.OfDouble ofDouble(int parallelism) {
        return new OfDouble(parallelism);
    }
    public static PrimitiveSorter.OfLong ofLong(int parallelism) {
        return new OfLong(parallelism);
    }    
    public static PrimitiveSorter.OfInt ofInt(int parallelism) {
        return new OfInt(parallelism);
    }
    public static PrimitiveSorter.OfFloat ofFloat(int parallelism) {
        return new OfFloat(parallelism);
    }
    public static PrimitiveSorter.OfChar ofChar(int parallelism) {
        return new OfChar(parallelism);
    }
    public static PrimitiveSorter.OfShort ofShort(int parallelism) {
        return new OfShort(parallelism);
    }
    public static PrimitiveSorter.OfByte ofByte(int parallelism) {
        return new OfByte(parallelism);
    }
    public static PrimitiveSorter.OfBoolean ofBoolean(int parallelism) {
        return new OfBoolean(parallelism);
    }

    private static class OfDouble implements PrimitiveSorter.OfDouble {
        private int parallelism;
        private OfDouble(int parallelism) {
            this.parallelism = parallelism;
        }
        public List<Algorithm> getAlgorithms() { return Arrays.asList(Algorithm.QUICK); }
        public void sort(double[] src, PrimitiveComparator.OfDouble comparator, double[] dst) {
            if(dst == null) dst = src;
            else {
                if(dst.length != src.length) dst = new double[src.length];
                System.arraycopy(src, 0, dst, 0, src.length);
            }
            jdk.prim.util.sort.dualpivot.OfDouble.sort(dst, comparator, parallelism, 0, dst.length);
        }
        public void sort(double[] src, double[] dst) {
            sort(src, Double::compare, dst);
        }
    }
    private static class OfLong implements PrimitiveSorter.OfLong {
        private int parallelism;
        private OfLong(int parallelism) {
            this.parallelism = parallelism;
        }
        public List<Algorithm> getAlgorithms() { return Arrays.asList(Algorithm.QUICK); }
        public void sort(long[] src, PrimitiveComparator.OfLong comparator, long[] dst) {
            if(dst == null) dst = src;
            else {
                if(dst.length != src.length) dst = new long[src.length];
                System.arraycopy(src, 0, dst, 0, src.length);
            }
            jdk.prim.util.sort.dualpivot.OfLong.sort(dst, comparator, parallelism, 0, dst.length);
        }
        public void sort(long[] src, long[] dst) {
            sort(src, Long::compare, dst);
        }
    }
    private static class OfInt implements PrimitiveSorter.OfInt {
        private int parallelism;
        private OfInt(int parallelism) {
            this.parallelism = parallelism;
        }
        public List<Algorithm> getAlgorithms() { return Arrays.asList(Algorithm.QUICK); }
        public void sort(int[] src, PrimitiveComparator.OfInt comparator, int[] dst) {
            if(dst == null) dst = src;
            else {
                if(dst.length != src.length) dst = new int[src.length];
                System.arraycopy(src, 0, dst, 0, src.length);
            }
            jdk.prim.util.sort.dualpivot.OfInt.sort(dst, comparator, parallelism, 0, dst.length);
        }
        public void sort(int[] src, int[] dst) {
            sort(src, Integer::compare, dst);
        }
    }
    private static class OfFloat implements PrimitiveSorter.OfFloat {
        private int parallelism;
        private OfFloat(int parallelism) {
            this.parallelism = parallelism;
        }
        public List<Algorithm> getAlgorithms() { return Arrays.asList(Algorithm.QUICK); }
        public void sort(float[] src, PrimitiveComparator.OfFloat comparator, float[] dst) {
            if(dst == null) dst = src;
            else {
                if(dst.length != src.length) dst = new float[src.length];
                System.arraycopy(src, 0, dst, 0, src.length);
            }
            jdk.prim.util.sort.dualpivot.OfFloat.sort(dst, comparator, parallelism, 0, dst.length);
        }
        public void sort(float[] src, float[] dst) {
            sort(src, Float::compare, dst);
        }
    }
    private static class OfChar implements PrimitiveSorter.OfChar {
        private int parallelism;
        private OfChar(int parallelism) {
            this.parallelism = parallelism;
        }
        public List<Algorithm> getAlgorithms() { return Arrays.asList(Algorithm.QUICK); }
        public void sort(char[] src, PrimitiveComparator.OfChar comparator, char[] dst) {
            if(dst == null) dst = src;
            else {
                if(dst.length != src.length) dst = new char[src.length];
                System.arraycopy(src, 0, dst, 0, src.length);
            }
            jdk.prim.util.sort.dualpivot.OfChar.sort(dst, comparator, parallelism, 0, dst.length);
        }
        public void sort(char[] src, char[] dst) {
            sort(src, Character::compare, dst);
        }
    }
    private static class OfShort implements PrimitiveSorter.OfShort {
        private int parallelism;
        private OfShort(int parallelism) {
            this.parallelism = parallelism;
        }
        public List<Algorithm> getAlgorithms() { return Arrays.asList(Algorithm.QUICK); }
        public void sort(short[] src, PrimitiveComparator.OfShort comparator, short[] dst) {
            if(dst == null) dst = src;
            else {
                if(dst.length != src.length) dst = new short[src.length];
                System.arraycopy(src, 0, dst, 0, src.length);
            }
            jdk.prim.util.sort.dualpivot.OfShort.sort(dst, comparator, parallelism, 0, dst.length);
        }
        public void sort(short[] src, short[] dst) {
            sort(src, Short::compare, dst);
        }
    }
    private static class OfByte implements PrimitiveSorter.OfByte {
        private int parallelism;
        private OfByte(int parallelism) {
            this.parallelism = parallelism;
        }
        public List<Algorithm> getAlgorithms() { return Arrays.asList(Algorithm.QUICK); }
        public void sort(byte[] src, PrimitiveComparator.OfByte comparator, byte[] dst) {
            if(dst == null) dst = src;
            else {
                if(dst.length != src.length) dst = new byte[src.length];
                System.arraycopy(src, 0, dst, 0, src.length);
            }
            jdk.prim.util.sort.dualpivot.OfByte.sort(dst, comparator, parallelism, 0, dst.length);
        }
        public void sort(byte[] src, byte[] dst) {
            sort(src, Byte::compare, dst);
        }
    }
    private static class OfBoolean implements PrimitiveSorter.OfBoolean {
        private int parallelism;
        private OfBoolean(int parallelism) {
            this.parallelism = parallelism;
        }
        public List<Algorithm> getAlgorithms() { return Arrays.asList(Algorithm.QUICK); }
        public void sort(boolean[] src, PrimitiveComparator.OfBoolean comparator, boolean[] dst) {
            if(dst == null) dst = src;
            else {
                if(dst.length != src.length) dst = new boolean[src.length];
                System.arraycopy(src, 0, dst, 0, src.length);
            }
            jdk.prim.util.sort.dualpivot.OfBoolean.sort(dst, comparator, parallelism, 0, dst.length);
        }
        public void sort(boolean[] src, boolean[] dst) {
            sort(src, Boolean::compare, dst);
        }
    }

}
