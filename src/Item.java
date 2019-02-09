import javax.swing.*;
import java.awt.*;

public class Item {
    protected String name;
    protected Image img;

    public Item(String name, String dir){
        this.name = name;
        loadImage(dir);
    }

    public void loadImage(String dir) {
        ImageIcon ii = new ImageIcon(dir);
        this.img = ii.getImage();
    }
}
