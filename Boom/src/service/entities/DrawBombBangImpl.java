package service.entities;

import entities.BombBang;

import java.awt.*;

public class DrawBombBangImpl implements IDraw{
    @Override
    public void draw(Object object, Graphics2D g2d) {
        if (object instanceof BombBang){
            BombBang bombBang = (BombBang) object;
            g2d.drawImage(bombBang.getImg_left(),bombBang.getX()+45-bombBang.getImg_left().getWidth(null),bombBang.getY(),null);
            g2d.drawImage(bombBang.getImg_right(),bombBang.getX(),bombBang.getY(),null);
            g2d.drawImage(bombBang.getImg_up(),bombBang.getX(),bombBang.getY()+45-bombBang.getImg_up().getHeight(null),null);
            g2d.drawImage(bombBang.getImg_down(),bombBang.getX(),bombBang.getY(),null);
        }
    }
}
