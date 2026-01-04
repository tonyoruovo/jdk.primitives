package jdk.prim.util.stream;

import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

import jdk.prim.util.PrimitiveSpliterator;
import jdk.prim.util.function.PrimitiveConsumer;
import jdk.prim.util.function.PrimitiveFunction;

/**
 * @see java.util.stream.Node
 */
interface PrimitiveNode<T, T_CONS, T_ARR, T_SPLITR> {

    interface OfDouble extends PrimitiveNode<java.lang.Double, PrimitiveConsumer.OfDouble, double[], PrimitiveSpliterator.OfDouble> {
        @Override default double[] asArray(PrimitiveFunction.OfInt<double[]> generator) {
            long size = count();
            if(size >= PrimitiveNodes.MAX_ARRAY_SIZE) {
                throw new IllegalArgumentException("Stream size is too big");
            }
            double[] array = generator.apply((int) size);
            copyInto(array, 0);
            return array;
        }
        @Override default void forEach(PrimitiveConsumer.OfDouble consumer) {
            spliterator().forEachRemaining(consumer);
        }
        @Override default void copyInto(double[] array, int offset) {
            double[] a = asArray();
            for (int i = 0; i < array.length; i++) a[offset + i] = array[i];
        }
        default PrimitiveNode.OfDouble truncate(long from, long to, PrimitiveFunction.OfInt<double[]> generator) {
            if(from == 0 && to == count()) return this;
            PrimitiveSpliterator.OfDouble spliterator = spliterator();
            long size = to - from;
            PrimitiveNode.Builder.OfDouble nodeBuilder = PrimitiveNodes.doubleBuilder(size, generator);
            nodeBuilder.begin(size);
            for(int i = 0; i < from && spliterator.tryAdvance(e -> {}); i++) {}
            if(to == count()) spliterator.forEachRemaining(nodeBuilder);
            else for(int i = 0; i < size && spliterator.tryAdvance(nodeBuilder); i++) {}

            nodeBuilder.end();
            return nodeBuilder.build();
        }
        @Override default double[] newArray(int count) { return new double[count]; }
    }
    interface OfLong extends PrimitiveNode<java.lang.Long, PrimitiveConsumer.OfLong, long[], PrimitiveSpliterator.OfLong> {
        @Override default long[] asArray(PrimitiveFunction.OfInt<long[]> generator) {
            long size = count();
            if(size >= PrimitiveNodes.MAX_ARRAY_SIZE) {
                throw new IllegalArgumentException("Stream size is too big");
            }
            long[] array = generator.apply((int) size);
            copyInto(array, 0);
            return array;
        }
        @Override default void forEach(PrimitiveConsumer.OfLong consumer) {
            spliterator().forEachRemaining(consumer);
        }
        @Override default void copyInto(long[] array, int offset) {
            long[] a = asArray();
            for (int i = 0; i < array.length; i++) a[offset + i] = array[i];
        }
        default PrimitiveNode.OfLong truncate(long from, long to, PrimitiveFunction.OfInt<long[]> generator) {
            if(from == 0 && to == count()) return this;
            PrimitiveSpliterator.OfLong spliterator = spliterator();
            long size = to - from;
            PrimitiveNode.Builder.OfLong nodeBuilder = PrimitiveNodes.longBuilder(size, generator);
            nodeBuilder.begin(size);
            for(int i = 0; i < from && spliterator.tryAdvance(e -> {}); i++) {}
            if(to == count()) spliterator.forEachRemaining(nodeBuilder);
            else for(int i = 0; i < size && spliterator.tryAdvance(nodeBuilder); i++) {}

            nodeBuilder.end();
            return nodeBuilder.build();
        }
        @Override default long[] newArray(int count) { return new long[count]; }
    }
    interface OfInt extends PrimitiveNode<java.lang.Integer, PrimitiveConsumer.OfInt, int[], PrimitiveSpliterator.OfInt> {
        @Override default int[] asArray(PrimitiveFunction.OfInt<int[]> generator) {
            long size = count();
            if(size >= PrimitiveNodes.MAX_ARRAY_SIZE) {
                throw new IllegalArgumentException("Stream size is too big");
            }
            int[] array = generator.apply((int) size);
            copyInto(array, 0);
            return array;
        }
        @Override default void forEach(PrimitiveConsumer.OfInt consumer) {
            spliterator().forEachRemaining(consumer);
        }
        @Override default void copyInto(int[] array, int offset) {
            int[] a = asArray();
            for (int i = 0; i < array.length; i++) a[offset + i] = array[i];
        }
        default PrimitiveNode.OfInt truncate(long from, long to, PrimitiveFunction.OfInt<int[]> generator) {
            if(from == 0 && to == count()) return this;
            PrimitiveSpliterator.OfInt spliterator = spliterator();
            long size = to - from;
            PrimitiveNode.Builder.OfInt nodeBuilder = PrimitiveNodes.intBuilder(size, generator);
            nodeBuilder.begin(size);
            for(int i = 0; i < from && spliterator.tryAdvance(e -> {}); i++) {}
            if(to == count()) spliterator.forEachRemaining(nodeBuilder);
            else for(int i = 0; i < size && spliterator.tryAdvance(nodeBuilder); i++) {}

            nodeBuilder.end();
            return nodeBuilder.build();
        }
        @Override default int[] newArray(int count) { return new int[count]; }
    }
    interface OfFloat extends PrimitiveNode<java.lang.Float, PrimitiveConsumer.OfFloat, float[], PrimitiveSpliterator.OfFloat> {
        @Override default float[] asArray(PrimitiveFunction.OfInt<float[]> generator) {
            long size = count();
            if(size >= PrimitiveNodes.MAX_ARRAY_SIZE) {
                throw new IllegalArgumentException("Stream size is too big");
            }
            float[] array = generator.apply((int) size);
            copyInto(array, 0);
            return array;
        }
        @Override default void forEach(PrimitiveConsumer.OfFloat consumer) {
            spliterator().forEachRemaining(consumer);
        }
        @Override default void copyInto(float[] array, int offset) {
            float[] a = asArray();
            for (int i = 0; i < array.length; i++) a[offset + i] = array[i];
        }
        default PrimitiveNode.OfFloat truncate(long from, long to, PrimitiveFunction.OfInt<float[]> generator) {
            if(from == 0 && to == count()) return this;
            PrimitiveSpliterator.OfFloat spliterator = spliterator();
            long size = to - from;
            PrimitiveNode.Builder.OfFloat nodeBuilder = PrimitiveNodes.floatBuilder(size, generator);
            nodeBuilder.begin(size);
            for(int i = 0; i < from && spliterator.tryAdvance(e -> {}); i++) {}
            if(to == count()) spliterator.forEachRemaining(nodeBuilder);
            else for(int i = 0; i < size && spliterator.tryAdvance(nodeBuilder); i++) {}

            nodeBuilder.end();
            return nodeBuilder.build();
        }
        @Override default float[] newArray(int count) { return new float[count]; }
    }
    interface OfChar extends PrimitiveNode<java.lang.Character, PrimitiveConsumer.OfChar, char[], PrimitiveSpliterator.OfChar> {
        @Override default char[] asArray(PrimitiveFunction.OfInt<char[]> generator) {
            long size = count();
            if(size >= PrimitiveNodes.MAX_ARRAY_SIZE) {
                throw new IllegalArgumentException("Stream size is too big");
            }
            char[] array = generator.apply((int) size);
            copyInto(array, 0);
            return array;
        }
        @Override default void forEach(PrimitiveConsumer.OfChar consumer) {
            spliterator().forEachRemaining(consumer);
        }
        @Override default void copyInto(char[] array, int offset) {
            char[] a = asArray();
            for (int i = 0; i < array.length; i++) a[offset + i] = array[i];
        }
        default PrimitiveNode.OfChar truncate(long from, long to, PrimitiveFunction.OfInt<char[]> generator) {
            if(from == 0 && to == count()) return this;
            PrimitiveSpliterator.OfChar spliterator = spliterator();
            long size = to - from;
            PrimitiveNode.Builder.OfChar nodeBuilder = PrimitiveNodes.charBuilder(size, generator);
            nodeBuilder.begin(size);
            for(int i = 0; i < from && spliterator.tryAdvance(e -> {}); i++) {}
            if(to == count()) spliterator.forEachRemaining(nodeBuilder);
            else for(int i = 0; i < size && spliterator.tryAdvance(nodeBuilder); i++) {}

            nodeBuilder.end();
            return nodeBuilder.build();
        }
        @Override default char[] newArray(int count) { return new char[count]; }
    }
    interface OfShort extends PrimitiveNode<java.lang.Short, PrimitiveConsumer.OfShort, short[], PrimitiveSpliterator.OfShort> {
        @Override default short[] asArray(PrimitiveFunction.OfInt<short[]> generator) {
            long size = count();
            if(size >= PrimitiveNodes.MAX_ARRAY_SIZE) {
                throw new IllegalArgumentException("Stream size is too big");
            }
            short[] array = generator.apply((int) size);
            copyInto(array, 0);
            return array;
        }
        @Override default void forEach(PrimitiveConsumer.OfShort consumer) {
            spliterator().forEachRemaining(consumer);
        }
        @Override default void copyInto(short[] array, int offset) {
            short[] a = asArray();
            for (int i = 0; i < array.length; i++) a[offset + i] = array[i];
        }
        default PrimitiveNode.OfShort truncate(long from, long to, PrimitiveFunction.OfInt<short[]> generator) {
            if(from == 0 && to == count()) return this;
            PrimitiveSpliterator.OfShort spliterator = spliterator();
            long size = to - from;
            PrimitiveNode.Builder.OfShort nodeBuilder = PrimitiveNodes.shortBuilder(size, generator);
            nodeBuilder.begin(size);
            for(int i = 0; i < from && spliterator.tryAdvance(e -> {}); i++) {}
            if(to == count()) spliterator.forEachRemaining(nodeBuilder);
            else for(int i = 0; i < size && spliterator.tryAdvance(nodeBuilder); i++) {}

            nodeBuilder.end();
            return nodeBuilder.build();
        }
        @Override default short[] newArray(int count) { return new short[count]; }
    }
    interface OfByte extends PrimitiveNode<java.lang.Byte, PrimitiveConsumer.OfByte, byte[], PrimitiveSpliterator.OfByte> {
        @Override default byte[] asArray(PrimitiveFunction.OfInt<byte[]> generator) {
            long size = count();
            if(size >= PrimitiveNodes.MAX_ARRAY_SIZE) {
                throw new IllegalArgumentException("Stream size is too big");
            }
            byte[] array = generator.apply((int) size);
            copyInto(array, 0);
            return array;
        }
        @Override default void forEach(PrimitiveConsumer.OfByte consumer) {
            spliterator().forEachRemaining(consumer);
        }
        @Override default void copyInto(byte[] array, int offset) {
            byte[] a = asArray();
            for (int i = 0; i < array.length; i++) a[offset + i] = array[i];
        }
        default PrimitiveNode.OfByte truncate(long from, long to, PrimitiveFunction.OfInt<byte[]> generator) {
            if(from == 0 && to == count()) return this;
            PrimitiveSpliterator.OfByte spliterator = spliterator();
            long size = to - from;
            PrimitiveNode.Builder.OfByte nodeBuilder = PrimitiveNodes.byteBuilder(size, generator);
            nodeBuilder.begin(size);
            for(int i = 0; i < from && spliterator.tryAdvance(e -> {}); i++) {}
            if(to == count()) spliterator.forEachRemaining(nodeBuilder);
            else for(int i = 0; i < size && spliterator.tryAdvance(nodeBuilder); i++) {}

            nodeBuilder.end();
            return nodeBuilder.build();
        }
        @Override default byte[] newArray(int count) { return new byte[count]; }
    }
    interface OfBoolean extends PrimitiveNode<java.lang.Boolean, PrimitiveConsumer.OfBoolean, boolean[], PrimitiveSpliterator.OfBoolean> {
        @Override default boolean[] asArray(PrimitiveFunction.OfInt<boolean[]> generator) {
            long size = count();
            if(size >= PrimitiveNodes.MAX_ARRAY_SIZE) {
                throw new IllegalArgumentException("Stream size is too big");
            }
            boolean[] array = generator.apply((int) size);
            copyInto(array, 0);
            return array;
        }
        @Override default void forEach(PrimitiveConsumer.OfBoolean consumer) {
            spliterator().forEachRemaining(consumer);
        }
        @Override default void copyInto(boolean[] array, int offset) {
            boolean[] a = asArray();
            for (int i = 0; i < array.length; i++) a[offset + i] = array[i];
        }
        default PrimitiveNode.OfBoolean truncate(long from, long to, PrimitiveFunction.OfInt<boolean[]> generator) {
            if(from == 0 && to == count()) return this;
            PrimitiveSpliterator.OfBoolean spliterator = spliterator();
            long size = to - from;
            PrimitiveNode.Builder.OfBoolean nodeBuilder = PrimitiveNodes.booleanBuilder(size, generator);
            nodeBuilder.begin(size);
            for(int i = 0; i < from && spliterator.tryAdvance(e -> {}); i++) {}
            if(to == count()) spliterator.forEachRemaining(nodeBuilder);
            else for(int i = 0; i < size && spliterator.tryAdvance(nodeBuilder); i++) {}

            nodeBuilder.end();
            return nodeBuilder.build();
        }
        @Override default boolean[] newArray(int count) { return new boolean[count]; }
    }

