package TikTok.service;

import TikTok.entities.Follower;
import TikTok.entities.Idol;
import TikTok.entities.Song;
import TikTok.entities.TikTok;

import java.util.ArrayList;
import java.util.Scanner;

public class TikTokService {
    public TikTok createTikTok(Scanner sc, ArrayList<Idol> idols, ArrayList<Song> songs,
                               IdolService idolService, SongService songService, ArrayList<Follower> followers,
                               FollowerService followerService){
        boolean isFalse = false;
        while (!isFalse){
            System.out.println("Nhập số idol: ");
            int n = Integer.parseInt(sc.nextLine());
            if (n > 0){
                isFalse = true;
            }
            for (int i = 0; i < n; i++){
                idols.add(idolService.createIdol(sc,followers,followerService));
            }
        }
        while (isFalse){
            System.out.println("Nhập số bài hát");
            int k = Integer.parseInt(sc.nextLine());
            if (k > 0){
                isFalse = false;
            }
            for (int i = 0; i < k; i++){
                songs.add(songService.creatSong(sc));
            }
        }
        return new TikTok(idols,songs);
    }
}
