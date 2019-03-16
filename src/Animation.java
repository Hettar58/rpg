import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Animation{
    private ArrayList frames;
    private int currFrameIndex;
    private long animTime;
    private long totalDuration;


    public Animation(){
        frames = new ArrayList();
        totalDuration = 0;
        start();
    }
    
    public Animation(String Magie,Entity Coordonner) {
    	String e = "";
    	frames = new ArrayList();
    	totalDuration = 0;
    	for(int i = 0; i <= 30;i++) {
    		e = "src/res/"+Magie+""+i+".png";
    		addFrame(e,totalDuration);   		
    	}
    	
    }

    public synchronized void addFrame(String dir, long duration){
        totalDuration += duration;
        ImageIcon ii = new ImageIcon(dir);
        Image image = ii.getImage();
        frames.add(new AnimFrame(image, totalDuration));
    }

    public synchronized void start(){
        animTime = 0;
        currFrameIndex = 0;
    }

    public synchronized void update(long elapsedTime){
        if (frames.size() > 1){
            if(currFrameIndex != frames.size() ) {
                animTime += elapsedTime;
                if (animTime >= totalDuration) {
                    animTime = animTime % totalDuration;
                    currFrameIndex = 0;
                }
                while (animTime > getFrame(currFrameIndex).endTime) {
                    currFrameIndex++;
                }
            }
        }
    }
    public synchronized Image getImage() {
        if (frames.size() == 0) {
            return null;
        } else {
            return getFrame(currFrameIndex).image;
        }
    }

    private AnimFrame getFrame(int i) {
        return (AnimFrame) frames.get(i);
    }

    private class AnimFrame {

        Image image;

        long endTime;

        public AnimFrame(Image image, long endTime) {
            this.image = image;
            this.endTime = endTime;
        }
    }
}