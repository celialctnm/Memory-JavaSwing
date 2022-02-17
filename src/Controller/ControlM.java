package Controller;

import Vue.*;
import Model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ControlM extends AbstractAction{

    Fenetre fen;
    Modele modele;
    Lynx lynx;
    Modele_Lynx modele_lynx;


    public ControlM(Fenetre fen, Modele modele, Chrono chrono) {
        this.modele = modele;
        this.fen = fen;
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == fen.jeu_objets){
            System.out.println("Bouton jeu objet");
            fen.dispose();
            modele_lynx = new Modele_Lynx();
            lynx = new Lynx();
        }

        if (e.getSource() == fen.item1){
            System.out.println("Nouvelle partie");
            fen.dispose();
            modele = new Modele();
            fen = new Fenetre();
        }

        if (e.getSource() == fen.item2){
            System.out.println("Affichage scores");

            try
            {
                FileInputStream file = new FileInputStream("src/Scores/scores.txt");
                Scanner scanner = new Scanner(file);

                String score1 = scanner.nextLine();
                String score2 = scanner.nextLine();
                String score3 = scanner.nextLine();

                JDialog scores = new JDialog(fen, "Tableau des scores");
                scores.setSize(200, 100);
                scores.setLocationRelativeTo(null);
                GridLayout Gscores = new GridLayout(3,1);
                JPanel PanScore = new JPanel();
                JLabel score_1 = new JLabel("              Rang 1 - "+score1);
                JLabel score_2 = new JLabel("              Rang 2 - "+score2);
                JLabel score_3 = new JLabel("              Rang 3 - "+score3);
                scores.setResizable(false);
                PanScore.add(score_1);
                PanScore.add(score_2);
                PanScore.add(score_3);

                PanScore.setLayout(Gscores);

                scores.add(PanScore);
                scores.setVisible(true);
                scanner.close();


            }
            catch(IOException e2)
            {
                e2.printStackTrace();
            }

            }

        }
    }

