package data;

import entities.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserData {
    public Map<String,User> userMap(){
        Map<String , User> userMap = new HashMap<>();
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
        userMap.put("phamthanhtu612000",user0);
        userMap.put("phamthanhtu612001",user1);
        userMap.put("phamthanhtu612002",user2);
        userMap.put("phamthanhtu612003",user3);
        userMap.put("phamthanhtu612004",user4);
        userMap.put("phamthanhtu612005",user5);
        userMap.put("phamthanhtu612006",user6);
        userMap.put("phamthanhtu612007",user7);
        userMap.put("phamthanhtu612008",user8);
        userMap.put("phamthanhtu612009",user9);
        return userMap;
    }

}
