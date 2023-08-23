package entities;

import service.entities.DrawBombBangImpl;
import service.entities.IDraw;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BombBang {
    IDraw iDraw;
    protected int x, y, size, timeLine;

    protected Image img_left, img_right, img_up, img_down;

    public BombBang(int x, int y, int size, ArrayList<Box> arrBox) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.timeLine = 250;
        img_left = new ImageIcon(getClass().getResource("/images/bombbang_left1.png")).getImage();
        img_right = new ImageIcon(getClass().getResource("/images/bombbang_right1.png")).getImage();
        img_up = new ImageIcon(getClass().getResource("/images/bombbang_up1.png")).getImage();
        img_down = new ImageIcon(getClass().getResource("/images/bombbang_down1.png")).getImage();
        for (int i = 1; i < size; i++){
            int tmp_left = 0, tmp_right = 0, tmp_up = 0, tmp_down = 0;
            for (int j = 0; j < arrBox.size(); j++){
                if (isImpactBox(x-(45*i), y, (i+1)*45,45,arrBox.get(j))){
                    tmp_left = 1;
                }
                if (isImpactBox(x, y, (i+1)*45,45,arrBox.get(j))){
                    tmp_right = 1;
                }
                if (isImpactBox(x, y- (45*i), 45,(i+1)*45,arrBox.get(j))){
                    tmp_up = 1;
                }
                if (isImpactBox(x,y,45,(i+1)*45,arrBox.get(j))){
                    tmp_down = 1;
                }
            }
            if (tmp_left == 0){
                setImage(Bomber.LEFT,size+1);
            }
            if (tmp_right == 0){
                setImage(Bomber.RIGHT,size+1);
            }
            if (tmp_up == 0){
                setImage(Bomber.UP,size+1);
            }
            if (tmp_down == 0){
                setImage(Bomber.DOWN,size+1);
            }
        }
    }
    public void drawActor(Graphics2D g2d){
        iDraw = new DrawBombBangImpl();
        iDraw.draw(this,g2d);
    }
    public boolean isImpactBox(int x, int y, int width, int height, Box box){
        Rectangle rec1 = new Rectangle(x,y,width,height);
        Rectangle rec2 = new Rectangle(box.x,box.y,box.width,box.height);
        return rec1.intersects(rec2);
    }
    public void setImage(int orient, int size){
        switch (orient){
            case Bomber.LEFT:
                img_left = new ImageIcon(getClass().getResource("/images/bombbang_left"+size+".png")).getImage();
                break;
            case Bomber.RIGHT:
                img_right = new ImageIcon(getClass().getResource("/images/bombbang_right"+size+".png")).getImage();
                break;
            case Bomber.UP:
                img_up = new ImageIcon(getClass().getResource("/images/bombbang_up"+size+".png")).getImage();
                break;
            case Bomber.DOWN:
                img_down = new ImageIcon(getClass().getResource("/images/bombbang_down"+size+".png")).getImage();
                break;
            default:break;
        }
    }
    public boolean isImpactBombVsActor(Actor actor){
        Rectangle rec1 = new Rectangle(x + 45 - img_left.getWidth(null)+5,y+5,img_left.getWidth(null)-5,
                img_left.getHeight(null)-10);
        Rectangle rec2 = new Rectangle(x,y+5,img_right.getWidth(null)-5,img_right.getHeight(null)-10);
        Rectangle rec3 = new Rectangle(x+5, y+45 - img_up.getHeight(null)+5,img_up.getWidth(null)-5,
                img_right.getHeight(null)-10);
        Rectangle rec4 = new Rectangle(x+5,y,img_down.getWidth(null) -10,img_up.getHeight(null)-5);
        Rectangle rec5 = new Rectangle(actor.getX(),actor.getY(),actor.getWidth(),actor.getHeight());
        if (rec5.intersects(rec1) || rec5.intersects(rec2) ||rec5.intersects(rec3) ||rec5.intersects(rec4)){
            return true;
        }
        return false;
    }
    public boolean isImpactBombVsBomb(Bomb bomb){
        Rectangle rec1 = new Rectangle(x+45 - img_left.getWidth(null),y,img_left.getWidth(null),img_left.getHeight(null));
        Rectangle rec2 = new Rectangle(x,y,img_right.getWidth(null),img_right.getHeight(null));
        Rectangle rec3 = new Rectangle(x, y+ 45,img_up.getHeight(null),img_up.getWidth(null));
        Rectangle rec4 = new Rectangle(x,y,img_down.getWidth(null),img_down.getHeight(null));
        Rectangle rec5 = new Rectangle(bomb.getX(),bomb.getY(),bomb.getWidth(),bomb.getHeight());
        if (rec5.intersects(rec1) ||rec5.intersects(rec2) ||rec5.intersects(rec3) ||rec5.intersects(rec4)){
            return true;
        }
        return false;
    }
    public boolean isImpactBombVsBox(Box box){
        if (box.getType() == Box.DISALLROW_BANG){
            return false;
        }
        Rectangle rec1 = new Rectangle(x+45 - img_left.getWidth(null),y,img_left.getWidth(null),img_left.getHeight(null));
        Rectangle rec2 = new Rectangle(x,y,img_right.getWidth(null),img_right.getHeight(null));
        Rectangle rec3 = new Rectangle(x, y + 45,img_up.getHeight(null),img_up.getWidth(null));
        Rectangle rec4 = new Rectangle(x,y,img_down.getWidth(null),img_down.getHeight(null));
        Rectangle rec5 = new Rectangle(box.getX(),box.getY(),box.getWidth(),box.getHeight());
        if (rec5.intersects(rec1) ||rec5.intersects(rec2) ||rec5.intersects(rec3) ||rec5.intersects(rec4)){
            return true;
        }
        return false;
    }
    public boolean isImpactBombBangvsBomb(Bomb bomb) {
        Rectangle rec1 = new Rectangle(x + 45 - img_left.getWidth(null), y, img_left.getWidth(null),
                img_left.getHeight(null));
        Rectangle rec2 = new Rectangle(x, y, img_right.getWidth(null), img_right.getHeight(null));
        Rectangle rec3 = new Rectangle(x, y + 45 - img_up.getHeight(null), img_up.getWidth(null),
                img_up.getHeight(null));
        Rectangle rec4 = new Rectangle(x, y, img_down.getWidth(null), img_down.getHeight(null));
        Rectangle rec5 = new Rectangle(bomb.getX(), bomb.getY(), bomb.getWidth(), bomb.getHeight());
        if (rec1.intersects(rec5) || rec2.intersects(rec5) || rec3.intersects(rec5) || rec4.intersects(rec5)) {
            return true;
        }
        return false;
    }
    public int getTimeLine() {
        return timeLine;
    }

    public void deadlineBomb() {
        if (timeLine > 0){
            timeLine--;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSize() {
        return size;
    }

    public Image getImg_left() {
        return img_left;
    }

    public Image getImg_right() {
        return img_right;
    }

    public Image getImg_up() {
        return img_up;
    }

    public Image getImg_down() {
        return img_down;
    }
}
