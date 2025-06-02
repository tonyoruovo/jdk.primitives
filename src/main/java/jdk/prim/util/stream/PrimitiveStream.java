package jdk.prim.util.stream;

import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.LongSummaryStatistics;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.function.BiConsumer;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongToIntFunction;
import java.util.function.LongUnaryOperator;
import java.util.function.Supplier;
import java.util.stream.BaseStream;
import java.util.stream.DoubleStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.stream.IntStream;

import jdk.prim.util.OptionalFloat;
import jdk.prim.util.OptionalChar;
import jdk.prim.util.OptionalShort;
import jdk.prim.util.OptionalByte;
import jdk.prim.util.FloatSummaryStatistics;
import jdk.prim.util.CharSummaryStatistics;
import jdk.prim.util.ShortSummaryStatistics;
import jdk.prim.util.ByteSummaryStatistics;
import jdk.prim.util.BooleanSummaryStatistics;
import jdk.prim.util.OptionalBoolean;
import jdk.prim.util.function.PrimitiveBiConsumer;
import jdk.prim.util.function.PrimitiveBiFunction;
import jdk.prim.util.function.PrimitiveConsumer;
import jdk.prim.util.function.PrimitiveFunction;
import jdk.prim.util.function.PrimitivePredicate;

/**
 * @see java.util.stream.Streams
 * @see java.util.stream.StreamSupport
 * @see java.util.stream.IntPipeline
 * @see java.util.stream.AbstractPipeline
 * @see java.util.stream.PipelineHelper
 * @see java.util.stream.Sink
 * @see java.util.stream.Node
 * @see java.util.stream.Node.Builder
 */
