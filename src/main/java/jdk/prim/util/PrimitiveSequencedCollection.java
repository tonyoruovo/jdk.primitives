package jdk.prim.util;

import java.util.SequencedCollection;

import jdk.prim.util.function.PrimitiveConsumer;

/**
 * A {@link SequencedCollection} for primitive elements
 * @param <T> The type of primitive wrapper for this sequenced collection
 * @param <T_CONS> the type of consumer for the generic {@link #forEach(Object) forEach}
 * 
 * @see SequencedCollection
 */
public interface PrimitiveSequencedCollection<
T,
T_CONS> extends SequencedCollection<T>, PrimitiveCollection<T, T_CONS> {
    /**
     * A {@link PrimitiveSequencedCollection} of {@code double} values.
     */
    interface OfDouble extends PrimitiveSequencedCollection<java.lang.Double, PrimitiveConsumer.OfDouble>, PrimitiveCollection.OfDouble {
        /**
         * The {@code double} specialization of {@link #addFirst(Object)}
         * @param e the element to be added to the head this collection
         */
        default void addFirstDouble(double e) { throw new UnsupportedOperationException(); }
        @Override
        default void addFirst(java.lang.Double e) { addFirstDouble(e); }
        /**
         * The {@code double} specialization of {@link #addLast(Object)}
         * @param e the element to be added to the tail of this collection
         */
        default void addLastDouble(double e) { throw new UnsupportedOperationException(); }
        @Override
        default void addLast(java.lang.Double e) { addLast(e); }
        /**
         * The {@code double} specialization of {@link #getFirst(Object)}
         * @return the element at the head of this collection
         */
        default double getFirstDouble() { return iteratorDouble().nextDouble(); }
        @Override
        default java.lang.Double getFirst() { return getFirstDouble(); }
        /**
         * The {@code double} specialization of {@link #getLast(Object)}
         * @return the element at the tail of this collection
         */
        default double getLastDouble() { return reversedDouble().iteratorDouble().nextDouble(); }
        @Override
        default java.lang.Double getLast() { return getLastDouble(); }
        /**
         * The {@code double} specialization of {@link #removeFirst(Object)}
         * @return the removed element
         */
        default double removeFirstDouble() {
            PrimitiveIterator.OfDouble it = iteratorDouble();
            double e = it.nextDouble();
            it.remove();
            return e;
        }
        @Override
        default java.lang.Double removeFirst() { return removeFirstDouble(); }
        @Override
        default java.lang.Double removeLast() { return removeLastDouble(); }
        /**
         * The {@code double} specialization of {@link #removeLast(Object)}
         * @return the removed element
         */
        default double removeLastDouble() {
            PrimitiveIterator.OfDouble it = reversedDouble().iteratorDouble();
            double e = it.nextDouble();
            it.remove();
            return e;
        }
        /**
         * Overridden to specialize return type.
         * @return the reverse-order view of this collection
         * @see SequencedCollection#reversed()
         */
        PrimitiveSequencedCollection.OfDouble reversedDouble();
        @Override
        default SequencedCollection<java.lang.Double> reversed() { return reversedDouble(); }
    }
    /**
     * A {@link PrimitiveSequencedCollection} of {@code long} values.
     */
    interface OfLong extends PrimitiveSequencedCollection<java.lang.Long, PrimitiveConsumer.OfLong>, PrimitiveCollection.OfLong {
        /**
         * The {@code long} specialization of {@link #addFirst(Object)}
         * @param e the element to be added to the head this collection
         */
        default void addFirstLong(long e) { throw new UnsupportedOperationException(); }
        @Override
        default void addFirst(java.lang.Long e) { addFirstLong(e); }
        /**
         * The {@code long} specialization of {@link #addLast(Object)}
         * @param e the element to be added to the tail of this collection
         */
        default void addLastLong(long e) { throw new UnsupportedOperationException(); }
        @Override
        default void addLast(java.lang.Long e) { addLast(e); }
        /**
         * The {@code long} specialization of {@link #getFirst(Object)}
         * @return the element at the head of this collection
         */
        default long getFirstLong() { return iteratorLong().nextLong(); }
        @Override
        default java.lang.Long getFirst() { return getFirstLong(); }
        /**
         * The {@code long} specialization of {@link #getLast(Object)}
         * @return the element at the tail of this collection
         */
        default long getLastLong() { return reversedLong().iteratorLong().nextLong(); }
        @Override
        default java.lang.Long getLast() { return getLastLong(); }
        /**
         * The {@code long} specialization of {@link #removeFirst(Object)}
         * @return the removed element
         */
        default long removeFirstLong() {
            PrimitiveIterator.OfLong it = iteratorLong();
            long e = it.nextLong();
            it.remove();
            return e;
        }
        @Override
        default java.lang.Long removeFirst() { return removeFirstLong(); }
        @Override
        default java.lang.Long removeLast() { return removeLastLong(); }
        /**
         * The {@code long} specialization of {@link #removeLast(Object)}
         * @return the removed element
         */
        default long removeLastLong() {
            PrimitiveIterator.OfLong it = reversedLong().iteratorLong();
            long e = it.nextLong();
            it.remove();
            return e;
        }
        /**
         * Overridden to specialize return type.
         * @return the reverse-order view of this collection
         * @see SequencedCollection#reversed()
         */
        PrimitiveSequencedCollection.OfLong reversedLong();
        @Override
        default SequencedCollection<java.lang.Long> reversed() { return reversedLong(); }
    }
    /**
     * A {@link PrimitiveSequencedCollection} of {@code int} values.
     */
    interface OfInt extends PrimitiveSequencedCollection<java.lang.Integer, PrimitiveConsumer.OfInt>, PrimitiveCollection.OfInt {
        /**
         * The {@code int} specialization of {@link #addFirst(Object)}
         * @param e the element to be added to the head this collection
         */
        default void addFirstInt(int e) { throw new UnsupportedOperationException(); }
        @Override
        default void addFirst(java.lang.Integer e) { addFirstInt(e); }
        /**
         * The {@code int} specialization of {@link #addLast(Object)}
         * @param e the element to be added to the tail of this collection
         */
        default void addLastInt(int e) { throw new UnsupportedOperationException(); }
        @Override
        default void addLast(java.lang.Integer e) { addLast(e); }
        /**
         * The {@code int} specialization of {@link #getFirst(Object)}
         * @return the element at the head of this collection
         */
        default int getFirstInt() { return iteratorInt().nextInt(); }
        @Override
        default java.lang.Integer getFirst() { return getFirstInt(); }
        /**
         * The {@code int} specialization of {@link #getLast(Object)}
         * @return the element at the tail of this collection
         */
        default int getLastInt() { return reversedInt().iteratorInt().nextInt(); }
        @Override
        default java.lang.Integer getLast() { return getLastInt(); }
        /**
         * The {@code int} specialization of {@link #removeFirst(Object)}
         * @return the removed element
         */
        default int removeFirstInt() {
            PrimitiveIterator.OfInt it = iteratorInt();
            int e = it.nextInt();
            it.remove();
            return e;
        }
        @Override
        default java.lang.Integer removeFirst() { return removeFirstInt(); }
        @Override
        default java.lang.Integer removeLast() { return removeLastInt(); }
        /**
         * The {@code int} specialization of {@link #removeLast(Object)}
         * @return the removed element
         */
        default int removeLastInt() {
            PrimitiveIterator.OfInt it = reversedInt().iteratorInt();
            int e = it.nextInt();
            it.remove();
            return e;
        }
        /**
         * Overridden to specialize return type.
         * @return the reverse-order view of this collection
         * @see SequencedCollection#reversed()
         */
        PrimitiveSequencedCollection.OfInt reversedInt();
        @Override
        default SequencedCollection<java.lang.Integer> reversed() { return reversedInt(); }
    }
    /**
     * A {@link PrimitiveSequencedCollection} of {@code float} values.
     */
    interface OfFloat extends PrimitiveSequencedCollection<java.lang.Float, PrimitiveConsumer.OfFloat>, PrimitiveCollection.OfFloat {
        /**
         * The {@code float} specialization of {@link #addFirst(Object)}
         * @param e the element to be added to the head this collection
         */
        default void addFirstFloat(float e) { throw new UnsupportedOperationException(); }
        @Override
        default void addFirst(java.lang.Float e) { addFirstFloat(e); }
        /**
         * The {@code float} specialization of {@link #addLast(Object)}
         * @param e the element to be added to the tail of this collection
         */
        default void addLastFloat(float e) { throw new UnsupportedOperationException(); }
        @Override
        default void addLast(java.lang.Float e) { addLast(e); }
        /**
         * The {@code float} specialization of {@link #getFirst(Object)}
         * @return the element at the head of this collection
         */
        default float getFirstFloat() { return iteratorFloat().nextFloat(); }
        @Override
        default java.lang.Float getFirst() { return getFirstFloat(); }
        /**
         * The {@code float} specialization of {@link #getLast(Object)}
         * @return the element at the tail of this collection
         */
        default float getLastFloat() { return reversedFloat().iteratorFloat().nextFloat(); }
        @Override
        default java.lang.Float getLast() { return getLastFloat(); }
        /**
         * The {@code float} specialization of {@link #removeFirst(Object)}
         * @return the removed element
         */
        default float removeFirstFloat() {
            PrimitiveIterator.OfFloat it = iteratorFloat();
            float e = it.nextFloat();
            it.remove();
            return e;
        }
        @Override
        default java.lang.Float removeFirst() { return removeFirstFloat(); }
        @Override
        default java.lang.Float removeLast() { return removeLastFloat(); }
        /**
         * The {@code float} specialization of {@link #removeLast(Object)}
         * @return the removed element
         */
        default float removeLastFloat() {
            PrimitiveIterator.OfFloat it = reversedFloat().iteratorFloat();
            float e = it.nextFloat();
            it.remove();
            return e;
        }
        /**
         * Overridden to specialize return type.
         * @return the reverse-order view of this collection
         * @see SequencedCollection#reversed()
         */
        PrimitiveSequencedCollection.OfFloat reversedFloat();
        @Override
        default SequencedCollection<java.lang.Float> reversed() { return reversedFloat(); }
    }
    /**
     * A {@link PrimitiveSequencedCollection} of {@code char} values.
     */
    interface OfChar extends PrimitiveSequencedCollection<java.lang.Character, PrimitiveConsumer.OfChar>, PrimitiveCollection.OfChar {
        /**
         * The {@code char} specialization of {@link #addFirst(Object)}
         * @param e the element to be added to the head this collection
         */
        default void addFirstChar(char e) { throw new UnsupportedOperationException(); }
        @Override
        default void addFirst(java.lang.Character e) { addFirstChar(e); }
        /**
         * The {@code char} specialization of {@link #addLast(Object)}
         * @param e the element to be added to the tail of this collection
         */
        default void addLastChar(char e) { throw new UnsupportedOperationException(); }
        @Override
        default void addLast(java.lang.Character e) { addLast(e); }
        /**
         * The {@code char} specialization of {@link #getFirst(Object)}
         * @return the element at the head of this collection
         */
        default char getFirstChar() { return iteratorChar().nextChar(); }
        @Override
        default java.lang.Character getFirst() { return getFirstChar(); }
        /**
         * The {@code char} specialization of {@link #getLast(Object)}
         * @return the element at the tail of this collection
         */
        default char getLastChar() { return reversedChar().iteratorChar().nextChar(); }
        @Override
        default java.lang.Character getLast() { return getLastChar(); }
        /**
         * The {@code char} specialization of {@link #removeFirst(Object)}
         * @return the removed element
         */
        default char removeFirstChar() {
            PrimitiveIterator.OfChar it = iteratorChar();
            char e = it.nextChar();
            it.remove();
            return e;
        }
        @Override
        default java.lang.Character removeFirst() { return removeFirstChar(); }
        @Override
        default java.lang.Character removeLast() { return removeLastChar(); }
        /**
         * The {@code char} specialization of {@link #removeLast(Object)}
         * @return the removed element
         */
        default char removeLastChar() {
            PrimitiveIterator.OfChar it = reversedChar().iteratorChar();
            char e = it.nextChar();
            it.remove();
            return e;
        }
        /**
         * Overridden to specialize return type.
         * @return the reverse-order view of this collection
         * @see SequencedCollection#reversed()
         */
        PrimitiveSequencedCollection.OfChar reversedChar();
        @Override
        default SequencedCollection<java.lang.Character> reversed() { return reversedChar(); }
    }
    /**
     * A {@link PrimitiveSequencedCollection} of {@code short} values.
     */
    interface OfShort extends PrimitiveSequencedCollection<java.lang.Short, PrimitiveConsumer.OfShort>, PrimitiveCollection.OfShort {
        /**
         * The {@code short} specialization of {@link #addFirst(Object)}
         * @param e the element to be added to the head this collection
         */
        default void addFirstShort(short e) { throw new UnsupportedOperationException(); }
        @Override
        default void addFirst(java.lang.Short e) { addFirstShort(e); }
        /**
         * The {@code short} specialization of {@link #addLast(Object)}
         * @param e the element to be added to the tail of this collection
         */
        default void addLastShort(short e) { throw new UnsupportedOperationException(); }
        @Override
        default void addLast(java.lang.Short e) { addLast(e); }
        /**
         * The {@code short} specialization of {@link #getFirst(Object)}
         * @return the element at the head of this collection
         */
        default short getFirstShort() { return iteratorShort().nextShort(); }
        @Override
        default java.lang.Short getFirst() { return getFirstShort(); }
        /**
         * The {@code short} specialization of {@link #getLast(Object)}
         * @return the element at the tail of this collection
         */
        default short getLastShort() { return reversedShort().iteratorShort().nextShort(); }
        @Override
        default java.lang.Short getLast() { return getLastShort(); }
        /**
         * The {@code short} specialization of {@link #removeFirst(Object)}
         * @return the removed element
         */
        default short removeFirstShort() {
            PrimitiveIterator.OfShort it = iteratorShort();
            short e = it.nextShort();
            it.remove();
            return e;
        }
        @Override
        default java.lang.Short removeFirst() { return removeFirstShort(); }
        @Override
        default java.lang.Short removeLast() { return removeLastShort(); }
        /**
         * The {@code short} specialization of {@link #removeLast(Object)}
         * @return the removed element
         */
        default short removeLastShort() {
            PrimitiveIterator.OfShort it = reversedShort().iteratorShort();
            short e = it.nextShort();
            it.remove();
            return e;
        }
        /**
         * Overridden to specialize return type.
         * @return the reverse-order view of this collection
         * @see SequencedCollection#reversed()
         */
        PrimitiveSequencedCollection.OfShort reversedShort();
        @Override
        default SequencedCollection<java.lang.Short> reversed() { return reversedShort(); }
    }
    /**
     * A {@link PrimitiveSequencedCollection} of {@code byte} values.
     */
    interface OfByte extends PrimitiveSequencedCollection<java.lang.Byte, PrimitiveConsumer.OfByte>, PrimitiveCollection.OfByte {
        /**
         * The {@code byte} specialization of {@link #addFirst(Object)}
         * @param e the element to be added to the head this collection
         */
        default void addFirstByte(byte e) { throw new UnsupportedOperationException(); }
        @Override
        default void addFirst(java.lang.Byte e) { addFirstByte(e); }
        /**
         * The {@code byte} specialization of {@link #addLast(Object)}
         * @param e the element to be added to the tail of this collection
         */
        default void addLastByte(byte e) { throw new UnsupportedOperationException(); }
        @Override
        default void addLast(java.lang.Byte e) { addLast(e); }
        /**
         * The {@code byte} specialization of {@link #getFirst(Object)}
         * @return the element at the head of this collection
         */
        default byte getFirstByte() { return iteratorByte().nextByte(); }
        @Override
        default java.lang.Byte getFirst() { return getFirstByte(); }
        /**
         * The {@code byte} specialization of {@link #getLast(Object)}
         * @return the element at the tail of this collection
         */
        default byte getLastByte() { return reversedByte().iteratorByte().nextByte(); }
        @Override
        default java.lang.Byte getLast() { return getLastByte(); }
        /**
         * The {@code byte} specialization of {@link #removeFirst(Object)}
         * @return the removed element
         */
        default byte removeFirstByte() {
            PrimitiveIterator.OfByte it = iteratorByte();
            byte e = it.nextByte();
            it.remove();
            return e;
        }
        @Override
        default java.lang.Byte removeFirst() { return removeFirstByte(); }
        @Override
        default java.lang.Byte removeLast() { return removeLastByte(); }
        /**
         * The {@code byte} specialization of {@link #removeLast(Object)}
         * @return the removed element
         */
        default byte removeLastByte() {
            PrimitiveIterator.OfByte it = reversedByte().iteratorByte();
            byte e = it.nextByte();
            it.remove();
            return e;
        }
        /**
         * Overridden to specialize return type.
         * @return the reverse-order view of this collection
         * @see SequencedCollection#reversed()
         */
        PrimitiveSequencedCollection.OfByte reversedByte();
        @Override
        default SequencedCollection<java.lang.Byte> reversed() { return reversedByte(); }
    }
    /**
     * A {@link PrimitiveSequencedCollection} of {@code boolean} values.
     */
    interface OfBoolean extends PrimitiveSequencedCollection<java.lang.Boolean, PrimitiveConsumer.OfBoolean>, PrimitiveCollection.OfBoolean {
        /**
         * The {@code boolean} specialization of {@link #addFirst(Object)}
         * @param e the element to be added to the head this collection
         */
        default void addFirstBoolean(boolean e) { throw new UnsupportedOperationException(); }
        @Override
        default void addFirst(java.lang.Boolean e) { addFirstBoolean(e); }
        /**
         * The {@code boolean} specialization of {@link #addLast(Object)}
         * @param e the element to be added to the tail of this collection
         */
        default void addLastBoolean(boolean e) { throw new UnsupportedOperationException(); }
        @Override
        default void addLast(java.lang.Boolean e) { addLast(e); }
        /**
         * The {@code boolean} specialization of {@link #getFirst(Object)}
         * @return the element at the head of this collection
         */
        default boolean getFirstBoolean() { return iteratorBoolean().nextBoolean(); }
        @Override
        default java.lang.Boolean getFirst() { return getFirstBoolean(); }
        /**
         * The {@code boolean} specialization of {@link #getLast(Object)}
         * @return the element at the tail of this collection
         */
        default boolean getLastBoolean() { return reversedBoolean().iteratorBoolean().nextBoolean(); }
        @Override
        default java.lang.Boolean getLast() { return getLastBoolean(); }
        /**
         * The {@code boolean} specialization of {@link #removeFirst(Object)}
         * @return the removed element
         */
        default boolean removeFirstBoolean() {
            PrimitiveIterator.OfBoolean it = iteratorBoolean();
            boolean e = it.nextBoolean();
            it.remove();
            return e;
        }
        @Override
        default java.lang.Boolean removeFirst() { return removeFirstBoolean(); }
        @Override
        default java.lang.Boolean removeLast() { return removeLastBoolean(); }
        /**
         * The {@code boolean} specialization of {@link #removeLast(Object)}
         * @return the removed element
         */
        default boolean removeLastBoolean() {
            PrimitiveIterator.OfBoolean it = reversedBoolean().iteratorBoolean();
            boolean e = it.nextBoolean();
            it.remove();
            return e;
        }
        /**
         * Overridden to specialize return type.
         * @return the reverse-order view of this collection
         * @see SequencedCollection#reversed()
         */
        PrimitiveSequencedCollection.OfBoolean reversedBoolean();
        @Override
        default SequencedCollection<java.lang.Boolean> reversed() { return reversedBoolean(); }
    }
}
