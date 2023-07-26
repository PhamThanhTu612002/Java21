import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

public class Board extends JPanel {
    public static final int N=101;
    public static final int M=101;
    public static final int DRAW = 0;
    public static final int WIN = 1;
    public static final int NORMAL = 2;
    private Image imageX;
    private Image imageY;
    private EndGame endGame;

    private final Cell[][] matrix = new Cell[N][M];
    private String currentPlayer = Cell.EMPTY_VALUE;


    public Board(String player) {
        this();
        this.currentPlayer = player;
    }

    public Board() {
        this.initMatrix();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                int x = e.getX();
                int y = e.getY();
                if (currentPlayer.equals(Cell.EMPTY_VALUE)) {
                    return;
                }
                //Click phát ra âm thanh
                soundClick();
                //Tính toán x, y rơi vào ô nào trong board, sau đó vé hình x hoăc o tùy ý
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        Cell cell = matrix[i][j];

                        int cXStart = cell.getX();
                        int cYStart = cell.getY();

                        int cXEnd = cXStart + cell.getWidth();
                        int cYEnd = cYStart + cell.getHeight();

                        if (x > cXStart && x < cXEnd && y > cYStart && y < cYEnd) {
                            if (cell.getValue().equals(Cell.EMPTY_VALUE)) {
                                cell.setValue(currentPlayer);
                                repaint();
                                int result = checkWin(currentPlayer);
                                if (endGame != null){
                                    endGame.end(currentPlayer,result);
                                }
                                if (result == NORMAL){
                                    currentPlayer = currentPlayer.equals(Cell.X_VALUE) ? Cell.O_VALUE : Cell.X_VALUE;
                                }
                            }
                        }
                    }
                }
            }
        });
        try {
            imageX = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("x.png")));
            imageY = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("o.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void initMatrix() {
        //Khởi tạo
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Cell cell = new Cell();
                matrix[i][j] = cell;
            }
        }
    }

    public void resetMatrix() {
        this.initMatrix();
        this.setCurrentPlayer(Cell.EMPTY_VALUE);
        repaint();
    }

    //0: hòa ,1:player hiện tại thắng, 2:player hiện tại chưa thắng
    public int checkWin(String player) {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (this.matrix[i][j].getValue().equals(player) && this.matrix[i][j + 1].getValue().equals(player) && this.matrix[i][j + 2].getValue().equals(player) && this.matrix[i][j + 3].getValue().equals(player) && this.matrix[i][j + 4].getValue().equals(player)) {
                    return WIN;
                } else if(this.matrix[i][j].getValue().equals(player) && this.matrix[i + 1][j].getValue().equals(player) && this.matrix[i + 2][j].getValue().equals(player) && this.matrix[i + 3][j].getValue().equals(player) && this.matrix[i + 4][j].getValue().equals(player)) {
                    return WIN;
                } else if(this.matrix[i][j].getValue().equals(player) && this.matrix[i + 1][j + 1].getValue().equals(player) && this.matrix[i + 2][j + 2].getValue().equals(player) && this.matrix[i + 3][j + 3].getValue().equals(player) && this.matrix[i + 4][j + 4].getValue().equals(player)){
                    return WIN;
                } else if(this.matrix[i][j].getValue().equals(player) && this.matrix[Math.abs(i+1)][Math.abs(j-1)].getValue().equals(player) && this.matrix[Math.abs(i+2)][Math.abs(j-2)].getValue().equals(player) && this.matrix[Math.abs(i+3)][Math.abs(j-3)].getValue().equals(player) && this.matrix[Math.abs(i+4)][Math.abs(j-4)].getValue().equals(player)) {
                    return WIN;
                }
            }
        }
        if (this.isFull()){
            return DRAW;
        }
        return NORMAL;
    }

    private boolean isFull() {
        int number = N*M;

        int k = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Cell cell = matrix[i][j];
                if (!cell.getValue().equals(Cell.EMPTY_VALUE)){
                    k++;
                }
            }
        }
        return k == number;
    }
    private synchronized void soundClick(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(Objects.requireNonNull(getClass().getResource("click.wav")));
                    clip.open(audioInputStream);
                    clip.start();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
    @Override
    public void paint(Graphics g){
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setColor(Color.BLUE);
        graphics2D.fillRect(0,0,20,20);

        int k = 0;
        for (int i=0; i<N;i++){
            for (int j=0;j<M;j++){

                int x=j*20;
                int y=i*20;

                //Cập nhật lại ma trận
                Cell cells = matrix[i][j];
                cells.setX(x);
                cells.setY(y);
                cells.setWidth(20);
                cells.setHeight(20);

                Color color = Color.WHITE;
                graphics2D.setColor(color);
                graphics2D.fillRect(x,y,20,20);
                graphics2D.setColor(Color.lightGray);
                graphics2D.drawRect(x, y, 20, 20);

                if (cells.getValue().equals(Cell.X_VALUE)){
                    Image image = imageX;
                    graphics2D.drawImage(image,x,y,20,20,this);
                }else if(cells.getValue().equals(Cell.O_VALUE)){
                    Image image = imageY;
                    graphics2D.drawImage(image,x,y,20,20,this);
                }
//                Image image = k%2==0 ? imageX:imageY;
//                graphics2D.drawImage(image,x,y,20,20,this);
                k++;
            }
        }
    }

    public void setCurrentPlayer(String currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void setEndGame(EndGame endGame) {
        this.endGame = endGame;
    }
}
