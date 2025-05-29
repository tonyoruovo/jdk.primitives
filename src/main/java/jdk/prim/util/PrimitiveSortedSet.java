package jdk.prim.util;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.Spliterator;

import jdk.prim.util.function.PrimitiveConsumer;

public interface PrimitiveSortedSet<E, E_CONS> extends PrimitiveSequencedSet<E, E_CONS>, SortedSet<E> {
    interface OfDouble extends PrimitiveSortedSet<java.lang.Double, PrimitiveConsumer.OfDouble>, PrimitiveSequencedSet.OfDouble {
        @Override default void addFirst(java.lang.Double e) { PrimitiveSortedSet.OfDouble.this.addFirstDouble(e); }
        @Override default void addLast(java.lang.Double e) { PrimitiveSortedSet.OfDouble.this.addLastDouble(e); }
        @Override default java.lang.Double getFirst() { return PrimitiveSortedSet.OfDouble.this.getFirst(); }
        @Override default java.lang.Double getLast() { return PrimitiveSortedSet.OfDouble.this.getLast(); }
        @Override default java.lang.Double removeFirst() { return PrimitiveSortedSet.OfDouble.this.removeFirst(); }
        @Override default java.lang.Double removeLast() { return PrimitiveSortedSet.OfDouble.this.removeLast(); }
        @Override default SortedSet<java.lang.Double> reversed() { return PrimitiveSortedSet.OfDouble.this.reversedDouble(); }
        @Override default Spliterator<java.lang.Double> spliterator() { return PrimitiveSortedSet.OfDouble.this.spliteratorDouble(); }
        @Override default Comparator<java.lang.Double> comparator() { return PrimitiveSortedSet.OfDouble.this.comparatorDouble(); }
        @Override default java.lang.Double first() { return PrimitiveSortedSet.OfDouble.this.firstDouble(); }
        @Override default SortedSet<java.lang.Double> headSet(java.lang.Double element) { return PrimitiveSortedSet.OfDouble.this.headSetDouble(element); }
        @Override default java.lang.Double last() { return PrimitiveSortedSet.OfDouble.this.lastDouble(); }
        @Override default SortedSet<java.lang.Double> subSet(java.lang.Double fromElement, java.lang.Double toElement) { return PrimitiveSortedSet.OfDouble.this.subSetDouble(fromElement, toElement); }
        @Override default SortedSet<java.lang.Double> tailSet(java.lang.Double fromElement) { return PrimitiveSortedSet.OfDouble.this.tailSetDouble(fromElement); }

        ///////////////// double equivalents
        
        PrimitiveComparator.OfDouble comparatorDouble();
        double firstDouble();
        @Override default double getFirstDouble() { return firstDouble(); }
        @Override default double getLastDouble() { return lastDouble(); }
        PrimitiveSortedSet.OfDouble headSetDouble(double element);
        double lastDouble();
        @Override default PrimitiveSortedSet.OfDouble reversedDouble() { return null; }
        PrimitiveSortedSet.OfDouble subSetDouble(double fromElement, double toElement);
        PrimitiveSortedSet.OfDouble tailSetDouble(double fromElement);
    }
    interface OfLong extends PrimitiveSortedSet<java.lang.Long, PrimitiveConsumer.OfLong>, PrimitiveSequencedSet.OfLong {
        @Override default void addFirst(java.lang.Long e) { PrimitiveSortedSet.OfLong.this.addFirstLong(e); }
        @Override default void addLast(java.lang.Long e) { PrimitiveSortedSet.OfLong.this.addLastLong(e); }
        @Override default java.lang.Long getFirst() { return PrimitiveSortedSet.OfLong.this.getFirst(); }
        @Override default java.lang.Long getLast() { return PrimitiveSortedSet.OfLong.this.getLast(); }
        @Override default java.lang.Long removeFirst() { return PrimitiveSortedSet.OfLong.this.removeFirst(); }
        @Override default java.lang.Long removeLast() { return PrimitiveSortedSet.OfLong.this.removeLast(); }
        @Override default SortedSet<java.lang.Long> reversed() { return PrimitiveSortedSet.OfLong.this.reversedLong(); }
        @Override default Spliterator<java.lang.Long> spliterator() { return PrimitiveSortedSet.OfLong.this.spliteratorLong(); }
        @Override default Comparator<java.lang.Long> comparator() { return PrimitiveSortedSet.OfLong.this.comparatorLong(); }
        @Override default java.lang.Long first() { return PrimitiveSortedSet.OfLong.this.firstLong(); }
        @Override default SortedSet<java.lang.Long> headSet(java.lang.Long element) { return PrimitiveSortedSet.OfLong.this.headSetLong(element); }
        @Override default java.lang.Long last() { return PrimitiveSortedSet.OfLong.this.lastLong(); }
        @Override default SortedSet<java.lang.Long> subSet(java.lang.Long fromElement, java.lang.Long toElement) { return PrimitiveSortedSet.OfLong.this.subSetLong(fromElement, toElement); }
        @Override default SortedSet<java.lang.Long> tailSet(java.lang.Long fromElement) { return PrimitiveSortedSet.OfLong.this.tailSetLong(fromElement); }

