
package oving_014;

/**
 *
 * @author erlend.lokken
 */

public class Sitte extends Tribune {
    private int[] antOpptatte;
     
    public Sitte(String tribunenavn, int kapasitet, int pris, int antRader) {
        super(tribunenavn, kapasitet, pris);
        this.antOpptatte = new int[antRader]; // Antall rader
    }
    
    public int getSeterPrRad() {
        return getKapasitet() / antOpptatte.length;
        
    }
    @Override
    public int finnAntallSolgteBiletter() {   
        int svar = 0;
        for(int i = 0; i < antOpptatte.length; i++) {
            svar += antOpptatte[i];
        }
        return svar;
    }
    
    @Override
    public int finnInntekt() {
        return finnAntallSolgteBiletter() * getPris();                
    }
    
    public int finnLedigRad(int antBiletter) {
        for(int i = 0; i < antOpptatte.length; i++) {
            if((getSeterPrRad() - antOpptatte[i]) >= antBiletter) {
                return i;
            }
        }
        return -1;
    }
    
    @Override
    public Billett[] kjopBiletter(int antBiletter) {
        if(antBiletter > getSeterPrRad() || finnLedigRad(antBiletter) < 0) {
            return null;
        }
        //Finner ledig rad og plass bestemmes
        int rad = finnLedigRad(antBiletter);
        int plass = antOpptatte[rad] + 1;        
        antOpptatte[rad] = antOpptatte[rad] + antBiletter;
        
        //Registrerer bilettobjekter på angitt rad og plass.
        Billett[] svar = new Billett[antBiletter];
        for(int i = 0; i < svar.length; i++) {
            svar[i] = new SittePlassBillett(getTribunenavn(), getPris(), (rad + 1), plass) {};     
            plass++;
        }
        return svar;
    }
    
    @Override
    public Billett[] kjopBiletter(String[] navn) {
        if(navn.length > getSeterPrRad() || finnLedigRad(navn.length) < 0) {
            return null;
        }

        //Finner ledig rad og plass bestemmes
        int rad = finnLedigRad(navn.length);
        int plass = antOpptatte[rad] + 1;        
        antOpptatte[rad] = antOpptatte[rad] + navn.length;
        
        //Registrerer bilettobjekter på angitt rad og plass.
        Billett[] svar = new Billett[navn.length];
        for(int i = 0; i < svar.length; i++) {
            svar[i] = new SittePlassBillett(getTribunenavn(), getPris(), (rad + 1), plass) {};
            plass++;
        }
        return svar;
                
    }
        
}
