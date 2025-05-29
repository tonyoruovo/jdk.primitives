package jdk.prim.util;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;

import jdk.prim.util.function.PrimitiveConsumer;

public interface PrimitiveNavigableSet<E, E_CONS> extends PrimitiveSortedSet<E, E_CONS>, NavigableSet<E> {
    interface OfDouble extends PrimitiveNavigableSet<java.lang.Double, PrimitiveConsumer.OfDouble>, PrimitiveSortedSet.OfDouble {
        @Override default java.lang.Double ceiling(java.lang.Double e) { return PrimitiveNavigableSet.OfDouble.this.ceilingDouble(e); }
        @Override default Iterator<java.lang.Double> descendingIterator() { return PrimitiveNavigableSet.OfDouble.this.descendingIteratorDouble(); }
        @Override default NavigableSet<java.lang.Double> descendingSet() { return PrimitiveNavigableSet.OfDouble.this.descendingSetDouble(); }
        @Override default java.lang.Double floor(java.lang.Double e) { return PrimitiveNavigableSet.OfDouble.this.floorDouble(e); }
        @Override default Iterator<java.lang.Double> iterator() { return PrimitiveNavigableSet.OfDouble.this.iterator(); }
        @Override default SortedSet<java.lang.Double> headSet(java.lang.Double toElement) { return PrimitiveNavigableSet.OfDouble.this.headSetDouble(toElement); }
        @Override default NavigableSet<java.lang.Double> headSet(java.lang.Double toElement, boolean inclusive) { return PrimitiveNavigableSet.OfDouble.this.headSetDouble(toElement, inclusive); }
        @Override default java.lang.Double higher(java.lang.Double e) { return PrimitiveNavigableSet.OfDouble.this.higherDouble(e); }
        @Override default java.lang.Double lower(java.lang.Double e) { return PrimitiveNavigableSet.OfDouble.this.lowerDouble(e); }
        @Override default java.lang.Double pollFirst() { return PrimitiveNavigableSet.OfDouble.this.pollFirstDouble(); }
        @Override default java.lang.Double pollLast() { return PrimitiveNavigableSet.OfDouble.this.pollLastDouble(); }
        @Override default java.lang.Double removeFirst() { return PrimitiveNavigableSet.OfDouble.this.removeFirstDouble(); }
        @Override default java.lang.Double removeLast() { return PrimitiveNavigableSet.OfDouble.this.removeLastDouble(); }
        @Override default NavigableSet<java.lang.Double> reversed() { return PrimitiveNavigableSet.OfDouble.this.reversedDouble(); }
        @Override default NavigableSet<java.lang.Double> subSet(java.lang.Double fromElement, boolean fromInclusive, java.lang.Double toElement, boolean toInclusive) { return PrimitiveNavigableSet.OfDouble.this.subSetDouble(fromElement, fromInclusive, toElement, toInclusive); }
        @Override default SortedSet<java.lang.Double> subSet(java.lang.Double fromElement, java.lang.Double toElement) { return PrimitiveNavigableSet.OfDouble.this.subSetDouble(fromElement, toElement); }
        @Override default NavigableSet<java.lang.Double> tailSet(java.lang.Double toElement, boolean inclusive) { return PrimitiveNavigableSet.OfDouble.this.tailSetDouble(toElement, inclusive); }
        @Override default SortedSet<java.lang.Double> tailSet(java.lang.Double toElement) { return PrimitiveNavigableSet.OfDouble.this.tailSetDouble(toElement); }

