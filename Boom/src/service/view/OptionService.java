package service.view;

import view.MainGameView;
import view.OptionView;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OptionService extends GameService{
    private OptionView optionView;
    public OptionService(MainGameView gameView) {
        super(gameView);
        optionView = this.gameView.container.getOption();
        optionView.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                gameView.container.showMenu();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (e.getSource() == optionView.getLbCancel()){
                    ImageIcon cancelIcon = new ImageIcon(getClass().getResource("/images/cancel2.png"));
                    optionView.getLbCancel().setIcon(cancelIcon);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (e.getSource() == optionView.getLbCancel()){
                    ImageIcon cancelIcon = new ImageIcon(getClass().getResource("/images/cancel1.png"));
                    optionView.getLbCancel().setIcon(cancelIcon);
                }
            }
        });
    }
}