        ///////////////// long equivalents
        
        PrimitiveComparator.OfLong comparatorLong();
        long firstLong();
        @Override default long getFirstLong() { return firstLong(); }
        @Override default long getLastLong() { return lastLong(); }
        PrimitiveSortedSet.OfLong headSetLong(long element);
        long lastLong();
        @Override default PrimitiveSortedSet.OfLong reversedLong() { return null; }
        PrimitiveSortedSet.OfLong subSetLong(long fromElement, long toElement);
        PrimitiveSortedSet.OfLong tailSetLong(long fromElement);
    }
    interface OfInt extends PrimitiveSortedSet<java.lang.Integer, PrimitiveConsumer.OfInt>, PrimitiveSequencedSet.OfInt {
        @Override default void addFirst(java.lang.Integer e) { PrimitiveSortedSet.OfInt.this.addFirstInt(e); }
        @Override default void addLast(java.lang.Integer e) { PrimitiveSortedSet.OfInt.this.addLastInt(e); }
        @Override default java.lang.Integer getFirst() { return PrimitiveSortedSet.OfInt.this.getFirst(); }
        @Override default java.lang.Integer getLast() { return PrimitiveSortedSet.OfInt.this.getLast(); }
        @Override default java.lang.Integer removeFirst() { return PrimitiveSortedSet.OfInt.this.removeFirst(); }
        @Override default java.lang.Integer removeLast() { return PrimitiveSortedSet.OfInt.this.removeLast(); }
        @Override default SortedSet<java.lang.Integer> reversed() { return PrimitiveSortedSet.OfInt.this.reversedInt(); }
        @Override default Spliterator<java.lang.Integer> spliterator() { return PrimitiveSortedSet.OfInt.this.spliteratorInt(); }
        @Override default Comparator<java.lang.Integer> comparator() { return PrimitiveSortedSet.OfInt.this.comparatorInt(); }
        @Override default java.lang.Integer first() { return PrimitiveSortedSet.OfInt.this.firstInt(); }
        @Override default SortedSet<java.lang.Integer> headSet(java.lang.Integer element) { return PrimitiveSortedSet.OfInt.this.headSetInt(element); }
        @Override default java.lang.Integer last() { return PrimitiveSortedSet.OfInt.this.lastInt(); }
        @Override default SortedSet<java.lang.Integer> subSet(java.lang.Integer fromElement, java.lang.Integer toElement) { return PrimitiveSortedSet.OfInt.this.subSetInt(fromElement, toElement); }
        @Override default SortedSet<java.lang.Integer> tailSet(java.lang.Integer fromElement) { return PrimitiveSortedSet.OfInt.this.tailSetInt(fromElement); }

        ///////////////// int equivalents
        