        double ceilingDouble(double e);
        PrimitiveIterator.OfDouble descendingIteratorDouble();
        PrimitiveNavigableSet.OfDouble descendingSetDouble();
        double floorDouble(double e);
        PrimitiveNavigableSet.OfDouble headSetDouble(double toElement, boolean inclusive);
        double higherDouble(double e);
        double lowerDouble(double e);
        double pollFirstDouble();
        double pollLastDouble();
        @Override default PrimitiveNavigableSet.OfDouble reversedDouble() { return null; }
        PrimitiveNavigableSet.OfDouble subSetDouble(double fromElement, boolean fromInclusive, double toElement, boolean toInclusive);
        PrimitiveNavigableSet.OfDouble tailSetDouble(double toElement, boolean inclusive);
    }
    interface OfLong extends PrimitiveNavigableSet<java.lang.Long, PrimitiveConsumer.OfLong>, PrimitiveSortedSet.OfLong {
        @Override default java.lang.Long ceiling(java.lang.Long e) { return PrimitiveNavigableSet.OfLong.this.ceilingLong(e); }
        @Override default Iterator<java.lang.Long> descendingIterator() { return PrimitiveNavigableSet.OfLong.this.descendingIteratorLong(); }
        @Override default NavigableSet<java.lang.Long> descendingSet() { return PrimitiveNavigableSet.OfLong.this.descendingSetLong(); }
        @Override default java.lang.Long floor(java.lang.Long e) { return PrimitiveNavigableSet.OfLong.this.floorLong(e); }
        @Override default Iterator<java.lang.Long> iterator() { return PrimitiveNavigableSet.OfLong.this.iterator(); }
        @Override default SortedSet<java.lang.Long> headSet(java.lang.Long toElement) { return PrimitiveNavigableSet.OfLong.this.headSetLong(toElement); }
        @Override default NavigableSet<java.lang.Long> headSet(java.lang.Long toElement, boolean inclusive) { return PrimitiveNavigableSet.OfLong.this.headSetLong(toElement, inclusive); }
        @Override default java.lang.Long higher(java.lang.Long e) { return PrimitiveNavigableSet.OfLong.this.higherLong(e); }
        @Override default java.lang.Long lower(java.lang.Long e) { return PrimitiveNavigableSet.OfLong.this.lowerLong(e); }
        @Override default java.lang.Long pollFirst() { return PrimitiveNavigableSet.OfLong.this.pollFirstLong(); }
        @Override default java.lang.Long pollLast() { return PrimitiveNavigableSet.OfLong.this.pollLastLong(); }
        @Override default java.lang.Long removeFirst() { return PrimitiveNavigableSet.OfLong.this.removeFirstLong(); }
        @Override default java.lang.Long removeLast() { return PrimitiveNavigableSet.OfLong.this.removeLastLong(); }
        @Override default NavigableSet<java.lang.Long> reversed() { return PrimitiveNavigableSet.OfLong.this.reversedLong(); }
        @Override default NavigableSet<java.lang.Long> subSet(java.lang.Long fromElement, boolean fromInclusive, java.lang.Long toElement, boolean toInclusive) { return PrimitiveNavigableSet.OfLong.this.subSetLong(fromElement, fromInclusive, toElement, toInclusive); }
        @Override default SortedSet<java.lang.Long> subSet(java.lang.Long fromElement, java.lang.Long toElement) { return PrimitiveNavigableSet.OfLong.this.subSetLong(fromElement, toElement); }
        @Override default NavigableSet<java.lang.Long> tailSet(java.lang.Long toElement, boolean inclusive) { return PrimitiveNavigableSet.OfLong.this.tailSetLong(toElement, inclusive); }
        @Override default SortedSet<java.lang.Long> tailSet(java.lang.Long toElement) { return PrimitiveNavigableSet.OfLong.this.tailSetLong(toElement); }

