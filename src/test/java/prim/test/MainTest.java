package prim.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import java.util.random.RandomGenerator;
import java.util.SplittableRandom;
import java.util.logging.Logger;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import jdk.prim.util.sort.PrimitiveBasicQuickSort;
import jdk.prim.util.sort.PrimitiveNaiveQuickSort;

// import jdk.prim.Main;

@DisplayName("Generic test for static methods")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MainTest {

    // private final Main m = new Main();

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
    static final Logger LOGGER = Logger.getAnonymousLogger();

    static {
        RandomGenerator random = new SplittableRandom();
        LENGTH = random.nextInt(32, 128);
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

    

    private static final void initDoubleArray(RandomGenerator r, int index) {
        double doubleVal = r.nextDouble(Double.MIN_NORMAL, Double.MAX_VALUE);
        boolean isNegative = r.nextBoolean();
        DOUBLE[index] = doubleVal * (isNegative ? -1 : 1);
    }
    

    private static final void initLongArray(RandomGenerator r, int index) {
        long longVal = r.nextLong(Long.MIN_VALUE, Long.MAX_VALUE);
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

    @Test
    @Order(0)
    @DisplayName("Naive quick sort for double arrays")
    void naiveDoubleQuickSort() {
        LOGGER.info("Starting naive quick for doubles");
        final double[] expected = new double[DOUBLE.length];
        System.arraycopy(DOUBLE, 0, expected, 0, DOUBLE.length);
        Arrays.sort(expected);
        PrimitiveNaiveQuickSort.ofDouble(true).sort(DOUBLE, Double::compare, null);
        assertArrayEquals(expected, DOUBLE);
    }
    @Test
    @Order(1)
    @DisplayName("Naive quick sort for long arrays")
    void naiveLongQuickSort() {
        LOGGER.info("Starting naive quick for longs");
        final long[] expected = new long[LONG.length];
        System.arraycopy(LONG, 0, expected, 0, LONG.length);
        Arrays.sort(expected);
        PrimitiveNaiveQuickSort.ofLong(true).sort(LONG, Long::compare, null);
        assertArrayEquals(expected, LONG);
    }
    @Test
    @Order(2)
    @DisplayName("Naive quick sort for int arrays")
    void naiveIntQuickSort() {
        LOGGER.info("Starting naive quick for ints");
        final int[] expected = new int[INT.length];
        System.arraycopy(INT, 0, expected, 0, INT.length);
        Arrays.sort(expected);
        PrimitiveNaiveQuickSort.ofInt(true).sort(INT, Integer::compare, null);
        assertArrayEquals(expected, INT);
    }
    @Test
    @Order(3)
    @DisplayName("Naive quick sort for float arrays")
    void naiveFloatQuickSort() {
        LOGGER.info("Starting naive quick for floats");
        final float[] expected = new float[FLOAT.length];
        System.arraycopy(FLOAT, 0, expected, 0, FLOAT.length);
        Arrays.sort(expected);
        PrimitiveNaiveQuickSort.ofFloat(true).sort(FLOAT, Float::compare, null);
        assertArrayEquals(expected, FLOAT);
    }
    @Test
    @Order(4)
    @DisplayName("Naive quick sort for char arrays")
    void naiveCharQuickSort() {
        LOGGER.info("Starting naive quick for chars");
        final char[] expected = new char[CHAR.length];
        System.arraycopy(CHAR, 0, expected, 0, CHAR.length);
        Arrays.sort(expected);
        PrimitiveNaiveQuickSort.ofChar(true).sort(CHAR, Character::compare, null);
        assertArrayEquals(expected, CHAR);
    }
    @Test
    @Order(5)
    @DisplayName("Naive quick sort for short arrays")
    void naiveShortQuickSort() {
        LOGGER.info("Starting naive quick for shorts");
        final short[] expected = new short[SHORT.length];
        System.arraycopy(SHORT, 0, expected, 0, SHORT.length);
        Arrays.sort(expected);
        PrimitiveNaiveQuickSort.ofShort(true).sort(SHORT, Short::compare, null);
        assertArrayEquals(expected, SHORT);
    }
    @Test
    @Order(6)
    @DisplayName("Naive quick sort for byte arrays")
    void naiveByteQuickSort() {
        LOGGER.info("Starting naive quick for bytes");
        final byte[] expected = new byte[BYTE.length];
        System.arraycopy(BYTE, 0, expected, 0, BYTE.length);
        Arrays.sort(expected);
        PrimitiveNaiveQuickSort.ofByte(true).sort(BYTE, Byte::compare, null);
        assertArrayEquals(expected, BYTE);
    }
    @Test
    @Order(7)
    @DisplayName("Naive quick sort for boolean arrays")
    void naiveBooleanQuickSort() {
        LOGGER.info("Starting naive quick for booleans");
        final boolean[] expected = new boolean[BOOLEAN.length];
        System.arraycopy(BOOLEAN, 0, expected, 0, BOOLEAN.length);
        PrimitiveNaiveQuickSort.ofBoolean(true).sort(BOOLEAN, Boolean::compare, null);
        assertArrayEquals(expected, BOOLEAN);
    }

    @Test
    @Order(8)
    @DisplayName("Basic quick sort for double arrays")
    void basicDoubleQuickSort() {
        System.out.println("0");
        LOGGER.info("Starting basic quick sort for doubles");
        System.out.println("1");
        final double[] expected = new double[DOUBLE.length];
        System.out.println("2");
        System.arraycopy(DOUBLE, 0, expected, 0, DOUBLE.length);
        System.out.println("3");
        Arrays.sort(expected);
        System.out.println("4");
        PrimitiveBasicQuickSort.ofDouble().sort(DOUBLE, Double::compare, null);
        System.out.println("5");
        assertArrayEquals(expected, DOUBLE);
        System.out.println("6");
    }
    @Test
    @Order(9)
    @DisplayName("Basic quick sort for long arrays")
    void basicLongQuickSort() {
        LOGGER.info("Starting basic quick sort for longs");
        final long[] expected = new long[LONG.length];
        System.arraycopy(LONG, 0, expected, 0, LONG.length);
        Arrays.sort(expected);
        PrimitiveBasicQuickSort.ofLong().sort(LONG, Long::compare, null);
        assertArrayEquals(expected, LONG);
    }
    @Test
    @Order(10)
    @DisplayName("Basic quick sort for int arrays")
    void basicIntQuickSort() {
        LOGGER.info("Starting basic quick sort for ints");
        final int[] expected = new int[INT.length];
        System.arraycopy(INT, 0, expected, 0, INT.length);
        Arrays.sort(expected);
        PrimitiveBasicQuickSort.ofInt().sort(INT, Integer::compare, null);
        assertArrayEquals(expected, INT);
    }
    @Test
    @Order(11)
    @DisplayName("Basic quick sort for float arrays")
    void basicFloatQuickSort() {
        LOGGER.info("Starting basic quick sort for floats");
        final float[] expected = new float[FLOAT.length];
        System.arraycopy(FLOAT, 0, expected, 0, FLOAT.length);
        Arrays.sort(expected);
        PrimitiveBasicQuickSort.ofFloat().sort(FLOAT, Float::compare, null);
        assertArrayEquals(expected, FLOAT);
    }
    @Test
    @Order(12)
    @DisplayName("Basic quick sort for char arrays")
    void basicCharQuickSort() {
        LOGGER.info("Starting basic quick sort for chars");
        final char[] expected = new char[CHAR.length];
        System.arraycopy(CHAR, 0, expected, 0, CHAR.length);
        Arrays.sort(expected);
        PrimitiveBasicQuickSort.ofChar().sort(CHAR, Character::compare, null);
        assertArrayEquals(expected, CHAR);
    }
    @Test
    @Order(13)
    @DisplayName("Basic quick sort for short arrays")
    void basicShortQuickSort() {
        LOGGER.info("Starting basic quick sort for shorts");
        final short[] expected = new short[SHORT.length];
        System.arraycopy(SHORT, 0, expected, 0, SHORT.length);
        Arrays.sort(expected);
        PrimitiveBasicQuickSort.ofShort().sort(SHORT, Short::compare, null);
        assertArrayEquals(expected, SHORT);
    }
    @Test
    @Order(14)
    @DisplayName("Basic quick sort for byte arrays")
    void basicByteQuickSort() {
        LOGGER.info("Starting basic quick sort for bytes");
        final byte[] expected = new byte[BYTE.length];
        System.arraycopy(BYTE, 0, expected, 0, BYTE.length);
        Arrays.sort(expected);
        PrimitiveBasicQuickSort.ofByte().sort(BYTE, Byte::compare, null);
        assertArrayEquals(expected, BYTE);
    }
    @Test
    @Order(15)
    @DisplayName("Basic quick sort for boolean arrays")
    void basicBooleanQuickSort() {
        LOGGER.info("Starting basic quick sort for booleans");
        final boolean[] expected = new boolean[BOOLEAN.length];
        System.arraycopy(BOOLEAN, 0, expected, 0, BOOLEAN.length);
        PrimitiveBasicQuickSort.ofBoolean().sort(BOOLEAN, Boolean::compare, null);
        assertArrayEquals(expected, BOOLEAN);
    }

}
