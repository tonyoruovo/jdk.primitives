package jdk.prim.util;

import java.util.Spliterator;
import java.util.Spliterators;

import jdk.prim.util.function.PrimitiveConsumer;

public final class PrimitiveAbstractSpliterator {
    static final int BATCH_UNIT = 1 << 10;  // batch array size increment
    static final int MAX_BATCH = 1 << 25;  // max batch array size;
    public static abstract class OfDouble extends Spliterators.AbstractDoubleSpliterator {
        public OfDouble(long est, int additionalCharacteristics) { super(est, additionalCharacteristics); }
    }
    public static abstract class OfLong extends Spliterators.AbstractLongSpliterator {
        public OfLong(long est, int additionalCharacteristics) { super(est, additionalCharacteristics); }
    }
    public static abstract class OfInt extends Spliterators.AbstractIntSpliterator {
        public OfInt(long est, int additionalCharacteristics) { super(est, additionalCharacteristics); }
    }
    public static abstract class OfFloat implements PrimitiveSpliterator.OfFloat {
        static final int MAX_BATCH = PrimitiveAbstractSpliterator.MAX_BATCH;
        static final int BATCH_UNIT = PrimitiveAbstractSpliterator.BATCH_UNIT;
        private final int characteristics;
        private long est;             // size estimate
        private int batch;            // batch size for splits

        /**
         * Create a {@code float} spliterator, reporting the given estimated size and characteristics.
         * @param est the estimated size of this spliterator if known, otherwise {@code Long.MAX_VALUE}
         * @param additionalCharacteristics properties of this spliterator's
         *        source or elements.  If {@code SIZED} is reported then this
         *        spliterator will additionally report {@code SUBSIZED}.
         */
        protected OfFloat(long est, int additionalCharacteristics) {
            this.est = est;
            this.characteristics = ((additionalCharacteristics & Spliterator.SIZED) != 0)
                                   ? additionalCharacteristics | Spliterator.SUBSIZED
                                   : additionalCharacteristics;
        }
        static final class CachingConsumer implements PrimitiveConsumer.OfFloat {
            private float cache;
            @Override
            public void acceptFloat(float value) { cache = value; }
        }
        /**
         * {@inheritDoc}
         */
        @Override
        public PrimitiveSpliterator.OfFloat trySplit() {
            CachingConsumer consumer = new CachingConsumer();
            long s = est;
            if (s > 1 && tryAdvance(consumer)) {
                int n = batch + BATCH_UNIT;
                if (n > s)
                    n = (int) s;
                if (n > MAX_BATCH)
                    n = MAX_BATCH;
                float[] a = new float[n];
                int j = 0;
                do { a[j] = consumer.cache; } while (++j < n && tryAdvance(consumer));
                batch = j;
                if (est != Long.MAX_VALUE) {
                    est -= j;
                    return new ArraySpliterator.OfFloat(a, 0, j, characteristics);
                }
                return new ArraySpliterator.OfFloat(a, 0, j, characteristics, Long.MAX_VALUE / 2);
            }
            return null;
        }
        /**
         * {@inheritDoc}
         */
        @Override
        public long estimateSize() {
            return est;
        }
        /**
         * {@inheritDoc}
         */
        @Override
        public int characteristics() {
            return characteristics;
        }

    }
    public static abstract class OfChar implements PrimitiveSpliterator.OfChar {
        static final int MAX_BATCH = PrimitiveAbstractSpliterator.MAX_BATCH;
        static final int BATCH_UNIT = PrimitiveAbstractSpliterator.BATCH_UNIT;
        private final int characteristics;
        private long est;             // size estimate
        private int batch;            // batch size for splits

