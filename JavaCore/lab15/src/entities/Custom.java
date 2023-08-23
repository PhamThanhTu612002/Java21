package entities;

import java.util.Map;

public class Custom {
    private String name;
    private String address;
    private String phone;
    private Map<Integer, Phone> phoneMap;
    private double money;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Map<Integer, Phone> getPhoneMap() {
        return phoneMap;
    }

    public void setPhoneMap(Map<Integer, Phone> phoneMap) {
        this.phoneMap = phoneMap;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Custom(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.phoneMap = null;
        this.money = 0;
    }

    public Custom(String name, String address, String phone, Map<Integer, Phone> phoneMap, double money) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.phoneMap = phoneMap;
        this.money = money;
    }

    @Override
    public String toString() {
        return "Custom{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", phoneMap=" + phoneMap +
                ", money=" + money +
                '}';
    }
}
