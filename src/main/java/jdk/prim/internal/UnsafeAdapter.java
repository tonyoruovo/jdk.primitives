package jdk.prim.internal;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.ProtectionDomain;

/**
 * An adapter class for the inaccessible {@code jdk.internal.misc.Unsafe} methods
 */
public final class UnsafeAdapter {
    private static final UnsafeAdapter unsafe = new UnsafeAdapter(Utility.getInternalUnsafe());

    public static UnsafeAdapter getUnsafe() { return unsafe; }

    private UnsafeAdapter(Object unsafe) {
        this.inner = unsafe;
    }

    public double getDouble(Object o, long offset) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getDouble", Object.class, long.class);
            return (double) m.invoke(inner, o, offset);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getDouble' reflectively", e);
        }
    }
    public void putDouble(Object o, long offset, double x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("putDouble", Object.class, long.class, double.class);
            m.invoke(inner, o, offset, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'putDouble' reflectively", e);
        }
    }
    public long getLong(Object o, long offset) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getLong", Object.class, long.class);
            return (long) m.invoke(inner, o, offset);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getLong' reflectively", e);
        }
    }
    public void putLong(Object o, long offset, long x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("putLong", Object.class, long.class, long.class);
            m.invoke(inner, o, offset, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'putLong' reflectively", e);
        }
    }
    public int getInt(Object o, long offset) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getInt", Object.class, long.class);
            return (int) m.invoke(inner, o, offset);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getInt' reflectively", e);
        }
    }
    public void putInt(Object o, long offset, int x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("putInt", Object.class, long.class, int.class);
            m.invoke(inner, o, offset, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'putInt' reflectively", e);
        }
    }
    public float getFloat(Object o, long offset) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getFloat", Object.class, long.class);
            return (float) m.invoke(inner, o, offset);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getFloat' reflectively", e);
        }
    }
    public void putFloat(Object o, long offset, float x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("putFloat", Object.class, long.class, float.class);
            m.invoke(inner, o, offset, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'putFloat' reflectively", e);
        }
    }
    public char getChar(Object o, long offset) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getChar", Object.class, long.class);
            return (char) m.invoke(inner, o, offset);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getChar' reflectively", e);
        }
    }
    public void putChar(Object o, long offset, char x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("putChar", Object.class, long.class, char.class);
            m.invoke(inner, o, offset, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'putChar' reflectively", e);
        }
    }
    public short getShort(Object o, long offset) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getShort", Object.class, long.class);
            return (short) m.invoke(inner, o, offset);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getShort' reflectively", e);
        }
    }
    public void putShort(Object o, long offset, short x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("putShort", Object.class, long.class, short.class);
            m.invoke(inner, o, offset, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'putShort' reflectively", e);
        }
    }
    public byte getByte(Object o, long offset) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getByte", Object.class, long.class);
            return (byte) m.invoke(inner, o, offset);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getByte' reflectively", e);
        }
    }
    public void putByte(Object o, long offset, byte x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("putByte", Object.class, long.class, byte.class);
            m.invoke(inner, o, offset, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'putByte' reflectively", e);
        }
    }
    public boolean getBoolean(Object o, long offset) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getBoolean", Object.class, long.class);
            return (boolean) m.invoke(inner, o, offset);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getBoolean' reflectively", e);
        }
    }
    public void putBoolean(Object o, long offset, boolean x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("putBoolean", Object.class, long.class, boolean.class);
            m.invoke(inner, o, offset, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'putBoolean' reflectively", e);
        }
    }
    public Object getReference(Object o, long offset) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getReference", Object.class, long.class);
            return m.invoke(inner, o, offset);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getReference' reflectively", e);
        }
    }
    public void putReference(Object o, long offset, Object x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("putReference", Object.class, long.class, Object.class);
            m.invoke(inner, o, offset, x);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'putReference' reflectively", e);
        }
    }
    public long getAddress(Object o, long offset) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAddress", Object.class, long.class);
            return (long) m.invoke(inner, o, offset);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAddress' reflectively", e);
        }
    }
    public void putAddress(Object o, long offset, long x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("putAddress", Object.class, long.class, long.class);
            m.invoke(inner, o, offset, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'putAddress' reflectively", e);
        }
    }
    public Object getUncompressedObject(long address) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getUncompressedObject", long.class);
            return m.invoke(inner, address);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getUncompressedObject' reflectively", e);
        }
    }
    public double getDouble(long address) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getDouble", long.class);
            return (double) m.invoke(inner, address);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getDouble' reflectively", e);
        }
    }
    public void putDouble(long address, double x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("putDouble", long.class, double.class);
            m.invoke(inner, address, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'putDouble' reflectively", e);
        }
    }
    public long getLong(long address) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getLong", long.class);
            return (long) m.invoke(inner, address);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getLong' reflectively", e);
        }
    }
    public void putLong(long address, long x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("putLong", long.class, long.class);
            m.invoke(inner, address, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'putLong' reflectively", e);
        }
    }
    public int getInt(long address) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getInt", long.class);
            return (int) m.invoke(inner, address);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getInt' reflectively", e);
        }
    }
    public void putInt(long address, int x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("putInt", long.class, int.class);
            m.invoke(inner, address, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'putInt' reflectively", e);
        }
    }
    public float getFloat(long address) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getFloat", long.class);
            return (float) m.invoke(inner, address);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getFloat' reflectively", e);
        }
    }
    public void putFloat(long address, float x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("putFloat", long.class, float.class);
            m.invoke(inner, address, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'putFloat' reflectively", e);
        }
    }
    public char getChar(long address) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getChar", long.class);
            return (char) m.invoke(inner, address);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getChar' reflectively", e);
        }
    }
    public void putChar(long address, char x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("putChar", long.class, char.class);
            m.invoke(inner, address, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'putChar' reflectively", e);
        }
    }
    public short getShort(long address) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getShort", long.class);
            return (short) m.invoke(inner, address);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getShort' reflectively", e);
        }
    }
    public void putShort(long address, short x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("putShort", long.class, short.class);
            m.invoke(inner, address, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'putShort' reflectively", e);
        }
    }
    public byte getByte(long address) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getByte", long.class);
            return (byte) m.invoke(inner, address);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getByte' reflectively", e);
        }
    }
    public void putByte(long address, byte x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("putByte", long.class, byte.class);
            m.invoke(inner, address, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'putByte' reflectively", e);
        }
    }
    public boolean getBoolean(long address) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getBoolean", long.class);
            return (boolean) m.invoke(inner, address);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getBoolean' reflectively", e);
        }
    }
    public void putBoolean(long address, boolean x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("putBoolean", long.class, boolean.class);
            m.invoke(inner, address, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'putBoolean' reflectively", e);
        }
    }
    public long getAddress(long address) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAddress", long.class);
            return (long) m.invoke(inner, address);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAddress' reflectively", e);
        }
    }
    public void putAddress(long address, long x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("putAddress", long.class, long.class);
            m.invoke(inner, address, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'putAddress' reflectively", e);
        }
    }
    public long allocateMemory(long bytes) {
        try {
            Method m = inner.getClass().getDeclaredMethod("allocateMemory", long.class);
            return (long) m.invoke(inner, bytes);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'allocateMemory' reflectively", e);
        }
    }
    public void reallocateMemory(long address, long bytes) {
        try {
            Method m = inner.getClass().getDeclaredMethod("reallocateMemory", long.class, long.class);
            m.invoke(inner, address, bytes);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'reallocateMemory' reflectively", e);
        }
    }
    public void setMemory(Object o, long offset, long bytes, byte value) {
        try {
            Method m = inner.getClass().getDeclaredMethod("setMemory", Object.class, long.class, long.class, byte.class);
            m.invoke(inner, o, offset, bytes, value);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'setMemory' reflectively", e);
        }
    }
    public void setMemory(long address, long bytes, byte value) {
        setMemory(null, address, bytes, value);
    }
    public void copyMemory(Object srcBase, long srcOffset, Object dstBase, long dstOffset, long bytes) {
        try {
            Method m = inner.getClass().getDeclaredMethod("copyMemory", Object.class, long.class, Object.class, long.class, long.class);
            m.invoke(inner, srcBase, srcOffset, dstBase, dstOffset, bytes);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'copyMemory' reflectively", e);
        }
    }
    public void copyMemory(long srcAddress, long dstAddress, long bytes) {
        try {
            Method m = inner.getClass().getDeclaredMethod("copyMemory", long.class, long.class, long.class);
            m.invoke(inner, srcAddress, dstAddress, bytes);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'copyMemory' reflectively", e);
        }
    }
    public void copySwapMemory(Object srcBase, long srcOffset, Object dstBase, long dstOffset, long bytes, long elemSize) {
        try {
            Method m = inner.getClass().getDeclaredMethod("copySwapMemory", Object.class, long.class, Object.class, long.class, long.class, long.class);
            m.invoke(inner, srcBase, srcOffset, dstBase, dstOffset, bytes, elemSize);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'copySwapMemory' reflectively", e);
        }
    }
    public void copySwapMemory(long srcAddress, long dstAddress, long bytes, long elemSize) {
        try {
            Method m = inner.getClass().getDeclaredMethod("copySwapMemory", long.class, long.class, long.class, long.class);
            m.invoke(inner, srcAddress, dstAddress, bytes, elemSize);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'copySwapMemory' reflectively", e);
        }
    }
    public void freeMemory(long address) {
        try {
            Method m = inner.getClass().getDeclaredMethod("freeMemory", long.class);
            m.invoke(inner, address);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'freeMemory' reflectively", e);
        }
    }
    public void writebackMemory(long address, long length) {
        try {
            Method m = inner.getClass().getDeclaredMethod("writebackMemory", long.class, long.class);
            m.invoke(inner, address, length);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'writebackMemory' reflectively", e);
        }
    }

    public static final int INVALID_FIELD_OFFSET = getIntConstant("INVALID_FIELD_OFFSET");

    private static int getIntConstant(String field) {
        return  getIntConstant(Utility.getInternalUnsafe().getClass(), field);
    }

    public static double getDoubleConstant(Class<?> cl, String staticIdentifier, double defaultValue) {
        double value = defaultValue;
        try {
            Field field = cl.getField(staticIdentifier);
            if(field.trySetAccessible()) value = (double) field.getDouble(null);
        } catch(NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace(System.err);
        }
        return value;
    }
    public static double getDoubleConstant(Class<?> cl, String staticIdentifier) {
        return getDoubleConstant(cl, staticIdentifier, 0.0);
    }
    public static long getLongConstant(Class<?> cl, String staticIdentifier, long defaultValue) {
        long value = defaultValue;
        try {
            Field field = cl.getField(staticIdentifier);
            if(field.trySetAccessible()) value = (long) field.getLong(null);
        } catch(NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace(System.err);
        }
        return value;
    }
    public static long getLongConstant(Class<?> cl, String staticIdentifier) {
        return getLongConstant(cl, staticIdentifier, 0L);
    }
    public static int getIntConstant(Class<?> cl, String staticIdentifier, int defaultValue) {
        int value = defaultValue;
        try {
            Field field = cl.getField(staticIdentifier);
            if(field.trySetAccessible()) value = (int) field.getInt(null);
        } catch(NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace(System.err);
        }
        return value;
    }
    public static int getIntConstant(Class<?> cl, String staticIdentifier) {
        return getIntConstant(cl, staticIdentifier, 0);
    }
    public static float getFloatConstant(Class<?> cl, String staticIdentifier, float defaultValue) {
        float value = defaultValue;
        try {
            Field field = cl.getField(staticIdentifier);
            if(field.trySetAccessible()) value = (float) field.getFloat(null);
        } catch(NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace(System.err);
        }
        return value;
    }
    public static float getFloatConstant(Class<?> cl, String staticIdentifier) {
        return getFloatConstant(cl, staticIdentifier, 0.0f);
    }
    public static char getCharConstant(Class<?> cl, String staticIdentifier, char defaultValue) {
        char value = defaultValue;
        try {
            Field field = cl.getField(staticIdentifier);
            if(field.trySetAccessible()) value = (char) field.getChar(null);
        } catch(NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace(System.err);
        }
        return value;
    }
    public static char getCharConstant(Class<?> cl, String staticIdentifier) {
        return getCharConstant(cl, staticIdentifier, (char) 0);
    }
    public static short getShortConstant(Class<?> cl, String staticIdentifier, short defaultValue) {
        short value = defaultValue;
        try {
            Field field = cl.getField(staticIdentifier);
            if(field.trySetAccessible()) value = (short) field.getShort(null);
        } catch(NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace(System.err);
        }
        return value;
    }
    public static short getShortConstant(Class<?> cl, String staticIdentifier) {
        return getShortConstant(cl, staticIdentifier, (short) 0);
    }
    public static byte getByteConstant(Class<?> cl, String staticIdentifier, byte defaultValue) {
        byte value = defaultValue;
        try {
            Field field = cl.getField(staticIdentifier);
            if(field.trySetAccessible()) value = (byte) field.getByte(null);
        } catch(NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace(System.err);
        }
        return value;
    }
    public static byte getByteConstant(Class<?> cl, String staticIdentifier) {
        return getByteConstant(cl, staticIdentifier, (byte) 0);
    }
    public static boolean getBooleanConstant(Class<?> cl, String staticIdentifier, boolean defaultValue) {
        boolean value = defaultValue;
        try {
            Field field = cl.getField(staticIdentifier);
            if(field.trySetAccessible()) value = (boolean) field.getBoolean(null);
        } catch(NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace(System.err);
        }
        return value;
    }
    public static boolean getBooleanConstant(Class<?> cl, String staticIdentifier) {
        return getBooleanConstant(cl, staticIdentifier, false);
    }
    @SuppressWarnings("unchecked")
    public static <T> T getConstant(Class<?> cl, String staticIdentifier, T defaultValue) {
        T value = defaultValue;
        try {
            Field field = cl.getField(staticIdentifier);
            if(field.trySetAccessible()) value = (T) field.get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace(System.err);
        }
        return value;
    }
    public static <T> T getConstant(Class<?> cl, String staticIdentifier) {
        return getConstant(cl, staticIdentifier, null);
    }

    public long objectFieldOffset(Field f) {
        try {
            Method m = inner.getClass().getDeclaredMethod("objectFieldOffset", Field.class);
            return (long) m.invoke(inner, f);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'objectFieldOffset' reflectively", e);
        }
    }
    public long objectFieldOffset(Class<?> c, String name) {
        try {
            Method m = inner.getClass().getDeclaredMethod("objectFieldOffset", Class.class, String.class);
            return (long) m.invoke(inner, c, name);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'objectFieldOffset' reflectively", e);
        }
    }
    public long staticFieldOffset(Field f) {
        try {
            Method m = inner.getClass().getDeclaredMethod("staticFieldOffset", Field.class);
            return (long) m.invoke(inner, f);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'staticFieldOffset' reflectively", e);
        }
    }
    public Object staticFieldBase(Field f) {
        try {
            Method m = inner.getClass().getDeclaredMethod("staticFieldBase", Field.class);
            return m.invoke(inner, f);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'staticFieldBase' reflectively", e);
        }
    }
    public boolean shouldBeInitialized(Class<?> c) {
        try {
            Method m = inner.getClass().getDeclaredMethod("shouldBeInitialized", Class.class);
            return (boolean) m.invoke(inner, c);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'shouldBeInitialized' reflectively", e);
        }
    }
    public void ensureClassInitialized(Class<?> c) {
        try {
            Method m = inner.getClass().getDeclaredMethod("ensureClassInitialized", Class.class);
            m.invoke(inner, c);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'ensureClassInitialized' reflectively", e);
        }
    }
    public int arrayBaseOffset(Class<?> arrayClass) {
        try {
            Method m = inner.getClass().getDeclaredMethod("arrayBaseOffset", Class.class);
            return (int) m.invoke(inner, arrayClass);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'arrayBaseOffset' reflectively", e);
        }
    }

    public static final int ARRAY_DOUBLE_BASE_OFFSET = getIntConstant("ARRAY_DOUBLE_BASE_OFFSET");
    public static final int ARRAY_LONG_BASE_OFFSET = getIntConstant("ARRAY_LONG_BASE_OFFSET");
    public static final int ARRAY_INT_BASE_OFFSET = getIntConstant("ARRAY_INT_BASE_OFFSET");
    public static final int ARRAY_FLOAT_BASE_OFFSET = getIntConstant("ARRAY_FLOAT_BASE_OFFSET");
    public static final int ARRAY_CHAR_BASE_OFFSET = getIntConstant("ARRAY_CHAR_BASE_OFFSET");
    public static final int ARRAY_SHORT_BASE_OFFSET = getIntConstant("ARRAY_SHORT_BASE_OFFSET");
    public static final int ARRAY_BYTE_BASE_OFFSET = getIntConstant("ARRAY_BYTE_BASE_OFFSET");
    public static final int ARRAY_BOOLEAN_BASE_OFFSET = getIntConstant("ARRAY_BOOLEAN_BASE_OFFSET");
    public static final int ARRAY_OBJECT_BASE_OFFSET = getIntConstant("ARRAY_OBJECT_BASE_OFFSET");

    public int arrayIndexScale(Class<?> arrayClass) {
        try {
            Method m = inner.getClass().getDeclaredMethod("arrayIndexScale", Class.class);
            return (int) m.invoke(inner, arrayClass);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'arrayIndexScale' reflectively", e);
        }
    }

    public static final int ARRAY_DOUBLE_INDEX_SCALE = getIntConstant("ARRAY_DOUBLE_INDEX_SCALE");
    public static final int ARRAY_LONG_INDEX_SCALE = getIntConstant("ARRAY_LONG_INDEX_SCALE");
    public static final int ARRAY_INT_INDEX_SCALE = getIntConstant("ARRAY_INT_INDEX_SCALE");
    public static final int ARRAY_FLOAT_INDEX_SCALE = getIntConstant("ARRAY_FLOAT_INDEX_SCALE");
    public static final int ARRAY_CHAR_INDEX_SCALE = getIntConstant("ARRAY_CHAR_INDEX_SCALE");
    public static final int ARRAY_SHORT_INDEX_SCALE = getIntConstant("ARRAY_SHORT_INDEX_SCALE");
    public static final int ARRAY_BYTE_INDEX_SCALE = getIntConstant("ARRAY_BYTE_INDEX_SCALE");
    public static final int ARRAY_BOOLEAN_INDEX_SCALE = getIntConstant("ARRAY_BOOLEAN_INDEX_SCALE");
    public static final int ARRAY_OBJECT_INDEX_SCALE = getIntConstant("ARRAY_OBJECT_INDEX_SCALE");

    public int addressSize() {
        try {
            Method m = inner.getClass().getDeclaredMethod("addressSize");
            return (int) m.invoke(inner);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'addressSize' reflectively", e);
        }
    }

    public static final int ADDRESS_SIZE = getIntConstant("ADDRESS_SIZE");

    public int pageSize() {
        try {
            Method m = inner.getClass().getDeclaredMethod("pageSize");
            return (int) m.invoke(inner);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'pageSize' reflectively", e);
        }
    }
    public int dataCacheLineFlushSize() {
        try {
            Method m = inner.getClass().getDeclaredMethod("dataCacheLineFlushSize");
            return (int) m.invoke(inner);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'dataCacheLineFlushSize' reflectively", e);
        }
    }
    public long dataCacheLineAlignDown(long address) {
        try {
            Method m = inner.getClass().getDeclaredMethod("dataCacheLineAlignDown", long.class);
            return (long) m.invoke(inner, address);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'dataCacheLineAlignDown' reflectively", e);
        }
    }

    public static boolean isWritebackEnabled() {
        try {
            Method m = Utility.getInternalUnsafe().getClass().getDeclaredMethod("isWritebackEnabled");
            return (boolean) m.invoke(null);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'isWritebackEnabled' reflectively", e);
        }
    }

    public Class<?> defineClass(String name, byte[] b, int off, int len,
                                ClassLoader loader, ProtectionDomain protectionDomain) {
        try {
            Method m = inner.getClass().getDeclaredMethod("defineClass", String.class,
                    byte[].class, int.class, int.class, ClassLoader.class, ProtectionDomain.class);
            return (Class<?>) m.invoke(inner, name, b, off, len, loader, protectionDomain);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'defineClass' reflectively", e);
        }
    }
    public Class<?> defineClass0(String name, byte[] b, int off, int len,
                                ClassLoader loader, ProtectionDomain protectionDomain) {
        try {
            Method m = inner.getClass().getDeclaredMethod("defineClass0", String.class,
                    byte[].class, int.class, int.class, ClassLoader.class, ProtectionDomain.class);
            return (Class<?>) m.invoke(inner, name, b, off, len, loader, protectionDomain);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'defineClass0' reflectively", e);
        }
    }

    public Object allocateInstance(Class<?> cls) {
        try {
            Method m = inner.getClass().getDeclaredMethod("allocateInstance", Class.class);
            return m.invoke(inner, cls);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'allocateInstance' reflectively", e);
        }
    }
    public Object allocateUninitializedArray(Class<?> componentType, int length) {
        try {
            Method m = inner.getClass().getDeclaredMethod("allocateUninitializedArray", Class.class, int.class);
            return m.invoke(inner, componentType, length);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'allocateUninitializedArray' reflectively", e);
        }
    }
    public Object allocateUninitializedArray0(Class<?> componentType, int length) {
        try {
            Method m = inner.getClass().getDeclaredMethod("allocateUninitializedArray0", Class.class, int.class);
            return m.invoke(inner, componentType, length);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'allocateUninitializedArray0' reflectively", e);
        }
    }
    public void throwException(Throwable ee) {
        try {
            Method m = inner.getClass().getDeclaredMethod("throwException", Throwable.class);
            m.invoke(inner, ee);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'throwException' reflectively", e);
        }
    }

    public boolean compareAndSetReference(Object o, long offset,
                                          Object expected,
                                          Object x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("compareAndSetReference", Object.class, long.class, Object.class, Object.class);
            return (boolean) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'compareAndSetReference' reflectively", e);
        }
    }
    public Object compareAndExchangeReference(Object o, long offset,
                                          Object expected,
                                          Object x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("compareAndExchangeReference", Object.class, long.class, Object.class, Object.class);
            return m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'compareAndExchangeReference' reflectively", e);
        }
    }
    public Object compareAndExchangeReferenceAcquire(Object o, long offset,
                                          Object expected,
                                          Object x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("compareAndExchangeReferenceAcquire", Object.class, long.class, Object.class, Object.class);
            return m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'compareAndExchangeReferenceAcquire' reflectively", e);
        }
    }
    public Object compareAndExchangeReferenceRelease(Object o, long offset,
                                          Object expected,
                                          Object x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("compareAndExchangeReferenceRelease", Object.class, long.class, Object.class, Object.class);
            return m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'compareAndExchangeReferenceRelease' reflectively", e);
        }
    }
    public boolean weakCompareAndSetReferencePlain(Object o, long offset, Object expected, Object x) {
        try {
            Method m = inner.getClass().getDeclaredMethod(" weakCompareAndSetReferencePlain", Object.class, long.class, Object.class, Object.class);
            return (boolean) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve ' weakCompareAndSetReferencePlain' reflectively", e);
        }
    }
    public boolean weakCompareAndSetReferenceAcquire(Object o, long offset, Object expected, Object x) {
        try {
            Method m = inner.getClass().getDeclaredMethod(" weakCompareAndSetReferenceAcquire", Object.class, long.class, Object.class, Object.class);
            return (boolean) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve ' weakCompareAndSetReferenceAcquire' reflectively", e);
        }
    }
    public boolean weakCompareAndSetReferenceRelease(Object o, long offset, Object expected, Object x) {
        try {
            Method m = inner.getClass().getDeclaredMethod(" weakCompareAndSetReferenceRelease", Object.class, long.class, Object.class, Object.class);
            return (boolean) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve ' weakCompareAndSetReferenceRelease' reflectively", e);
        }
    }
    public boolean weakCompareAndSetReference(Object o, long offset, Object expected, Object x) {
        try {
            Method m = inner.getClass().getDeclaredMethod(" weakCompareAndSetReference", Object.class, long.class, Object.class, Object.class);
            return (boolean) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve ' weakCompareAndSetReference' reflectively", e);
        }
    }

    public boolean compareAndSetDouble(Object o, long offset,
                                          double expected,
                                          double x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("compareAndSetDouble", Object.class, long.class, double.class, double.class);
            return (boolean) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'compareAndSetDouble' reflectively", e);
        }
    }
    public double compareAndExchangeDouble(Object o, long offset,
                                              double expected,
                                              double x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("compareAndExchangeDouble", Object.class, long.class, double.class, double.class);
            return (double) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'compareAndExchangeDouble' reflectively", e);
        }
    }
    public double compareAndExchangeDoubleAcquire(Object o, long offset,
                                                     double expected,
                                                     double x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("compareAndExchangeDoubleAcquire", Object.class, long.class, double.class, double.class);
            return (double) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'compareAndExchangeDoubleAcquire' reflectively", e);
        }
    }
    public double compareAndExchangeDoubleRelease(Object o, long offset,
                                                     double expected,
                                                     double x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("compareAndExchangeDoubleRelease", Object.class, long.class, double.class, double.class);
            return (double) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'compareAndExchangeDoubleRelease' reflectively", e);
        }
    }
    public boolean weakCompareAndSetDoublePlain(Object o, long offset,
                                                   double expected,
                                                   double x) {
        try {
            Method m = inner.getClass().getDeclaredMethod(" weakCompareAndSetDoublePlain", Object.class, long.class, double.class, double.class);
            return (boolean) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve ' weakCompareAndSetDoublePlain' reflectively", e);
        }
    }
    public boolean weakCompareAndSetDoubleAcquire(Object o, long offset,
                                                     double expected,
                                                     double x) {
        try {
            Method m = inner.getClass().getDeclaredMethod(" weakCompareAndSetDoubleAcquire", Object.class, long.class, double.class, double.class);
            return (boolean) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve ' weakCompareAndSetDoubleAcquire' reflectively", e);
        }
    }
    public boolean weakCompareAndSetDoubleRelease(Object o, long offset,
                                                     double expected,
                                                     double x) {
        try {
            Method m = inner.getClass().getDeclaredMethod(" weakCompareAndSetDoubleRelease", Object.class, long.class, double.class, double.class);
            return (boolean) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve ' weakCompareAndSetDoubleRelease' reflectively", e);
        }
    }
    public boolean weakCompareAndSetDouble(Object o, long offset,
                                              double expected,
                                              double x) {
        try {
            Method m = inner.getClass().getDeclaredMethod(" weakCompareAndSetDouble", Object.class, long.class, double.class, double.class);
            return (boolean) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve ' weakCompareAndSetDouble' reflectively", e);
        }
    }

    public boolean compareAndSetLong(Object o, long offset,
                                       long expected,
                                       long x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("compareAndSetLong", Object.class, long.class, long.class, long.class);
            return (boolean) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'compareAndSetLong' reflectively", e);
        }
    }
    public long compareAndExchangeLong(Object o, long offset,
                                           long expected,
                                           long x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("compareAndExchangeLong", Object.class, long.class, long.class, long.class);
            return (long) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'compareAndExchangeLong' reflectively", e);
        }
    }
    public long compareAndExchangeLongAcquire(Object o, long offset,
                                                  long expected,
                                                  long x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("compareAndExchangeLongAcquire", Object.class, long.class, long.class, long.class);
            return (long) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'compareAndExchangeLongAcquire' reflectively", e);
        }
    }
    public long compareAndExchangeLongRelease(Object o, long offset,
                                                  long expected,
                                                  long x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("compareAndExchangeLongRelease", Object.class, long.class, long.class, long.class);
            return (long) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'compareAndExchangeLongRelease' reflectively", e);
        }
    }
    public boolean weakCompareAndSetLongPlain(Object o, long offset,
                                                long expected,
                                                long x) {
        try {
            Method m = inner.getClass().getDeclaredMethod(" weakCompareAndSetLongPlain", Object.class, long.class, long.class, long.class);
            return (boolean) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve ' weakCompareAndSetLongPlain' reflectively", e);
        }
    }
    public boolean weakCompareAndSetLongAcquire(Object o, long offset,
                                                  long expected,
                                                  long x) {
        try {
            Method m = inner.getClass().getDeclaredMethod(" weakCompareAndSetLongAcquire", Object.class, long.class, long.class, long.class);
            return (boolean) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve ' weakCompareAndSetLongAcquire' reflectively", e);
        }
    }
    public boolean weakCompareAndSetLongRelease(Object o, long offset,
                                                  long expected,
                                                  long x) {
        try {
            Method m = inner.getClass().getDeclaredMethod(" weakCompareAndSetLongRelease", Object.class, long.class, long.class, long.class);
            return (boolean) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve ' weakCompareAndSetLongRelease' reflectively", e);
        }
    }
    public boolean weakCompareAndSetLong(Object o, long offset,
                                           long expected,
                                           long x) {
        try {
            Method m = inner.getClass().getDeclaredMethod(" weakCompareAndSetLong", Object.class, long.class, long.class, long.class);
            return (boolean) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve ' weakCompareAndSetLong' reflectively", e);
        }
    }

    public boolean compareAndSetInt(Object o, long offset,
                                     int expected,
                                     int x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("compareAndSetInt", Object.class, long.class, int.class, int.class);
            return (boolean) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'compareAndSetInt' reflectively", e);
        }
    }
    public int compareAndExchangeInt(Object o, long offset,
                                       int expected,
                                       int x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("compareAndExchangeInt", Object.class, long.class, int.class, int.class);
            return (int) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'compareAndExchangeInt' reflectively", e);
        }
    }
    public int compareAndExchangeIntAcquire(Object o, long offset,
                                              int expected,
                                              int x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("compareAndExchangeIntAcquire", Object.class, long.class, int.class, int.class);
            return (int) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'compareAndExchangeIntAcquire' reflectively", e);
        }
    }
    public int compareAndExchangeIntRelease(Object o, long offset,
                                              int expected,
                                              int x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("compareAndExchangeIntRelease", Object.class, long.class, int.class, int.class);
            return (int) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'compareAndExchangeIntRelease' reflectively", e);
        }
    }
    public boolean weakCompareAndSetIntPlain(Object o, long offset,
                                              int expected,
                                              int x) {
        try {
            Method m = inner.getClass().getDeclaredMethod(" weakCompareAndSetIntPlain", Object.class, long.class, int.class, int.class);
            return (boolean) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve ' weakCompareAndSetIntPlain' reflectively", e);
        }
    }
    public boolean weakCompareAndSetIntAcquire(Object o, long offset,
                                                int expected,
                                                int x) {
        try {
            Method m = inner.getClass().getDeclaredMethod(" weakCompareAndSetIntAcquire", Object.class, long.class, int.class, int.class);
            return (boolean) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve ' weakCompareAndSetIntAcquire' reflectively", e);
        }
    }
    public boolean weakCompareAndSetIntRelease(Object o, long offset,
                                                int expected,
                                                int x) {
        try {
            Method m = inner.getClass().getDeclaredMethod(" weakCompareAndSetIntRelease", Object.class, long.class, int.class, int.class);
            return (boolean) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve ' weakCompareAndSetIntRelease' reflectively", e);
        }
    }
    public boolean weakCompareAndSetInt(Object o, long offset,
                                         int expected,
                                         int x) {
        try {
            Method m = inner.getClass().getDeclaredMethod(" weakCompareAndSetInt", Object.class, long.class, int.class, int.class);
            return (boolean) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve ' weakCompareAndSetInt' reflectively", e);
        }
    }

    public boolean compareAndSetFloat(Object o, long offset,
                                    float expected,
                                    float x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("compareAndSetFloat", Object.class, long.class, float.class, float.class);
            return (boolean) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'compareAndSetFloat' reflectively", e);
        }
    }
    public float compareAndExchangeFloat(Object o, long offset,
                                     float expected,
                                     float x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("compareAndExchangeFloat", Object.class, long.class, float.class, float.class);
            return (float) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'compareAndExchangeFloat' reflectively", e);
        }
    }
    public float compareAndExchangeFloatAcquire(Object o, long offset,
                                            float expected,
                                            float x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("compareAndExchangeFloatAcquire", Object.class, long.class, float.class, float.class);
            return (float) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'compareAndExchangeFloatAcquire' reflectively", e);
        }
    }
    public float compareAndExchangeFloatRelease(Object o, long offset,
                                            float expected,
                                            float x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("compareAndExchangeFloatRelease", Object.class, long.class, float.class, float.class);
            return (float) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'compareAndExchangeFloatRelease' reflectively", e);
        }
    }
    public boolean weakCompareAndSetFloatPlain(Object o, long offset,
                                             float expected,
                                             float x) {
        try {
            Method m = inner.getClass().getDeclaredMethod(" weakCompareAndSetFloatPlain", Object.class, long.class, float.class, float.class);
            return (boolean) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve ' weakCompareAndSetFloatPlain' reflectively", e);
        }
    }
    public boolean weakCompareAndSetFloatAcquire(Object o, long offset,
                                               float expected,
                                               float x) {
        try {
            Method m = inner.getClass().getDeclaredMethod(" weakCompareAndSetFloatAcquire", Object.class, long.class, float.class, float.class);
            return (boolean) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve ' weakCompareAndSetFloatAcquire' reflectively", e);
        }
    }
    public boolean weakCompareAndSetFloatRelease(Object o, long offset,
                                               float expected,
                                               float x) {
        try {
            Method m = inner.getClass().getDeclaredMethod(" weakCompareAndSetFloatRelease", Object.class, long.class, float.class, float.class);
            return (boolean) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve ' weakCompareAndSetFloatRelease' reflectively", e);
        }
    }
    public boolean weakCompareAndSetFloat(Object o, long offset,
                                        float expected,
                                        float x) {
        try {
            Method m = inner.getClass().getDeclaredMethod(" weakCompareAndSetFloat", Object.class, long.class, float.class, float.class);
            return (boolean) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve ' weakCompareAndSetFloat' reflectively", e);
        }
    }

    public boolean compareAndSetChar(Object o, long offset,
                                      char expected,
                                      char x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("compareAndSetChar", Object.class, long.class, char.class, char.class);
            return (boolean) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'compareAndSetChar' reflectively", e);
        }
    }
    public char compareAndExchangeChar(Object o, long offset,
                                         char expected,
                                         char x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("compareAndExchangeChar", Object.class, long.class, char.class, char.class);
            return (char) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'compareAndExchangeChar' reflectively", e);
        }
    }
    public char compareAndExchangeCharAcquire(Object o, long offset,
                                                char expected,
                                                char x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("compareAndExchangeCharAcquire", Object.class, long.class, char.class, char.class);
            return (char) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'compareAndExchangeCharAcquire' reflectively", e);
        }
    }
    public char compareAndExchangeCharRelease(Object o, long offset,
                                                char expected,
                                                char x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("compareAndExchangeCharRelease", Object.class, long.class, char.class, char.class);
            return (char) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'compareAndExchangeCharRelease' reflectively", e);
        }
    }
    public boolean weakCompareAndSetCharPlain(Object o, long offset,
                                               char expected,
                                               char x) {
        try {
            Method m = inner.getClass().getDeclaredMethod(" weakCompareAndSetCharPlain", Object.class, long.class, char.class, char.class);
            return (boolean) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve ' weakCompareAndSetCharPlain' reflectively", e);
        }
    }
    public boolean weakCompareAndSetCharAcquire(Object o, long offset,
                                                 char expected,
                                                 char x) {
        try {
            Method m = inner.getClass().getDeclaredMethod(" weakCompareAndSetCharAcquire", Object.class, long.class, char.class, char.class);
            return (boolean) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve ' weakCompareAndSetCharAcquire' reflectively", e);
        }
    }
    public boolean weakCompareAndSetCharRelease(Object o, long offset,
                                                 char expected,
                                                 char x) {
        try {
            Method m = inner.getClass().getDeclaredMethod(" weakCompareAndSetCharRelease", Object.class, long.class, char.class, char.class);
            return (boolean) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve ' weakCompareAndSetCharRelease' reflectively", e);
        }
    }
    public boolean weakCompareAndSetChar(Object o, long offset,
                                          char expected,
                                          char x) {
        try {
            Method m = inner.getClass().getDeclaredMethod(" weakCompareAndSetChar", Object.class, long.class, char.class, char.class);
            return (boolean) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve ' weakCompareAndSetChar' reflectively", e);
        }
    }

    public boolean compareAndSetShort(Object o, long offset,
                                     short expected,
                                     short x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("compareAndSetShort", Object.class, long.class, short.class, short.class);
            return (boolean) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'compareAndSetShort' reflectively", e);
        }
    }
    public short compareAndExchangeShort(Object o, long offset,
                                       short expected,
                                       short x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("compareAndExchangeShort", Object.class, long.class, short.class, short.class);
            return (short) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'compareAndExchangeShort' reflectively", e);
        }
    }
    public short compareAndExchangeShortAcquire(Object o, long offset,
                                              short expected,
                                              short x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("compareAndExchangeShortAcquire", Object.class, long.class, short.class, short.class);
            return (short) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'compareAndExchangeShortAcquire' reflectively", e);
        }
    }
    public short compareAndExchangeShortRelease(Object o, long offset,
                                              short expected,
                                              short x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("compareAndExchangeShortRelease", Object.class, long.class, short.class, short.class);
            return (short) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'compareAndExchangeShortRelease' reflectively", e);
        }
    }
    public boolean weakCompareAndSetShortPlain(Object o, long offset,
                                              short expected,
                                              short x) {
        try {
            Method m = inner.getClass().getDeclaredMethod(" weakCompareAndSetShortPlain", Object.class, long.class, short.class, short.class);
            return (boolean) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve ' weakCompareAndSetShortPlain' reflectively", e);
        }
    }
    public boolean weakCompareAndSetShortAcquire(Object o, long offset,
                                                short expected,
                                                short x) {
        try {
            Method m = inner.getClass().getDeclaredMethod(" weakCompareAndSetShortAcquire", Object.class, long.class, short.class, short.class);
            return (boolean) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve ' weakCompareAndSetShortAcquire' reflectively", e);
        }
    }
    public boolean weakCompareAndSetShortRelease(Object o, long offset,
                                                short expected,
                                                short x) {
        try {
            Method m = inner.getClass().getDeclaredMethod(" weakCompareAndSetShortRelease", Object.class, long.class, short.class, short.class);
            return (boolean) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve ' weakCompareAndSetShortRelease' reflectively", e);
        }
    }
    public boolean weakCompareAndSetShort(Object o, long offset,
                                         short expected,
                                         short x) {
        try {
            Method m = inner.getClass().getDeclaredMethod(" weakCompareAndSetShort", Object.class, long.class, short.class, short.class);
            return (boolean) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve ' weakCompareAndSetShort' reflectively", e);
        }
    }

    public boolean compareAndSetByte(Object o, long offset,
                                     byte expected,
                                     byte x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("compareAndSetByte", Object.class, long.class, byte.class, byte.class);
            return (boolean) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'compareAndSetByte' reflectively", e);
        }
    }
    public byte compareAndExchangeByte(Object o, long offset,
                                       byte expected,
                                       byte x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("compareAndExchangeByte", Object.class, long.class, byte.class, byte.class);
            return (byte) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'compareAndExchangeByte' reflectively", e);
        }
    }
    public byte compareAndExchangeByteAcquire(Object o, long offset,
                                              byte expected,
                                              byte x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("compareAndExchangeByteAcquire", Object.class, long.class, byte.class, byte.class);
            return (byte) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'compareAndExchangeByteAcquire' reflectively", e);
        }
    }
    public byte compareAndExchangeByteRelease(Object o, long offset,
                                              byte expected,
                                              byte x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("compareAndExchangeByteRelease", Object.class, long.class, byte.class, byte.class);
            return (byte) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'compareAndExchangeByteRelease' reflectively", e);
        }
    }
    public boolean weakCompareAndSetBytePlain(Object o, long offset,
                                              byte expected,
                                              byte x) {
        try {
            Method m = inner.getClass().getDeclaredMethod(" weakCompareAndSetBytePlain", Object.class, long.class, byte.class, byte.class);
            return (boolean) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve ' weakCompareAndSetBytePlain' reflectively", e);
        }
    }
    public boolean weakCompareAndSetByteAcquire(Object o, long offset,
                                                byte expected,
                                                byte x) {
        try {
            Method m = inner.getClass().getDeclaredMethod(" weakCompareAndSetByteAcquire", Object.class, long.class, byte.class, byte.class);
            return (boolean) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve ' weakCompareAndSetByteAcquire' reflectively", e);
        }
    }
    public boolean weakCompareAndSetByteRelease(Object o, long offset,
                                                byte expected,
                                                byte x) {
        try {
            Method m = inner.getClass().getDeclaredMethod(" weakCompareAndSetByteRelease", Object.class, long.class, byte.class, byte.class);
            return (boolean) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve ' weakCompareAndSetByteRelease' reflectively", e);
        }
    }
    public boolean weakCompareAndSetByte(Object o, long offset,
                                         byte expected,
                                         byte x) {
        try {
            Method m = inner.getClass().getDeclaredMethod(" weakCompareAndSetByte", Object.class, long.class, byte.class, byte.class);
            return (boolean) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve ' weakCompareAndSetByte' reflectively", e);
        }
    }

    public boolean compareAndSetBoolean(Object o, long offset,
                                     boolean expected,
                                     boolean x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("compareAndSetBoolean", Object.class, long.class, boolean.class, boolean.class);
            return (boolean) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'compareAndSetBoolean' reflectively", e);
        }
    }
    public boolean compareAndExchangeBoolean(Object o, long offset,
                                       boolean expected,
                                       boolean x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("compareAndExchangeBoolean", Object.class, long.class, boolean.class, boolean.class);
            return (boolean) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'compareAndExchangeBoolean' reflectively", e);
        }
    }
    public boolean compareAndExchangeBooleanAcquire(Object o, long offset,
                                              boolean expected,
                                              boolean x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("compareAndExchangeBooleanAcquire", Object.class, long.class, boolean.class, boolean.class);
            return (boolean) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'compareAndExchangeBooleanAcquire' reflectively", e);
        }
    }
    public boolean compareAndExchangeBooleanRelease(Object o, long offset,
                                              boolean expected,
                                              boolean x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("compareAndExchangeBooleanRelease", Object.class, long.class, boolean.class, boolean.class);
            return (boolean) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'compareAndExchangeBooleanRelease' reflectively", e);
        }
    }
    public boolean weakCompareAndSetBooleanPlain(Object o, long offset,
                                              boolean expected,
                                              boolean x) {
        try {
            Method m = inner.getClass().getDeclaredMethod(" weakCompareAndSetBooleanPlain", Object.class, long.class, boolean.class, boolean.class);
            return (boolean) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve ' weakCompareAndSetBooleanPlain' reflectively", e);
        }
    }
    public boolean weakCompareAndSetBooleanAcquire(Object o, long offset,
                                                boolean expected,
                                                boolean x) {
        try {
            Method m = inner.getClass().getDeclaredMethod(" weakCompareAndSetBooleanAcquire", Object.class, long.class, boolean.class, boolean.class);
            return (boolean) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve ' weakCompareAndSetBooleanAcquire' reflectively", e);
        }
    }
    public boolean weakCompareAndSetBooleanRelease(Object o, long offset,
                                                boolean expected,
                                                boolean x) {
        try {
            Method m = inner.getClass().getDeclaredMethod(" weakCompareAndSetBooleanRelease", Object.class, long.class, boolean.class, boolean.class);
            return (boolean) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve ' weakCompareAndSetBooleanRelease' reflectively", e);
        }
    }
    public boolean weakCompareAndSetBoolean(Object o, long offset,
                                         boolean expected,
                                         boolean x) {
        try {
            Method m = inner.getClass().getDeclaredMethod(" weakCompareAndSetBoolean", Object.class, long.class, boolean.class, boolean.class);
            return (boolean) m.invoke(inner, o, offset, expected, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve ' weakCompareAndSetBoolean' reflectively", e);
        }
    }

    public Object getReferenceVolatile(Object o, long offset) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getReferenceVolatile", Object.class, long.class);
            return m.invoke(inner, o, offset);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'getReferenceVolatile' reflectively", e);
        }
    }
    public void putReferenceVolatile(Object o, long offset, Object x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("putReferenceVolatile", Object.class, long.class, Object.class);
            m.invoke(inner, o, offset, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'putReferenceVolatile' reflectively", e);
        }
    }

    public double getDoubleVolatile(Object o, long offset) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getDoubleVolatile", Object.class, long.class);
            return (double) m.invoke(inner, o, offset);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'getDoubleVolatile' reflectively", e);
        }
    }
    public void putDoubleVolatile(Object o, long offset, double x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("putDoubleVolatile", Object.class, long.class, double.class);
            m.invoke(inner, o, offset, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'putDoubleVolatile' reflectively", e);
        }
    }

    public long getLongVolatile(Object o, long offset) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getLongVolatile", Object.class, long.class);
            return (long) m.invoke(inner, o, offset);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'getLongVolatile' reflectively", e);
        }
    }
    public void putLongVolatile(Object o, long offset, long x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("putLongVolatile", Object.class, long.class, long.class);
            m.invoke(inner, o, offset, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'putLongVolatile' reflectively", e);
        }
    }

    public int getIntVolatile(Object o, long offset) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getIntVolatile", Object.class, long.class);
            return (int) m.invoke(inner, o, offset);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'getIntVolatile' reflectively", e);
        }
    }
    public void putIntVolatile(Object o, long offset, int x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("putIntVolatile", Object.class, long.class, int.class);
            m.invoke(inner, o, offset, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'putIntVolatile' reflectively", e);
        }
    }

    public float getFloatVolatile(Object o, long offset) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getFloatVolatile", Object.class, long.class);
            return (float) m.invoke(inner, o, offset);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'getFloatVolatile' reflectively", e);
        }
    }
    public void putFloatVolatile(Object o, long offset, float x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("putFloatVolatile", Object.class, long.class, float.class);
            m.invoke(inner, o, offset, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'putFloatVolatile' reflectively", e);
        }
    }

    public char getCharVolatile(Object o, long offset) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getCharVolatile", Object.class, long.class);
            return (char) m.invoke(inner, o, offset);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'getCharVolatile' reflectively", e);
        }
    }
    public void putCharVolatile(Object o, long offset, char x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("putCharVolatile", Object.class, long.class, char.class);
            m.invoke(inner, o, offset, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'putCharVolatile' reflectively", e);
        }
    }

    public short getShortVolatile(Object o, long offset) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getShortVolatile", Object.class, long.class);
            return (short) m.invoke(inner, o, offset);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'getShortVolatile' reflectively", e);
        }
    }
    public void putShortVolatile(Object o, long offset, short x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("putShortVolatile", Object.class, long.class, short.class);
            m.invoke(inner, o, offset, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'putShortVolatile' reflectively", e);
        }
    }

    public byte getByteVolatile(Object o, long offset) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getByteVolatile", Object.class, long.class);
            return (byte) m.invoke(inner, o, offset);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'getByteVolatile' reflectively", e);
        }
    }
    public void putByteVolatile(Object o, long offset, byte x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("putByteVolatile", Object.class, long.class, byte.class);
            m.invoke(inner, o, offset, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'putByteVolatile' reflectively", e);
        }
    }

    public boolean getBooleanVolatile(Object o, long offset) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getBooleanVolatile", Object.class, long.class);
            return (boolean) m.invoke(inner, o, offset);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'getBooleanVolatile' reflectively", e);
        }
    }
    public void putBooleanVolatile(Object o, long offset, boolean x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("putBooleanVolatile", Object.class, long.class, boolean.class);
            m.invoke(inner, o, offset, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'putBooleanVolatile' reflectively", e);
        }
    }

    public Object getReferenceAcquire(Object o, long offset) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getReferenceAcquire", Object.class, long.class);
            return m.invoke(inner, o, offset);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'getReferenceAcquire' reflectively", e);
        }
    }

    public double getDoubleAcquire(Object o, long offset) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getDoubleAcquire", Object.class, long.class);
            return (double) m.invoke(inner, o, offset);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getDoubleAcquire' reflectively", e);
        }
    }
    public long getLongAcquire(Object o, long offset) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getLongAcquire", Object.class, long.class);
            return (long) m.invoke(inner, o, offset);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getLongAcquire' reflectively", e);
        }
    }
    public int getIntAcquire(Object o, long offset) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getIntAcquire", Object.class, long.class);
            return (int) m.invoke(inner, o, offset);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getIntAcquire' reflectively", e);
        }
    }
    public float getFloatAcquire(Object o, long offset) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getFloatAcquire", Object.class, long.class);
            return (float) m.invoke(inner, o, offset);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getFloatAcquire' reflectively", e);
        }
    }
    public char getCharAcquire(Object o, long offset) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getCharAcquire", Object.class, long.class);
            return (char) m.invoke(inner, o, offset);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getCharAcquire' reflectively", e);
        }
    }
    public short getShortAcquire(Object o, long offset) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getShortAcquire", Object.class, long.class);
            return (short) m.invoke(inner, o, offset);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getShortAcquire' reflectively", e);
        }
    }
    public byte getByteAcquire(Object o, long offset) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getByteAcquire", Object.class, long.class);
            return (byte) m.invoke(inner, o, offset);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getByteAcquire' reflectively", e);
        }
    }
    public boolean getBooleanAcquire(Object o, long offset) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getBooleanAcquire", Object.class, long.class);
            return (boolean) m.invoke(inner, o, offset);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getBooleanAcquire' reflectively", e);
        }
    }

    public void putReferenceRelease(Object o, long offset, Object x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("putReferenceRelease", Object.class, long.class, Object.class);
            m.invoke(inner, o, offset, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'putReferenceRelease' reflectively", e);
        }
    }

    public void putDoubleRelease(Object o, long offset, double x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("putDoubleRelease", Object.class, long.class, double.class);
            m.invoke(inner, o, offset, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'putDoubleRelease' reflectively", e);
        }
    }
    public void putLongRelease(Object o, long offset, long x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("putLongRelease", Object.class, long.class, long.class);
            m.invoke(inner, o, offset, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'putLongRelease' reflectively", e);
        }
    }
    public void putIntRelease(Object o, long offset, int x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("putIntRelease", Object.class, long.class, int.class);
            m.invoke(inner, o, offset, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'putIntRelease' reflectively", e);
        }
    }
    public void putFloatRelease(Object o, long offset, float x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("putFloatRelease", Object.class, long.class, float.class);
            m.invoke(inner, o, offset, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'putFloatRelease' reflectively", e);
        }
    }
    public void putCharRelease(Object o, long offset, char x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("putCharRelease", Object.class, long.class, char.class);
            m.invoke(inner, o, offset, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'putCharRelease' reflectively", e);
        }
    }
    public void putShortRelease(Object o, long offset, short x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("putShortRelease", Object.class, long.class, short.class);
            m.invoke(inner, o, offset, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'putShortRelease' reflectively", e);
        }
    }
    public void putByteRelease(Object o, long offset, byte x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("putByteRelease", Object.class, long.class, byte.class);
            m.invoke(inner, o, offset, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'putByteRelease' reflectively", e);
        }
    }
    public void putBooleanRelease(Object o, long offset, boolean x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("putBooleanRelease", Object.class, long.class, boolean.class);
            m.invoke(inner, o, offset, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'putBooleanRelease' reflectively", e);
        }
    }

    public void putReferenceOpaque(Object o, long offset, Object x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("putReferenceOpaque", Object.class, long.class, Object.class);
            m.invoke(inner, o, offset, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'putReferenceOpaque' reflectively", e);
        }
    }

    public void putDoubleOpaque(Object o, long offset, double x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("putDoubleOpaque", Object.class, long.class, double.class);
            m.invoke(inner, o, offset, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'putDoubleOpaque' reflectively", e);
        }
    }
    public void putLongOpaque(Object o, long offset, long x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("putLongOpaque", Object.class, long.class, long.class);
            m.invoke(inner, o, offset, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'putLongOpaque' reflectively", e);
        }
    }
    public void putIntOpaque(Object o, long offset, int x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("putIntOpaque", Object.class, long.class, int.class);
            m.invoke(inner, o, offset, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'putIntOpaque' reflectively", e);
        }
    }
    public void putFloatOpaque(Object o, long offset, float x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("putFloatOpaque", Object.class, long.class, float.class);
            m.invoke(inner, o, offset, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'putFloatOpaque' reflectively", e);
        }
    }
    public void putCharOpaque(Object o, long offset, char x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("putCharOpaque", Object.class, long.class, char.class);
            m.invoke(inner, o, offset, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'putCharOpaque' reflectively", e);
        }
    }
    public void putShortOpaque(Object o, long offset, short x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("putShortOpaque", Object.class, long.class, short.class);
            m.invoke(inner, o, offset, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'putShortOpaque' reflectively", e);
        }
    }
    public void putByteOpaque(Object o, long offset, byte x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("putByteOpaque", Object.class, long.class, byte.class);
            m.invoke(inner, o, offset, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'putByteOpaque' reflectively", e);
        }
    }
    public void putBooleanOpaque(Object o, long offset, boolean x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("putBooleanOpaque", Object.class, long.class, boolean.class);
            m.invoke(inner, o, offset, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'putBooleanOpaque' reflectively", e);
        }
    }

    public Object getReferenceOpaque(Object o, long offset) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getReferenceOpaque", Object.class, long.class);
            return m.invoke(inner, o, offset);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'getReferenceOpaque' reflectively", e);
        }
    }

    public double getDoubleOpaque(Object o, long offset) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getDoubleOpaque", Object.class, long.class);
            return (double) m.invoke(inner, o, offset);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getDoubleOpaque' reflectively", e);
        }
    }
    public long getLongOpaque(Object o, long offset) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getLongOpaque", Object.class, long.class);
            return (long) m.invoke(inner, o, offset);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getLongOpaque' reflectively", e);
        }
    }
    public int getIntOpaque(Object o, long offset) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getIntOpaque", Object.class, long.class);
            return (int) m.invoke(inner, o, offset);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getIntOpaque' reflectively", e);
        }
    }
    public float getFloatOpaque(Object o, long offset) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getFloatOpaque", Object.class, long.class);
            return (float) m.invoke(inner, o, offset);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getFloatOpaque' reflectively", e);
        }
    }
    public char getCharOpaque(Object o, long offset) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getCharOpaque", Object.class, long.class);
            return (char) m.invoke(inner, o, offset);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getCharOpaque' reflectively", e);
        }
    }
    public short getShortOpaque(Object o, long offset) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getShortOpaque", Object.class, long.class);
            return (short) m.invoke(inner, o, offset);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getShortOpaque' reflectively", e);
        }
    }
    public byte getByteOpaque(Object o, long offset) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getByteOpaque", Object.class, long.class);
            return (byte) m.invoke(inner, o, offset);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getByteOpaque' reflectively", e);
        }
    }
    public boolean getBooleanOpaque(Object o, long offset) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getBooleanOpaque", Object.class, long.class);
            return (boolean) m.invoke(inner, o, offset);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getBooleanOpaque' reflectively", e);
        }
    }

    public void park(boolean isAbsolute, long time) {
        try {
            Method m = inner.getClass().getDeclaredMethod("park", boolean.class, long.class);
            m.invoke(inner, isAbsolute, time);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'park' reflectively", e);
        }
    }
    public void unPark(Object thread) {
        try {
            Method m = inner.getClass().getDeclaredMethod("park", Object.class);
            m.invoke(inner, thread);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'park' reflectively", e);
        }
    }
    public int getLoadAverage(double[] loadavg, int nelems) {
        try {
            Method m = inner.getClass().getDeclaredMethod("park", double[].class, int.class);
            return (int) m.invoke(inner, loadavg, nelems);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'park' reflectively", e);
        }
    }

    public double getAndAddDouble(Object o, long offset, double delta) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndAddDouble", Object.class, long.class, double.class);
            return (double) m.invoke(inner, o, offset, delta);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'getAndAddDouble' reflectively", e);
        }
    }
    public double getAndAddDoubleRelease(Object o, long offset, double delta) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndAddDoubleRelease", Object.class, long.class, double.class);
            return (double) m.invoke(inner, o, offset, delta);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndAddDoubleRelease' reflectively", e);
        }
    }
    public double getAndAddDoubleAcquire(Object o, long offset, double delta) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndAddDoubleAcquire", Object.class, long.class, double.class);
            return (double) m.invoke(inner, o, offset, delta);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndAddDoubleAcquire' reflectively", e);
        }
    }
    public long getAndAddLong(Object o, long offset, long delta) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndAddLong", Object.class, long.class, long.class);
            return (long) m.invoke(inner, o, offset, delta);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'getAndAddLong' reflectively", e);
        }
    }
    public long getAndAddLongRelease(Object o, long offset, long delta) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndAddLongRelease", Object.class, long.class, long.class);
            return (long) m.invoke(inner, o, offset, delta);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndAddLongRelease' reflectively", e);
        }
    }
    public long getAndAddLongAcquire(Object o, long offset, long delta) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndAddLongAcquire", Object.class, long.class, long.class);
            return (long) m.invoke(inner, o, offset, delta);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndAddLongAcquire' reflectively", e);
        }
    }
    public int getAndAddInt(Object o, long offset, int delta) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndAddInt", Object.class, long.class, int.class);
            return (int) m.invoke(inner, o, offset, delta);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'getAndAddInt' reflectively", e);
        }
    }
    public int getAndAddIntRelease(Object o, long offset, int delta) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndAddIntRelease", Object.class, long.class, int.class);
            return (int) m.invoke(inner, o, offset, delta);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndAddIntRelease' reflectively", e);
        }
    }
    public int getAndAddIntAcquire(Object o, long offset, int delta) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndAddIntAcquire", Object.class, long.class, int.class);
            return (int) m.invoke(inner, o, offset, delta);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndAddIntAcquire' reflectively", e);
        }
    }
    public float getAndAddFloat(Object o, long offset, float delta) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndAddFloat", Object.class, long.class, float.class);
            return (float) m.invoke(inner, o, offset, delta);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'getAndAddFloat' reflectively", e);
        }
    }
    public float getAndAddFloatRelease(Object o, long offset, float delta) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndAddFloatRelease", Object.class, long.class, float.class);
            return (float) m.invoke(inner, o, offset, delta);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndAddFloatRelease' reflectively", e);
        }
    }
    public float getAndAddFloatAcquire(Object o, long offset, float delta) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndAddFloatAcquire", Object.class, long.class, float.class);
            return (float) m.invoke(inner, o, offset, delta);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndAddFloatAcquire' reflectively", e);
        }
    }
    public char getAndAddChar(Object o, long offset, char delta) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndAddChar", Object.class, long.class, char.class);
            return (char) m.invoke(inner, o, offset, delta);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'getAndAddChar' reflectively", e);
        }
    }
    public char getAndAddCharRelease(Object o, long offset, char delta) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndAddCharRelease", Object.class, long.class, char.class);
            return (char) m.invoke(inner, o, offset, delta);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndAddCharRelease' reflectively", e);
        }
    }
    public char getAndAddCharAcquire(Object o, long offset, char delta) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndAddCharAcquire", Object.class, long.class, char.class);
            return (char) m.invoke(inner, o, offset, delta);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndAddCharAcquire' reflectively", e);
        }
    }
    public short getAndAddShort(Object o, long offset, short delta) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndAddShort", Object.class, long.class, short.class);
            return (short) m.invoke(inner, o, offset, delta);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'getAndAddShort' reflectively", e);
        }
    }
    public short getAndAddShortRelease(Object o, long offset, short delta) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndAddShortRelease", Object.class, long.class, short.class);
            return (short) m.invoke(inner, o, offset, delta);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndAddShortRelease' reflectively", e);
        }
    }
    public short getAndAddShortAcquire(Object o, long offset, short delta) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndAddShortAcquire", Object.class, long.class, short.class);
            return (short) m.invoke(inner, o, offset, delta);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndAddShortAcquire' reflectively", e);
        }
    }
    public byte getAndAddByte(Object o, long offset, byte delta) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndAddByte", Object.class, long.class, byte.class);
            return (byte) m.invoke(inner, o, offset, delta);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'getAndAddByte' reflectively", e);
        }
    }
    public byte getAndAddByteRelease(Object o, long offset, byte delta) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndAddByteRelease", Object.class, long.class, byte.class);
            return (byte) m.invoke(inner, o, offset, delta);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndAddByteRelease' reflectively", e);
        }
    }
    public byte getAndAddByteAcquire(Object o, long offset, byte delta) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndAddByteAcquire", Object.class, long.class, byte.class);
            return (byte) m.invoke(inner, o, offset, delta);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndAddByteAcquire' reflectively", e);
        }
    }



    public Object getAndSetReference(Object o, long offset, Object newValue) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndSetReference", Object.class, long.class, Object.class);
            return m.invoke(inner, o, offset, newValue);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'getAndSetReference' reflectively", e);
        }
    }
    public Object getAndSetReferenceRelease(Object o, long offset, Object newValue) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndSetReferenceRelease", Object.class, long.class, Object.class);
            return m.invoke(inner, o, offset, newValue);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndSetReferenceRelease' reflectively", e);
        }
    }
    public Object getAndSetReferenceAcquire(Object o, long offset, Object newValue) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndSetReferenceAcquire", Object.class, long.class, Object.class);
            return m.invoke(inner, o, offset, newValue);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndSetReferenceAcquire' reflectively", e);
        }
    }

    public double getAndSetDouble(Object o, long offset, double newValue) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndSetDouble", Object.class, long.class, double.class);
            return (double) m.invoke(inner, o, offset, newValue);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'getAndSetDouble' reflectively", e);
        }
    }
    public double getAndSetDoubleRelease(Object o, long offset, double newValue) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndSetDoubleRelease", Object.class, long.class, double.class);
            return (double) m.invoke(inner, o, offset, newValue);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndSetDoubleRelease' reflectively", e);
        }
    }
    public double getAndSetDoubleAcquire(Object o, long offset, double newValue) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndSetDoubleAcquire", Object.class, long.class, double.class);
            return (double) m.invoke(inner, o, offset, newValue);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndSetDoubleAcquire' reflectively", e);
        }
    }
    public long getAndSetLong(Object o, long offset, long newValue) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndSetLong", Object.class, long.class, long.class);
            return (long) m.invoke(inner, o, offset, newValue);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'getAndSetLong' reflectively", e);
        }
    }
    public long getAndSetLongRelease(Object o, long offset, long newValue) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndSetLongRelease", Object.class, long.class, long.class);
            return (long) m.invoke(inner, o, offset, newValue);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndSetLongRelease' reflectively", e);
        }
    }
    public long getAndSetLongAcquire(Object o, long offset, long newValue) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndSetLongAcquire", Object.class, long.class, long.class);
            return (long) m.invoke(inner, o, offset, newValue);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndSetLongAcquire' reflectively", e);
        }
    }
    public int getAndSetInt(Object o, long offset, int newValue) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndSetInt", Object.class, long.class, int.class);
            return (int) m.invoke(inner, o, offset, newValue);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'getAndSetInt' reflectively", e);
        }
    }
    public int getAndSetIntRelease(Object o, long offset, int newValue) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndSetIntRelease", Object.class, long.class, int.class);
            return (int) m.invoke(inner, o, offset, newValue);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndSetIntRelease' reflectively", e);
        }
    }
    public int getAndSetIntAcquire(Object o, long offset, int newValue) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndSetIntAcquire", Object.class, long.class, int.class);
            return (int) m.invoke(inner, o, offset, newValue);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndSetIntAcquire' reflectively", e);
        }
    }
    public float getAndSetFloat(Object o, long offset, float newValue) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndSetFloat", Object.class, long.class, float.class);
            return (float) m.invoke(inner, o, offset, newValue);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'getAndSetFloat' reflectively", e);
        }
    }
    public float getAndSetFloatRelease(Object o, long offset, float newValue) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndSetFloatRelease", Object.class, long.class, float.class);
            return (float) m.invoke(inner, o, offset, newValue);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndSetFloatRelease' reflectively", e);
        }
    }
    public float getAndSetFloatAcquire(Object o, long offset, float newValue) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndSetFloatAcquire", Object.class, long.class, float.class);
            return (float) m.invoke(inner, o, offset, newValue);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndSetFloatAcquire' reflectively", e);
        }
    }
    public char getAndSetChar(Object o, long offset, char newValue) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndSetChar", Object.class, long.class, char.class);
            return (char) m.invoke(inner, o, offset, newValue);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'getAndSetChar' reflectively", e);
        }
    }
    public char getAndSetCharRelease(Object o, long offset, char newValue) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndSetCharRelease", Object.class, long.class, char.class);
            return (char) m.invoke(inner, o, offset, newValue);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndSetCharRelease' reflectively", e);
        }
    }
    public char getAndSetCharAcquire(Object o, long offset, char newValue) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndSetCharAcquire", Object.class, long.class, char.class);
            return (char) m.invoke(inner, o, offset, newValue);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndSetCharAcquire' reflectively", e);
        }
    }
    public short getAndSetShort(Object o, long offset, short newValue) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndSetShort", Object.class, long.class, short.class);
            return (short) m.invoke(inner, o, offset, newValue);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'getAndSetShort' reflectively", e);
        }
    }
    public short getAndSetShortRelease(Object o, long offset, short newValue) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndSetShortRelease", Object.class, long.class, short.class);
            return (short) m.invoke(inner, o, offset, newValue);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndSetShortRelease' reflectively", e);
        }
    }
    public short getAndSetShortAcquire(Object o, long offset, short newValue) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndSetShortAcquire", Object.class, long.class, short.class);
            return (short) m.invoke(inner, o, offset, newValue);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndSetShortAcquire' reflectively", e);
        }
    }
    public byte getAndSetByte(Object o, long offset, byte newValue) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndSetByte", Object.class, long.class, byte.class);
            return (byte) m.invoke(inner, o, offset, newValue);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'getAndSetByte' reflectively", e);
        }
    }
    public byte getAndSetByteRelease(Object o, long offset, byte newValue) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndSetByteRelease", Object.class, long.class, byte.class);
            return (byte) m.invoke(inner, o, offset, newValue);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndSetByteRelease' reflectively", e);
        }
    }
    public byte getAndSetByteAcquire(Object o, long offset, byte newValue) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndSetByteAcquire", Object.class, long.class, byte.class);
            return (byte) m.invoke(inner, o, offset, newValue);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndSetByteAcquire' reflectively", e);
        }
    }
    public boolean getAndSetBoolean(Object o, long offset, boolean newValue) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndSetBoolean", Object.class, long.class, boolean.class);
            return (boolean) m.invoke(inner, o, offset, newValue);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw  new RuntimeException("Failed to retrieve 'getAndSetBoolean' reflectively", e);
        }
    }
    public boolean getAndSetBooleanRelease(Object o, long offset, boolean newValue) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndSetBooleanRelease", Object.class, long.class, boolean.class);
            return (boolean) m.invoke(inner, o, offset, newValue);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndSetBooleanRelease' reflectively", e);
        }
    }
    public boolean getAndSetBooleanAcquire(Object o, long offset, boolean newValue) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndSetBooleanAcquire", Object.class, long.class, boolean.class);
            return (boolean) m.invoke(inner, o, offset, newValue);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndSetBooleanAcquire' reflectively", e);
        }
    }

    public long getAndBitwiseOrLong(Object o, long offset, long mask) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndBitwiseOrLong", Object.class, long.class, long.class);
            return (long) m.invoke(inner, o, offset, mask);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndBitwiseOrLong' reflectively", e);
        }
    }
    public long getAndBitwiseOrLongAcquire(Object o, long offset, long mask) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndBitwiseOrLongAcquire", Object.class, long.class, long.class);
            return (long) m.invoke(inner, o, offset, mask);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndBitwiseOrLongAcquire' reflectively", e);
        }
    }
    public long getAndBitwiseOrLongRelease(Object o, long offset, long mask) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndBitwiseOrLongRelease", Object.class, long.class, long.class);
            return (long) m.invoke(inner, o, offset, mask);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndBitwiseOrLongRelease' reflectively", e);
        }
    }
    public long getAndBitwiseAndLong(Object o, long offset, long mask) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndBitwiseAndLong", Object.class, long.class, long.class);
            return (long) m.invoke(inner, o, offset, mask);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndBitwiseAndLong' reflectively", e);
        }
    }
    public long getAndBitwiseAndLongRelease(Object o, long offset, long mask) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndBitwiseAndLongRelease", Object.class, long.class, long.class);
            return (long) m.invoke(inner, o, offset, mask);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndBitwiseAndLongRelease' reflectively", e);
        }
    }
    public long getAndBitwiseAndLongAcquire(Object o, long offset, long mask) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndBitwiseAndLongAcquire", Object.class, long.class, long.class);
            return (long) m.invoke(inner, o, offset, mask);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndBitwiseAndLongAcquire' reflectively", e);
        }
    }
    public long getAndBitwiseXorLong(Object o, long offset, long mask) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndBitwiseXorLong", Object.class, long.class, long.class);
            return (long) m.invoke(inner, o, offset, mask);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndBitwiseXorLong' reflectively", e);
        }
    }
    public long getAndBitwiseXorLongAcquire(Object o, long offset, long mask) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndBitwiseXorLongAcquire", Object.class, long.class, long.class);
            return (long) m.invoke(inner, o, offset, mask);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndBitwiseXorLongAcquire' reflectively", e);
        }
    }
    public long getAndBitwiseXorLongRelease(Object o, long offset, long mask) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndBitwiseXorLongRelease", Object.class, long.class, long.class);
            return (long) m.invoke(inner, o, offset, mask);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndBitwiseXorLongRelease' reflectively", e);
        }
    }
    public int getAndBitwiseOrInt(Object o, long offset, int mask) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndBitwiseOrInt", Object.class, long.class, int.class);
            return (int) m.invoke(inner, o, offset, mask);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndBitwiseOrInt' reflectively", e);
        }
    }
    public int getAndBitwiseOrIntAcquire(Object o, long offset, int mask) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndBitwiseOrIntAcquire", Object.class, long.class, int.class);
            return (int) m.invoke(inner, o, offset, mask);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndBitwiseOrIntAcquire' reflectively", e);
        }
    }
    public int getAndBitwiseOrIntRelease(Object o, long offset, int mask) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndBitwiseOrIntRelease", Object.class, long.class, int.class);
            return (int) m.invoke(inner, o, offset, mask);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndBitwiseOrIntRelease' reflectively", e);
        }
    }
    public int getAndBitwiseAndInt(Object o, long offset, int mask) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndBitwiseAndInt", Object.class, long.class, int.class);
            return (int) m.invoke(inner, o, offset, mask);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndBitwiseAndInt' reflectively", e);
        }
    }
    public int getAndBitwiseAndIntRelease(Object o, long offset, int mask) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndBitwiseAndIntRelease", Object.class, long.class, int.class);
            return (int) m.invoke(inner, o, offset, mask);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndBitwiseAndIntRelease' reflectively", e);
        }
    }
    public int getAndBitwiseAndIntAcquire(Object o, long offset, int mask) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndBitwiseAndIntAcquire", Object.class, long.class, int.class);
            return (int) m.invoke(inner, o, offset, mask);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndBitwiseAndIntAcquire' reflectively", e);
        }
    }
    public int getAndBitwiseXorInt(Object o, long offset, int mask) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndBitwiseXorInt", Object.class, long.class, int.class);
            return (int) m.invoke(inner, o, offset, mask);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndBitwiseXorInt' reflectively", e);
        }
    }
    public int getAndBitwiseXorIntAcquire(Object o, long offset, int mask) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndBitwiseXorIntAcquire", Object.class, long.class, int.class);
            return (int) m.invoke(inner, o, offset, mask);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndBitwiseXorIntAcquire' reflectively", e);
        }
    }
    public int getAndBitwiseXorIntRelease(Object o, long offset, int mask) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndBitwiseXorIntRelease", Object.class, long.class, int.class);
            return (int) m.invoke(inner, o, offset, mask);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndBitwiseXorIntRelease' reflectively", e);
        }
    }
    public char getAndBitwiseOrChar(Object o, long offset, char mask) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndBitwiseOrChar", Object.class, long.class, char.class);
            return (char) m.invoke(inner, o, offset, mask);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndBitwiseOrChar' reflectively", e);
        }
    }
    public char getAndBitwiseOrCharAcquire(Object o, long offset, char mask) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndBitwiseOrCharAcquire", Object.class, long.class, char.class);
            return (char) m.invoke(inner, o, offset, mask);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndBitwiseOrCharAcquire' reflectively", e);
        }
    }
    public char getAndBitwiseOrCharRelease(Object o, long offset, char mask) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndBitwiseOrCharRelease", Object.class, long.class, char.class);
            return (char) m.invoke(inner, o, offset, mask);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndBitwiseOrCharRelease' reflectively", e);
        }
    }
    public char getAndBitwiseAndChar(Object o, long offset, char mask) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndBitwiseAndChar", Object.class, long.class, char.class);
            return (char) m.invoke(inner, o, offset, mask);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndBitwiseAndChar' reflectively", e);
        }
    }
    public char getAndBitwiseAndCharRelease(Object o, long offset, char mask) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndBitwiseAndCharRelease", Object.class, long.class, char.class);
            return (char) m.invoke(inner, o, offset, mask);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndBitwiseAndCharRelease' reflectively", e);
        }
    }
    public char getAndBitwiseAndCharAcquire(Object o, long offset, char mask) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndBitwiseAndCharAcquire", Object.class, long.class, char.class);
            return (char) m.invoke(inner, o, offset, mask);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndBitwiseAndCharAcquire' reflectively", e);
        }
    }
    public char getAndBitwiseXorChar(Object o, long offset, char mask) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndBitwiseXorChar", Object.class, long.class, char.class);
            return (char) m.invoke(inner, o, offset, mask);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndBitwiseXorChar' reflectively", e);
        }
    }
    public char getAndBitwiseXorCharAcquire(Object o, long offset, char mask) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndBitwiseXorCharAcquire", Object.class, long.class, char.class);
            return (char) m.invoke(inner, o, offset, mask);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndBitwiseXorCharAcquire' reflectively", e);
        }
    }
    public char getAndBitwiseXorCharRelease(Object o, long offset, char mask) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndBitwiseXorCharRelease", Object.class, long.class, char.class);
            return (char) m.invoke(inner, o, offset, mask);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndBitwiseXorCharRelease' reflectively", e);
        }
    }
    public short getAndBitwiseOrShort(Object o, long offset, short mask) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndBitwiseOrShort", Object.class, long.class, short.class);
            return (short) m.invoke(inner, o, offset, mask);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndBitwiseOrShort' reflectively", e);
        }
    }
    public short getAndBitwiseOrShortAcquire(Object o, long offset, short mask) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndBitwiseOrShortAcquire", Object.class, long.class, short.class);
            return (short) m.invoke(inner, o, offset, mask);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndBitwiseOrShortAcquire' reflectively", e);
        }
    }
    public short getAndBitwiseOrShortRelease(Object o, long offset, short mask) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndBitwiseOrShortRelease", Object.class, long.class, short.class);
            return (short) m.invoke(inner, o, offset, mask);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndBitwiseOrShortRelease' reflectively", e);
        }
    }
    public short getAndBitwiseAndShort(Object o, long offset, short mask) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndBitwiseAndShort", Object.class, long.class, short.class);
            return (short) m.invoke(inner, o, offset, mask);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndBitwiseAndShort' reflectively", e);
        }
    }
    public short getAndBitwiseAndShortRelease(Object o, long offset, short mask) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndBitwiseAndShortRelease", Object.class, long.class, short.class);
            return (short) m.invoke(inner, o, offset, mask);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndBitwiseAndShortRelease' reflectively", e);
        }
    }
    public short getAndBitwiseAndShortAcquire(Object o, long offset, short mask) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndBitwiseAndShortAcquire", Object.class, long.class, short.class);
            return (short) m.invoke(inner, o, offset, mask);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndBitwiseAndShortAcquire' reflectively", e);
        }
    }
    public short getAndBitwiseXorShort(Object o, long offset, short mask) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndBitwiseXorShort", Object.class, long.class, short.class);
            return (short) m.invoke(inner, o, offset, mask);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndBitwiseXorShort' reflectively", e);
        }
    }
    public short getAndBitwiseXorShortAcquire(Object o, long offset, short mask) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndBitwiseXorShortAcquire", Object.class, long.class, short.class);
            return (short) m.invoke(inner, o, offset, mask);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndBitwiseXorShortAcquire' reflectively", e);
        }
    }
    public short getAndBitwiseXorShortRelease(Object o, long offset, short mask) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndBitwiseXorShortRelease", Object.class, long.class, short.class);
            return (short) m.invoke(inner, o, offset, mask);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndBitwiseXorShortRelease' reflectively", e);
        }
    }
    public byte getAndBitwiseOrByte(Object o, long offset, byte mask) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndBitwiseOrByte", Object.class, long.class, byte.class);
            return (byte) m.invoke(inner, o, offset, mask);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndBitwiseOrByte' reflectively", e);
        }
    }
    public byte getAndBitwiseOrByteAcquire(Object o, long offset, byte mask) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndBitwiseOrByteAcquire", Object.class, long.class, byte.class);
            return (byte) m.invoke(inner, o, offset, mask);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndBitwiseOrByteAcquire' reflectively", e);
        }
    }
    public byte getAndBitwiseOrByteRelease(Object o, long offset, byte mask) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndBitwiseOrByteRelease", Object.class, long.class, byte.class);
            return (byte) m.invoke(inner, o, offset, mask);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndBitwiseOrByteRelease' reflectively", e);
        }
    }
    public byte getAndBitwiseAndByte(Object o, long offset, byte mask) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndBitwiseAndByte", Object.class, long.class, byte.class);
            return (byte) m.invoke(inner, o, offset, mask);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndBitwiseAndByte' reflectively", e);
        }
    }
    public byte getAndBitwiseAndByteRelease(Object o, long offset, byte mask) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndBitwiseAndByteRelease", Object.class, long.class, byte.class);
            return (byte) m.invoke(inner, o, offset, mask);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndBitwiseAndByteRelease' reflectively", e);
        }
    }
    public byte getAndBitwiseAndByteAcquire(Object o, long offset, byte mask) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndBitwiseAndByteAcquire", Object.class, long.class, byte.class);
            return (byte) m.invoke(inner, o, offset, mask);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndBitwiseAndByteAcquire' reflectively", e);
        }
    }
    public byte getAndBitwiseXorByte(Object o, long offset, byte mask) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndBitwiseXorByte", Object.class, long.class, byte.class);
            return (byte) m.invoke(inner, o, offset, mask);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndBitwiseXorByte' reflectively", e);
        }
    }
    public byte getAndBitwiseXorByteAcquire(Object o, long offset, byte mask) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndBitwiseXorByteAcquire", Object.class, long.class, byte.class);
            return (byte) m.invoke(inner, o, offset, mask);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndBitwiseXorByteAcquire' reflectively", e);
        }
    }
    public byte getAndBitwiseXorByteRelease(Object o, long offset, byte mask) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndBitwiseXorByteRelease", Object.class, long.class, byte.class);
            return (byte) m.invoke(inner, o, offset, mask);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndBitwiseXorByteRelease' reflectively", e);
        }
    }
    public boolean getAndBitwiseOrBoolean(Object o, long offset, boolean mask) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndBitwiseOrBoolean", Object.class, long.class, boolean.class);
            return (boolean) m.invoke(inner, o, offset, mask);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndBitwiseOrBoolean' reflectively", e);
        }
    }
    public boolean getAndBitwiseOrBooleanAcquire(Object o, long offset, boolean mask) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndBitwiseOrBooleanAcquire", Object.class, long.class, boolean.class);
            return (boolean) m.invoke(inner, o, offset, mask);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndBitwiseOrBooleanAcquire' reflectively", e);
        }
    }
    public boolean getAndBitwiseOrBooleanRelease(Object o, long offset, boolean mask) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndBitwiseOrBooleanRelease", Object.class, long.class, boolean.class);
            return (boolean) m.invoke(inner, o, offset, mask);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndBitwiseOrBooleanRelease' reflectively", e);
        }
    }
    public boolean getAndBitwiseAndBoolean(Object o, long offset, boolean mask) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndBitwiseAndBoolean", Object.class, long.class, boolean.class);
            return (boolean) m.invoke(inner, o, offset, mask);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndBitwiseAndBoolean' reflectively", e);
        }
    }
    public boolean getAndBitwiseAndBooleanRelease(Object o, long offset, boolean mask) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndBitwiseAndBooleanRelease", Object.class, long.class, boolean.class);
            return (boolean) m.invoke(inner, o, offset, mask);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndBitwiseAndBooleanRelease' reflectively", e);
        }
    }
    public boolean getAndBitwiseAndBooleanAcquire(Object o, long offset, boolean mask) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndBitwiseAndBooleanAcquire", Object.class, long.class, boolean.class);
            return (boolean) m.invoke(inner, o, offset, mask);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndBitwiseAndBooleanAcquire' reflectively", e);
        }
    }
    public boolean getAndBitwiseXorBoolean(Object o, long offset, boolean mask) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndBitwiseXorBoolean", Object.class, long.class, boolean.class);
            return (boolean) m.invoke(inner, o, offset, mask);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndBitwiseXorBoolean' reflectively", e);
        }
    }
    public boolean getAndBitwiseXorBooleanAcquire(Object o, long offset, boolean mask) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndBitwiseXorBooleanAcquire", Object.class, long.class, boolean.class);
            return (boolean) m.invoke(inner, o, offset, mask);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndBitwiseXorBooleanAcquire' reflectively", e);
        }
    }
    public boolean getAndBitwiseXorBooleanRelease(Object o, long offset, boolean mask) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getAndBitwiseXorBooleanRelease", Object.class, long.class, boolean.class);
            return (boolean) m.invoke(inner, o, offset, mask);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getAndBitwiseXorBooleanRelease' reflectively", e);
        }
    }

    public void loadFence() {
        try {
            Method m = inner.getClass().getDeclaredMethod("loadFence");
            m.invoke(inner);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'loadFence' reflectively", e);
        }
    }
    public void storeFence() {
        try {
            Method m = inner.getClass().getDeclaredMethod("storeFence");
            m.invoke(inner);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'storeFence' reflectively", e);
        }
    }
    public void fullFence() {
        try {
            Method m = inner.getClass().getDeclaredMethod("fullFence");
            m.invoke(inner);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'fullFence' reflectively", e);
        }
    }
    public void loadLoadFence() {
        try {
            Method m = inner.getClass().getDeclaredMethod("loadLoadFence");
            m.invoke(inner);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'loadLoadFence' reflectively", e);
        }
    }
    public void storeStoreFence() {
        try {
            Method m = inner.getClass().getDeclaredMethod("storeStoreFence");
            m.invoke(inner);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'storeStoreFence' reflectively", e);
        }
    }

    public boolean isBigEndian() {
        try {
            Method m = inner.getClass().getDeclaredMethod("isBigEndian");
            return (boolean) m.invoke(inner);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'isBigEndian' reflectively", e);
        }
    }

    public boolean unalignedAccess() {
        try {
            Method m = inner.getClass().getDeclaredMethod("unalignedAccess");
            return (boolean) m.invoke(inner);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'unalignedAccess' reflectively", e);
        }
    }

    public long getLongUnaligned(Object o, long offset) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getLongUnaligned", Object.class, long.class);
            return (long) m.invoke(inner, o, offset);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getLongUnaligned' reflectively", e);
        }
    }
    public long getLongUnaligned(Object o, long offset, boolean bigEndian) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getLongUnaligned", Object.class, long.class, boolean.class);
            return (long) m.invoke(inner, o, offset, bigEndian);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getLongUnaligned' reflectively", e);
        }
    }
    public void putLongUnaligned(Object o, long offset, long x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("putLongUnaligned", Object.class, long.class, long.class);
            m.invoke(inner, o, offset, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'putLongUnaligned' reflectively", e);
        }
    }
    public void putLongUnaligned(Object o, long offset, long x, boolean bigEndian) {
        try {
            Method m = inner.getClass().getDeclaredMethod("putLongUnaligned", Object.class, long.class, long.class, boolean.class);
            m.invoke(inner, o, offset, x, bigEndian);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'putLongUnaligned' reflectively", e);
        }
    }
    public int getIntUnaligned(Object o, long offset) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getIntUnaligned", Object.class, long.class);
            return (int) m.invoke(inner, o, offset);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getIntUnaligned' reflectively", e);
        }
    }
    public int getIntUnaligned(Object o, long offset, boolean bigEndian) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getIntUnaligned", Object.class, long.class, boolean.class);
            return (int) m.invoke(inner, o, offset, bigEndian);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getIntUnaligned' reflectively", e);
        }
    }
    public void putIntUnaligned(Object o, long offset, int x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("putIntUnaligned", Object.class, long.class, int.class);
            m.invoke(inner, o, offset, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'putIntUnaligned' reflectively", e);
        }
    }
    public void putIntUnaligned(Object o, long offset, int x, boolean bigEndian) {
        try {
            Method m = inner.getClass().getDeclaredMethod("putIntUnaligned", Object.class, long.class, int.class, boolean.class);
            m.invoke(inner, o, offset, x, bigEndian);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'putIntUnaligned' reflectively", e);
        }
    }
    public char getCharUnaligned(Object o, long offset) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getCharUnaligned", Object.class, long.class);
            return (char) m.invoke(inner, o, offset);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getCharUnaligned' reflectively", e);
        }
    }
    public char getCharUnaligned(Object o, long offset, boolean bigEndian) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getCharUnaligned", Object.class, long.class, boolean.class);
            return (char) m.invoke(inner, o, offset, bigEndian);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getCharUnaligned' reflectively", e);
        }
    }
    public void putCharUnaligned(Object o, long offset, char x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("putCharUnaligned", Object.class, long.class, char.class);
            m.invoke(inner, o, offset, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'putCharUnaligned' reflectively", e);
        }
    }
    public void putCharUnaligned(Object o, long offset, char x, boolean bigEndian) {
        try {
            Method m = inner.getClass().getDeclaredMethod("putCharUnaligned", Object.class, long.class, char.class, boolean.class);
            m.invoke(inner, o, offset, x, bigEndian);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'putCharUnaligned' reflectively", e);
        }
    }
    public short getShortUnaligned(Object o, long offset) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getShortUnaligned", Object.class, long.class);
            return (short) m.invoke(inner, o, offset);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getShortUnaligned' reflectively", e);
        }
    }
    public short getShortUnaligned(Object o, long offset, boolean bigEndian) {
        try {
            Method m = inner.getClass().getDeclaredMethod("getShortUnaligned", Object.class, long.class, boolean.class);
            return (short) m.invoke(inner, o, offset, bigEndian);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'getShortUnaligned' reflectively", e);
        }
    }
    public void putShortUnaligned(Object o, long offset, short x) {
        try {
            Method m = inner.getClass().getDeclaredMethod("putShortUnaligned", Object.class, long.class, short.class);
            m.invoke(inner, o, offset, x);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'putShortUnaligned' reflectively", e);
        }
    }
    public void putShortUnaligned(Object o, long offset, short x, boolean bigEndian) {
        try {
            Method m = inner.getClass().getDeclaredMethod("putShortUnaligned", Object.class, long.class, short.class, boolean.class);
            m.invoke(inner, o, offset, x, bigEndian);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'putShortUnaligned' reflectively", e);
        }
    }

    public void invokeCleaner(java.nio.ByteBuffer directBuffer) {
        try {
            Method m = inner.getClass().getDeclaredMethod("invokeCleaner", java.nio.ByteBuffer.class);
            m.invoke(inner, directBuffer);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve 'invokeCleaner' reflectively", e);
        }
    }

    private final Object inner;

}
