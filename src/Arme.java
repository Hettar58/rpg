public class Arme extends Equipement {
    protected int givenEtat;
    protected int aleatoire;
    
    
    public Arme(){

        ATK=10;
        VIT=10;
        aleatoire = (int)(Math.random()*50+1);
        if (aleatoire <=5)
            this.setEffect();
    }

    public void setEffect() {
        aleatoire = (int) (Math.random() * 100 + 1);
        if (aleatoire >= 0 && aleatoire < 10) {
            this.givenEtat = 0;
        }
        if (aleatoire >= 10 && aleatoire < 20) {
            this.givenEtat = 1;
        }
        if (aleatoire >= 20 && aleatoire < 30) {
            this.givenEtat = 2;
        }
        if (aleatoire >= 30 && aleatoire < 40) {
            this.givenEtat = 3;
        }
        if (aleatoire >= 40 && aleatoire < 50) {
            this.givenEtat = 4;
        }
        if (aleatoire >= 50 && aleatoire < 60) {
            this.givenEtat = 5;
        }
        if (aleatoire >= 60 && aleatoire < 70) {
            this.givenEtat = 6;
        }
        if (aleatoire >= 70 && aleatoire < 80) {
            this.givenEtat = 7;
        }
        if (aleatoire >= 80 && aleatoire <= 100) {
            this.givenEtat = 8;
        }

    }

       
}

