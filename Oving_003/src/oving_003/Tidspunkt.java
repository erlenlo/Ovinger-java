package oving_003;

/**
 * Tidspunkt.java
 *
 * Klasse som håndterer tidspunkt gitt som et heltall av typen long.
 *
 * NB! Konstruktøren foretar ingen kontroll av om tidspunktet er gyldig!
 */
class Tidspunkt implements Comparable<Tidspunkt> {

    /**
     *
     * @author erlend.lokken
     */

    private final long tid; // format ååååmmddttmm

    public Tidspunkt(long tid) {
        this.tid = tid;
    }

    public long getTidspunkt() {
        return tid;
    }

    /**
     * Formaterer tidspunktet slik: dd-mm-åååå kl ttmm
     */
    public String toString() {
        /*
         * Foretar trygg omforming til mindre type,
         * dato og klokkeslett er hver for seg innenfor tallområdet til int.
         */
        int dato = (int) (tid / 10000);
        int klokkeslett = (int) (tid % 10000);
        int år = dato / 10000;
        int mndDag = dato % 10000;
        int mnd = mndDag / 100;
        int dag = mndDag % 100;

        String tid = "";
        if (dag < 10) {
            tid += "0";
        }
        tid += dag + "-";
        if (mnd < 10) {
            tid += "0";
        }
        tid += mnd + "-" + år + " kl ";
        if (klokkeslett < 1000) {
            tid += "0";
        }
        tid += klokkeslett;
        return tid;
    }

    public int compareTo(Tidspunkt detAndre) {
        if (tid < detAndre.tid) {
            return -1;
        } else if (tid > detAndre.tid) {
            return 1;
        } else {
            return 0;
        }
    }

}
