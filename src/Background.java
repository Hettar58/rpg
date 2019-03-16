import javax.swing.Icon;

public class Background extends Sprite{
    public Background(int x, int y, String dir){
        super(x, y);
        loadImage(dir);
        getImageDimensions();
    }
}
