package jdk.prim.util;

import java.util.Deque;
import java.util.Iterator;

import jdk.prim.util.function.PrimitiveConsumer;

public interface PrimitiveDeque<E, E_CONS> extends PrimitiveQueue<E, E_CONS>, Deque<E> {
    interface OfDouble extends PrimitiveDeque<java.lang.Double, PrimitiveConsumer.OfDouble>, PrimitiveQueue.OfDouble, PrimitiveSequencedCollection.OfDouble {
        @Override default boolean add(java.lang.Double e) { return this.addDouble(e); }
        @Override default void addFirst(java.lang.Double e) { this.addFirstDouble(e); }
        @Override default void addLast(java.lang.Double e) { this.addLastDouble(e); }
        @Override default boolean contains(Object e) { return PrimitiveCollection.OfDouble.super.contains(e); }
        @Override default java.lang.Double element() { return this.elementDouble(); }
        @Override default java.lang.Double getFirst() { this.getFirstDouble(); }
        @Override default java.lang.Double getLast() { this.getLastDouble(); }
        @Override default boolean offer(java.lang.Double e) { return this.offerDouble(e); }
        @Override default java.lang.Double peek() { return this.peekDouble(); }
        @Override default java.lang.Double poll() { return this.pollDouble(); }
        @Override default java.lang.Double removeFirst() { this.removeFirstDouble(); }
        @Override default java.lang.Double removeLast() { this.removeLastDouble(); }
        @Override default Deque<java.lang.Double> reversed() { return this.reversedDouble(); }
        @Override default Iterator<java.lang.Double> iterator() { return this.iteratorDouble(); }

        @Override PrimitiveDeque.OfDouble reversedDouble();
    }
    interface OfLong extends PrimitiveDeque<java.lang.Long, PrimitiveConsumer.OfLong>, PrimitiveQueue.OfLong, PrimitiveSequencedCollection.OfLong {
        @Override default boolean add(java.lang.Long e) { return this.addLong(e); }
        @Override default void addFirst(java.lang.Long e) { this.addFirstLong(e); }
        @Override default void addLast(java.lang.Long e) { this.addLastLong(e); }
        @Override default boolean contains(Object e) { return PrimitiveCollection.OfLong.super.contains(e); }
        @Override default java.lang.Long element() { return this.elementLong(); }
        @Override default java.lang.Long getFirst() { this.getFirstLong(); }
        @Override default java.lang.Long getLast() { this.getLastLong(); }
        @Override default boolean offer(java.lang.Long e) { return this.offerLong(e); }
        @Override default java.lang.Long peek() { return this.peekLong(); }
        @Override default java.lang.Long poll() { return this.pollLong(); }
        @Override default java.lang.Long removeFirst() { this.removeFirstLong(); }
        @Override default java.lang.Long removeLast() { this.removeLastLong(); }
        @Override default Deque<java.lang.Long> reversed() { return this.reversedLong(); }
        @Override default Iterator<java.lang.Long> iterator() { return this.iteratorLong(); }

        @Override PrimitiveDeque.OfLong reversedLong();
    }
    interface OfInt extends PrimitiveDeque<java.lang.Integer, PrimitiveConsumer.OfInt>, PrimitiveQueue.OfInt, PrimitiveSequencedCollection.OfInt {
        @Override default boolean add(java.lang.Integer e) { return this.addInt(e); }
        @Override default void addFirst(java.lang.Integer e) { this.addFirstInt(e); }
        @Override default void addLast(java.lang.Integer e) { this.addLastInt(e); }
        @Override default boolean contains(Object e) { return PrimitiveCollection.OfInt.super.contains(e); }
        @Override default java.lang.Integer element() { return this.elementInt(); }
        @Override default java.lang.Integer getFirst() { this.getFirstInt(); }
        @Override default java.lang.Integer getLast() { this.getLastInt(); }
        @Override default boolean offer(java.lang.Integer e) { return this.offerInt(e); }
        @Override default java.lang.Integer peek() { return this.peekInt(); }
        @Override default java.lang.Integer poll() { return this.pollInt(); }
        @Override default java.lang.Integer removeFirst() { this.removeFirstInt(); }
        @Override default java.lang.Integer removeLast() { this.removeLastInt(); }
        @Override default Deque<java.lang.Integer> reversed() { return this.reversedInt(); }
        @Override default Iterator<java.lang.Integer> iterator() { return this.iteratorInt(); }

