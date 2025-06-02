package jdk.prim.util;

import java.util.Deque;
import java.util.Iterator;

import jdk.prim.util.function.PrimitiveConsumer;

public interface PrimitiveDeque<E, E_CONS> extends PrimitiveQueue<E, E_CONS>, Deque<E> {
    interface OfDouble extends PrimitiveDeque<java.lang.Double, PrimitiveConsumer.OfDouble>, PrimitiveQueue.OfDouble, PrimitiveSequencedCollection.OfDouble {

        //////////////// compile-time error prevention

        @Override default boolean add(java.lang.Double e) { return this.addDouble(e); }
        @Override default void addFirst(java.lang.Double e) { this.addFirstDouble(e); }
        @Override default void addLast(java.lang.Double e) { this.addLastDouble(e); }
        @Override default boolean contains(Object e) { return PrimitiveQueue.OfDouble.super.contains(e); }
        @Override default java.lang.Double element() { return this.elementDouble(); }
        @Override default java.lang.Double getFirst() { return this.getFirstDouble(); }
        @Override default java.lang.Double getLast() { return this.getLastDouble(); }
        @Override default boolean offer(java.lang.Double e) { return this.offerDouble(e); }
        @Override default java.lang.Double peek() { return this.peekDouble(); }
        @Override default java.lang.Double poll() { return this.pollDouble(); }
        @Override default java.lang.Double removeFirst() { return this.removeFirstDouble(); }
        @Override default java.lang.Double removeLast() { return this.removeLastDouble(); }
        @Override default Deque<java.lang.Double> reversed() { return this.reversedDouble(); }
        @Override default Iterator<java.lang.Double> iterator() { return this.iteratorDouble(); }
        
        ////////////////// java.util.Deque implementations
        
        @Override default Iterator<java.lang.Double> descendingIterator() { return this.descendingIteratorDouble(); }
        @Override default boolean offerFirst(java.lang.Double e) { return this.offerFirstDouble(e); }
        @Override default boolean offerLast(java.lang.Double e) { return this.offerLastDouble(e); }
        @Override default java.lang.Double peekFirst() { return this.peekFirstDouble(); }
        @Override default java.lang.Double peekLast() { return this.peekLastDouble(); }
        @Override default java.lang.Double pollFirst() { return this.pollFirstDouble(); }
        @Override default java.lang.Double pollLast() { return this.pollLastDouble(); }
        @Override default boolean removeFirstOccurrence(java.lang.Object e) { if(e instanceof java.lang.Double) return this.removeFirstOccurrenceDouble((java.lang.Double) e); throw new IllegalArgumentException("argument was expected to be java.lang.Double"); }
        @Override default boolean removeLastOccurrence(java.lang.Object e) { if(e instanceof java.lang.Double) return this.removeLastOccurrenceDouble((java.lang.Double) e); throw new IllegalArgumentException("argument was expected to be java.lang.Double"); }

        ///////////////// double declarations

        PrimitiveIterator.OfDouble descendingIteratorDouble();
        boolean offerFirstDouble(double e);
        boolean offerLastDouble(double e);
        double peekFirstDouble();
        double peekLastDouble();
        double pollFirstDouble();
        double pollLastDouble();
        boolean removeFirstOccurrenceDouble(double e);
        boolean removeLastOccurrenceDouble(double e);
        @Override PrimitiveDeque.OfDouble reversedDouble();
    }
    interface OfLong extends PrimitiveDeque<java.lang.Long, PrimitiveConsumer.OfLong>, PrimitiveQueue.OfLong, PrimitiveSequencedCollection.OfLong {

        //////////////// compile-time error prevention

