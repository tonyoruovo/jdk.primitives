package jdk.prim;

import jdk.prim.util.function.PrimitiveFunction;

public interface PrimitiveMapper<T extends PrimitiveFunction<T, R>, R extends PrimitiveFunction<R, T>> {
    T getMapper();
    R getReverseMapper();
}
