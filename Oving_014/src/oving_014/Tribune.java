
package oving_014;

/**
 *
 * @author erlend.lokken
 */
import java.io.Serializable;
import java.util.Arrays;

public class Tribune implements Comparable<Tribune>, Serializable {
    private String tribunenavn;
    private int kapasitet;
    private int pris;
    
    public Tribune(String tribunenavn, int kapasitet, int pris) {
        this.tribunenavn = tribunenavn;
        this.kapasitet = kapasitet;
        this.pris = pris;        
    }
    
    public Tribune(Tribune t) {
        this.tribunenavn = t.tribunenavn;
        this.kapasitet = t.kapasitet;
        this.pris = t.pris;
    }
    
    public String getTribunenavn() {
        return tribunenavn;
    }

    public int getKapasitet() {
        return kapasitet;
    }

    public int getPris() {
        return pris;
    }
    
    public String[][] getTilskuer() {
        return null;
    }
    
    public int finnAntallSolgteBiletter() {
        return 0; // Defineres i subklassene
    }
    
    
    public int finnInntekt() {
        return 0; // Defineres i subklassene
    }
    
    public Billett[] kjopBiletter(int antBiletter) {
        return null; // Defineres i subklassene
    }
    
    public Billett[] kjopBiletter(String[] navn) {
        return null; // Defineres i subklassene
    }    
    
    @Override
    public int compareTo(Tribune tribune) {
        if(this.finnInntekt() > tribune.finnInntekt()) {
            return 1;
        }
        if(this.finnInntekt() == tribune.finnInntekt()) {
            return 0;
        } else {
            return -1;
        }
    }          
    
    public String toString() {
        return "Tribunenavn: " + getTribunenavn()
                + "\nKapasitet: " + getKapasitet()
                + "\nAntall solgte: " + finnAntallSolgteBiletter()
                + "\nInntekt: " + finnInntekt();
    }    
    
}
