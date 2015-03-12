
package oving_005;

/**
 *
 * @author erlend.lokken
 */
public class ValutaKalkulator {
    private final double kursSEK;
    
    
    public ValutaKalkulator() {
        this.kursSEK = 0.940753186;
    }

    public double getKursSEK() {
        return kursSEK;
    }

    public double fraNOKtilSEK(double belop) {
        return belop / kursSEK;
    }
    public double fraSEKtilNOK(double belop) {
        return belop * kursSEK;
    }
}
