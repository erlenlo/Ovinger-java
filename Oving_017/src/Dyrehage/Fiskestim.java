
package Dyrehage;

/**
 *
 * @author erlend.lokken
 */
public class Fiskestim extends Dyregruppe {
    private final double gjennomsnittligLengde;
    private final boolean kanDeleAkvarium;

    public Fiskestim(double gjennomsnittligLengde, boolean kanDeleAkvarium, String gruppeNavn, int antIndivider, String norskNavn, String latNavn, String latFamilie, int ankommetDato, String adresse) {
        super(gruppeNavn, antIndivider, norskNavn, latNavn, latFamilie, ankommetDato, adresse);
        this.gjennomsnittligLengde = gjennomsnittligLengde;
        this.kanDeleAkvarium = kanDeleAkvarium;
    }

    public double getGjennomsnittligLengde() {
        return gjennomsnittligLengde;
    }

    public boolean isKanDeleAkvarium() {
        return kanDeleAkvarium;
    }
    
    @Override
    public String toString() {
        return "Snittlengde: " + gjennomsnittligLengde + "\nDele: " + kanDeleAkvarium;
    }
}
