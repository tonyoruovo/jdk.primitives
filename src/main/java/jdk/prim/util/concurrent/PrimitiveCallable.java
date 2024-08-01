package jdk.prim.util.concurrent;

import java.util.concurrent.Callable;

/**
 * A common interface for all {@code Callable} types that provide
 * primitive support.
 * 
 * @param <TO> the type return value of {@link #call()}
 * @see Callable
 */
@FunctionalInterface
public interface PrimitiveCallable<TO> extends Callable<TO> {
    /**
     * A {@code PrimitiveCallable} for a {@code double} value.
     */
    @FunctionalInterface
    interface ToDouble extends PrimitiveCallable<java.lang.Double> {
        /**
         * Computes a {@code double}, result or throws an exception
         * if unable to do so.
         * @return the computed {@code double}
         * @throws Exception if unable to compute the {@code double}
         * @apiNote This is the {@code double} equivalent of {@link #call()}
         * but is recommended over {@link #call()} as this is first class.
         */
        double callDouble() throws Exception;
        /**
         * {@inheritDoc}
         * 
         * @return {@inheritDoc}
         * @throws Exception {@inheritDoc}
         * @implNote The default implementation returns the value of {@link #callDouble()}
         * causing a primitive-to-wrapper conversion
         */
        @Override default java.lang.Double call() throws Exception { return callDouble(); }
    }    
    /**
     * A {@code PrimitiveCallable} for a {@code long} value.
     */
    @FunctionalInterface
    interface ToLong extends PrimitiveCallable<java.lang.Long> {
        /**
         * Computes a {@code long}, result or throws an exception
         * if unable to do so.
         * @return the computed {@code long}
         * @throws Exception if unable to compute the {@code long}
         * @apiNote This is the {@code long} equivalent of {@link #call()}
         * but is recommended over {@link #call()} as this is first class.
         */
        long callLong() throws Exception;
        /**
         * {@inheritDoc}
         * 
         * @return {@inheritDoc}
         * @throws Exception {@inheritDoc}
         * @implNote The default implementation returns the value of {@link #callLong()}
         * causing a primitive-to-wrapper conversion
         */
        @Override default java.lang.Long call() throws Exception { return callLong(); }
    }
    /**
     * A {@code PrimitiveCallable} for a {@code int} value.
     */
    @FunctionalInterface
    interface ToInt extends PrimitiveCallable<java.lang.Integer> {
        /**
         * Computes a {@code int}, result or throws an exception
         * if unable to do so.
         * @return the computed {@code int}
         * @throws Exception if unable to compute the {@code int}
         * @apiNote This is the {@code int} equivalent of {@link #call()}
         * but is recommended over {@link #call()} as this is first class.
         */
        int callInt() throws Exception;
        /**
         * {@inheritDoc}
         * 
         * @return {@inheritDoc}
         * @throws Exception {@inheritDoc}
         * @implNote The default implementation returns the value of {@link #callInt()}
         * causing a primitive-to-wrapper conversion
         */
        @Override default java.lang.Integer call() throws Exception { return callInt(); }
    }
    /**
     * A {@code PrimitiveCallable} for a {@code float} value.
     */
    @FunctionalInterface
    interface ToFloat extends PrimitiveCallable<java.lang.Float> {
        /**
         * Computes a {@code float}, result or throws an exception
         * if unable to do so.
         * @return the computed {@code float}
         * @throws Exception if unable to compute the {@code float}
         * @apiNote This is the {@code float} equivalent of {@link #call()}
         * but is recommended over {@link #call()} as this is first class.
         */
        float callFloat() throws Exception;
        /**
         * {@inheritDoc}
         * 
         * @return {@inheritDoc}
         * @throws Exception {@inheritDoc}
         * @implNote The default implementation returns the value of {@link #callFloat()}
         * causing a primitive-to-wrapper conversion
         */
        @Override default java.lang.Float call() throws Exception { return callFloat(); }
    }
    /**
     * A {@code PrimitiveCallable} for a {@code char} value.
     */
    @FunctionalInterface
    interface ToChar extends PrimitiveCallable<java.lang.Character> {
        /**
         * Computes a {@code char}, result or throws an exception
         * if unable to do so.
         * @return the computed {@code char}
         * @throws Exception if unable to compute the {@code char}
         * @apiNote This is the {@code char} equivalent of {@link #call()}
         * but is recommended over {@link #call()} as this is first class.
         */
        char callChar() throws Exception;
        /**
         * {@inheritDoc}
         * 
         * @return {@inheritDoc}
         * @throws Exception {@inheritDoc}
         * @implNote The default implementation returns the value of {@link #callChar()}
         * causing a primitive-to-wrapper conversion
         */
        @Override default java.lang.Character call() throws Exception { return callChar(); }
    }
    /**
     * A {@code PrimitiveCallable} for a {@code short} value.
     */
    @FunctionalInterface
    interface ToShort extends PrimitiveCallable<java.lang.Short> {
        /**
         * Computes a {@code short}, result or throws an exception
         * if unable to do so.
         * @return the computed {@code short}
         * @throws Exception if unable to compute the {@code short}
         * @apiNote This is the {@code short} equivalent of {@link #call()}
         * but is recommended over {@link #call()} as this is first class.
         */
        short callShort() throws Exception;
        /**
         * {@inheritDoc}
         * 
         * @return {@inheritDoc}
         * @throws Exception {@inheritDoc}
         * @implNote The default implementation returns the value of {@link #callShort()}
         * causing a primitive-to-wrapper conversion
         */
        @Override default java.lang.Short call() throws Exception { return callShort(); }
    }
    /**
     * A {@code PrimitiveCallable} for a {@code byte} value.
     */
    @FunctionalInterface
    interface ToByte extends PrimitiveCallable<java.lang.Byte> {
        /**
         * Computes a {@code byte}, result or throws an exception
         * if unable to do so.
         * @return the computed {@code byte}
         * @throws Exception if unable to compute the {@code byte}
         * @apiNote This is the {@code byte} equivalent of {@link #call()}
         * but is recommended over {@link #call()} as this is first class.
         */
        byte callByte() throws Exception;
        /**
         * {@inheritDoc}
         * 
         * @return {@inheritDoc}
         * @throws Exception {@inheritDoc}
         * @implNote The default implementation returns the value of {@link #callByte()}
         * causing a primitive-to-wrapper conversion
         */
        @Override default java.lang.Byte call() throws Exception { return callByte(); }
    }
    /**
     * A {@code PrimitiveCallable} for a {@code boolean} value.
     */
    @FunctionalInterface
    interface ToBoolean extends PrimitiveCallable<java.lang.Boolean> {
        /**
         * Computes a {@code boolean}, result or throws an exception
         * if unable to do so.
         * @return the computed {@code boolean}
         * @throws Exception if unable to compute the {@code boolean}
         * @apiNote This is the {@code boolean} equivalent of {@link #call()}
         * but is recommended over {@link #call()} as this is first class.
         */
        boolean callBoolean() throws Exception;
        /**
         * {@inheritDoc}
         * 
         * @return {@inheritDoc}
         * @throws Exception {@inheritDoc}
         * @implNote The default implementation returns the value of {@link #callBoolean()}
         * causing a primitive-to-wrapper conversion
         */
        @Override default java.lang.Boolean call() throws Exception { return callBoolean(); }
    }
}
