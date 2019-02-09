public class Equipement {

    protected int PV;
    protected int ATK;
    protected int MNA;
    protected int DEF;
    protected int MAGATK;
    protected int STM;
    protected int LCK;
    protected int etat;
    protected int VIT;
    protected String nom;

    public Equipement(){
    ATK=0;
    DEF=0;
    PV=0;
    MNA=0;
    MAGATK=0;
    LCK=1;
    STM=0;
    VIT=0;
    nom="Nom de l'arme ou armure"
    }

    public setPV(int nPV){this.PV=nPV;}
    public int getPV(){
        return this.PV;
    }
    public void setSTM(int nSTM){ this.STM = nSTM; }
    public int getSTM(){ return this.STM; }
    public void setATK(int nATK){ this.ATK = nATK; }
    public int getATK(){ return this.ATK; }
    public void setDEF(int nDEF){ this.DEF = nDEF; }
    public int getDEF(){ return this.DEF; }
    public void setVIT(int nVIT){ this.VIT = nVIT; }
    public int getVIT(){ return this.VIT; }
    public void setMNA(int nMNA){ this.MNA = nMNA; }
    public int getMNA(){ return this.MNA; }
    public void setLCK(int nLCK){ this.LCK = nLCK; }
    public int getLCK(){ return this.LCK; }
    public void setEtat(int nEtat){ this.etat=nEtat; }
    public int getEtat(){ return this.etat;}
}
