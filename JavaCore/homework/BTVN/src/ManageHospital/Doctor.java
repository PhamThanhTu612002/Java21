package ManageHospital;

public class Doctor extends Person{
    private String chuyenKhoa;
    private int soGioLam;

    public String getChuyenKhoa() {
        return chuyenKhoa;
    }

    public void setChuyenKhoa(String chuyenKhoa) {
        this.chuyenKhoa = chuyenKhoa;
    }

    public int getSoGioLam() {
        return soGioLam;
    }

    public void setSoGioLam(int soGioLam) {
        this.soGioLam = soGioLam;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                super.toString()+
                " ,chuyenKhoa='" + chuyenKhoa + '\'' +
                ", soGioLam=" + soGioLam +
                '}';
    }
}
