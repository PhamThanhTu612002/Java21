package entities;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class Bomber extends Actor {
    public static int ALLOW_RUN = 0;
    public static int DISALLOW_RUN = 1;

    protected int sizeBomb, quantityBomb, status, score, heart;

    public Bomber(int x, int y, int type,  int orient, int speed, int sizebomb, int quantityBomb) {
        this.x = x;
        this.y = y;
        this.orient = orient;
        this.type = type;
        this.speed = speed;
        this.sizeBomb = sizebomb;
        this.quantityBomb = quantityBomb;
    }
    public abstract void setNew(int x, int y);

    public int getSizeBomb() {
        return sizeBomb;
    }

    public void setSizeBomb(int sizeBomb) {
        this.sizeBomb = sizeBomb;
    }

    public int getQuantityBomb() {
        return quantityBomb;
    }

    public void setQuantityBomb(int quantityBomb) {
        this.quantityBomb = quantityBomb;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getHeart() {
        return heart;
    }

    public void setHeart(int heart) {
        this.heart = heart;
    }
    public void setImg(Image img) {
        this.img = img;
    }
    public void setChange(int orient) {
        super.changeOrient(orient);
    }
    @Override
    public boolean move(int count, ArrayList<Box> arrBox, ArrayList<Bomb> arrBomb) {
        if (status == DEAD) {
            return false;
        }
        return super.move(count, arrBox,arrBomb);
    }
    public boolean isImpactBomberVsActor(Actor actor) {
        if (status == DEAD) {
            return false;
        }
        Rectangle rec1 = new Rectangle(x, y, width, height);
        Rectangle rec2 = new Rectangle(actor.getX(), actor.getY(), actor.getWidth(), actor.getHeight());
        return rec1.intersects(rec2);
    }
}
