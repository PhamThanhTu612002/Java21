package ManageRankedMatch.service;

import ManageRankedMatch.entities.Figure;

import java.util.Scanner;

public class FigureService {
    public Figure createFigure(Scanner sc){
        System.out.println("Nhập tên tướng: ");
        String name = sc.nextLine();
        System.out.println("Nhập vị trí: ");
        String position = sc.nextLine();
        return new Figure(name,position);
    }
}
