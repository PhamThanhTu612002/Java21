package sound;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

public class Sound {
    public static Sound instance;
    public static final String MENU = "src/sound/menu.wav";
    public static final String PLAYGAME = "src/sound/playgame.wav";
    public static final String BOMB = "";
    public static final String BOMBER_DIE = "";
    public static final String HOVER = "src/sound/hover.wav";
    public static final String MONSTER_DIE = "";
    public static final String BONG_BANG = "src/sound/bombang.wav";
    public static final String ITEM = "src/sound/pick_item.wav";
    public static final String WIN = "src/sound/wingame.wav";
    public static final String LOSE = "src/sound/gameover.wav";
    public static final String MOVE = "src/sound/move.wav";
    private HashMap<String, Clip> audioMap;

    public Sound() {
        audioMap = new HashMap<>();
        loadAllAudio();
    }
    public static Sound getInstance(){
        if (instance == null){
            instance = new Sound();
        }
        return instance;
    }
    public void loadAllAudio(){
        putAudio(MENU);
        putAudio(PLAYGAME);
        putAudio(HOVER);
        putAudio(MOVE);
        putAudio(ITEM);
        putAudio(BONG_BANG);
        putAudio(LOSE);
        putAudio(WIN);
    }
    public void stop(){
        getAudio(MENU).stop();
        getAudio(PLAYGAME).stop();
        getAudio(HOVER).stop();
        getAudio(MOVE).stop();
        getAudio(ITEM).stop();
        getAudio(BONG_BANG).stop();
        getAudio(LOSE).stop();
        getAudio(WIN).stop();
    }
    public Clip getAudio(String name){
        return audioMap.get(name);
    }
    public void putAudio(String name){
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(name));
            clip.open(audioInputStream);
            audioMap.put(name,clip);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
