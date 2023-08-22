package view;

import javax.swing.*;
import java.awt.*;

public class GameView {
	private JFrame view;
	public static final int WIDTHJF = 947 + 6;
	public static final int HEIGHTJF = 675 + 29;
	public MyContainer myContainer;

	public GameView() {
		view = new JFrame("Easy BOOM!");
		view.setLayout(new CardLayout());
		view.setSize(WIDTHJF, HEIGHTJF);
		view.setLocationRelativeTo(null);
		view.setResizable(false);
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myContainer = new MyContainer(this);
		view.add(myContainer.myContainer);

		Image image = Toolkit.getDefaultToolkit().getImage("src/Images/dau.png");
		view.setIconImage(image);
	}

	public JFrame getView() {
		return view;
	}

}
