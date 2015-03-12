package oving_014;

/**
 *
 * @author erlend.lokken
 */
public class Staa extends Tribune {

    private int antSolgteBiletter;

    public Staa(String tribunenavn, int kapasitet, int pris) {
        super(tribunenavn, kapasitet, pris);
    }


    @Override
    public int finnAntallSolgteBiletter() {
        return antSolgteBiletter;
    }

    @Override
    public int finnInntekt() {
        return antSolgteBiletter * getPris();
    }

    @Override
    public Billett[] kjopBiletter(int antBiletter) {
        if (antBiletter > getKapasitet()) {
            return null;
        }
        Billett[] svar = new Billett[antBiletter];
        for (int i = 0; i < antBiletter; i++) {
            svar[i] = new StaaPlassBillett(getTribunenavn(), getPris()) {
            };
        }
        antSolgteBiletter += svar.length;
        return svar;
    }

    @Override
    public Billett[] kjopBiletter(String[] navn) {
        if (navn.length > getKapasitet()) {
            return null;
        }
        Billett[] svar = new Billett[navn.length];
        for (int i = 0; i < svar.length; i++) {
            svar[i] = new StaaPlassBillett(getTribunenavn(), getPris()) {
            };
        }
        antSolgteBiletter += svar.length;
        return svar;

    }


}
