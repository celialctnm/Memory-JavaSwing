package Controller;

import Model.Chrono;
import Model.Modele;
import Model.Modele_Lynx;
import Vue.Fenetre;
import Vue.Lynx;

import javax.swing.*;
import java.awt.event.ActionEvent;


public class Controller_Menu_Lynx extends AbstractAction {

    Lynx lynx;
    Fenetre fen;
    Modele_Lynx modele;
    Modele modele_fen;

    public Controller_Menu_Lynx(Lynx lynx, Modele_Lynx modele, Chrono chrono) {
        this.lynx = lynx;
        this.modele = modele;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == lynx.memoryFen){
            lynx.dispose();
            modele_fen = new Modele();
            fen = new Fenetre();
        }
    }
}
