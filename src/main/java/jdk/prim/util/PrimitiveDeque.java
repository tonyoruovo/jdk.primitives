package jdk.prim.util;

import java.util.Deque;

import jdk.prim.util.function.PrimitiveConsumer;

public interface PrimitiveDeque<E, E_CONS> extends PrimitiveQueue<E, E_CONS>, Deque<E> {
    interface OfDouble extends PrimitiveDeque<java.lang.Double, PrimitiveConsumer.OfDouble>, PrimitiveQueue.OfDouble, PrimitiveSequencedCollection.OfDouble {
        @Override default boolean add(java.lang.Double e) { return this.addDouble(e); }
        @Override default void addFirst(java.lang.Double e) { this.addFirstDouble(e); }
        @Override default void addLast(java.lang.Double e) { this.addLastDouble(e); }
        @Override default java.lang.Double element() { return this.elementDouble(); }
        @Override default Deque<java.lang.Double> reversed() { return this.reversedDouble(); }
    }
    interface OfLong extends PrimitiveDeque<java.lang.Long, PrimitiveConsumer.OfLong>, PrimitiveQueue.OfLong, PrimitiveSequencedCollection.OfLong {
        @Override default boolean add(java.lang.Long e) { return this.addLong(e); }
        @Override default void addFirst(java.lang.Long e) { this.addFirstLong(e); }
        @Override default void addLast(java.lang.Long e) { this.addLastLong(e); }
        @Override default java.lang.Long element() { return this.elementLong(); }
        @Override default Deque<java.lang.Long> reversed() { return this.reversedLong(); }
    }
    interface OfInt extends PrimitiveDeque<java.lang.Integer, PrimitiveConsumer.OfInt>, PrimitiveQueue.OfInt, PrimitiveSequencedCollection.OfInt {
        @Override default boolean add(java.lang.Integer e) { return this.addInt(e); }
        @Override default void addFirst(java.lang.Integer e) { this.addFirstInt(e); }
        @Override default void addLast(java.lang.Integer e) { this.addLastInt(e); }
        @Override default java.lang.Integer element() { return this.elementInt(); }
        @Override default Deque<java.lang.Integer> reversed() { return this.reversedInt(); }
    }
    interface OfFloat extends PrimitiveDeque<java.lang.Float, PrimitiveConsumer.OfFloat>, PrimitiveQueue.OfFloat, PrimitiveSequencedCollection.OfFloat {
        @Override default boolean add(java.lang.Float e) { return this.addFloat(e); }
        @Override default void addFirst(java.lang.Float e) { this.addFirstFloat(e); }
        @Override default void addLast(java.lang.Float e) { this.addLastFloat(e); }
        @Override default java.lang.Float element() { return this.elementFloat(); }
        @Override default Deque<java.lang.Float> reversed() { return this.reversedFloat(); }
    }
    interface OfChar extends PrimitiveDeque<java.lang.Character, PrimitiveConsumer.OfChar>, PrimitiveQueue.OfChar, PrimitiveSequencedCollection.OfChar {
        @Override default boolean add(java.lang.Character e) { return this.addChar(e); }
        @Override default void addFirst(java.lang.Character e) { this.addFirstChar(e); }
        @Override default void addLast(java.lang.Character e) { this.addLastChar(e); }
        @Override default java.lang.Character element() { return this.elementChar(); }
        @Override default Deque<java.lang.Character> reversed() { return this.reversedChar(); }
    }
    interface OfShort extends PrimitiveDeque<java.lang.Short, PrimitiveConsumer.OfShort>, PrimitiveQueue.OfShort, PrimitiveSequencedCollection.OfShort {
        @Override default boolean add(java.lang.Short e) { return this.addShort(e); }
        @Override default void addFirst(java.lang.Short e) { this.addFirstShort(e); }
        @Override default void addLast(java.lang.Short e) { this.addLastShort(e); }
        @Override default java.lang.Short element() { return this.elementShort(); }
        @Override default Deque<java.lang.Short> reversed() { return this.reversedShort(); }
    }
    interface OfByte extends PrimitiveDeque<java.lang.Byte, PrimitiveConsumer.OfByte>, PrimitiveQueue.OfByte, PrimitiveSequencedCollection.OfByte {
        @Override default boolean add(java.lang.Byte e) { return this.addByte(e); }
        @Override default void addFirst(java.lang.Byte e) { this.addFirstByte(e); }
        @Override default void addLast(java.lang.Byte e) { this.addLastByte(e); }
        @Override default java.lang.Byte element() { return this.elementByte(); }
        @Override default Deque<java.lang.Byte> reversed() { return this.reversedByte(); }
    }
    interface OfBoolean extends PrimitiveDeque<java.lang.Boolean, PrimitiveConsumer.OfBoolean>, PrimitiveQueue.OfBoolean, PrimitiveSequencedCollection.OfBoolean {
        @Override default boolean add(java.lang.Boolean e) { return this.addBoolean(e); }
        @Override default void addFirst(java.lang.Boolean e) { this.addFirstBoolean(e); }
        @Override default void addLast(java.lang.Boolean e) { this.addLastBoolean(e); }
        @Override default java.lang.Boolean element() { return this.elementBoolean(); }
        @Override default Deque<java.lang.Boolean> reversed() { return this.reversedBoolean(); }
    }
}
