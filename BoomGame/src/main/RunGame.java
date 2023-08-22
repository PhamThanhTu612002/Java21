package main;


import entities.ReadFileHightScore;
import service.mainServiceImpl.ControllerMain;
import service.mainServiceImpl.ControllerView;
import view.GameView;

public class RunGame {
	public static void main(String[] args) {
		GameView view = new GameView();
		ReadFileHightScore model = new ReadFileHightScore();
		ControllerMain controller = new ControllerView(model, view);
		controller.displayGame();

		view.getView().setVisible(true);
	}
}
