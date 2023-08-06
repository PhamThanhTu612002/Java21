package TikTok.service;

import TikTok.entities.Song;

import java.util.Scanner;

public class SongService {
    public Song creatSong(Scanner sc){
        System.out.println("Nhập tên bài hát: ");
        String name = sc.nextLine();
        System.out.println("Nhập tên ca sĩ: ");
        String singer = sc.nextLine();
        return new Song(name,singer);
    }
}
