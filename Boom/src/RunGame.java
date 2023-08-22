import service.view.GameService;
import service.view.IView;
import view.MainGameView;

public class RunGame {
    public static void main(String[] args) {
        MainGameView view = new MainGameView();
        IView iView = new GameService(view);
        iView.display();

        view.getGameView().setVisible(true);
    }
}
