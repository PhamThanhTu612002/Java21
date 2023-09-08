package service.entities;

import entities.Item;

import java.awt.*;

public class DrawItemImpl implements IDraw{
    @Override
    public void draw(Object object, Graphics2D g2d) {
        if (object instanceof Item){
            Item item = (Item) object;
            g2d.drawImage(item.getImg(),item.getX(),item.getY(), null);
        }
    }
}
