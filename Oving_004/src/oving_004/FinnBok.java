package oving_004;

/**
 *
 * @author erlend.lokken
 */
import java.sql.*;
import static javax.swing.JOptionPane.*;

public class FinnBok {
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
            

            String s = showInputDialog("Skriv isbn:");
            String sql1 = "select * from boktittel where isbn = '" + s + "'";                        
            ResultSet rs1 = stmt.executeQuery(sql1);
                        
            //STEP 3: Extract data from result set
            while(rs1.next()) {
                String isbn = rs1.getString("ISBN");
                String forfatter = rs1.getString("Forfatter");  
                String tittel = rs1.getString("tittel");
                
                
                //Skriv ut verdier
                System.out.println("ISBN: " + isbn);
                System.out.println("Forfatter: " + forfatter);
                System.out.println("Tittel: " + tittel);
                
            }
            String sql2 = "select count(*) as antall from eksemplar where isbn = '" + s + "'";
            ResultSet rs2 = stmt.executeQuery(sql2);
            
            while(rs2.next()) {
                int antall = rs2.getInt("Antall");
                if(antall > 0) {
                    System.out.println("Antall: " + antall);
                } else {                
                    showMessageDialog(null, "Ingen bøker med dette isbn-nummeret.");
                }
            }             
                        
            //STEP 4: Clean-up environment
            rs1.close();
            rs2.close();
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


