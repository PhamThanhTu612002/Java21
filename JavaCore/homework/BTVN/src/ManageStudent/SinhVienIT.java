package ManageStudent;

public class SinhVienIT extends SinhVienTechMaster{
    private double java;
    private double html;
    private double css;

    public SinhVienIT(String name, String major, double java, double html, double css) {
        super(name, major);
        this.java = java;
        this.html = html;
        this.css = css;
    }
    @Override
    public double getDiem() {
        return (2*java + html + css)/4;
    }

    @Override
    public String toString() {
        return "SinhVienIT{" +
                super.toString() +
                ", java=" + java +
                ", html=" + html +
                ", css=" + css +
                '}';
    }
}
