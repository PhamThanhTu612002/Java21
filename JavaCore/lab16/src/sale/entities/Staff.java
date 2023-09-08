package sale.entities;

public class Staff extends Person {
    private String email;


    public Staff(String name, String phone, String address) {
        super(name, phone, address);
    }

    public Staff(String name, String phone, String address, String email) {
        super(name, phone, address);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
