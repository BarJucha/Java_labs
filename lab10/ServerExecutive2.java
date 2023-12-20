import javax.imageio.IIOException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Random;

public class ServerExecutive2 implements Runnable{
    private int count = 0;
    private Socket socket;
    public ServerExecutive2(Socket s,int num){
        socket = s;
        count = num;
    }
    @Override
    public void run() {
        while (true){
            try {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                while(true) {
                    String message = (String) ois.readObject();
                    System.out.println("Message Received: " + message + " klienta numer " + count);
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(message + " klienta " + count);
                }
            }
            catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}