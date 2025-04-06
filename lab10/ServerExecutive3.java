import javax.imageio.IIOException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Random;

public class ServerExecutive3 implements Runnable{
    private int count = 0;
    private Socket socket;
    public ServerExecutive3(Socket s,int num){
        socket = s;
        count = num;
    }
    @Override
    public void run() {
        while (true){
            try {
                Random random = new Random();
                Thread oisThread = new Thread(new OISThread(socket, count));
                oisThread.start();
                //ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                while(true) {
                    //String message = (String) ois.readObject();
                    //System.out.println("Message Received: " + message + " klienta numer " + count);
                    Thread.sleep(random.nextInt(5000) + 5000);
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject("Wysłano wiadomość do klienta " + count);
                    System.out.println("Wysłano wiadomość do klienta " + count);
                }
            }
            catch (IOException | InterruptedException e ) {
                throw new RuntimeException(e);
            }
        }
    }
}