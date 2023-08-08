package lab2.entities;

public class Student {
    private int id;
    private static int autoId;
    private String name;
    private double scoreMath;
    private double scorePhysic;
    private double scoreChemistry;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getScoreMath() {
        return scoreMath;
    }

    public void setScoreMath(double scoreMath) {
        this.scoreMath = scoreMath;
    }

    public double getScorePhysic() {
        return scorePhysic;
    }

    public void setScorePhysic(double scorePhysic) {
        this.scorePhysic = scorePhysic;
    }

    public double getScoreChemistry() {
        return scoreChemistry;
    }

    public void setScoreChemistry(double scoreChemistry) {
        this.scoreChemistry = scoreChemistry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(String name, double scoreMath, double scorePhysic, double scoreChemistry) {
        this.id = ++autoId;
        this.name = name;
        this.scoreMath = scoreMath;
        this.scorePhysic = scorePhysic;
        this.scoreChemistry = scoreChemistry;
    }
    public double calAvg(){
        return (this.scoreMath+this.getScoreChemistry()+this.getScorePhysic())/3;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", scoreMath=" + scoreMath +
                ", scorePhysic=" + scorePhysic +
                ", scoreChemistry=" + scoreChemistry +
                '}';
    }
}
