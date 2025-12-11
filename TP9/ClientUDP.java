import java.io.*;
import java.net.*;

public class ClientUDP 
{
    public static void main(String[] args) 
    {
        String s = "Test";
        InetAddress addr = null;
        DatagramPacket packet = null;
        DatagramSocket sock = null;

        try 
        {
            addr = InetAddress.getLocalHost();
            System.out.println("adresse=" + addr.getHostName());
        } 
        catch (Exception ex) 
        {
            System.out.println("Erreur : Unknown LocalHost");
            ex.printStackTrace();
        }

        byte[] data = s.getBytes();

        try 
        {
            packet = new DatagramPacket(data, data.length, addr, 1234);
        } 
        catch (Exception ex) 
        {
            System.out.println("Erreur : Problème avec le DatagramPacket");
            ex.printStackTrace();
        }

        try 
        {
            sock = new DatagramSocket();
            sock.send(packet);
            System.out.println("Message envoyé au serveur");
        } 
        catch (Exception ex) 
        {
            System.out.println("Erreur : Problème avec l'envoi du paquet");
            ex.printStackTrace();
        }

        try 
        {
            while (true) 
            {
                System.out.println("- Waiting for the server response");
                packet = new DatagramPacket(new byte[1024], 1024);
                sock.receive(packet);
                String str = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received response : " + str);
                break;
            }
        } 
        catch (Exception ex) {
            System.out.println("Erreur : Problème réception réponse serveur");
            ex.printStackTrace();
        } 
        sock.close();
    }
}
