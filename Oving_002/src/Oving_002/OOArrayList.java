
package Oving_002;

/**
 *
 * @author erlend.lokken
 */

import java.util.*;

public class OOArrayList {
    private ArrayList<Student> studenter = new ArrayList<Student>(); 
    private int antStud = 0;
    
    public OOArrayList() {}
    
    public boolean regStudent(String studentNavn) {
        for(Student s: studenter) {
            if(s.getNavn().equals(studentNavn)) {
                return false;
            }
        }        
        studenter.add(new Student(studentNavn, 0));
        antStud++;
        return true;
    }
        
    public int finnAntStud() {
        return studenter.size();
    }
    
    public int finnAntOppgStudent(String navn) {
        for(Student s: studenter) {
            if(s.getNavn().equals(navn)) {
                return s.getAntOppg();
            }
        }
        return -1;
    }
    
    public boolean økAntOppgaver(String navn, int antOppg) {
        for(Student s: studenter) {
            if(s.getNavn().equals(navn)) {
                s.setAntOppgaver(s.getAntOppg() + antOppg);
                return true;
            }
        }
        return false;
    }
    
    public String[] finnAlleNavn() {
        String[] svar = new String[studenter.size()];
        int teller = 0;
        for(Student s: studenter) {
            svar[teller] = s.getNavn();
            teller++;
        }
        return svar;
    }
    
    public String toString() {
        String svar = "";
        for(Student s: studenter) {
            svar += s.toString() + "\n";
        }
        return "Informasjon om alle studenter: \n" + svar;
    }
    
}
