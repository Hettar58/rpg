public class Character extends Entity{
    private String item;
    public Character(int x, int y){
        super(x, y);
        MNA = 75;
        MNA_max = 75;
        PV = 100;
        PV_max = PV;
        MNA = 50;
        MNA_max = MNA;
        ATK = 10;
        MAGATK = 15;
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

    public void setItem(String item){
        this.item = item;
    }

    public String getItem(){
        return this.item;
    }
}
