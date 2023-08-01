package ManageHospital;

public class Patient extends Person {
    private String soBenhAn;
    private String ngayNhapVien;

    public String getSoBenhAn() {
        return soBenhAn;
    }

    public void setSoBenhAn(String soBenhAn) {
        this.soBenhAn = soBenhAn;
    }

    public String getNgayNhapVien() {
        return ngayNhapVien;
    }

    public void setNgayNhapVien(String ngayNhapVien) {
        this.ngayNhapVien = ngayNhapVien;
    }

    @Override
    public String toString() {
        return "Patient{" + super
                .toString()+
                " ,soBenhAn=" + soBenhAn +
                ", ngayNhapVien='" + ngayNhapVien + '\'' +
                '}';
    }
}