        PrimitiveComparator.OfInt comparatorInt();
        int firstInt();
        @Override default int getFirstInt() { return firstInt(); }
        @Override default int getLastInt() { return lastInt(); }
        PrimitiveSortedSet.OfInt headSetInt(int element);
        int lastInt();
        @Override default PrimitiveSortedSet.OfInt reversedInt() { return null; }
        PrimitiveSortedSet.OfInt subSetInt(int fromElement, int toElement);
        PrimitiveSortedSet.OfInt tailSetInt(int fromElement);
    }
    interface OfFloat extends PrimitiveSortedSet<java.lang.Float, PrimitiveConsumer.OfFloat>, PrimitiveSequencedSet.OfFloat {
        @Override default void addFirst(java.lang.Float e) { PrimitiveSortedSet.OfFloat.this.addFirstFloat(e); }
        @Override default void addLast(java.lang.Float e) { PrimitiveSortedSet.OfFloat.this.addLastFloat(e); }
        @Override default java.lang.Float getFirst() { return PrimitiveSortedSet.OfFloat.this.getFirst(); }
        @Override default java.lang.Float getLast() { return PrimitiveSortedSet.OfFloat.this.getLast(); }
        @Override default java.lang.Float removeFirst() { return PrimitiveSortedSet.OfFloat.this.removeFirst(); }
        @Override default java.lang.Float removeLast() { return PrimitiveSortedSet.OfFloat.this.removeLast(); }
        @Override default SortedSet<java.lang.Float> reversed() { return PrimitiveSortedSet.OfFloat.this.reversedFloat(); }
        @Override default Spliterator<java.lang.Float> spliterator() { return PrimitiveSortedSet.OfFloat.this.spliteratorFloat(); }
        @Override default Comparator<java.lang.Float> comparator() { return PrimitiveSortedSet.OfFloat.this.comparatorFloat(); }
        @Override default java.lang.Float first() { return PrimitiveSortedSet.OfFloat.this.firstFloat(); }
        @Override default SortedSet<java.lang.Float> headSet(java.lang.Float element) { return PrimitiveSortedSet.OfFloat.this.headSetFloat(element); }
        @Override default java.lang.Float last() { return PrimitiveSortedSet.OfFloat.this.lastFloat(); }
        @Override default SortedSet<java.lang.Float> subSet(java.lang.Float fromElement, java.lang.Float toElement) { return PrimitiveSortedSet.OfFloat.this.subSetFloat(fromElement, toElement); }
        @Override default SortedSet<java.lang.Float> tailSet(java.lang.Float fromElement) { return PrimitiveSortedSet.OfFloat.this.tailSetFloat(fromElement); }

        ///////////////// float equivalents
        
        PrimitiveComparator.OfFloat comparatorFloat();
        float firstFloat();
        @Override default float getFirstFloat() { return firstFloat(); }
        @Override default float getLastFloat() { return lastFloat(); }
        PrimitiveSortedSet.OfFloat headSetFloat(float element);
        float lastFloat();
        @Override default PrimitiveSortedSet.OfFloat reversedFloat() { return null; }
        PrimitiveSortedSet.OfFloat subSetFloat(float fromElement, float toElement);
        PrimitiveSortedSet.OfFloat tailSetFloat(float fromElement);
    }
    interface OfChar extends PrimitiveSortedSet<java.lang.Character, PrimitiveConsumer.OfChar>, PrimitiveSequencedSet.OfChar {
        @Override default void addFirst(java.lang.Character e) { PrimitiveSortedSet.OfChar.this.addFirstChar(e); }
        @Override default void addLast(java.lang.Character e) { PrimitiveSortedSet.OfChar.this.addLastChar(e); }
        @Override default java.lang.Character getFirst() { return PrimitiveSortedSet.OfChar.this.getFirst(); }
        @Override default java.lang.Character getLast() { return PrimitiveSortedSet.OfChar.this.getLast(); }
        @Override default java.lang.Character removeFirst() { return PrimitiveSortedSet.OfChar.this.removeFirst(); }
        @Override default java.lang.Character removeLast() { return PrimitiveSortedSet.OfChar.this.removeLast(); }
        @Override default SortedSet<java.lang.Character> reversed() { return PrimitiveSortedSet.OfChar.this.reversedChar(); }
        @Override default Spliterator<java.lang.Character> spliterator() { return PrimitiveSortedSet.OfChar.this.spliteratorChar(); }
        @Override default Comparator<java.lang.Character> comparator() { return PrimitiveSortedSet.OfChar.this.comparatorChar(); }
        @Override default java.lang.Character first() { return PrimitiveSortedSet.OfChar.this.firstChar(); }
        @Override default SortedSet<java.lang.Character> headSet(java.lang.Character element) { return PrimitiveSortedSet.OfChar.this.headSetChar(element); }
        @Override default java.lang.Character last() { return PrimitiveSortedSet.OfChar.this.lastChar(); }
        @Override default SortedSet<java.lang.Character> subSet(java.lang.Character fromElement, java.lang.Character toElement) { return PrimitiveSortedSet.OfChar.this.subSetChar(fromElement, toElement); }
        @Override default SortedSet<java.lang.Character> tailSet(java.lang.Character fromElement) { return PrimitiveSortedSet.OfChar.this.tailSetChar(fromElement); }

        ///////////////// char equivalents
        
