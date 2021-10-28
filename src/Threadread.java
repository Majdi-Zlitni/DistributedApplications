import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
public class Threadread extends Thread {
Socket s;
BufferedReader br;// reading text from a character input stream
public Threadread(Socket socket) {
	s=socket;
	try {
		br=new BufferedReader(new InputStreamReader(s.getInputStream()));//fi el variable mtaa el buffer reader bch nhoto ely bch na9rouh mel socket
		
	}catch(IOException e) {
		e.printStackTrace();
	}
}
public void run() {
	try {
		while(true) {
			String str=br.readLine();
			System.out.println("Le client a dit: "+str);
		}
	}catch(IOException e) {
		e.printStackTrace();
	}
}
}
