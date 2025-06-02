package jdk.prim.util;

import java.util.concurrent.CountedCompleter;
import java.util.concurrent.ForkJoinPool;

import jdk.prim.util.function.PrimitiveBiFunction;
/**
 * @see java.util.ArrayPrefixHelpers
 */
class PrimitiveArrayHelper {
    private PrimitiveArrayHelper() {}
    
    static final int CUMULATE = 1;
    static final int SUMMED   = 2;
    static final int FINISHED = 4;

    /** The smallest subtask array partition size to use as threshold */
    static final int MIN_PARTITION = 16;
    static final class FloatCumulateTask extends CountedCompleter<Void> {
        final float[] array;
        final PrimitiveBiFunction.ToFloat.OfFloat.AndFloat function;
        FloatCumulateTask left, right;
        float in, out;
        final int lo, hi, origin, fence, threshold;
        public FloatCumulateTask(FloatCumulateTask parent, PrimitiveBiFunction.ToFloat.OfFloat.AndFloat function, float[] array, int lo, int hi) {
            super(parent);
            this.function = function;
            this.array = array;
            this.lo = this.origin = lo;
            this.hi = this.fence = hi;
            int p;
            this.threshold =
                (p = (hi - lo) / (ForkJoinPool.getCommonPoolParallelism() << 3)) <= MIN_PARTITION ? MIN_PARTITION : p;
        }
        FloatCumulateTask(FloatCumulateTask parent, PrimitiveBiFunction.ToFloat.OfFloat.AndFloat function, float[] array, int origin, int fence, int threshold, int lo, int hi) {
            super(parent);
            this.array = array;
            this.function = function;
            this.origin = origin;
            this.fence = fence;
            this.threshold = threshold;
            this.hi = hi;
            this.lo = lo;
        }
        public final void compute() {
            final PrimitiveBiFunction.ToFloat.OfFloat.AndFloat fn;
            final float[] a;
            if ((fn = this.function) == null || (a = this.array) == null) {
                throw new NullPointerException();
            }
            int th = threshold, org = origin, fnc = fence, l, h;
            FloatCumulateTask t = this;
            outer: while((l = t.lo) >= 0 && (h = t.hi) <= a.length) {
                if((h - 1) > th) {
                    FloatCumulateTask lt = t.left, rt = t.right, f;
                    if(lt == null) {
                        int mid = (l + h) >>> 1;
                        f = rt = t.right = new FloatCumulateTask(t, fn, a, org, fnc, th, mid, h);
                        t = lt = t.left = new FloatCumulateTask(t, fn, a, org, fnc, th, l, mid);
                    } else {
                        float pin = t.in;
                        lt.in = pin;
                        f = t = null;
                        if(rt != null) {
                            float lout = lt.out;
                            rt.in = (l == org ? lout : (fn.applyFloat(pin, lout)));
                            for(int c;;) {
                                if(((c = rt.getPendingCount()) & CUMULATE) != 0) break;
                                if(rt.compareAndSetPendingCount(c, c | CUMULATE)) {
                                    t = rt; break;
                                }
                            }
                        }
                        for(int c;;) {
                            if(((c = lt.getPendingCount()) & CUMULATE) != 0) break;
                            if(lt.compareAndSetPendingCount(c, c | CUMULATE)) {
                                if(t != null) f = t;
                                t = lt;
                                break;
                            }
                        }
                        if(t == null) break;
                    }
                    if(f != null) f.fork();
                } else {
                    int state;
                    for(int b;;) {
                        if(((b = t.getPendingCount()) & FINISHED) != 0) break outer;
                        state = ((b & CUMULATE) != 0 ? FINISHED : (l > org) ? SUMMED : SUMMED | FINISHED);
                        if (t.compareAndSetPendingCount(b, b | state)) break;
                    }
                    float sum;
                    if (state != SUMMED) {
                        int first;
                        if (l == org) {
                            sum = a[org];
                            first = org + 1;
                        } else {
                            sum = t.in;
                            first = l;
                        }
                        for(int i = first; i < h; ++i) a[i] = sum = fn.applyFloat(sum, a[i]);
                    } else if(h < fnc) {
                        sum = a[l];
                        for(int i = l + 1; i < h; ++i) {
                            sum = fn.applyFloat(sum, a[i]);
                        }
                    } else sum = t.in;
                    t.out = sum;
                    for(FloatCumulateTask par;;){
                        if((par = (FloatCumulateTask)t.getCompleter()) == null) {
                            if((state & FINISHED) != 0) t.quietlyComplete();
                            break outer;
                        }
                        int b = par.getPendingCount();
                        if((b & state & FINISHED) != 0) t = par;
                        else if((b & state & SUMMED) != 0) {
                            int nextState; FloatCumulateTask lt, rt;
                            if ((lt = par.left) != null && (rt = par.right) != null) {
                                float lout = lt.out;
                                par.out = (rt.hi == fnc ? lout : fn.applyFloat(lout, rt.out));
                            }
                            int refork = (((b & CUMULATE) == 0 && par.lo == org) ? CUMULATE : 0);
                            if ((nextState = b | state | refork) == b || par.compareAndSetPendingCount(b, nextState)) {
                                state = SUMMED;
                                t = par;
                                if(refork != 0) par.fork();
                            }
                        } else if (par.compareAndSetPendingCount(b, b | state)) {
                            break outer;
                        }
                    }
                }
            }
        }
        @java.io.Serial
        private static final long serialVersionUID = -98765434567842789L;
    }
    static final class CharCumulateTask extends CountedCompleter<Void> {
        final char[] array;
        final PrimitiveBiFunction.ToChar.OfChar.AndChar function;
        CharCumulateTask left, right;
        char in, out;
        final int lo, hi, origin, fence, threshold;
        public CharCumulateTask(CharCumulateTask parent, PrimitiveBiFunction.ToChar.OfChar.AndChar function, char[] array, int lo, int hi) {
            super(parent);
            this.function = function;
            this.array = array;
            this.lo = this.origin = lo;
            this.hi = this.fence = hi;
            int p;
            this.threshold =
                (p = (hi - lo) / (ForkJoinPool.getCommonPoolParallelism() << 3)) <= MIN_PARTITION ? MIN_PARTITION : p;
        }
        CharCumulateTask(CharCumulateTask parent, PrimitiveBiFunction.ToChar.OfChar.AndChar function, char[] array, int origin, int fence, int threshold, int lo, int hi) {
            super(parent);
            this.array = array;
            this.function = function;
            this.origin = origin;
            this.fence = fence;
            this.threshold = threshold;
            this.hi = hi;
            this.lo = lo;
        }
        public final void compute() {
            final PrimitiveBiFunction.ToChar.OfChar.AndChar fn;
            final char[] a;
            if ((fn = this.function) == null || (a = this.array) == null) {
                throw new NullPointerException();
            }
            int th = threshold, org = origin, fnc = fence, l, h;
            CharCumulateTask t = this;
            outer: while((l = t.lo) >= 0 && (h = t.hi) <= a.length) {
                if((h - 1) > th) {
                    CharCumulateTask lt = t.left, rt = t.right, f;
                    if(lt == null) {
                        int mid = (l + h) >>> 1;
                        f = rt = t.right = new CharCumulateTask(t, fn, a, org, fnc, th, mid, h);
                        t = lt = t.left = new CharCumulateTask(t, fn, a, org, fnc, th, l, mid);
                    } else {
                        char pin = t.in;
                        lt.in = pin;
                        f = t = null;
                        if(rt != null) {
                            char lout = lt.out;
                            rt.in = (l == org ? lout : (fn.applyChar(pin, lout)));
                            for(int c;;) {
                                if(((c = rt.getPendingCount()) & CUMULATE) != 0) break;
                                if(rt.compareAndSetPendingCount(c, c | CUMULATE)) {
                                    t = rt; break;
                                }
                            }
                        }
                        for(int c;;) {
                            if(((c = lt.getPendingCount()) & CUMULATE) != 0) break;
                            if(lt.compareAndSetPendingCount(c, c | CUMULATE)) {
                                if(t != null) f = t;
                                t = lt;
                                break;
                            }
                        }
                        if(t == null) break;
                    }
                if(f != null) f.fork();
            } else {
                int state;
                for(int b;;) {
                    if(((b = t.getPendingCount()) & FINISHED) != 0) break outer;
                    state = ((b & CUMULATE) != 0 ? FINISHED : (l > org) ? SUMMED : SUMMED | FINISHED);
                    if (t.compareAndSetPendingCount(b, b | state)) break;
                }
                char sum;
                if (state != SUMMED) {
                    int first;
                    if (l == org) {
                        sum = a[org];
                        first = org + 1;
                    } else {
                        sum = t.in;
                        first = l;
                    }
                    for(int i = first; i < h; ++i) a[i] = sum = fn.applyChar(sum, a[i]);
                } else if(h < fnc) {
                    sum = a[l];
                    for(int i = l + 1; i < h; ++i) {
                        sum = fn.applyChar(sum, a[i]);
                    }
                        } else sum = t.in;
                t.out = sum;
                for(CharCumulateTask par;;){
                    if((par = (CharCumulateTask)t.getCompleter()) == null) {
                        if((state & FINISHED) != 0) t.quietlyComplete();
                        break outer;
                    }
                    int b = par.getPendingCount();
                    if((b & state & FINISHED) != 0) t = par;
                    else if((b & state & SUMMED) != 0) {
                        int nextState; CharCumulateTask lt, rt;
                        if ((lt = par.left) != null && (rt = par.right) != null) {
                            char lout = lt.out;
                            par.out = (rt.hi == fnc ? lout : fn.applyChar(lout, rt.out));
                        }
                        int refork = (((b & CUMULATE) == 0 && par.lo == org) ? CUMULATE : 0);
                        if ((nextState = b | state | refork) == b || par.compareAndSetPendingCount(b, nextState)) {
                            state = SUMMED;
                            t = par;
                            if(refork != 0) par.fork();
                        }
                    } else if (par.compareAndSetPendingCount(b, b | state)) {
                        break outer;
                    }
                }
            }
            }
        }
        @java.io.Serial
        private static final long serialVersionUID = -98765434567842789L;
    }    
    static final class ShortCumulateTask extends CountedCompleter<Void> {
        final short[] array;
        final PrimitiveBiFunction.ToShort.OfShort.AndShort function;
        ShortCumulateTask left, right;
        short in, out;
        final int lo, hi, origin, fence, threshold;
        public ShortCumulateTask(ShortCumulateTask parent, PrimitiveBiFunction.ToShort.OfShort.AndShort function, short[] array, int lo, int hi) {
            super(parent);
            this.function = function;
            this.array = array;
            this.lo = this.origin = lo;
            this.hi = this.fence = hi;
            int p;
            this.threshold =
                (p = (hi - lo) / (ForkJoinPool.getCommonPoolParallelism() << 3)) <= MIN_PARTITION ? MIN_PARTITION : p;
        }
        ShortCumulateTask(ShortCumulateTask parent, PrimitiveBiFunction.ToShort.OfShort.AndShort function, short[] array, int origin, int fence, int threshold, int lo, int hi) {
            super(parent);
            this.array = array;
            this.function = function;
            this.origin = origin;
            this.fence = fence;
            this.threshold = threshold;
            this.hi = hi;
            this.lo = lo;
        }
        public final void compute() {
            final PrimitiveBiFunction.ToShort.OfShort.AndShort fn;
            final short[] a;
            if ((fn = this.function) == null || (a = this.array) == null) {
                throw new NullPointerException();
            }
            int th = threshold, org = origin, fnc = fence, l, h;
            ShortCumulateTask t = this;
            outer: while((l = t.lo) >= 0 && (h = t.hi) <= a.length) {
                if((h - 1) > th) {
                    ShortCumulateTask lt = t.left, rt = t.right, f;
                    if(lt == null) {
                        int mid = (l + h) >>> 1;
                        f = rt = t.right = new ShortCumulateTask(t, fn, a, org, fnc, th, mid, h);
                        t = lt = t.left = new ShortCumulateTask(t, fn, a, org, fnc, th, l, mid);
                    } else {
                        short pin = t.in;
                        lt.in = pin;
                        f = t = null;
                        if(rt != null) {
                            short lout = lt.out;
                            rt.in = (l == org ? lout : (fn.applyShort(pin, lout)));
                            for(int c;;) {
                                if(((c = rt.getPendingCount()) & CUMULATE) != 0) break;
                                if(rt.compareAndSetPendingCount(c, c | CUMULATE)) {
                                    t = rt; break;
                                }
                            }
                        }
                        for(int c;;) {
                            if(((c = lt.getPendingCount()) & CUMULATE) != 0) break;
                            if(lt.compareAndSetPendingCount(c, c | CUMULATE)) {
                                if(t != null) f = t;
                                t = lt;
                                break;
                            }
                        }
                        if(t == null) break;
                    }
                if(f != null) f.fork();
            } else {
                int state;
                for(int b;;) {
                    if(((b = t.getPendingCount()) & FINISHED) != 0) break outer;
                    state = ((b & CUMULATE) != 0 ? FINISHED : (l > org) ? SUMMED : SUMMED | FINISHED);
                    if (t.compareAndSetPendingCount(b, b | state)) break;
                }
                short sum;
                if (state != SUMMED) {
                    int first;
                    if (l == org) {
                        sum = a[org];
                        first = org + 1;
                    } else {
                        sum = t.in;
                        first = l;
                    }
                    for(int i = first; i < h; ++i) a[i] = sum = fn.applyShort(sum, a[i]);
                } else if(h < fnc) {
                    sum = a[l];
                    for(int i = l + 1; i < h; ++i) {
                        sum = fn.applyShort(sum, a[i]);
                    }
                        } else sum = t.in;
                t.out = sum;
                for(ShortCumulateTask par;;){
                    if((par = (ShortCumulateTask)t.getCompleter()) == null) {
                        if((state & FINISHED) != 0) t.quietlyComplete();
                        break outer;
                    }
                    int b = par.getPendingCount();
                    if((b & state & FINISHED) != 0) t = par;
                    else if((b & state & SUMMED) != 0) {
                        int nextState; ShortCumulateTask lt, rt;
                        if ((lt = par.left) != null && (rt = par.right) != null) {
                            short lout = lt.out;
                            par.out = (rt.hi == fnc ? lout : fn.applyShort(lout, rt.out));
                        }
                        int refork = (((b & CUMULATE) == 0 && par.lo == org) ? CUMULATE : 0);
                        if ((nextState = b | state | refork) == b || par.compareAndSetPendingCount(b, nextState)) {
                            state = SUMMED;
                            t = par;
                            if(refork != 0) par.fork();
                        }
                    } else if (par.compareAndSetPendingCount(b, b | state)) {
                        break outer;
                    }
                }
            }
            }
        }
        @java.io.Serial
        private static final long serialVersionUID = -98765434567842789L;
    }
    static final class ByteCumulateTask extends CountedCompleter<Void> {
        final byte[] array;
        final PrimitiveBiFunction.ToByte.OfByte.AndByte function;
        ByteCumulateTask left, right;
        byte in, out;
        final int lo, hi, origin, fence, threshold;
        public ByteCumulateTask(ByteCumulateTask parent, PrimitiveBiFunction.ToByte.OfByte.AndByte function, byte[] array, int lo, int hi) {
            super(parent);
            this.function = function;
            this.array = array;
            this.lo = this.origin = lo;
            this.hi = this.fence = hi;
            int p;
            this.threshold =
                (p = (hi - lo) / (ForkJoinPool.getCommonPoolParallelism() << 3)) <= MIN_PARTITION ? MIN_PARTITION : p;
        }
        ByteCumulateTask(ByteCumulateTask parent, PrimitiveBiFunction.ToByte.OfByte.AndByte function, byte[] array, int origin, int fence, int threshold, int lo, int hi) {
            super(parent);
            this.array = array;
            this.function = function;
            this.origin = origin;
            this.fence = fence;
            this.threshold = threshold;
            this.hi = hi;
            this.lo = lo;
        }
        public final void compute() {
            final PrimitiveBiFunction.ToByte.OfByte.AndByte fn;
            final byte[] a;
            if ((fn = this.function) == null || (a = this.array) == null) {
                throw new NullPointerException();
            }
            int th = threshold, org = origin, fnc = fence, l, h;
            ByteCumulateTask t = this;
            outer: while((l = t.lo) >= 0 && (h = t.hi) <= a.length) {
                if((h - 1) > th) {
                    ByteCumulateTask lt = t.left, rt = t.right, f;
                    if(lt == null) {
                        int mid = (l + h) >>> 1;
                        f = rt = t.right = new ByteCumulateTask(t, fn, a, org, fnc, th, mid, h);
                        t = lt = t.left = new ByteCumulateTask(t, fn, a, org, fnc, th, l, mid);
                    } else {
                        byte pin = t.in;
                        lt.in = pin;
                        f = t = null;
                        if(rt != null) {
                            byte lout = lt.out;
                            rt.in = (l == org ? lout : (fn.applyByte(pin, lout)));
                            for(int c;;) {
                                if(((c = rt.getPendingCount()) & CUMULATE) != 0) break;
                                if(rt.compareAndSetPendingCount(c, c | CUMULATE)) {
                                    t = rt; break;
                                }
                            }
                        }
                        for(int c;;) {
                            if(((c = lt.getPendingCount()) & CUMULATE) != 0) break;
                            if(lt.compareAndSetPendingCount(c, c | CUMULATE)) {
                                if(t != null) f = t;
                                t = lt;
                                break;
                            }
                        }
                        if(t == null) break;
                    }
                if(f != null) f.fork();
            } else {
                int state;
                for(int b;;) {
                    if(((b = t.getPendingCount()) & FINISHED) != 0) break outer;
                    state = ((b & CUMULATE) != 0 ? FINISHED : (l > org) ? SUMMED : SUMMED | FINISHED);
                    if (t.compareAndSetPendingCount(b, b | state)) break;
                }
                byte sum;
                if (state != SUMMED) {
                    int first;
                    if (l == org) {
                        sum = a[org];
                        first = org + 1;
                    } else {
                        sum = t.in;
                        first = l;
                    }
                    for(int i = first; i < h; ++i) a[i] = sum = fn.applyByte(sum, a[i]);
                } else if(h < fnc) {
                    sum = a[l];
                    for(int i = l + 1; i < h; ++i) {
                        sum = fn.applyByte(sum, a[i]);
                    }
                        } else sum = t.in;
                t.out = sum;
                for(ByteCumulateTask par;;){
                    if((par = (ByteCumulateTask)t.getCompleter()) == null) {
                        if((state & FINISHED) != 0) t.quietlyComplete();
                        break outer;
                    }
                    int b = par.getPendingCount();
                    if((b & state & FINISHED) != 0) t = par;
                    else if((b & state & SUMMED) != 0) {
                        int nextState; ByteCumulateTask lt, rt;
                        if ((lt = par.left) != null && (rt = par.right) != null) {
                            byte lout = lt.out;
                            par.out = (rt.hi == fnc ? lout : fn.applyByte(lout, rt.out));
                        }
                        int refork = (((b & CUMULATE) == 0 && par.lo == org) ? CUMULATE : 0);
                        if ((nextState = b | state | refork) == b || par.compareAndSetPendingCount(b, nextState)) {
                            state = SUMMED;
                            t = par;
                            if(refork != 0) par.fork();
                        }
                    } else if (par.compareAndSetPendingCount(b, b | state)) {
                        break outer;
                    }
                }
            }
            }
        }
        @java.io.Serial
        private static final long serialVersionUID = -98765434567842789L;
    }
    static final class BooleanCumulateTask extends CountedCompleter<Void> {
        final boolean[] array;
        final PrimitiveBiFunction.ToBoolean.OfBoolean.AndBoolean function;
        BooleanCumulateTask left, right;
        boolean in, out;
        final int lo, hi, origin, fence, threshold;
        public BooleanCumulateTask(BooleanCumulateTask parent, PrimitiveBiFunction.ToBoolean.OfBoolean.AndBoolean function, boolean[] array, int lo, int hi) {
            super(parent);
            this.function = function;
            this.array = array;
            this.lo = this.origin = lo;
            this.hi = this.fence = hi;
            int p;
            this.threshold =
                (p = (hi - lo) / (ForkJoinPool.getCommonPoolParallelism() << 3)) <= MIN_PARTITION ? MIN_PARTITION : p;
        }
        BooleanCumulateTask(BooleanCumulateTask parent, PrimitiveBiFunction.ToBoolean.OfBoolean.AndBoolean function, boolean[] array, int origin, int fence, int threshold, int lo, int hi) {
            super(parent);
            this.array = array;
            this.function = function;
            this.origin = origin;
            this.fence = fence;
            this.threshold = threshold;
            this.hi = hi;
            this.lo = lo;
        }
        public final void compute() {
            final PrimitiveBiFunction.ToBoolean.OfBoolean.AndBoolean fn;
            final boolean[] a;
            if ((fn = this.function) == null || (a = this.array) == null) {
                throw new NullPointerException();
            }
            int th = threshold, org = origin, fnc = fence, l, h;
            BooleanCumulateTask t = this;
            outer: while((l = t.lo) >= 0 && (h = t.hi) <= a.length) {
                if((h - 1) > th) {
                    BooleanCumulateTask lt = t.left, rt = t.right, f;
                    if(lt == null) {
                        int mid = (l + h) >>> 1;
                        f = rt = t.right = new BooleanCumulateTask(t, fn, a, org, fnc, th, mid, h);
                        t = lt = t.left = new BooleanCumulateTask(t, fn, a, org, fnc, th, l, mid);
                    } else {
                        boolean pin = t.in;
                        lt.in = pin;
                        f = t = null;
                        if(rt != null) {
                            boolean lout = lt.out;
                            rt.in = (l == org ? lout : (fn.applyBoolean(pin, lout)));
                            for(int c;;) {
                                if(((c = rt.getPendingCount()) & CUMULATE) != 0) break;
                                if(rt.compareAndSetPendingCount(c, c | CUMULATE)) {
                                    t = rt; break;
                                }
                            }
                        }
                        for(int c;;) {
                            if(((c = lt.getPendingCount()) & CUMULATE) != 0) break;
                            if(lt.compareAndSetPendingCount(c, c | CUMULATE)) {
                                if(t != null) f = t;
                                t = lt;
                                break;
                            }
                        }
                        if(t == null) break;
                    }
                if(f != null) f.fork();
            } else {
                int state;
                for(int b;;) {
                    if(((b = t.getPendingCount()) & FINISHED) != 0) break outer;
                    state = ((b & CUMULATE) != 0 ? FINISHED : (l > org) ? SUMMED : SUMMED | FINISHED);
                    if (t.compareAndSetPendingCount(b, b | state)) break;
                }
                boolean sum;
                if (state != SUMMED) {
                    int first;
                    if (l == org) {
                        sum = a[org];
                        first = org + 1;
                    } else {
                        sum = t.in;
                        first = l;
                    }
                    for(int i = first; i < h; ++i) a[i] = sum = fn.applyBoolean(sum, a[i]);
                } else if(h < fnc) {
                    sum = a[l];
                    for(int i = l + 1; i < h; ++i) {
                        sum = fn.applyBoolean(sum, a[i]);
                    }
                        } else sum = t.in;
                t.out = sum;
                for(BooleanCumulateTask par;;){
                    if((par = (BooleanCumulateTask)t.getCompleter()) == null) {
                        if((state & FINISHED) != 0) t.quietlyComplete();
                        break outer;
                    }
                    int b = par.getPendingCount();
                    if((b & state & FINISHED) != 0) t = par;
                    else if((b & state & SUMMED) != 0) {
                        int nextState; BooleanCumulateTask lt, rt;
                        if ((lt = par.left) != null && (rt = par.right) != null) {
                            boolean lout = lt.out;
                            par.out = (rt.hi == fnc ? lout : fn.applyBoolean(lout, rt.out));
                        }
                        int refork = (((b & CUMULATE) == 0 && par.lo == org) ? CUMULATE : 0);
                        if ((nextState = b | state | refork) == b || par.compareAndSetPendingCount(b, nextState)) {
                            state = SUMMED;
                            t = par;
                            if(refork != 0) par.fork();
                        }
                    } else if (par.compareAndSetPendingCount(b, b | state)) {
                        break outer;
                    }
                }
            }
            }
        }
        @java.io.Serial
        private static final long serialVersionUID = -98765434567842789L;
    }
}
