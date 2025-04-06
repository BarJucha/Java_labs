public class Osoba {
    private String nazwisko;
    private int wiek;
    public Osoba(String n, int w){
        nazwisko = n;
        wiek = w;
    }
    public int getWiek(){return wiek;}
    public String getNazwisko(){return nazwisko;}

    @Override
    public String toString() {
        return "Osoba {" +
                "nazwisko='" + nazwisko + '\'' +
                ", wiek=" + wiek +
                '}';
    }
}
