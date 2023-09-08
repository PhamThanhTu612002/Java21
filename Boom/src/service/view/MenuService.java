package service.view;

import entities.ReadScore;
import sound.Sound;
import view.MainGameView;
import view.MenuView;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuService extends GameService{
    private MenuView menuView;

    public MenuService(MainGameView view) {
        super(view);
        menuView = this.gameView.container.getMenu();
        menuView.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getSource() == menuView.getLbExit()){
                    System.exit(0);
                }
                if (e.getSource() == menuView.getLbConduct()){
                    gameView.container.showOption();
                }
                if (e.getSource() == menuView.getLbPlayGame()){
                    gameView.container.showPlaygame();
                    Sound.getInstance().stop();
                    Sound.getInstance().getAudio(Sound.PLAYGAME).start();
                    Sound.getInstance().getAudio(Sound.PLAYGAME).loop(100);
                }
                if (e.getSource() == menuView.getLbHighScore()){
                    MenuService.super.setModel(new ReadScore());
                    gameView.container.showHighScore();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (e.getSource() == menuView.getLbPlayGame()){
                    Sound.getInstance().getAudio(Sound.HOVER).start();
                    Sound.getInstance().getAudio(Sound.HOVER).loop(1);
                    ImageIcon playIcon = new ImageIcon(getClass().getResource("/images/Play2.png"));
                    menuView.getLbPlayGame().setIcon(playIcon);
                }
                if (e.getSource() == menuView.getLbConduct()){
                    Sound.getInstance().getAudio(Sound.HOVER).start();
                    Sound.getInstance().getAudio(Sound.HOVER).loop(1);
                    ImageIcon optionIcon = new ImageIcon(getClass().getResource("/images/Option2.png"));
                    menuView.getLbConduct().setIcon(optionIcon);
                }
                if (e.getSource() == menuView.getLbHighScore()){
                    Sound.getInstance().getAudio(Sound.HOVER).start();
                    Sound.getInstance().getAudio(Sound.HOVER).loop(1);
                    ImageIcon highScoreIcon = new ImageIcon(getClass().getResource("/images/HightScore2.png"));
                    menuView.getLbHighScore().setIcon(highScoreIcon);
                }
                if (e.getSource() == menuView.getLbExit()){
                    Sound.getInstance().getAudio(Sound.HOVER).start();
                    Sound.getInstance().getAudio(Sound.HOVER).loop(1);
                    ImageIcon exitIcon = new ImageIcon(getClass().getResource("/images/Exit2.png"));
                    menuView.getLbExit().setIcon(exitIcon);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (e.getSource() == menuView.getLbPlayGame()){
                    ImageIcon playIcon = new ImageIcon(getClass().getResource("/images/Play.png"));
                    menuView.getLbPlayGame().setIcon(playIcon);
                }
                if (e.getSource() == menuView.getLbConduct()){
                    ImageIcon optionIcon = new ImageIcon(getClass().getResource("/images/Option.png"));
                    menuView.getLbConduct().setIcon(optionIcon);
                }
                if (e.getSource() == menuView.getLbHighScore()){
                    ImageIcon highScoreIcon = new ImageIcon(getClass().getResource("/images/HightScore.png"));
                    menuView.getLbHighScore().setIcon(highScoreIcon);
                }
                if (e.getSource() == menuView.getLbExit()){
                    ImageIcon exitIcon = new ImageIcon(getClass().getResource("/images/Exit.png"));
                    menuView.getLbExit().setIcon(exitIcon);
                }
            }
        });
    }
}