        long ceilingLong(long e);
        PrimitiveIterator.OfLong descendingIteratorLong();
        PrimitiveNavigableSet.OfLong descendingSetLong();
        long floorLong(long e);
        PrimitiveNavigableSet.OfLong headSetLong(long toElement, boolean inclusive);
        long higherLong(long e);
        long lowerLong(long e);
        long pollFirstLong();
        long pollLastLong();
        @Override default PrimitiveNavigableSet.OfLong reversedLong() { return null; }
        PrimitiveNavigableSet.OfLong subSetLong(long fromElement, boolean fromInclusive, long toElement, boolean toInclusive);
        PrimitiveNavigableSet.OfLong tailSetLong(long toElement, boolean inclusive);
    }
    interface OfInt extends PrimitiveNavigableSet<java.lang.Integer, PrimitiveConsumer.OfInt>, PrimitiveSortedSet.OfInt {
        @Override default java.lang.Integer ceiling(java.lang.Integer e) { return PrimitiveNavigableSet.OfInt.this.ceilingInt(e); }
        @Override default Iterator<java.lang.Integer> descendingIterator() { return PrimitiveNavigableSet.OfInt.this.descendingIteratorInt(); }
        @Override default NavigableSet<java.lang.Integer> descendingSet() { return PrimitiveNavigableSet.OfInt.this.descendingSetInt(); }
        @Override default java.lang.Integer floor(java.lang.Integer e) { return PrimitiveNavigableSet.OfInt.this.floorInt(e); }
        @Override default Iterator<java.lang.Integer> iterator() { return PrimitiveNavigableSet.OfInt.this.iterator(); }
        @Override default SortedSet<java.lang.Integer> headSet(java.lang.Integer toElement) { return PrimitiveNavigableSet.OfInt.this.headSetInt(toElement); }
        @Override default NavigableSet<java.lang.Integer> headSet(java.lang.Integer toElement, boolean inclusive) { return PrimitiveNavigableSet.OfInt.this.headSetInt(toElement, inclusive); }
        @Override default java.lang.Integer higher(java.lang.Integer e) { return PrimitiveNavigableSet.OfInt.this.higherInt(e); }
        @Override default java.lang.Integer lower(java.lang.Integer e) { return PrimitiveNavigableSet.OfInt.this.lowerInt(e); }
        @Override default java.lang.Integer pollFirst() { return PrimitiveNavigableSet.OfInt.this.pollFirstInt(); }
        @Override default java.lang.Integer pollLast() { return PrimitiveNavigableSet.OfInt.this.pollLastInt(); }
        @Override default java.lang.Integer removeFirst() { return PrimitiveNavigableSet.OfInt.this.removeFirstInt(); }
        @Override default java.lang.Integer removeLast() { return PrimitiveNavigableSet.OfInt.this.removeLastInt(); }
        @Override default NavigableSet<java.lang.Integer> reversed() { return PrimitiveNavigableSet.OfInt.this.reversedInt(); }
        @Override default NavigableSet<java.lang.Integer> subSet(java.lang.Integer fromElement, boolean fromInclusive, java.lang.Integer toElement, boolean toInclusive) { return PrimitiveNavigableSet.OfInt.this.subSetInt(fromElement, fromInclusive, toElement, toInclusive); }
        @Override default SortedSet<java.lang.Integer> subSet(java.lang.Integer fromElement, java.lang.Integer toElement) { return PrimitiveNavigableSet.OfInt.this.subSetInt(fromElement, toElement); }
        @Override default NavigableSet<java.lang.Integer> tailSet(java.lang.Integer toElement, boolean inclusive) { return PrimitiveNavigableSet.OfInt.this.tailSetInt(toElement, inclusive); }
        @Override default SortedSet<java.lang.Integer> tailSet(java.lang.Integer toElement) { return PrimitiveNavigableSet.OfInt.this.tailSetInt(toElement); }

