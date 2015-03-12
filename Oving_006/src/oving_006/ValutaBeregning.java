
package oving_006;

/**
 *
 * @author erlend.lokken
 */


public class ValutaBeregning {
    private String valutaNavn;
    private double kursMotNOK;    
    
    public ValutaBeregning(String valutaNavn, double kursMotNOK) {
        this.valutaNavn = valutaNavn;
        this.kursMotNOK = kursMotNOK;
    }

    public String getValutaNavn() {
        return valutaNavn;
    }

    public double getKursMotNOK() {
        return kursMotNOK;
    }
    
    public double sumNOK(double belop) {
        return belop * kursMotNOK;
    }
    public double sumValuta(double belop) {
        return belop/kursMotNOK;
    }
    public String toString() {
        return valutaNavn;
    }
    
}
