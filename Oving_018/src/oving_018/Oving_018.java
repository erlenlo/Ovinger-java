package oving_018;

/**
 *
 * @author erlend.lokken
 */
import java.sql.*;
import static javax.swing.JOptionPane.*;

public class Oving_018 {
   static final String DB_URL = "jdbc:derby://localhost:1527/persondata";    
   static final String USER = "vprg";
   static final String PASS = "vprg";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 1: Open connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            //STEP 2: Execute a query
            stmt = conn.createStatement();
            

            ResultSet res = stmt.executeQuery("select * from person");
            while (res.next()) {
              int persNr = res.getInt("persnr");
              String fornavn = res.getString("fornavn");
              String etternavn = res.getString("etternavn");
              System.out.println(persNr + ": " + fornavn + " " + etternavn);
            }
            
           //STEP 3: Clean-up environment
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            System.out.println("Connection failed");
        } catch (Exception e) {
            System.out.println("Connection failed");
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
        