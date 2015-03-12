/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package oving_001;

import java.util.*;

public class Restaurant {
    private String navn;
    private String etableringsAar;
    private Bord bord;

    public Restaurant(String navn, String etableringsAar, int antBord) {
        this.navn = navn;
        this.etableringsAar = etableringsAar;
        this.bord = new Bord(antBord);
    }

    public String getNavn() {
        return navn;
    }
    public void setNavn(String navn) {
        this.navn = navn;
    }    
    public String getEtableringsAar() {
        return etableringsAar;
    }
    public int hvorGammel() {
        int etablert = Integer.parseInt(etableringsAar);
        GregorianCalendar cal = new GregorianCalendar();
        int aar = cal.get(Calendar.YEAR);
        return aar - etablert;        
    }
    
    public int getAntBord() {
        return bord.getAntBord();
    }
    
    public int antLedige() {
        return bord.antLedige();
    }
    public int antReservert() {
        return bord.antReservert();
    }
    
    public boolean reserver(String navn, int bordnr) {
        return bord.reserver(navn, bordnr);
    }
    
    public void frigjor(int[] bordnr) {
        for(int i = 0; i < bordnr.length; i++) {
            bord.frigjort(bordnr[i]);
        }
    }
    
    public int[] finnReservert(String navn) {
        int[] svar = bord.finnReservert(navn);
        return svar;
    }
    
}
