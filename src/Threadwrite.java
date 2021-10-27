import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
public class Threadwrite extends Thread {
	Socket s;
	PrintWriter pw;
	public Threadwrite(Socket socket) {
		s=socket;
		try {
			pw=new PrintWriter(s.getOutputStream());
		}catch(IOException e) {
			e.printStackTrace();
			
		}
	}
	public void run() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			String str= sc.nextLine();
			pw.print(str);
			pw.flush();
		}
	}


}
