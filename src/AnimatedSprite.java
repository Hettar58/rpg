import java.awt.*;

public class AnimatedSprite extends Sprite {
    protected Animation anim;

    public AnimatedSprite(int x, int y){
        super(x, y);
        this.anim = new Animation();
    }

    @Override
    public Image getImage(){
        return this.anim.getImage();
    }

    public void loadImage(String dir, int duration){
        this.anim.addFrame(dir, duration);
    }

    public void updateAnim(long elapsedTime) {
        anim.update(elapsedTime);
    }
}
