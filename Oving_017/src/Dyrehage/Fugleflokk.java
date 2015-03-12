
package Dyrehage;

/**
 *
 * @author erlend.lokken
 */
public class Fugleflokk extends Dyregruppe {
    private final double gjennomsnittligVekt;
    private final boolean svommer;

    public Fugleflokk(double gjennomsnittligVekt, boolean svommer, String gruppeNavn, int antIndivider, String norskNavn, String latNavn, String latFamilie, int ankommetDato, String adresse) {
        super(gruppeNavn, antIndivider, norskNavn, latNavn, latFamilie, ankommetDato, adresse);
        this.gjennomsnittligVekt = gjennomsnittligVekt;
        this.svommer = svommer;
    }

    public double getGjennomsnittligVekt() {
        return gjennomsnittligVekt;
    }

    public boolean isSvommer() {
        return svommer;
    }
    @Override
    public String toString() {
        return "Snittvekt: " + gjennomsnittligVekt + "\nSvømmer: " + svommer;
    }
}
