import java.util.Random;

public class Zadaie2 {
    public static void main(String[] args){
        int n = 4;
        LicznikWatkow licznik = new LicznikWatkow();
        Thread[] threads = new Thread[n];
        System.out.println("Główny wątek uruchomiony");
        for (int i=0; i<n; i++){
            new Thread(new RandomWatek(i, licznik)).start();
        }
        synchronized (licznik){
            while (licznik.getLicznik() > 0){
                try {
                    licznik.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Główny wątek zakończony");
    }
}
