package jdk.prim.util.concurrent;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * A common interface for all primitive {@code Future} types
 * 
 * @see Future
 */
public interface PrimitiveFuture<TO> extends Future<TO> {
    /**
     * A {@code PrimitiveFuture} for a {@code double}
     */
    interface ToDouble extends PrimitiveFuture<java.lang.Double> {
        /**
         * The {@code double} variant of {@link #get(long, TimeUnit)}
         * @param timeout the max time to wait
         * @param unit the time unit of the {@code timeout} argument
         * @return the computed {@code double}
         * @throws CancellationException if the computation was cancelled
         * @throws InterruptedException if the current thread was interrupted while waiting
         * @throws ExecutionException if the computation threw an exception
         * @throws TimeoutException if the wait timed out
         * @see Future#get(long, TimeUnit)
         * @apiNote This is the {@code double} specialisation of {@link #get(long, TimeUnit)}
         * and should be preferred
         */
        double getDouble(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException;
        /**
         * The {@code double} specialisation for {@link #get()}
         * @return the computed {@code double}
         * @throws CancellationException if the computation was cancelled
         * @throws InterruptedException if the current thread was interrupted while waiting
         * @throws ExecutionException if the computation threw
         * @see Future#get()
         * @apiNote This is the {@code double} specialisation of {@link #get()} and should
         * be preferred
         */
        double getDouble() throws InterruptedException, ExecutionException;
        /**
         * {@inheritDoc}
         * @param timeout {@inheritDoc}
         * @param unit {@inheritDoc}
         * @return {@inheritDoc}
         * @throws CancellationException {@inheritDoc}
         * @throws InterruptedException {@inheritDoc}
         * @throws ExecutionException {@inheritDoc}
         * @throws TimeoutException {@inheritDoc}
         * @implNote The default implementation returns the value of {@link #getDouble(long, TimeUnit)}
         */
        @Override default java.lang.Double get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException { return getDouble(timeout, unit); }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         * @throws CancellationException {@inheritDoc}
         * @throws InterruptedException {@inheritDoc}
         * @throws ExecutionException {@inheritDoc}
         * @implNote The default implementation returns {@link #getDouble()}
         */
        @Override default java.lang.Double get() throws InterruptedException, ExecutionException { return getDouble(); }
        /**
         * The {@code double} specialisation for {@link #resultNow()}
         * @return the computed {@code double}
         * @throws IllegalStateException If the task has not completed or did not complete with
         * a result
         * @see Future#resultNow()
         * @apiNote This should be preferred over {@link #resultNow()} as not conversion is done here
         */
        default double resultNowDouble() {
            if (!isDone())
                throw new IllegalStateException("Task has not completed");
            boolean interrupted = false;
            try {
                while (true) {
                    try {
                        return getDouble();
                    } catch (InterruptedException e) {
                        interrupted = true;
                    } catch (ExecutionException e) {
                        throw new IllegalStateException("Task completed with exception");
                    } catch (CancellationException e) {
                        throw new IllegalStateException("Task was cancelled");
                    }
                }
            } finally {
                if (interrupted) Thread.currentThread().interrupt();
            }
        }
        /**
         * Returns the exception thrown by the task without waiting.
         * @return the exception thrown by the task
         * @throws IllegalStateException is the task has not completed,
         * the task completed or was cancelled
         * @implNote The default implementation overrides the default
         * implementation defined in {@link Future#exceptionNow()} to
         * support the method specialisation {@link #getDouble()}
         */
        @Override default Throwable exceptionNow() {
            if (!isDone())
                throw new IllegalStateException("Task has not completed");
            if (isCancelled())
                throw new IllegalStateException("Task was cancelled");
            boolean interrupted = false;
            try {
                while (true) {
                    try {
                        getDouble();
                        throw new IllegalStateException("Task completed with a result");
                    } catch (InterruptedException e) {
                        interrupted = true;
                    } catch (ExecutionException e) {
                        return e.getCause();
                    }
                }
            } finally {
                if (interrupted) Thread.currentThread().interrupt();
            }
        }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote This is overridden to allow for the specialised
         * {@link #getDouble()} to be used instead of {@link #get()}
         */
        @Override default Future.State state() {
        if (!isDone())
            return State.RUNNING;
        if (isCancelled())
            return State.CANCELLED;
        boolean interrupted = false;
        try {
            while (true) {
                try {
                    getDouble();
                    return State.SUCCESS;
                } catch (InterruptedException e) {
                    interrupted = true;
                } catch (ExecutionException e) {
                    return State.FAILED;
                }
            }
        } finally {
            if (interrupted) Thread.currentThread().interrupt();
        }
        }
    }
    /**
     * A {@code PrimitiveFuture} for a {@code long}
     */
    interface ToLong extends PrimitiveFuture<java.lang.Long> {
        /**
         * The {@code long} variant of {@link #get(long, TimeUnit)}
         * @param timeout the max time to wait
         * @param unit the time unit of the {@code timeout} argument
         * @return the computed {@code long}
         * @throws CancellationException if the computation was cancelled
         * @throws InterruptedException if the current thread was interrupted while waiting
         * @throws ExecutionException if the computation threw an exception
         * @throws TimeoutException if the wait timed out
         * @see Future#get(long, TimeUnit)
         * @apiNote This is the {@code long} specialisation of {@link #get(long, TimeUnit)}
         * and should be preferred
         */
        long getLong(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException;
        /**
         * The {@code long} specialisation for {@link #get()}
         * @return the computed {@code long}
         * @throws CancellationException if the computation was cancelled
         * @throws InterruptedException if the current thread was interrupted while waiting
         * @throws ExecutionException if the computation threw
         * @see Future#get()
         * @apiNote This is the {@code long} specialisation of {@link #get()} and should
         * be preferred
         */
        long getLong() throws InterruptedException, ExecutionException;
        /**
         * {@inheritDoc}
         * @param timeout {@inheritDoc}
         * @param unit {@inheritDoc}
         * @return {@inheritDoc}
         * @throws CancellationException {@inheritDoc}
         * @throws InterruptedException {@inheritDoc}
         * @throws ExecutionException {@inheritDoc}
         * @throws TimeoutException {@inheritDoc}
         * @implNote The default implementation returns the value of {@link #getLong(long, TimeUnit)}
         */
        @Override default java.lang.Long get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException { return getLong(timeout, unit); }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         * @throws CancellationException {@inheritDoc}
         * @throws InterruptedException {@inheritDoc}
         * @throws ExecutionException {@inheritDoc}
         * @implNote The default implementation returns {@link #getLong()}
         */
        @Override default java.lang.Long get() throws InterruptedException, ExecutionException { return getLong(); }
        /**
         * The {@code long} specialisation for {@link #resultNow()}
         * @return the computed {@code long}
         * @throws IllegalStateException If the task has not completed or did not complete with
         * a result
         * @see Future#resultNow()
         * @apiNote This should be preferred over {@link #resultNow()} as not conversion is done here
         */
        default long resultNowLong() {
            if (!isDone())
                throw new IllegalStateException("Task has not completed");
            boolean interrupted = false;
            try {
                while (true) {
                    try {
                        return getLong();
                    } catch (InterruptedException e) {
                        interrupted = true;
                    } catch (ExecutionException e) {
                        throw new IllegalStateException("Task completed with exception");
                    } catch (CancellationException e) {
                        throw new IllegalStateException("Task was cancelled");
                    }
                }
            } finally {
                if (interrupted) Thread.currentThread().interrupt();
            }
        }
        /**
         * Returns the exception thrown by the task without waiting.
         * @return the exception thrown by the task
         * @throws IllegalStateException is the task has not completed,
         * the task completed or was cancelled
         * @implNote The default implementation overrides the default
         * implementation defined in {@link Future#exceptionNow()} to
         * support the method specialisation {@link #getLong()}
         */
        @Override default Throwable exceptionNow() {
            if (!isDone())
                throw new IllegalStateException("Task has not completed");
            if (isCancelled())
                throw new IllegalStateException("Task was cancelled");
            boolean interrupted = false;
            try {
                while (true) {
                    try {
                        getLong();
                        throw new IllegalStateException("Task completed with a result");
                    } catch (InterruptedException e) {
                        interrupted = true;
                    } catch (ExecutionException e) {
                        return e.getCause();
                    }
                }
            } finally {
                if (interrupted) Thread.currentThread().interrupt();
            }
        }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote This is overridden to allow for the specialised
         * {@link #getLong()} to be used instead of {@link #get()}
         */
        @Override default Future.State state() {
        if (!isDone())
            return State.RUNNING;
        if (isCancelled())
            return State.CANCELLED;
        boolean interrupted = false;
        try {
            while (true) {
                try {
                    getLong();
                    return State.SUCCESS;
                } catch (InterruptedException e) {
                    interrupted = true;
                } catch (ExecutionException e) {
                    return State.FAILED;
                }
            }
        } finally {
            if (interrupted) Thread.currentThread().interrupt();
        }
        }
    }
    /**
     * A {@code PrimitiveFuture} for a {@code int}
     */
    interface ToInt extends PrimitiveFuture<java.lang.Integer> {
        /**
         * The {@code int} variant of {@link #get(long, TimeUnit)}
         * @param timeout the max time to wait
         * @param unit the time unit of the {@code timeout} argument
         * @return the computed {@code int}
         * @throws CancellationException if the computation was cancelled
         * @throws InterruptedException if the current thread was interrupted while waiting
         * @throws ExecutionException if the computation threw an exception
         * @throws TimeoutException if the wait timed out
         * @see Future#get(long, TimeUnit)
         * @apiNote This is the {@code int} specialisation of {@link #get(long, TimeUnit)}
         * and should be preferred
         */
        int getInt(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException;
        /**
         * The {@code int} specialisation for {@link #get()}
         * @return the computed {@code int}
         * @throws CancellationException if the computation was cancelled
         * @throws InterruptedException if the current thread was interrupted while waiting
         * @throws ExecutionException if the computation threw
         * @see Future#get()
         * @apiNote This is the {@code int} specialisation of {@link #get()} and should
         * be preferred
         */
        int getInt() throws InterruptedException, ExecutionException;
        /**
         * {@inheritDoc}
         * @param timeout {@inheritDoc}
         * @param unit {@inheritDoc}
         * @return {@inheritDoc}
         * @throws CancellationException {@inheritDoc}
         * @throws InterruptedException {@inheritDoc}
         * @throws ExecutionException {@inheritDoc}
         * @throws TimeoutException {@inheritDoc}
         * @implNote The default implementation returns the value of {@link #getInt(long, TimeUnit)}
         */
        @Override default java.lang.Integer get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException { return getInt(timeout, unit); }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         * @throws CancellationException {@inheritDoc}
         * @throws InterruptedException {@inheritDoc}
         * @throws ExecutionException {@inheritDoc}
         * @implNote The default implementation returns {@link #getInt()}
         */
        @Override default java.lang.Integer get() throws InterruptedException, ExecutionException { return getInt(); }
        /**
         * The {@code int} specialisation for {@link #resultNow()}
         * @return the computed {@code int}
         * @throws IllegalStateException If the task has not completed or did not complete with
         * a result
         * @see Future#resultNow()
         * @apiNote This should be preferred over {@link #resultNow()} as not conversion is done here
         */
        default int resultNowInt() {
            if (!isDone())
                throw new IllegalStateException("Task has not completed");
            boolean interrupted = false;
            try {
                while (true) {
                    try {
                        return getInt();
                    } catch (InterruptedException e) {
                        interrupted = true;
                    } catch (ExecutionException e) {
                        throw new IllegalStateException("Task completed with exception");
                    } catch (CancellationException e) {
                        throw new IllegalStateException("Task was cancelled");
                    }
                }
            } finally {
                if (interrupted) Thread.currentThread().interrupt();
            }
        }
        /**
         * Returns the exception thrown by the task without waiting.
         * @return the exception thrown by the task
         * @throws IllegalStateException is the task has not completed,
         * the task completed or was cancelled
         * @implNote The default implementation overrides the default
         * implementation defined in {@link Future#exceptionNow()} to
         * support the method specialisation {@link #getInt()}
         */
        @Override default Throwable exceptionNow() {
            if (!isDone())
                throw new IllegalStateException("Task has not completed");
            if (isCancelled())
                throw new IllegalStateException("Task was cancelled");
            boolean interrupted = false;
            try {
                while (true) {
                    try {
                        getInt();
                        throw new IllegalStateException("Task completed with a result");
                    } catch (InterruptedException e) {
                        interrupted = true;
                    } catch (ExecutionException e) {
                        return e.getCause();
                    }
                }
            } finally {
                if (interrupted) Thread.currentThread().interrupt();
            }
        }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote This is overridden to allow for the specialised
         * {@link #getInt()} to be used instead of {@link #get()}
         */
        @Override default Future.State state() {
        if (!isDone())
            return State.RUNNING;
        if (isCancelled())
            return State.CANCELLED;
        boolean interrupted = false;
        try {
            while (true) {
                try {
                    getInt();
                    return State.SUCCESS;
                } catch (InterruptedException e) {
                    interrupted = true;
                } catch (ExecutionException e) {
                    return State.FAILED;
                }
            }
        } finally {
            if (interrupted) Thread.currentThread().interrupt();
        }
        }
    }
    /**
     * A {@code PrimitiveFuture} for a {@code float}
     */
    interface ToFloat extends PrimitiveFuture<java.lang.Float> {
        /**
         * The {@code float} variant of {@link #get(long, TimeUnit)}
         * @param timeout the max time to wait
         * @param unit the time unit of the {@code timeout} argument
         * @return the computed {@code float}
         * @throws CancellationException if the computation was cancelled
         * @throws InterruptedException if the current thread was interrupted while waiting
         * @throws ExecutionException if the computation threw an exception
         * @throws TimeoutException if the wait timed out
         * @see Future#get(long, TimeUnit)
         * @apiNote This is the {@code float} specialisation of {@link #get(long, TimeUnit)}
         * and should be preferred
         */
        float getFloat(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException;
        /**
         * The {@code float} specialisation for {@link #get()}
         * @return the computed {@code float}
         * @throws CancellationException if the computation was cancelled
         * @throws InterruptedException if the current thread was interrupted while waiting
         * @throws ExecutionException if the computation threw
         * @see Future#get()
         * @apiNote This is the {@code float} specialisation of {@link #get()} and should
         * be preferred
         */
        float getFloat() throws InterruptedException, ExecutionException;
        /**
         * {@inheritDoc}
         * @param timeout {@inheritDoc}
         * @param unit {@inheritDoc}
         * @return {@inheritDoc}
         * @throws CancellationException {@inheritDoc}
         * @throws InterruptedException {@inheritDoc}
         * @throws ExecutionException {@inheritDoc}
         * @throws TimeoutException {@inheritDoc}
         * @implNote The default implementation returns the value of {@link #getFloat(long, TimeUnit)}
         */
        @Override default java.lang.Float get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException { return getFloat(timeout, unit); }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         * @throws CancellationException {@inheritDoc}
         * @throws InterruptedException {@inheritDoc}
         * @throws ExecutionException {@inheritDoc}
         * @implNote The default implementation returns {@link #getFloat()}
         */
        @Override default java.lang.Float get() throws InterruptedException, ExecutionException { return getFloat(); }
        /**
         * The {@code float} specialisation for {@link #resultNow()}
         * @return the computed {@code float}
         * @throws IllegalStateException If the task has not completed or did not complete with
         * a result
         * @see Future#resultNow()
         * @apiNote This should be preferred over {@link #resultNow()} as not conversion is done here
         */
        default float resultNowFloat() {
            if (!isDone())
                throw new IllegalStateException("Task has not completed");
            boolean interrupted = false;
            try {
                while (true) {
                    try {
                        return getFloat();
                    } catch (InterruptedException e) {
                        interrupted = true;
                    } catch (ExecutionException e) {
                        throw new IllegalStateException("Task completed with exception");
                    } catch (CancellationException e) {
                        throw new IllegalStateException("Task was cancelled");
                    }
                }
            } finally {
                if (interrupted) Thread.currentThread().interrupt();
            }
        }
        /**
         * Returns the exception thrown by the task without waiting.
         * @return the exception thrown by the task
         * @throws IllegalStateException is the task has not completed,
         * the task completed or was cancelled
         * @implNote The default implementation overrides the default
         * implementation defined in {@link Future#exceptionNow()} to
         * support the method specialisation {@link #getFloat()}
         */
        @Override default Throwable exceptionNow() {
            if (!isDone())
                throw new IllegalStateException("Task has not completed");
            if (isCancelled())
                throw new IllegalStateException("Task was cancelled");
            boolean interrupted = false;
            try {
                while (true) {
                    try {
                        getFloat();
                        throw new IllegalStateException("Task completed with a result");
                    } catch (InterruptedException e) {
                        interrupted = true;
                    } catch (ExecutionException e) {
                        return e.getCause();
                    }
                }
            } finally {
                if (interrupted) Thread.currentThread().interrupt();
            }
        }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote This is overridden to allow for the specialised
         * {@link #getFloat()} to be used instead of {@link #get()}
         */
        @Override default Future.State state() {
        if (!isDone())
            return State.RUNNING;
        if (isCancelled())
            return State.CANCELLED;
        boolean interrupted = false;
        try {
            while (true) {
                try {
                    getFloat();
                    return State.SUCCESS;
                } catch (InterruptedException e) {
                    interrupted = true;
                } catch (ExecutionException e) {
                    return State.FAILED;
                }
            }
        } finally {
            if (interrupted) Thread.currentThread().interrupt();
        }
        }
    }
    /**
     * A {@code PrimitiveFuture} for a {@code char}
     */
    interface ToChar extends PrimitiveFuture<java.lang.Character> {
        /**
         * The {@code char} variant of {@link #get(long, TimeUnit)}
         * @param timeout the max time to wait
         * @param unit the time unit of the {@code timeout} argument
         * @return the computed {@code char}
         * @throws CancellationException if the computation was cancelled
         * @throws InterruptedException if the current thread was interrupted while waiting
         * @throws ExecutionException if the computation threw an exception
         * @throws TimeoutException if the wait timed out
         * @see Future#get(long, TimeUnit)
         * @apiNote This is the {@code char} specialisation of {@link #get(long, TimeUnit)}
         * and should be preferred
         */
        char getChar(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException;
        /**
         * The {@code char} specialisation for {@link #get()}
         * @return the computed {@code char}
         * @throws CancellationException if the computation was cancelled
         * @throws InterruptedException if the current thread was interrupted while waiting
         * @throws ExecutionException if the computation threw
         * @see Future#get()
         * @apiNote This is the {@code char} specialisation of {@link #get()} and should
         * be preferred
         */
        char getChar() throws InterruptedException, ExecutionException;
        /**
         * {@inheritDoc}
         * @param timeout {@inheritDoc}
         * @param unit {@inheritDoc}
         * @return {@inheritDoc}
         * @throws CancellationException {@inheritDoc}
         * @throws InterruptedException {@inheritDoc}
         * @throws ExecutionException {@inheritDoc}
         * @throws TimeoutException {@inheritDoc}
         * @implNote The default implementation returns the value of {@link #getChar(long, TimeUnit)}
         */
        @Override default java.lang.Character get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException { return getChar(timeout, unit); }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         * @throws CancellationException {@inheritDoc}
         * @throws InterruptedException {@inheritDoc}
         * @throws ExecutionException {@inheritDoc}
         * @implNote The default implementation returns {@link #getChar()}
         */
        @Override default java.lang.Character get() throws InterruptedException, ExecutionException { return getChar(); }
        /**
         * The {@code char} specialisation for {@link #resultNow()}
         * @return the computed {@code char}
         * @throws IllegalStateException If the task has not completed or did not complete with
         * a result
         * @see Future#resultNow()
         * @apiNote This should be preferred over {@link #resultNow()} as not conversion is done here
         */
        default char resultNowChar() {
            if (!isDone())
                throw new IllegalStateException("Task has not completed");
            boolean interrupted = false;
            try {
                while (true) {
                    try {
                        return getChar();
                    } catch (InterruptedException e) {
                        interrupted = true;
                    } catch (ExecutionException e) {
                        throw new IllegalStateException("Task completed with exception");
                    } catch (CancellationException e) {
                        throw new IllegalStateException("Task was cancelled");
                    }
                }
            } finally {
                if (interrupted) Thread.currentThread().interrupt();
            }
        }
        /**
         * Returns the exception thrown by the task without waiting.
         * @return the exception thrown by the task
         * @throws IllegalStateException is the task has not completed,
         * the task completed or was cancelled
         * @implNote The default implementation overrides the default
         * implementation defined in {@link Future#exceptionNow()} to
         * support the method specialisation {@link #getChar()}
         */
        @Override default Throwable exceptionNow() {
            if (!isDone())
                throw new IllegalStateException("Task has not completed");
            if (isCancelled())
                throw new IllegalStateException("Task was cancelled");
            boolean interrupted = false;
            try {
                while (true) {
                    try {
                        getChar();
                        throw new IllegalStateException("Task completed with a result");
                    } catch (InterruptedException e) {
                        interrupted = true;
                    } catch (ExecutionException e) {
                        return e.getCause();
                    }
                }
            } finally {
                if (interrupted) Thread.currentThread().interrupt();
            }
        }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote This is overridden to allow for the specialised
         * {@link #getChar()} to be used instead of {@link #get()}
         */
        @Override default Future.State state() {
        if (!isDone())
            return State.RUNNING;
        if (isCancelled())
            return State.CANCELLED;
        boolean interrupted = false;
        try {
            while (true) {
                try {
                    getChar();
                    return State.SUCCESS;
                } catch (InterruptedException e) {
                    interrupted = true;
                } catch (ExecutionException e) {
                    return State.FAILED;
                }
            }
        } finally {
            if (interrupted) Thread.currentThread().interrupt();
        }
        }
    }
    /**
     * A {@code PrimitiveFuture} for a {@code short}
     */
    interface ToShort extends PrimitiveFuture<java.lang.Short> {
        /**
         * The {@code short} variant of {@link #get(long, TimeUnit)}
         * @param timeout the max time to wait
         * @param unit the time unit of the {@code timeout} argument
         * @return the computed {@code short}
         * @throws CancellationException if the computation was cancelled
         * @throws InterruptedException if the current thread was interrupted while waiting
         * @throws ExecutionException if the computation threw an exception
         * @throws TimeoutException if the wait timed out
         * @see Future#get(long, TimeUnit)
         * @apiNote This is the {@code short} specialisation of {@link #get(long, TimeUnit)}
         * and should be preferred
         */
        short getShort(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException;
        /**
         * The {@code short} specialisation for {@link #get()}
         * @return the computed {@code short}
         * @throws CancellationException if the computation was cancelled
         * @throws InterruptedException if the current thread was interrupted while waiting
         * @throws ExecutionException if the computation threw
         * @see Future#get()
         * @apiNote This is the {@code short} specialisation of {@link #get()} and should
         * be preferred
         */
        short getShort() throws InterruptedException, ExecutionException;
        /**
         * {@inheritDoc}
         * @param timeout {@inheritDoc}
         * @param unit {@inheritDoc}
         * @return {@inheritDoc}
         * @throws CancellationException {@inheritDoc}
         * @throws InterruptedException {@inheritDoc}
         * @throws ExecutionException {@inheritDoc}
         * @throws TimeoutException {@inheritDoc}
         * @implNote The default implementation returns the value of {@link #getShort(long, TimeUnit)}
         */
        @Override default java.lang.Short get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException { return getShort(timeout, unit); }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         * @throws CancellationException {@inheritDoc}
         * @throws InterruptedException {@inheritDoc}
         * @throws ExecutionException {@inheritDoc}
         * @implNote The default implementation returns {@link #getShort()}
         */
        @Override default java.lang.Short get() throws InterruptedException, ExecutionException { return getShort(); }
        /**
         * The {@code short} specialisation for {@link #resultNow()}
         * @return the computed {@code short}
         * @throws IllegalStateException If the task has not completed or did not complete with
         * a result
         * @see Future#resultNow()
         * @apiNote This should be preferred over {@link #resultNow()} as not conversion is done here
         */
        default short resultNowShort() {
            if (!isDone())
                throw new IllegalStateException("Task has not completed");
            boolean interrupted = false;
            try {
                while (true) {
                    try {
                        return getShort();
                    } catch (InterruptedException e) {
                        interrupted = true;
                    } catch (ExecutionException e) {
                        throw new IllegalStateException("Task completed with exception");
                    } catch (CancellationException e) {
                        throw new IllegalStateException("Task was cancelled");
                    }
                }
            } finally {
                if (interrupted) Thread.currentThread().interrupt();
            }
        }
        /**
         * Returns the exception thrown by the task without waiting.
         * @return the exception thrown by the task
         * @throws IllegalStateException is the task has not completed,
         * the task completed or was cancelled
         * @implNote The default implementation overrides the default
         * implementation defined in {@link Future#exceptionNow()} to
         * support the method specialisation {@link #getShort()}
         */
        @Override default Throwable exceptionNow() {
            if (!isDone())
                throw new IllegalStateException("Task has not completed");
            if (isCancelled())
                throw new IllegalStateException("Task was cancelled");
            boolean interrupted = false;
            try {
                while (true) {
                    try {
                        getShort();
                        throw new IllegalStateException("Task completed with a result");
                    } catch (InterruptedException e) {
                        interrupted = true;
                    } catch (ExecutionException e) {
                        return e.getCause();
                    }
                }
            } finally {
                if (interrupted) Thread.currentThread().interrupt();
            }
        }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote This is overridden to allow for the specialised
         * {@link #getShort()} to be used instead of {@link #get()}
         */
        @Override default Future.State state() {
        if (!isDone())
            return State.RUNNING;
        if (isCancelled())
            return State.CANCELLED;
        boolean interrupted = false;
        try {
            while (true) {
                try {
                    getShort();
                    return State.SUCCESS;
                } catch (InterruptedException e) {
                    interrupted = true;
                } catch (ExecutionException e) {
                    return State.FAILED;
                }
            }
        } finally {
            if (interrupted) Thread.currentThread().interrupt();
        }
        }
    }
    /**
     * A {@code PrimitiveFuture} for a {@code byte}
     */
    interface ToByte extends PrimitiveFuture<java.lang.Byte> {
        /**
         * The {@code byte} variant of {@link #get(long, TimeUnit)}
         * @param timeout the max time to wait
         * @param unit the time unit of the {@code timeout} argument
         * @return the computed {@code byte}
         * @throws CancellationException if the computation was cancelled
         * @throws InterruptedException if the current thread was interrupted while waiting
         * @throws ExecutionException if the computation threw an exception
         * @throws TimeoutException if the wait timed out
         * @see Future#get(long, TimeUnit)
         * @apiNote This is the {@code byte} specialisation of {@link #get(long, TimeUnit)}
         * and should be preferred
         */
        byte getByte(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException;
        /**
         * The {@code byte} specialisation for {@link #get()}
         * @return the computed {@code byte}
         * @throws CancellationException if the computation was cancelled
         * @throws InterruptedException if the current thread was interrupted while waiting
         * @throws ExecutionException if the computation threw
         * @see Future#get()
         * @apiNote This is the {@code byte} specialisation of {@link #get()} and should
         * be preferred
         */
        byte getByte() throws InterruptedException, ExecutionException;
        /**
         * {@inheritDoc}
         * @param timeout {@inheritDoc}
         * @param unit {@inheritDoc}
         * @return {@inheritDoc}
         * @throws CancellationException {@inheritDoc}
         * @throws InterruptedException {@inheritDoc}
         * @throws ExecutionException {@inheritDoc}
         * @throws TimeoutException {@inheritDoc}
         * @implNote The default implementation returns the value of {@link #getByte(long, TimeUnit)}
         */
        @Override default java.lang.Byte get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException { return getByte(timeout, unit); }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         * @throws CancellationException {@inheritDoc}
         * @throws InterruptedException {@inheritDoc}
         * @throws ExecutionException {@inheritDoc}
         * @implNote The default implementation returns {@link #getByte()}
         */
        @Override default java.lang.Byte get() throws InterruptedException, ExecutionException { return getByte(); }
        /**
         * The {@code byte} specialisation for {@link #resultNow()}
         * @return the computed {@code byte}
         * @throws IllegalStateException If the task has not completed or did not complete with
         * a result
         * @see Future#resultNow()
         * @apiNote This should be preferred over {@link #resultNow()} as not conversion is done here
         */
        default byte resultNowByte() {
            if (!isDone())
                throw new IllegalStateException("Task has not completed");
            boolean interrupted = false;
            try {
                while (true) {
                    try {
                        return getByte();
                    } catch (InterruptedException e) {
                        interrupted = true;
                    } catch (ExecutionException e) {
                        throw new IllegalStateException("Task completed with exception");
                    } catch (CancellationException e) {
                        throw new IllegalStateException("Task was cancelled");
                    }
                }
            } finally {
                if (interrupted) Thread.currentThread().interrupt();
            }
        }
        /**
         * Returns the exception thrown by the task without waiting.
         * @return the exception thrown by the task
         * @throws IllegalStateException is the task has not completed,
         * the task completed or was cancelled
         * @implNote The default implementation overrides the default
         * implementation defined in {@link Future#exceptionNow()} to
         * support the method specialisation {@link #getByte()}
         */
        @Override default Throwable exceptionNow() {
            if (!isDone())
                throw new IllegalStateException("Task has not completed");
            if (isCancelled())
                throw new IllegalStateException("Task was cancelled");
            boolean interrupted = false;
            try {
                while (true) {
                    try {
                        getByte();
                        throw new IllegalStateException("Task completed with a result");
                    } catch (InterruptedException e) {
                        interrupted = true;
                    } catch (ExecutionException e) {
                        return e.getCause();
                    }
                }
            } finally {
                if (interrupted) Thread.currentThread().interrupt();
            }
        }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote This is overridden to allow for the specialised
         * {@link #getByte()} to be used instead of {@link #get()}
         */
        @Override default Future.State state() {
        if (!isDone())
            return State.RUNNING;
        if (isCancelled())
            return State.CANCELLED;
        boolean interrupted = false;
        try {
            while (true) {
                try {
                    getByte();
                    return State.SUCCESS;
                } catch (InterruptedException e) {
                    interrupted = true;
                } catch (ExecutionException e) {
                    return State.FAILED;
                }
            }
        } finally {
            if (interrupted) Thread.currentThread().interrupt();
        }
        }
    }
    /**
     * A {@code PrimitiveFuture} for a {@code boolean}
     */
    interface ToBoolean extends PrimitiveFuture<java.lang.Boolean> {
        /**
         * The {@code boolean} variant of {@link #get(long, TimeUnit)}
         * @param timeout the max time to wait
         * @param unit the time unit of the {@code timeout} argument
         * @return the computed {@code boolean}
         * @throws CancellationException if the computation was cancelled
         * @throws InterruptedException if the current thread was interrupted while waiting
         * @throws ExecutionException if the computation threw an exception
         * @throws TimeoutException if the wait timed out
         * @see Future#get(long, TimeUnit)
         * @apiNote This is the {@code boolean} specialisation of {@link #get(long, TimeUnit)}
         * and should be preferred
         */
        boolean getBoolean(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException;
        /**
         * The {@code boolean} specialisation for {@link #get()}
         * @return the computed {@code boolean}
         * @throws CancellationException if the computation was cancelled
         * @throws InterruptedException if the current thread was interrupted while waiting
         * @throws ExecutionException if the computation threw
         * @see Future#get()
         * @apiNote This is the {@code boolean} specialisation of {@link #get()} and should
         * be preferred
         */
        boolean getBoolean() throws InterruptedException, ExecutionException;
        /**
         * {@inheritDoc}
         * @param timeout {@inheritDoc}
         * @param unit {@inheritDoc}
         * @return {@inheritDoc}
         * @throws CancellationException {@inheritDoc}
         * @throws InterruptedException {@inheritDoc}
         * @throws ExecutionException {@inheritDoc}
         * @throws TimeoutException {@inheritDoc}
         * @implNote The default implementation returns the value of {@link #getBoolean(long, TimeUnit)}
         */
        @Override default java.lang.Boolean get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException { return getBoolean(timeout, unit); }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         * @throws CancellationException {@inheritDoc}
         * @throws InterruptedException {@inheritDoc}
         * @throws ExecutionException {@inheritDoc}
         * @implNote The default implementation returns {@link #getBoolean()}
         */
        @Override default java.lang.Boolean get() throws InterruptedException, ExecutionException { return getBoolean(); }
        /**
         * The {@code boolean} specialisation for {@link #resultNow()}
         * @return the computed {@code boolean}
         * @throws IllegalStateException If the task has not completed or did not complete with
         * a result
         * @see Future#resultNow()
         * @apiNote This should be preferred over {@link #resultNow()} as not conversion is done here
         */
        default boolean resultNowBoolean() {
            if (!isDone())
                throw new IllegalStateException("Task has not completed");
            boolean interrupted = false;
            try {
                while (true) {
                    try {
                        return getBoolean();
                    } catch (InterruptedException e) {
                        interrupted = true;
                    } catch (ExecutionException e) {
                        throw new IllegalStateException("Task completed with exception");
                    } catch (CancellationException e) {
                        throw new IllegalStateException("Task was cancelled");
                    }
                }
            } finally {
                if (interrupted) Thread.currentThread().interrupt();
            }
        }
        /**
         * Returns the exception thrown by the task without waiting.
         * @return the exception thrown by the task
         * @throws IllegalStateException is the task has not completed,
         * the task completed or was cancelled
         * @implNote The default implementation overrides the default
         * implementation defined in {@link Future#exceptionNow()} to
         * support the method specialisation {@link #getBoolean()}
         */
        @Override default Throwable exceptionNow() {
            if (!isDone())
                throw new IllegalStateException("Task has not completed");
            if (isCancelled())
                throw new IllegalStateException("Task was cancelled");
            boolean interrupted = false;
            try {
                while (true) {
                    try {
                        getBoolean();
                        throw new IllegalStateException("Task completed with a result");
                    } catch (InterruptedException e) {
                        interrupted = true;
                    } catch (ExecutionException e) {
                        return e.getCause();
                    }
                }
            } finally {
                if (interrupted) Thread.currentThread().interrupt();
            }
        }
        /**
         * {@inheritDoc}
         * @return {@inheritDoc}
         * @implNote This is overridden to allow for the specialised
         * {@link #getBoolean()} to be used instead of {@link #get()}
         */
        @Override default Future.State state() {
        if (!isDone())
            return State.RUNNING;
        if (isCancelled())
            return State.CANCELLED;
        boolean interrupted = false;
        try {
            while (true) {
                try {
                    getBoolean();
                    return State.SUCCESS;
                } catch (InterruptedException e) {
                    interrupted = true;
                } catch (ExecutionException e) {
                    return State.FAILED;
                }
            }
        } finally {
            if (interrupted) Thread.currentThread().interrupt();
        }
        }
    }
}
