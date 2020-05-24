import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ControlPanel extends TransparentPane {
    private JPanel inputPanel;

    private JLabel enemiName;
    private JButton attackButton;
    private JButton objectsButton;
    private JButton magicButton;
    private JButton escapeButton;

    private Character personnage;
    private Enemi enemi;

    private TransparentPane objets;

    private JPanel middlePanel;


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
        this.middlePanel = new TransparentPane(0f, 1.0f);
        inputPanel = new TransparentPane(0f, 1.0f);
        attackButton = new Button("Attaque");
        objectsButton = new Button("Objets");
        magicButton = new Button("Magie");
        escapeButton = new Button("Fuite");


        magie = new TransparentPane(0f, 1.0f);
        feu = new Button("Feu");
        glace = new Button("Glace");
        electricite = new Button("electricite");
        terre = new Button("Seisme");

        info = new TransparentPane(0f, 1.0f);
        playerName = new JLabel(personnage.getNom()+": "+personnage.getPV()+"/"+personnage.getPV_max()+" PV - "+personnage.getMNA()+"/"+personnage.getMNA_max()+" MANA");

        inputPanel.setLayout(new GridLayout(4, 1));
        magie.setLayout(new GridLayout(2, 2));
        info.setLayout(new FlowLayout());


        playerName.setForeground(Color.BLUE);

        inputPanel.add(attackButton);
        inputPanel.add(objectsButton);
        inputPanel.add(magicButton);
        inputPanel.add(escapeButton);

        objets = new TransparentPane(0f, 1.0f);
        objets.setLayout(new GridLayout(4, 4));
        /*for(int i = 0; i < perso.getItems().size(); i++){
            System.out.println("boucle");
            Item it = (Item)perso.getItems().get(i);
            String text = it.getName()+" x"+perso.getItems().get(i).getQuantity();
            JButton jb = new Button(text);
            jb.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    main.setPlayerAction("objet");
                    perso.setUsedItem(it);
                    main.tour(0, 0);
                }
            });
            objets.add(jb);
        }*/

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
                main.tour(0,0);
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

        feu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(personnage.getMNA()-20>=0) {
            		personnage.setmagie("feu");
                main.setPlayerAction("magie");
                main.tour(0,0);
            	}
            }
        });
        glace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(personnage.getMNA()-15>=0) {
            		personnage.setmagie("glace");
                main.setPlayerAction("magie");
                main.tour(0,0);
            	}
            }
        });
        electricite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(personnage.getMNA()-25>=0) {
            	personnage.setmagie("electriciter");
                main.setPlayerAction("magie");
                main.tour(0,0);
            	}
            }
        });
        terre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(personnage.getMNA()-15>=0) {
                personnage.setmagie("terre");
                main.setPlayerAction("magie");
                main.tour(0,0);
            	}
            }
        });
    }

    public void refresh(){
        playerName.setText(personnage.getNom()+": "+personnage.getPV()+"/"+personnage.getPV_max()+" PV - "+personnage.getMNA()+"/"+personnage.getMNA_max()+" MANA");
        objets.setVisible(false);
        magie.setVisible(false);
    }

    public void setPersonnage(Character perso){
        this.personnage = perso;
    }
    public void setEnemi(Enemi enemi){this.enemi = enemi;}

    
}
