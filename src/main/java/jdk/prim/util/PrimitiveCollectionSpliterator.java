package jdk.prim.util;

class PrimitiveCollectionSpliterator {
    static class OfDouble extends PrimitiveIteratorSpliterator.OfDouble {
        /**
         * Creates a spliterator using the given {@code double}
         * collection's {@link PrimitiveCollection.OfDouble#iteratorDouble() iterator} for traversal,
         * and reporting its {@link java.util.Collection#size() size} as its initial
         * size.
         *
         * @param collection the {@code double} collection
         * @param characteristics properties of this spliterator's
         *        source or elements.
         */
        public OfDouble(PrimitiveCollection.OfDouble collection, int characteristics) {
            super(collection.iteratorDouble(), (long) collection.size(), characteristics);
        }
    }
    static class OfLong extends PrimitiveIteratorSpliterator.OfLong {
        /**
         * Creates a spliterator using the given {@code long}
         * collection's {@link PrimitiveCollection.OfLong#iteratorLong() iterator} for traversal,
         * and reporting its {@link java.util.Collection#size() size} as its initial
         * size.
         *
         * @param collection the {@code long} collection
         * @param characteristics properties of this spliterator's
         *        source or elements.
         */
        public OfLong(PrimitiveCollection.OfLong collection, int characteristics) {
            super(collection.iteratorLong(), (long) collection.size(), characteristics);
        }
    }
    static class OfInt extends PrimitiveIteratorSpliterator.OfInt {
        /**
         * Creates a spliterator using the given {@code int}
         * collection's {@link PrimitiveCollection.OfInt#iteratorInt() iterator} for traversal,
         * and reporting its {@link java.util.Collection#size() size} as its initial
         * size.
         *
         * @param collection the {@code int} collection
         * @param characteristics properties of this spliterator's
         *        source or elements.
         */
        public OfInt(PrimitiveCollection.OfInt collection, int characteristics) {
            super(collection.iteratorInt(), (long) collection.size(), characteristics);
        }
    }
    static class OfFloat extends PrimitiveIteratorSpliterator.OfFloat {
        /**
         * Creates a spliterator using the given {@code float}
         * collection's {@link PrimitiveCollection.OfFloat#iteratorFloat() iterator} for traversal,
         * and reporting its {@link java.util.Collection#size() size} as its initial
         * size.
         *
         * @param collection the {@code float} collection
         * @param characteristics properties of this spliterator's
         *        source or elements.
         */
        public OfFloat(PrimitiveCollection.OfFloat collection, int characteristics) {
            super(collection.iteratorFloat(), (long) collection.size(), characteristics);
        }
    }
    static class OfChar extends PrimitiveIteratorSpliterator.OfChar {
        /**
         * Creates a spliterator using the given {@code char}
         * collection's {@link PrimitiveCollection.OfChar#iteratorChar() iterator} for traversal,
         * and reporting its {@link java.util.Collection#size() size} as its initial
         * size.
         *
         * @param collection the {@code char} collection
         * @param characteristics properties of this spliterator's
         *        source or elements.
         */
        public OfChar(PrimitiveCollection.OfChar collection, int characteristics) {
            super(collection.iteratorChar(), (long) collection.size(), characteristics);
        }
    }
    static class OfShort extends PrimitiveIteratorSpliterator.OfShort {
        /**
         * Creates a spliterator using the given {@code short}
         * collection's {@link PrimitiveCollection.OfShort#iteratorShort() iterator} for traversal,
         * and reporting its {@link java.util.Collection#size() size} as its initial
         * size.
         *
         * @param collection the {@code short} collection
         * @param characteristics properties of this spliterator's
         *        source or elements.
         */
        public OfShort(PrimitiveCollection.OfShort collection, int characteristics) {
            super(collection.iteratorShort(), (long) collection.size(), characteristics);
        }
    }
    static class OfByte extends PrimitiveIteratorSpliterator.OfByte {
        /**
         * Creates a spliterator using the given {@code byte}
         * collection's {@link PrimitiveCollection.OfByte#iteratorByte() iterator} for traversal,
         * and reporting its {@link java.util.Collection#size() size} as its initial
         * size.
         *
         * @param collection the {@code byte} collection
         * @param characteristics properties of this spliterator's
         *        source or elements.
         */
        public OfByte(PrimitiveCollection.OfByte collection, int characteristics) {
            super(collection.iteratorByte(), (long) collection.size(), characteristics);
        }
    }
    static class OfBoolean extends PrimitiveIteratorSpliterator.OfBoolean {
        /**
         * Creates a spliterator using the given {@code boolean}
         * collection's {@link PrimitiveCollection.OfBoolean#iteratorBoolean() iterator} for traversal,
         * and reporting its {@link java.util.Collection#size() size} as its initial
         * size.
         *
         * @param collection the {@code boolean} collection
         * @param characteristics properties of this spliterator's
         *        source or elements.
         */
        public OfBoolean(PrimitiveCollection.OfBoolean collection, int characteristics) {
            super(collection.iteratorBoolean(), (long) collection.size(), characteristics);
        }
    }
}
