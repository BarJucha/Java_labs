import java.util.Random;
import java.util.ArrayList;
public class Buffer {
    private ArrayList<String> data = new ArrayList<>();

    public synchronized void produce(String message, int count){
        data.add(message);
        System.out.println("Wyprodukowano " + message + ", rozmiar obiektu " + data.size());
    }

    public synchronized String consume(int consumerID){
        if (data.isEmpty()){return null;}
        String message = data.remove(0);
        System.out.println("Pobrano " + message + " przez konsumenta " + consumerID + ", rozmiar obiektu "+data.size());
        return message;
    }
}
