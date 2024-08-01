package jdk.prim.util.concurrent;

import java.util.concurrent.RunnableFuture;

/**
 * A common interface for all primitive {@code RunnableFuture} types
 * 
 * @see RunnableFuture
 */
public interface PrimitiveRunnableFuture<TO> extends RunnableFuture<TO>, PrimitiveFuture<TO> {
    /**
     * A {@code PrimitiveRunnableFuture} for a {@code double}
     */
    interface ToDouble extends PrimitiveRunnableFuture<java.lang.Double>, PrimitiveFuture.ToDouble {
    }
    /**
     * A {@code PrimitiveRunnableFuture} for a {@code long}
     */
    interface ToLong extends PrimitiveRunnableFuture<java.lang.Long>, PrimitiveFuture.ToLong {
    }
    /**
     * A {@code PrimitiveRunnableFuture} for a {@code int}
     */
    interface ToInt extends PrimitiveRunnableFuture<java.lang.Integer>, PrimitiveFuture.ToInt {
    }
    /**
     * A {@code PrimitiveRunnableFuture} for a {@code float}
     */
    interface ToFloat extends PrimitiveRunnableFuture<java.lang.Float>, PrimitiveFuture.ToFloat {
    }
    /**
     * A {@code PrimitiveRunnableFuture} for a {@code char}
     */
    interface ToChar extends PrimitiveRunnableFuture<java.lang.Character>, PrimitiveFuture.ToChar {
    }
    /**
     * A {@code PrimitiveRunnableFuture} for a {@code short}
     */
    interface ToShort extends PrimitiveRunnableFuture<java.lang.Short>, PrimitiveFuture.ToShort {
    }
    /**
     * A {@code PrimitiveRunnableFuture} for a {@code byte}
     */
    interface ToByte extends PrimitiveRunnableFuture<java.lang.Byte>, PrimitiveFuture.ToByte {
    }
    /**
     * A {@code PrimitiveRunnableFuture} for a {@code boolean}
     */
    interface ToBoolean extends PrimitiveRunnableFuture<java.lang.Boolean>, PrimitiveFuture.ToBoolean {
    }
}
