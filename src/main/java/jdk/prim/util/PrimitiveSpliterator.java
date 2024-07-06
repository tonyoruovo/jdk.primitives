/**
 * 
 */
package jdk.prim.util;

import java.util.Spliterator;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

import jdk.prim.util.function.PrimitiveConsumer;

/**
 * 
 */
public interface PrimitiveSpliterator<T, T_CONS, T_SPLITR extends Spliterator.OfPrimitive<T, T_CONS, T_SPLITR>>
		extends Spliterator.OfPrimitive<T, T_CONS, T_SPLITR> {
			
			interface OfDouble extends PrimitiveSpliterator<Double, DoubleConsumer, Spliterator.OfDouble>, Spliterator.OfDouble {
				PrimitiveSpliterator.OfDouble trySplit();
			}
			interface OfLong extends PrimitiveSpliterator<Long, LongConsumer, Spliterator.OfLong>, Spliterator.OfLong {
				PrimitiveSpliterator.OfLong trySplit();
			}
			interface OfInt extends PrimitiveSpliterator<Integer, IntConsumer, Spliterator.OfInt>, Spliterator.OfInt {
				PrimitiveSpliterator.OfInt trySplit();
			}
			interface OfFloat extends PrimitiveSpliterator<Float, PrimitiveConsumer.OfFloat, OfFloat> {
				OfFloat trySplit();
			}
			interface OfChar extends PrimitiveSpliterator<Character, PrimitiveConsumer.OfChar, OfChar> {
				OfChar trySplit();
			}
			interface OfShort extends PrimitiveSpliterator<Short, PrimitiveConsumer.OfShort, OfShort> {
				OfShort trySplit();
			}
			interface OfByte extends PrimitiveSpliterator<Byte, PrimitiveConsumer.OfByte, OfByte> {
				OfByte trySplit();
			}
			interface OfBoolean extends PrimitiveSpliterator<Boolean, PrimitiveConsumer.OfBoolean, OfBoolean> {
				OfBoolean trySplit();
			}
}
