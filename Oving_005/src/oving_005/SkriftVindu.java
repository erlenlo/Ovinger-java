
package oving_005;

/**
 *
 * @author erlend.lokken
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SkriftVindu extends JFrame {
    private JLabel tekst = new JLabel("Erlend er kul");
    private final int hoyde;
    
    public SkriftVindu(String tittel, int hoyde) {
        this.hoyde = hoyde;
        setTitle(tittel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3,2,5,5));
        
        // Lager skrifttyper
        Font sansSerif = new Font("SansSerif", Font.ITALIC, hoyde);
        Font serif = new Font("Serif", Font.ITALIC, hoyde);
        Font monospaced = new Font("Monospaced", Font.ITALIC, hoyde);
        Font dialog = new Font("Dialog", Font.ITALIC, hoyde);
        
       
        // Lager knapper
        
        JButton sansKnapp = new JButton("SansSerif");
        sansKnapp.setFont(sansSerif);
        add(sansKnapp);
        
        JButton serifKnapp = new JButton("Serif");
        serifKnapp.setFont(serif);
        add(serifKnapp);
        
        JButton monoKnapp = new JButton("Monospaced");
        monoKnapp.setFont(monospaced);
        add(monoKnapp);
        
        JButton dialogKnapp = new JButton("Dialog");
        dialogKnapp.setFont(dialog);
        add(dialogKnapp);
        
        KnappeLytter lytteren = new KnappeLytter();
        sansKnapp.addActionListener(lytteren);
        serifKnapp.addActionListener(lytteren);
        monoKnapp.addActionListener(lytteren);
        dialogKnapp.addActionListener(lytteren);
        
        add(tekst);
        pack();
    }
        
    private class KnappeLytter implements ActionListener {
        public void actionPerformed(ActionEvent hendelse) {
            JButton valgtKnapp = (JButton) hendelse.getSource();
            String knappeTekst = valgtKnapp.getText();
            Font font = null;
            if(knappeTekst.equals("SansSerif")) {
                font = new Font("SansSerif", Font.ITALIC, hoyde);
            }
            if(knappeTekst.equals("Serif")) {
                font = new Font("Serif", Font.ITALIC, hoyde);
            }
            if(knappeTekst.equals("Monospaced")) {
                font = new Font("Monospaced", Font.ITALIC, hoyde);
            }
            if(knappeTekst.equals("Dialog")) {
                font = new Font("Dialog", Font.ITALIC, hoyde);
            }
            tekst.setFont(font);
            
        }
    }
}
