package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class GraWojnaTest {

    @Test
    public void symuluj() {
        GraWojna g1 = new GraWojna();
        GraWojna g2 = new GraWojna();
        assertNotEquals(g1.talia, g2.talia);
    }
}