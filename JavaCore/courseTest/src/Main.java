import data.UserData;
import entities.User;
import service.UserService;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserData userData = new UserData();
        UserService userService = new UserService();
        Map<String,User> userMap = userData.userMap();
        userService.homePage(sc,userService,userMap);
    }
}