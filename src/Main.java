import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Main extends JFrame implements MouseListener {
    private Render render;
    private LogPanel actionLog;
    private ControlPanel fightUI;
    private Enemi enemi1;
    private Character perso1;
    private String playerAction;
    private String cpuAction = "attaque";
    private boolean fin = true;
    private int state=0;
    private int state2=0;
    
    

    public Main(){
        initUI();
    }
    private void initUI(){
    	perso1 = new Character(280, 250);
        enemi1 = new Enemi(480, 250);
        fightUI = new ControlPanel(0.3f, 1f, perso1, enemi1, this);
        actionLog = new LogPanel(0.5f, 1.0f);
        render = new Render();
        render.setLayout(null);
        add(render);

        render.addEntity(perso1);
        render.addEntity(enemi1);
        setTitle("RPG");
        setSize(800, 620);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        fightUI.setPersonnage(perso1);
        render.add(fightUI);
        render.add(actionLog);
        render.addMouseListener(this);
    }

    public static void main(String[] args){
        System.setProperty("file.encoding", "UTF-8");
        EventQueue.invokeLater(() -> {
            Main app = new Main();
            app.setVisible(true);
        });
    }

    public void mouseClicked(MouseEvent e){
        System.out.println("clic");
        if(fin == false) {
        	int a,b;
        	a = getstate();
        	b = getstate2();
        	System.out.println(a+" "+b);
        	fin = true;
            tour(a,b);
        }
    }
    public void tour(int sta,int sta2){

        if (fin){
        	fin =false;
        	fightUI.setVisible(false);
        	
            if (perso1.getPV() > 0 && enemi1.getPV() > 0){
                
                    if (playerAction.equals("attaque")){
                    	if(sta == 0 && sta2 == 0) {
                    		actionLog.updateLog(perso1.getNom()+" attaque !");
                    		perso1.attaque(enemi1);
                    		setstate(0,1);
                    	}
                        if(sta == 0 && sta2 == 1) { 
                        	
                        	setstate(1,0); // passage au tour de l'ennemie.
                        	actionLog.updateLog(perso1.getNom()+" inflige "+ perso1.getADMG() +" DMG � l'enemi");
                        }
                        
                        
                    }
                    
                    if (playerAction.equals("objet")) {
                        if(perso1.getItem().equals("Potion verte")) {
                            perso1.setPV(perso1.getPV()+20);
                            actionLog.updateLog("Vous avez r�cup�r� 20 PDV");
                            
                        }
                        if(perso1.getItem().equals("Potion rouge")) {
                            perso1.setPV(perso1.getPV()+50);
                            actionLog.updateLog("Vous avez r�cup�r� 50 PDV");                          
                        }
                        if(perso1.getItem().equals("Potion Bleue")) {
                            perso1.setMNA(perso1.getMNA()+25);
                            actionLog.updateLog("Vous avez r�cup�r� 20 MANA");
                            
                        }
                        if(perso1.getItem().equals("Antidote")) {
                            perso1.setEtat(0);
                            actionLog.updateLog("Vous etes revenu a l'etat normal");
                        }
                        setPlayerAction("");
                        perso1.setItem("");
                        setstate(1,0);
                        
                    }
                    if (playerAction.equals("magie")) {
                    	Magie magie = new Magie(perso1,enemi1);
                        setstate(1,0);
                        perso1.setItem("");
                        setPlayerAction("");
                    }

                }
                if (enemi1.getPV() > 0 && perso1.getPV() > 0 ){
                	
                	
                    if (cpuAction.equals("attaque")){
                    	if(sta == 1 && sta2 == 0) {
                    		if(enemi1.getEtat() == 2) {
                        		actionLog.updateLog("L'ennemie est gel�");
                        		setstate(2,0);
                        		enemi1.touretat++;
                        	}
                        	if(enemi1.getEtat() == 3) {
                        		int aleatoire = (int)(Math.random()*100);
                        		if(aleatoire < 30) {
                        			actionLog.updateLog("L'ennemie est paralys�");
                        			setstate(2,0);
                        		}
                        		enemi1.touretat++;
                        	}
                        	if(enemi1.getEtat() < 2) {
                    		actionLog.updateLog("l'enemie attaque !");
                        	enemi1.attaque(perso1);
                        	setstate(1,1);
                        	}
                    	}
                        if(sta == 1 && sta2 == 1) {
                        	actionLog.updateLog("l'enemie a inflig� "+ enemi1.getADMG() +" à l'enemi");
                        	setstate(1,2);                        	
                        }
                        if(sta == 1 && sta2 == 2) {
                    		if(enemi1.getEtat() == 1) {
                    			enemi1.setPV(enemi1.getPV()-12);
                    			actionLog.updateLog("L'ennemie Brule");
                    			setstate(2,0);
                    			enemi1.touretat++;                    			
                    		}
                    		else setstate(2,0);
                        
                        }
                    }
                    
                    
                }
                if(perso1.getPV() <= 0) {
            		setstate(4,0);
            		if(sta == 4 && sta2 == 0) {
            			actionLog.updateLog("Game over");
            			setstate(2,1);
            		}
                }
                if(enemi1.getPV() <= 0) {
                	setstate(3,2);
                	if (sta == 3 && sta2 == 2) {
                		actionLog.updateLog("Gagn�");
                		setstate(3,1);
                	}
                	if (sta == 3 && sta2 == 1) {
                		actionLog.updateLog("vous avez gagn� "+enemi1.getEXP()+" Exp");
                		setstate(3,0);
                	}
                		if(perso1.niveau < perso1.niveausup) {
                			if(sta == 3 && sta2 == 0) {
                			actionLog.updateLog("Vous �tes mont� au niveau "+ perso1.niveausup);
                			perso1.niveau = perso1.niveausup;
                			}
                		}
                		setstate(2,1);
                	}
                		
                
                if (sta == 2 && sta2 == 0){
                	if(enemi1.touretat >= 3)
                		enemi1.setEtat(0);
                	fin = true;
                    actionLog.updateLog("C'est � votre tour");
                    fightUI.refresh();
                    fightUI.setVisible(true);
                    setstate(0,0);
                    }
                if (sta == 2 && sta2 == 1) {
                	if(enemi1.touretat >= 3)
                		enemi1.setEtat(0);
                	fin = true;
                    setstate(0,0);
                }
                
            
        }
    }
    

    public void setPlayerAction(String action){this.playerAction = action;}
    public void setCpuAction(String action){this.cpuAction = action;}
    public void setstate(int state,int state2) {
    	this.state = state;
    	this.state2 = state2;
    }
    public int getstate() {
    	return state;
    }
    public int getstate2() {
    	return state2;
    }
    public boolean getfin() {return fin;}
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public Character getperso() {
    	return perso1;
    }
}
