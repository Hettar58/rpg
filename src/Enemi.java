public class Enemi extends Sprite{
    private int PV;
    private int PV_max;
    private int lootExp;
    private int ATK;
    private int DEF;
    private Animation anim;

    public Enemi (int x, int y){
        super(x, y);
        PV = 200;
        PV_max = 200;
        ATK = 5;
        DEF = 10;
        anim = new Animation();
        loadImage("src/res/enemi1.png");

    }

    public void attaque(Character character){
        int defense = character.getDEF();
        character.setDMG(ATK/(100/(100+defense)));
    }

    public void setDMG(int DMG){
        PV = PV - DMG;

    }

    public int getDEF(){return DEF;}
    public int getPV(){return PV;}
    public int getPV_max(){return PV_max;}

}
