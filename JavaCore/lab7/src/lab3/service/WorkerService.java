package lab3.service;

import lab3.entities.HistorySalary;
import lab3.entities.Worker;
import lab3.handle.WorkerHandle;

import java.util.ArrayList;
import java.util.Scanner;

public class WorkerService {
    double newSalary;
    private WorkerHandle handle = new WorkerHandle();
    public Worker createWorker(Scanner sc){
        System.out.println("Enter name: ");
        String name = sc.nextLine();
        int age = handle.handleAge(sc);
        double salary = handle.handleSalary(sc);
        System.out.println("Enter work place: ");
        String workPlace = sc.nextLine();
        return new Worker(name,age,salary,workPlace);
    }
    public void workersList(Scanner sc, WorkerService workerService, ArrayList<Worker> workers){
        Worker worker = workerService.createWorker(sc);
        workers.add(worker);
    }
    public ArrayList<HistorySalary> updateSalary(Scanner sc,ArrayList<Worker> workers,ArrayList<HistorySalary> historySalaries){
        do {
            System.out.println("Enter id: ");
            String searchedID = sc.nextLine();
            System.out.println("Update salary: ");
            newSalary = handle.handleNewSalary(sc);
            for (Worker worker : workers){
                do {
                    if (!worker.getId().equals(searchedID)){
                        System.out.println("Không có id này!");
                        break;
                    }else {
                        HistorySalary historySalary;
                        if (newSalary > 0){
                            historySalary = new HistorySalary(worker,"UP",newSalary + worker.getSalary());
                            historySalaries.add(historySalary);
                            worker.setSalary(newSalary+worker.getSalary());
                        }else{
                            historySalary = new HistorySalary(worker,"DOWN",newSalary + worker.getSalary());
                            historySalaries.add(historySalary);
                            worker.setSalary(newSalary+worker.getSalary());
                        }
                    }
                }while (!worker.getId().equals(searchedID));
            }
            return historySalaries;
        } while (true);
    }
    public void displayInfor(ArrayList<HistorySalary> historySalaries){
            System.out.println(historySalaries);
    }


}
