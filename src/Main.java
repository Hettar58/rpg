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
    private boolean fin;
    private int state;

    public Main(){
        initUI();
    }
    private void initUI(){
        fin = true;
        perso1 = new Character(280, 250);
        enemi1 = new Enemi(480, 250);
        fightUI = new ControlPanel(0.3f, 1f, perso1, enemi1, this);
        actionLog = new LogPanel(0.3f, 1.0f);
        render = new Render();
        render.setLayout(null);
        add(render);

        render.addEntity(perso1);
        render.addEntity(enemi1);
        setTitle("RPG");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        fightUI.setPersonnage(perso1);
        render.add(fightUI);
        render.add(actionLog);
        fightUI.addMouseListener(this);
    }

    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            Main app = new Main();
            app.setVisible(true);
        });
    }

    public void mouseClicked(MouseEvent e){
        System.out.println("clic");
        if (fin == false){

            if(state <= 2){
                state++;
                System.out.println(state);
            }
            tour(state);
        }
    }
    public void tour(int state){
        System.out.println("f");
        if (fin == true){
            fin = false;
        }
        if (fin == false){
            if(perso1.getPV() <= 0) {
                actionLog.updateLog("Game over");
            }
            if(enemi1.getPV() <= 0) {
                actionLog.updateLog("Gagné");
            }
            if (perso1.getPV() > 0 && enemi1.getPV() > 0){
                if (state == 0){ //ACTION JOUEUR
                    if (playerAction.equals("attaque")){
                        actionLog.updateLog(perso1.getNom()+" attaque !");
                        perso1.attaque(enemi1);
                        System.out.println("perso attaque");
                        actionLog.updateLog(perso1.getNom()+" inflige"+ perso1.getADMG() +"DMG Ã  l'enemi");
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
                    }

                }
                if (state == 1){
                    if (cpuAction.equals("attaque")){
                        actionLog.updateLog("l'enemie attaque !");
                        enemi1.attaque(perso1);
                        System.out.println("enemi attaque");
                        actionLog.updateLog("l'enemie a infligé "+ enemi1.getADMG() +" Ã  l'enemi");
                    }
                }
                if (state == 2){
                    state = 0;
                    fin = true;
                }
            }
        }
    }

    public void setPlayerAction(String action){this.playerAction = action;}
    public void setCpuAction(String action){this.cpuAction = action;}
    public void setFin(boolean fin){this.fin = fin;}
    public void mousePressed(MouseEvent e){ }
    public void mouseReleased(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
}
