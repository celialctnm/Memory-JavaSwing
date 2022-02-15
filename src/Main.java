import Vue.*;
import Model.*;
import Controller.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater( new Runnable() {

            public void run() {
                Fenetre fenetre = new Fenetre();
                Modele modele = new Modele();
                Control control = new Control(fenetre,modele,fenetre.chrono);
                fenetre.setTitle("Memory");
            }
        });
    }
}
