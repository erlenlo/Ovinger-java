
package Dyrehage;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author erlend.lokken
 */
@IndividType(standardSkriveMetode = "skrivUtInfo")

public class Individ extends Dyr implements SkandinaviskeRovdyr {
    private final String navn;
    private final String fDato;
    private final String kjonn;
    private final boolean farlig;
    private static final long MILLIS_IN_YEAR = 31556952000L;

    public Individ(String navn, String fDato, String kjonn, boolean farlig, String norskNavn, String latNavn, String latFamilie, int ankommetDato, String adresse) {
        super(norskNavn, latNavn, latFamilie, ankommetDato, adresse);
        this.navn = navn;
        this.fDato = fDato;
        this.kjonn = kjonn;
        this.farlig = farlig;
    }

    @Override
    public String getNavn() {
        return navn;
    }

    @Override
    public String getFDato() {
        return fDato;
    }

    public String getKjonn() {
        return kjonn;
    }

    public boolean isFarlig() {
        return farlig;
    }
    
    @Override
    public void flytt(String nyAdresse) {
        adresse = nyAdresse;
    }
    
    @Override
    public int getAlder() {
        SimpleDateFormat datoformat = new SimpleDateFormat("ddMMyyyy");
        Date fodtDato;
        Date dagensDato = new Date();
        try {
            fodtDato = datoformat.parse(fDato);
        } catch(java.text.ParseException pe) {
            return 0;
        }
        
        long alderMillis = fodtDato.getTime();
        long dagensMillis = dagensDato.getTime();
        int alder = (int)((dagensMillis - alderMillis) / MILLIS_IN_YEAR);
        
        return alder;
    }
    
    @Override
    public String toString() {
        String res = super.toString();
        String erFarlig;
        if(farlig) {
            erFarlig = "Dyret er farlig.";
        } else {
            erFarlig = "Dyret er ikke farlig.";
        }
        
        res += "\nNavn: " + navn + "\nFødselsdato: " + fDato + "\nAlder: " + getAlder() + "\nKjønn: " + kjonn + "\n" + erFarlig;
        return res;
    }
    
    @Override
    public String skrivUtInfo() {
        return toString();
    }
    
    @Override
    public int getAntKull() {
        return 0; // Defineres i subklasser
    }
    
    @Override
    public void leggTilKull(int antall) {        
        // Defineres i subklasser
    } 
    
    @Override
    public void leggTilNyttKull() {
        // Defineres i subklasser
    }
    
}
