package handle;

import entities.User;
import utils.RegexUser;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;

public class HandleUser {
    RegexUser regexUser = new RegexUser();
    public int handleChoice(Scanner sc){
        do {
            System.out.println("Nhập lựa chọn:");
            try {
                return Integer.parseInt(sc.nextLine());
            }catch (Exception e){
                System.out.println("Vui lòng nhập lại lựa chọn!");
            }
        }while (true);
    }
    public String handleUserName(Scanner sc, Map<String,User> userMap){
        do {
            System.out.println("Mời bạn nhập username:");
            try {
                int count = 0;
                String username = sc.nextLine();
                for (Map.Entry<String, User> user : userMap.entrySet()){
                    if (username.equals(user.getValue().getUserName())){
                        count++;
                    }
                }
                if (count == 0){
                    return username;
                }else {
                    System.out.println("Username đã tồn tại!");
                }
            }catch (Exception e){
                System.out.println("Mời bạn nhập lại!");
            }
        }while (true);
    }
    public String handleEmail(Scanner sc,Map<String,User> userMap){
        do {
            System.out.println("Mời bạn nhập email:");
            try {
                String email = sc.nextLine();
                Matcher matcher = regexUser.regexUserName(sc,email);
                int count = 0;
                for (Map.Entry<String, User> user : userMap.entrySet()){
                    if (!matcher.matches() || email.equals(user.getValue().getEmail())){
                        count++;
                    }
                }
                if (count == 0){
                    return email;
                }else {
                    System.out.println("Email đã tồn tại hoặc sai định dạng!");
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
                Matcher matcher = regexUser.regexPassword(sc,password);
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