    interface Builder<T> extends PrimitiveSink<T> {

        interface OfDouble extends PrimitiveNode.Builder<java.lang.Double>, PrimitiveSink.OfDouble {
            @Override PrimitiveNode.OfDouble build();
        }
        interface OfLong extends PrimitiveNode.Builder<java.lang.Long>, PrimitiveSink.OfLong {
            @Override PrimitiveNode.OfLong build();
        }
        interface OfInt extends PrimitiveNode.Builder<java.lang.Integer>, PrimitiveSink.OfInt {
            @Override PrimitiveNode.OfInt build();
        }
        interface OfFloat extends PrimitiveNode.Builder<java.lang.Float>, PrimitiveSink.OfFloat {
            @Override PrimitiveNode.OfFloat build();
        }
        interface OfChar extends PrimitiveNode.Builder<java.lang.Character>, PrimitiveSink.OfChar {
            @Override PrimitiveNode.OfChar build();
        }
        interface OfShort extends PrimitiveNode.Builder<java.lang.Short>, PrimitiveSink.OfShort {
            @Override PrimitiveNode.OfShort build();
        }
        interface OfByte extends PrimitiveNode.Builder<java.lang.Byte>, PrimitiveSink.OfByte {
            @Override PrimitiveNode.OfByte build();
        }
        interface OfBoolean extends PrimitiveNode.Builder<java.lang.Boolean>, PrimitiveSink.OfBoolean {
            @Override PrimitiveNode.OfBoolean build();
        }
        
