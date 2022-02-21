package Vue;

import Controller.*;
import Model.*;

import javax.swing.*;
import java.awt.*;

public class Lynx extends JFrame{
    //Label temps
    public JLabel temps;

    //Fenêtre principale, grille et cases
    public JPanel Fenetreprincipale;
    public GridLayout Ggrille;
    public JPanel Pgrille;

    //Control
    public Controller_Lynx controller_lynx;
    public Modele_Lynx modele;
    public Chrono chrono;
    public Controller_Menu_Lynx controller_menu_lynx;

    //Cases
    public JButton[] buttonList;
    public ImageIcon[] imagesList;

    /*Menu*/
    public JMenuBar barreMenu;
    public JMenu menu;
    public JMenuItem memoryFen;


    public Lynx() {

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

        modele = new Modele_Lynx();
        chrono = new Chrono(temps);
        controller_lynx = new Controller_Lynx(this, modele, chrono);
        controller_menu_lynx = new Controller_Menu_Lynx(this, modele, chrono);

        Fenetreprincipale = new JPanel();

        modele.loadImagesLynx();
        modele.randomOrderLynx();

        imagesList = new ImageIcon[modele.listeImageLynx.length];
        for (int i = 0; i< imagesList.length; i++){
            imagesList[i] = modele.listeImageLynx[i];
        }

        buttonList = new JButton[imagesList.length];
        for (int i = 0; i<imagesList.length; i++){
            ImageIcon imageIcon = new ImageIcon("src/Vue/imageRecto.jpg");
            JButton cases = new JButton(imageIcon);
            buttonList[i] = cases;
            buttonList[i].addActionListener(controller_lynx);
        }


        Ggrille = new GridLayout(5,5);
        Ggrille.setHgap(10);
        Ggrille.setVgap(10);
        Pgrille = new JPanel();
        Pgrille.setPreferredSize(new Dimension(620,580));

    }

    public void creerWidgetVersion(){

        Pgrille.setLayout(Ggrille);
        for (int i = 0; i<buttonList.length; i++){
            Pgrille.add(buttonList[i]);
        }

        barreMenu = new JMenuBar();
        menu = new JMenu("Menu");
        memoryFen = new JMenuItem(controller_menu_lynx);
        memoryFen.setText("Memory");

        menu.add(memoryFen);
        barreMenu.add(menu);

        Fenetreprincipale.add(barreMenu);
        Fenetreprincipale.add(temps);
        Fenetreprincipale.add(Pgrille);

        setContentPane(Fenetreprincipale);
        setJMenuBar(barreMenu);
    }

}