        int ceilingInt(int e);
        PrimitiveIterator.OfInt descendingIteratorInt();
        PrimitiveNavigableSet.OfInt descendingSetInt();
        int floorInt(int e);
        PrimitiveNavigableSet.OfInt headSetInt(int toElement, boolean inclusive);
        int higherInt(int e);
        int lowerInt(int e);
        int pollFirstInt();
        int pollLastInt();
        @Override default PrimitiveNavigableSet.OfInt reversedInt() { return null; }
        PrimitiveNavigableSet.OfInt subSetInt(int fromElement, boolean fromInclusive, int toElement, boolean toInclusive);
        PrimitiveNavigableSet.OfInt tailSetInt(int toElement, boolean inclusive);
    }
    interface OfFloat extends PrimitiveNavigableSet<java.lang.Float, PrimitiveConsumer.OfFloat>, PrimitiveSortedSet.OfFloat {
        @Override default java.lang.Float ceiling(java.lang.Float e) { return PrimitiveNavigableSet.OfFloat.this.ceilingFloat(e); }
        @Override default Iterator<java.lang.Float> descendingIterator() { return PrimitiveNavigableSet.OfFloat.this.descendingIteratorFloat(); }
        @Override default NavigableSet<java.lang.Float> descendingSet() { return PrimitiveNavigableSet.OfFloat.this.descendingSetFloat(); }
        @Override default java.lang.Float floor(java.lang.Float e) { return PrimitiveNavigableSet.OfFloat.this.floorFloat(e); }
        @Override default Iterator<java.lang.Float> iterator() { return PrimitiveNavigableSet.OfFloat.this.iterator(); }
        @Override default SortedSet<java.lang.Float> headSet(java.lang.Float toElement) { return PrimitiveNavigableSet.OfFloat.this.headSetFloat(toElement); }
        @Override default NavigableSet<java.lang.Float> headSet(java.lang.Float toElement, boolean inclusive) { return PrimitiveNavigableSet.OfFloat.this.headSetFloat(toElement, inclusive); }
        @Override default java.lang.Float higher(java.lang.Float e) { return PrimitiveNavigableSet.OfFloat.this.higherFloat(e); }
        @Override default java.lang.Float lower(java.lang.Float e) { return PrimitiveNavigableSet.OfFloat.this.lowerFloat(e); }
        @Override default java.lang.Float pollFirst() { return PrimitiveNavigableSet.OfFloat.this.pollFirstFloat(); }
        @Override default java.lang.Float pollLast() { return PrimitiveNavigableSet.OfFloat.this.pollLastFloat(); }
        @Override default java.lang.Float removeFirst() { return PrimitiveNavigableSet.OfFloat.this.removeFirstFloat(); }
        @Override default java.lang.Float removeLast() { return PrimitiveNavigableSet.OfFloat.this.removeLastFloat(); }
        @Override default NavigableSet<java.lang.Float> reversed() { return PrimitiveNavigableSet.OfFloat.this.reversedFloat(); }
        @Override default NavigableSet<java.lang.Float> subSet(java.lang.Float fromElement, boolean fromInclusive, java.lang.Float toElement, boolean toInclusive) { return PrimitiveNavigableSet.OfFloat.this.subSetFloat(fromElement, fromInclusive, toElement, toInclusive); }
        @Override default SortedSet<java.lang.Float> subSet(java.lang.Float fromElement, java.lang.Float toElement) { return PrimitiveNavigableSet.OfFloat.this.subSetFloat(fromElement, toElement); }
        @Override default NavigableSet<java.lang.Float> tailSet(java.lang.Float toElement, boolean inclusive) { return PrimitiveNavigableSet.OfFloat.this.tailSetFloat(toElement, inclusive); }
        @Override default SortedSet<java.lang.Float> tailSet(java.lang.Float toElement) { return PrimitiveNavigableSet.OfFloat.this.tailSetFloat(toElement); }

