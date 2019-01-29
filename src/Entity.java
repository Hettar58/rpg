import javax.swing.*;

public class Entity extends AnimatedSprite {

    protected int PV;
    protected int PV_max;
    protected int EXP;
    protected int MNA;
    protected int ATK;
    protected int VIT;
    protected int DEF;
    protected int STM;
    protected int LCK;
    protected int etat;
    protected int delay;
    protected int niveau;
    protected String nom;

    public Entity(int x, int y) {
        super(x, y);
        PV = 100;
        MNA = 75;
        STM = 75;
        ATK = 10;
        DEF = 10;
        etat = 0;
        LCK = 8;
        EXP = 0;
        niveau = 1;
        nom = "Nom du personnage";
    }

    public void attaque(Enemi enemi){
        int defense = enemi.getDEF();
        enemi.setDMG(ATK/(100/(50+defense)));
    }

    public void setDMG(int DMG){
        PV = PV - DMG;
    }

    public void setPV(int nPV){
        this.PV = nPV;
    }
    public int getPV(){
        return this.PV;
    }
    public void setPV_max(int nPV_max){this.PV_max = nPV_max;}
    public int getPV_max(){return this.PV_max;}
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
        this.etat = nEtat;
    }
    public int getEtat(){
        return this.etat;
    }
    public void setEXP(int nEXP){
        this.EXP = nEXP;
    }
    public int getEXP(){
        return this.EXP;
    }
    public void setNom(String nNom){this.nom = nNom;}
    public String getNom(){return this.nom;}
    }

