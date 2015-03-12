package Klient;

/**
 *
 * @author erlend.lokken
 */

import Dyrehage.SkandinaviskeRovdyr;
import Dyrehage.Rovdyrfabrikk;

public class TestKlient {
    public static void main(String[] args) {        
        Rovdyrfabrikk fabrikk = new Rovdyrfabrikk();
        
        SkandinaviskeRovdyr berit = fabrikk.nyBinne("Berit", "01062002", 2005, "Bjørneskogen", 1);
        SkandinaviskeRovdyr bjarne = fabrikk.nyHannbjorn("Bjarne", "02022005", 2010, "Bjørneskogen", 2);
        SkandinaviskeRovdyr ugne = fabrikk.nyUlvetispe("Ugne", "03031999", 2007, "Ulveredet", 2);
        SkandinaviskeRovdyr ulf = fabrikk.nyUlvehann("Ulf", "12122000", 2006, "Ulveredet", 0);
        
        
        System.out.println("Antall tester: 5");
        
        if(berit.getNavn().equalsIgnoreCase("Berit") && bjarne.getNavn().equalsIgnoreCase("Bjarne")) {
            System.out.println("Test 1 vellykket.");            
        }
        
        if(berit.getAlder() == 12 && ugne.getAlder() == 16) {
            System.out.println("Test 2 vellykket.");                        
        }
        
        if(ulf.getFDato().equals("12122000") && ugne.getFDato().equals("03031999")) {            
            System.out.println("Test 3 vellykket.");                                    
        }
        
        if(bjarne.getAdresse().equalsIgnoreCase("Bjørneskogen") && ulf.getAdresse().equalsIgnoreCase("Ulveredet")) {
            System.out.println("Test 4 vellykket.");                                    
        }
        
        ugne.flytt("Ulveskogen");
        bjarne.flytt("Bjørnehiet");
        if(ugne.getAdresse().equalsIgnoreCase("Ulveskogen") && bjarne.getAdresse().equalsIgnoreCase("Bjørnehiet")) {
            System.out.println("Test 5 vellykket.");                                                
        }
        
        if(berit.getAntKull() == 1 && ulf.getAntKull() == 0) {
            System.out.println("Test 6 vellykket.");                                                           
        }
        
        berit.leggTilNyttKull();
        ugne.leggTilKull(2);
        
        if(berit.getAntKull() == 2 && ugne.getAntKull() == 4) {
            System.out.println("Test 7 vellykket.");                                                                       
        }

        System.out.println("\n" + ulf.skrivUtInfo());
    }
    
}
