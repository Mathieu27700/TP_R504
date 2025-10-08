import java.io.*;
import java.net.*;

public class ClientUDP2 {
    public static void main(String[] args) {
        try {
            String s = "Hello World";
            byte[] data = s.getBytes();

            InetAddress addr = InetAddress.getLocalHost();
            System.out.println("Adresse = " + addr.getHostName());

            DatagramSocket sock = new DatagramSocket();

            DatagramPacket packet = new DatagramPacket(data, data.length, addr, 1235);
            sock.send(packet);
            System.out.println("Message envoyé au serveur : " + s);

            byte[] buffer = new byte[1024];
            DatagramPacket response = new DatagramPacket(buffer, buffer.length);

            sock.receive(response);
            String reply = new String(response.getData(), 0, response.getLength());
            System.out.println("Réponse reçue du serveur : " + reply);

            sock.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

