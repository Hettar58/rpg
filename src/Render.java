import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Render extends JPanel implements ActionListener {
    private Timer timer;
    private int DELAY;

    public Render(){
        initRender();
    }

    private void initRender(){
        timer = new Timer(DELAY, this);
        timer.start();
    }

    private void draw(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d
    }



    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public void actionPerformed(ActionEvent e){

    }
}
