package jdk.prim.util.stream;

import jdk.prim.PrimitiveIterable;
import jdk.prim.util.*;
import jdk.prim.util.function.PrimitiveConsumer;

import java.util.Arrays;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

/**
 * @param <T> the type of primitive as an object
 * @param <T_ARR> the primitive array
 * @param <T_CONS> a {@link jdk.prim.util.function.PrimitiveConsumer primitive consumer}
 * @see java.util.stream.SpinedBuffer
 */
abstract class PrimitiveSpinedBuffer<T, T_ARR, T_CONS> extends AbstractSpinedBuffer implements PrimitiveIterable<T, T_CONS> {

    static class OfDouble extends PrimitiveSpinedBuffer<java.lang.Double, double[], PrimitiveConsumer.OfDouble> implements PrimitiveConsumer.OfDouble, PrimitiveIterable.OfDouble {
        OfDouble() {}
        OfDouble(int initialCapacity) { super(initialCapacity); }
        @Override public void forEach(Consumer<? super Double> consumer) {
            if(consumer instanceof PrimitiveConsumer.OfDouble) forEach((PrimitiveConsumer.OfDouble) consumer);
            else spliterator().forEachRemaining(consumer);
        }
        @Override public double[][] newArrayOfArray(int size) { return new double[size][]; }
        @Override public double[] newArray(int size) { return new double[size]; }
        @Override protected int arrayLength(double[] array) { return array.length; }
        @Override protected void arrayForEach(double[] array, int from, int to, PrimitiveConsumer.OfDouble consumer) {
            for(int i = from; i < to; i++) consumer.accept(array[i]);
        }
        @Override public void acceptDouble(double val) {
            preAccept();
            curChunk[elementIndex++] = val;
        }
        public double get(long index) {
            int ch = chunkFor(index);
            if(spineIndex == 0 && ch == 0) return curChunk[(int) index];
            else return spine[ch][(int) (index - priorElementCount[ch])];
        }
        @Override public PrimitiveIterator.OfDouble iteratorDouble() { return PrimitiveIterators.fromSpliterator(spliteratorDouble()); }
        @Override public PrimitiveIterator.OfDouble iterator() { return iteratorDouble(); }
        public PrimitiveSpliterator.OfDouble spliteratorDouble() {
            class Splitr extends BaseSpliterator<PrimitiveSpliterator.OfDouble> implements PrimitiveSpliterator.OfDouble {
                Splitr(int firstSpineIndex, int lastSpineIndex, int firstSpineElementIndex, int lastSpineElementFence) {
                    super(firstSpineIndex, lastSpineIndex, firstSpineElementIndex, lastSpineElementFence);
                }
                Splitr newSpliterator(int firstSpineIndex, int lastSpineIndex, int firstSpineElementIndex, int lastSpineElementFence) {
                    return new Splitr(firstSpineIndex, lastSpineIndex, firstSpineElementIndex, lastSpineElementFence);
                }
                void arrayForOne(double[] array, int index, PrimitiveConsumer.OfDouble consumer) { consumer.accept(array[index]); }
                PrimitiveSpliterator.OfDouble arraySpliterator(double[] array, int offset, int len) {
                    return PrimitiveSpliterators.spliterator(array, offset, offset + len);
                }
                public void forEachRemaining(PrimitiveConsumer.OfDouble consumer) {
                    if (splSpineIndex < lastSpineIndex
                            || (splSpineIndex == lastSpineIndex && splElementIndex < lastSpineElementFence)) {
                        int i = splElementIndex;
                        // completed chunks, if any
                        for (int sp = splSpineIndex; sp < lastSpineIndex; sp++) {
                            double[] chunk = spine[sp];
                            arrayForEach(chunk, i, arrayLength(chunk), consumer);
                            i = 0;
                        }
                        // last (or current uncompleted) chunk
                        double[] chunk = (splSpineIndex == lastSpineIndex) ? splChunk : spine[lastSpineIndex];
                        arrayForEach(chunk, i, lastSpineElementFence, consumer);
                        // mark consumed
                        splSpineIndex = lastSpineIndex;
                        splElementIndex = lastSpineElementFence;
                    }
                }
                public boolean tryAdvance(PrimitiveConsumer.OfDouble consumer) {
                    if(splSpineIndex < lastSpineIndex || (splSpineIndex == lastSpineIndex && splElementIndex < lastSpineElementFence)) {
                        arrayForOne(splChunk, splElementIndex++, consumer);

                        if(splElementIndex == arrayLength(splChunk)) {
                            splElementIndex = 0;
                            ++splSpineIndex;
                            if(spine != null && splSpineIndex <= lastSpineIndex) splChunk = spine[splSpineIndex];
                        }
                        return true;
                    }
                    return false;
                }
            };
            return new Splitr(0, spineIndex, 0, elementIndex);
        }

    }
    static class OfLong extends PrimitiveSpinedBuffer<java.lang.Long, long[], PrimitiveConsumer.OfLong> implements PrimitiveConsumer.OfLong, PrimitiveIterable.OfLong {
        OfLong() {}
        OfLong(int initialCapacity) { super(initialCapacity); }
        @Override public void forEach(Consumer<? super java.lang.Long> consumer) {
            if(consumer instanceof PrimitiveConsumer.OfLong) forEach((PrimitiveConsumer.OfLong) consumer);
            else spliterator().forEachRemaining(consumer);
        }
        @Override public long[][] newArrayOfArray(int size) { return new long[size][]; }
        @Override public long[] newArray(int size) { return new long[size]; }
        @Override protected int arrayLength(long[] array) { return array.length; }
        @Override protected void arrayForEach(long[] array, int from, int to, PrimitiveConsumer.OfLong consumer) {
            for(int i = from; i < to; i++) consumer.accept(array[i]);
        }
        @Override public void acceptLong(long val) {
            preAccept();
            curChunk[elementIndex++] = val;
        }
        public long get(long index) {
            int ch = chunkFor(index);
            if(spineIndex == 0 && ch == 0) return curChunk[(int) index];
            else return spine[ch][(int) (index - priorElementCount[ch])];
        }
        @Override public PrimitiveIterator.OfLong iteratorLong() { return PrimitiveIterators.fromSpliterator(spliteratorLong()); }
        @Override public PrimitiveIterator.OfLong iterator() { return iteratorLong(); }
        public PrimitiveSpliterator.OfLong spliteratorLong() {
            class Splitr extends BaseSpliterator<PrimitiveSpliterator.OfLong> implements PrimitiveSpliterator.OfLong {
                Splitr(int firstSpineIndex, int lastSpineIndex, int firstSpineElementIndex, int lastSpineElementFence) {
                    super(firstSpineIndex, lastSpineIndex, firstSpineElementIndex, lastSpineElementFence);
                }
                Splitr newSpliterator(int firstSpineIndex, int lastSpineIndex, int firstSpineElementIndex, int lastSpineElementFence) {
                    return new Splitr(firstSpineIndex, lastSpineIndex, firstSpineElementIndex, lastSpineElementFence);
                }
                void arrayForOne(long[] array, int index, PrimitiveConsumer.OfLong consumer) { consumer.accept(array[index]); }
                PrimitiveSpliterator.OfLong arraySpliterator(long[] array, int offset, int len) {
                    return PrimitiveSpliterators.spliterator(array, offset, offset + len);
                }
                public void forEachRemaining(PrimitiveConsumer.OfLong consumer) {
                    if (splSpineIndex < lastSpineIndex
                            || (splSpineIndex == lastSpineIndex && splElementIndex < lastSpineElementFence)) {
                        int i = splElementIndex;
                        // completed chunks, if any
                        for (int sp = splSpineIndex; sp < lastSpineIndex; sp++) {
                            long[] chunk = spine[sp];
                            arrayForEach(chunk, i, arrayLength(chunk), consumer);
                            i = 0;
                        }
                        // last (or current uncompleted) chunk
                        long[] chunk = (splSpineIndex == lastSpineIndex) ? splChunk : spine[lastSpineIndex];
                        arrayForEach(chunk, i, lastSpineElementFence, consumer);
                        // mark consumed
                        splSpineIndex = lastSpineIndex;
                        splElementIndex = lastSpineElementFence;
                    }
                }
                public boolean tryAdvance(PrimitiveConsumer.OfLong consumer) {
                    if(splSpineIndex < lastSpineIndex || (splSpineIndex == lastSpineIndex && splElementIndex < lastSpineElementFence)) {
                        arrayForOne(splChunk, splElementIndex++, consumer);

                        if(splElementIndex == arrayLength(splChunk)) {
                            splElementIndex = 0;
                            ++splSpineIndex;
                            if(spine != null && splSpineIndex <= lastSpineIndex) splChunk = spine[splSpineIndex];
                        }
                        return true;
                    }
                    return false;
                }
            };
            return new Splitr(0, spineIndex, 0, elementIndex);
        }
        
    }
    static class OfInt extends PrimitiveSpinedBuffer<java.lang.Integer, int[], PrimitiveConsumer.OfInt> implements PrimitiveConsumer.OfInt, PrimitiveIterable.OfInt {
        OfInt() {}
        OfInt(int initialCapacity) { super(initialCapacity); }
        @Override public void forEach(Consumer<? super java.lang.Integer> consumer) {
            if(consumer instanceof PrimitiveConsumer.OfInt) forEach((PrimitiveConsumer.OfInt) consumer);
            else spliterator().forEachRemaining(consumer);
        }
        @Override public int[][] newArrayOfArray(int size) { return new int[size][]; }
        @Override public int[] newArray(int size) { return new int[size]; }
        @Override protected int arrayLength(int[] array) { return array.length; }
        @Override protected void arrayForEach(int[] array, int from, int to, PrimitiveConsumer.OfInt consumer) {
            for(int i = from; i < to; i++) consumer.accept(array[i]);
        }
        @Override public void acceptInt(int val) {
            preAccept();
            curChunk[elementIndex++] = val;
        }
        public int get(long index) {
            int ch = chunkFor(index);
            if(spineIndex == 0 && ch == 0) return curChunk[(int) index];
            else return spine[ch][(int) (index - priorElementCount[ch])];
        }
        @Override public PrimitiveIterator.OfInt iteratorInt() { return PrimitiveIterators.fromSpliterator(spliteratorInt()); }
        @Override public PrimitiveIterator.OfInt iterator() { return iteratorInt(); }
        public PrimitiveSpliterator.OfInt spliteratorInt() {
            class Splitr extends BaseSpliterator<PrimitiveSpliterator.OfInt> implements PrimitiveSpliterator.OfInt {
                Splitr(int firstSpineIndex, int lastSpineIndex, int firstSpineElementIndex, int lastSpineElementFence) {
                    super(firstSpineIndex, lastSpineIndex, firstSpineElementIndex, lastSpineElementFence);
                }
                Splitr newSpliterator(int firstSpineIndex, int lastSpineIndex, int firstSpineElementIndex, int lastSpineElementFence) {
                    return new Splitr(firstSpineIndex, lastSpineIndex, firstSpineElementIndex, lastSpineElementFence);
                }
                void arrayForOne(int[] array, int index, PrimitiveConsumer.OfInt consumer) { consumer.accept(array[index]); }
                PrimitiveSpliterator.OfInt arraySpliterator(int[] array, int offset, int len) {
                    return PrimitiveSpliterators.spliterator(array, offset, offset + len);
                }
                public void forEachRemaining(PrimitiveConsumer.OfInt consumer) {
                    if (splSpineIndex < lastSpineIndex
                            || (splSpineIndex == lastSpineIndex && splElementIndex < lastSpineElementFence)) {
                        int i = splElementIndex;
                        // completed chunks, if any
                        for (int sp = splSpineIndex; sp < lastSpineIndex; sp++) {
                            int[] chunk = spine[sp];
                            arrayForEach(chunk, i, arrayLength(chunk), consumer);
                            i = 0;
                        }
                        // last (or current uncompleted) chunk
                        int[] chunk = (splSpineIndex == lastSpineIndex) ? splChunk : spine[lastSpineIndex];
                        arrayForEach(chunk, i, lastSpineElementFence, consumer);
                        // mark consumed
                        splSpineIndex = lastSpineIndex;
                        splElementIndex = lastSpineElementFence;
                    }
                }
                public boolean tryAdvance(PrimitiveConsumer.OfInt consumer) {
                    if(splSpineIndex < lastSpineIndex || (splSpineIndex == lastSpineIndex && splElementIndex < lastSpineElementFence)) {
                        arrayForOne(splChunk, splElementIndex++, consumer);

                        if(splElementIndex == arrayLength(splChunk)) {
                            splElementIndex = 0;
                            ++splSpineIndex;
                            if(spine != null && splSpineIndex <= lastSpineIndex) splChunk = spine[splSpineIndex];
                        }
                        return true;
                    }
                    return false;
                }
            };
            return new Splitr(0, spineIndex, 0, elementIndex);
        }
        
    }
    static class OfFloat extends PrimitiveSpinedBuffer<java.lang.Float, float[], PrimitiveConsumer.OfFloat> implements PrimitiveConsumer.OfFloat, PrimitiveIterable.OfFloat {
        OfFloat() {}
        OfFloat(int initialCapacity) { super(initialCapacity); }
        @Override public void forEach(Consumer<? super java.lang.Float> consumer) {
            if(consumer instanceof PrimitiveConsumer.OfFloat) forEach((PrimitiveConsumer.OfFloat) consumer);
            else spliterator().forEachRemaining(consumer);
        }
        @Override public float[][] newArrayOfArray(int size) { return new float[size][]; }
        @Override public float[] newArray(int size) { return new float[size]; }
        @Override protected int arrayLength(float[] array) { return array.length; }
        @Override protected void arrayForEach(float[] array, int from, int to, PrimitiveConsumer.OfFloat consumer) {
            for(int i = from; i < to; i++) consumer.acceptFloat(array[i]);
        }
        @Override public void acceptFloat(float val) {
            preAccept();
            curChunk[elementIndex++] = val;
        }
        public float get(long index) {
            int ch = chunkFor(index);
            if(spineIndex == 0 && ch == 0) return curChunk[(int) index];
            else return spine[ch][(int) (index - priorElementCount[ch])];
        }
        @Override public PrimitiveIterator.OfFloat iteratorFloat() { return PrimitiveIterators.fromSpliterator(spliteratorFloat()); }
        @Override public PrimitiveIterator.OfFloat iterator() { return iteratorFloat(); }
        public PrimitiveSpliterator.OfFloat spliteratorFloat() {
            class Splitr extends BaseSpliterator<PrimitiveSpliterator.OfFloat> implements PrimitiveSpliterator.OfFloat {
                Splitr(int firstSpineIndex, int lastSpineIndex, int firstSpineElementIndex, int lastSpineElementFence) {
                    super(firstSpineIndex, lastSpineIndex, firstSpineElementIndex, lastSpineElementFence);
                }
                Splitr newSpliterator(int firstSpineIndex, int lastSpineIndex, int firstSpineElementIndex, int lastSpineElementFence) {
                    return new Splitr(firstSpineIndex, lastSpineIndex, firstSpineElementIndex, lastSpineElementFence);
                }
                void arrayForOne(float[] array, int index, PrimitiveConsumer.OfFloat consumer) { consumer.acceptFloat(array[index]); }
                PrimitiveSpliterator.OfFloat arraySpliterator(float[] array, int offset, int len) {
                    return PrimitiveSpliterators.spliterator(array, offset, offset + len);
                }
                public void forEachRemaining(PrimitiveConsumer.OfFloat consumer) {
                    if (splSpineIndex < lastSpineIndex
                            || (splSpineIndex == lastSpineIndex && splElementIndex < lastSpineElementFence)) {
                        int i = splElementIndex;
                        // completed chunks, if any
                        for (int sp = splSpineIndex; sp < lastSpineIndex; sp++) {
                            float[] chunk = spine[sp];
                            arrayForEach(chunk, i, arrayLength(chunk), consumer);
                            i = 0;
                        }
                        // last (or current uncompleted) chunk
                        float[] chunk = (splSpineIndex == lastSpineIndex) ? splChunk : spine[lastSpineIndex];
                        arrayForEach(chunk, i, lastSpineElementFence, consumer);
                        // mark consumed
                        splSpineIndex = lastSpineIndex;
                        splElementIndex = lastSpineElementFence;
                    }
                }
                public boolean tryAdvance(PrimitiveConsumer.OfFloat consumer) {
                    if(splSpineIndex < lastSpineIndex || (splSpineIndex == lastSpineIndex && splElementIndex < lastSpineElementFence)) {
                        arrayForOne(splChunk, splElementIndex++, consumer);

                        if(splElementIndex == arrayLength(splChunk)) {
                            splElementIndex = 0;
                            ++splSpineIndex;
                            if(spine != null && splSpineIndex <= lastSpineIndex) splChunk = spine[splSpineIndex];
                        }
                        return true;
                    }
                    return false;
                }
            };
            return new Splitr(0, spineIndex, 0, elementIndex);
        }
        
    }
    static class OfChar extends PrimitiveSpinedBuffer<java.lang.Character, char[], PrimitiveConsumer.OfChar> implements PrimitiveConsumer.OfChar, PrimitiveIterable.OfChar {
        OfChar() {}
        OfChar(int initialCapacity) { super(initialCapacity); }
        @Override public void forEach(Consumer<? super java.lang.Character> consumer) {
            if(consumer instanceof PrimitiveConsumer.OfChar) forEach((PrimitiveConsumer.OfChar) consumer);
            else spliterator().forEachRemaining(consumer);
        }
        @Override public char[][] newArrayOfArray(int size) { return new char[size][]; }
        @Override public char[] newArray(int size) { return new char[size]; }
        @Override protected int arrayLength(char[] array) { return array.length; }
        @Override protected void arrayForEach(char[] array, int from, int to, PrimitiveConsumer.OfChar consumer) {
            for(int i = from; i < to; i++) consumer.acceptChar(array[i]);
        }
        @Override public void acceptChar(char val) {
            preAccept();
            curChunk[elementIndex++] = val;
        }
        public char get(long index) {
            int ch = chunkFor(index);
            if(spineIndex == 0 && ch == 0) return curChunk[(int) index];
            else return spine[ch][(int) (index - priorElementCount[ch])];
        }
        @Override public PrimitiveIterator.OfChar iteratorChar() { return PrimitiveIterators.fromSpliterator(spliteratorChar()); }
        @Override public PrimitiveIterator.OfChar iterator() { return iteratorChar(); }
        public PrimitiveSpliterator.OfChar spliteratorChar() {
            class Splitr extends BaseSpliterator<PrimitiveSpliterator.OfChar> implements PrimitiveSpliterator.OfChar {
                Splitr(int firstSpineIndex, int lastSpineIndex, int firstSpineElementIndex, int lastSpineElementFence) {
                    super(firstSpineIndex, lastSpineIndex, firstSpineElementIndex, lastSpineElementFence);
                }
                Splitr newSpliterator(int firstSpineIndex, int lastSpineIndex, int firstSpineElementIndex, int lastSpineElementFence) {
                    return new Splitr(firstSpineIndex, lastSpineIndex, firstSpineElementIndex, lastSpineElementFence);
                }
                void arrayForOne(char[] array, int index, PrimitiveConsumer.OfChar consumer) { consumer.acceptChar(array[index]); }
                PrimitiveSpliterator.OfChar arraySpliterator(char[] array, int offset, int len) {
                    return PrimitiveSpliterators.spliterator(array, offset, offset + len);
                }
                public void forEachRemaining(PrimitiveConsumer.OfChar consumer) {
                    if (splSpineIndex < lastSpineIndex
                            || (splSpineIndex == lastSpineIndex && splElementIndex < lastSpineElementFence)) {
                        int i = splElementIndex;
                        // completed chunks, if any
                        for (int sp = splSpineIndex; sp < lastSpineIndex; sp++) {
                            char[] chunk = spine[sp];
                            arrayForEach(chunk, i, arrayLength(chunk), consumer);
                            i = 0;
                        }
                        // last (or current uncompleted) chunk
                        char[] chunk = (splSpineIndex == lastSpineIndex) ? splChunk : spine[lastSpineIndex];
                        arrayForEach(chunk, i, lastSpineElementFence, consumer);
                        // mark consumed
                        splSpineIndex = lastSpineIndex;
                        splElementIndex = lastSpineElementFence;
                    }
                }
                public boolean tryAdvance(PrimitiveConsumer.OfChar consumer) {
                    if(splSpineIndex < lastSpineIndex || (splSpineIndex == lastSpineIndex && splElementIndex < lastSpineElementFence)) {
                        arrayForOne(splChunk, splElementIndex++, consumer);

                        if(splElementIndex == arrayLength(splChunk)) {
                            splElementIndex = 0;
                            ++splSpineIndex;
                            if(spine != null && splSpineIndex <= lastSpineIndex) splChunk = spine[splSpineIndex];
                        }
                        return true;
                    }
                    return false;
                }
            };
            return new Splitr(0, spineIndex, 0, elementIndex);
        }
        
    }
    static class OfShort extends PrimitiveSpinedBuffer<java.lang.Short, short[], PrimitiveConsumer.OfShort> implements PrimitiveConsumer.OfShort, PrimitiveIterable.OfShort {
        OfShort() {}
        OfShort(int initialCapacity) { super(initialCapacity); }
        @Override public void forEach(Consumer<? super java.lang.Short> consumer) {
            if(consumer instanceof PrimitiveConsumer.OfShort) forEach((PrimitiveConsumer.OfShort) consumer);
            else spliterator().forEachRemaining(consumer);
        }
        @Override public short[][] newArrayOfArray(int size) { return new short[size][]; }
        @Override public short[] newArray(int size) { return new short[size]; }
        @Override protected int arrayLength(short[] array) { return array.length; }
        @Override protected void arrayForEach(short[] array, int from, int to, PrimitiveConsumer.OfShort consumer) {
            for(int i = from; i < to; i++) consumer.acceptShort(array[i]);
        }
        @Override public void acceptShort(short val) {
            preAccept();
            curChunk[elementIndex++] = val;
        }
        public short get(long index) {
            int ch = chunkFor(index);
            if(spineIndex == 0 && ch == 0) return curChunk[(int) index];
            else return spine[ch][(int) (index - priorElementCount[ch])];
        }
        @Override public PrimitiveIterator.OfShort iteratorShort() { return PrimitiveIterators.fromSpliterator(spliteratorShort()); }
        @Override public PrimitiveIterator.OfShort iterator() { return iteratorShort(); }
        public PrimitiveSpliterator.OfShort spliteratorShort() {
            class Splitr extends BaseSpliterator<PrimitiveSpliterator.OfShort> implements PrimitiveSpliterator.OfShort {
                Splitr(int firstSpineIndex, int lastSpineIndex, int firstSpineElementIndex, int lastSpineElementFence) {
                    super(firstSpineIndex, lastSpineIndex, firstSpineElementIndex, lastSpineElementFence);
                }
                Splitr newSpliterator(int firstSpineIndex, int lastSpineIndex, int firstSpineElementIndex, int lastSpineElementFence) {
                    return new Splitr(firstSpineIndex, lastSpineIndex, firstSpineElementIndex, lastSpineElementFence);
                }
                void arrayForOne(short[] array, int index, PrimitiveConsumer.OfShort consumer) { consumer.acceptShort(array[index]); }
                PrimitiveSpliterator.OfShort arraySpliterator(short[] array, int offset, int len) {
                    return PrimitiveSpliterators.spliterator(array, offset, offset + len);
                }
                public void forEachRemaining(PrimitiveConsumer.OfShort consumer) {
                    if (splSpineIndex < lastSpineIndex
                            || (splSpineIndex == lastSpineIndex && splElementIndex < lastSpineElementFence)) {
                        int i = splElementIndex;
                        // completed chunks, if any
                        for (int sp = splSpineIndex; sp < lastSpineIndex; sp++) {
                            short[] chunk = spine[sp];
                            arrayForEach(chunk, i, arrayLength(chunk), consumer);
                            i = 0;
                        }
                        // last (or current uncompleted) chunk
                        short[] chunk = (splSpineIndex == lastSpineIndex) ? splChunk : spine[lastSpineIndex];
                        arrayForEach(chunk, i, lastSpineElementFence, consumer);
                        // mark consumed
                        splSpineIndex = lastSpineIndex;
                        splElementIndex = lastSpineElementFence;
                    }
                }
                public boolean tryAdvance(PrimitiveConsumer.OfShort consumer) {
                    if(splSpineIndex < lastSpineIndex || (splSpineIndex == lastSpineIndex && splElementIndex < lastSpineElementFence)) {
                        arrayForOne(splChunk, splElementIndex++, consumer);

                        if(splElementIndex == arrayLength(splChunk)) {
                            splElementIndex = 0;
                            ++splSpineIndex;
                            if(spine != null && splSpineIndex <= lastSpineIndex) splChunk = spine[splSpineIndex];
                        }
                        return true;
                    }
                    return false;
                }
            };
            return new Splitr(0, spineIndex, 0, elementIndex);
        }
        
    }
    static class OfByte extends PrimitiveSpinedBuffer<java.lang.Byte, byte[], PrimitiveConsumer.OfByte> implements PrimitiveConsumer.OfByte, PrimitiveIterable.OfByte {
        OfByte() {}
        OfByte(int initialCapacity) { super(initialCapacity); }
        @Override public void forEach(Consumer<? super java.lang.Byte> consumer) {
            if(consumer instanceof PrimitiveConsumer.OfByte) forEach((PrimitiveConsumer.OfByte) consumer);
            else spliterator().forEachRemaining(consumer);
        }
        @Override public byte[][] newArrayOfArray(int size) { return new byte[size][]; }
        @Override public byte[] newArray(int size) { return new byte[size]; }
        @Override protected int arrayLength(byte[] array) { return array.length; }
        @Override protected void arrayForEach(byte[] array, int from, int to, PrimitiveConsumer.OfByte consumer) {
            for(int i = from; i < to; i++) consumer.acceptByte(array[i]);
        }
        @Override public void acceptByte(byte val) {
            preAccept();
            curChunk[elementIndex++] = val;
        }
        public byte get(long index) {
            int ch = chunkFor(index);
            if(spineIndex == 0 && ch == 0) return curChunk[(int) index];
            else return spine[ch][(int) (index - priorElementCount[ch])];
        }
        @Override public PrimitiveIterator.OfByte iteratorByte() { return PrimitiveIterators.fromSpliterator(spliteratorByte()); }
        @Override public PrimitiveIterator.OfByte iterator() { return iteratorByte(); }
        public PrimitiveSpliterator.OfByte spliteratorByte() {
            class Splitr extends BaseSpliterator<PrimitiveSpliterator.OfByte> implements PrimitiveSpliterator.OfByte {
                Splitr(int firstSpineIndex, int lastSpineIndex, int firstSpineElementIndex, int lastSpineElementFence) {
                    super(firstSpineIndex, lastSpineIndex, firstSpineElementIndex, lastSpineElementFence);
                }
                Splitr newSpliterator(int firstSpineIndex, int lastSpineIndex, int firstSpineElementIndex, int lastSpineElementFence) {
                    return new Splitr(firstSpineIndex, lastSpineIndex, firstSpineElementIndex, lastSpineElementFence);
                }
                void arrayForOne(byte[] array, int index, PrimitiveConsumer.OfByte consumer) { consumer.acceptByte(array[index]); }
                PrimitiveSpliterator.OfByte arraySpliterator(byte[] array, int offset, int len) {
                    return PrimitiveSpliterators.spliterator(array, offset, offset + len);
                }
                public void forEachRemaining(PrimitiveConsumer.OfByte consumer) {
                    if (splSpineIndex < lastSpineIndex
                            || (splSpineIndex == lastSpineIndex && splElementIndex < lastSpineElementFence)) {
                        int i = splElementIndex;
                        // completed chunks, if any
                        for (int sp = splSpineIndex; sp < lastSpineIndex; sp++) {
                            byte[] chunk = spine[sp];
                            arrayForEach(chunk, i, arrayLength(chunk), consumer);
                            i = 0;
                        }
                        // last (or current uncompleted) chunk
                        byte[] chunk = (splSpineIndex == lastSpineIndex) ? splChunk : spine[lastSpineIndex];
                        arrayForEach(chunk, i, lastSpineElementFence, consumer);
                        // mark consumed
                        splSpineIndex = lastSpineIndex;
                        splElementIndex = lastSpineElementFence;
                    }
                }
                public boolean tryAdvance(PrimitiveConsumer.OfByte consumer) {
                    if(splSpineIndex < lastSpineIndex || (splSpineIndex == lastSpineIndex && splElementIndex < lastSpineElementFence)) {
                        arrayForOne(splChunk, splElementIndex++, consumer);

                        if(splElementIndex == arrayLength(splChunk)) {
                            splElementIndex = 0;
                            ++splSpineIndex;
                            if(spine != null && splSpineIndex <= lastSpineIndex) splChunk = spine[splSpineIndex];
                        }
                        return true;
                    }
                    return false;
                }
            };
            return new Splitr(0, spineIndex, 0, elementIndex);
        }
        
    }
    static class OfBoolean extends PrimitiveSpinedBuffer<java.lang.Boolean, boolean[], PrimitiveConsumer.OfBoolean> implements PrimitiveConsumer.OfBoolean, PrimitiveIterable.OfBoolean {
        OfBoolean() {}
        OfBoolean(int initialCapacity) { super(initialCapacity); }
        @Override public void forEach(Consumer<? super java.lang.Boolean> consumer) {
            if(consumer instanceof PrimitiveConsumer.OfBoolean) forEach((PrimitiveConsumer.OfBoolean) consumer);
            else spliterator().forEachRemaining(consumer);
        }
        @Override public boolean[][] newArrayOfArray(int size) { return new boolean[size][]; }
        @Override public boolean[] newArray(int size) { return new boolean[size]; }
        @Override protected int arrayLength(boolean[] array) { return array.length; }
        @Override protected void arrayForEach(boolean[] array, int from, int to, PrimitiveConsumer.OfBoolean consumer) {
            for(int i = from; i < to; i++) consumer.acceptBoolean(array[i]);
        }
        @Override public void acceptBoolean(boolean val) {
            preAccept();
            curChunk[elementIndex++] = val;
        }
        public boolean get(long index) {
            int ch = chunkFor(index);
            if(spineIndex == 0 && ch == 0) return curChunk[(int) index];
            else return spine[ch][(int) (index - priorElementCount[ch])];
        }
        @Override public PrimitiveIterator.OfBoolean iteratorBoolean() { return PrimitiveIterators.fromSpliterator(spliteratorBoolean()); }
        @Override public PrimitiveIterator.OfBoolean iterator() { return iteratorBoolean(); }
        public PrimitiveSpliterator.OfBoolean spliteratorBoolean() {
            class Splitr extends BaseSpliterator<PrimitiveSpliterator.OfBoolean> implements PrimitiveSpliterator.OfBoolean {
                Splitr(int firstSpineIndex, int lastSpineIndex, int firstSpineElementIndex, int lastSpineElementFence) {
                    super(firstSpineIndex, lastSpineIndex, firstSpineElementIndex, lastSpineElementFence);
                }
                Splitr newSpliterator(int firstSpineIndex, int lastSpineIndex, int firstSpineElementIndex, int lastSpineElementFence) {
                    return new Splitr(firstSpineIndex, lastSpineIndex, firstSpineElementIndex, lastSpineElementFence);
                }
                void arrayForOne(boolean[] array, int index, PrimitiveConsumer.OfBoolean consumer) { consumer.acceptBoolean(array[index]); }
                PrimitiveSpliterator.OfBoolean arraySpliterator(boolean[] array, int offset, int len) {
                    return PrimitiveSpliterators.spliterator(array, offset, offset + len);
                }
                public void forEachRemaining(PrimitiveConsumer.OfBoolean consumer) {
                    if (splSpineIndex < lastSpineIndex
                            || (splSpineIndex == lastSpineIndex && splElementIndex < lastSpineElementFence)) {
                        int i = splElementIndex;
                        // completed chunks, if any
                        for (int sp = splSpineIndex; sp < lastSpineIndex; sp++) {
                            boolean[] chunk = spine[sp];
                            arrayForEach(chunk, i, arrayLength(chunk), consumer);
                            i = 0;
                        }
                        // last (or current uncompleted) chunk
                        boolean[] chunk = (splSpineIndex == lastSpineIndex) ? splChunk : spine[lastSpineIndex];
                        arrayForEach(chunk, i, lastSpineElementFence, consumer);
                        // mark consumed
                        splSpineIndex = lastSpineIndex;
                        splElementIndex = lastSpineElementFence;
                    }
                }
                public boolean tryAdvance(PrimitiveConsumer.OfBoolean consumer) {
                    if(splSpineIndex < lastSpineIndex || (splSpineIndex == lastSpineIndex && splElementIndex < lastSpineElementFence)) {
                        arrayForOne(splChunk, splElementIndex++, consumer);

                        if(splElementIndex == arrayLength(splChunk)) {
                            splElementIndex = 0;
                            ++splSpineIndex;
                            if(spine != null && splSpineIndex <= lastSpineIndex) splChunk = spine[splSpineIndex];
                        }
                        return true;
                    }
                    return false;
                }
            };
            return new Splitr(0, spineIndex, 0, elementIndex);
        }
        
    }

