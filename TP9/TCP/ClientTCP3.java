import java.io.*;
import java.net.*;

public class ClientTCP3 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 2016);
            DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());
            DataInputStream dIn = new DataInputStream(socket.getInputStream());

            String msg = "Bonjour Serveur";
            System.out.println("Message envoyé: " + msg);
            dOut.writeUTF(msg);

            String reponse = dIn.readUTF();
            System.out.println("Message reçu du serveur: " + reponse);

            socket.close();
        } catch (Exception e) {
            System.out.println("ERREUR : " + e.getMessage());
        }
    }
}

