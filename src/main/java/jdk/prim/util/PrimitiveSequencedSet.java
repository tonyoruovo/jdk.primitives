package jdk.prim.util;

import java.util.SequencedSet;

import jdk.prim.util.function.PrimitiveConsumer;

public interface PrimitiveSequencedSet<E, E_CONS> extends PrimitiveSet<E, E_CONS>, PrimitiveSequencedCollection<E, E_CONS>, SequencedSet<E> {
    interface OfDouble extends PrimitiveSequencedSet<java.lang.Double, PrimitiveConsumer.OfDouble>, PrimitiveSet.OfDouble, PrimitiveSequencedCollection.OfDouble {
        @Override default SequencedSet<java.lang.Double> reversed() { return PrimitiveSequencedSet.OfDouble.this.reversedDouble(); }
        @Override PrimitiveSequencedSet.OfDouble reversedDouble();
    }
    interface OfLong extends PrimitiveSequencedSet<java.lang.Long, PrimitiveConsumer.OfLong>, PrimitiveSet.OfLong, PrimitiveSequencedCollection.OfLong {
        @Override default SequencedSet<java.lang.Long> reversed() { return PrimitiveSequencedSet.OfLong.this.reversedLong(); }
        @Override PrimitiveSequencedSet.OfLong reversedLong();
    }
    interface OfInt extends PrimitiveSequencedSet<java.lang.Integer, PrimitiveConsumer.OfInt>, PrimitiveSet.OfInt, PrimitiveSequencedCollection.OfInt {
        @Override default SequencedSet<java.lang.Integer> reversed() { return PrimitiveSequencedSet.OfInt.this.reversedInt(); }
        @Override PrimitiveSequencedSet.OfInt reversedInt();
    }
    interface OfFloat extends PrimitiveSequencedSet<java.lang.Float, PrimitiveConsumer.OfFloat>, PrimitiveSet.OfFloat, PrimitiveSequencedCollection.OfFloat {
        @Override default SequencedSet<java.lang.Float> reversed() { return PrimitiveSequencedSet.OfFloat.this.reversedFloat(); }
        @Override PrimitiveSequencedSet.OfFloat reversedFloat();
    }
    interface OfChar extends PrimitiveSequencedSet<java.lang.Character, PrimitiveConsumer.OfChar>, PrimitiveSet.OfChar, PrimitiveSequencedCollection.OfChar {
        @Override default SequencedSet<java.lang.Character> reversed() { return PrimitiveSequencedSet.OfChar.this.reversedChar(); }
        @Override PrimitiveSequencedSet.OfChar reversedChar();
    }
    interface OfShort extends PrimitiveSequencedSet<java.lang.Short, PrimitiveConsumer.OfShort>, PrimitiveSet.OfShort, PrimitiveSequencedCollection.OfShort {
        @Override default SequencedSet<java.lang.Short> reversed() { return PrimitiveSequencedSet.OfShort.this.reversedShort(); }
        @Override PrimitiveSequencedSet.OfShort reversedShort();
    }
    interface OfByte extends PrimitiveSequencedSet<java.lang.Byte, PrimitiveConsumer.OfByte>, PrimitiveSet.OfByte, PrimitiveSequencedCollection.OfByte {
        @Override default SequencedSet<java.lang.Byte> reversed() { return PrimitiveSequencedSet.OfByte.this.reversedByte(); }
        @Override PrimitiveSequencedSet.OfByte reversedByte();
    }
    interface OfBoolean extends PrimitiveSequencedSet<java.lang.Boolean, PrimitiveConsumer.OfBoolean>, PrimitiveSet.OfBoolean, PrimitiveSequencedCollection.OfBoolean {
        @Override default SequencedSet<java.lang.Boolean> reversed() { return PrimitiveSequencedSet.OfBoolean.this.reversedBoolean(); }
        @Override PrimitiveSequencedSet.OfBoolean reversedBoolean();
    }
}
