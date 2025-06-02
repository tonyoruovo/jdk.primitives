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
public interface PrimitiveNode<T, T_CONS, T_ARR, T_SPLITR> {

    interface OfDouble extends PrimitiveNode<java.lang.Double, DoubleConsumer, double[], PrimitiveSpliterator.OfDouble> {
        default PrimitiveNode.OfDouble truncate(long from, long to, PrimitiveFunction.OfInt<double[]> generator) {
            if(from == 0 && to == count()) return this;
            PrimitiveSpliterator.OfDouble spliterator = spliterator();
            long size = to - from;
            PrimitiveNode.Builder.OfDouble nodeBuilder = PrimitiveNodes.builder(size, generator);
            nodeBuilder.begin(size);
            for(int i = 0; i < from && spliterator.tryAdvance(e -> {}); i++) {}
            if(to == count()) spliterator.forEachRemaining(nodeBuilder);
            else for(int i = 0; i < size && spliterator.tryAdvance(nodeBuilder); i++) {}

            nodeBuilder.end();
            return nodeBuilder.build();
        }
    }
    interface OfLong extends PrimitiveNode<java.lang.Long, LongConsumer, long[], PrimitiveSpliterator.OfLong> {
        default PrimitiveNode.OfLong truncate(long from, long to, PrimitiveFunction.OfInt<long[]> generator) {
            if(from == 0 && to == count()) return this;
            PrimitiveSpliterator.OfLong spliterator = spliterator();
            long size = to - from;
            PrimitiveNode.Builder.OfLong nodeBuilder = PrimitiveNodes.builder(size, generator);
            nodeBuilder.begin(size);
            for(int i = 0; i < from && spliterator.tryAdvance(e -> {}); i++) {}
            if(to == count()) spliterator.forEachRemaining(nodeBuilder);
            else for(int i = 0; i < size && spliterator.tryAdvance(nodeBuilder); i++) {}

            nodeBuilder.end();
            return nodeBuilder.build();
        }
    }
    interface OfInt extends PrimitiveNode<java.lang.Integer, IntConsumer, int[], PrimitiveSpliterator.OfInt> {
        default PrimitiveNode.OfInt truncate(long from, long to, PrimitiveFunction.OfInt<int[]> generator) {
            if(from == 0 && to == count()) return this;
            PrimitiveSpliterator.OfInt spliterator = spliterator();
            long size = to - from;
            PrimitiveNode.Builder.OfInt nodeBuilder = PrimitiveNodes.builder(size, generator);
            nodeBuilder.begin(size);
            for(int i = 0; i < from && spliterator.tryAdvance(e -> {}); i++) {}
            if(to == count()) spliterator.forEachRemaining(nodeBuilder);
            else for(int i = 0; i < size && spliterator.tryAdvance(nodeBuilder); i++) {}

            nodeBuilder.end();
            return nodeBuilder.build();
        }
    }
    interface OfFloat extends PrimitiveNode<java.lang.Float, PrimitiveConsumer.OfFloat, float[], PrimitiveSpliterator.OfFloat> {
        default PrimitiveNode.OfFloat truncate(long from, long to, PrimitiveFunction.OfInt<float[]> generator) {
            if(from == 0 && to == count()) return this;
            PrimitiveSpliterator.OfFloat spliterator = spliterator();
            long size = to - from;
            PrimitiveNode.Builder.OfFloat nodeBuilder = PrimitiveNodes.builder(size, generator);
            nodeBuilder.begin(size);
            for(int i = 0; i < from && spliterator.tryAdvance(e -> {}); i++) {}
            if(to == count()) spliterator.forEachRemaining(nodeBuilder);
            else for(int i = 0; i < size && spliterator.tryAdvance(nodeBuilder); i++) {}

            nodeBuilder.end();
            return nodeBuilder.build();
        }
    }
    interface OfChar extends PrimitiveNode<java.lang.Character, PrimitiveConsumer.OfChar, char[], PrimitiveSpliterator.OfChar> {
        default PrimitiveNode.OfChar truncate(long from, long to, PrimitiveFunction.OfInt<char[]> generator) {
            if(from == 0 && to == count()) return this;
            PrimitiveSpliterator.OfChar spliterator = spliterator();
            long size = to - from;
            PrimitiveNode.Builder.OfChar nodeBuilder = PrimitiveNodes.builder(size, generator);
            nodeBuilder.begin(size);
            for(int i = 0; i < from && spliterator.tryAdvance(e -> {}); i++) {}
            if(to == count()) spliterator.forEachRemaining(nodeBuilder);
            else for(int i = 0; i < size && spliterator.tryAdvance(nodeBuilder); i++) {}

            nodeBuilder.end();
            return nodeBuilder.build();
        }
    }
    interface OfShort extends PrimitiveNode<java.lang.Short, PrimitiveConsumer.OfShort, short[], PrimitiveSpliterator.OfShort> {
        default PrimitiveNode.OfShort truncate(long from, long to, PrimitiveFunction.OfInt<short[]> generator) {
            if(from == 0 && to == count()) return this;
            PrimitiveSpliterator.OfShort spliterator = spliterator();
            long size = to - from;
            PrimitiveNode.Builder.OfShort nodeBuilder = PrimitiveNodes.builder(size, generator);
            nodeBuilder.begin(size);
            for(int i = 0; i < from && spliterator.tryAdvance(e -> {}); i++) {}
            if(to == count()) spliterator.forEachRemaining(nodeBuilder);
            else for(int i = 0; i < size && spliterator.tryAdvance(nodeBuilder); i++) {}

            nodeBuilder.end();
            return nodeBuilder.build();
        }
    }
    interface OfByte extends PrimitiveNode<java.lang.Byte, PrimitiveConsumer.OfByte, byte[], PrimitiveSpliterator.OfByte> {
        default PrimitiveNode.OfByte truncate(long from, long to, PrimitiveFunction.OfInt<byte[]> generator) {
            if(from == 0 && to == count()) return this;
            PrimitiveSpliterator.OfByte spliterator = spliterator();
            long size = to - from;
            PrimitiveNode.Builder.OfByte nodeBuilder = PrimitiveNodes.builder(size, generator);
            nodeBuilder.begin(size);
            for(int i = 0; i < from && spliterator.tryAdvance(e -> {}); i++) {}
            if(to == count()) spliterator.forEachRemaining(nodeBuilder);
            else for(int i = 0; i < size && spliterator.tryAdvance(nodeBuilder); i++) {}

            nodeBuilder.end();
            return nodeBuilder.build();
        }
    }
    interface OfBoolean extends PrimitiveNode<java.lang.Boolean, PrimitiveConsumer.OfBoolean, boolean[], PrimitiveSpliterator.OfBoolean> {
        default PrimitiveNode.OfBoolean truncate(long from, long to, PrimitiveFunction.OfInt<boolean[]> generator) {
            if(from == 0 && to == count()) return this;
            PrimitiveSpliterator.OfBoolean spliterator = spliterator();
            long size = to - from;
            PrimitiveNode.Builder.OfBoolean nodeBuilder = PrimitiveNodes.builder(size, generator);
            nodeBuilder.begin(size);
            for(int i = 0; i < from && spliterator.tryAdvance(e -> {}); i++) {}
            if(to == count()) spliterator.forEachRemaining(nodeBuilder);
            else for(int i = 0; i < size && spliterator.tryAdvance(nodeBuilder); i++) {}

            nodeBuilder.end();
            return nodeBuilder.build();
        }
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
     * @param consumer
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
     * @see java.util.stream.Node#copyInto(Object[], int)
     */
    void copyInto(T_ARR array, int offset);
    /**
     * @see java.util.stream.Node#count
     */
    long count();
}
