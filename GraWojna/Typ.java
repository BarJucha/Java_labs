/**
 * Typ wyliczyniowy Typ do przechowywania typów kart.
 */
public enum Typ {
    DWA(2), TRZY(3), CZTERY(4), PIEC(5), SZESC(6), SIEDEM(7), OSIEM(8), DZIEWIEC(9), DZIESIEC(10), J(11), Q(12), K(13), A(14);
    /**
     * Pole int value sluży do przechowywania wartości typu określonej w liczbie calkowitej.
     */
    protected int value;
    Typ(int i){
        this.value = i;
    }

    /**
     *
     * @return Zwraca value, czyli wartość liczbową typu.
     */
    public int getValue(){return value;}
}
