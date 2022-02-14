package Controller;

import Model.Chrono;
import Model.Modele;
import Vue.Fenetre;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Control implements ActionListener {

    Fenetre fen;
    Modele modele;

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

    public void creerWidgetC() {


    }



    public void reinitBoutton(){
        fen.case1 = new JButton(fen.imagerecto);
        fen.case2 = new JButton(fen.imagerecto);
        fen.case3 = new JButton(fen.imagerecto);
        fen.case4 = new JButton(fen.imagerecto);
        fen.case5 = new JButton(fen.imagerecto);
        fen.case6 = new JButton(fen.imagerecto);
        fen.case7 = new JButton(fen.imagerecto);
        fen.case8 = new JButton(fen.imagerecto);
        fen.case9 = new JButton(fen.imagerecto);
        fen.case10 = new JButton(fen.imagerecto);
        fen.case11 = new JButton(fen.imagerecto);
        fen.case12 = new JButton(fen.imagerecto);
        fen.case13 = new JButton(fen.imagerecto);
        fen.case14 = new JButton(fen.imagerecto);
        fen.case15 = new JButton(fen.imagerecto);
        fen.case16 = new JButton(fen.imagerecto);


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
            reinitBoutton();

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

    public void rectocartes(){
        carte1.setIcon(fen.imagerecto);
        carte2.setIcon(fen.imagerecto);
    }

    public void actionPerformed(ActionEvent e) {

        initWidgetC();
        creerWidgetC();
        System.out.println(modele.EtatPartie() + " Nombres de paires : " + this.NBRPAIRES);

        if (modele.etatPartie == true){
            fen.chrono.start();
            modele.etatPartie = false;
        }


        /*
        Si la case 1 est appuyée,
            l'image de la carte 1 apparait
            le nombre de carte retournées augmente de 1
         */

        if (e.getSource() == this.fen.case1) {
            fen.case1.setIcon(fen.image1);
            NBRCARTERETOURNEES();
            if (CarteSelect == null) {
                CarteSelect = fen.image1;
                if (carte1 == null) {
                    carte1 = fen.case1;
                    carte1.setEnabled(false);
                    carte1.setDisabledIcon(carte1.getIcon());
                }
            } else if (CarteSelect2 == null) {
                CarteSelect2 = fen.image1;
                if (carte2 == null){
                    carte2 = fen.case1;
                    carte2.setEnabled(false);
                    carte2.setDisabledIcon(carte2.getIcon());
                }
            }
        }

        /*
        Case 2
         */

        else if (e.getSource() == this.fen.case2) {
            fen.case2.setIcon(fen.image2);
            NBRCARTERETOURNEES();
            if (CarteSelect == null) {
                CarteSelect = fen.image2;
                if (carte1 == null){
                    carte1 = fen.case2;
                    carte1.setEnabled(false);
                    carte1.setDisabledIcon(carte1.getIcon());
                }

            } else if (CarteSelect2 == null) {
                CarteSelect2 = fen.image2;
                if (carte2 == null){
                    carte2 = fen.case2;
                    carte2.setEnabled(false);
                    carte2.setDisabledIcon(carte2.getIcon());
                }

            }
        }

        /*
        case  3
         */

        else if (e.getSource() == this.fen.case3) {
            fen.case3.setIcon(fen.image3);
            NBRCARTERETOURNEES();
            if (CarteSelect == null) {
                CarteSelect = fen.image3;
                if (carte1 == null){
                    carte1 = fen.case3;
                    carte1.setEnabled(false);
                    carte1.setDisabledIcon(carte1.getIcon());
                }

            } else if (CarteSelect2 == null) {
                CarteSelect2 = fen.image3;
                if (carte2 == null){
                    carte2 = fen.case3;
                    carte2.setEnabled(false);
                    carte2.setDisabledIcon(carte2.getIcon());
                }
            }
        }

        /*
        case  4
         */

        else if (e.getSource() == this.fen.case4) {
            fen.case4.setIcon(fen.image4);
            NBRCARTERETOURNEES();
            if (CarteSelect == null) {
                CarteSelect = fen.image4;
                if (carte1 == null){
                    carte1 = fen.case4;
                    carte1.setEnabled(false);
                    carte1.setDisabledIcon(carte1.getIcon());
                }
            } else if (CarteSelect2 == null) {
                CarteSelect2 = fen.image4;
                if (carte2 == null){
                    carte2 = fen.case4;
                    carte2.setEnabled(false);
                    carte2.setDisabledIcon(carte2.getIcon());
                }
            }
        }

        /*
        case 5
         */

        else if (e.getSource() == this.fen.case5) {
            fen.case5.setIcon(fen.image5);
            NBRCARTERETOURNEES();
            if (CarteSelect == null) {
                CarteSelect = fen.image5;
                if (carte1 == null){
                    carte1 = fen.case5;
                    carte1.setEnabled(false);
                    carte1.setDisabledIcon(carte1.getIcon());
                }

            } else if (CarteSelect2 == null) {
                CarteSelect2 = fen.image5;
                if (carte2 == null){
                    carte2 = fen.case5;
                    carte2.setEnabled(false);
                    carte2.setDisabledIcon(carte2.getIcon());
                }
            }
        }

        /*
        case  6
         */

        else if (e.getSource() == this.fen.case6) {
            fen.case6.setIcon(fen.image6);
            NBRCARTERETOURNEES();
            if (CarteSelect == null) {
                CarteSelect = fen.image6;
                if (carte1 == null){
                    carte1 = fen.case6;
                    carte1.setEnabled(false);
                    carte1.setDisabledIcon(carte1.getIcon());
                }

            } else if (CarteSelect2 == null) {
                CarteSelect2 = fen.image6;
                if (carte2 == null){
                    carte2 = fen.case6;
                    carte2.setEnabled(false);
                    carte2.setDisabledIcon(carte2.getIcon());
                }
            }
        }

        /*
        case 7
         */

        else if (e.getSource() == this.fen.case7) {
            fen.case7.setIcon(fen.image7);
            NBRCARTERETOURNEES();
            if (CarteSelect == null) {
                CarteSelect = fen.image7;
                if (carte1 == null){
                    carte1 = fen.case7;
                    carte1.setEnabled(false);
                    carte1.setDisabledIcon(carte1.getIcon());
                }

            } else if (CarteSelect2 == null) {
                CarteSelect2 = fen.image7;
                if (carte2 == null){
                    carte2 = fen.case7;
                    carte2.setEnabled(false);
                    carte2.setDisabledIcon(carte2.getIcon());
                }
            }
        }

        /*
        case 8
         */

        else if (e.getSource() == this.fen.case8) {
            fen.case8.setIcon(fen.image8);
            NBRCARTERETOURNEES();
            if (CarteSelect == null) {
                CarteSelect = fen.image8;
                if (carte1 == null){
                    carte1 = fen.case8;
                    carte1.setEnabled(false);
                    carte1.setDisabledIcon(carte1.getIcon());
                }


            } else if (CarteSelect2 == null) {
                CarteSelect2 = fen.image8;
                if (carte2 == null){
                    carte2 = fen.case8;
                    carte2.setEnabled(false);
                    carte2.setDisabledIcon(carte2.getIcon());
                }
            }
        }

        /*
        case 9
         */

        else if (e.getSource() == this.fen.case9) {
            fen.case9.setIcon(fen.image9);
            fen.chrono.stop();
            NBRCARTERETOURNEES();
            if (CarteSelect == null) {
                CarteSelect = fen.image9;
                if (carte1 == null){
                    carte1 = fen.case9;
                    carte1.setEnabled(false);
                    carte1.setDisabledIcon(carte1.getIcon());
                }


            } else if (CarteSelect2 == null) {
                CarteSelect2 = fen.image9;
                if (carte2 == null){
                    carte2 = fen.case9;
                    carte2.setEnabled(false);
                    carte2.setDisabledIcon(carte2.getIcon());
                }
            }
        }

        /*
        case  10
         */

        else if (e.getSource() == this.fen.case10) {
            fen.case10.setIcon(fen.image10);
            NBRCARTERETOURNEES();
            if (CarteSelect == null) {
                CarteSelect = fen.image10;
                if (carte1 == null){
                    carte1 = fen.case10;
                    carte1.setEnabled(false);
                    carte1.setDisabledIcon(carte1.getIcon());
                }

            } else if (CarteSelect2 == null) {
                CarteSelect2 = fen.image10;
                if (carte2 == null){
                    carte2 = fen.case10;
                    carte2.setEnabled(false);
                    carte2.setDisabledIcon(carte2.getIcon());
                }
            }
        }

        /*
        case 11
         */

        else if (e.getSource() == this.fen.case11) {
            fen.case11.setIcon(fen.image11);
            NBRCARTERETOURNEES();
            if (CarteSelect == null) {
                CarteSelect = fen.image11;
                if (carte1 == null){
                    carte1 = fen.case11;
                    carte1.setEnabled(false);
                    carte1.setDisabledIcon(carte1.getIcon());
                }

            } else if (CarteSelect2 == null) {
                CarteSelect2 = fen.image11;
                if (carte2 == null){
                    carte2 = fen.case11;
                    carte2.setEnabled(false);
                    carte2.setDisabledIcon(carte2.getIcon());
                }
            }
        }

        /*
        case 12
         */

        else if (e.getSource() == this.fen.case12) {
            fen.case12.setIcon(fen.image12);
            NBRCARTERETOURNEES();
            if (CarteSelect == null) {
                CarteSelect = fen.image12;
                if (carte1 == null){
                    carte1 = fen.case12;
                    carte1.setEnabled(false);
                    carte1.setDisabledIcon(carte1.getIcon());
                }

            } else if (CarteSelect2 == null) {
                CarteSelect2 = fen.image12;
                if (carte2 == null){
                    carte2 = fen.case12;
                    carte2.setEnabled(false);
                    carte2.setDisabledIcon(carte2.getIcon());
                }
            }
        }

        /*
        case 13
         */

        else if (e.getSource() == this.fen.case13) {
            fen.case13.setIcon(fen.image13);
            NBRCARTERETOURNEES();
            if (CarteSelect == null) {
                CarteSelect = fen.image13;
                if (carte1 == null){
                    carte1 = fen.case13;
                    carte1.setEnabled(false);
                    carte1.setDisabledIcon(carte1.getIcon());
                }

            } else if (CarteSelect2 == null) {
                CarteSelect2 = fen.image13;
                if (carte2 == null){
                    carte2 = fen.case13;
                    carte2.setEnabled(false);
                    carte2.setDisabledIcon(carte2.getIcon());
                }
            }
        }

        /*
        case 14
         */

        else if (e.getSource() == this.fen.case14) {
            fen.case14.setIcon(fen.image14);
            NBRCARTERETOURNEES();
            if (CarteSelect == null) {
                CarteSelect = fen.image14;
                if (carte1 == null){
                    carte1 = fen.case14;
                    carte1.setEnabled(false);
                    carte1.setDisabledIcon(carte1.getIcon());
                }

            } else if (CarteSelect2 == null) {
                CarteSelect2 = fen.image14;
                if (carte2 == null){
                    carte2 = fen.case14;
                    carte2.setEnabled(false);
                    carte2.setDisabledIcon(carte2.getIcon());
                }
            }
        }

        /*
        case 15
         */

        else if (e.getSource() == this.fen.case15) {
            fen.case15.setIcon(fen.image15);
            NBRCARTERETOURNEES();
            if (CarteSelect == null) {
                CarteSelect = fen.image15;
                if (carte1 == null){
                    carte1 = fen.case15;
                    carte1.setEnabled(false);
                    carte1.setDisabledIcon(carte1.getIcon());
                }

            } else if (CarteSelect2 == null) {
                CarteSelect2 = fen.image15;
                if (carte2 == null){
                    carte2 = fen.case15;
                    carte2.setEnabled(false);
                    carte2.setDisabledIcon(carte2.getIcon());
                }
            }
        }

        /*
        case 16
         */

        else if (e.getSource() == this.fen.case16) {
            fen.case16.setIcon(fen.image16);
            NBRCARTERETOURNEES();
            if (CarteSelect == null) {
                CarteSelect = fen.image16;
                if (carte1 == null){
                    carte1 = fen.case16;
                    carte1.setEnabled(false);
                    carte1.setDisabledIcon(carte1.getIcon());
                }

            } else if (CarteSelect2 == null) {
                CarteSelect2 = fen.image16;
                if (carte2 == null){
                    carte2 = fen.case16;
                    carte2.setEnabled(false);
                    carte2.setDisabledIcon(carte2.getIcon());
                }
            }
        }

        /*
        Comparer les deux cartes
         */

        if (CarteSelect != null && CarteSelect2 != null) {
            CompareImage();
            if (CompareImage() == true) {
                JOptionPane.showMessageDialog(null, "Cartes identiques ");
                NBRPAIRES = NBRPAIRES + 1;
                desactiverCarte1et2();
                reinitialiseCartesSelect();
            } else {
                JOptionPane.showMessageDialog(null, "Cartes non identiques ");
                NBRESSAI();
                rectocartes();
                carte1.setEnabled(true);
                carte2.setEnabled(true);
                reinitialiseCartesSelect();
            }
        }


        /*
        Victoire si paires = 8
         */

        if (NBRPAIRES == 8){
            fen.chrono.stop();
            JOptionPane.showMessageDialog(null, "Félicitations ! Vous avez trouvé toutes les paires ! ");

            //scores//
            String score=this.fen.temps.getText();
            score=score.replaceAll(",",".");
            double dscore = Double.parseDouble(score);
            System.out.println(dscore);

            Double[] tab = new Double[3];

            try
            {
                FileInputStream file = new FileInputStream("Scores/score1.txt");
                Scanner scanner = new Scanner(file);

                String Scan = scanner.nextLine();
                Scan=Scan.replaceAll(",",".");
                double score1 = Double.parseDouble(Scan);
                Scan = scanner.nextLine();
                Scan=Scan.replaceAll(",",".");
                double score2 = Double.parseDouble(Scan);
                Scan = scanner.nextLine();
                Scan=Scan.replaceAll(",",".");
                double score3 = Double.parseDouble(Scan);

                Double[] tabScoretxt = new Double[3];
                tabScoretxt[0] = score1;
                tabScoretxt[1] = score2;
                tabScoretxt[2] = score3;


                if (dscore < score1){
                    tabScoretxt[0] = dscore;
                    tabScoretxt[1] = score1;
                    tabScoretxt[2] = score2;
                }

                else if (dscore < score2){
                    tabScoretxt[1] = dscore;
                    tabScoretxt[2] = score2;
                }

                else if (dscore < score3){
                    tabScoretxt[2] = dscore;
                }

                else {
                    System.out.println("Ce n'est pas un meilleur score");
                }

                FileWriter fw = new FileWriter("Scores/score1.txt");
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

            }
            catch(IOException e1)
            {
                e1.printStackTrace();
            }

        }

    }
}
