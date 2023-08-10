package data;

import entities.User;

import java.util.ArrayList;
import java.util.Scanner;

public class UserData {
    public ArrayList<User> listUser(){
        ArrayList<User> listUser = new ArrayList<>();
        User user0 = new User("phamthanhtu612000","tutuduyduy0@gmail.com","Thanhtu612000");
        User user1 = new User("phamthanhtu612001","tutuduyduy1@gmail.com","Thanhtu612001");
        User user2 = new User("phamthanhtu612002","tutuduyduy2@gmail.com","Thanhtu612002");
        User user3 = new User("phamthanhtu612003","tutuduyduy3@gmail.com","Thanhtu612003");
        User user4 = new User("phamthanhtu612004","tutuduyduy4@gmail.com","Thanhtu612004");
        User user5 = new User("phamthanhtu612005","tutuduyduy5@gmail.com","Thanhtu612005");
        User user6 = new User("phamthanhtu612006","tutuduyduy6@gmail.com","Thanhtu612006");
        User user7 = new User("phamthanhtu612007","tutuduyduy7@gmail.com","Thanhtu612007");
        User user8 = new User("phamthanhtu612008","tutuduyduy8@gmail.com","Thanhtu612008");
        User user9 = new User("phamthanhtu612009","tutuduyduy9@gmail.com","Thanhtu612009");
        listUser.add(user0);
        listUser.add(user1);
        listUser.add(user2);
        listUser.add(user3);
        listUser.add(user4);
        listUser.add(user5);
        listUser.add(user6);
        listUser.add(user7);
        listUser.add(user8);
        listUser.add(user9);
        return  listUser;
    }

}
