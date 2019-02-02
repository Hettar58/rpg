import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel extends TransparentPane {
    private JLabel actionLog;
    private JLabel playerName;
    private JLabel enemiName;
    private JButton attackButton;
    private JButton objectsButton;
    private JButton magicButton;
    private JButton escapeButton;
    private Character personnage;
    private JPanel objets;
    private Enemi enemi;
    private JButton potionVerte;
    private JButton potionRouge;
    private JButton potionBleue;
    private JButton antidote;
    public ControlPanel(float panelOpacity, float childrenOpacity, Character perso, Enemi enemi, Main main){
        super(panelOpacity, childrenOpacity);

        this.personnage = perso;
        this.enemi = enemi;
        this.setLayout(null);

        this.setBounds(0, 480, 800, 100);

        actionLog = new JLabel("Le combat commence");
        playerName = new JLabel(personnage.getNom()+": "+personnage.getPV()+"/"+personnage.getPV_max());
        attackButton = new JButton("Attaquer");
        objectsButton = new JButton("Objets");
        magicButton = new JButton("Magie");
        escapeButton = new JButton("Fuite");
        objets = new JPanel();
        potionVerte = new JButton("Potion verte");
        potionRouge = new JButton("Potion rouge");
        potionBleue = new JButton("Potion bleue");
        antidote = new JButton("Antidote");

        objets.setLayout(new GridLayout(2, 2));

        attackButton.setBounds(0, 0, 100, 25);
        objectsButton.setBounds(0, 25, 100, 25);
        magicButton.setBounds(0, 50, 100, 25);
        escapeButton.setBounds(0, 75, 100, 25);
        playerName.setBounds(650, 0, 100, 20);
        objets.setBounds(120, 0, 250, 100);
        playerName.setForeground(Color.BLUE);

        objets.add(potionVerte);
        objets.add(potionRouge);
        objets.add(potionBleue);
        objets.add(antidote);

        this.add(attackButton);
        this.add(objectsButton);
        this.add(magicButton);
        this.add(escapeButton);
        this.add(playerName);
        this.add(objets);
        objets.setVisible(false);

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
                    objets.setVisible(true);
                }
            }
        });

        magicButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.setPlayerAction("objet");
                main.tour();
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
