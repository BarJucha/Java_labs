import java.util.Objects;

public class Karta {
    private Kolor kolor;
    private Typ typ;
    public Karta(Kolor kolor, Typ typ){
        this.typ = typ;
        this.kolor = kolor;
    }
    public Kolor getKolor(){
        return kolor;
    }
    public Typ getTyp(){
        return typ;
    }
    public int getNumer(){
        return typ.getValue();
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Karta card = (Karta) o;
        return kolor == card.kolor && typ == card.typ;
    }
    public int hashCode(){
        return Objects.hash(kolor, typ);
    }
    public void wyswietlKarte(){
        System.out.print(typ + " " + kolor + ", ");
    }
}