        @Override default boolean add(java.lang.Long e) { return this.addLong(e); }
        @Override default void addFirst(java.lang.Long e) { this.addFirstLong(e); }
        @Override default void addLast(java.lang.Long e) { this.addLastLong(e); }
        @Override default boolean contains(Object e) { return PrimitiveQueue.OfLong.super.contains(e); }
        @Override default java.lang.Long element() { return this.elementLong(); }
        @Override default java.lang.Long getFirst() { return this.getFirstLong(); }
        @Override default java.lang.Long getLast() { return this.getLastLong(); }
        @Override default boolean offer(java.lang.Long e) { return this.offerLong(e); }
        @Override default java.lang.Long peek() { return this.peekLong(); }
        @Override default java.lang.Long poll() { return this.pollLong(); }
        @Override default java.lang.Long removeFirst() { return this.removeFirstLong(); }
        @Override default java.lang.Long removeLast() { return this.removeLastLong(); }
        @Override default Deque<java.lang.Long> reversed() { return this.reversedLong(); }
        @Override default Iterator<java.lang.Long> iterator() { return this.iteratorLong(); }
        
        ////////////////// java.util.Deque implementations
        
        @Override default Iterator<java.lang.Long> descendingIterator() { return this.descendingIteratorLong(); }
        @Override default boolean offerFirst(java.lang.Long e) { return this.offerFirstLong(e); }
        @Override default boolean offerLast(java.lang.Long e) { return this.offerLastLong(e); }
        @Override default java.lang.Long peekFirst() { return this.peekFirstLong(); }
        @Override default java.lang.Long peekLast() { return this.peekLastLong(); }
        @Override default java.lang.Long pollFirst() { return this.pollFirstLong(); }
        @Override default java.lang.Long pollLast() { return this.pollLastLong(); }
        @Override default boolean removeFirstOccurrence(java.lang.Object e) { if(e instanceof java.lang.Long) return this.removeFirstOccurrenceLong((java.lang.Long) e); throw new IllegalArgumentException("argument was expected to be java.lang.Long"); }
        @Override default boolean removeLastOccurrence(java.lang.Object e) { if(e instanceof java.lang.Long) return this.removeLastOccurrenceLong((java.lang.Long) e); throw new IllegalArgumentException("argument was expected to be java.lang.Long"); }

        ///////////////// long declarations

        PrimitiveIterator.OfLong descendingIteratorLong();
        boolean offerFirstLong(long e);
        boolean offerLastLong(long e);
        long peekFirstLong();
        long peekLastLong();
        long pollFirstLong();
        long pollLastLong();
        boolean removeFirstOccurrenceLong(long e);
        boolean removeLastOccurrenceLong(long e);
        @Override PrimitiveDeque.OfLong reversedLong();
    }
    interface OfInt extends PrimitiveDeque<java.lang.Integer, PrimitiveConsumer.OfInt>, PrimitiveQueue.OfInt, PrimitiveSequencedCollection.OfInt {

        //////////////// compile-time error prevention

        @Override default boolean add(java.lang.Integer e) { return this.addInt(e); }
        @Override default void addFirst(java.lang.Integer e) { this.addFirstInt(e); }
        @Override default void addLast(java.lang.Integer e) { this.addLastInt(e); }
        @Override default boolean contains(Object e) { return PrimitiveQueue.OfInt.super.contains(e); }
        @Override default java.lang.Integer element() { return this.elementInt(); }
        @Override default java.lang.Integer getFirst() { return this.getFirstInt(); }
        @Override default java.lang.Integer getLast() { return this.getLastInt(); }
        @Override default boolean offer(java.lang.Integer e) { return this.offerInt(e); }
        @Override default java.lang.Integer peek() { return this.peekInt(); }
        @Override default java.lang.Integer poll() { return this.pollInt(); }
        @Override default java.lang.Integer removeFirst() { return this.removeFirstInt(); }
        @Override default java.lang.Integer removeLast() { return this.removeLastInt(); }
        @Override default Deque<java.lang.Integer> reversed() { return this.reversedInt(); }
        @Override default Iterator<java.lang.Integer> iterator() { return this.iteratorInt(); }
        
        ////////////////// java.util.Deque implementations
        
