import java.io.*;
import java.net.*;
import java.util.Scanner;
public class Serveur {
public static void main(String[] args) {
	final int port =2022;
	try {
		ServerSocket server=new ServerSocket(port);//hadherna ServerSocket bch naamlou enregistrement ll services yaati error 
												   //edha ma ynajemch yaamel communication maa el port
		System.out.println("Started");
		while(true) {//el server bch ya9bel barcha clients heka aaleh aamelna boucle for
			Socket socket= server.accept();
			System.out.println(socket.getPort()+" connecté");//bch ygolena ely el port kedha raw conected 
			InputStream in =socket.getInputStream();//bch nhoto el données ely jayin men aadn el client sous forme d'octet
			InputStreamReader reader = new InputStreamReader(in);//bch na9rohom bel charachter bel charachter
			BufferedReader istream= new BufferedReader(reader);//convertion en flux manipulant chaine de charactères
			while(true) {//boucle pour l'echange de plusieur msg avec meme client
				String line= istream.readLine();//lehna tssir el recupération de donnée envoyer par le client
				System.out.println("Majdi a dit: "+line);
				if(line.equals("fin")) {
					socket.close();
					break;
				}
				//fely fet el serveur bch yestana lin el client yebaathlou haja w yaamel aaliha manipulation
				//men octet ll character hata lin tsir el recuperation line par line
				//w tawa fi el ostra el jayin el serveur bch yaati el ordre ll client bch yekteb haja
				//maanetha fi kol partie thama input w output
				System.out.println("Now the server can send data to  client");
				Scanner sc= new Scanner(System.in);
				String str=sc.nextLine();//lecture ligne par ligne
				OutputStream out=socket.getOutputStream();//flux d'ecriture sortant en octets
				PrintWriter ostream=new PrintWriter(out);//manipulation des characteres
				ostream.println(str);//ecriture sur le flux sortant
				ostream.flush();
				
				
			}
					
		}
	}catch(IOException e) {
		
	}
}
}
