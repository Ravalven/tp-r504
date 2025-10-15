import java.io.*;
import java.net.*;

public class Clienthttp
{
	public static void main (String[] args ) throws Exception
	{
		Socket socket = new Socket( args[0], 80 );

		OutputStreamWriter osw = new OutputStreamWriter( socket.getOutputStream() );
		InputStreamReader isw = new InputStreamReader( socket.getInputStream() );
		
		BufferedWriter bufOut = new BufferedWriter(osw);
		BufferedReader bufIn = new BufferedReader(isw);


		String line = bufIn.readLine();
		while( line != null ){
			System.out.println(line);
			line = bufIn.readLine();
		}
		bufIn.close();
		bufOut.close();
		socket.close();
	}
}
