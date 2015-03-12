package oving_003;

/**
 *
 * @author erlend.lokken
 */
import static javax.swing.JOptionPane.*;

public class Oving_003 {

    public static void main(String[] args) {
        Konferansesenter konferanse = new Konferansesenter("Konferansesenter:");

        String[] muligheter = {"Registrer rom", "Reserver rom", "Skriv ut all info", "Info for gitt rom", "Avslutt"};
        int valg = showOptionDialog(null, "Valg", "Valg", 0, PLAIN_MESSAGE, null, muligheter, muligheter[0]);
        final int REGISTRER = 0;
        final int RESERVER = 1;
        final int SKRIV_ALT = 2;
        final int SKRIV_GITT = 3;
        final int AVSLUTT = 4;
        while (valg != AVSLUTT) {
            switch (valg) {
                case REGISTRER:
                    registrer(konferanse);
                    break;
                case RESERVER:
                    reserver(konferanse);
                    break;
                case SKRIV_ALT:
                    listAllInfo(konferanse);
                    break;
                case SKRIV_GITT:
                    listInfoGittNummer(konferanse);
                    break;
            }
            valg = showOptionDialog(null, "Valg", "Valg", 0, PLAIN_MESSAGE, null, muligheter, muligheter[0]);
        }
        
    }

    public static void registrer(Konferansesenter konferanse) {
        int romNummer = Integer.parseInt(showInputDialog("Romnummer:"));
        int størrelse = Integer.parseInt(showInputDialog("Størrelse:"));
        boolean ok = konferanse.registrerRom(romNummer, størrelse);
        if (!ok) {
            showMessageDialog(null, "Rommet er registrert fra før.");
        } else {
            showMessageDialog(null, "Rommet er registrert.");
        }
    }

    public static void reserver(Konferansesenter konferanse) {
        int romNummer = Integer.parseInt(showInputDialog("Romnummer:"));
        int størrelse = Integer.parseInt(showInputDialog("Antall personer:"));
        long lesFraTid = Long.parseLong(showInputDialog("Skriv inn fraTid på formen ååååmmddttmm.\n"
                + "Eksempel: 201501010930\n"
                + "1. Januar 2015, klokken 09:30"));

        long lesTilTid = Long.parseLong(showInputDialog("Skriv inn tilTid på formen ååååmmddttmm.\n"
                + "Eksempel: 201501010930\n"
                + "1. Januar 2015, klokken 09:30"));

        Tidspunkt fraTid = new Tidspunkt(lesFraTid);
        Tidspunkt tilTid = new Tidspunkt(lesTilTid);

        String navn = "";
        String nummer = "";
        Kunde k = null;
        boolean ok = false;
        while (!ok) {
            try {
                navn = showInputDialog("Navn:");
                nummer = showInputDialog("Telefonnummer:");
                k = new Kunde(navn, nummer);
                ok = true;
            } catch (IllegalArgumentException e) {
                showMessageDialog(null, "Navn og telefonnummer må oppgis, prøv igjen.");
            }

        }
        boolean res = false;
        Reservasjon res1 = null;
        
        while(!res) {
            try {
                res1 = new Reservasjon(fraTid, tilTid, k);
                res = true;                
            } catch (IllegalArgumentException e) {
                showMessageDialog(null, "FraTid er lik eller etter tilTid");
                lesFraTid = Long.parseLong(showInputDialog("Skriv inn fraTid på formen ååååmmddttmm.\n"
                        + "Eksempel: 201501010930\n"
                        + "1. Januar 2015, klokken 09:30"));

                lesTilTid = Long.parseLong(showInputDialog("Skriv inn tilTid på formen ååååmmddttmm.\n"
                        + "Eksempel: 201501010930\n"
                        + "1. Januar 2015, klokken 09:30"));

                fraTid = new Tidspunkt(lesFraTid);
                tilTid = new Tidspunkt(lesTilTid);                                
            }
        }
                
        
        boolean reservert = konferanse.reserverRom(res1, romNummer, størrelse);
        if (!reservert) {
            showMessageDialog(null, "Romnummer finnes ikke eller tiden overlapper med en allerede reservert tid. Prøv igjen.");
        } else {
            showMessageDialog(null, "Rommet er reservert: \n" + k.toString());
        }

    }
    public static void listAllInfo(Konferansesenter konferanse) {
        showMessageDialog(null, konferanse.toString());
    }
    
    public static void listInfoGittNummer(Konferansesenter konferanse) {
        int romNummer = Integer.parseInt(showInputDialog("Romnummer:"));
        String svar = konferanse.listInfoGittNummer(romNummer);
        if(svar == "") {
            showMessageDialog(null, "Romnummer finnes ikke.");                        
        } else {        
            showMessageDialog(null, konferanse.listInfoGittNummer(romNummer));
        }
    }
    

}
