package lab4;

public class Bill {
    private Family family;
    private double oldNum;
    private double newNum;
    private double priceElec;

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public double getOldNum() {
        return oldNum;
    }

    public void setOldNum(double oldNum) {
        this.oldNum = oldNum;
    }

    public double getNewNum() {
        return newNum;
    }

    public void setNewNum(double newNum) {
        this.newNum = newNum;
    }

    public double getPriceElec() {
        return priceElec;
    }

    public void setPriceElec(double priceElec) {
        this.priceElec = priceElec;
    }

    public Bill(Family family, double oldNum, double newNum, double priceElec) {
        this.family = family;
        this.oldNum = oldNum;
        this.newNum = newNum;
        this.priceElec = priceElec;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "family=" + family +
                ", oldNum=" + oldNum +
                ", newNum=" + newNum +
                ", priceElec=" + priceElec +
                '}';
    }
}
