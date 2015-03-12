/**
 * Hovedprogrammet. Går i løkke og lar brukeren gjøre valg.
 */
package Oving_002;

/**
 *
 * @author erlend.lokken
 */
public class KlientProgram {

    public static void main(String[] args) {

        OppgaveOversikt oversikt = new OppgaveOversikt();
        OOArrayList arraylist = new OOArrayList();
        GodkjenningBGS bgs = new GodkjenningBGS(oversikt);

        String valg = bgs.lesValg();
        while (valg != null) {
            bgs.utførValgtOppgave(valg);
            valg = bgs.lesValg();
        }

        /* Prøver toString() */
        System.out.println(oversikt.toString());
    }
}
