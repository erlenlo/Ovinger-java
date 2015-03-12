/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package oving_003;

/**
 *
 * @author erlend.lokken
 */
public class RomTest {
    public static void main(String[] args) {
        Rom rom1 = new Rom(10, 15);
        Rom rom2 = new Rom(20, 25);
        Rom rom3 = new Rom(30, 10);            
        System.out.println("Totalt antall tester: 2");
                                
        if(rom1.toString().equals("Romnummer: 10, størrelse: 15 personer.") &&
           rom2.toString().equals("Romnummer: 20, størrelse: 25 personer.") &&
           rom3.toString().equals("Romnummer: 30, størrelse: 10 personer.")) {
            System.out.println("Rom: Test 1 er vellykket.");
        }
        
        Reservasjon res1 = new Reservasjon(new Tidspunkt(201501111000L), new Tidspunkt(201501111100L), new Kunde("Erlend", "47653540"));
        Reservasjon res2 = new Reservasjon(new Tidspunkt(201501111300L), new Tidspunkt(201501111400L), new Kunde("Erlend", "47653540"));
        Reservasjon res3 = new Reservasjon(new Tidspunkt(201501111030L), new Tidspunkt(201501111200L), new Kunde("Erlend", "47653540"));
        
        if(rom1.reserverRom(res1) && 
           rom1.reserverRom(res2) && 
          !rom1.reserverRom(res3)) {            
            System.out.println("Rom: Test 2 er vellykket.");            
        }
    }
    
}
