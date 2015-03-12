package oving_005;

/**
 *
 * @author erlend.lokken
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;
import static javax.swing.JOptionPane.*;

public class KalkulatorVindu extends JFrame {

    private JLabel resultatUtskrift = new JLabel("Resultat kommer her...");
    private JTextField belop = new JTextField(20);

    public KalkulatorVindu(String tittel) {
        setTitle(tittel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2, 5, 5));

        JLabel ledetekst = new JLabel("Skriv beløp:");

        // Lager knapper
        JButton sekKnapp = new JButton("Fra NOK Til SEK");
        add(sekKnapp);
        add(ledetekst);

        JButton nokKnapp = new JButton("Fra SEK til NOK");
        add(nokKnapp);
        add(belop);
        add(resultatUtskrift);
        
        // Lager en lytter som leser knappene
        KnappeLytter lytter = new KnappeLytter();
        sekKnapp.addActionListener(lytter);
        nokKnapp.addActionListener(lytter);

        pack();

    }

    private class KnappeLytter implements ActionListener {

        public void actionPerformed(ActionEvent hendelse) {
            ValutaKalkulator kalk = new ValutaKalkulator();
            JButton valgtKnapp = (JButton) hendelse.getSource();
            String valg = valgtKnapp.getText();
            
            double resultat;
            double beregn = 0;
            try {
                resultat = Double.parseDouble(belop.getText());
                
                switch (valg) {
                    case "Fra NOK Til SEK":
                        beregn = kalk.fraNOKtilSEK(resultat);
                        break;
                    case "Fra SEK til NOK":
                        beregn = kalk.fraSEKtilNOK(resultat);
                        break;
                }
                
                DecimalFormat df = new DecimalFormat("####.##");
                if(valg.equals("Fra SEK til NOK")) {
                    resultatUtskrift.setText(df.format(beregn) + "NOK");
                } else {
                    resultatUtskrift.setText(df.format(beregn) + "SEK");

                }
            } catch(NumberFormatException e) {
                //showMessageDialog(null, "Feil fra omforming til tall. Prøv igjen.");
                resultatUtskrift.setText("Feil fra omforming til tall.");
            }
        }
    }
}


