public class Magie extends AnimatedSprite{
	private LogPanel actionLog = new LogPanel(0.5f, 1.0f);
	
	public Magie (Character perso1, Enemi enemi1) {
		super(enemi1.getX(),enemi1.getY());
		
		int aleatoire = (int)(Math.random()*100);
        if(perso1.getmagie().equals("feu")) {
            perso1.setMNA(perso1.getMNA()-20);
            perso1.magattack(enemi1,10);
            actionLog.updateLog(perso1.getNom()+" attaque feu !");
            if (aleatoire < 30) {
            	enemi1.setEtat(1);
            	enemi1.touretat=0;
            }
        }
        if(perso1.getmagie().equals("glace")) {
            perso1.setMNA(perso1.getMNA()-15);
            perso1.magattack(enemi1,7);
            actionLog.updateLog(perso1.getNom()+" attaque Glace !");
            if (aleatoire < 5) {
            	enemi1.setEtat(2);
            	enemi1.touretat=0;
            }
            for(int i = 1; i <= 31;i++) {
        		String e = "src/res/GlaceMagie"+i+".jpg";
        		enemi1.loadImage(e,50);
            }
            enemi1.loadImage(null);
        }
        if(perso1.getmagie().equals("electriciter")) {
            perso1.setMNA(perso1.getMNA()-25);
            perso1.magattack(enemi1,10);
            actionLog.updateLog(perso1.getNom()+" attaque electrique !");
            if (aleatoire < 20) {
            	enemi1.setEtat(3);
            	enemi1.touretat=0;
            }
        }
        if(perso1.getmagie().equals("terre")) {
        	actionLog.updateLog(perso1.getNom()+" attaque terre !");
        	perso1.setMNA(perso1.getMNA()-15);
            perso1.magattack(enemi1,9);
        }
        
        
	}
	

}
