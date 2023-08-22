package entities;

import service.entities.DrawBoxImpl;
import service.entities.IDraw;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Box {
    IDraw iDraw;
    public static int ALLROW_BANG = 0;
    public static int DISALLROW_BANG = 1;
    public int x;
    public int y;
    protected int width;
    protected int height;
    protected int type;
    public Image img;

    public Box(int x, int y, int type, String image) {
        super();
        this.x = x;
        this.y = y;
        this.type = type;
        this.img = new ImageIcon(getClass().getResource(image)).getImage();
        this.width = img.getWidth(null);
        this.height = img.getHeight(null);
    }
    public void drawBox(Graphics2D graphics2D){
        iDraw = new DrawBoxImpl();
        iDraw.draw(this, graphics2D);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getType() {
        return type;
    }
    public int isImpactBoxVsActor(Actor actor){
        Rectangle rec1 = new Rectangle(x,y,width,height);
        Rectangle rec2 = new Rectangle(actor.getX(), actor.getY(),actor.getWidth(),actor.getHeight());
        if (!rec1.intersects(rec2)){
            if (rec1.getHeight() == 1 && (actor.getOrient() == Actor.UP || actor.getOrient() == Actor.DOWN)){
                if (actor.getX() == rec1.getX()){
                    return (int) rec1.getHeight();
                }else {
                    return (int) -rec1.getHeight();
                }
            }
        }else {
            if (actor.getY() == rec1.getY()) {
                return (int) rec1.getHeight();
            } else {
                return (int) -rec1.getHeight();
            }
        }
        return  0;
    }
}
