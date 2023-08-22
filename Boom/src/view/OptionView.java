package view;

import service.view.GameService;

import javax.swing.*;
import java.awt.event.MouseAdapter;

public class OptionView {
    protected JPanel optionViewJp;
    private JLabel lbBackground;
    private JLabel lbCancel;
    private JLabel lbBackOp;
    private ImageIcon backgroundIcon;
    private ImageIcon cancelIcon;
    private ImageIcon opIcon;

    public OptionView() {
        optionViewJp = new JPanel();
        optionViewJp.setLayout(null);
        initComps();
    }

    public JLabel getLbCancel() {
        return lbCancel;
    }

    public void initComps(){
        lbBackground = new JLabel();
        lbBackground.setBounds(0,-15, MainGameView.WIDTH,MainGameView.HEIGHT);
        backgroundIcon = new  ImageIcon(getClass().getResource("/images/background_Menu2.png"));
        lbBackground.setIcon(backgroundIcon);

        lbBackOp = new JLabel();
        lbBackOp.setBounds(55,-10,MainGameView.WIDTH,MainGameView.HEIGHT);
        opIcon = new ImageIcon(getClass().getResource("/images/background_option.png"));
        lbBackOp.setIcon(opIcon);

        lbCancel = new JLabel();
        cancelIcon = new ImageIcon(getClass().getResource("/images/cancel1.png"));
        lbCancel.setBounds(829, 564,cancelIcon.getIconWidth(),cancelIcon.getIconHeight());
        lbCancel.setIcon(cancelIcon);

        optionViewJp.add(lbCancel);
        optionViewJp.add(lbBackOp);
        optionViewJp.add(lbBackground);
    }
    public void addMouseListener(MouseAdapter adapter){
        lbCancel.addMouseListener(adapter);
    }
}
