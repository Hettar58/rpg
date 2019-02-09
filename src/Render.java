import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Render extends JPanel implements ActionListener{
    private Timer timer;
    private int DELAY;
    private List<Entity> entites;
    private Background bg;
    private Background bg2;
    private long startTime;
    private long currTime;
    public Render(){
        initRender();
    }

    private void initRender(){
        System.out.println("created render");
        bg = new Background(0, 0, "src/res/SF_MagicCircle.png");
        bg2 = new Background(0, 0, "src/res/SF_GothicRoom.png");
        entites = new ArrayList<>();
        setBackground(Color.white);
        DELAY = 20;
        timer = new Timer(DELAY, this);
        timer.start();
    }

    private synchronized void draw(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(bg.getImage(), bg.getX(), bg.getY(), this);
        g2d.drawImage(bg2.getImage(), bg.getX(), bg.getY(), this);
        for (Entity entite : entites){
            g2d.setColor(entite.getStatus());
            g2d.drawString((entite.getPV()+"/"+entite.getPV_max()), entite.getX()-5, entite.getY()-10);
            g2d.drawImage(entite.getImage(), entite.getX(), entite.getY(), this);
        }
    }

    public void addEntity(Entity entite){
        entites.add(entite);
    }

    @Override
    public synchronized void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
        Toolkit.getDefaultToolkit().sync();
    }
    @Override
    public synchronized void actionPerformed(ActionEvent e){
        long elapsedTime = System.currentTimeMillis() - currTime;
        currTime += elapsedTime;
        for(Entity entite : entites){
            entite.updateAnim(elapsedTime);
        }
        repaint();
    }
}
