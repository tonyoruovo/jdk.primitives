
package jdk.prim.util.function;

import java.util.function.Function;

@FunctionalInterface interface PrimitiveFunction<TO, OF> extends Function<OF, TO> {

    @FunctionalInterface

    @Override default <R> PrimitiveFunction<R, OF> andThen(Function<? super TO, ? extends R> after) {return of -> after.apply(apply(of));}
    @Override default ToDouble<OF> andThenDouble(ToDouble<? super OF> after) throws ClassCastException {throw new ClassCastException("Not a primitive wrapper");}
    @Override default ToLong<OF> andThenLong(ToLong<? super OF> after) throws ClassCastException {throw new ClassCastException("Not a primitive wrapper");}
    @Override default ToInt<OF> andThenInt(ToInt<? super OF> after) throws ClassCastException {throw new ClassCastException("Not a primitive wrapper");}
    @Override default ToFloat<OF> andThenFloat(ToFloat<? super OF> after) throws ClassCastException {throw new ClassCastException("Not a primitive wrapper");}
    @Override default ToChar<OF> andThenChar(ToChar<? super OF> after) throws ClassCastException {throw new ClassCastException("Not a primitive wrapper");}
    @Override default ToShort<OF> andThenShort(ToShort<? super OF> after) throws ClassCastException {throw new ClassCastException("Not a primitive wrapper");}
    @Override default ToByte<OF> andThenByte(ToByte<? super OF> after) throws ClassCastException {throw new ClassCastException("Not a primitive wrapper");}
    @Override default ToBoolean<OF> andThenBoolean(ToBoolean<? super OF> after) throws ClassCastException {throw new ClassCastException("Not a primitive wrapper");}
    @Override default <T> PrimitiveFunction<TO, T> compose(Function<? super T, ? extends OF> before) {return t -> apply(before.apply(t));}
    @Override default <T> PrimitiveFunction<java.lang.Double, T> composeDouble(OfDouble<T> before) {return t -> apply(before.applyDouble(t));}
}