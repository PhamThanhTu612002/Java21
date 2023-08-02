package ManageStudent;

public class SinhVienBiz extends SinhVienTechMaster {
    private double marketting;
    private double sales;

    public SinhVienBiz(String name, String major, double marketting, double sales) {
        super(name, major);
        this.marketting = marketting;
        this.sales = sales;
    }
    @Override
    public double getDiem() {
        return (2*marketting + sales)/3 ;
    }

    @Override
    public String toString() {
        return "SinhVienBiz{" +
                super.toString()+
                ", marketting=" + marketting +
                ", sales=" + sales +
                '}';
    }
}
