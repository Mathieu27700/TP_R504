import java.io.*;
import java.net.*;

public class ServeurTCP3 {
    public static void main(String[] args) {
        try {
            ServerSocket socketserver = new ServerSocket(2016);
            System.out.println("Serveur en attente de connexion...");

            while (true) {
                Socket socket = socketserver.accept(); 
                System.out.println("Connexion d'un client");

                DataInputStream dIn = new DataInputStream(socket.getInputStream());
                String msg = dIn.readUTF();
                System.out.println("Message reçu: " + msg);

                String rev = new StringBuilder(msg).reverse().toString();

                DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());
                dOut.writeUTF(rev);

                System.out.println("Message inversé envoyé: " + rev);

                socket.close();
            }

        } catch (Exception e) {
            System.out.println("ERREUR : " + e.getMessage());
        }
    }
}

