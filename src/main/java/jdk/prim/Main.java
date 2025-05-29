package jdk.prim;

import java.util.Arrays;
import java.util.SplittableRandom;
import java.util.concurrent.ForkJoinPool;
import java.util.random.RandomGenerator;

import jdk.prim.util.PrimitiveArrays;
import jdk.prim.util.PrimitiveComparator;
import jdk.prim.util.map.PrimitiveEntry;
import jdk.prim.util.sort.PrimitiveBasicQuickSort;
import jdk.prim.util.sort.PrimitiveDualPivot;
import jdk.prim.util.sort.PrimitiveNaiveQuickSort;

/**
 * Hello world!
 *
 */
public class Main 
{

    private static final void initDoubleArray(RandomGenerator r, int index) {
        double doubleVal = r.nextDouble(Double.MIN_NORMAL, Double.MAX_VALUE);
        boolean isNegative = r.nextBoolean();
        DOUBLE[index] = doubleVal * (isNegative ? -1 : 1);
    }
    

    private static final void initLongArray(RandomGenerator r, int index) {
        long longVal = r.nextLong(0, 128);
        LONG[index] = longVal;
    }
    

    private static final void initIntArray(RandomGenerator r, int index) {
        int intVal = r.nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
        INT[index] = intVal;
    }
    

    private static final void initFloatArray(RandomGenerator r, int index) {
        float floatVal = r.nextFloat(Float.MIN_VALUE, Float.MAX_VALUE);
        boolean isNegative = r.nextBoolean();
        FLOAT[index] = floatVal * (isNegative ? -1 : 1);
    }
    

    private static final void initCharArray(RandomGenerator r, int index) {
        char charVal = Character.valueOf((char) r.nextInt(0x21, 0x7E));
        CHAR[index] = charVal;
    }
    

    private static final void initShortArray(RandomGenerator r, int index) {
        short shortVal = (short) r.nextInt(Short.MIN_VALUE, Short.MAX_VALUE);
        SHORT[index] = shortVal;
    }
    

    private static final void initByteArray(RandomGenerator r, int index) {
        byte byteVal = (byte) r.nextInt(Byte.MIN_VALUE, Byte.MAX_VALUE);
        BYTE[index] = byteVal;
    }
    

    private static final void initBooleanArray(RandomGenerator r, int index) {
        boolean booleanVal = r.nextBoolean();
        BOOLEAN[index] = booleanVal;
    }

    /**Length of the array*/
    static final int LENGTH;

    static final double[] DOUBLE;
    static final long[] LONG;
    static final int[] INT;
    static final float[] FLOAT;
    static final char[] CHAR;
    static final short[] SHORT;
    static final byte[] BYTE;
    static final boolean[] BOOLEAN;
    // static final Logger LOGGER = Logger.getAnonymousLogger();

    static {
        RandomGenerator random = new SplittableRandom();
        LENGTH = random.nextInt(0, 32);
        DOUBLE = new double[LENGTH];
        LONG = new long[LENGTH];
        INT = new int[LENGTH];
        FLOAT = new float[LENGTH];
        CHAR = new char[LENGTH];
        SHORT = new short[LENGTH];
        BYTE = new byte[LENGTH];
        BOOLEAN = new boolean[LENGTH];
        for (int i = 0; i < LENGTH; i++) {
            initDoubleArray(random, i);            
            initLongArray(random, i);
            initIntArray(random, i);
            initFloatArray(random, i);
            initCharArray(random, i);
            initShortArray(random, i);
            initByteArray(random, i);
            initBooleanArray(random, i);
        }
    }

    public static PrimitiveEntry.OfChar.AndBoolean c() {
        return null;
    }
	
    public static void main( String[] args ) {
        var d = Arrays.toString(BOOLEAN);
        System.err.println(d);

        var sorted = new boolean[BOOLEAN.length];
        PrimitiveDualPivot.ofBoolean(ForkJoinPool.getCommonPoolParallelism()).sort(BOOLEAN, sorted);

        d = Arrays.toString(sorted);
        System.err.println(d);

        var c = c();
        var k = c.getKeyChar();
        var c2 = c.mapToDoubleKey(x -> x);
        var k2 = c2.getKeyDouble();
    }
}
