package Exam;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isNumber = false;
        //bài 1
//        Product product = new Product();
//        //Input information
//        System.out.println("Input Id:");
//        product.setId(Integer.parseInt(sc.nextLine()));
//        System.out.println("Input Name:");
//        product.setName(sc.nextLine());
//        System.out.println("Input Price:");
//        product.setPrice(Double.parseDouble(sc.nextLine()));
//
//        System.out.println("ID:"+ product.getId() + " -Name:" + product.getName() +
//                " -Price:" +product.getPrice() + " -VAT:" + product.calVAT());

        //bài 2
        Employee employee = new Employee();
        //Input information
        System.out.println("Employee :");
        employee.setId(IdGenerator.getNextId());
        System.out.println("Input Name:");
        employee.setName(sc.nextLine());
        System.out.println("Input Address:");
        employee.setAddress(sc.nextLine());

        while (!isNumber) {
            try {
                System.out.println("Input Age:");
                employee.setAge(Integer.parseInt(sc.nextLine()));
                isNumber = true;
            } catch (NumberFormatException e) {
                System.out.println("Đây không phải là một số. Vui lòng nhập lại.");
            }

        }
        while (isNumber){
            try {
                System.out.println("Input Experience:");
                employee.setExperience(Double.parseDouble(sc.nextLine()));
                isNumber = false;
            }catch (NumberFormatException e){
                System.out.println("Đây không phải là một số. Vui lòng nhập lại.");
            }
        }
        System.out.println("Input PlaceWork:");
        employee.setPlaceWork(sc.nextLine());

        System.out.println(employee);

        //bài 3
//        System.out.println("Nhập số employees cần nhập:");
//        int n = Integer.parseInt(sc.nextLine());
//
//        ArrayList<Employee> list = new ArrayList<>();
//        for (int i = 0; i < n; i++){
//            Employee employee = new Employee();
//            System.out.println("Employee "+(i+1)+":");
//            employee.setId(IdGenerator.getNextId());
//            System.out.println("Input Name:");
//            employee.setName(sc.nextLine());
//            System.out.println("Input Address:");
//            employee.setAddress(sc.nextLine());
//            while (!isNumber) {
//            try {
//                System.out.println("Input Age:");
//                employee.setAge(Integer.parseInt(sc.nextLine()));
//                isNumber = true;
//            } catch (NumberFormatException e) {
//                System.out.println("Đây không phải là một số. Vui lòng nhập lại.");
//            }
//
//        }
//        while (isNumber){
//            try {
//                System.out.println("Input Experience:");
//                employee.setExperience(Double.parseDouble(sc.nextLine()));
//                isNumber = false;
//            }catch (NumberFormatException e){
//                System.out.println("Đây không phải là một số. Vui lòng nhập lại.");
//            }
//        }
//            System.out.println("Input PlaceWork:");
//            employee.setPlaceWork(sc.nextLine());
//
//            list.add(employee);
//        }
//        System.out.println(list);
    }
}
