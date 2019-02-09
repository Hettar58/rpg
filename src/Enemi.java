public class Enemi extends Entity{
    private int givenEXP;
    
    public Enemi (int x, int y, int niveauJoueur) {
        super(x, y);
        PV = 200;
        PV_max = 200;
        ATK = (int)(8*Math.sqrt((double)(niveauJoueur))+3*niveauJoueur);
        DEF = 10;
        VIT = 10;
        givenEXP = (int)(10+Math.sqrt((double)(6*niveauJoueur)));
        loadImage("src/res/enemi1_state1.png", 100);
        loadImage("src/res/enemi1_state2.png", 100);
        loadImage("src/res/enemi1_state3.png", 100);
        loadImage("src/res/enemi1_state2.png", 100);
        System.out.println("created enemi, PV:"+PV+" ATK:"+ATK+" DEF:"+DEF+" VIT:"+VIT+" givenEXP:"+givenEXP);
    }

    public int getGivenEXP(){return this.givenEXP;}
}
