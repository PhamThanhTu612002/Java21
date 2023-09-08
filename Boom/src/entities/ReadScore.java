package entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadScore {
    private ArrayList<HighScore> arrHighScore;

    public ReadScore() {
        arrHighScore = new ArrayList<>();
        try {
            FileReader reader = new FileReader("src/highscore/HighScore.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null){
                String str[] = line.split(":");
                String name = str[0];
                int score = Integer.parseInt(str[1]);
                HighScore score1 = new HighScore(name,score);
                arrHighScore.add(score1);
            }
            bufferedReader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public ArrayList<HighScore> getArrHighScore() {
        return arrHighScore;
    }

    public void setArrHighScore(ArrayList<HighScore> arrHighScore) {
        this.arrHighScore = arrHighScore;
    }
}
