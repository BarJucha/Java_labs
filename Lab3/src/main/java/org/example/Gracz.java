package org.example;

import java.util.ArrayList;

/**
 * Klasa Gracz opisuje gracza biorącego udział w grze
 */
public class Gracz {
    /**
     * Zmienna Talia kartyGracza opisuje karty, które posiada gracz.
     */
    public Talia kartyGracza;
    public Gracz(){
        this.kartyGracza = new Talia(new ArrayList<>());
    }

    /**
     * @param karty metoda przyjmuje liste kart, które następnie dodaje do talii gracza.
     */
    public void dodajKarte(ArrayList<Karta> karty){
        kartyGracza.karty.addAll(karty);
    }

    /**
     *
     * @param karta metoda przyjmuje karte, która zostaje dodana do talii gracza.
     */
    public void dodajKarte(Karta karta){
        kartyGracza.karty.add(karta);
    }

    /**
     * Metoda dajKarte() bierze kartę z talii gracza
     * @return Zwraca jedną kartę z talii gracza
     * @throws BrakKartException Jeśli gracz nie ma już kart wyrzyca wyjątek BrakKartException
     */
    public Karta dajKarte() throws BrakKartException {
        return kartyGracza.pociagnijKarte();
    }
}
