package oving_012;

/**
 *
 * @author erlend.lokken
 */
public class Test_Dato {

  // Dato()-konstruktøren kan kaste unntaksobjekt ParseException, det er et såkalt sjekket unntak,
    // det  vil si at kompilatoren krever at det må håndteres eller kastes videre. Her velger vi
    // den siste måten, dvs. main() kaster unntaksobjektet ut av programmet. Hvis feil oppstår,
    // stopper programmet. I menyklassen (Oppgave11_4_meny.java) håndterer vi unntaket.
    // Se kapittel 15 for mer info. om unntakshåndtering.
    public static void main(String[] args) throws java.text.ParseException {
        Dato dato1 = new Dato();  // dagens dato
        String resultat = "Dagens dato er: " + dato1.format()
                + "\nÅret er: " + dato1.finnÅr()
                + ", måneden er: " + dato1.finnMnd()
                + ", dagen er: " + dato1.finnDagIMnd()
                + "\nEksakt tidspunkt: " + dato1.toString();
        System.out.println("Sjekk opplysningene om dagens dato:\n" + resultat);

        System.out.println("\nTotalt antall tester: 4");
        dato1 = new Dato("22102000");
        if (dato1.format().equals("22102000")) {
            System.out.println("Dato: Test 1 vellykket");
        }

        /*
         * Lager en ny dato som er 0-4 dager fram i tiden, og sammenlikner de to datoene.
         */
        resultat = "";
        for (int antDager = 0; antDager <= 4; antDager++) {
            Dato dato2 = dato1.nyDato(antDager);
            int forhold = dato1.compareTo(dato2);
            if (forhold < 0) {
                resultat += ("\n" + dato1.format() + " er før " + dato2.format());
            } else if (forhold == 0) {
                resultat += ("\n" + dato1.format() + " er lik " + dato2.format());
            } else {
                resultat += ("\n" + dato1.format() + " er etter " + dato2.format());
            }
            /* Finner antall dager mellom de to datoene */
            int dgForskjell = dato1.dagerForskjell(dato2);
            resultat += ("\nFra " + dato1.format() + " til " + dato2.format() + " er det " + dgForskjell + " dager.");
        }
        if (resultat.equals("\n22102000 er lik 22102000"
                + "\nFra 22102000 til 22102000 er det 0 dager."
                + "\n22102000 er før 23102000"
                + "\nFra 22102000 til 23102000 er det 1 dager."
                + "\n22102000 er før 24102000"
                + "\nFra 22102000 til 24102000 er det 2 dager."
                + "\n22102000 er før 25102000"
                + "\nFra 22102000 til 25102000 er det 3 dager."
                + "\n22102000 er før 26102000"
                + "\nFra 22102000 til 26102000 er det 4 dager.")) {
            System.out.println("Dato: Test 2 vellykket");
        }

        /*
         * Samme som foregående test, men krysser grensen mellom to år.
         */
        dato1 = new Dato("30122007");
        resultat = "";
        for (int antDager = 0; antDager <= 4; antDager++) {
            Dato dato2 = dato1.nyDato(antDager);
            int forhold = dato1.compareTo(dato2);
            if (forhold < 0) {
                resultat += ("\n" + dato1.format() + " er før " + dato2.format());
            } else if (forhold == 0) {
                resultat += ("\n" + dato1.format() + " er lik " + dato2.format());
            } else {
                resultat += ("\n" + dato1.format() + " er etter " + dato2.format());
            }
            /* Finner antall dager mellom de to datoene */
            int dgForskjell = dato1.dagerForskjell(dato2);
            resultat += ("\nFra " + dato1.format() + " til " + dato2.format() + " er det " + dgForskjell + " dager.");
        }
        if (resultat.equals("\n30122007 er lik 30122007"
                + "\nFra 30122007 til 30122007 er det 0 dager."
                + "\n30122007 er før 31122007"
                + "\nFra 30122007 til 31122007 er det 1 dager."
                + "\n30122007 er før 01012008"
                + "\nFra 30122007 til 01012008 er det 2 dager."
                + "\n30122007 er før 02012008"
                + "\nFra 30122007 til 02012008 er det 3 dager."
                + "\n30122007 er før 03012008"
                + "\nFra 30122007 til 03012008 er det 4 dager.")) {
            System.out.println("Dato: Test 3 vellykket");
        }

        /*
         * Lager to datoer og finner antall år mellom de to.
         */
        Dato dato3 = new Dato("22101970");
        Dato dato4 = dato3.nyDato(4);
        int antÅr = dato3.antHeleÅrForskjell(dato4);
        resultat = ("\nFra " + dato3.format() + " til " + dato4.format() + " er det " + antÅr + " hele år.");

        dato4 = new Dato("30121980");
        antÅr = dato3.antHeleÅrForskjell(dato4);
        resultat += ("\nFra " + dato3.format() + " til " + dato4.format() + " er det " + antÅr + " hele år.");
        antÅr = dato4.antHeleÅrForskjell(dato3);
        resultat += ("\nFra " + dato4.format() + " til " + dato3.format() + " er det " + antÅr + " hele år.");

        dato4 = new Dato("30011980");
        antÅr = dato3.antHeleÅrForskjell(dato4);
        resultat += ("\nFra " + dato3.format() + " til " + dato4.format() + " er det " + antÅr + " hele år.");
        antÅr = dato4.antHeleÅrForskjell(dato3);
        resultat += ("\nFra " + dato4.format() + " til " + dato3.format() + " er det " + antÅr + " hele år.");
        if (resultat.equals("\nFra 22101970 til 26101970 er det 0 hele år."
                + "\nFra 22101970 til 30121980 er det 10 hele år."
                + "\nFra 30121980 til 22101970 er det -10 hele år."
                + "\nFra 22101970 til 30011980 er det 9 hele år."
                + "\nFra 30011980 til 22101970 er det -9 hele år.")) {
            System.out.println("Dato: Test 4 vellykket");
        }
    }
}
