package entities;

import service.entities.*;

import java.awt.*;

public class MonterMin extends Monster{
    private IDraw iDraw;
    private IOrient iOrient;

    public MonterMin(int x, int y, int type, int orient, int speed, int heart, String images) {
        super(x, y, type, orient,speed, heart, images);
        height = 45;
        width = 45;
    }

    @Override
    public void changeOrient(int orient) {
        super.changeOrient(orient);
        iOrient = new OrientMonsterImpl();
        iOrient.changeOrient(this,orient);
    }

    @Override
    public void drawActor(Graphics2D g2d) {
        super.drawActor(g2d);
        iDraw = new DrawMonsterImpl();
        iDraw.draw(this,g2d);
    }
}
