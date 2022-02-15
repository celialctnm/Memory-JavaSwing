package Controller;

import Model.Chrono;
import Model.Modele;
import Vue.Fenetre;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class Control implements ActionListener {


    public JDialog gameover;
    public JLabel txtgameover;
    public JButton bgameover;

    /*
    Cartes
     */
    public ImageIcon CarteSelect;
    public ImageIcon CarteSelect2;

    public JButton carte1;
    public JButton carte2;


    /*
    Maintenance
     */
    Fenetre fen;
    Modele modele;

    JButton carteSelected = null;
    JButton carteSelected2 = null;
    JButton carteSelected3 = null;

    public int nbrPaires = 0;




    /*
    Paires
     */

    public int NBRPAIRES = 0;

    public Control() {
    }

    public Control(Fenetre fenetre, Modele modele, Chrono chrono) {
        this.fen = fenetre;
        this.modele = modele;
    }

    public void initWidgetC() {
        Chrono chrono = new Chrono(fen.temps);

    }

    /*
    Nombre d'essais restants
     */

    public int NBRESSAI() {
        int nbressai = this.modele.getNbressai();
        nbressai = this.modele.setNbressai(nbressai - 1);
        fen.essai.setText("Essais restants : " + nbressai);
        if (nbressai == 0) {
            fen.chrono.stop();
            JOptionPane.showMessageDialog(null, "Vous avez perdu");

        }

        return nbressai;
    }

    /*
    Nombres de cartes retournées
     */

    public int NBRCARTERETOURNEES() {
        int nbrCR = modele.getNBRcartesRetournees();
        nbrCR = modele.setNBRcartesRetournees(nbrCR + 1);
        return nbrCR;
    }

    /*
    Comparer deux images
     */

    public boolean CompareImage() {
        return CarteSelect.equals(CarteSelect2);
    }


    /*
    reinitialiser différentes cartes selectionnées
     */

    public void reinitialiseCartesSelect() {

        CarteSelect = null;
        CarteSelect2 = null;
        carte1 = null;
        carte2 = null;
    }

    /*
    Desactiver boutons cartes 1 et 2
     */

    public void desactiverCarte1et2() {

        carte1.setEnabled(false);
        carte2.setEnabled(false);
    }

    /*
    retourner cartes
    */

    public void rectocartes() {
        carte1.setIcon(fen.rectoCarte);
        carte2.setIcon(fen.rectoCarte);
    }

    public boolean isSameImg(JButton button, JButton button2) {
        System.out.println(button.getIcon());
        System.out.println(button2.getIcon());
        if (button.getIcon() == button2.getIcon()) {
            return true;
        }
        return false;
    }

    /*
    Maintenance
     */

    public void reinitialiserCartesSelectionnees() {
        carteSelected = null;
        carteSelected2 = null;
    }

    public void desactiverCartes() {
        carteSelected.setEnabled(false);
        carteSelected2.setEnabled(false);
    }

    public void retournerCartes() {
        carteSelected.setIcon(fen.rectoCarte);
        carteSelected2.setIcon(fen.rectoCarte);
    }

    public void echangeCarte1et3(){
        carteSelected = carteSelected3;
        carteSelected3 = null;
    }

    public void actionPerformed(ActionEvent e) {
        initWidgetC();
        System.out.println(modele.EtatPartie() + " Nombres de paires : " + this.nbrPaires);

        if (modele.etatPartie) {
            fen.chrono.start();
            modele.etatPartie = false;
        }

        if (carteSelected == null) {
            carteSelected = (JButton) e.getSource();

            for (int j = 0; j < fen.buttonList.length; j++) {
                if (carteSelected == fen.buttonList[j]) {
                    carteSelected.setIcon(fen.imagesList[j]);
                }
            }
            return;
        }
        if (carteSelected2 == null) {
            carteSelected2 = (JButton) e.getSource();
            if (carteSelected2 != carteSelected) {
                for (int j = 0; j < fen.buttonList.length; j++) {
                    if (carteSelected2 == fen.buttonList[j]) {
                        carteSelected2.setIcon(fen.imagesList[j]);
                    }
                }
                return;
            }

            if (carteSelected2.equals(carteSelected)) {
                reinitialiserCartesSelectionnees();
                return;
            }
        }

        if (carteSelected3 == null) {
            carteSelected3 = (JButton) e.getSource();
            if (carteSelected3 != carteSelected2 && carteSelected3 != carteSelected) {
                for (int j = 0; j < fen.buttonList.length; j++) {
                    if (carteSelected3 == fen.buttonList[j]) {
                        carteSelected3.setIcon(fen.imagesList[j]);
                    }
                }
            }

            if (carteSelected != null && carteSelected2 != null && carteSelected3 != null) {
                if (carteSelected.getIcon().toString().equals(carteSelected2.getIcon().toString())) {
                    desactiverCartes();
                    reinitialiserCartesSelectionnees();
                    echangeCarte1et3();
                    nbrPaires++;
                } else {
                    retournerCartes();
                    reinitialiserCartesSelectionnees();
                    echangeCarte1et3();
                }
            }


        /*
        Victoire si paires = 8
         */

            if (nbrPaires == (fen.buttonList.length/2)-1) {
                fen.chrono.stop();
                JOptionPane.showMessageDialog(null, "Félicitations ! Vous avez trouvé toutes les paires ! ");

                //scores//
                String score = this.fen.temps.getText();
                score = score.replaceAll(",", ".");
                double dscore = Double.parseDouble(score);
                System.out.println(dscore);

                Double[] tab = new Double[3];

                try {
                    FileInputStream file = new FileInputStream("src/Scores/scores.txt");
                    Scanner scanner = new Scanner(file);

                    String Scan = scanner.nextLine();
                    Scan = Scan.replaceAll(",", ".");
                    double score1 = Double.parseDouble(Scan);
                    Scan = scanner.nextLine();
                    Scan = Scan.replaceAll(",", ".");
                    double score2 = Double.parseDouble(Scan);
                    Scan = scanner.nextLine();
                    Scan = Scan.replaceAll(",", ".");
                    double score3 = Double.parseDouble(Scan);

                    Double[] tabScoretxt = new Double[3];
                    tabScoretxt[0] = score1;
                    tabScoretxt[1] = score2;
                    tabScoretxt[2] = score3;


                    if (dscore < score1) {
                        tabScoretxt[0] = dscore;
                        tabScoretxt[1] = score1;
                        tabScoretxt[2] = score2;
                    } else if (dscore < score2) {
                        tabScoretxt[1] = dscore;
                        tabScoretxt[2] = score2;
                    } else if (dscore < score3) {
                        tabScoretxt[2] = dscore;
                    } else {
                        System.out.println("Ce n'est pas un meilleur score");
                    }

                    FileWriter fw = new FileWriter("src/Scores/scores.txt");
                    BufferedWriter bw = new BufferedWriter(fw);

                    String scoretxt1;
                    String scoretxt2;
                    String scoretxt3;

                    bw.write(scoretxt1 = Double.toString(tabScoretxt[0]));
                    bw.newLine();
                    bw.write(scoretxt2 = Double.toString(tabScoretxt[1]));
                    bw.newLine();
                    bw.write(scoretxt3 = Double.toString(tabScoretxt[2]));

                    bw.close();

                    scanner.close();

                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }
        }
    }
}
