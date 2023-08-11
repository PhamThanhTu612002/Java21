package lab3.entities;

import java.time.LocalDate;

public class HistorySalary {
    private Worker worker;
    private double newSalary;
    private String status;
    private LocalDate date;

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getNewSalary() {
        return newSalary;
    }

    public void setNewSalary(double newSalary) {
        this.newSalary = newSalary;
    }

    public HistorySalary(Worker worker, String status, double newSalary) {
        this.worker = worker;
        this.status = status;
        this.date = LocalDate.now();
        this.newSalary = newSalary;
    }

    @Override
    public String toString() {
        return "HistorySalary{" +
                "workerID=" + worker.getId() +
                "workerName=" + worker.getName()+
                ", newSalary=" + newSalary +
                ", status='" + status + '\'' +
                ", date=" + date +
                '}';
    }
}
