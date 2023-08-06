package Family.entities;

import java.time.LocalDate;

public class Member {
    private static int autoid;
    private int id;
    private String name;
    private LocalDate dateOfBirth;
    private String job;

  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Member(String name, LocalDate dateOfBirth, String job) {
        this.id = ++autoid;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.job = job;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}
