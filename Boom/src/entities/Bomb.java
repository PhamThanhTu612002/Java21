package entities;

import javax.swing.*;
import java.awt.*;

public class Bomb extends Actor{
    protected int size, timeLine;

    public Bomb(int x, int y, int size, int timeLine) {
        x = (x / 45) * 45;
        y = (y / 45) * 45;
        this.x = x;
        this.y = y;
        this.orient = 0;
        this.type = Actor.BOMB;
        this.size = size;
        this.timeLine = timeLine;
        img = new ImageIcon(getClass().getResource("/images/bomb.gif")).getImage();
        this.width = img.getWidth(null);
        this.height = img.getHeight(null);
    }
    @Override
    public void drawActor(Graphics2D graphics2D){
        super.drawActor(graphics2D);
        graphics2D.drawImage(img,x,y,null);
    }

    public int getSize() {
        return size;
    }
    public boolean setRun(Bomber bomber){
        Rectangle rec2 = new Rectangle(x,y,width,height);
        Rectangle rec3 = new Rectangle(bomber.getX(),bomber.getY(),bomber.getWidth(),bomber.getHeight());
        return rec2.intersects(rec3);
    }
    public boolean isImpact(int xNewBomb, int yNewBomb){
        Rectangle rec1 = new Rectangle(x,y,45,45);
        Rectangle rec2 = new Rectangle(xNewBomb,yNewBomb,45,45);
        return rec1.intersects(rec2);
    }
    public int isImpactBombVsActor(Actor actor){
        if (actor.getRunBomb() == Bomber.ALLOW_RUN){
            return 0;
        }
        Rectangle rec1 = new Rectangle(x,y,45,45);
        Rectangle rec2 = new Rectangle(actor.getX(),actor.getY(),actor.getWidth(),getHeight());
        if (rec1.intersects(rec2)){
            if (actor.getType() != Monster.Mon){
                return 2;
            }
        return 1;
        }
        return 0;
    }
    public void setSize(int size) {
        this.size = size;
    }

    public int getTimeLine() {
        return timeLine;
    }

    public void setTimeLine(int timeLine) {
        this.timeLine = timeLine;
    }
    public void deadlineBomb() {
        this.timeLine--;
    }
}
