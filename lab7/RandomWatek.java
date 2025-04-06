import java.util.Random;

public class RandomWatek implements Runnable{
    private int id;
    private final LicznikWatkow licznik;
    public RandomWatek(int i, LicznikWatkow licznik) {
        this.id = i;
        this.licznik = licznik;
    }

    @Override
    public void run() {
        synchronized (licznik){
            licznik.zwieksz();
        }
        Random random = new Random();
        int czas = random.nextInt(1000);
        System.out.println("Wątek "+id + " uruchomiony na " + czas + "ms");
        try {
            Thread.sleep(czas);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Wątek " + id + " zakończony");
        synchronized (licznik){
            licznik.zmniejsz();
            licznik.notify();
        }
    }
}
