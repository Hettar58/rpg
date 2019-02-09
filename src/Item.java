import javax.swing.*;
import java.awt.*;

public class Item{
    protected Character joueur;
    protected String affectedStat; //statisitque afectée
    protected String method; //pourcentage ou valeur flat
    protected int value; //valeur de la modification.
    protected String name;
    protected Image img;
    public Item(String name, String dir, Character joueur, String affectedStat, String method, int value) {
        this.name = name;
        loadImage(dir);
        this.joueur = joueur;
        this.affectedStat = affectedStat;
        this.method = method;
        this.value = value;
    }
    public void loadImage(String dir) {
        ImageIcon ii = new ImageIcon(dir);
        this.img = ii.getImage();
    }
    public void use(){
        if (this.affectedStat.equals("PV")){
            if (this.method.equals("%")){
                joueur.setPV((int)(joueur.getPV()+(100*value/joueur.getPV())));
            }
            else{
                joueur.setPV(joueur.getPV()+value);
            }
        }
        if (this.affectedStat.equals("MNA")){
            if (this.method.equals("%")){
                joueur.setMNA((int)(joueur.getMNA()+(100*value/joueur.getMNA())));
            }
            else{
                joueur.setMNA(joueur.getMNA()+value);
            }
        }
        if (this.affectedStat.equals("VIT")){
            if (this.method.equals("%")){
                joueur.setVIT((int)(joueur.getVIT()+(100*value/joueur.getPV())));
            }
            else{
                joueur.setVIT(joueur.getVIT()+value);
            }
        }if (this.affectedStat.equals("ATK")){
            if (this.method.equals("%")){
                joueur.setATK((int)(joueur.getATK()+(100*value/joueur.getATK())));
            }
            else{
                joueur.setATK(joueur.getATK()+value);
            }
        }if (this.affectedStat.equals("INT")){
            if (this.method.equals("%")){
                joueur.setINT((int)(joueur.getINT()+(100*value/joueur.getINT())));
            }
            else{
                joueur.setINT(joueur.getINT()+value);
            }
        }
        if (this.affectedStat.equals("DEF")){
            if (this.method.equals("%")){
                joueur.setDEF((int)(joueur.getDEF()+(100*value/joueur.getDEF())));
            }
            else{
                joueur.setDEF(joueur.getDEF()+value);
            }
        }
        if (this.affectedStat.equals("STM")){
            if (this.method.equals("%")){
                joueur.setSTM((int)(joueur.getSTM()+(100*value/joueur.getSTM())));
            }
            else{
                joueur.setSTM(joueur.getSTM()+value);
            }
        }
        if (this.affectedStat.equals("MAGDEF")){
            if (this.method.equals("%")){
                joueur.setMAGDEF((int)(joueur.getMAGDEF()+(100*value/joueur.getMAGDEF())));
            }
            else{
                joueur.setMAGDEF(joueur.getMAGDEF()+value);
            }
        }
    }

    public void setAffectedStat(String newStat){this.affectedStat = newStat;}
    public String getAffectedStat(){return this.affectedStat;}
    public void setMethod(String newMethod){this.method = newMethod;}
    public String getMethod(){return this.method;}
    public void setValue(int newValue){this.value = value;}
    public int getValue(){return this.value;}
    public void setName(String name){this.name = name;}
    public String getName(){return this.name;}
}
