package service.view;

import view.MainGameView;
import view.PlaygameView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlaygameService extends GameService{
    private PlaygameView playgameView;
    public PlaygameService(MainGameView gameView) {
        super(gameView);
        playgameView = this.gameView.container.getPlaygameView();
        playgameView.addPlayGameListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == playgameView.getBtbMenu()){
                    playgameView.getmMagager().setRound(1);
                    gameView.container.showMenu();
                }
            }
        });
    }
}