        /**
         * Create a {@code char} spliterator, reporting the given estimated size and characteristics.
         * @param est the estimated size of this spliterator if known, otherwise {@code Long.MAX_VALUE}
         * @param additionalCharacteristics properties of this spliterator's
         *        source or elements.  If {@code SIZED} is reported then this
         *        spliterator will additionally report {@code SUBSIZED}.
         */
        protected OfChar(long est, int additionalCharacteristics) {
            this.est = est;
            this.characteristics = ((additionalCharacteristics & Spliterator.SIZED) != 0)
                                   ? additionalCharacteristics | Spliterator.SUBSIZED
                                   : additionalCharacteristics;
        }
        static final class CachingConsumer implements PrimitiveConsumer.OfChar {
            private char cache;
            @Override
            public void acceptChar(char value) { cache = value; }
        }
        /**
         * {@inheritDoc}
         */
        @Override
        public PrimitiveSpliterator.OfChar trySplit() {
            CachingConsumer consumer = new CachingConsumer();
            long s = est;
            if (s > 1 && tryAdvance(consumer)) {
                int n = batch + BATCH_UNIT;
                if (n > s)
                    n = (int) s;
                if (n > MAX_BATCH)
                    n = MAX_BATCH;
                char[] a = new char[n];
                int j = 0;
                do { a[j] = consumer.cache; } while (++j < n && tryAdvance(consumer));
                batch = j;
                if (est != Long.MAX_VALUE) {
                    est -= j;
                    return new ArraySpliterator.OfChar(a, 0, j, characteristics);
                }
                return new ArraySpliterator.OfChar(a, 0, j, characteristics, Long.MAX_VALUE / 2);
            }
            return null;
        }
        /**
         * {@inheritDoc}
         */
        @Override
        public long estimateSize() {
            return est;
        }
        /**
         * {@inheritDoc}
         */
        @Override
        public int characteristics() {
            return characteristics;
        }

    }
    public static abstract class OfShort implements PrimitiveSpliterator.OfShort {
        static final int MAX_BATCH = PrimitiveAbstractSpliterator.MAX_BATCH;
        static final int BATCH_UNIT = PrimitiveAbstractSpliterator.BATCH_UNIT;
        private final int characteristics;
        private long est;             // size estimate
        private int batch;            // batch size for splits

        /**
         * Create a {@code short} spliterator, reporting the given estimated size and characteristics.
         * @param est the estimated size of this spliterator if known, otherwise {@code Long.MAX_VALUE}
         * @param additionalCharacteristics properties of this spliterator's
         *        source or elements.  If {@code SIZED} is reported then this
         *        spliterator will additionally report {@code SUBSIZED}.
         */
        protected OfShort(long est, int additionalCharacteristics) {
            this.est = est;
            this.characteristics = ((additionalCharacteristics & Spliterator.SIZED) != 0)
                                   ? additionalCharacteristics | Spliterator.SUBSIZED
                                   : additionalCharacteristics;
        }
        static final class CachingConsumer implements PrimitiveConsumer.OfShort {
            private short cache;
            @Override
            public void acceptShort(short value) { cache = value; }
        }
        /**
         * {@inheritDoc}
         */
        @Override
        public PrimitiveSpliterator.OfShort trySplit() {
            CachingConsumer consumer = new CachingConsumer();
            long s = est;
            if (s > 1 && tryAdvance(consumer)) {
                int n = batch + BATCH_UNIT;
                if (n > s)
                    n = (int) s;
                if (n > MAX_BATCH)
                    n = MAX_BATCH;
                short[] a = new short[n];
                int j = 0;
                do { a[j] = consumer.cache; } while (++j < n && tryAdvance(consumer));
                batch = j;
                if (est != Long.MAX_VALUE) {
                    est -= j;
                    return new ArraySpliterator.OfShort(a, 0, j, characteristics);
                }
                return new ArraySpliterator.OfShort(a, 0, j, characteristics, Long.MAX_VALUE / 2);
            }
            return null;
        }
        /**
         * {@inheritDoc}
         */
        @Override
        public long estimateSize() {
            return est;
        }
        /**
         * {@inheritDoc}
         */
        @Override
        public int characteristics() {
            return characteristics;
        }

    }
    public static abstract class OfByte implements PrimitiveSpliterator.OfByte {
        static final int MAX_BATCH = PrimitiveAbstractSpliterator.MAX_BATCH;
        static final int BATCH_UNIT = PrimitiveAbstractSpliterator.BATCH_UNIT;
        private final int characteristics;
        private long est;             // size estimate
        private int batch;            // batch size for splits

