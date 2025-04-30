package jdk.prim.util;

import java.util.Spliterator;

import jdk.prim.util.function.PrimitiveConsumer;

class PrimitiveIteratorSpliterator {
    static class OfDouble implements PrimitiveSpliterator.OfDouble {
        static final int BATCH_UNIT = PrimitiveAbstractSpliterator.BATCH_UNIT;
        static final int MAX_BATCH = PrimitiveAbstractSpliterator.MAX_BATCH;
        private final PrimitiveIterator.OfDouble it;
        private final int characteristics;
        private long est;             // size estimate
        private int batch;            // batch size for splits
        /**
         * 
         * Creates a spliterator using the given iterator
         * for traversal, and reporting the given initial size
         * and characteristics.
         *
         * @param it the iterator for the source
         * @param size the number of elements in the source
         * @param characteristics properties of this spliterator's
         * source or elements.
         */
        public OfDouble(PrimitiveIterator.OfDouble it, long size, int characteristics) {
            this.it = it;
            this.est = size;
            this.characteristics = (characteristics & Spliterator.CONCURRENT) == 0
                                   ? characteristics | Spliterator.SIZED | Spliterator.SUBSIZED
                                   : characteristics;
        }
        /**
         * Creates a spliterator using the given iterator for a source of unknown size,
         * reporting the given characteristics
         * 
         * @param it the iterator for the source
         * @param characteristics properties of this spliterator's elements/source
         */
        public OfDouble(PrimitiveIterator.OfDouble it, int characteristics) {
            this(it, Long.MAX_VALUE, characteristics & ~(Spliterator.SIZED | Spliterator.SUBSIZED));
        }
        @Override
        public PrimitiveSpliterator.OfDouble trySplit() {
            PrimitiveIterator.OfDouble i = it;
            long s = est;
            if (s > 1 && i.hasNext()) {
                int n = batch + BATCH_UNIT;
                if (n > s)
                    n = (int) s;
                if (n > MAX_BATCH)
                    n = MAX_BATCH;
                double[] a = new double[n];
                int j = 0;
                do { a[j] = i.nextDouble(); } while (++j < n && i.hasNext());
                batch = j;
                if (est != Long.MAX_VALUE) {
                    est -= j;
                    return new ArraySpliterator.OfDouble(a, 0, j, characteristics);
                }
                return new ArraySpliterator.OfDouble(a, 0, j, characteristics, Long.MAX_VALUE / 2);
            }
            return null;
        }
        @Override
        public void forEachRemaining(PrimitiveConsumer.OfDouble action) {
            if(action == null) throw new NullPointerException();
            it.forEachRemaining(action);
        }
        @Override
        public boolean tryAdvance(PrimitiveConsumer.OfDouble action) {
            if(action == null) throw new NullPointerException();
            if(it.hasNext()) {
                action.acceptDouble(it.nextDouble());
                return true;
            }
            return false;
        }
        @Override
        public long estimateSize() {
            return est;
        }
        @Override
        public int characteristics() { return characteristics; }
        @Override
        public PrimitiveComparator.OfDouble getComparator() {
            if(hasCharacteristics(Spliterator.SORTED)) return null;
            throw new IllegalStateException();
        }
    }
    static class OfLong implements PrimitiveSpliterator.OfLong {
        static final int BATCH_UNIT = PrimitiveAbstractSpliterator.BATCH_UNIT;
        static final int MAX_BATCH = PrimitiveAbstractSpliterator.MAX_BATCH;
        private final PrimitiveIterator.OfLong it;
        private final int characteristics;
        private long est;             // size estimate
        private int batch;            // batch size for splits
        /**
         * 
         * Creates a spliterator using the given iterator
         * for traversal, and reporting the given initial size
         * and characteristics.
         *
         * @param it the iterator for the source
         * @param size the number of elements in the source
         * @param characteristics properties of this spliterator's
         * source or elements.
         */
        public OfLong(PrimitiveIterator.OfLong it, long size, int characteristics) {
            this.it = it;
            this.est = size;
            this.characteristics = (characteristics & Spliterator.CONCURRENT) == 0
                                   ? characteristics | Spliterator.SIZED | Spliterator.SUBSIZED
                                   : characteristics;
        }
        /**
         *          * Creates a spliterator using the given iterator for aCreates a spliterator using the given iterator for a source of unknown size,
         * reporting the given characteristics
         * 
         * @param it the iterator for the source
         * @param characteristics properties of this spliterator's elements/source
         */
        public OfLong(PrimitiveIterator.OfLong it, int characteristics) {
            this(it, Long.MAX_VALUE, characteristics & ~(Spliterator.SIZED | Spliterator.SUBSIZED));
        }
        @Override
        public PrimitiveSpliterator.OfLong trySplit() {
            PrimitiveIterator.OfLong i = it;
            long s = est;
            if (s > 1 && i.hasNext()) {
                int n = batch + BATCH_UNIT;
                if (n > s)
                    n = (int) s;
                if (n > MAX_BATCH)
                    n = MAX_BATCH;
                long[] a = new long[n];
                int j = 0;
                do { a[j] = i.nextLong(); } while (++j < n && i.hasNext());
                batch = j;
                if (est != Long.MAX_VALUE) {
                    est -= j;
                    return new ArraySpliterator.OfLong(a, 0, j, characteristics);
                }
                return new ArraySpliterator.OfLong(a, 0, j, characteristics, Long.MAX_VALUE / 2);
            }
            return null;
        }
        @Override
        public void forEachRemaining(PrimitiveConsumer.OfLong action) {
            if(action == null) throw new NullPointerException();
            it.forEachRemaining(action);
        }
        @Override
        public boolean tryAdvance(PrimitiveConsumer.OfLong action) {
            if(action == null) throw new NullPointerException();
            if(it.hasNext()) {
                action.acceptLong(it.nextLong());
                return true;
            }
            return false;
        }
        @Override
        public long estimateSize() {
            return est;
        }
        @Override
        public int characteristics() { return characteristics; }
        @Override
        public PrimitiveComparator.OfLong getComparator() {
            if(hasCharacteristics(Spliterator.SORTED)) return null;
            throw new IllegalStateException();
        }
    }
    static class OfInt implements PrimitiveSpliterator.OfInt {
        static final int BATCH_UNIT = PrimitiveAbstractSpliterator.BATCH_UNIT;
        static final int MAX_BATCH = PrimitiveAbstractSpliterator.MAX_BATCH;
        private final PrimitiveIterator.OfInt it;
        private final int characteristics;
        private long est;             // size estimate
        private int batch;            // batch size for splits
        /**
         * 
         * Creates a spliterator using the given iterator
         * for traversal, and reporting the given initial size
         * and characteristics.
         *
         * @param it the iterator for the source
         * @param size the number of elements in the source
         * @param characteristics properties of this spliterator's
         * source or elements.
         */
        public OfInt(PrimitiveIterator.OfInt it, long size, int characteristics) {
            this.it = it;
            this.est = size;
            this.characteristics = (characteristics & Spliterator.CONCURRENT) == 0
                                   ? characteristics | Spliterator.SIZED | Spliterator.SUBSIZED
                                   : characteristics;
        }
        /**
         *          * source of unknown size, reporting the givenCreates a spliterator using the given iterator for a source of unknown size,
         * reporting the given characteristics
         * 
         * @param it the iterator for the source
         * @param characteristics properties of this spliterator's elements/source
         */
        public OfInt(PrimitiveIterator.OfInt it, int characteristics) {
            this(it, Long.MAX_VALUE, characteristics & ~(Spliterator.SIZED | Spliterator.SUBSIZED));
        }
        @Override
        public PrimitiveSpliterator.OfInt trySplit() {
            PrimitiveIterator.OfInt i = it;
            long s = est;
            if (s > 1 && i.hasNext()) {
                int n = batch + BATCH_UNIT;
                if (n > s)
                    n = (int) s;
                if (n > MAX_BATCH)
                    n = MAX_BATCH;
                int[] a = new int[n];
                int j = 0;
                do { a[j] = i.nextInt(); } while (++j < n && i.hasNext());
                batch = j;
                if (est != Long.MAX_VALUE) {
                    est -= j;
                    return new ArraySpliterator.OfInt(a, 0, j, characteristics);
                }
                return new ArraySpliterator.OfInt(a, 0, j, characteristics, Long.MAX_VALUE / 2);
            }
            return null;
        }
        @Override
        public void forEachRemaining(PrimitiveConsumer.OfInt action) {
            if(action == null) throw new NullPointerException();
            it.forEachRemaining(action);
        }
        @Override
        public boolean tryAdvance(PrimitiveConsumer.OfInt action) {
            if(action == null) throw new NullPointerException();
            if(it.hasNext()) {
                action.acceptInt(it.nextInt());
                return true;
            }
            return false;
        }
        @Override
        public long estimateSize() {
            return est;
        }
        @Override
        public int characteristics() { return characteristics; }
        @Override
        public PrimitiveComparator.OfInt getComparator() {
            if(hasCharacteristics(Spliterator.SORTED)) return null;
            throw new IllegalStateException();
        }
    }
    static class OfFloat implements PrimitiveSpliterator.OfFloat {
        static final int BATCH_UNIT = PrimitiveAbstractSpliterator.BATCH_UNIT;
        static final int MAX_BATCH = PrimitiveAbstractSpliterator.MAX_BATCH;
        private final PrimitiveIterator.OfFloat it;
        private final int characteristics;
        private long est;             // size estimate
        private int batch;            // batch size for splits
        /**
         * 
         * Creates a spliterator using the given iterator
         * for traversal, and reporting the given initial size
         * and characteristics.
         *
         * @param it the iterator for the source
         * @param size the number of elements in the source
         * @param characteristics properties of this spliterator's
         * source or elements.
         */
        public OfFloat(PrimitiveIterator.OfFloat it, long size, int characteristics) {
            this.it = it;
            this.est = size;
            this.characteristics = (characteristics & Spliterator.CONCURRENT) == 0
                                   ? characteristics | Spliterator.SIZED | Spliterator.SUBSIZED
                                   : characteristics;
        }
        /**
         *          * characteristics.Creates a spliterator using the given iterator for a source of unknown size,
         * reporting the given characteristics
         * 
         * @param it the iterator for the source
         * @param characteristics properties of this spliterator's elements/source
         */
        public OfFloat(PrimitiveIterator.OfFloat it, int characteristics) {
            this(it, Long.MAX_VALUE, characteristics & ~(Spliterator.SIZED | Spliterator.SUBSIZED));
        }
        @Override
        public PrimitiveSpliterator.OfFloat trySplit() {
            PrimitiveIterator.OfFloat i = it;
            long s = est;
            if (s > 1 && i.hasNext()) {
                int n = batch + BATCH_UNIT;
                if (n > s)
                    n = (int) s;
                if (n > MAX_BATCH)
                    n = MAX_BATCH;
                float[] a = new float[n];
                int j = 0;
                do { a[j] = i.nextFloat(); } while (++j < n && i.hasNext());
                batch = j;
                if (est != Long.MAX_VALUE) {
                    est -= j;
                    return new ArraySpliterator.OfFloat(a, 0, j, characteristics);
                }
                return new ArraySpliterator.OfFloat(a, 0, j, characteristics, Long.MAX_VALUE / 2);
            }
            return null;
        }
        @Override
        public void forEachRemaining(PrimitiveConsumer.OfFloat action) {
            if(action == null) throw new NullPointerException();
            it.forEachRemaining(action);
        }
        @Override
        public boolean tryAdvance(PrimitiveConsumer.OfFloat action) {
            if(action == null) throw new NullPointerException();
            if(it.hasNext()) {
                action.acceptFloat(it.nextFloat());
                return true;
            }
            return false;
        }
        @Override
        public long estimateSize() {
            return est;
        }
        @Override
        public int characteristics() { return characteristics; }
        @Override
        public PrimitiveComparator.OfFloat getComparator() {
            if(hasCharacteristics(Spliterator.SORTED)) return null;
            throw new IllegalStateException();
        }
    }
    static class OfChar implements PrimitiveSpliterator.OfChar {
        static final int BATCH_UNIT = PrimitiveAbstractSpliterator.BATCH_UNIT;
        static final int MAX_BATCH = PrimitiveAbstractSpliterator.MAX_BATCH;
        private final PrimitiveIterator.OfChar it;
        private final int characteristics;
        private long est;             // size estimate
        private int batch;            // batch size for splits
        /**
         * 
         * Creates a spliterator using the given iterator
         * for traversal, and reporting the given initial size
         * and characteristics.
         *
         * @param it the iterator for the source
         * @param size the number of elements in the source
         * @param characteristics properties of this spliterator's
         * source or elements.
         */
        public OfChar(PrimitiveIterator.OfChar it, long size, int characteristics) {
            this.it = it;
            this.est = size;
            this.characteristics = (characteristics & Spliterator.CONCURRENT) == 0
                                   ? characteristics | Spliterator.SIZED | Spliterator.SUBSIZED
                                   : characteristics;
        }
        /**
         *          *Creates a spliterator using the given iterator for a source of unknown size,
         * reporting the given characteristics
         * 
         * @param it the iterator for the source
         * @param characteristics properties of this spliterator's elements/source
         */
        public OfChar(PrimitiveIterator.OfChar it, int characteristics) {
            this(it, Long.MAX_VALUE, characteristics & ~(Spliterator.SIZED | Spliterator.SUBSIZED));
        }
        @Override
        public PrimitiveSpliterator.OfChar trySplit() {
            PrimitiveIterator.OfChar i = it;
            long s = est;
            if (s > 1 && i.hasNext()) {
                int n = batch + BATCH_UNIT;
                if (n > s)
                    n = (int) s;
                if (n > MAX_BATCH)
                    n = MAX_BATCH;
                char[] a = new char[n];
                int j = 0;
                do { a[j] = i.nextChar(); } while (++j < n && i.hasNext());
                batch = j;
                if (est != Long.MAX_VALUE) {
                    est -= j;
                    return new ArraySpliterator.OfChar(a, 0, j, characteristics);
                }
                return new ArraySpliterator.OfChar(a, 0, j, characteristics, Long.MAX_VALUE / 2);
            }
            return null;
        }
        @Override
        public void forEachRemaining(PrimitiveConsumer.OfChar action) {
            if(action == null) throw new NullPointerException();
            it.forEachRemaining(action);
        }
        @Override
        public boolean tryAdvance(PrimitiveConsumer.OfChar action) {
            if(action == null) throw new NullPointerException();
            if(it.hasNext()) {
                action.acceptChar(it.nextChar());
                return true;
            }
            return false;
        }
        @Override
        public long estimateSize() {
            return est;
        }
        @Override
        public int characteristics() { return characteristics; }
        @Override
        public PrimitiveComparator.OfChar getComparator() {
            if(hasCharacteristics(Spliterator.SORTED)) return null;
            throw new IllegalStateException();
        }
    }
    static class OfShort implements PrimitiveSpliterator.OfShort {
        static final int BATCH_UNIT = PrimitiveAbstractSpliterator.BATCH_UNIT;
        static final int MAX_BATCH = PrimitiveAbstractSpliterator.MAX_BATCH;
        private final PrimitiveIterator.OfShort it;
        private final int characteristics;
        private long est;             // size estimate
        private int batch;            // batch size for splits
        /**
         * 
         * Creates a spliterator using the given iterator
         * for traversal, and reporting the given initial size
         * and characteristics.
         *
         * @param it the iterator for the source
         * @param size the number of elements in the source
         * @param characteristics properties of this spliterator's
         * source or elements.
         */
        public OfShort(PrimitiveIterator.OfShort it, long size, int characteristics) {
            this.it = it;
            this.est = size;
            this.characteristics = (characteristics & Spliterator.CONCURRENT) == 0
                                   ? characteristics | Spliterator.SIZED | Spliterator.SUBSIZED
                                   : characteristics;
        }
        /**
         *          * @param iterator the iterator for the sourceCreates a spliterator using the given iterator for a source of unknown size,
         * reporting the given characteristics
         * 
         * @param it the iterator for the source
         * @param characteristics properties of this spliterator's elements/source
         */
        public OfShort(PrimitiveIterator.OfShort it, int characteristics) {
            this(it, Long.MAX_VALUE, characteristics & ~(Spliterator.SIZED | Spliterator.SUBSIZED));
        }
        @Override
        public PrimitiveSpliterator.OfShort trySplit() {
            PrimitiveIterator.OfShort i = it;
            long s = est;
            if (s > 1 && i.hasNext()) {
                int n = batch + BATCH_UNIT;
                if (n > s)
                    n = (int) s;
                if (n > MAX_BATCH)
                    n = MAX_BATCH;
                short[] a = new short[n];
                int j = 0;
                do { a[j] = i.nextShort(); } while (++j < n && i.hasNext());
                batch = j;
                if (est != Long.MAX_VALUE) {
                    est -= j;
                    return new ArraySpliterator.OfShort(a, 0, j, characteristics);
                }
                return new ArraySpliterator.OfShort(a, 0, j, characteristics, Long.MAX_VALUE / 2);
            }
            return null;
        }
        @Override
        public void forEachRemaining(PrimitiveConsumer.OfShort action) {
            if(action == null) throw new NullPointerException();
            it.forEachRemaining(action);
        }
        @Override
        public boolean tryAdvance(PrimitiveConsumer.OfShort action) {
            if(action == null) throw new NullPointerException();
            if(it.hasNext()) {
                action.acceptShort(it.nextShort());
                return true;
            }
            return false;
        }
        @Override
        public long estimateSize() {
            return est;
        }
        @Override
        public int characteristics() { return characteristics; }
        @Override
        public PrimitiveComparator.OfShort getComparator() {
            if(hasCharacteristics(Spliterator.SORTED)) return null;
            throw new IllegalStateException();
        }
    }
    static class OfByte implements PrimitiveSpliterator.OfByte {
        static final int BATCH_UNIT = PrimitiveAbstractSpliterator.BATCH_UNIT;
        static final int MAX_BATCH = PrimitiveAbstractSpliterator.MAX_BATCH;
        private final PrimitiveIterator.OfByte it;
        private final int characteristics;
        private long est;             // size estimate
        private int batch;            // batch size for splits
        /**
         * 
         * Creates a spliterator using the given iterator
         * for traversal, and reporting the given initial size
         * and characteristics.
         *
         * @param it the iterator for the source
         * @param size the number of elements in the source
         * @param characteristics properties of this spliterator's
         * source or elements.
         */
        public OfByte(PrimitiveIterator.OfByte it, long size, int characteristics) {
            this.it = it;
            this.est = size;
            this.characteristics = (characteristics & Spliterator.CONCURRENT) == 0
                                   ? characteristics | Spliterator.SIZED | Spliterator.SUBSIZED
                                   : characteristics;
        }
        /**
         *          * @param characteristics properties of this spliterator'sCreates a spliterator using the given iterator for a source of unknown size,
         * reporting the given characteristics
         * 
         * @param it the iterator for the source
         * @param characteristics properties of this spliterator's elements/source
         */
        public OfByte(PrimitiveIterator.OfByte it, int characteristics) {
            this(it, Long.MAX_VALUE, characteristics & ~(Spliterator.SIZED | Spliterator.SUBSIZED));
        }
        @Override
        public PrimitiveSpliterator.OfByte trySplit() {
            PrimitiveIterator.OfByte i = it;
            long s = est;
            if (s > 1 && i.hasNext()) {
                int n = batch + BATCH_UNIT;
                if (n > s)
                    n = (int) s;
                if (n > MAX_BATCH)
                    n = MAX_BATCH;
                byte[] a = new byte[n];
                int j = 0;
                do { a[j] = i.nextByte(); } while (++j < n && i.hasNext());
                batch = j;
                if (est != Long.MAX_VALUE) {
                    est -= j;
                    return new ArraySpliterator.OfByte(a, 0, j, characteristics);
                }
                return new ArraySpliterator.OfByte(a, 0, j, characteristics, Long.MAX_VALUE / 2);
            }
            return null;
        }
        @Override
        public void forEachRemaining(PrimitiveConsumer.OfByte action) {
            if(action == null) throw new NullPointerException();
            it.forEachRemaining(action);
        }
        @Override
        public boolean tryAdvance(PrimitiveConsumer.OfByte action) {
            if(action == null) throw new NullPointerException();
            if(it.hasNext()) {
                action.acceptByte(it.nextByte());
                return true;
            }
            return false;
        }
        @Override
        public long estimateSize() {
            return est;
        }
        @Override
        public int characteristics() { return characteristics; }
        @Override
        public PrimitiveComparator.OfByte getComparator() {
            if(hasCharacteristics(Spliterator.SORTED)) return null;
            throw new IllegalStateException();
        }
    }
    static class OfBoolean implements PrimitiveSpliterator.OfBoolean {
        static final int BATCH_UNIT = PrimitiveAbstractSpliterator.BATCH_UNIT;
        static final int MAX_BATCH = PrimitiveAbstractSpliterator.MAX_BATCH;
        private final PrimitiveIterator.OfBoolean it;
        private final int characteristics;
        private long est;             // size estimate
        private int batch;            // batch size for splits
        /**
         * 
         * Creates a spliterator using the given iterator
         * for traversal, and reporting the given initial size
         * and characteristics.
         *
         * @param it the iterator for the source
         * @param size the number of elements in the source
         * @param characteristics properties of this spliterator's
         * source or elements.
         */
        public OfBoolean(PrimitiveIterator.OfBoolean it, long size, int characteristics) {
            this.it = it;
            this.est = size;
            this.characteristics = (characteristics & Spliterator.CONCURRENT) == 0
                                   ? characteristics | Spliterator.SIZED | Spliterator.SUBSIZED
                                   : characteristics;
        }
        /**
         *          * source or elements.Creates a spliterator using the given iterator for a source of unknown size,
         * reporting the given characteristics
         * 
         * @param it the iterator for the source
         * @param characteristics properties of this spliterator's elements/source
         */
        public OfBoolean(PrimitiveIterator.OfBoolean it, int characteristics) {
            this(it, Long.MAX_VALUE, characteristics & ~(Spliterator.SIZED | Spliterator.SUBSIZED));
        }
        @Override
        public PrimitiveSpliterator.OfBoolean trySplit() {
            PrimitiveIterator.OfBoolean i = it;
            long s = est;
            if (s > 1 && i.hasNext()) {
                int n = batch + BATCH_UNIT;
                if (n > s)
                    n = (int) s;
                if (n > MAX_BATCH)
                    n = MAX_BATCH;
                boolean[] a = new boolean[n];
                int j = 0;
                do { a[j] = i.nextBoolean(); } while (++j < n && i.hasNext());
                batch = j;
                if (est != Long.MAX_VALUE) {
                    est -= j;
                    return new ArraySpliterator.OfBoolean(a, 0, j, characteristics);
                }
                return new ArraySpliterator.OfBoolean(a, 0, j, characteristics, Long.MAX_VALUE / 2);
            }
            return null;
        }
        @Override
        public void forEachRemaining(PrimitiveConsumer.OfBoolean action) {
            if(action == null) throw new NullPointerException();
            it.forEachRemaining(action);
        }
        @Override
        public boolean tryAdvance(PrimitiveConsumer.OfBoolean action) {
            if(action == null) throw new NullPointerException();
            if(it.hasNext()) {
                action.acceptBoolean(it.nextBoolean());
                return true;
            }
            return false;
        }
        @Override
        public long estimateSize() {
            return est;
        }
        @Override
        public int characteristics() { return characteristics; }
        @Override
        public PrimitiveComparator.OfBoolean getComparator() {
            if(hasCharacteristics(Spliterator.SORTED)) return null;
            throw new IllegalStateException();
        }
    }    
}
