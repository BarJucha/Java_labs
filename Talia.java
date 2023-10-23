import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Talia {
    ArrayList<Karta> karty;
    public Talia(ArrayList<Karta> karty) {
        this.karty = karty;
    }
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
    public void potasuj() {
        Collections.shuffle(karty);
    }
    public Karta pociagnijKarte() throws BrakKartException {
        if (karty.isEmpty()) {
            throw new BrakKartException("Brak kart w talii.");
        }
        return karty.remove(0);
    }
    public ArrayList<Karta> getKarty(){
        return karty;
    }
    public void wyswietlTalie(){
        for(Karta karta : karty){
            karta.wyswietlKarte();
        }
    }
    public boolean isEmpty(){
        return karty.isEmpty();
    }
}
