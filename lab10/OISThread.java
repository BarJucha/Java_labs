import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class OISThread implements Runnable{
    private Socket socket;
    private int clientID;

    public OISThread(Socket s, int n){socket = s; clientID = n;}
    @Override
    public void run() {
        try {
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            while (true){
                String message = (String) ois.readObject();
                System.out.println("Message Received: " + message + " od klienta numer " + clientID);
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}