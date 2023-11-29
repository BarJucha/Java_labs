import java.util.Random;

public class Producent implements Runnable{
    private int count = 0;
    private static int idCounter = 0;
    private int id;
    private Buffer buffer;

    public Producent(Buffer buffer) {
        this.buffer = buffer;
        this.id = idCounter++;
    }

    @Override
    public void run() {
        Random random = new Random();

        while (true) {
            try {
                Thread.sleep(random.nextInt(1000));
                String message = "Producent " + id + ", " + ++count;
                buffer.produce(message, count);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
