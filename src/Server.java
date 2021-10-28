 import java.io.*;
import java.net.*;
import java.util.* ;

public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket ss= new ServerSocket(2022);
			while(true) {
				Socket s = ss.accept();
				try {
					ObjectInputStream ois= new ObjectInputStream(s.getInputStream());
					Voiture v=(Voiture)ois.readObject();
					System.out.println(v.getMarque());
					v.setPrixVente((float)(v.getPrixAchat()-v.getKm()*0.15));
					ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
					oos.writeObject(v);
					 oos.flush();
					 s.close();

				}catch (ClassNotFoundException ex) {
                    
                }

			}
			
		} catch (IOException ex) {
            System.out.println(ex.getStackTrace());
        }

	}
}
