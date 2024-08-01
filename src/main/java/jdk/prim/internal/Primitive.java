package jdk.prim.internal;

/**
 * Gives you control over how a cast may be done
 * 
 * @param <BOX> the wra
 */
public interface Primitive<BOX> {
    /**
     * Creates and returns a wrapper version of this primitive or the object that defines the generic that is the wrapper for this primitive.
     * <p>
     * This is analogous to {@link java.util.stream.DoubleStream#boxed() DoubleStream.boxed()}
     * @return the wrapper for this primitive or the object that defines the generic that is the wrapper for this primitive.
     */
    BOX wrap();
    /**
     * Defines the conversion of a {@code long} to a {@code double}
     * @param p the value to be converted
     * @return the {@code double} equivalent of the input
     */
    default double asDouble(long p) { return p; }
    /**
     * Defines the conversion of an {@code int} to a {@code double}
     * @param p the value to be converted
     * @return the {@code double} equivalent of the input
     */
    default double asDouble(int p) { return p; }
    /**
     * Defines the conversion of a {@code float} to a {@code double}
     * @param p the value to be converted
     * @return the {@code double} equivalent of the input
     */
    default double asDouble(float p) { return p; }
    /**
     * Defines the conversion of a {@code char} to a {@code double}
     * @param p the value to be converted
     * @return the {@code double} equivalent of the input
     */
    default double asDouble(char p) { return p; }
    /**
     * Defines the conversion of a {@code short} to a {@code double}
     * @param p the value to be converted
     * @return the {@code double} equivalent of the input
     */
    default double asDouble(short p) { return p; }
    /**
     * Defines the conversion of a {@code byte} to a {@code double}
     * @param p the value to be converted
     * @return the {@code double} equivalent of the input
     */
    default double asDouble(byte p) { return p; }
    /**
     * Defines the conversion of a {@code boolean} to a {@code double}
     * @param p the value to be converted
     * @return the {@code double} equivalent of the input
     */
    default double asDouble(boolean p) { return p ? 1 : 0; }
    /**
     * Defines the conversion of a {@code long} to a {@code long}
     * @param p the value to be converted
     * @return the {@code long} equivalent of the input
     */
    default long asLong(double p) { return (long) p; }
    /**
     * Defines the conversion of an {@code int} to a {@code long}
     * @param p the value to be converted
     * @return the {@code long} equivalent of the input
     */
    default long asLong(int p) { return p; }
    /**
     * Defines the conversion of a {@code float} to a {@code long}
     * @param p the value to be converted
     * @return the {@code long} equivalent of the input
     */
    default long asLong(float p) { return (long) p; }
    /**
     * Defines the conversion of a {@code char} to a {@code long}
     * @param p the value to be converted
     * @return the {@code long} equivalent of the input
     */
    default long asLong(char p) { return p; }
    /**
     * Defines the conversion of a {@code short} to a {@code long}
     * @param p the value to be converted
     * @return the {@code long} equivalent of the input
     */
    default long asLong(short p) { return p; }
    /**
     * Defines the conversion of a {@code byte} to a {@code long}
     * @param p the value to be converted
     * @return the {@code long} equivalent of the input
     */
    default long asLong(byte p) { return p; }
    /**
     * Defines the conversion of a {@code boolean} to a {@code long}
     * @param p the value to be converted
     * @return the {@code long} equivalent of the input
     */
    default long asLong(boolean p) { return p ? 1 : 0; }
    /**
     * Defines the conversion of a {@code long} to a {@code int}
     * @param p the value to be converted
     * @return the {@code int} equivalent of the input
     */
    default int asInt(double p) { return (int) p; }
    /**
     * Defines the conversion of an {@code int} to a {@code int}
     * @param p the value to be converted
     * @return the {@code int} equivalent of the input
     */
    default int asInt(long p) { return (int) p; }
    /**
     * Defines the conversion of a {@code float} to a {@code int}
     * @param p the value to be converted
     * @return the {@code int} equivalent of the input
     */
    default int asInt(float p) { return (int) p; }
    /**
     * Defines the conversion of a {@code char} to a {@code int}
     * @param p the value to be converted
     * @return the {@code int} equivalent of the input
     */
    default int asInt(char p) { return p; }
    /**
     * Defines the conversion of a {@code short} to a {@code int}
     * @param p the value to be converted
     * @return the {@code int} equivalent of the input
     */
    default int asInt(short p) { return p; }
    /**
     * Defines the conversion of a {@code byte} to a {@code int}
     * @param p the value to be converted
     * @return the {@code int} equivalent of the input
     */
    default int asInt(byte p) { return p; }
    /**
     * Defines the conversion of a {@code boolean} to a {@code int}
     * @param p the value to be converted
     * @return the {@code int} equivalent of the input
     */
    default int asInt(boolean p) { return p ? 1 : 0; }
    /**
     * Defines the conversion of a {@code long} to a {@code float}
     * @param p the value to be converted
     * @return the {@code float} equivalent of the input
     */
    default float asFloat(double p) { return (float) p; }
    /**
     * Defines the conversion of an {@code int} to a {@code float}
     * @param p the value to be converted
     * @return the {@code float} equivalent of the input
     */
    default float asFloat(long p) { return p; }
    /**
     * Defines the conversion of a {@code float} to a {@code float}
     * @param p the value to be converted
     * @return the {@code float} equivalent of the input
     */
    default float asFloat(int p) { return p; }
    /**
     * Defines the conversion of a {@code char} to a {@code float}
     * @param p the value to be converted
     * @return the {@code float} equivalent of the input
     */
    default float asFloat(char p) { return p; }
    /**
     * Defines the conversion of a {@code short} to a {@code float}
     * @param p the value to be converted
     * @return the {@code float} equivalent of the input
     */
    default float asFloat(short p) { return p; }
    /**
     * Defines the conversion of a {@code byte} to a {@code float}
     * @param p the value to be converted
     * @return the {@code float} equivalent of the input
     */
    default float asFloat(byte p) { return p; }
    /**
     * Defines the conversion of a {@code boolean} to a {@code float}
     * @param p the value to be converted
     * @return the {@code float} equivalent of the input
     */
    default float asFloat(boolean p) { return p ? 1 : 0; }
    /**
     * Defines the conversion of a {@code long} to a {@code char}
     * @param p the value to be converted
     * @return the {@code char} equivalent of the input
     */
    default char asChar(double p) { return (char) p; }
    /**
     * Defines the conversion of an {@code int} to a {@code char}
     * @param p the value to be converted
     * @return the {@code char} equivalent of the input
     */
    default char asChar(long p) { return (char) p; }
    /**
     * Defines the conversion of a {@code float} to a {@code char}
     * @param p the value to be converted
     * @return the {@code char} equivalent of the input
     */
    default char asChar(int p) { return (char) p; }
    /**
     * Defines the conversion of a {@code char} to a {@code char}
     * @param p the value to be converted
     * @return the {@code char} equivalent of the input
     */
    default char asChar(float p) { return (char) p; }
    /**
     * Defines the conversion of a {@code short} to a {@code char}
     * @param p the value to be converted
     * @return the {@code char} equivalent of the input
     */
    default char asChar(short p) { return (char) p; }
    /**
     * Defines the conversion of a {@code byte} to a {@code char}
     * @param p the value to be converted
     * @return the {@code char} equivalent of the input
     */
    default char asChar(byte p) { return (char) p; }
    /**
     * Defines the conversion of a {@code boolean} to a {@code char}
     * @param p the value to be converted
     * @return the {@code char} equivalent of the input
     */
    default char asChar(boolean p) { return (char) (p ? 1 : 0); }
    /**
     * Defines the conversion of a {@code long} to a {@code short}
     * @param p the value to be converted
     * @return the {@code short} equivalent of the input
     */
    default short asShort(double p) { return (short) p; }
    /**
     * Defines the conversion of an {@code int} to a {@code short}
     * @param p the value to be converted
     * @return the {@code short} equivalent of the input
     */
    default short asShort(long p) { return (short) p; }
    /**
     * Defines the conversion of a {@code float} to a {@code short}
     * @param p the value to be converted
     * @return the {@code short} equivalent of the input
     */
    default short asShort(int p) { return (short) p; }
    /**
     * Defines the conversion of a {@code char} to a {@code short}
     * @param p the value to be converted
     * @return the {@code short} equivalent of the input
     */
    default short asShort(float p) { return (short) p; }
    /**
     * Defines the conversion of a {@code short} to a {@code short}
     * @param p the value to be converted
     * @return the {@code short} equivalent of the input
     */
    default short asShort(char p) { return (short) p; }
    /**
     * Defines the conversion of a {@code byte} to a {@code short}
     * @param p the value to be converted
     * @return the {@code short} equivalent of the input
     */
    default short asShort(byte p) { return (short) p; }
    /**
     * Defines the conversion of a {@code boolean} to a {@code short}
     * @param p the value to be converted
     * @return the {@code short} equivalent of the input
     */
    default short asShort(boolean p) { return (short) (p ? 1 : 0); }
    /**
     * Defines the conversion of a {@code long} to a {@code byte}
     * @param p the value to be converted
     * @return the {@code byte} equivalent of the input
     */
    default byte asByte(double p) { return (byte) p; }
    /**
     * Defines the conversion of an {@code int} to a {@code byte}
     * @param p the value to be converted
     * @return the {@code byte} equivalent of the input
     */
    default byte asByte(long p) { return (byte) p; }
    /**
     * Defines the conversion of a {@code float} to a {@code byte}
     * @param p the value to be converted
     * @return the {@code byte} equivalent of the input
     */
    default byte asByte(int p) { return (byte) p; }
    /**
     * Defines the conversion of a {@code char} to a {@code byte}
     * @param p the value to be converted
     * @return the {@code byte} equivalent of the input
     */
    default byte asByte(float p) { return (byte) p; }
    /**
     * Defines the conversion of a {@code short} to a {@code byte}
     * @param p the value to be converted
     * @return the {@code byte} equivalent of the input
     */
    default byte asByte(char p) { return (byte) p; }
    /**
     * Defines the conversion of a {@code byte} to a {@code byte}
     * @param p the value to be converted
     * @return the {@code byte} equivalent of the input
     */
    default byte asByte(short p) { return (byte) p; }
    /**
     * Defines the conversion of a {@code boolean} to a {@code byte}
     * @param p the value to be converted
     * @return the {@code byte} equivalent of the input
     */
    default byte asByte(boolean p) { return (byte) (p ? 1 : 0); }
    /**
     * Defines the conversion of a {@code long} to a {@code boolean}
     * @param p the value to be converted
     * @return the {@code boolean} equivalent of the input
     */
    default boolean asBoolean(double p) { return p != 0; }
    /**
     * Defines the conversion of an {@code int} to a {@code boolean}
     * @param p the value to be converted
     * @return the {@code boolean} equivalent of the input
     */
    default boolean asBoolean(long p) { return p != 0; }
    /**
     * Defines the conversion of a {@code float} to a {@code boolean}
     * @param p the value to be converted
     * @return the {@code boolean} equivalent of the input
     */
    default boolean asBoolean(int p) { return p != 0; }
    /**
     * Defines the conversion of a {@code char} to a {@code boolean}
     * @param p the value to be converted
     * @return the {@code boolean} equivalent of the input
     */
    default boolean asBoolean(float p) { return p != 0; }
    /**
     * Defines the conversion of a {@code short} to a {@code boolean}
     * @param p the value to be converted
     * @return the {@code boolean} equivalent of the input
     */
    default boolean asBoolean(char p) { return p != 0; }
    /**
     * Defines the conversion of a {@code byte} to a {@code boolean}
     * @param p the value to be converted
     * @return the {@code boolean} equivalent of the input
     */
    default boolean asBoolean(short p) { return p != 0; }
    /**
     * Defines the conversion of a {@code boolean} to a {@code boolean}
     * @param p the value to be converted
     * @return the {@code boolean} equivalent of the input
     */
    default boolean asBoolean(byte p) { return p != 0; }
}
