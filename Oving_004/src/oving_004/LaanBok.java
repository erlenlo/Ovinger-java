 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package oving_004;

/**
 *
 * @author erlend.lokken
 */
import java.sql.*;
import static javax.swing.JOptionPane.*;

public class LaanBok {
   static final String DB_URL = "jdbc:derby://localhost:1527/oving_db";    
   static final String USER = "db";
   static final String PASS = "db";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 1: Open connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            //STEP 2: Execute a query
            stmt = conn.createStatement();
            
            String navn = showInputDialog(null, "Navn:");
            int eks_nr = Integer.parseInt(showInputDialog("Eksemplar nummer:"));
            String isbn = showInputDialog("Skriv isbn:");            
            String sql3 = "update eksemplar set laant_av = '" + navn + "' where isbn = '" + isbn + "' "
                        + "and eks_nr = " + eks_nr + " and laant_av is null";
            
            int svar = stmt.executeUpdate(sql3);
            if(svar != 0) {
                showMessageDialog(null, "Eksemplar nummer " + eks_nr + " er lånt av " + navn + "." );
            } else {
                showMessageDialog(null, "Noe gikk galt under låning av bok.");                
            }
                                                
            //STEP 4: Clean-up environment
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
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
        
