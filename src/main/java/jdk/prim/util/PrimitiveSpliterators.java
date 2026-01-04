package jdk.prim.util;

import java.util.Objects;
import java.util.Spliterator;

import jdk.prim.util.function.PrimitiveConsumer;

public class PrimitiveSpliterators {
    public static PrimitiveSpliterator.OfDouble spliterator(double[] array, int from, int to, int additionalCharacteristics) {
        checkFromToBounds(Objects.requireNonNull(array).length, from, to);
        return new ArraySpliterator.OfDouble(array, from, to, additionalCharacteristics);
    }
    public static PrimitiveSpliterator.OfDouble spliterator(double[] array, int from, int to) {
        checkFromToBounds(Objects.requireNonNull(array).length, from, to);
        return new ArraySpliterator.OfDouble(array, from, to, Spliterator.ORDERED | Spliterator.IMMUTABLE);
    }
    public static PrimitiveSpliterator.OfDouble emptyDouble() {
        return new PrimitiveSpliterator.OfDouble() {
            public int characteristics() { return PrimitiveSpliterator.SIZED | PrimitiveSpliterator.SUBSIZED; }
            public long estimateSize() { return 0; }
            public PrimitiveComparator.OfDouble getComparator() { throw new IllegalStateException(); }
            public boolean tryAdvance(PrimitiveConsumer.OfDouble consumer) {
                if(consumer == null) throw new NullPointerException("consumer is null");
                return false;
            }
            public PrimitiveSpliterator.OfDouble trySplit() { return null; }
        };
    }
    public static PrimitiveSpliterator.OfDouble spliterator(double[] array, int additionalCharacteristics) {
        return new ArraySpliterator.OfDouble(Objects.requireNonNull(array), additionalCharacteristics);
    }
    public static PrimitiveSpliterator.OfDouble spliterator(PrimitiveIterator.OfDouble iterator, long size, int characteristics) {
        return new PrimitiveIteratorSpliterator.OfDouble(Objects.requireNonNull(iterator), size, characteristics);
    }
    public static PrimitiveSpliterator.OfDouble spliteratorUnknownSize(PrimitiveIterator.OfDouble iterator, int characteristics) {
        return new PrimitiveIteratorSpliterator.OfDouble(Objects.requireNonNull(iterator), characteristics);
    }
    public static PrimitiveSpliterator.OfDouble spliterator(PrimitiveCollection.OfDouble collection, int characteristics) {
        return new PrimitiveCollectionSpliterator.OfDouble(collection, characteristics);
    }
    public static PrimitiveSpliterator.OfLong spliterator(long[] array, int from, int to, int additionalCharacteristics) {
        checkFromToBounds(Objects.requireNonNull(array).length, from, to);
        return new ArraySpliterator.OfLong(array, from, to, additionalCharacteristics);
    }
    public static PrimitiveSpliterator.OfLong spliterator(long[] array, int from, int to) {
        checkFromToBounds(Objects.requireNonNull(array).length, from, to);
        return new ArraySpliterator.OfLong(array, from, to, Spliterator.ORDERED | Spliterator.IMMUTABLE);
    }
    public static PrimitiveSpliterator.OfLong emptyLong() {
        return new PrimitiveSpliterator.OfLong() {
            public int characteristics() { return PrimitiveSpliterator.SIZED | PrimitiveSpliterator.SUBSIZED; }
            public long estimateSize() { return 0; }
            public PrimitiveComparator.OfLong getComparator() { throw new IllegalStateException(); }
            public boolean tryAdvance(PrimitiveConsumer.OfLong consumer) {
                if(consumer == null) throw new NullPointerException("consumer is null");
                return false;
            }
            public PrimitiveSpliterator.OfLong trySplit() { return null; }
        };
    }
    public static PrimitiveSpliterator.OfLong spliterator(long[] array, int additionalCharacteristics) {
        return new ArraySpliterator.OfLong(Objects.requireNonNull(array), additionalCharacteristics);
    }
    public static PrimitiveSpliterator.OfLong spliterator(PrimitiveIterator.OfLong iterator, long size, int characteristics) {
        return new PrimitiveIteratorSpliterator.OfLong(Objects.requireNonNull(iterator), size, characteristics);
    }
    public static PrimitiveSpliterator.OfLong spliteratorUnknownSize(PrimitiveIterator.OfLong iterator, int characteristics) {
        return new PrimitiveIteratorSpliterator.OfLong(Objects.requireNonNull(iterator), characteristics);
    }
    public static PrimitiveSpliterator.OfLong spliterator(PrimitiveCollection.OfLong collection, int characteristics) {
        return new PrimitiveCollectionSpliterator.OfLong(collection, characteristics);
    }
    public static PrimitiveSpliterator.OfInt spliterator(int[] array, int from, int to, int additionalCharacteristics) {
        checkFromToBounds(Objects.requireNonNull(array).length, from, to);
        return new ArraySpliterator.OfInt(array, from, to, additionalCharacteristics);
    }
    public static PrimitiveSpliterator.OfInt spliterator(int[] array, int from, int to) {
        checkFromToBounds(Objects.requireNonNull(array).length, from, to);
        return new ArraySpliterator.OfInt(array, from, to, Spliterator.ORDERED | Spliterator.IMMUTABLE);
    }
    public static PrimitiveSpliterator.OfInt emptyInt() {
        return new PrimitiveSpliterator.OfInt() {
            public int characteristics() { return PrimitiveSpliterator.SIZED | PrimitiveSpliterator.SUBSIZED; }
            public long estimateSize() { return 0; }
            public PrimitiveComparator.OfInt getComparator() { throw new IllegalStateException(); }
            public boolean tryAdvance(PrimitiveConsumer.OfInt consumer) {
                if(consumer == null) throw new NullPointerException("consumer is null");
                return false;
            }
            public PrimitiveSpliterator.OfInt trySplit() { return null; }
        };
    }
    public static PrimitiveSpliterator.OfInt spliterator(int[] array, int additionalCharacteristics) {
        return new ArraySpliterator.OfInt(Objects.requireNonNull(array), additionalCharacteristics);
    }
    public static PrimitiveSpliterator.OfInt spliterator(PrimitiveIterator.OfInt iterator, long size, int characteristics) {
        return new PrimitiveIteratorSpliterator.OfInt(Objects.requireNonNull(iterator), size, characteristics);
    }
    public static PrimitiveSpliterator.OfInt spliteratorUnknownSize(PrimitiveIterator.OfInt iterator, int characteristics) {
        return new PrimitiveIteratorSpliterator.OfInt(Objects.requireNonNull(iterator), characteristics);
    }
    public static PrimitiveSpliterator.OfInt spliterator(PrimitiveCollection.OfInt collection, int characteristics) {
        return new PrimitiveCollectionSpliterator.OfInt(collection, characteristics);
    }
    public static PrimitiveSpliterator.OfFloat spliterator(float[] array, int from, int to, int additionalCharacteristics) {
        checkFromToBounds(Objects.requireNonNull(array).length, from, to);
        return new ArraySpliterator.OfFloat(array, from, to, additionalCharacteristics);
    }
    public static PrimitiveSpliterator.OfFloat spliterator(float[] array, int from, int to) {
        checkFromToBounds(Objects.requireNonNull(array).length, from, to);
        return new ArraySpliterator.OfFloat(array, from, to, Spliterator.ORDERED | Spliterator.IMMUTABLE);
    }
    public static PrimitiveSpliterator.OfFloat emptyFloat() {
        return new PrimitiveSpliterator.OfFloat() {
            public int characteristics() { return PrimitiveSpliterator.SIZED | PrimitiveSpliterator.SUBSIZED; }
            public long estimateSize() { return 0; }
            public PrimitiveComparator.OfFloat getComparator() { throw new IllegalStateException(); }
            public boolean tryAdvance(PrimitiveConsumer.OfFloat consumer) {
                if(consumer == null) throw new NullPointerException("consumer is null");
                return false;
            }
            public PrimitiveSpliterator.OfFloat trySplit() { return null; }
        };
    }
    public static PrimitiveSpliterator.OfFloat spliterator(float[] array, int additionalCharacteristics) {
        return new ArraySpliterator.OfFloat(Objects.requireNonNull(array), additionalCharacteristics);
    }
    public static PrimitiveSpliterator.OfFloat spliterator(PrimitiveIterator.OfFloat iterator, long size, int characteristics) {
        return new PrimitiveIteratorSpliterator.OfFloat(Objects.requireNonNull(iterator), size, characteristics);
    }
    public static PrimitiveSpliterator.OfFloat spliteratorUnknownSize(PrimitiveIterator.OfFloat iterator, int characteristics) {
        return new PrimitiveIteratorSpliterator.OfFloat(Objects.requireNonNull(iterator), characteristics);
    }
    public static PrimitiveSpliterator.OfFloat spliterator(PrimitiveCollection.OfFloat collection, int characteristics) {
        return new PrimitiveCollectionSpliterator.OfFloat(collection, characteristics);
    }
    public static PrimitiveSpliterator.OfChar spliterator(char[] array, int from, int to, int additionalCharacteristics) {
        checkFromToBounds(Objects.requireNonNull(array).length, from, to);
        return new ArraySpliterator.OfChar(array, from, to, additionalCharacteristics);
    }
    public static PrimitiveSpliterator.OfChar spliterator(char[] array, int from, int to) {
        checkFromToBounds(Objects.requireNonNull(array).length, from, to);
        return new ArraySpliterator.OfChar(array, from, to, Spliterator.ORDERED | Spliterator.IMMUTABLE);
    }
    public static PrimitiveSpliterator.OfChar emptyChar() {
        return new PrimitiveSpliterator.OfChar() {
            public int characteristics() { return PrimitiveSpliterator.SIZED | PrimitiveSpliterator.SUBSIZED; }
            public long estimateSize() { return 0; }
            public PrimitiveComparator.OfChar getComparator() { throw new IllegalStateException(); }
            public boolean tryAdvance(PrimitiveConsumer.OfChar consumer) {
                if(consumer == null) throw new NullPointerException("consumer is null");
                return false;
            }
            public PrimitiveSpliterator.OfChar trySplit() { return null; }
        };
    }
    public static PrimitiveSpliterator.OfChar spliterator(char[] array, int additionalCharacteristics) {
        return new ArraySpliterator.OfChar(Objects.requireNonNull(array), additionalCharacteristics);
    }
    public static PrimitiveSpliterator.OfChar spliterator(PrimitiveIterator.OfChar iterator, long size, int characteristics) {
        return new PrimitiveIteratorSpliterator.OfChar(Objects.requireNonNull(iterator), size, characteristics);
    }
    public static PrimitiveSpliterator.OfChar spliteratorUnknownSize(PrimitiveIterator.OfChar iterator, int characteristics) {
        return new PrimitiveIteratorSpliterator.OfChar(Objects.requireNonNull(iterator), characteristics);
    }
    public static PrimitiveSpliterator.OfChar spliterator(PrimitiveCollection.OfChar collection, int characteristics) {
        return new PrimitiveCollectionSpliterator.OfChar(collection, characteristics);
    }
    public static PrimitiveSpliterator.OfShort spliterator(short[] array, int from, int to, int additionalCharacteristics) {
        checkFromToBounds(Objects.requireNonNull(array).length, from, to);
        return new ArraySpliterator.OfShort(array, from, to, additionalCharacteristics);
    }
    public static PrimitiveSpliterator.OfShort spliterator(short[] array, int from, int to) {
        checkFromToBounds(Objects.requireNonNull(array).length, from, to);
        return new ArraySpliterator.OfShort(array, from, to, Spliterator.ORDERED | Spliterator.IMMUTABLE);
    }
    public static PrimitiveSpliterator.OfShort emptyShort() {
        return new PrimitiveSpliterator.OfShort() {
            public int characteristics() { return PrimitiveSpliterator.SIZED | PrimitiveSpliterator.SUBSIZED; }
            public long estimateSize() { return 0; }
            public PrimitiveComparator.OfShort getComparator() { throw new IllegalStateException(); }
            public boolean tryAdvance(PrimitiveConsumer.OfShort consumer) {
                if(consumer == null) throw new NullPointerException("consumer is null");
                return false;
            }
            public PrimitiveSpliterator.OfShort trySplit() { return null; }
        };
    }
    public static PrimitiveSpliterator.OfShort spliterator(short[] array, int additionalCharacteristics) {
        return new ArraySpliterator.OfShort(Objects.requireNonNull(array), additionalCharacteristics);
    }
    public static PrimitiveSpliterator.OfShort spliterator(PrimitiveIterator.OfShort iterator, long size, int characteristics) {
        return new PrimitiveIteratorSpliterator.OfShort(Objects.requireNonNull(iterator), size, characteristics);
    }
    public static PrimitiveSpliterator.OfShort spliteratorUnknownSize(PrimitiveIterator.OfShort iterator, int characteristics) {
        return new PrimitiveIteratorSpliterator.OfShort(Objects.requireNonNull(iterator), characteristics);
    }
    public static PrimitiveSpliterator.OfShort spliterator(PrimitiveCollection.OfShort collection, int characteristics) {
        return new PrimitiveCollectionSpliterator.OfShort(collection, characteristics);
    }
    public static PrimitiveSpliterator.OfByte spliterator(byte[] array, int from, int to, int additionalCharacteristics) {
        checkFromToBounds(Objects.requireNonNull(array).length, from, to);
        return new ArraySpliterator.OfByte(array, from, to, additionalCharacteristics);
    }
    public static PrimitiveSpliterator.OfByte spliterator(byte[] array, int from, int to) {
        checkFromToBounds(Objects.requireNonNull(array).length, from, to);
        return new ArraySpliterator.OfByte(array, from, to, Spliterator.ORDERED | Spliterator.IMMUTABLE);
    }
    public static PrimitiveSpliterator.OfByte emptyByte() {
        return new PrimitiveSpliterator.OfByte() {
            public int characteristics() { return PrimitiveSpliterator.SIZED | PrimitiveSpliterator.SUBSIZED; }
            public long estimateSize() { return 0; }
            public PrimitiveComparator.OfByte getComparator() { throw new IllegalStateException(); }
            public boolean tryAdvance(PrimitiveConsumer.OfByte consumer) {
                if(consumer == null) throw new NullPointerException("consumer is null");
                return false;
            }
            public PrimitiveSpliterator.OfByte trySplit() { return null; }
        };
    }
    public static PrimitiveSpliterator.OfByte spliterator(byte[] array, int additionalCharacteristics) {
        return new ArraySpliterator.OfByte(Objects.requireNonNull(array), additionalCharacteristics);
    }
    public static PrimitiveSpliterator.OfByte spliterator(PrimitiveIterator.OfByte iterator, long size, int characteristics) {
        return new PrimitiveIteratorSpliterator.OfByte(Objects.requireNonNull(iterator), size, characteristics);
    }
    public static PrimitiveSpliterator.OfByte spliteratorUnknownSize(PrimitiveIterator.OfByte iterator, int characteristics) {
        return new PrimitiveIteratorSpliterator.OfByte(Objects.requireNonNull(iterator), characteristics);
    }
    public static PrimitiveSpliterator.OfByte spliterator(PrimitiveCollection.OfByte collection, int characteristics) {
        return new PrimitiveCollectionSpliterator.OfByte(collection, characteristics);
    }
    public static PrimitiveSpliterator.OfBoolean spliterator(boolean[] array, int from, int to, int additionalCharacteristics) {
        checkFromToBounds(Objects.requireNonNull(array).length, from, to);
        return new ArraySpliterator.OfBoolean(array, from, to, additionalCharacteristics);
    }
    public static PrimitiveSpliterator.OfBoolean spliterator(boolean[] array, int from, int to) {
        checkFromToBounds(Objects.requireNonNull(array).length, from, to);
        return new ArraySpliterator.OfBoolean(array, from, to, Spliterator.ORDERED | Spliterator.IMMUTABLE);
    }
    public static PrimitiveSpliterator.OfBoolean emptyBoolean() {
        return new PrimitiveSpliterator.OfBoolean() {
            public int characteristics() { return PrimitiveSpliterator.SIZED | PrimitiveSpliterator.SUBSIZED; }
            public long estimateSize() { return 0; }
            public PrimitiveComparator.OfBoolean getComparator() { throw new IllegalStateException(); }
            public boolean tryAdvance(PrimitiveConsumer.OfBoolean consumer) {
                if(consumer == null) throw new NullPointerException("consumer is null");
                return false;
            }
            public PrimitiveSpliterator.OfBoolean trySplit() { return null; }
        };
    }
    public static PrimitiveSpliterator.OfBoolean spliterator(boolean[] array, int additionalCharacteristics) {
        return new ArraySpliterator.OfBoolean(Objects.requireNonNull(array), additionalCharacteristics);
    }
    public static PrimitiveSpliterator.OfBoolean spliterator(PrimitiveIterator.OfBoolean iterator, long size, int characteristics) {
        return new PrimitiveIteratorSpliterator.OfBoolean(Objects.requireNonNull(iterator), size, characteristics);
    }
    public static PrimitiveSpliterator.OfBoolean spliteratorUnknownSize(PrimitiveIterator.OfBoolean iterator, int characteristics) {
        return new PrimitiveIteratorSpliterator.OfBoolean(Objects.requireNonNull(iterator), characteristics);
    }
    public static PrimitiveSpliterator.OfBoolean spliterator(PrimitiveCollection.OfBoolean collection, int characteristics) {
        return new PrimitiveCollectionSpliterator.OfBoolean(collection, characteristics);
    }
    
    /**
     * Validate inclusive start index and exclusive end index against the length
     * of an array.
     * @param arrayLength The length of the array
     * @param origin The inclusive start index
     * @param fence The exclusive end index
     * @throws ArrayIndexOutOfBoundsException if the start index is greater than
     * the end index, if the start index is negative, or the end index is
     * greater than the array length
     */
    private static void checkFromToBounds(int arrayLength, int origin, int fence) {
        if (origin > fence) {
            throw new ArrayIndexOutOfBoundsException(
                    "origin(" + origin + ") > fence(" + fence + ")");
        }
        if (origin < 0) {
            throw new ArrayIndexOutOfBoundsException(origin);
        }
        if (fence > arrayLength) {
            throw new ArrayIndexOutOfBoundsException(fence);
        }
    }
}