    /**
     * @see java.util.stream.SpinedBuffer.OfPrimitive#SPLITERATOR_CHARACTERISTICS
     */
    private static final int SPLITERATOR_CHARACTERISTICS
            = Spliterator.SIZED | Spliterator.ORDERED | Spliterator.SUBSIZED;

    /**
     * @see java.util.stream.SpinedBuffer.OfPrimitive.BaseSpliterator
     */
    abstract class BaseSpliterator<T_SPLITR extends Spliterator<T>> implements Spliterator<T> {
        /**
         * @see java.util.stream.SpinedBuffer.OfPrimitive.BaseSpliterator#splSpineIndex
         */
        int splSpineIndex;
        /**
         * @see java.util.stream.SpinedBuffer.OfPrimitive.BaseSpliterator#lastSpineIndex
         */
        final int lastSpineIndex;
        /**
         * @see java.util.stream.SpinedBuffer.OfPrimitive.BaseSpliterator#splElementIndex
         */
        int splElementIndex;
        /**
         * @see java.util.stream.SpinedBuffer.OfPrimitive.BaseSpliterator#lastSpineElementFence
         */
        final int lastSpineElementFence;
        /**
         * @see java.util.stream.SpinedBuffer.OfPrimitive.BaseSpliterator#splChunk
         */
        T_ARR splChunk;

