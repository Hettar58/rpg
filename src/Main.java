import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    public Main(){
        initUI();
    }
    private void initUI(){
        Render render = new Render();
        setTitle("RPG");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            Main app = new Main();
            app.setVisible(true);
        });
    }
}
