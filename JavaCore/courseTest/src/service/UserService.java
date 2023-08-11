package service;

import entities.User;
import handle.HandleUser;
import views.MenuUser;

import java.util.ArrayList;
import java.util.Scanner;

public class UserService {
    HandleUser handleUser = new HandleUser();
    MenuUser menuUser = new MenuUser();

    public void homePage(Scanner sc,UserService userService, ArrayList<User> users){
        boolean isFalse = false;
        do {
            menuUser.homePage();
            int choice = handleUser.handleChoice(sc);
            switch (choice) {
                case 1 -> {
                    userService.login(sc, users);
                    isFalse = true;
                }
                case 2 -> users.add(userService.registerNewUser(sc, users));
                default -> {
                }
            }
        }while (!isFalse);
    }
    public User registerNewUser(Scanner sc, ArrayList<User> users){
        String userName = handleUser.handleUserName(sc,users);
        String email = handleUser.handleEmail(sc,users);
        String passWord = handleUser.handlePassWord(sc);
        return new User(userName,email,passWord);
    }
    public void login(Scanner sc, ArrayList<User> users){
        boolean isFalse = false;
        int count = 0;
        do {
                System.out.println("Username: ");
                String username = sc.nextLine();
                System.out.println("Password: ");
                String password = sc.nextLine();
            try {
                for (User user : users){
                    successLogin(sc,users,user,username,password);
                    loginAgain(sc,users,user,username,password);
                    if (!username.equals(user.getUserName())){
                        count++;
                    }
                }
                if (count == users.size()){
                    System.out.println("Kiểm tra lại username!");
                    this.login(sc,users);
                }
                isFalse = true;
            }catch (Exception e){
                System.out.println("Mời bạn nhập lại!");
            }
        }while (!isFalse);
    }
    public void successLogin(Scanner sc,ArrayList<User>users,User user, String username, String password){
        boolean isFalse = false;
        if (username.equals(user.getUserName()) && password.equals(user.getPassWord())){
            System.out.println("Đăng nhập thành công!");
            do {
                menuUser.mainMenu();
                int choice = handleUser.handleChoice(sc);
                switch (choice) {
                    case 1 -> changeUsername(sc, users, user, handleUser);
                    case 2 -> changeEmail(sc, users, user, handleUser);
                    case 3 -> changePassword(sc, user, handleUser);
                    case 4 -> {
                        System.out.println("Đăng xuất thành công!");
                        this.homePage(sc, this, users);
                    }
                    case 0 -> isFalse = true;
                }
            }while (!isFalse);
        }
    }
    public void loginAgain(Scanner sc,ArrayList<User>users,User user, String username, String password){
        if (username.equals(user.getUserName()) && !password.equals(user.getPassWord())){
            System.out.println("Sai mật khẩu!");
            menuUser.loginPage();
            int choice = handleUser.handleChoice(sc);
            switch (choice) {
                case 1 -> this.login(sc, users);
                case 2 -> {
                    handleForgetPassword(sc, users, username);
                    homePage(sc, this, users);
                }
            }
        }
    }
    public void handleForgetPassword(Scanner sc, ArrayList<User> users,String username){
        int count = 0;
        do {
            System.out.println("Xác nhận email: ");
            try {
                String email = sc.nextLine();
                for (User user : users){
                    if (email.equals(user.getEmail()) && username.equals(user.getUserName())){
                        System.out.println("Nhập mật khẩu mới: ");
                        String newPassword = handleUser.handlePassWord(sc);
                        user.setPassWord(newPassword);
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
    public void changeUsername(Scanner sc, ArrayList<User> users, User user, HandleUser handleUser){
        String username = handleUser.handleUserName(sc,users);
        user.setUserName(username);
        System.out.println("Cập nhật username thành công!");
        System.out.println(user);
    }
    public void changeEmail(Scanner sc, ArrayList<User> users, User user, HandleUser handleUser){
        String email = handleUser.handleEmail(sc,users);
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