        @Override default Iterator<java.lang.Integer> descendingIterator() { return this.descendingIteratorInt(); }
        @Override default boolean offerFirst(java.lang.Integer e) { return this.offerFirstInt(e); }
        @Override default boolean offerLast(java.lang.Integer e) { return this.offerLastInt(e); }
        @Override default java.lang.Integer peekFirst() { return this.peekFirstInt(); }
        @Override default java.lang.Integer peekLast() { return this.peekLastInt(); }
        @Override default java.lang.Integer pollFirst() { return this.pollFirstInt(); }
        @Override default java.lang.Integer pollLast() { return this.pollLastInt(); }
        @Override default boolean removeFirstOccurrence(java.lang.Object e) { if(e instanceof java.lang.Integer) return this.removeFirstOccurrenceInt((java.lang.Integer) e); throw new IllegalArgumentException("argument was expected to be java.lang.Integer"); }
        @Override default boolean removeLastOccurrence(java.lang.Object e) { if(e instanceof java.lang.Integer) return this.removeLastOccurrenceInt((java.lang.Integer) e); throw new IllegalArgumentException("argument was expected to be java.lang.Integer"); }

        ///////////////// int declarations

        PrimitiveIterator.OfInt descendingIteratorInt();
        boolean offerFirstInt(int e);
        boolean offerLastInt(int e);
        int peekFirstInt();
        int peekLastInt();
        int pollFirstInt();
        int pollLastInt();
        boolean removeFirstOccurrenceInt(int e);
        boolean removeLastOccurrenceInt(int e);
        @Override PrimitiveDeque.OfInt reversedInt();
    }
    interface OfFloat extends PrimitiveDeque<java.lang.Float, PrimitiveConsumer.OfFloat>, PrimitiveQueue.OfFloat, PrimitiveSequencedCollection.OfFloat {

        //////////////// compile-time error prevention

        @Override default boolean add(java.lang.Float e) { return this.addFloat(e); }
        @Override default void addFirst(java.lang.Float e) { this.addFirstFloat(e); }
        @Override default void addLast(java.lang.Float e) { this.addLastFloat(e); }
        @Override default boolean contains(Object e) { return PrimitiveQueue.OfFloat.super.contains(e); }
        @Override default java.lang.Float element() { return this.elementFloat(); }
        @Override default java.lang.Float getFirst() { return this.getFirstFloat(); }
        @Override default java.lang.Float getLast() { return this.getLastFloat(); }
        @Override default boolean offer(java.lang.Float e) { return this.offerFloat(e); }
        @Override default java.lang.Float peek() { return this.peekFloat(); }
        @Override default java.lang.Float poll() { return this.pollFloat(); }
        @Override default java.lang.Float removeFirst() { return this.removeFirstFloat(); }
        @Override default java.lang.Float removeLast() { return this.removeLastFloat(); }
        @Override default Deque<java.lang.Float> reversed() { return this.reversedFloat(); }
        @Override default Iterator<java.lang.Float> iterator() { return this.iteratorFloat(); }
        
        ////////////////// java.util.Deque implementations
        
        @Override default Iterator<java.lang.Float> descendingIterator() { return this.descendingIteratorFloat(); }
        @Override default boolean offerFirst(java.lang.Float e) { return this.offerFirstFloat(e); }
        @Override default boolean offerLast(java.lang.Float e) { return this.offerLastFloat(e); }
        @Override default java.lang.Float peekFirst() { return this.peekFirstFloat(); }
        @Override default java.lang.Float peekLast() { return this.peekLastFloat(); }
        @Override default java.lang.Float pollFirst() { return this.pollFirstFloat(); }
        @Override default java.lang.Float pollLast() { return this.pollLastFloat(); }
        @Override default boolean removeFirstOccurrence(java.lang.Object e) { if(e instanceof java.lang.Float) return this.removeFirstOccurrenceFloat((java.lang.Float) e); throw new IllegalArgumentException("argument was expected to be java.lang.Float"); }
        @Override default boolean removeLastOccurrence(java.lang.Object e) { if(e instanceof java.lang.Float) return this.removeLastOccurrenceFloat((java.lang.Float) e); throw new IllegalArgumentException("argument was expected to be java.lang.Float"); }

        ///////////////// float declarations

        PrimitiveIterator.OfFloat descendingIteratorFloat();
        boolean offerFirstFloat(float e);
        boolean offerLastFloat(float e);
        float peekFirstFloat();
        float peekLastFloat();
        float pollFirstFloat();
        float pollLastFloat();
        boolean removeFirstOccurrenceFloat(float e);
        boolean removeLastOccurrenceFloat(float e);
        @Override PrimitiveDeque.OfFloat reversedFloat();
    }
    interface OfChar extends PrimitiveDeque<java.lang.Character, PrimitiveConsumer.OfChar>, PrimitiveQueue.OfChar, PrimitiveSequencedCollection.OfChar {

