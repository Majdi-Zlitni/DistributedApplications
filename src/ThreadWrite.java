import java.util.Scanner;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class ThreadWrite extends Thread{
	int p;
public ThreadWrite(int p) {
	this.p=p;
}
public void run() {
	Scanner sc=new Scanner(System.in);
	
		try {
			DatagramSocket ds = new DatagramSocket();
			while(true) {
			System.out.println("Tappez votre msg!");
			String s=sc.nextLine();
			byte[] b= new byte[s.length()];
			b=s.getBytes();
			DatagramPacket dp = new DatagramPacket(b,b.length,InetAddress.getLocalHost(),p);
			ds.send(dp);
		
	}
		}catch(Exception e) {
			e.printStackTrace();
		}
	
}
}