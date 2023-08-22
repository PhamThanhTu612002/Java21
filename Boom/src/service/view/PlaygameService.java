package service.view;

import view.MainGameView;
import view.PlaygameView;

public class PlaygameService extends GameService{
    private PlaygameView playgameView;
    public PlaygameService(MainGameView gameView) {
        super(gameView);
        playgameView = this.gameView.container.getPlaygameView();
    }
}
