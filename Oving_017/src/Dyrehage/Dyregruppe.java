
package Dyrehage;

/**
 *
 * @author erlend.lokken
 */
public class Dyregruppe extends Dyr{
    private final String gruppeNavn;
    private int antIndivider;

    public Dyregruppe(String gruppeNavn, int antIndivider, String norskNavn, String latNavn, String latFamilie, int ankommetDato, String adresse) {
        super(norskNavn, latNavn, latFamilie, ankommetDato, adresse);
        this.gruppeNavn = gruppeNavn;
        this.antIndivider = antIndivider;
    }


    public String getGruppeNavn() {
        return gruppeNavn;
    }

    public int getAntIndivider() {
        return antIndivider;
    }

    public void setAntIndivider(int antIndivider) {
        this.antIndivider = antIndivider;
    }

    @Override
    public String toString() {
        return "Gruppenavn: " + gruppeNavn + "\nAntall Individer=" + antIndivider;
    }

    
}
