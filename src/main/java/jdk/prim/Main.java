package jdk.prim;


import java.util.Iterator;
import jdk.prim.util.PrimitiveIterators;

/**
 * Hello world!
 *
 */
public class Main 
{
	
	public int testValue() {
        var a = new String[]{"david", "samson", "joshua", "moses"};
        Iterator<String> itr = PrimitiveIterators.reverseItr(a);
        int i = 0;
        while(itr.hasNext()) { System.out.println(String.format("next: %1$s, length: %2$d, iteration: %3$d", itr.next(), a.length, i++)); if(i > 6) break; }
        return a.length;
	}
	
    public static void main( String[] args )
    {
        System.out.println(new Main().testValue());
    }
}
