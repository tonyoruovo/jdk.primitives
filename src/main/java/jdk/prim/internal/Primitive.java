package jdk.prim.internal;

/*
 * Double
 * Long
 * Int
 * Float
 * Char
 * Short
 * Byte
 * Boolean
 */

/**
 * Gives you control over how a cast may be done
 * 
 * @param <BOX> the wrapper. This is usually the extended interface
 * @param <P> the primitive wrapper (such as {@code Integer} for {@code int}, {@code Double} for {@code double} etc)
 */
public interface Primitive<BOX, P, T extends Primitive<BOX, P, T>> {
    /**
     * Creates and returns a wrapper version of this primitive or the object that defines the generic that is the wrapper for this primitive.
     * <p>
     * This is analogous to {@link java.util.stream.DoubleStream#boxed() DoubleStream.boxed()}
     * @return the wrapper for this primitive or the object that defines the generic that is the wrapper for this primitive.
     */
    BOX boxed();
    Primitive<BOX, java.lang.Double, ? extends Primitive<BOX, java.lang.Double, ?>> toDouble();
    Primitive<BOX, java.lang.Long, ? extends Primitive<BOX, java.lang.Long, ?>> toLong();
    Primitive<BOX, java.lang.Integer, ? extends Primitive<BOX, java.lang.Integer, ?>> toInt();
    Primitive<BOX, java.lang.Float, ? extends Primitive<BOX, java.lang.Float, ?>> toFloat();
    Primitive<BOX, java.lang.Character, ? extends Primitive<BOX, java.lang.Character, ?>> toChar();
    Primitive<BOX, java.lang.Short, ? extends Primitive<BOX, java.lang.Short, ?>> toShort();
    Primitive<BOX, java.lang.Byte, ? extends Primitive<BOX, java.lang.Byte, ?>> toByte();
    Primitive<BOX, java.lang.Boolean, ? extends Primitive<BOX, java.lang.Boolean, ?>> toBoolean();
}
