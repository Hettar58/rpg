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
	if(perso1.getPV() > 0 && enemi1.getPV() > 0){
        if (playerAction.equals("attaque")){
        	if(perso1.getVIT() >= enemi1.getVIT()) {
        		actionLog.updateLog(perso1.getNom()+" attaque !");
        		perso1.attaque(enemi1);
        		actionLog.updateLog(perso1.getNom()+" inflige"+ perso1.getADMG() +"DMG Ã  l'enemi");
        		actionLog.updateLog("l'enemie Attaque !");
        		enemi1.attaqueE(perso1);
        		actionLog.updateLog("l'enemie a infligé "+ enemi1.getADMG() +" Ã  l'enemi");
        	}
            if(perso1.getVIT() < enemi1.getVIT()) {
            	actionLog.updateLog("l'enemie attaque !");
            	enemi1.attaqueE(perso1);
            	actionLog.updateLog("l'enemie a infligé "+ enemi1.getADMG() +" Ã  l'enemi");
            	actionLog.updateLog(perso1.getNom()+" attaque !");
        		perso1.attaque(enemi1);
        		actionLog.updateLog(perso1.getNom()+" inflige"+ perso1.getADMG() +"DMG Ã  l'enemi");
            }
            
        }
	}
	if(perso1.getPV() <= 0) {
		System.out.println("Game over");
	}
	if(enemi1.getPV() <= 0) {
		System.out.println("Gagné");
	}
    }

    public void setPlayerAction(String action){this.playerAction = action;}
}