        float ceilingFloat(float e);
        PrimitiveIterator.OfFloat descendingIteratorFloat();
        PrimitiveNavigableSet.OfFloat descendingSetFloat();
        float floorFloat(float e);
        PrimitiveNavigableSet.OfFloat headSetFloat(float toElement, boolean inclusive);
        float higherFloat(float e);
        float lowerFloat(float e);
        float pollFirstFloat();
        float pollLastFloat();
        @Override default PrimitiveNavigableSet.OfFloat reversedFloat() { return null; }
        PrimitiveNavigableSet.OfFloat subSetFloat(float fromElement, boolean fromInclusive, float toElement, boolean toInclusive);
        PrimitiveNavigableSet.OfFloat tailSetFloat(float toElement, boolean inclusive);
    }
    interface OfChar extends PrimitiveNavigableSet<java.lang.Character, PrimitiveConsumer.OfChar>, PrimitiveSortedSet.OfChar {
        @Override default java.lang.Character ceiling(java.lang.Character e) { return PrimitiveNavigableSet.OfChar.this.ceilingChar(e); }
        @Override default Iterator<java.lang.Character> descendingIterator() { return PrimitiveNavigableSet.OfChar.this.descendingIteratorChar(); }
        @Override default NavigableSet<java.lang.Character> descendingSet() { return PrimitiveNavigableSet.OfChar.this.descendingSetChar(); }
        @Override default java.lang.Character floor(java.lang.Character e) { return PrimitiveNavigableSet.OfChar.this.floorChar(e); }
        @Override default Iterator<java.lang.Character> iterator() { return PrimitiveNavigableSet.OfChar.this.iterator(); }
        @Override default SortedSet<java.lang.Character> headSet(java.lang.Character toElement) { return PrimitiveNavigableSet.OfChar.this.headSetChar(toElement); }
        @Override default NavigableSet<java.lang.Character> headSet(java.lang.Character toElement, boolean inclusive) { return PrimitiveNavigableSet.OfChar.this.headSetChar(toElement, inclusive); }
        @Override default java.lang.Character higher(java.lang.Character e) { return PrimitiveNavigableSet.OfChar.this.higherChar(e); }
        @Override default java.lang.Character lower(java.lang.Character e) { return PrimitiveNavigableSet.OfChar.this.lowerChar(e); }
        @Override default java.lang.Character pollFirst() { return PrimitiveNavigableSet.OfChar.this.pollFirstChar(); }
        @Override default java.lang.Character pollLast() { return PrimitiveNavigableSet.OfChar.this.pollLastChar(); }
        @Override default java.lang.Character removeFirst() { return PrimitiveNavigableSet.OfChar.this.removeFirstChar(); }
        @Override default java.lang.Character removeLast() { return PrimitiveNavigableSet.OfChar.this.removeLastChar(); }
        @Override default NavigableSet<java.lang.Character> reversed() { return PrimitiveNavigableSet.OfChar.this.reversedChar(); }
        @Override default NavigableSet<java.lang.Character> subSet(java.lang.Character fromElement, boolean fromInclusive, java.lang.Character toElement, boolean toInclusive) { return PrimitiveNavigableSet.OfChar.this.subSetChar(fromElement, fromInclusive, toElement, toInclusive); }
        @Override default SortedSet<java.lang.Character> subSet(java.lang.Character fromElement, java.lang.Character toElement) { return PrimitiveNavigableSet.OfChar.this.subSetChar(fromElement, toElement); }
        @Override default NavigableSet<java.lang.Character> tailSet(java.lang.Character toElement, boolean inclusive) { return PrimitiveNavigableSet.OfChar.this.tailSetChar(toElement, inclusive); }
        @Override default SortedSet<java.lang.Character> tailSet(java.lang.Character toElement) { return PrimitiveNavigableSet.OfChar.this.tailSetChar(toElement); }

