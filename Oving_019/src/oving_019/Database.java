package oving_019;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Erlend
 */
public class Database {

    private Connection conn;
    private Statement stmt;
    private ResultSet result;

    public Database(String URL, String username, String password) throws Exception {
        conn = DriverManager.getConnection(URL, username, password);
        stmt = conn.createStatement();

//        System.out.println("Connecting to database...");
//        try {
//            conn = DriverManager.getConnection(URL, username, password);
//            stmt = conn.createStatement();
//
//        } catch (SQLException ex) {
//            System.out.println("Connection failed.");
//        }
    }

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

//Registrerer ny bok..
    public boolean regNyBok(Bok b) {
        String isbn = b.getIsbn();
        String tittel = b.getTittel();
        String forfatter = b.getForfatter();

        String query = "INSERT INTO boktittel values('" + isbn + "', '" + tittel + "','" + forfatter + "')";
        String queryEksemplar = "INSERT INTO eksemplar values('" + isbn + "', 1, null)";

        if (registrertFraFor(b.getIsbn())) {
            return false;
        }

        try {
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
            stmt.executeUpdate(queryEksemplar);
            conn.commit();
            return true;
        } catch (SQLException se) {
            rollback();
            return false;
        } finally {
            try {
                conn.setAutoCommit(true);
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public boolean laanUtBok(String isbn, int eks_nr, String navn) {
        if (!registrertFraFor(isbn)) {
            return false;
        }
        String query = "UPDATE eksemplar set laant_av = '" + navn + "' WHERE isbn = '" + isbn + "' AND eks_nr = " + eks_nr + "";

        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
            stmt.close();
            return true;
        } catch (SQLException se) {
            se.printStackTrace();
            return false;
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    //Registrerer nytt eksemplar av eksisterende isbn-nummer
    public int regNyttEksemplar(String isbn) {
        if (!registrertFraFor(isbn)) {
            return 0;
        }
        int nyttNummer;
        String max = "SELECT MAX(eks_nr) as maks FROM eksemplar WHERE isbn = '" + isbn + "'";

        try {
            stmt = conn.createStatement();
            result = stmt.executeQuery(max);
            result.next();
            nyttNummer = result.getInt("MAKS") + 1;
            String query = "INSERT INTO eksemplar values('" + isbn + "'," + nyttNummer + ", null" + ")";
            stmt.executeUpdate(query);

            stmt.close();
            result.close();
            return nyttNummer;
        } catch (SQLException se) {
            return 0;
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (result != null) {
                    result.close();
                }
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
        }
    }

//Sjekker om bok med gitt isbn-nummer er registrer fra før.    
    public boolean registrertFraFor(String isbn) {
        String query = "SELECT * from eksemplar WHERE isbn = '" + isbn + "'";
        try {
            stmt = conn.createStatement();
            result = stmt.executeQuery(query);

            if (result == null) {
                return false;
            }

            while (result.next()) {
                if (isbn.equals(result.getString("isbn"))) {
                    result.close();
                    stmt.close();
                    return true;
                }
            }
        } catch (SQLException se) {
            return false;
        }
        return false;
    }

    //Metode som kan utføre gitt spørring
    public ResultSet hentQuery(String query) {
        try {
            stmt = conn.createStatement();
        } catch (SQLException se) {
            System.out.println("Feil ved henting av data.");
            rollback();
        }
        try {
            result = stmt.executeQuery(query);
        } catch (SQLException se) {
            System.out.println("Feil ved henting av data.");
        }
        return result;
    }

    public void rollback() {
        try {
            conn.rollback();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}