        //////////////// compile-time error prevention

        @Override default boolean add(java.lang.Character e) { return this.addChar(e); }
        @Override default void addFirst(java.lang.Character e) { this.addFirstChar(e); }
        @Override default void addLast(java.lang.Character e) { this.addLastChar(e); }
        @Override default boolean contains(Object e) { return PrimitiveQueue.OfChar.super.contains(e); }
        @Override default java.lang.Character element() { return this.elementChar(); }
        @Override default java.lang.Character getFirst() { return this.getFirstChar(); }
        @Override default java.lang.Character getLast() { return this.getLastChar(); }
        @Override default boolean offer(java.lang.Character e) { return this.offerChar(e); }
        @Override default java.lang.Character peek() { return this.peekChar(); }
        @Override default java.lang.Character poll() { return this.pollChar(); }
        @Override default java.lang.Character removeFirst() { return this.removeFirstChar(); }
        @Override default java.lang.Character removeLast() { return this.removeLastChar(); }
        @Override default Deque<java.lang.Character> reversed() { return this.reversedChar(); }
        @Override default Iterator<java.lang.Character> iterator() { return this.iteratorChar(); }
        
        ////////////////// java.util.Deque implementations
        
        @Override default Iterator<java.lang.Character> descendingIterator() { return this.descendingIteratorChar(); }
        @Override default boolean offerFirst(java.lang.Character e) { return this.offerFirstChar(e); }
        @Override default boolean offerLast(java.lang.Character e) { return this.offerLastChar(e); }
        @Override default java.lang.Character peekFirst() { return this.peekFirstChar(); }
        @Override default java.lang.Character peekLast() { return this.peekLastChar(); }
        @Override default java.lang.Character pollFirst() { return this.pollFirstChar(); }
        @Override default java.lang.Character pollLast() { return this.pollLastChar(); }
        @Override default boolean removeFirstOccurrence(java.lang.Object e) { if(e instanceof java.lang.Character) return this.removeFirstOccurrenceChar((java.lang.Character) e); throw new IllegalArgumentException("argument was expected to be java.lang.Character"); }
        @Override default boolean removeLastOccurrence(java.lang.Object e) { if(e instanceof java.lang.Character) return this.removeLastOccurrenceChar((java.lang.Character) e); throw new IllegalArgumentException("argument was expected to be java.lang.Character"); }

        ///////////////// char declarations

        PrimitiveIterator.OfChar descendingIteratorChar();
        boolean offerFirstChar(char e);
        boolean offerLastChar(char e);
        char peekFirstChar();
        char peekLastChar();
        char pollFirstChar();
        char pollLastChar();
        boolean removeFirstOccurrenceChar(char e);
        boolean removeLastOccurrenceChar(char e);
        @Override PrimitiveDeque.OfChar reversedChar();
    }
    interface OfShort extends PrimitiveDeque<java.lang.Short, PrimitiveConsumer.OfShort>, PrimitiveQueue.OfShort, PrimitiveSequencedCollection.OfShort {

        //////////////// compile-time error prevention

        @Override default boolean add(java.lang.Short e) { return this.addShort(e); }
        @Override default void addFirst(java.lang.Short e) { this.addFirstShort(e); }
        @Override default void addLast(java.lang.Short e) { this.addLastShort(e); }
        @Override default boolean contains(Object e) { return PrimitiveQueue.OfShort.super.contains(e); }
        @Override default java.lang.Short element() { return this.elementShort(); }
        @Override default java.lang.Short getFirst() { return this.getFirstShort(); }
        @Override default java.lang.Short getLast() { return this.getLastShort(); }
        @Override default boolean offer(java.lang.Short e) { return this.offerShort(e); }
        @Override default java.lang.Short peek() { return this.peekShort(); }
        @Override default java.lang.Short poll() { return this.pollShort(); }
        @Override default java.lang.Short removeFirst() { return this.removeFirstShort(); }
        @Override default java.lang.Short removeLast() { return this.removeLastShort(); }
        @Override default Deque<java.lang.Short> reversed() { return this.reversedShort(); }
        @Override default Iterator<java.lang.Short> iterator() { return this.iteratorShort(); }
        
