
package oving_003;

/**
 *
 * @author erlend.lokken
 */
import java.util.*;

public class Rom {
    private ArrayList<Reservasjon> reservasjon = new ArrayList<Reservasjon>();
    private int romNummer;
    private int størrelse;
    
    public Rom(int romNummer, int størrelse) {
        this.romNummer = romNummer;
        this.størrelse = størrelse;
        this.reservasjon = reservasjon;
    }
            
    public int getRomNummer() {
        return romNummer;
    }
    
    public int getStørrelse() {
        return størrelse;
    }

    public void setRomNummer(int romNummer) {
        this.romNummer = romNummer;
    }

    public void setStørrelse(int størrelse) {
        this.størrelse = størrelse;
    }
    public boolean reserverRom(Reservasjon reserver) {
        for(Reservasjon r: reservasjon) {
            if(r.overlapp(reserver.getFraTid(), reserver.getTilTid())) {
                return false;
            }
        }
        reservasjon.add(new Reservasjon(reserver));
        return true;
    }
        
    public String toString() {
        String svar = "Romnummer: " + romNummer + ", størrelse: " + størrelse + " personer.";
        for(Reservasjon r: reservasjon) {
            svar += "\n" + r.toString();
        }
        return svar;
    }
                
    
}
