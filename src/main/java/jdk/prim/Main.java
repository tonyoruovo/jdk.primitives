package jdk.prim;

import jdk.prim.util.function.PrimitiveBiFunction;

/**
 * Hello world!
 *
 */
public class Main 
{
	
	public int testValue() {
        PrimitiveBiFunction.ToChar.OfShort.AndByte f = (x, y) -> java.lang.Character.highSurrogate((x << 31) | y);
        var g = f.andThenInt(x -> String.valueOf(x).codePointAt(0));
		return g.applyInt((short) 0xffe3, (byte) 0xf5);
	}
	
    public static void main( String[] args )
    {
        System.out.println(new Main().testValue());
    }
}
