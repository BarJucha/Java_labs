package org.example;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.Scanner;

public class SocketClientExample2 {

    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException{
        //get the localhost IP address, if server is running on some other IP, you need to use that
        InetAddress host = InetAddress.getLocalHost();
        Socket socket = new Socket(host.getHostName(), 9876);
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        Random random = new Random();
        int countI = 0;
        while (true){
            Thread.sleep(random.nextInt(5000)+5000);
            oos.writeObject("Numer wiadomości: " + countI++);
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            String message = (String) ois.readObject();
            System.out.println("Message: " + message);
        }
    }
}