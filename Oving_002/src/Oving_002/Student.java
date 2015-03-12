
package Oving_002;

/**
 *
 * @author erlend.lokken
 */
public class Student {
    private final String navn;
    private int antOppg;

    public Student(String navn, int antOppg) {
        this.navn = navn;
        this.antOppg = antOppg;
    }
    
    public Student(String navn) {
        this.navn = navn;
        this.antOppg = 0;
    }
    
    public Student(Student s) {
        this.navn = s.navn;
        this.antOppg = s.antOppg;
    }

    public String getNavn() {
        return navn;
    }

    public int getAntOppg() {
        return antOppg;
    }
    
    public void setAntOppgaver(int antOppgaver) {
        if(antOppgaver < 0) {
            throw new IllegalArgumentException("Antall oppgaver kan ikke være negativt.");
        }
        this.antOppg = antOppgaver;
    }
    
    public String toString() {
        return "Navn: " + navn + ", antall oppgaver løst: " + antOppg;
    }
}
