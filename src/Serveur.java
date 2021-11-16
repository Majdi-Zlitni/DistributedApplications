import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Serveur {
	public static void main(String[] args) {
		try {
			DatagramSocket ds = new DatagramSocket();
			DatagramSocket sr = new DatagramSocket(2021);
			while (true) {
				byte[] buffer = new byte[2];
				DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
				sr.receive(dp);
				String S = new String(buffer);
				System.out.println("entier reçu :" + S);
				int n = Integer.parseInt(S);
				String be;
				int f = 1;
				if (n > 0) {
					for (int i = 1; i <= n; i++) {
						f = f * i;
					}
					be = Integer.toString(f);
					System.out.println("résulat :" + f);
					int l = be.length();
					byte[] b = new byte[l];
					b = be.getBytes();
					DatagramPacket pe = new DatagramPacket(b, b.length, InetAddress.getLocalHost(), 2020);
					ds.send(pe);
					ds.close();
					sr.close();
					break;
				} else {
					be = "Veuillez entrer un nombre positif ! ";
					int l = be.length();
					byte[] b = new byte[l];
					b = be.getBytes();
					DatagramPacket pe = new DatagramPacket(b, b.length, InetAddress.getLocalHost(), 2020);
					ds.send(pe);
				}

			}

		} catch (IOException e) {
		}

	}
}
