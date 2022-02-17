package Controller;

import Model.Chrono;
import Model.Modele_Lynx;
import Vue.Lynx;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller_Lynx implements ActionListener {
    /*
    Maintenance
     */
    Lynx lynx;
    Modele_Lynx modele;

    public ImageIcon carteSelected;
    public ImageIcon carteSelected2;
    public ImageIcon carteSelected3;

    public JButton carteSelectionnee;
    ImageIcon[] images;

    JDialog modelDialog;
    JPanel panelDialog;

    public int nbrCartesTrouvees = 0;

    public Controller_Lynx() {

    }

    public Controller_Lynx(Lynx lynx, Modele_Lynx modele, Chrono chrono) {
        this.lynx = lynx;
        this.modele = modele;
    }

    public void initWidgetC() {
        Chrono chrono = new Chrono(lynx.temps);
        carteSelectionnee = null;
    }

    public void isWin(){
        if (nbrCartesTrouvees == 3){
            lynx.chrono.stop();
            JOptionPane.showMessageDialog(null,"Vous avez trouvé toutes les cartes ! ");
        }
    }

    public void actionPerformed(ActionEvent e) {
        initWidgetC();

        if (modele.etatPartie) {
            modele.etatPartie = false;

            //Mise en place des images à trouver
            images = new ImageIcon[3];
            for (int i = 0; i<3; i++) {
                images[i] = lynx.imagesList[(int) (Math.random() * 25)];
            }
            carteSelected = images[0];
            carteSelected2 = images[1];
            carteSelected3 = images[2];

            carteSelected.getImage().getScaledInstance(5, 5, Image.SCALE_DEFAULT);
            carteSelected2.getImage().getScaledInstance(5, 5, Image.SCALE_DEFAULT);
            carteSelected3.getImage().getScaledInstance(5, 5, Image.SCALE_DEFAULT);

            //Création de la boite de dialogue dans laquelle se trouvera les 3 images à trouver
            modelDialog = new JDialog(null, "Swing Tester", Dialog.ModalityType.DOCUMENT_MODAL);
            panelDialog = new JPanel();
            panelDialog.add(new JButton(carteSelected));
            panelDialog.add(new JButton(carteSelected2));
            panelDialog.add(new JButton(carteSelected3));

            modelDialog.add(panelDialog);
            modelDialog.setBounds(0, 0, 620, 300);
            modelDialog.setLocationRelativeTo(null);
            modelDialog.setVisible(true);

            lynx.chrono.start();
        }

        //Comparaison de la carte selectionnée avec celles à trouver
        if (carteSelectionnee == null){
            carteSelectionnee = (JButton) e.getSource();
            System.out.println(carteSelectionnee.getIcon());


            for (int i = 0; i< images.length; i++){
                if (carteSelectionnee.getIcon().toString().equals(images[i].toString())){
                    carteSelectionnee.setEnabled(false);
                    nbrCartesTrouvees++;
                    isWin();
                }
            }
        }

    }
}

