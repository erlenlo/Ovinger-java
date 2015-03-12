

package oving_012;

import java.util.Date;

/**
 *
 * @author erlend.lokken
 */
public class SoelvMedlem extends BonusMedlem {

    public SoelvMedlem(int medlNr, int poeng, Personalia pers, Dato innmeldtDato) {
        super(medlNr, poeng, pers, innmeldtDato);
    }
    
    @Override
    public boolean registrerPoeng(int antPoeng) {
        if(antPoeng < 0) {
            return false;
        } else {
            poeng += (antPoeng * 1.2);
            return true;
        }
    }    
    
}
