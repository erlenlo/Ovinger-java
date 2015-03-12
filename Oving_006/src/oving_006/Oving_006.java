package oving_006;

import javax.swing.UIManager;

/**
 *
 * @author erlend.lokken
 */
public class Oving_006 {

    public static void main(String[] args) {
    // Set System L&F
        /*
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());                    
        } catch (Exception ex) {
            System.out.println("Failed setting System laf. Reverting to Java defult.");
        }
                */
        ValutaVindu vindu = new ValutaVindu("Valutakalkulator");
        vindu.setVisible(true);

    }

}
