package jdk.prim.util.stream;

import java.util.Arrays;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

import jdk.prim.util.PrimitiveSpliterator;
import jdk.prim.util.PrimitiveSpliterators;
import jdk.prim.util.function.PrimitiveConsumer;
import jdk.prim.util.function.PrimitiveFunction;

/**
 * @see java.util.stream.Nodes
 */
final class PrimitiveNodes {
    private PrimitiveNodes() {
        throw new Error("Attempted instantiation");
    }
    static final long MAX_ARRAY_SIZE = java.lang.Integer.MAX_VALUE - 8;
    public static PrimitiveNode.OfDouble emptyDouble() {
        return new PrimitiveNode.OfDouble() {
            public double[] asArray(PrimitiveFunction.OfInt<double[]> generator) { return generator.apply(0); }
            public long count() { return 0; }
            public void copyInto(double[] array, int offset) { if(array == null) throw new NullPointerException("array is null"); }
            public void forEach(DoubleConsumer consumer) { if(consumer == null) throw new NullPointerException("consumer is null"); }
            public PrimitiveSpliterator.OfDouble  spliterator() { return PrimitiveSpliterators.emptyDouble(); }
        };
    }
    public static PrimitiveNode.OfLong emptyLong() {
        return new PrimitiveNode.OfLong() {
            public long[] asArray(PrimitiveFunction.OfInt<long[]> generator) { return generator.apply(0); }
            public long count() { return 0; }
            public void copyInto(long[] array, int offset) { if(array == null) throw new NullPointerException("array is null"); }
            public void forEach(LongConsumer consumer) { if(consumer == null) throw new NullPointerException("consumer is null"); }
            public PrimitiveSpliterator.OfLong  spliterator() { return PrimitiveSpliterators.emptyLong(); }
        };
    }
    public static PrimitiveNode.OfInt emptyInt() {
        return new PrimitiveNode.OfInt() {
            public int[] asArray(PrimitiveFunction.OfInt<int[]> generator) { return generator.apply(0); }
            public long count() { return 0; }
            public void copyInto(int[] array, int offset) { if(array == null) throw new NullPointerException("array is null"); }
            public void forEach(IntConsumer consumer) { if(consumer == null) throw new NullPointerException("consumer is null"); }
            public PrimitiveSpliterator.OfInt  spliterator() { return PrimitiveSpliterators.emptyInt(); }
        };
    }
    public static PrimitiveNode.OfFloat emptyFloat() {
        return new PrimitiveNode.OfFloat() {
            public float[] asArray(PrimitiveFunction.OfInt<float[]> generator) { return generator.apply(0); }
            public long count() { return 0; }
            public void copyInto(float[] array, int offset) { if(array == null) throw new NullPointerException("array is null"); }
            public void forEach(PrimitiveConsumer.OfFloat consumer) { if(consumer == null) throw new NullPointerException("consumer is null"); }
            public PrimitiveSpliterator.OfFloat  spliterator() { return PrimitiveSpliterators.emptyFloat(); }
        };
    }
    public static PrimitiveNode.OfChar emptyChar() {
        return new PrimitiveNode.OfChar() {
            public char[] asArray(PrimitiveFunction.OfInt<char[]> generator) { return generator.apply(0); }
            public long count() { return 0; }
            public void copyInto(char[] array, int offset) { if(array == null) throw new NullPointerException("array is null"); }
            public void forEach(PrimitiveConsumer.OfChar consumer) { if(consumer == null) throw new NullPointerException("consumer is null"); }
            public PrimitiveSpliterator.OfChar  spliterator() { return PrimitiveSpliterators.emptyChar(); }
        };
    }
    public static PrimitiveNode.OfShort emptyShort() {
        return new PrimitiveNode.OfShort() {
            public short[] asArray(PrimitiveFunction.OfInt<short[]> generator) { return generator.apply(0); }
            public long count() { return 0; }
            public void copyInto(short[] array, int offset) { if(array == null) throw new NullPointerException("array is null"); }
            public void forEach(PrimitiveConsumer.OfShort consumer) { if(consumer == null) throw new NullPointerException("consumer is null"); }
            public PrimitiveSpliterator.OfShort  spliterator() { return PrimitiveSpliterators.emptyShort(); }
        };
    }
    public static PrimitiveNode.OfByte emptyByte() {
        return new PrimitiveNode.OfByte() {
            public byte[] asArray(PrimitiveFunction.OfInt<byte[]> generator) { return generator.apply(0); }
            public long count() { return 0; }
            public void copyInto(byte[] array, int offset) { if(array == null) throw new NullPointerException("array is null"); }
            public void forEach(PrimitiveConsumer.OfByte consumer) { if(consumer == null) throw new NullPointerException("consumer is null"); }
            public PrimitiveSpliterator.OfByte  spliterator() { return PrimitiveSpliterators.emptyByte(); }
        };
    }
    public static PrimitiveNode.OfBoolean emptyBoolean() {
        return new PrimitiveNode.OfBoolean() {
            public boolean[] asArray(PrimitiveFunction.OfInt<boolean[]> generator) { return generator.apply(0); }
            public long count() { return 0; }
            public void copyInto(boolean[] array, int offset) { if(array == null) throw new NullPointerException("array is null"); }
            public void forEach(PrimitiveConsumer.OfBoolean consumer) { if(consumer == null) throw new NullPointerException("consumer is null"); }
            public PrimitiveSpliterator.OfBoolean  spliterator() { return PrimitiveSpliterators.emptyBoolean(); }
        };
    }
    public static class DoubleArrayNode implements PrimitiveNode.OfDouble {
        private final double[] array;
        int curSize;
        DoubleArrayNode(long size) {
            if(size > MAX_ARRAY_SIZE) throw new IllegalArgumentException("Stream exceeds maximum array size");
            array = new double[(int) size];
            curSize = 0;
        }
        DoubleArrayNode(double[] array) {
            this.array = array;
            this.curSize = array.length;
        }
        public PrimitiveSpliterator.OfDouble spliterator() { return PrimitiveSpliterators.spliterator(array, 0, curSize, 0); }
        public double[] asArray() {
            if(array.length == curSize) return array;
            return Arrays.copyOf(array, curSize);
        }
        public void copyInto(double[] dest, int destOffset) { System.arrayCopy(array, 0, dest, destOffset, curSize); }
        public long count() { return curSize; }
        public void forEach(PrimitiveConsumer.OfDouble consumer) {
            for (int i = 0; i < curSize; i++) {
                consumer.acceptDouble(array[i]);
            }
        }
        public String toString() {
            return String.format("DoubleArrayNode[%d][%s]", array.length - curSize, Arrays.toString(array));
        }
    }
    public static class LongArrayNode implements PrimitiveNode.OfLong {
        private final long[] array;
        int curSize;
        LongArrayNode(long size) {
            if(size > MAX_ARRAY_SIZE) throw new IllegalArgumentException("Stream exceeds maximum array size");
            array = new long[(int) size];
            curSize = 0;
        }
        LongArrayNode(long[] array) {
            this.array = array;
            this.curSize = array.length;
        }
        public PrimitiveSpliterator.OfLong spliterator() { return PrimitiveSpliterators.spliterator(array, 0, curSize, 0); }
        public long[] asArray() {
            if(array.length == curSize) return array;
            return Arrays.copyOf(array, curSize);
        }
        public void copyInto(long[] dest, int destOffset) { System.arrayCopy(array, 0, dest, destOffset, curSize); }
        public long count() { return curSize; }
        public void forEach(PrimitiveConsumer.OfLong consumer) {
            for (int i = 0; i < curSize; i++) {
                consumer.acceptLong(array[i]);
            }
        }
        public String toString() {
            return String.format("LongArrayNode[%d][%s]", array.length - curSize, Arrays.toString(array));
        }
    }
    public static class IntArrayNode implements PrimitiveNode.OfInt {
        private final int[] array;
        int curSize;
        IntArrayNode(long size) {
            if(size > MAX_ARRAY_SIZE) throw new IllegalArgumentException("Stream exceeds maximum array size");
            array = new int[(int) size];
            curSize = 0;
        }
        IntArrayNode(int[] array) {
            this.array = array;
            this.curSize = array.length;
        }
        public PrimitiveSpliterator.OfInt spliterator() { return PrimitiveSpliterators.spliterator(array, 0, curSize, 0); }
        public int[] asArray() {
            if(array.length == curSize) return array;
            return Arrays.copyOf(array, curSize);
        }
        public void copyInto(int[] dest, int destOffset) { System.arrayCopy(array, 0, dest, destOffset, curSize); }
        public long count() { return curSize; }
        public void forEach(PrimitiveConsumer.OfInt consumer) {
            for (int i = 0; i < curSize; i++) {
                consumer.acceptInt(array[i]);
            }
        }
        public String toString() {
            return String.format("IntArrayNode[%d][%s]", array.length - curSize, Arrays.toString(array));
        }
    }
    public static class FloatArrayNode implements PrimitiveNode.OfFloat {
        private final float[] array;
        int curSize;
        FloatArrayNode(long size) {
            if(size > MAX_ARRAY_SIZE) throw new IllegalArgumentException("Stream exceeds maximum array size");
            array = new float[(int) size];
            curSize = 0;
        }
        FloatArrayNode(float[] array) {
            this.array = array;
            this.curSize = array.length;
        }
        public PrimitiveSpliterator.OfFloat spliterator() { return PrimitiveSpliterators.spliterator(array, 0, curSize, 0); }
        public float[] asArray() {
            if(array.length == curSize) return array;
            return Arrays.copyOf(array, curSize);
        }
        public void copyInto(float[] dest, int destOffset) { System.arrayCopy(array, 0, dest, destOffset, curSize); }
        public long count() { return curSize; }
        public void forEach(PrimitiveConsumer.OfFloat consumer) {
            for (int i = 0; i < curSize; i++) {
                consumer.acceptFloat(array[i]);
            }
        }
        public String toString() {
            return String.format("FloatArrayNode[%d][%s]", array.length - curSize, Arrays.toString(array));
        }
    }
    public static class CharArrayNode implements PrimitiveNode.OfChar {
        private final char[] array;
        int curSize;
        CharArrayNode(long size) {
            if(size > MAX_ARRAY_SIZE) throw new IllegalArgumentException("Stream exceeds maximum array size");
            array = new char[(int) size];
            curSize = 0;
        }
        CharArrayNode(char[] array) {
            this.array = array;
            this.curSize = array.length;
        }
        public PrimitiveSpliterator.OfChar spliterator() { return PrimitiveSpliterators.spliterator(array, 0, curSize, 0); }
        public char[] asArray() {
            if(array.length == curSize) return array;
            return Arrays.copyOf(array, curSize);
        }
        public void copyInto(char[] dest, int destOffset) { System.arrayCopy(array, 0, dest, destOffset, curSize); }
        public long count() { return curSize; }
        public void forEach(PrimitiveConsumer.OfChar consumer) {
            for (int i = 0; i < curSize; i++) {
                consumer.acceptChar(array[i]);
            }
        }
        public String toString() {
            return String.format("CharArrayNode[%d][%s]", array.length - curSize, Arrays.toString(array));
        }
    }
    public static class ShortArrayNode implements PrimitiveNode.OfShort {
        private final short[] array;
        int curSize;
        ShortArrayNode(long size) {
            if(size > MAX_ARRAY_SIZE) throw new IllegalArgumentException("Stream exceeds maximum array size");
            array = new short[(int) size];
            curSize = 0;
        }
        ShortArrayNode(short[] array) {
            this.array = array;
            this.curSize = array.length;
        }
        public PrimitiveSpliterator.OfShort spliterator() { return PrimitiveSpliterators.spliterator(array, 0, curSize, 0); }
        public short[] asArray() {
            if(array.length == curSize) return array;
            return Arrays.copyOf(array, curSize);
        }
        public void copyInto(short[] dest, int destOffset) { System.arrayCopy(array, 0, dest, destOffset, curSize); }
        public long count() { return curSize; }
        public void forEach(PrimitiveConsumer.OfShort consumer) {
            for (int i = 0; i < curSize; i++) {
                consumer.acceptShort(array[i]);
            }
        }
        public String toString() {
            return String.format("ShortArrayNode[%d][%s]", array.length - curSize, Arrays.toString(array));
        }
    }
    public static class ByteArrayNode implements PrimitiveNode.OfByte {
        private final byte[] array;
        int curSize;
        ByteArrayNode(long size) {
            if(size > MAX_ARRAY_SIZE) throw new IllegalArgumentException("Stream exceeds maximum array size");
            array = new byte[(int) size];
            curSize = 0;
        }
        ByteArrayNode(byte[] array) {
            this.array = array;
            this.curSize = array.length;
        }
        public PrimitiveSpliterator.OfByte spliterator() { return PrimitiveSpliterators.spliterator(array, 0, curSize, 0); }
        public byte[] asArray() {
            if(array.length == curSize) return array;
            return Arrays.copyOf(array, curSize);
        }
        public void copyInto(byte[] dest, int destOffset) { System.arrayCopy(array, 0, dest, destOffset, curSize); }
        public long count() { return curSize; }
        public void forEach(PrimitiveConsumer.OfByte consumer) {
            for (int i = 0; i < curSize; i++) {
                consumer.acceptByte(array[i]);
            }
        }
        public String toString() {
            return String.format("ByteArrayNode[%d][%s]", array.length - curSize, Arrays.toString(array));
        }
    }
    public static class BooleanArrayNode implements PrimitiveNode.OfBoolean {
        private final boolean[] array;
        int curSize;
        BooleanArrayNode(long size) {
            if(size > MAX_ARRAY_SIZE) throw new IllegalArgumentException("Stream exceeds maximum array size");
            array = new boolean[(int) size];
            curSize = 0;
        }
        BooleanArrayNode(boolean[] array) {
            this.array = array;
            this.curSize = array.length;
        }
        public PrimitiveSpliterator.OfBoolean spliterator() { return PrimitiveSpliterators.spliterator(array, 0, curSize, 0); }
        public boolean[] asArray() {
            if(array.length == curSize) return array;
            return Arrays.copyOf(array, curSize);
        }
        public void copyInto(boolean[] dest, int destOffset) { System.arrayCopy(array, 0, dest, destOffset, curSize); }
        public long count() { return curSize; }
        public void forEach(PrimitiveConsumer.OfBoolean consumer) {
            for (int i = 0; i < curSize; i++) {
                consumer.acceptBoolean(array[i]);
            }
        }
        public String toString() {
            return String.format("BooleanArrayNode[%d][%s]", array.length - curSize, Arrays.toString(array));
        }
    }
}
