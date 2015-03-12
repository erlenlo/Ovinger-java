
package Oving_002;

/**
 *
 * @author erlend.lokken
 */
public class OppgaveOversikt {
    private Student [] studenter = new Student[5];
    private int antStud = 0;
    
    public OppgaveOversikt() {
        this.studenter = studenter;
    }
    
    public boolean regStudent(String studentNavn) {
        for(int i = 0; i < antStud; i++) {
            if(studenter[i].getNavn().equals(studentNavn)) {
                return false;
            }
        }
        if(studenter.length == antStud) {
            utvidTabell();
        }
        
        studenter[antStud] = new Student(studentNavn, 0);
        antStud++;
        return true;
    }
    
    public void utvidTabell() {
        Student[] nyTab = new Student[antStud + 5];
        for(int i = 0; i < antStud; i++) {
            nyTab[i] = studenter[i];
        }
        studenter = nyTab;
    }
    
    public int finnAntStud() {
        return antStud;
    }
    
    public int finnAntOppgStudent(String navn) {
        for(int i = 0; i < antStud; i++) {
            if(studenter[i].getNavn().equals(navn)) {
                return studenter[i].getAntOppg();
            }
        }
        return -1;
    }
    
    public boolean økAntOppgaver(String navn, int antOppg) {
        for(int i = 0; i < antStud; i++) {
            if(studenter[i].getNavn().equals(navn)) {
                studenter[i].setAntOppgaver(studenter[i].getAntOppg() + antOppg);
                return true;
            }
        }
        return false;
    }
    
    public String[] finnAlleNavn() {
        String[] svar = new String[antStud];
        for(int i = 0; i < antStud; i++) {
            svar[i] = studenter[i].getNavn();
        }
        return svar;
    }
    
    public String toString() {
        String svar = "";
        for(int i = 0; i < antStud; i++) {
            svar += studenter[i].toString() + "\n";
        }
        return "Informasjon om alle studenter: \n" + svar;
    }
}
