package jdk.prim.util;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;

import jdk.prim.PrimitiveComparator;
import jdk.prim.util.function.PrimitiveConsumer;
import jdk.prim.util.function.PrimitiveFunction;

public interface PrimitiveList<
T,
T_CONS> extends PrimitiveSequencedCollection<T, T_CONS>, List<T> {
    interface OfDouble extends PrimitiveList<java.lang.Double, PrimitiveConsumer.OfDouble>, PrimitiveSequencedCollection.OfDouble {
        @Override
        default boolean add(java.lang.Double e) { return addDouble(e); }
        void addDouble(int index, double e);
        @Override
        default void add(int index, java.lang.Double e) { addDouble(index, e); }
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
        int indexOfDouble(double e);
        @Override
        default int indexOf(Object o) { return (o instanceof java.lang.Double element) ? indexOfDouble(element) : -1; }
        @Override
        default Iterator<java.lang.Double> iterator() { return iteratorDouble(); }
        int lastIndexOfDouble(double e);
        @Override
        default int lastIndexOf(Object o) { return (o instanceof java.lang.Double element) ? lastIndexOfDouble(element) : -1; }
        PrimitiveListIterator.OfDouble listIteratorDouble();
        @Override
        default ListIterator<java.lang.Double> listIterator() {
            return listIteratorDouble();
        }
        PrimitiveListIterator.OfDouble listIteratorDouble(int from);
        @Override
        default ListIterator<java.lang.Double> listIterator(int from) { 
            return listIteratorDouble(from);
        }
        @Override
        default PrimitiveList.OfDouble reversed() { return null; }
        double removeElementAtIndex(int i);
        @Override
        default java.lang.Double remove(int index) { return removeElementAtIndex(index); }
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
        default void replaceAllDouble(PrimitiveFunction.ToDouble.OfDouble fn) {
            PrimitiveListIterator.OfDouble li = listIteratorDouble();
            while (li.hasNext()) {
                li.setDouble(fn.applyDouble(li.nextDouble()));
            }
        }
        double setDouble(int index, double e);
        @Override default java.lang.Double set(int index, java.lang.Double e) { return setDouble(index, e); }
        default void sortDouble(PrimitiveComparator.OfDouble c) {
            // double[] a = this.toArrayDouble();
            //TODO: Not implemented until PrimitiveCountedCompleter & PrimitiveRecursiveTask are impelemented
            // Note that impelementations will copy from java.util.DualPivotQuicksort
            // Arrays.sort(a, c);
        }
        @Override
        default void sort(Comparator<? super java.lang.Double> c) {
            sortDouble(c::compare);
        }
        @Override
        default PrimitiveSpliterator.OfDouble spliteratorDouble() { return null; }
        @Override
        default Spliterator<java.lang.Double> spliterator() { return spliteratorDouble(); }
        PrimitiveList.OfDouble subListDouble(int from, int to);
        @Override
        default List<java.lang.Double> subList(int from, int to) { return subListDouble(from, to); }
        @Override
        java.lang.Double[] toArray();
    }
    interface OfLong extends PrimitiveList<java.lang.Long, PrimitiveConsumer.OfLong>, PrimitiveSequencedCollection.OfLong {
        @Override
        default boolean add(java.lang.Long e) { return addLong(e); }
        void addLong(int index, long e);
        @Override
        default void add(int index, java.lang.Long e) { addLong(index, e); }
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
        int indexOfLong(long e);
        @Override
        default int indexOf(Object o) { return (o instanceof java.lang.Long element) ? indexOfLong(element) : -1; }
        @Override
        default Iterator<java.lang.Long> iterator() { return iteratorLong(); }
        int lastIndexOfLong(long e);
        @Override
        default int lastIndexOf(Object o) { return (o instanceof java.lang.Long element) ? lastIndexOfLong(element) : -1; }
        PrimitiveListIterator.OfLong listIteratorLong();
        @Override
        default ListIterator<java.lang.Long> listIterator() {
            return listIteratorLong();
        }
        PrimitiveListIterator.OfLong listIteratorLong(int from);
        @Override
        default ListIterator<java.lang.Long> listIterator(int from) { 
            return listIteratorLong(from);
        }
        @Override
        default PrimitiveList.OfLong reversed() { return null; }
        long removeElementAtIndex(int i);
        @Override
        default java.lang.Long remove(int index) { return removeElementAtIndex(index); }
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
        default void replaceAllLong(PrimitiveFunction.ToLong.OfLong fn) {
            PrimitiveListIterator.OfLong li = listIteratorLong();
            while (li.hasNext()) {
                li.setLong(fn.applyLong(li.nextLong()));
            }
        }
        long setLong(int index, long e);
        @Override default java.lang.Long set(int index, java.lang.Long e) { return setLong(index, e); }
        default void sortLong(PrimitiveComparator.OfLong c) {
            // long[] a = this.toArrayLong();
            //TODO: Not implemented until PrimitiveCountedCompleter & PrimitiveRecursiveTask are impelemented
            // Note that impelementations will copy from java.util.DualPivotQuicksort
            // Arrays.sort(a, c);
        }
        @Override
        default void sort(Comparator<? super java.lang.Long> c) {
            sortLong(c::compare);
        }
        @Override
        default PrimitiveSpliterator.OfLong spliteratorLong() { return null; }
        @Override
        default Spliterator<java.lang.Long> spliterator() { return spliteratorLong(); }
        PrimitiveList.OfLong subListLong(int from, int to);
        @Override
        default List<java.lang.Long> subList(int from, int to) { return subListLong(from, to); }
        @Override
        java.lang.Long[] toArray();
    }
    interface OfInt extends PrimitiveList<java.lang.Integer, PrimitiveConsumer.OfInt>, PrimitiveSequencedCollection.OfInt {
        @Override
        default boolean add(java.lang.Integer e) { return addInt(e); }
        void addInt(int index, int e);
        @Override
        default void add(int index, java.lang.Integer e) { addInt(index, e); }
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
        int indexOfInt(int e);
        @Override
        default int indexOf(Object o) { return (o instanceof java.lang.Integer element) ? indexOfInt(element) : -1; }
        @Override
        default Iterator<java.lang.Integer> iterator() { return iteratorInt(); }
        int lastIndexOfInt(int e);
        @Override
        default int lastIndexOf(Object o) { return (o instanceof java.lang.Integer element) ? lastIndexOfInt(element) : -1; }
        PrimitiveListIterator.OfInt listIteratorInt();
        @Override
        default ListIterator<java.lang.Integer> listIterator() {
            return listIteratorInt();
        }
        PrimitiveListIterator.OfInt listIteratorInt(int from);
        @Override
        default ListIterator<java.lang.Integer> listIterator(int from) { 
            return listIteratorInt(from);
        }
        @Override
        default PrimitiveList.OfInt reversed() { return null; }
        int removeElementAtIndex(int i);
        @Override
        default java.lang.Integer remove(int index) { return removeElementAtIndex(index); }
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
        default void replaceAllInt(PrimitiveFunction.ToInt.OfInt fn) {
            PrimitiveListIterator.OfInt li = listIteratorInt();
            while (li.hasNext()) {
                li.setInt(fn.applyInt(li.nextInt()));
            }
        }
        int setInt(int index, int e);
        @Override default java.lang.Integer set(int index, java.lang.Integer e) { return setInt(index, e); }
        default void sortInt(PrimitiveComparator.OfInt c) {
            // int[] a = this.toArrayInt();
            //TODO: Not implemented until PrimitiveCountedCompleter & PrimitiveRecursiveTask are impelemented
            // Note that impelementations will copy from java.util.DualPivotQuicksort
            // Arrays.sort(a, c);
        }
        @Override
        default void sort(Comparator<? super java.lang.Integer> c) {
            sortInt(c::compare);
        }
        @Override
        default PrimitiveSpliterator.OfInt spliteratorInt() { return null; }
        @Override
        default Spliterator<java.lang.Integer> spliterator() { return spliteratorInt(); }
        PrimitiveList.OfInt subListInt(int from, int to);
        @Override
        default List<java.lang.Integer> subList(int from, int to) { return subListInt(from, to); }
        @Override
        java.lang.Integer[] toArray();
    }
    interface OfFloat extends PrimitiveList<java.lang.Float, PrimitiveConsumer.OfFloat>, PrimitiveSequencedCollection.OfFloat {
        @Override
        default boolean add(java.lang.Float e) { return addFloat(e); }
        void addFloat(int index, float e);
        @Override
        default void add(int index, java.lang.Float e) { addFloat(index, e); }
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
        int indexOfFloat(float e);
        @Override
        default int indexOf(Object o) { return (o instanceof java.lang.Float element) ? indexOfFloat(element) : -1; }
        @Override
        default Iterator<java.lang.Float> iterator() { return iteratorFloat(); }
        int lastIndexOfFloat(float e);
        @Override
        default int lastIndexOf(Object o) { return (o instanceof java.lang.Float element) ? lastIndexOfFloat(element) : -1; }
        PrimitiveListIterator.OfFloat listIteratorFloat();
        @Override
        default ListIterator<java.lang.Float> listIterator() {
            return listIteratorFloat();
        }
        PrimitiveListIterator.OfFloat listIteratorFloat(int from);
        @Override
        default ListIterator<java.lang.Float> listIterator(int from) { 
            return listIteratorFloat(from);
        }
        @Override
        default PrimitiveList.OfFloat reversed() { return null; }
        float removeElementAtIndex(int i);
        @Override
        default java.lang.Float remove(int index) { return removeElementAtIndex(index); }
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
        default void replaceAllFloat(PrimitiveFunction.ToFloat.OfFloat fn) {
            PrimitiveListIterator.OfFloat li = listIteratorFloat();
            while (li.hasNext()) {
                li.setFloat(fn.applyFloat(li.nextFloat()));
            }
        }
        float setFloat(int index, float e);
        @Override default java.lang.Float set(int index, java.lang.Float e) { return setFloat(index, e); }
        default void sortFloat(PrimitiveComparator.OfFloat c) {
            // float[] a = this.toArrayFloat();
            //TODO: Not implemented until PrimitiveCountedCompleter & PrimitiveRecursiveTask are impelemented
            // Note that impelementations will copy from java.util.DualPivotQuicksort
            // Arrays.sort(a, c);
        }
        @Override
        default void sort(Comparator<? super java.lang.Float> c) {
            sortFloat(c::compare);
        }
        @Override
        default PrimitiveSpliterator.OfFloat spliteratorFloat() { return null; }
        @Override
        default Spliterator<java.lang.Float> spliterator() { return spliteratorFloat(); }
        PrimitiveList.OfFloat subListFloat(int from, int to);
        @Override
        default List<java.lang.Float> subList(int from, int to) { return subListFloat(from, to); }
        @Override
        java.lang.Float[] toArray();
    }
    interface OfChar extends PrimitiveList<java.lang.Character, PrimitiveConsumer.OfChar>, PrimitiveSequencedCollection.OfChar {
        @Override
        default boolean add(java.lang.Character e) { return addChar(e); }
        void addChar(int index, char e);
        @Override
        default void add(int index, java.lang.Character e) { addChar(index, e); }
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
        int indexOfChar(char e);
        @Override
        default int indexOf(Object o) { return (o instanceof java.lang.Character element) ? indexOfChar(element) : -1; }
        @Override
        default Iterator<java.lang.Character> iterator() { return iteratorChar(); }
        int lastIndexOfChar(char e);
        @Override
        default int lastIndexOf(Object o) { return (o instanceof java.lang.Character element) ? lastIndexOfChar(element) : -1; }
        PrimitiveListIterator.OfChar listIteratorChar();
        @Override
        default ListIterator<java.lang.Character> listIterator() {
            return listIteratorChar();
        }
        PrimitiveListIterator.OfChar listIteratorChar(int from);
        @Override
        default ListIterator<java.lang.Character> listIterator(int from) { 
            return listIteratorChar(from);
        }
        @Override
        default PrimitiveList.OfChar reversed() { return null; }
        char removeElementAtIndex(int i);
        @Override
        default java.lang.Character remove(int index) { return removeElementAtIndex(index); }
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
        default void replaceAllChar(PrimitiveFunction.ToChar.OfChar fn) {
            PrimitiveListIterator.OfChar li = listIteratorChar();
            while (li.hasNext()) {
                li.setChar(fn.applyChar(li.nextChar()));
            }
        }
        char setChar(int index, char e);
        @Override default java.lang.Character set(int index, java.lang.Character e) { return setChar(index, e); }
        default void sortChar(PrimitiveComparator.OfChar c) {
            // char[] a = this.toArrayChar();
            //TODO: Not implemented until PrimitiveCountedCompleter & PrimitiveRecursiveTask are impelemented
            // Note that impelementations will copy from java.util.DualPivotQuicksort
            // Arrays.sort(a, c);
        }
        @Override
        default void sort(Comparator<? super java.lang.Character> c) {
            sortChar(c::compare);
        }
        @Override
        default PrimitiveSpliterator.OfChar spliteratorChar() { return null; }
        @Override
        default Spliterator<java.lang.Character> spliterator() { return spliteratorChar(); }
        PrimitiveList.OfChar subListChar(int from, int to);
        @Override
        default List<java.lang.Character> subList(int from, int to) { return subListChar(from, to); }
        @Override
        java.lang.Character[] toArray();
    }
    interface OfShort extends PrimitiveList<java.lang.Short, PrimitiveConsumer.OfShort>, PrimitiveSequencedCollection.OfShort {
        @Override
        default boolean add(java.lang.Short e) { return addShort(e); }
        void addShort(int index, short e);
        @Override
        default void add(int index, java.lang.Short e) { addShort(index, e); }
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
        int indexOfShort(short e);
        @Override
        default int indexOf(Object o) { return (o instanceof java.lang.Short element) ? indexOfShort(element) : -1; }
        @Override
        default Iterator<java.lang.Short> iterator() { return iteratorShort(); }
        int lastIndexOfShort(short e);
        @Override
        default int lastIndexOf(Object o) { return (o instanceof java.lang.Short element) ? lastIndexOfShort(element) : -1; }
        PrimitiveListIterator.OfShort listIteratorShort();
        @Override
        default ListIterator<java.lang.Short> listIterator() {
            return listIteratorShort();
        }
        PrimitiveListIterator.OfShort listIteratorShort(int from);
        @Override
        default ListIterator<java.lang.Short> listIterator(int from) { 
            return listIteratorShort(from);
        }
        @Override
        default PrimitiveList.OfShort reversed() { return null; }
        short removeElementAtIndex(int i);
        @Override
        default java.lang.Short remove(int index) { return removeElementAtIndex(index); }
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
        default void replaceAllShort(PrimitiveFunction.ToShort.OfShort fn) {
            PrimitiveListIterator.OfShort li = listIteratorShort();
            while (li.hasNext()) {
                li.setShort(fn.applyShort(li.nextShort()));
            }
        }
        short setShort(int index, short e);
        @Override default java.lang.Short set(int index, java.lang.Short e) { return setShort(index, e); }
        default void sortShort(PrimitiveComparator.OfShort c) {
            // short[] a = this.toArrayShort();
            //TODO: Not implemented until PrimitiveCountedCompleter & PrimitiveRecursiveTask are impelemented
            // Note that impelementations will copy from java.util.DualPivotQuicksort
            // Arrays.sort(a, c);
        }
        @Override
        default void sort(Comparator<? super java.lang.Short> c) {
            sortShort(c::compare);
        }
        @Override
        default PrimitiveSpliterator.OfShort spliteratorShort() { return null; }
        @Override
        default Spliterator<java.lang.Short> spliterator() { return spliteratorShort(); }
        PrimitiveList.OfShort subListShort(int from, int to);
        @Override
        default List<java.lang.Short> subList(int from, int to) { return subListShort(from, to); }
        @Override
        java.lang.Short[] toArray();
    }
    interface OfByte extends PrimitiveList<java.lang.Byte, PrimitiveConsumer.OfByte>, PrimitiveSequencedCollection.OfByte {
        @Override
        default boolean add(java.lang.Byte e) { return addByte(e); }
        void addByte(int index, byte e);
        @Override
        default void add(int index, java.lang.Byte e) { addByte(index, e); }
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
        int indexOfByte(byte e);
        @Override
        default int indexOf(Object o) { return (o instanceof java.lang.Byte element) ? indexOfByte(element) : -1; }
        @Override
        default Iterator<java.lang.Byte> iterator() { return iteratorByte(); }
        int lastIndexOfByte(byte e);
        @Override
        default int lastIndexOf(Object o) { return (o instanceof java.lang.Byte element) ? lastIndexOfByte(element) : -1; }
        PrimitiveListIterator.OfByte listIteratorByte();
        @Override
        default ListIterator<java.lang.Byte> listIterator() {
            return listIteratorByte();
        }
        PrimitiveListIterator.OfByte listIteratorByte(int from);
        @Override
        default ListIterator<java.lang.Byte> listIterator(int from) { 
            return listIteratorByte(from);
        }
        @Override
        default PrimitiveList.OfByte reversed() { return null; }
        byte removeElementAtIndex(int i);
        @Override
        default java.lang.Byte remove(int index) { return removeElementAtIndex(index); }
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
        default void replaceAllByte(PrimitiveFunction.ToByte.OfByte fn) {
            PrimitiveListIterator.OfByte li = listIteratorByte();
            while (li.hasNext()) {
                li.setByte(fn.applyByte(li.nextByte()));
            }
        }
        byte setByte(int index, byte e);
        @Override default java.lang.Byte set(int index, java.lang.Byte e) { return setByte(index, e); }
        default void sortByte(PrimitiveComparator.OfByte c) {
            // byte[] a = this.toArrayByte();
            //TODO: Not implemented until PrimitiveCountedCompleter & PrimitiveRecursiveTask are impelemented
            // Note that impelementations will copy from java.util.DualPivotQuicksort
            // Arrays.sort(a, c);
        }
        @Override
        default void sort(Comparator<? super java.lang.Byte> c) {
            sortByte(c::compare);
        }
        @Override
        default PrimitiveSpliterator.OfByte spliteratorByte() { return null; }
        @Override
        default Spliterator<java.lang.Byte> spliterator() { return spliteratorByte(); }
        PrimitiveList.OfByte subListByte(int from, int to);
        @Override
        default List<java.lang.Byte> subList(int from, int to) { return subListByte(from, to); }
        @Override
        java.lang.Byte[] toArray();
    }
    interface OfBoolean extends PrimitiveList<java.lang.Boolean, PrimitiveConsumer.OfBoolean>, PrimitiveSequencedCollection.OfBoolean {
        @Override
        default boolean add(java.lang.Boolean e) { return addBoolean(e); }
        void addBoolean(int index, boolean e);
        @Override
        default void add(int index, java.lang.Boolean e) { addBoolean(index, e); }
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
        int indexOfBoolean(boolean e);
        @Override
        default int indexOf(Object o) { return (o instanceof java.lang.Boolean element) ? indexOfBoolean(element) : -1; }
        @Override
        default Iterator<java.lang.Boolean> iterator() { return iteratorBoolean(); }
        int lastIndexOfBoolean(boolean e);
        @Override
        default int lastIndexOf(Object o) { return (o instanceof java.lang.Boolean element) ? lastIndexOfBoolean(element) : -1; }
        PrimitiveListIterator.OfBoolean listIteratorBoolean();
        @Override
        default ListIterator<java.lang.Boolean> listIterator() {
            return listIteratorBoolean();
        }
        PrimitiveListIterator.OfBoolean listIteratorBoolean(int from);
        @Override
        default ListIterator<java.lang.Boolean> listIterator(int from) { 
            return listIteratorBoolean(from);
        }
        @Override
        default PrimitiveList.OfBoolean reversed() { return null; }
        boolean removeElementAtIndex(int i);
        @Override
        default java.lang.Boolean remove(int index) { return removeElementAtIndex(index); }
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
        default void replaceAllBoolean(PrimitiveFunction.ToBoolean.OfBoolean fn) {
            PrimitiveListIterator.OfBoolean li = listIteratorBoolean();
            while (li.hasNext()) {
                li.setBoolean(fn.applyBoolean(li.nextBoolean()));
            }
        }
        boolean setBoolean(int index, boolean e);
        @Override default java.lang.Boolean set(int index, java.lang.Boolean e) { return setBoolean(index, e); }
        default void sortBoolean(PrimitiveComparator.OfBoolean c) {
            // boolean[] a = this.toArrayBoolean();
            //TODO: Not implemented until PrimitiveCountedCompleter & PrimitiveRecursiveTask are impelemented
            // Note that impelementations will copy from java.util.DualPivotQuicksort
            // Arrays.sort(a, c);
        }
        @Override
        default void sort(Comparator<? super java.lang.Boolean> c) {
            sortBoolean(c::compare);
        }
        @Override
        default PrimitiveSpliterator.OfBoolean spliteratorBoolean() { return null; }
        @Override
        default Spliterator<java.lang.Boolean> spliterator() { return spliteratorBoolean(); }
        PrimitiveList.OfBoolean subListBoolean(int from, int to);
        @Override
        default List<java.lang.Boolean> subList(int from, int to) { return subListBoolean(from, to); }
        @Override
        java.lang.Boolean[] toArray();
    }
}
