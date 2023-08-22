package view;

import javax.swing.*;
import java.awt.*;

public class MainGameView {
    private JFrame gameView;
    public Container container;
    public static final int WIDTH = 953;
    public static final int HEIGHT =704;

    public MainGameView() {
        gameView = new JFrame("BOOM!");
        gameView.setLayout(new CardLayout());
        gameView.setSize(WIDTH,HEIGHT);
        gameView.setLocationRelativeTo(null);
        gameView.setResizable(false);
        gameView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        container = new Container(this);
        gameView.add(container.containerJp);

        Image image = Toolkit.getDefaultToolkit().getImage("/images/dau.png");
        gameView.setIconImage(image);
    }

    public JFrame getGameView() {
        return gameView;
    }
}
