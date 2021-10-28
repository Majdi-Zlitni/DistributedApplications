import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(2022);// is listening. serverside, which sends requests to clients side socket and waits for response from client.
			while(true) {
		
					Socket s= ss.accept();//sockets guarantee data arrives in the correct order
					Threadread r= new Threadread(s);
					Threadwrite w= new Threadwrite(s);
					r.start();
					w.start();
				
			}
		}catch (IOException e) {
			e.printStackTrace();
		}

	}

}
