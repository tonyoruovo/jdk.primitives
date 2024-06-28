package prim.test;

// import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import jdk.prim.Main;

public class MainTest {

    private final Main m = new Main();

    @Test
    void addition() {
		System.out.println("Starting tests...");
        // assertEquals("Hello World!", m.hello());
        System.out.println(m.testValue());
    }

}
