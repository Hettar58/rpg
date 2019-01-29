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
    private Enemi enemi;

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

        magicButton.setBounds(0, 0, 100, 25);
        escapeButton.setBounds(0, 25, 100, 25);
        attackButton.setBounds(0, 50, 100, 25);
        objectsButton.setBounds(0, 75, 100, 25);
        playerName.setBounds(100, 0, 300, 20);

        playerName.setForeground(Color.BLUE);
        
        this.add(attackButton);
        this.add(objectsButton);
        this.add(magicButton);
        this.add(escapeButton);
        this.add(playerName);

        attackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.setPlayerAction("attaque");
                main.tour();
            }
        });
    }

    public void setPersonnage(Character perso){
        this.personnage = perso;
    }
    public void setEnemi(Enemi enemi){this.enemi = enemi;}


}
