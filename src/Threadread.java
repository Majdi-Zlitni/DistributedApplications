import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
public class Threadread extends Thread {
Socket s;
BufferedReader br;
public Threadread(Socket s) {
	this.s=s;
	try {
		br=new BufferedReader(new InputStreamReader(s.getInputStream()));
		
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
