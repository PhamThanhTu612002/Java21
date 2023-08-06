package Family;

import Family.entities.Family;
import Family.entities.Member;
import Family.service.FamilyService;
import Family.service.MemberService;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Member> listMembers = new ArrayList<>();
        ArrayList<Family> listFamilies = new ArrayList<>();
        MemberService memberService = new MemberService();
        System.out.println("Mời bạn nhập số hộ dân:");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n;i++){
            FamilyService familyService = new FamilyService();
            listFamilies.add(familyService.createFamily(sc,memberService,listMembers));
        }
        System.out.println(listFamilies);

    }
}
