package jdk.prim.util;

import java.util.Queue;

import jdk.prim.util.function.PrimitiveConsumer;

public interface PrimitiveQueue<E, E_CONS> extends PrimitiveCollection<E, E_CONS>, Queue<E> {
    interface OfDouble extends PrimitiveQueue<java.lang.Double, PrimitiveConsumer.OfDouble>, PrimitiveCollection.OfDouble {
        @Override default boolean add(java.lang.Double e) { return this.addDouble(e); }
        @Override default java.lang.Double element() { return this.elementDouble(); }
        @Override default boolean offer(java.lang.Double e) { return this.offerDouble(e); }
        @Override default java.lang.Double peek() { return this.peekDouble(); }
        @Override default java.lang.Double poll() {  return this.pollDouble(); }

        /////////////// double equivalent

        double elementDouble();
        boolean offerDouble(double e);
        double peekDouble();
        double pollDouble();
    }
    interface OfLong extends PrimitiveQueue<java.lang.Long, PrimitiveConsumer.OfLong>, PrimitiveCollection.OfLong {
        @Override default boolean add(java.lang.Long e) { return this.addLong(e); }
        @Override default java.lang.Long element() { return this.elementLong(); }
        @Override default boolean offer(java.lang.Long e) { return this.offerLong(e); }
        @Override default java.lang.Long peek() { return this.peekLong(); }
        @Override default java.lang.Long poll() {  return this.pollLong(); }

        /////////////// long equivalent

        long elementLong();
        boolean offerLong(long e);
        long peekLong();
        long pollLong();
    }
    interface OfInt extends PrimitiveQueue<java.lang.Integer, PrimitiveConsumer.OfInt>, PrimitiveCollection.OfInt {
        @Override default boolean add(java.lang.Integer e) { return this.addInt(e); }
        @Override default java.lang.Integer element() { return this.elementInt(); }
        @Override default boolean offer(java.lang.Integer e) { return this.offerInt(e); }
        @Override default java.lang.Integer peek() { return this.peekInt(); }
        @Override default java.lang.Integer poll() {  return this.pollInt(); }

        /////////////// int equivalent

        int elementInt();
        boolean offerInt(int e);
        int peekInt();
        int pollInt();
    }
    interface OfFloat extends PrimitiveQueue<java.lang.Float, PrimitiveConsumer.OfFloat>, PrimitiveCollection.OfFloat {
        @Override default boolean add(java.lang.Float e) { return this.addFloat(e); }
        @Override default java.lang.Float element() { return this.elementFloat(); }
        @Override default boolean offer(java.lang.Float e) { return this.offerFloat(e); }
        @Override default java.lang.Float peek() { return this.peekFloat(); }
        @Override default java.lang.Float poll() {  return this.pollFloat(); }

        /////////////// float equivalent

        float elementFloat();
        boolean offerFloat(float e);
        float peekFloat();
        float pollFloat();
    }
    interface OfChar extends PrimitiveQueue<java.lang.Character, PrimitiveConsumer.OfChar>, PrimitiveCollection.OfChar {
        @Override default boolean add(java.lang.Character e) { return this.addChar(e); }
        @Override default java.lang.Character element() { return this.elementChar(); }
        @Override default boolean offer(java.lang.Character e) { return this.offerChar(e); }
        @Override default java.lang.Character peek() { return this.peekChar(); }
        @Override default java.lang.Character poll() {  return this.pollChar(); }

        /////////////// char equivalent

        char elementChar();
        boolean offerChar(char e);
        char peekChar();
        char pollChar();
    }
    interface OfShort extends PrimitiveQueue<java.lang.Short, PrimitiveConsumer.OfShort>, PrimitiveCollection.OfShort {
        @Override default boolean add(java.lang.Short e) { return this.addShort(e); }
        @Override default java.lang.Short element() { return this.elementShort(); }
        @Override default boolean offer(java.lang.Short e) { return this.offerShort(e); }
        @Override default java.lang.Short peek() { return this.peekShort(); }
        @Override default java.lang.Short poll() {  return this.pollShort(); }

        /////////////// short equivalent

        short elementShort();
        boolean offerShort(short e);
        short peekShort();
        short pollShort();
    }
    interface OfByte extends PrimitiveQueue<java.lang.Byte, PrimitiveConsumer.OfByte>, PrimitiveCollection.OfByte {
        @Override default boolean add(java.lang.Byte e) { return this.addByte(e); }
        @Override default java.lang.Byte element() { return this.elementByte(); }
        @Override default boolean offer(java.lang.Byte e) { return this.offerByte(e); }
        @Override default java.lang.Byte peek() { return this.peekByte(); }
        @Override default java.lang.Byte poll() {  return this.pollByte(); }

        /////////////// byte equivalent

        byte elementByte();
        boolean offerByte(byte e);
        byte peekByte();
        byte pollByte();
    }
    interface OfBoolean extends PrimitiveQueue<java.lang.Boolean, PrimitiveConsumer.OfBoolean>, PrimitiveCollection.OfBoolean {
        @Override default boolean add(java.lang.Boolean e) { return this.addBoolean(e); }
        @Override default java.lang.Boolean element() { return this.elementBoolean(); }
        @Override default boolean offer(java.lang.Boolean e) { return this.offerBoolean(e); }
        @Override default java.lang.Boolean peek() { return this.peekBoolean(); }
        @Override default java.lang.Boolean poll() {  return this.pollBoolean(); }

        /////////////// boolean equivalent

        boolean elementBoolean();
        boolean offerBoolean(boolean e);
        boolean peekBoolean();
        boolean pollBoolean();
    }
}
