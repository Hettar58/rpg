import javax.swing.*;

public class Entity extends AnimatedSprite {

	protected int ADMG;
    protected int PV;
    protected int PV_max;
    protected int EXP;
    protected int MNA;
    protected int MNA_max;
    protected int ATK;
    protected int MAGATK;
    protected int VIT;
    protected int DEF;
    protected int MAGDEF;
    protected int STM;
    protected int LCK;
    protected int etat;
    protected int delay;
    protected int niveau;
    protected int niveausup;
    protected String nom;

    public Entity(int x, int y) {
        super(x, y);
        ADMG = 0;
        PV = 100;
        MNA = 75;
        STM = 75;
        ATK = 10;
        DEF = 10;
        etat = 0;
        LCK = 8;
        EXP = 0;
        niveau = 1;
        niveausup=1;
        nom = "Nom du personnage";
    }

    public void attaque(Entity enemi){
    	int Crit = (int)(Math.random()*100);
    	if(Crit > 4) {
    		int defense = enemi.getDEF();
    		enemi.setDMG(ATK/(100/(50+defense)));
    		ADMG = (ATK/(100/(50+defense)));
    	}
    	if(Crit <= 4) {
            int defense = enemi.getDEF();
            enemi.setDMG(ATK+5/(100/(50+defense)));
            ADMG = (ATK/(100/(50+defense)));
        	}
    }
    public void magattack(Entity enemi,int MATK){
    	int Crit = (int)(Math.random()*100);
    	if(Crit > 4) {
    		int defense = enemi.getDEF();
    		enemi.setDMG((MAGATK+MATK)/(100/(50+defense)));
    		ADMG = ((MAGATK+MATK)/(100/(50+defense)));
    	}
    	if(Crit <= 4) {
            int defense = enemi.getDEF();
            enemi.setDMG((MAGATK+5+MATK)/(100/(50+defense)));
            ADMG = ((MAGATK+MATK)/(100/(50+defense)));
        	}
    }
    
    public int getADMG() {
    	return ADMG;
    }
    public void setDMG(int DMG){
    	ADMG = DMG;
        if (PV - DMG < 0){
            PV = 0;
        }
        else{
            PV = PV - DMG;
        }
    }
    public void setMAGDMG(int DMG){
    	ADMG = DMG;
        if (PV - DMG < 0){
            PV = 0;
        }
        else{
            PV = PV - DMG;
        }
    }

    public void setPV(int nPV){
        if (nPV > this.PV_max){
            this.PV = this.PV_max;
        }
        else{
            this.PV = nPV;
        }

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
    public void setMNA_max(int MNA){this.MNA_max = MNA;}
    public int getMNA_max() {return this.MNA_max;}
    public void setLCK(int nLCK){
        this.LCK = nLCK;
    }
    public int getLCK(){
        return this.LCK;
    }
    public void setEtat(int nEtat){
        this.etat=nEtat;
    }
    public int getEtat(){
        return this.etat;
    }

    public void setEXP(int nEXP){
        this.EXP = nEXP;
        if(this.EXP >= 200) {
        	niveausup++;
        }
    }
    public int getEXP(){
        return this.EXP;
    }
    public void setNom(String nNom){this.nom = nNom;}
    public String getNom(){return this.nom;}
	


}