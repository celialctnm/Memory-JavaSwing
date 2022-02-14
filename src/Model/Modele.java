package Model;

import Vue.*;

import javax.swing.*;
import java.io.File;

public class Modele {

    public ImageIcon[] NewlisteImage = new ImageIcon[16];

    public ImageIcon[] listeImages = new ImageIcon[8];

    public boolean etatPartie = true;


    public int nbressai = 10;
    public int NBRcartesRetournees = 1;
    public int NBRPaires = 0;

    public Modele() {
    }

    public int getNbressai() {
        return this.nbressai;
    }

    public int setNbressai(int nbressai) {
        this.nbressai = nbressai;
        return this.nbressai;
    }

    public int getNBRcartesRetournees() {
        return this.NBRcartesRetournees;
    }

    public int setNBRcartesRetournees(int NBRcartesRetournees) {
        this.NBRcartesRetournees = NBRcartesRetournees;
        return this.NBRcartesRetournees;
    }

    public String EtatPartie() {
        return " Cartes retournées : " + this.NBRcartesRetournees;
    }

    public int getNBRPaires() {
        return this.NBRPaires;
    }

    public int setNBRPaires(int NBRPaires) {
        this.NBRPaires = NBRPaires;
        return this.NBRPaires;
    }

    public void loadIMGListe1() {
        try {
            File folder = new File("src/memory/image");
            int cpt = 0;
            for (final File fileEntry : folder.listFiles()) {
                listeImages[cpt] = new ImageIcon("src/memory/image" + '/' + fileEntry.getName());
                cpt++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void ordreAleatoire() {

        for (var position = NewlisteImage.length - 1; position >= 1; position--) {

            int hasard = (int) Math.floor(Math.random() * (position + 1));

            var sauve = NewlisteImage[position];
            NewlisteImage[position] = NewlisteImage[hasard];
            NewlisteImage[hasard] = sauve;

        }
    }

    public void ajouterListe1() {
        for (int i = 0; i < 8; i++) {
            NewlisteImage[i] = listeImages[i];
        }
        for (int z = 0; z < listeImages.length; z++) {
            NewlisteImage[z + 8] = listeImages[z];
        }
    }

}
