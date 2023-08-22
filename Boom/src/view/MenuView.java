package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;

public class MenuView {
    protected JPanel menuViewJp;
    private JLabel lbPlayGame;
    private JLabel lbConduct;
    private JLabel lbHighScore;
    private JLabel lbExit;
    private JLabel lbBackground;
    private ImageIcon backgroundIcon;

    public JLabel getLbPlayGame() {
        return lbPlayGame;
    }

    public void setLbPlayGame(JLabel lbPlayGame) {
        this.lbPlayGame = lbPlayGame;
    }

    public JLabel getLbConduct() {
        return lbConduct;
    }

    public void setLbConduct(JLabel lbConduct) {
        this.lbConduct = lbConduct;
    }

    public JLabel getLbHighScore() {
        return lbHighScore;
    }

    public void setLbHighScore(JLabel lbHighScore) {
        this.lbHighScore = lbHighScore;
    }

    public JLabel getLbExit() {
        return lbExit;
    }

    public void setLbExit(JLabel lbExit) {
        this.lbExit = lbExit;
    }

    public MenuView() {
        menuViewJp = new JPanel();
        menuViewJp.setBackground(Color.YELLOW);
        menuViewJp.setLayout(null);
        initComps();
        initBackground();
    }
    public JLabel setLable(int x, int y, String imageIcon){
        JLabel label = new JLabel();
        ImageIcon icon = new ImageIcon(getClass().getResource(imageIcon));
        label.setBounds(x,y,icon.getIconWidth(),icon.getIconHeight());
        label.setIcon(icon);
        return label;
    }
    public void initComps(){
        lbPlayGame = setLable(650,125,"/images/Play.png");
        lbConduct = setLable(650,225,"/images/Option.png");
        lbHighScore = setLable(650,325,"/images/HightScore.png");
        lbExit = setLable(650,425,"/images/Exit.png");

        menuViewJp.add(lbPlayGame);
        menuViewJp.add(lbConduct);
        menuViewJp.add(lbHighScore);
        menuViewJp.add(lbExit);
    }
    public void initBackground(){
        lbBackground = new JLabel();
        lbBackground.setBounds(0,-15,MainGameView.WIDTH,MainGameView.HEIGHT);
        lbBackground.setBackground(Color.BLACK);
        backgroundIcon = new ImageIcon(getClass().getResource("/images/background_Menu.png"));
        lbBackground.setIcon(backgroundIcon);
        menuViewJp.add(lbBackground);
    }
    public void addMouseListener(MouseAdapter adapter){
        lbPlayGame.addMouseListener(adapter);
        lbConduct.addMouseListener(adapter);
        lbHighScore.addMouseListener(adapter);
        lbExit.addMouseListener(adapter);
    }
}
