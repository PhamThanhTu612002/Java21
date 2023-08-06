package TikTok.service;

import TikTok.entities.Follower;
import TikTok.entities.Idol;
import TikTok.entities.Song;

import java.util.ArrayList;
import java.util.Scanner;

public class IdolService {
    public Idol createIdol(Scanner sc, ArrayList<Follower> followers,FollowerService followerService){
        boolean isFalse = false;
        System.out.println("Nhâp tên idol: ");
        String name = sc.nextLine();
        System.out.println("Nhập email :");
        String email = sc.nextLine();
        while (!isFalse){
            System.out.println("Nhập số người theo dõi: ");
            int n = Integer.parseInt(sc.nextLine());
            if (n >= 0){
                isFalse = true;
            }
            for (int i = 0; i < n; i++){
                followers.add(followerService.creatFollower(sc));
            }
        }
        System.out.println("Nhập nhóm: ");
        String group = sc.nextLine();
        return new Idol(name,email,followers,group);
    }
}
