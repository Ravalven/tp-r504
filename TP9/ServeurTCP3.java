import java.io.*;
import java.net.*;

public class ServeurTCP3 {
    public static void main(String[] args) {
        try (ServerSocket socketserver = new ServerSocket(2016)) {
            System.out.println("Serveur en attente...");
            while (true) {
                try (Socket socket = socketserver.accept();
                     DataInputStream dIn = new DataInputStream(socket.getInputStream())) {
                     
                    System.out.println("Connection d'un client");
                    String message = dIn.readUTF();
                    System.out.println("Message reçu : " + message);
                    String rev = new StringBuilder(message).reverse().toString();
                    System.out.println("Message inversé : " + rev);

                    DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());
                    dOut.writeUTF(rev);
    
                } catch (EOFException eof) {
                    System.out.println("Client déconnecté prématurément");
                } catch (IOException ioe) {
                    System.out.println("Erreur lors de la communication avec le client");
                    ioe.printStackTrace();
                }
            }
        } catch (IOException e) {
            System.out.println("Erreur du serveur");
            e.printStackTrace();
        }
    }
}
