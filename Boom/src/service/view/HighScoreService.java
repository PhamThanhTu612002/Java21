package service.view;

import entities.ReadScore;
import sound.Sound;
import view.HighScoreView;
import view.MainGameView;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HighScoreService extends GameService{
    private HighScoreView highScoreView;
    private ReadScore hscore;

    public HighScoreService(ReadScore hscore,MainGameView gameView) {
        super(gameView);
        this.hscore = hscore;
        highScoreView = this.gameView.container.getHighScoreView();
        highScoreView.addHightScoreActorMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getSource() == highScoreView.getLbCancel()){
                    gameView.container.showMenu();
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                ImageIcon lbCancel = new ImageIcon(getClass().getResource("/images/cancel2.png"));
                highScoreView.getLbCancel().setIcon(lbCancel);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                ImageIcon lbCancel = new ImageIcon(getClass().getResource("/images/cancel1.png"));
                highScoreView.getLbCancel().setIcon(lbCancel);
            }
        });
        drawScore();
    }
    private void drawScore(){
        highScoreView.setArrayHighScore(hscore.getArrHighScore());
    }
}
