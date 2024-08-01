package jdk.prim.util.concurrent;

import java.util.concurrent.ScheduledFuture;

/**
 * A common interface for all primitive {@code ScheduledFuture} types
 * 
 * @see ScheduledFuture
 */
public interface PrimitiveScheduledFuture<TO> extends ScheduledFuture<TO>, PrimitiveFuture<TO> {
    /**
     * A {@code PrimitiveScheduledFuture} for a {@code double}
     */
    interface ToDouble extends PrimitiveScheduledFuture<java.lang.Double>, PrimitiveFuture.ToDouble {
    }
    /**
     * A {@code PrimitiveScheduledFuture} for a {@code long}
     */
    interface ToLong extends PrimitiveScheduledFuture<java.lang.Long>, PrimitiveFuture.ToLong {
    }
    /**
     * A {@code PrimitiveScheduledFuture} for a {@code int}
     */
    interface ToInt extends PrimitiveScheduledFuture<java.lang.Integer>, PrimitiveFuture.ToInt {
    }
    /**
     * A {@code PrimitiveScheduledFuture} for a {@code float}
     */
    interface ToFloat extends PrimitiveScheduledFuture<java.lang.Float>, PrimitiveFuture.ToFloat {
    }
    /**
     * A {@code PrimitiveScheduledFuture} for a {@code char}
     */
    interface ToChar extends PrimitiveScheduledFuture<java.lang.Character>, PrimitiveFuture.ToChar {
    }
    /**
     * A {@code PrimitiveScheduledFuture} for a {@code short}
     */
    interface ToShort extends PrimitiveScheduledFuture<java.lang.Short>, PrimitiveFuture.ToShort {
    }
    /**
     * A {@code PrimitiveScheduledFuture} for a {@code byte}
     */
    interface ToByte extends PrimitiveScheduledFuture<java.lang.Byte>, PrimitiveFuture.ToByte {
    }
    /**
     * A {@code PrimitiveScheduledFuture} for a {@code boolean}
     */
    interface ToBoolean extends PrimitiveScheduledFuture<java.lang.Boolean>, PrimitiveFuture.ToBoolean {
    }
}
