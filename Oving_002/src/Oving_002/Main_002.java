
package Oving_002;

/**
 *
 * @author erlend.lokken
 */

import static javax.swing.JOptionPane.*;
public class Main_002 {

    public static void main(String[] args) {       
        
        OppgaveOversikt oversikt = new OppgaveOversikt();
        OOArrayList arraylist = new OOArrayList();
        
        String[] muligheter = {"Registrert student", "Øk oppgaver", "Finn oppgaver", "List ut alle navn", "Avslutt"};
        int valg = showOptionDialog(null,"Muligheter", "Valg", 0, PLAIN_MESSAGE, null, muligheter, muligheter[0]);
        
        final int REGISTRER = 0;
        final int ØK = 1;
        final int FINN = 2;
        final int LIST_UT = 3;
        final int AVSLUTT = 4;
        
        while(valg != AVSLUTT) {
            switch(valg) {
                case REGISTRER:
                    registrer(arraylist);
                    break;
                case ØK:
                    økOppgaver(arraylist);
                    break;
                case FINN:
                    finnOppgaver(arraylist);
                    break;
                case LIST_UT:
                    listUtPersoner(arraylist);
                    break;
            }
            valg = showOptionDialog(null,"Muligheter", "Valg", 0, PLAIN_MESSAGE, null, muligheter, muligheter[0]);
        }
        
        showMessageDialog(null, arraylist.toString());
            
    }
    
    public static void registrer(OOArrayList arraylist) {
        String navn = showInputDialog("Navn: ");
        boolean registrert = arraylist.regStudent(navn);
        if(!registrert) {
            showMessageDialog(null, "Student er registrert fra før.");
        }                
    }
    
    public static void økOppgaver(OOArrayList arraylist) {
        String navn = showInputDialog("Navn: ");
        int antOppgaver = Integer.parseInt(showInputDialog("Antall oppgaver:"));
        boolean registert = arraylist.økAntOppgaver(navn, antOppgaver);
        if(!registert) {
            showMessageDialog(null, "Student ikke funnet.");
        }        
    }
    
    public static void finnOppgaver(OOArrayList arraylist) {
        String navn = showInputDialog("Navn: ");
        int antallOppgaver = arraylist.finnAntOppgStudent(navn);
        if(antallOppgaver >= 0) {
            showMessageDialog(null, navn + " har godkjent " + antallOppgaver + " oppgaver.");
        } else {
            showMessageDialog(null, "Student ikke funnet.");
        }
    }
    
    public static void listUtPersoner(OOArrayList arraylist) {
        String[] svar = arraylist.finnAlleNavn();
        for(int i = 0; i < svar.length; i++) {
            System.out.println(svar[i]);
        }
    }
     
}
