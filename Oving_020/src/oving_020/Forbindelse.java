package oving_020;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 *
 * @author Erlend
 */
public class Forbindelse {

    private Connection conn;
    private Statement stmt;
    private ResultSet result;

    // Åpner forbindelse i konstruktør
    public Forbindelse(String URL, String username, String password) {
        System.out.println("Connecting to database...");
        try {
            conn = DriverManager.getConnection(URL, username, password);
            stmt = conn.createStatement();
            System.out.println("Connection successful.");
            
        } catch (SQLException ex) {
            System.out.println("Connection failed.");
        }
    }

    //Metode som lukker databaseforbindelsen
    public boolean lukkForbindelse() {
        try {
            stmt.close();
            conn.close();
            return true;

        } catch (SQLException se) {
        } catch (Exception e) {
        } finally {
            try {
                if (result != null) {
                    result.close();
                }
            } catch (SQLException se) {
            }
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se1) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se2) {
            }
        }
        return false;
    }

    public boolean fakturer(int maanedNummer, String filnavn) {
        String query = "SELECT pk.PROSJ_ID, p.KUNDE, pk.TEKST, pk.BELØP "
                + "FROM prosjektkostnader pk JOIN prosjekt p ON p.PROSJ_ID = pk.PROSJ_ID "
                + "WHERE MONTH(pk.DATO) = " + maanedNummer + " AND pk.FAKTURA_SENDT IS NULL";

        String queryTimer = "SELECT pa.PROSJ_ID, 'timer' as tid, p.KUNDE, SUM(pa.ANT_TIMER * p.TIMEFAKTOR * a.TIMELØNN) as timer "
                + "FROM prosjektarbeid pa JOIN ansatt a ON a.ANS_ID = pa.ANS_ID "
                + "JOIN prosjekt p ON p.PROSJ_ID = pa.PROSJ_ID "
                + "WHERE MONTH(pa.DATO) = "+maanedNummer+" GROUP BY p.KUNDE, pa.PROSJ_ID";

        ArrayList<String[]> timer = new ArrayList<>();
        int antKolonner;
        try {
            result = stmt.executeQuery(queryTimer);
            antKolonner = result.getMetaData().getColumnCount();
            while (result.next()) {
                String[] row = new String[antKolonner];
                for (int i = 0; i < antKolonner; i++) {
                    row[i] = result.getString(i + 1);
                }
                timer.add(row);
            }            
            skrivTilFil(filnavn, timer);

            ArrayList<String[]> prosjekt = new ArrayList<>();
            result = stmt.executeQuery(query);
            antKolonner = result.getMetaData().getColumnCount();
            while (result.next()) {
                String[] row = new String[antKolonner];
                for (int i = 0; i < antKolonner; i++) {
                    row[i] = result.getString(i + 1);
                }
                prosjekt.add(row);
            }
            skrivTilFil(filnavn, prosjekt);
            
            String updatePA = "UPDATE prosjektarbeid set FAKTURA_SENDT = CURRENT_DATE WHERE MONTH(dato) = "+maanedNummer+"";
            String updatePK = "UPDATE prosjektkostnader set FAKTURA_SENDT = CURRENT_DATE WHERE MONTH(dato) = "+maanedNummer+"";
            
            conn.setAutoCommit(false);
            stmt.executeUpdate(updatePA);
            stmt.executeUpdate(updatePK);
            conn.commit();
            conn.setAutoCommit(true);            
            
        } catch (SQLException se) {
            se.printStackTrace();
            return false;
        }

        return true;
    }

    public void skrivTilFil(String filnavn, ArrayList<String[]> res) {
        PrintWriter writer = null;

        try {
            writer = new PrintWriter(new FileWriter(filnavn, true));
            for (String[] str : res) {
                for (String s : str) {
                    writer.write(s + "; ");
                }
                writer.println();
            }
            
        } catch (IOException e) {
        } finally {
            if (writer != null) {
                writer.close();
            }
        }

    }

}