package Model;

import Vue.*;

import javax.swing.*;
import java.io.File;
import java.util.Objects;

public class Modele {

    /*
    Maintenances
     */
    String[] imagesPaths = new String[20];
    public ImageIcon[] listeImages = new ImageIcon[imagesPaths.length];
    public boolean etatPartie = true;

    public Modele() {
    }

    public void loadImages(){
        try {
            File folder = new File("src/images");
            int cpt = 0;
            for (final File fileEntry : Objects.requireNonNull(folder.listFiles())) {
                listeImages[cpt] = new ImageIcon("src/images" + '/' + fileEntry.getName());
                cpt++;
            }
            System.out.println(cpt);
            int cpt2 = 10;
            for (final File fileEntry : Objects.requireNonNull(folder.listFiles())) {
                listeImages[cpt2] = new ImageIcon("src/images" + '/' + fileEntry.getName());
                cpt2++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i< listeImages.length; i++){
            System.out.println("Index " + i + "" + listeImages[i]);
        }
    }

    public void randomOrder(){
        for (var position = listeImages.length - 1; position >= 1; position--) {

            int hasard = (int) Math.floor(Math.random() * (position + 1));

            var sauve = listeImages[position];
            listeImages[position] = listeImages[hasard];
            listeImages[hasard] = sauve;
        }
    }
}
