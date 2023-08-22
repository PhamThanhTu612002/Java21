package service.entities;

import entities.Bomber;
import entities.KhoKho;

import java.awt.*;

public class DrawBomberImpl implements IDraw{
    @Override
    public void draw(Object object, Graphics2D g2d) {
        if(object instanceof KhoKho) {
            KhoKho khoKho = (KhoKho) object;
            g2d.drawImage(khoKho.img, khoKho.getX(), khoKho.getY() - 20, null);
        }
    }
}
