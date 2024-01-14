package vn.techmaster.movieapp.model;

public enum Role {
    USER("User"),
    ADMIN("Admin");

    private final String value;
    Role(String value) {
        this.value = value;
    }
}
