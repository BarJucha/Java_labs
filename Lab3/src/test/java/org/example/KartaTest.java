package org.example;

import static org.junit.Assert.*;

public class KartaTest {

    @org.junit.Test
    public void getKolor() {
        Karta k1 = new Karta(Kolor.Trefl, Typ.K);
        assertEquals(Kolor.Trefl, k1.getKolor());
    }

    @org.junit.Test
    public void getTyp() {
        Karta k1 = new Karta(Kolor.Trefl, Typ.K);
        assertEquals(Typ.K, k1.getTyp());
    }

    @org.junit.Test
    public void getNumer() {
        Karta k1 = new Karta(Kolor.Pik, Typ.DZIESIEC);
        assertEquals(k1.getNumer(), Typ.DZIESIEC.getValue());
    }

    @org.junit.Test
    public void testEquals() {
        Karta k1 = new Karta(Kolor.Kier, Typ.SZESC);
        Karta k2 = new Karta(Kolor.Kier, Typ.SZESC);
        assertTrue(k1.equals(k2));
    }

    @org.junit.Test
    public void testHashCode() {
        Karta k1 = new Karta(Kolor.Kier, Typ.SZESC);
        Karta k2 = new Karta(Kolor.Kier, Typ.SZESC);
        Karta k3 = new Karta(Kolor.Kier, Typ.PIEC);
        assertEquals(k1.hashCode(), k2.hashCode());
        assertNotEquals(k1.hashCode(),k3.hashCode());
    }

    @org.junit.Test
    public void wyswietlKarte() {
        assertTrue(true);
    }
}