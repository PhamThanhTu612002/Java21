import data.UserData;
import entities.User;
import service.UserService;
import views.MenuUser;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserData userData = new UserData();
        UserService userService = new UserService();
        ArrayList<User> users = userData.listUser();
        userService.homePage(sc,userService,users);
    }
}