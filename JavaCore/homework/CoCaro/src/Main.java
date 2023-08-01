import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

    private static int sec =0;
    private static Timer timer = new Timer();
    private static JLabel lbTime;
    private static Board board;
    private static JButton btbStart;
    private static DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
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


        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        //Boxlayout,Flowlayout,Borderlayout
        JPanel jPanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(jPanel,BoxLayout.Y_AXIS);
        jPanel.setLayout(boxLayout);

        board.setPreferredSize(new Dimension(1200,700));

        JPanel bottomJp = new JPanel();
        bottomJp.setPreferredSize(new Dimension(jPanel.getWidth(), 40));
        btbStart = new JButton("Start");
        //Timer & TimerTask
        lbTime = new JLabel("00:00:00");

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
        jFrame.setResizable(false);
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

        sec = 0;
        lbTime.setText("00:00:00");
        timer.cancel();
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                sec++;
                LocalTime time = LocalTime.ofSecondOfDay(sec);
                String formattedTime = time.format(timeFormatter);
                lbTime.setText(formattedTime);
            }
        }, 1000, 1000);
        btbStart.setText("Stop");
    }
    private static void stopGame(){
        btbStart.setText("Start");

        sec=0;
        lbTime.setText("00:00:00");

        timer.cancel();
        timer=new Timer();

        board.resetMatrix();
    }
}
