import java.net.*;
import java.io.*;

public class Clienthttp {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java Clienthttp <host> [port]");
            return;
        }

        String host = args[0];
        int port = (args.length >= 2) ? Integer.parseInt(args[1]) : 80;

        try {
            Socket socket = new Socket(host, port);

            OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());
            InputStreamReader isw = new InputStreamReader(socket.getInputStream());

            BufferedWriter bufOut = new BufferedWriter(osw);
            BufferedReader bufIn = new BufferedReader(isw);

            String request = "GET / HTTP/1.0\r\nHost: " + host + "\r\n\r\n";
            bufOut.write(request);
            bufOut.flush();

            String line = bufIn.readLine();
            while (line != null) {
                System.out.println(line);
                line = bufIn.readLine();
            }

            bufIn.close();
            bufOut.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
