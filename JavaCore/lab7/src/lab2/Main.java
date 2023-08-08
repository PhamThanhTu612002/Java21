package lab2;

import lab2.entities.Student;
import lab2.service.StudentService;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        StudentService studentService = new StudentService();

        System.out.println("Nhập số học sinh cần nhâp: ");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++){
                students.add(studentService.createStudent(sc));
        }
        studentService.displayStudent(students);
        studentService.calPercentRank(students);
    }
}
