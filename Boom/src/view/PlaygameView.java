package view;

import entities.Actor;
import entities.Bomber;
import entities.Manager;
import sound.Sound;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.BitSet;
import java.util.Observable;
import java.util.Observer;

public class PlaygameView implements Runnable {
    public static boolean IS_RUNNING = true;
    protected JPanel playgameViewJp;
    private BitSet traceKey = new BitSet();
    private Manager mMagager;
    JButton btbMenu;
    private int i = 0;
    private int count = 0;
    private int move = 0;
    private int timeDead = 0;
    private int timeLose = 0;
    private int timeNext = 0;
    private Thread mytheard;
    private Container container;

    public PlaygameView(Container container) {
        playgameViewJp = panelGame;
        this.container = container;
        mMagager = new Manager();
        playgameViewJp.setLayout(null);
        playgameViewJp.setFocusable(true);
        playgameViewJp.addKeyListener(keyAdapter);
        mytheard = new Thread(this);
        mytheard.start();
        innitComps();
    }
    public void innitComps(){
        btbMenu = new JButton();
        btbMenu.setText("MENU");
        btbMenu.setBackground(Color.BLUE);
        btbMenu.setForeground(Color.YELLOW);
        btbMenu.setFont(new Font("Arial",Font.BOLD,25));
        btbMenu.setBounds(755,630,175,38);
        playgameViewJp.add(btbMenu);
    }
    @SuppressWarnings("serial")
    private JPanel panelGame = new JPanel(){
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D graphics2D = (Graphics2D) g;
            graphics2D.setStroke(new BasicStroke(2));
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
            mMagager.draWBackground(graphics2D);
            mMagager.drawAllBomb(graphics2D);
            mMagager.drawAllItem(graphics2D);
            mMagager.drawAllBox(graphics2D);
            mMagager.drawAllMonster(graphics2D);
            mMagager.getmBomber().drawActor(graphics2D);
            mMagager.drawInfor(graphics2D);
            if (mMagager.getStatus() == 1){
                mMagager.drawDialog(graphics2D,1);
            }
            if (mMagager.getStatus() == 2){
                mMagager.drawDialog(graphics2D,2);
            }
            if (mMagager.getStatus() == 3){
                mMagager.drawDialog(graphics2D,3);
            }
        }
    };
    private KeyAdapter keyAdapter = new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            traceKey.set(e.getKeyCode());
        }

        @Override
        public void keyReleased(KeyEvent e) {
            traceKey.clear(e.getKeyCode());
        }
    };
    @Override
    public void run() {
        while (IS_RUNNING){
            try {
                Thread.sleep(1);
                playgameViewJp.repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (traceKey.get(KeyEvent.VK_A) || traceKey.get(KeyEvent.VK_LEFT)){
                mMagager.getmBomber().changeOrient(Bomber.LEFT);
                mMagager.getmBomber().move(count,mMagager.getArrBox(),mMagager.getArrBomb());
                runActor();
            }
            if (traceKey.get(KeyEvent.VK_W) || traceKey.get(KeyEvent.VK_UP)){
                mMagager.getmBomber().changeOrient(Bomber.UP);
                mMagager.getmBomber().move(count,mMagager.getArrBox(),mMagager.getArrBomb());
                runActor();
            }
            if (traceKey.get(KeyEvent.VK_S) || traceKey.get(KeyEvent.VK_DOWN)){
                mMagager.getmBomber().changeOrient(Bomber.DOWN);
                mMagager.getmBomber().move(count,mMagager.getArrBox(),mMagager.getArrBomb());
                runActor();
            }
            if (traceKey.get(KeyEvent.VK_D) || traceKey.get(KeyEvent.VK_RIGHT)){
                mMagager.getmBomber().changeOrient(Bomber.RIGHT);
                mMagager.getmBomber().move(count,mMagager.getArrBox(),mMagager.getArrBomb());
                runActor();
            }
            if (traceKey.get(KeyEvent.VK_J) || traceKey.get(KeyEvent.VK_SPACE)){
                mMagager.initBomb();
                mMagager.getmBomber().setRunBomb(Bomber.ALLOW_RUN);
                runActor();
            }
            mMagager.setRunBomer();
            mMagager.checkWin();
            mMagager.deadLineAllBomb();
            mMagager.checkDead();
            mMagager.checkImpactVsItem();

            if (mMagager.getStatus() == 1) {
                timeLose++;
                if (timeLose == 2000) {
                    mMagager.initManager();
                    container.showMenu();
                    timeLose = 0;
                }
            }

            if (mMagager.getStatus() == 2) {
                timeNext++;
                if (timeNext == 2000) {
                    mMagager.initManager();
                    timeNext = 0;
                }
            }

            if (mMagager.getStatus() == 3) {
                timeNext++;
                if (timeNext == 2000) {
                    mMagager.initManager();
                    container.showMenu();
                    timeNext = 0;
                }
            }
            if (mMagager.getmBomber().getStatus() == Bomber.DEAD){
                timeDead++;
                if (timeDead == 2000){
                mMagager.setNewBomb();
                timeDead = 0;
                }
            }
            if (move == 0) {
                mMagager.changeOrientAll();
                move = 5000;
            }
            if (move > 0) {
                move--;
            }
            mMagager.moveAllMonster(count);
            count++;
            if (count == 1000000) {
                count = 0;
            }
        }
    }

    public Manager getmMagager() {
        return mMagager;
    }
    private void runActor() {
        i++;
        if (i == 200) {
            Sound.getInstance().getAudio(Sound.MOVE).start();
            Sound.getInstance().getAudio(Sound.MOVE).loop(2);
            i = 0;
        }
    }
    public void chooseActor() {
        mMagager = new Manager();
    }
    public void addPlayGameListener(ActionListener actionListener) {
        btbMenu.addActionListener(actionListener);
    }

    public JButton getBtbMenu() {
        return btbMenu;
    }
}
