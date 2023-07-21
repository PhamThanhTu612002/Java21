import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

    private static int sec =0;
    private static Timer timer = new Timer();
    private static JLabel lbTime;
    private static Board board;
    private static JButton btbStart;
    public static void main(String[] args) {
        board = new Board();
        board.setEndGame(new EndGame(){
            @Override
            public void end(String player, int st) {
                if (st == Board.WIN){
                    JOptionPane.showMessageDialog(null,"Người chơi "+player+" thắng");
                    stopGame();
                }else if (st == Board.DRAW){
                    JOptionPane.showMessageDialog(null,"Hòa rồi");
                    stopGame();
                }
            }
        });

//        if (choice==0){
//            board = new Board(Cell.X_VALUE);
//        }else {
//            board = new Board(Cell.O_VALUE);
//        }

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        //Boxlayout,Flowlayout,Borderlayout
        JPanel jPanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(jPanel,BoxLayout.Y_AXIS);
        jPanel.setLayout(boxLayout);

        board.setPreferredSize(new Dimension(1200,700));

        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER,0,0);
        JPanel bottomJp = new JPanel();
        bottomJp.setLayout(flowLayout);
        bottomJp.setBackground(Color.YELLOW);

        btbStart = new JButton("Start");
        //Timer & TimerTask
        lbTime = new JLabel("00:00");

        bottomJp.add(lbTime);
        bottomJp.add(btbStart);
        btbStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(btbStart.getText().equals("Start")){
                startGame();
                }else {
                    stopGame();
                }
            }
        });


        jPanel.add(board);
        jPanel.add(bottomJp);

        JFrame jFrame = new JFrame("Cờ caro");
        jFrame.setSize(1200,700);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setResizable(true);
        jFrame.add(jPanel);

        jFrame.setLocation(150,50);
        jFrame.pack();
        //show giao diện
        jFrame.setVisible(true);
    }
    public static void startGame(){
        //Hỏi ai đi trước
        int choice = JOptionPane .showConfirmDialog(null,"Người chơi O đi trước đúng ko?","Ai là người đi trước?",JOptionPane.YES_NO_OPTION);
        board.resetMatrix();
        String currentPlayer = (choice == 1) ? Cell.X_VALUE : Cell.O_VALUE;
        board.setCurrentPlayer(currentPlayer);
        System.out.println(currentPlayer);

        //Đếm ngược
        sec =0;
        lbTime.setText("0:0");
        timer.cancel();
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                sec++;
                String value = sec/60 + ":" + sec%60;
                lbTime.setText(value);
            }
        }, 1000, 1000);
        btbStart.setText("Stop");
    }
    private static void stopGame(){
        btbStart.setText("Start");

        sec=0;
        lbTime.setText("0:0");

        timer.cancel();
        timer=new Timer();

        board.resetMatrix();
    }
}
