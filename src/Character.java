import java.awt.*;

public class Character extends Sprite {
    private String nom;
    private int niveau;
    private int levelPass;
    //stats
    private int EXP; //experience
    private int PV; //points de vie
    private int PV_max;
    private int VIT; //vitesse
    private int ATK; //attaque
    private int INT; //intelligence
    private int DEF; //defense
    private int MNA; //mana
    private int STM; //endurance
    private int LCK; // chance
    private int etat; //0 = normal, 1 = poison, 2 = paralysie, ...
    private int delay; //si jeu en temps réel, délai avant de pouvoir faire une action

    public Character(int x, int y){
        super(x, y);
        PV = 100;
        PV_max = 100;
        ATK = 10;
        DEF = 10;
        EXP = 0;
        niveau = 1;
        nom = "Character générique";
        loadImage("src/res/perso1.png");
        getImageDimensions();
    }

    public void attaque(Enemi enemi){
        int defense = enemi.getDEF();
        enemi.setDMG(ATK/(100/(100+defense)));
    }

    public void setDMG(int DMG){
        PV = PV - DMG;
    }
    public int getDEF(){return DEF;}
    public int getPV(){return PV;}
    public int getPV_max(){return PV_max;}
}
