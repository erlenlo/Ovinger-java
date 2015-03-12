package oving_019;

/**
 *
 * @author Erlend
 */
import java.sql.SQLException;
import static javax.swing.JOptionPane.*;

public class Oving_019 {

    static final String DB_URL = "jdbc:derby://localhost:1527/oving";
    static final String USER = "db";
    static final String PASS = "db";

    public static void main(String[] args) throws Exception {

        Bok boken = new Bok("Ny-bok", "Tjohei", "Erlend Løkken");
        Bok boka = new Bok("New-book", "Heihopp", "Hans Hansen");
        Database database = null;

        System.out.println("Connecting to database...");        
        try {
            database = new Database(DB_URL, USER, PASS);            
        }catch(SQLException se) {
            System.out.println("Connection failed.");            
        }
        

//        boolean registrer = database.regNyBok(boka);
//        if(!registrer) {
//            showMessageDialog(null, "Boka ble ikke registrert.");
//        } else {
//            showMessageDialog(null, "Boka ble registrert.");            
//        }
//        
//        boolean utlaant = database.laanUtBok("New-book", 1, "Erlend");
//        if(!utlaant) {
//            showMessageDialog(null, "Boken ble ikke utlånt.");
//        } else {
//            showMessageDialog(null, "Boken ble utlånt.");
//        }
        
//        int nr = database.regNyttEksemplar("New-book");
//        showMessageDialog(null, "Eksemplar nummer " + nr + " er registrert.");
        
        System.out.println("Registrer ny bok, false hvis registrering mislykkes: " + database.regNyBok(boka) + "\nForventes TRUE");
        System.out.println("Registrer ny bok, false hvis registrering mislykkes: " + database.regNyBok(boka) + "\nForventes FALSE");
        System.out.println("Registrer nytt eksemplar med isbn = Ny-bok: " + database.regNyttEksemplar("Ny-bok") + "\nForventes retur > 0");
        System.out.println("Registrer nytt eksemplar med ugyldig isbn:  " + database.regNyttEksemplar("asdasjdjasd") + "\nForventes retur = 0");
        
        System.out.println("Registrer leietaker: " + database.laanUtBok("Ny-bok", 1, "Erlend") + "\nForventes TRUE");
        System.out.println("Registrer leietaker: " + database.laanUtBok("asdalskdnoqiwe", 1, "Erlend") + "\nForventes FALSE");
        
        
        
        boolean lukket = database.lukkForbindelse();
        if(lukket) {
            System.out.println("Connection closed.");
        } else {
            System.out.println("Connection could not close.");            
        }
    }

}
