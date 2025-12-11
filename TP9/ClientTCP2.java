// ClientTCP2.java
import java.io.*;
import java.net.*;

public class ClientTCP2 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Erreur : nombre d'arguments incorrect");
            return;
        }
        try {
            Socket socket = new Socket("localhost", 2016);
            DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());
            dOut.writeUTF( args[0] );
            System.out.println("Message sent to server.");
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