        /**
         * @see java.util.stream.SpinedBuffer.OfPrimitive.BaseSpliterator#BaseSpliterator(int, int, int, int)
         */
        BaseSpliterator(int firstSpineIndex, int lastSpineIndex, int firstSpineElementIndex, int lastSpineElementFence) {
            this.splSpineIndex = firstSpineIndex;
            this.lastSpineIndex = lastSpineIndex;
            this.splElementIndex = firstSpineElementIndex;
            this.lastSpineElementFence = lastSpineElementFence;
            assert spine != null || firstSpineIndex == 0 && lastSpineIndex == 0;
            splChunk = (spine == null) ? curChunk : spine[firstSpineIndex];
        }
        /**
         * @see java.util.stream.SpinedBuffer.OfPrimitive.BaseSpliterator#newSpliterator(int, int, int, int)
         */
        abstract T_SPLITR newSpliterator(int firstSpineIndex, int lastSpineIndex, int firstSpineElementIndex, int lastSpineElementFence);
        /**
         * @see java.util.stream.SpinedBuffer.OfPrimitive.BaseSpliterator#arrayForOne(Object, int, Object)
         */
        abstract void arrayForOne(T_ARR array, int index, T_CONS consumer);
        /**
         * @see java.util.stream.SpinedBuffer.OfPrimitive.BaseSpliterator#arraySpliterator(Object, int, int)
         */
        abstract T_SPLITR arraySpliterator(T_ARR array, int offset, int len);
        @Override public long estimateSize() {
            return (splSpineIndex == lastSpineIndex)
                    ? (long) lastSpineElementFence - splElementIndex
                    : priorElementCount[lastSpineIndex] + lastSpineElementFence - priorElementCount[splSpineIndex] - splElementIndex;
        }
        @Override public int characteristics() { return SPLITERATOR_CHARACTERISTICS; }

