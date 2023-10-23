import java.util.ArrayList;

public class Gracz {
    public Talia kartyGracza;
    public Gracz(){
        this.kartyGracza = new Talia(new ArrayList<>());
    }
    public void dodajKarte(ArrayList<Karta> karty){
        kartyGracza.karty.addAll(karty);
    }
    public void dodajKarte(Karta karta){
        kartyGracza.karty.add(karta);
    }
    public Karta dajKarte() throws BrakKartException {
        return kartyGracza.pociagnijKarte();
    }
}
