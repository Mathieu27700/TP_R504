import java.io.*;
import java.net.*;

public class ClientUDP {
    public static void main(String[] args) {
        try {
            String s = "Hello World";
            byte[] data = s.getBytes();

            InetAddress addr = InetAddress.getLocalHost();
            System.out.println("Adresse = " + addr.getHostName());

            DatagramPacket packet = new DatagramPacket(data, data.length, addr, 1234);

            DatagramSocket sock = new DatagramSocket();
            sock.send(packet);

            sock.close();
            System.out.println("Message envoyé !");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

