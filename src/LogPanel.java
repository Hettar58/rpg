import javax.swing.*;
import java.awt.*;

public class LogPanel extends TransparentPane {
    private JLabel output;

    public LogPanel(float panelOpacity, float childrenOpacity){
        super(panelOpacity, childrenOpacity);
        output = new JLabel("Le combat commence !");
        output.setBounds(0, 0, 800, 50);
        output.setForeground(Color.BLUE);
        this.add(output);
        this.setBounds(100, 0, 600, 50);
    }

    public void updateLog(String s){
        output.setText(s);
    }
}
