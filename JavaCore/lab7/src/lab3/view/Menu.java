package lab3.view;

import lab3.entities.HistorySalary;
import lab3.entities.Worker;
import lab3.service.WorkerService;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public void mainMenu(){
        System.out.println("1. Add worker");
        System.out.println("2. Up salary");
        System.out.println("3. Down salary");
        System.out.println("4. Display information salary");
        System.out.println("5. Exit");
    }
    public int selectMenu(Scanner scanner){
        do {
            System.out.println("Please choose: ");
            try {
                return Integer.parseInt(scanner.nextLine());
            }catch (Exception e){
                System.out.println("try again!");
            }
        } while (true);
    }
    public void menuNavigation(int choice, Scanner sc, ArrayList<Worker> workers, WorkerService workerService, ArrayList<HistorySalary> historySalaries){
        switch (choice){
            case 1:
                workerService.workersList(sc,workerService,workers);
                break;
            case 2:
                workerService.updateSalary(sc,workers,historySalaries);
                break;
            case 3:
                workerService.updateSalary(sc,workers,historySalaries);
                break;
            case 4:
                workerService.displayInfor(historySalaries);
                break;
            case 5:
                break;
        }
    }
}
