package oving_012;

/**
 *
 * @author erlend.lokken
 */
import java.util.*;

public class Medlemsarkiv {

    private ArrayList<BonusMedlem> medlemmer = new ArrayList<>();
    private int antMedlemmer = 0;

    public Medlemsarkiv() {
    }

    // Leger en metode som registrer poeng for korrekt medlemskap
    public boolean registrerPoeng(int medlnr, int antPoeng) {
        for (BonusMedlem b : medlemmer) {
            if (b.getMedlNr() == medlnr) {
                return b.registrerPoeng(antPoeng);
            }
        }
        return false; // Medlemsnummer finnes ikke...
    }
    
    // Lager metode som finner poeng gitt medlemsnummer og passord
    public int finnPoeng(int medlnr, String passord) {
        int antPoeng = 0;
        for (BonusMedlem b : medlemmer) {
            if (b.getMedlNr() == medlnr && b.okPassord(passord)) {
                antPoeng = b.getPoeng();
                return antPoeng;
            }
        }
        return -1;
    }

    
    
    //Metode som registrerer et nytt medlem
    public int nyMedlem(Personalia pers, Dato innmeldt) {
        if(pers == null || innmeldt == null) {
            return -1;
        }
        int medlNr = finnLedigNr();
        while(medlNr == 0) {
            medlNr = finnLedigNr();
        }
        medlemmer.add(new BasicMedlem(medlNr, 0, pers, innmeldt));
        antMedlemmer++;
        return medlNr;
    }
    
    // Medode som returnerer et tilfeldig heltall
    // som ikke allerede er i bruk som medlemsnummer.    
    private int finnLedigNr() {
        Random r = new Random();        
        int nummer = r.nextInt(10000);
        for (BonusMedlem b : medlemmer) {
            if(nummer == b.getMedlNr()) {
                return 0;
            }
        }
        return nummer;
    }
    
    // Sjekker medlemmer og foretar eventuelle oppgraderinger.
    public void sjekkMedlemmer(Dato dato) {
        int soelv = 25000;
        int gull = 75000;
        
        for(BonusMedlem b: medlemmer) {
            if(b instanceof BasicMedlem && b.finnKvalPoeng(dato) >= soelv && b.finnKvalPoeng(dato) < gull) {
                int indeks = medlemmer.indexOf(b);
                b = new SoelvMedlem(b.getMedlNr(), b.finnKvalPoeng(dato), b.getPers(), b.getInnmeldtDato());
                medlemmer.set(indeks, b);
            }
            if(b instanceof BasicMedlem && b.finnKvalPoeng(dato) >= gull) {
                int indeks = medlemmer.indexOf(b);
                b = new GullMedlem(b.getMedlNr(), b.finnKvalPoeng(dato), b.getPers(), b.getInnmeldtDato());
                medlemmer.set(indeks, b);
            }
            if(b instanceof SoelvMedlem && b.finnKvalPoeng(dato) >= gull) {
                int indeks = medlemmer.indexOf(b);
                b = new GullMedlem(b.getMedlNr(), b.finnKvalPoeng(dato), b.getPers(), b.getInnmeldtDato());
                medlemmer.set(indeks, b);
            }                        
        }
    }
    
    public BonusMedlem[] medlemsListe() {
        BonusMedlem[] svar = new BonusMedlem[medlemmer.size()];
        for(int i = 0; i < medlemmer.size(); i++) {
            svar[i] = medlemmer.get(i);
        }
        return svar;
    }
    
    
    public String[] info() {
        int teller = 0;
        String[] svar = new String[medlemmer.size()];        
        for(BonusMedlem b: medlemmer) {
            svar[teller] = "Medlemsnummer: " + b.getMedlNr() + "\nInnmeldt: " + b.getInnmeldtDato().toString() + "\n" + b.getClass() + "\nPoeng: " + b.getPoeng() + "\n";    
            teller++;
        }
        return svar;
    }
    
}
