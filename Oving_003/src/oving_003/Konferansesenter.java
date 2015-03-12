
package oving_003;

/**
 *
 * @author erlend.lokken
 */

import java.util.*;

public class Konferansesenter {
    private ArrayList<Rom> rommene = new ArrayList<Rom>();
    private final String navn;
    private int antRom;
    
    public Konferansesenter(String navn) {
        this.navn = navn;
    }
    
    public String getNavn() {
        return navn;
    }
    
    public boolean reserverRom(Reservasjon reservasjon, int romNummer, int antPersoner) {
        for(Rom r: rommene) {
            if(r.getRomNummer() == romNummer && r.getStørrelse() >= antPersoner) {
                return r.reserverRom(reservasjon);
            }
        }
        return false;
    }
    
    public boolean registrerRom(int romNummer, int størrelse) { // størreles = antall personer det er plass til
        //Ikke tillatt hvis rom er registert fra før
        for(Rom r: rommene) {
            if(r.getRomNummer() == romNummer) {
                return false; // Rom er registrert fra før.
            }
        }
        rommene.add(new Rom(romNummer, størrelse));
        antRom++;
        return true;
    }
    
    public int finnAntallRom() {
        return rommene.size();
    }
    
    public Rom finnBestemtRomGittIndeks(int indeks) {
        return rommene.get(indeks);
    }
    
    public Rom finnBestemtRomGittNummer(int romNummer) {
        for(Rom r: rommene) {
            if(r.getRomNummer() == romNummer) {
                return r;
            }
        }
        return null; // Rom ikke funnet
    }
    public String listInfoGittNummer(int romNummer) {
        String svar = "";
        for(Rom r: rommene) {
            if(r.getRomNummer() == romNummer) {
                svar += r.toString();
            }
        }
        return svar;
    }
    
    public String toString() {
        String svar = navn + "\nAntall rom: " + finnAntallRom();
        for(Rom r: rommene) {
            svar += "\n" + r.toString();
        }
        return svar;
    }
    
    
    
}
