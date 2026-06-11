package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class TriangleTest {
    @Test
    public void testEquilateral() {
        assertEquals("Equilateral", Triangle.type(3,3,3));
    }

    @Test
    public void testIsosceles() {
        assertEquals("Isosceles", Triangle.type(3,3,4));
    }

    @Test
    public void testScalene() {
        assertEquals("Scalene", Triangle.type(3,4,5));
    }
}
