package org.example;

import java.util.ArrayList;

/**
 * Klasa SprawdzarkaWygranej stworzona jest aby sprawdzać czy jest wygrany.
 */
public class SprawdzarkaWygranej {
    /**
     * Przyjmuje dwa argumenty i jesli jest koniec wyswietla wynik gry.
     * @param gracze przyjmuje tablice graczy, w grze
     * @param tura przyjmuje numer tury
     * @return Zwraca false jeśli obaj gracze posiadają karty, false w przeciwnym wypadku
     */
    static boolean Sprawdz(ArrayList<Gracz> gracze, int tura){
        if(gracze.get(0).kartyGracza.isEmpty() && gracze.get(1).kartyGracza.isEmpty()){
            System.out.println("REMIS! Tura: " + tura);
            return true;
        }
        if(gracze.get(0).kartyGracza.isEmpty()){
            System.out.println("Wygral gracz 2 w turze: " + tura);
            return true;
        }
        if(gracze.get(1).kartyGracza.isEmpty()){
            System.out.println("Wygral gracz 1 w turze: " + tura);
            return true;
        }
        return false;
    }
}
