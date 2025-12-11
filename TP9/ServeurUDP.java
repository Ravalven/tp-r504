import java.io.*;
import java.net.*;

public class ServeurUDP 
{
    public static void main(String[] args) 
    {
        try 
        {
            DatagramSocket sock = new DatagramSocket(1234);
            while (true) 
            {
                System.out.println("- Waiting for data");
                DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
                sock.receive(packet);
                String str = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received data: " + str);

                String rep = "Message : " + str;
                byte[] data = rep.getBytes();
                DatagramPacket response = new DatagramPacket(data, data.length, packet.getAddress(), packet.getPort());

                sock.send(response);
                System.out.println("Reponse envoyee au client");
            }
        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