        @Override public T_SPLITR trySplit() {
            if (splSpineIndex < lastSpineIndex) {
                // split just before last chunk (if it is full this means 50:50 split)
                T_SPLITR ret = newSpliterator(splSpineIndex, lastSpineIndex - 1,
                        splElementIndex, arrayLength(spine[lastSpineIndex - 1]));
                // position us to start of last chunk
                splSpineIndex = lastSpineIndex;
                splElementIndex = 0;
                splChunk = spine[splSpineIndex];
                return ret;
            }
            else if (splSpineIndex == lastSpineIndex) {
                int t = (lastSpineElementFence - splElementIndex) / 2;
                if (t == 0)
                    return null;
                else {
                    T_SPLITR ret = arraySpliterator(splChunk, splElementIndex, t);
                    splElementIndex += t;
                    return ret;
                }
            }
            else {
                return null;
            }
        }
    }

    /**
     * @see java.util.stream.SpinedBuffer#curChunk
     */
    T_ARR curChunk;
    /**
     * @see java.util.stream.SpinedBuffer#spine
     */
    T_ARR[] spine;
    /**
     *
     * @see java.util.stream.SpinedBuffer.OfPrimitive#OfPrimitive(int)
     */
    PrimitiveSpinedBuffer(int initialCapacity) {
        super(initialCapacity);
        curChunk = newArray(1 << initialChunkPower);
    }
    /**
     *
     * @see java.util.stream.SpinedBuffer.OfPrimitive#OfPrimitive()
     */
    PrimitiveSpinedBuffer() {
        super();
        curChunk = newArray(1 << initialChunkPower);
    }

