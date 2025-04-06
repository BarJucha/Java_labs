package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class GraczTest {

    @Test
    public void dodajKarte() {
        Karta k1 = new Karta(Kolor.Pik, Typ.K);
        Gracz g = new Gracz();
        g.dodajKarte(k1);
        assertEquals(k1.getKolor(), g.kartyGracza.karty.get(0).getKolor());
    }

    @Test
    public void testDodajKarte() {
    }

    @Test
    public void dajKarte() throws BrakKartException {
        Karta k1 = new Karta(Kolor.Pik, Typ.K);
        Gracz g = new Gracz();
        g.dodajKarte(k1);
        assertEquals(k1.getKolor(), g.dajKarte().getKolor());
    }
}