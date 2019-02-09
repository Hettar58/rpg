public class Character extends Entity{
    protected int niveau;
    protected int niveausup;
    private int levelPass;
    private int EXP;
    private Inventory inv;
    public Character(int x, int y){
        super(x, y);
        PV = 100;
        PV_max = PV;
        MNA = 50;
        MNA_max = MNA;
        ATK = 10;
        INT = 15;
        DEF = 10;
        EXP = 0;
        niveau = 1;
        niveausup = 1;
        levelPass = (int)(Math.sqrt((double)(100*niveau)) + 1.5*niveau+Math.pow(niveau, 2.0));
        VIT = 10;
        nom = "Joueur 1";
        loadImage("src/res/perso1_state1.png", 100);
        loadImage("src/res/perso1_state2.png", 100);
        loadImage("src/res/perso1_state1.png", 100);
        loadImage("src/res/perso1_state3.png", 100);
        System.out.println("created character, PV:"+PV+" MNA:"+MNA+" ATK:"+ATK+" DEF:"+DEF+" EXP:"+EXP+" LVL:"+niveau+" levelPass:"+levelPass+" VIT:"+VIT+" nom:"+nom);
    }

    public void addItem(Item item){
        inv.addItem(item, 1);
    }

    public Item getItem(String item){
        return inv.getItem(item);
    }

    public void setEXP(int nEXP){
        this.EXP = nEXP;
        if(this.EXP >= levelPass) {
            niveausup++;
            levelPass = (int)(Math.sqrt((double)(100*niveau)) + 1.5*niveau+Math.pow(niveau, 2.0));
        }
    }
    public int getEXP(){
        return this.EXP;
    }
    public void setNiveau(int niveau){this.niveau = niveau;}
    public int getNiveau(){return this.niveau;}
}