public interface PrimitiveStream<
T,
DoubleMapper extends PrimitiveFunction.ToDouble<T>,
LongMapper extends PrimitiveFunction.ToLong<T>,
IntMapper extends PrimitiveFunction.ToInt<T>,
FloatMapper extends PrimitiveFunction.ToFloat<T>,
CharMapper extends PrimitiveFunction.ToChar<T>,
ShortMapper extends PrimitiveFunction.ToShort<T>,
ByteMapper extends PrimitiveFunction.ToByte<T>,
BooleanMapper extends PrimitiveFunction.ToBoolean<T>
> {
    interface OfDouble extends PrimitiveStream<java.lang.Double, PrimitiveFunction.ToDouble.OfDouble, PrimitiveFunction.ToLong.OfDouble, PrimitiveFunction.ToInt.OfDouble, PrimitiveFunction.ToFloat.OfDouble, PrimitiveFunction.ToChar.OfDouble, PrimitiveFunction.ToShort.OfDouble, PrimitiveFunction.ToByte.OfDouble, PrimitiveFunction.ToBoolean.OfDouble>, DoubleStream {
        boolean allMatchDouble(PrimitivePredicate.OfDouble predicate);
        boolean anyMatchDouble(PrimitivePredicate.OfDouble predicate);
        OptionalDouble average();
        Stream<java.lang.Double> boxed();
        <R> R collectDouble(Supplier<? extends R> supplier, PrimitiveBiConsumer.AndDouble<? super R> accumulator, BiConsumer<? super R, ? super R> combiner);
        long count();
        OfDouble distinct();
        OfDouble filterDouble(PrimitivePredicate.OfDouble predicate);
        OptionalDouble findAny();
        OptionalDouble findFirst();
        OfDouble flatMapDouble(PrimitiveFunction.OfDouble<? extends OfDouble> mapper);
        void forEachDouble(PrimitiveConsumer.OfDouble action);
        void forEachOrderedDouble(PrimitiveConsumer.OfDouble action);
        OfDouble limit(long maxSize);
        <U> Stream<U> mapObj(PrimitiveFunction.OfDouble<U> mapper);
        OptionalDouble max();
        OptionalDouble min();
        boolean noneMatchDouble(PrimitivePredicate.OfDouble action);
        OfDouble peekDouble(PrimitiveConsumer.OfDouble action);
        double reduceDouble(double identity, PrimitiveBiFunction.ToDouble.OfDouble.AndDouble op);
        OptionalDouble reduceDouble(PrimitiveBiFunction.ToDouble.OfDouble.AndDouble op);
        OfDouble skip(long n);
        OfDouble sorted();
        double sum();
        DoubleSummaryStatistics summaryStatistics();
        OfDouble takeWhileDouble(PrimitivePredicate.OfDouble predicate);
        double[] toArray();
        @Override
        OfDouble map(DoubleUnaryOperator mapper);
        @Override
        OfLong mapToLong(DoubleToLongFunction mapper);
        @Override
        OfInt mapToInt(DoubleToIntFunction mapper);
        @Override
        default OfDouble mapDouble(PrimitiveFunction.ToDouble.OfDouble mapper) {
            return map(mapper);
        }
        @Override
        default OfLong mapLong(PrimitiveFunction.ToLong.OfDouble mapper) {
            return mapToLong((DoubleToLongFunction) mapper);
        }
        @Override
        default OfInt mapInt(PrimitiveFunction.ToInt.OfDouble mapper) {
            return mapToInt((DoubleToIntFunction) mapper);
        }
    }
    interface OfLong extends PrimitiveStream<java.lang.Long, PrimitiveFunction.ToDouble.OfLong, PrimitiveFunction.ToLong.OfLong, PrimitiveFunction.ToInt.OfLong, PrimitiveFunction.ToFloat.OfLong, PrimitiveFunction.ToChar.OfLong, PrimitiveFunction.ToShort.OfLong, PrimitiveFunction.ToByte.OfLong, PrimitiveFunction.ToBoolean.OfLong>, LongStream {
        boolean allMatchLong(PrimitivePredicate.OfLong predicate);
        boolean anyMatchLong(PrimitivePredicate.OfLong predicate);
        OptionalDouble average();
        Stream<java.lang.Long> boxed();
        <R> R collectLong(Supplier<? extends R> supplier, PrimitiveBiConsumer.AndLong<? super R> accumulator, BiConsumer<? super R, ? super R> combiner);
        long count();
        OfLong distinct();
        OfLong filterLong(PrimitivePredicate.OfLong predicate);
        OptionalLong findAny();
        OptionalLong findFirst();
        OfLong flatMapLong(PrimitiveFunction.OfLong<? extends OfLong> mapper);
        void forEachLong(PrimitiveConsumer.OfLong action);
        void forEachOrderedLong(PrimitiveConsumer.OfLong action);
        OfLong limit(long maxSize);
        <U> Stream<U> mapObj(PrimitiveFunction.OfLong<U> mapper);
        OptionalLong max();
        OptionalLong min();
        boolean noneMatchLong(PrimitivePredicate.OfLong action);
        OfLong peekLong(PrimitiveConsumer.OfLong action);
        long reduceLong(long identity, PrimitiveBiFunction.ToLong.OfLong.AndLong op);
        OptionalLong reduceLong(PrimitiveBiFunction.ToLong.OfLong.AndLong op);
        OfLong skip(long n);
        OfLong sorted();
        long sum();
        LongSummaryStatistics summaryStatistics();
        OfLong takeWhileLong(PrimitivePredicate.OfLong predicate);
        long[] toArray();
        @Override
        OfLong map(LongUnaryOperator mapper);
        @Override
        OfDouble mapToDouble(LongToDoubleFunction mapper);
        @Override
        OfInt mapToInt(LongToIntFunction mapper);
        @Override
        default OfDouble mapDouble(PrimitiveFunction.ToDouble.OfLong mapper) {
            return mapToDouble((LongToDoubleFunction) mapper);
        }
        @Override
        default OfLong mapLong(PrimitiveFunction.ToLong.OfLong mapper) {
            return map(mapper);
        }
        @Override
        default OfInt mapInt(PrimitiveFunction.ToInt.OfLong mapper) {
            return mapToInt((LongToIntFunction) mapper);
        }
    }
    interface OfInt extends PrimitiveStream<java.lang.Integer, PrimitiveFunction.ToDouble.OfInt, PrimitiveFunction.ToLong.OfInt, PrimitiveFunction.ToInt.OfInt, PrimitiveFunction.ToFloat.OfInt, PrimitiveFunction.ToChar.OfInt, PrimitiveFunction.ToShort.OfInt, PrimitiveFunction.ToByte.OfInt, PrimitiveFunction.ToBoolean.OfInt>, IntStream {
        boolean allMatchInt(PrimitivePredicate.OfInt predicate);
        boolean anyMatchInt(PrimitivePredicate.OfInt predicate);
        OptionalDouble average();
        Stream<java.lang.Integer> boxed();
        <R> R collectInt(Supplier<? extends R> supplier, PrimitiveBiConsumer.AndInt<? super R> accumulator, BiConsumer<? super R, ? super R> combiner);
        long count();
        OfInt distinct();
        OfInt filterInt(PrimitivePredicate.OfInt predicate);
        OptionalInt findAny();
        OptionalInt findFirst();
        OfInt flatMapInt(PrimitiveFunction.OfInt<? extends OfInt> mapper);
        void forEachInt(PrimitiveConsumer.OfInt action);
        void forEachOrderedInt(PrimitiveConsumer.OfInt action);
        OfInt limit(long maxSize);
        <U> Stream<U> mapObj(PrimitiveFunction.OfInt<U> mapper);
        OptionalInt max();
        OptionalInt min();
        boolean noneMatchInt(PrimitivePredicate.OfInt action);
        OfInt peekInt(PrimitiveConsumer.OfInt action);
        int reduceInt(int identity, PrimitiveBiFunction.ToInt.OfInt.AndInt op);
        OptionalInt reduceInt(PrimitiveBiFunction.ToInt.OfInt.AndInt op);
        OfInt skip(long n);
        OfInt sorted();
        int sum();
        IntSummaryStatistics summaryStatistics();
        OfInt takeWhileInt(PrimitivePredicate.OfInt predicate);
        int[] toArray();
        @Override
        OfInt map(IntUnaryOperator mapper);
        @Override
        OfDouble mapToDouble(IntToDoubleFunction mapper);
        @Override
        OfLong mapToLong(IntToLongFunction mapper);
        @Override
        default OfDouble mapDouble(PrimitiveFunction.ToDouble.OfInt mapper) {
            return mapToDouble((IntToDoubleFunction) mapper);
        }
        @Override
        default OfLong mapLong(PrimitiveFunction.ToLong.OfInt mapper) {
            return mapToLong(mapper);
        }
        @Override
        default OfInt mapInt(PrimitiveFunction.ToInt.OfInt mapper) {
            return map((IntUnaryOperator) mapper);
        }
    }
    interface OfFloat extends PrimitiveStream<java.lang.Float, PrimitiveFunction.ToDouble.OfFloat, PrimitiveFunction.ToLong.OfFloat, PrimitiveFunction.ToInt.OfFloat, PrimitiveFunction.ToFloat.OfFloat, PrimitiveFunction.ToChar.OfFloat, PrimitiveFunction.ToShort.OfFloat, PrimitiveFunction.ToByte.OfFloat, PrimitiveFunction.ToBoolean.OfFloat>, BaseStream<java.lang.Float, OfFloat> {
        boolean allMatchFloat(PrimitivePredicate.OfFloat predicate);
        boolean anyMatchFloat(PrimitivePredicate.OfFloat predicate);
        OptionalDouble average();
        Stream<java.lang.Float> boxed();
        <R> R collectFloat(Supplier<? extends R> supplier, PrimitiveBiConsumer.AndFloat<? super R> accumulator, BiConsumer<? super R, ? super R> combiner);
        long count();
        OfFloat distinct();
        OfFloat filterFloat(PrimitivePredicate.OfFloat predicate);
        OptionalFloat findAny();
        OptionalFloat findFirst();
        OfFloat flatMapFloat(PrimitiveFunction.OfFloat<? extends OfFloat> mapper);
        void forEachFloat(PrimitiveConsumer.OfFloat action);
        void forEachOrderedFloat(PrimitiveConsumer.OfFloat action);
        OfFloat limit(long maxSize);
        <U> Stream<U> mapObj(PrimitiveFunction.OfFloat<U> mapper);
        OptionalFloat max();
        OptionalFloat min();
        boolean noneMatchFloat(PrimitivePredicate.OfFloat action);
        OfFloat peekFloat(PrimitiveConsumer.OfFloat action);
        float reduceFloat(float identity, PrimitiveBiFunction.ToFloat.OfFloat.AndFloat op);
        OptionalFloat reduceFloat(PrimitiveBiFunction.ToFloat.OfFloat.AndFloat op);
        OfFloat skip(long n);
        OfFloat sorted();
        float sum();
        FloatSummaryStatistics summaryStatistics();
        OfFloat takeWhileFloat(PrimitivePredicate.OfFloat predicate);
        float[] toArray();
    }
    interface OfChar extends PrimitiveStream<java.lang.Character, PrimitiveFunction.ToDouble.OfChar, PrimitiveFunction.ToLong.OfChar, PrimitiveFunction.ToInt.OfChar, PrimitiveFunction.ToFloat.OfChar, PrimitiveFunction.ToChar.OfChar, PrimitiveFunction.ToShort.OfChar, PrimitiveFunction.ToByte.OfChar, PrimitiveFunction.ToBoolean.OfChar>, BaseStream<java.lang.Character, OfChar> {
        boolean allMatchChar(PrimitivePredicate.OfChar predicate);
        boolean anyMatchChar(PrimitivePredicate.OfChar predicate);
        Optional<String> average();
        Stream<java.lang.Character> boxed();
        <R> R collectChar(Supplier<? extends R> supplier, PrimitiveBiConsumer.AndChar<? super R> accumulator, BiConsumer<? super R, ? super R> combiner);
        long count();
        OfChar distinct();
        OfChar filterChar(PrimitivePredicate.OfChar predicate);
        OptionalChar findAny();
        OptionalChar findFirst();
        OfChar flatMapChar(PrimitiveFunction.OfChar<? extends OfChar> mapper);
        void forEachChar(PrimitiveConsumer.OfChar action);
        void forEachOrderedChar(PrimitiveConsumer.OfChar action);
        OfChar limit(long maxSize);
        <U> Stream<U> mapObj(PrimitiveFunction.OfChar<U> mapper);
        OptionalChar max();
        OptionalChar min();
        boolean noneMatchChar(PrimitivePredicate.OfChar action);
        OfChar peekChar(PrimitiveConsumer.OfChar action);
        char reduceChar(char identity, PrimitiveBiFunction.ToChar.OfChar.AndChar op);
        OptionalChar reduceChar(PrimitiveBiFunction.ToChar.OfChar.AndChar op);
        OfChar skip(long n);
        OfChar sorted();
        char sum();
        CharSummaryStatistics summaryStatistics();
        OfChar takeWhileChar(PrimitivePredicate.OfChar predicate);
        char[] toArray();
    }
    interface OfShort extends PrimitiveStream<java.lang.Short, PrimitiveFunction.ToDouble.OfShort, PrimitiveFunction.ToLong.OfShort, PrimitiveFunction.ToInt.OfShort, PrimitiveFunction.ToFloat.OfShort, PrimitiveFunction.ToChar.OfShort, PrimitiveFunction.ToShort.OfShort, PrimitiveFunction.ToByte.OfShort, PrimitiveFunction.ToBoolean.OfShort>, BaseStream<java.lang.Short, OfShort> {
        boolean allMatchShort(PrimitivePredicate.OfShort predicate);
        boolean anyMatchShort(PrimitivePredicate.OfShort predicate);
        OptionalShort average();
        Stream<java.lang.Short> boxed();
        <R> R collectShort(Supplier<? extends R> supplier, PrimitiveBiConsumer.AndShort<? super R> accumulator, BiConsumer<? super R, ? super R> combiner);
        long count();
        OfShort distinct();
        OfShort filterShort(PrimitivePredicate.OfShort predicate);
        OptionalShort findAny();
        OptionalShort findFirst();
        OfShort flatMapShort(PrimitiveFunction.OfShort<? extends OfShort> mapper);
        void forEachShort(PrimitiveConsumer.OfShort action);
        void forEachOrderedShort(PrimitiveConsumer.OfShort action);
        OfShort limit(long maxSize);
        <U> Stream<U> mapObj(PrimitiveFunction.OfShort<U> mapper);
        OptionalShort max();
        OptionalShort min();
        boolean noneMatchShort(PrimitivePredicate.OfShort action);
        OfShort peekShort(PrimitiveConsumer.OfShort action);
        short reduceShort(short identity, PrimitiveBiFunction.ToShort.OfShort.AndShort op);
        OptionalShort reduceShort(PrimitiveBiFunction.ToShort.OfShort.AndShort op);
        OfShort skip(long n);
        OfShort sorted();
        short sum();
        ShortSummaryStatistics summaryStatistics();
        OfShort takeWhileShort(PrimitivePredicate.OfShort predicate);
        short[] toArray();
    }
    interface OfByte extends PrimitiveStream<java.lang.Byte, PrimitiveFunction.ToDouble.OfByte, PrimitiveFunction.ToLong.OfByte, PrimitiveFunction.ToInt.OfByte, PrimitiveFunction.ToFloat.OfByte, PrimitiveFunction.ToChar.OfByte, PrimitiveFunction.ToShort.OfByte, PrimitiveFunction.ToByte.OfByte, PrimitiveFunction.ToBoolean.OfByte>, BaseStream<java.lang.Byte, OfByte> {
        boolean allMatchByte(PrimitivePredicate.OfByte predicate);
        boolean anyMatchByte(PrimitivePredicate.OfByte predicate);
        OptionalByte average();
        Stream<java.lang.Byte> boxed();
        <R> R collectByte(Supplier<? extends R> supplier, PrimitiveBiConsumer.AndByte<? super R> accumulator, BiConsumer<? super R, ? super R> combiner);
        long count();
        OfByte distinct();
        OfByte filterByte(PrimitivePredicate.OfByte predicate);
        OptionalByte findAny();
        OptionalByte findFirst();
        OfByte flatMapByte(PrimitiveFunction.OfByte<? extends OfByte> mapper);
        void forEachByte(PrimitiveConsumer.OfByte action);
        void forEachOrderedByte(PrimitiveConsumer.OfByte action);
        OfByte limit(long maxSize);
        <U> Stream<U> mapObj(PrimitiveFunction.OfByte<U> mapper);
        OptionalByte max();
        OptionalByte min();
        boolean noneMatchByte(PrimitivePredicate.OfByte action);
        OfByte peekByte(PrimitiveConsumer.OfByte action);
        byte reduceByte(byte identity, PrimitiveBiFunction.ToByte.OfByte.AndByte op);
        OptionalByte reduceByte(PrimitiveBiFunction.ToByte.OfByte.AndByte op);
        OfByte skip(long n);
        OfByte sorted();
        byte sum();
        ByteSummaryStatistics summaryStatistics();
        OfByte takeWhileByte(PrimitivePredicate.OfByte predicate);
        byte[] toArray();
    }
    interface OfBoolean extends PrimitiveStream<java.lang.Boolean, PrimitiveFunction.ToDouble.OfBoolean, PrimitiveFunction.ToLong.OfBoolean, PrimitiveFunction.ToInt.OfBoolean, PrimitiveFunction.ToFloat.OfBoolean, PrimitiveFunction.ToChar.OfBoolean, PrimitiveFunction.ToShort.OfBoolean, PrimitiveFunction.ToByte.OfBoolean, PrimitiveFunction.ToBoolean.OfBoolean>, BaseStream<java.lang.Boolean, OfBoolean> {
        boolean allMatchBoolean(PrimitivePredicate.OfBoolean predicate);
        boolean anyMatchBoolean(PrimitivePredicate.OfBoolean predicate);
        OptionalBoolean average();
        Stream<java.lang.Boolean> boxed();
        <R> R collectBoolean(Supplier<? extends R> supplier, PrimitiveBiConsumer.AndBoolean<? super R> accumulator, BiConsumer<? super R, ? super R> combiner);
        long count();
        OfBoolean distinct();
        OfBoolean filterBoolean(PrimitivePredicate.OfBoolean predicate);
        OptionalBoolean findAny();
        OptionalBoolean findFirst();
        OfBoolean flatMapBoolean(PrimitiveFunction.OfBoolean<? extends OfBoolean> mapper);
        void forEachBoolean(PrimitiveConsumer.OfBoolean action);
        void forEachOrderedBoolean(PrimitiveConsumer.OfBoolean action);
        OfBoolean limit(long maxSize);
        <U> Stream<U> mapObj(PrimitiveFunction.OfBoolean<U> mapper);
        OptionalBoolean max();
        OptionalBoolean min();
        boolean noneMatchBoolean(PrimitivePredicate.OfBoolean action);
        OfBoolean peekBoolean(PrimitiveConsumer.OfBoolean action);
        boolean reduceBoolean(boolean identity, PrimitiveBiFunction.ToBoolean.OfBoolean.AndBoolean op);
        OptionalBoolean reduceBoolean(PrimitiveBiFunction.ToBoolean.OfBoolean.AndBoolean op);
        OfBoolean skip(long n);
        OfBoolean sorted();
        boolean sum();
        BooleanSummaryStatistics summaryStatistics();
        OfBoolean takeWhileBoolean(PrimitivePredicate.OfBoolean predicate);
        boolean[] toArray();
    }

    OfDouble mapDouble(DoubleMapper mapper);
    OfLong mapLong(LongMapper mapper);
    OfInt mapInt(IntMapper mapper);
    OfFloat mapFloat(FloatMapper mapper);
    OfChar mapChar(CharMapper mapper);
    OfShort mapShort(ShortMapper mapper);
    OfByte mapByte(ByteMapper mapper);
    OfBoolean mapBoolean(BooleanMapper mapper);
}
