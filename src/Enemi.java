public class Enemi extends Sprite {
    private int PV;
    private int lootExp;
    private int ATK;
    private int DEF;

    public Enemi (int x, int y){
        super(x, y);
        PV = 200;
        ATK = 5;
        DEF = 5;
        loadImage("src/res/enemi1.png");
        getImageDimensions();
    }

    public void attaque(Character character){
        int defense = character.getDEF();
        character.setDMG(ATK/(100/(100+defense)));
    }

    public void setDMG(int DMG){
        PV = PV - DMG;
    }

    public int getDEF(){return DEF;}

}
