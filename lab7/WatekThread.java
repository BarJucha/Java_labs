public class WatekThread extends Thread {

    @Override
    public void run() {
        System.out.println("Komunikat z wątku potomnego");
        try {
            Thread.sleep(2000); // Symulacja działania wątku
        } catch (InterruptedException e) {
            e.getMessage();
        }
        System.out.println("Wątek potomny zakończony");
    }

    public static void main(String[] args) {
        System.out.println("Komunikat z głównego wątku");

        WatekThread watek = new WatekThread();
        watek.start();

        try {
            watek.join(); // Czekaj, aż wątek potomny zakończy działanie
        } catch (InterruptedException e) {
            e.getMessage();
        }

        System.out.println("Główny wątek zakończony");
    }
}