        PrimitiveNode<T, ?, ?, ?> build();
    }

    /**
     * @see java.util.stream.Node#spliterator
     */
    T_SPLITR spliterator();

    /**
     * @see java.util.stream.Node#forEach(java.util.function.Consumer)
     */
    void forEach(T_CONS consumer);
    /**
     * @see java.util.stream.Node#getChild(int)
     */
    default int getChildCount() { return 0; }
    /**
     * @see java.util.stream.Node#getChild(int)
     */
    default PrimitiveNode<T, T_CONS, T_ARR, T_SPLITR> getChild(int i) {
        throw new IndexOutOfBoundsException(i);
    }
    /**
     * @see java.util.stream.Node#truncate
     */
    default PrimitiveNode<T, T_CONS, T_ARR, T_SPLITR> truncate(long from, long to, PrimitiveFunction.OfInt<T_ARR> generator) {
        throw new IllegalStateException("Vague implementation called");
    }
    /**
     * @see java.util.stream.Node#asArray(java.util.function.IntFunction)
     */
    T_ARR asArray(PrimitiveFunction.OfInt<T_ARR> generator);

    /**
     * @see java.util.stream.Node.OfPrimitive#asPrimitiveArray()
     */
    T_ARR asArray();

    /**
     * @see java.util.stream.Node.OfPrimitive#newArray(int)
     */
    T_ARR newArray(int count);
    /**
     * @see java.util.stream.Node#copyInto(Object[], int)
     */
    void copyInto(T_ARR array, int offset);
    /**
     * @see java.util.stream.Node#count
     */
    long count();
}
