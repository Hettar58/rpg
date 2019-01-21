import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    public Main(){
        initUI();
    }
    private void initUI(){
        Render render = new Render();
        render.setLayout(null);
        add(render);

        Character perso1 = new Character(280, 250);
        Enemi enemi1 = new Enemi(480, 250);
        render.addPersonnage(perso1);
        render.addEnemi(enemi1);
        setTitle("RPG");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JLabel playerName = new JLabel(""+perso1.getNom()+": "+perso1.getPV()+" / "+perso1.getPV_max());
        JButton attackButton = new JButton("Attaquer");
        JButton objectsButton = new JButton("Objets");

        playerName.setBounds(15, 450, 200, 25);
        attackButton.setBounds(15, 476, 100, 25);
        objectsButton.setBounds(15, 510, 100, 25);

        render.add(playerName);
        render.add(attackButton);
        render.add(objectsButton);

        attackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                perso1.attaque(enemi1);
            }
        });
    }

    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            Main app = new Main();
            app.setVisible(true);
        });
    }
}