        @Override PrimitiveDeque.OfInt reversedInt();
    }
    interface OfFloat extends PrimitiveDeque<java.lang.Float, PrimitiveConsumer.OfFloat>, PrimitiveQueue.OfFloat, PrimitiveSequencedCollection.OfFloat {
        @Override default boolean add(java.lang.Float e) { return this.addFloat(e); }
        @Override default void addFirst(java.lang.Float e) { this.addFirstFloat(e); }
        @Override default void addLast(java.lang.Float e) { this.addLastFloat(e); }
        @Override default boolean contains(Object e) { return PrimitiveCollection.OfFloat.super.contains(e); }
        @Override default java.lang.Float element() { return this.elementFloat(); }
        @Override default java.lang.Float getFirst() { this.getFirstFloat(); }
        @Override default java.lang.Float getLast() { this.getLastFloat(); }
        @Override default boolean offer(java.lang.Float e) { return this.offerFloat(e); }
        @Override default java.lang.Float peek() { return this.peekFloat(); }
        @Override default java.lang.Float poll() { return this.pollFloat(); }
        @Override default java.lang.Float removeFirst() { this.removeFirstFloat(); }
        @Override default java.lang.Float removeLast() { this.removeLastFloat(); }
        @Override default Deque<java.lang.Float> reversed() { return this.reversedFloat(); }
        @Override default Iterator<java.lang.Float> iterator() { return this.iteratorFloat(); }

        @Override PrimitiveDeque.OfFloat reversedFloat();
    }
    interface OfChar extends PrimitiveDeque<java.lang.Character, PrimitiveConsumer.OfChar>, PrimitiveQueue.OfChar, PrimitiveSequencedCollection.OfChar {
        @Override default boolean add(java.lang.Character e) { return this.addChar(e); }
        @Override default void addFirst(java.lang.Character e) { this.addFirstChar(e); }
        @Override default void addLast(java.lang.Character e) { this.addLastChar(e); }
        @Override default boolean contains(Object e) { return PrimitiveCollection.OfChar.super.contains(e); }
        @Override default java.lang.Character element() { return this.elementChar(); }
        @Override default java.lang.Character getFirst() { this.getFirstChar(); }
        @Override default java.lang.Character getLast() { this.getLastChar(); }
        @Override default boolean offer(java.lang.Character e) { return this.offerChar(e); }
        @Override default java.lang.Character peek() { return this.peekChar(); }
        @Override default java.lang.Character poll() { return this.pollChar(); }
        @Override default java.lang.Character removeFirst() { this.removeFirstChar(); }
        @Override default java.lang.Character removeLast() { this.removeLastChar(); }
        @Override default Deque<java.lang.Character> reversed() { return this.reversedChar(); }
        @Override default Iterator<java.lang.Character> iterator() { return this.iteratorChar(); }

