package education.entities;

import sale.entities.Person;

public class Student extends Person {
    private String email;
    private double avgScore;
    public Student(String name, String phone, String address) {
        super(name, phone, address);
    }

    public Student(String name, String phone, String address, String email, double avgScore) {
        super(name, phone, address);
        this.email = email;
        this.avgScore = avgScore;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(double avgScore) {
        this.avgScore = avgScore;
    }
}
