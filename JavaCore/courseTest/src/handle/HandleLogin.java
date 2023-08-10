package handle;

import entities.User;
import views.MenuUser;

import java.util.ArrayList;
import java.util.Scanner;

public class HandleLogin {
    MenuUser menuUser = new MenuUser();
    public User handleLogin(Scanner sc, ArrayList<User> users){
        do {
            try {
                System.out.println("Username: ");
                String username = sc.nextLine();
                System.out.println("Password: ");
                String password = sc.nextLine();
                for (User user : users){
                    if (!username.equals(user.getUserName()) && !password.equals(user.getPassWord())){
                        System.out.println("Kiểm tra lại username");
                        break;
                    }else if (username.equals(user.getUserName()) && !password.equals(user.getPassWord())){
                        System.out.println("Sai mật khẩu!");
                        menuUser.loginPage();
                        System.out.println("Nhập lựa chọn: ");
                        int choice = Integer.parseInt(sc.nextLine());
                        switch (choice){
                            case 1:
                                this.handleLogin(sc,users);
                                break;
                            case 2:
                                handleForgetPassword(sc,users);
                                this.handleLogin(sc,users);
                                break;
                        }
                    }else {
                        System.out.println("Đăng nhập thành công!");
                        menuUser.mainMenu();
                        System.out.println("Nhập lựa chọn: ");
                        int choice = Integer.parseInt(sc.nextLine());
                        switch (choice){
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                            case 0:
                                break;
                        }
                        return user;
                    }
                }
            }catch (Exception e){
                System.out.println("Mời bạn nhập lại!");
            }
        }while (true);
    }
    public String handleForgetPassword(Scanner sc, ArrayList<User> users){
        do {
            System.out.println("Xác nhận email: ");
            try {
                String email = sc.nextLine();
                for (User user : users){
                    if (!email.equals(user.getEmail())){
                        System.out.println("Email chưa tồn tại!");
                        break;
                    }else {
                        System.out.println("Nhập mật khẩu mới: ");
                        user.setPassWord(sc.nextLine());
                        return "Đổi mật khẩu thành công!";
                    }
                }
            }catch (Exception e){
                System.out.println("Mời bạn nhập lại!");
            }
        }while (true);
    }
}
