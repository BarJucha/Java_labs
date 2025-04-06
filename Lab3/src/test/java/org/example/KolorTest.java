package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class KolorTest {

    @Test
    public void values() {
        Kolor k1 = Kolor.Kier;
        assertEquals(k1, Kolor.Kier);
    }

    @Test
    public void valueOf() {
        Kolor k1 = Kolor.Kier;
        assertNotEquals(k1, Kolor.Pik);
    }
}