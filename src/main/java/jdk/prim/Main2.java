package jdk.prim;

import jdk.prim.internal.UnsafeAdapter;
import jdk.prim.internal.Utility;

public class Main2 {

    // Calculate offset of the 'length' field in an array
    private static long getLengthOffset(Object array) {
        long baseOffset = UnsafeAdapter.getUnsafe().arrayBaseOffset(array.getClass());
        return baseOffset - Integer.BYTES; // Length sits before the first element
    }

    // Change array length (unsafe!)
    public static void setArrayLength(Object array, int newLength) {
        if (newLength < 0) throw new IllegalArgumentException("Invalid length");
        Utility.getUnsafe().putInt(array, getLengthOffset(array), newLength);
    }

    public static void main(String[] args) {
        // Original array with capacity for 5 elements
        String[] array = {"A", "B", "C", "D", "E"};
        System.out.println("Original length: " + array.length); // 5

        // Reduce length to 3 (hides last 2 elements)
        setArrayLength(array, 3);
        System.out.println("After reducing: " + array.length); // 3
        System.out.println("Element [2]: " + array[2]); // "C" (still accessible)

        // Attempting array[3] would throw ArrayIndexOutOfBoundsException

        // Restore original length (if GC hasn't collected hidden elements)
        setArrayLength(array, 5);
        System.out.println("After restoring: " + array.length); // 5
        System.out.println("Element [3]: " + array[3]); // "D" (MAY BE NULL IF GC RAN)
    }
}