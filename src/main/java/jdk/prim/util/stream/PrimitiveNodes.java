package jdk.prim.util.stream;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

import jdk.prim.util.PrimitiveArrays;
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
            public double[] asArray() { return PrimitiveArrays.emptyDouble(); }
            public long count() { return 0; }
            public void copyInto(double[] array, int offset) { if(array == null) throw new NullPointerException("array is null"); }
            public void forEach(DoubleConsumer consumer) { if(consumer == null) throw new NullPointerException("consumer is null"); }
            public PrimitiveSpliterator.OfDouble  spliterator() { return PrimitiveSpliterators.emptyDouble(); }
        };
    }
    public static PrimitiveNode.OfLong emptyLong() {
        return new PrimitiveNode.OfLong() {
            public long[] asArray(PrimitiveFunction.OfInt<long[]> generator) { return generator.apply(0); }
            public long[] asArray() { return PrimitiveArrays.emptyLong(); }
            public long count() { return 0; }
            public void copyInto(long[] array, int offset) { if(array == null) throw new NullPointerException("array is null"); }
            public void forEach(LongConsumer consumer) { if(consumer == null) throw new NullPointerException("consumer is null"); }
            public PrimitiveSpliterator.OfLong  spliterator() { return PrimitiveSpliterators.emptyLong(); }
        };
    }
    public static PrimitiveNode.OfInt emptyInt() {
        return new PrimitiveNode.OfInt() {
            public int[] asArray(PrimitiveFunction.OfInt<int[]> generator) { return generator.apply(0); }
            public int[] asArray() { return PrimitiveArrays.emptyInt(); }
            public long count() { return 0; }
            public void copyInto(int[] array, int offset) { if(array == null) throw new NullPointerException("array is null"); }
            public void forEach(IntConsumer consumer) { if(consumer == null) throw new NullPointerException("consumer is null"); }
            public PrimitiveSpliterator.OfInt  spliterator() { return PrimitiveSpliterators.emptyInt(); }
        };
    }
    public static PrimitiveNode.OfFloat emptyFloat() {
        return new PrimitiveNode.OfFloat() {
            public float[] asArray(PrimitiveFunction.OfInt<float[]> generator) { return generator.apply(0); }
            public float[] asArray() { return PrimitiveArrays.emptyFloat(); }
            public long count() { return 0; }
            public void copyInto(float[] array, int offset) { if(array == null) throw new NullPointerException("array is null"); }
            public void forEach(PrimitiveConsumer.OfFloat consumer) { if(consumer == null) throw new NullPointerException("consumer is null"); }
            public PrimitiveSpliterator.OfFloat  spliterator() { return PrimitiveSpliterators.emptyFloat(); }
        };
    }
    public static PrimitiveNode.OfChar emptyChar() {
        return new PrimitiveNode.OfChar() {
            public char[] asArray(PrimitiveFunction.OfInt<char[]> generator) { return generator.apply(0); }
            public char[] asArray() { return PrimitiveArrays.emptyChar(); }
            public long count() { return 0; }
            public void copyInto(char[] array, int offset) { if(array == null) throw new NullPointerException("array is null"); }
            public void forEach(PrimitiveConsumer.OfChar consumer) { if(consumer == null) throw new NullPointerException("consumer is null"); }
            public PrimitiveSpliterator.OfChar  spliterator() { return PrimitiveSpliterators.emptyChar(); }
        };
    }
    public static PrimitiveNode.OfShort emptyShort() {
        return new PrimitiveNode.OfShort() {
            public short[] asArray(PrimitiveFunction.OfInt<short[]> generator) { return generator.apply(0); }
            public short[] asArray() { return PrimitiveArrays.emptyShort(); }
            public long count() { return 0; }
            public void copyInto(short[] array, int offset) { if(array == null) throw new NullPointerException("array is null"); }
            public void forEach(PrimitiveConsumer.OfShort consumer) { if(consumer == null) throw new NullPointerException("consumer is null"); }
            public PrimitiveSpliterator.OfShort  spliterator() { return PrimitiveSpliterators.emptyShort(); }
        };
    }
    public static PrimitiveNode.OfByte emptyByte() {
        return new PrimitiveNode.OfByte() {
            public byte[] asArray(PrimitiveFunction.OfInt<byte[]> generator) { return generator.apply(0); }
            public byte[] asArray() { return PrimitiveArrays.emptyByte(); }
            public long count() { return 0; }
            public void copyInto(byte[] array, int offset) { if(array == null) throw new NullPointerException("array is null"); }
            public void forEach(PrimitiveConsumer.OfByte consumer) { if(consumer == null) throw new NullPointerException("consumer is null"); }
            public PrimitiveSpliterator.OfByte  spliterator() { return PrimitiveSpliterators.emptyByte(); }
        };
    }
    public static PrimitiveNode.OfBoolean emptyBoolean() {
        return new PrimitiveNode.OfBoolean() {
            public boolean[] asArray(PrimitiveFunction.OfInt<boolean[]> generator) { return generator.apply(0); }
            public boolean[] asArray() { return PrimitiveArrays.emptyBoolean(); }
            public long count() { return 0; }
            public void copyInto(boolean[] array, int offset) { if(array == null) throw new NullPointerException("array is null"); }
            public void forEach(PrimitiveConsumer.OfBoolean consumer) { if(consumer == null) throw new NullPointerException("consumer is null"); }
            public PrimitiveSpliterator.OfBoolean  spliterator() { return PrimitiveSpliterators.emptyBoolean(); }
        };
    }

    public static class DoubleArrayNode implements PrimitiveNode.OfDouble {
        protected final double[] array;
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
        public void copyInto(double[] dest, int destOffset) { System.arraycopy(array, 0, dest, destOffset, curSize); }
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
        protected final long[] array;
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
        public void copyInto(long[] dest, int destOffset) { System.arraycopy(array, 0, dest, destOffset, curSize); }
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
        protected final int[] array;
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
        public void copyInto(int[] dest, int destOffset) { System.arraycopy(array, 0, dest, destOffset, curSize); }
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
        protected final float[] array;
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
        public void copyInto(float[] dest, int destOffset) { System.arraycopy(array, 0, dest, destOffset, curSize); }
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
        protected final char[] array;
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
        public void copyInto(char[] dest, int destOffset) { System.arraycopy(array, 0, dest, destOffset, curSize); }
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
        protected final short[] array;
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
        public void copyInto(short[] dest, int destOffset) { System.arraycopy(array, 0, dest, destOffset, curSize); }
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
        protected final byte[] array;
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
        public void copyInto(byte[] dest, int destOffset) { System.arraycopy(array, 0, dest, destOffset, curSize); }
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
        protected final boolean[] array;
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
        public void copyInto(boolean[] dest, int destOffset) { System.arraycopy(array, 0, dest, destOffset, curSize); }
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

    public static final class DoubleFixedNodeBuilder extends DoubleArrayNode implements PrimitiveNode.Builder.OfDouble {
        DoubleFixedNodeBuilder(long size) {
            super(size);
            assert size < MAX_ARRAY_SIZE;
        }
        @Override public PrimitiveNode.OfDouble build() {
            if (curSize < array.length) {
                throw new IllegalStateException(String.format("Current size %d is less than fixed size %d", curSize, array.length));
            }

            return this;
        }
        @Override public void begin(long size) {
            if(size != array.length) {
                throw new IllegalStateException(String.format("Begin size %d is not equal to fixed size %d", size, array.length));
            }

            curSize = 0;
        }
        @Override public void acceptDouble(double d) {
            if(curSize < array.length) array[curSize++] = d;
            else throw new IllegalStateException("Accept exceeded fixed size of %d".formatted(array.length));
        }
        @Override public void end() {
            if(curSize < array.length) throw new IllegalStateException(String.format("End size %d is less than fixed size %d", curSize, array.length));
        }
        @Override public String toString() {
            return String.format("DoubleFixedNodeBuilder[%d][%s]", array.length - curSize, Arrays.toString(array));
        }
    }
    public static final class LongFixedNodeBuilder extends LongArrayNode implements PrimitiveNode.Builder.OfLong {
        LongFixedNodeBuilder(long size) {
            super(size);
            assert size < MAX_ARRAY_SIZE;
        }
        @Override public PrimitiveNode.OfLong build() {
            if (curSize < array.length) {
                throw new IllegalStateException(String.format("Current size %d is less than fixed size %d", curSize, array.length));
            }

            return this;
        }
        @Override public void begin(long size) {
            if(size != array.length) {
                throw new IllegalStateException(String.format("Begin size %d is not equal to fixed size %d", size, array.length));
            }

            curSize = 0;
        }
        @Override public void acceptLong(long l) {
            if(curSize < array.length) array[curSize++] = l;
            else throw new IllegalStateException("Accept exceeded fixed size of %d".formatted(array.length));
        }
        @Override public void end() {
            if(curSize < array.length) throw new IllegalStateException(String.format("End size %d is less than fixed size %d", curSize, array.length));
        }
        @Override public String toString() {
            return String.format("LongFixedNodeBuilder[%d][%s]", array.length - curSize, Arrays.toString(array));
        }
    }
    public static final class IntFixedNodeBuilder extends IntArrayNode implements PrimitiveNode.Builder.OfInt {
        IntFixedNodeBuilder(long size) {
            super(size);
            assert size < MAX_ARRAY_SIZE;
        }
        @Override public PrimitiveNode.OfInt build() {
            if (curSize < array.length) {
                throw new IllegalStateException(String.format("Current size %d is less than fixed size %d", curSize, array.length));
            }

            return this;
        }
        @Override public void begin(long size) {
            if(size != array.length) {
                throw new IllegalStateException(String.format("Begin size %d is not equal to fixed size %d", size, array.length));
            }

            curSize = 0;
        }
        @Override public void acceptInt(int i) {
            if(curSize < array.length) array[curSize++] = i;
            else throw new IllegalStateException("Accept exceeded fixed size of %d".formatted(array.length));
        }
        @Override public void end() {
            if(curSize < array.length) throw new IllegalStateException(String.format("End size %d is less than fixed size %d", curSize, array.length));
        }
        @Override public String toString() {
            return String.format("IntFixedNodeBuilder[%d][%s]", array.length - curSize, Arrays.toString(array));
        }
    }
    public static final class FloatFixedNodeBuilder extends FloatArrayNode implements PrimitiveNode.Builder.OfFloat {
        FloatFixedNodeBuilder(long size) {
            super(size);
            assert size < MAX_ARRAY_SIZE;
        }
        @Override public PrimitiveNode.OfFloat build() {
            if (curSize < array.length) {
                throw new IllegalStateException(String.format("Current size %d is less than fixed size %d", curSize, array.length));
            }

            return this;
        }
        @Override public void begin(long size) {
            if(size != array.length) {
                throw new IllegalStateException(String.format("Begin size %d is not equal to fixed size %d", size, array.length));
            }

            curSize = 0;
        }
        @Override public void acceptFloat(float f) {
            if(curSize < array.length) array[curSize++] = f;
            else throw new IllegalStateException("Accept exceeded fixed size of %d".formatted(array.length));
        }
        @Override public void end() {
            if(curSize < array.length) throw new IllegalStateException(String.format("End size %d is less than fixed size %d", curSize, array.length));
        }
        @Override public String toString() {
            return String.format("FloatFixedNodeBuilder[%d][%s]", array.length - curSize, Arrays.toString(array));
        }
    }
    public static final class CharFixedNodeBuilder extends CharArrayNode implements PrimitiveNode.Builder.OfChar {
        CharFixedNodeBuilder(long size) {
            super(size);
            assert size < MAX_ARRAY_SIZE;
        }
        @Override public PrimitiveNode.OfChar build() {
            if (curSize < array.length) {
                throw new IllegalStateException(String.format("Current size %d is less than fixed size %d", curSize, array.length));
            }

            return this;
        }
        @Override public void begin(long size) {
            if(size != array.length) {
                throw new IllegalStateException(String.format("Begin size %d is not equal to fixed size %d", size, array.length));
            }

            curSize = 0;
        }
        @Override public void acceptChar(char c) {
            if(curSize < array.length) array[curSize++] = c;
            else throw new IllegalStateException("Accept exceeded fixed size of %d".formatted(array.length));
        }
        @Override public void end() {
            if(curSize < array.length) throw new IllegalStateException(String.format("End size %d is less than fixed size %d", curSize, array.length));
        }
        @Override public String toString() {
            return String.format("CharFixedNodeBuilder[%d][%s]", array.length - curSize, Arrays.toString(array));
        }
    }
    public static final class ShortFixedNodeBuilder extends ShortArrayNode implements PrimitiveNode.Builder.OfShort {
        ShortFixedNodeBuilder(long size) {
            super(size);
            assert size < MAX_ARRAY_SIZE;
        }
        @Override public PrimitiveNode.OfShort build() {
            if (curSize < array.length) {
                throw new IllegalStateException(String.format("Current size %d is less than fixed size %d", curSize, array.length));
            }

            return this;
        }
        @Override public void begin(long size) {
            if(size != array.length) {
                throw new IllegalStateException(String.format("Begin size %d is not equal to fixed size %d", size, array.length));
            }

            curSize = 0;
        }
        @Override public void acceptShort(short s) {
            if(curSize < array.length) array[curSize++] = s;
            else throw new IllegalStateException("Accept exceeded fixed size of %d".formatted(array.length));
        }
        @Override public void end() {
            if(curSize < array.length) throw new IllegalStateException(String.format("End size %d is less than fixed size %d", curSize, array.length));
        }
        @Override public String toString() {
            return String.format("ShortFixedNodeBuilder[%d][%s]", array.length - curSize, Arrays.toString(array));
        }
    }
    public static final class ByteFixedNodeBuilder extends ByteArrayNode implements PrimitiveNode.Builder.OfByte {
        ByteFixedNodeBuilder(long size) {
            super(size);
            assert size < MAX_ARRAY_SIZE;
        }
        @Override public PrimitiveNode.OfByte build() {
            if (curSize < array.length) {
                throw new IllegalStateException(String.format("Current size %d is less than fixed size %d", curSize, array.length));
            }

            return this;
        }
        @Override public void begin(long size) {
            if(size != array.length) {
                throw new IllegalStateException(String.format("Begin size %d is not equal to fixed size %d", size, array.length));
            }

            curSize = 0;
        }
        @Override public void acceptByte(byte b) {
            if(curSize < array.length) array[curSize++] = b;
            else throw new IllegalStateException("Accept exceeded fixed size of %d".formatted(array.length));
        }
        @Override public void end() {
            if(curSize < array.length) throw new IllegalStateException(String.format("End size %d is less than fixed size %d", curSize, array.length));
        }
        @Override public String toString() {
            return String.format("ByteFixedNodeBuilder[%d][%s]", array.length - curSize, Arrays.toString(array));
        }
    }
    public static final class BooleanFixedNodeBuilder extends BooleanArrayNode implements PrimitiveNode.Builder.OfBoolean {
        BooleanFixedNodeBuilder(long size) {
            super(size);
            assert size < MAX_ARRAY_SIZE;
        }
        @Override public PrimitiveNode.OfBoolean build() {
            if (curSize < array.length) {
                throw new IllegalStateException(String.format("Current size %d is less than fixed size %d", curSize, array.length));
            }

            return this;
        }
        @Override public void begin(long size) {
            if(size != array.length) {
                throw new IllegalStateException(String.format("Begin size %d is not equal to fixed size %d", size, array.length));
            }

            curSize = 0;
        }
        @Override public void acceptBoolean(boolean b) {
            if(curSize < array.length) array[curSize++] = b;
            else throw new IllegalStateException("Accept exceeded fixed size of %d".formatted(array.length));
        }
        @Override public void end() {
            if(curSize < array.length) throw new IllegalStateException(String.format("End size %d is less than fixed size %d", curSize, array.length));
        }
        @Override public String toString() {
            return String.format("BooleanFixedNodeBuilder[%d][%s]", array.length - curSize, Arrays.toString(array));
        }
    }

    public static final class DoubleSpinedNodeBuilder extends PrimitiveSpinedBuffer.OfDouble implements PrimitiveNode.OfDouble, PrimitiveNode.Builder.OfDouble {
        private boolean building = false;

        DoubleSpinedNodeBuilder() {}

        @Override public PrimitiveSpliterator.OfDouble spliterator() {
            assert !building : "during building";
            return super.spliteratorDouble();
        }
        @Override public void forEach(PrimitiveConsumer.OfDouble c) {
            assert !building : "during building";
            super.forEach(c);
        }
        @Override public void begin(long size) {
            assert !building : "was already building";
            building = true;
            clear();
            ensureCapacity(size);
        }
        @Override public void acceptDouble(double x) {
            assert building : "not building";
            super.acceptDouble(x);
        }
        @Override public void end() {
            assert building : "not building";
            building = false;
        }
        @Override public void copyInto(double[] array, int offset) {
            assert !building : "during building";
            super.copyInto(array, offset);
        }
        @Override public double[] asArray() {
            assert !building : "during building";
            return super.asArray();
        }
        @Override public PrimitiveNode.OfDouble build() {
            assert !building : "during building";
            return this;
        }
    }
    public static final class LongSpinedNodeBuilder extends PrimitiveSpinedBuffer.OfLong implements PrimitiveNode.OfLong, PrimitiveNode.Builder.OfLong {
        private boolean building = false;

        LongSpinedNodeBuilder() {}

        @Override public PrimitiveSpliterator.OfLong spliterator() {
            assert !building : "during building";
            return super.spliteratorLong();
        }
        @Override public void forEach(PrimitiveConsumer.OfLong c) {
            assert !building : "during building";
            super.forEach(c);
        }
        @Override public void begin(long size) {
            assert !building : "was already building";
            building = true;
            clear();
            ensureCapacity(size);
        }
        @Override public void acceptLong(long x) {
            assert building : "not building";
            super.acceptLong(x);
        }
        @Override public void end() {
            assert building : "not building";
            building = false;
        }
        @Override public void copyInto(long[] array, int offset) {
            assert !building : "during building";
            super.copyInto(array, offset);
        }
        @Override public long[] asArray() {
            assert !building : "during building";
            return super.asArray();
        }
        @Override public PrimitiveNode.OfLong build() {
            assert !building : "during building";
            return this;
        }
    }
    public static final class IntSpinedNodeBuilder extends PrimitiveSpinedBuffer.OfInt implements PrimitiveNode.OfInt, PrimitiveNode.Builder.OfInt {
        private boolean building = false;

        IntSpinedNodeBuilder() {}

        @Override public PrimitiveSpliterator.OfInt spliterator() {
            assert !building : "during building";
            return super.spliteratorInt();
        }
        @Override public void forEach(PrimitiveConsumer.OfInt c) {
            assert !building : "during building";
            super.forEach(c);
        }
        @Override public void begin(long size) {
            assert !building : "was already building";
            building = true;
            clear();
            ensureCapacity(size);
        }
        @Override public void acceptInt(int x) {
            assert building : "not building";
            super.acceptInt(x);
        }
        @Override public void end() {
            assert building : "not building";
            building = false;
        }
        @Override public void copyInto(int[] array, int offset) {
            assert !building : "during building";
            super.copyInto(array, offset);
        }
        @Override public int[] asArray() {
            assert !building : "during building";
            return super.asArray();
        }
        @Override public PrimitiveNode.OfInt build() {
            assert !building : "during building";
            return this;
        }
    }
    public static final class FloatSpinedNodeBuilder extends PrimitiveSpinedBuffer.OfFloat implements PrimitiveNode.OfFloat, PrimitiveNode.Builder.OfFloat {
        private boolean building = false;

        FloatSpinedNodeBuilder() {}

        @Override public PrimitiveSpliterator.OfFloat spliterator() {
            assert !building : "during building";
            return super.spliteratorFloat();
        }
        @Override public void forEach(PrimitiveConsumer.OfFloat c) {
            assert !building : "during building";
            super.forEach(c);
        }
        @Override public void begin(long size) {
            assert !building : "was already building";
            building = true;
            clear();
            ensureCapacity(size);
        }
        @Override public void acceptFloat(float x) {
            assert building : "not building";
            super.acceptFloat(x);
        }
        @Override public void end() {
            assert building : "not building";
            building = false;
        }
        @Override public void copyInto(float[] array, int offset) {
            assert !building : "during building";
            super.copyInto(array, offset);
        }
        @Override public float[] asArray() {
            assert !building : "during building";
            return super.asArray();
        }
        @Override public PrimitiveNode.OfFloat build() {
            assert !building : "during building";
            return this;
        }
    }
    public static final class CharSpinedNodeBuilder extends PrimitiveSpinedBuffer.OfChar implements PrimitiveNode.OfChar, PrimitiveNode.Builder.OfChar {
        private boolean building = false;

        CharSpinedNodeBuilder() {}

        @Override public PrimitiveSpliterator.OfChar spliterator() {
            assert !building : "during building";
            return super.spliteratorChar();
        }
        @Override public void forEach(PrimitiveConsumer.OfChar c) {
            assert !building : "during building";
            super.forEach(c);
        }
        @Override public void begin(long size) {
            assert !building : "was already building";
            building = true;
            clear();
            ensureCapacity(size);
        }
        @Override public void acceptChar(char x) {
            assert building : "not building";
            super.acceptChar(x);
        }
        @Override public void end() {
            assert building : "not building";
            building = false;
        }
        @Override public void copyInto(char[] array, int offset) {
            assert !building : "during building";
            super.copyInto(array, offset);
        }
        @Override public char[] asArray() {
            assert !building : "during building";
            return super.asArray();
        }
        @Override public PrimitiveNode.OfChar build() {
            assert !building : "during building";
            return this;
        }
    }
    public static final class ShortSpinedNodeBuilder extends PrimitiveSpinedBuffer.OfShort implements PrimitiveNode.OfShort, PrimitiveNode.Builder.OfShort {
        private boolean building = false;

        ShortSpinedNodeBuilder() {}

        @Override public PrimitiveSpliterator.OfShort spliterator() {
            assert !building : "during building";
            return super.spliteratorShort();
        }
        @Override public void forEach(PrimitiveConsumer.OfShort c) {
            assert !building : "during building";
            super.forEach(c);
        }
        @Override public void begin(long size) {
            assert !building : "was already building";
            building = true;
            clear();
            ensureCapacity(size);
        }
        @Override public void acceptShort(short x) {
            assert building : "not building";
            super.acceptShort(x);
        }
        @Override public void end() {
            assert building : "not building";
            building = false;
        }
        @Override public void copyInto(short[] array, int offset) {
            assert !building : "during building";
            super.copyInto(array, offset);
        }
        @Override public short[] asArray() {
            assert !building : "during building";
            return super.asArray();
        }
        @Override public PrimitiveNode.OfShort build() {
            assert !building : "during building";
            return this;
        }
    }
    public static final class ByteSpinedNodeBuilder extends PrimitiveSpinedBuffer.OfByte implements PrimitiveNode.OfByte, PrimitiveNode.Builder.OfByte {
        private boolean building = false;

        ByteSpinedNodeBuilder() {}

        @Override public PrimitiveSpliterator.OfByte spliterator() {
            assert !building : "during building";
            return super.spliteratorByte();
        }
        @Override public void forEach(PrimitiveConsumer.OfByte c) {
            assert !building : "during building";
            super.forEach(c);
        }
        @Override public void begin(long size) {
            assert !building : "was already building";
            building = true;
            clear();
            ensureCapacity(size);
        }
        @Override public void acceptByte(byte x) {
            assert building : "not building";
            super.acceptByte(x);
        }
        @Override public void end() {
            assert building : "not building";
            building = false;
        }
        @Override public void copyInto(byte[] array, int offset) {
            assert !building : "during building";
            super.copyInto(array, offset);
        }
        @Override public byte[] asArray() {
            assert !building : "during building";
            return super.asArray();
        }
        @Override public PrimitiveNode.OfByte build() {
            assert !building : "during building";
            return this;
        }
    }
    public static final class BooleanSpinedNodeBuilder extends PrimitiveSpinedBuffer.OfBoolean implements PrimitiveNode.OfBoolean, PrimitiveNode.Builder.OfBoolean {
        private boolean building = false;

        BooleanSpinedNodeBuilder() {}

        @Override public PrimitiveSpliterator.OfBoolean spliterator() {
            assert !building : "during building";
            return super.spliteratorBoolean();
        }
        @Override public void forEach(PrimitiveConsumer.OfBoolean c) {
            assert !building : "during building";
            super.forEach(c);
        }
        @Override public void begin(long size) {
            assert !building : "was already building";
            building = true;
            clear();
            ensureCapacity(size);
        }
        @Override public void acceptBoolean(boolean x) {
            assert building : "not building";
            super.acceptBoolean(x);
        }
        @Override public void end() {
            assert building : "not building";
            building = false;
        }
        @Override public void copyInto(boolean[] array, int offset) {
            assert !building : "during building";
            super.copyInto(array, offset);
        }
        @Override public boolean[] asArray() {
            assert !building : "during building";
            return super.asArray();
        }
        @Override public PrimitiveNode.OfBoolean build() {
            assert !building : "during building";
            return this;
        }
    }

}
