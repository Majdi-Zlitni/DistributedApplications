import java.net.DatagramPacket;
import java.net.DatagramSocket;
public class ThreadRead extends Thread {
	int p;
public ThreadRead(int p) {
	this.p=p;
}
public void run() {
	try {
		DatagramSocket ds=new DatagramSocket(p);
		while(true) {
		
			byte[] b=new byte[100];
			DatagramPacket dp=new DatagramPacket(b,b.length);
			ds.receive(dp);
			String s=new String(b);
			System.out.println(s);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
}