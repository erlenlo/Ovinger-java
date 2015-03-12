/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package oving_014;

/**
 *
 * @author erlend.lokken
 */

import java.io.*;
import java.util.Arrays;
import static javax.swing.JOptionPane.*;

public class Oving_014_main {
    public static void main(String[] args) throws Exception {
        //Ståtribuner
        Tribune storestaa = new Staa("Store stå", 20, 100);
        Tribune svingen = new Staa("Svingen", 40, 80);
        
        //Sittetribuner
        Tribune adressa = new Sitte("Adressa", 50, 150, 5);
        
        //VIP-tribuner
        Tribune vip = new VIP("Adidas - VIP", 20, 250, 2, 10);
        
        Tribune[] resultat = new Tribune[4];
        String[] tribuner = {"Storestaa", "Svingen", "Adressa", "VIP"};
        String[] muligheter = {"Kjøp biletter", "List info", "Søk VIP", "Avslutt"};        
        int valg = showOptionDialog(null, "Valg", "Valg", 0, PLAIN_MESSAGE, null, muligheter, muligheter[0]);
        final int KJOP = 0;
        final int INFO = 1;
        final int SOK = 2;
        final int AVSLUTT = 3;
        
        int antallBiletter;
        String liste;
        while(valg != AVSLUTT) {
            switch(valg) {
                case KJOP:
                    liste = (String) showInputDialog(null, "Velg tribune", "Tribuner", DEFAULT_OPTION, null, tribuner, tribuner[0]);
                    if(liste.equals("Storestaa")) {
                        antallBiletter = Integer.parseInt(showInputDialog("Antall biletter"));
                        Billett[] kjopStorestaa = storestaa.kjopBiletter(antallBiletter);
                        for(Billett b: kjopStorestaa) {
                            System.out.println(b.toString());
                        }                                
                    }
                    if(liste.equals("Svingen")) {
                        antallBiletter = Integer.parseInt(showInputDialog("Antall biletter"));
                        Billett[] kjopSvingen = svingen.kjopBiletter(antallBiletter);
                        for(Billett b: kjopSvingen) {
                            System.out.println(b.toString());
                        }                                
                    }
                    if(liste.equals("Adressa")) {
                        antallBiletter = Integer.parseInt(showInputDialog("Antall biletter"));
                        Billett[] kjopAdressa = adressa.kjopBiletter(antallBiletter);
                        while(kjopAdressa == null) {
                            showMessageDialog(null, "For mange biletter!");
                            antallBiletter = Integer.parseInt(showInputDialog("Antall biletter"));
                            kjopAdressa = adressa.kjopBiletter(antallBiletter);
                        }
                        for(Billett b: kjopAdressa) {
                            System.out.println(b.toString());
                        }                                
                    }
                    if(liste.equals("VIP")) {
                        antallBiletter = Integer.parseInt(showInputDialog("Antall biletter"));
                        String[] navn = new String[antallBiletter];
                        for(int i = 0; i < navn.length; i++) {
                            navn[i] = showInputDialog("Oppgi navn:");
                        }
                        Billett[] kjopVIP = vip.kjopBiletter(navn);
                        for(Billett b: kjopVIP) {
                            System.out.println(b.toString());
                        }                                
                    }
                    break;
                case INFO:
                    // Legger alle tribuneobjekter i en tabell og sorterer etter inntekt
                    // ved bruk av arrays.sort og compareTo
                    resultat[0] = storestaa;
                    resultat[1] = svingen;
                    resultat[2] = adressa;
                    resultat[3] = vip;

                    Arrays.sort(resultat);

                    System.out.println("");
                    for (Tribune resultat1 : resultat) {
                        System.out.println(resultat1.toString() + "\n");
                    }
                    break;
                case SOK:
                    String[][] sok = vip.getTilskuer();
                    String navn = showInputDialog("Navn:");
                    for(int i = 0; i < sok.length; i++) {
                        for(int j = 0; j < vip.finnAntallSolgteBiletter(); j++) {
                            if(sok[i][j].equals(navn)) {
                                showMessageDialog(null, "Rad: " + (i + 1) + "\nPlass: " + (j + 1));
                            } else {
                                showMessageDialog(null, "Person ikke funnet.");
                            }                            
                        }
                        break;
                    }
                    break;
                    
            }
            valg = showOptionDialog(null, "Valg", "Valg", 0, PLAIN_MESSAGE, null, muligheter, muligheter[0]);
        }
        

            boolean ok = skrivTilFil("C:\\Datafiler\\oving14.ser", resultat);
            if(!ok) {
                showMessageDialog(null, "Feil ved skriving til fil.");
            }
                        
    }
    
    public static boolean skrivTilFil(String filnavn, Tribune[] tribune) throws Exception {
        boolean ok = false;
        if(tribune != null) {
            try {
                FileOutputStream utstrom = new FileOutputStream(filnavn);
                ObjectOutputStream ut = new ObjectOutputStream(utstrom);
                for (int i = 0; i < tribune.length; i++) {
                    ut.writeObject(tribune[i]);                    
                }
                utstrom.close();
                ut.close();
                ok = true;
            } catch(IOException e) {
                ok = false;
            }
            return ok;
        } else {
            return ok;
        }                
    }
    
    
}
