package utils;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUser {
    public Matcher regexUserName(Scanner sc,String email){
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(email);
    }
    public Matcher regexPassword(Scanner sc,String password){
        String regex = "^(?=.*[A-Z])(?=.*[.,-_;])(?=.*[a-zA-Z0-9]).{7,15}$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(password);
    }
}
