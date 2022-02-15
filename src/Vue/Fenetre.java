package Vue;

import Controller.*;
import Model.*;

import javax.swing.*;
import java.awt.*;

public class Fenetre extends JFrame{

     /*
    Maintenance
     */

    //Label temps
    public JLabel temps;

    //Fenêtre principale, grille et cases
    public JPanel Fenetreprincipale;
    public GridLayout Ggrille;
    public JPanel Pgrille;

    //Essai
    public JLabel essai;

    //Control
    public Control control;
    public Modele modele;
    public Chrono chrono;
    public ControlM controlMenu;

    //Cases
    public JButton[] buttonList;
    public String[] imagesPaths;
    public String[] images;
    public ImageIcon[] imagesList;
    public ImageIcon rectoCarte;

    /*Menu*/
    public JMenuBar barMenu;
    public JMenu menu;
    public JMenuItem item1;
    public JMenuItem item2;


    public Fenetre() {

        initAttribut();
        creerWidgetVersion();
        setLocationRelativeTo(null);
        setSize(630,680);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public void initAttribut() {

        temps = new JLabel("0.0");
        temps.setPreferredSize(new Dimension(50,10));

        modele = new Modele();
        chrono = new Chrono(temps);
        control = new Control(this, modele, chrono);
        controlMenu = new ControlM(this, modele, chrono);

        Fenetreprincipale = new JPanel();

        Ggrille = new GridLayout(4,4);
        Pgrille = new JPanel();
        Pgrille.setPreferredSize(new Dimension(620,580));

        modele.loadImages();
        modele.randomOrder();

        images = new String[modele.listeImages.length];
        imagesList = new ImageIcon[modele.listeImages.length];
        for (int i = 0; i< images.length; i++){
            imagesList[i] = modele.listeImages[i];
        }

        imagesPaths = new String[]{"src/images/image0.jpeg","src/images/image1.jpeg","src/images/image2.jpeg","src/images/image3.jpeg","src/images/image4.jpeg","src/images/image5.jpeg","src/images/image6.jpeg","src/images/image7.jpeg","src/images/image0.jpeg","src/images/image1.jpeg","src/images/image2.jpeg","src/images/image3.jpeg","src/images/image4.jpeg","src/images/image5.jpeg","src/images/image6.jpeg","src/images/image7.jpeg"};
        buttonList = new JButton[imagesPaths.length];
        for (int i = 0; i<imagesPaths.length; i++){
            rectoCarte = new ImageIcon("src/Vue/imageRecto.jpg");
            JButton cases = new JButton(rectoCarte);
            buttonList[i] = cases;
            buttonList[i].addActionListener(control);
        }
        essai = new JLabel("Essais restants : " + modele.getNbressai());
        essai.setPreferredSize(new Dimension(200,10));
    }

    public void creerWidgetVersion(){

        Pgrille.setLayout(Ggrille);
        for (int i = 0; i<buttonList.length; i++){
            Pgrille.add(buttonList[i]);
        }

        barMenu = new JMenuBar();
        menu = new JMenu("Options");
        item1 = new JMenuItem(controlMenu);
        item1.setText("Nouvelle partie");
        item2 = new JMenuItem(controlMenu);
        item2.setText("Meilleurs scores");

        menu.add(item1);
        menu.add(item2);
        barMenu.add(menu);

        Fenetreprincipale.add(temps);
        Fenetreprincipale.add(Pgrille);
        Fenetreprincipale.add(essai);

        setContentPane(Fenetreprincipale);
        setJMenuBar(barMenu);
    }

}

