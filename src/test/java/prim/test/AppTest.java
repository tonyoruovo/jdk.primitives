package prim.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import prim.App;

public class AppTest {

    private final App app = new App();

    @Test
    void addition() {
		System.out.println("Starting tests...");
        assertEquals("Hello World!", app.hello());
    }

}
