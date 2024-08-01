package jdk.prim.util.concurrent;

import java.util.concurrent.RunnableScheduledFuture;

/**
 * A common interface for all primitive {@code RunnableScheduledFuture} types
 * 
 * @see RunnableScheduledFuture
 */
public interface PrimitiveRunnableScheduledFuture<TO> extends RunnableScheduledFuture<TO>, PrimitiveRunnableFuture<TO>, PrimitiveScheduledFuture<TO> {
    /**
     * A {@code PrimitiveRunnableScheduledFuture} for a {@code double}
     */
    interface ToDouble extends PrimitiveRunnableScheduledFuture<java.lang.Double>, PrimitiveRunnableFuture.ToDouble, PrimitiveScheduledFuture.ToDouble {
    }
    /**
     * A {@code PrimitiveRunnableScheduledFuture} for a {@code long}
     */
    interface ToLong extends PrimitiveRunnableScheduledFuture<java.lang.Long>, PrimitiveRunnableFuture.ToLong, PrimitiveScheduledFuture.ToLong {
    }
    /**
     * A {@code PrimitiveRunnableScheduledFuture} for a {@code int}
     */
    interface ToInt extends PrimitiveRunnableScheduledFuture<java.lang.Integer>, PrimitiveRunnableFuture.ToInt, PrimitiveScheduledFuture.ToInt {
    }
    /**
     * A {@code PrimitiveRunnableScheduledFuture} for a {@code float}
     */
    interface ToFloat extends PrimitiveRunnableScheduledFuture<java.lang.Float>, PrimitiveRunnableFuture.ToFloat, PrimitiveScheduledFuture.ToFloat {
    }
    /**
     * A {@code PrimitiveRunnableScheduledFuture} for a {@code char}
     */
    interface ToChar extends PrimitiveRunnableScheduledFuture<java.lang.Character>, PrimitiveRunnableFuture.ToChar, PrimitiveScheduledFuture.ToChar {
    }
    /**
     * A {@code PrimitiveRunnableScheduledFuture} for a {@code short}
     */
    interface ToShort extends PrimitiveRunnableScheduledFuture<java.lang.Short>, PrimitiveRunnableFuture.ToShort, PrimitiveScheduledFuture.ToShort {
    }
    /**
     * A {@code PrimitiveRunnableScheduledFuture} for a {@code byte}
     */
    interface ToByte extends PrimitiveRunnableScheduledFuture<java.lang.Byte>, PrimitiveRunnableFuture.ToByte, PrimitiveScheduledFuture.ToByte {
    }
    /**
     * A {@code PrimitiveRunnableScheduledFuture} for a {@code boolean}
     */
    interface ToBoolean extends PrimitiveRunnableScheduledFuture<java.lang.Boolean>, PrimitiveRunnableFuture.ToBoolean, PrimitiveScheduledFuture.ToBoolean {
    }
}
