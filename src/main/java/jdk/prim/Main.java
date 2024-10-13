package jdk.prim;

import java.util.Arrays;
import java.util.SplittableRandom;
import java.util.random.RandomGenerator;

import jdk.prim.util.PrimitiveArrays;
import jdk.prim.util.PrimitiveComparator;
import jdk.prim.util.sort.PrimitiveBasicQuickSort;

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
        LENGTH = random.nextInt(5, 12);
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
	
    public static void main( String[] args )
    {
        var d = Arrays.toString(LONG);
        System.err.println(d);

        sort(LONG, Long::compare, null);

        d = Arrays.toString(LONG);
        System.err.println(d);
    }

    static void sort(long[] src, PrimitiveComparator.OfLong c, long[] dst){
        if(dst == null) dst = src;
        else if(dst.length != src.length) {
            dst = new long[src.length];
            System.arraycopy(src, 0, dst, 0, src.length);
        }

        applySort(dst, c, 0, dst.length - 1);
    }

    static void applySort(long[] a, PrimitiveComparator.OfLong c, int l, int h) {
        if(l>=h) return;
        int partionIndex = partition(a, c, l, h);

        applySort(a, c, l, partionIndex - 1);
        applySort(a, c, partionIndex + 1, h);
    }

    static int partition(long[] a, PrimitiveComparator.OfLong c, int l, int h) {
        final int pivotIndex = (l + h) / 2;

        int leftIndex = l;
        int rightIndex = h;

        while(true) {
            /* 
            scan from the left of pivot index until we find a
            value >= pivot. WHen the scan gets to the pivot index,
            then we must stop
            */
            while(c.compareLong(a[leftIndex], a[pivotIndex]) <= 0 && leftIndex < pivotIndex) {
                leftIndex++;
            }
            //scan from the right of the pivot
            while(c.compareLong(a[rightIndex], a[pivotIndex]) >= 0 && rightIndex > pivotIndex) {
                rightIndex--;
            }

            if(c.compareLong(a[leftIndex], a[pivotIndex]) > 0 && c.compareLong(a[pivotIndex], a[rightIndex]) < 0) PrimitiveArrays.swap(a, leftIndex, rightIndex);
            else if(c.compareLong(a[leftIndex], a[pivotIndex]) > 0) PrimitiveArrays.swap(a, leftIndex, pivotIndex);
            else if(c.compareLong(a[rightIndex], a[pivotIndex]) < 0) PrimitiveArrays.swap(a, pivotIndex, rightIndex);
            else break;
        }


        return pivotIndex;
    }
}
