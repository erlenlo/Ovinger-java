
package Dyrehage;

/**
 *
 * @author erlend.lokken
 */
public interface SkandinaviskeRovdyr {
    String getNavn();
    String getFDato();
    int getAlder();
    String getAdresse();
    void flytt(String nyAdresse);
    String skrivUtInfo();
    int getAntKull();
    void leggTilKull(int antall);
    void leggTilNyttKull();
}
