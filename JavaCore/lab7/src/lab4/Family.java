package lab4;

public class Family {
    private String nameHost;
    private String address;
    private String idElectricMachine;

    public String getNameHost() {
        return nameHost;
    }

    public void setNameHost(String nameHost) {
        this.nameHost = nameHost;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdElectricMachine() {
        return idElectricMachine;
    }

    public void setIdElectricMachine(String idElectricMachine) {
        this.idElectricMachine = idElectricMachine;
    }

    public Family(String nameHost, String address, String idElectricMachine) {
        this.nameHost = nameHost;
        this.address = address;
        this.idElectricMachine = idElectricMachine;
    }

    @Override
    public String toString() {
        return "Family{" +
                "nameHost='" + nameHost + '\'' +
                ", address='" + address + '\'' +
                ", idElectricMachine='" + idElectricMachine + '\'' +
                '}';
    }
}
