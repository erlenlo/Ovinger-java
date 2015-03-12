
package oving_012;

import java.util.Date;

/**
 *
 * @author erlend.lokken
 */
public class BasicMedlem extends BonusMedlem {
    //private static final int poeng = 5000;

    public BasicMedlem(int medlNr, int poeng, Personalia pers, Dato innmeldtDato) {
        super(medlNr, poeng, pers, innmeldtDato);
    }
    
    @Override
    public boolean registrerPoeng(int antPoeng) {
        if(antPoeng < 0) {
            return false;
        } else {
            poeng += antPoeng;
            return true;
        }
    }

    
    
}
