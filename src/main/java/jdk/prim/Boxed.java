package jdk.prim;

/**
 * Represents a type (primitive container type) that can be boxed to the java equivalent for that primitive type.
 * <p>
 * This is analogous to {@link java.util.stream.DoubleStream#boxed()}
 * 
 * @see java.util.stream.DoubleStream#boxed()
 */
public interface Boxed<B> {
    /**
     * Boxes this type to the equivalent boxed primitive version.
     * <p>
     * For example:
     * <pre>
     * <code>jdk.prim.PrimitiveIterable.OfInt iterable = toSomeIntCollection();
     *java.lang.Iterable&lt;java.lang.Integer&gt; boxed = iterable.boxed();
     * </code>
     * </pre>
     * @return the boxed version of {@code this}
     */
    B boxed();
}