        /**
         * Create a {@code byte} spliterator, reporting the given estimated size and characteristics.
         * @param est the estimated size of this spliterator if known, otherwise {@code Long.MAX_VALUE}
         * @param additionalCharacteristics properties of this spliterator's
         *        source or elements.  If {@code SIZED} is reported then this
         *        spliterator will additionally report {@code SUBSIZED}.
         */
        protected OfByte(long est, int additionalCharacteristics) {
            this.est = est;
            this.characteristics = ((additionalCharacteristics & Spliterator.SIZED) != 0)
                                   ? additionalCharacteristics | Spliterator.SUBSIZED
                                   : additionalCharacteristics;
        }
        static final class CachingConsumer implements PrimitiveConsumer.OfByte {
            private byte cache;
            @Override
            public void acceptByte(byte value) { cache = value; }
        }
        /**
         * {@inheritDoc}
         */
        @Override
        public PrimitiveSpliterator.OfByte trySplit() {
            CachingConsumer consumer = new CachingConsumer();
            long s = est;
            if (s > 1 && tryAdvance(consumer)) {
                int n = batch + BATCH_UNIT;
                if (n > s)
                    n = (int) s;
                if (n > MAX_BATCH)
                    n = MAX_BATCH;
                byte[] a = new byte[n];
                int j = 0;
                do { a[j] = consumer.cache; } while (++j < n && tryAdvance(consumer));
                batch = j;
                if (est != Long.MAX_VALUE) {
                    est -= j;
                    return new ArraySpliterator.OfByte(a, 0, j, characteristics);
                }
                return new ArraySpliterator.OfByte(a, 0, j, characteristics, Long.MAX_VALUE / 2);
            }
            return null;
        }
        /**
         * {@inheritDoc}
         */
        @Override
        public long estimateSize() {
            return est;
        }
        /**
         * {@inheritDoc}
         */
        @Override
        public int characteristics() {
            return characteristics;
        }

    }
    public static abstract class OfBoolean implements PrimitiveSpliterator.OfBoolean {
        static final int MAX_BATCH = PrimitiveAbstractSpliterator.MAX_BATCH;
        static final int BATCH_UNIT = PrimitiveAbstractSpliterator.BATCH_UNIT;
        private final int characteristics;
        private long est;             // size estimate
        private int batch;            // batch size for splits

        /**
         * Create a {@code boolean} spliterator, reporting the given estimated size and characteristics.
         * @param est the estimated size of this spliterator if known, otherwise {@code Long.MAX_VALUE}
         * @param additionalCharacteristics properties of this spliterator's
         *        source or elements.  If {@code SIZED} is reported then this
         *        spliterator will additionally report {@code SUBSIZED}.
         */
        protected OfBoolean(long est, int additionalCharacteristics) {
            this.est = est;
            this.characteristics = ((additionalCharacteristics & Spliterator.SIZED) != 0)
                                   ? additionalCharacteristics | Spliterator.SUBSIZED
                                   : additionalCharacteristics;
        }
        static final class CachingConsumer implements PrimitiveConsumer.OfBoolean {
            private boolean cache;
            @Override
            public void acceptBoolean(boolean value) { cache = value; }
        }
        /**
         * {@inheritDoc}
         */
        @Override
        public PrimitiveSpliterator.OfBoolean trySplit() {
            CachingConsumer consumer = new CachingConsumer();
            long s = est;
            if (s > 1 && tryAdvance(consumer)) {
                int n = batch + BATCH_UNIT;
                if (n > s)
                    n = (int) s;
                if (n > MAX_BATCH)
                    n = MAX_BATCH;
                boolean[] a = new boolean[n];
                int j = 0;
                do { a[j] = consumer.cache; } while (++j < n && tryAdvance(consumer));
                batch = j;
                if (est != Long.MAX_VALUE) {
                    est -= j;
                    return new ArraySpliterator.OfBoolean(a, 0, j, characteristics);
                }
                return new ArraySpliterator.OfBoolean(a, 0, j, characteristics, Long.MAX_VALUE / 2);
            }
            return null;
        }
        /**
         * {@inheritDoc}
         */
        @Override
        public long estimateSize() {
            return est;
        }
        /**
         * {@inheritDoc}
         */
        @Override
        public int characteristics() {
            return characteristics;
        }

    }    
}
