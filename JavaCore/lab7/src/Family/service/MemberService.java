package Family.service;

import Family.entities.Member;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MemberService {
    public Member createMember(Scanner sc){
        System.out.println("Mời bạn nhập tên:");
        String name = sc.nextLine();
        System.out.println("Mời bạn nhập ngày sinh:");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dob = LocalDate.parse(sc.nextLine(),formatter);
        System.out.println("Mời bạn nhập nghề: ");
        String job = sc.nextLine();
        return  new Member(name,dob,job);
    }
}