        @Override PrimitiveDeque.OfChar reversedChar();
    }
    interface OfShort extends PrimitiveDeque<java.lang.Short, PrimitiveConsumer.OfShort>, PrimitiveQueue.OfShort, PrimitiveSequencedCollection.OfShort {
        @Override default boolean add(java.lang.Short e) { return this.addShort(e); }
        @Override default void addFirst(java.lang.Short e) { this.addFirstShort(e); }
        @Override default void addLast(java.lang.Short e) { this.addLastShort(e); }
        @Override default boolean contains(Object e) { return PrimitiveCollection.OfShort.super.contains(e); }
        @Override default java.lang.Short element() { return this.elementShort(); }
        @Override default java.lang.Short getFirst() { this.getFirstShort(); }
        @Override default java.lang.Short getLast() { this.getLastShort(); }
        @Override default boolean offer(java.lang.Short e) { return this.offerShort(e); }
        @Override default java.lang.Short peek() { return this.peekShort(); }
        @Override default java.lang.Short poll() { return this.pollShort(); }
        @Override default java.lang.Short removeFirst() { this.removeFirstShort(); }
        @Override default java.lang.Short removeLast() { this.removeLastShort(); }
        @Override default Deque<java.lang.Short> reversed() { return this.reversedShort(); }
        @Override default Iterator<java.lang.Short> iterator() { return this.iteratorShort(); }

        @Override PrimitiveDeque.OfShort reversedShort();
    }
    interface OfByte extends PrimitiveDeque<java.lang.Byte, PrimitiveConsumer.OfByte>, PrimitiveQueue.OfByte, PrimitiveSequencedCollection.OfByte {
        @Override default boolean add(java.lang.Byte e) { return this.addByte(e); }
        @Override default void addFirst(java.lang.Byte e) { this.addFirstByte(e); }
        @Override default void addLast(java.lang.Byte e) { this.addLastByte(e); }
        @Override default boolean contains(Object e) { return PrimitiveCollection.OfByte.super.contains(e); }
        @Override default java.lang.Byte element() { return this.elementByte(); }
        @Override default java.lang.Byte getFirst() { this.getFirstByte(); }
        @Override default java.lang.Byte getLast() { this.getLastByte(); }
        @Override default boolean offer(java.lang.Byte e) { return this.offerByte(e); }
        @Override default java.lang.Byte peek() { return this.peekByte(); }
        @Override default java.lang.Byte poll() { return this.pollByte(); }
        @Override default java.lang.Byte removeFirst() { this.removeFirstByte(); }
        @Override default java.lang.Byte removeLast() { this.removeLastByte(); }
        @Override default Deque<java.lang.Byte> reversed() { return this.reversedByte(); }
        @Override default Iterator<java.lang.Byte> iterator() { return this.iteratorByte(); }

        @Override PrimitiveDeque.OfByte reversedByte();
    }
    interface OfBoolean extends PrimitiveDeque<java.lang.Boolean, PrimitiveConsumer.OfBoolean>, PrimitiveQueue.OfBoolean, PrimitiveSequencedCollection.OfBoolean {
        @Override default boolean add(java.lang.Boolean e) { return this.addBoolean(e); }
        @Override default void addFirst(java.lang.Boolean e) { this.addFirstBoolean(e); }
        @Override default void addLast(java.lang.Boolean e) { this.addLastBoolean(e); }
        @Override default boolean contains(Object e) { return PrimitiveCollection.OfBoolean.super.contains(e); }
        @Override default java.lang.Boolean element() { return this.elementBoolean(); }
        @Override default java.lang.Boolean getFirst() { this.getFirstBoolean(); }
        @Override default java.lang.Boolean getLast() { this.getLastBoolean(); }
        @Override default boolean offer(java.lang.Boolean e) { return this.offerBoolean(e); }
        @Override default java.lang.Boolean peek() { return this.peekBoolean(); }
        @Override default java.lang.Boolean poll() { return this.pollBoolean(); }
        @Override default java.lang.Boolean removeFirst() { this.removeFirstBoolean(); }
        @Override default java.lang.Boolean removeLast() { this.removeLastBoolean(); }
        @Override default Deque<java.lang.Boolean> reversed() { return this.reversedBoolean(); }
        @Override default Iterator<java.lang.Boolean> iterator() { return this.iteratorBoolean(); }

        @Override PrimitiveDeque.OfBoolean reversedBoolean();
    }
}
