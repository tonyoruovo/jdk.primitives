package jdk.prim.util.map;

import java.util.Map;

import jdk.prim.Boxed;
import jdk.prim.util.function.PrimitiveFunction;

public interface PrimitiveEntry<K, V> extends Map.Entry<K, V>, Boxed<Map.Entry<K, V>> {

    interface OfDouble<V> extends PrimitiveEntry<java.lang.Double, V> {
        @Override
        default Map.Entry<java.lang.Double, V> boxed() { return this; }
        default OfDouble<V> mapToDoubleKey(PrimitiveFunction.ToDouble.OfDouble mapper) {
            if(mapper == null) throw new NullPointerException();
            PrimitiveEntry.OfDouble<V> thisEnt = this;
            return new OfDouble<V>() {
                public boolean equals(Object o) { return thisEnt.equals(o); }
                public int hashCode() { return thisEnt.hashCode(); }
                public double getKeyDouble() { return mapper.applyDouble(thisEnt.getKeyDouble()); }
                public V getValue() { return thisEnt.getValue(); }
                public V setValue(V v) { return thisEnt.setValue(v); }
            };
        }
        default OfLong<V> mapToLongKey(PrimitiveFunction.ToLong.OfDouble mapper) {
            if(mapper == null) throw new NullPointerException();
            return new OfLong<V>() {
                public boolean equals(Object o) { return OfDouble.this.equals(o); }
                public int hashCode() { return OfDouble.this.hashCode(); }
                public long getKeyLong() { return mapper.applyLong(OfDouble.this.getKeyDouble()); }
                public V getValue() { return OfDouble.this.getValue(); }
                public V setValue(V v) { return OfDouble.this.setValue(v); }
            };
        }
        default OfInt<V> mapToIntKey(PrimitiveFunction.ToInt.OfDouble mapper) {
            if(mapper == null) throw new NullPointerException();
            return new OfInt<V>() {
                public boolean equals(Object o) { return OfDouble.this.equals(o); }
                public int hashCode() { return OfDouble.this.hashCode(); }
                public int getKeyInt() { return mapper.applyInt(OfDouble.this.getKeyDouble()); }
                public V getValue() { return OfDouble.this.getValue(); }
                public V setValue(V v) { return OfDouble.this.setValue(v); }
            };
        }
        default OfFloat<V> mapToFloatKey(PrimitiveFunction.ToFloat.OfDouble mapper) {
            if(mapper == null) throw new NullPointerException();
            return new OfFloat<V>() {
                public boolean equals(Object o) { return OfDouble.this.equals(o); }
                public int hashCode() { return OfDouble.this.hashCode(); }
                public float getKeyFloat() { return mapper.applyFloat(OfDouble.this.getKeyDouble()); }
                public V getValue() { return OfDouble.this.getValue(); }
                public V setValue(V v) { return OfDouble.this.setValue(v); }
            };
        }
        default OfChar<V> mapToCharKey(PrimitiveFunction.ToChar.OfDouble mapper) {
            if(mapper == null) throw new NullPointerException();
            return new OfChar<V>() {
                public boolean equals(Object o) { return OfDouble.this.equals(o); }
                public int hashCode() { return OfDouble.this.hashCode(); }
                public char getKeyChar() { return mapper.applyChar(OfDouble.this.getKeyDouble()); }
                public V getValue() { return OfDouble.this.getValue(); }
                public V setValue(V v) { return OfDouble.this.setValue(v); }
            };
        }
        default OfShort<V> mapToShortKey(PrimitiveFunction.ToShort.OfDouble mapper) {
            if(mapper == null) throw new NullPointerException();
            return new OfShort<V>() {
                public boolean equals(Object o) { return OfDouble.this.equals(o); }
                public int hashCode() { return OfDouble.this.hashCode(); }
                public short getKeyShort() { return mapper.applyShort(OfDouble.this.getKeyDouble()); }
                public V getValue() { return OfDouble.this.getValue(); }
                public V setValue(V v) { return OfDouble.this.setValue(v); }
            };
        }
        default OfByte<V> mapToByteKey(PrimitiveFunction.ToByte.OfDouble mapper) {
            if(mapper == null) throw new NullPointerException();
            return new OfByte<V>() {
                public boolean equals(Object o) { return OfDouble.this.equals(o); }
                public int hashCode() { return OfDouble.this.hashCode(); }
                public byte getKeyByte() { return mapper.applyByte(OfDouble.this.getKeyDouble()); }
                public V getValue() { return OfDouble.this.getValue(); }
                public V setValue(V v) { return OfDouble.this.setValue(v); }
            };
        }
        default OfBoolean<V> mapToBooleanKey(PrimitiveFunction.ToBoolean.OfDouble mapper) {
            if(mapper == null) throw new NullPointerException();
            return new OfBoolean<V>() {
                public boolean equals(Object o) { return OfDouble.this.equals(o); }
                public int hashCode() { return OfDouble.this.hashCode(); }
                public boolean getKeyBoolean() { return mapper.applyBoolean(OfDouble.this.getKeyDouble()); }
                public V getValue() { return OfDouble.this.getValue(); }
                public V setValue(V v) { return OfDouble.this.setValue(v); }
            };
        }
        @Override default java.lang.Double getKey() { return OfDouble.this.getKeyDouble(); }
        double getKeyDouble();
        interface AndDouble extends OfDouble<java.lang.Double> {
            @Override default java.lang.Double getValue() { return getValueDouble(); }
            @Override default java.lang.Double setValue(java.lang.Double v) { return setValueDouble(v); }
            @Override default PrimitiveEntry.OfDouble.AndDouble mapToDoubleKey(PrimitiveFunction.ToDouble.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfDouble.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfDouble.AndDouble.this.setValueDouble(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfDouble.AndDouble.this.getKeyDouble()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndDouble mapToLongKey(PrimitiveFunction.ToLong.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfDouble.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfDouble.AndDouble.this.setValueDouble(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfDouble.AndDouble.this.getKeyDouble()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndDouble mapToIntKey(PrimitiveFunction.ToInt.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfDouble.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfDouble.AndDouble.this.setValueDouble(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfDouble.AndDouble.this.getKeyDouble()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndDouble mapToFloatKey(PrimitiveFunction.ToFloat.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfDouble.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfDouble.AndDouble.this.setValueDouble(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfDouble.AndDouble.this.getKeyDouble()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndDouble mapToCharKey(PrimitiveFunction.ToChar.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfDouble.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfDouble.AndDouble.this.setValueDouble(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfDouble.AndDouble.this.getKeyDouble()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndDouble mapToShortKey(PrimitiveFunction.ToShort.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfDouble.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfDouble.AndDouble.this.setValueDouble(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfDouble.AndDouble.this.getKeyDouble()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndDouble mapToByteKey(PrimitiveFunction.ToByte.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfDouble.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfDouble.AndDouble.this.setValueDouble(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfDouble.AndDouble.this.getKeyDouble()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndDouble mapToBooleanKey(PrimitiveFunction.ToBoolean.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfDouble.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfDouble.AndDouble.this.setValueDouble(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfDouble.AndDouble.this.getKeyDouble()); }
                };
            }
            default PrimitiveEntry.OfDouble.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfDouble mapper, PrimitiveFunction.ToDouble.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndDouble() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndDouble.this.getKeyDouble(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfDouble.AndDouble.this.getValueDouble()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfDouble.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            default PrimitiveEntry.OfDouble.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfDouble mapper, PrimitiveFunction.ToDouble.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndLong() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndDouble.this.getKeyDouble(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfDouble.AndDouble.this.getValueDouble()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfDouble.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            default PrimitiveEntry.OfDouble.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfDouble mapper, PrimitiveFunction.ToDouble.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndInt() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndDouble.this.getKeyDouble(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfDouble.AndDouble.this.getValueDouble()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfDouble.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            default PrimitiveEntry.OfDouble.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfDouble mapper, PrimitiveFunction.ToDouble.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndFloat() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndDouble.this.getKeyDouble(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfDouble.AndDouble.this.getValueDouble()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfDouble.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            default PrimitiveEntry.OfDouble.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfDouble mapper, PrimitiveFunction.ToDouble.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndChar() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndDouble.this.getKeyDouble(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfDouble.AndDouble.this.getValueDouble()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfDouble.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            default PrimitiveEntry.OfDouble.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfDouble mapper, PrimitiveFunction.ToDouble.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndShort() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndDouble.this.getKeyDouble(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfDouble.AndDouble.this.getValueDouble()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfDouble.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            default PrimitiveEntry.OfDouble.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfDouble mapper, PrimitiveFunction.ToDouble.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndByte() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndDouble.this.getKeyDouble(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfDouble.AndDouble.this.getValueDouble()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfDouble.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            default PrimitiveEntry.OfDouble.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfDouble mapper, PrimitiveFunction.ToDouble.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndBoolean() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndDouble.this.getKeyDouble(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfDouble.AndDouble.this.getValueDouble()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfDouble.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            double getValueDouble();
            double setValueDouble(double value);
        }
        interface AndLong extends OfDouble<java.lang.Long> {
            @Override default java.lang.Long getValue() { return getValueLong(); }
            @Override default java.lang.Long setValue(java.lang.Long v) { return setValueLong(v); }
            @Override default PrimitiveEntry.OfDouble.AndLong mapToDoubleKey(PrimitiveFunction.ToDouble.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfDouble.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfDouble.AndLong.this.setValueLong(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfDouble.AndLong.this.getKeyDouble()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndLong mapToLongKey(PrimitiveFunction.ToLong.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfDouble.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfDouble.AndLong.this.setValueLong(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfDouble.AndLong.this.getKeyDouble()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndLong mapToIntKey(PrimitiveFunction.ToInt.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfDouble.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfDouble.AndLong.this.setValueLong(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfDouble.AndLong.this.getKeyDouble()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndLong mapToFloatKey(PrimitiveFunction.ToFloat.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfDouble.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfDouble.AndLong.this.setValueLong(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfDouble.AndLong.this.getKeyDouble()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndLong mapToCharKey(PrimitiveFunction.ToChar.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfDouble.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfDouble.AndLong.this.setValueLong(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfDouble.AndLong.this.getKeyDouble()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndLong mapToShortKey(PrimitiveFunction.ToShort.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfDouble.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfDouble.AndLong.this.setValueLong(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfDouble.AndLong.this.getKeyDouble()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndLong mapToByteKey(PrimitiveFunction.ToByte.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfDouble.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfDouble.AndLong.this.setValueLong(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfDouble.AndLong.this.getKeyDouble()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndLong mapToBooleanKey(PrimitiveFunction.ToBoolean.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfDouble.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfDouble.AndLong.this.setValueLong(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfDouble.AndLong.this.getKeyDouble()); }
                };
            }
            default PrimitiveEntry.OfDouble.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfLong mapper, PrimitiveFunction.ToLong.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndDouble() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndLong.this.getKeyDouble(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfDouble.AndLong.this.getValueLong()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfDouble.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            default PrimitiveEntry.OfDouble.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfLong mapper, PrimitiveFunction.ToLong.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndLong() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndLong.this.getKeyDouble(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfDouble.AndLong.this.getValueLong()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfDouble.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            default PrimitiveEntry.OfDouble.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfLong mapper, PrimitiveFunction.ToLong.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndInt() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndLong.this.getKeyDouble(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfDouble.AndLong.this.getValueLong()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfDouble.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            default PrimitiveEntry.OfDouble.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfLong mapper, PrimitiveFunction.ToLong.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndFloat() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndLong.this.getKeyDouble(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfDouble.AndLong.this.getValueLong()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfDouble.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            default PrimitiveEntry.OfDouble.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfLong mapper, PrimitiveFunction.ToLong.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndChar() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndLong.this.getKeyDouble(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfDouble.AndLong.this.getValueLong()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfDouble.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            default PrimitiveEntry.OfDouble.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfLong mapper, PrimitiveFunction.ToLong.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndShort() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndLong.this.getKeyDouble(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfDouble.AndLong.this.getValueLong()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfDouble.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            default PrimitiveEntry.OfDouble.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfLong mapper, PrimitiveFunction.ToLong.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndByte() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndLong.this.getKeyDouble(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfDouble.AndLong.this.getValueLong()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfDouble.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            default PrimitiveEntry.OfDouble.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfLong mapper, PrimitiveFunction.ToLong.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndBoolean() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndLong.this.getKeyDouble(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfDouble.AndLong.this.getValueLong()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfDouble.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            long getValueLong();
            long setValueLong(long value);
        }
        interface AndInt extends OfDouble<java.lang.Integer> {
            @Override default java.lang.Integer getValue() { return getValueInt(); }
            @Override default java.lang.Integer setValue(java.lang.Integer v) { return setValueInt(v); }
            @Override default PrimitiveEntry.OfDouble.AndInt mapToDoubleKey(PrimitiveFunction.ToDouble.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfDouble.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfDouble.AndInt.this.setValueInt(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfDouble.AndInt.this.getKeyDouble()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndInt mapToLongKey(PrimitiveFunction.ToLong.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfDouble.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfDouble.AndInt.this.setValueInt(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfDouble.AndInt.this.getKeyDouble()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndInt mapToIntKey(PrimitiveFunction.ToInt.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfDouble.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfDouble.AndInt.this.setValueInt(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfDouble.AndInt.this.getKeyDouble()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndInt mapToFloatKey(PrimitiveFunction.ToFloat.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfDouble.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfDouble.AndInt.this.setValueInt(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfDouble.AndInt.this.getKeyDouble()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndInt mapToCharKey(PrimitiveFunction.ToChar.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfDouble.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfDouble.AndInt.this.setValueInt(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfDouble.AndInt.this.getKeyDouble()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndInt mapToShortKey(PrimitiveFunction.ToShort.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfDouble.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfDouble.AndInt.this.setValueInt(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfDouble.AndInt.this.getKeyDouble()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndInt mapToByteKey(PrimitiveFunction.ToByte.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfDouble.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfDouble.AndInt.this.setValueInt(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfDouble.AndInt.this.getKeyDouble()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndInt mapToBooleanKey(PrimitiveFunction.ToBoolean.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfDouble.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfDouble.AndInt.this.setValueInt(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfDouble.AndInt.this.getKeyDouble()); }
                };
            }
            default PrimitiveEntry.OfDouble.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfInt mapper, PrimitiveFunction.ToInt.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndDouble() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndInt.this.getKeyDouble(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfDouble.AndInt.this.getValueInt()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfDouble.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            default PrimitiveEntry.OfDouble.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfInt mapper, PrimitiveFunction.ToInt.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndLong() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndInt.this.getKeyDouble(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfDouble.AndInt.this.getValueInt()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfDouble.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            default PrimitiveEntry.OfDouble.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfInt mapper, PrimitiveFunction.ToInt.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndInt() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndInt.this.getKeyDouble(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfDouble.AndInt.this.getValueInt()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfDouble.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            default PrimitiveEntry.OfDouble.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfInt mapper, PrimitiveFunction.ToInt.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndFloat() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndInt.this.getKeyDouble(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfDouble.AndInt.this.getValueInt()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfDouble.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            default PrimitiveEntry.OfDouble.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfInt mapper, PrimitiveFunction.ToInt.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndChar() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndInt.this.getKeyDouble(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfDouble.AndInt.this.getValueInt()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfDouble.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            default PrimitiveEntry.OfDouble.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfInt mapper, PrimitiveFunction.ToInt.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndShort() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndInt.this.getKeyDouble(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfDouble.AndInt.this.getValueInt()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfDouble.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            default PrimitiveEntry.OfDouble.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfInt mapper, PrimitiveFunction.ToInt.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndByte() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndInt.this.getKeyDouble(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfDouble.AndInt.this.getValueInt()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfDouble.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            default PrimitiveEntry.OfDouble.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfInt mapper, PrimitiveFunction.ToInt.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndBoolean() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndInt.this.getKeyDouble(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfDouble.AndInt.this.getValueInt()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfDouble.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            int getValueInt();
            int setValueInt(int value);
        }
        interface AndFloat extends OfDouble<java.lang.Float> {
            @Override default java.lang.Float getValue() { return getValueFloat(); }
            @Override default java.lang.Float setValue(java.lang.Float v) { return setValueFloat(v); }
            @Override default PrimitiveEntry.OfDouble.AndFloat mapToDoubleKey(PrimitiveFunction.ToDouble.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfDouble.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfDouble.AndFloat.this.setValueFloat(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfDouble.AndFloat.this.getKeyDouble()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndFloat mapToLongKey(PrimitiveFunction.ToLong.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfDouble.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfDouble.AndFloat.this.setValueFloat(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfDouble.AndFloat.this.getKeyDouble()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndFloat mapToIntKey(PrimitiveFunction.ToInt.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfDouble.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfDouble.AndFloat.this.setValueFloat(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfDouble.AndFloat.this.getKeyDouble()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndFloat mapToFloatKey(PrimitiveFunction.ToFloat.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfDouble.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfDouble.AndFloat.this.setValueFloat(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfDouble.AndFloat.this.getKeyDouble()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndFloat mapToCharKey(PrimitiveFunction.ToChar.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfDouble.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfDouble.AndFloat.this.setValueFloat(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfDouble.AndFloat.this.getKeyDouble()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndFloat mapToShortKey(PrimitiveFunction.ToShort.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfDouble.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfDouble.AndFloat.this.setValueFloat(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfDouble.AndFloat.this.getKeyDouble()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndFloat mapToByteKey(PrimitiveFunction.ToByte.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfDouble.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfDouble.AndFloat.this.setValueFloat(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfDouble.AndFloat.this.getKeyDouble()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndFloat mapToBooleanKey(PrimitiveFunction.ToBoolean.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfDouble.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfDouble.AndFloat.this.setValueFloat(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfDouble.AndFloat.this.getKeyDouble()); }
                };
            }
            default PrimitiveEntry.OfDouble.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfFloat mapper, PrimitiveFunction.ToFloat.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndDouble() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndFloat.this.getKeyDouble(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfDouble.AndFloat.this.getValueFloat()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfDouble.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            default PrimitiveEntry.OfDouble.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfFloat mapper, PrimitiveFunction.ToFloat.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndLong() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndFloat.this.getKeyDouble(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfDouble.AndFloat.this.getValueFloat()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfDouble.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            default PrimitiveEntry.OfDouble.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfFloat mapper, PrimitiveFunction.ToFloat.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndInt() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndFloat.this.getKeyDouble(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfDouble.AndFloat.this.getValueFloat()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfDouble.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            default PrimitiveEntry.OfDouble.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfFloat mapper, PrimitiveFunction.ToFloat.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndFloat() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndFloat.this.getKeyDouble(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfDouble.AndFloat.this.getValueFloat()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfDouble.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            default PrimitiveEntry.OfDouble.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfFloat mapper, PrimitiveFunction.ToFloat.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndChar() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndFloat.this.getKeyDouble(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfDouble.AndFloat.this.getValueFloat()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfDouble.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            default PrimitiveEntry.OfDouble.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfFloat mapper, PrimitiveFunction.ToFloat.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndShort() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndFloat.this.getKeyDouble(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfDouble.AndFloat.this.getValueFloat()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfDouble.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            default PrimitiveEntry.OfDouble.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfFloat mapper, PrimitiveFunction.ToFloat.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndByte() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndFloat.this.getKeyDouble(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfDouble.AndFloat.this.getValueFloat()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfDouble.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            default PrimitiveEntry.OfDouble.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfFloat mapper, PrimitiveFunction.ToFloat.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndBoolean() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndFloat.this.getKeyDouble(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfDouble.AndFloat.this.getValueFloat()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfDouble.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            float getValueFloat();
            float setValueFloat(float value);
        }
        interface AndChar extends OfDouble<java.lang.Character> {
            @Override default java.lang.Character getValue() { return getValueChar(); }
            @Override default java.lang.Character setValue(java.lang.Character v) { return setValueChar(v); }
            @Override default PrimitiveEntry.OfDouble.AndChar mapToDoubleKey(PrimitiveFunction.ToDouble.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfDouble.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfDouble.AndChar.this.setValueChar(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfDouble.AndChar.this.getKeyDouble()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndChar mapToLongKey(PrimitiveFunction.ToLong.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfDouble.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfDouble.AndChar.this.setValueChar(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfDouble.AndChar.this.getKeyDouble()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndChar mapToIntKey(PrimitiveFunction.ToInt.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfDouble.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfDouble.AndChar.this.setValueChar(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfDouble.AndChar.this.getKeyDouble()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndChar mapToFloatKey(PrimitiveFunction.ToFloat.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfDouble.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfDouble.AndChar.this.setValueChar(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfDouble.AndChar.this.getKeyDouble()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndChar mapToCharKey(PrimitiveFunction.ToChar.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfDouble.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfDouble.AndChar.this.setValueChar(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfDouble.AndChar.this.getKeyDouble()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndChar mapToShortKey(PrimitiveFunction.ToShort.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfDouble.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfDouble.AndChar.this.setValueChar(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfDouble.AndChar.this.getKeyDouble()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndChar mapToByteKey(PrimitiveFunction.ToByte.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfDouble.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfDouble.AndChar.this.setValueChar(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfDouble.AndChar.this.getKeyDouble()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndChar mapToBooleanKey(PrimitiveFunction.ToBoolean.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfDouble.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfDouble.AndChar.this.setValueChar(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfDouble.AndChar.this.getKeyDouble()); }
                };
            }
            default PrimitiveEntry.OfDouble.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfChar mapper, PrimitiveFunction.ToChar.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndDouble() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndChar.this.getKeyDouble(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfDouble.AndChar.this.getValueChar()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfDouble.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            default PrimitiveEntry.OfDouble.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfChar mapper, PrimitiveFunction.ToChar.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndLong() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndChar.this.getKeyDouble(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfDouble.AndChar.this.getValueChar()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfDouble.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            default PrimitiveEntry.OfDouble.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfChar mapper, PrimitiveFunction.ToChar.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndInt() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndChar.this.getKeyDouble(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfDouble.AndChar.this.getValueChar()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfDouble.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            default PrimitiveEntry.OfDouble.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfChar mapper, PrimitiveFunction.ToChar.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndFloat() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndChar.this.getKeyDouble(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfDouble.AndChar.this.getValueChar()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfDouble.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            default PrimitiveEntry.OfDouble.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfChar mapper, PrimitiveFunction.ToChar.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndChar() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndChar.this.getKeyDouble(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfDouble.AndChar.this.getValueChar()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfDouble.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            default PrimitiveEntry.OfDouble.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfChar mapper, PrimitiveFunction.ToChar.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndShort() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndChar.this.getKeyDouble(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfDouble.AndChar.this.getValueChar()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfDouble.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            default PrimitiveEntry.OfDouble.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfChar mapper, PrimitiveFunction.ToChar.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndByte() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndChar.this.getKeyDouble(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfDouble.AndChar.this.getValueChar()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfDouble.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            default PrimitiveEntry.OfDouble.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfChar mapper, PrimitiveFunction.ToChar.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndBoolean() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndChar.this.getKeyDouble(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfDouble.AndChar.this.getValueChar()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfDouble.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            char getValueChar();
            char setValueChar(char value);
        }
        interface AndShort extends OfDouble<java.lang.Short> {
            @Override default java.lang.Short getValue() { return getValueShort(); }
            @Override default java.lang.Short setValue(java.lang.Short v) { return setValueShort(v); }
            @Override default PrimitiveEntry.OfDouble.AndShort mapToDoubleKey(PrimitiveFunction.ToDouble.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfDouble.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfDouble.AndShort.this.setValueShort(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfDouble.AndShort.this.getKeyDouble()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndShort mapToLongKey(PrimitiveFunction.ToLong.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfDouble.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfDouble.AndShort.this.setValueShort(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfDouble.AndShort.this.getKeyDouble()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndShort mapToIntKey(PrimitiveFunction.ToInt.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfDouble.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfDouble.AndShort.this.setValueShort(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfDouble.AndShort.this.getKeyDouble()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndShort mapToFloatKey(PrimitiveFunction.ToFloat.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfDouble.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfDouble.AndShort.this.setValueShort(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfDouble.AndShort.this.getKeyDouble()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndShort mapToCharKey(PrimitiveFunction.ToChar.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfDouble.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfDouble.AndShort.this.setValueShort(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfDouble.AndShort.this.getKeyDouble()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndShort mapToShortKey(PrimitiveFunction.ToShort.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfDouble.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfDouble.AndShort.this.setValueShort(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfDouble.AndShort.this.getKeyDouble()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndShort mapToByteKey(PrimitiveFunction.ToByte.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfDouble.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfDouble.AndShort.this.setValueShort(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfDouble.AndShort.this.getKeyDouble()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndShort mapToBooleanKey(PrimitiveFunction.ToBoolean.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfDouble.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfDouble.AndShort.this.setValueShort(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfDouble.AndShort.this.getKeyDouble()); }
                };
            }
            default PrimitiveEntry.OfDouble.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfShort mapper, PrimitiveFunction.ToShort.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndDouble() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndShort.this.getKeyDouble(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfDouble.AndShort.this.getValueShort()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfDouble.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            default PrimitiveEntry.OfDouble.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfShort mapper, PrimitiveFunction.ToShort.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndLong() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndShort.this.getKeyDouble(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfDouble.AndShort.this.getValueShort()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfDouble.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            default PrimitiveEntry.OfDouble.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfShort mapper, PrimitiveFunction.ToShort.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndInt() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndShort.this.getKeyDouble(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfDouble.AndShort.this.getValueShort()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfDouble.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            default PrimitiveEntry.OfDouble.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfShort mapper, PrimitiveFunction.ToShort.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndFloat() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndShort.this.getKeyDouble(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfDouble.AndShort.this.getValueShort()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfDouble.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            default PrimitiveEntry.OfDouble.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfShort mapper, PrimitiveFunction.ToShort.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndChar() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndShort.this.getKeyDouble(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfDouble.AndShort.this.getValueShort()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfDouble.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            default PrimitiveEntry.OfDouble.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfShort mapper, PrimitiveFunction.ToShort.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndShort() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndShort.this.getKeyDouble(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfDouble.AndShort.this.getValueShort()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfDouble.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            default PrimitiveEntry.OfDouble.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfShort mapper, PrimitiveFunction.ToShort.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndByte() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndShort.this.getKeyDouble(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfDouble.AndShort.this.getValueShort()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfDouble.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            default PrimitiveEntry.OfDouble.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfShort mapper, PrimitiveFunction.ToShort.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndBoolean() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndShort.this.getKeyDouble(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfDouble.AndShort.this.getValueShort()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfDouble.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            short getValueShort();
            short setValueShort(short value);
        }
        interface AndByte extends OfDouble<java.lang.Byte> {
            @Override default java.lang.Byte getValue() { return getValueByte(); }
            @Override default java.lang.Byte setValue(java.lang.Byte v) { return setValueByte(v); }
            @Override default PrimitiveEntry.OfDouble.AndByte mapToDoubleKey(PrimitiveFunction.ToDouble.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfDouble.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfDouble.AndByte.this.setValueByte(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfDouble.AndByte.this.getKeyDouble()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndByte mapToLongKey(PrimitiveFunction.ToLong.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfDouble.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfDouble.AndByte.this.setValueByte(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfDouble.AndByte.this.getKeyDouble()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndByte mapToIntKey(PrimitiveFunction.ToInt.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfDouble.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfDouble.AndByte.this.setValueByte(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfDouble.AndByte.this.getKeyDouble()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndByte mapToFloatKey(PrimitiveFunction.ToFloat.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfDouble.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfDouble.AndByte.this.setValueByte(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfDouble.AndByte.this.getKeyDouble()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndByte mapToCharKey(PrimitiveFunction.ToChar.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfDouble.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfDouble.AndByte.this.setValueByte(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfDouble.AndByte.this.getKeyDouble()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndByte mapToShortKey(PrimitiveFunction.ToShort.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfDouble.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfDouble.AndByte.this.setValueByte(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfDouble.AndByte.this.getKeyDouble()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndByte mapToByteKey(PrimitiveFunction.ToByte.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfDouble.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfDouble.AndByte.this.setValueByte(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfDouble.AndByte.this.getKeyDouble()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndByte mapToBooleanKey(PrimitiveFunction.ToBoolean.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfDouble.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfDouble.AndByte.this.setValueByte(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfDouble.AndByte.this.getKeyDouble()); }
                };
            }
            default PrimitiveEntry.OfDouble.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfByte mapper, PrimitiveFunction.ToByte.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndDouble() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndByte.this.getKeyDouble(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfDouble.AndByte.this.getValueByte()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfDouble.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            default PrimitiveEntry.OfDouble.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfByte mapper, PrimitiveFunction.ToByte.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndLong() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndByte.this.getKeyDouble(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfDouble.AndByte.this.getValueByte()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfDouble.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            default PrimitiveEntry.OfDouble.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfByte mapper, PrimitiveFunction.ToByte.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndInt() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndByte.this.getKeyDouble(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfDouble.AndByte.this.getValueByte()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfDouble.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            default PrimitiveEntry.OfDouble.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfByte mapper, PrimitiveFunction.ToByte.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndFloat() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndByte.this.getKeyDouble(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfDouble.AndByte.this.getValueByte()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfDouble.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            default PrimitiveEntry.OfDouble.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfByte mapper, PrimitiveFunction.ToByte.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndChar() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndByte.this.getKeyDouble(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfDouble.AndByte.this.getValueByte()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfDouble.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            default PrimitiveEntry.OfDouble.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfByte mapper, PrimitiveFunction.ToByte.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndShort() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndByte.this.getKeyDouble(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfDouble.AndByte.this.getValueByte()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfDouble.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            default PrimitiveEntry.OfDouble.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfByte mapper, PrimitiveFunction.ToByte.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndByte() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndByte.this.getKeyDouble(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfDouble.AndByte.this.getValueByte()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfDouble.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            default PrimitiveEntry.OfDouble.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfByte mapper, PrimitiveFunction.ToByte.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndBoolean() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndByte.this.getKeyDouble(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfDouble.AndByte.this.getValueByte()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfDouble.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            byte getValueByte();
            byte setValueByte(byte value);
        }
        interface AndBoolean extends OfDouble<java.lang.Boolean> {
            @Override default java.lang.Boolean getValue() { return getValueBoolean(); }
            @Override default java.lang.Boolean setValue(java.lang.Boolean v) { return setValueBoolean(v); }
            @Override default PrimitiveEntry.OfDouble.AndBoolean mapToDoubleKey(PrimitiveFunction.ToDouble.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfDouble.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfDouble.AndBoolean.this.setValueBoolean(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfDouble.AndBoolean.this.getKeyDouble()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndBoolean mapToLongKey(PrimitiveFunction.ToLong.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfDouble.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfDouble.AndBoolean.this.setValueBoolean(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfDouble.AndBoolean.this.getKeyDouble()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndBoolean mapToIntKey(PrimitiveFunction.ToInt.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfDouble.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfDouble.AndBoolean.this.setValueBoolean(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfDouble.AndBoolean.this.getKeyDouble()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndBoolean mapToFloatKey(PrimitiveFunction.ToFloat.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfDouble.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfDouble.AndBoolean.this.setValueBoolean(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfDouble.AndBoolean.this.getKeyDouble()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndBoolean mapToCharKey(PrimitiveFunction.ToChar.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfDouble.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfDouble.AndBoolean.this.setValueBoolean(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfDouble.AndBoolean.this.getKeyDouble()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndBoolean mapToShortKey(PrimitiveFunction.ToShort.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfDouble.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfDouble.AndBoolean.this.setValueBoolean(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfDouble.AndBoolean.this.getKeyDouble()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndBoolean mapToByteKey(PrimitiveFunction.ToByte.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfDouble.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfDouble.AndBoolean.this.setValueBoolean(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfDouble.AndBoolean.this.getKeyDouble()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndBoolean mapToBooleanKey(PrimitiveFunction.ToBoolean.OfDouble mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfDouble.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfDouble.AndBoolean.this.setValueBoolean(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfDouble.AndBoolean.this.getKeyDouble()); }
                };
            }
            default PrimitiveEntry.OfDouble.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndDouble() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndBoolean.this.getKeyDouble(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfDouble.AndBoolean.this.getValueBoolean()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfDouble.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            default PrimitiveEntry.OfDouble.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndLong() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndBoolean.this.getKeyDouble(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfDouble.AndBoolean.this.getValueBoolean()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfDouble.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            default PrimitiveEntry.OfDouble.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndInt() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndBoolean.this.getKeyDouble(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfDouble.AndBoolean.this.getValueBoolean()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfDouble.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            default PrimitiveEntry.OfDouble.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndFloat() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndBoolean.this.getKeyDouble(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfDouble.AndBoolean.this.getValueBoolean()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfDouble.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            default PrimitiveEntry.OfDouble.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndChar() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndBoolean.this.getKeyDouble(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfDouble.AndBoolean.this.getValueBoolean()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfDouble.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            default PrimitiveEntry.OfDouble.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndShort() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndBoolean.this.getKeyDouble(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfDouble.AndBoolean.this.getValueBoolean()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfDouble.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            default PrimitiveEntry.OfDouble.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndByte() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndBoolean.this.getKeyDouble(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfDouble.AndBoolean.this.getValueBoolean()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfDouble.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            default PrimitiveEntry.OfDouble.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfDouble.AndBoolean() {
                    public double getKeyDouble() { return PrimitiveEntry.OfDouble.AndBoolean.this.getKeyDouble(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfDouble.AndBoolean.this.getValueBoolean()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfDouble.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            boolean getValueBoolean();
            boolean setValueBoolean(boolean value);
        }
    }
    interface OfLong<V> extends PrimitiveEntry<java.lang.Long, V> {
        @Override
        default Map.Entry<java.lang.Long, V> boxed() { return this; }
        default OfDouble<V> mapToDoubleKey(PrimitiveFunction.ToDouble.OfLong mapper) {
            if(mapper == null) throw new NullPointerException();
            return new OfDouble<V>() {
                public boolean equals(Object o) { return OfLong.this.equals(o); }
                public int hashCode() { return OfLong.this.hashCode(); }
                public double getKeyDouble() { return mapper.applyDouble(OfLong.this.getKeyLong()); }
                public V getValue() { return OfLong.this.getValue(); }
                public V setValue(V v) { return OfLong.this.setValue(v); }
            };
        }
        default OfLong<V> mapToLongKey(PrimitiveFunction.ToLong.OfLong mapper) {
            if(mapper == null) throw new NullPointerException();
            return new OfLong<V>() {
                public boolean equals(Object o) { return OfLong.this.equals(o); }
                public int hashCode() { return OfLong.this.hashCode(); }
                public long getKeyLong() { return mapper.applyLong(OfLong.this.getKeyLong()); }
                public V getValue() { return OfLong.this.getValue(); }
                public V setValue(V v) { return OfLong.this.setValue(v); }
            };
        }
        default OfInt<V> mapToIntKey(PrimitiveFunction.ToInt.OfLong mapper) {
            if(mapper == null) throw new NullPointerException();
            PrimitiveEntry.OfLong<V> thisEnt = this;
            return new OfInt<V>() {
                public boolean equals(Object o) { return thisEnt.equals(o); }
                public int hashCode() { return thisEnt.hashCode(); }
                public int getKeyInt() { return mapper.applyInt(thisEnt.getKeyLong()); }
                public V getValue() { return thisEnt.getValue(); }
                public V setValue(V v) { return thisEnt.setValue(v); }
            };
        }
        default OfFloat<V> mapToFloatKey(PrimitiveFunction.ToFloat.OfLong mapper) {
            if(mapper == null) throw new NullPointerException();
            return new OfFloat<V>() {
                public boolean equals(Object o) { return OfLong.this.equals(o); }
                public int hashCode() { return OfLong.this.hashCode(); }
                public float getKeyFloat() { return mapper.applyFloat(OfLong.this.getKeyLong()); }
                public V getValue() { return OfLong.this.getValue(); }
                public V setValue(V v) { return OfLong.this.setValue(v); }
            };
        }
        default OfChar<V> mapToCharKey(PrimitiveFunction.ToChar.OfLong mapper) {
            if(mapper == null) throw new NullPointerException();
            return new OfChar<V>() {
                public boolean equals(Object o) { return OfLong.this.equals(o); }
                public int hashCode() { return OfLong.this.hashCode(); }
                public char getKeyChar() { return mapper.applyChar(OfLong.this.getKeyLong()); }
                public V getValue() { return OfLong.this.getValue(); }
                public V setValue(V v) { return OfLong.this.setValue(v); }
            };
        }
        default OfShort<V> mapToShortKey(PrimitiveFunction.ToShort.OfLong mapper) {
            if(mapper == null) throw new NullPointerException();
            return new OfShort<V>() {
                public boolean equals(Object o) { return OfLong.this.equals(o); }
                public int hashCode() { return OfLong.this.hashCode(); }
                public short getKeyShort() { return mapper.applyShort(OfLong.this.getKeyLong()); }
                public V getValue() { return OfLong.this.getValue(); }
                public V setValue(V v) { return OfLong.this.setValue(v); }
            };
        }
        default OfByte<V> mapToByteKey(PrimitiveFunction.ToByte.OfLong mapper) {
            if(mapper == null) throw new NullPointerException();
            return new OfByte<V>() {
                public boolean equals(Object o) { return OfLong.this.equals(o); }
                public int hashCode() { return OfLong.this.hashCode(); }
                public byte getKeyByte() { return mapper.applyByte(OfLong.this.getKeyLong()); }
                public V getValue() { return OfLong.this.getValue(); }
                public V setValue(V v) { return OfLong.this.setValue(v); }
            };
        }
        default OfBoolean<V> mapToBooleanKey(PrimitiveFunction.ToBoolean.OfLong mapper) {
            if(mapper == null) throw new NullPointerException();
            return new OfBoolean<V>() {
                public boolean equals(Object o) { return OfLong.this.equals(o); }
                public int hashCode() { return OfLong.this.hashCode(); }
                public boolean getKeyBoolean() { return mapper.applyBoolean(OfLong.this.getKeyLong()); }
                public V getValue() { return OfLong.this.getValue(); }
                public V setValue(V v) { return OfLong.this.setValue(v); }
            };
        }
        @Override default java.lang.Long getKey() { return OfLong.this.getKeyLong(); }
        long getKeyLong();
        interface AndDouble extends OfLong<java.lang.Double> {
            @Override default java.lang.Double getValue() { return getValueDouble(); }
            @Override default java.lang.Double setValue(java.lang.Double v) { return setValueDouble(v); }
            @Override default PrimitiveEntry.OfDouble.AndDouble mapToDoubleKey(PrimitiveFunction.ToDouble.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfLong.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfLong.AndDouble.this.setValueDouble(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfLong.AndDouble.this.getKeyLong()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndDouble mapToLongKey(PrimitiveFunction.ToLong.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfLong.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfLong.AndDouble.this.setValueDouble(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfLong.AndDouble.this.getKeyLong()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndDouble mapToIntKey(PrimitiveFunction.ToInt.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfLong.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfLong.AndDouble.this.setValueDouble(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfLong.AndDouble.this.getKeyLong()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndDouble mapToFloatKey(PrimitiveFunction.ToFloat.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfLong.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfLong.AndDouble.this.setValueDouble(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfLong.AndDouble.this.getKeyLong()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndDouble mapToCharKey(PrimitiveFunction.ToChar.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfLong.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfLong.AndDouble.this.setValueDouble(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfLong.AndDouble.this.getKeyLong()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndDouble mapToShortKey(PrimitiveFunction.ToShort.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfLong.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfLong.AndDouble.this.setValueDouble(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfLong.AndDouble.this.getKeyLong()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndDouble mapToByteKey(PrimitiveFunction.ToByte.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfLong.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfLong.AndDouble.this.setValueDouble(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfLong.AndDouble.this.getKeyLong()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndDouble mapToBooleanKey(PrimitiveFunction.ToBoolean.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfLong.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfLong.AndDouble.this.setValueDouble(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfLong.AndDouble.this.getKeyLong()); }
                };
            }
            default PrimitiveEntry.OfLong.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfDouble mapper, PrimitiveFunction.ToDouble.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndDouble() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndDouble.this.getKeyLong(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfLong.AndDouble.this.getValueDouble()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfLong.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            default PrimitiveEntry.OfLong.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfDouble mapper, PrimitiveFunction.ToDouble.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndLong() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndDouble.this.getKeyLong(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfLong.AndDouble.this.getValueDouble()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfLong.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            default PrimitiveEntry.OfLong.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfDouble mapper, PrimitiveFunction.ToDouble.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndInt() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndDouble.this.getKeyLong(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfLong.AndDouble.this.getValueDouble()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfLong.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            default PrimitiveEntry.OfLong.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfDouble mapper, PrimitiveFunction.ToDouble.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndFloat() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndDouble.this.getKeyLong(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfLong.AndDouble.this.getValueDouble()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfLong.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            default PrimitiveEntry.OfLong.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfDouble mapper, PrimitiveFunction.ToDouble.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndChar() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndDouble.this.getKeyLong(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfLong.AndDouble.this.getValueDouble()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfLong.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            default PrimitiveEntry.OfLong.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfDouble mapper, PrimitiveFunction.ToDouble.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndShort() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndDouble.this.getKeyLong(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfLong.AndDouble.this.getValueDouble()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfLong.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            default PrimitiveEntry.OfLong.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfDouble mapper, PrimitiveFunction.ToDouble.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndByte() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndDouble.this.getKeyLong(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfLong.AndDouble.this.getValueDouble()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfLong.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            default PrimitiveEntry.OfLong.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfDouble mapper, PrimitiveFunction.ToDouble.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndBoolean() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndDouble.this.getKeyLong(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfLong.AndDouble.this.getValueDouble()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfLong.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            double getValueDouble();
            double setValueDouble(double value);
        }
        interface AndLong extends OfLong<java.lang.Long> {
            @Override default java.lang.Long getValue() { return getValueLong(); }
            @Override default java.lang.Long setValue(java.lang.Long v) { return setValueLong(v); }
            @Override default PrimitiveEntry.OfDouble.AndLong mapToDoubleKey(PrimitiveFunction.ToDouble.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfLong.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfLong.AndLong.this.setValueLong(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfLong.AndLong.this.getKeyLong()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndLong mapToLongKey(PrimitiveFunction.ToLong.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfLong.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfLong.AndLong.this.setValueLong(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfLong.AndLong.this.getKeyLong()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndLong mapToIntKey(PrimitiveFunction.ToInt.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfLong.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfLong.AndLong.this.setValueLong(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfLong.AndLong.this.getKeyLong()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndLong mapToFloatKey(PrimitiveFunction.ToFloat.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfLong.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfLong.AndLong.this.setValueLong(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfLong.AndLong.this.getKeyLong()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndLong mapToCharKey(PrimitiveFunction.ToChar.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfLong.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfLong.AndLong.this.setValueLong(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfLong.AndLong.this.getKeyLong()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndLong mapToShortKey(PrimitiveFunction.ToShort.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfLong.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfLong.AndLong.this.setValueLong(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfLong.AndLong.this.getKeyLong()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndLong mapToByteKey(PrimitiveFunction.ToByte.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfLong.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfLong.AndLong.this.setValueLong(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfLong.AndLong.this.getKeyLong()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndLong mapToBooleanKey(PrimitiveFunction.ToBoolean.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfLong.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfLong.AndLong.this.setValueLong(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfLong.AndLong.this.getKeyLong()); }
                };
            }
            default PrimitiveEntry.OfLong.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfLong mapper, PrimitiveFunction.ToLong.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndDouble() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndLong.this.getKeyLong(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfLong.AndLong.this.getValueLong()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfLong.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            default PrimitiveEntry.OfLong.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfLong mapper, PrimitiveFunction.ToLong.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndLong() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndLong.this.getKeyLong(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfLong.AndLong.this.getValueLong()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfLong.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            default PrimitiveEntry.OfLong.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfLong mapper, PrimitiveFunction.ToLong.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndInt() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndLong.this.getKeyLong(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfLong.AndLong.this.getValueLong()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfLong.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            default PrimitiveEntry.OfLong.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfLong mapper, PrimitiveFunction.ToLong.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndFloat() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndLong.this.getKeyLong(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfLong.AndLong.this.getValueLong()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfLong.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            default PrimitiveEntry.OfLong.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfLong mapper, PrimitiveFunction.ToLong.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndChar() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndLong.this.getKeyLong(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfLong.AndLong.this.getValueLong()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfLong.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            default PrimitiveEntry.OfLong.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfLong mapper, PrimitiveFunction.ToLong.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndShort() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndLong.this.getKeyLong(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfLong.AndLong.this.getValueLong()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfLong.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            default PrimitiveEntry.OfLong.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfLong mapper, PrimitiveFunction.ToLong.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndByte() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndLong.this.getKeyLong(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfLong.AndLong.this.getValueLong()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfLong.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            default PrimitiveEntry.OfLong.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfLong mapper, PrimitiveFunction.ToLong.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndBoolean() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndLong.this.getKeyLong(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfLong.AndLong.this.getValueLong()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfLong.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            long getValueLong();
            long setValueLong(long value);
        }
        interface AndInt extends OfLong<java.lang.Integer> {
            @Override default java.lang.Integer getValue() { return getValueInt(); }
            @Override default java.lang.Integer setValue(java.lang.Integer v) { return setValueInt(v); }
            @Override default PrimitiveEntry.OfDouble.AndInt mapToDoubleKey(PrimitiveFunction.ToDouble.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfLong.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfLong.AndInt.this.setValueInt(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfLong.AndInt.this.getKeyLong()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndInt mapToLongKey(PrimitiveFunction.ToLong.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfLong.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfLong.AndInt.this.setValueInt(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfLong.AndInt.this.getKeyLong()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndInt mapToIntKey(PrimitiveFunction.ToInt.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfLong.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfLong.AndInt.this.setValueInt(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfLong.AndInt.this.getKeyLong()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndInt mapToFloatKey(PrimitiveFunction.ToFloat.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfLong.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfLong.AndInt.this.setValueInt(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfLong.AndInt.this.getKeyLong()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndInt mapToCharKey(PrimitiveFunction.ToChar.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfLong.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfLong.AndInt.this.setValueInt(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfLong.AndInt.this.getKeyLong()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndInt mapToShortKey(PrimitiveFunction.ToShort.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfLong.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfLong.AndInt.this.setValueInt(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfLong.AndInt.this.getKeyLong()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndInt mapToByteKey(PrimitiveFunction.ToByte.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfLong.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfLong.AndInt.this.setValueInt(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfLong.AndInt.this.getKeyLong()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndInt mapToBooleanKey(PrimitiveFunction.ToBoolean.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfLong.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfLong.AndInt.this.setValueInt(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfLong.AndInt.this.getKeyLong()); }
                };
            }
            default PrimitiveEntry.OfLong.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfInt mapper, PrimitiveFunction.ToInt.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndDouble() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndInt.this.getKeyLong(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfLong.AndInt.this.getValueInt()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfLong.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            default PrimitiveEntry.OfLong.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfInt mapper, PrimitiveFunction.ToInt.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndLong() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndInt.this.getKeyLong(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfLong.AndInt.this.getValueInt()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfLong.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            default PrimitiveEntry.OfLong.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfInt mapper, PrimitiveFunction.ToInt.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndInt() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndInt.this.getKeyLong(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfLong.AndInt.this.getValueInt()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfLong.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            default PrimitiveEntry.OfLong.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfInt mapper, PrimitiveFunction.ToInt.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndFloat() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndInt.this.getKeyLong(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfLong.AndInt.this.getValueInt()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfLong.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            default PrimitiveEntry.OfLong.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfInt mapper, PrimitiveFunction.ToInt.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndChar() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndInt.this.getKeyLong(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfLong.AndInt.this.getValueInt()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfLong.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            default PrimitiveEntry.OfLong.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfInt mapper, PrimitiveFunction.ToInt.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndShort() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndInt.this.getKeyLong(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfLong.AndInt.this.getValueInt()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfLong.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            default PrimitiveEntry.OfLong.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfInt mapper, PrimitiveFunction.ToInt.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndByte() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndInt.this.getKeyLong(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfLong.AndInt.this.getValueInt()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfLong.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            default PrimitiveEntry.OfLong.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfInt mapper, PrimitiveFunction.ToInt.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndBoolean() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndInt.this.getKeyLong(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfLong.AndInt.this.getValueInt()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfLong.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            int getValueInt();
            int setValueInt(int value);
        }
        interface AndFloat extends OfLong<java.lang.Float> {
            @Override default java.lang.Float getValue() { return getValueFloat(); }
            @Override default java.lang.Float setValue(java.lang.Float v) { return setValueFloat(v); }
            @Override default PrimitiveEntry.OfDouble.AndFloat mapToDoubleKey(PrimitiveFunction.ToDouble.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfLong.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfLong.AndFloat.this.setValueFloat(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfLong.AndFloat.this.getKeyLong()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndFloat mapToLongKey(PrimitiveFunction.ToLong.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfLong.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfLong.AndFloat.this.setValueFloat(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfLong.AndFloat.this.getKeyLong()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndFloat mapToIntKey(PrimitiveFunction.ToInt.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfLong.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfLong.AndFloat.this.setValueFloat(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfLong.AndFloat.this.getKeyLong()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndFloat mapToFloatKey(PrimitiveFunction.ToFloat.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfLong.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfLong.AndFloat.this.setValueFloat(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfLong.AndFloat.this.getKeyLong()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndFloat mapToCharKey(PrimitiveFunction.ToChar.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfLong.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfLong.AndFloat.this.setValueFloat(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfLong.AndFloat.this.getKeyLong()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndFloat mapToShortKey(PrimitiveFunction.ToShort.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfLong.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfLong.AndFloat.this.setValueFloat(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfLong.AndFloat.this.getKeyLong()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndFloat mapToByteKey(PrimitiveFunction.ToByte.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfLong.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfLong.AndFloat.this.setValueFloat(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfLong.AndFloat.this.getKeyLong()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndFloat mapToBooleanKey(PrimitiveFunction.ToBoolean.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfLong.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfLong.AndFloat.this.setValueFloat(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfLong.AndFloat.this.getKeyLong()); }
                };
            }
            default PrimitiveEntry.OfLong.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfFloat mapper, PrimitiveFunction.ToFloat.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndDouble() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndFloat.this.getKeyLong(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfLong.AndFloat.this.getValueFloat()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfLong.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            default PrimitiveEntry.OfLong.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfFloat mapper, PrimitiveFunction.ToFloat.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndLong() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndFloat.this.getKeyLong(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfLong.AndFloat.this.getValueFloat()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfLong.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            default PrimitiveEntry.OfLong.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfFloat mapper, PrimitiveFunction.ToFloat.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndInt() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndFloat.this.getKeyLong(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfLong.AndFloat.this.getValueFloat()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfLong.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            default PrimitiveEntry.OfLong.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfFloat mapper, PrimitiveFunction.ToFloat.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndFloat() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndFloat.this.getKeyLong(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfLong.AndFloat.this.getValueFloat()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfLong.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            default PrimitiveEntry.OfLong.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfFloat mapper, PrimitiveFunction.ToFloat.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndChar() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndFloat.this.getKeyLong(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfLong.AndFloat.this.getValueFloat()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfLong.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            default PrimitiveEntry.OfLong.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfFloat mapper, PrimitiveFunction.ToFloat.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndShort() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndFloat.this.getKeyLong(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfLong.AndFloat.this.getValueFloat()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfLong.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            default PrimitiveEntry.OfLong.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfFloat mapper, PrimitiveFunction.ToFloat.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndByte() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndFloat.this.getKeyLong(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfLong.AndFloat.this.getValueFloat()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfLong.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            default PrimitiveEntry.OfLong.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfFloat mapper, PrimitiveFunction.ToFloat.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndBoolean() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndFloat.this.getKeyLong(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfLong.AndFloat.this.getValueFloat()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfLong.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            float getValueFloat();
            float setValueFloat(float value);
        }
        interface AndChar extends OfLong<java.lang.Character> {
            @Override default java.lang.Character getValue() { return getValueChar(); }
            @Override default java.lang.Character setValue(java.lang.Character v) { return setValueChar(v); }
            @Override default PrimitiveEntry.OfDouble.AndChar mapToDoubleKey(PrimitiveFunction.ToDouble.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfLong.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfLong.AndChar.this.setValueChar(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfLong.AndChar.this.getKeyLong()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndChar mapToLongKey(PrimitiveFunction.ToLong.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfLong.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfLong.AndChar.this.setValueChar(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfLong.AndChar.this.getKeyLong()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndChar mapToIntKey(PrimitiveFunction.ToInt.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfLong.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfLong.AndChar.this.setValueChar(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfLong.AndChar.this.getKeyLong()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndChar mapToFloatKey(PrimitiveFunction.ToFloat.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfLong.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfLong.AndChar.this.setValueChar(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfLong.AndChar.this.getKeyLong()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndChar mapToCharKey(PrimitiveFunction.ToChar.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfLong.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfLong.AndChar.this.setValueChar(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfLong.AndChar.this.getKeyLong()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndChar mapToShortKey(PrimitiveFunction.ToShort.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfLong.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfLong.AndChar.this.setValueChar(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfLong.AndChar.this.getKeyLong()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndChar mapToByteKey(PrimitiveFunction.ToByte.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfLong.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfLong.AndChar.this.setValueChar(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfLong.AndChar.this.getKeyLong()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndChar mapToBooleanKey(PrimitiveFunction.ToBoolean.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfLong.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfLong.AndChar.this.setValueChar(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfLong.AndChar.this.getKeyLong()); }
                };
            }
            default PrimitiveEntry.OfLong.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfChar mapper, PrimitiveFunction.ToChar.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndDouble() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndChar.this.getKeyLong(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfLong.AndChar.this.getValueChar()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfLong.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            default PrimitiveEntry.OfLong.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfChar mapper, PrimitiveFunction.ToChar.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndLong() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndChar.this.getKeyLong(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfLong.AndChar.this.getValueChar()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfLong.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            default PrimitiveEntry.OfLong.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfChar mapper, PrimitiveFunction.ToChar.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndInt() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndChar.this.getKeyLong(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfLong.AndChar.this.getValueChar()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfLong.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            default PrimitiveEntry.OfLong.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfChar mapper, PrimitiveFunction.ToChar.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndFloat() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndChar.this.getKeyLong(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfLong.AndChar.this.getValueChar()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfLong.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            default PrimitiveEntry.OfLong.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfChar mapper, PrimitiveFunction.ToChar.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndChar() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndChar.this.getKeyLong(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfLong.AndChar.this.getValueChar()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfLong.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            default PrimitiveEntry.OfLong.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfChar mapper, PrimitiveFunction.ToChar.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndShort() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndChar.this.getKeyLong(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfLong.AndChar.this.getValueChar()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfLong.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            default PrimitiveEntry.OfLong.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfChar mapper, PrimitiveFunction.ToChar.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndByte() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndChar.this.getKeyLong(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfLong.AndChar.this.getValueChar()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfLong.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            default PrimitiveEntry.OfLong.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfChar mapper, PrimitiveFunction.ToChar.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndBoolean() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndChar.this.getKeyLong(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfLong.AndChar.this.getValueChar()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfLong.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            char getValueChar();
            char setValueChar(char value);
        }
        interface AndShort extends OfLong<java.lang.Short> {
            @Override default java.lang.Short getValue() { return getValueShort(); }
            @Override default java.lang.Short setValue(java.lang.Short v) { return setValueShort(v); }
            @Override default PrimitiveEntry.OfDouble.AndShort mapToDoubleKey(PrimitiveFunction.ToDouble.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfLong.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfLong.AndShort.this.setValueShort(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfLong.AndShort.this.getKeyLong()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndShort mapToLongKey(PrimitiveFunction.ToLong.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfLong.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfLong.AndShort.this.setValueShort(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfLong.AndShort.this.getKeyLong()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndShort mapToIntKey(PrimitiveFunction.ToInt.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfLong.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfLong.AndShort.this.setValueShort(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfLong.AndShort.this.getKeyLong()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndShort mapToFloatKey(PrimitiveFunction.ToFloat.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfLong.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfLong.AndShort.this.setValueShort(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfLong.AndShort.this.getKeyLong()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndShort mapToCharKey(PrimitiveFunction.ToChar.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfLong.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfLong.AndShort.this.setValueShort(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfLong.AndShort.this.getKeyLong()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndShort mapToShortKey(PrimitiveFunction.ToShort.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfLong.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfLong.AndShort.this.setValueShort(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfLong.AndShort.this.getKeyLong()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndShort mapToByteKey(PrimitiveFunction.ToByte.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfLong.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfLong.AndShort.this.setValueShort(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfLong.AndShort.this.getKeyLong()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndShort mapToBooleanKey(PrimitiveFunction.ToBoolean.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfLong.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfLong.AndShort.this.setValueShort(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfLong.AndShort.this.getKeyLong()); }
                };
            }
            default PrimitiveEntry.OfLong.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfShort mapper, PrimitiveFunction.ToShort.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndDouble() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndShort.this.getKeyLong(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfLong.AndShort.this.getValueShort()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfLong.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            default PrimitiveEntry.OfLong.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfShort mapper, PrimitiveFunction.ToShort.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndLong() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndShort.this.getKeyLong(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfLong.AndShort.this.getValueShort()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfLong.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            default PrimitiveEntry.OfLong.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfShort mapper, PrimitiveFunction.ToShort.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndInt() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndShort.this.getKeyLong(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfLong.AndShort.this.getValueShort()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfLong.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            default PrimitiveEntry.OfLong.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfShort mapper, PrimitiveFunction.ToShort.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndFloat() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndShort.this.getKeyLong(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfLong.AndShort.this.getValueShort()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfLong.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            default PrimitiveEntry.OfLong.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfShort mapper, PrimitiveFunction.ToShort.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndChar() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndShort.this.getKeyLong(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfLong.AndShort.this.getValueShort()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfLong.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            default PrimitiveEntry.OfLong.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfShort mapper, PrimitiveFunction.ToShort.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndShort() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndShort.this.getKeyLong(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfLong.AndShort.this.getValueShort()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfLong.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            default PrimitiveEntry.OfLong.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfShort mapper, PrimitiveFunction.ToShort.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndByte() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndShort.this.getKeyLong(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfLong.AndShort.this.getValueShort()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfLong.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            default PrimitiveEntry.OfLong.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfShort mapper, PrimitiveFunction.ToShort.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndBoolean() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndShort.this.getKeyLong(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfLong.AndShort.this.getValueShort()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfLong.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            short getValueShort();
            short setValueShort(short value);
        }
        interface AndByte extends OfLong<java.lang.Byte> {
            @Override default java.lang.Byte getValue() { return getValueByte(); }
            @Override default java.lang.Byte setValue(java.lang.Byte v) { return setValueByte(v); }
            @Override default PrimitiveEntry.OfDouble.AndByte mapToDoubleKey(PrimitiveFunction.ToDouble.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfLong.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfLong.AndByte.this.setValueByte(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfLong.AndByte.this.getKeyLong()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndByte mapToLongKey(PrimitiveFunction.ToLong.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfLong.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfLong.AndByte.this.setValueByte(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfLong.AndByte.this.getKeyLong()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndByte mapToIntKey(PrimitiveFunction.ToInt.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfLong.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfLong.AndByte.this.setValueByte(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfLong.AndByte.this.getKeyLong()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndByte mapToFloatKey(PrimitiveFunction.ToFloat.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfLong.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfLong.AndByte.this.setValueByte(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfLong.AndByte.this.getKeyLong()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndByte mapToCharKey(PrimitiveFunction.ToChar.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfLong.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfLong.AndByte.this.setValueByte(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfLong.AndByte.this.getKeyLong()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndByte mapToShortKey(PrimitiveFunction.ToShort.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfLong.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfLong.AndByte.this.setValueByte(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfLong.AndByte.this.getKeyLong()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndByte mapToByteKey(PrimitiveFunction.ToByte.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfLong.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfLong.AndByte.this.setValueByte(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfLong.AndByte.this.getKeyLong()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndByte mapToBooleanKey(PrimitiveFunction.ToBoolean.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfLong.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfLong.AndByte.this.setValueByte(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfLong.AndByte.this.getKeyLong()); }
                };
            }
            default PrimitiveEntry.OfLong.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfByte mapper, PrimitiveFunction.ToByte.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndDouble() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndByte.this.getKeyLong(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfLong.AndByte.this.getValueByte()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfLong.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            default PrimitiveEntry.OfLong.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfByte mapper, PrimitiveFunction.ToByte.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndLong() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndByte.this.getKeyLong(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfLong.AndByte.this.getValueByte()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfLong.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            default PrimitiveEntry.OfLong.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfByte mapper, PrimitiveFunction.ToByte.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndInt() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndByte.this.getKeyLong(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfLong.AndByte.this.getValueByte()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfLong.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            default PrimitiveEntry.OfLong.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfByte mapper, PrimitiveFunction.ToByte.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndFloat() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndByte.this.getKeyLong(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfLong.AndByte.this.getValueByte()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfLong.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            default PrimitiveEntry.OfLong.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfByte mapper, PrimitiveFunction.ToByte.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndChar() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndByte.this.getKeyLong(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfLong.AndByte.this.getValueByte()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfLong.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            default PrimitiveEntry.OfLong.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfByte mapper, PrimitiveFunction.ToByte.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndShort() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndByte.this.getKeyLong(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfLong.AndByte.this.getValueByte()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfLong.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            default PrimitiveEntry.OfLong.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfByte mapper, PrimitiveFunction.ToByte.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndByte() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndByte.this.getKeyLong(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfLong.AndByte.this.getValueByte()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfLong.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            default PrimitiveEntry.OfLong.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfByte mapper, PrimitiveFunction.ToByte.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndBoolean() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndByte.this.getKeyLong(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfLong.AndByte.this.getValueByte()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfLong.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            byte getValueByte();
            byte setValueByte(byte value);
        }
        interface AndBoolean extends OfLong<java.lang.Boolean> {
            @Override default java.lang.Boolean getValue() { return getValueBoolean(); }
            @Override default java.lang.Boolean setValue(java.lang.Boolean v) { return setValueBoolean(v); }
            @Override default PrimitiveEntry.OfDouble.AndBoolean mapToDoubleKey(PrimitiveFunction.ToDouble.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfLong.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfLong.AndBoolean.this.setValueBoolean(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfLong.AndBoolean.this.getKeyLong()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndBoolean mapToLongKey(PrimitiveFunction.ToLong.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfLong.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfLong.AndBoolean.this.setValueBoolean(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfLong.AndBoolean.this.getKeyLong()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndBoolean mapToIntKey(PrimitiveFunction.ToInt.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfLong.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfLong.AndBoolean.this.setValueBoolean(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfLong.AndBoolean.this.getKeyLong()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndBoolean mapToFloatKey(PrimitiveFunction.ToFloat.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfLong.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfLong.AndBoolean.this.setValueBoolean(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfLong.AndBoolean.this.getKeyLong()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndBoolean mapToCharKey(PrimitiveFunction.ToChar.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfLong.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfLong.AndBoolean.this.setValueBoolean(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfLong.AndBoolean.this.getKeyLong()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndBoolean mapToShortKey(PrimitiveFunction.ToShort.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfLong.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfLong.AndBoolean.this.setValueBoolean(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfLong.AndBoolean.this.getKeyLong()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndBoolean mapToByteKey(PrimitiveFunction.ToByte.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfLong.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfLong.AndBoolean.this.setValueBoolean(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfLong.AndBoolean.this.getKeyLong()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndBoolean mapToBooleanKey(PrimitiveFunction.ToBoolean.OfLong mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfLong.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfLong.AndBoolean.this.setValueBoolean(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfLong.AndBoolean.this.getKeyLong()); }
                };
            }
            default PrimitiveEntry.OfLong.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndDouble() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndBoolean.this.getKeyLong(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfLong.AndBoolean.this.getValueBoolean()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfLong.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            default PrimitiveEntry.OfLong.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndLong() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndBoolean.this.getKeyLong(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfLong.AndBoolean.this.getValueBoolean()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfLong.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            default PrimitiveEntry.OfLong.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndInt() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndBoolean.this.getKeyLong(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfLong.AndBoolean.this.getValueBoolean()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfLong.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            default PrimitiveEntry.OfLong.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndFloat() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndBoolean.this.getKeyLong(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfLong.AndBoolean.this.getValueBoolean()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfLong.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            default PrimitiveEntry.OfLong.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndChar() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndBoolean.this.getKeyLong(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfLong.AndBoolean.this.getValueBoolean()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfLong.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            default PrimitiveEntry.OfLong.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndShort() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndBoolean.this.getKeyLong(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfLong.AndBoolean.this.getValueBoolean()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfLong.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            default PrimitiveEntry.OfLong.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndByte() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndBoolean.this.getKeyLong(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfLong.AndBoolean.this.getValueBoolean()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfLong.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            default PrimitiveEntry.OfLong.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfLong.AndBoolean() {
                    public long getKeyLong() { return PrimitiveEntry.OfLong.AndBoolean.this.getKeyLong(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfLong.AndBoolean.this.getValueBoolean()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfLong.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            boolean getValueBoolean();
            boolean setValueBoolean(boolean value);
        }
    }
    interface OfInt<V> extends PrimitiveEntry<java.lang.Integer, V> {
        @Override
        default Map.Entry<java.lang.Integer, V> boxed() { return this; }
        default OfDouble<V> mapToDoubleKey(PrimitiveFunction.ToDouble.OfInt mapper) {
            if(mapper == null) throw new NullPointerException();
            return new OfDouble<V>() {
                public boolean equals(Object o) { return OfInt.this.equals(o); }
                public int hashCode() { return OfInt.this.hashCode(); }
                public double getKeyDouble() { return mapper.applyDouble(OfInt.this.getKeyInt()); }
                public V getValue() { return OfInt.this.getValue(); }
                public V setValue(V v) { return OfInt.this.setValue(v); }
            };
        }
        default OfLong<V> mapToLongKey(PrimitiveFunction.ToLong.OfInt mapper) {
            if(mapper == null) throw new NullPointerException();
            return new OfLong<V>() {
                public boolean equals(Object o) { return OfInt.this.equals(o); }
                public int hashCode() { return OfInt.this.hashCode(); }
                public long getKeyLong() { return mapper.applyLong(OfInt.this.getKeyInt()); }
                public V getValue() { return OfInt.this.getValue(); }
                public V setValue(V v) { return OfInt.this.setValue(v); }
            };
        }
        default OfInt<V> mapToIntKey(PrimitiveFunction.ToInt.OfInt mapper) {
            if(mapper == null) throw new NullPointerException();
            PrimitiveEntry.OfInt<V> thisEnt = this;
            return new OfInt<V>() {
                public boolean equals(Object o) { return thisEnt.equals(o); }
                public int hashCode() { return thisEnt.hashCode(); }
                public int getKeyInt() { return mapper.applyInt(thisEnt.getKeyInt()); }
                public V getValue() { return thisEnt.getValue(); }
                public V setValue(V v) { return thisEnt.setValue(v); }
            };
        }
        default OfFloat<V> mapToFloatKey(PrimitiveFunction.ToFloat.OfInt mapper) {
            if(mapper == null) throw new NullPointerException();
            return new OfFloat<V>() {
                public boolean equals(Object o) { return OfInt.this.equals(o); }
                public int hashCode() { return OfInt.this.hashCode(); }
                public float getKeyFloat() { return mapper.applyFloat(OfInt.this.getKeyInt()); }
                public V getValue() { return OfInt.this.getValue(); }
                public V setValue(V v) { return OfInt.this.setValue(v); }
            };
        }
        default OfChar<V> mapToCharKey(PrimitiveFunction.ToChar.OfInt mapper) {
            if(mapper == null) throw new NullPointerException();
            return new OfChar<V>() {
                public boolean equals(Object o) { return OfInt.this.equals(o); }
                public int hashCode() { return OfInt.this.hashCode(); }
                public char getKeyChar() { return mapper.applyChar(OfInt.this.getKeyInt()); }
                public V getValue() { return OfInt.this.getValue(); }
                public V setValue(V v) { return OfInt.this.setValue(v); }
            };
        }
        default OfShort<V> mapToShortKey(PrimitiveFunction.ToShort.OfInt mapper) {
            if(mapper == null) throw new NullPointerException();
            return new OfShort<V>() {
                public boolean equals(Object o) { return OfInt.this.equals(o); }
                public int hashCode() { return OfInt.this.hashCode(); }
                public short getKeyShort() { return mapper.applyShort(OfInt.this.getKeyInt()); }
                public V getValue() { return OfInt.this.getValue(); }
                public V setValue(V v) { return OfInt.this.setValue(v); }
            };
        }
        default OfByte<V> mapToByteKey(PrimitiveFunction.ToByte.OfInt mapper) {
            if(mapper == null) throw new NullPointerException();
            return new OfByte<V>() {
                public boolean equals(Object o) { return OfInt.this.equals(o); }
                public int hashCode() { return OfInt.this.hashCode(); }
                public byte getKeyByte() { return mapper.applyByte(OfInt.this.getKeyInt()); }
                public V getValue() { return OfInt.this.getValue(); }
                public V setValue(V v) { return OfInt.this.setValue(v); }
            };
        }
        default OfBoolean<V> mapToBooleanKey(PrimitiveFunction.ToBoolean.OfInt mapper) {
            if(mapper == null) throw new NullPointerException();
            return new OfBoolean<V>() {
                public boolean equals(Object o) { return OfInt.this.equals(o); }
                public int hashCode() { return OfInt.this.hashCode(); }
                public boolean getKeyBoolean() { return mapper.applyBoolean(OfInt.this.getKeyInt()); }
                public V getValue() { return OfInt.this.getValue(); }
                public V setValue(V v) { return OfInt.this.setValue(v); }
            };
        }
        @Override default java.lang.Integer getKey() { return OfInt.this.getKeyInt(); }
        int getKeyInt();
        interface AndDouble extends OfInt<java.lang.Double> {
            @Override default java.lang.Double getValue() { return getValueDouble(); }
            @Override default java.lang.Double setValue(java.lang.Double v) { return setValueDouble(v); }
            @Override default PrimitiveEntry.OfDouble.AndDouble mapToDoubleKey(PrimitiveFunction.ToDouble.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfInt.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfInt.AndDouble.this.setValueDouble(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfInt.AndDouble.this.getKeyInt()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndDouble mapToLongKey(PrimitiveFunction.ToLong.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfInt.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfInt.AndDouble.this.setValueDouble(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfInt.AndDouble.this.getKeyInt()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndDouble mapToIntKey(PrimitiveFunction.ToInt.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfInt.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfInt.AndDouble.this.setValueDouble(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfInt.AndDouble.this.getKeyInt()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndDouble mapToFloatKey(PrimitiveFunction.ToFloat.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfInt.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfInt.AndDouble.this.setValueDouble(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfInt.AndDouble.this.getKeyInt()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndDouble mapToCharKey(PrimitiveFunction.ToChar.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfInt.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfInt.AndDouble.this.setValueDouble(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfInt.AndDouble.this.getKeyInt()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndDouble mapToShortKey(PrimitiveFunction.ToShort.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfInt.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfInt.AndDouble.this.setValueDouble(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfInt.AndDouble.this.getKeyInt()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndDouble mapToByteKey(PrimitiveFunction.ToByte.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfInt.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfInt.AndDouble.this.setValueDouble(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfInt.AndDouble.this.getKeyInt()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndDouble mapToBooleanKey(PrimitiveFunction.ToBoolean.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfInt.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfInt.AndDouble.this.setValueDouble(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfInt.AndDouble.this.getKeyInt()); }
                };
            }
            default PrimitiveEntry.OfInt.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfDouble mapper, PrimitiveFunction.ToDouble.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndDouble() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndDouble.this.getKeyInt(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfInt.AndDouble.this.getValueDouble()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfInt.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            default PrimitiveEntry.OfInt.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfDouble mapper, PrimitiveFunction.ToDouble.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndLong() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndDouble.this.getKeyInt(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfInt.AndDouble.this.getValueDouble()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfInt.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            default PrimitiveEntry.OfInt.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfDouble mapper, PrimitiveFunction.ToDouble.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndInt() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndDouble.this.getKeyInt(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfInt.AndDouble.this.getValueDouble()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfInt.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            default PrimitiveEntry.OfInt.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfDouble mapper, PrimitiveFunction.ToDouble.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndFloat() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndDouble.this.getKeyInt(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfInt.AndDouble.this.getValueDouble()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfInt.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            default PrimitiveEntry.OfInt.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfDouble mapper, PrimitiveFunction.ToDouble.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndChar() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndDouble.this.getKeyInt(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfInt.AndDouble.this.getValueDouble()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfInt.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            default PrimitiveEntry.OfInt.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfDouble mapper, PrimitiveFunction.ToDouble.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndShort() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndDouble.this.getKeyInt(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfInt.AndDouble.this.getValueDouble()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfInt.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            default PrimitiveEntry.OfInt.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfDouble mapper, PrimitiveFunction.ToDouble.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndByte() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndDouble.this.getKeyInt(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfInt.AndDouble.this.getValueDouble()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfInt.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            default PrimitiveEntry.OfInt.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfDouble mapper, PrimitiveFunction.ToDouble.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndBoolean() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndDouble.this.getKeyInt(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfInt.AndDouble.this.getValueDouble()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfInt.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            double getValueDouble();
            double setValueDouble(double value);
        }
        interface AndLong extends OfInt<java.lang.Long> {
            @Override default java.lang.Long getValue() { return getValueLong(); }
            @Override default java.lang.Long setValue(java.lang.Long v) { return setValueLong(v); }
            @Override default PrimitiveEntry.OfDouble.AndLong mapToDoubleKey(PrimitiveFunction.ToDouble.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfInt.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfInt.AndLong.this.setValueLong(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfInt.AndLong.this.getKeyInt()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndLong mapToLongKey(PrimitiveFunction.ToLong.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfInt.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfInt.AndLong.this.setValueLong(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfInt.AndLong.this.getKeyInt()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndLong mapToIntKey(PrimitiveFunction.ToInt.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfInt.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfInt.AndLong.this.setValueLong(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfInt.AndLong.this.getKeyInt()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndLong mapToFloatKey(PrimitiveFunction.ToFloat.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfInt.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfInt.AndLong.this.setValueLong(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfInt.AndLong.this.getKeyInt()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndLong mapToCharKey(PrimitiveFunction.ToChar.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfInt.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfInt.AndLong.this.setValueLong(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfInt.AndLong.this.getKeyInt()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndLong mapToShortKey(PrimitiveFunction.ToShort.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfInt.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfInt.AndLong.this.setValueLong(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfInt.AndLong.this.getKeyInt()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndLong mapToByteKey(PrimitiveFunction.ToByte.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfInt.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfInt.AndLong.this.setValueLong(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfInt.AndLong.this.getKeyInt()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndLong mapToBooleanKey(PrimitiveFunction.ToBoolean.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfInt.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfInt.AndLong.this.setValueLong(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfInt.AndLong.this.getKeyInt()); }
                };
            }
            default PrimitiveEntry.OfInt.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfLong mapper, PrimitiveFunction.ToLong.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndDouble() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndLong.this.getKeyInt(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfInt.AndLong.this.getValueLong()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfInt.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            default PrimitiveEntry.OfInt.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfLong mapper, PrimitiveFunction.ToLong.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndLong() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndLong.this.getKeyInt(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfInt.AndLong.this.getValueLong()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfInt.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            default PrimitiveEntry.OfInt.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfLong mapper, PrimitiveFunction.ToLong.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndInt() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndLong.this.getKeyInt(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfInt.AndLong.this.getValueLong()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfInt.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            default PrimitiveEntry.OfInt.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfLong mapper, PrimitiveFunction.ToLong.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndFloat() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndLong.this.getKeyInt(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfInt.AndLong.this.getValueLong()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfInt.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            default PrimitiveEntry.OfInt.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfLong mapper, PrimitiveFunction.ToLong.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndChar() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndLong.this.getKeyInt(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfInt.AndLong.this.getValueLong()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfInt.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            default PrimitiveEntry.OfInt.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfLong mapper, PrimitiveFunction.ToLong.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndShort() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndLong.this.getKeyInt(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfInt.AndLong.this.getValueLong()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfInt.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            default PrimitiveEntry.OfInt.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfLong mapper, PrimitiveFunction.ToLong.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndByte() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndLong.this.getKeyInt(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfInt.AndLong.this.getValueLong()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfInt.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            default PrimitiveEntry.OfInt.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfLong mapper, PrimitiveFunction.ToLong.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndBoolean() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndLong.this.getKeyInt(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfInt.AndLong.this.getValueLong()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfInt.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            long getValueLong();
            long setValueLong(long value);
        }
        interface AndInt extends OfInt<java.lang.Integer> {
            @Override default java.lang.Integer getValue() { return getValueInt(); }
            @Override default java.lang.Integer setValue(java.lang.Integer v) { return setValueInt(v); }
            @Override default PrimitiveEntry.OfDouble.AndInt mapToDoubleKey(PrimitiveFunction.ToDouble.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfInt.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfInt.AndInt.this.setValueInt(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfInt.AndInt.this.getKeyInt()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndInt mapToLongKey(PrimitiveFunction.ToLong.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfInt.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfInt.AndInt.this.setValueInt(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfInt.AndInt.this.getKeyInt()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndInt mapToIntKey(PrimitiveFunction.ToInt.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfInt.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfInt.AndInt.this.setValueInt(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfInt.AndInt.this.getKeyInt()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndInt mapToFloatKey(PrimitiveFunction.ToFloat.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfInt.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfInt.AndInt.this.setValueInt(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfInt.AndInt.this.getKeyInt()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndInt mapToCharKey(PrimitiveFunction.ToChar.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfInt.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfInt.AndInt.this.setValueInt(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfInt.AndInt.this.getKeyInt()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndInt mapToShortKey(PrimitiveFunction.ToShort.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfInt.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfInt.AndInt.this.setValueInt(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfInt.AndInt.this.getKeyInt()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndInt mapToByteKey(PrimitiveFunction.ToByte.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfInt.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfInt.AndInt.this.setValueInt(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfInt.AndInt.this.getKeyInt()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndInt mapToBooleanKey(PrimitiveFunction.ToBoolean.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfInt.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfInt.AndInt.this.setValueInt(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfInt.AndInt.this.getKeyInt()); }
                };
            }
            default PrimitiveEntry.OfInt.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfInt mapper, PrimitiveFunction.ToInt.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndDouble() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndInt.this.getKeyInt(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfInt.AndInt.this.getValueInt()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfInt.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            default PrimitiveEntry.OfInt.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfInt mapper, PrimitiveFunction.ToInt.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndLong() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndInt.this.getKeyInt(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfInt.AndInt.this.getValueInt()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfInt.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            default PrimitiveEntry.OfInt.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfInt mapper, PrimitiveFunction.ToInt.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndInt() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndInt.this.getKeyInt(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfInt.AndInt.this.getValueInt()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfInt.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            default PrimitiveEntry.OfInt.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfInt mapper, PrimitiveFunction.ToInt.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndFloat() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndInt.this.getKeyInt(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfInt.AndInt.this.getValueInt()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfInt.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            default PrimitiveEntry.OfInt.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfInt mapper, PrimitiveFunction.ToInt.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndChar() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndInt.this.getKeyInt(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfInt.AndInt.this.getValueInt()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfInt.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            default PrimitiveEntry.OfInt.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfInt mapper, PrimitiveFunction.ToInt.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndShort() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndInt.this.getKeyInt(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfInt.AndInt.this.getValueInt()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfInt.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            default PrimitiveEntry.OfInt.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfInt mapper, PrimitiveFunction.ToInt.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndByte() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndInt.this.getKeyInt(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfInt.AndInt.this.getValueInt()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfInt.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            default PrimitiveEntry.OfInt.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfInt mapper, PrimitiveFunction.ToInt.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndBoolean() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndInt.this.getKeyInt(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfInt.AndInt.this.getValueInt()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfInt.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            int getValueInt();
            int setValueInt(int value);
        }
        interface AndFloat extends OfInt<java.lang.Float> {
            @Override default java.lang.Float getValue() { return getValueFloat(); }
            @Override default java.lang.Float setValue(java.lang.Float v) { return setValueFloat(v); }
            @Override default PrimitiveEntry.OfDouble.AndFloat mapToDoubleKey(PrimitiveFunction.ToDouble.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfInt.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfInt.AndFloat.this.setValueFloat(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfInt.AndFloat.this.getKeyInt()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndFloat mapToLongKey(PrimitiveFunction.ToLong.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfInt.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfInt.AndFloat.this.setValueFloat(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfInt.AndFloat.this.getKeyInt()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndFloat mapToIntKey(PrimitiveFunction.ToInt.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfInt.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfInt.AndFloat.this.setValueFloat(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfInt.AndFloat.this.getKeyInt()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndFloat mapToFloatKey(PrimitiveFunction.ToFloat.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfInt.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfInt.AndFloat.this.setValueFloat(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfInt.AndFloat.this.getKeyInt()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndFloat mapToCharKey(PrimitiveFunction.ToChar.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfInt.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfInt.AndFloat.this.setValueFloat(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfInt.AndFloat.this.getKeyInt()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndFloat mapToShortKey(PrimitiveFunction.ToShort.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfInt.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfInt.AndFloat.this.setValueFloat(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfInt.AndFloat.this.getKeyInt()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndFloat mapToByteKey(PrimitiveFunction.ToByte.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfInt.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfInt.AndFloat.this.setValueFloat(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfInt.AndFloat.this.getKeyInt()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndFloat mapToBooleanKey(PrimitiveFunction.ToBoolean.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfInt.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfInt.AndFloat.this.setValueFloat(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfInt.AndFloat.this.getKeyInt()); }
                };
            }
            default PrimitiveEntry.OfInt.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfFloat mapper, PrimitiveFunction.ToFloat.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndDouble() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndFloat.this.getKeyInt(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfInt.AndFloat.this.getValueFloat()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfInt.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            default PrimitiveEntry.OfInt.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfFloat mapper, PrimitiveFunction.ToFloat.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndLong() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndFloat.this.getKeyInt(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfInt.AndFloat.this.getValueFloat()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfInt.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            default PrimitiveEntry.OfInt.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfFloat mapper, PrimitiveFunction.ToFloat.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndInt() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndFloat.this.getKeyInt(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfInt.AndFloat.this.getValueFloat()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfInt.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            default PrimitiveEntry.OfInt.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfFloat mapper, PrimitiveFunction.ToFloat.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndFloat() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndFloat.this.getKeyInt(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfInt.AndFloat.this.getValueFloat()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfInt.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            default PrimitiveEntry.OfInt.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfFloat mapper, PrimitiveFunction.ToFloat.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndChar() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndFloat.this.getKeyInt(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfInt.AndFloat.this.getValueFloat()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfInt.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            default PrimitiveEntry.OfInt.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfFloat mapper, PrimitiveFunction.ToFloat.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndShort() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndFloat.this.getKeyInt(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfInt.AndFloat.this.getValueFloat()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfInt.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            default PrimitiveEntry.OfInt.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfFloat mapper, PrimitiveFunction.ToFloat.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndByte() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndFloat.this.getKeyInt(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfInt.AndFloat.this.getValueFloat()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfInt.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            default PrimitiveEntry.OfInt.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfFloat mapper, PrimitiveFunction.ToFloat.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndBoolean() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndFloat.this.getKeyInt(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfInt.AndFloat.this.getValueFloat()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfInt.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            float getValueFloat();
            float setValueFloat(float value);
        }
        interface AndChar extends OfInt<java.lang.Character> {
            @Override default java.lang.Character getValue() { return getValueChar(); }
            @Override default java.lang.Character setValue(java.lang.Character v) { return setValueChar(v); }
            @Override default PrimitiveEntry.OfDouble.AndChar mapToDoubleKey(PrimitiveFunction.ToDouble.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfInt.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfInt.AndChar.this.setValueChar(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfInt.AndChar.this.getKeyInt()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndChar mapToLongKey(PrimitiveFunction.ToLong.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfInt.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfInt.AndChar.this.setValueChar(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfInt.AndChar.this.getKeyInt()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndChar mapToIntKey(PrimitiveFunction.ToInt.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfInt.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfInt.AndChar.this.setValueChar(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfInt.AndChar.this.getKeyInt()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndChar mapToFloatKey(PrimitiveFunction.ToFloat.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfInt.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfInt.AndChar.this.setValueChar(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfInt.AndChar.this.getKeyInt()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndChar mapToCharKey(PrimitiveFunction.ToChar.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfInt.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfInt.AndChar.this.setValueChar(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfInt.AndChar.this.getKeyInt()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndChar mapToShortKey(PrimitiveFunction.ToShort.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfInt.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfInt.AndChar.this.setValueChar(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfInt.AndChar.this.getKeyInt()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndChar mapToByteKey(PrimitiveFunction.ToByte.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfInt.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfInt.AndChar.this.setValueChar(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfInt.AndChar.this.getKeyInt()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndChar mapToBooleanKey(PrimitiveFunction.ToBoolean.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfInt.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfInt.AndChar.this.setValueChar(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfInt.AndChar.this.getKeyInt()); }
                };
            }
            default PrimitiveEntry.OfInt.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfChar mapper, PrimitiveFunction.ToChar.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndDouble() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndChar.this.getKeyInt(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfInt.AndChar.this.getValueChar()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfInt.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            default PrimitiveEntry.OfInt.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfChar mapper, PrimitiveFunction.ToChar.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndLong() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndChar.this.getKeyInt(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfInt.AndChar.this.getValueChar()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfInt.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            default PrimitiveEntry.OfInt.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfChar mapper, PrimitiveFunction.ToChar.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndInt() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndChar.this.getKeyInt(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfInt.AndChar.this.getValueChar()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfInt.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            default PrimitiveEntry.OfInt.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfChar mapper, PrimitiveFunction.ToChar.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndFloat() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndChar.this.getKeyInt(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfInt.AndChar.this.getValueChar()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfInt.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            default PrimitiveEntry.OfInt.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfChar mapper, PrimitiveFunction.ToChar.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndChar() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndChar.this.getKeyInt(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfInt.AndChar.this.getValueChar()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfInt.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            default PrimitiveEntry.OfInt.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfChar mapper, PrimitiveFunction.ToChar.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndShort() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndChar.this.getKeyInt(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfInt.AndChar.this.getValueChar()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfInt.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            default PrimitiveEntry.OfInt.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfChar mapper, PrimitiveFunction.ToChar.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndByte() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndChar.this.getKeyInt(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfInt.AndChar.this.getValueChar()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfInt.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            default PrimitiveEntry.OfInt.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfChar mapper, PrimitiveFunction.ToChar.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndBoolean() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndChar.this.getKeyInt(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfInt.AndChar.this.getValueChar()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfInt.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            char getValueChar();
            char setValueChar(char value);
        }
        interface AndShort extends OfInt<java.lang.Short> {
            @Override default java.lang.Short getValue() { return getValueShort(); }
            @Override default java.lang.Short setValue(java.lang.Short v) { return setValueShort(v); }
            @Override default PrimitiveEntry.OfDouble.AndShort mapToDoubleKey(PrimitiveFunction.ToDouble.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfInt.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfInt.AndShort.this.setValueShort(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfInt.AndShort.this.getKeyInt()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndShort mapToLongKey(PrimitiveFunction.ToLong.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfInt.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfInt.AndShort.this.setValueShort(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfInt.AndShort.this.getKeyInt()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndShort mapToIntKey(PrimitiveFunction.ToInt.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfInt.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfInt.AndShort.this.setValueShort(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfInt.AndShort.this.getKeyInt()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndShort mapToFloatKey(PrimitiveFunction.ToFloat.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfInt.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfInt.AndShort.this.setValueShort(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfInt.AndShort.this.getKeyInt()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndShort mapToCharKey(PrimitiveFunction.ToChar.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfInt.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfInt.AndShort.this.setValueShort(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfInt.AndShort.this.getKeyInt()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndShort mapToShortKey(PrimitiveFunction.ToShort.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfInt.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfInt.AndShort.this.setValueShort(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfInt.AndShort.this.getKeyInt()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndShort mapToByteKey(PrimitiveFunction.ToByte.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfInt.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfInt.AndShort.this.setValueShort(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfInt.AndShort.this.getKeyInt()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndShort mapToBooleanKey(PrimitiveFunction.ToBoolean.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfInt.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfInt.AndShort.this.setValueShort(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfInt.AndShort.this.getKeyInt()); }
                };
            }
            default PrimitiveEntry.OfInt.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfShort mapper, PrimitiveFunction.ToShort.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndDouble() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndShort.this.getKeyInt(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfInt.AndShort.this.getValueShort()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfInt.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            default PrimitiveEntry.OfInt.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfShort mapper, PrimitiveFunction.ToShort.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndLong() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndShort.this.getKeyInt(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfInt.AndShort.this.getValueShort()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfInt.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            default PrimitiveEntry.OfInt.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfShort mapper, PrimitiveFunction.ToShort.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndInt() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndShort.this.getKeyInt(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfInt.AndShort.this.getValueShort()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfInt.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            default PrimitiveEntry.OfInt.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfShort mapper, PrimitiveFunction.ToShort.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndFloat() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndShort.this.getKeyInt(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfInt.AndShort.this.getValueShort()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfInt.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            default PrimitiveEntry.OfInt.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfShort mapper, PrimitiveFunction.ToShort.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndChar() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndShort.this.getKeyInt(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfInt.AndShort.this.getValueShort()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfInt.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            default PrimitiveEntry.OfInt.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfShort mapper, PrimitiveFunction.ToShort.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndShort() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndShort.this.getKeyInt(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfInt.AndShort.this.getValueShort()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfInt.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            default PrimitiveEntry.OfInt.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfShort mapper, PrimitiveFunction.ToShort.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndByte() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndShort.this.getKeyInt(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfInt.AndShort.this.getValueShort()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfInt.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            default PrimitiveEntry.OfInt.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfShort mapper, PrimitiveFunction.ToShort.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndBoolean() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndShort.this.getKeyInt(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfInt.AndShort.this.getValueShort()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfInt.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            short getValueShort();
            short setValueShort(short value);
        }
        interface AndByte extends OfInt<java.lang.Byte> {
            @Override default java.lang.Byte getValue() { return getValueByte(); }
            @Override default java.lang.Byte setValue(java.lang.Byte v) { return setValueByte(v); }
            @Override default PrimitiveEntry.OfDouble.AndByte mapToDoubleKey(PrimitiveFunction.ToDouble.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfInt.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfInt.AndByte.this.setValueByte(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfInt.AndByte.this.getKeyInt()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndByte mapToLongKey(PrimitiveFunction.ToLong.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfInt.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfInt.AndByte.this.setValueByte(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfInt.AndByte.this.getKeyInt()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndByte mapToIntKey(PrimitiveFunction.ToInt.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfInt.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfInt.AndByte.this.setValueByte(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfInt.AndByte.this.getKeyInt()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndByte mapToFloatKey(PrimitiveFunction.ToFloat.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfInt.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfInt.AndByte.this.setValueByte(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfInt.AndByte.this.getKeyInt()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndByte mapToCharKey(PrimitiveFunction.ToChar.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfInt.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfInt.AndByte.this.setValueByte(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfInt.AndByte.this.getKeyInt()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndByte mapToShortKey(PrimitiveFunction.ToShort.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfInt.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfInt.AndByte.this.setValueByte(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfInt.AndByte.this.getKeyInt()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndByte mapToByteKey(PrimitiveFunction.ToByte.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfInt.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfInt.AndByte.this.setValueByte(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfInt.AndByte.this.getKeyInt()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndByte mapToBooleanKey(PrimitiveFunction.ToBoolean.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfInt.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfInt.AndByte.this.setValueByte(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfInt.AndByte.this.getKeyInt()); }
                };
            }
            default PrimitiveEntry.OfInt.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfByte mapper, PrimitiveFunction.ToByte.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndDouble() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndByte.this.getKeyInt(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfInt.AndByte.this.getValueByte()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfInt.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            default PrimitiveEntry.OfInt.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfByte mapper, PrimitiveFunction.ToByte.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndLong() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndByte.this.getKeyInt(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfInt.AndByte.this.getValueByte()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfInt.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            default PrimitiveEntry.OfInt.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfByte mapper, PrimitiveFunction.ToByte.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndInt() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndByte.this.getKeyInt(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfInt.AndByte.this.getValueByte()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfInt.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            default PrimitiveEntry.OfInt.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfByte mapper, PrimitiveFunction.ToByte.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndFloat() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndByte.this.getKeyInt(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfInt.AndByte.this.getValueByte()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfInt.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            default PrimitiveEntry.OfInt.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfByte mapper, PrimitiveFunction.ToByte.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndChar() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndByte.this.getKeyInt(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfInt.AndByte.this.getValueByte()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfInt.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            default PrimitiveEntry.OfInt.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfByte mapper, PrimitiveFunction.ToByte.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndShort() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndByte.this.getKeyInt(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfInt.AndByte.this.getValueByte()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfInt.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            default PrimitiveEntry.OfInt.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfByte mapper, PrimitiveFunction.ToByte.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndByte() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndByte.this.getKeyInt(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfInt.AndByte.this.getValueByte()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfInt.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            default PrimitiveEntry.OfInt.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfByte mapper, PrimitiveFunction.ToByte.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndBoolean() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndByte.this.getKeyInt(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfInt.AndByte.this.getValueByte()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfInt.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            byte getValueByte();
            byte setValueByte(byte value);
        }
        interface AndBoolean extends OfInt<java.lang.Boolean> {
            @Override default java.lang.Boolean getValue() { return getValueBoolean(); }
            @Override default java.lang.Boolean setValue(java.lang.Boolean v) { return setValueBoolean(v); }
            @Override default PrimitiveEntry.OfDouble.AndBoolean mapToDoubleKey(PrimitiveFunction.ToDouble.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfInt.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfInt.AndBoolean.this.setValueBoolean(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfInt.AndBoolean.this.getKeyInt()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndBoolean mapToLongKey(PrimitiveFunction.ToLong.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfInt.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfInt.AndBoolean.this.setValueBoolean(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfInt.AndBoolean.this.getKeyInt()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndBoolean mapToIntKey(PrimitiveFunction.ToInt.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfInt.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfInt.AndBoolean.this.setValueBoolean(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfInt.AndBoolean.this.getKeyInt()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndBoolean mapToFloatKey(PrimitiveFunction.ToFloat.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfInt.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfInt.AndBoolean.this.setValueBoolean(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfInt.AndBoolean.this.getKeyInt()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndBoolean mapToCharKey(PrimitiveFunction.ToChar.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfInt.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfInt.AndBoolean.this.setValueBoolean(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfInt.AndBoolean.this.getKeyInt()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndBoolean mapToShortKey(PrimitiveFunction.ToShort.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfInt.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfInt.AndBoolean.this.setValueBoolean(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfInt.AndBoolean.this.getKeyInt()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndBoolean mapToByteKey(PrimitiveFunction.ToByte.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfInt.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfInt.AndBoolean.this.setValueBoolean(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfInt.AndBoolean.this.getKeyInt()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndBoolean mapToBooleanKey(PrimitiveFunction.ToBoolean.OfInt mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfInt.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfInt.AndBoolean.this.setValueBoolean(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfInt.AndBoolean.this.getKeyInt()); }
                };
            }
            default PrimitiveEntry.OfInt.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndDouble() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndBoolean.this.getKeyInt(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfInt.AndBoolean.this.getValueBoolean()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfInt.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            default PrimitiveEntry.OfInt.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndLong() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndBoolean.this.getKeyInt(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfInt.AndBoolean.this.getValueBoolean()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfInt.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            default PrimitiveEntry.OfInt.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndInt() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndBoolean.this.getKeyInt(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfInt.AndBoolean.this.getValueBoolean()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfInt.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            default PrimitiveEntry.OfInt.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndFloat() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndBoolean.this.getKeyInt(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfInt.AndBoolean.this.getValueBoolean()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfInt.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            default PrimitiveEntry.OfInt.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndChar() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndBoolean.this.getKeyInt(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfInt.AndBoolean.this.getValueBoolean()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfInt.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            default PrimitiveEntry.OfInt.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndShort() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndBoolean.this.getKeyInt(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfInt.AndBoolean.this.getValueBoolean()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfInt.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            default PrimitiveEntry.OfInt.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndByte() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndBoolean.this.getKeyInt(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfInt.AndBoolean.this.getValueBoolean()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfInt.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            default PrimitiveEntry.OfInt.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfInt.AndBoolean() {
                    public int getKeyInt() { return PrimitiveEntry.OfInt.AndBoolean.this.getKeyInt(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfInt.AndBoolean.this.getValueBoolean()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfInt.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            boolean getValueBoolean();
            boolean setValueBoolean(boolean value);
        }
    }
    interface OfFloat<V> extends PrimitiveEntry<java.lang.Float, V> {
        @Override
        default Map.Entry<java.lang.Float, V> boxed() { return this; }
        default OfDouble<V> mapToDoubleKey(PrimitiveFunction.ToDouble.OfFloat mapper) {
            if(mapper == null) throw new NullPointerException();
            return new OfDouble<V>() {
                public boolean equals(Object o) { return OfFloat.this.equals(o); }
                public int hashCode() { return OfFloat.this.hashCode(); }
                public double getKeyDouble() { return mapper.applyDouble(OfFloat.this.getKeyFloat()); }
                public V getValue() { return OfFloat.this.getValue(); }
                public V setValue(V v) { return OfFloat.this.setValue(v); }
            };
        }
        default OfLong<V> mapToLongKey(PrimitiveFunction.ToLong.OfFloat mapper) {
            if(mapper == null) throw new NullPointerException();
            return new OfLong<V>() {
                public boolean equals(Object o) { return OfFloat.this.equals(o); }
                public int hashCode() { return OfFloat.this.hashCode(); }
                public long getKeyLong() { return mapper.applyLong(OfFloat.this.getKeyFloat()); }
                public V getValue() { return OfFloat.this.getValue(); }
                public V setValue(V v) { return OfFloat.this.setValue(v); }
            };
        }
        default OfInt<V> mapToIntKey(PrimitiveFunction.ToInt.OfFloat mapper) {
            if(mapper == null) throw new NullPointerException();
            return new OfInt<V>() {
                public boolean equals(Object o) { return OfFloat.this.equals(o); }
                public int hashCode() { return OfFloat.this.hashCode(); }
                public int getKeyInt() { return mapper.applyInt(OfFloat.this.getKeyFloat()); }
                public V getValue() { return OfFloat.this.getValue(); }
                public V setValue(V v) { return OfFloat.this.setValue(v); }
            };
        }
        default OfFloat<V> mapToFloatKey(PrimitiveFunction.ToFloat.OfFloat mapper) {
            if(mapper == null) throw new NullPointerException();
            PrimitiveEntry.OfFloat<V> thisEnt = this;
            return new OfFloat<V>() {
                public boolean equals(Object o) { return thisEnt.equals(o); }
                public int hashCode() { return thisEnt.hashCode(); }
                public float getKeyFloat() { return mapper.applyFloat(thisEnt.getKeyFloat()); }
                public V getValue() { return thisEnt.getValue(); }
                public V setValue(V v) { return thisEnt.setValue(v); }
            };
        }
        default OfChar<V> mapToCharKey(PrimitiveFunction.ToChar.OfFloat mapper) {
            if(mapper == null) throw new NullPointerException();
            return new OfChar<V>() {
                public boolean equals(Object o) { return OfFloat.this.equals(o); }
                public int hashCode() { return OfFloat.this.hashCode(); }
                public char getKeyChar() { return mapper.applyChar(OfFloat.this.getKeyFloat()); }
                public V getValue() { return OfFloat.this.getValue(); }
                public V setValue(V v) { return OfFloat.this.setValue(v); }
            };
        }
        default OfShort<V> mapToShortKey(PrimitiveFunction.ToShort.OfFloat mapper) {
            if(mapper == null) throw new NullPointerException();
            return new OfShort<V>() {
                public boolean equals(Object o) { return OfFloat.this.equals(o); }
                public int hashCode() { return OfFloat.this.hashCode(); }
                public short getKeyShort() { return mapper.applyShort(OfFloat.this.getKeyFloat()); }
                public V getValue() { return OfFloat.this.getValue(); }
                public V setValue(V v) { return OfFloat.this.setValue(v); }
            };
        }
        default OfByte<V> mapToByteKey(PrimitiveFunction.ToByte.OfFloat mapper) {
            if(mapper == null) throw new NullPointerException();
            return new OfByte<V>() {
                public boolean equals(Object o) { return OfFloat.this.equals(o); }
                public int hashCode() { return OfFloat.this.hashCode(); }
                public byte getKeyByte() { return mapper.applyByte(OfFloat.this.getKeyFloat()); }
                public V getValue() { return OfFloat.this.getValue(); }
                public V setValue(V v) { return OfFloat.this.setValue(v); }
            };
        }
        default OfBoolean<V> mapToBooleanKey(PrimitiveFunction.ToBoolean.OfFloat mapper) {
            if(mapper == null) throw new NullPointerException();
            return new OfBoolean<V>() {
                public boolean equals(Object o) { return OfFloat.this.equals(o); }
                public int hashCode() { return OfFloat.this.hashCode(); }
                public boolean getKeyBoolean() { return mapper.applyBoolean(OfFloat.this.getKeyFloat()); }
                public V getValue() { return OfFloat.this.getValue(); }
                public V setValue(V v) { return OfFloat.this.setValue(v); }
            };
        }
        @Override default java.lang.Float getKey() { return OfFloat.this.getKeyFloat(); }
        float getKeyFloat();
        interface AndDouble extends OfFloat<java.lang.Double> {
            @Override default java.lang.Double getValue() { return getValueDouble(); }
            @Override default java.lang.Double setValue(java.lang.Double v) { return setValueDouble(v); }
            @Override default PrimitiveEntry.OfDouble.AndDouble mapToDoubleKey(PrimitiveFunction.ToDouble.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfFloat.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfFloat.AndDouble.this.setValueDouble(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfFloat.AndDouble.this.getKeyFloat()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndDouble mapToLongKey(PrimitiveFunction.ToLong.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfFloat.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfFloat.AndDouble.this.setValueDouble(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfFloat.AndDouble.this.getKeyFloat()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndDouble mapToIntKey(PrimitiveFunction.ToInt.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfFloat.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfFloat.AndDouble.this.setValueDouble(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfFloat.AndDouble.this.getKeyFloat()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndDouble mapToFloatKey(PrimitiveFunction.ToFloat.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfFloat.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfFloat.AndDouble.this.setValueDouble(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfFloat.AndDouble.this.getKeyFloat()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndDouble mapToCharKey(PrimitiveFunction.ToChar.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfFloat.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfFloat.AndDouble.this.setValueDouble(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfFloat.AndDouble.this.getKeyFloat()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndDouble mapToShortKey(PrimitiveFunction.ToShort.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfFloat.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfFloat.AndDouble.this.setValueDouble(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfFloat.AndDouble.this.getKeyFloat()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndDouble mapToByteKey(PrimitiveFunction.ToByte.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfFloat.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfFloat.AndDouble.this.setValueDouble(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfFloat.AndDouble.this.getKeyFloat()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndDouble mapToBooleanKey(PrimitiveFunction.ToBoolean.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfFloat.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfFloat.AndDouble.this.setValueDouble(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfFloat.AndDouble.this.getKeyFloat()); }
                };
            }
            default PrimitiveEntry.OfFloat.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfDouble mapper, PrimitiveFunction.ToDouble.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndDouble() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndDouble.this.getKeyFloat(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfFloat.AndDouble.this.getValueDouble()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfFloat.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            default PrimitiveEntry.OfFloat.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfDouble mapper, PrimitiveFunction.ToDouble.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndLong() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndDouble.this.getKeyFloat(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfFloat.AndDouble.this.getValueDouble()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfFloat.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            default PrimitiveEntry.OfFloat.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfDouble mapper, PrimitiveFunction.ToDouble.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndInt() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndDouble.this.getKeyFloat(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfFloat.AndDouble.this.getValueDouble()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfFloat.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            default PrimitiveEntry.OfFloat.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfDouble mapper, PrimitiveFunction.ToDouble.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndFloat() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndDouble.this.getKeyFloat(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfFloat.AndDouble.this.getValueDouble()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfFloat.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            default PrimitiveEntry.OfFloat.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfDouble mapper, PrimitiveFunction.ToDouble.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndChar() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndDouble.this.getKeyFloat(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfFloat.AndDouble.this.getValueDouble()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfFloat.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            default PrimitiveEntry.OfFloat.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfDouble mapper, PrimitiveFunction.ToDouble.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndShort() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndDouble.this.getKeyFloat(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfFloat.AndDouble.this.getValueDouble()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfFloat.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            default PrimitiveEntry.OfFloat.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfDouble mapper, PrimitiveFunction.ToDouble.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndByte() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndDouble.this.getKeyFloat(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfFloat.AndDouble.this.getValueDouble()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfFloat.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            default PrimitiveEntry.OfFloat.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfDouble mapper, PrimitiveFunction.ToDouble.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndBoolean() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndDouble.this.getKeyFloat(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfFloat.AndDouble.this.getValueDouble()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfFloat.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            double getValueDouble();
            double setValueDouble(double value);
        }
        interface AndLong extends OfFloat<java.lang.Long> {
            @Override default java.lang.Long getValue() { return getValueLong(); }
            @Override default java.lang.Long setValue(java.lang.Long v) { return setValueLong(v); }
            @Override default PrimitiveEntry.OfDouble.AndLong mapToDoubleKey(PrimitiveFunction.ToDouble.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfFloat.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfFloat.AndLong.this.setValueLong(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfFloat.AndLong.this.getKeyFloat()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndLong mapToLongKey(PrimitiveFunction.ToLong.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfFloat.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfFloat.AndLong.this.setValueLong(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfFloat.AndLong.this.getKeyFloat()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndLong mapToIntKey(PrimitiveFunction.ToInt.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfFloat.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfFloat.AndLong.this.setValueLong(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfFloat.AndLong.this.getKeyFloat()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndLong mapToFloatKey(PrimitiveFunction.ToFloat.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfFloat.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfFloat.AndLong.this.setValueLong(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfFloat.AndLong.this.getKeyFloat()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndLong mapToCharKey(PrimitiveFunction.ToChar.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfFloat.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfFloat.AndLong.this.setValueLong(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfFloat.AndLong.this.getKeyFloat()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndLong mapToShortKey(PrimitiveFunction.ToShort.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfFloat.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfFloat.AndLong.this.setValueLong(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfFloat.AndLong.this.getKeyFloat()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndLong mapToByteKey(PrimitiveFunction.ToByte.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfFloat.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfFloat.AndLong.this.setValueLong(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfFloat.AndLong.this.getKeyFloat()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndLong mapToBooleanKey(PrimitiveFunction.ToBoolean.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfFloat.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfFloat.AndLong.this.setValueLong(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfFloat.AndLong.this.getKeyFloat()); }
                };
            }
            default PrimitiveEntry.OfFloat.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfLong mapper, PrimitiveFunction.ToLong.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndDouble() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndLong.this.getKeyFloat(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfFloat.AndLong.this.getValueLong()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfFloat.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            default PrimitiveEntry.OfFloat.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfLong mapper, PrimitiveFunction.ToLong.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndLong() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndLong.this.getKeyFloat(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfFloat.AndLong.this.getValueLong()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfFloat.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            default PrimitiveEntry.OfFloat.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfLong mapper, PrimitiveFunction.ToLong.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndInt() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndLong.this.getKeyFloat(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfFloat.AndLong.this.getValueLong()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfFloat.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            default PrimitiveEntry.OfFloat.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfLong mapper, PrimitiveFunction.ToLong.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndFloat() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndLong.this.getKeyFloat(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfFloat.AndLong.this.getValueLong()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfFloat.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            default PrimitiveEntry.OfFloat.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfLong mapper, PrimitiveFunction.ToLong.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndChar() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndLong.this.getKeyFloat(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfFloat.AndLong.this.getValueLong()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfFloat.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            default PrimitiveEntry.OfFloat.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfLong mapper, PrimitiveFunction.ToLong.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndShort() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndLong.this.getKeyFloat(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfFloat.AndLong.this.getValueLong()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfFloat.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            default PrimitiveEntry.OfFloat.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfLong mapper, PrimitiveFunction.ToLong.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndByte() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndLong.this.getKeyFloat(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfFloat.AndLong.this.getValueLong()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfFloat.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            default PrimitiveEntry.OfFloat.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfLong mapper, PrimitiveFunction.ToLong.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndBoolean() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndLong.this.getKeyFloat(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfFloat.AndLong.this.getValueLong()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfFloat.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            long getValueLong();
            long setValueLong(long value);
        }
        interface AndInt extends OfFloat<java.lang.Integer> {
            @Override default java.lang.Integer getValue() { return getValueInt(); }
            @Override default java.lang.Integer setValue(java.lang.Integer v) { return setValueInt(v); }
            @Override default PrimitiveEntry.OfDouble.AndInt mapToDoubleKey(PrimitiveFunction.ToDouble.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfFloat.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfFloat.AndInt.this.setValueInt(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfFloat.AndInt.this.getKeyFloat()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndInt mapToLongKey(PrimitiveFunction.ToLong.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfFloat.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfFloat.AndInt.this.setValueInt(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfFloat.AndInt.this.getKeyFloat()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndInt mapToIntKey(PrimitiveFunction.ToInt.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfFloat.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfFloat.AndInt.this.setValueInt(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfFloat.AndInt.this.getKeyFloat()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndInt mapToFloatKey(PrimitiveFunction.ToFloat.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfFloat.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfFloat.AndInt.this.setValueInt(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfFloat.AndInt.this.getKeyFloat()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndInt mapToCharKey(PrimitiveFunction.ToChar.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfFloat.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfFloat.AndInt.this.setValueInt(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfFloat.AndInt.this.getKeyFloat()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndInt mapToShortKey(PrimitiveFunction.ToShort.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfFloat.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfFloat.AndInt.this.setValueInt(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfFloat.AndInt.this.getKeyFloat()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndInt mapToByteKey(PrimitiveFunction.ToByte.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfFloat.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfFloat.AndInt.this.setValueInt(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfFloat.AndInt.this.getKeyFloat()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndInt mapToBooleanKey(PrimitiveFunction.ToBoolean.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfFloat.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfFloat.AndInt.this.setValueInt(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfFloat.AndInt.this.getKeyFloat()); }
                };
            }
            default PrimitiveEntry.OfFloat.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfInt mapper, PrimitiveFunction.ToInt.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndDouble() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndInt.this.getKeyFloat(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfFloat.AndInt.this.getValueInt()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfFloat.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            default PrimitiveEntry.OfFloat.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfInt mapper, PrimitiveFunction.ToInt.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndLong() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndInt.this.getKeyFloat(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfFloat.AndInt.this.getValueInt()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfFloat.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            default PrimitiveEntry.OfFloat.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfInt mapper, PrimitiveFunction.ToInt.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndInt() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndInt.this.getKeyFloat(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfFloat.AndInt.this.getValueInt()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfFloat.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            default PrimitiveEntry.OfFloat.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfInt mapper, PrimitiveFunction.ToInt.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndFloat() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndInt.this.getKeyFloat(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfFloat.AndInt.this.getValueInt()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfFloat.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            default PrimitiveEntry.OfFloat.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfInt mapper, PrimitiveFunction.ToInt.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndChar() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndInt.this.getKeyFloat(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfFloat.AndInt.this.getValueInt()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfFloat.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            default PrimitiveEntry.OfFloat.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfInt mapper, PrimitiveFunction.ToInt.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndShort() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndInt.this.getKeyFloat(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfFloat.AndInt.this.getValueInt()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfFloat.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            default PrimitiveEntry.OfFloat.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfInt mapper, PrimitiveFunction.ToInt.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndByte() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndInt.this.getKeyFloat(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfFloat.AndInt.this.getValueInt()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfFloat.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            default PrimitiveEntry.OfFloat.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfInt mapper, PrimitiveFunction.ToInt.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndBoolean() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndInt.this.getKeyFloat(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfFloat.AndInt.this.getValueInt()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfFloat.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            int getValueInt();
            int setValueInt(int value);
        }
        interface AndFloat extends OfFloat<java.lang.Float> {
            @Override default java.lang.Float getValue() { return getValueFloat(); }
            @Override default java.lang.Float setValue(java.lang.Float v) { return setValueFloat(v); }
            @Override default PrimitiveEntry.OfDouble.AndFloat mapToDoubleKey(PrimitiveFunction.ToDouble.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfFloat.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfFloat.AndFloat.this.setValueFloat(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfFloat.AndFloat.this.getKeyFloat()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndFloat mapToLongKey(PrimitiveFunction.ToLong.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfFloat.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfFloat.AndFloat.this.setValueFloat(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfFloat.AndFloat.this.getKeyFloat()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndFloat mapToIntKey(PrimitiveFunction.ToInt.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfFloat.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfFloat.AndFloat.this.setValueFloat(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfFloat.AndFloat.this.getKeyFloat()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndFloat mapToFloatKey(PrimitiveFunction.ToFloat.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfFloat.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfFloat.AndFloat.this.setValueFloat(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfFloat.AndFloat.this.getKeyFloat()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndFloat mapToCharKey(PrimitiveFunction.ToChar.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfFloat.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfFloat.AndFloat.this.setValueFloat(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfFloat.AndFloat.this.getKeyFloat()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndFloat mapToShortKey(PrimitiveFunction.ToShort.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfFloat.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfFloat.AndFloat.this.setValueFloat(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfFloat.AndFloat.this.getKeyFloat()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndFloat mapToByteKey(PrimitiveFunction.ToByte.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfFloat.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfFloat.AndFloat.this.setValueFloat(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfFloat.AndFloat.this.getKeyFloat()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndFloat mapToBooleanKey(PrimitiveFunction.ToBoolean.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfFloat.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfFloat.AndFloat.this.setValueFloat(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfFloat.AndFloat.this.getKeyFloat()); }
                };
            }
            default PrimitiveEntry.OfFloat.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfFloat mapper, PrimitiveFunction.ToFloat.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndDouble() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndFloat.this.getKeyFloat(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfFloat.AndFloat.this.getValueFloat()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfFloat.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            default PrimitiveEntry.OfFloat.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfFloat mapper, PrimitiveFunction.ToFloat.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndLong() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndFloat.this.getKeyFloat(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfFloat.AndFloat.this.getValueFloat()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfFloat.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            default PrimitiveEntry.OfFloat.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfFloat mapper, PrimitiveFunction.ToFloat.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndInt() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndFloat.this.getKeyFloat(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfFloat.AndFloat.this.getValueFloat()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfFloat.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            default PrimitiveEntry.OfFloat.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfFloat mapper, PrimitiveFunction.ToFloat.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndFloat() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndFloat.this.getKeyFloat(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfFloat.AndFloat.this.getValueFloat()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfFloat.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            default PrimitiveEntry.OfFloat.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfFloat mapper, PrimitiveFunction.ToFloat.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndChar() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndFloat.this.getKeyFloat(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfFloat.AndFloat.this.getValueFloat()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfFloat.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            default PrimitiveEntry.OfFloat.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfFloat mapper, PrimitiveFunction.ToFloat.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndShort() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndFloat.this.getKeyFloat(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfFloat.AndFloat.this.getValueFloat()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfFloat.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            default PrimitiveEntry.OfFloat.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfFloat mapper, PrimitiveFunction.ToFloat.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndByte() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndFloat.this.getKeyFloat(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfFloat.AndFloat.this.getValueFloat()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfFloat.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            default PrimitiveEntry.OfFloat.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfFloat mapper, PrimitiveFunction.ToFloat.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndBoolean() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndFloat.this.getKeyFloat(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfFloat.AndFloat.this.getValueFloat()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfFloat.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            float getValueFloat();
            float setValueFloat(float value);
        }
        interface AndChar extends OfFloat<java.lang.Character> {
            @Override default java.lang.Character getValue() { return getValueChar(); }
            @Override default java.lang.Character setValue(java.lang.Character v) { return setValueChar(v); }
            @Override default PrimitiveEntry.OfDouble.AndChar mapToDoubleKey(PrimitiveFunction.ToDouble.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfFloat.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfFloat.AndChar.this.setValueChar(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfFloat.AndChar.this.getKeyFloat()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndChar mapToLongKey(PrimitiveFunction.ToLong.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfFloat.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfFloat.AndChar.this.setValueChar(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfFloat.AndChar.this.getKeyFloat()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndChar mapToIntKey(PrimitiveFunction.ToInt.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfFloat.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfFloat.AndChar.this.setValueChar(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfFloat.AndChar.this.getKeyFloat()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndChar mapToFloatKey(PrimitiveFunction.ToFloat.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfFloat.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfFloat.AndChar.this.setValueChar(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfFloat.AndChar.this.getKeyFloat()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndChar mapToCharKey(PrimitiveFunction.ToChar.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfFloat.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfFloat.AndChar.this.setValueChar(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfFloat.AndChar.this.getKeyFloat()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndChar mapToShortKey(PrimitiveFunction.ToShort.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfFloat.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfFloat.AndChar.this.setValueChar(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfFloat.AndChar.this.getKeyFloat()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndChar mapToByteKey(PrimitiveFunction.ToByte.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfFloat.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfFloat.AndChar.this.setValueChar(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfFloat.AndChar.this.getKeyFloat()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndChar mapToBooleanKey(PrimitiveFunction.ToBoolean.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfFloat.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfFloat.AndChar.this.setValueChar(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfFloat.AndChar.this.getKeyFloat()); }
                };
            }
            default PrimitiveEntry.OfFloat.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfChar mapper, PrimitiveFunction.ToChar.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndDouble() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndChar.this.getKeyFloat(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfFloat.AndChar.this.getValueChar()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfFloat.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            default PrimitiveEntry.OfFloat.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfChar mapper, PrimitiveFunction.ToChar.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndLong() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndChar.this.getKeyFloat(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfFloat.AndChar.this.getValueChar()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfFloat.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            default PrimitiveEntry.OfFloat.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfChar mapper, PrimitiveFunction.ToChar.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndInt() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndChar.this.getKeyFloat(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfFloat.AndChar.this.getValueChar()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfFloat.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            default PrimitiveEntry.OfFloat.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfChar mapper, PrimitiveFunction.ToChar.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndFloat() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndChar.this.getKeyFloat(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfFloat.AndChar.this.getValueChar()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfFloat.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            default PrimitiveEntry.OfFloat.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfChar mapper, PrimitiveFunction.ToChar.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndChar() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndChar.this.getKeyFloat(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfFloat.AndChar.this.getValueChar()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfFloat.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            default PrimitiveEntry.OfFloat.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfChar mapper, PrimitiveFunction.ToChar.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndShort() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndChar.this.getKeyFloat(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfFloat.AndChar.this.getValueChar()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfFloat.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            default PrimitiveEntry.OfFloat.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfChar mapper, PrimitiveFunction.ToChar.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndByte() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndChar.this.getKeyFloat(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfFloat.AndChar.this.getValueChar()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfFloat.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            default PrimitiveEntry.OfFloat.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfChar mapper, PrimitiveFunction.ToChar.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndBoolean() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndChar.this.getKeyFloat(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfFloat.AndChar.this.getValueChar()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfFloat.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            char getValueChar();
            char setValueChar(char value);
        }
        interface AndShort extends OfFloat<java.lang.Short> {
            @Override default java.lang.Short getValue() { return getValueShort(); }
            @Override default java.lang.Short setValue(java.lang.Short v) { return setValueShort(v); }
            @Override default PrimitiveEntry.OfDouble.AndShort mapToDoubleKey(PrimitiveFunction.ToDouble.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfFloat.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfFloat.AndShort.this.setValueShort(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfFloat.AndShort.this.getKeyFloat()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndShort mapToLongKey(PrimitiveFunction.ToLong.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfFloat.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfFloat.AndShort.this.setValueShort(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfFloat.AndShort.this.getKeyFloat()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndShort mapToIntKey(PrimitiveFunction.ToInt.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfFloat.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfFloat.AndShort.this.setValueShort(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfFloat.AndShort.this.getKeyFloat()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndShort mapToFloatKey(PrimitiveFunction.ToFloat.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfFloat.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfFloat.AndShort.this.setValueShort(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfFloat.AndShort.this.getKeyFloat()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndShort mapToCharKey(PrimitiveFunction.ToChar.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfFloat.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfFloat.AndShort.this.setValueShort(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfFloat.AndShort.this.getKeyFloat()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndShort mapToShortKey(PrimitiveFunction.ToShort.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfFloat.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfFloat.AndShort.this.setValueShort(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfFloat.AndShort.this.getKeyFloat()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndShort mapToByteKey(PrimitiveFunction.ToByte.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfFloat.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfFloat.AndShort.this.setValueShort(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfFloat.AndShort.this.getKeyFloat()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndShort mapToBooleanKey(PrimitiveFunction.ToBoolean.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfFloat.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfFloat.AndShort.this.setValueShort(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfFloat.AndShort.this.getKeyFloat()); }
                };
            }
            default PrimitiveEntry.OfFloat.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfShort mapper, PrimitiveFunction.ToShort.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndDouble() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndShort.this.getKeyFloat(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfFloat.AndShort.this.getValueShort()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfFloat.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            default PrimitiveEntry.OfFloat.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfShort mapper, PrimitiveFunction.ToShort.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndLong() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndShort.this.getKeyFloat(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfFloat.AndShort.this.getValueShort()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfFloat.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            default PrimitiveEntry.OfFloat.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfShort mapper, PrimitiveFunction.ToShort.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndInt() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndShort.this.getKeyFloat(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfFloat.AndShort.this.getValueShort()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfFloat.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            default PrimitiveEntry.OfFloat.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfShort mapper, PrimitiveFunction.ToShort.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndFloat() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndShort.this.getKeyFloat(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfFloat.AndShort.this.getValueShort()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfFloat.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            default PrimitiveEntry.OfFloat.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfShort mapper, PrimitiveFunction.ToShort.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndChar() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndShort.this.getKeyFloat(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfFloat.AndShort.this.getValueShort()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfFloat.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            default PrimitiveEntry.OfFloat.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfShort mapper, PrimitiveFunction.ToShort.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndShort() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndShort.this.getKeyFloat(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfFloat.AndShort.this.getValueShort()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfFloat.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            default PrimitiveEntry.OfFloat.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfShort mapper, PrimitiveFunction.ToShort.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndByte() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndShort.this.getKeyFloat(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfFloat.AndShort.this.getValueShort()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfFloat.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            default PrimitiveEntry.OfFloat.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfShort mapper, PrimitiveFunction.ToShort.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndBoolean() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndShort.this.getKeyFloat(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfFloat.AndShort.this.getValueShort()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfFloat.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            short getValueShort();
            short setValueShort(short value);
        }
        interface AndByte extends OfFloat<java.lang.Byte> {
            @Override default java.lang.Byte getValue() { return getValueByte(); }
            @Override default java.lang.Byte setValue(java.lang.Byte v) { return setValueByte(v); }
            @Override default PrimitiveEntry.OfDouble.AndByte mapToDoubleKey(PrimitiveFunction.ToDouble.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfFloat.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfFloat.AndByte.this.setValueByte(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfFloat.AndByte.this.getKeyFloat()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndByte mapToLongKey(PrimitiveFunction.ToLong.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfFloat.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfFloat.AndByte.this.setValueByte(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfFloat.AndByte.this.getKeyFloat()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndByte mapToIntKey(PrimitiveFunction.ToInt.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfFloat.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfFloat.AndByte.this.setValueByte(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfFloat.AndByte.this.getKeyFloat()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndByte mapToFloatKey(PrimitiveFunction.ToFloat.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfFloat.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfFloat.AndByte.this.setValueByte(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfFloat.AndByte.this.getKeyFloat()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndByte mapToCharKey(PrimitiveFunction.ToChar.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfFloat.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfFloat.AndByte.this.setValueByte(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfFloat.AndByte.this.getKeyFloat()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndByte mapToShortKey(PrimitiveFunction.ToShort.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfFloat.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfFloat.AndByte.this.setValueByte(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfFloat.AndByte.this.getKeyFloat()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndByte mapToByteKey(PrimitiveFunction.ToByte.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfFloat.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfFloat.AndByte.this.setValueByte(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfFloat.AndByte.this.getKeyFloat()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndByte mapToBooleanKey(PrimitiveFunction.ToBoolean.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfFloat.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfFloat.AndByte.this.setValueByte(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfFloat.AndByte.this.getKeyFloat()); }
                };
            }
            default PrimitiveEntry.OfFloat.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfByte mapper, PrimitiveFunction.ToByte.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndDouble() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndByte.this.getKeyFloat(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfFloat.AndByte.this.getValueByte()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfFloat.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            default PrimitiveEntry.OfFloat.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfByte mapper, PrimitiveFunction.ToByte.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndLong() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndByte.this.getKeyFloat(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfFloat.AndByte.this.getValueByte()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfFloat.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            default PrimitiveEntry.OfFloat.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfByte mapper, PrimitiveFunction.ToByte.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndInt() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndByte.this.getKeyFloat(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfFloat.AndByte.this.getValueByte()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfFloat.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            default PrimitiveEntry.OfFloat.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfByte mapper, PrimitiveFunction.ToByte.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndFloat() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndByte.this.getKeyFloat(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfFloat.AndByte.this.getValueByte()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfFloat.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            default PrimitiveEntry.OfFloat.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfByte mapper, PrimitiveFunction.ToByte.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndChar() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndByte.this.getKeyFloat(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfFloat.AndByte.this.getValueByte()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfFloat.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            default PrimitiveEntry.OfFloat.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfByte mapper, PrimitiveFunction.ToByte.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndShort() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndByte.this.getKeyFloat(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfFloat.AndByte.this.getValueByte()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfFloat.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            default PrimitiveEntry.OfFloat.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfByte mapper, PrimitiveFunction.ToByte.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndByte() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndByte.this.getKeyFloat(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfFloat.AndByte.this.getValueByte()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfFloat.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            default PrimitiveEntry.OfFloat.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfByte mapper, PrimitiveFunction.ToByte.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndBoolean() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndByte.this.getKeyFloat(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfFloat.AndByte.this.getValueByte()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfFloat.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            byte getValueByte();
            byte setValueByte(byte value);
        }
        interface AndBoolean extends OfFloat<java.lang.Boolean> {
            @Override default java.lang.Boolean getValue() { return getValueBoolean(); }
            @Override default java.lang.Boolean setValue(java.lang.Boolean v) { return setValueBoolean(v); }
            @Override default PrimitiveEntry.OfDouble.AndBoolean mapToDoubleKey(PrimitiveFunction.ToDouble.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfFloat.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfFloat.AndBoolean.this.setValueBoolean(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfFloat.AndBoolean.this.getKeyFloat()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndBoolean mapToLongKey(PrimitiveFunction.ToLong.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfFloat.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfFloat.AndBoolean.this.setValueBoolean(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfFloat.AndBoolean.this.getKeyFloat()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndBoolean mapToIntKey(PrimitiveFunction.ToInt.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfFloat.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfFloat.AndBoolean.this.setValueBoolean(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfFloat.AndBoolean.this.getKeyFloat()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndBoolean mapToFloatKey(PrimitiveFunction.ToFloat.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfFloat.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfFloat.AndBoolean.this.setValueBoolean(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfFloat.AndBoolean.this.getKeyFloat()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndBoolean mapToCharKey(PrimitiveFunction.ToChar.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfFloat.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfFloat.AndBoolean.this.setValueBoolean(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfFloat.AndBoolean.this.getKeyFloat()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndBoolean mapToShortKey(PrimitiveFunction.ToShort.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfFloat.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfFloat.AndBoolean.this.setValueBoolean(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfFloat.AndBoolean.this.getKeyFloat()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndBoolean mapToByteKey(PrimitiveFunction.ToByte.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfFloat.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfFloat.AndBoolean.this.setValueBoolean(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfFloat.AndBoolean.this.getKeyFloat()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndBoolean mapToBooleanKey(PrimitiveFunction.ToBoolean.OfFloat mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfFloat.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfFloat.AndBoolean.this.setValueBoolean(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfFloat.AndBoolean.this.getKeyFloat()); }
                };
            }
            default PrimitiveEntry.OfFloat.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndDouble() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndBoolean.this.getKeyFloat(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfFloat.AndBoolean.this.getValueBoolean()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfFloat.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            default PrimitiveEntry.OfFloat.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndLong() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndBoolean.this.getKeyFloat(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfFloat.AndBoolean.this.getValueBoolean()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfFloat.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            default PrimitiveEntry.OfFloat.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndInt() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndBoolean.this.getKeyFloat(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfFloat.AndBoolean.this.getValueBoolean()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfFloat.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            default PrimitiveEntry.OfFloat.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndFloat() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndBoolean.this.getKeyFloat(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfFloat.AndBoolean.this.getValueBoolean()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfFloat.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            default PrimitiveEntry.OfFloat.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndChar() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndBoolean.this.getKeyFloat(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfFloat.AndBoolean.this.getValueBoolean()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfFloat.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            default PrimitiveEntry.OfFloat.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndShort() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndBoolean.this.getKeyFloat(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfFloat.AndBoolean.this.getValueBoolean()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfFloat.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            default PrimitiveEntry.OfFloat.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndByte() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndBoolean.this.getKeyFloat(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfFloat.AndBoolean.this.getValueBoolean()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfFloat.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            default PrimitiveEntry.OfFloat.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfFloat.AndBoolean() {
                    public float getKeyFloat() { return PrimitiveEntry.OfFloat.AndBoolean.this.getKeyFloat(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfFloat.AndBoolean.this.getValueBoolean()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfFloat.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            boolean getValueBoolean();
            boolean setValueBoolean(boolean value);
        }
    }
    interface OfChar<V> extends PrimitiveEntry<java.lang.Character, V> {
        @Override
        default Map.Entry<java.lang.Character, V> boxed() { return this; }
        default OfDouble<V> mapToDoubleKey(PrimitiveFunction.ToDouble.OfChar mapper) {
            if(mapper == null) throw new NullPointerException();
            return new OfDouble<V>() {
                public boolean equals(Object o) { return OfChar.this.equals(o); }
                public int hashCode() { return OfChar.this.hashCode(); }
                public double getKeyDouble() { return mapper.applyDouble(OfChar.this.getKeyChar()); }
                public V getValue() { return OfChar.this.getValue(); }
                public V setValue(V v) { return OfChar.this.setValue(v); }
            };
        }
        default OfLong<V> mapToLongKey(PrimitiveFunction.ToLong.OfChar mapper) {
            if(mapper == null) throw new NullPointerException();
            return new OfLong<V>() {
                public boolean equals(Object o) { return OfChar.this.equals(o); }
                public int hashCode() { return OfChar.this.hashCode(); }
                public long getKeyLong() { return mapper.applyLong(OfChar.this.getKeyChar()); }
                public V getValue() { return OfChar.this.getValue(); }
                public V setValue(V v) { return OfChar.this.setValue(v); }
            };
        }
        default OfInt<V> mapToIntKey(PrimitiveFunction.ToInt.OfChar mapper) {
            if(mapper == null) throw new NullPointerException();
            return new OfInt<V>() {
                public boolean equals(Object o) { return OfChar.this.equals(o); }
                public int hashCode() { return OfChar.this.hashCode(); }
                public int getKeyInt() { return mapper.applyInt(OfChar.this.getKeyChar()); }
                public V getValue() { return OfChar.this.getValue(); }
                public V setValue(V v) { return OfChar.this.setValue(v); }
            };
        }
        default OfFloat<V> mapToFloatKey(PrimitiveFunction.ToFloat.OfChar mapper) {
            if(mapper == null) throw new NullPointerException();
            return new OfFloat<V>() {
                public boolean equals(Object o) { return OfChar.this.equals(o); }
                public int hashCode() { return OfChar.this.hashCode(); }
                public float getKeyFloat() { return mapper.applyFloat(OfChar.this.getKeyChar()); }
                public V getValue() { return OfChar.this.getValue(); }
                public V setValue(V v) { return OfChar.this.setValue(v); }
            };
        }
        default OfChar<V> mapToCharKey(PrimitiveFunction.ToChar.OfChar mapper) {
            if(mapper == null) throw new NullPointerException();
            PrimitiveEntry.OfChar<V> thisEnt = this;
            return new OfChar<V>() {
                public boolean equals(Object o) { return thisEnt.equals(o); }
                public int hashCode() { return thisEnt.hashCode(); }
                public char getKeyChar() { return mapper.applyChar(thisEnt.getKeyChar()); }
                public V getValue() { return thisEnt.getValue(); }
                public V setValue(V v) { return thisEnt.setValue(v); }
            };
        }
        default OfShort<V> mapToShortKey(PrimitiveFunction.ToShort.OfChar mapper) {
            if(mapper == null) throw new NullPointerException();
            return new OfShort<V>() {
                public boolean equals(Object o) { return OfChar.this.equals(o); }
                public int hashCode() { return OfChar.this.hashCode(); }
                public short getKeyShort() { return mapper.applyShort(OfChar.this.getKeyChar()); }
                public V getValue() { return OfChar.this.getValue(); }
                public V setValue(V v) { return OfChar.this.setValue(v); }
            };
        }
        default OfByte<V> mapToByteKey(PrimitiveFunction.ToByte.OfChar mapper) {
            if(mapper == null) throw new NullPointerException();
            return new OfByte<V>() {
                public boolean equals(Object o) { return OfChar.this.equals(o); }
                public int hashCode() { return OfChar.this.hashCode(); }
                public byte getKeyByte() { return mapper.applyByte(OfChar.this.getKeyChar()); }
                public V getValue() { return OfChar.this.getValue(); }
                public V setValue(V v) { return OfChar.this.setValue(v); }
            };
        }
        default OfBoolean<V> mapToBooleanKey(PrimitiveFunction.ToBoolean.OfChar mapper) {
            if(mapper == null) throw new NullPointerException();
            return new OfBoolean<V>() {
                public boolean equals(Object o) { return OfChar.this.equals(o); }
                public int hashCode() { return OfChar.this.hashCode(); }
                public boolean getKeyBoolean() { return mapper.applyBoolean(OfChar.this.getKeyChar()); }
                public V getValue() { return OfChar.this.getValue(); }
                public V setValue(V v) { return OfChar.this.setValue(v); }
            };
        }
        @Override default java.lang.Character getKey() { return OfChar.this.getKeyChar(); }
        char getKeyChar();
        interface AndDouble extends OfChar<java.lang.Double> {
            @Override default java.lang.Double getValue() { return getValueDouble(); }
            @Override default java.lang.Double setValue(java.lang.Double v) { return setValueDouble(v); }
            @Override default PrimitiveEntry.OfDouble.AndDouble mapToDoubleKey(PrimitiveFunction.ToDouble.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfChar.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfChar.AndDouble.this.setValueDouble(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfChar.AndDouble.this.getKeyChar()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndDouble mapToLongKey(PrimitiveFunction.ToLong.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfChar.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfChar.AndDouble.this.setValueDouble(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfChar.AndDouble.this.getKeyChar()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndDouble mapToIntKey(PrimitiveFunction.ToInt.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfChar.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfChar.AndDouble.this.setValueDouble(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfChar.AndDouble.this.getKeyChar()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndDouble mapToFloatKey(PrimitiveFunction.ToFloat.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfChar.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfChar.AndDouble.this.setValueDouble(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfChar.AndDouble.this.getKeyChar()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndDouble mapToCharKey(PrimitiveFunction.ToChar.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfChar.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfChar.AndDouble.this.setValueDouble(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfChar.AndDouble.this.getKeyChar()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndDouble mapToShortKey(PrimitiveFunction.ToShort.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfChar.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfChar.AndDouble.this.setValueDouble(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfChar.AndDouble.this.getKeyChar()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndDouble mapToByteKey(PrimitiveFunction.ToByte.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfChar.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfChar.AndDouble.this.setValueDouble(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfChar.AndDouble.this.getKeyChar()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndDouble mapToBooleanKey(PrimitiveFunction.ToBoolean.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfChar.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfChar.AndDouble.this.setValueDouble(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfChar.AndDouble.this.getKeyChar()); }
                };
            }
            default PrimitiveEntry.OfChar.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfDouble mapper, PrimitiveFunction.ToDouble.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndDouble() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndDouble.this.getKeyChar(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfChar.AndDouble.this.getValueDouble()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfChar.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            default PrimitiveEntry.OfChar.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfDouble mapper, PrimitiveFunction.ToDouble.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndLong() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndDouble.this.getKeyChar(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfChar.AndDouble.this.getValueDouble()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfChar.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            default PrimitiveEntry.OfChar.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfDouble mapper, PrimitiveFunction.ToDouble.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndInt() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndDouble.this.getKeyChar(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfChar.AndDouble.this.getValueDouble()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfChar.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            default PrimitiveEntry.OfChar.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfDouble mapper, PrimitiveFunction.ToDouble.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndFloat() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndDouble.this.getKeyChar(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfChar.AndDouble.this.getValueDouble()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfChar.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            default PrimitiveEntry.OfChar.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfDouble mapper, PrimitiveFunction.ToDouble.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndChar() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndDouble.this.getKeyChar(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfChar.AndDouble.this.getValueDouble()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfChar.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            default PrimitiveEntry.OfChar.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfDouble mapper, PrimitiveFunction.ToDouble.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndShort() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndDouble.this.getKeyChar(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfChar.AndDouble.this.getValueDouble()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfChar.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            default PrimitiveEntry.OfChar.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfDouble mapper, PrimitiveFunction.ToDouble.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndByte() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndDouble.this.getKeyChar(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfChar.AndDouble.this.getValueDouble()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfChar.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            default PrimitiveEntry.OfChar.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfDouble mapper, PrimitiveFunction.ToDouble.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndBoolean() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndDouble.this.getKeyChar(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfChar.AndDouble.this.getValueDouble()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfChar.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            double getValueDouble();
            double setValueDouble(double value);
        }
        interface AndLong extends OfChar<java.lang.Long> {
            @Override default java.lang.Long getValue() { return getValueLong(); }
            @Override default java.lang.Long setValue(java.lang.Long v) { return setValueLong(v); }
            @Override default PrimitiveEntry.OfDouble.AndLong mapToDoubleKey(PrimitiveFunction.ToDouble.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfChar.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfChar.AndLong.this.setValueLong(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfChar.AndLong.this.getKeyChar()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndLong mapToLongKey(PrimitiveFunction.ToLong.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfChar.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfChar.AndLong.this.setValueLong(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfChar.AndLong.this.getKeyChar()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndLong mapToIntKey(PrimitiveFunction.ToInt.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfChar.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfChar.AndLong.this.setValueLong(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfChar.AndLong.this.getKeyChar()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndLong mapToFloatKey(PrimitiveFunction.ToFloat.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfChar.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfChar.AndLong.this.setValueLong(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfChar.AndLong.this.getKeyChar()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndLong mapToCharKey(PrimitiveFunction.ToChar.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfChar.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfChar.AndLong.this.setValueLong(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfChar.AndLong.this.getKeyChar()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndLong mapToShortKey(PrimitiveFunction.ToShort.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfChar.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfChar.AndLong.this.setValueLong(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfChar.AndLong.this.getKeyChar()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndLong mapToByteKey(PrimitiveFunction.ToByte.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfChar.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfChar.AndLong.this.setValueLong(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfChar.AndLong.this.getKeyChar()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndLong mapToBooleanKey(PrimitiveFunction.ToBoolean.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfChar.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfChar.AndLong.this.setValueLong(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfChar.AndLong.this.getKeyChar()); }
                };
            }
            default PrimitiveEntry.OfChar.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfLong mapper, PrimitiveFunction.ToLong.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndDouble() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndLong.this.getKeyChar(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfChar.AndLong.this.getValueLong()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfChar.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            default PrimitiveEntry.OfChar.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfLong mapper, PrimitiveFunction.ToLong.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndLong() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndLong.this.getKeyChar(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfChar.AndLong.this.getValueLong()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfChar.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            default PrimitiveEntry.OfChar.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfLong mapper, PrimitiveFunction.ToLong.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndInt() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndLong.this.getKeyChar(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfChar.AndLong.this.getValueLong()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfChar.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            default PrimitiveEntry.OfChar.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfLong mapper, PrimitiveFunction.ToLong.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndFloat() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndLong.this.getKeyChar(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfChar.AndLong.this.getValueLong()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfChar.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            default PrimitiveEntry.OfChar.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfLong mapper, PrimitiveFunction.ToLong.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndChar() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndLong.this.getKeyChar(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfChar.AndLong.this.getValueLong()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfChar.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            default PrimitiveEntry.OfChar.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfLong mapper, PrimitiveFunction.ToLong.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndShort() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndLong.this.getKeyChar(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfChar.AndLong.this.getValueLong()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfChar.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            default PrimitiveEntry.OfChar.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfLong mapper, PrimitiveFunction.ToLong.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndByte() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndLong.this.getKeyChar(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfChar.AndLong.this.getValueLong()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfChar.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            default PrimitiveEntry.OfChar.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfLong mapper, PrimitiveFunction.ToLong.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndBoolean() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndLong.this.getKeyChar(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfChar.AndLong.this.getValueLong()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfChar.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            long getValueLong();
            long setValueLong(long value);
        }
        interface AndInt extends OfChar<java.lang.Integer> {
            @Override default java.lang.Integer getValue() { return getValueInt(); }
            @Override default java.lang.Integer setValue(java.lang.Integer v) { return setValueInt(v); }
            @Override default PrimitiveEntry.OfDouble.AndInt mapToDoubleKey(PrimitiveFunction.ToDouble.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfChar.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfChar.AndInt.this.setValueInt(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfChar.AndInt.this.getKeyChar()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndInt mapToLongKey(PrimitiveFunction.ToLong.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfChar.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfChar.AndInt.this.setValueInt(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfChar.AndInt.this.getKeyChar()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndInt mapToIntKey(PrimitiveFunction.ToInt.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfChar.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfChar.AndInt.this.setValueInt(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfChar.AndInt.this.getKeyChar()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndInt mapToFloatKey(PrimitiveFunction.ToFloat.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfChar.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfChar.AndInt.this.setValueInt(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfChar.AndInt.this.getKeyChar()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndInt mapToCharKey(PrimitiveFunction.ToChar.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfChar.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfChar.AndInt.this.setValueInt(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfChar.AndInt.this.getKeyChar()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndInt mapToShortKey(PrimitiveFunction.ToShort.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfChar.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfChar.AndInt.this.setValueInt(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfChar.AndInt.this.getKeyChar()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndInt mapToByteKey(PrimitiveFunction.ToByte.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfChar.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfChar.AndInt.this.setValueInt(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfChar.AndInt.this.getKeyChar()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndInt mapToBooleanKey(PrimitiveFunction.ToBoolean.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfChar.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfChar.AndInt.this.setValueInt(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfChar.AndInt.this.getKeyChar()); }
                };
            }
            default PrimitiveEntry.OfChar.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfInt mapper, PrimitiveFunction.ToInt.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndDouble() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndInt.this.getKeyChar(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfChar.AndInt.this.getValueInt()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfChar.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            default PrimitiveEntry.OfChar.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfInt mapper, PrimitiveFunction.ToInt.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndLong() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndInt.this.getKeyChar(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfChar.AndInt.this.getValueInt()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfChar.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            default PrimitiveEntry.OfChar.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfInt mapper, PrimitiveFunction.ToInt.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndInt() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndInt.this.getKeyChar(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfChar.AndInt.this.getValueInt()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfChar.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            default PrimitiveEntry.OfChar.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfInt mapper, PrimitiveFunction.ToInt.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndFloat() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndInt.this.getKeyChar(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfChar.AndInt.this.getValueInt()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfChar.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            default PrimitiveEntry.OfChar.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfInt mapper, PrimitiveFunction.ToInt.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndChar() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndInt.this.getKeyChar(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfChar.AndInt.this.getValueInt()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfChar.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            default PrimitiveEntry.OfChar.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfInt mapper, PrimitiveFunction.ToInt.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndShort() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndInt.this.getKeyChar(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfChar.AndInt.this.getValueInt()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfChar.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            default PrimitiveEntry.OfChar.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfInt mapper, PrimitiveFunction.ToInt.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndByte() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndInt.this.getKeyChar(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfChar.AndInt.this.getValueInt()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfChar.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            default PrimitiveEntry.OfChar.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfInt mapper, PrimitiveFunction.ToInt.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndBoolean() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndInt.this.getKeyChar(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfChar.AndInt.this.getValueInt()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfChar.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            int getValueInt();
            int setValueInt(int value);
        }
        interface AndFloat extends OfChar<java.lang.Float> {
            @Override default java.lang.Float getValue() { return getValueFloat(); }
            @Override default java.lang.Float setValue(java.lang.Float v) { return setValueFloat(v); }
            @Override default PrimitiveEntry.OfDouble.AndFloat mapToDoubleKey(PrimitiveFunction.ToDouble.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfChar.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfChar.AndFloat.this.setValueFloat(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfChar.AndFloat.this.getKeyChar()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndFloat mapToLongKey(PrimitiveFunction.ToLong.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfChar.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfChar.AndFloat.this.setValueFloat(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfChar.AndFloat.this.getKeyChar()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndFloat mapToIntKey(PrimitiveFunction.ToInt.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfChar.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfChar.AndFloat.this.setValueFloat(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfChar.AndFloat.this.getKeyChar()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndFloat mapToFloatKey(PrimitiveFunction.ToFloat.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfChar.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfChar.AndFloat.this.setValueFloat(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfChar.AndFloat.this.getKeyChar()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndFloat mapToCharKey(PrimitiveFunction.ToChar.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfChar.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfChar.AndFloat.this.setValueFloat(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfChar.AndFloat.this.getKeyChar()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndFloat mapToShortKey(PrimitiveFunction.ToShort.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfChar.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfChar.AndFloat.this.setValueFloat(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfChar.AndFloat.this.getKeyChar()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndFloat mapToByteKey(PrimitiveFunction.ToByte.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfChar.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfChar.AndFloat.this.setValueFloat(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfChar.AndFloat.this.getKeyChar()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndFloat mapToBooleanKey(PrimitiveFunction.ToBoolean.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfChar.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfChar.AndFloat.this.setValueFloat(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfChar.AndFloat.this.getKeyChar()); }
                };
            }
            default PrimitiveEntry.OfChar.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfFloat mapper, PrimitiveFunction.ToFloat.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndDouble() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndFloat.this.getKeyChar(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfChar.AndFloat.this.getValueFloat()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfChar.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            default PrimitiveEntry.OfChar.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfFloat mapper, PrimitiveFunction.ToFloat.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndLong() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndFloat.this.getKeyChar(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfChar.AndFloat.this.getValueFloat()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfChar.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            default PrimitiveEntry.OfChar.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfFloat mapper, PrimitiveFunction.ToFloat.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndInt() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndFloat.this.getKeyChar(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfChar.AndFloat.this.getValueFloat()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfChar.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            default PrimitiveEntry.OfChar.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfFloat mapper, PrimitiveFunction.ToFloat.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndFloat() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndFloat.this.getKeyChar(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfChar.AndFloat.this.getValueFloat()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfChar.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            default PrimitiveEntry.OfChar.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfFloat mapper, PrimitiveFunction.ToFloat.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndChar() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndFloat.this.getKeyChar(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfChar.AndFloat.this.getValueFloat()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfChar.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            default PrimitiveEntry.OfChar.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfFloat mapper, PrimitiveFunction.ToFloat.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndShort() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndFloat.this.getKeyChar(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfChar.AndFloat.this.getValueFloat()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfChar.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            default PrimitiveEntry.OfChar.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfFloat mapper, PrimitiveFunction.ToFloat.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndByte() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndFloat.this.getKeyChar(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfChar.AndFloat.this.getValueFloat()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfChar.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            default PrimitiveEntry.OfChar.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfFloat mapper, PrimitiveFunction.ToFloat.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndBoolean() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndFloat.this.getKeyChar(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfChar.AndFloat.this.getValueFloat()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfChar.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            float getValueFloat();
            float setValueFloat(float value);
        }
        interface AndChar extends OfChar<java.lang.Character> {
            @Override default java.lang.Character getValue() { return getValueChar(); }
            @Override default java.lang.Character setValue(java.lang.Character v) { return setValueChar(v); }
            @Override default PrimitiveEntry.OfDouble.AndChar mapToDoubleKey(PrimitiveFunction.ToDouble.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfChar.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfChar.AndChar.this.setValueChar(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfChar.AndChar.this.getKeyChar()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndChar mapToLongKey(PrimitiveFunction.ToLong.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfChar.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfChar.AndChar.this.setValueChar(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfChar.AndChar.this.getKeyChar()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndChar mapToIntKey(PrimitiveFunction.ToInt.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfChar.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfChar.AndChar.this.setValueChar(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfChar.AndChar.this.getKeyChar()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndChar mapToFloatKey(PrimitiveFunction.ToFloat.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfChar.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfChar.AndChar.this.setValueChar(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfChar.AndChar.this.getKeyChar()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndChar mapToCharKey(PrimitiveFunction.ToChar.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfChar.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfChar.AndChar.this.setValueChar(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfChar.AndChar.this.getKeyChar()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndChar mapToShortKey(PrimitiveFunction.ToShort.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfChar.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfChar.AndChar.this.setValueChar(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfChar.AndChar.this.getKeyChar()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndChar mapToByteKey(PrimitiveFunction.ToByte.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfChar.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfChar.AndChar.this.setValueChar(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfChar.AndChar.this.getKeyChar()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndChar mapToBooleanKey(PrimitiveFunction.ToBoolean.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfChar.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfChar.AndChar.this.setValueChar(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfChar.AndChar.this.getKeyChar()); }
                };
            }
            default PrimitiveEntry.OfChar.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfChar mapper, PrimitiveFunction.ToChar.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndDouble() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndChar.this.getKeyChar(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfChar.AndChar.this.getValueChar()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfChar.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            default PrimitiveEntry.OfChar.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfChar mapper, PrimitiveFunction.ToChar.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndLong() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndChar.this.getKeyChar(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfChar.AndChar.this.getValueChar()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfChar.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            default PrimitiveEntry.OfChar.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfChar mapper, PrimitiveFunction.ToChar.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndInt() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndChar.this.getKeyChar(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfChar.AndChar.this.getValueChar()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfChar.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            default PrimitiveEntry.OfChar.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfChar mapper, PrimitiveFunction.ToChar.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndFloat() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndChar.this.getKeyChar(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfChar.AndChar.this.getValueChar()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfChar.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            default PrimitiveEntry.OfChar.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfChar mapper, PrimitiveFunction.ToChar.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndChar() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndChar.this.getKeyChar(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfChar.AndChar.this.getValueChar()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfChar.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            default PrimitiveEntry.OfChar.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfChar mapper, PrimitiveFunction.ToChar.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndShort() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndChar.this.getKeyChar(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfChar.AndChar.this.getValueChar()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfChar.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            default PrimitiveEntry.OfChar.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfChar mapper, PrimitiveFunction.ToChar.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndByte() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndChar.this.getKeyChar(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfChar.AndChar.this.getValueChar()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfChar.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            default PrimitiveEntry.OfChar.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfChar mapper, PrimitiveFunction.ToChar.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndBoolean() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndChar.this.getKeyChar(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfChar.AndChar.this.getValueChar()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfChar.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            char getValueChar();
            char setValueChar(char value);
        }
        interface AndShort extends OfChar<java.lang.Short> {
            @Override default java.lang.Short getValue() { return getValueShort(); }
            @Override default java.lang.Short setValue(java.lang.Short v) { return setValueShort(v); }
            @Override default PrimitiveEntry.OfDouble.AndShort mapToDoubleKey(PrimitiveFunction.ToDouble.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfChar.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfChar.AndShort.this.setValueShort(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfChar.AndShort.this.getKeyChar()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndShort mapToLongKey(PrimitiveFunction.ToLong.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfChar.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfChar.AndShort.this.setValueShort(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfChar.AndShort.this.getKeyChar()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndShort mapToIntKey(PrimitiveFunction.ToInt.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfChar.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfChar.AndShort.this.setValueShort(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfChar.AndShort.this.getKeyChar()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndShort mapToFloatKey(PrimitiveFunction.ToFloat.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfChar.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfChar.AndShort.this.setValueShort(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfChar.AndShort.this.getKeyChar()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndShort mapToCharKey(PrimitiveFunction.ToChar.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfChar.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfChar.AndShort.this.setValueShort(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfChar.AndShort.this.getKeyChar()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndShort mapToShortKey(PrimitiveFunction.ToShort.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfChar.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfChar.AndShort.this.setValueShort(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfChar.AndShort.this.getKeyChar()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndShort mapToByteKey(PrimitiveFunction.ToByte.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfChar.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfChar.AndShort.this.setValueShort(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfChar.AndShort.this.getKeyChar()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndShort mapToBooleanKey(PrimitiveFunction.ToBoolean.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfChar.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfChar.AndShort.this.setValueShort(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfChar.AndShort.this.getKeyChar()); }
                };
            }
            default PrimitiveEntry.OfChar.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfShort mapper, PrimitiveFunction.ToShort.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndDouble() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndShort.this.getKeyChar(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfChar.AndShort.this.getValueShort()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfChar.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            default PrimitiveEntry.OfChar.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfShort mapper, PrimitiveFunction.ToShort.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndLong() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndShort.this.getKeyChar(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfChar.AndShort.this.getValueShort()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfChar.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            default PrimitiveEntry.OfChar.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfShort mapper, PrimitiveFunction.ToShort.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndInt() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndShort.this.getKeyChar(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfChar.AndShort.this.getValueShort()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfChar.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            default PrimitiveEntry.OfChar.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfShort mapper, PrimitiveFunction.ToShort.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndFloat() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndShort.this.getKeyChar(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfChar.AndShort.this.getValueShort()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfChar.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            default PrimitiveEntry.OfChar.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfShort mapper, PrimitiveFunction.ToShort.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndChar() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndShort.this.getKeyChar(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfChar.AndShort.this.getValueShort()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfChar.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            default PrimitiveEntry.OfChar.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfShort mapper, PrimitiveFunction.ToShort.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndShort() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndShort.this.getKeyChar(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfChar.AndShort.this.getValueShort()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfChar.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            default PrimitiveEntry.OfChar.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfShort mapper, PrimitiveFunction.ToShort.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndByte() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndShort.this.getKeyChar(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfChar.AndShort.this.getValueShort()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfChar.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            default PrimitiveEntry.OfChar.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfShort mapper, PrimitiveFunction.ToShort.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndBoolean() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndShort.this.getKeyChar(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfChar.AndShort.this.getValueShort()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfChar.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            short getValueShort();
            short setValueShort(short value);
        }
        interface AndByte extends OfChar<java.lang.Byte> {
            @Override default java.lang.Byte getValue() { return getValueByte(); }
            @Override default java.lang.Byte setValue(java.lang.Byte v) { return setValueByte(v); }
            @Override default PrimitiveEntry.OfDouble.AndByte mapToDoubleKey(PrimitiveFunction.ToDouble.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfChar.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfChar.AndByte.this.setValueByte(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfChar.AndByte.this.getKeyChar()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndByte mapToLongKey(PrimitiveFunction.ToLong.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfChar.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfChar.AndByte.this.setValueByte(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfChar.AndByte.this.getKeyChar()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndByte mapToIntKey(PrimitiveFunction.ToInt.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfChar.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfChar.AndByte.this.setValueByte(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfChar.AndByte.this.getKeyChar()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndByte mapToFloatKey(PrimitiveFunction.ToFloat.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfChar.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfChar.AndByte.this.setValueByte(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfChar.AndByte.this.getKeyChar()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndByte mapToCharKey(PrimitiveFunction.ToChar.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfChar.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfChar.AndByte.this.setValueByte(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfChar.AndByte.this.getKeyChar()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndByte mapToShortKey(PrimitiveFunction.ToShort.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfChar.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfChar.AndByte.this.setValueByte(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfChar.AndByte.this.getKeyChar()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndByte mapToByteKey(PrimitiveFunction.ToByte.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfChar.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfChar.AndByte.this.setValueByte(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfChar.AndByte.this.getKeyChar()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndByte mapToBooleanKey(PrimitiveFunction.ToBoolean.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfChar.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfChar.AndByte.this.setValueByte(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfChar.AndByte.this.getKeyChar()); }
                };
            }
            default PrimitiveEntry.OfChar.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfByte mapper, PrimitiveFunction.ToByte.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndDouble() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndByte.this.getKeyChar(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfChar.AndByte.this.getValueByte()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfChar.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            default PrimitiveEntry.OfChar.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfByte mapper, PrimitiveFunction.ToByte.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndLong() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndByte.this.getKeyChar(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfChar.AndByte.this.getValueByte()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfChar.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            default PrimitiveEntry.OfChar.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfByte mapper, PrimitiveFunction.ToByte.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndInt() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndByte.this.getKeyChar(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfChar.AndByte.this.getValueByte()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfChar.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            default PrimitiveEntry.OfChar.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfByte mapper, PrimitiveFunction.ToByte.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndFloat() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndByte.this.getKeyChar(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfChar.AndByte.this.getValueByte()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfChar.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            default PrimitiveEntry.OfChar.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfByte mapper, PrimitiveFunction.ToByte.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndChar() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndByte.this.getKeyChar(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfChar.AndByte.this.getValueByte()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfChar.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            default PrimitiveEntry.OfChar.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfByte mapper, PrimitiveFunction.ToByte.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndShort() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndByte.this.getKeyChar(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfChar.AndByte.this.getValueByte()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfChar.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            default PrimitiveEntry.OfChar.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfByte mapper, PrimitiveFunction.ToByte.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndByte() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndByte.this.getKeyChar(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfChar.AndByte.this.getValueByte()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfChar.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            default PrimitiveEntry.OfChar.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfByte mapper, PrimitiveFunction.ToByte.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndBoolean() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndByte.this.getKeyChar(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfChar.AndByte.this.getValueByte()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfChar.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            byte getValueByte();
            byte setValueByte(byte value);
        }
        interface AndBoolean extends OfChar<java.lang.Boolean> {
            @Override default java.lang.Boolean getValue() { return getValueBoolean(); }
            @Override default java.lang.Boolean setValue(java.lang.Boolean v) { return setValueBoolean(v); }
            @Override default PrimitiveEntry.OfDouble.AndBoolean mapToDoubleKey(PrimitiveFunction.ToDouble.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfChar.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfChar.AndBoolean.this.setValueBoolean(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfChar.AndBoolean.this.getKeyChar()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndBoolean mapToLongKey(PrimitiveFunction.ToLong.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfChar.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfChar.AndBoolean.this.setValueBoolean(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfChar.AndBoolean.this.getKeyChar()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndBoolean mapToIntKey(PrimitiveFunction.ToInt.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfChar.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfChar.AndBoolean.this.setValueBoolean(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfChar.AndBoolean.this.getKeyChar()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndBoolean mapToFloatKey(PrimitiveFunction.ToFloat.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfChar.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfChar.AndBoolean.this.setValueBoolean(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfChar.AndBoolean.this.getKeyChar()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndBoolean mapToCharKey(PrimitiveFunction.ToChar.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfChar.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfChar.AndBoolean.this.setValueBoolean(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfChar.AndBoolean.this.getKeyChar()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndBoolean mapToShortKey(PrimitiveFunction.ToShort.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfChar.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfChar.AndBoolean.this.setValueBoolean(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfChar.AndBoolean.this.getKeyChar()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndBoolean mapToByteKey(PrimitiveFunction.ToByte.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfChar.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfChar.AndBoolean.this.setValueBoolean(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfChar.AndBoolean.this.getKeyChar()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndBoolean mapToBooleanKey(PrimitiveFunction.ToBoolean.OfChar mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfChar.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfChar.AndBoolean.this.setValueBoolean(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfChar.AndBoolean.this.getKeyChar()); }
                };
            }
            default PrimitiveEntry.OfChar.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndDouble() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndBoolean.this.getKeyChar(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfChar.AndBoolean.this.getValueBoolean()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfChar.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            default PrimitiveEntry.OfChar.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndLong() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndBoolean.this.getKeyChar(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfChar.AndBoolean.this.getValueBoolean()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfChar.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            default PrimitiveEntry.OfChar.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndInt() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndBoolean.this.getKeyChar(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfChar.AndBoolean.this.getValueBoolean()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfChar.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            default PrimitiveEntry.OfChar.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndFloat() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndBoolean.this.getKeyChar(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfChar.AndBoolean.this.getValueBoolean()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfChar.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            default PrimitiveEntry.OfChar.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndChar() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndBoolean.this.getKeyChar(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfChar.AndBoolean.this.getValueBoolean()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfChar.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            default PrimitiveEntry.OfChar.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndShort() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndBoolean.this.getKeyChar(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfChar.AndBoolean.this.getValueBoolean()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfChar.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            default PrimitiveEntry.OfChar.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndByte() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndBoolean.this.getKeyChar(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfChar.AndBoolean.this.getValueBoolean()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfChar.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            default PrimitiveEntry.OfChar.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfChar.AndBoolean() {
                    public char getKeyChar() { return PrimitiveEntry.OfChar.AndBoolean.this.getKeyChar(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfChar.AndBoolean.this.getValueBoolean()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfChar.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            boolean getValueBoolean();
            boolean setValueBoolean(boolean value);
        }
    }
    interface OfShort<V> extends PrimitiveEntry<java.lang.Short, V> {
        @Override
        default Map.Entry<java.lang.Short, V> boxed() { return this; }
        default OfDouble<V> mapToDoubleKey(PrimitiveFunction.ToDouble.OfShort mapper) {
            if(mapper == null) throw new NullPointerException();
            return new OfDouble<V>() {
                public boolean equals(Object o) { return OfShort.this.equals(o); }
                public int hashCode() { return OfShort.this.hashCode(); }
                public double getKeyDouble() { return mapper.applyDouble(OfShort.this.getKeyShort()); }
                public V getValue() { return OfShort.this.getValue(); }
                public V setValue(V v) { return OfShort.this.setValue(v); }
            };
        }
        default OfLong<V> mapToLongKey(PrimitiveFunction.ToLong.OfShort mapper) {
            if(mapper == null) throw new NullPointerException();
            return new OfLong<V>() {
                public boolean equals(Object o) { return OfShort.this.equals(o); }
                public int hashCode() { return OfShort.this.hashCode(); }
                public long getKeyLong() { return mapper.applyLong(OfShort.this.getKeyShort()); }
                public V getValue() { return OfShort.this.getValue(); }
                public V setValue(V v) { return OfShort.this.setValue(v); }
            };
        }
        default OfInt<V> mapToIntKey(PrimitiveFunction.ToInt.OfShort mapper) {
            if(mapper == null) throw new NullPointerException();
            return new OfInt<V>() {
                public boolean equals(Object o) { return OfShort.this.equals(o); }
                public int hashCode() { return OfShort.this.hashCode(); }
                public int getKeyInt() { return mapper.applyInt(OfShort.this.getKeyShort()); }
                public V getValue() { return OfShort.this.getValue(); }
                public V setValue(V v) { return OfShort.this.setValue(v); }
            };
        }
        default OfFloat<V> mapToFloatKey(PrimitiveFunction.ToFloat.OfShort mapper) {
            if(mapper == null) throw new NullPointerException();
            return new OfFloat<V>() {
                public boolean equals(Object o) { return OfShort.this.equals(o); }
                public int hashCode() { return OfShort.this.hashCode(); }
                public float getKeyFloat() { return mapper.applyFloat(OfShort.this.getKeyShort()); }
                public V getValue() { return OfShort.this.getValue(); }
                public V setValue(V v) { return OfShort.this.setValue(v); }
            };
        }
        default OfChar<V> mapToCharKey(PrimitiveFunction.ToChar.OfShort mapper) {
            if(mapper == null) throw new NullPointerException();
            return new OfChar<V>() {
                public boolean equals(Object o) { return OfShort.this.equals(o); }
                public int hashCode() { return OfShort.this.hashCode(); }
                public char getKeyChar() { return mapper.applyChar(OfShort.this.getKeyShort()); }
                public V getValue() { return OfShort.this.getValue(); }
                public V setValue(V v) { return OfShort.this.setValue(v); }
            };
        }
        default OfShort<V> mapToShortKey(PrimitiveFunction.ToShort.OfShort mapper) {
            if(mapper == null) throw new NullPointerException();
            PrimitiveEntry.OfShort<V> thisEnt = this;
            return new OfShort<V>() {
                public boolean equals(Object o) { return thisEnt.equals(o); }
                public int hashCode() { return thisEnt.hashCode(); }
                public short getKeyShort() { return mapper.applyShort(thisEnt.getKeyShort()); }
                public V getValue() { return thisEnt.getValue(); }
                public V setValue(V v) { return thisEnt.setValue(v); }
            };
        }
        default OfByte<V> mapToByteKey(PrimitiveFunction.ToByte.OfShort mapper) {
            if(mapper == null) throw new NullPointerException();
            return new OfByte<V>() {
                public boolean equals(Object o) { return OfShort.this.equals(o); }
                public int hashCode() { return OfShort.this.hashCode(); }
                public byte getKeyByte() { return mapper.applyByte(OfShort.this.getKeyShort()); }
                public V getValue() { return OfShort.this.getValue(); }
                public V setValue(V v) { return OfShort.this.setValue(v); }
            };
        }
        default OfBoolean<V> mapToBooleanKey(PrimitiveFunction.ToBoolean.OfShort mapper) {
            if(mapper == null) throw new NullPointerException();
            return new OfBoolean<V>() {
                public boolean equals(Object o) { return OfShort.this.equals(o); }
                public int hashCode() { return OfShort.this.hashCode(); }
                public boolean getKeyBoolean() { return mapper.applyBoolean(OfShort.this.getKeyShort()); }
                public V getValue() { return OfShort.this.getValue(); }
                public V setValue(V v) { return OfShort.this.setValue(v); }
            };
        }
        @Override default java.lang.Short getKey() { return OfShort.this.getKeyShort(); }
        short getKeyShort();
        interface AndDouble extends OfShort<java.lang.Double> {
            @Override default java.lang.Double getValue() { return getValueDouble(); }
            @Override default java.lang.Double setValue(java.lang.Double v) { return setValueDouble(v); }
            @Override default PrimitiveEntry.OfDouble.AndDouble mapToDoubleKey(PrimitiveFunction.ToDouble.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfShort.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfShort.AndDouble.this.setValueDouble(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfShort.AndDouble.this.getKeyShort()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndDouble mapToLongKey(PrimitiveFunction.ToLong.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfShort.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfShort.AndDouble.this.setValueDouble(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfShort.AndDouble.this.getKeyShort()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndDouble mapToIntKey(PrimitiveFunction.ToInt.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfShort.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfShort.AndDouble.this.setValueDouble(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfShort.AndDouble.this.getKeyShort()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndDouble mapToFloatKey(PrimitiveFunction.ToFloat.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfShort.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfShort.AndDouble.this.setValueDouble(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfShort.AndDouble.this.getKeyShort()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndDouble mapToCharKey(PrimitiveFunction.ToChar.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfShort.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfShort.AndDouble.this.setValueDouble(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfShort.AndDouble.this.getKeyShort()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndDouble mapToShortKey(PrimitiveFunction.ToShort.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfShort.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfShort.AndDouble.this.setValueDouble(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfShort.AndDouble.this.getKeyShort()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndDouble mapToByteKey(PrimitiveFunction.ToByte.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfShort.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfShort.AndDouble.this.setValueDouble(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfShort.AndDouble.this.getKeyShort()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndDouble mapToBooleanKey(PrimitiveFunction.ToBoolean.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfShort.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfShort.AndDouble.this.setValueDouble(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfShort.AndDouble.this.getKeyShort()); }
                };
            }
            default PrimitiveEntry.OfShort.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfDouble mapper, PrimitiveFunction.ToDouble.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndDouble() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndDouble.this.getKeyShort(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfShort.AndDouble.this.getValueDouble()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfShort.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            default PrimitiveEntry.OfShort.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfDouble mapper, PrimitiveFunction.ToDouble.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndLong() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndDouble.this.getKeyShort(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfShort.AndDouble.this.getValueDouble()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfShort.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            default PrimitiveEntry.OfShort.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfDouble mapper, PrimitiveFunction.ToDouble.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndInt() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndDouble.this.getKeyShort(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfShort.AndDouble.this.getValueDouble()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfShort.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            default PrimitiveEntry.OfShort.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfDouble mapper, PrimitiveFunction.ToDouble.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndFloat() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndDouble.this.getKeyShort(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfShort.AndDouble.this.getValueDouble()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfShort.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            default PrimitiveEntry.OfShort.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfDouble mapper, PrimitiveFunction.ToDouble.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndChar() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndDouble.this.getKeyShort(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfShort.AndDouble.this.getValueDouble()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfShort.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            default PrimitiveEntry.OfShort.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfDouble mapper, PrimitiveFunction.ToDouble.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndShort() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndDouble.this.getKeyShort(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfShort.AndDouble.this.getValueDouble()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfShort.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            default PrimitiveEntry.OfShort.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfDouble mapper, PrimitiveFunction.ToDouble.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndByte() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndDouble.this.getKeyShort(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfShort.AndDouble.this.getValueDouble()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfShort.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            default PrimitiveEntry.OfShort.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfDouble mapper, PrimitiveFunction.ToDouble.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndBoolean() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndDouble.this.getKeyShort(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfShort.AndDouble.this.getValueDouble()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfShort.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            double getValueDouble();
            double setValueDouble(double value);
        }
        interface AndLong extends OfShort<java.lang.Long> {
            @Override default java.lang.Long getValue() { return getValueLong(); }
            @Override default java.lang.Long setValue(java.lang.Long v) { return setValueLong(v); }
            @Override default PrimitiveEntry.OfDouble.AndLong mapToDoubleKey(PrimitiveFunction.ToDouble.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfShort.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfShort.AndLong.this.setValueLong(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfShort.AndLong.this.getKeyShort()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndLong mapToLongKey(PrimitiveFunction.ToLong.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfShort.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfShort.AndLong.this.setValueLong(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfShort.AndLong.this.getKeyShort()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndLong mapToIntKey(PrimitiveFunction.ToInt.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfShort.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfShort.AndLong.this.setValueLong(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfShort.AndLong.this.getKeyShort()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndLong mapToFloatKey(PrimitiveFunction.ToFloat.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfShort.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfShort.AndLong.this.setValueLong(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfShort.AndLong.this.getKeyShort()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndLong mapToCharKey(PrimitiveFunction.ToChar.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfShort.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfShort.AndLong.this.setValueLong(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfShort.AndLong.this.getKeyShort()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndLong mapToShortKey(PrimitiveFunction.ToShort.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfShort.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfShort.AndLong.this.setValueLong(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfShort.AndLong.this.getKeyShort()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndLong mapToByteKey(PrimitiveFunction.ToByte.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfShort.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfShort.AndLong.this.setValueLong(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfShort.AndLong.this.getKeyShort()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndLong mapToBooleanKey(PrimitiveFunction.ToBoolean.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfShort.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfShort.AndLong.this.setValueLong(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfShort.AndLong.this.getKeyShort()); }
                };
            }
            default PrimitiveEntry.OfShort.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfLong mapper, PrimitiveFunction.ToLong.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndDouble() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndLong.this.getKeyShort(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfShort.AndLong.this.getValueLong()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfShort.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            default PrimitiveEntry.OfShort.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfLong mapper, PrimitiveFunction.ToLong.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndLong() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndLong.this.getKeyShort(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfShort.AndLong.this.getValueLong()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfShort.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            default PrimitiveEntry.OfShort.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfLong mapper, PrimitiveFunction.ToLong.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndInt() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndLong.this.getKeyShort(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfShort.AndLong.this.getValueLong()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfShort.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            default PrimitiveEntry.OfShort.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfLong mapper, PrimitiveFunction.ToLong.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndFloat() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndLong.this.getKeyShort(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfShort.AndLong.this.getValueLong()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfShort.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            default PrimitiveEntry.OfShort.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfLong mapper, PrimitiveFunction.ToLong.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndChar() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndLong.this.getKeyShort(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfShort.AndLong.this.getValueLong()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfShort.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            default PrimitiveEntry.OfShort.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfLong mapper, PrimitiveFunction.ToLong.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndShort() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndLong.this.getKeyShort(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfShort.AndLong.this.getValueLong()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfShort.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            default PrimitiveEntry.OfShort.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfLong mapper, PrimitiveFunction.ToLong.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndByte() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndLong.this.getKeyShort(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfShort.AndLong.this.getValueLong()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfShort.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            default PrimitiveEntry.OfShort.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfLong mapper, PrimitiveFunction.ToLong.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndBoolean() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndLong.this.getKeyShort(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfShort.AndLong.this.getValueLong()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfShort.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            long getValueLong();
            long setValueLong(long value);
        }
        interface AndInt extends OfShort<java.lang.Integer> {
            @Override default java.lang.Integer getValue() { return getValueInt(); }
            @Override default java.lang.Integer setValue(java.lang.Integer v) { return setValueInt(v); }
            @Override default PrimitiveEntry.OfDouble.AndInt mapToDoubleKey(PrimitiveFunction.ToDouble.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfShort.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfShort.AndInt.this.setValueInt(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfShort.AndInt.this.getKeyShort()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndInt mapToLongKey(PrimitiveFunction.ToLong.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfShort.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfShort.AndInt.this.setValueInt(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfShort.AndInt.this.getKeyShort()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndInt mapToIntKey(PrimitiveFunction.ToInt.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfShort.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfShort.AndInt.this.setValueInt(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfShort.AndInt.this.getKeyShort()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndInt mapToFloatKey(PrimitiveFunction.ToFloat.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfShort.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfShort.AndInt.this.setValueInt(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfShort.AndInt.this.getKeyShort()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndInt mapToCharKey(PrimitiveFunction.ToChar.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfShort.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfShort.AndInt.this.setValueInt(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfShort.AndInt.this.getKeyShort()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndInt mapToShortKey(PrimitiveFunction.ToShort.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfShort.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfShort.AndInt.this.setValueInt(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfShort.AndInt.this.getKeyShort()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndInt mapToByteKey(PrimitiveFunction.ToByte.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfShort.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfShort.AndInt.this.setValueInt(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfShort.AndInt.this.getKeyShort()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndInt mapToBooleanKey(PrimitiveFunction.ToBoolean.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfShort.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfShort.AndInt.this.setValueInt(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfShort.AndInt.this.getKeyShort()); }
                };
            }
            default PrimitiveEntry.OfShort.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfInt mapper, PrimitiveFunction.ToInt.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndDouble() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndInt.this.getKeyShort(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfShort.AndInt.this.getValueInt()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfShort.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            default PrimitiveEntry.OfShort.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfInt mapper, PrimitiveFunction.ToInt.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndLong() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndInt.this.getKeyShort(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfShort.AndInt.this.getValueInt()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfShort.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            default PrimitiveEntry.OfShort.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfInt mapper, PrimitiveFunction.ToInt.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndInt() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndInt.this.getKeyShort(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfShort.AndInt.this.getValueInt()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfShort.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            default PrimitiveEntry.OfShort.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfInt mapper, PrimitiveFunction.ToInt.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndFloat() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndInt.this.getKeyShort(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfShort.AndInt.this.getValueInt()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfShort.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            default PrimitiveEntry.OfShort.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfInt mapper, PrimitiveFunction.ToInt.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndChar() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndInt.this.getKeyShort(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfShort.AndInt.this.getValueInt()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfShort.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            default PrimitiveEntry.OfShort.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfInt mapper, PrimitiveFunction.ToInt.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndShort() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndInt.this.getKeyShort(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfShort.AndInt.this.getValueInt()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfShort.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            default PrimitiveEntry.OfShort.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfInt mapper, PrimitiveFunction.ToInt.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndByte() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndInt.this.getKeyShort(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfShort.AndInt.this.getValueInt()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfShort.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            default PrimitiveEntry.OfShort.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfInt mapper, PrimitiveFunction.ToInt.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndBoolean() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndInt.this.getKeyShort(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfShort.AndInt.this.getValueInt()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfShort.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            int getValueInt();
            int setValueInt(int value);
        }
        interface AndFloat extends OfShort<java.lang.Float> {
            @Override default java.lang.Float getValue() { return getValueFloat(); }
            @Override default java.lang.Float setValue(java.lang.Float v) { return setValueFloat(v); }
            @Override default PrimitiveEntry.OfDouble.AndFloat mapToDoubleKey(PrimitiveFunction.ToDouble.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfShort.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfShort.AndFloat.this.setValueFloat(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfShort.AndFloat.this.getKeyShort()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndFloat mapToLongKey(PrimitiveFunction.ToLong.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfShort.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfShort.AndFloat.this.setValueFloat(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfShort.AndFloat.this.getKeyShort()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndFloat mapToIntKey(PrimitiveFunction.ToInt.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfShort.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfShort.AndFloat.this.setValueFloat(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfShort.AndFloat.this.getKeyShort()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndFloat mapToFloatKey(PrimitiveFunction.ToFloat.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfShort.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfShort.AndFloat.this.setValueFloat(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfShort.AndFloat.this.getKeyShort()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndFloat mapToCharKey(PrimitiveFunction.ToChar.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfShort.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfShort.AndFloat.this.setValueFloat(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfShort.AndFloat.this.getKeyShort()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndFloat mapToShortKey(PrimitiveFunction.ToShort.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfShort.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfShort.AndFloat.this.setValueFloat(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfShort.AndFloat.this.getKeyShort()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndFloat mapToByteKey(PrimitiveFunction.ToByte.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfShort.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfShort.AndFloat.this.setValueFloat(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfShort.AndFloat.this.getKeyShort()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndFloat mapToBooleanKey(PrimitiveFunction.ToBoolean.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfShort.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfShort.AndFloat.this.setValueFloat(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfShort.AndFloat.this.getKeyShort()); }
                };
            }
            default PrimitiveEntry.OfShort.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfFloat mapper, PrimitiveFunction.ToFloat.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndDouble() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndFloat.this.getKeyShort(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfShort.AndFloat.this.getValueFloat()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfShort.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            default PrimitiveEntry.OfShort.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfFloat mapper, PrimitiveFunction.ToFloat.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndLong() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndFloat.this.getKeyShort(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfShort.AndFloat.this.getValueFloat()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfShort.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            default PrimitiveEntry.OfShort.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfFloat mapper, PrimitiveFunction.ToFloat.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndInt() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndFloat.this.getKeyShort(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfShort.AndFloat.this.getValueFloat()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfShort.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            default PrimitiveEntry.OfShort.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfFloat mapper, PrimitiveFunction.ToFloat.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndFloat() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndFloat.this.getKeyShort(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfShort.AndFloat.this.getValueFloat()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfShort.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            default PrimitiveEntry.OfShort.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfFloat mapper, PrimitiveFunction.ToFloat.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndChar() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndFloat.this.getKeyShort(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfShort.AndFloat.this.getValueFloat()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfShort.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            default PrimitiveEntry.OfShort.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfFloat mapper, PrimitiveFunction.ToFloat.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndShort() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndFloat.this.getKeyShort(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfShort.AndFloat.this.getValueFloat()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfShort.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            default PrimitiveEntry.OfShort.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfFloat mapper, PrimitiveFunction.ToFloat.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndByte() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndFloat.this.getKeyShort(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfShort.AndFloat.this.getValueFloat()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfShort.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            default PrimitiveEntry.OfShort.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfFloat mapper, PrimitiveFunction.ToFloat.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndBoolean() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndFloat.this.getKeyShort(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfShort.AndFloat.this.getValueFloat()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfShort.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            float getValueFloat();
            float setValueFloat(float value);
        }
        interface AndChar extends OfShort<java.lang.Character> {
            @Override default java.lang.Character getValue() { return getValueChar(); }
            @Override default java.lang.Character setValue(java.lang.Character v) { return setValueChar(v); }
            @Override default PrimitiveEntry.OfDouble.AndChar mapToDoubleKey(PrimitiveFunction.ToDouble.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfShort.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfShort.AndChar.this.setValueChar(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfShort.AndChar.this.getKeyShort()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndChar mapToLongKey(PrimitiveFunction.ToLong.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfShort.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfShort.AndChar.this.setValueChar(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfShort.AndChar.this.getKeyShort()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndChar mapToIntKey(PrimitiveFunction.ToInt.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfShort.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfShort.AndChar.this.setValueChar(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfShort.AndChar.this.getKeyShort()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndChar mapToFloatKey(PrimitiveFunction.ToFloat.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfShort.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfShort.AndChar.this.setValueChar(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfShort.AndChar.this.getKeyShort()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndChar mapToCharKey(PrimitiveFunction.ToChar.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfShort.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfShort.AndChar.this.setValueChar(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfShort.AndChar.this.getKeyShort()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndChar mapToShortKey(PrimitiveFunction.ToShort.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfShort.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfShort.AndChar.this.setValueChar(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfShort.AndChar.this.getKeyShort()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndChar mapToByteKey(PrimitiveFunction.ToByte.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfShort.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfShort.AndChar.this.setValueChar(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfShort.AndChar.this.getKeyShort()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndChar mapToBooleanKey(PrimitiveFunction.ToBoolean.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfShort.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfShort.AndChar.this.setValueChar(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfShort.AndChar.this.getKeyShort()); }
                };
            }
            default PrimitiveEntry.OfShort.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfChar mapper, PrimitiveFunction.ToChar.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndDouble() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndChar.this.getKeyShort(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfShort.AndChar.this.getValueChar()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfShort.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            default PrimitiveEntry.OfShort.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfChar mapper, PrimitiveFunction.ToChar.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndLong() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndChar.this.getKeyShort(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfShort.AndChar.this.getValueChar()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfShort.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            default PrimitiveEntry.OfShort.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfChar mapper, PrimitiveFunction.ToChar.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndInt() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndChar.this.getKeyShort(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfShort.AndChar.this.getValueChar()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfShort.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            default PrimitiveEntry.OfShort.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfChar mapper, PrimitiveFunction.ToChar.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndFloat() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndChar.this.getKeyShort(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfShort.AndChar.this.getValueChar()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfShort.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            default PrimitiveEntry.OfShort.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfChar mapper, PrimitiveFunction.ToChar.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndChar() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndChar.this.getKeyShort(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfShort.AndChar.this.getValueChar()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfShort.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            default PrimitiveEntry.OfShort.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfChar mapper, PrimitiveFunction.ToChar.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndShort() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndChar.this.getKeyShort(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfShort.AndChar.this.getValueChar()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfShort.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            default PrimitiveEntry.OfShort.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfChar mapper, PrimitiveFunction.ToChar.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndByte() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndChar.this.getKeyShort(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfShort.AndChar.this.getValueChar()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfShort.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            default PrimitiveEntry.OfShort.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfChar mapper, PrimitiveFunction.ToChar.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndBoolean() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndChar.this.getKeyShort(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfShort.AndChar.this.getValueChar()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfShort.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            char getValueChar();
            char setValueChar(char value);
        }
        interface AndShort extends OfShort<java.lang.Short> {
            @Override default java.lang.Short getValue() { return getValueShort(); }
            @Override default java.lang.Short setValue(java.lang.Short v) { return setValueShort(v); }
            @Override default PrimitiveEntry.OfDouble.AndShort mapToDoubleKey(PrimitiveFunction.ToDouble.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfShort.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfShort.AndShort.this.setValueShort(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfShort.AndShort.this.getKeyShort()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndShort mapToLongKey(PrimitiveFunction.ToLong.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfShort.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfShort.AndShort.this.setValueShort(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfShort.AndShort.this.getKeyShort()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndShort mapToIntKey(PrimitiveFunction.ToInt.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfShort.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfShort.AndShort.this.setValueShort(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfShort.AndShort.this.getKeyShort()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndShort mapToFloatKey(PrimitiveFunction.ToFloat.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfShort.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfShort.AndShort.this.setValueShort(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfShort.AndShort.this.getKeyShort()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndShort mapToCharKey(PrimitiveFunction.ToChar.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfShort.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfShort.AndShort.this.setValueShort(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfShort.AndShort.this.getKeyShort()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndShort mapToShortKey(PrimitiveFunction.ToShort.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfShort.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfShort.AndShort.this.setValueShort(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfShort.AndShort.this.getKeyShort()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndShort mapToByteKey(PrimitiveFunction.ToByte.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfShort.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfShort.AndShort.this.setValueShort(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfShort.AndShort.this.getKeyShort()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndShort mapToBooleanKey(PrimitiveFunction.ToBoolean.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfShort.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfShort.AndShort.this.setValueShort(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfShort.AndShort.this.getKeyShort()); }
                };
            }
            default PrimitiveEntry.OfShort.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfShort mapper, PrimitiveFunction.ToShort.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndDouble() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndShort.this.getKeyShort(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfShort.AndShort.this.getValueShort()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfShort.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            default PrimitiveEntry.OfShort.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfShort mapper, PrimitiveFunction.ToShort.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndLong() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndShort.this.getKeyShort(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfShort.AndShort.this.getValueShort()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfShort.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            default PrimitiveEntry.OfShort.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfShort mapper, PrimitiveFunction.ToShort.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndInt() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndShort.this.getKeyShort(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfShort.AndShort.this.getValueShort()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfShort.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            default PrimitiveEntry.OfShort.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfShort mapper, PrimitiveFunction.ToShort.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndFloat() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndShort.this.getKeyShort(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfShort.AndShort.this.getValueShort()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfShort.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            default PrimitiveEntry.OfShort.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfShort mapper, PrimitiveFunction.ToShort.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndChar() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndShort.this.getKeyShort(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfShort.AndShort.this.getValueShort()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfShort.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            default PrimitiveEntry.OfShort.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfShort mapper, PrimitiveFunction.ToShort.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndShort() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndShort.this.getKeyShort(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfShort.AndShort.this.getValueShort()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfShort.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            default PrimitiveEntry.OfShort.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfShort mapper, PrimitiveFunction.ToShort.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndByte() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndShort.this.getKeyShort(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfShort.AndShort.this.getValueShort()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfShort.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            default PrimitiveEntry.OfShort.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfShort mapper, PrimitiveFunction.ToShort.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndBoolean() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndShort.this.getKeyShort(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfShort.AndShort.this.getValueShort()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfShort.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            short getValueShort();
            short setValueShort(short value);
        }
        interface AndByte extends OfShort<java.lang.Byte> {
            @Override default java.lang.Byte getValue() { return getValueByte(); }
            @Override default java.lang.Byte setValue(java.lang.Byte v) { return setValueByte(v); }
            @Override default PrimitiveEntry.OfDouble.AndByte mapToDoubleKey(PrimitiveFunction.ToDouble.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfShort.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfShort.AndByte.this.setValueByte(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfShort.AndByte.this.getKeyShort()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndByte mapToLongKey(PrimitiveFunction.ToLong.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfShort.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfShort.AndByte.this.setValueByte(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfShort.AndByte.this.getKeyShort()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndByte mapToIntKey(PrimitiveFunction.ToInt.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfShort.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfShort.AndByte.this.setValueByte(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfShort.AndByte.this.getKeyShort()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndByte mapToFloatKey(PrimitiveFunction.ToFloat.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfShort.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfShort.AndByte.this.setValueByte(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfShort.AndByte.this.getKeyShort()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndByte mapToCharKey(PrimitiveFunction.ToChar.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfShort.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfShort.AndByte.this.setValueByte(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfShort.AndByte.this.getKeyShort()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndByte mapToShortKey(PrimitiveFunction.ToShort.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfShort.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfShort.AndByte.this.setValueByte(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfShort.AndByte.this.getKeyShort()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndByte mapToByteKey(PrimitiveFunction.ToByte.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfShort.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfShort.AndByte.this.setValueByte(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfShort.AndByte.this.getKeyShort()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndByte mapToBooleanKey(PrimitiveFunction.ToBoolean.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfShort.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfShort.AndByte.this.setValueByte(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfShort.AndByte.this.getKeyShort()); }
                };
            }
            default PrimitiveEntry.OfShort.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfByte mapper, PrimitiveFunction.ToByte.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndDouble() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndByte.this.getKeyShort(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfShort.AndByte.this.getValueByte()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfShort.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            default PrimitiveEntry.OfShort.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfByte mapper, PrimitiveFunction.ToByte.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndLong() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndByte.this.getKeyShort(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfShort.AndByte.this.getValueByte()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfShort.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            default PrimitiveEntry.OfShort.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfByte mapper, PrimitiveFunction.ToByte.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndInt() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndByte.this.getKeyShort(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfShort.AndByte.this.getValueByte()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfShort.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            default PrimitiveEntry.OfShort.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfByte mapper, PrimitiveFunction.ToByte.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndFloat() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndByte.this.getKeyShort(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfShort.AndByte.this.getValueByte()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfShort.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            default PrimitiveEntry.OfShort.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfByte mapper, PrimitiveFunction.ToByte.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndChar() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndByte.this.getKeyShort(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfShort.AndByte.this.getValueByte()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfShort.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            default PrimitiveEntry.OfShort.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfByte mapper, PrimitiveFunction.ToByte.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndShort() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndByte.this.getKeyShort(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfShort.AndByte.this.getValueByte()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfShort.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            default PrimitiveEntry.OfShort.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfByte mapper, PrimitiveFunction.ToByte.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndByte() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndByte.this.getKeyShort(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfShort.AndByte.this.getValueByte()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfShort.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            default PrimitiveEntry.OfShort.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfByte mapper, PrimitiveFunction.ToByte.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndBoolean() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndByte.this.getKeyShort(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfShort.AndByte.this.getValueByte()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfShort.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            byte getValueByte();
            byte setValueByte(byte value);
        }
        interface AndBoolean extends OfShort<java.lang.Boolean> {
            @Override default java.lang.Boolean getValue() { return getValueBoolean(); }
            @Override default java.lang.Boolean setValue(java.lang.Boolean v) { return setValueBoolean(v); }
            @Override default PrimitiveEntry.OfDouble.AndBoolean mapToDoubleKey(PrimitiveFunction.ToDouble.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfShort.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfShort.AndBoolean.this.setValueBoolean(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfShort.AndBoolean.this.getKeyShort()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndBoolean mapToLongKey(PrimitiveFunction.ToLong.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfShort.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfShort.AndBoolean.this.setValueBoolean(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfShort.AndBoolean.this.getKeyShort()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndBoolean mapToIntKey(PrimitiveFunction.ToInt.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfShort.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfShort.AndBoolean.this.setValueBoolean(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfShort.AndBoolean.this.getKeyShort()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndBoolean mapToFloatKey(PrimitiveFunction.ToFloat.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfShort.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfShort.AndBoolean.this.setValueBoolean(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfShort.AndBoolean.this.getKeyShort()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndBoolean mapToCharKey(PrimitiveFunction.ToChar.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfShort.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfShort.AndBoolean.this.setValueBoolean(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfShort.AndBoolean.this.getKeyShort()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndBoolean mapToShortKey(PrimitiveFunction.ToShort.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfShort.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfShort.AndBoolean.this.setValueBoolean(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfShort.AndBoolean.this.getKeyShort()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndBoolean mapToByteKey(PrimitiveFunction.ToByte.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfShort.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfShort.AndBoolean.this.setValueBoolean(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfShort.AndBoolean.this.getKeyShort()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndBoolean mapToBooleanKey(PrimitiveFunction.ToBoolean.OfShort mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfShort.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfShort.AndBoolean.this.setValueBoolean(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfShort.AndBoolean.this.getKeyShort()); }
                };
            }
            default PrimitiveEntry.OfShort.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndDouble() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndBoolean.this.getKeyShort(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfShort.AndBoolean.this.getValueBoolean()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfShort.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            default PrimitiveEntry.OfShort.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndLong() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndBoolean.this.getKeyShort(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfShort.AndBoolean.this.getValueBoolean()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfShort.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            default PrimitiveEntry.OfShort.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndInt() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndBoolean.this.getKeyShort(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfShort.AndBoolean.this.getValueBoolean()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfShort.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            default PrimitiveEntry.OfShort.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndFloat() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndBoolean.this.getKeyShort(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfShort.AndBoolean.this.getValueBoolean()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfShort.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            default PrimitiveEntry.OfShort.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndChar() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndBoolean.this.getKeyShort(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfShort.AndBoolean.this.getValueBoolean()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfShort.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            default PrimitiveEntry.OfShort.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndShort() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndBoolean.this.getKeyShort(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfShort.AndBoolean.this.getValueBoolean()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfShort.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            default PrimitiveEntry.OfShort.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndByte() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndBoolean.this.getKeyShort(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfShort.AndBoolean.this.getValueBoolean()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfShort.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            default PrimitiveEntry.OfShort.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfShort.AndBoolean() {
                    public short getKeyShort() { return PrimitiveEntry.OfShort.AndBoolean.this.getKeyShort(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfShort.AndBoolean.this.getValueBoolean()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfShort.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            boolean getValueBoolean();
            boolean setValueBoolean(boolean value);
        }
    }
    interface OfByte<V> extends PrimitiveEntry<java.lang.Byte, V> {
        @Override
        default Map.Entry<java.lang.Byte, V> boxed() { return this; }
        default OfDouble<V> mapToDoubleKey(PrimitiveFunction.ToDouble.OfByte mapper) {
            if(mapper == null) throw new NullPointerException();
            return new OfDouble<V>() {
                public boolean equals(Object o) { return OfByte.this.equals(o); }
                public int hashCode() { return OfByte.this.hashCode(); }
                public double getKeyDouble() { return mapper.applyDouble(OfByte.this.getKeyByte()); }
                public V getValue() { return OfByte.this.getValue(); }
                public V setValue(V v) { return OfByte.this.setValue(v); }
            };
        }
        default OfLong<V> mapToLongKey(PrimitiveFunction.ToLong.OfByte mapper) {
            if(mapper == null) throw new NullPointerException();
            return new OfLong<V>() {
                public boolean equals(Object o) { return OfByte.this.equals(o); }
                public int hashCode() { return OfByte.this.hashCode(); }
                public long getKeyLong() { return mapper.applyLong(OfByte.this.getKeyByte()); }
                public V getValue() { return OfByte.this.getValue(); }
                public V setValue(V v) { return OfByte.this.setValue(v); }
            };
        }
        default OfInt<V> mapToIntKey(PrimitiveFunction.ToInt.OfByte mapper) {
            if(mapper == null) throw new NullPointerException();
            return new OfInt<V>() {
                public boolean equals(Object o) { return OfByte.this.equals(o); }
                public int hashCode() { return OfByte.this.hashCode(); }
                public int getKeyInt() { return mapper.applyInt(OfByte.this.getKeyByte()); }
                public V getValue() { return OfByte.this.getValue(); }
                public V setValue(V v) { return OfByte.this.setValue(v); }
            };
        }
        default OfFloat<V> mapToFloatKey(PrimitiveFunction.ToFloat.OfByte mapper) {
            if(mapper == null) throw new NullPointerException();
            return new OfFloat<V>() {
                public boolean equals(Object o) { return OfByte.this.equals(o); }
                public int hashCode() { return OfByte.this.hashCode(); }
                public float getKeyFloat() { return mapper.applyFloat(OfByte.this.getKeyByte()); }
                public V getValue() { return OfByte.this.getValue(); }
                public V setValue(V v) { return OfByte.this.setValue(v); }
            };
        }
        default OfChar<V> mapToCharKey(PrimitiveFunction.ToChar.OfByte mapper) {
            if(mapper == null) throw new NullPointerException();
            return new OfChar<V>() {
                public boolean equals(Object o) { return OfByte.this.equals(o); }
                public int hashCode() { return OfByte.this.hashCode(); }
                public char getKeyChar() { return mapper.applyChar(OfByte.this.getKeyByte()); }
                public V getValue() { return OfByte.this.getValue(); }
                public V setValue(V v) { return OfByte.this.setValue(v); }
            };
        }
        default OfShort<V> mapToShortKey(PrimitiveFunction.ToShort.OfByte mapper) {
            if(mapper == null) throw new NullPointerException();
            return new OfShort<V>() {
                public boolean equals(Object o) { return OfByte.this.equals(o); }
                public int hashCode() { return OfByte.this.hashCode(); }
                public short getKeyShort() { return mapper.applyShort(OfByte.this.getKeyByte()); }
                public V getValue() { return OfByte.this.getValue(); }
                public V setValue(V v) { return OfByte.this.setValue(v); }
            };
        }
        default OfByte<V> mapToByteKey(PrimitiveFunction.ToByte.OfByte mapper) {
            if(mapper == null) throw new NullPointerException();
            PrimitiveEntry.OfByte<V> thisEnt = this;
            return new OfByte<V>() {
                public boolean equals(Object o) { return thisEnt.equals(o); }
                public int hashCode() { return thisEnt.hashCode(); }
                public byte getKeyByte() { return mapper.applyByte(thisEnt.getKeyByte()); }
                public V getValue() { return thisEnt.getValue(); }
                public V setValue(V v) { return thisEnt.setValue(v); }
            };
        }
        default OfBoolean<V> mapToBooleanKey(PrimitiveFunction.ToBoolean.OfByte mapper) {
            if(mapper == null) throw new NullPointerException();
            return new OfBoolean<V>() {
                public boolean equals(Object o) { return OfByte.this.equals(o); }
                public int hashCode() { return OfByte.this.hashCode(); }
                public boolean getKeyBoolean() { return mapper.applyBoolean(OfByte.this.getKeyByte()); }
                public V getValue() { return OfByte.this.getValue(); }
                public V setValue(V v) { return OfByte.this.setValue(v); }
            };
        }
        @Override default java.lang.Byte getKey() { return OfByte.this.getKeyByte(); }
        byte getKeyByte();
        interface AndDouble extends OfByte<java.lang.Double> {
            @Override default java.lang.Double getValue() { return getValueDouble(); }
            @Override default java.lang.Double setValue(java.lang.Double v) { return setValueDouble(v); }
            @Override default PrimitiveEntry.OfDouble.AndDouble mapToDoubleKey(PrimitiveFunction.ToDouble.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfByte.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfByte.AndDouble.this.setValueDouble(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfByte.AndDouble.this.getKeyByte()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndDouble mapToLongKey(PrimitiveFunction.ToLong.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfByte.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfByte.AndDouble.this.setValueDouble(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfByte.AndDouble.this.getKeyByte()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndDouble mapToIntKey(PrimitiveFunction.ToInt.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfByte.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfByte.AndDouble.this.setValueDouble(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfByte.AndDouble.this.getKeyByte()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndDouble mapToFloatKey(PrimitiveFunction.ToFloat.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfByte.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfByte.AndDouble.this.setValueDouble(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfByte.AndDouble.this.getKeyByte()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndDouble mapToCharKey(PrimitiveFunction.ToChar.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfByte.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfByte.AndDouble.this.setValueDouble(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfByte.AndDouble.this.getKeyByte()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndDouble mapToShortKey(PrimitiveFunction.ToShort.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfByte.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfByte.AndDouble.this.setValueDouble(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfByte.AndDouble.this.getKeyByte()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndDouble mapToByteKey(PrimitiveFunction.ToByte.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfByte.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfByte.AndDouble.this.setValueDouble(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfByte.AndDouble.this.getKeyByte()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndDouble mapToBooleanKey(PrimitiveFunction.ToBoolean.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfByte.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfByte.AndDouble.this.setValueDouble(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfByte.AndDouble.this.getKeyByte()); }
                };
            }
            default PrimitiveEntry.OfByte.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfDouble mapper, PrimitiveFunction.ToDouble.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndDouble() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndDouble.this.getKeyByte(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfByte.AndDouble.this.getValueDouble()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfByte.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            default PrimitiveEntry.OfByte.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfDouble mapper, PrimitiveFunction.ToDouble.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndLong() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndDouble.this.getKeyByte(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfByte.AndDouble.this.getValueDouble()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfByte.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            default PrimitiveEntry.OfByte.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfDouble mapper, PrimitiveFunction.ToDouble.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndInt() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndDouble.this.getKeyByte(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfByte.AndDouble.this.getValueDouble()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfByte.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            default PrimitiveEntry.OfByte.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfDouble mapper, PrimitiveFunction.ToDouble.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndFloat() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndDouble.this.getKeyByte(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfByte.AndDouble.this.getValueDouble()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfByte.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            default PrimitiveEntry.OfByte.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfDouble mapper, PrimitiveFunction.ToDouble.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndChar() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndDouble.this.getKeyByte(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfByte.AndDouble.this.getValueDouble()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfByte.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            default PrimitiveEntry.OfByte.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfDouble mapper, PrimitiveFunction.ToDouble.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndShort() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndDouble.this.getKeyByte(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfByte.AndDouble.this.getValueDouble()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfByte.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            default PrimitiveEntry.OfByte.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfDouble mapper, PrimitiveFunction.ToDouble.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndByte() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndDouble.this.getKeyByte(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfByte.AndDouble.this.getValueDouble()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfByte.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            default PrimitiveEntry.OfByte.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfDouble mapper, PrimitiveFunction.ToDouble.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndBoolean() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndDouble.this.getKeyByte(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfByte.AndDouble.this.getValueDouble()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfByte.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            double getValueDouble();
            double setValueDouble(double value);
        }
        interface AndLong extends OfByte<java.lang.Long> {
            @Override default java.lang.Long getValue() { return getValueLong(); }
            @Override default java.lang.Long setValue(java.lang.Long v) { return setValueLong(v); }
            @Override default PrimitiveEntry.OfDouble.AndLong mapToDoubleKey(PrimitiveFunction.ToDouble.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfByte.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfByte.AndLong.this.setValueLong(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfByte.AndLong.this.getKeyByte()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndLong mapToLongKey(PrimitiveFunction.ToLong.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfByte.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfByte.AndLong.this.setValueLong(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfByte.AndLong.this.getKeyByte()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndLong mapToIntKey(PrimitiveFunction.ToInt.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfByte.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfByte.AndLong.this.setValueLong(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfByte.AndLong.this.getKeyByte()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndLong mapToFloatKey(PrimitiveFunction.ToFloat.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfByte.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfByte.AndLong.this.setValueLong(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfByte.AndLong.this.getKeyByte()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndLong mapToCharKey(PrimitiveFunction.ToChar.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfByte.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfByte.AndLong.this.setValueLong(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfByte.AndLong.this.getKeyByte()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndLong mapToShortKey(PrimitiveFunction.ToShort.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfByte.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfByte.AndLong.this.setValueLong(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfByte.AndLong.this.getKeyByte()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndLong mapToByteKey(PrimitiveFunction.ToByte.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfByte.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfByte.AndLong.this.setValueLong(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfByte.AndLong.this.getKeyByte()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndLong mapToBooleanKey(PrimitiveFunction.ToBoolean.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfByte.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfByte.AndLong.this.setValueLong(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfByte.AndLong.this.getKeyByte()); }
                };
            }
            default PrimitiveEntry.OfByte.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfLong mapper, PrimitiveFunction.ToLong.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndDouble() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndLong.this.getKeyByte(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfByte.AndLong.this.getValueLong()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfByte.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            default PrimitiveEntry.OfByte.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfLong mapper, PrimitiveFunction.ToLong.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndLong() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndLong.this.getKeyByte(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfByte.AndLong.this.getValueLong()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfByte.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            default PrimitiveEntry.OfByte.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfLong mapper, PrimitiveFunction.ToLong.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndInt() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndLong.this.getKeyByte(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfByte.AndLong.this.getValueLong()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfByte.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            default PrimitiveEntry.OfByte.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfLong mapper, PrimitiveFunction.ToLong.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndFloat() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndLong.this.getKeyByte(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfByte.AndLong.this.getValueLong()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfByte.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            default PrimitiveEntry.OfByte.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfLong mapper, PrimitiveFunction.ToLong.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndChar() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndLong.this.getKeyByte(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfByte.AndLong.this.getValueLong()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfByte.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            default PrimitiveEntry.OfByte.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfLong mapper, PrimitiveFunction.ToLong.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndShort() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndLong.this.getKeyByte(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfByte.AndLong.this.getValueLong()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfByte.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            default PrimitiveEntry.OfByte.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfLong mapper, PrimitiveFunction.ToLong.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndByte() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndLong.this.getKeyByte(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfByte.AndLong.this.getValueLong()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfByte.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            default PrimitiveEntry.OfByte.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfLong mapper, PrimitiveFunction.ToLong.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndBoolean() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndLong.this.getKeyByte(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfByte.AndLong.this.getValueLong()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfByte.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            long getValueLong();
            long setValueLong(long value);
        }
        interface AndInt extends OfByte<java.lang.Integer> {
            @Override default java.lang.Integer getValue() { return getValueInt(); }
            @Override default java.lang.Integer setValue(java.lang.Integer v) { return setValueInt(v); }
            @Override default PrimitiveEntry.OfDouble.AndInt mapToDoubleKey(PrimitiveFunction.ToDouble.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfByte.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfByte.AndInt.this.setValueInt(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfByte.AndInt.this.getKeyByte()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndInt mapToLongKey(PrimitiveFunction.ToLong.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfByte.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfByte.AndInt.this.setValueInt(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfByte.AndInt.this.getKeyByte()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndInt mapToIntKey(PrimitiveFunction.ToInt.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfByte.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfByte.AndInt.this.setValueInt(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfByte.AndInt.this.getKeyByte()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndInt mapToFloatKey(PrimitiveFunction.ToFloat.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfByte.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfByte.AndInt.this.setValueInt(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfByte.AndInt.this.getKeyByte()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndInt mapToCharKey(PrimitiveFunction.ToChar.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfByte.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfByte.AndInt.this.setValueInt(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfByte.AndInt.this.getKeyByte()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndInt mapToShortKey(PrimitiveFunction.ToShort.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfByte.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfByte.AndInt.this.setValueInt(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfByte.AndInt.this.getKeyByte()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndInt mapToByteKey(PrimitiveFunction.ToByte.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfByte.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfByte.AndInt.this.setValueInt(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfByte.AndInt.this.getKeyByte()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndInt mapToBooleanKey(PrimitiveFunction.ToBoolean.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfByte.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfByte.AndInt.this.setValueInt(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfByte.AndInt.this.getKeyByte()); }
                };
            }
            default PrimitiveEntry.OfByte.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfInt mapper, PrimitiveFunction.ToInt.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndDouble() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndInt.this.getKeyByte(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfByte.AndInt.this.getValueInt()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfByte.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            default PrimitiveEntry.OfByte.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfInt mapper, PrimitiveFunction.ToInt.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndLong() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndInt.this.getKeyByte(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfByte.AndInt.this.getValueInt()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfByte.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            default PrimitiveEntry.OfByte.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfInt mapper, PrimitiveFunction.ToInt.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndInt() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndInt.this.getKeyByte(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfByte.AndInt.this.getValueInt()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfByte.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            default PrimitiveEntry.OfByte.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfInt mapper, PrimitiveFunction.ToInt.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndFloat() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndInt.this.getKeyByte(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfByte.AndInt.this.getValueInt()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfByte.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            default PrimitiveEntry.OfByte.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfInt mapper, PrimitiveFunction.ToInt.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndChar() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndInt.this.getKeyByte(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfByte.AndInt.this.getValueInt()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfByte.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            default PrimitiveEntry.OfByte.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfInt mapper, PrimitiveFunction.ToInt.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndShort() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndInt.this.getKeyByte(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfByte.AndInt.this.getValueInt()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfByte.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            default PrimitiveEntry.OfByte.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfInt mapper, PrimitiveFunction.ToInt.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndByte() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndInt.this.getKeyByte(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfByte.AndInt.this.getValueInt()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfByte.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            default PrimitiveEntry.OfByte.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfInt mapper, PrimitiveFunction.ToInt.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndBoolean() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndInt.this.getKeyByte(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfByte.AndInt.this.getValueInt()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfByte.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            int getValueInt();
            int setValueInt(int value);
        }
        interface AndFloat extends OfByte<java.lang.Float> {
            @Override default java.lang.Float getValue() { return getValueFloat(); }
            @Override default java.lang.Float setValue(java.lang.Float v) { return setValueFloat(v); }
            @Override default PrimitiveEntry.OfDouble.AndFloat mapToDoubleKey(PrimitiveFunction.ToDouble.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfByte.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfByte.AndFloat.this.setValueFloat(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfByte.AndFloat.this.getKeyByte()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndFloat mapToLongKey(PrimitiveFunction.ToLong.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfByte.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfByte.AndFloat.this.setValueFloat(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfByte.AndFloat.this.getKeyByte()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndFloat mapToIntKey(PrimitiveFunction.ToInt.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfByte.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfByte.AndFloat.this.setValueFloat(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfByte.AndFloat.this.getKeyByte()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndFloat mapToFloatKey(PrimitiveFunction.ToFloat.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfByte.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfByte.AndFloat.this.setValueFloat(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfByte.AndFloat.this.getKeyByte()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndFloat mapToCharKey(PrimitiveFunction.ToChar.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfByte.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfByte.AndFloat.this.setValueFloat(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfByte.AndFloat.this.getKeyByte()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndFloat mapToShortKey(PrimitiveFunction.ToShort.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfByte.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfByte.AndFloat.this.setValueFloat(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfByte.AndFloat.this.getKeyByte()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndFloat mapToByteKey(PrimitiveFunction.ToByte.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfByte.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfByte.AndFloat.this.setValueFloat(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfByte.AndFloat.this.getKeyByte()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndFloat mapToBooleanKey(PrimitiveFunction.ToBoolean.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfByte.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfByte.AndFloat.this.setValueFloat(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfByte.AndFloat.this.getKeyByte()); }
                };
            }
            default PrimitiveEntry.OfByte.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfFloat mapper, PrimitiveFunction.ToFloat.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndDouble() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndFloat.this.getKeyByte(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfByte.AndFloat.this.getValueFloat()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfByte.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            default PrimitiveEntry.OfByte.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfFloat mapper, PrimitiveFunction.ToFloat.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndLong() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndFloat.this.getKeyByte(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfByte.AndFloat.this.getValueFloat()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfByte.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            default PrimitiveEntry.OfByte.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfFloat mapper, PrimitiveFunction.ToFloat.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndInt() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndFloat.this.getKeyByte(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfByte.AndFloat.this.getValueFloat()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfByte.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            default PrimitiveEntry.OfByte.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfFloat mapper, PrimitiveFunction.ToFloat.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndFloat() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndFloat.this.getKeyByte(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfByte.AndFloat.this.getValueFloat()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfByte.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            default PrimitiveEntry.OfByte.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfFloat mapper, PrimitiveFunction.ToFloat.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndChar() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndFloat.this.getKeyByte(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfByte.AndFloat.this.getValueFloat()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfByte.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            default PrimitiveEntry.OfByte.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfFloat mapper, PrimitiveFunction.ToFloat.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndShort() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndFloat.this.getKeyByte(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfByte.AndFloat.this.getValueFloat()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfByte.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            default PrimitiveEntry.OfByte.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfFloat mapper, PrimitiveFunction.ToFloat.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndByte() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndFloat.this.getKeyByte(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfByte.AndFloat.this.getValueFloat()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfByte.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            default PrimitiveEntry.OfByte.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfFloat mapper, PrimitiveFunction.ToFloat.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndBoolean() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndFloat.this.getKeyByte(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfByte.AndFloat.this.getValueFloat()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfByte.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            float getValueFloat();
            float setValueFloat(float value);
        }
        interface AndChar extends OfByte<java.lang.Character> {
            @Override default java.lang.Character getValue() { return getValueChar(); }
            @Override default java.lang.Character setValue(java.lang.Character v) { return setValueChar(v); }
            @Override default PrimitiveEntry.OfDouble.AndChar mapToDoubleKey(PrimitiveFunction.ToDouble.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfByte.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfByte.AndChar.this.setValueChar(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfByte.AndChar.this.getKeyByte()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndChar mapToLongKey(PrimitiveFunction.ToLong.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfByte.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfByte.AndChar.this.setValueChar(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfByte.AndChar.this.getKeyByte()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndChar mapToIntKey(PrimitiveFunction.ToInt.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfByte.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfByte.AndChar.this.setValueChar(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfByte.AndChar.this.getKeyByte()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndChar mapToFloatKey(PrimitiveFunction.ToFloat.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfByte.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfByte.AndChar.this.setValueChar(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfByte.AndChar.this.getKeyByte()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndChar mapToCharKey(PrimitiveFunction.ToChar.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfByte.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfByte.AndChar.this.setValueChar(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfByte.AndChar.this.getKeyByte()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndChar mapToShortKey(PrimitiveFunction.ToShort.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfByte.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfByte.AndChar.this.setValueChar(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfByte.AndChar.this.getKeyByte()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndChar mapToByteKey(PrimitiveFunction.ToByte.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfByte.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfByte.AndChar.this.setValueChar(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfByte.AndChar.this.getKeyByte()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndChar mapToBooleanKey(PrimitiveFunction.ToBoolean.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfByte.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfByte.AndChar.this.setValueChar(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfByte.AndChar.this.getKeyByte()); }
                };
            }
            default PrimitiveEntry.OfByte.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfChar mapper, PrimitiveFunction.ToChar.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndDouble() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndChar.this.getKeyByte(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfByte.AndChar.this.getValueChar()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfByte.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            default PrimitiveEntry.OfByte.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfChar mapper, PrimitiveFunction.ToChar.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndLong() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndChar.this.getKeyByte(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfByte.AndChar.this.getValueChar()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfByte.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            default PrimitiveEntry.OfByte.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfChar mapper, PrimitiveFunction.ToChar.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndInt() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndChar.this.getKeyByte(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfByte.AndChar.this.getValueChar()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfByte.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            default PrimitiveEntry.OfByte.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfChar mapper, PrimitiveFunction.ToChar.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndFloat() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndChar.this.getKeyByte(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfByte.AndChar.this.getValueChar()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfByte.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            default PrimitiveEntry.OfByte.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfChar mapper, PrimitiveFunction.ToChar.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndChar() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndChar.this.getKeyByte(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfByte.AndChar.this.getValueChar()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfByte.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            default PrimitiveEntry.OfByte.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfChar mapper, PrimitiveFunction.ToChar.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndShort() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndChar.this.getKeyByte(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfByte.AndChar.this.getValueChar()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfByte.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            default PrimitiveEntry.OfByte.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfChar mapper, PrimitiveFunction.ToChar.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndByte() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndChar.this.getKeyByte(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfByte.AndChar.this.getValueChar()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfByte.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            default PrimitiveEntry.OfByte.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfChar mapper, PrimitiveFunction.ToChar.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndBoolean() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndChar.this.getKeyByte(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfByte.AndChar.this.getValueChar()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfByte.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            char getValueChar();
            char setValueChar(char value);
        }
        interface AndShort extends OfByte<java.lang.Short> {
            @Override default java.lang.Short getValue() { return getValueShort(); }
            @Override default java.lang.Short setValue(java.lang.Short v) { return setValueShort(v); }
            @Override default PrimitiveEntry.OfDouble.AndShort mapToDoubleKey(PrimitiveFunction.ToDouble.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfByte.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfByte.AndShort.this.setValueShort(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfByte.AndShort.this.getKeyByte()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndShort mapToLongKey(PrimitiveFunction.ToLong.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfByte.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfByte.AndShort.this.setValueShort(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfByte.AndShort.this.getKeyByte()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndShort mapToIntKey(PrimitiveFunction.ToInt.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfByte.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfByte.AndShort.this.setValueShort(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfByte.AndShort.this.getKeyByte()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndShort mapToFloatKey(PrimitiveFunction.ToFloat.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfByte.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfByte.AndShort.this.setValueShort(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfByte.AndShort.this.getKeyByte()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndShort mapToCharKey(PrimitiveFunction.ToChar.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfByte.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfByte.AndShort.this.setValueShort(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfByte.AndShort.this.getKeyByte()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndShort mapToShortKey(PrimitiveFunction.ToShort.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfByte.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfByte.AndShort.this.setValueShort(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfByte.AndShort.this.getKeyByte()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndShort mapToByteKey(PrimitiveFunction.ToByte.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfByte.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfByte.AndShort.this.setValueShort(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfByte.AndShort.this.getKeyByte()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndShort mapToBooleanKey(PrimitiveFunction.ToBoolean.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfByte.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfByte.AndShort.this.setValueShort(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfByte.AndShort.this.getKeyByte()); }
                };
            }
            default PrimitiveEntry.OfByte.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfShort mapper, PrimitiveFunction.ToShort.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndDouble() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndShort.this.getKeyByte(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfByte.AndShort.this.getValueShort()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfByte.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            default PrimitiveEntry.OfByte.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfShort mapper, PrimitiveFunction.ToShort.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndLong() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndShort.this.getKeyByte(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfByte.AndShort.this.getValueShort()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfByte.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            default PrimitiveEntry.OfByte.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfShort mapper, PrimitiveFunction.ToShort.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndInt() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndShort.this.getKeyByte(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfByte.AndShort.this.getValueShort()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfByte.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            default PrimitiveEntry.OfByte.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfShort mapper, PrimitiveFunction.ToShort.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndFloat() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndShort.this.getKeyByte(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfByte.AndShort.this.getValueShort()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfByte.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            default PrimitiveEntry.OfByte.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfShort mapper, PrimitiveFunction.ToShort.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndChar() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndShort.this.getKeyByte(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfByte.AndShort.this.getValueShort()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfByte.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            default PrimitiveEntry.OfByte.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfShort mapper, PrimitiveFunction.ToShort.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndShort() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndShort.this.getKeyByte(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfByte.AndShort.this.getValueShort()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfByte.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            default PrimitiveEntry.OfByte.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfShort mapper, PrimitiveFunction.ToShort.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndByte() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndShort.this.getKeyByte(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfByte.AndShort.this.getValueShort()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfByte.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            default PrimitiveEntry.OfByte.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfShort mapper, PrimitiveFunction.ToShort.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndBoolean() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndShort.this.getKeyByte(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfByte.AndShort.this.getValueShort()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfByte.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            short getValueShort();
            short setValueShort(short value);
        }
        interface AndByte extends OfByte<java.lang.Byte> {
            @Override default java.lang.Byte getValue() { return getValueByte(); }
            @Override default java.lang.Byte setValue(java.lang.Byte v) { return setValueByte(v); }
            @Override default PrimitiveEntry.OfDouble.AndByte mapToDoubleKey(PrimitiveFunction.ToDouble.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfByte.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfByte.AndByte.this.setValueByte(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfByte.AndByte.this.getKeyByte()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndByte mapToLongKey(PrimitiveFunction.ToLong.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfByte.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfByte.AndByte.this.setValueByte(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfByte.AndByte.this.getKeyByte()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndByte mapToIntKey(PrimitiveFunction.ToInt.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfByte.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfByte.AndByte.this.setValueByte(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfByte.AndByte.this.getKeyByte()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndByte mapToFloatKey(PrimitiveFunction.ToFloat.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfByte.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfByte.AndByte.this.setValueByte(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfByte.AndByte.this.getKeyByte()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndByte mapToCharKey(PrimitiveFunction.ToChar.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfByte.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfByte.AndByte.this.setValueByte(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfByte.AndByte.this.getKeyByte()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndByte mapToShortKey(PrimitiveFunction.ToShort.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfByte.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfByte.AndByte.this.setValueByte(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfByte.AndByte.this.getKeyByte()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndByte mapToByteKey(PrimitiveFunction.ToByte.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfByte.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfByte.AndByte.this.setValueByte(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfByte.AndByte.this.getKeyByte()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndByte mapToBooleanKey(PrimitiveFunction.ToBoolean.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfByte.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfByte.AndByte.this.setValueByte(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfByte.AndByte.this.getKeyByte()); }
                };
            }
            default PrimitiveEntry.OfByte.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfByte mapper, PrimitiveFunction.ToByte.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndDouble() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndByte.this.getKeyByte(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfByte.AndByte.this.getValueByte()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfByte.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            default PrimitiveEntry.OfByte.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfByte mapper, PrimitiveFunction.ToByte.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndLong() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndByte.this.getKeyByte(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfByte.AndByte.this.getValueByte()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfByte.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            default PrimitiveEntry.OfByte.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfByte mapper, PrimitiveFunction.ToByte.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndInt() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndByte.this.getKeyByte(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfByte.AndByte.this.getValueByte()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfByte.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            default PrimitiveEntry.OfByte.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfByte mapper, PrimitiveFunction.ToByte.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndFloat() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndByte.this.getKeyByte(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfByte.AndByte.this.getValueByte()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfByte.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            default PrimitiveEntry.OfByte.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfByte mapper, PrimitiveFunction.ToByte.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndChar() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndByte.this.getKeyByte(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfByte.AndByte.this.getValueByte()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfByte.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            default PrimitiveEntry.OfByte.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfByte mapper, PrimitiveFunction.ToByte.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndShort() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndByte.this.getKeyByte(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfByte.AndByte.this.getValueByte()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfByte.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            default PrimitiveEntry.OfByte.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfByte mapper, PrimitiveFunction.ToByte.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndByte() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndByte.this.getKeyByte(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfByte.AndByte.this.getValueByte()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfByte.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            default PrimitiveEntry.OfByte.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfByte mapper, PrimitiveFunction.ToByte.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndBoolean() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndByte.this.getKeyByte(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfByte.AndByte.this.getValueByte()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfByte.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            byte getValueByte();
            byte setValueByte(byte value);
        }
        interface AndBoolean extends OfByte<java.lang.Boolean> {
            @Override default java.lang.Boolean getValue() { return getValueBoolean(); }
            @Override default java.lang.Boolean setValue(java.lang.Boolean v) { return setValueBoolean(v); }
            @Override default PrimitiveEntry.OfDouble.AndBoolean mapToDoubleKey(PrimitiveFunction.ToDouble.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfByte.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfByte.AndBoolean.this.setValueBoolean(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfByte.AndBoolean.this.getKeyByte()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndBoolean mapToLongKey(PrimitiveFunction.ToLong.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfByte.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfByte.AndBoolean.this.setValueBoolean(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfByte.AndBoolean.this.getKeyByte()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndBoolean mapToIntKey(PrimitiveFunction.ToInt.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfByte.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfByte.AndBoolean.this.setValueBoolean(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfByte.AndBoolean.this.getKeyByte()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndBoolean mapToFloatKey(PrimitiveFunction.ToFloat.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfByte.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfByte.AndBoolean.this.setValueBoolean(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfByte.AndBoolean.this.getKeyByte()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndBoolean mapToCharKey(PrimitiveFunction.ToChar.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfByte.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfByte.AndBoolean.this.setValueBoolean(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfByte.AndBoolean.this.getKeyByte()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndBoolean mapToShortKey(PrimitiveFunction.ToShort.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfByte.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfByte.AndBoolean.this.setValueBoolean(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfByte.AndBoolean.this.getKeyByte()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndBoolean mapToByteKey(PrimitiveFunction.ToByte.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfByte.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfByte.AndBoolean.this.setValueBoolean(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfByte.AndBoolean.this.getKeyByte()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndBoolean mapToBooleanKey(PrimitiveFunction.ToBoolean.OfByte mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfByte.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfByte.AndBoolean.this.setValueBoolean(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfByte.AndBoolean.this.getKeyByte()); }
                };
            }
            default PrimitiveEntry.OfByte.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndDouble() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndBoolean.this.getKeyByte(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfByte.AndBoolean.this.getValueBoolean()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfByte.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            default PrimitiveEntry.OfByte.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndLong() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndBoolean.this.getKeyByte(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfByte.AndBoolean.this.getValueBoolean()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfByte.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            default PrimitiveEntry.OfByte.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndInt() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndBoolean.this.getKeyByte(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfByte.AndBoolean.this.getValueBoolean()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfByte.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            default PrimitiveEntry.OfByte.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndFloat() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndBoolean.this.getKeyByte(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfByte.AndBoolean.this.getValueBoolean()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfByte.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            default PrimitiveEntry.OfByte.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndChar() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndBoolean.this.getKeyByte(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfByte.AndBoolean.this.getValueBoolean()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfByte.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            default PrimitiveEntry.OfByte.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndShort() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndBoolean.this.getKeyByte(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfByte.AndBoolean.this.getValueBoolean()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfByte.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            default PrimitiveEntry.OfByte.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndByte() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndBoolean.this.getKeyByte(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfByte.AndBoolean.this.getValueBoolean()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfByte.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            default PrimitiveEntry.OfByte.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfByte.AndBoolean() {
                    public byte getKeyByte() { return PrimitiveEntry.OfByte.AndBoolean.this.getKeyByte(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfByte.AndBoolean.this.getValueBoolean()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfByte.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            boolean getValueBoolean();
            boolean setValueBoolean(boolean value);
        }
    }
    interface OfBoolean<V> extends PrimitiveEntry<java.lang.Boolean, V> {
        @Override
        default Map.Entry<java.lang.Boolean, V> boxed() { return this; }
        default OfDouble<V> mapToDoubleKey(PrimitiveFunction.ToDouble.OfBoolean mapper) {
            if(mapper == null) throw new NullPointerException();
            return new OfDouble<V>() {
                public boolean equals(Object o) { return OfBoolean.this.equals(o); }
                public int hashCode() { return OfBoolean.this.hashCode(); }
                public double getKeyDouble() { return mapper.applyDouble(OfBoolean.this.getKeyBoolean()); }
                public V getValue() { return OfBoolean.this.getValue(); }
                public V setValue(V v) { return OfBoolean.this.setValue(v); }
            };
        }
        default OfLong<V> mapToLongKey(PrimitiveFunction.ToLong.OfBoolean mapper) {
            if(mapper == null) throw new NullPointerException();
            return new OfLong<V>() {
                public boolean equals(Object o) { return OfBoolean.this.equals(o); }
                public int hashCode() { return OfBoolean.this.hashCode(); }
                public long getKeyLong() { return mapper.applyLong(OfBoolean.this.getKeyBoolean()); }
                public V getValue() { return OfBoolean.this.getValue(); }
                public V setValue(V v) { return OfBoolean.this.setValue(v); }
            };
        }
        default OfInt<V> mapToIntKey(PrimitiveFunction.ToInt.OfBoolean mapper) {
            if(mapper == null) throw new NullPointerException();
            return new OfInt<V>() {
                public boolean equals(Object o) { return OfBoolean.this.equals(o); }
                public int hashCode() { return OfBoolean.this.hashCode(); }
                public int getKeyInt() { return mapper.applyInt(OfBoolean.this.getKeyBoolean()); }
                public V getValue() { return OfBoolean.this.getValue(); }
                public V setValue(V v) { return OfBoolean.this.setValue(v); }
            };
        }
        default OfFloat<V> mapToFloatKey(PrimitiveFunction.ToFloat.OfBoolean mapper) {
            if(mapper == null) throw new NullPointerException();
            return new OfFloat<V>() {
                public boolean equals(Object o) { return OfBoolean.this.equals(o); }
                public int hashCode() { return OfBoolean.this.hashCode(); }
                public float getKeyFloat() { return mapper.applyFloat(OfBoolean.this.getKeyBoolean()); }
                public V getValue() { return OfBoolean.this.getValue(); }
                public V setValue(V v) { return OfBoolean.this.setValue(v); }
            };
        }
        default OfChar<V> mapToCharKey(PrimitiveFunction.ToChar.OfBoolean mapper) {
            if(mapper == null) throw new NullPointerException();
            return new OfChar<V>() {
                public boolean equals(Object o) { return OfBoolean.this.equals(o); }
                public int hashCode() { return OfBoolean.this.hashCode(); }
                public char getKeyChar() { return mapper.applyChar(OfBoolean.this.getKeyBoolean()); }
                public V getValue() { return OfBoolean.this.getValue(); }
                public V setValue(V v) { return OfBoolean.this.setValue(v); }
            };
        }
        default OfShort<V> mapToShortKey(PrimitiveFunction.ToShort.OfBoolean mapper) {
            if(mapper == null) throw new NullPointerException();
            return new OfShort<V>() {
                public boolean equals(Object o) { return OfBoolean.this.equals(o); }
                public int hashCode() { return OfBoolean.this.hashCode(); }
                public short getKeyShort() { return mapper.applyShort(OfBoolean.this.getKeyBoolean()); }
                public V getValue() { return OfBoolean.this.getValue(); }
                public V setValue(V v) { return OfBoolean.this.setValue(v); }
            };
        }
        default OfByte<V> mapToByteKey(PrimitiveFunction.ToByte.OfBoolean mapper) {
            if(mapper == null) throw new NullPointerException();
            return new OfByte<V>() {
                public boolean equals(Object o) { return OfBoolean.this.equals(o); }
                public int hashCode() { return OfBoolean.this.hashCode(); }
                public byte getKeyByte() { return mapper.applyByte(OfBoolean.this.getKeyBoolean()); }
                public V getValue() { return OfBoolean.this.getValue(); }
                public V setValue(V v) { return OfBoolean.this.setValue(v); }
            };
        }
        default OfBoolean<V> mapToBooleanKey(PrimitiveFunction.ToBoolean.OfBoolean mapper) {
            if(mapper == null) throw new NullPointerException();
            PrimitiveEntry.OfBoolean<V> thisEnt = this;
            return new OfBoolean<V>() {
                public boolean equals(Object o) { return thisEnt.equals(o); }
                public int hashCode() { return thisEnt.hashCode(); }
                public boolean getKeyBoolean() { return mapper.applyBoolean(thisEnt.getKeyBoolean()); }
                public V getValue() { return thisEnt.getValue(); }
                public V setValue(V v) { return thisEnt.setValue(v); }
            };
        }
        @Override default java.lang.Boolean getKey() { return OfBoolean.this.getKeyBoolean(); }
        boolean getKeyBoolean();
        interface AndDouble extends OfBoolean<java.lang.Double> {
            @Override default java.lang.Double getValue() { return getValueDouble(); }
            @Override default java.lang.Double setValue(java.lang.Double v) { return setValueDouble(v); }
            @Override default PrimitiveEntry.OfDouble.AndDouble mapToDoubleKey(PrimitiveFunction.ToDouble.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfBoolean.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfBoolean.AndDouble.this.setValueDouble(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfBoolean.AndDouble.this.getKeyBoolean()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndDouble mapToLongKey(PrimitiveFunction.ToLong.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfBoolean.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfBoolean.AndDouble.this.setValueDouble(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfBoolean.AndDouble.this.getKeyBoolean()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndDouble mapToIntKey(PrimitiveFunction.ToInt.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfBoolean.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfBoolean.AndDouble.this.setValueDouble(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfBoolean.AndDouble.this.getKeyBoolean()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndDouble mapToFloatKey(PrimitiveFunction.ToFloat.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfBoolean.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfBoolean.AndDouble.this.setValueDouble(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfBoolean.AndDouble.this.getKeyBoolean()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndDouble mapToCharKey(PrimitiveFunction.ToChar.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfBoolean.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfBoolean.AndDouble.this.setValueDouble(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfBoolean.AndDouble.this.getKeyBoolean()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndDouble mapToShortKey(PrimitiveFunction.ToShort.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfBoolean.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfBoolean.AndDouble.this.setValueDouble(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfBoolean.AndDouble.this.getKeyBoolean()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndDouble mapToByteKey(PrimitiveFunction.ToByte.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfBoolean.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfBoolean.AndDouble.this.setValueDouble(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfBoolean.AndDouble.this.getKeyBoolean()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndDouble mapToBooleanKey(PrimitiveFunction.ToBoolean.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndDouble() {
                    public double getValueDouble() { return PrimitiveEntry.OfBoolean.AndDouble.this.getValueDouble(); }
                    public double setValueDouble(double value) { return PrimitiveEntry.OfBoolean.AndDouble.this.setValueDouble(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfBoolean.AndDouble.this.getKeyBoolean()); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfDouble mapper, PrimitiveFunction.ToDouble.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndDouble() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndDouble.this.getKeyBoolean(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfBoolean.AndDouble.this.getValueDouble()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfBoolean.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfDouble mapper, PrimitiveFunction.ToDouble.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndLong() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndDouble.this.getKeyBoolean(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfBoolean.AndDouble.this.getValueDouble()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfBoolean.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfDouble mapper, PrimitiveFunction.ToDouble.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndInt() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndDouble.this.getKeyBoolean(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfBoolean.AndDouble.this.getValueDouble()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfBoolean.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfDouble mapper, PrimitiveFunction.ToDouble.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndFloat() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndDouble.this.getKeyBoolean(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfBoolean.AndDouble.this.getValueDouble()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfBoolean.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfDouble mapper, PrimitiveFunction.ToDouble.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndChar() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndDouble.this.getKeyBoolean(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfBoolean.AndDouble.this.getValueDouble()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfBoolean.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfDouble mapper, PrimitiveFunction.ToDouble.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndShort() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndDouble.this.getKeyBoolean(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfBoolean.AndDouble.this.getValueDouble()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfBoolean.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfDouble mapper, PrimitiveFunction.ToDouble.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndByte() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndDouble.this.getKeyBoolean(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfBoolean.AndDouble.this.getValueDouble()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfBoolean.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfDouble mapper, PrimitiveFunction.ToDouble.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndBoolean() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndDouble.this.getKeyBoolean(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfBoolean.AndDouble.this.getValueDouble()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfBoolean.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
                };
            }
            double getValueDouble();
            double setValueDouble(double value);
        }
        interface AndLong extends OfBoolean<java.lang.Long> {
            @Override default java.lang.Long getValue() { return getValueLong(); }
            @Override default java.lang.Long setValue(java.lang.Long v) { return setValueLong(v); }
            @Override default PrimitiveEntry.OfDouble.AndLong mapToDoubleKey(PrimitiveFunction.ToDouble.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfBoolean.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfBoolean.AndLong.this.setValueLong(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfBoolean.AndLong.this.getKeyBoolean()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndLong mapToLongKey(PrimitiveFunction.ToLong.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfBoolean.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfBoolean.AndLong.this.setValueLong(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfBoolean.AndLong.this.getKeyBoolean()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndLong mapToIntKey(PrimitiveFunction.ToInt.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfBoolean.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfBoolean.AndLong.this.setValueLong(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfBoolean.AndLong.this.getKeyBoolean()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndLong mapToFloatKey(PrimitiveFunction.ToFloat.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfBoolean.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfBoolean.AndLong.this.setValueLong(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfBoolean.AndLong.this.getKeyBoolean()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndLong mapToCharKey(PrimitiveFunction.ToChar.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfBoolean.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfBoolean.AndLong.this.setValueLong(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfBoolean.AndLong.this.getKeyBoolean()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndLong mapToShortKey(PrimitiveFunction.ToShort.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfBoolean.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfBoolean.AndLong.this.setValueLong(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfBoolean.AndLong.this.getKeyBoolean()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndLong mapToByteKey(PrimitiveFunction.ToByte.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfBoolean.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfBoolean.AndLong.this.setValueLong(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfBoolean.AndLong.this.getKeyBoolean()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndLong mapToBooleanKey(PrimitiveFunction.ToBoolean.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndLong() {
                    public long getValueLong() { return PrimitiveEntry.OfBoolean.AndLong.this.getValueLong(); }
                    public long setValueLong(long value) { return PrimitiveEntry.OfBoolean.AndLong.this.setValueLong(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfBoolean.AndLong.this.getKeyBoolean()); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfLong mapper, PrimitiveFunction.ToLong.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndDouble() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndLong.this.getKeyBoolean(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfBoolean.AndLong.this.getValueLong()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfBoolean.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfLong mapper, PrimitiveFunction.ToLong.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndLong() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndLong.this.getKeyBoolean(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfBoolean.AndLong.this.getValueLong()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfBoolean.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfLong mapper, PrimitiveFunction.ToLong.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndInt() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndLong.this.getKeyBoolean(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfBoolean.AndLong.this.getValueLong()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfBoolean.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfLong mapper, PrimitiveFunction.ToLong.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndFloat() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndLong.this.getKeyBoolean(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfBoolean.AndLong.this.getValueLong()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfBoolean.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfLong mapper, PrimitiveFunction.ToLong.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndChar() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndLong.this.getKeyBoolean(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfBoolean.AndLong.this.getValueLong()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfBoolean.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfLong mapper, PrimitiveFunction.ToLong.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndShort() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndLong.this.getKeyBoolean(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfBoolean.AndLong.this.getValueLong()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfBoolean.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfLong mapper, PrimitiveFunction.ToLong.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndByte() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndLong.this.getKeyBoolean(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfBoolean.AndLong.this.getValueLong()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfBoolean.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfLong mapper, PrimitiveFunction.ToLong.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndBoolean() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndLong.this.getKeyBoolean(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfBoolean.AndLong.this.getValueLong()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfBoolean.AndLong.this.setValueLong(rm.applyLong(value))); }
                };
            }
            long getValueLong();
            long setValueLong(long value);
        }
        interface AndInt extends OfBoolean<java.lang.Integer> {
            @Override default java.lang.Integer getValue() { return getValueInt(); }
            @Override default java.lang.Integer setValue(java.lang.Integer v) { return setValueInt(v); }
            @Override default PrimitiveEntry.OfDouble.AndInt mapToDoubleKey(PrimitiveFunction.ToDouble.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfBoolean.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfBoolean.AndInt.this.setValueInt(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfBoolean.AndInt.this.getKeyBoolean()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndInt mapToLongKey(PrimitiveFunction.ToLong.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfBoolean.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfBoolean.AndInt.this.setValueInt(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfBoolean.AndInt.this.getKeyBoolean()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndInt mapToIntKey(PrimitiveFunction.ToInt.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfBoolean.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfBoolean.AndInt.this.setValueInt(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfBoolean.AndInt.this.getKeyBoolean()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndInt mapToFloatKey(PrimitiveFunction.ToFloat.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfBoolean.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfBoolean.AndInt.this.setValueInt(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfBoolean.AndInt.this.getKeyBoolean()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndInt mapToCharKey(PrimitiveFunction.ToChar.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfBoolean.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfBoolean.AndInt.this.setValueInt(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfBoolean.AndInt.this.getKeyBoolean()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndInt mapToShortKey(PrimitiveFunction.ToShort.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfBoolean.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfBoolean.AndInt.this.setValueInt(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfBoolean.AndInt.this.getKeyBoolean()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndInt mapToByteKey(PrimitiveFunction.ToByte.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfBoolean.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfBoolean.AndInt.this.setValueInt(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfBoolean.AndInt.this.getKeyBoolean()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndInt mapToBooleanKey(PrimitiveFunction.ToBoolean.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndInt() {
                    public int getValueInt() { return PrimitiveEntry.OfBoolean.AndInt.this.getValueInt(); }
                    public int setValueInt(int value) { return PrimitiveEntry.OfBoolean.AndInt.this.setValueInt(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfBoolean.AndInt.this.getKeyBoolean()); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfInt mapper, PrimitiveFunction.ToInt.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndDouble() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndInt.this.getKeyBoolean(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfBoolean.AndInt.this.getValueInt()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfBoolean.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfInt mapper, PrimitiveFunction.ToInt.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndLong() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndInt.this.getKeyBoolean(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfBoolean.AndInt.this.getValueInt()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfBoolean.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfInt mapper, PrimitiveFunction.ToInt.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndInt() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndInt.this.getKeyBoolean(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfBoolean.AndInt.this.getValueInt()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfBoolean.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfInt mapper, PrimitiveFunction.ToInt.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndFloat() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndInt.this.getKeyBoolean(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfBoolean.AndInt.this.getValueInt()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfBoolean.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfInt mapper, PrimitiveFunction.ToInt.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndChar() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndInt.this.getKeyBoolean(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfBoolean.AndInt.this.getValueInt()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfBoolean.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfInt mapper, PrimitiveFunction.ToInt.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndShort() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndInt.this.getKeyBoolean(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfBoolean.AndInt.this.getValueInt()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfBoolean.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfInt mapper, PrimitiveFunction.ToInt.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndByte() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndInt.this.getKeyBoolean(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfBoolean.AndInt.this.getValueInt()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfBoolean.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfInt mapper, PrimitiveFunction.ToInt.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndBoolean() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndInt.this.getKeyBoolean(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfBoolean.AndInt.this.getValueInt()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfBoolean.AndInt.this.setValueInt(rm.applyInt(value))); }
                };
            }
            int getValueInt();
            int setValueInt(int value);
        }
        interface AndFloat extends OfBoolean<java.lang.Float> {
            @Override default java.lang.Float getValue() { return getValueFloat(); }
            @Override default java.lang.Float setValue(java.lang.Float v) { return setValueFloat(v); }
            @Override default PrimitiveEntry.OfDouble.AndFloat mapToDoubleKey(PrimitiveFunction.ToDouble.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfBoolean.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfBoolean.AndFloat.this.setValueFloat(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfBoolean.AndFloat.this.getKeyBoolean()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndFloat mapToLongKey(PrimitiveFunction.ToLong.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfBoolean.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfBoolean.AndFloat.this.setValueFloat(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfBoolean.AndFloat.this.getKeyBoolean()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndFloat mapToIntKey(PrimitiveFunction.ToInt.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfBoolean.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfBoolean.AndFloat.this.setValueFloat(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfBoolean.AndFloat.this.getKeyBoolean()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndFloat mapToFloatKey(PrimitiveFunction.ToFloat.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfBoolean.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfBoolean.AndFloat.this.setValueFloat(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfBoolean.AndFloat.this.getKeyBoolean()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndFloat mapToCharKey(PrimitiveFunction.ToChar.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfBoolean.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfBoolean.AndFloat.this.setValueFloat(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfBoolean.AndFloat.this.getKeyBoolean()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndFloat mapToShortKey(PrimitiveFunction.ToShort.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfBoolean.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfBoolean.AndFloat.this.setValueFloat(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfBoolean.AndFloat.this.getKeyBoolean()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndFloat mapToByteKey(PrimitiveFunction.ToByte.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfBoolean.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfBoolean.AndFloat.this.setValueFloat(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfBoolean.AndFloat.this.getKeyBoolean()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndFloat mapToBooleanKey(PrimitiveFunction.ToBoolean.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndFloat() {
                    public float getValueFloat() { return PrimitiveEntry.OfBoolean.AndFloat.this.getValueFloat(); }
                    public float setValueFloat(float value) { return PrimitiveEntry.OfBoolean.AndFloat.this.setValueFloat(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfBoolean.AndFloat.this.getKeyBoolean()); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfFloat mapper, PrimitiveFunction.ToFloat.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndDouble() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndFloat.this.getKeyBoolean(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfBoolean.AndFloat.this.getValueFloat()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfBoolean.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfFloat mapper, PrimitiveFunction.ToFloat.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndLong() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndFloat.this.getKeyBoolean(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfBoolean.AndFloat.this.getValueFloat()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfBoolean.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfFloat mapper, PrimitiveFunction.ToFloat.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndInt() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndFloat.this.getKeyBoolean(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfBoolean.AndFloat.this.getValueFloat()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfBoolean.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfFloat mapper, PrimitiveFunction.ToFloat.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndFloat() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndFloat.this.getKeyBoolean(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfBoolean.AndFloat.this.getValueFloat()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfBoolean.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfFloat mapper, PrimitiveFunction.ToFloat.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndChar() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndFloat.this.getKeyBoolean(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfBoolean.AndFloat.this.getValueFloat()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfBoolean.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfFloat mapper, PrimitiveFunction.ToFloat.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndShort() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndFloat.this.getKeyBoolean(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfBoolean.AndFloat.this.getValueFloat()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfBoolean.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfFloat mapper, PrimitiveFunction.ToFloat.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndByte() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndFloat.this.getKeyBoolean(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfBoolean.AndFloat.this.getValueFloat()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfBoolean.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfFloat mapper, PrimitiveFunction.ToFloat.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndBoolean() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndFloat.this.getKeyBoolean(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfBoolean.AndFloat.this.getValueFloat()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfBoolean.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
                };
            }
            float getValueFloat();
            float setValueFloat(float value);
        }
        interface AndChar extends OfBoolean<java.lang.Character> {
            @Override default java.lang.Character getValue() { return getValueChar(); }
            @Override default java.lang.Character setValue(java.lang.Character v) { return setValueChar(v); }
            @Override default PrimitiveEntry.OfDouble.AndChar mapToDoubleKey(PrimitiveFunction.ToDouble.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfBoolean.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfBoolean.AndChar.this.setValueChar(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfBoolean.AndChar.this.getKeyBoolean()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndChar mapToLongKey(PrimitiveFunction.ToLong.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfBoolean.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfBoolean.AndChar.this.setValueChar(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfBoolean.AndChar.this.getKeyBoolean()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndChar mapToIntKey(PrimitiveFunction.ToInt.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfBoolean.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfBoolean.AndChar.this.setValueChar(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfBoolean.AndChar.this.getKeyBoolean()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndChar mapToFloatKey(PrimitiveFunction.ToFloat.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfBoolean.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfBoolean.AndChar.this.setValueChar(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfBoolean.AndChar.this.getKeyBoolean()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndChar mapToCharKey(PrimitiveFunction.ToChar.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfBoolean.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfBoolean.AndChar.this.setValueChar(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfBoolean.AndChar.this.getKeyBoolean()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndChar mapToShortKey(PrimitiveFunction.ToShort.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfBoolean.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfBoolean.AndChar.this.setValueChar(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfBoolean.AndChar.this.getKeyBoolean()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndChar mapToByteKey(PrimitiveFunction.ToByte.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfBoolean.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfBoolean.AndChar.this.setValueChar(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfBoolean.AndChar.this.getKeyBoolean()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndChar mapToBooleanKey(PrimitiveFunction.ToBoolean.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndChar() {
                    public char getValueChar() { return PrimitiveEntry.OfBoolean.AndChar.this.getValueChar(); }
                    public char setValueChar(char value) { return PrimitiveEntry.OfBoolean.AndChar.this.setValueChar(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfBoolean.AndChar.this.getKeyBoolean()); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfChar mapper, PrimitiveFunction.ToChar.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndDouble() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndChar.this.getKeyBoolean(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfBoolean.AndChar.this.getValueChar()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfBoolean.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfChar mapper, PrimitiveFunction.ToChar.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndLong() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndChar.this.getKeyBoolean(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfBoolean.AndChar.this.getValueChar()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfBoolean.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfChar mapper, PrimitiveFunction.ToChar.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndInt() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndChar.this.getKeyBoolean(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfBoolean.AndChar.this.getValueChar()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfBoolean.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfChar mapper, PrimitiveFunction.ToChar.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndFloat() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndChar.this.getKeyBoolean(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfBoolean.AndChar.this.getValueChar()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfBoolean.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfChar mapper, PrimitiveFunction.ToChar.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndChar() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndChar.this.getKeyBoolean(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfBoolean.AndChar.this.getValueChar()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfBoolean.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfChar mapper, PrimitiveFunction.ToChar.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndShort() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndChar.this.getKeyBoolean(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfBoolean.AndChar.this.getValueChar()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfBoolean.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfChar mapper, PrimitiveFunction.ToChar.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndByte() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndChar.this.getKeyBoolean(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfBoolean.AndChar.this.getValueChar()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfBoolean.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfChar mapper, PrimitiveFunction.ToChar.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndBoolean() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndChar.this.getKeyBoolean(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfBoolean.AndChar.this.getValueChar()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfBoolean.AndChar.this.setValueChar(rm.applyChar(value))); }
                };
            }
            char getValueChar();
            char setValueChar(char value);
        }
        interface AndShort extends OfBoolean<java.lang.Short> {
            @Override default java.lang.Short getValue() { return getValueShort(); }
            @Override default java.lang.Short setValue(java.lang.Short v) { return setValueShort(v); }
            @Override default PrimitiveEntry.OfDouble.AndShort mapToDoubleKey(PrimitiveFunction.ToDouble.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfBoolean.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfBoolean.AndShort.this.setValueShort(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfBoolean.AndShort.this.getKeyBoolean()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndShort mapToLongKey(PrimitiveFunction.ToLong.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfBoolean.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfBoolean.AndShort.this.setValueShort(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfBoolean.AndShort.this.getKeyBoolean()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndShort mapToIntKey(PrimitiveFunction.ToInt.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfBoolean.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfBoolean.AndShort.this.setValueShort(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfBoolean.AndShort.this.getKeyBoolean()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndShort mapToFloatKey(PrimitiveFunction.ToFloat.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfBoolean.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfBoolean.AndShort.this.setValueShort(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfBoolean.AndShort.this.getKeyBoolean()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndShort mapToCharKey(PrimitiveFunction.ToChar.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfBoolean.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfBoolean.AndShort.this.setValueShort(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfBoolean.AndShort.this.getKeyBoolean()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndShort mapToShortKey(PrimitiveFunction.ToShort.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfBoolean.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfBoolean.AndShort.this.setValueShort(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfBoolean.AndShort.this.getKeyBoolean()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndShort mapToByteKey(PrimitiveFunction.ToByte.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfBoolean.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfBoolean.AndShort.this.setValueShort(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfBoolean.AndShort.this.getKeyBoolean()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndShort mapToBooleanKey(PrimitiveFunction.ToBoolean.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndShort() {
                    public short getValueShort() { return PrimitiveEntry.OfBoolean.AndShort.this.getValueShort(); }
                    public short setValueShort(short value) { return PrimitiveEntry.OfBoolean.AndShort.this.setValueShort(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfBoolean.AndShort.this.getKeyBoolean()); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfShort mapper, PrimitiveFunction.ToShort.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndDouble() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndShort.this.getKeyBoolean(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfBoolean.AndShort.this.getValueShort()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfBoolean.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfShort mapper, PrimitiveFunction.ToShort.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndLong() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndShort.this.getKeyBoolean(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfBoolean.AndShort.this.getValueShort()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfBoolean.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfShort mapper, PrimitiveFunction.ToShort.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndInt() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndShort.this.getKeyBoolean(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfBoolean.AndShort.this.getValueShort()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfBoolean.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfShort mapper, PrimitiveFunction.ToShort.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndFloat() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndShort.this.getKeyBoolean(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfBoolean.AndShort.this.getValueShort()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfBoolean.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfShort mapper, PrimitiveFunction.ToShort.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndChar() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndShort.this.getKeyBoolean(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfBoolean.AndShort.this.getValueShort()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfBoolean.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfShort mapper, PrimitiveFunction.ToShort.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndShort() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndShort.this.getKeyBoolean(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfBoolean.AndShort.this.getValueShort()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfBoolean.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfShort mapper, PrimitiveFunction.ToShort.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndByte() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndShort.this.getKeyBoolean(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfBoolean.AndShort.this.getValueShort()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfBoolean.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfShort mapper, PrimitiveFunction.ToShort.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndBoolean() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndShort.this.getKeyBoolean(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfBoolean.AndShort.this.getValueShort()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfBoolean.AndShort.this.setValueShort(rm.applyShort(value))); }
                };
            }
            short getValueShort();
            short setValueShort(short value);
        }
        interface AndByte extends OfBoolean<java.lang.Byte> {
            @Override default java.lang.Byte getValue() { return getValueByte(); }
            @Override default java.lang.Byte setValue(java.lang.Byte v) { return setValueByte(v); }
            @Override default PrimitiveEntry.OfDouble.AndByte mapToDoubleKey(PrimitiveFunction.ToDouble.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfBoolean.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfBoolean.AndByte.this.setValueByte(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfBoolean.AndByte.this.getKeyBoolean()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndByte mapToLongKey(PrimitiveFunction.ToLong.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfBoolean.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfBoolean.AndByte.this.setValueByte(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfBoolean.AndByte.this.getKeyBoolean()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndByte mapToIntKey(PrimitiveFunction.ToInt.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfBoolean.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfBoolean.AndByte.this.setValueByte(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfBoolean.AndByte.this.getKeyBoolean()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndByte mapToFloatKey(PrimitiveFunction.ToFloat.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfBoolean.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfBoolean.AndByte.this.setValueByte(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfBoolean.AndByte.this.getKeyBoolean()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndByte mapToCharKey(PrimitiveFunction.ToChar.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfBoolean.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfBoolean.AndByte.this.setValueByte(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfBoolean.AndByte.this.getKeyBoolean()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndByte mapToShortKey(PrimitiveFunction.ToShort.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfBoolean.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfBoolean.AndByte.this.setValueByte(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfBoolean.AndByte.this.getKeyBoolean()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndByte mapToByteKey(PrimitiveFunction.ToByte.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfBoolean.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfBoolean.AndByte.this.setValueByte(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfBoolean.AndByte.this.getKeyBoolean()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndByte mapToBooleanKey(PrimitiveFunction.ToBoolean.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndByte() {
                    public byte getValueByte() { return PrimitiveEntry.OfBoolean.AndByte.this.getValueByte(); }
                    public byte setValueByte(byte value) { return PrimitiveEntry.OfBoolean.AndByte.this.setValueByte(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfBoolean.AndByte.this.getKeyBoolean()); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfByte mapper, PrimitiveFunction.ToByte.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndDouble() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndByte.this.getKeyBoolean(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfBoolean.AndByte.this.getValueByte()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfBoolean.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfByte mapper, PrimitiveFunction.ToByte.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndLong() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndByte.this.getKeyBoolean(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfBoolean.AndByte.this.getValueByte()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfBoolean.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfByte mapper, PrimitiveFunction.ToByte.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndInt() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndByte.this.getKeyBoolean(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfBoolean.AndByte.this.getValueByte()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfBoolean.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfByte mapper, PrimitiveFunction.ToByte.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndFloat() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndByte.this.getKeyBoolean(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfBoolean.AndByte.this.getValueByte()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfBoolean.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfByte mapper, PrimitiveFunction.ToByte.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndChar() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndByte.this.getKeyBoolean(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfBoolean.AndByte.this.getValueByte()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfBoolean.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfByte mapper, PrimitiveFunction.ToByte.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndShort() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndByte.this.getKeyBoolean(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfBoolean.AndByte.this.getValueByte()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfBoolean.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfByte mapper, PrimitiveFunction.ToByte.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndByte() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndByte.this.getKeyBoolean(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfBoolean.AndByte.this.getValueByte()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfBoolean.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfByte mapper, PrimitiveFunction.ToByte.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndBoolean() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndByte.this.getKeyBoolean(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfBoolean.AndByte.this.getValueByte()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfBoolean.AndByte.this.setValueByte(rm.applyByte(value))); }
                };
            }
            byte getValueByte();
            byte setValueByte(byte value);
        }
        interface AndBoolean extends OfBoolean<java.lang.Boolean> {
            @Override default java.lang.Boolean getValue() { return getValueBoolean(); }
            @Override default java.lang.Boolean setValue(java.lang.Boolean v) { return setValueBoolean(v); }
            @Override default PrimitiveEntry.OfDouble.AndBoolean mapToDoubleKey(PrimitiveFunction.ToDouble.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfDouble.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfBoolean.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfBoolean.AndBoolean.this.setValueBoolean(value); }
                    public double getKeyDouble() { return mapper.applyDouble(PrimitiveEntry.OfBoolean.AndBoolean.this.getKeyBoolean()); }
                };
            }
            @Override default PrimitiveEntry.OfLong.AndBoolean mapToLongKey(PrimitiveFunction.ToLong.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfLong.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfBoolean.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfBoolean.AndBoolean.this.setValueBoolean(value); }
                    public long getKeyLong() { return mapper.applyLong(PrimitiveEntry.OfBoolean.AndBoolean.this.getKeyBoolean()); }
                };
            }
            @Override default PrimitiveEntry.OfInt.AndBoolean mapToIntKey(PrimitiveFunction.ToInt.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfInt.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfBoolean.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfBoolean.AndBoolean.this.setValueBoolean(value); }
                    public int getKeyInt() { return mapper.applyInt(PrimitiveEntry.OfBoolean.AndBoolean.this.getKeyBoolean()); }
                };
            }
            @Override default PrimitiveEntry.OfFloat.AndBoolean mapToFloatKey(PrimitiveFunction.ToFloat.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfFloat.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfBoolean.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfBoolean.AndBoolean.this.setValueBoolean(value); }
                    public float getKeyFloat() { return mapper.applyFloat(PrimitiveEntry.OfBoolean.AndBoolean.this.getKeyBoolean()); }
                };
            }
            @Override default PrimitiveEntry.OfChar.AndBoolean mapToCharKey(PrimitiveFunction.ToChar.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfChar.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfBoolean.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfBoolean.AndBoolean.this.setValueBoolean(value); }
                    public char getKeyChar() { return mapper.applyChar(PrimitiveEntry.OfBoolean.AndBoolean.this.getKeyBoolean()); }
                };
            }
            @Override default PrimitiveEntry.OfShort.AndBoolean mapToShortKey(PrimitiveFunction.ToShort.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfShort.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfBoolean.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfBoolean.AndBoolean.this.setValueBoolean(value); }
                    public short getKeyShort() { return mapper.applyShort(PrimitiveEntry.OfBoolean.AndBoolean.this.getKeyBoolean()); }
                };
            }
            @Override default PrimitiveEntry.OfByte.AndBoolean mapToByteKey(PrimitiveFunction.ToByte.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfByte.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfBoolean.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfBoolean.AndBoolean.this.setValueBoolean(value); }
                    public byte getKeyByte() { return mapper.applyByte(PrimitiveEntry.OfBoolean.AndBoolean.this.getKeyBoolean()); }
                };
            }
            @Override default PrimitiveEntry.OfBoolean.AndBoolean mapToBooleanKey(PrimitiveFunction.ToBoolean.OfBoolean mapper) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                return new PrimitiveEntry.OfBoolean.AndBoolean() {
                    public boolean getValueBoolean() { return PrimitiveEntry.OfBoolean.AndBoolean.this.getValueBoolean(); }
                    public boolean setValueBoolean(boolean value) { return PrimitiveEntry.OfBoolean.AndBoolean.this.setValueBoolean(value); }
                    public boolean getKeyBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfBoolean.AndBoolean.this.getKeyBoolean()); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndDouble mapToDoubleValue(PrimitiveFunction.ToDouble.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfDouble rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndDouble() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndBoolean.this.getKeyBoolean(); }
                    public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.OfBoolean.AndBoolean.this.getValueBoolean()); }
                    public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.OfBoolean.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndLong mapToLongValue(PrimitiveFunction.ToLong.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfLong rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndLong() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndBoolean.this.getKeyBoolean(); }
                    public long getValueLong() { return mapper.applyLong(PrimitiveEntry.OfBoolean.AndBoolean.this.getValueBoolean()); }
                    public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.OfBoolean.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndInt mapToIntValue(PrimitiveFunction.ToInt.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfInt rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndInt() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndBoolean.this.getKeyBoolean(); }
                    public int getValueInt() { return mapper.applyInt(PrimitiveEntry.OfBoolean.AndBoolean.this.getValueBoolean()); }
                    public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.OfBoolean.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndFloat mapToFloatValue(PrimitiveFunction.ToFloat.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfFloat rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndFloat() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndBoolean.this.getKeyBoolean(); }
                    public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.OfBoolean.AndBoolean.this.getValueBoolean()); }
                    public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.OfBoolean.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndChar mapToCharValue(PrimitiveFunction.ToChar.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfChar rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndChar() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndBoolean.this.getKeyBoolean(); }
                    public char getValueChar() { return mapper.applyChar(PrimitiveEntry.OfBoolean.AndBoolean.this.getValueBoolean()); }
                    public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.OfBoolean.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndShort mapToShortValue(PrimitiveFunction.ToShort.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfShort rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndShort() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndBoolean.this.getKeyBoolean(); }
                    public short getValueShort() { return mapper.applyShort(PrimitiveEntry.OfBoolean.AndBoolean.this.getValueBoolean()); }
                    public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.OfBoolean.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndByte mapToByteValue(PrimitiveFunction.ToByte.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfByte rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndByte() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndBoolean.this.getKeyBoolean(); }
                    public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.OfBoolean.AndBoolean.this.getValueBoolean()); }
                    public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.OfBoolean.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            default PrimitiveEntry.OfBoolean.AndBoolean mapToBooleanValue(PrimitiveFunction.ToBoolean.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfBoolean rm) {
                if(mapper == null) throw new NullPointerException("mapper is null");
                if(rm == null) throw new NullPointerException("rm is null");
                return new PrimitiveEntry.OfBoolean.AndBoolean() {
                    public boolean getKeyBoolean() { return PrimitiveEntry.OfBoolean.AndBoolean.this.getKeyBoolean(); }
                    public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.OfBoolean.AndBoolean.this.getValueBoolean()); }
                    public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.OfBoolean.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
                };
            }
            boolean getValueBoolean();
            boolean setValueBoolean(boolean value);
        }
    }
    
    interface AndDouble<K> extends PrimitiveEntry<K, java.lang.Double> {
        @Override default java.lang.Double setValue(java.lang.Double value) { return setValueDouble(value); }
        @Override default java.lang.Double getValue() { return getValueDouble(); }
        @Override default Map.Entry<K, java.lang.Double> boxed() { return this; }
        default AndDouble<K> mapToDoubleValue(PrimitiveFunction.ToDouble.OfDouble mapper, PrimitiveFunction.ToDouble.OfDouble rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndDouble<K>() {
                public K getKey() { return PrimitiveEntry.AndDouble.this.getKey(); }
                public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.AndDouble.this.getValueDouble()); }
                public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
            };
        }
        default AndLong<K> mapToLongValue(PrimitiveFunction.ToLong.OfDouble mapper, PrimitiveFunction.ToDouble.OfLong rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndLong<K>() {
                public K getKey() { return PrimitiveEntry.AndDouble.this.getKey(); }
                public long getValueLong() { return mapper.applyLong(PrimitiveEntry.AndDouble.this.getValueDouble()); }
                public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
            };
        }
        default AndInt<K> mapToIntValue(PrimitiveFunction.ToInt.OfDouble mapper, PrimitiveFunction.ToDouble.OfInt rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndInt<K>() {
                public K getKey() { return PrimitiveEntry.AndDouble.this.getKey(); }
                public int getValueInt() { return mapper.applyInt(PrimitiveEntry.AndDouble.this.getValueDouble()); }
                public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
            };
        }
        default AndFloat<K> mapToFloatValue(PrimitiveFunction.ToFloat.OfDouble mapper, PrimitiveFunction.ToDouble.OfFloat rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndFloat<K>() {
                public K getKey() { return PrimitiveEntry.AndDouble.this.getKey(); }
                public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.AndDouble.this.getValueDouble()); }
                public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
            };
        }
        default AndChar<K> mapToCharValue(PrimitiveFunction.ToChar.OfDouble mapper, PrimitiveFunction.ToDouble.OfChar rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndChar<K>() {
                public K getKey() { return PrimitiveEntry.AndDouble.this.getKey(); }
                public char getValueChar() { return mapper.applyChar(PrimitiveEntry.AndDouble.this.getValueDouble()); }
                public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
            };
        }
        default AndShort<K> mapToShortValue(PrimitiveFunction.ToShort.OfDouble mapper, PrimitiveFunction.ToDouble.OfShort rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndShort<K>() {
                public K getKey() { return PrimitiveEntry.AndDouble.this.getKey(); }
                public short getValueShort() { return mapper.applyShort(PrimitiveEntry.AndDouble.this.getValueDouble()); }
                public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
            };
        }
        default AndByte<K> mapToByteValue(PrimitiveFunction.ToByte.OfDouble mapper, PrimitiveFunction.ToDouble.OfByte rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndByte<K>() {
                public K getKey() { return PrimitiveEntry.AndDouble.this.getKey(); }
                public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.AndDouble.this.getValueDouble()); }
                public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
            };
        }
        default AndBoolean<K> mapToBooleanValue(PrimitiveFunction.ToBoolean.OfDouble mapper, PrimitiveFunction.ToDouble.OfBoolean rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndBoolean<K>() {
                public K getKey() { return PrimitiveEntry.AndDouble.this.getKey(); }
                public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.AndDouble.this.getValueDouble()); }
                public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.AndDouble.this.setValueDouble(rm.applyDouble(value))); }
            };
        }
        double setValueDouble(double value);
        double getValueDouble();
    }
    interface AndLong<K> extends PrimitiveEntry<K, java.lang.Long> {
        @Override default java.lang.Long setValue(java.lang.Long value) { return setValueLong(value); }
        @Override default java.lang.Long getValue() { return getValueLong(); }
        @Override default Map.Entry<K, java.lang.Long> boxed() { return this; }
        default AndDouble<K> mapToDoubleValue(PrimitiveFunction.ToDouble.OfLong mapper, PrimitiveFunction.ToLong.OfDouble rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndDouble<K>() {
                public K getKey() { return PrimitiveEntry.AndLong.this.getKey(); }
                public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.AndLong.this.getValueLong()); }
                public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.AndLong.this.setValueLong(rm.applyLong(value))); }
            };
        }
        default AndLong<K> mapToLongValue(PrimitiveFunction.ToLong.OfLong mapper, PrimitiveFunction.ToLong.OfLong rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndLong<K>() {
                public K getKey() { return PrimitiveEntry.AndLong.this.getKey(); }
                public long getValueLong() { return mapper.applyLong(PrimitiveEntry.AndLong.this.getValueLong()); }
                public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.AndLong.this.setValueLong(rm.applyLong(value))); }
            };
        }
        default AndInt<K> mapToIntValue(PrimitiveFunction.ToInt.OfLong mapper, PrimitiveFunction.ToLong.OfInt rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndInt<K>() {
                public K getKey() { return PrimitiveEntry.AndLong.this.getKey(); }
                public int getValueInt() { return mapper.applyInt(PrimitiveEntry.AndLong.this.getValueLong()); }
                public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.AndLong.this.setValueLong(rm.applyLong(value))); }
            };
        }
        default AndFloat<K> mapToFloatValue(PrimitiveFunction.ToFloat.OfLong mapper, PrimitiveFunction.ToLong.OfFloat rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndFloat<K>() {
                public K getKey() { return PrimitiveEntry.AndLong.this.getKey(); }
                public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.AndLong.this.getValueLong()); }
                public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.AndLong.this.setValueLong(rm.applyLong(value))); }
            };
        }
        default AndChar<K> mapToCharValue(PrimitiveFunction.ToChar.OfLong mapper, PrimitiveFunction.ToLong.OfChar rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndChar<K>() {
                public K getKey() { return PrimitiveEntry.AndLong.this.getKey(); }
                public char getValueChar() { return mapper.applyChar(PrimitiveEntry.AndLong.this.getValueLong()); }
                public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.AndLong.this.setValueLong(rm.applyLong(value))); }
            };
        }
        default AndShort<K> mapToShortValue(PrimitiveFunction.ToShort.OfLong mapper, PrimitiveFunction.ToLong.OfShort rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndShort<K>() {
                public K getKey() { return PrimitiveEntry.AndLong.this.getKey(); }
                public short getValueShort() { return mapper.applyShort(PrimitiveEntry.AndLong.this.getValueLong()); }
                public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.AndLong.this.setValueLong(rm.applyLong(value))); }
            };
        }
        default AndByte<K> mapToByteValue(PrimitiveFunction.ToByte.OfLong mapper, PrimitiveFunction.ToLong.OfByte rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndByte<K>() {
                public K getKey() { return PrimitiveEntry.AndLong.this.getKey(); }
                public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.AndLong.this.getValueLong()); }
                public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.AndLong.this.setValueLong(rm.applyLong(value))); }
            };
        }
        default AndBoolean<K> mapToBooleanValue(PrimitiveFunction.ToBoolean.OfLong mapper, PrimitiveFunction.ToLong.OfBoolean rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndBoolean<K>() {
                public K getKey() { return PrimitiveEntry.AndLong.this.getKey(); }
                public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.AndLong.this.getValueLong()); }
                public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.AndLong.this.setValueLong(rm.applyLong(value))); }
            };
        }
        long setValueLong(long value);
        long getValueLong();
    }
    interface AndInt<K> extends PrimitiveEntry<K, java.lang.Integer> {
        @Override default java.lang.Integer setValue(java.lang.Integer value) { return setValueInt(value); }
        @Override default java.lang.Integer getValue() { return getValueInt(); }
        @Override default Map.Entry<K, java.lang.Integer> boxed() { return this; }
        default AndDouble<K> mapToDoubleValue(PrimitiveFunction.ToDouble.OfInt mapper, PrimitiveFunction.ToInt.OfDouble rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndDouble<K>() {
                public K getKey() { return PrimitiveEntry.AndInt.this.getKey(); }
                public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.AndInt.this.getValueInt()); }
                public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.AndInt.this.setValueInt(rm.applyInt(value))); }
            };
        }
        default AndLong<K> mapToLongValue(PrimitiveFunction.ToLong.OfInt mapper, PrimitiveFunction.ToInt.OfLong rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndLong<K>() {
                public K getKey() { return PrimitiveEntry.AndInt.this.getKey(); }
                public long getValueLong() { return mapper.applyLong(PrimitiveEntry.AndInt.this.getValueInt()); }
                public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.AndInt.this.setValueInt(rm.applyInt(value))); }
            };
        }
        default AndInt<K> mapToIntValue(PrimitiveFunction.ToInt.OfInt mapper, PrimitiveFunction.ToInt.OfInt rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndInt<K>() {
                public K getKey() { return PrimitiveEntry.AndInt.this.getKey(); }
                public int getValueInt() { return mapper.applyInt(PrimitiveEntry.AndInt.this.getValueInt()); }
                public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.AndInt.this.setValueInt(rm.applyInt(value))); }
            };
        }
        default AndFloat<K> mapToFloatValue(PrimitiveFunction.ToFloat.OfInt mapper, PrimitiveFunction.ToInt.OfFloat rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndFloat<K>() {
                public K getKey() { return PrimitiveEntry.AndInt.this.getKey(); }
                public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.AndInt.this.getValueInt()); }
                public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.AndInt.this.setValueInt(rm.applyInt(value))); }
            };
        }
        default AndChar<K> mapToCharValue(PrimitiveFunction.ToChar.OfInt mapper, PrimitiveFunction.ToInt.OfChar rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndChar<K>() {
                public K getKey() { return PrimitiveEntry.AndInt.this.getKey(); }
                public char getValueChar() { return mapper.applyChar(PrimitiveEntry.AndInt.this.getValueInt()); }
                public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.AndInt.this.setValueInt(rm.applyInt(value))); }
            };
        }
        default AndShort<K> mapToShortValue(PrimitiveFunction.ToShort.OfInt mapper, PrimitiveFunction.ToInt.OfShort rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndShort<K>() {
                public K getKey() { return PrimitiveEntry.AndInt.this.getKey(); }
                public short getValueShort() { return mapper.applyShort(PrimitiveEntry.AndInt.this.getValueInt()); }
                public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.AndInt.this.setValueInt(rm.applyInt(value))); }
            };
        }
        default AndByte<K> mapToByteValue(PrimitiveFunction.ToByte.OfInt mapper, PrimitiveFunction.ToInt.OfByte rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndByte<K>() {
                public K getKey() { return PrimitiveEntry.AndInt.this.getKey(); }
                public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.AndInt.this.getValueInt()); }
                public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.AndInt.this.setValueInt(rm.applyInt(value))); }
            };
        }
        default AndBoolean<K> mapToBooleanValue(PrimitiveFunction.ToBoolean.OfInt mapper, PrimitiveFunction.ToInt.OfBoolean rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndBoolean<K>() {
                public K getKey() { return PrimitiveEntry.AndInt.this.getKey(); }
                public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.AndInt.this.getValueInt()); }
                public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.AndInt.this.setValueInt(rm.applyInt(value))); }
            };
        }
        int setValueInt(int value);
        int getValueInt();
    }
    interface AndFloat<K> extends PrimitiveEntry<K, java.lang.Float> {
        @Override default java.lang.Float setValue(java.lang.Float value) { return setValueFloat(value); }
        @Override default java.lang.Float getValue() { return getValueFloat(); }
        @Override default Map.Entry<K, java.lang.Float> boxed() { return this; }
        default AndDouble<K> mapToDoubleValue(PrimitiveFunction.ToDouble.OfFloat mapper, PrimitiveFunction.ToFloat.OfDouble rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndDouble<K>() {
                public K getKey() { return PrimitiveEntry.AndFloat.this.getKey(); }
                public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.AndFloat.this.getValueFloat()); }
                public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
            };
        }
        default AndLong<K> mapToLongValue(PrimitiveFunction.ToLong.OfFloat mapper, PrimitiveFunction.ToFloat.OfLong rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndLong<K>() {
                public K getKey() { return PrimitiveEntry.AndFloat.this.getKey(); }
                public long getValueLong() { return mapper.applyLong(PrimitiveEntry.AndFloat.this.getValueFloat()); }
                public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
            };
        }
        default AndInt<K> mapToIntValue(PrimitiveFunction.ToInt.OfFloat mapper, PrimitiveFunction.ToFloat.OfInt rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndInt<K>() {
                public K getKey() { return PrimitiveEntry.AndFloat.this.getKey(); }
                public int getValueInt() { return mapper.applyInt(PrimitiveEntry.AndFloat.this.getValueFloat()); }
                public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
            };
        }
        default AndFloat<K> mapToFloatValue(PrimitiveFunction.ToFloat.OfFloat mapper, PrimitiveFunction.ToFloat.OfFloat rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndFloat<K>() {
                public K getKey() { return PrimitiveEntry.AndFloat.this.getKey(); }
                public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.AndFloat.this.getValueFloat()); }
                public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
            };
        }
        default AndChar<K> mapToCharValue(PrimitiveFunction.ToChar.OfFloat mapper, PrimitiveFunction.ToFloat.OfChar rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndChar<K>() {
                public K getKey() { return PrimitiveEntry.AndFloat.this.getKey(); }
                public char getValueChar() { return mapper.applyChar(PrimitiveEntry.AndFloat.this.getValueFloat()); }
                public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
            };
        }
        default AndShort<K> mapToShortValue(PrimitiveFunction.ToShort.OfFloat mapper, PrimitiveFunction.ToFloat.OfShort rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndShort<K>() {
                public K getKey() { return PrimitiveEntry.AndFloat.this.getKey(); }
                public short getValueShort() { return mapper.applyShort(PrimitiveEntry.AndFloat.this.getValueFloat()); }
                public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
            };
        }
        default AndByte<K> mapToByteValue(PrimitiveFunction.ToByte.OfFloat mapper, PrimitiveFunction.ToFloat.OfByte rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndByte<K>() {
                public K getKey() { return PrimitiveEntry.AndFloat.this.getKey(); }
                public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.AndFloat.this.getValueFloat()); }
                public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
            };
        }
        default AndBoolean<K> mapToBooleanValue(PrimitiveFunction.ToBoolean.OfFloat mapper, PrimitiveFunction.ToFloat.OfBoolean rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndBoolean<K>() {
                public K getKey() { return PrimitiveEntry.AndFloat.this.getKey(); }
                public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.AndFloat.this.getValueFloat()); }
                public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.AndFloat.this.setValueFloat(rm.applyFloat(value))); }
            };
        }
        float setValueFloat(float value);
        float getValueFloat();
    }
    interface AndChar<K> extends PrimitiveEntry<K, java.lang.Character> {
        @Override default java.lang.Character setValue(java.lang.Character value) { return setValueChar(value); }
        @Override default java.lang.Character getValue() { return getValueChar(); }
        @Override default Map.Entry<K, java.lang.Character> boxed() { return this; }
        default AndDouble<K> mapToDoubleValue(PrimitiveFunction.ToDouble.OfChar mapper, PrimitiveFunction.ToChar.OfDouble rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndDouble<K>() {
                public K getKey() { return PrimitiveEntry.AndChar.this.getKey(); }
                public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.AndChar.this.getValueChar()); }
                public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.AndChar.this.setValueChar(rm.applyChar(value))); }
            };
        }
        default AndLong<K> mapToLongValue(PrimitiveFunction.ToLong.OfChar mapper, PrimitiveFunction.ToChar.OfLong rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndLong<K>() {
                public K getKey() { return PrimitiveEntry.AndChar.this.getKey(); }
                public long getValueLong() { return mapper.applyLong(PrimitiveEntry.AndChar.this.getValueChar()); }
                public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.AndChar.this.setValueChar(rm.applyChar(value))); }
            };
        }
        default AndInt<K> mapToIntValue(PrimitiveFunction.ToInt.OfChar mapper, PrimitiveFunction.ToChar.OfInt rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndInt<K>() {
                public K getKey() { return PrimitiveEntry.AndChar.this.getKey(); }
                public int getValueInt() { return mapper.applyInt(PrimitiveEntry.AndChar.this.getValueChar()); }
                public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.AndChar.this.setValueChar(rm.applyChar(value))); }
            };
        }
        default AndFloat<K> mapToFloatValue(PrimitiveFunction.ToFloat.OfChar mapper, PrimitiveFunction.ToChar.OfFloat rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndFloat<K>() {
                public K getKey() { return PrimitiveEntry.AndChar.this.getKey(); }
                public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.AndChar.this.getValueChar()); }
                public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.AndChar.this.setValueChar(rm.applyChar(value))); }
            };
        }
        default AndChar<K> mapToCharValue(PrimitiveFunction.ToChar.OfChar mapper, PrimitiveFunction.ToChar.OfChar rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndChar<K>() {
                public K getKey() { return PrimitiveEntry.AndChar.this.getKey(); }
                public char getValueChar() { return mapper.applyChar(PrimitiveEntry.AndChar.this.getValueChar()); }
                public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.AndChar.this.setValueChar(rm.applyChar(value))); }
            };
        }
        default AndShort<K> mapToShortValue(PrimitiveFunction.ToShort.OfChar mapper, PrimitiveFunction.ToChar.OfShort rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndShort<K>() {
                public K getKey() { return PrimitiveEntry.AndChar.this.getKey(); }
                public short getValueShort() { return mapper.applyShort(PrimitiveEntry.AndChar.this.getValueChar()); }
                public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.AndChar.this.setValueChar(rm.applyChar(value))); }
            };
        }
        default AndByte<K> mapToByteValue(PrimitiveFunction.ToByte.OfChar mapper, PrimitiveFunction.ToChar.OfByte rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndByte<K>() {
                public K getKey() { return PrimitiveEntry.AndChar.this.getKey(); }
                public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.AndChar.this.getValueChar()); }
                public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.AndChar.this.setValueChar(rm.applyChar(value))); }
            };
        }
        default AndBoolean<K> mapToBooleanValue(PrimitiveFunction.ToBoolean.OfChar mapper, PrimitiveFunction.ToChar.OfBoolean rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndBoolean<K>() {
                public K getKey() { return PrimitiveEntry.AndChar.this.getKey(); }
                public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.AndChar.this.getValueChar()); }
                public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.AndChar.this.setValueChar(rm.applyChar(value))); }
            };
        }
        char setValueChar(char value);
        char getValueChar();
    }
    interface AndShort<K> extends PrimitiveEntry<K, java.lang.Short> {
        @Override default java.lang.Short setValue(java.lang.Short value) { return setValueShort(value); }
        @Override default java.lang.Short getValue() { return getValueShort(); }
        @Override default Map.Entry<K, java.lang.Short> boxed() { return this; }
        default AndDouble<K> mapToDoubleValue(PrimitiveFunction.ToDouble.OfShort mapper, PrimitiveFunction.ToShort.OfDouble rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndDouble<K>() {
                public K getKey() { return PrimitiveEntry.AndShort.this.getKey(); }
                public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.AndShort.this.getValueShort()); }
                public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.AndShort.this.setValueShort(rm.applyShort(value))); }
            };
        }
        default AndLong<K> mapToLongValue(PrimitiveFunction.ToLong.OfShort mapper, PrimitiveFunction.ToShort.OfLong rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndLong<K>() {
                public K getKey() { return PrimitiveEntry.AndShort.this.getKey(); }
                public long getValueLong() { return mapper.applyLong(PrimitiveEntry.AndShort.this.getValueShort()); }
                public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.AndShort.this.setValueShort(rm.applyShort(value))); }
            };
        }
        default AndInt<K> mapToIntValue(PrimitiveFunction.ToInt.OfShort mapper, PrimitiveFunction.ToShort.OfInt rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndInt<K>() {
                public K getKey() { return PrimitiveEntry.AndShort.this.getKey(); }
                public int getValueInt() { return mapper.applyInt(PrimitiveEntry.AndShort.this.getValueShort()); }
                public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.AndShort.this.setValueShort(rm.applyShort(value))); }
            };
        }
        default AndFloat<K> mapToFloatValue(PrimitiveFunction.ToFloat.OfShort mapper, PrimitiveFunction.ToShort.OfFloat rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndFloat<K>() {
                public K getKey() { return PrimitiveEntry.AndShort.this.getKey(); }
                public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.AndShort.this.getValueShort()); }
                public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.AndShort.this.setValueShort(rm.applyShort(value))); }
            };
        }
        default AndChar<K> mapToCharValue(PrimitiveFunction.ToChar.OfShort mapper, PrimitiveFunction.ToShort.OfChar rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndChar<K>() {
                public K getKey() { return PrimitiveEntry.AndShort.this.getKey(); }
                public char getValueChar() { return mapper.applyChar(PrimitiveEntry.AndShort.this.getValueShort()); }
                public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.AndShort.this.setValueShort(rm.applyShort(value))); }
            };
        }
        default AndShort<K> mapToShortValue(PrimitiveFunction.ToShort.OfShort mapper, PrimitiveFunction.ToShort.OfShort rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndShort<K>() {
                public K getKey() { return PrimitiveEntry.AndShort.this.getKey(); }
                public short getValueShort() { return mapper.applyShort(PrimitiveEntry.AndShort.this.getValueShort()); }
                public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.AndShort.this.setValueShort(rm.applyShort(value))); }
            };
        }
        default AndByte<K> mapToByteValue(PrimitiveFunction.ToByte.OfShort mapper, PrimitiveFunction.ToShort.OfByte rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndByte<K>() {
                public K getKey() { return PrimitiveEntry.AndShort.this.getKey(); }
                public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.AndShort.this.getValueShort()); }
                public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.AndShort.this.setValueShort(rm.applyShort(value))); }
            };
        }
        default AndBoolean<K> mapToBooleanValue(PrimitiveFunction.ToBoolean.OfShort mapper, PrimitiveFunction.ToShort.OfBoolean rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndBoolean<K>() {
                public K getKey() { return PrimitiveEntry.AndShort.this.getKey(); }
                public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.AndShort.this.getValueShort()); }
                public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.AndShort.this.setValueShort(rm.applyShort(value))); }
            };
        }
        short setValueShort(short value);
        short getValueShort();
    }
    interface AndByte<K> extends PrimitiveEntry<K, java.lang.Byte> {
        @Override default java.lang.Byte setValue(java.lang.Byte value) { return setValueByte(value); }
        @Override default java.lang.Byte getValue() { return getValueByte(); }
        @Override default Map.Entry<K, java.lang.Byte> boxed() { return this; }
        default AndDouble<K> mapToDoubleValue(PrimitiveFunction.ToDouble.OfByte mapper, PrimitiveFunction.ToByte.OfDouble rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndDouble<K>() {
                public K getKey() { return PrimitiveEntry.AndByte.this.getKey(); }
                public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.AndByte.this.getValueByte()); }
                public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.AndByte.this.setValueByte(rm.applyByte(value))); }
            };
        }
        default AndLong<K> mapToLongValue(PrimitiveFunction.ToLong.OfByte mapper, PrimitiveFunction.ToByte.OfLong rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndLong<K>() {
                public K getKey() { return PrimitiveEntry.AndByte.this.getKey(); }
                public long getValueLong() { return mapper.applyLong(PrimitiveEntry.AndByte.this.getValueByte()); }
                public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.AndByte.this.setValueByte(rm.applyByte(value))); }
            };
        }
        default AndInt<K> mapToIntValue(PrimitiveFunction.ToInt.OfByte mapper, PrimitiveFunction.ToByte.OfInt rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndInt<K>() {
                public K getKey() { return PrimitiveEntry.AndByte.this.getKey(); }
                public int getValueInt() { return mapper.applyInt(PrimitiveEntry.AndByte.this.getValueByte()); }
                public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.AndByte.this.setValueByte(rm.applyByte(value))); }
            };
        }
        default AndFloat<K> mapToFloatValue(PrimitiveFunction.ToFloat.OfByte mapper, PrimitiveFunction.ToByte.OfFloat rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndFloat<K>() {
                public K getKey() { return PrimitiveEntry.AndByte.this.getKey(); }
                public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.AndByte.this.getValueByte()); }
                public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.AndByte.this.setValueByte(rm.applyByte(value))); }
            };
        }
        default AndChar<K> mapToCharValue(PrimitiveFunction.ToChar.OfByte mapper, PrimitiveFunction.ToByte.OfChar rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndChar<K>() {
                public K getKey() { return PrimitiveEntry.AndByte.this.getKey(); }
                public char getValueChar() { return mapper.applyChar(PrimitiveEntry.AndByte.this.getValueByte()); }
                public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.AndByte.this.setValueByte(rm.applyByte(value))); }
            };
        }
        default AndShort<K> mapToShortValue(PrimitiveFunction.ToShort.OfByte mapper, PrimitiveFunction.ToByte.OfShort rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndShort<K>() {
                public K getKey() { return PrimitiveEntry.AndByte.this.getKey(); }
                public short getValueShort() { return mapper.applyShort(PrimitiveEntry.AndByte.this.getValueByte()); }
                public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.AndByte.this.setValueByte(rm.applyByte(value))); }
            };
        }
        default AndByte<K> mapToByteValue(PrimitiveFunction.ToByte.OfByte mapper, PrimitiveFunction.ToByte.OfByte rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndByte<K>() {
                public K getKey() { return PrimitiveEntry.AndByte.this.getKey(); }
                public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.AndByte.this.getValueByte()); }
                public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.AndByte.this.setValueByte(rm.applyByte(value))); }
            };
        }
        default AndBoolean<K> mapToBooleanValue(PrimitiveFunction.ToBoolean.OfByte mapper, PrimitiveFunction.ToByte.OfBoolean rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndBoolean<K>() {
                public K getKey() { return PrimitiveEntry.AndByte.this.getKey(); }
                public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.AndByte.this.getValueByte()); }
                public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.AndByte.this.setValueByte(rm.applyByte(value))); }
            };
        }
        byte setValueByte(byte value);
        byte getValueByte();
    }
    interface AndBoolean<K> extends PrimitiveEntry<K, java.lang.Boolean> {
        @Override default java.lang.Boolean setValue(java.lang.Boolean value) { return setValueBoolean(value); }
        @Override default java.lang.Boolean getValue() { return getValueBoolean(); }
        @Override default Map.Entry<K, java.lang.Boolean> boxed() { return this; }
        default AndDouble<K> mapToDoubleValue(PrimitiveFunction.ToDouble.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfDouble rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndDouble<K>() {
                public K getKey() { return PrimitiveEntry.AndBoolean.this.getKey(); }
                public double getValueDouble() { return mapper.applyDouble(PrimitiveEntry.AndBoolean.this.getValueBoolean()); }
                public double setValueDouble(double value) { return mapper.applyDouble(PrimitiveEntry.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
            };
        }
        default AndLong<K> mapToLongValue(PrimitiveFunction.ToLong.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfLong rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndLong<K>() {
                public K getKey() { return PrimitiveEntry.AndBoolean.this.getKey(); }
                public long getValueLong() { return mapper.applyLong(PrimitiveEntry.AndBoolean.this.getValueBoolean()); }
                public long setValueLong(long value) { return mapper.applyLong(PrimitiveEntry.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
            };
        }
        default AndInt<K> mapToIntValue(PrimitiveFunction.ToInt.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfInt rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndInt<K>() {
                public K getKey() { return PrimitiveEntry.AndBoolean.this.getKey(); }
                public int getValueInt() { return mapper.applyInt(PrimitiveEntry.AndBoolean.this.getValueBoolean()); }
                public int setValueInt(int value) { return mapper.applyInt(PrimitiveEntry.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
            };
        }
        default AndFloat<K> mapToFloatValue(PrimitiveFunction.ToFloat.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfFloat rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndFloat<K>() {
                public K getKey() { return PrimitiveEntry.AndBoolean.this.getKey(); }
                public float getValueFloat() { return mapper.applyFloat(PrimitiveEntry.AndBoolean.this.getValueBoolean()); }
                public float setValueFloat(float value) { return mapper.applyFloat(PrimitiveEntry.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
            };
        }
        default AndChar<K> mapToCharValue(PrimitiveFunction.ToChar.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfChar rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndChar<K>() {
                public K getKey() { return PrimitiveEntry.AndBoolean.this.getKey(); }
                public char getValueChar() { return mapper.applyChar(PrimitiveEntry.AndBoolean.this.getValueBoolean()); }
                public char setValueChar(char value) { return mapper.applyChar(PrimitiveEntry.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
            };
        }
        default AndShort<K> mapToShortValue(PrimitiveFunction.ToShort.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfShort rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndShort<K>() {
                public K getKey() { return PrimitiveEntry.AndBoolean.this.getKey(); }
                public short getValueShort() { return mapper.applyShort(PrimitiveEntry.AndBoolean.this.getValueBoolean()); }
                public short setValueShort(short value) { return mapper.applyShort(PrimitiveEntry.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
            };
        }
        default AndByte<K> mapToByteValue(PrimitiveFunction.ToByte.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfByte rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndByte<K>() {
                public K getKey() { return PrimitiveEntry.AndBoolean.this.getKey(); }
                public byte getValueByte() { return mapper.applyByte(PrimitiveEntry.AndBoolean.this.getValueBoolean()); }
                public byte setValueByte(byte value) { return mapper.applyByte(PrimitiveEntry.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
            };
        }
        default AndBoolean<K> mapToBooleanValue(PrimitiveFunction.ToBoolean.OfBoolean mapper, PrimitiveFunction.ToBoolean.OfBoolean rm) {
            if(mapper == null) throw new NullPointerException("mapper is null");
            if(rm == null) throw new NullPointerException("rm is null");
            return new AndBoolean<K>() {
                public K getKey() { return PrimitiveEntry.AndBoolean.this.getKey(); }
                public boolean getValueBoolean() { return mapper.applyBoolean(PrimitiveEntry.AndBoolean.this.getValueBoolean()); }
                public boolean setValueBoolean(boolean value) { return mapper.applyBoolean(PrimitiveEntry.AndBoolean.this.setValueBoolean(rm.applyBoolean(value))); }
            };
        }
        boolean setValueBoolean(boolean value);
        boolean getValueBoolean();
    }

    @Override
    Map.Entry<K, V> boxed();
}
