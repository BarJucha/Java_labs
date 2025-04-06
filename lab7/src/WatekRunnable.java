public class WatekRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Komunikat z wątku potomnego");
        try {
            Thread.sleep(2000); // Symulacja działania wątku
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Wątek potomny zakończony");
    }
    public static void main(String[] args) {
        System.out.println("Komunikat z głównego wątku");

        Thread thread = new Thread(new WatekRunnable());
        thread.start();

        try {
            thread.join(); // Czekaj, aż wątek potomny zakończy działanie
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Główny wątek zakończony");
    }
}
