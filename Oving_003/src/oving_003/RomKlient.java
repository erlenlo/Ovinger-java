/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oving_003;

import static javax.swing.JOptionPane.*;

/**
 *
 * @author erlend.lokken
 */
public class RomKlient {

    public static void main(String[] args) {

        int romNummer = 10;
        int antPersoner = 15;
        Rom rom1 = new Rom(romNummer, antPersoner);

        String[] muligheter = {"Reserver", "Avslutt"};
        final int RESERVER = 0;
        final int AVSLUTT = 1;
        int valg = showOptionDialog(null, "Valg", "Valg", 0, PLAIN_MESSAGE, null, muligheter, muligheter[0]);
        while (valg != AVSLUTT) {
            switch (valg) {
                case RESERVER:
                    reserver(rom1);
                    break;
            }
            valg = showOptionDialog(null, "Valg", "Valg", 0, PLAIN_MESSAGE, null, muligheter, muligheter[0]);
        }

        System.out.println(rom1.toString());

    }

    public static void reserver(Rom rom) {
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
                nummer = showInputDialog("Nummer:");
                k = new Kunde(navn, nummer);
                ok = true;
            } catch (IllegalArgumentException e) {
                showMessageDialog(null, "Navn og telefonnummer må oppgis, prøv igjen.");
            }

        }

        Reservasjon res1 = new Reservasjon(fraTid, tilTid, k);
        boolean reservert = rom.reserverRom(res1);
        if (!reservert) {
            showMessageDialog(null, "Ønsket reserveringstid er opptatt, prøv en annen tid.");
        } else {
            showMessageDialog(null, "Rommet er reservert.");
        }

    }

}
