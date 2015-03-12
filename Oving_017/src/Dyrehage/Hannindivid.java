package Dyrehage;

/**
 *
 * @author erlend.lokken
 */
public class Hannindivid extends Individ {

    private int antKull;

    public Hannindivid(String navn, String fDato, String kjonn, boolean farlig,
            String norskNavn, String latNavn, String latFamilie, int ankommet, String adresse, int antKull) {
        super(navn, fDato, kjonn, farlig, norskNavn, latNavn, latFamilie, ankommet, adresse);
        this.antKull = antKull;
    }

    @Override
    public int getAntKull() {
        return 0;
    }

    public void setAntKull(int antKull) {
        this.antKull = antKull;
    }

    @Override
    public void leggTilKull(int antall) {
    }

    @Override
    public void leggTilNyttKull() {
        this.antKull++;
    }

}
