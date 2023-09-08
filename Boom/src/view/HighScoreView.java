package view;

import entities.HighScore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

public class HighScoreView {
    protected JPanel highScoreJp;
    private ArrayList<HighScore> arrayHighScore;
    private JLabel lbCancel;
    private ImageIcon backgroundHS;

    public HighScoreView() {
        highScoreJp = pnHighScore;
        highScoreJp.setLayout(null);
        initComps();
    }
    public void initComps(){
        lbCancel = new JLabel();
        backgroundHS = new ImageIcon(getClass().getResource("/images/cancel1.png"));
        lbCancel.setBounds(829, 564, backgroundHS.getIconWidth(), backgroundHS.getIconHeight());
        lbCancel.setIcon(backgroundHS);
        highScoreJp.add(lbCancel);
    }
    private JPanel pnHighScore = new JPanel(){
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D graphics2D = (Graphics2D) g;
            drawImage(graphics2D);
            if (arrayHighScore != null) {
                drawHighScore(graphics2D);
            }
        }
    };
    public void drawImage(Graphics2D g2d){
        Image background = new ImageIcon(getClass().getResource("/images/background_Menu2.png")).getImage();
        Image backgrLb = new ImageIcon(getClass().getResource("/images/background_hightscore.png")).getImage();
        g2d.drawImage(background, 0, 0, null);
        g2d.drawImage(backgrLb, 55, 40, null);
    }
    public void drawHighScore(Graphics2D g2d){
        g2d.setStroke(new BasicStroke(2));
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setFont(new Font("Arial",Font.BOLD,30));
        g2d.setColor(Color.YELLOW);
        int y = 170;
        for (int i = 0; i < arrayHighScore.size(); i++){
            g2d.drawString(""+(i+1),195,y);
            g2d.drawString("" + arrayHighScore.get(i).getName(),330,y);
            g2d.drawString("" + arrayHighScore.get(i).getScore(),665,y);
            y = y +45;
        }
    }
    public void addHightScoreActorMouseListener(MouseAdapter adapter) {
        lbCancel.addMouseListener(adapter);
    }
    public ArrayList<HighScore> getArrayHighScore() {
        return arrayHighScore;
    }

    public void setArrayHighScore(ArrayList<HighScore> arrayHighScore) {
        this.arrayHighScore = arrayHighScore;
    }

    public JLabel getLbCancel() {
        return lbCancel;
    }

    public void setLbCancel(JLabel lbCancel) {
        this.lbCancel = lbCancel;
    }

    public ImageIcon getBackgroundHS() {
        return backgroundHS;
    }

    public void setBackgroundHS(ImageIcon backgroundHS) {
        this.backgroundHS = backgroundHS;
    }
}