        ////////////////// java.util.Deque implementations
        
        @Override default Iterator<java.lang.Short> descendingIterator() { return this.descendingIteratorShort(); }
        @Override default boolean offerFirst(java.lang.Short e) { return this.offerFirstShort(e); }
        @Override default boolean offerLast(java.lang.Short e) { return this.offerLastShort(e); }
        @Override default java.lang.Short peekFirst() { return this.peekFirstShort(); }
        @Override default java.lang.Short peekLast() { return this.peekLastShort(); }
        @Override default java.lang.Short pollFirst() { return this.pollFirstShort(); }
        @Override default java.lang.Short pollLast() { return this.pollLastShort(); }
        @Override default boolean removeFirstOccurrence(java.lang.Object e) { if(e instanceof java.lang.Short) return this.removeFirstOccurrenceShort((java.lang.Short) e); throw new IllegalArgumentException("argument was expected to be java.lang.Short"); }
        @Override default boolean removeLastOccurrence(java.lang.Object e) { if(e instanceof java.lang.Short) return this.removeLastOccurrenceShort((java.lang.Short) e); throw new IllegalArgumentException("argument was expected to be java.lang.Short"); }

        ///////////////// short declarations

        PrimitiveIterator.OfShort descendingIteratorShort();
        boolean offerFirstShort(short e);
        boolean offerLastShort(short e);
        short peekFirstShort();
        short peekLastShort();
        short pollFirstShort();
        short pollLastShort();
        boolean removeFirstOccurrenceShort(short e);
        boolean removeLastOccurrenceShort(short e);
        @Override PrimitiveDeque.OfShort reversedShort();
    }
    interface OfByte extends PrimitiveDeque<java.lang.Byte, PrimitiveConsumer.OfByte>, PrimitiveQueue.OfByte, PrimitiveSequencedCollection.OfByte {

        //////////////// compile-time error prevention

        @Override default boolean add(java.lang.Byte e) { return this.addByte(e); }
        @Override default void addFirst(java.lang.Byte e) { this.addFirstByte(e); }
        @Override default void addLast(java.lang.Byte e) { this.addLastByte(e); }
        @Override default boolean contains(Object e) { return PrimitiveQueue.OfByte.super.contains(e); }
        @Override default java.lang.Byte element() { return this.elementByte(); }
        @Override default java.lang.Byte getFirst() { return this.getFirstByte(); }
        @Override default java.lang.Byte getLast() { return this.getLastByte(); }
        @Override default boolean offer(java.lang.Byte e) { return this.offerByte(e); }
        @Override default java.lang.Byte peek() { return this.peekByte(); }
        @Override default java.lang.Byte poll() { return this.pollByte(); }
        @Override default java.lang.Byte removeFirst() { return this.removeFirstByte(); }
        @Override default java.lang.Byte removeLast() { return this.removeLastByte(); }
        @Override default Deque<java.lang.Byte> reversed() { return this.reversedByte(); }
        @Override default Iterator<java.lang.Byte> iterator() { return this.iteratorByte(); }
        
        ////////////////// java.util.Deque implementations
        
        @Override default Iterator<java.lang.Byte> descendingIterator() { return this.descendingIteratorByte(); }
        @Override default boolean offerFirst(java.lang.Byte e) { return this.offerFirstByte(e); }
        @Override default boolean offerLast(java.lang.Byte e) { return this.offerLastByte(e); }
        @Override default java.lang.Byte peekFirst() { return this.peekFirstByte(); }
        @Override default java.lang.Byte peekLast() { return this.peekLastByte(); }
        @Override default java.lang.Byte pollFirst() { return this.pollFirstByte(); }
        @Override default java.lang.Byte pollLast() { return this.pollLastByte(); }
        @Override default boolean removeFirstOccurrence(java.lang.Object e) { if(e instanceof java.lang.Byte) return this.removeFirstOccurrenceByte((java.lang.Byte) e); throw new IllegalArgumentException("argument was expected to be java.lang.Byte"); }
        @Override default boolean removeLastOccurrence(java.lang.Object e) { if(e instanceof java.lang.Byte) return this.removeLastOccurrenceByte((java.lang.Byte) e); throw new IllegalArgumentException("argument was expected to be java.lang.Byte"); }

