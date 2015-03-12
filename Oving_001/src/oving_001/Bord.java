/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package oving_001;

public class Bord {
    
    private String[] bord;
    private int antallBord;
    
    public Bord(int antallBord) {
        this.antallBord = antallBord;
        this.bord = new String[antallBord];
    }
    
    public int getAntBord() {
        return bord.length;
    }
    
    public int antLedige() {
        int teller = 0;
        for(int i = 0; i < bord.length; i++) {
            if(bord[i] == null) {
                teller++;
            }
        }
        return teller;
    }
    
    public int antReservert() {
        int teller = 0;
        for(int i = 0; i < bord.length; i++) {
            if(bord[i] != null) {
                teller++;
            }
        }
        return teller;        
    }
    
    public void frigjort(int bordnr) {
        bord[bordnr] = null;
    }
    
    public boolean reserver(String navn, int bordnr) {
        if(bord[bordnr] != null) {
            return false;
        }
        bord[bordnr] = navn;
        return true;
    }
    
    public int[] finnReservert(String navn) {
        int teller = 0;
        for(int i = 0; i < bord.length; i++) {
            if(bord[i] != null) {
                if(bord[i].equals(navn)) {
                 teller++;
                }
            }
        }
        int teller2 = 0;
        int[] svar = new int[teller];
        for(int i = 0; i < bord.length; i++) {
            if(bord[i] != null) {
                if(bord[i].equals(navn)) {
                    svar[teller2] = i;
                    teller2++;
                }
            }
        }
        return svar;
    }
                
}