        char ceilingChar(char e);
        PrimitiveIterator.OfChar descendingIteratorChar();
        PrimitiveNavigableSet.OfChar descendingSetChar();
        char floorChar(char e);
        PrimitiveNavigableSet.OfChar headSetChar(char toElement, boolean inclusive);
        char higherChar(char e);
        char lowerChar(char e);
        char pollFirstChar();
        char pollLastChar();
        @Override default PrimitiveNavigableSet.OfChar reversedChar() { return null; }
        PrimitiveNavigableSet.OfChar subSetChar(char fromElement, boolean fromInclusive, char toElement, boolean toInclusive);
        PrimitiveNavigableSet.OfChar tailSetChar(char toElement, boolean inclusive);
    }
    interface OfShort extends PrimitiveNavigableSet<java.lang.Short, PrimitiveConsumer.OfShort>, PrimitiveSortedSet.OfShort {
        @Override default java.lang.Short ceiling(java.lang.Short e) { return PrimitiveNavigableSet.OfShort.this.ceilingShort(e); }
        @Override default Iterator<java.lang.Short> descendingIterator() { return PrimitiveNavigableSet.OfShort.this.descendingIteratorShort(); }
        @Override default NavigableSet<java.lang.Short> descendingSet() { return PrimitiveNavigableSet.OfShort.this.descendingSetShort(); }
        @Override default java.lang.Short floor(java.lang.Short e) { return PrimitiveNavigableSet.OfShort.this.floorShort(e); }
        @Override default Iterator<java.lang.Short> iterator() { return PrimitiveNavigableSet.OfShort.this.iterator(); }
        @Override default SortedSet<java.lang.Short> headSet(java.lang.Short toElement) { return PrimitiveNavigableSet.OfShort.this.headSetShort(toElement); }
        @Override default NavigableSet<java.lang.Short> headSet(java.lang.Short toElement, boolean inclusive) { return PrimitiveNavigableSet.OfShort.this.headSetShort(toElement, inclusive); }
        @Override default java.lang.Short higher(java.lang.Short e) { return PrimitiveNavigableSet.OfShort.this.higherShort(e); }
        @Override default java.lang.Short lower(java.lang.Short e) { return PrimitiveNavigableSet.OfShort.this.lowerShort(e); }
        @Override default java.lang.Short pollFirst() { return PrimitiveNavigableSet.OfShort.this.pollFirstShort(); }
        @Override default java.lang.Short pollLast() { return PrimitiveNavigableSet.OfShort.this.pollLastShort(); }
        @Override default java.lang.Short removeFirst() { return PrimitiveNavigableSet.OfShort.this.removeFirstShort(); }
        @Override default java.lang.Short removeLast() { return PrimitiveNavigableSet.OfShort.this.removeLastShort(); }
        @Override default NavigableSet<java.lang.Short> reversed() { return PrimitiveNavigableSet.OfShort.this.reversedShort(); }
        @Override default NavigableSet<java.lang.Short> subSet(java.lang.Short fromElement, boolean fromInclusive, java.lang.Short toElement, boolean toInclusive) { return PrimitiveNavigableSet.OfShort.this.subSetShort(fromElement, fromInclusive, toElement, toInclusive); }
        @Override default SortedSet<java.lang.Short> subSet(java.lang.Short fromElement, java.lang.Short toElement) { return PrimitiveNavigableSet.OfShort.this.subSetShort(fromElement, toElement); }
        @Override default NavigableSet<java.lang.Short> tailSet(java.lang.Short toElement, boolean inclusive) { return PrimitiveNavigableSet.OfShort.this.tailSetShort(toElement, inclusive); }
        @Override default SortedSet<java.lang.Short> tailSet(java.lang.Short toElement) { return PrimitiveNavigableSet.OfShort.this.tailSetShort(toElement); }

