/**
 * 
 */
package jdk.prim.util;

import java.util.Spliterator;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

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
			interface OfFloat extends PrimitiveSpliterator<Float, jdk.prim.util.function.Float.Consumer, OfFloat> {
				OfFloat trySplit();
			}
			interface OfChar extends PrimitiveSpliterator<Character, jdk.prim.util.function.Char.Consumer, OfChar> {
				OfChar trySplit();
			}
			interface OfShort extends PrimitiveSpliterator<Short, jdk.prim.util.function.Short.Consumer, OfShort> {
				OfShort trySplit();
			}
			interface OfByte extends PrimitiveSpliterator<Byte, jdk.prim.util.function.Byte.Consumer, OfByte> {
				OfByte trySplit();
			}
			interface OfBoolean extends PrimitiveSpliterator<Boolean, jdk.prim.util.function.Boolean.Consumer, OfBoolean> {
				OfBoolean trySplit();
			}
}
