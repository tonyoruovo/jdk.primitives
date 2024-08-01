package jdk.prim.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.TimeUnit;

/**
 * A shared interface for {@code CompletionService} types that specialise on java primitives
 * 
 * @see CompletionService
 */
public interface PrimitiveCompletionService<OF> extends CompletionService<OF> {
    /**
     * A {@code CompletionService} for a {@code double}
     */
    interface OfDouble extends PrimitiveCompletionService<java.lang.Double> {
        /**
         * The {@code double} specialisation of {@link #poll()}
         * @return the {@code double} future representing the representing
         * the next completed task or {@code null} if none is present
         * @see CompletionService#poll()
         */
        PrimitiveFuture.ToDouble pollDouble();
        /**
         * The {@code double} specialisation of {@link #poll(long, TimeUnit)}
         * @param timeout how long to wait before giving up, in units of {@code unit}
         * @param unit a {@code TimeUnit} determining how to interpret the {@code timeout} parameter
         * @return  the Future representing the next completed task or
        *         {@code null} if the specified waiting time elapses
        *         before one is present
        * @throws InterruptedException if interrupted while waiting
         * @see CompletionService#poll(long, TimeUnit)
         */
        PrimitiveFuture.ToDouble pollDouble(long timeout, TimeUnit unit) throws InterruptedException;
        /**
         * The {@code double} specialisation of {@link #submit(Runnable, Double)}
        * @param task the task to submit
        * @param result the result to return upon successful completion
        * @return a Future representing pending completion of the task,
        *         and whose {@code get()} method will return the given
        *         result value upon completion
        * @throws RejectedExecutionException if the task cannot be
        *         scheduled for execution
        * @throws NullPointerException if the task is null
         * @see CompletionService#submit(Runnable, Object)
         */
        PrimitiveFuture.ToDouble submitDouble(Runnable task, double result);
        /**
         * The {@code double} specialisation of {@link #submit(Callable)}
        *
        * @param task the task to submit
        * @return a Future representing pending completion of the task
        * @throws RejectedExecutionException if the task cannot be
        *         scheduled for execution
        * @throws NullPointerException if the task is null
         * @see CompletionService#submit(Callable)
         */
        PrimitiveFuture.ToDouble submitDouble(PrimitiveCallable.ToDouble task);
        /**
        * The {@code double} specialisation for {@link #take()}
        * @return the Future representing the next completed task
        * @throws InterruptedException if interrupted while waiting
         * @see CompletionService#take()
         */
        PrimitiveFuture.ToDouble takeDouble();
        /**
         * {@inheritDoc}
         * 
         * @return {@inheritDoc}
         * 
         * @implNote The default implementation calls {@link #pollDouble()}
         */
        @Override default PrimitiveFuture.ToDouble poll() { return pollDouble(); }
        /**
         * {@inheritDoc}
         * 
         * @return {@inheritDoc}
         * 
         * @implNote The default implementation calls {@link #pollDouble(long, TimeUnit)}
         */
        @Override default PrimitiveFuture.ToDouble poll(long timeout, TimeUnit unit) throws InterruptedException { return pollDouble(timeout, unit); }
        /**
         * {@inheritDoc}
         * 
         * @return {@inheritDoc}
         * 
         * @implNote The default implementation calls {@link #submitDouble(Runnable, java.lang.Double)}
         */
        @Override default PrimitiveFuture.ToDouble submit(Runnable task, java.lang.Double result) { return submitDouble(task, result); }
        /**
         * {@inheritDoc}
         * 
         * @return {@inheritDoc}
         * 
         * @implNote The default implementation calls {@link #submitDouble(Callable)}
         */
        @Override default PrimitiveFuture.ToDouble submit(Callable<java.lang.Double> task) { return submitDouble((PrimitiveCallable.ToDouble) task::call); }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         * @throws InterruptedException {@inheritDoc}
         */
        @Override default PrimitiveFuture.ToDouble take() { return takeDouble(); }
    }
    /**
     * A {@code CompletionService} for a {@code long}
     */
    interface OfLong extends PrimitiveCompletionService<java.lang.Long> {
        /**
         * The {@code long} specialisation of {@link #poll()}
         * @return the {@code long} future representing the representing
         * the next completed task or {@code null} if none is present
         * @see CompletionService#poll()
         */
        PrimitiveFuture.ToLong pollLong();
        /**
         * The {@code long} specialisation of {@link #poll(long, TimeUnit)}
         * @param timeout how long to wait before giving up, in units of {@code unit}
         * @param unit a {@code TimeUnit} determining how to interpret the {@code timeout} parameter
         * @return  the Future representing the next completed task or
        *         {@code null} if the specified waiting time elapses
        *         before one is present
        * @throws InterruptedException if interrupted while waiting
         * @see CompletionService#poll(long, TimeUnit)
         */
        PrimitiveFuture.ToLong pollLong(long timeout, TimeUnit unit) throws InterruptedException;
        /**
         * The {@code long} specialisation of {@link #submit(Runnable, Double)}
        * @param task the task to submit
        * @param result the result to return upon successful completion
        * @return a Future representing pending completion of the task,
        *         and whose {@code get()} method will return the given
        *         result value upon completion
        * @throws RejectedExecutionException if the task cannot be
        *         scheduled for execution
        * @throws NullPointerException if the task is null
         * @see CompletionService#submit(Runnable, Object)
         */
        PrimitiveFuture.ToLong submitLong(Runnable task, long result);
        /**
         * The {@code long} specialisation of {@link #submit(Callable)}
        *
        * @param task the task to submit
        * @return a Future representing pending completion of the task
        * @throws RejectedExecutionException if the task cannot be
        *         scheduled for execution
        * @throws NullPointerException if the task is null
         * @see CompletionService#submit(Callable)
         */
        PrimitiveFuture.ToLong submitLong(PrimitiveCallable.ToLong task);
        /**
        * The {@code long} specialisation for {@link #take()}
        * @return the Future representing the next completed task
        * @throws InterruptedException if interrupted while waiting
         * @see CompletionService#take()
         */
        PrimitiveFuture.ToLong takeLong();
        /**
         * {@inheritDoc}
         * 
         * @return {@inheritDoc}
         * 
         * @implNote The default implementation calls {@link #pollLong()}
         */
        @Override default PrimitiveFuture.ToLong poll() { return pollLong(); }
        /**
         * {@inheritDoc}
         * 
         * @return {@inheritDoc}
         * 
         * @implNote The default implementation calls {@link #pollLong(long, TimeUnit)}
         */
        @Override default PrimitiveFuture.ToLong poll(long timeout, TimeUnit unit) throws InterruptedException { return pollLong(timeout, unit); }
        /**
         * {@inheritDoc}
         * 
         * @return {@inheritDoc}
         * 
         * @implNote The default implementation calls {@link #submitLong(Runnable, java.lang.Long)}
         */
        @Override default PrimitiveFuture.ToLong submit(Runnable task, java.lang.Long result) { return submitLong(task, result); }
        /**
         * {@inheritDoc}
         * 
         * @return {@inheritDoc}
         * 
         * @implNote The default implementation calls {@link #submitLong(Callable)}
         */
        @Override default PrimitiveFuture.ToLong submit(Callable<java.lang.Long> task) { return submitLong((PrimitiveCallable.ToLong) task::call); }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         * @throws InterruptedException {@inheritDoc}
         */
        @Override default PrimitiveFuture.ToLong take() { return takeLong(); }
    }
    /**
     * A {@code CompletionService} for a {@code int}
     */
    interface OfInt extends PrimitiveCompletionService<java.lang.Integer> {
        /**
         * The {@code int} specialisation of {@link #poll()}
         * @return the {@code int} future representing the representing
         * the next completed task or {@code null} if none is present
         * @see CompletionService#poll()
         */
        PrimitiveFuture.ToInt pollInt();
        /**
         * The {@code int} specialisation of {@link #poll(long, TimeUnit)}
         * @param timeout how long to wait before giving up, in units of {@code unit}
         * @param unit a {@code TimeUnit} determining how to interpret the {@code timeout} parameter
         * @return  the Future representing the next completed task or
        *         {@code null} if the specified waiting time elapses
        *         before one is present
        * @throws InterruptedException if interrupted while waiting
         * @see CompletionService#poll(long, TimeUnit)
         */
        PrimitiveFuture.ToInt pollInt(long timeout, TimeUnit unit) throws InterruptedException;
        /**
         * The {@code int} specialisation of {@link #submit(Runnable, Double)}
        * @param task the task to submit
        * @param result the result to return upon successful completion
        * @return a Future representing pending completion of the task,
        *         and whose {@code get()} method will return the given
        *         result value upon completion
        * @throws RejectedExecutionException if the task cannot be
        *         scheduled for execution
        * @throws NullPointerException if the task is null
         * @see CompletionService#submit(Runnable, Object)
         */
        PrimitiveFuture.ToInt submitInt(Runnable task, int result);
        /**
         * The {@code int} specialisation of {@link #submit(Callable)}
        *
        * @param task the task to submit
        * @return a Future representing pending completion of the task
        * @throws RejectedExecutionException if the task cannot be
        *         scheduled for execution
        * @throws NullPointerException if the task is null
         * @see CompletionService#submit(Callable)
         */
        PrimitiveFuture.ToInt submitInt(PrimitiveCallable.ToInt task);
        /**
        * The {@code int} specialisation for {@link #take()}
        * @return the Future representing the next completed task
        * @throws InterruptedException if interrupted while waiting
         * @see CompletionService#take()
         */
        PrimitiveFuture.ToInt takeInt();
        /**
         * {@inheritDoc}
         * 
         * @return {@inheritDoc}
         * 
         * @implNote The default implementation calls {@link #pollInt()}
         */
        @Override default PrimitiveFuture.ToInt poll() { return pollInt(); }
        /**
         * {@inheritDoc}
         * 
         * @return {@inheritDoc}
         * 
         * @implNote The default implementation calls {@link #pollInt(long, TimeUnit)}
         */
        @Override default PrimitiveFuture.ToInt poll(long timeout, TimeUnit unit) throws InterruptedException { return pollInt(timeout, unit); }
        /**
         * {@inheritDoc}
         * 
         * @return {@inheritDoc}
         * 
         * @implNote The default implementation calls {@link #submitInt(Runnable, java.lang.Int)}
         */
        @Override default PrimitiveFuture.ToInt submit(Runnable task, java.lang.Integer result) { return submitInt(task, result); }
        /**
         * {@inheritDoc}
         * 
         * @return {@inheritDoc}
         * 
         * @implNote The default implementation calls {@link #submitInt(Callable)}
         */
        @Override default PrimitiveFuture.ToInt submit(Callable<java.lang.Integer> task) { return submitInt((PrimitiveCallable.ToInt) task::call); }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         * @throws InterruptedException {@inheritDoc}
         */
        @Override default PrimitiveFuture.ToInt take() { return takeInt(); }
    }
    /**
     * A {@code CompletionService} for a {@code float}
     */
    interface OfFloat extends PrimitiveCompletionService<java.lang.Float> {
        /**
         * The {@code float} specialisation of {@link #poll()}
         * @return the {@code float} future representing the representing
         * the next completed task or {@code null} if none is present
         * @see CompletionService#poll()
         */
        PrimitiveFuture.ToFloat pollFloat();
        /**
         * The {@code float} specialisation of {@link #poll(long, TimeUnit)}
         * @param timeout how long to wait before giving up, in units of {@code unit}
         * @param unit a {@code TimeUnit} determining how to interpret the {@code timeout} parameter
         * @return  the Future representing the next completed task or
        *         {@code null} if the specified waiting time elapses
        *         before one is present
        * @throws InterruptedException if interrupted while waiting
         * @see CompletionService#poll(long, TimeUnit)
         */
        PrimitiveFuture.ToFloat pollFloat(long timeout, TimeUnit unit) throws InterruptedException;
        /**
         * The {@code float} specialisation of {@link #submit(Runnable, Double)}
        * @param task the task to submit
        * @param result the result to return upon successful completion
        * @return a Future representing pending completion of the task,
        *         and whose {@code get()} method will return the given
        *         result value upon completion
        * @throws RejectedExecutionException if the task cannot be
        *         scheduled for execution
        * @throws NullPointerException if the task is null
         * @see CompletionService#submit(Runnable, Object)
         */
        PrimitiveFuture.ToFloat submitFloat(Runnable task, float result);
        /**
         * The {@code float} specialisation of {@link #submit(Callable)}
        *
        * @param task the task to submit
        * @return a Future representing pending completion of the task
        * @throws RejectedExecutionException if the task cannot be
        *         scheduled for execution
        * @throws NullPointerException if the task is null
         * @see CompletionService#submit(Callable)
         */
        PrimitiveFuture.ToFloat submitFloat(PrimitiveCallable.ToFloat task);
        /**
        * The {@code float} specialisation for {@link #take()}
        * @return the Future representing the next completed task
        * @throws InterruptedException if interrupted while waiting
         * @see CompletionService#take()
         */
        PrimitiveFuture.ToFloat takeFloat();
        /**
         * {@inheritDoc}
         * 
         * @return {@inheritDoc}
         * 
         * @implNote The default implementation calls {@link #pollFloat()}
         */
        @Override default PrimitiveFuture.ToFloat poll() { return pollFloat(); }
        /**
         * {@inheritDoc}
         * 
         * @return {@inheritDoc}
         * 
         * @implNote The default implementation calls {@link #pollFloat(long, TimeUnit)}
         */
        @Override default PrimitiveFuture.ToFloat poll(long timeout, TimeUnit unit) throws InterruptedException { return pollFloat(timeout, unit); }
        /**
         * {@inheritDoc}
         * 
         * @return {@inheritDoc}
         * 
         * @implNote The default implementation calls {@link #submitFloat(Runnable, java.lang.Float)}
         */
        @Override default PrimitiveFuture.ToFloat submit(Runnable task, java.lang.Float result) { return submitFloat(task, result); }
        /**
         * {@inheritDoc}
         * 
         * @return {@inheritDoc}
         * 
         * @implNote The default implementation calls {@link #submitFloat(Callable)}
         */
        @Override default PrimitiveFuture.ToFloat submit(Callable<java.lang.Float> task) { return submitFloat((PrimitiveCallable.ToFloat) task::call); }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         * @throws InterruptedException {@inheritDoc}
         */
        @Override default PrimitiveFuture.ToFloat take() { return takeFloat(); }
    }
    /**
     * A {@code CompletionService} for a {@code char}
     */
    interface OfChar extends PrimitiveCompletionService<java.lang.Character> {
        /**
         * The {@code char} specialisation of {@link #poll()}
         * @return the {@code char} future representing the representing
         * the next completed task or {@code null} if none is present
         * @see CompletionService#poll()
         */
        PrimitiveFuture.ToChar pollChar();
        /**
         * The {@code char} specialisation of {@link #poll(long, TimeUnit)}
         * @param timeout how long to wait before giving up, in units of {@code unit}
         * @param unit a {@code TimeUnit} determining how to interpret the {@code timeout} parameter
         * @return  the Future representing the next completed task or
        *         {@code null} if the specified waiting time elapses
        *         before one is present
        * @throws InterruptedException if interrupted while waiting
         * @see CompletionService#poll(long, TimeUnit)
         */
        PrimitiveFuture.ToChar pollChar(long timeout, TimeUnit unit) throws InterruptedException;
        /**
         * The {@code char} specialisation of {@link #submit(Runnable, Double)}
        * @param task the task to submit
        * @param result the result to return upon successful completion
        * @return a Future representing pending completion of the task,
        *         and whose {@code get()} method will return the given
        *         result value upon completion
        * @throws RejectedExecutionException if the task cannot be
        *         scheduled for execution
        * @throws NullPointerException if the task is null
         * @see CompletionService#submit(Runnable, Object)
         */
        PrimitiveFuture.ToChar submitChar(Runnable task, char result);
        /**
         * The {@code char} specialisation of {@link #submit(Callable)}
        *
        * @param task the task to submit
        * @return a Future representing pending completion of the task
        * @throws RejectedExecutionException if the task cannot be
        *         scheduled for execution
        * @throws NullPointerException if the task is null
         * @see CompletionService#submit(Callable)
         */
        PrimitiveFuture.ToChar submitChar(PrimitiveCallable.ToChar task);
        /**
        * The {@code char} specialisation for {@link #take()}
        * @return the Future representing the next completed task
        * @throws InterruptedException if interrupted while waiting
         * @see CompletionService#take()
         */
        PrimitiveFuture.ToChar takeChar();
        /**
         * {@inheritDoc}
         * 
         * @return {@inheritDoc}
         * 
         * @implNote The default implementation calls {@link #pollChar()}
         */
        @Override default PrimitiveFuture.ToChar poll() { return pollChar(); }
        /**
         * {@inheritDoc}
         * 
         * @return {@inheritDoc}
         * 
         * @implNote The default implementation calls {@link #pollChar(long, TimeUnit)}
         */
        @Override default PrimitiveFuture.ToChar poll(long timeout, TimeUnit unit) throws InterruptedException { return pollChar(timeout, unit); }
        /**
         * {@inheritDoc}
         * 
         * @return {@inheritDoc}
         * 
         * @implNote The default implementation calls {@link #submitChar(Runnable, java.lang.Char)}
         */
        @Override default PrimitiveFuture.ToChar submit(Runnable task, java.lang.Character result) { return submitChar(task, result); }
        /**
         * {@inheritDoc}
         * 
         * @return {@inheritDoc}
         * 
         * @implNote The default implementation calls {@link #submitChar(Callable)}
         */
        @Override default PrimitiveFuture.ToChar submit(Callable<java.lang.Character> task) { return submitChar((PrimitiveCallable.ToChar) task::call); }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         * @throws InterruptedException {@inheritDoc}
         */
        @Override default PrimitiveFuture.ToChar take() { return takeChar(); }
    }
    /**
     * A {@code CompletionService} for a {@code short}
     */
    interface OfShort extends PrimitiveCompletionService<java.lang.Short> {
        /**
         * The {@code short} specialisation of {@link #poll()}
         * @return the {@code short} future representing the representing
         * the next completed task or {@code null} if none is present
         * @see CompletionService#poll()
         */
        PrimitiveFuture.ToShort pollShort();
        /**
         * The {@code short} specialisation of {@link #poll(long, TimeUnit)}
         * @param timeout how long to wait before giving up, in units of {@code unit}
         * @param unit a {@code TimeUnit} determining how to interpret the {@code timeout} parameter
         * @return  the Future representing the next completed task or
        *         {@code null} if the specified waiting time elapses
        *         before one is present
        * @throws InterruptedException if interrupted while waiting
         * @see CompletionService#poll(long, TimeUnit)
         */
        PrimitiveFuture.ToShort pollShort(long timeout, TimeUnit unit) throws InterruptedException;
        /**
         * The {@code short} specialisation of {@link #submit(Runnable, Double)}
        * @param task the task to submit
        * @param result the result to return upon successful completion
        * @return a Future representing pending completion of the task,
        *         and whose {@code get()} method will return the given
        *         result value upon completion
        * @throws RejectedExecutionException if the task cannot be
        *         scheduled for execution
        * @throws NullPointerException if the task is null
         * @see CompletionService#submit(Runnable, Object)
         */
        PrimitiveFuture.ToShort submitShort(Runnable task, short result);
        /**
         * The {@code short} specialisation of {@link #submit(Callable)}
        *
        * @param task the task to submit
        * @return a Future representing pending completion of the task
        * @throws RejectedExecutionException if the task cannot be
        *         scheduled for execution
        * @throws NullPointerException if the task is null
         * @see CompletionService#submit(Callable)
         */
        PrimitiveFuture.ToShort submitShort(PrimitiveCallable.ToShort task);
        /**
        * The {@code short} specialisation for {@link #take()}
        * @return the Future representing the next completed task
        * @throws InterruptedException if interrupted while waiting
         * @see CompletionService#take()
         */
        PrimitiveFuture.ToShort takeShort();
        /**
         * {@inheritDoc}
         * 
         * @return {@inheritDoc}
         * 
         * @implNote The default implementation calls {@link #pollShort()}
         */
        @Override default PrimitiveFuture.ToShort poll() { return pollShort(); }
        /**
         * {@inheritDoc}
         * 
         * @return {@inheritDoc}
         * 
         * @implNote The default implementation calls {@link #pollShort(long, TimeUnit)}
         */
        @Override default PrimitiveFuture.ToShort poll(long timeout, TimeUnit unit) throws InterruptedException { return pollShort(timeout, unit); }
        /**
         * {@inheritDoc}
         * 
         * @return {@inheritDoc}
         * 
         * @implNote The default implementation calls {@link #submitShort(Runnable, java.lang.Short)}
         */
        @Override default PrimitiveFuture.ToShort submit(Runnable task, java.lang.Short result) { return submitShort(task, result); }
        /**
         * {@inheritDoc}
         * 
         * @return {@inheritDoc}
         * 
         * @implNote The default implementation calls {@link #submitShort(Callable)}
         */
        @Override default PrimitiveFuture.ToShort submit(Callable<java.lang.Short> task) { return submitShort((PrimitiveCallable.ToShort) task::call); }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         * @throws InterruptedException {@inheritDoc}
         */
        @Override default PrimitiveFuture.ToShort take() { return takeShort(); }
    }
    /**
     * A {@code CompletionService} for a {@code byte}
     */
    interface OfByte extends PrimitiveCompletionService<java.lang.Byte> {
        /**
         * The {@code byte} specialisation of {@link #poll()}
         * @return the {@code byte} future representing the representing
         * the next completed task or {@code null} if none is present
         * @see CompletionService#poll()
         */
        PrimitiveFuture.ToByte pollByte();
        /**
         * The {@code byte} specialisation of {@link #poll(long, TimeUnit)}
         * @param timeout how long to wait before giving up, in units of {@code unit}
         * @param unit a {@code TimeUnit} determining how to interpret the {@code timeout} parameter
         * @return  the Future representing the next completed task or
        *         {@code null} if the specified waiting time elapses
        *         before one is present
        * @throws InterruptedException if interrupted while waiting
         * @see CompletionService#poll(long, TimeUnit)
         */
        PrimitiveFuture.ToByte pollByte(long timeout, TimeUnit unit) throws InterruptedException;
        /**
         * The {@code byte} specialisation of {@link #submit(Runnable, Double)}
        * @param task the task to submit
        * @param result the result to return upon successful completion
        * @return a Future representing pending completion of the task,
        *         and whose {@code get()} method will return the given
        *         result value upon completion
        * @throws RejectedExecutionException if the task cannot be
        *         scheduled for execution
        * @throws NullPointerException if the task is null
         * @see CompletionService#submit(Runnable, Object)
         */
        PrimitiveFuture.ToByte submitByte(Runnable task, byte result);
        /**
         * The {@code byte} specialisation of {@link #submit(Callable)}
        *
        * @param task the task to submit
        * @return a Future representing pending completion of the task
        * @throws RejectedExecutionException if the task cannot be
        *         scheduled for execution
        * @throws NullPointerException if the task is null
         * @see CompletionService#submit(Callable)
         */
        PrimitiveFuture.ToByte submitByte(PrimitiveCallable.ToByte task);
        /**
        * The {@code byte} specialisation for {@link #take()}
        * @return the Future representing the next completed task
        * @throws InterruptedException if interrupted while waiting
         * @see CompletionService#take()
         */
        PrimitiveFuture.ToByte takeByte();
        /**
         * {@inheritDoc}
         * 
         * @return {@inheritDoc}
         * 
         * @implNote The default implementation calls {@link #pollByte()}
         */
        @Override default PrimitiveFuture.ToByte poll() { return pollByte(); }
        /**
         * {@inheritDoc}
         * 
         * @return {@inheritDoc}
         * 
         * @implNote The default implementation calls {@link #pollByte(long, TimeUnit)}
         */
        @Override default PrimitiveFuture.ToByte poll(long timeout, TimeUnit unit) throws InterruptedException { return pollByte(timeout, unit); }
        /**
         * {@inheritDoc}
         * 
         * @return {@inheritDoc}
         * 
         * @implNote The default implementation calls {@link #submitByte(Runnable, java.lang.Byte)}
         */
        @Override default PrimitiveFuture.ToByte submit(Runnable task, java.lang.Byte result) { return submitByte(task, result); }
        /**
         * {@inheritDoc}
         * 
         * @return {@inheritDoc}
         * 
         * @implNote The default implementation calls {@link #submitByte(Callable)}
         */
        @Override default PrimitiveFuture.ToByte submit(Callable<java.lang.Byte> task) { return submitByte((PrimitiveCallable.ToByte) task::call); }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         * @throws InterruptedException {@inheritDoc}
         */
        @Override default PrimitiveFuture.ToByte take() { return takeByte(); }
    }
    /**
     * A {@code CompletionService} for a {@code boolean}
     */
    interface OfBoolean extends PrimitiveCompletionService<java.lang.Boolean> {
        /**
         * The {@code boolean} specialisation of {@link #poll()}
         * @return the {@code boolean} future representing the representing
         * the next completed task or {@code null} if none is present
         * @see CompletionService#poll()
         */
        PrimitiveFuture.ToBoolean pollBoolean();
        /**
         * The {@code boolean} specialisation of {@link #poll(long, TimeUnit)}
         * @param timeout how long to wait before giving up, in units of {@code unit}
         * @param unit a {@code TimeUnit} determining how to interpret the {@code timeout} parameter
         * @return  the Future representing the next completed task or
        *         {@code null} if the specified waiting time elapses
        *         before one is present
        * @throws InterruptedException if interrupted while waiting
         * @see CompletionService#poll(long, TimeUnit)
         */
        PrimitiveFuture.ToBoolean pollBoolean(long timeout, TimeUnit unit) throws InterruptedException;
        /**
         * The {@code boolean} specialisation of {@link #submit(Runnable, Double)}
        * @param task the task to submit
        * @param result the result to return upon successful completion
        * @return a Future representing pending completion of the task,
        *         and whose {@code get()} method will return the given
        *         result value upon completion
        * @throws RejectedExecutionException if the task cannot be
        *         scheduled for execution
        * @throws NullPointerException if the task is null
         * @see CompletionService#submit(Runnable, Object)
         */
        PrimitiveFuture.ToBoolean submitBoolean(Runnable task, boolean result);
        /**
         * The {@code boolean} specialisation of {@link #submit(Callable)}
        *
        * @param task the task to submit
        * @return a Future representing pending completion of the task
        * @throws RejectedExecutionException if the task cannot be
        *         scheduled for execution
        * @throws NullPointerException if the task is null
         * @see CompletionService#submit(Callable)
         */
        PrimitiveFuture.ToBoolean submitBoolean(PrimitiveCallable.ToBoolean task);
        /**
        * The {@code boolean} specialisation for {@link #take()}
        * @return the Future representing the next completed task
        * @throws InterruptedException if interrupted while waiting
         * @see CompletionService#take()
         */
        PrimitiveFuture.ToBoolean takeBoolean();
        /**
         * {@inheritDoc}
         * 
         * @return {@inheritDoc}
         * 
         * @implNote The default implementation calls {@link #pollBoolean()}
         */
        @Override default PrimitiveFuture.ToBoolean poll() { return pollBoolean(); }
        /**
         * {@inheritDoc}
         * 
         * @return {@inheritDoc}
         * 
         * @implNote The default implementation calls {@link #pollBoolean(long, TimeUnit)}
         */
        @Override default PrimitiveFuture.ToBoolean poll(long timeout, TimeUnit unit) throws InterruptedException { return pollBoolean(timeout, unit); }
        /**
         * {@inheritDoc}
         * 
         * @return {@inheritDoc}
         * 
         * @implNote The default implementation calls {@link #submitBoolean(Runnable, java.lang.Boolean)}
         */
        @Override default PrimitiveFuture.ToBoolean submit(Runnable task, java.lang.Boolean result) { return submitBoolean(task, result); }
        /**
         * {@inheritDoc}
         * 
         * @return {@inheritDoc}
         * 
         * @implNote The default implementation calls {@link #submitBoolean(Callable)}
         */
        @Override default PrimitiveFuture.ToBoolean submit(Callable<java.lang.Boolean> task) { return submitBoolean((PrimitiveCallable.ToBoolean) task::call); }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         * @throws InterruptedException {@inheritDoc}
         */
        @Override default PrimitiveFuture.ToBoolean take() { return takeBoolean(); }
    }
}
