package service;

import entities.User;
import handle.HandleLogin;
import handle.HandleRegisterUser;

import java.util.ArrayList;
import java.util.Scanner;

public class UserService {
    HandleRegisterUser handleUser = new HandleRegisterUser();
    HandleLogin handleLogin = new HandleLogin();
    public User registerNewUser(Scanner sc, ArrayList<User> users){
        String userName = handleUser.handleUserName(sc,users);
        String email = handleUser.handleEmail(sc,users);
        String passWord = handleUser.handlePassWord(sc);
        return new User(userName,email,passWord);
    }
    public void login(Scanner sc,ArrayList<User> users){
        handleLogin.handleLogin(sc,users);
    }
}
