package Vue;

import Controller.*;
import Model.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Fenetre extends JFrame{

    /*
    Label temps
     */
    public JLabel temps;

    /*
    Fenêtre principale, grille et cases
     */
    public JPanel Fenetreprincipale;

    public GridLayout Ggrille;
    public JPanel Pgrille;

    public JButton case1;
    public JButton case2;
    public JButton case3;
    public JButton case4;
    public JButton case5;
    public JButton case6;
    public JButton case7;
    public JButton case8;
    public JButton case9;
    public JButton case10;
    public JButton case11;
    public JButton case12;
    public JButton case13;
    public JButton case14;
    public JButton case15;
    public JButton case16;

    /*
    Essai
     */
    public JLabel essai;

    /*
    Control
    */
    public Control control;
    public Modele modele;
    public Chrono chrono;
    public ControlM controlMenu;


    /*
    images
     */
    public ImageIcon imagerecto;
    public ImageIcon image1;
    public ImageIcon image2;
    public ImageIcon image3;
    public ImageIcon image4;
    public ImageIcon image5;
    public ImageIcon image6;
    public ImageIcon image7;
    public ImageIcon image8;
    public ImageIcon image9;
    public ImageIcon image10;
    public ImageIcon image11;
    public ImageIcon image12;
    public ImageIcon image13;
    public ImageIcon image14;
    public ImageIcon image15;
    public ImageIcon image16;

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

        imagerecto = new ImageIcon("src/memory/vue/recto.jpg");

        modele.loadIMGListe1();
        modele.ajouterListe1();
        modele.ordreAleatoire();

        image1 = new ImageIcon();
        image1 = modele.NewlisteImage[0];
        image2 = new ImageIcon();
        image2 = modele.NewlisteImage[1];
        image3 = new ImageIcon();
        image3 = modele.NewlisteImage[2];
        image4 = new ImageIcon();
        image4 = modele.NewlisteImage[3];
        image5 = new ImageIcon();
        image5 = modele.NewlisteImage[4];
        image6 = new ImageIcon();
        image6 = modele.NewlisteImage[5];
        image7 = new ImageIcon();
        image7 = modele.NewlisteImage[6];
        image8 = new ImageIcon();
        image8 = modele.NewlisteImage[7];
        image9 = new ImageIcon();
        image9 = modele.NewlisteImage[8];
        image10 = new ImageIcon();
        image10 = modele.NewlisteImage[9];
        image11 = new ImageIcon();
        image11 = modele.NewlisteImage[10];
        image12 = new ImageIcon();
        image12 = modele.NewlisteImage[11];
        image13 = new ImageIcon();
        image13 = modele.NewlisteImage[12];
        image14 = new ImageIcon();
        image14 = modele.NewlisteImage[13];
        image15 = new ImageIcon();
        image15 = modele.NewlisteImage[14];
        image16 = new ImageIcon();
        image16 = modele.NewlisteImage[15];


        /*
        String[] paths = {"C:/1.jpg", "C:/2.jpg", "C:/3.jpg", "C:/4.jpg", "C:/5.jpg", "C:/6.jpg", "C:/7.jpg", "C:/8.jpg"};
        JButton[] buttonList = new JButton[paths.length];
        for(int i = 0; i < 8; i++) {
            ImageIcon image = new ImageIcon(paths[i]);
            JButton button = new JButton(image);
            buttonList.add(button);
        }

         */

        case1 = new JButton(imagerecto);;
        case2 = new JButton(imagerecto);
        case3 = new JButton(imagerecto);
        case4 = new JButton(imagerecto);
        case5 = new JButton(imagerecto);
        case6 = new JButton(imagerecto);
        case7 = new JButton(imagerecto);
        case8 = new JButton(imagerecto);
        case9 = new JButton(imagerecto);
        case10 = new JButton(imagerecto);
        case11 = new JButton(imagerecto);
        case12 = new JButton(imagerecto);
        case13 = new JButton(imagerecto);
        case14 = new JButton(imagerecto);
        case15 = new JButton(imagerecto);
        case16 = new JButton(imagerecto);




        case1.addActionListener(control);
        case2.addActionListener(control);
        case3.addActionListener(control);
        case4.addActionListener(control);
        case5.addActionListener(control);
        case6.addActionListener(control);
        case7.addActionListener(control);
        case8.addActionListener(control);
        case9.addActionListener(control);
        case10.addActionListener(control);
        case11.addActionListener(control);
        case12.addActionListener(control);
        case13.addActionListener(control);
        case14.addActionListener(control);
        case15.addActionListener(control);
        case16.addActionListener(control);




        essai = new JLabel("Essais restants : " + modele.getNbressai());
        essai.setPreferredSize(new Dimension(200,10));



    }

    public void creerWidgetVersion(){

        Pgrille.setLayout(Ggrille);
        Pgrille.add(case1);
        Pgrille.add(case2);
        Pgrille.add(case3);
        Pgrille.add(case4);
        Pgrille.add(case5);
        Pgrille.add(case6);
        Pgrille.add(case7);
        Pgrille.add(case8);
        Pgrille.add(case9);
        Pgrille.add(case10);
        Pgrille.add(case11);
        Pgrille.add(case12);
        Pgrille.add(case13);
        Pgrille.add(case14);
        Pgrille.add(case15);
        Pgrille.add(case16);

        barMenu = new JMenuBar();

        menu = new JMenu("Options");

        item1 = new JMenuItem(controlMenu);
        item1.setText("Nouvelle partie");
        item2 = new JMenuItem(controlMenu);
        item2.setText("Meilleurs scores");

        menu.add(item1);
        menu.add(item2);

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