        PrimitiveComparator.OfChar comparatorChar();
        char firstChar();
        @Override default char getFirstChar() { return firstChar(); }
        @Override default char getLastChar() { return lastChar(); }
        PrimitiveSortedSet.OfChar headSetChar(char element);
        char lastChar();
        @Override default PrimitiveSortedSet.OfChar reversedChar() { return null; }
        PrimitiveSortedSet.OfChar subSetChar(char fromElement, char toElement);
        PrimitiveSortedSet.OfChar tailSetChar(char fromElement);
    }
    interface OfShort extends PrimitiveSortedSet<java.lang.Short, PrimitiveConsumer.OfShort>, PrimitiveSequencedSet.OfShort {
        @Override default void addFirst(java.lang.Short e) { PrimitiveSortedSet.OfShort.this.addFirstShort(e); }
        @Override default void addLast(java.lang.Short e) { PrimitiveSortedSet.OfShort.this.addLastShort(e); }
        @Override default java.lang.Short getFirst() { return PrimitiveSortedSet.OfShort.this.getFirst(); }
        @Override default java.lang.Short getLast() { return PrimitiveSortedSet.OfShort.this.getLast(); }
        @Override default java.lang.Short removeFirst() { return PrimitiveSortedSet.OfShort.this.removeFirst(); }
        @Override default java.lang.Short removeLast() { return PrimitiveSortedSet.OfShort.this.removeLast(); }
        @Override default SortedSet<java.lang.Short> reversed() { return PrimitiveSortedSet.OfShort.this.reversedShort(); }
        @Override default Spliterator<java.lang.Short> spliterator() { return PrimitiveSortedSet.OfShort.this.spliteratorShort(); }
        @Override default Comparator<java.lang.Short> comparator() { return PrimitiveSortedSet.OfShort.this.comparatorShort(); }
        @Override default java.lang.Short first() { return PrimitiveSortedSet.OfShort.this.firstShort(); }
        @Override default SortedSet<java.lang.Short> headSet(java.lang.Short element) { return PrimitiveSortedSet.OfShort.this.headSetShort(element); }
        @Override default java.lang.Short last() { return PrimitiveSortedSet.OfShort.this.lastShort(); }
        @Override default SortedSet<java.lang.Short> subSet(java.lang.Short fromElement, java.lang.Short toElement) { return PrimitiveSortedSet.OfShort.this.subSetShort(fromElement, toElement); }
        @Override default SortedSet<java.lang.Short> tailSet(java.lang.Short fromElement) { return PrimitiveSortedSet.OfShort.this.tailSetShort(fromElement); }

        ///////////////// short equivalents
        
        PrimitiveComparator.OfShort comparatorShort();
        short firstShort();
        @Override default short getFirstShort() { return firstShort(); }
        @Override default short getLastShort() { return lastShort(); }
        PrimitiveSortedSet.OfShort headSetShort(short element);
        short lastShort();
        @Override default PrimitiveSortedSet.OfShort reversedShort() { return null; }
        PrimitiveSortedSet.OfShort subSetShort(short fromElement, short toElement);
        PrimitiveSortedSet.OfShort tailSetShort(short fromElement);
    }
    interface OfByte extends PrimitiveSortedSet<java.lang.Byte, PrimitiveConsumer.OfByte>, PrimitiveSequencedSet.OfByte {
        @Override default void addFirst(java.lang.Byte e) { PrimitiveSortedSet.OfByte.this.addFirstByte(e); }
        @Override default void addLast(java.lang.Byte e) { PrimitiveSortedSet.OfByte.this.addLastByte(e); }
        @Override default java.lang.Byte getFirst() { return PrimitiveSortedSet.OfByte.this.getFirst(); }
        @Override default java.lang.Byte getLast() { return PrimitiveSortedSet.OfByte.this.getLast(); }
        @Override default java.lang.Byte removeFirst() { return PrimitiveSortedSet.OfByte.this.removeFirst(); }
        @Override default java.lang.Byte removeLast() { return PrimitiveSortedSet.OfByte.this.removeLast(); }
        @Override default SortedSet<java.lang.Byte> reversed() { return PrimitiveSortedSet.OfByte.this.reversedByte(); }
        @Override default Spliterator<java.lang.Byte> spliterator() { return PrimitiveSortedSet.OfByte.this.spliteratorByte(); }
        @Override default Comparator<java.lang.Byte> comparator() { return PrimitiveSortedSet.OfByte.this.comparatorByte(); }
        @Override default java.lang.Byte first() { return PrimitiveSortedSet.OfByte.this.firstByte(); }
        @Override default SortedSet<java.lang.Byte> headSet(java.lang.Byte element) { return PrimitiveSortedSet.OfByte.this.headSetByte(element); }
        @Override default java.lang.Byte last() { return PrimitiveSortedSet.OfByte.this.lastByte(); }
        @Override default SortedSet<java.lang.Byte> subSet(java.lang.Byte fromElement, java.lang.Byte toElement) { return PrimitiveSortedSet.OfByte.this.subSetByte(fromElement, toElement); }
        @Override default SortedSet<java.lang.Byte> tailSet(java.lang.Byte fromElement) { return PrimitiveSortedSet.OfByte.this.tailSetByte(fromElement); }

