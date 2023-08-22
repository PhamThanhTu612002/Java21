import entities.Student;
import service.StudenManager;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Student> studentMap = new HashMap<>();
        StudenManager studenManager = new StudenManager();
        studenManager.addStudent(sc,studentMap);
        studenManager.getStudentById(sc,studentMap);
        studenManager.removeStudent(sc,studentMap);
        studenManager.getAverageScore(studentMap);
        System.out.println(studentMap);
    }
}
