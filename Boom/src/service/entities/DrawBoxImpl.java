package service.entities;

import entities.Box;

import java.awt.*;

public class DrawBoxImpl implements IDraw{
    @Override
    public void draw(Object object, Graphics2D g2d) {
        if(object instanceof Box) {
            Box box = (Box) object;
            g2d.drawImage(box.img, box.x, box.y, null);
        }
    }
}
