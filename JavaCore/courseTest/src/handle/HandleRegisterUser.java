package handle;

import entities.User;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HandleRegisterUser {
    public String handleUserName(Scanner sc,ArrayList<User> users){
        do {
            System.out.println("Mời bạn nhập username:");
            try {
                String userName = sc.nextLine();
                for (User user : users){
                    if (userName.equals(user.getUserName())){
                        System.out.println("Username đã tồn tại");
                        break;
                    }else {
                        return userName;
                    }
                }
            }catch (Exception e){
                System.out.println("Mời bạn nhập lại!");
            }
        }while (true);
    }
    public String handleEmail(Scanner sc,ArrayList<User> users){
        do {
            System.out.println("Mời bạn nhập email:");
            try {
                String email = sc.nextLine();
                // Định dạng regex cho email

                String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
                // Tạo đối tượng Pattern từ regex

                Pattern pattern = Pattern.compile(regex);
                // Tạo đối tượng Matcher để so khớp chuỗi với regex
                Matcher matcher = pattern.matcher(email);
                for (User user : users){
                    if (!matcher.matches() || email.equals(user.getEmail())){
                        System.out.println("Email chưa hợp lệ hoặc đã tồn tại!");
                        break;
                    }else {
                        return email;
                    }
                }
            }catch (Exception e){
                System.out.println("Mời bạn nhập lại!");
            }
        }while (true);
    }
    public String handlePassWord(Scanner sc){
        do {
            System.out.println("Mời bạn nhập password:");
            try {
                String password = sc.nextLine();

                // Định dạng regex cho mật khẩu
                String regex = "^(?=.*[A-Z])(?=.*[.,-_;])(?=.*[a-zA-Z0-9]).{7,15}$";

                // Tạo đối tượng Pattern từ regex
                Pattern pattern = Pattern.compile(regex);

                // Tạo đối tượng Matcher để so khớp chuỗi với regex
                Matcher matcher = pattern.matcher(password);

                if (!matcher.matches()){
                    System.out.println("Password không hợp lệ!");
                }else {
                    return password;
                }
            }catch (Exception e){
                System.out.println("Mời bạn nhập lại!");
            }
        }while (true);
    }
}
