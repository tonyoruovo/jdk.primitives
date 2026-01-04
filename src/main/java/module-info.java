/**
 * <p>
 * The core module for the jdk.primitive project. It attempts to provide a one-for-one
 * implementation of jdk generic types (and for types where it is logically needed)
 * in all primitives  including:
 * <ul>
 * <li>{@code double}</li>
 * <li>{@code long}</li>
 * <li>{@code int}</li>
 * <li>{@code float}</li>
 * <li>{@code char}</li>
 * <li>{@code short}</li>
 * <li>{@code byte}</li>
 * <li>{@code boolean}</li>
 * </ul>
 * It is the goal of this project to implement primitive alternatives for some of the following:
 * <ol>
 * <li>
 * <h3>{@code java.lang}</h3>
 * <ul>
 * <li>{@link java.lang.Iterable Iterable}</li>
 * <li>{@link java.lang.ThreadLocal ThreadLocal}</li>
 * <li>{@link java.lang.InheritableThreadLocal InheritableThreadLocal}</li>
 * </ul>
 * </li>
 * <li>
 * <h3>{@code java.util}</h3>
 * <ul>
 * <li>{@link java.util.Collection Collection} (sub-interfaces and implementations)</li>
 * <li>{@link java.util.Map Map} (sub-interfaces and implementations and related types)</li>
 * <li>{@link java.util.Comparator Comparator}</li>
 * <li>{@link java.util.Enumeration Enumeration}</li>
 * <li>{@link java.util.Dictionary Dictionary}</li>
 * <li>SummaryStatistics: To complete the {@link java.util.DoubleSummaryStatistics},
 * {@link java.util.LongSummaryStatistics} and {@link java.util.IntSummaryStatistics} trio</li>
 * <li>{@link java.util.Iterator Iterator} (sub-interfaces and implementations)</li>
 * <li>{@link java.util.Optional Optional} (sub-interfaces and implementations)</li>
 * <li>{@link java.util.ServiceLoader ServiceLoader}</li>
 * <li>{@link java.util.ServiceLoader.Provider ServiceLoader.Provider}</li>
 * <li>{@link java.util.Spliterator Spliterator}</li>
 * </ul>
 * </li>
 * <li>
 * <h3>{@code java.util.concurrent}</h3>
 * <ul>
 * <li>All collection and map related types</li>
 * <li>All types related to concurrency and distributed programming</li>
 * <li>The {@link java.util.concurrent.Flow Flow} API</li>
 * </ul>
 * </li>
 * <li>
 * <h3>{@code java.util.concurrent.atomic}</h3>
 * <ul>
 * <li>All adders, accumulators, updaters and arrays</li>
 * </ul>
 * </li>
 * <li>
 * <h3>{@code java.util.function}</h3>
 * <ul>
 * <li>All function-related types</li>
 * <li>All consumer-related types</li>
 * <li>All predicate-related types</li>
 * <li>All supplier-related types</li>
 * </ul>
 * </li>
 * <li>
 * <h3>{@code java.util.stream}</h3>
 * <ul>
 * <li>All stream-related types</li>
 * <li>{@link java.util.stream.Collector Collector}</li>
 * <li>{@link java.util.stream.Gatherer Gatherer}</li>
 * </ul>
 * </li>
 * </ol>
 * ... and many more to come.
 * <p>
 * Generally if a type (for example, an interface) is defined as {@code Type<T>}, and it's (or one of it's) generic
 * method is {@code foo(T t)} then a primitive specialisation (for example a
 * {@code float}) for such a type would be {@code PrimitiveType.OfFloat extends PrimitiveType<java.lang.Float>}
 * and the specialised method would be {@code fooFloat(float f)}.
 * @author Oruovo E. Anthony
 */
module jdk.primitives {
    exports jdk.prim;
    exports jdk.prim.util;
    exports jdk.prim.util.concurrent;
    exports jdk.prim.util.function;
    exports jdk.prim.util.map;
    exports jdk.prim.util.stream;
    requires jdk.unsupported;// Used by the jdk.prim.util.dualpivot package
    requires java.logging;//Only used by the test environment
}
