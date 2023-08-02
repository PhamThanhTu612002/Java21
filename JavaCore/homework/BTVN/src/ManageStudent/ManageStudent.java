package ManageStudent;

public class ManageStudent {
    private SinhVienIT it;
    private SinhVienBiz biz;

    public SinhVienIT getIt() {
        return it;
    }

    public void setIt(SinhVienIT it) {
        this.it = it;
    }

    public SinhVienBiz getBiz() {
        return biz;
    }

    public void setBiz(SinhVienBiz biz) {
        this.biz = biz;
    }

    @Override
    public String toString() {
        return "ManageStudent{" +
                "it=" + it +
                ", biz=" + biz +
                '}';
    }
}
