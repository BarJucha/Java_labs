public enum Typ {
    DWA(2), TRZY(3), CZTERY(4), PIEC(5), SZESC(6), SIEDEM(7), OSIEM(8), DZIEWIEC(9), DZIESIEC(10), J(11), Q(12), K(13), A(14);

    protected int value;
    Typ(int i){
        this.value = i;
    }
    public int getValue(){return value;}
}
