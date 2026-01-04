package jdk.prim.util.concurrent;

import jdk.prim.internal.UnsafeAdapter;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.*;
import java.util.concurrent.locks.LockSupport;

public abstract class PrimitiveForkJoinTask<V> extends ForkJoinTask<V> implements PrimitiveFuture<V> {

    /*
     * see ForkJoinTask
     */
    static final int DONE           = 1 << 31;
    static final int ABNORMAL       = 1 << 16;
    static final int THROWN         = 1 << 17;
    static final int HAVE_EXCEPTION = DONE | ABNORMAL | THROWN;
    static final int MARKER         = 1 << 30;
    static final int SMASK          = 0xffff;
    static final int UNCOMPENSATE   = 1 << 16;

    static ForkJoinPool common = UnsafeAdapter.getConstant(ForkJoinPool.class, "common");

    private int awaitDone(boolean interruptible, long deadline) {
        ForkJoinWorkerThread wt; ForkJoinPool p; ForkJoinPool.WorkQueue q;
        Thread t; boolean internal; int s;
        if (internal =
                (t = Thread.currentThread()) instanceof ForkJoinWorkerThread) {
            p = (wt = (ForkJoinWorkerThread)t).pool;
            q = wt.workQueue;
        }
        else
            q = ForkJoinPool.externalQueue(p = common);
        return (((s = (p == null) ? 0 :
                ((this instanceof CountedCompleter) ?
                        p.helpComplete(this, q, internal) :
                        (this instanceof InterruptibleTask) && !internal ? status :
                                p.helpJoin(this, q, internal))) < 0)) ? s :
                awaitDone(internal ? p : null, s, interruptible, deadline);
    }

    public abstract class OfDouble extends PrimitiveForkJoinTask<java.lang.Double> implements PrimitiveFuture.ToDouble, Serializable {
        public final double joinDouble() {
            int s;
            if((((s = status) < 0 ? s : awaitDone(false, 0L)) & ABNORMAL) != 0)
                reportExecution(false);
            return getRawResultDouble();
        }
        public final double invokeDouble() {}
        public final double resultNowDouble() {}
        public void completeDouble(double value) {}
        public final double getDouble() throws InterruptedException, ExecutionException {}
        public final double getDouble(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {}
        public abstract double getRawResultDouble();
        protected abstract void setRawResultDouble(double value);
    }

    public abstract class OfLong extends PrimitiveForkJoinTask<java.lang.Long> implements PrimitiveFuture.ToLong, Serializable {
        public final long joinLong() {
            int s;
            if((((s = status) < 0 ? s : awaitDone(false, 0L)) & ABNORMAL) != 0)
                reportExecution(false);
            return getRawResultLong();
        }
        public final long invokeLong() {}
        public final long resultNowLong() {}
        public void completeLong(long value) {}
        public final long getLong() throws InterruptedException, ExecutionException {}
        public final long getLong(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {}
        public abstract long getRawResultLong();
        protected abstract void setRawResultLong(long value);
    }

    public abstract class OfInt extends PrimitiveForkJoinTask<java.lang.Integer> implements PrimitiveFuture.ToInt, Serializable {
        public final int joinInt() {
            int s;
            if((((s = status) < 0 ? s : awaitDone(false, 0L)) & ABNORMAL) != 0)
                reportExecution(false);
            return getRawResultInt();
        }
        public final int invokeInt() {}
        public final int resultNowInt() {}
        public void completeInt(int value) {}
        public final int getInt() throws InterruptedException, ExecutionException {}
        public final int getInt(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {}
        public abstract int getRawResultInt();
        protected abstract void setRawResultInt(int value);
    }

    public abstract class OfFloat extends PrimitiveForkJoinTask<java.lang.Float> implements PrimitiveFuture.ToFloat, Serializable {
        public final float joinFloat() {
            int s;
            if((((s = status) < 0 ? s : awaitDone(false, 0L)) & ABNORMAL) != 0)
                reportExecution(false);
            return getRawResultFloat();
        }
        public final float invokeFloat() {}
        public final float resultNowFloat() {}
        public void completeFloat(float value) {}
        public final float getFloat() throws InterruptedException, ExecutionException {}
        public final float getFloat(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {}
        public abstract float getRawResultFloat();
        protected abstract void setRawResultFloat(float value);
    }

    public abstract class OfChar extends PrimitiveForkJoinTask<java.lang.Character> implements PrimitiveFuture.ToChar, Serializable {
        public final char joinChar() {
            int s;
            if((((s = status) < 0 ? s : awaitDone(false, 0L)) & ABNORMAL) != 0)
                reportExecution(false);
            return getRawResultChar();
        }
        public final char invokeChar() {}
        public final char resultNowChar() {}
        public void completeChar(char value) {}
        public final char getChar() throws InterruptedException, ExecutionException {}
        public final char getChar(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {}
        public abstract char getRawResultChar();
        protected abstract void setRawResultChar(char value);
    }

    public abstract class OfShort extends PrimitiveForkJoinTask<java.lang.Short> implements PrimitiveFuture.ToShort, Serializable {
        public final short joinShort() {
            int s;
            if((((s = status) < 0 ? s : awaitDone(false, 0L)) & ABNORMAL) != 0)
                reportExecution(false);
            return getRawResultShort();
        }
        public final short invokeShort() {}
        public final short resultNowShort() {}
        public void completeShort(short value) {}
        public final short getShort() throws InterruptedException, ExecutionException {}
        public final short getShort(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {}
        public abstract short getRawResultShort();
        protected abstract void setRawResultShort(short value);
    }

    public abstract class OfByte extends PrimitiveForkJoinTask<java.lang.Byte> implements PrimitiveFuture.ToByte, Serializable {
        public final byte joinByte() {
            int s;
            if((((s = status) < 0 ? s : awaitDone(false, 0L)) & ABNORMAL) != 0)
                reportExecution(false);
            return getRawResultByte();
        }
        public final byte invokeByte() {}
        public final byte resultNowByte() {}
        public void completeByte(byte value) {}
        public final byte getByte() throws InterruptedException, ExecutionException {}
        public final byte getByte(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {}
        public abstract byte getRawResultByte();
        protected abstract void setRawResultByte(byte value);
    }

    public abstract class OfBoolean extends PrimitiveForkJoinTask<java.lang.Boolean> implements PrimitiveFuture.ToBoolean, Serializable {
        public final boolean joinBoolean() {
            int s;
            if((((s = status) < 0 ? s : awaitDone(false, 0L)) & ABNORMAL) != 0)
                reportExecution(false);
            return getRawResultBoolean();
        }
        public final boolean invokeBoolean() {}
        public final boolean resultNowBoolean() {}
        public void completeBoolean(boolean value) {}
        public final boolean getBoolean() throws InterruptedException, ExecutionException {}
        public final boolean getBoolean(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {}
        public abstract boolean getRawResultBoolean();
        protected abstract void setRawResultBoolean(boolean value);
    }

}
