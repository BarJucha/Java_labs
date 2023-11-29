import java.util.Random;

public class Przyklad {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        int numProducers = 3;
        int numConsumers = 2;

        // Start producers
        for (int i = 0; i < numProducers; i++) {
            new Thread(new Producent(buffer)).start();
        }

        // Start consumers
        for (int i = 0; i < numConsumers; i++) {
            new Thread(new Konsument(buffer)).start();
        }

        // Run the program for a random period of time
        try {
            Thread.sleep(new Random().nextInt(5000) + 5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Stop all threads
        System.exit(0);
    }
}
