package entities;

import service.entities.DrawBomberImpl;
import service.entities.IDraw;
import service.entities.IOrient;
import service.entities.OrientKhoKhoImpl;

import javax.swing.*;
import java.awt.*;

public class KhoKho extends Bomber{
    private IDraw iDraw;
    private IOrient iOrient;
    public KhoKho(int x, int y, int orient, int sizebomb, int quantityBomb) {
        super(x, y, orient, sizebomb, quantityBomb);
        this.runBomb = DISALLOW_RUN;
        this.heart = 3;
        this.score = 0;
        this.status = Actor.ALIVE;
        this.img = new ImageIcon(getClass().getResource("/images/khokho_down.png")).getImage();
        width = img.getWidth(null);
        height = img.getHeight(null)-20;
    }

    @Override
    public void setNew(int x, int y) {
        this.x = x;
        this.y = y;
        this.status = ALIVE;
        this.img = new ImageIcon(getClass().getResource("/images/khokho_down.png")).getImage();
    }
    @Override
    public void drawActor(Graphics2D g2d) {
        super.drawActor(g2d);
        iDraw = new DrawBomberImpl();
        iDraw.draw(this,g2d);
    };
    @Override
    public void changeOrient(int orient) {
        super.changeOrient(orient);
        iOrient = new OrientKhoKhoImpl();
        iOrient.changeOrient(this, orient);
    }


    @Override
    public void setQuantityBomb(int quantityBomb) {
        if (quantityBomb > 6) {
            return;
        }
        this.quantityBomb = quantityBomb;
    }

    @Override
    public void setSizeBomb(int sizeBomb) {
        if (sizeBomb > 7) {
            return;
        }
        this.sizeBomb = sizeBomb;
    }
}
