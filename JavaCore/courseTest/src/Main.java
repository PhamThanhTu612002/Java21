import data.UserData;
import entities.User;
import service.UserService;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserData userData = new UserData();
        UserService userService = new UserService();
        ArrayList<User> users = userData.listUser();
        System.out.println("Nhập lựa chon: ");
        int choice = Integer.parseInt(sc.nextLine());
        switch (choice){
            case 1:
                userService.login(sc,users);
                break;
            case 2:
                users.add(userService.registerNewUser(sc,users));
                break;
        }
    }
}