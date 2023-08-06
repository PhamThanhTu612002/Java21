package Family.service;

import Family.entities.Family;
import Family.entities.Member;

import java.util.ArrayList;
import java.util.Scanner;

public class FamilyService {
    public Family createFamily(Scanner sc,MemberService memberService,ArrayList<Member> members ){
        System.out.println("Mời bạn nhập địa chỉ:");
        String address = sc.nextLine();
        System.out.println("Mời bạn nhập số thành viên:");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n;i++){
            Member member = memberService.createMember(sc);
            members.add(member);
        }
        return new Family(address,members);
    }
}
