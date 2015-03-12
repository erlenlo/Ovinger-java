/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package oving_001;

import static javax.swing.JOptionPane.*;
        

public class Main_001 {
    public static void main(String[] args) {
        
        Restaurant restaurant = new Restaurant("Monte Rosa", "2004", 10);
        
        showMessageDialog(null, restaurant.getNavn() + "\n" + "Etablert: " + restaurant.getEtableringsAar() + "\n" + "Antall bord: " + restaurant.getAntBord());
        
        
        String[] muligheter = {"Reserver bord", "Finn bord", "Frigi bord", "Hvis ledige/reserverte bord", "Avslutt"};
        int valg = showOptionDialog(null, "Valg", "Muligheter", 0, PLAIN_MESSAGE, null, muligheter, muligheter[0]);
        
        final int RESERVER = 0;
        final int FINN_BORD = 1;
        final int FRIGI_BORD = 2;
        final int LEDIG_RESERVERT = 3;
        final int AVSLUTT = 4;
        
        while(valg != AVSLUTT) {
            switch(valg) {
                case RESERVER:
                    reserver(restaurant);
                    break;

                case FINN_BORD:
                    finnBord(restaurant);
                    break;

                case FRIGI_BORD:
                    frigiBord(restaurant);
                    break;  
                
                case LEDIG_RESERVERT:
                    listStatus(restaurant);
                    break;
            }
            valg = showOptionDialog(null, "Valg", "Muligheter", 0, PLAIN_MESSAGE, null, muligheter, muligheter[0]);
            
        }
        
    }
    
    public static void reserver(Restaurant restaurant) {
        String navn = showInputDialog("Navn:");
        
        int bordnr = 0;
        boolean ok = false;
        while(!ok) {
            bordnr = Integer.parseInt(showInputDialog("Bordnummer: (0 - 9)"));
            if(bordnr >= 0 && bordnr < restaurant.getAntBord()) {
                ok = true;                
            } else {
                ok = false;
                showMessageDialog(null, "Ugyldig bordnummer.");
            }
        }
        
        boolean registrert = restaurant.reserver(navn, bordnr);   
        if(registrert) {
            showMessageDialog(null, "Bordnummer " + bordnr + " er registrert på " + navn + ".");
        } else {
            showMessageDialog(null, "Bordnummer allerede reservert eller ugyldig bordnummer.");
        }        
    }
    
    public static void finnBord(Restaurant restaurant) {
        String navn = showInputDialog("Navn:");
        int[] svar = restaurant.finnReservert(navn);
        if(svar.length != 0) {
            System.out.println(navn + " har reservert bord nummer:");
            for(int i = 0; i < svar.length; i++) {
                System.out.print(svar[i] + ", ");
                System.out.println("");
            } 
        } else {            
            System.out.println(navn + " har ikke reservert bord.");
        }
    }
    
    public static void frigiBord(Restaurant restaurant) {
        int antallBord = Integer.parseInt(showInputDialog("Hvor mange bord skal frigjøres?"));
        int[] frigjor = new int[antallBord];
        for(int i = 0; i < frigjor.length; i++) {
            int bordNummer = Integer.parseInt(showInputDialog("Frigjør følgende bordnummer:"));
            frigjor[i] = bordNummer;
        }
        restaurant.frigjor(frigjor);        
    }
    
    public static void listStatus(Restaurant restaurant) {
        showMessageDialog(null, "Antall ledige: " + restaurant.antLedige()
                          + "\n Antall reserverte: " + restaurant.antReservert());
    }
    
}
