package service.view;

import entities.ReadScore;
import view.MainGameView;
import view.OptionView;

public class GameService implements IView{
    protected MainGameView gameView;
    private ReadScore hscore;

    public GameService(MainGameView gameView, ReadScore hscore) {
        this.gameView = gameView;
        this.hscore = hscore;
    }
    public void setModel(ReadScore hscore) {
        this.hscore = hscore;
        highScoreService();
    }

    public GameService(MainGameView gameView) {
        this.gameView = gameView;
    }
    public void menuService(){
        new MenuService(gameView);
    }
    public void optionService(){
        new OptionService(gameView);
    }
    public void highScoreService(){
        new HighScoreService(hscore,gameView);
    }
    public void playGameService(){
        new PlaygameService(gameView);
    }

    @Override
    public void display() {
        gameView.container.showMenu();
        menuService();
        optionService();
        playGameService();
    }
}
