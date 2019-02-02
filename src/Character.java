public class Character extends Entity{
    public Character(int x, int y){
        super(x, y);
        PV = 100;
        PV_max = 100;
        ATK = 10;
        DEF = 10;
        EXP = 0;
        niveau = 0;
        VIT = 10;
        nom = "Joueur 1";
        loadImage("src/res/perso1_state1.png", 100);
        loadImage("src/res/perso1_state2.png", 100);
        loadImage("src/res/perso1_state1.png", 100);
        loadImage("src/res/perso1_state3.png", 100);
    }
}
