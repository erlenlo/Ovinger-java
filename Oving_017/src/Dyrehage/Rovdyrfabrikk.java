package Dyrehage;

/**
 *
 * @author erlend.lokken
 */

import java.util.ArrayList;

public class Rovdyrfabrikk  {
    private ArrayList<SkandinaviskeRovdyr> rovdyr;
    private int antDyr;
    
    public Rovdyrfabrikk() {
        this.rovdyr = new ArrayList<>();
    }
    
    public SkandinaviskeRovdyr nyBinne(String navn, String fDato, int ankommetDato, String adresse, int antKull) {
        if(navn == null || fDato.equals("") || ankommetDato < 0 || adresse == null) {
            return null; // Feil input
        }
        Individ i = new Hunnindivid(navn, fDato, "Hunnkjønn", true, "Bjørn", "Ursus arctos", "Ursidae", ankommetDato, adresse, antKull);
        rovdyr.add(i);
        antDyr++;
        return i;
        
    }
    public SkandinaviskeRovdyr nyHannbjorn(String navn, String fDato, int ankommetDato, String adresse, int antKull) {
        if(navn == null || fDato.equals("") || ankommetDato < 0 || adresse == null) {
            return null; // Feil input
        }
        Individ i = new Hannindivid(navn, fDato, "Hannkjønn", true, "Bjørn", "Ursus arctos", "Ursidae", ankommetDato, adresse, antKull);
        rovdyr.add(i);
        antDyr++;
        return i;
        
    }
    public SkandinaviskeRovdyr nyUlvetispe(String navn, String fDato, int ankommetDato, String adresse, int antKull) {
        if(navn == null || fDato.equals("") || ankommetDato < 0 || adresse == null) {
            return null; // Feil input
        }
        Individ i = new Hunnindivid(navn, fDato, "Hunnkjønn", true, "Ulv", "Canis lupus", "Canidae", ankommetDato, adresse, antKull);
        rovdyr.add(i);
        antDyr++;
        return i;
        
    }
    public SkandinaviskeRovdyr nyUlvehann(String navn, String fDato, int ankommetDato, String adresse, int antKull) {
        if(navn == null || fDato.equals("") || ankommetDato < 0 || adresse == null) {
            return null; // Feil input
        }
        Individ i = new Hannindivid(navn, fDato, "Hankjønn", true, "Ulv", "Canis lupus", "Canidae", ankommetDato, adresse, antKull);
        rovdyr.add(i);
        antDyr++;
        return i;
        
    }
}
