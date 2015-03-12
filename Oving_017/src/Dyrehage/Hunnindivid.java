package Dyrehage;

/**
 *
 * @author erlend.lokken
 */
public class Hunnindivid extends Individ{
    private int antKull;
    
    public Hunnindivid(String navn, String fDato, String kjonn, boolean farlig, 
                       String norskNavn, String latNavn, String latFamilie, int ankommet, String adresse,int antKull) {
        super(navn, fDato, kjonn, farlig, norskNavn, latNavn, latFamilie, ankommet, adresse);
        this.antKull = antKull;        
    }
    
    @Override
    public int getAntKull() {
        return antKull;
    }

    public void setAntKull(int antKull) {
        this.antKull = antKull;
    }  
    
    @Override
    public void leggTilKull(int antall) {
        this.antKull += antall;
    }
    
    @Override
    public void leggTilNyttKull() {
        this.antKull++;
    }
    
 }
