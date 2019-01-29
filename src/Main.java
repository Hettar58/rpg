import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    Render render;
    LogPanel actionLog;
    ControlPanel fightUI;
    Enemi enemi1;
    Character perso1;
    String playerAction;
    String cpuAction;

    public Main(){
        initUI();
    }
    private void initUI(){
        perso1 = new Character(280, 250);
        enemi1 = new Enemi(480, 250);
        fightUI = new ControlPanel(0.3f, 1f, perso1, enemi1, this);
        actionLog = new LogPanel(0.3f, 1.0f);
        render = new Render();
        render.setLayout(null);
        add(render);

        render.addPersonnage(perso1);
        render.addEnemi(enemi1);
        setTitle("RPG");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        fightUI.setPersonnage(perso1);
        render.add(fightUI);
        render.add(actionLog);
    }

    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            Main app = new Main();
            app.setVisible(true);
        });
    }

    public void tour(){
        if (playerAction.equals("attaque")){
            actionLog.updateLog(perso1.getNom()+" attaque !");
            perso1.attaque(enemi1);
        }
    }

    public void setPlayerAction(String action){this.playerAction = action;}
}
