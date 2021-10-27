import java. io.*;
import java.net.*;
import java.util.Scanner;
public class Client {
		public static void main(String[] args) {
			final int port= 2022;
			try {
				Socket socket= new Socket(InetAddress.getLocalHost(),port);//etablir une cnx avec le serveur
				//pour l'envoi de msg :
				OutputStream out = socket.getOutputStream();
				PrintWriter ostream= new PrintWriter(out);
				while(true) {
					System.out.println("Majdi tappez votre msg");
					Scanner sc = new Scanner(System.in);
					String str=sc.nextLine();
					System.out.println("Majdi vous avez ecrit: "+str);
					ostream.println(str);
					ostream.flush();
					if(str.equals("fin")) {
						socket.close();
						System.out.println("Fin cnx");
						break;
					}
					//Reception de msg
					BufferedReader in= new BufferedReader(new InputStreamReader(socket.getInputStream()));
	                System.out.println("This msg was sent form the server and displayed in Client interface : " +in.readLine());
	            }
	        }catch(IOException e) {
				
			}
		}

}
