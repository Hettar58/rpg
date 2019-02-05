public class Enemi extends Entity{
    public Enemi (int x, int y) {
        super(x, y);
        PV = 200;
        PV_max = 200;
        ATK = 10;
        DEF = 10;
        VIT = 10;
        EXP = 200;
        loadImage("src/res/enemi1_state1.png", 100);
        loadImage("src/res/enemi1_state2.png", 100);
        loadImage("src/res/enemi1_state3.png", 100);
        loadImage("src/res/enemi1_state2.png", 100);
    }
}
