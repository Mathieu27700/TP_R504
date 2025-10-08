import java.io.*;
import java.net.*;

public class ServeurUDP2 {
    public static void main(String[] args) {
        try {
            DatagramSocket sock = new DatagramSocket(1235);

            while (true) {
                System.out.println("- Waiting data...");

                byte[] buffer = new byte[1024];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                sock.receive(packet);

                String str = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Message reçu : " + str);

                InetAddress clientAddr = packet.getAddress();
                int clientPort = packet.getPort();
                DatagramPacket response = new DatagramPacket(
                    str.getBytes(), str.getBytes().length, clientAddr, clientPort
                );
                sock.send(response);
                System.out.println("Message renvoyé au client.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

