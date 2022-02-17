package Model;

import javax.swing.*;
import java.io.File;
import java.util.Objects;

public class Modele_Lynx {

    public boolean etatPartie = true;
    public ImageIcon[] listeImageLynx = new ImageIcon[25];

    public void loadImagesLynx(){
        try {
            File folder = new File("src/imagesLynx");
            int cpt = 0;
            for (final File fileEntry : Objects.requireNonNull(folder.listFiles())) {
                listeImageLynx[cpt] = new ImageIcon("src/imagesLynx" + '/' + fileEntry.getName());
                cpt++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void randomOrderLynx(){
        for (var position = listeImageLynx.length - 1; position >= 1; position--) {

            int hasard = (int) Math.floor(Math.random() * (position + 1));

            var sauve = listeImageLynx[position];
            listeImageLynx[position] = listeImageLynx[hasard];
            listeImageLynx[hasard] = sauve;

        }
    }

}
