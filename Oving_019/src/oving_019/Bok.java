package oving_019;

/**
 *
 * @author Erlend
 */
public class Bok {

    private final String isbn;
    private final String tittel;
    private final String forfatter;

    /**
     * Konstruktør: Isbn, tittel og forfatter må oppgis, de kan ikke være verken
     * null eller tomme strenger.
     *
     * @param isbn
     * @param tittel
     * @param forfatter
     */
    public Bok(String isbn, String tittel, String forfatter) {
        if(isbn == null || isbn.equals("") || tittel == null || tittel.equals("") || forfatter == null || forfatter.equals("")) {
            throw new IllegalArgumentException("Isbn, tittel og forfatter må oppgis.");
        }
        this.isbn = isbn;
        this.tittel = tittel;
        this.forfatter = forfatter;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTittel() {
        return tittel;
    }

    public String getForfatter() {
        return forfatter;
    }

    @Override
    public String toString() {
        return isbn + ": " + forfatter + ", " + tittel;
    }
}
