import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Render extends JPanel implements ActionListener {
    private Timer timer;
    private int DELAY;
    private List<Character> persos;
    private List<Enemi> enemis;
    private Background bg;
    private Background bg2;

    public Render(){
        initRender();
    }

    private void initRender(){
        System.out.println("created render");
        bg = new Background(0, 0, "src/res/SF_MagicCircle.png");
        bg2 = new Background(0, 0, "src/res/SF_GothicRoom.png");
        persos = new ArrayList<>();
        enemis = new ArrayList<>();
        setBackground(Color.white);
        timer = new Timer(DELAY, this);
        timer.start();
    }

    private void draw(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(bg.getImage(), bg.getX(), bg.getY(), this);
        g2d.drawImage(bg2.getImage(), bg.getX(), bg.getY(), this);
        for (Character perso : persos){
            g2d.setColor(Color.GREEN);
            g2d.drawString((perso.getPV()+"/"+perso.getPV_max()), perso.getX()-5, perso.getY()-10);
            g2d.drawImage(perso.getImage(), perso.getX(), perso.getY(), this);
        }

        for(Enemi enemi : enemis){
            g2d.setColor(Color.GREEN);
            g2d.drawString((enemi.getPV()+"/"+enemi.getPV_max()), enemi.getX()-5, enemi.getY()-10);
            g2d.drawImage(enemi.getImage(), enemi.getX(), enemi.getY(), this);
        }
    }

    public void addEnemi(Enemi enemi){
        enemis.add(enemi);
    }

    public void addPersonnage(Character character){
        persos.add(character);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        repaint();
    }
}
