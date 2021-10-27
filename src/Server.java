import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket s = new ServerSocket(2025);
			while(true) {
		
					Socket ss= s.accept();
					Threadread r= new Threadread(ss);
					Threadwrite w= new Threadwrite(ss);
					r.start();
					w.start();
				
			}
		}catch (IOException e) {
			e.printStackTrace();
		}

	}

}
