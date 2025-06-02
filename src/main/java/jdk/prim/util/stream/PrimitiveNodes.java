package jdk.prim.util.stream;

import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

import jdk.prim.util.PrimitiveSpliterator;
import jdk.prim.util.PrimitiveSpliterators;
import jdk.prim.util.function.PrimitiveConsumer;
import jdk.prim.util.function.PrimitiveFunction;

final class PrimitiveNodes {
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
}
