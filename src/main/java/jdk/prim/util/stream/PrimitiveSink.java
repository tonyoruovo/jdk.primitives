package jdk.prim.util.stream;

import jdk.prim.util.function.PrimitiveConsumer;

/**
 * @see java.util.stream.Sink
 */
interface PrimitiveSink<T> extends PrimitiveConsumer<T> {
    /** A {@code PrimitiveSink} for {@code double} element stream */
    interface OfDouble extends PrimitiveSink<java.lang.Double>, PrimitiveConsumer.OfDouble {
        @Override default void accept(java.lang.Double value) { acceptDouble(value); }
    }
    /** A {@code PrimitiveSink} for {@code long} element stream */
    interface OfLong extends PrimitiveSink<java.lang.Long>, PrimitiveConsumer.OfLong {
        @Override default void accept(java.lang.Long value) { acceptLong(value); }
    }
    /** A {@code PrimitiveSink} for {@code int} element stream */
    interface OfInt extends PrimitiveSink<java.lang.Integer>, PrimitiveConsumer.OfInt {
        @Override default void accept(java.lang.Integer value) { acceptInt(value); }
    }
    /** A {@code PrimitiveSink} for {@code float} element stream */
    interface OfFloat extends PrimitiveSink<java.lang.Float>, PrimitiveConsumer.OfFloat {
        @Override default void accept(java.lang.Float value) { acceptFloat(value); }
    }
    /** A {@code PrimitiveSink} for {@code char} element stream */
    interface OfChar extends PrimitiveSink<java.lang.Character>, PrimitiveConsumer.OfChar {
        @Override default void accept(java.lang.Character value) { acceptChar(value); }
    }
    /** A {@code PrimitiveSink} for {@code short} element stream */
    interface OfShort extends PrimitiveSink<java.lang.Short>, PrimitiveConsumer.OfShort {
        @Override default void accept(java.lang.Short value) { acceptShort(value); }
    }
    /** A {@code PrimitiveSink} for {@code byte} element stream */
    interface OfByte extends PrimitiveSink<java.lang.Byte>, PrimitiveConsumer.OfByte {
        @Override default void accept(java.lang.Byte value) { acceptByte(value); }
    }
    /** A {@code PrimitiveSink} for {@code boolean} element stream */
    interface OfBoolean extends PrimitiveSink<java.lang.Boolean>, PrimitiveConsumer.OfBoolean {
        @Override default void accept(java.lang.Boolean value) { acceptBoolean(value); }
    }
    
    abstract static class ChainedDouble<E_OUT> implements OfDouble {
        protected final PrimitiveSink<? super E_OUT> downstream;

        public ChainedDouble(PrimitiveSink<? super E_OUT> downstream) {
            this.downstream = downstream;
        }
        @Override
        public void begin(long size) { downstream.begin(size); }
        @Override
        public void end() { downstream.end(); }
        @Override
        public boolean cancellationRequested() { return downstream.cancellationRequested(); }
    }
    abstract static class ChainedLong<E_OUT> implements OfLong {
        protected final PrimitiveSink<? super E_OUT> downstream;

        public ChainedLong(PrimitiveSink<? super E_OUT> downstream) {
            this.downstream = downstream;
        }
        @Override
        public void begin(long size) { downstream.begin(size); }
        @Override
        public void end() { downstream.end(); }
        @Override
        public boolean cancellationRequested() { return downstream.cancellationRequested(); }
    }
    abstract static class ChainedInt<E_OUT> implements OfInt {
        protected final PrimitiveSink<? super E_OUT> downstream;

        public ChainedInt(PrimitiveSink<? super E_OUT> downstream) {
            this.downstream = downstream;
        }
        @Override
        public void begin(long size) { downstream.begin(size); }
        @Override
        public void end() { downstream.end(); }
        @Override
        public boolean cancellationRequested() { return downstream.cancellationRequested(); }
    }
    abstract static class ChainedFloat<E_OUT> implements OfFloat {
        protected final PrimitiveSink<? super E_OUT> downstream;

        public ChainedFloat(PrimitiveSink<? super E_OUT> downstream) {
            this.downstream = downstream;
        }
        @Override
        public void begin(long size) { downstream.begin(size); }
        @Override
        public void end() { downstream.end(); }
        @Override
        public boolean cancellationRequested() { return downstream.cancellationRequested(); }
    }
    abstract static class ChainedChar<E_OUT> implements OfChar {
        protected final PrimitiveSink<? super E_OUT> downstream;

        public ChainedChar(PrimitiveSink<? super E_OUT> downstream) {
            this.downstream = downstream;
        }
        @Override
        public void begin(long size) { downstream.begin(size); }
        @Override
        public void end() { downstream.end(); }
        @Override
        public boolean cancellationRequested() { return downstream.cancellationRequested(); }
    }
    abstract static class ChainedShort<E_OUT> implements OfShort {
        protected final PrimitiveSink<? super E_OUT> downstream;

        public ChainedShort(PrimitiveSink<? super E_OUT> downstream) {
            this.downstream = downstream;
        }
        @Override
        public void begin(long size) { downstream.begin(size); }
        @Override
        public void end() { downstream.end(); }
        @Override
        public boolean cancellationRequested() { return downstream.cancellationRequested(); }
    }
    abstract static class ChainedByte<E_OUT> implements OfByte {
        protected final PrimitiveSink<? super E_OUT> downstream;

        public ChainedByte(PrimitiveSink<? super E_OUT> downstream) {
            this.downstream = downstream;
        }
        @Override
        public void begin(long size) { downstream.begin(size); }
        @Override
        public void end() { downstream.end(); }
        @Override
        public boolean cancellationRequested() { return downstream.cancellationRequested(); }
    }
    abstract static class ChainedBoolean<E_OUT> implements OfBoolean {
        protected final PrimitiveSink<? super E_OUT> downstream;

        public ChainedBoolean(PrimitiveSink<? super E_OUT> downstream) {
            this.downstream = downstream;
        }
        @Override
        public void begin(long size) { downstream.begin(size); }
        @Override
        public void end() { downstream.end(); }
        @Override
        public boolean cancellationRequested() { return downstream.cancellationRequested(); }
    }
    /**
     * @see java.util.stream.Sink#begin(long)
     */
    default void begin(long size) {}
    /**
     * @see java.util.stream.Sink#end
     */
    default void end() {}
    /**
     * @see java.util.stream.Sink#cancellationRequested
     */
    default boolean cancellationRequested() { return false; }

    @Override default void accept(T t) { throw new IllegalStateException("non primitive variant disallowed"); }
}
