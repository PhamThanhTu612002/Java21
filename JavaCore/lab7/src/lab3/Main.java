package lab3;

import lab3.entities.HistorySalary;
import lab3.entities.Worker;
import lab3.service.WorkerService;
import lab3.view.Menu;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Worker> workers = new ArrayList<>();
        ArrayList<HistorySalary> historySalaries = new ArrayList<>();
        WorkerService workerService  = new WorkerService();
        Menu menu = new Menu();
        menu.mainMenu();
        int choice;
        do {
            choice = menu.selectMenu(sc);
            menu.menuNavigation(choice,sc,workers,workerService,historySalaries);
        }while (choice < 5 && choice > 0);


    }
}
