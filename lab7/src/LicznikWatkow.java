class LicznikWatkow {
    private int licznik;

    public LicznikWatkow() {
        this.licznik = 0;
    }

    public int getLicznik() {
        return licznik;
    }

    public void zwieksz() {
        licznik += 1;
    }

    public void zmniejsz() {
        licznik -= 1;
    }
}
