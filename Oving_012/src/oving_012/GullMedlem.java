
package oving_012;

import java.util.Date;

/**
 *
 * @author erlend.lokken
 */
public class GullMedlem extends BonusMedlem {

    public GullMedlem(int medlNr, int poeng, Personalia pers, Dato innmeldtDato) {
        super(medlNr, poeng, pers, innmeldtDato);
    }
    
    @Override
    public boolean registrerPoeng(int antPoeng) {
        if(antPoeng < 0) {
            return false;
        } else {
            poeng += (antPoeng * 1.5);
            return true;
        }
    }
            
}
