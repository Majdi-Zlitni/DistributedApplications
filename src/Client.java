import java.io.*;
import java.net.*;
import java.util.*;
public class Client {
    public static void main(String[] args) {
        try {
        	   
            try {
                Socket s=new Socket(InetAddress.getLocalHost(),3000);                  
                
                    ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
                    Scanner sc=new Scanner (System.in);
                    System.out.println("donner la marque");
                    String m=sc.nextLine();
                    System.out.println("donner le prix de vente");
                    float pa=sc.nextFloat();
                    System.out.println("donner le kilométrage");
                    int km=sc.nextInt();
                    Voiture v=new Voiture (m,pa,km);
                    oos.writeObject(v);
                    oos.flush();
   
                    ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
                    Voiture v1=(Voiture)ois.readObject();
                    System.out.println("Le prix de vente "+v1.getPrixVente());
                    s.close();
            } catch (ClassNotFoundException ex) {
              
             }
         
                 // TODO code application logic here
                 } catch (IOException ex) {
                 	System.out.println(ex.getStackTrace());
     }
 }
 
}

