package ManageHospital;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    private static boolean isNum = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Doctor doctor = new Doctor();
        Patient patient = new Patient();

        //Bac si
        System.out.println("Nhap thong tin bac si:");
        System.out.println("Nhap ten:");
        doctor.setName(sc.nextLine());
        System.out.println("Nhap dia chi:");
        doctor.setAddress(sc.nextLine());
        while (!isNum){
            try {
                System.out.println("Nhap tuoi:");
                doctor.setAge(Integer.parseInt(sc.nextLine()));
                if (doctor.getAge()>18){
                    isNum = true;
                }
            }catch (NumberFormatException e){
                System.out.println("Hay nhap so!");
            }
        }
        System.out.println("Nhap chuyen khoa");
        doctor.setChuyenKhoa(sc.nextLine());
        while (isNum){
            try {
                System.out.println("Nhap so gio lam:");
                doctor.setSoGioLam(Integer.parseInt(sc.nextLine()));
                if (doctor.getSoGioLam()>0){
                    isNum = false;
                }
            }catch (NumberFormatException e){
                System.out.println("Hay nhap so!");
            }
        }

        //Benh nhan
        System.out.println("Nhap thong tin benh nhan:");
        System.out.println("Nhap ten benh nhan:");
        patient.setName(sc.nextLine());
        System.out.println("Nhap dia chi benh nhan:");
        patient.setAddress(sc.nextLine());
        while (!isNum){
            try {
                System.out.println("Nhap tuoi benh nhan:");
                patient.setAge(Integer.parseInt(sc.nextLine()));
                if (doctor.getAge()>0){
                    isNum = true;
                }
            }catch (NumberFormatException e){
                System.out.println("Hay nhap so!");
            }
        }
        System.out.println("Nhap so benh an:");
        patient.setSoBenhAn(sc.nextLine());
        System.out.println("Nhap nhay nhap vien:");
        patient.setNgayNhapVien(sc.nextLine());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(patient.getNgayNhapVien(),formatter);
        patient.setNgayNhapVien(String.valueOf(localDate));

        ManageHospital hospital = new ManageHospital();
        hospital.setDoctor(doctor);
        hospital.setPatient(patient);

        System.out.println(hospital);
    }
}
