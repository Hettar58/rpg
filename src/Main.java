import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask.*;
import java.util.Timer.*;
import java.util.TimerTask;
public class Main extends JFrame {
    Render render;
    LogPanel actionLog;
    ControlPanel fightUI;
    Enemi enemi1;
    Character perso1;
    String playerAction;
    String cpuAction;
    boolean fin=true;

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
        setSize(800, 630);
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
    	final javax.swing.Timer timer;
    	if(fin) {
    		fin = false;
	if(perso1.getPV() > 0 && enemi1.getPV() > 0){
		
        if (playerAction.equals("attaque")){
        	if(perso1.getVIT() >= enemi1.getVIT()) {
        		actionLog.updateLog(perso1.getNom()+" attaque !");
        		perso1.attaque(enemi1);
        		actionLog.updateLog(perso1.getNom()+" inflige"+ perso1.getADMG() +"DMG Ã  l'enemi");
        		ActionListener action = new ActionListener (){
        			 public void actionPerformed(ActionEvent arg0) {
        		if (enemi1.getPV() > 0) {
        			actionLog.updateLog("l'enemie Attaque !");
        			enemi1.attaqueE(perso1);
        			actionLog.updateLog("l'enemie a infligé "+ enemi1.getADMG() +" Ã  l'enemi");
        			Timer timer = (Timer) arg0.getSource();
        			timer.stop();
        			fin = true;
        		}
        			 }
        		};
        		timer = new javax.swing.Timer(2000,action);
        		timer.start();
        		
        		}
        
        		
        	}
        	final javax.swing.Timer timer2;
            if(perso1.getVIT() < enemi1.getVIT()) {
            	actionLog.updateLog("l'enemie attaque !");
            	enemi1.attaqueE(perso1);
            	actionLog.updateLog("l'enemie a infligé "+ enemi1.getADMG() +" Ã  l'enemi");
            	ActionListener action1 = new ActionListener (){
       			 public void actionPerformed(ActionEvent arg0) {
            	if (perso1.getPV() > 0) {
            		actionLog.updateLog(perso1.getNom()+" attaque !");
        			perso1.attaque(enemi1);
        			actionLog.updateLog(perso1.getNom()+" inflige"+ perso1.getADMG() +"DMG Ã  l'enemi");
        			Timer timer2 = (Timer) arg0.getSource();
        			timer2.stop();
        			fin = true;
        		}
        			 }
        		};
        		timer2 = new javax.swing.Timer(2000,action1);
        		timer2.start();
        		
            	}
            
        }
        if (playerAction.equals("objet")) {
        	if(perso1.getItem().equals("Potion verte")) {
        		perso1.setPV(perso1.getPV()+10);
        	}
        	if(perso1.getItem().equals("Potion rouge")) {
        		perso1.setPV(perso1.getPV()+50);
        	}
        	if(perso1.getItem().equals("Potion bleu")) {
        		perso1.setMNA(perso1.getMNA()+25);
        	}
        	if(perso1.getItem().equals("Antidote")) {
        		perso1.setEtat(0);
        	}
        	final javax.swing.Timer timer3;
        	ActionListener action = new ActionListener (){
   			 public void actionPerformed(ActionEvent arg0) {
   		 
   			actionLog.updateLog("l'enemie Attaque !");
   			enemi1.attaqueE(perso1);
   			actionLog.updateLog("l'enemie a infligé "+ enemi1.getADMG() +" Ã  l'enemi");
   			Timer timer3 = (Timer) arg0.getSource();
   			timer3.stop();
   			fin = true;
   		
   			 }
   		};
   		timer3 = new javax.swing.Timer(2000,action);
   		timer3.start();
   		
        }

       

	}
    	if(perso1.getPV() <= 0) {
			actionLog.updateLog("Game over");
		}
		if(enemi1.getPV() <= 0) {
			actionLog.updateLog("Gagné");
		}
    }

    public void setPlayerAction(String action){this.playerAction = action;}
}
