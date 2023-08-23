package service.entities;

import entities.MonterMin;

import java.awt.*;

public class DrawMonsterImpl implements IDraw{
    @Override
    public void draw(Object object, Graphics2D g2d) {
        if (object instanceof MonterMin){
            MonterMin monterMin = (MonterMin) object;
            g2d.drawImage(monterMin.img, monterMin.getX() + 3, monterMin.getY() + 1,null);
        }
    }
}
