package views;

import entities.User;

public class MenuUser {
    public void homePage(){
        System.out.println("1 - Đăng nhập");
        System.out.println("2 - Đăng ký");
    }
    public void loginPage(){
        System.out.println("1 - Đăng nhập lại");
        System.out.println("2 - Quên mật khẩu");
    }
    public void mainMenu(){
        System.out.println("1 - Thay đổi username");
        System.out.println("2 - Thay đổi email");
        System.out.println("3 - Thay đổi mật khẩu");
        System.out.println("4 - Đăng xuất");
        System.out.println("0 - Thoát chương trình");
    }

}
