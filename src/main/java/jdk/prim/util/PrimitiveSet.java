package jdk.prim.util;

import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;

import jdk.prim.util.function.PrimitiveConsumer;

public interface PrimitiveSet<E, E_CONS> extends Set<E>, PrimitiveCollection<E, E_CONS> {
    /**
     * The {@code double} equivalent of a {@link java.util.Set set}
     */
    interface OfDouble extends PrimitiveSet<java.lang.Double, PrimitiveConsumer.OfDouble>, PrimitiveCollection.OfDouble {
        ///////////////////// Compile-error prevention
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override default boolean add(java.lang.Double e) {  return PrimitiveCollection.OfDouble.super.add(e); }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override default boolean contains(Object o) { return PrimitiveCollection.OfDouble.super.contains(o); }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override default Iterator<java.lang.Double> iterator() { return PrimitiveCollection.OfDouble.super.iterator(); }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override default Spliterator<java.lang.Double> spliterator() { return PrimitiveCollection.OfDouble.super.spliterator(); }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override default java.lang.Double[] toArray() { return PrimitiveCollection.OfDouble.super.toArray(); }
    }
    /**
     * The {@code long} equivalent of a {@link java.util.Set set}
     */
    interface OfLong extends PrimitiveSet<java.lang.Long, PrimitiveConsumer.OfLong>, PrimitiveCollection.OfLong {
        ///////////////////// Compile-error prevention
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override default boolean add(java.lang.Long e) {  return PrimitiveCollection.OfLong.super.add(e); }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override default boolean contains(Object o) { return PrimitiveCollection.OfLong.super.contains(o); }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override default Iterator<java.lang.Long> iterator() { return PrimitiveCollection.OfLong.super.iterator(); }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override default Spliterator<java.lang.Long> spliterator() { return PrimitiveCollection.OfLong.super.spliterator(); }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override default java.lang.Long[] toArray() { return PrimitiveCollection.OfLong.super.toArray(); }
    }
    /**
     * The {@code int} equivalent of a {@link java.util.Set set}
     */
    interface OfInt extends PrimitiveSet<java.lang.Integer, PrimitiveConsumer.OfInt>, PrimitiveCollection.OfInt {
        ///////////////////// Compile-error prevention
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override default boolean add(java.lang.Integer e) {  return PrimitiveCollection.OfInt.super.add(e); }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override default boolean contains(Object o) { return PrimitiveCollection.OfInt.super.contains(o); }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override default Iterator<java.lang.Integer> iterator() { return PrimitiveCollection.OfInt.super.iterator(); }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override default Spliterator<java.lang.Integer> spliterator() { return PrimitiveCollection.OfInt.super.spliterator(); }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override default java.lang.Integer[] toArray() { return PrimitiveCollection.OfInt.super.toArray(); }
    }
    /**
     * The {@code float} equivalent of a {@link java.util.Set set}
     */
    interface OfFloat extends PrimitiveSet<java.lang.Float, PrimitiveConsumer.OfFloat>, PrimitiveCollection.OfFloat {
        ///////////////////// Compile-error prevention
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override default boolean add(java.lang.Float e) {  return PrimitiveCollection.OfFloat.super.add(e); }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override default boolean contains(Object o) { return PrimitiveCollection.OfFloat.super.contains(o); }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override default Iterator<java.lang.Float> iterator() { return PrimitiveCollection.OfFloat.super.iterator(); }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override default Spliterator<java.lang.Float> spliterator() { return PrimitiveCollection.OfFloat.super.spliterator(); }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override default java.lang.Float[] toArray() { return PrimitiveCollection.OfFloat.super.toArray(); }
    }
    /**
     * The {@code char} equivalent of a {@link java.util.Set set}
     */
    interface OfChar extends PrimitiveSet<java.lang.Character, PrimitiveConsumer.OfChar>, PrimitiveCollection.OfChar {
        ///////////////////// Compile-error prevention
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override default boolean add(java.lang.Character e) {  return PrimitiveCollection.OfChar.super.add(e); }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override default boolean contains(Object o) { return PrimitiveCollection.OfChar.super.contains(o); }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override default Iterator<java.lang.Character> iterator() { return PrimitiveCollection.OfChar.super.iterator(); }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override default Spliterator<java.lang.Character> spliterator() { return PrimitiveCollection.OfChar.super.spliterator(); }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override default java.lang.Character[] toArray() { return PrimitiveCollection.OfChar.super.toArray(); }
    }
    /**
     * The {@code short} equivalent of a {@link java.util.Set set}
     */
    interface OfShort extends PrimitiveSet<java.lang.Short, PrimitiveConsumer.OfShort>, PrimitiveCollection.OfShort {
        ///////////////////// Compile-error prevention
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override default boolean add(java.lang.Short e) {  return PrimitiveCollection.OfShort.super.add(e); }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override default boolean contains(Object o) { return PrimitiveCollection.OfShort.super.contains(o); }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override default Iterator<java.lang.Short> iterator() { return PrimitiveCollection.OfShort.super.iterator(); }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override default Spliterator<java.lang.Short> spliterator() { return PrimitiveCollection.OfShort.super.spliterator(); }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override default java.lang.Short[] toArray() { return PrimitiveCollection.OfShort.super.toArray(); }
    }
    /**
     * The {@code byte} equivalent of a {@link java.util.Set set}
     */
    interface OfByte extends PrimitiveSet<java.lang.Byte, PrimitiveConsumer.OfByte>, PrimitiveCollection.OfByte {
        ///////////////////// Compile-error prevention
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override default boolean add(java.lang.Byte e) {  return PrimitiveCollection.OfByte.super.add(e); }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override default boolean contains(Object o) { return PrimitiveCollection.OfByte.super.contains(o); }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override default Iterator<java.lang.Byte> iterator() { return PrimitiveCollection.OfByte.super.iterator(); }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override default Spliterator<java.lang.Byte> spliterator() { return PrimitiveCollection.OfByte.super.spliterator(); }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override default java.lang.Byte[] toArray() { return PrimitiveCollection.OfByte.super.toArray(); }
    }
    /**
     * The {@code boolean} equivalent of a {@link java.util.Set set}
     */
    interface OfBoolean extends PrimitiveSet<java.lang.Boolean, PrimitiveConsumer.OfBoolean>, PrimitiveCollection.OfBoolean {
        ///////////////////// Compile-error prevention
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override default boolean add(java.lang.Boolean e) {  return PrimitiveCollection.OfBoolean.super.add(e); }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override default boolean contains(Object o) { return PrimitiveCollection.OfBoolean.super.contains(o); }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override default Iterator<java.lang.Boolean> iterator() { return PrimitiveCollection.OfBoolean.super.iterator(); }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override default Spliterator<java.lang.Boolean> spliterator() { return PrimitiveCollection.OfBoolean.super.spliterator(); }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override default java.lang.Boolean[] toArray() { return PrimitiveCollection.OfBoolean.super.toArray(); }
    }
}
