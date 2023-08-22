package service;

import entities.Student;

import java.util.Map;
import java.util.Scanner;

public class StudenManager {

    public void addStudent(Scanner sc, Map<Integer, Student> studentMap){
        System.out.println("Nhập số học sinh cần nhâp:");
        int n = Integer.parseInt(sc.nextLine());
        while (n > 0){
            System.out.println("Nhập tên: ");
            String name = sc.nextLine();
            System.out.println("Nhập điểm:");
            double diem = Double.parseDouble(sc.nextLine());
            Student student = new Student(name, diem);
            studentMap.put(student.getId(), student);
            n--;
        }
    }
    public void removeStudent(Scanner sc,Map<Integer, Student> studentMap){
        System.out.println("Nhập id cần xóa: ");
        int id = Integer.parseInt(sc.nextLine());
        studentMap.remove(id);
    }
    public void getStudentById(Scanner sc,Map<Integer, Student> studentMap){
        System.out.println("Nhập id cần tìm: ");
        int id = Integer.parseInt(sc.nextLine());
        studentMap.get(id);
    }
    public void getAverageScore(Map<Integer, Student> studentMap){
        double tong = 0;
        for (Map.Entry<Integer,Student> entry : studentMap.entrySet()){
            tong = tong + entry.getValue().getScore();
        }
        System.out.println("Điểm trung bình = "+ tong/studentMap.size());
    }
}
