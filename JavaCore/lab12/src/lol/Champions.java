package lol;

public class Champions {
    private String hair;
    private String weapon;

    public String getHair() {
        return hair;
    }

    public void setHair(String hair) {
        this.hair = hair;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public Champions(String hair, String weapon) {
        this.hair = hair;
        this.weapon = weapon;
    }

}