        short ceilingShort(short e);
        PrimitiveIterator.OfShort descendingIteratorShort();
        PrimitiveNavigableSet.OfShort descendingSetShort();
        short floorShort(short e);
        PrimitiveNavigableSet.OfShort headSetShort(short toElement, boolean inclusive);
        short higherShort(short e);
        short lowerShort(short e);
        short pollFirstShort();
        short pollLastShort();
        @Override default PrimitiveNavigableSet.OfShort reversedShort() { return null; }
        PrimitiveNavigableSet.OfShort subSetShort(short fromElement, boolean fromInclusive, short toElement, boolean toInclusive);
        PrimitiveNavigableSet.OfShort tailSetShort(short toElement, boolean inclusive);
    }
    interface OfByte extends PrimitiveNavigableSet<java.lang.Byte, PrimitiveConsumer.OfByte>, PrimitiveSortedSet.OfByte {
        @Override default java.lang.Byte ceiling(java.lang.Byte e) { return PrimitiveNavigableSet.OfByte.this.ceilingByte(e); }
        @Override default Iterator<java.lang.Byte> descendingIterator() { return PrimitiveNavigableSet.OfByte.this.descendingIteratorByte(); }
        @Override default NavigableSet<java.lang.Byte> descendingSet() { return PrimitiveNavigableSet.OfByte.this.descendingSetByte(); }
        @Override default java.lang.Byte floor(java.lang.Byte e) { return PrimitiveNavigableSet.OfByte.this.floorByte(e); }
        @Override default Iterator<java.lang.Byte> iterator() { return PrimitiveNavigableSet.OfByte.this.iterator(); }
        @Override default SortedSet<java.lang.Byte> headSet(java.lang.Byte toElement) { return PrimitiveNavigableSet.OfByte.this.headSetByte(toElement); }
        @Override default NavigableSet<java.lang.Byte> headSet(java.lang.Byte toElement, boolean inclusive) { return PrimitiveNavigableSet.OfByte.this.headSetByte(toElement, inclusive); }
        @Override default java.lang.Byte higher(java.lang.Byte e) { return PrimitiveNavigableSet.OfByte.this.higherByte(e); }
        @Override default java.lang.Byte lower(java.lang.Byte e) { return PrimitiveNavigableSet.OfByte.this.lowerByte(e); }
        @Override default java.lang.Byte pollFirst() { return PrimitiveNavigableSet.OfByte.this.pollFirstByte(); }
        @Override default java.lang.Byte pollLast() { return PrimitiveNavigableSet.OfByte.this.pollLastByte(); }
        @Override default java.lang.Byte removeFirst() { return PrimitiveNavigableSet.OfByte.this.removeFirstByte(); }
        @Override default java.lang.Byte removeLast() { return PrimitiveNavigableSet.OfByte.this.removeLastByte(); }
        @Override default NavigableSet<java.lang.Byte> reversed() { return PrimitiveNavigableSet.OfByte.this.reversedByte(); }
        @Override default NavigableSet<java.lang.Byte> subSet(java.lang.Byte fromElement, boolean fromInclusive, java.lang.Byte toElement, boolean toInclusive) { return PrimitiveNavigableSet.OfByte.this.subSetByte(fromElement, fromInclusive, toElement, toInclusive); }
        @Override default SortedSet<java.lang.Byte> subSet(java.lang.Byte fromElement, java.lang.Byte toElement) { return PrimitiveNavigableSet.OfByte.this.subSetByte(fromElement, toElement); }
        @Override default NavigableSet<java.lang.Byte> tailSet(java.lang.Byte toElement, boolean inclusive) { return PrimitiveNavigableSet.OfByte.this.tailSetByte(toElement, inclusive); }
        @Override default SortedSet<java.lang.Byte> tailSet(java.lang.Byte toElement) { return PrimitiveNavigableSet.OfByte.this.tailSetByte(toElement); }