    /**
     * @see java.util.stream.SpinedBuffer.OfPrimitive#newArrayArray(int)
     */
    protected abstract T_ARR[] newArrayOfArray(int size);

    /**
     * @see java.util.stream.SpinedBuffer.OfPrimitive#newArray(int)
     */
    public abstract T_ARR newArray(int size);

    /**
     * @see java.util.stream.SpinedBuffer.OfPrimitive#arrayLength
     */
    protected abstract int arrayLength(T_ARR array);

    /**
     * @see java.util.stream.SpinedBuffer.OfPrimitive#arrayForEach
     */
    protected abstract void arrayForEach(T_ARR array, int from, int to, T_CONS consumer);
    /**
     * @see java.util.stream.SpinedBuffer#capacity
     */
    protected long capacity() {
        return (spineIndex == 0)
                ? arrayLength(curChunk)
                : priorElementCount[spineIndex] + arrayLength(spine[spineIndex]);
    }
    /**
     * @see java.util.stream.SpinedBuffer.OfPrimitive#inflateSpine
     */
    private void inflateSpine(){
        if(spine == null) {
            spine = newArrayOfArray(MIN_SPINE_SIZE);
            priorElementCount = new long[MIN_SPINE_SIZE];
            spine[0] = curChunk;
        }
    }
    /**
     *
     * @see java.util.stream.SpinedBuffer#ensureCapacity
     */
    protected final void ensureCapacity(long targetSize) {
        long capacity = capacity();
        if(targetSize > capacity) {
            inflateSpine();
            for (int i = spineIndex + 1; targetSize > capacity; i++) {
                if(i >= spine.length) {
                    int newSpineSize = spine.length * 2;
                    spine = Arrays.copyOf(spine, newSpineSize);
                    priorElementCount = Arrays.copyOf(priorElementCount, newSpineSize);
                }
                int nextChunkSize = chunkSize(i);
                spine[i] = newArray(nextChunkSize);
                priorElementCount[i] = priorElementCount[i - 1] + arrayLength(spine[i - 1]);
                capacity += nextChunkSize;
            }
        }
    }
    /**
     * @see java.util.stream.SpinedBuffer#increaseCapacity
     */
    protected void increaseCapacity() { ensureCapacity(capacity() + 1); }
    /**
     * @see java.util.stream.SpinedBuffer.OfPrimitive#chunkFor
     */
    protected int chunkFor(long index) {
        if(spineIndex == 0) {
            if(index < elementIndex) return 0;
            else throw new IndexOutOfBoundsException((Long.toString(index)));
        }
        if(index >= count()) throw new IndexOutOfBoundsException(Long.toString(index));
        for(int i = 0; i <= spineIndex; i++)
            if(index < priorElementCount[i] + arrayLength(spine[i]))
                return i;
        throw new IndexOutOfBoundsException(Long.toString(index));
    }
    /**
     * @see java.util.stream.SpinedBuffer#copyInto
     */
    public void copyInto(T_ARR array, int offset) {
        long finalOffset = offset + count();
        if (finalOffset > arrayLength(array) || finalOffset < offset) {
            throw new IndexOutOfBoundsException("Does not fit");
        }
        if(spineIndex == 0)
            System.arraycopy(curChunk, 0, array, offset, elementIndex);
        else {
            for(int i = 0; i < spineIndex; i++) {
                System.arraycopy(spine[i], 0, array, offset, arrayLength(spine[i]));
                offset += arrayLength(spine[i]);
            }
            if(elementIndex > 0) System.arraycopy(curChunk, 0, array, offset, elementIndex);
        }
    }
    /**
     * @see java.util.stream.SpinedBuffer.OfPrimitive#asPrimitiveArray
     */
    public T_ARR asArray() {
        long size = count();
        if (size >= PrimitiveNodes.MAX_ARRAY_SIZE) throw new IllegalArgumentException("Stream size exceeds max array size");
        T_ARR result = newArray((int) size);
        copyInto(result, 0);
        return result;
    }
    /**
     * @see java.util.stream.SpinedBuffer.OfPrimitive#preAccept
     */
    protected void preAccept() {
        if (elementIndex == arrayLength(curChunk)) {
            inflateSpine();
            if(spineIndex + 1 >= spine.length || spine[spineIndex + 1] == null) increaseCapacity();
            elementIndex = 0;
            ++spineIndex;
            curChunk = spine[spineIndex];
        }
    }
    /**
     * @see java.util.stream.SpinedBuffer#clear
     */
    public void clear() {
        if(spine != null) {
            curChunk = spine[0];
            spine = null;
            priorElementCount = null;
        }
        elementIndex = 0;
        spineIndex = 0;
    }
}
