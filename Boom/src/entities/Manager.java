package entities;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Manager {
    private Bomber mBomber;
    private String Background;
    private ArrayList<Box> arrBox;
    private ArrayList<Box> arrShawDow;
    public int round = 1;
    private int nextRound = 0;
    private int status = 0;
    public Manager(){
        initManager();
    }
    public void setBomBer() {
        mBomber = new KhoKho(540, 495,Bomber.DOWN, 5, 1);
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
    public void drawAllShawDow(Graphics2D g2d) {
        for (int i = 0; i < arrShawDow.size(); i++) {
            arrShawDow.get(i).drawBox(g2d);
        }
    }
    public void initManager(){
        switch (round){
            case 1:
                setBomBer();
                inits("src/map1/BOX.txt","src/map1/SHADOW.txt","","");
                nextRound =0;
                status = 0;
                break;
            case 2:
                mBomber.setNew(540,495);
                inits("src/map2/BOX.txt","src/map2/SHADOW.txt","","");
                nextRound =0;
                status = 0;
                break;
            default:
                break;
        }
    }
    public void initArrBox(String pathBox, String pathShadow){
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

        try {
            FileReader fileShawDow = new FileReader(pathShadow);
            BufferedReader inputShawDow = new BufferedReader(fileShawDow);
            String line;
            while ((line = inputShawDow.readLine()) != null) {
                String str[] = line.split(":");
                int x = Integer.parseInt(str[0]);
                int y = Integer.parseInt(str[1]);
                int type = Integer.parseInt(str[2]);
                String images = str[3];
                Box box = new Box(x, y, type, images);
                arrShawDow.add(box);
            }
            inputShawDow.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void inits(String pathBox, String pathShadow, String pathMonster, String pathItem){
        arrBox = new ArrayList<Box>();
        arrShawDow = new ArrayList<>();
        initArrBox(pathBox,pathShadow);
    }
    public ArrayList<Box> getArrBox() {
        return arrBox;
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
