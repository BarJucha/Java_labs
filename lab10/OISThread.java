import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class OISThread implements Runnable{
    private Socket socket;

    public OISThread(Socket s){socket = s;}
    @Override
    public void run() {
        try {
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            while (true){
                String message = (String) ois.readObject();
                System.out.println("Message Received: " + message + " klienta numer " + count);
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
