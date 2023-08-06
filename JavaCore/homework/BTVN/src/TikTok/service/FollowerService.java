package TikTok.service;

import TikTok.entities.Follower;

import java.util.Scanner;

public class FollowerService {
    public Follower creatFollower(Scanner sc) {
        boolean isFalse = false;
        System.out.println("Nhập tên người theo dõi: ");
        String name = sc.nextLine();
        System.out.println("Nhập email: ");
        String email = sc.nextLine();
        int nol = 0;
        while (!isFalse) {
            System.out.println("Nhập số lượt like: ");
            nol = Integer.parseInt(sc.nextLine());
            if (nol >= 0) {
                isFalse = true;
            }
        }
        return new Follower(name, email, nol);
    }
}
