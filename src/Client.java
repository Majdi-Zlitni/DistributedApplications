import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
public class Client {
	public static void main(String[] args)
	{
		try {
			Socket s = new Socket(InetAddress.getLocalHost(),2022);
			Threadwrite w= new Threadwrite(s);
			Threadread r = new Threadread(s);
			w.start();
			r.start();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
