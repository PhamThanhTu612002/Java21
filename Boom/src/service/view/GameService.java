package service.view;

import view.MainGameView;
import view.OptionView;

public class GameService implements IView{
    protected MainGameView gameView;

    public GameService(MainGameView gameView) {
        this.gameView = gameView;
    }
    public void menuService(){
        new MenuService(gameView);
    }
    public void optionService(){
        new OptionService(gameView);
    }

    @Override
    public void display() {
        gameView.container.showMenu();
        menuService();
        optionService();
    }
}