        byte ceilingByte(byte e);
        PrimitiveIterator.OfByte descendingIteratorByte();
        PrimitiveNavigableSet.OfByte descendingSetByte();
        byte floorByte(byte e);
        PrimitiveNavigableSet.OfByte headSetByte(byte toElement, boolean inclusive);
        byte higherByte(byte e);
        byte lowerByte(byte e);
        byte pollFirstByte();
        byte pollLastByte();
        @Override default PrimitiveNavigableSet.OfByte reversedByte() { return null; }
        PrimitiveNavigableSet.OfByte subSetByte(byte fromElement, boolean fromInclusive, byte toElement, boolean toInclusive);
        PrimitiveNavigableSet.OfByte tailSetByte(byte toElement, boolean inclusive);
    }
    interface OfBoolean extends PrimitiveNavigableSet<java.lang.Boolean, PrimitiveConsumer.OfBoolean>, PrimitiveSortedSet.OfBoolean {
        @Override default java.lang.Boolean ceiling(java.lang.Boolean e) { return PrimitiveNavigableSet.OfBoolean.this.ceilingBoolean(e); }
        @Override default Iterator<java.lang.Boolean> descendingIterator() { return PrimitiveNavigableSet.OfBoolean.this.descendingIteratorBoolean(); }
        @Override default NavigableSet<java.lang.Boolean> descendingSet() { return PrimitiveNavigableSet.OfBoolean.this.descendingSetBoolean(); }
        @Override default java.lang.Boolean floor(java.lang.Boolean e) { return PrimitiveNavigableSet.OfBoolean.this.floorBoolean(e); }
        @Override default Iterator<java.lang.Boolean> iterator() { return PrimitiveNavigableSet.OfBoolean.this.iterator(); }
        @Override default SortedSet<java.lang.Boolean> headSet(java.lang.Boolean toElement) { return PrimitiveNavigableSet.OfBoolean.this.headSetBoolean(toElement); }
        @Override default NavigableSet<java.lang.Boolean> headSet(java.lang.Boolean toElement, boolean inclusive) { return PrimitiveNavigableSet.OfBoolean.this.headSetBoolean(toElement, inclusive); }
        @Override default java.lang.Boolean higher(java.lang.Boolean e) { return PrimitiveNavigableSet.OfBoolean.this.higherBoolean(e); }
        @Override default java.lang.Boolean lower(java.lang.Boolean e) { return PrimitiveNavigableSet.OfBoolean.this.lowerBoolean(e); }
        @Override default java.lang.Boolean pollFirst() { return PrimitiveNavigableSet.OfBoolean.this.pollFirstBoolean(); }
        @Override default java.lang.Boolean pollLast() { return PrimitiveNavigableSet.OfBoolean.this.pollLastBoolean(); }
        @Override default java.lang.Boolean removeFirst() { return PrimitiveNavigableSet.OfBoolean.this.removeFirstBoolean(); }
        @Override default java.lang.Boolean removeLast() { return PrimitiveNavigableSet.OfBoolean.this.removeLastBoolean(); }
        @Override default NavigableSet<java.lang.Boolean> reversed() { return PrimitiveNavigableSet.OfBoolean.this.reversedBoolean(); }
        @Override default NavigableSet<java.lang.Boolean> subSet(java.lang.Boolean fromElement, boolean fromInclusive, java.lang.Boolean toElement, boolean toInclusive) { return PrimitiveNavigableSet.OfBoolean.this.subSetBoolean(fromElement, fromInclusive, toElement, toInclusive); }
        @Override default SortedSet<java.lang.Boolean> subSet(java.lang.Boolean fromElement, java.lang.Boolean toElement) { return PrimitiveNavigableSet.OfBoolean.this.subSetBoolean(fromElement, toElement); }
        @Override default NavigableSet<java.lang.Boolean> tailSet(java.lang.Boolean toElement, boolean inclusive) { return PrimitiveNavigableSet.OfBoolean.this.tailSetBoolean(toElement, inclusive); }
        @Override default SortedSet<java.lang.Boolean> tailSet(java.lang.Boolean toElement) { return PrimitiveNavigableSet.OfBoolean.this.tailSetBoolean(toElement); }

        boolean ceilingBoolean(boolean e);
        PrimitiveIterator.OfBoolean descendingIteratorBoolean();
        PrimitiveNavigableSet.OfBoolean descendingSetBoolean();
        boolean floorBoolean(boolean e);
        PrimitiveNavigableSet.OfBoolean headSetBoolean(boolean toElement, boolean inclusive);
        boolean higherBoolean(boolean e);
        boolean lowerBoolean(boolean e);
        boolean pollFirstBoolean();
        boolean pollLastBoolean();
        @Override default PrimitiveNavigableSet.OfBoolean reversedBoolean() { return null; }
        PrimitiveNavigableSet.OfBoolean subSetBoolean(boolean fromElement, boolean fromInclusive, boolean toElement, boolean toInclusive);
        PrimitiveNavigableSet.OfBoolean tailSetBoolean(boolean toElement, boolean inclusive);
    }
}
