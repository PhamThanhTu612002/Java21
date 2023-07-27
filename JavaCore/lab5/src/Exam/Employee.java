package Exam;


public class Employee extends Person{
    private double experience;
    private String placeWork;

    public double getExperience() {
        return experience;
    }

    public void setExperience(double experience) {
        this.experience = experience;
    }

    public String getPlaceWork() {
        return placeWork;
    }

    public void setPlaceWork(String placeWork) {
        this.placeWork = placeWork;
    }

    @Override
    public String toString() {
        return "Employee{" +
                super.toString() +
                ", experience=" + experience +
                ", placeWork='" + placeWork + '\'' +
                '}';
    }
}
