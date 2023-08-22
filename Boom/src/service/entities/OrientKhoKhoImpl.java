package service.entities;

import entities.Actor;
import entities.KhoKho;

import javax.swing.*;

public class OrientKhoKhoImpl implements IOrient{
    @Override
    public void changeOrient(Object object, int orient) {
        if (object instanceof KhoKho){
            KhoKho khokho = (KhoKho) object;
            if (khokho.getStatus() == Actor.DEAD){
                return;
            }
            khokho.setChange(orient);
            switch (orient){
                case Actor.LEFT:
                    khokho.img = new ImageIcon(getClass().getResource("/images/khokho_left.png")).getImage();
                    break;
                case Actor.RIGHT:
                    khokho.img = new ImageIcon(getClass().getResource("/images/khokho_right.png")).getImage();
                    break;
                case Actor.UP:
                    khokho.img = new ImageIcon(getClass().getResource("/images/khokho_up.png")).getImage();
                    break;
                case Actor.DOWN:
                    khokho.img = new ImageIcon(getClass().getResource("/images/khokho_down.png")).getImage();
                    break;
                default:
                    break;
            }
        }
    }
}
