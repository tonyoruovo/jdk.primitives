package jdk.prim.util;

import java.util.Spliterator;

import jdk.prim.util.function.PrimitiveConsumer;

class ArraySpliterator {
    static class OfDouble implements PrimitiveSpliterator.OfDouble {
        private final double[] array;
        private int index;        // current index, modified on advance/split
        private final int fence;  // one past last index
        private final int characteristics;
        private long estimatedSize; // estimated size, to help to split evenly
        public OfDouble(double[] array, int additionalCharacteristics) {
            this(array, 0, array.length, additionalCharacteristics);
        }
        public OfDouble(double[] array, int origin, int fence, int additionalCharacteristics) {
            this.array = array;
            this.index = origin;
            this.fence = fence;
            this.characteristics = additionalCharacteristics | Spliterator.SIZED | Spliterator.SUBSIZED;
            this.estimatedSize = -1;
        }
        OfDouble(double[] array, int origin, int fence, int additionalCharacteristics, long estimatedSize) {
            this.array = array;
            this.index = origin;
            this.fence = fence;
            this.characteristics = additionalCharacteristics & ~(Spliterator.SIZED | Spliterator.SUBSIZED);
            this.estimatedSize = estimatedSize;
        }
        @Override
        public ArraySpliterator.OfDouble trySplit() {
            int lo = index, mid = (lo + fence) >>> 1;
            if(lo >= mid) return null;
            if(estimatedSize == -1) {
                return new ArraySpliterator.OfDouble(array, lo, index = mid, characteristics);
            }
            long prefixEstimatedSize = estimatedSize >>> 1;
            estimatedSize -= prefixEstimatedSize;
            return new ArraySpliterator.OfDouble(array, lo, index = mid, characteristics, prefixEstimatedSize);
        }
        @Override
        public void forEachRemaining(PrimitiveConsumer.OfDouble action) {
            double[] a; int i, hi; // hoist accesses and checks from loop
            if (action == null)
                throw new NullPointerException();
            if ((a = array).length >= (hi = fence) &&
                (i = index) >= 0 && i < (index = hi)) {
                do { action.acceptDouble(a[i]); } while (++i < hi);
            }
        }
        @Override
        public boolean tryAdvance(PrimitiveConsumer.OfDouble action) {
            if (action == null)
                throw new NullPointerException();
            if (index >= 0 && index < fence) {
                action.acceptDouble(array[index++]);
                return true;
            }
            return false;
        }
        @Override
        public long estimateSize() {
            return estimatedSize >= 0 ? estimatedSize : (long)(fence - index);
        }
        @Override
        public int characteristics() {
            return characteristics;
        }
        @Override
        public PrimitiveComparator.OfDouble getComparator() {
            if(hasCharacteristics(Spliterator.SORTED)) return null;
            throw new IllegalStateException();
        }
    }
    static class OfLong implements PrimitiveSpliterator.OfLong {
        private final long[] array;
        private int index;        // current index, modified on advance/split
        private final int fence;  // one past last index
        private final int characteristics;
        private long estimatedSize; // estimated size, to help to split evenly
        public OfLong(long[] array, int additionalCharacteristics) {
            this(array, 0, array.length, additionalCharacteristics);
        }
        public OfLong(long[] array, int origin, int fence, int additionalCharacteristics) {
            this.array = array;
            this.index = origin;
            this.fence = fence;
            this.characteristics = additionalCharacteristics | Spliterator.SIZED | Spliterator.SUBSIZED;
            this.estimatedSize = -1;
        }
        OfLong(long[] array, int origin, int fence, int additionalCharacteristics, long estimatedSize) {
            this.array = array;
            this.index = origin;
            this.fence = fence;
            this.characteristics = additionalCharacteristics & ~(Spliterator.SIZED | Spliterator.SUBSIZED);
            this.estimatedSize = estimatedSize;
        }
        @Override
        public ArraySpliterator.OfLong trySplit() {
            int lo = index, mid = (lo + fence) >>> 1;
            if(lo >= mid) return null;
            if(estimatedSize == -1) {
                return new ArraySpliterator.OfLong(array, lo, index = mid, characteristics);
            }
            long prefixEstimatedSize = estimatedSize >>> 1;
            estimatedSize -= prefixEstimatedSize;
            return new ArraySpliterator.OfLong(array, lo, index = mid, characteristics, prefixEstimatedSize);
        }
        @Override
        public void forEachRemaining(PrimitiveConsumer.OfLong action) {
            long[] a; int i, hi; // hoist accesses and checks from loop
            if (action == null)
                throw new NullPointerException();
            if ((a = array).length >= (hi = fence) &&
                (i = index) >= 0 && i < (index = hi)) {
                do { action.acceptLong(a[i]); } while (++i < hi);
            }
        }
        @Override
        public boolean tryAdvance(PrimitiveConsumer.OfLong action) {
            if (action == null)
                throw new NullPointerException();
            if (index >= 0 && index < fence) {
                action.acceptLong(array[index++]);
                return true;
            }
            return false;
        }
        @Override
        public long estimateSize() {
            return estimatedSize >= 0 ? estimatedSize : (long)(fence - index);
        }
        @Override
        public int characteristics() {
            return characteristics;
        }
        @Override
        public PrimitiveComparator.OfLong getComparator() {
            if(hasCharacteristics(Spliterator.SORTED)) return null;
            throw new IllegalStateException();
        }
    }
    static class OfInt implements PrimitiveSpliterator.OfInt {
        private final int[] array;
        private int index;        // current index, modified on advance/split
        private final int fence;  // one past last index
        private final int characteristics;
        private long estimatedSize; // estimated size, to help to split evenly
        public OfInt(int[] array, int additionalCharacteristics) {
            this(array, 0, array.length, additionalCharacteristics);
        }
        public OfInt(int[] array, int origin, int fence, int additionalCharacteristics) {
            this.array = array;
            this.index = origin;
            this.fence = fence;
            this.characteristics = additionalCharacteristics | Spliterator.SIZED | Spliterator.SUBSIZED;
            this.estimatedSize = -1;
        }
        OfInt(int[] array, int origin, int fence, int additionalCharacteristics, long estimatedSize) {
            this.array = array;
            this.index = origin;
            this.fence = fence;
            this.characteristics = additionalCharacteristics & ~(Spliterator.SIZED | Spliterator.SUBSIZED);
            this.estimatedSize = estimatedSize;
        }
        @Override
        public ArraySpliterator.OfInt trySplit() {
            int lo = index, mid = (lo + fence) >>> 1;
            if(lo >= mid) return null;
            if(estimatedSize == -1) {
                return new ArraySpliterator.OfInt(array, lo, index = mid, characteristics);
            }
            long prefixEstimatedSize = estimatedSize >>> 1;
            estimatedSize -= prefixEstimatedSize;
            return new ArraySpliterator.OfInt(array, lo, index = mid, characteristics, prefixEstimatedSize);
        }
        @Override
        public void forEachRemaining(PrimitiveConsumer.OfInt action) {
            int[] a; int i, hi; // hoist accesses and checks from loop
            if (action == null)
                throw new NullPointerException();
            if ((a = array).length >= (hi = fence) &&
                (i = index) >= 0 && i < (index = hi)) {
                do { action.acceptInt(a[i]); } while (++i < hi);
            }
        }
        @Override
        public boolean tryAdvance(PrimitiveConsumer.OfInt action) {
            if (action == null)
                throw new NullPointerException();
            if (index >= 0 && index < fence) {
                action.acceptInt(array[index++]);
                return true;
            }
            return false;
        }
        @Override
        public long estimateSize() {
            return estimatedSize >= 0 ? estimatedSize : (long)(fence - index);
        }
        @Override
        public int characteristics() {
            return characteristics;
        }
        @Override
        public PrimitiveComparator.OfInt getComparator() {
            if(hasCharacteristics(Spliterator.SORTED)) return null;
            throw new IllegalStateException();
        }
    }
    static class OfFloat implements PrimitiveSpliterator.OfFloat {
        private final float[] array;
        private int index;        // current index, modified on advance/split
        private final int fence;  // one past last index
        private final int characteristics;
        private long estimatedSize; // estimated size, to help to split evenly
        public OfFloat(float[] array, int additionalCharacteristics) {
            this(array, 0, array.length, additionalCharacteristics);
        }
        public OfFloat(float[] array, int origin, int fence, int additionalCharacteristics) {
            this.array = array;
            this.index = origin;
            this.fence = fence;
            this.characteristics = additionalCharacteristics | Spliterator.SIZED | Spliterator.SUBSIZED;
            this.estimatedSize = -1;
        }
        OfFloat(float[] array, int origin, int fence, int additionalCharacteristics, long estimatedSize) {
            this.array = array;
            this.index = origin;
            this.fence = fence;
            this.characteristics = additionalCharacteristics & ~(Spliterator.SIZED | Spliterator.SUBSIZED);
            this.estimatedSize = estimatedSize;
        }
        @Override
        public ArraySpliterator.OfFloat trySplit() {
            int lo = index, mid = (lo + fence) >>> 1;
            if(lo >= mid) return null;
            if(estimatedSize == -1) {
                return new ArraySpliterator.OfFloat(array, lo, index = mid, characteristics);
            }
            long prefixEstimatedSize = estimatedSize >>> 1;
            estimatedSize -= prefixEstimatedSize;
            return new ArraySpliterator.OfFloat(array, lo, index = mid, characteristics, prefixEstimatedSize);
        }
        @Override
        public void forEachRemaining(PrimitiveConsumer.OfFloat action) {
            float[] a; int i, hi; // hoist accesses and checks from loop
            if (action == null)
                throw new NullPointerException();
            if ((a = array).length >= (hi = fence) &&
                (i = index) >= 0 && i < (index = hi)) {
                do { action.acceptFloat(a[i]); } while (++i < hi);
            }
        }
        @Override
        public boolean tryAdvance(PrimitiveConsumer.OfFloat action) {
            if (action == null)
                throw new NullPointerException();
            if (index >= 0 && index < fence) {
                action.acceptFloat(array[index++]);
                return true;
            }
            return false;
        }
        @Override
        public long estimateSize() {
            return estimatedSize >= 0 ? estimatedSize : (long)(fence - index);
        }
        @Override
        public int characteristics() {
            return characteristics;
        }
        @Override
        public PrimitiveComparator.OfFloat getComparator() {
            if(hasCharacteristics(Spliterator.SORTED)) return null;
            throw new IllegalStateException();
        }
    }
    static class OfChar implements PrimitiveSpliterator.OfChar {
        private final char[] array;
        private int index;        // current index, modified on advance/split
        private final int fence;  // one past last index
        private final int characteristics;
        private long estimatedSize; // estimated size, to help to split evenly
        public OfChar(char[] array, int additionalCharacteristics) {
            this(array, 0, array.length, additionalCharacteristics);
        }
        public OfChar(char[] array, int origin, int fence, int additionalCharacteristics) {
            this.array = array;
            this.index = origin;
            this.fence = fence;
            this.characteristics = additionalCharacteristics | Spliterator.SIZED | Spliterator.SUBSIZED;
            this.estimatedSize = -1;
        }
        OfChar(char[] array, int origin, int fence, int additionalCharacteristics, long estimatedSize) {
            this.array = array;
            this.index = origin;
            this.fence = fence;
            this.characteristics = additionalCharacteristics & ~(Spliterator.SIZED | Spliterator.SUBSIZED);
            this.estimatedSize = estimatedSize;
        }
        @Override
        public ArraySpliterator.OfChar trySplit() {
            int lo = index, mid = (lo + fence) >>> 1;
            if(lo >= mid) return null;
            if(estimatedSize == -1) {
                return new ArraySpliterator.OfChar(array, lo, index = mid, characteristics);
            }
            long prefixEstimatedSize = estimatedSize >>> 1;
            estimatedSize -= prefixEstimatedSize;
            return new ArraySpliterator.OfChar(array, lo, index = mid, characteristics, prefixEstimatedSize);
        }
        @Override
        public void forEachRemaining(PrimitiveConsumer.OfChar action) {
            char[] a; int i, hi; // hoist accesses and checks from loop
            if (action == null)
                throw new NullPointerException();
            if ((a = array).length >= (hi = fence) &&
                (i = index) >= 0 && i < (index = hi)) {
                do { action.acceptChar(a[i]); } while (++i < hi);
            }
        }
        @Override
        public boolean tryAdvance(PrimitiveConsumer.OfChar action) {
            if (action == null)
                throw new NullPointerException();
            if (index >= 0 && index < fence) {
                action.acceptChar(array[index++]);
                return true;
            }
            return false;
        }
        @Override
        public long estimateSize() {
            return estimatedSize >= 0 ? estimatedSize : (long)(fence - index);
        }
        @Override
        public int characteristics() {
            return characteristics;
        }
        @Override
        public PrimitiveComparator.OfChar getComparator() {
            if(hasCharacteristics(Spliterator.SORTED)) return null;
            throw new IllegalStateException();
        }
    }
    static class OfShort implements PrimitiveSpliterator.OfShort {
        private final short[] array;
        private int index;        // current index, modified on advance/split
        private final int fence;  // one past last index
        private final int characteristics;
        private long estimatedSize; // estimated size, to help to split evenly
        public OfShort(short[] array, int additionalCharacteristics) {
            this(array, 0, array.length, additionalCharacteristics);
        }
        public OfShort(short[] array, int origin, int fence, int additionalCharacteristics) {
            this.array = array;
            this.index = origin;
            this.fence = fence;
            this.characteristics = additionalCharacteristics | Spliterator.SIZED | Spliterator.SUBSIZED;
            this.estimatedSize = -1;
        }
        OfShort(short[] array, int origin, int fence, int additionalCharacteristics, long estimatedSize) {
            this.array = array;
            this.index = origin;
            this.fence = fence;
            this.characteristics = additionalCharacteristics & ~(Spliterator.SIZED | Spliterator.SUBSIZED);
            this.estimatedSize = estimatedSize;
        }
        @Override
        public ArraySpliterator.OfShort trySplit() {
            int lo = index, mid = (lo + fence) >>> 1;
            if(lo >= mid) return null;
            if(estimatedSize == -1) {
                return new ArraySpliterator.OfShort(array, lo, index = mid, characteristics);
            }
            long prefixEstimatedSize = estimatedSize >>> 1;
            estimatedSize -= prefixEstimatedSize;
            return new ArraySpliterator.OfShort(array, lo, index = mid, characteristics, prefixEstimatedSize);
        }
        @Override
        public void forEachRemaining(PrimitiveConsumer.OfShort action) {
            short[] a; int i, hi; // hoist accesses and checks from loop
            if (action == null)
                throw new NullPointerException();
            if ((a = array).length >= (hi = fence) &&
                (i = index) >= 0 && i < (index = hi)) {
                do { action.acceptShort(a[i]); } while (++i < hi);
            }
        }
        @Override
        public boolean tryAdvance(PrimitiveConsumer.OfShort action) {
            if (action == null)
                throw new NullPointerException();
            if (index >= 0 && index < fence) {
                action.acceptShort(array[index++]);
                return true;
            }
            return false;
        }
        @Override
        public long estimateSize() {
            return estimatedSize >= 0 ? estimatedSize : (long)(fence - index);
        }
        @Override
        public int characteristics() {
            return characteristics;
        }
        @Override
        public PrimitiveComparator.OfShort getComparator() {
            if(hasCharacteristics(Spliterator.SORTED)) return null;
            throw new IllegalStateException();
        }
    }
    static class OfByte implements PrimitiveSpliterator.OfByte {
        private final byte[] array;
        private int index;        // current index, modified on advance/split
        private final int fence;  // one past last index
        private final int characteristics;
        private long estimatedSize; // estimated size, to help to split evenly
        public OfByte(byte[] array, int additionalCharacteristics) {
            this(array, 0, array.length, additionalCharacteristics);
        }
        public OfByte(byte[] array, int origin, int fence, int additionalCharacteristics) {
            this.array = array;
            this.index = origin;
            this.fence = fence;
            this.characteristics = additionalCharacteristics | Spliterator.SIZED | Spliterator.SUBSIZED;
            this.estimatedSize = -1;
        }
        OfByte(byte[] array, int origin, int fence, int additionalCharacteristics, long estimatedSize) {
            this.array = array;
            this.index = origin;
            this.fence = fence;
            this.characteristics = additionalCharacteristics & ~(Spliterator.SIZED | Spliterator.SUBSIZED);
            this.estimatedSize = estimatedSize;
        }
        @Override
        public ArraySpliterator.OfByte trySplit() {
            int lo = index, mid = (lo + fence) >>> 1;
            if(lo >= mid) return null;
            if(estimatedSize == -1) {
                return new ArraySpliterator.OfByte(array, lo, index = mid, characteristics);
            }
            long prefixEstimatedSize = estimatedSize >>> 1;
            estimatedSize -= prefixEstimatedSize;
            return new ArraySpliterator.OfByte(array, lo, index = mid, characteristics, prefixEstimatedSize);
        }
        @Override
        public void forEachRemaining(PrimitiveConsumer.OfByte action) {
            byte[] a; int i, hi; // hoist accesses and checks from loop
            if (action == null)
                throw new NullPointerException();
            if ((a = array).length >= (hi = fence) &&
                (i = index) >= 0 && i < (index = hi)) {
                do { action.acceptByte(a[i]); } while (++i < hi);
            }
        }
        @Override
        public boolean tryAdvance(PrimitiveConsumer.OfByte action) {
            if (action == null)
                throw new NullPointerException();
            if (index >= 0 && index < fence) {
                action.acceptByte(array[index++]);
                return true;
            }
            return false;
        }
        @Override
        public long estimateSize() {
            return estimatedSize >= 0 ? estimatedSize : (long)(fence - index);
        }
        @Override
        public int characteristics() {
            return characteristics;
        }
        @Override
        public PrimitiveComparator.OfByte getComparator() {
            if(hasCharacteristics(Spliterator.SORTED)) return null;
            throw new IllegalStateException();
        }
    }
    static class OfBoolean implements PrimitiveSpliterator.OfBoolean {
        private final boolean[] array;
        private int index;        // current index, modified on advance/split
        private final int fence;  // one past last index
        private final int characteristics;
        private long estimatedSize; // estimated size, to help to split evenly
        public OfBoolean(boolean[] array, int additionalCharacteristics) {
            this(array, 0, array.length, additionalCharacteristics);
        }
        public OfBoolean(boolean[] array, int origin, int fence, int additionalCharacteristics) {
            this.array = array;
            this.index = origin;
            this.fence = fence;
            this.characteristics = additionalCharacteristics | Spliterator.SIZED | Spliterator.SUBSIZED;
            this.estimatedSize = -1;
        }
        OfBoolean(boolean[] array, int origin, int fence, int additionalCharacteristics, long estimatedSize) {
            this.array = array;
            this.index = origin;
            this.fence = fence;
            this.characteristics = additionalCharacteristics & ~(Spliterator.SIZED | Spliterator.SUBSIZED);
            this.estimatedSize = estimatedSize;
        }
        @Override
        public ArraySpliterator.OfBoolean trySplit() {
            int lo = index, mid = (lo + fence) >>> 1;
            if(lo >= mid) return null;
            if(estimatedSize == -1) {
                return new ArraySpliterator.OfBoolean(array, lo, index = mid, characteristics);
            }
            long prefixEstimatedSize = estimatedSize >>> 1;
            estimatedSize -= prefixEstimatedSize;
            return new ArraySpliterator.OfBoolean(array, lo, index = mid, characteristics, prefixEstimatedSize);
        }
        @Override
        public void forEachRemaining(PrimitiveConsumer.OfBoolean action) {
            boolean[] a; int i, hi; // hoist accesses and checks from loop
            if (action == null)
                throw new NullPointerException();
            if ((a = array).length >= (hi = fence) &&
                (i = index) >= 0 && i < (index = hi)) {
                do { action.acceptBoolean(a[i]); } while (++i < hi);
            }
        }
        @Override
        public boolean tryAdvance(PrimitiveConsumer.OfBoolean action) {
            if (action == null)
                throw new NullPointerException();
            if (index >= 0 && index < fence) {
                action.acceptBoolean(array[index++]);
                return true;
            }
            return false;
        }
        @Override
        public long estimateSize() {
            return estimatedSize >= 0 ? estimatedSize : (long)(fence - index);
        }
        @Override
        public int characteristics() {
            return characteristics;
        }
        @Override
        public PrimitiveComparator.OfBoolean getComparator() {
            if(hasCharacteristics(Spliterator.SORTED)) return null;
            throw new IllegalStateException();
        }
    }
}
