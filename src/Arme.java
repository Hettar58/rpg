public class Arme extends Equipement {

    protected int aleatoire;

    public Arme(){
        ATK=6666;
        VIT=20;
        aleatoire = (int)(Math.random()*50+1);
        if (aleatoire <=5)
            int arme = geteffect;
    }

    public void seteffect(){
        aleatoire = (int)(Math.random()*100+1);
        if (aleatoire>=0 && aleatoire<10);
            int arme = etat(0);
        if (aleatoire >=10 && aleatoire<20);
        int arme = etat(1);
        if (aleatoire >=20 && aleatoire<30);
        int arme = etat(2);
        if (aleatoire >=30 && aleatoire<40);
        int arme = etat(3);
        if (aleatoire >=40 && aleatoire<50);
        int arme = etat(4);
        if (aleatoire >=50 && aleatoire<60);
        int arme = etat(5);
        if (aleatoire =>60 && aleatoire<70);
        int arme = etat(6);
        if (aleatoire >=70 && aleatoire<80);
        int arme = etat(7);
        if (aleatoire >=80 && aleatoire<=100);
        int arme = etat(8);

    }
    public int geteffect(){
            return aleatoire;
    }
}

