package jdk.prim.util;

/**
 * A pseudo-package for holding the primitive declaration with functionalities and syntax of {@link java.util.AbstractCollection AbstractCollection}
 */
public final class PrimitiveAbstractCollection {
    /**
     * Created as a base class for generic implementation of {@code double} collections.
     * It only declare default methods
     * 
     * <p>
     * This is analogous to {@link java.util.AbstractCollection}
     */
    public static abstract class OfDouble implements PrimitiveCollection.OfDouble {
        /** Constructor for subclasses */
        protected OfDouble() {}

        ///////////// Query operations

        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         */
        public boolean isEmpty() { return size() == 0; }

        public boolean containsDouble(double value) {
            PrimitiveIterator.OfDouble it = iteratorDouble();
            if(Double.isNaN(value)) while(it.hasNext()) if(Double.isNaN(it.nextDouble())) return true;
            while(it.hasNext()) if(it.nextDouble() == value) return true;
            return false;
        }

        private static double realloc(double[] array, PrimitiveIterator.OfDouble it) {
//            int len = array.length;
//            int i = len;
//            while(it.hasNext()) {
//                if(i == len)
//            }
            return (double) 0.0;
        }
    }
    /**
     * Created as a base class for generic implementation of {@code long} collections.
     * It only declare default methods
     * 
     * <p>
     * This is analogous to {@link java.util.AbstractCollection}
     */
    public static abstract class OfLong implements PrimitiveCollection.OfLong {
        /** Constructor for subclasses */
        protected OfLong() {}

        ///////////// Query operations

        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         */
        public boolean isEmpty() { return size() == 0; }

        public boolean containsLong(long value) {
            PrimitiveIterator.OfLong it = iteratorLong();
            // has special values
            while(it.hasNext()) if(it.nextLong() == value) return true;
            return false;
        }

        private static long realloc(long[] array, PrimitiveIterator.OfLong it) {
//            int len = array.length;
//            int i = len;
//            while(it.hasNext()) {
//                if(i == len)
//            }
            return (long) 0.0;
        }
    }
    /**
     * Created as a base class for generic implementation of {@code int} collections.
     * It only declare default methods
     * 
     * <p>
     * This is analogous to {@link java.util.AbstractCollection}
     */
    public static abstract class OfInt implements PrimitiveCollection.OfInt {
        /** Constructor for subclasses */
        protected OfInt() {}

        ///////////// Query operations

        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         */
        public boolean isEmpty() { return size() == 0; }

        public boolean containsInt(int value) {
            PrimitiveIterator.OfInt it = iteratorInt();
            // has special values
            while(it.hasNext()) if(it.nextInt() == value) return true;
            return false;
        }

        private static int realloc(int[] array, PrimitiveIterator.OfInt it) {
//            int len = array.length;
//            int i = len;
//            while(it.hasNext()) {
//                if(i == len)
//            }
            return (int) 0.0;
        }
    }
    /**
     * Created as a base class for generic implementation of {@code float} collections.
     * It only declare default methods
     * 
     * <p>
     * This is analogous to {@link java.util.AbstractCollection}
     */
    public static abstract class OfFloat implements PrimitiveCollection.OfFloat {
        /** Constructor for subclasses */
        protected OfFloat() {}

        ///////////// Query operations

        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         */
        public boolean isEmpty() { return size() == 0; }

        public boolean containsFloat(float value) {
            PrimitiveIterator.OfFloat it = iteratorFloat();
            if(Float.isNaN(value)) while(it.hasNext()) if(Float.isNaN(it.nextFloat())) return true;
            while(it.hasNext()) if(it.nextFloat() == value) return true;
            return false;
        }

        private static float realloc(float[] array, PrimitiveIterator.OfFloat it) {
//            int len = array.length;
//            int i = len;
//            while(it.hasNext()) {
//                if(i == len)
//            }
            return (float) 0.0;
        }
    }
    /**
     * Created as a base class for generic implementation of {@code char} collections.
     * It only declare default methods
     * 
     * <p>
     * This is analogous to {@link java.util.AbstractCollection}
     */
    public static abstract class OfChar implements PrimitiveCollection.OfChar {
        /** Constructor for subclasses */
        protected OfChar() {}

        ///////////// Query operations

        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         */
        public boolean isEmpty() { return size() == 0; }

        public boolean containsChar(char value) {
            PrimitiveIterator.OfChar it = iteratorChar();
            // has special values
            while(it.hasNext()) if(it.nextChar() == value) return true;
            return false;
        }

        private static char realloc(char[] array, PrimitiveIterator.OfChar it) {
//            int len = array.length;
//            int i = len;
//            while(it.hasNext()) {
//                if(i == len)
//            }
            return (char) 0.0;
        }
    }
    /**
     * Created as a base class for generic implementation of {@code short} collections.
     * It only declare default methods
     * 
     * <p>
     * This is analogous to {@link java.util.AbstractCollection}
     */
    public static abstract class OfShort implements PrimitiveCollection.OfShort {
        /** Constructor for subclasses */
        protected OfShort() {}

        ///////////// Query operations

        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         */
        public boolean isEmpty() { return size() == 0; }

        public boolean containsShort(short value) {
            PrimitiveIterator.OfShort it = iteratorShort();
            // has special values
            while(it.hasNext()) if(it.nextShort() == value) return true;
            return false;
        }

        private static short realloc(short[] array, PrimitiveIterator.OfShort it) {
//            int len = array.length;
//            int i = len;
//            while(it.hasNext()) {
//                if(i == len)
//            }
            return (short) 0.0;
        }
    }
    /**
     * Created as a base class for generic implementation of {@code byte} collections.
     * It only declare default methods
     * 
     * <p>
     * This is analogous to {@link java.util.AbstractCollection}
     */
    public static abstract class OfByte implements PrimitiveCollection.OfByte {
        /** Constructor for subclasses */
        protected OfByte() {}

        ///////////// Query operations

        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         */
        public boolean isEmpty() { return size() == 0; }

        public boolean containsByte(byte value) {
            PrimitiveIterator.OfByte it = iteratorByte();
            // has special values
            while(it.hasNext()) if(it.nextByte() == value) return true;
            return false;
        }

        private static byte realloc(byte[] array, PrimitiveIterator.OfByte it) {
//            int len = array.length;
//            int i = len;
//            while(it.hasNext()) {
//                if(i == len)
//            }
            return (byte) 0.0;
        }
    }
    /**
     * Created as a base class for generic implementation of {@code boolean} collections.
     * It only declare default methods
     * 
     * <p>
     * This is analogous to {@link java.util.AbstractCollection}
     */
    public static abstract class OfBoolean implements PrimitiveCollection.OfBoolean {
        /** Constructor for subclasses */
        protected OfBoolean() {}

        ///////////// Query operations

        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         */
        public boolean isEmpty() { return size() == 0; }

        public boolean containsBoolean(boolean value) {
            PrimitiveIterator.OfBoolean it = iteratorBoolean();
            // has special values
            while(it.hasNext()) if(it.nextBoolean() == value) return true;
            return false;
        }

        private static boolean realloc(boolean[] array, PrimitiveIterator.OfBoolean it) {
//            int len = array.length;
//            int i = len;
//            while(it.hasNext()) {
//                if(i == len)
//            }
            return false;
        }
    }
}
