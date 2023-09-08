package entities;

import sound.Sound;
import view.MainGameView;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Random;

public class Manager {
    private Random random = new Random();
    private Bomber mBomber;
    private String Background;
    private ArrayList<Box> arrBox;
    private ArrayList<Monster> arrMonster;
    private ArrayList<Bomb> arrBomb;
    private ArrayList<BombBang> arrBombBang;
    private ArrayList<Item> arrItem;
    private ArrayList<HighScore> arrayHighScore;
    public int round = 1;
    private int status = 0;
    public Manager(){
        initManager();
    }
    public void setBomBer() {
        mBomber = new KhoKho(540, 495,Actor.BOMBER,Bomber.DOWN,5, 1, 1);
    }
    public void draWBackground(Graphics2D g2d) {
        Image imgBackground = new ImageIcon(getClass().getResource(Background)).getImage();
        g2d.drawImage(imgBackground, 0, 0, null);
    }
    public void drawAllBox(Graphics2D g2d) {
        for (int i = 0; i < arrBox.size(); i++) {
            arrBox.get(i).drawBox(g2d);
        }
    }
    public void drawAllMonster(Graphics2D g2d){
        for (int i = 0; i < arrMonster.size(); i++){
            arrMonster.get(i).drawActor(g2d);
        }
    }
    public void drawAllBomb(Graphics2D g2d){
        for (int i = 0; i < arrBomb.size(); i++){
            arrBomb.get(i).drawActor(g2d);
        }
        for (int i = 0; i < arrBombBang.size(); i++){
            arrBombBang.get(i).drawActor(g2d);
        }
    }
    public void drawAllItem(Graphics2D g2d){
        for (int i = 0; i < arrItem.size(); i++){
            arrItem.get(i).drawItem(g2d);
        }
    }
    public void drawInfor(Graphics2D g2d){
        Image image = new ImageIcon(getClass().getResource("/images/heart_1.png")).getImage();
        if (mBomber.getHeart() == 3){
            g2d.drawImage(image,840, 319,null);
            g2d.drawImage(image,865, 319,null);
            g2d.drawImage(image,890, 319,null);
        }
        if (mBomber.getHeart() == 2){
            g2d.drawImage(image,840, 319,null);
            g2d.drawImage(image,865, 319,null);
        }
        if (mBomber.getHeart() == 1){
            g2d.drawImage(image,840, 319,null);;
        }
        g2d.setFont(new Font("Arial", Font.BOLD, 28));
        g2d.setColor(Color.YELLOW);
        g2d.drawString("MAP " + round, 800, 283);
        g2d.setFont(new Font("Arial", Font.BOLD, 18));
        g2d.setColor(Color.YELLOW);
        g2d.drawString("Số mạng: ",750,337);
        g2d.drawString("Số Boom: " + mBomber.getQuantityBomb(), 750, 357);
        g2d.drawString("Kích Thước Boom: " + mBomber.getSizeBomb(), 750, 377);
        g2d.drawString("Tốc độ: " + (10 - mBomber.getSpeed()), 750, 396);
        g2d.drawString("Điểm: " + mBomber.getScore(), 750, 416);
    }
    public void drawDialog(Graphics2D g2d, int type){
        g2d.setFont(new Font("Arial",Font.BOLD,70));
        g2d.setColor(Color.RED);
        if (type == 1){
            g2d.drawString("GAME OVER!!!",200,250);
        }else{
            if (type == 3){
                g2d.drawString("YOU WIN!!!",200,250);
            }else {
                g2d.drawString("GAME OVER!!!",200,250);
            }
        }
    }
    public void changeOrientAll() {
        for (int i = 0; i < arrMonster.size(); i++) {
            int orient = random.nextInt(4) + 1;
            arrMonster.get(i).changeOrient(orient);
        }
    }
    public void moveAllMonster(int count){
        for (int i = 0; i < arrMonster.size(); i++){
            if (!arrMonster.get(i).move(count, arrBox,arrBomb)){
                int orient = random.nextInt(4)+1;
                arrMonster.get(i).changeOrient(orient);
            }
        }
    }
    public void initManager(){
        switch (round){
            case 1:
                setBomBer();
                inits("src/map1/BOX.txt","src/map1/MONSTER.txt","src/map1/ITEM.txt");
                status = 0;
                break;
            default:
                break;
        }
    }
    public void initArrBox(String pathBox){
        try {
            FileReader reader = new FileReader(pathBox);
            BufferedReader bufferedReader = new BufferedReader(reader);
            Background = bufferedReader.readLine();
            String line;
            while ((line = bufferedReader.readLine()) != null){
                String str[] = line.split(":");
                int x = Integer.parseInt(str[0]);
                int y = Integer.parseInt(str[1]);
                int type = Integer.parseInt(str[2]);
                String images = str[3];
                Box box = new Box(x, y, type, images);
                arrBox.add(box);
            }
            bufferedReader.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public void initArrMonster(String pathMonster){
        try {
            FileReader reader = new FileReader(pathMonster);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null){
                String str[] = line.split(":");
                int x = Integer.parseInt(str[0]);
                int y = Integer.parseInt(str[1]);
                int type = Integer.parseInt(str[2]);
                int orient = Integer.parseInt(str[3]);
                int speed = Integer.parseInt(str[4]);
                int heart = Integer.parseInt(str[5]);
                String img = str[6];

                MonterMin monterMin = new MonterMin(x,y,type,orient,speed,heart,img);
                if (type == Monster.Mon){
                    arrMonster.add(monterMin);
                }
            }
            bufferedReader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void initBomb(){
        if (mBomber.getStatus() == Actor.DEAD){
            return;
        }
        int x = mBomber.getX() + mBomber.getWidth()/2;
        int y = mBomber.getY() + mBomber.getHeight()/2;
        for (int i = 0; i < arrBomb.size(); i++){
            if (arrBomb.get(i).isImpact(x,y)){
                return;
            }
        }
        if (arrBomb.size() >= mBomber.getQuantityBomb()){
            return;
        }
        Bomb bomb = new Bomb(x,y,mBomber.getSizeBomb(),1500);
        arrBomb.add(bomb);
    }
    public void innitArrHightScore(String path) {
        try {
            FileReader file = new FileReader(path);
            BufferedReader input = new BufferedReader(file);
            String line;
            while ((line = input.readLine()) != null) {
                String str[] = line.split(":");
                String name = str[0];
                int score = Integer.parseInt(str[1]);
                HighScore hightScore = new HighScore(name, score);
                arrayHighScore.add(hightScore);
            }
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void innitArrItem(String path){
        try {
            FileReader reader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null){
                String str[] = line.split(":");
                int x = Integer.parseInt(str[0]);
                int y = Integer.parseInt(str[1]);
                int type = Integer.parseInt(str[2]);
                String img = str[3];
                Item item = new Item(x,y,type,img);
                arrItem.add(item);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void inits(String pathBox, String pathMonster, String pathItem){
        arrBox = new ArrayList<>();
        arrMonster = new ArrayList<>();
        arrBomb = new ArrayList<>();
        arrBombBang = new ArrayList<>();
        arrayHighScore = new ArrayList<>();
        arrItem = new ArrayList<>();

        initArrBox(pathBox);
        initArrMonster(pathMonster);
        innitArrItem(pathItem);
        innitArrHightScore("src/highscore/HighScore.txt");
    }
    public void setRunBomer(){
        if (arrBomb.size() > 0){
            if (!arrBomb.get(arrBomb.size() - 1).setRun(mBomber)){
                mBomber.setRunBomb(Bomber.DISALLOW_RUN);
            }
        }
    }
    public void deadLineAllBomb(){
        for (int i = 0; i < arrBomb.size(); i++){
            arrBomb.get(i).deadlineBomb();
            if (arrBomb.get(i).getTimeLine() == 250){
                BombBang bombBang = new BombBang(arrBomb.get(i).getX(),arrBomb.get(i).getY(),arrBomb.get(i).getSize(),arrBox);
                Sound.getInstance().getAudio(Sound.BONG_BANG).start();
                Sound.getInstance().getAudio(Sound.BONG_BANG).loop(1);
                arrBombBang.add(bombBang);
                arrBomb.remove(arrBomb.get(i));
            }
        }
        for (int i = 0; i < arrMonster.size(); i++){
            for (int j = 0; j < arrBomb.size(); j++){
                if (arrBomb.get(j).isImpactBombVsActor(arrMonster.get(j)) == 2){
                    BombBang bomBang = new BombBang(arrBomb.get(i).getX(), arrBomb.get(i).getY(),
                            arrBomb.get(i).getSize(), arrBox);
                    Sound.getInstance().getAudio(Sound.BONG_BANG).start();
                    Sound.getInstance().getAudio(Sound.BONG_BANG).loop(1);
                    arrBombBang.add(bomBang);
                    arrBomb.remove(i);
                }
            }
        }
        for (int k = 0; k < arrBombBang.size(); k++){
            arrBombBang.get(k).deadlineBomb();
            for (int i = 0; i < arrMonster.size(); i++){
                if (arrBombBang.get(k).isImpactBombBangVsActor(arrMonster.get(i))){
                    if (arrMonster.get(i).getType() == Monster.Mon){
                        mBomber.setScore(mBomber.getScore()+100);
                    }
                    arrMonster.remove(arrMonster.get(i));
                }
            }
            if (arrBombBang.get(k).getTimeLine() == 0) {
                arrBombBang.remove(arrBombBang.get(k));
            }
        }
        for (int i = 0; i < arrBombBang.size(); i++){
            for (int j = 0; j < arrBomb.size(); j++){
                if (arrBombBang.get(i).isImpactBombBangvsBomb(arrBomb.get(j))){
                    BombBang bombBang = new BombBang(arrBomb.get(j).getX(),arrBomb.get(j).getY(),arrBomb.get(j).getSize(),arrBox);
                    arrBombBang.add(bombBang);
                    arrBomb.remove(i);
                }
            }
        }
        for (int i = 0; i < arrBombBang.size(); i++) {
            for (int j = 0; j < arrBox.size(); j++) {
                if (arrBombBang.get(i).isImpactBombBangVsBox(arrBox.get(j))) {
                    arrBox.remove(arrBox.get(j));
                }
            }
        }

    }
    public void checkDead(){
        for (int i = 0; i < arrBombBang.size(); i++){
            if (arrBombBang.get(i).isImpactBombBangVsActor(mBomber) && mBomber.getStatus() == Bomber.ALIVE){
                Image icon = null;
                if (mBomber instanceof KhoKho){
                    icon = new ImageIcon(getClass().getResource("/images/ghost.png")).getImage();
                }
                mBomber.setImg(icon);
                if (mBomber.getStatus() == Bomber.DEAD){
                    return;
                }
                mBomber.setHeart(mBomber.getHeart()-1);
                mBomber.setStatus(Bomber.DEAD);
            }
        }
        for (int i = 0; i < arrMonster.size(); i++){
            if (mBomber.isImpactBomberVsActor(arrMonster.get(i))){
                Image image = null;
                if (mBomber instanceof KhoKho){
                    image = new ImageIcon(getClass().getResource("/images/ghost.png")).getImage();
                }
                mBomber.setImg(image);
                if (mBomber.getStatus() == Bomber.DEAD) {
                    return;
                }
                mBomber.setHeart(mBomber.getHeart()-1);
                mBomber.setStatus(Bomber.DEAD);
            }
        }
    }
    public void checkImpactVsItem(){
        for (int i = 0; i < arrItem.size(); i++){
            if (arrItem.get(i).isImpactVsBomber(mBomber)){
                if (arrItem.get(i).getType() == Item.ITEM_SIZEBOOM){
                    mBomber.setSizeBomb(mBomber.getSizeBomb()+1);
                    Sound.getInstance().stop();
                    Sound.getInstance().getAudio(Sound.ITEM).start();
                    Sound.getInstance().getAudio(Sound.ITEM).loop(1);
                    arrItem.remove(i);
                    break;
                }
                if (arrItem.get(i).getType() == Item.ITEM_SHOE){
                    mBomber.setSpeed(mBomber.getSpeed() - 1);
                    Sound.getInstance().getAudio(Sound.ITEM).start();
                    Sound.getInstance().getAudio(Sound.ITEM).loop(1);
                    arrItem.remove(i);
                    break;
                }
            }
        }
    }
    public void checkWin(){
        if (mBomber.getHeart() == 0){
            round = 1;
            status = 1;
            Sound.getInstance().stop();
            Sound.getInstance().getAudio(Sound.LOSE).start();
            saveScore();
        }
        if (arrMonster.size() == 0){
            if (round == 1){
                status = 3;
                Sound.getInstance().stop();
                Sound.getInstance().getAudio(Sound.WIN).start();
                saveScore();
                return;
            }
            mBomber.setScore(mBomber.getScore());
            status = 2;
        }
    }
    public void setNewBomb(){
        switch (round){
            case 1:
                mBomber.setNew(540,495);
                break;
            default:break;
        }
    }
    public void saveScore(){
        if (arrayHighScore.size() < 10){
            String name = JOptionPane.showInputDialog("Hãy nhập tên của bạn: ");
            HighScore score = new HighScore(name, mBomber.getScore());
            arrayHighScore.add(score);
        }else if (mBomber.getScore() > arrayHighScore.get(arrayHighScore.size()-1).getScore() && arrayHighScore.size() >=10){
            String name = JOptionPane.showInputDialog("Hãy nhập tên của bạn: ");
            HighScore score = new HighScore(name, mBomber.getScore());
            arrayHighScore.add(score);
        }
        arrayHighScore.sort(new Comparator<HighScore>() {
            @Override
            public int compare(HighScore o1, HighScore o2) {
                if (o1.getScore() < o2.getScore()){
                    return 1;
                }else {
                    if (o1.getScore() == o2.getScore()){
                        return 0;
                    }else {
                        return -1;
                    }
                }
            }
        });
        if (arrayHighScore.size() > 10){
            arrayHighScore.remove(arrayHighScore.size()-1);
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("src/highscore/HighScore.txt");
            for (int i = 0; i < arrayHighScore.size(); i++ ){
                String infor = arrayHighScore.get(i).getName() + ":" +arrayHighScore.get(i).getScore()+"\n";
                fileOutputStream.write(infor.getBytes());
            }
            fileOutputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public ArrayList<Box> getArrBox() {
        return arrBox;
    }

    public ArrayList<Bomb> getArrBomb() {
        return arrBomb;
    }

    public Bomber getmBomber() {
        return mBomber;
    }

    public int getStatus() {
        return status;
    }

    public void setRound(int round) {
        this.round = round;
    }
}
