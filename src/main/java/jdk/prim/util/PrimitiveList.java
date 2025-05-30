package jdk.prim.util;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;

import jdk.prim.util.function.PrimitiveConsumer;
import jdk.prim.util.function.PrimitiveFunction;
/**
 * A list of primitive elements.
 * <p>
 * A major difference between this interface and the other {@code PrimitiveCollection} implementations is the replacement of
 * {@link #remove(int)} with {@code removeElementAtIndex(int)} (as seen at {@link OfInt#removeElementAtIndex(int)} for
 * example) which breaks the convention set by this project. This is a
 * necessary exception because {@code removeXxx(int)} is already being used by {@link PrimitiveCollection}, and that
 * declaration returns a {@code boolean}. Hence, convention is broken here to prevent compile-time errors
 * @param <T> The type of primitive wrapper for this sequenced collection
 * @param <T_CONS> the type of consumer for the generic {@link #forEach(Object) forEach}
 * 
 * @see List
 */
public interface PrimitiveList<T, T_CONS> extends PrimitiveSequencedCollection<T, T_CONS>, List<T> {
    /**
     * A list of {@code double} elements
     */
    interface OfDouble extends PrimitiveList<java.lang.Double, PrimitiveConsumer.OfDouble>, PrimitiveSequencedCollection.OfDouble {
        @Override
        default boolean add(java.lang.Double e) { return addDouble(e); }
        /**
         * The {@code double} specialization of {@link #add(int, Object)}
         * @param index the index at which the specified element will be inserted
         * @param e the element to be insert
         */
        void addDouble(int index, double e);
        @Override
        default void add(int index, java.lang.Double e) { addDouble(index, e); }
        /**
         * The {@code double} specialization of {@link #addAll(int, java.util.Collection)}
         * @param index the index at which the insertion is to take place
         * @param e the collection to be inserted
         * @return {@true} if the list changed as a result of this call
         */
        boolean addAllDouble(int index, PrimitiveCollection.OfDouble e);
        @Override
        default void addFirstDouble(double e) { addDouble(0, e); }
        @Override
        default void addFirst(java.lang.Double e) { addFirstDouble(e); }
        @Override
        default void addLastDouble(double e) { addDouble(e); }
        @Override
        default void addLast(java.lang.Double e) { addLastDouble(e); }
        @Override
        default boolean contains(Object o) { return jdk.prim.util.PrimitiveSequencedCollection.OfDouble.super.contains(o); }
        /**
         * The {@code double} specialisation of {@link #get(int)}
         * @param index the index of the element to be returned
         * @return the {@code double} value at the specified index within this list
         */
        double getDouble(int index);
        @Override
        default java.lang.Double get(int index) { return getDouble(index); }
        @Override
        default double getFirstDouble() { return getDouble(0); }
        @Override
        default java.lang.Double getFirst() { return getFirstDouble(); }
        @Override
        default double getLastDouble() { return getDouble(size() - 1); }
        @Override
        default java.lang.Double getLast() { return getLastDouble(); }
        /**
         * The {@code double} specialisation of {@link #indexOf(Object)}
         * @param e the element to search for
         * @return the index of the given element or {@code -1} if
         * the element does not exist in this list.
         */
        int indexOfDouble(double e);
        @Override
        default int indexOf(Object o) { return (o instanceof java.lang.Double element) ? indexOfDouble(element) : -1; }
        @Override
        default Iterator<java.lang.Double> iterator() { return iteratorDouble(); }
        /**
         * The {@code double} specialisation of {@link #lastIndexOf(Object)}
         * @param e the element to search for
         * @return the last index of the given element or {@code -1} if
         * the element does not exist in this list
         */
        int lastIndexOfDouble(double e);
        @Override
        default int lastIndexOf(Object o) { return (o instanceof java.lang.Double element) ? lastIndexOfDouble(element) : -1; }
        /**
         * The {@code double} specialisation of {@link #listIterator()}
         * @return the {@code ListIterator} for this interface
         */
        PrimitiveListIterator.OfDouble listIteratorDouble();
        @Override
        default ListIterator<java.lang.Double> listIterator() {
            return listIteratorDouble();
        }
        /**
         * The {@code double} specialisation of {@link #listIterator(int)}
         * @param from the index from which the iterator should begin
         * @return the list-ietrator from the given index
         */
        PrimitiveListIterator.OfDouble listIteratorDouble(int from);
        @Override
        default ListIterator<java.lang.Double> listIterator(int from) { 
            return listIteratorDouble(from);
        }
        /**
         * The {@code double} specialisation of {@link #reversed()}
         * @return a reversed-ordered view of this list
         */
        default PrimitiveList.OfDouble reversedDouble() { return jdk.prim.util.rolv.OfDouble.of(this, true); }
        @Override
        default List<java.lang.Double> reversed() { return reversedDouble(); }
        /**
         * The {@code double} specialisation of {@link #remove(int)}
         * @param i the index of the element to be removed
         * @return the element that was replaced
         */
        double removeElementAtIndex(int i);
        @Override
        default java.lang.Double remove(int index) { return removeElementAtIndex(index); }
        /**
         * The {@code double} specialisation of {@link #remove(Object)}
         * @param e the element (if present) to be removed
         * @return {@code true} if this list contained the specified element
         */
        boolean removeDouble(double e);
        @Override
        default boolean remove(Object o) { return (o instanceof java.lang.Double element) ? removeDouble(element) : false; }
        @Override
        default double removeFirstDouble() { return removeElementAtIndex(0); }
        @Override
        default java.lang.Double removeFirst() { return removeFirstDouble(); }
        @Override
        default double removeLastDouble() { return removeElementAtIndex(size() - 1); }
        @Override
        default java.lang.Double removeLast() { return removeLastDouble(); }
        /**
         * The {@code double} specialisation of {@link #replaceAll(java.util.function.Function)}
         * @param fn the function to be applied to each element
         */
        default void replaceAllDouble(PrimitiveFunction.ToDouble.OfDouble fn) {
            PrimitiveListIterator.OfDouble li = listIteratorDouble();
            while (li.hasNext()) {
                li.setDouble(fn.applyDouble(li.nextDouble()));
            }
        }
        /**
         * The {@code double} specialisation of {@link #set(int, Object)}
         * @param index the index at which the replacement is to be done
         * @param e the replacement
         * @return the replaced element
         */
        double setDouble(int index, double e);
        @Override default java.lang.Double set(int index, java.lang.Double e) { return setDouble(index, e); }
        /**
         * The {@code double} specialisation of {@link #sort(Comparator)}
         * @param c the {@link PrimitiveComparator.OfDouble Comparator} used to
         * define the order
         */
        default void sortDouble(PrimitiveComparator.OfDouble c) {
            double[] doubles = toArrayDouble();
            PrimitiveArrays.sort(doubles, c);
            PrimitiveListIterator.OfDouble li = listIteratorDouble();
            for(double d : doubles) {
                li.nextDouble();
                li.setDouble(d);
            }
        }
        @Override
        default void sort(Comparator<? super java.lang.Double> c) {
            sortDouble(c::compare);
        }
        @Override
        default PrimitiveSpliterator.OfDouble spliteratorDouble() { return null; }
        @Override
        default Spliterator<java.lang.Double> spliterator() { return spliteratorDouble(); }
        /**
         * The {@code double} specialisation of {@link #subList(int, int)}
         * @param from the index (inclusive) that defined the start of the returned list
         * @param to the index (exclusive) that defines the start of the returned list
         * @return a list where all elements in it are the same that exists from the specified
         * index to the given index respectively
         */
        PrimitiveList.OfDouble subListDouble(int from, int to);
        @Override
        default List<java.lang.Double> subList(int from, int to) { return subListDouble(from, to); }
        @Override
        java.lang.Double[] toArray();
    }
    /**
     * A list of {@code long} elements
     */
    interface OfLong extends PrimitiveList<java.lang.Long, PrimitiveConsumer.OfLong>, PrimitiveSequencedCollection.OfLong {
        @Override
        default boolean add(java.lang.Long e) { return addLong(e); }
        /**
         * The {@code long} specialization of {@link #add(int, Object)}
         * @param index the index at which the specified element will be inserted
         * @param e the element to be insert
         */
        void addLong(int index, long e);
        @Override
        default void add(int index, java.lang.Long e) { addLong(index, e); }
        /**
         * The {@code long} specialization of {@link #addAll(int, java.util.Collection)}
         * @param index the index at which the insertion is to take place
         * @param e the collection to be inserted
         * @return {@true} if the list changed as a result of this call
         */
        boolean addAllLong(int index, PrimitiveCollection.OfLong e);
        @Override
        default void addFirstLong(long e) { addLong(0, e); }
        @Override
        default void addFirst(java.lang.Long e) { addFirstLong(e); }
        @Override
        default void addLastLong(long e) { addLong(e); }
        @Override
        default void addLast(java.lang.Long e) { addLastLong(e); }
        @Override
        default boolean contains(Object o) { return jdk.prim.util.PrimitiveSequencedCollection.OfLong.super.contains(o); }
        /**
         * The {@code long} specialisation of {@link #get(int)}
         * @param index the index of the element to be returned
         * @return the {@code long} value at the specified index within this list
         */
        long getLong(int index);
        @Override
        default java.lang.Long get(int index) { return getLong(index); }
        @Override
        default long getFirstLong() { return getLong(0); }
        @Override
        default java.lang.Long getFirst() { return getFirstLong(); }
        @Override
        default long getLastLong() { return getLong(size() - 1); }
        @Override
        default java.lang.Long getLast() { return getLastLong(); }
        /**
         * The {@code long} specialisation of {@link #indexOf(Object)}
         * @param e the element to search for
         * @return the index of the given element or {@code -1} if
         * the element does not exist in this list.
         */
        int indexOfLong(long e);
        @Override
        default int indexOf(Object o) { return (o instanceof java.lang.Long element) ? indexOfLong(element) : -1; }
        @Override
        default Iterator<java.lang.Long> iterator() { return iteratorLong(); }
        /**
         * The {@code long} specialisation of {@link #lastIndexOf(Object)}
         * @param e the element to search for
         * @return the last index of the given element or {@code -1} if
         * the element does not exist in this list
         */
        int lastIndexOfLong(long e);
        @Override
        default int lastIndexOf(Object o) { return (o instanceof java.lang.Long element) ? lastIndexOfLong(element) : -1; }
        /**
         * The {@code long} specialisation of {@link #listIterator()}
         * @return the {@code ListIterator} for this interface
         */
        PrimitiveListIterator.OfLong listIteratorLong();
        @Override
        default ListIterator<java.lang.Long> listIterator() {
            return listIteratorLong();
        }
        /**
         * The {@code long} specialisation of {@link #listIterator(int)}
         * @param from the index from which the iterator should begin
         * @return the list-ietrator from the given index
         */
        PrimitiveListIterator.OfLong listIteratorLong(int from);
        @Override
        default ListIterator<java.lang.Long> listIterator(int from) { 
            return listIteratorLong(from);
        }
        /**
         * The {@code long} specialisation of {@link #reversed()}
         * @return a reversed-ordered view of this list
         */
        default PrimitiveList.OfLong reversedLong() { return jdk.prim.util.rolv.OfLong.of(this, true); }
        @Override
        default List<java.lang.Long> reversed() { return reversedLong(); }
        /**
         * The {@code long} specialisation of {@link #remove(int)}
         * @param i the index of the element to be removed
         * @return the element that was replaced
         */
        long removeElementAtIndex(int i);
        @Override
        default java.lang.Long remove(int index) { return removeElementAtIndex(index); }
        /**
         * The {@code long} specialisation of {@link #remove(Object)}
         * @param e the element (if present) to be removed
         * @return {@code true} if this list contained the specified element
         */
        boolean removeLong(long e);
        @Override
        default boolean remove(Object o) { return (o instanceof java.lang.Long element) ? removeLong(element) : false; }
        @Override
        default long removeFirstLong() { return removeElementAtIndex(0); }
        @Override
        default java.lang.Long removeFirst() { return removeFirstLong(); }
        @Override
        default long removeLastLong() { return removeElementAtIndex(size() - 1); }
        @Override
        default java.lang.Long removeLast() { return removeLastLong(); }
        /**
         * The {@code long} specialisation of {@link #replaceAll(java.util.function.Function)}
         * @param fn the function to be applied to each element
         */
        default void replaceAllLong(PrimitiveFunction.ToLong.OfLong fn) {
            PrimitiveListIterator.OfLong li = listIteratorLong();
            while (li.hasNext()) {
                li.setLong(fn.applyLong(li.nextLong()));
            }
        }
        /**
         * The {@code long} specialisation of {@link #set(int, Object)}
         * @param index the index at which the replacement is to be done
         * @param e the replacement
         * @return the replaced element
         */
        long setLong(int index, long e);
        @Override default java.lang.Long set(int index, java.lang.Long e) { return setLong(index, e); }
        /**
         * The {@code long} specialisation of {@link #sort(Comparator)}
         * @param c the {@link PrimitiveComparator.OfLong Comparator} used to
         * define the order
         */
        default void sortLong(PrimitiveComparator.OfLong c) {
            long[] longs = toArrayLong();
            PrimitiveArrays.sort(longs, c);
            PrimitiveListIterator.OfLong li = listIteratorLong();
            for(long l : longs) {
                li.nextLong();
                li.setLong(l);
            }
        }
        @Override
        default void sort(Comparator<? super java.lang.Long> c) {
            sortLong(c::compare);
        }
        @Override
        default PrimitiveSpliterator.OfLong spliteratorLong() { return null; }
        @Override
        default Spliterator<java.lang.Long> spliterator() { return spliteratorLong(); }
        /**
         * The {@code long} specialisation of {@link #subList(int, int)}
         * @param from the index (inclusive) that defined the start of the returned list
         * @param to the index (exclusive) that defines the start of the returned list
         * @return a list where all elements in it are the same that exists from the specified
         * index to the given index respectively
         */
        PrimitiveList.OfLong subListLong(int from, int to);
        @Override
        default List<java.lang.Long> subList(int from, int to) { return subListLong(from, to); }
        @Override
        java.lang.Long[] toArray();
    }
    /**
     * A list of {@code int} elements
     */
    interface OfInt extends PrimitiveList<java.lang.Integer, PrimitiveConsumer.OfInt>, PrimitiveSequencedCollection.OfInt {
        @Override
        default boolean add(java.lang.Integer e) { return addInt(e); }
        /**
         * The {@code int} specialization of {@link #add(int, Object)}
         * @param index the index at which the specified element will be inserted
         * @param e the element to be insert
         */
        void addInt(int index, int e);
        @Override
        default void add(int index, java.lang.Integer e) { addInt(index, e); }
        /**
         * The {@code int} specialization of {@link #addAll(int, java.util.Collection)}
         * @param index the index at which the insertion is to take place
         * @param e the collection to be inserted
         * @return {@true} if the list changed as a result of this call
         */
        boolean addAllInt(int index, PrimitiveCollection.OfInt e);
        @Override
        default void addFirstInt(int e) { addInt(0, e); }
        @Override
        default void addFirst(java.lang.Integer e) { addFirstInt(e); }
        @Override
        default void addLastInt(int e) { addInt(e); }
        @Override
        default void addLast(java.lang.Integer e) { addLastInt(e); }
        @Override
        default boolean contains(Object o) { return jdk.prim.util.PrimitiveSequencedCollection.OfInt.super.contains(o); }
        /**
         * The {@code int} specialisation of {@link #get(int)}
         * @param index the index of the element to be returned
         * @return the {@code int} value at the specified index within this list
         */
        int getInt(int index);
        @Override
        default java.lang.Integer get(int index) { return getInt(index); }
        @Override
        default int getFirstInt() { return getInt(0); }
        @Override
        default java.lang.Integer getFirst() { return getFirstInt(); }
        @Override
        default int getLastInt() { return getInt(size() - 1); }
        @Override
        default java.lang.Integer getLast() { return getLastInt(); }
        /**
         * The {@code int} specialisation of {@link #indexOf(Object)}
         * @param e the element to search for
         * @return the index of the given element or {@code -1} if
         * the element does not exist in this list.
         */
        int indexOfInt(int e);
        @Override
        default int indexOf(Object o) { return (o instanceof java.lang.Integer element) ? indexOfInt(element) : -1; }
        @Override
        default Iterator<java.lang.Integer> iterator() { return iteratorInt(); }
        /**
         * The {@code int} specialisation of {@link #lastIndexOf(Object)}
         * @param e the element to search for
         * @return the last index of the given element or {@code -1} if
         * the element does not exist in this list
         */
        int lastIndexOfInt(int e);
        @Override
        default int lastIndexOf(Object o) { return (o instanceof java.lang.Integer element) ? lastIndexOfInt(element) : -1; }
        /**
         * The {@code int} specialisation of {@link #listIterator()}
         * @return the {@code ListIterator} for this interface
         */
        PrimitiveListIterator.OfInt listIteratorInt();
        @Override
        default ListIterator<java.lang.Integer> listIterator() {
            return listIteratorInt();
        }
        /**
         * The {@code int} specialisation of {@link #listIterator(int)}
         * @param from the index from which the iterator should begin
         * @return the list-ietrator from the given index
         */
        PrimitiveListIterator.OfInt listIteratorInt(int from);
        @Override
        default ListIterator<java.lang.Integer> listIterator(int from) { 
            return listIteratorInt(from);
        }
        /**
         * The {@code int} specialisation of {@link #reversed()}
         * @return a reversed-ordered view of this list
         */
        default PrimitiveList.OfInt reversedInt() { return jdk.prim.util.rolv.OfInt.of(this, true); }
        @Override
        default List<java.lang.Integer> reversed() { return reversedInt(); }
        /**
         * The {@code int} specialisation of {@link #remove(int)}
         * @param i the index of the element to be removed
         * @return the element that was replaced
         */
        int removeElementAtIndex(int i);
        @Override
        default java.lang.Integer remove(int index) { return removeElementAtIndex(index); }
        /**
         * The {@code int} specialisation of {@link #remove(Object)}
         * @param e the element (if present) to be removed
         * @return {@code true} if this list contained the specified element
         */
        boolean removeInt(int e);
        @Override
        default boolean remove(Object o) { return (o instanceof java.lang.Integer element) ? removeInt(element) : false; }
        @Override
        default int removeFirstInt() { return removeElementAtIndex(0); }
        @Override
        default java.lang.Integer removeFirst() { return removeFirstInt(); }
        @Override
        default int removeLastInt() { return removeElementAtIndex(size() - 1); }
        @Override
        default java.lang.Integer removeLast() { return removeLastInt(); }
        /**
         * The {@code int} specialisation of {@link #replaceAll(java.util.function.Function)}
         * @param fn the function to be applied to each element
         */
        default void replaceAllInt(PrimitiveFunction.ToInt.OfInt fn) {
            PrimitiveListIterator.OfInt li = listIteratorInt();
            while (li.hasNext()) {
                li.setInt(fn.applyInt(li.nextInt()));
            }
        }
        /**
         * The {@code int} specialisation of {@link #set(int, Object)}
         * @param index the index at which the replacement is to be done
         * @param e the replacement
         * @return the replaced element
         */
        int setInt(int index, int e);
        @Override default java.lang.Integer set(int index, java.lang.Integer e) { return setInt(index, e); }
        /**
         * The {@code int} specialisation of {@link #sort(Comparator)}
         * @param c the {@link PrimitiveComparator.OfInt Comparator} used to
         * define the order
         */
        default void sortInt(PrimitiveComparator.OfInt c) {
            int[] ints = toArrayInt();
            PrimitiveArrays.sort(ints, c);
            PrimitiveListIterator.OfInt li = listIteratorInt();
            for(int i : ints) {
                li.nextInt();
                li.setInt(i);
            }
        }
        @Override
        default void sort(Comparator<? super java.lang.Integer> c) {
            sortInt(c::compare);
        }
        @Override
        default PrimitiveSpliterator.OfInt spliteratorInt() { return null; }
        @Override
        default Spliterator<java.lang.Integer> spliterator() { return spliteratorInt(); }
        /**
         * The {@code int} specialisation of {@link #subList(int, int)}
         * @param from the index (inclusive) that defined the start of the returned list
         * @param to the index (exclusive) that defines the start of the returned list
         * @return a list where all elements in it are the same that exists from the specified
         * index to the given index respectively
         */
        PrimitiveList.OfInt subListInt(int from, int to);
        @Override
        default List<java.lang.Integer> subList(int from, int to) { return subListInt(from, to); }
        @Override
        java.lang.Integer[] toArray();
    }
    /**
     * A list of {@code float} elements
     */
    interface OfFloat extends PrimitiveList<java.lang.Float, PrimitiveConsumer.OfFloat>, PrimitiveSequencedCollection.OfFloat {
        @Override
        default boolean add(java.lang.Float e) { return addFloat(e); }
        /**
         * The {@code float} specialization of {@link #add(int, Object)}
         * @param index the index at which the specified element will be inserted
         * @param e the element to be insert
         */
        void addFloat(int index, float e);
        @Override
        default void add(int index, java.lang.Float e) { addFloat(index, e); }
        /**
         * The {@code float} specialization of {@link #addAll(int, java.util.Collection)}
         * @param index the index at which the insertion is to take place
         * @param e the collection to be inserted
         * @return {@true} if the list changed as a result of this call
         */
        boolean addAllFloat(int index, PrimitiveCollection.OfFloat e);
        @Override
        default void addFirstFloat(float e) { addFloat(0, e); }
        @Override
        default void addFirst(java.lang.Float e) { addFirstFloat(e); }
        @Override
        default void addLastFloat(float e) { addFloat(e); }
        @Override
        default void addLast(java.lang.Float e) { addLastFloat(e); }
        @Override
        default boolean contains(Object o) { return jdk.prim.util.PrimitiveSequencedCollection.OfFloat.super.contains(o); }
        /**
         * The {@code float} specialisation of {@link #get(int)}
         * @param index the index of the element to be returned
         * @return the {@code float} value at the specified index within this list
         */
        float getFloat(int index);
        @Override
        default java.lang.Float get(int index) { return getFloat(index); }
        @Override
        default float getFirstFloat() { return getFloat(0); }
        @Override
        default java.lang.Float getFirst() { return getFirstFloat(); }
        @Override
        default float getLastFloat() { return getFloat(size() - 1); }
        @Override
        default java.lang.Float getLast() { return getLastFloat(); }
        /**
         * The {@code float} specialisation of {@link #indexOf(Object)}
         * @param e the element to search for
         * @return the index of the given element or {@code -1} if
         * the element does not exist in this list.
         */
        int indexOfFloat(float e);
        @Override
        default int indexOf(Object o) { return (o instanceof java.lang.Float element) ? indexOfFloat(element) : -1; }
        @Override
        default Iterator<java.lang.Float> iterator() { return iteratorFloat(); }
        /**
         * The {@code float} specialisation of {@link #lastIndexOf(Object)}
         * @param e the element to search for
         * @return the last index of the given element or {@code -1} if
         * the element does not exist in this list
         */
        int lastIndexOfFloat(float e);
        @Override
        default int lastIndexOf(Object o) { return (o instanceof java.lang.Float element) ? lastIndexOfFloat(element) : -1; }
        /**
         * The {@code float} specialisation of {@link #listIterator()}
         * @return the {@code ListIterator} for this interface
         */
        PrimitiveListIterator.OfFloat listIteratorFloat();
        @Override
        default ListIterator<java.lang.Float> listIterator() {
            return listIteratorFloat();
        }
        /**
         * The {@code float} specialisation of {@link #listIterator(int)}
         * @param from the index from which the iterator should begin
         * @return the list-ietrator from the given index
         */
        PrimitiveListIterator.OfFloat listIteratorFloat(int from);
        @Override
        default ListIterator<java.lang.Float> listIterator(int from) { 
            return listIteratorFloat(from);
        }
        /**
         * The {@code float} specialisation of {@link #reversed()}
         * @return a reversed-ordered view of this list
         */
        default PrimitiveList.OfFloat reversedFloat() { return jdk.prim.util.rolv.OfFloat.of(this, true); }
        @Override
        default List<java.lang.Float> reversed() { return reversedFloat(); }
        /**
         * The {@code float} specialisation of {@link #remove(int)}
         * @param i the index of the element to be removed
         * @return the element that was replaced
         */
        float removeElementAtIndex(int i);
        @Override
        default java.lang.Float remove(int index) { return removeElementAtIndex(index); }
        /**
         * The {@code float} specialisation of {@link #remove(Object)}
         * @param e the element (if present) to be removed
         * @return {@code true} if this list contained the specified element
         */
        boolean removeFloat(float e);
        @Override
        default boolean remove(Object o) { return (o instanceof java.lang.Float element) ? removeFloat(element) : false; }
        @Override
        default float removeFirstFloat() { return removeElementAtIndex(0); }
        @Override
        default java.lang.Float removeFirst() { return removeFirstFloat(); }
        @Override
        default float removeLastFloat() { return removeElementAtIndex(size() - 1); }
        @Override
        default java.lang.Float removeLast() { return removeLastFloat(); }
        /**
         * The {@code float} specialisation of {@link #replaceAll(java.util.function.Function)}
         * @param fn the function to be applied to each element
         */
        default void replaceAllFloat(PrimitiveFunction.ToFloat.OfFloat fn) {
            PrimitiveListIterator.OfFloat li = listIteratorFloat();
            while (li.hasNext()) {
                li.setFloat(fn.applyFloat(li.nextFloat()));
            }
        }
        /**
         * The {@code float} specialisation of {@link #set(int, Object)}
         * @param index the index at which the replacement is to be done
         * @param e the replacement
         * @return the replaced element
         */
        float setFloat(int index, float e);
        @Override default java.lang.Float set(int index, java.lang.Float e) { return setFloat(index, e); }
        /**
         * The {@code float} specialisation of {@link #sort(Comparator)}
         * @param c the {@link PrimitiveComparator.OfFloat Comparator} used to
         * define the order
         */
        default void sortFloat(PrimitiveComparator.OfFloat c) {
            float[] floats = toArrayFloat();
            PrimitiveArrays.sort(floats, c);
            PrimitiveListIterator.OfFloat li = listIteratorFloat();
            for(float f : floats) {
                li.nextFloat();
                li.setFloat(f);
            }
        }
        @Override
        default void sort(Comparator<? super java.lang.Float> c) {
            sortFloat(c::compare);
        }
        @Override
        default PrimitiveSpliterator.OfFloat spliteratorFloat() { return null; }
        @Override
        default Spliterator<java.lang.Float> spliterator() { return spliteratorFloat(); }
        /**
         * The {@code float} specialisation of {@link #subList(int, int)}
         * @param from the index (inclusive) that defined the start of the returned list
         * @param to the index (exclusive) that defines the start of the returned list
         * @return a list where all elements in it are the same that exists from the specified
         * index to the given index respectively
         */
        PrimitiveList.OfFloat subListFloat(int from, int to);
        @Override
        default List<java.lang.Float> subList(int from, int to) { return subListFloat(from, to); }
        @Override
        java.lang.Float[] toArray();
    }
    /**
     * A list of {@code char} elements
     */
    interface OfChar extends PrimitiveList<java.lang.Character, PrimitiveConsumer.OfChar>, PrimitiveSequencedCollection.OfChar {
        @Override
        default boolean add(java.lang.Character e) { return addChar(e); }
        /**
         * The {@code char} specialization of {@link #add(int, Object)}
         * @param index the index at which the specified element will be inserted
         * @param e the element to be insert
         */
        void addChar(int index, char e);
        @Override
        default void add(int index, java.lang.Character e) { addChar(index, e); }
        /**
         * The {@code char} specialization of {@link #addAll(int, java.util.Collection)}
         * @param index the index at which the insertion is to take place
         * @param e the collection to be inserted
         * @return {@true} if the list changed as a result of this call
         */
        boolean addAllChar(int index, PrimitiveCollection.OfChar e);
        @Override
        default void addFirstChar(char e) { addChar(0, e); }
        @Override
        default void addFirst(java.lang.Character e) { addFirstChar(e); }
        @Override
        default void addLastChar(char e) { addChar(e); }
        @Override
        default void addLast(java.lang.Character e) { addLastChar(e); }
        @Override
        default boolean contains(Object o) { return jdk.prim.util.PrimitiveSequencedCollection.OfChar.super.contains(o); }
        /**
         * The {@code char} specialisation of {@link #get(int)}
         * @param index the index of the element to be returned
         * @return the {@code char} value at the specified index within this list
         */
        char getChar(int index);
        @Override
        default java.lang.Character get(int index) { return getChar(index); }
        @Override
        default char getFirstChar() { return getChar(0); }
        @Override
        default java.lang.Character getFirst() { return getFirstChar(); }
        @Override
        default char getLastChar() { return getChar(size() - 1); }
        @Override
        default java.lang.Character getLast() { return getLastChar(); }
        /**
         * The {@code char} specialisation of {@link #indexOf(Object)}
         * @param e the element to search for
         * @return the index of the given element or {@code -1} if
         * the element does not exist in this list.
         */
        int indexOfChar(char e);
        @Override
        default int indexOf(Object o) { return (o instanceof java.lang.Character element) ? indexOfChar(element) : -1; }
        @Override
        default Iterator<java.lang.Character> iterator() { return iteratorChar(); }
        /**
         * The {@code char} specialisation of {@link #lastIndexOf(Object)}
         * @param e the element to search for
         * @return the last index of the given element or {@code -1} if
         * the element does not exist in this list
         */
        int lastIndexOfChar(char e);
        @Override
        default int lastIndexOf(Object o) { return (o instanceof java.lang.Character element) ? lastIndexOfChar(element) : -1; }
        /**
         * The {@code char} specialisation of {@link #listIterator()}
         * @return the {@code ListIterator} for this interface
         */
        PrimitiveListIterator.OfChar listIteratorChar();
        @Override
        default ListIterator<java.lang.Character> listIterator() {
            return listIteratorChar();
        }
        /**
         * The {@code char} specialisation of {@link #listIterator(int)}
         * @param from the index from which the iterator should begin
         * @return the list-ietrator from the given index
         */
        PrimitiveListIterator.OfChar listIteratorChar(int from);
        @Override
        default ListIterator<java.lang.Character> listIterator(int from) { 
            return listIteratorChar(from);
        }
        /**
         * The {@code char} specialisation of {@link #reversed()}
         * @return a reversed-ordered view of this list
         */
        default PrimitiveList.OfChar reversedChar() { return jdk.prim.util.rolv.OfChar.of(this, true); }
        @Override
        default List<java.lang.Character> reversed() { return reversedChar(); }
        /**
         * The {@code char} specialisation of {@link #remove(int)}
         * @param i the index of the element to be removed
         * @return the element that was replaced
         */
        char removeElementAtIndex(int i);
        @Override
        default java.lang.Character remove(int index) { return removeElementAtIndex(index); }
        /**
         * The {@code char} specialisation of {@link #remove(Object)}
         * @param e the element (if present) to be removed
         * @return {@code true} if this list contained the specified element
         */
        boolean removeChar(char e);
        @Override
        default boolean remove(Object o) { return (o instanceof java.lang.Character element) ? removeChar(element) : false; }
        @Override
        default char removeFirstChar() { return removeElementAtIndex(0); }
        @Override
        default java.lang.Character removeFirst() { return removeFirstChar(); }
        @Override
        default char removeLastChar() { return removeElementAtIndex(size() - 1); }
        @Override
        default java.lang.Character removeLast() { return removeLastChar(); }
        /**
         * The {@code char} specialisation of {@link #replaceAll(java.util.function.Function)}
         * @param fn the function to be applied to each element
         */
        default void replaceAllChar(PrimitiveFunction.ToChar.OfChar fn) {
            PrimitiveListIterator.OfChar li = listIteratorChar();
            while (li.hasNext()) {
                li.setChar(fn.applyChar(li.nextChar()));
            }
        }
        /**
         * The {@code char} specialisation of {@link #set(int, Object)}
         * @param index the index at which the replacement is to be done
         * @param e the replacement
         * @return the replaced element
         */
        char setChar(int index, char e);
        @Override default java.lang.Character set(int index, java.lang.Character e) { return setChar(index, e); }
        /**
         * The {@code char} specialisation of {@link #sort(Comparator)}
         * @param c the {@link PrimitiveComparator.OfChar Comparator} used to
         * define the order
         */
        default void sortChar(PrimitiveComparator.OfChar c) {
            char[] chars = toArrayChar();
            PrimitiveArrays.sort(chars, c);
            PrimitiveListIterator.OfChar li = listIteratorChar();
            for(char k : chars) {
                li.nextChar();
                li.setChar(k);
            }
        }
        @Override
        default void sort(Comparator<? super java.lang.Character> c) {
            sortChar(c::compare);
        }
        @Override
        default PrimitiveSpliterator.OfChar spliteratorChar() { return null; }
        @Override
        default Spliterator<java.lang.Character> spliterator() { return spliteratorChar(); }
        /**
         * The {@code char} specialisation of {@link #subList(int, int)}
         * @param from the index (inclusive) that defined the start of the returned list
         * @param to the index (exclusive) that defines the start of the returned list
         * @return a list where all elements in it are the same that exists from the specified
         * index to the given index respectively
         */
        PrimitiveList.OfChar subListChar(int from, int to);
        @Override
        default List<java.lang.Character> subList(int from, int to) { return subListChar(from, to); }
        @Override
        java.lang.Character[] toArray();
    }
    /**
     * A list of {@code short} elements
     */
    interface OfShort extends PrimitiveList<java.lang.Short, PrimitiveConsumer.OfShort>, PrimitiveSequencedCollection.OfShort {
        @Override
        default boolean add(java.lang.Short e) { return addShort(e); }
        /**
         * The {@code short} specialization of {@link #add(int, Object)}
         * @param index the index at which the specified element will be inserted
         * @param e the element to be insert
         */
        void addShort(int index, short e);
        @Override
        default void add(int index, java.lang.Short e) { addShort(index, e); }
        /**
         * The {@code short} specialization of {@link #addAll(int, java.util.Collection)}
         * @param index the index at which the insertion is to take place
         * @param e the collection to be inserted
         * @return {@true} if the list changed as a result of this call
         */
        boolean addAllShort(int index, PrimitiveCollection.OfShort e);
        @Override
        default void addFirstShort(short e) { addShort(0, e); }
        @Override
        default void addFirst(java.lang.Short e) { addFirstShort(e); }
        @Override
        default void addLastShort(short e) { addShort(e); }
        @Override
        default void addLast(java.lang.Short e) { addLastShort(e); }
        @Override
        default boolean contains(Object o) { return jdk.prim.util.PrimitiveSequencedCollection.OfShort.super.contains(o); }
        /**
         * The {@code short} specialisation of {@link #get(int)}
         * @param index the index of the element to be returned
         * @return the {@code short} value at the specified index within this list
         */
        short getShort(int index);
        @Override
        default java.lang.Short get(int index) { return getShort(index); }
        @Override
        default short getFirstShort() { return getShort(0); }
        @Override
        default java.lang.Short getFirst() { return getFirstShort(); }
        @Override
        default short getLastShort() { return getShort(size() - 1); }
        @Override
        default java.lang.Short getLast() { return getLastShort(); }
        /**
         * The {@code short} specialisation of {@link #indexOf(Object)}
         * @param e the element to search for
         * @return the index of the given element or {@code -1} if
         * the element does not exist in this list.
         */
        int indexOfShort(short e);
        @Override
        default int indexOf(Object o) { return (o instanceof java.lang.Short element) ? indexOfShort(element) : -1; }
        @Override
        default Iterator<java.lang.Short> iterator() { return iteratorShort(); }
        /**
         * The {@code short} specialisation of {@link #lastIndexOf(Object)}
         * @param e the element to search for
         * @return the last index of the given element or {@code -1} if
         * the element does not exist in this list
         */
        int lastIndexOfShort(short e);
        @Override
        default int lastIndexOf(Object o) { return (o instanceof java.lang.Short element) ? lastIndexOfShort(element) : -1; }
        /**
         * The {@code short} specialisation of {@link #listIterator()}
         * @return the {@code ListIterator} for this interface
         */
        PrimitiveListIterator.OfShort listIteratorShort();
        @Override
        default ListIterator<java.lang.Short> listIterator() {
            return listIteratorShort();
        }
        /**
         * The {@code short} specialisation of {@link #listIterator(int)}
         * @param from the index from which the iterator should begin
         * @return the list-ietrator from the given index
         */
        PrimitiveListIterator.OfShort listIteratorShort(int from);
        @Override
        default ListIterator<java.lang.Short> listIterator(int from) { 
            return listIteratorShort(from);
        }
        /**
         * The {@code short} specialisation of {@link #reversed()}
         * @return a reversed-ordered view of this list
         */
        default PrimitiveList.OfShort reversedShort() { return jdk.prim.util.rolv.OfShort.of(this, true); }
        @Override
        default List<java.lang.Short> reversed() { return reversedShort(); }
        /**
         * The {@code short} specialisation of {@link #remove(int)}
         * @param i the index of the element to be removed
         * @return the element that was replaced
         */
        short removeElementAtIndex(int i);
        @Override
        default java.lang.Short remove(int index) { return removeElementAtIndex(index); }
        /**
         * The {@code short} specialisation of {@link #remove(Object)}
         * @param e the element (if present) to be removed
         * @return {@code true} if this list contained the specified element
         */
        boolean removeShort(short e);
        @Override
        default boolean remove(Object o) { return (o instanceof java.lang.Short element) ? removeShort(element) : false; }
        @Override
        default short removeFirstShort() { return removeElementAtIndex(0); }
        @Override
        default java.lang.Short removeFirst() { return removeFirstShort(); }
        @Override
        default short removeLastShort() { return removeElementAtIndex(size() - 1); }
        @Override
        default java.lang.Short removeLast() { return removeLastShort(); }
        /**
         * The {@code short} specialisation of {@link #replaceAll(java.util.function.Function)}
         * @param fn the function to be applied to each element
         */
        default void replaceAllShort(PrimitiveFunction.ToShort.OfShort fn) {
            PrimitiveListIterator.OfShort li = listIteratorShort();
            while (li.hasNext()) {
                li.setShort(fn.applyShort(li.nextShort()));
            }
        }
        /**
         * The {@code short} specialisation of {@link #set(int, Object)}
         * @param index the index at which the replacement is to be done
         * @param e the replacement
         * @return the replaced element
         */
        short setShort(int index, short e);
        @Override default java.lang.Short set(int index, java.lang.Short e) { return setShort(index, e); }
        /**
         * The {@code short} specialisation of {@link #sort(Comparator)}
         * @param c the {@link PrimitiveComparator.OfShort Comparator} used to
         * define the order
         */
        default void sortShort(PrimitiveComparator.OfShort c) {
            short[] shorts = toArrayShort();
            PrimitiveArrays.sort(shorts, c);
            PrimitiveListIterator.OfShort li = listIteratorShort();
            for(short s : shorts) {
                li.nextShort();
                li.setShort(s);
            }
        }
        @Override
        default void sort(Comparator<? super java.lang.Short> c) {
            sortShort(c::compare);
        }
        @Override
        default PrimitiveSpliterator.OfShort spliteratorShort() { return null; }
        @Override
        default Spliterator<java.lang.Short> spliterator() { return spliteratorShort(); }
        /**
         * The {@code short} specialisation of {@link #subList(int, int)}
         * @param from the index (inclusive) that defined the start of the returned list
         * @param to the index (exclusive) that defines the start of the returned list
         * @return a list where all elements in it are the same that exists from the specified
         * index to the given index respectively
         */
        PrimitiveList.OfShort subListShort(int from, int to);
        @Override
        default List<java.lang.Short> subList(int from, int to) { return subListShort(from, to); }
        @Override
        java.lang.Short[] toArray();
    }
    /**
     * A list of {@code byte} elements
     */
    interface OfByte extends PrimitiveList<java.lang.Byte, PrimitiveConsumer.OfByte>, PrimitiveSequencedCollection.OfByte {
        @Override
        default boolean add(java.lang.Byte e) { return addByte(e); }
        /**
         * The {@code byte} specialization of {@link #add(int, Object)}
         * @param index the index at which the specified element will be inserted
         * @param e the element to be insert
         */
        void addByte(int index, byte e);
        @Override
        default void add(int index, java.lang.Byte e) { addByte(index, e); }
        /**
         * The {@code byte} specialization of {@link #addAll(int, java.util.Collection)}
         * @param index the index at which the insertion is to take place
         * @param e the collection to be inserted
         * @return {@true} if the list changed as a result of this call
         */
        boolean addAllByte(int index, PrimitiveCollection.OfByte e);
        @Override
        default void addFirstByte(byte e) { addByte(0, e); }
        @Override
        default void addFirst(java.lang.Byte e) { addFirstByte(e); }
        @Override
        default void addLastByte(byte e) { addByte(e); }
        @Override
        default void addLast(java.lang.Byte e) { addLastByte(e); }
        @Override
        default boolean contains(Object o) { return jdk.prim.util.PrimitiveSequencedCollection.OfByte.super.contains(o); }
        /**
         * The {@code byte} specialisation of {@link #get(int)}
         * @param index the index of the element to be returned
         * @return the {@code byte} value at the specified index within this list
         */
        byte getByte(int index);
        @Override
        default java.lang.Byte get(int index) { return getByte(index); }
        @Override
        default byte getFirstByte() { return getByte(0); }
        @Override
        default java.lang.Byte getFirst() { return getFirstByte(); }
        @Override
        default byte getLastByte() { return getByte(size() - 1); }
        @Override
        default java.lang.Byte getLast() { return getLastByte(); }
        /**
         * The {@code byte} specialisation of {@link #indexOf(Object)}
         * @param e the element to search for
         * @return the index of the given element or {@code -1} if
         * the element does not exist in this list.
         */
        int indexOfByte(byte e);
        @Override
        default int indexOf(Object o) { return (o instanceof java.lang.Byte element) ? indexOfByte(element) : -1; }
        @Override
        default Iterator<java.lang.Byte> iterator() { return iteratorByte(); }
        /**
         * The {@code byte} specialisation of {@link #lastIndexOf(Object)}
         * @param e the element to search for
         * @return the last index of the given element or {@code -1} if
         * the element does not exist in this list
         */
        int lastIndexOfByte(byte e);
        @Override
        default int lastIndexOf(Object o) { return (o instanceof java.lang.Byte element) ? lastIndexOfByte(element) : -1; }
        /**
         * The {@code byte} specialisation of {@link #listIterator()}
         * @return the {@code ListIterator} for this interface
         */
        PrimitiveListIterator.OfByte listIteratorByte();
        @Override
        default ListIterator<java.lang.Byte> listIterator() {
            return listIteratorByte();
        }
        /**
         * The {@code byte} specialisation of {@link #listIterator(int)}
         * @param from the index from which the iterator should begin
         * @return the list-ietrator from the given index
         */
        PrimitiveListIterator.OfByte listIteratorByte(int from);
        @Override
        default ListIterator<java.lang.Byte> listIterator(int from) { 
            return listIteratorByte(from);
        }
        /**
         * The {@code byte} specialisation of {@link #reversed()}
         * @return a reversed-ordered view of this list
         */
        default PrimitiveList.OfByte reversedByte() { return jdk.prim.util.rolv.OfByte.of(this, true); }
        @Override
        default List<java.lang.Byte> reversed() { return reversedByte(); }
        /**
         * The {@code byte} specialisation of {@link #remove(int)}
         * @param i the index of the element to be removed
         * @return the element that was replaced
         */
        byte removeElementAtIndex(int i);
        @Override
        default java.lang.Byte remove(int index) { return removeElementAtIndex(index); }
        /**
         * The {@code byte} specialisation of {@link #remove(Object)}
         * @param e the element (if present) to be removed
         * @return {@code true} if this list contained the specified element
         */
        boolean removeByte(byte e);
        @Override
        default boolean remove(Object o) { return (o instanceof java.lang.Byte element) ? removeByte(element) : false; }
        @Override
        default byte removeFirstByte() { return removeElementAtIndex(0); }
        @Override
        default java.lang.Byte removeFirst() { return removeFirstByte(); }
        @Override
        default byte removeLastByte() { return removeElementAtIndex(size() - 1); }
        @Override
        default java.lang.Byte removeLast() { return removeLastByte(); }
        /**
         * The {@code byte} specialisation of {@link #replaceAll(java.util.function.Function)}
         * @param fn the function to be applied to each element
         */
        default void replaceAllByte(PrimitiveFunction.ToByte.OfByte fn) {
            PrimitiveListIterator.OfByte li = listIteratorByte();
            while (li.hasNext()) {
                li.setByte(fn.applyByte(li.nextByte()));
            }
        }
        /**
         * The {@code byte} specialisation of {@link #set(int, Object)}
         * @param index the index at which the replacement is to be done
         * @param e the replacement
         * @return the replaced element
         */
        byte setByte(int index, byte e);
        @Override default java.lang.Byte set(int index, java.lang.Byte e) { return setByte(index, e); }
        /**
         * The {@code byte} specialisation of {@link #sort(Comparator)}
         * @param c the {@link PrimitiveComparator.OfByte Comparator} used to
         * define the order
         */
        default void sortByte(PrimitiveComparator.OfByte c) {
            byte[] bytes = toArrayByte();
            PrimitiveArrays.sort(bytes, c);
            PrimitiveListIterator.OfByte li = listIteratorByte();
            for(byte b : bytes) {
                li.nextByte();
                li.setByte(b);
            }
        }
        @Override
        default void sort(Comparator<? super java.lang.Byte> c) {
            sortByte(c::compare);
        }
        @Override
        default PrimitiveSpliterator.OfByte spliteratorByte() { return null; }
        @Override
        default Spliterator<java.lang.Byte> spliterator() { return spliteratorByte(); }
        /**
         * The {@code byte} specialisation of {@link #subList(int, int)}
         * @param from the index (inclusive) that defined the start of the returned list
         * @param to the index (exclusive) that defines the start of the returned list
         * @return a list where all elements in it are the same that exists from the specified
         * index to the given index respectively
         */
        PrimitiveList.OfByte subListByte(int from, int to);
        @Override
        default List<java.lang.Byte> subList(int from, int to) { return subListByte(from, to); }
        @Override
        java.lang.Byte[] toArray();
    }
    /**
     * A list of {@code boolean} elements
     */
    interface OfBoolean extends PrimitiveList<java.lang.Boolean, PrimitiveConsumer.OfBoolean>, PrimitiveSequencedCollection.OfBoolean {
        @Override
        default boolean add(java.lang.Boolean e) { return addBoolean(e); }
        /**
         * The {@code boolean} specialization of {@link #add(int, Object)}
         * @param index the index at which the specified element will be inserted
         * @param e the element to be insert
         */
        void addBoolean(int index, boolean e);
        @Override
        default void add(int index, java.lang.Boolean e) { addBoolean(index, e); }
        /**
         * The {@code boolean} specialization of {@link #addAll(int, java.util.Collection)}
         * @param index the index at which the insertion is to take place
         * @param e the collection to be inserted
         * @return {@true} if the list changed as a result of this call
         */
        boolean addAllBoolean(int index, PrimitiveCollection.OfBoolean e);
        @Override
        default void addFirstBoolean(boolean e) { addBoolean(0, e); }
        @Override
        default void addFirst(java.lang.Boolean e) { addFirstBoolean(e); }
        @Override
        default void addLastBoolean(boolean e) { addBoolean(e); }
        @Override
        default void addLast(java.lang.Boolean e) { addLastBoolean(e); }
        @Override
        default boolean contains(Object o) { return jdk.prim.util.PrimitiveSequencedCollection.OfBoolean.super.contains(o); }
        /**
         * The {@code boolean} specialisation of {@link #get(int)}
         * @param index the index of the element to be returned
         * @return the {@code boolean} value at the specified index within this list
         */
        boolean getBoolean(int index);
        @Override
        default java.lang.Boolean get(int index) { return getBoolean(index); }
        @Override
        default boolean getFirstBoolean() { return getBoolean(0); }
        @Override
        default java.lang.Boolean getFirst() { return getFirstBoolean(); }
        @Override
        default boolean getLastBoolean() { return getBoolean(size() - 1); }
        @Override
        default java.lang.Boolean getLast() { return getLastBoolean(); }
        /**
         * The {@code boolean} specialisation of {@link #indexOf(Object)}
         * @param e the element to search for
         * @return the index of the given element or {@code -1} if
         * the element does not exist in this list.
         */
        int indexOfBoolean(boolean e);
        @Override
        default int indexOf(Object o) { return (o instanceof java.lang.Boolean element) ? indexOfBoolean(element) : -1; }
        @Override
        default Iterator<java.lang.Boolean> iterator() { return iteratorBoolean(); }
        /**
         * The {@code boolean} specialisation of {@link #lastIndexOf(Object)}
         * @param e the element to search for
         * @return the last index of the given element or {@code -1} if
         * the element does not exist in this list
         */
        int lastIndexOfBoolean(boolean e);
        @Override
        default int lastIndexOf(Object o) { return (o instanceof java.lang.Boolean element) ? lastIndexOfBoolean(element) : -1; }
        /**
         * The {@code boolean} specialisation of {@link #listIterator()}
         * @return the {@code ListIterator} for this interface
         */
        PrimitiveListIterator.OfBoolean listIteratorBoolean();
        @Override
        default ListIterator<java.lang.Boolean> listIterator() {
            return listIteratorBoolean();
        }
        /**
         * The {@code boolean} specialisation of {@link #listIterator(int)}
         * @param from the index from which the iterator should begin
         * @return the list-ietrator from the given index
         */
        PrimitiveListIterator.OfBoolean listIteratorBoolean(int from);
        @Override
        default ListIterator<java.lang.Boolean> listIterator(int from) { 
            return listIteratorBoolean(from);
        }
        /**
         * The {@code boolean} specialisation of {@link #reversed()}
         * @return a reversed-ordered view of this list
         */
        default PrimitiveList.OfBoolean reversedBoolean() { return jdk.prim.util.rolv.OfBoolean.of(this, true); }
        @Override
        default List<java.lang.Boolean> reversed() { return reversedBoolean(); }
        /**
         * The {@code boolean} specialisation of {@link #remove(int)}
         * @param i the index of the element to be removed
         * @return the element that was replaced
         */
        boolean removeElementAtIndex(int i);
        @Override
        default java.lang.Boolean remove(int index) { return removeElementAtIndex(index); }
        /**
         * The {@code boolean} specialisation of {@link #remove(Object)}
         * @param e the element (if present) to be removed
         * @return {@code true} if this list contained the specified element
         */
        boolean removeBoolean(boolean e);
        @Override
        default boolean remove(Object o) { return (o instanceof java.lang.Boolean element) ? removeBoolean(element) : false; }
        @Override
        default boolean removeFirstBoolean() { return removeElementAtIndex(0); }
        @Override
        default java.lang.Boolean removeFirst() { return removeFirstBoolean(); }
        @Override
        default boolean removeLastBoolean() { return removeElementAtIndex(size() - 1); }
        @Override
        default java.lang.Boolean removeLast() { return removeLastBoolean(); }
        /**
         * The {@code boolean} specialisation of {@link #replaceAll(java.util.function.Function)}
         * @param fn the function to be applied to each element
         */
        default void replaceAllBoolean(PrimitiveFunction.ToBoolean.OfBoolean fn) {
            PrimitiveListIterator.OfBoolean li = listIteratorBoolean();
            while (li.hasNext()) {
                li.setBoolean(fn.applyBoolean(li.nextBoolean()));
            }
        }
        /**
         * The {@code boolean} specialisation of {@link #set(int, Object)}
         * @param index the index at which the replacement is to be done
         * @param e the replacement
         * @return the replaced element
         */
        boolean setBoolean(int index, boolean e);
        @Override default java.lang.Boolean set(int index, java.lang.Boolean e) { return setBoolean(index, e); }
        /**
         * The {@code boolean} specialisation of {@link #sort(Comparator)}
         * @param c the {@link PrimitiveComparator.OfBoolean Comparator} used to
         * define the order
         */
        default void sortBoolean(PrimitiveComparator.OfBoolean c) {
            boolean[] booleans = toArrayBoolean();
            PrimitiveArrays.sort(booleans, c);
            PrimitiveListIterator.OfBoolean li = listIteratorBoolean();
            for(boolean b : booleans) {
                li.nextBoolean();
                li.setBoolean(b);
            }
        }
        @Override
        default void sort(Comparator<? super java.lang.Boolean> c) {
            sortBoolean(c::compare);
        }
        @Override
        default PrimitiveSpliterator.OfBoolean spliteratorBoolean() { return null; }
        @Override
        default Spliterator<java.lang.Boolean> spliterator() { return spliteratorBoolean(); }
        /**
         * The {@code boolean} specialisation of {@link #subList(int, int)}
         * @param from the index (inclusive) that defined the start of the returned list
         * @param to the index (exclusive) that defines the start of the returned list
         * @return a list where all elements in it are the same that exists from the specified
         * index to the given index respectively
         */
        PrimitiveList.OfBoolean subListBoolean(int from, int to);
        @Override
        default List<java.lang.Boolean> subList(int from, int to) { return subListBoolean(from, to); }
        @Override
        java.lang.Boolean[] toArray();
    }
}
