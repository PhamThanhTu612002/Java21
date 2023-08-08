package lab3.entities;

import java.time.LocalDate;

public class HistorySalary {
    private Worker worker;
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

    public HistorySalary(Worker worker, String status) {
        this.worker = worker;
        this.status = status;
        this.date = LocalDate.now();
    }

    @Override
    public String toString() {
        return "HistorySalary{" +
                "worker=" + worker +
                ", status='" + status + '\'' +
                ", date=" + date +
                '}';
    }
}
