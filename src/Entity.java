import javax.swing.*;

public class Entity extends Sprite {

    private int PV;
    private int PV_max;
    private int EXP;
    private int MNA;
    private int ATK;
    private int VIT;
    private int DEF;
    private int STM;
    private int LCK;
    private int etat;
    private int delay;
    private int niveau;
    private String nom;

    public entite(int x, int y) {
        PV = 100;
        mna = 75;
        STM = 75;
        ATK = 10;
        DEF = 10;
        etat = 0;
        LCK = 8;
        EXP = 0;
        niveau = 1;
        nom = "Nom du personnage";
        loadImage(String dir);
        getImageDimensions();
    }
    public void setPV(int nPV){
        this.PV = nPV;
    }
    public int getPV(){
        return this.PV;
    }
    public void setSTM(int nSTM){
        this.STM = nSTM;
    }
    public int getSTM(){
        return this.STM;
    }
    public void setATK(int nATK){
        this.ATK = nATK;
    }
    public int getATK(){
        return this.ATK;
    }
    public void setDEF(int nDEF){
        this.DEF = nDEF;
    }
    public int getDEF(){
        return this.DEF;
    }
    public void setVIT(int nVIT){
        this.VIT = nVIT;
    }
    public int getVIT(){
        return this.VIT;
    }
    public void setMNA(int nMNA){
        this.MNA = nMNA;
    }
    public int getMNA(){
        return this.MNA;
    }
    public void setLCK(int nLCK){
        this.LCK = nLCK;
    }
    public int getLCK(){
        return this.LCK;
    }
    public void setEtat(int nEtat){
        this.Etat = nEtat;
    }
    public void getEtat(){
        return this.Etat;
    }
    public void setEXP(int nEXP){
        this.EXP = nEXP;
    }
    public int getEXP(){
        return this.EXP;
    }
    }

