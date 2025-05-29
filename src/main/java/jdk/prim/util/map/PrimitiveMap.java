package jdk.prim.util.map;

import java.util.Map;

import jdk.prim.Boxed;
/**
 * The primitive equivalent of {@link java.util.Map}
 */
public interface PrimitiveMap<K, V> extends Map<K, V>, Boxed<Map<K, V>> {
    interface OfDouble<V> extends PrimitiveMap<java.lang.Double, V> {}
    interface OfLong<V> extends PrimitiveMap<java.lang.Long, V> {}
    interface OfInt<V> extends PrimitiveMap<java.lang.Integer, V> {}
    interface OfFloat<V> extends PrimitiveMap<java.lang.Float, V> {}
    interface OfChar<V> extends PrimitiveMap<java.lang.Character, V> {}
    interface OfShort<V> extends PrimitiveMap<java.lang.Short, V> {}
    interface OfByte<V> extends PrimitiveMap<java.lang.Byte, V> {}
    interface OfBoolean<V> extends PrimitiveMap<java.lang.Boolean, V> {}
    
    interface AndDouble<K> extends PrimitiveMap<K, java.lang.Double> {}
    interface AndLong<K> extends PrimitiveMap<K, java.lang.Long> {}
    interface AndInt<K> extends PrimitiveMap<K, java.lang.Integer> {}
    interface AndFloat<K> extends PrimitiveMap<K, java.lang.Float> {}
    interface AndChar<K> extends PrimitiveMap<K, java.lang.Character> {}
    interface AndShort<K> extends PrimitiveMap<K, java.lang.Short> {}
    interface AndByte<K> extends PrimitiveMap<K, java.lang.Byte> {}
    interface AndBoolean<K> extends PrimitiveMap<K, java.lang.Boolean> {}
}
