package jdk.prim.util.concurrent.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import jdk.prim.util.concurrent.PrimitiveCompletionStage;
import jdk.prim.util.concurrent.PrimitiveFuture;
import jdk.prim.util.function.PrimitiveBiConsumer;
import jdk.prim.util.function.PrimitiveConsumer;
import jdk.prim.util.function.PrimitiveBiFunction;
import jdk.prim.util.function.PrimitiveFunction;

public class OfShort extends CompletableFuture<java.lang.Short> implements PrimitiveCompletionStage.OfShort, PrimitiveFuture.ToShort {}
