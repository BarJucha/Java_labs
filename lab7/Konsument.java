import java.util.Random;

public class Konsument implements Runnable{
    private static int idCounter = 0;
    private int id;
    private Buffer buffer;

    public Konsument(Buffer buffer) {
        this.buffer = buffer;
        this.id = idCounter++;
    }

    @Override
    public void run() {
        Random random = new Random();

        while (true) {
            try {
                Thread.sleep(random.nextInt(1000));
                buffer.consume(id);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
