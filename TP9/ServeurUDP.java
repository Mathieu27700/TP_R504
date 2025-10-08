import java.io.*;
import java.net.*;

public class ServeurUDP {
    public static void main(String[] args) {
        try {
            // Création d’une socket UDP sur le port 1234
            DatagramSocket sock = new DatagramSocket(1234);

            while (true) {
                System.out.println("- Waiting data...");

                // Préparation du buffer de réception
                DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);

                // Réception des données
                sock.receive(packet);

                // Conversion des bytes reçus en String
                String str = new String(packet.getData(), 0, packet.getLength());
                System.out.println("str = " + str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

