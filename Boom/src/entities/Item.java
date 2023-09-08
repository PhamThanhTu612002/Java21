package entities;

import service.entities.DrawItemImpl;
import service.entities.IDraw;

import javax.swing.*;
import java.awt.*;

public class Item {
    IDraw iDraw;
    public static final int ITEM_SIZEBOOM = 2;
    public static final int ITEM_SHOE = 3;
    protected int x,y,type,width,height,timeLine;
    protected Image img;

    public Item(int x, int y, int type, String image) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.img = new ImageIcon(getClass().getResource(image)).getImage();
        this.width = img.getWidth(null);
        this.height = img.getHeight(null);
        timeLine = 250;
    }
    public boolean isImpactVsBomber(Bomber bomber){
        Rectangle rec1 = new Rectangle(x,y,width,height);
        Rectangle rec2 = new Rectangle(bomber.getX(),bomber.getY(),bomber.getWidth(),bomber.getHeight());
        return rec1.intersects(rec2);
    }
    public void drawItem(Graphics2D graphics2D){
        iDraw = new DrawItemImpl();
        iDraw.draw(this,graphics2D);
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getTimeLine() {
        return timeLine;
    }

    public void setTimeLine(int timeLine) {
        this.timeLine = timeLine;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }
}
