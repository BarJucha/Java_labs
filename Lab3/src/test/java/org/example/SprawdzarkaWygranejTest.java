package org.example;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SprawdzarkaWygranejTest {

    @Test
    public void sprawdz() {
        Gracz g1 = new Gracz();
        Gracz g2 = new Gracz();
        Gracz g3 = new Gracz();
        Karta k1 = new Karta(Kolor.Pik, Typ.SZESC);
        g1.dodajKarte(k1);
        g2.dodajKarte(k1);
        ArrayList<Gracz> test1 = new ArrayList<>();
        test1.add(g1);
        test1.add(g2);
        assertFalse(SprawdzarkaWygranej.Sprawdz(test1, 1));
        test1.remove(1);
        test1.add(g3);
        assertTrue(SprawdzarkaWygranej.Sprawdz(test1, 1));
    }
}