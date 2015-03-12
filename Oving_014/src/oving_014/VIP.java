package oving_014;

/**
 *
 * @author erlend.lokken
 */
public class VIP extends Tribune {

    private String[][] tilskuer;
    private int antRader;
    private int antPlasser;


    public VIP(String tribunenavn, int kapasitet, int pris, int antRader, int antPlasser) {
        super(tribunenavn, kapasitet, pris);
        this.antRader = antRader;
        this.antPlasser = antPlasser;
        this.tilskuer = new String[antRader][antPlasser];
    }
    public int getAntRader() {
        return antRader;
    }

    public int getAntPlasser() {
        return antPlasser;
    }

    @Override
    public String[][] getTilskuer() {
        return tilskuer;
    }
    
    @Override
    public int finnAntallSolgteBiletter() {
        int antSolgte = 0;
        for (int i = 0; i < antRader; i++) {
            for (int j = 0; j < antPlasser; j++) {
                if (tilskuer[i][j] != null) {
                    antSolgte++;
                }
            }
        }
        return antSolgte;
    }

    @Override
    public int finnInntekt() {
        return (finnAntallSolgteBiletter() * getPris());
    }

    @Override
    public Billett[] kjopBiletter(int antBiletter) {
        return null; // Ingen får billett uten å oppgi navn
    }

    @Override
    public Billett[] kjopBiletter(String[] navn) {
        if (navn.length > antPlasser && navn.length > antallLedig()) {
            return null;
        }
        Billett[] svar = new Billett[navn.length];
        
        int teller = 0;
        for (int i = 0; i < antRader; i++) {
            for (int j = 0; j < antPlasser; j++) {
                if (tilskuer[i][j] == null && teller < navn.length) {
                    tilskuer[i][j] = navn[teller];
                    svar[teller] = new SittePlassBillett(getTribunenavn(), getPris(), (i+1), (j + 1));            
                    teller++;
                }
            }
        }                
        return svar;
    }

    public int antallLedig() {
        return getKapasitet() - finnAntallSolgteBiletter();
    }
        
}
