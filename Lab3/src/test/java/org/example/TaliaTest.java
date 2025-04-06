package org.example;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TaliaTest {

    @Test
    public void utworzPelnaTalie() {
        Talia talia = Talia.utworzPelnaTalie();
        assertTrue(talia.getKarty().size() == 52);
    }

    @Test
    public void potasuj() {
        Talia talia = Talia.utworzPelnaTalie();
        Talia talia2 = Talia.utworzPelnaTalie();
        talia2.potasuj();
        assertNotEquals(talia, talia2);
    }

    @Test
    public void pociagnijKarte() throws BrakKartException {
        Talia talia = Talia.utworzPelnaTalie();
        Karta k2 = talia.pociagnijKarte();
        assertEquals(Kolor.Trefl, k2.getKolor());
        assertNotEquals(Kolor.Karo, k2.getKolor());
    }

    @Test
    public void getKarty() {
        Talia t = Talia.utworzPelnaTalie();
        ArrayList<Karta> karty = t.getKarty();
        assertEquals(karty.get(0).getKolor(), Kolor.Trefl);
    }

    @Test
    public void wyswietlTalie() {
    }

    @Test
    public void isEmpty() {
        Talia t = Talia.utworzPelnaTalie();
        assertFalse(t.isEmpty());
    }
}