        ///////////////// byte equivalents
        
        PrimitiveComparator.OfByte comparatorByte();
        byte firstByte();
        @Override default byte getFirstByte() { return firstByte(); }
        @Override default byte getLastByte() { return lastByte(); }
        PrimitiveSortedSet.OfByte headSetByte(byte element);
        byte lastByte();
        @Override default PrimitiveSortedSet.OfByte reversedByte() { return null; }
        PrimitiveSortedSet.OfByte subSetByte(byte fromElement, byte toElement);
        PrimitiveSortedSet.OfByte tailSetByte(byte fromElement);
    }
    interface OfBoolean extends PrimitiveSortedSet<java.lang.Boolean, PrimitiveConsumer.OfBoolean>, PrimitiveSequencedSet.OfBoolean {
        @Override default void addFirst(java.lang.Boolean e) { PrimitiveSortedSet.OfBoolean.this.addFirstBoolean(e); }
        @Override default void addLast(java.lang.Boolean e) { PrimitiveSortedSet.OfBoolean.this.addLastBoolean(e); }
        @Override default java.lang.Boolean getFirst() { return PrimitiveSortedSet.OfBoolean.this.getFirst(); }
        @Override default java.lang.Boolean getLast() { return PrimitiveSortedSet.OfBoolean.this.getLast(); }
        @Override default java.lang.Boolean removeFirst() { return PrimitiveSortedSet.OfBoolean.this.removeFirst(); }
        @Override default java.lang.Boolean removeLast() { return PrimitiveSortedSet.OfBoolean.this.removeLast(); }
        @Override default SortedSet<java.lang.Boolean> reversed() { return PrimitiveSortedSet.OfBoolean.this.reversedBoolean(); }
        @Override default Spliterator<java.lang.Boolean> spliterator() { return PrimitiveSortedSet.OfBoolean.this.spliteratorBoolean(); }
        @Override default Comparator<java.lang.Boolean> comparator() { return PrimitiveSortedSet.OfBoolean.this.comparatorBoolean(); }
        @Override default java.lang.Boolean first() { return PrimitiveSortedSet.OfBoolean.this.firstBoolean(); }
        @Override default SortedSet<java.lang.Boolean> headSet(java.lang.Boolean element) { return PrimitiveSortedSet.OfBoolean.this.headSetBoolean(element); }
        @Override default java.lang.Boolean last() { return PrimitiveSortedSet.OfBoolean.this.lastBoolean(); }
        @Override default SortedSet<java.lang.Boolean> subSet(java.lang.Boolean fromElement, java.lang.Boolean toElement) { return PrimitiveSortedSet.OfBoolean.this.subSetBoolean(fromElement, toElement); }
        @Override default SortedSet<java.lang.Boolean> tailSet(java.lang.Boolean fromElement) { return PrimitiveSortedSet.OfBoolean.this.tailSetBoolean(fromElement); }

        ///////////////// boolean equivalents
        
        PrimitiveComparator.OfBoolean comparatorBoolean();
        boolean firstBoolean();
        @Override default boolean getFirstBoolean() { return firstBoolean(); }
        @Override default boolean getLastBoolean() { return lastBoolean(); }
        PrimitiveSortedSet.OfBoolean headSetBoolean(boolean element);
        boolean lastBoolean();
        @Override default PrimitiveSortedSet.OfBoolean reversedBoolean() { return null; }
        PrimitiveSortedSet.OfBoolean subSetBoolean(boolean fromElement, boolean toElement);
        PrimitiveSortedSet.OfBoolean tailSetBoolean(boolean fromElement);
    }
}
