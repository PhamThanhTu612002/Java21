package TikTok.entities;

public class Follower {
    private static int autoId;
    private int id;
    private String name;
    private String email;
    private int numOfLike;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumOfLike() {
        return numOfLike;
    }

    public void setNumOfLike(int numOfLike) {
        this.numOfLike = numOfLike;
    }

    public Follower(String name, String email, int numOfLike) {
        this.id = ++autoId;
        this.name = name;
        this.email = email;
        this.numOfLike = numOfLike;
    }

    @Override
    public String toString() {
        return "Follower{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", numOfLike=" + numOfLike +
                '}';
    }
}
