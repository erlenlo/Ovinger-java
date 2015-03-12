package oving_020;

import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author Erlend
 */
public class Oving_020 {

    static final String DB_URL = "jdbc:derby://localhost:1527/prosjektarbeid";
    static final String USER = "db";
    static final String PASS = "db";

    public static void main(String[] args) throws Exception{
        
        Forbindelse forbindelse = new Forbindelse(DB_URL, USER, PASS);
        
        
        
        boolean fakturert = forbindelse.fakturer(10, "C:\\Datafiler\\faktura.txt");
        if(!fakturert) {
            showMessageDialog(null, "Feil ved fakturering.");
        } else {
            showMessageDialog(null, "Faktura sendt.");
        }
        
        
        
        boolean lukket = forbindelse.lukkForbindelse();
        if(lukket) {
            System.out.println("Connection closed.");
        } else {
            System.out.println("Connection could not close.");            
        }
    }

}