package lab2.service;

import lab2.entities.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentService {

    public Student createStudent(Scanner sc){
        System.out.println("Nhập tên: ");
        String name = sc.nextLine();
        System.out.println("Nhập điểm Toán: ");
        double scMa = Double.parseDouble(sc.nextLine());
        System.out.println("Nhập điểm Lý: ");
        double scPhy = Double.parseDouble(sc.nextLine());
        System.out.println("Nhập điểm Hóa: ");
        double scChe = Double.parseDouble(sc.nextLine());
        return new Student(name,scMa,scPhy,scChe);
    }
    public void displayStudent(ArrayList<Student> students){
        for (Student student : students){
            System.out.println("Name: " +student.getName());
            System.out.println("Avg Score: " + student.calAvg());
            if (student.calAvg() >= 8){
                System.out.println("Rank: A");
            } else if (student.calAvg() < 8 && student.calAvg() >= 6.5) {
                System.out.println("Rank: B");
            } else if (student.calAvg() < 6.5) {
                System.out.println("Rank: C");
            }
        }
    }
    public void calPercentRank(ArrayList<Student> students){
        int count = 0;
        int count1 = 0;
        int count2 = 0;
        for (Student student : students){
            if (student.calAvg() >= 8) {
                count++;
            }
            if (student.calAvg() < 8 && student.calAvg() >= 6.5) {
                count1++;
            }
            if (student.calAvg() < 6.5) {
                count2++;
            }
        }
        System.out.println("Có " +(count*100/students.size())+"% học sinh danh A");
        System.out.println("Có " +(count1*100/students.size())+"% học sinh danh B");
        System.out.println("Có " +(count2*100/students.size())+"% học sinh danh C");
    }
}
