package org.example;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class OISClientThread implements Runnable{
    private Socket socket;

    public OISClientThread(Socket s){socket = s;}
    @Override
    public void run() {
        try {
            while (true){
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                String message = (String) ois.readObject();
                System.out.println("Wiadomość od serwera: " + message);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.getStackTrace();
        }
    }
}
