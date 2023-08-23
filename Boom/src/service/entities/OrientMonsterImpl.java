package service.entities;

import entities.Actor;
import entities.MonterMin;

import javax.swing.*;

public class OrientMonsterImpl implements IOrient{
    @Override
    public void changeOrient(Object object, int orient) {
        if (object instanceof MonterMin){
            MonterMin monterMin = (MonterMin) object;
            monterMin.setChange(orient);
            switch (orient){
                case Actor.LEFT:
                    monterMin.img = new ImageIcon(getClass().getResource("/images/quaivat 1_left.png")).getImage();
                    break;
                case Actor.RIGHT:
                    monterMin.img = new ImageIcon(getClass().getResource("/images/quaivat 1_right.png")).getImage();
                    break;
                case Actor.UP:
                    monterMin.img = new ImageIcon(getClass().getResource("/images/quaivat 1_up.png")).getImage();
                    break;
                case Actor.DOWN:
                    monterMin.img = new ImageIcon(getClass().getResource("/images/quaivat 1_down.png")).getImage();
                    break;
                default:
                    break;
            }
        }
    }
}
