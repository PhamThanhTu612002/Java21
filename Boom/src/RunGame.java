import entities.ReadScore;
import service.view.GameService;
import service.view.IView;
import view.MainGameView;

public class RunGame {
    public static void main(String[] args) {
        MainGameView view = new MainGameView();
        ReadScore score = new ReadScore();
        IView iView = new GameService(view,score);
        iView.display();
        view.getGameView().setVisible(true);
    }
}
