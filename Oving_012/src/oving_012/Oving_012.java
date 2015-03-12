package oving_012;

/**
 *
 * @author erlend.lokken
 */
import java.text.ParseException;
import static javax.swing.JOptionPane.*;
import java.util.Date;

public class Oving_012 {

    public static void main(String[] args) throws ParseException {
        Personalia pers1 = new Personalia("Erlend", "Løkken", "erlend.lokken@gmail.com", "raptus");
        Personalia pers2 = new Personalia("Ingeborg", "Bakken", "ingeborg.bakken@gmail.com", "1234");

        //Dato dato = new Dato();
        Dato innmeldt1 = new Dato("01012015");
        Dato innmeldt2 = new Dato("01022015");

        Medlemsarkiv medlemmer = new Medlemsarkiv();

        int medlNrPers1 = medlemmer.nyMedlem(pers1, innmeldt1);
        int medlNrPers2 = medlemmer.nyMedlem(pers2, innmeldt2);

        //Registrerer poeng
        boolean regPoeng1 = medlemmer.registrerPoeng(medlNrPers1, 30000);
        if (!regPoeng1) {
            showMessageDialog(null, "Medlemmernummer ikke funnet.");
        }
        boolean regPoeng2 = medlemmer.registrerPoeng(medlNrPers2, 80000);
        if (!regPoeng2) {
            showMessageDialog(null, "Medlemmernummer ikke funnet.");
        }

        /**
         * **************************************************************************************************
         */
        String[] muligheter = {"Sjekke", "Info", "RegPoeng", "Avlutt"};
        int valg = showOptionDialog(null, "Valg", "Valg", 0, PLAIN_MESSAGE, null, muligheter, muligheter[0]);

        final int SJEKKE = 0;
        final int INFO = 1;
        final int REGPOENG = 2;
        final int AVSLUTT = 3;

        while (valg != AVSLUTT) {
            switch (valg) {
                //Sjekker medlemmer og foretar oppgraderinger.
                case SJEKKE:
                    String datoLest = showInputDialog("Oppgi dato (ddMMyyyy)");
                    Dato dato = new Dato(datoLest);
                    medlemmer.sjekkMedlemmer(dato);
                    break;
                case INFO:
                    String[] info = medlemmer.info();
                    for (int i = 0; i < info.length; i++) {
                        System.out.println(info[i]);
                    }
                    break;
                case REGPOENG:
                    int medlNR = Integer.parseInt(showInputDialog("Oppgi medlemsnummer:"));
                    int antPoeng = Integer.parseInt(showInputDialog("Antall poeng:"));
                    boolean registrer = medlemmer.registrerPoeng(medlNR, antPoeng);
                    if (!registrer) {
                        showMessageDialog(null, "Medlemsnummer ikke funnet.");
                    }
                    break;
            }
            valg = showOptionDialog(null, "Valg", "Valg", 0, PLAIN_MESSAGE, null, muligheter, muligheter[0]);
        }


        //Finner poeng
        int finnPoengPers1 = medlemmer.finnPoeng(medlNrPers1, "raptus");
        if (finnPoengPers1 < 0) {
            showMessageDialog(null, "Feil passord");
        } else {
            showMessageDialog(null, "Medlemsnummer: " + medlNrPers1 + " har " + finnPoengPers1 + " poeng.");
        }

        int finnPoengPers2 = medlemmer.finnPoeng(medlNrPers2, "1234");
        if (finnPoengPers2 < 0) {
            showMessageDialog(null, "Feil passord");
        } else {
            showMessageDialog(null, "Medlemsnummer: " + medlNrPers2 + " har " + finnPoengPers2 + " poeng.");
        }


    }

}
