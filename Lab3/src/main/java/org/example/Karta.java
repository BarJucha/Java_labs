package org.example;

import java.util.Objects;

/**
 * Klasa Karta opisuje kartę do gry.
 */
public class Karta {
    /**
     * Zmienna Kolor kolor przechowuje informacje o kolorze karty.
     */
    private Kolor kolor;
    /**
     * Zmienna Typ typ przechowuje informacje o typie karty.
     */
    private Typ typ;

    /**
     * Konstruktor dwu argumentowy
     * @param kolor kolor jaki otrzymuje karta
     * @param typ typ jaki otrzymuje karta
     */
    public Karta(Kolor kolor, Typ typ){
        this.typ = typ;
        this.kolor = kolor;
    }

    /**
     * Metoda getKolor():
     * @return Zwraca kolor karty
     */
    public Kolor getKolor(){
        return kolor;
    }
    /**
     * Metoda getTyp():
     * @return Zwraca typ karty
     */
    public Typ getTyp(){
        return typ;
    }
    /**
     * Metoda getNumer():
     * @return Zwraca wartość typu karty w liczbie całkowitej
     */
    public int getNumer(){
        return typ.getValue();
    }

    /**
     * Sprawdza indentyczność dwóch obiektów.
     * @param o Przyjmuje drugi obiekt
     * @return Zwraca true jesli obiekty są indentyczne, false jesli nie są.
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Karta card = (Karta) o;
        return kolor == card.kolor && typ == card.typ;
    }

    /**
     *
     * @return Zwraca hash obiektu.
     */
    public int hashCode(){
        return Objects.hash(kolor, typ);
    }

    /**
     * Metoda wyswietlKarte() wyswietla karte w formacie 'typ kolor, '
     */
    public void wyswietlKarte(){
        System.out.print(typ + " " + kolor + ", ");
    }
}
