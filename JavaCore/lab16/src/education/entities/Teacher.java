package education.entities;

import sale.entities.Person;

public class Teacher extends Person {
    private String major;
    private String email;
    public Teacher(String name, String phone, String address) {
        super(name, phone, address);
    }

    public Teacher(String name, String phone, String address, String major, String email) {
        super(name, phone, address);
        this.major = major;
        this.email = email;
    }
}
