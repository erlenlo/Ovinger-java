
package oving_006;

/**
 *
 * @author erlend.lokken
 */

import java.awt.*;
import javax.swing.event.*;
import javax.swing.*;
import static javax.swing.JOptionPane.*;
import java.text.DecimalFormat;

public class ValutaVindu extends JFrame {
    
    ValutaBeregning nyValuta = new ValutaBeregning("Ny Valuta", 0.00);
    ValutaBeregning euro = new ValutaBeregning("Euro", 8.85);
    ValutaBeregning usd = new ValutaBeregning("US Dollar", 7.60);
    ValutaBeregning gbp = new ValutaBeregning("Britiske pund", 11.54);
    ValutaBeregning nok = new ValutaBeregning("Norske Kroner", 1.00);
    ValutaBeregning sek = new ValutaBeregning("Svenske Kroner", 0.93);
    ValutaBeregning dkk = new ValutaBeregning("Danske Kroner", 1.19);
    ValutaBeregning isk = new ValutaBeregning("Islandske kroner", 0.058);
    ValutaBeregning aud = new ValutaBeregning("Australsk dollar", 6.25);
    ValutaBeregning rub = new ValutaBeregning("Russiske rubler", 11.7);
    ValutaBeregning yen = new ValutaBeregning("Japanske yen", 6.5);
    
    ValutaBeregning[] valutaer = {nyValuta, euro, usd, gbp, nok, sek, dkk, isk, aud, rub, yen};    
    JList liste = new JList(valutaer);
    JList liste2 = new JList(valutaer);
        
    public ValutaVindu(String tittel) {
        setTitle(tittel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Legger på scroll
        JScrollPane rullefelt1 = new JScrollPane(liste);
        JScrollPane rullefelt2 = new JScrollPane(liste2);
        add(rullefelt1, BorderLayout.WEST);
        add(rullefelt2, BorderLayout.EAST);
        
        // Legger tekst i nord
        TekstNord tekst = new TekstNord();
        add(tekst, BorderLayout.NORTH);

        
        //Legger på lutt luft i sør
        add(new JPanel(), BorderLayout.SOUTH);
                        
        ListeLytter lytter = new ListeLytter();
        liste.addListSelectionListener(lytter);
        liste2.addListSelectionListener(lytter);
        
        pack();
    }
    private class ListeLytter implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent hendelse) {
            Object obj1 = liste.getSelectedValue();
            Object obj2 = liste2.getSelectedValue();
            ValutaBeregning fraValg = (ValutaBeregning) obj1;
            ValutaBeregning tilValg = (ValutaBeregning) obj2;
            DecimalFormat df = new DecimalFormat("####.##");
            
            double belop = 0;
            double resultat = 0;
            if(fraValg != null && tilValg != null && !fraValg.getValutaNavn().equals("Ny Valuta") && !tilValg.getValutaNavn().equals("Ny Valuta")) {
                boolean ok = false;
                while(!ok) {
                    try {
                        belop = Double.parseDouble(showInputDialog("Oppgi beløp:"));
                        ok = true;
                    } catch(NullPointerException e) {
                        ok = false;
                    } catch(NumberFormatException ne) {
                        showMessageDialog(null, "Feil fra omforming til tall, prøv igjen.");
                    }   
                }                    
                double fraValuta = fraValg.getKursMotNOK();
                double tilValuta = tilValg.getKursMotNOK();
                resultat = (fraValuta/tilValuta) * belop;                
                showMessageDialog(null, belop + " " + fraValg.getValutaNavn() + " er " + df.format(resultat) + " " + tilValg.getValutaNavn());
                
                //Resetter listevalg
                liste.clearSelection();
                liste2.clearSelection();
            }
            // Kode for å legge inn ny valuta.
            DefaultListModel dlm = new DefaultListModel();
                        
            if(fraValg != null && tilValg != null && fraValg.getValutaNavn().equals("Ny Valuta") && tilValg.getValutaNavn().equals("Ny Valuta")) {
                String valutaNavn = showInputDialog("Oppgi valutanavn:");
                double kurs = Double.parseDouble(showInputDialog("Oppgi kurs mot norske kroner:"));
                ValutaBeregning ny = new ValutaBeregning(valutaNavn, kurs);                
                
                for(int i = 0; i < valutaer.length; i++) {
                    dlm.addElement(valutaer[i]);
                }
                dlm.addElement(ny);                
                liste.setModel(dlm);
                liste2.setModel(dlm);
                
                liste.clearSelection();
                liste2.clearSelection();
            }            
        }
    }
    
    // Deler opp i flere paneler for å plassere element i vinduet
    
    private class TekstNord extends JPanel{
        public TekstNord() {            
            setLayout(new GridLayout(1,1,5,5));
            JLabel tekst1 = new JLabel("Fra valuta:", JLabel.LEFT);
            JLabel tekst2 = new JLabel("Til valuta:", JLabel.RIGHT);
            add(tekst1);
            add(tekst2);
            
        }
    }
}
