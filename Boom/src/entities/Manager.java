package entities;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Manager {
    private Random random = new Random();
    private Bomber mBomber;
    private String Background;
    private ArrayList<Box> arrBox;
    private ArrayList<Monster> arrMonster;
    private ArrayList<Bomb> arrBomb;
    private ArrayList<BombBang> arrBombBang;
    public int round = 1;
    private int nextRound = 0;
    private int status = 0;
    public Manager(){
        initManager();
    }
    public void setBomBer() {
        mBomber = new KhoKho(540, 495,Actor.BOMBER,Bomber.DOWN,1, 5, 1);
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
                inits("src/map1/BOX.txt","src/map1/MONSTER.txt","");
                nextRound =0;
                status = 0;
                break;
            case 2:
                mBomber.setNew(540,495);
                inits("src/map2/BOX.txt","src/map1/MONSTER.txt","");
                nextRound =0;
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
        Bomb bomb = new Bomb(x,y,mBomber.getSizeBomb(),1500);
        arrBomb.add(bomb);
    }
    public void inits(String pathBox, String pathMonster, String pathItem){
        arrBox = new ArrayList<Box>();
        arrMonster = new ArrayList<Monster>();
        arrBomb = new ArrayList<>();
        arrBombBang = new ArrayList<>();

        initArrBox(pathBox);
        initArrMonster(pathMonster);
    }
    public void setRunBomer(){
        if (arrBomb.size() > 0){
            if (arrBomb.get(arrBomb.size()-1).setRun(mBomber) == false){
                mBomber.setRunBomb(Bomber.DISALLOW_RUN);
            }
        }
    }
    public void deadLineAllBomb(){
        for (int i = 0; i < arrBomb.size(); i++){
            arrBomb.get(i).deadlineBomb();
            if (arrBomb.get(i).getTimeLine() == 250){
                BombBang bombBang = new BombBang(arrBomb.get(i).getX(),arrBomb.get(i).getY(),arrBomb.get(i).getSize(),arrBox);
                arrBombBang.add(bombBang);
                arrBomb.remove(i);
            }
        }
        for (int k = 0; k < arrBombBang.size(); k++){
            arrBombBang.get(k).deadlineBomb();
            for (int j = 0; j < arrMonster.size(); j++){
                if (arrBombBang.get(k).isImpactBombVsActor(arrMonster.get(j))){
                    arrMonster.remove(j);
                }
            }
            if (arrBombBang.get(k).getTimeLine() == 0){
                arrBombBang.remove(k);
            }
        }
        for (int i = 0; i < arrBombBang.size(); i++){
            for (int j = 0; j < arrBomb.size(); j++){
                if (arrBombBang.get(i).isImpactBombVsBomb(arrBomb.get(j))){
                    BombBang bombBang = new BombBang(arrBomb.get(j).getX(),arrBomb.get(j).getY(),arrBomb.get(j).getSize(),arrBox);
                    arrBombBang.add(bombBang);
                    arrBomb.remove(i);
                }
            }
        }
        for (int k = 0; k < arrBombBang.size(); k++){
            arrBombBang.get(k).deadlineBomb();
            for (int j = 0; j < arrBox.size(); j++){
                if (arrBombBang.get(k).isImpactBombVsBox(arrBox.get(j))){
                    arrBox.remove(j);
                }
            }
            if (arrBombBang.get(k).getTimeLine() == 0){
                arrBombBang.remove(k);
            }
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
