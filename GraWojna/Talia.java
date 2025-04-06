import java.util.ArrayList;
import java.util.Collections;

/**
 * Klasa talia ma obsługiwać karty w talii.
 */
public class Talia {
    /**
     * Pole karty jest listą kart, które są w talii.
     */
    ArrayList<Karta> karty;
    public Talia(ArrayList<Karta> karty) {
        this.karty = karty;
    }

    /**
     * Metoda utworzPelnaTalie() tworzy nowa talie zawierajaca wszystkie rodzaje kart, kazda po jednej sztuce
     * @return Zwraca nową Talie
     */
    public static Talia utworzPelnaTalie() {
        ArrayList<Karta> karty = new ArrayList<>();
        for (Kolor kolor : Kolor.values()) {
            for (Typ typ : Typ.values()) {
                Karta karta = new Karta(kolor, typ);
                karty.add(karta);
            }
        }
        return new Talia(karty);
    }

    /**
     * Metoda potasuj() tasuje (miesza) kolejność kart w talii.
     */
    public void potasuj() {
        Collections.shuffle(karty);
    }

    /**
     * Metoda pociągnijKarte ma za zadanie pociągnięcie pierwszej karty w talii, usunięcie i zwrócenie jej
     * @return Zwraca pierwszą kartę w talii.
     * @throws BrakKartException Jesli nie ma już kart w talii
     */
    public Karta pociagnijKarte() throws BrakKartException {
        if (karty.isEmpty()) {
            throw new BrakKartException("Brak kart w talii.");
        }
        return karty.remove(0);
    }

    /**
     *
     * @return Zwraca liste kart w talii.
     */
    public ArrayList<Karta> getKarty(){
        return karty;
    }

    /**
     * Metoda wyswietlTalie() wyswietla kazda karte w talii.
     */
    public void wyswietlTalie(){
        for(Karta karta : karty){
            karta.wyswietlKarte();
        }
    }

    /**
     * Metoda isEmpty() służy do sprawdzenia czy w talii są jakieś karty
     * @return true jesli lista kart w talii jest pusta, false jesli nie
     */
    public boolean isEmpty(){
        return karty.isEmpty();
    }
}
