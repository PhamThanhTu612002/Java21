package view;

import entities.Bomber;
import entities.Manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.BitSet;
import java.util.Observable;
import java.util.Observer;

public class PlaygameView implements Observer, Runnable {
    public static boolean IS_RUNNING = true;
    protected JPanel playgameViewJp;
    private BitSet traceKey = new BitSet();
    private Manager mMagager;
    private int i = 0;
    private int count = 0;
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
            mMagager.drawAllBox(graphics2D);
            mMagager.getmBomber().drawActor(graphics2D);
            mMagager.drawAllShawDow(graphics2D);
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
                mMagager.getmBomber().move(count,mMagager.getArrBox());
                runActor();
            }
            if (traceKey.get(KeyEvent.VK_W) || traceKey.get(KeyEvent.VK_UP)){
                mMagager.getmBomber().changeOrient(Bomber.UP);
                mMagager.getmBomber().move(count,mMagager.getArrBox());
                runActor();
            }
            if (traceKey.get(KeyEvent.VK_S) || traceKey.get(KeyEvent.VK_DOWN)){
                mMagager.getmBomber().changeOrient(Bomber.DOWN);
                mMagager.getmBomber().move(count,mMagager.getArrBox());
                runActor();
            }
            if (traceKey.get(KeyEvent.VK_D) || traceKey.get(KeyEvent.VK_RIGHT)){
                mMagager.getmBomber().changeOrient(Bomber.RIGHT);
                mMagager.getmBomber().move(count,mMagager.getArrBox());
                runActor();
            }
        }
    }

    @Override
    public void update(Observable o, Object arg) {
    }
    public Manager getmMagager() {
        return mMagager;
    }
    private void runActor() {
        i++;
        if (i == 200) {
            i = 0;
        }
    }
    public void chooseActor() {
        mMagager = new Manager();
    }
}
