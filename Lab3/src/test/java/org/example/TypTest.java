package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class TypTest {

    @Test
    public void getValue() {
        Typ t = Typ.Q;
        assertEquals(12, t.getValue());
    }
}