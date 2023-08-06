package TikTok;

import TikTok.entities.Follower;
import TikTok.entities.Idol;
import TikTok.entities.Song;
import TikTok.service.FollowerService;
import TikTok.service.IdolService;
import TikTok.service.SongService;
import TikTok.service.TikTokService;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TikTokService tikTokService = new TikTokService();
        ArrayList<Idol> idols = new ArrayList<>();
        ArrayList<Song> songs = new ArrayList<>();
        IdolService idolService = new IdolService();
        SongService songService = new SongService();
        ArrayList<Follower> followers = new ArrayList<>();
        FollowerService followerService = new FollowerService();
        System.out.println(tikTokService.createTikTok(sc,idols,songs,idolService,songService,followers,followerService));
    }
}
