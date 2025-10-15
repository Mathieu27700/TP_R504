import java.io.*;
import java.net.*;

public class ClientHTTP {
    public static void main(String[] args) {
        try {
            if (args.length < 1) {
                System.out.println("Usage : java ClientHttp <nom_hote>");
                return;
            }

            String host = args[0];
            System.out.println("Connexion à " + host + " sur le port 80...");

            Socket socket = new Socket(host, 80);

            OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());
            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            BufferedWriter bufOut = new BufferedWriter(osw);
            BufferedReader bufIn = new BufferedReader(isr);

            String request = "GET / HTTP/1.0\r\nHost: " + host + "\r\n\r\n";
            bufOut.write(request, 0, request.length());
            bufOut.flush();

            String line = bufIn.readLine();
            while (line != null) {
                System.out.println(line);
                line = bufIn.readLine();
            }

            bufIn.close();
            bufOut.close();
            socket.close();

        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}

