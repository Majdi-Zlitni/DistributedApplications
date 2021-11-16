import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			DatagramSocket ds = new DatagramSocket();
			DatagramSocket sr = new DatagramSocket(2020);
			while (true) {
				byte[] buffer = new byte[100];
				DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
				int n = sc.nextInt();
				String be = Integer.toString(n);
				int l = be.length();
				byte[] b = new byte[l];
				b = be.getBytes();
				DatagramPacket pe = new DatagramPacket(b, b.length, InetAddress.getLocalHost(), 2021);
				ds.send(pe);
				sr.receive(dp);
				String S = new String(buffer);

				if (!S.contains("Veuillez entrer un nombre positif ! ")) {
					System.out.println(n + "!= " + S);
					ds.close();
					sr.close();
					break;
				}
				System.out.println(S);
			}
		} catch (IOException e) {
		}
	}
}
