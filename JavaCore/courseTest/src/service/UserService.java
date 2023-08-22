package service;

import entities.User;
import handle.HandleUser;
import views.MenuUser;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class UserService {
    HandleUser handleUser = new HandleUser();
    MenuUser menuUser = new MenuUser();

    public void homePage(Scanner sc, UserService userService, Map<String,User> userMap){
        boolean isFalse = false;
        do {
            menuUser.homePage();
            int choice = handleUser.handleChoice(sc);
            switch (choice) {
                case 1 -> {
                    userService.login(sc, userMap);
                    isFalse = true;
                }
                case 2 -> userService.registerNewUser(sc,userMap);
                default -> {
                }
            }
        }while (!isFalse);
    }
    public Map<String, User> registerNewUser(Scanner sc, Map<String,User> userMap){
        String userName = handleUser.handleUserName(sc,userMap);
        String email = handleUser.handleEmail(sc,userMap);
        String passWord = handleUser.handlePassWord(sc);
        userMap.put(userName,new User(userName,email,passWord));
        return userMap;
    }
    public void login(Scanner sc, Map<String,User> userMap){
        boolean isFalse = false;
        int count = 0;
        do {
                System.out.println("Username: ");
                String username = sc.nextLine();
                System.out.println("Password: ");
                String password = sc.nextLine();
            try {
                for (Map.Entry<String, User> user : userMap.entrySet()){
                    successLogin(sc,userMap,user.getValue(),username,password);
                    loginAgain(sc,userMap,user.getValue(),username,password);
                    if (!username.equals(user.getValue().getUserName())){
                        count++;
                    }
                }
                if (count == userMap.size()){
                    System.out.println("Kiểm tra lại username!");
                    this.login(sc,userMap);
                }
                isFalse = true;
            }catch (Exception e){
                System.out.println("Mời bạn nhập lại!");
            }
        }while (!isFalse);
    }
    public void successLogin(Scanner sc,Map<String,User> userMap,User user, String username, String password){
        boolean isFalse = false;
        if (username.equals(user.getUserName()) && password.equals(user.getPassWord())){
            System.out.println("Đăng nhập thành công!");
            do {
                menuUser.mainMenu();
                int choice = handleUser.handleChoice(sc);
                switch (choice) {
                    case 1 -> changeUsername(sc, userMap, user, handleUser);
                    case 2 -> changeEmail(sc, userMap, user, handleUser);
                    case 3 -> changePassword(sc, user, handleUser);
                    case 4 -> {
                        System.out.println("Đăng xuất thành công!");
                        this.homePage(sc, this, userMap);
                    }
                    case 0 -> isFalse = true;
                }
            }while (!isFalse);
        }
    }
    public void loginAgain(Scanner sc,Map<String,User> userMap,User user, String username, String password){
        if (username.equals(user.getUserName()) && !password.equals(user.getPassWord())){
            System.out.println("Sai mật khẩu!");
            menuUser.loginPage();
            int choice = handleUser.handleChoice(sc);
            switch (choice) {
                case 1 -> this.login(sc, userMap);
                case 2 -> {
                    handleForgetPassword(sc, userMap, username);
                    homePage(sc, this, userMap);
                }
            }
        }
    }
    public void handleForgetPassword(Scanner sc, Map<String, User> userMap,String username){
        int count = 0;
        do {
            System.out.println("Xác nhận email: ");
            try {
                String email = sc.nextLine();
                for (Map.Entry<String, User> user : userMap.entrySet()){
                    if (email.equals(user.getValue().getEmail()) && username.equals(user.getValue().getUserName())){
                        System.out.println("Nhập mật khẩu mới: ");
                        String newPassword = handleUser.handlePassWord(sc);
                        user.getValue().setPassWord(newPassword);
                        System.out.println("Đổi mật khẩu thành công!");
                        count++;
                    }
                }
                if (count == 0){
                    System.out.println("Email không chính xác!");
                }
            }catch (Exception e){
                System.out.println("Mời bạn nhập lại!");
            }
        }while (count == 0);
    }
    public void changeUsername(Scanner sc, Map<String,User> userMap, User user, HandleUser handleUser){
        String username = handleUser.handleUserName(sc,userMap);
        user.setUserName(username);
        System.out.println("Cập nhật username thành công!");
        System.out.println(user);
    }
    public void changeEmail(Scanner sc, Map<String,User> userMap, User user, HandleUser handleUser){
        String email = handleUser.handleEmail(sc,userMap);
        user.setEmail(email);
        System.out.println("Cập nhật email thành công!");
        System.out.println(user);
    }
    public void changePassword(Scanner sc, User user, HandleUser handleUser){
        String password = handleUser.handlePassWord(sc);
        user.setPassWord(password);
        System.out.println("Cập nhật password thành công!");
        System.out.println(user);
    }
}