        ///////////////// byte declarations

        PrimitiveIterator.OfByte descendingIteratorByte();
        boolean offerFirstByte(byte e);
        boolean offerLastByte(byte e);
        byte peekFirstByte();
        byte peekLastByte();
        byte pollFirstByte();
        byte pollLastByte();
        boolean removeFirstOccurrenceByte(byte e);
        boolean removeLastOccurrenceByte(byte e);
        @Override PrimitiveDeque.OfByte reversedByte();
    }
    interface OfBoolean extends PrimitiveDeque<java.lang.Boolean, PrimitiveConsumer.OfBoolean>, PrimitiveQueue.OfBoolean, PrimitiveSequencedCollection.OfBoolean {

        //////////////// compile-time error prevention

        @Override default boolean add(java.lang.Boolean e) { return this.addBoolean(e); }
        @Override default void addFirst(java.lang.Boolean e) { this.addFirstBoolean(e); }
        @Override default void addLast(java.lang.Boolean e) { this.addLastBoolean(e); }
        @Override default boolean contains(Object e) { return PrimitiveQueue.OfBoolean.super.contains(e); }
        @Override default java.lang.Boolean element() { return this.elementBoolean(); }
        @Override default java.lang.Boolean getFirst() { return this.getFirstBoolean(); }
        @Override default java.lang.Boolean getLast() { return this.getLastBoolean(); }
        @Override default boolean offer(java.lang.Boolean e) { return this.offerBoolean(e); }
        @Override default java.lang.Boolean peek() { return this.peekBoolean(); }
        @Override default java.lang.Boolean poll() { return this.pollBoolean(); }
        @Override default java.lang.Boolean removeFirst() { return this.removeFirstBoolean(); }
        @Override default java.lang.Boolean removeLast() { return this.removeLastBoolean(); }
        @Override default Deque<java.lang.Boolean> reversed() { return this.reversedBoolean(); }
        @Override default Iterator<java.lang.Boolean> iterator() { return this.iteratorBoolean(); }
        
        ////////////////// java.util.Deque implementations
        
        @Override default Iterator<java.lang.Boolean> descendingIterator() { return this.descendingIteratorBoolean(); }
        @Override default boolean offerFirst(java.lang.Boolean e) { return this.offerFirstBoolean(e); }
        @Override default boolean offerLast(java.lang.Boolean e) { return this.offerLastBoolean(e); }
        @Override default java.lang.Boolean peekFirst() { return this.peekFirstBoolean(); }
        @Override default java.lang.Boolean peekLast() { return this.peekLastBoolean(); }
        @Override default java.lang.Boolean pollFirst() { return this.pollFirstBoolean(); }
        @Override default java.lang.Boolean pollLast() { return this.pollLastBoolean(); }
        @Override default boolean removeFirstOccurrence(java.lang.Object e) { if(e instanceof java.lang.Boolean) return this.removeFirstOccurrenceBoolean((java.lang.Boolean) e); throw new IllegalArgumentException("argument was expected to be java.lang.Boolean"); }
        @Override default boolean removeLastOccurrence(java.lang.Object e) { if(e instanceof java.lang.Boolean) return this.removeLastOccurrenceBoolean((java.lang.Boolean) e); throw new IllegalArgumentException("argument was expected to be java.lang.Boolean"); }

        ///////////////// boolean declarations

        PrimitiveIterator.OfBoolean descendingIteratorBoolean();
        boolean offerFirstBoolean(boolean e);
        boolean offerLastBoolean(boolean e);
        boolean peekFirstBoolean();
        boolean peekLastBoolean();
        boolean pollFirstBoolean();
        boolean pollLastBoolean();
        boolean removeFirstOccurrenceBoolean(boolean e);
        boolean removeLastOccurrenceBoolean(boolean e);
        @Override PrimitiveDeque.OfBoolean reversedBoolean();
    }
}
