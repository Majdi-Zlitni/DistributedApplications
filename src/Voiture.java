import java.io.Serializable;

public class Voiture implements Serializable{
    private String Marque;
    private float PrixAchat;
    private float PrixVente;
    private int km;

    public Voiture(String Marque, float PrixAchat, int km) {
        this.Marque = Marque;
        this.PrixAchat = PrixAchat;
        this.km = km;
    }
    public String getMarque() {
        return Marque;
    }

    public void setMarque(String Marque) {
        this.Marque = Marque;
    }

    public float getPrixAchat() {
        return PrixAchat;
    }

    public void setPrixAchat(float PrixAchat) {
        this.PrixAchat = PrixAchat;
    }

    public float getPrixVente() {
        return PrixVente;
    }

    public void setPrixVente(float PrixVente) {
        this.PrixVente = PrixVente;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }
    
    
    
}


