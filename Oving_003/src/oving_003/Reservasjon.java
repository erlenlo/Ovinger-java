package oving_003;

/**
 * Resevasjon.java
 *
 * Et objekt inneholder data om en reservasjon. 
 * Operasjoner for å hente ut data,
 * og for å sjekke om overlapp med annen reservasjon.
 */
class Reservasjon {
/**
 *
 * @author erlend.lokken
 */
    private final Tidspunkt fraTid;
    private final Tidspunkt tilTid;
    private final Kunde kunde;
    /**
     * Konstruktør: fraTid må være før tilTid. Ingen av argumentene kan være
     * null.
     */
    public Reservasjon(Tidspunkt fraTid, Tidspunkt tilTid, Kunde kunde) {
        if (fraTid == null || tilTid == null) {
            throw new IllegalArgumentException("Fra-tid og/eller til-tid er null");
        }
        if (fraTid.compareTo(tilTid) >= 0) {
            throw new IllegalArgumentException("Fra-tid er lik eller etter til-tid");
        }
        if (kunde == null) {
            throw new IllegalArgumentException("Kunde er null");
        }
        this.fraTid = fraTid;
        this.tilTid = tilTid;
        this.kunde = kunde;
    }
    public Reservasjon(Reservasjon r) {
        this.fraTid = r.fraTid;
        this.tilTid = r.tilTid;
        this.kunde = r.kunde;
    }
    

    public Tidspunkt getFraTid() {
        return fraTid;
    }

    public Tidspunkt getTilTid() {
        return tilTid;
    }

    /**
     * Metoden returnerer true dersom tidsintervallet [sjekkFraTid, sjekkTilTid]
     * overlapper med det tidsintervallet som er i det reservasjonsobjektet vi
     * er inne i [fraTid, tilTid]. Overlapp er ikke definert hvis sjekkFraTid
     * eller sjekkTilTid er null. Da kaster metoden NullPointerException.
     */
    public boolean overlapp(Tidspunkt sjekkFraTid, Tidspunkt sjekkTilTid) {
        return (sjekkTilTid.compareTo(fraTid) > 0 && sjekkFraTid.compareTo(tilTid) < 0);
    }

    public String toString() {
        return "Kunde: " + kunde.getNavn() + ", tlf: " + kunde.getTlf() + ", fra "
                + fraTid.toString() + ", til " + tilTid.toString();
    }

}
