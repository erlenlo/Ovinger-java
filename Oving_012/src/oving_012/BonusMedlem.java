/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oving_012;

import java.util.Date;
import java.util.*;

/**
 *
 * @author erlend.lokken
 */
public class BonusMedlem {

    private final int medlNr;
    private final Personalia pers;
    private final Dato innmeldtDato;
    protected int poeng = 0;
    
    /*
    public BonusMedlem(int medlNr, int poeng, String fornavn, String etternavn, String epostAdr, Date innmeldtDato, String passord) {
        this.medlNr = medlNr;
        this.pers = new Personalia(fornavn, etternavn, epostAdr, passord);
        this.innmeldtDato = new Dato(innmeldtDato);
        this.poeng = poeng;
    }
    */
    public BonusMedlem(int medlNr, int poeng, Personalia pers, Dato innmeldtDato) {
        this.medlNr = medlNr;
        this.poeng = poeng;
        this.pers = pers;
        this.innmeldtDato = innmeldtDato;
    }
    
    
    // Getters
    public int getMedlNr() {
        return medlNr;
    }

    public Personalia getPers() {
        return pers;
    }

    public Dato getInnmeldtDato() {
        return innmeldtDato;
    }

    public int getPoeng() {
        return poeng;
    }
    
    public void setPoeng(int antPoeng) {
        this.poeng = antPoeng;
    }
    
    public int finnKvalPoeng(Dato innsendt) {
        //Dato dato = new Dato(d);
        int antallDager = innsendt.dagerForskjell(innmeldtDato);
        if(antallDager > -365) {
            return poeng;
        } else {
            return 0;
        }
    }
    
    /******************************************/
    public boolean okPassord(String passord) {
        return pers.okPassord(passord);
    }
    
    /******************************************/
    public boolean registrerPoeng(int antPoeng) {
        if(antPoeng < 0) {
            return false;
        } else {
        poeng += antPoeng;
        return true;            
        }
    }   

}
