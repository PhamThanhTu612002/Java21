package PublicTransport;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean isFlase = false;
        double distance = 0;
        Scanner sc = new Scanner(System.in);
        while (!isFlase){
            System.out.println("Mời bạn nhập quãng đường: ");
            distance = Double.parseDouble(sc.nextLine());
            if (distance >= 0){
                isFlase = true;
            }
        }
        Bus bus = new Bus();
        Plane plane = new Plane();
        Train train = new Train();
        System.out.println("Thời gian xe bus cần đi là: " + bus.calTime(distance) + "h");
        System.out.println("Thời gian tàu hỏa cần đi là: " + train.calTime(distance)+ "h");
        System.out.println("Thời gian máy bay cần đi là: " + plane.calTime(distance)+ "h");

    }
}
