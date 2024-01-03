public class Osoba {
    private String nazwisko;
    private int wiek;
    public Osoba(String n, int w){
        nazwisko = n;
        wiek = w;
    }
    public int getWiek(){return wiek;}
    public String getNazwisko(){return nazwisko;}
}
