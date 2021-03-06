import javax.swing.*;
import java.awt.*;

public class Sprite {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected boolean visible;
    protected Image image;

    public Sprite(int x, int y){
        this.x = x;
        this.y = y;
        this.visible = true;
    }

    protected void getImageDimensions(){
        this.width = this.image.getWidth(null);
        this.height = this.image.getHeight(null);
    }

    protected Image getImage(){
        return this.image;
    }

    protected void loadImage(String dir){
        ImageIcon ii = new ImageIcon(dir);
        this.image = ii.getImage();
    }

    public int getX(){return x;}
    public void setX(int x){ this.x = x;}
    public int getY(){return y;}
    public void setY(int y){this.y = y;}
    public boolean isVisible(){return visible;}
    public Rectangle getBounds(){return new Rectangle(x, y, width, height);}
    public int getWidth(){return width;}
    public int getHeight(){return height;}
}
