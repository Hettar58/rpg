import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel extends TransparentPane {
    private JPanel inputPanel;

    private JLabel enemiName;
    private JButton attackButton;
    private JButton objectsButton;
    private JButton magicButton;
    private JButton escapeButton;

    private Character personnage;
    private Enemi enemi;

    private JPanel middlePanel;

    private JPanel objets;
    private JButton potionVerte;
    private JButton potionRouge;
    private JButton potionBleue;
    private JButton antidote;

    private JPanel magie;
    private JButton feu;
    private JButton glace;
    private JButton electricite;
    private JButton terre;

    private JPanel info;
    private JLabel playerName;
    public ControlPanel(float panelOpacity, float childrenOpacity, Character perso, Enemi enemi, Main main){
        super(panelOpacity, childrenOpacity);

        this.personnage = perso;
        this.enemi = enemi;
        this.setLayout(new GridLayout(1, 4));
        this.setBounds(0, 480, 800, 100);
        this.middlePanel = new JPanel();
        inputPanel = new JPanel();
        attackButton = new JButton("Attaquer");
        objectsButton = new JButton("Objets");
        magicButton = new JButton("Magie");
        escapeButton = new JButton("Fuite");

        objets = new JPanel();
        potionVerte = new JButton("Potion verte");
        potionRouge = new JButton("Potion rouge");
        potionBleue = new JButton("Potion bleue");
        antidote = new JButton("Antidote");

        magie = new JPanel();
        feu = new JButton("Feu");
        glace = new JButton("Glace");
        electricite = new JButton("électricité");
        terre = new JButton("Séisme");

        info = new JPanel();
        playerName = new JLabel(personnage.getNom()+": "+personnage.getPV()+"/"+personnage.getPV_max());

        inputPanel.setLayout(new GridLayout(4, 1));
        objets.setLayout(new GridLayout(2, 2));
        magie.setLayout(new GridLayout(2, 2));
        info.setLayout(new FlowLayout());


        playerName.setForeground(Color.BLUE);

        inputPanel.add(attackButton);
        inputPanel.add(objectsButton);
        inputPanel.add(magicButton);
        inputPanel.add(escapeButton);

        objets.add(potionVerte);
        objets.add(potionRouge);
        objets.add(potionBleue);
        objets.add(antidote);

        magie.add(feu);
        magie.add(glace);
        magie.add(electricite);
        magie.add(terre);

        info.add(playerName);

        middlePanel.add(objets);
        middlePanel.add(magie);

        objets.setVisible(false);
        magie.setVisible(false);
        this.add(inputPanel);
        this.add(middlePanel);
        this.add(info);


        attackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
                main.setPlayerAction("attaque");
                main.tour();
            }
        });

        objectsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(objets.isVisible()){
                    objets.setVisible(false);
                }
                else {
                    magie.setVisible(false);
                    objets.setVisible(true);
                }
            }
        });

        magicButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (magie.isVisible()){
                    magie.setVisible(false);
                }
                else{
                    objets.setVisible(false);
                    magie.setVisible(true);
                }
            }
        });

        escapeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.setPlayerAction("fuite");
            }
        });

        potionVerte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                personnage.setItem("Potion verte");
                main.setPlayerAction("objet");
                main.tour();
            }
        });

        potionBleue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                personnage.setItem("Potion Bleue");
                main.setPlayerAction("objet");
                main.tour();
            }
        });

        potionRouge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                personnage.setItem("Potion rouge");
                main.setPlayerAction("objet");
                main.tour();
            }
        });
        antidote.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                personnage.setItem("Antidote");
                main.setPlayerAction("objet");
                main.tour();
            }
        });
    }

    public void setPersonnage(Character perso){
        this.personnage = perso;
    }
    public void setEnemi(Enemi enemi){this.enemi = enemi;}
}
