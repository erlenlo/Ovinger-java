package oving_014;

/**
 *
 * @author erlend.lokken
 */
import java.util.Arrays;
import java.io.*;
import static javax.swing.JOptionPane.*;

public class Oving_014 {

    public static void main(String[] args) {
        lesFraFil("C:\\Datafiler\\oving14.ser");
    }

    public static void lesFraFil(String filnavn) {
        try {
            FileInputStream fil = new FileInputStream(filnavn);
            ObjectInputStream obj = new ObjectInputStream(fil);
            try {
                while (true) {
                    Object objLest = obj.readObject();
                    System.out.println(objLest + "\n");
                }
            } catch (EOFException e) {
            }
            fil.close();
            obj.close();
        } catch (IOException | ClassNotFoundException e) {}
    }

}
