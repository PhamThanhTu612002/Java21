package ManageStudent;

public abstract class SinhVienTechMaster {
    private String name;
    private String major;
    public SinhVienTechMaster(String name, String major) {
        this.name = name;
        this.major = major;
    }
    public abstract double getDiem();

    public String getHocLuc() {
        if (this.getDiem()<5){
            return "Yếu";
        } else if (this.getDiem()>=5 && this.getDiem()<6.5) {
            return "Trung Bình";
        } else if (this.getDiem()>=6.5 && this.getDiem()<7.5) {
            return "Khá";
        } else if (this.getDiem()>=7.5 && this.getDiem()<=10) {
            return "Giỏi";
        }else
        return "";
    }
    public void xuat(){
        System.out.println("Họ tên: "+ name);
        System.out.println("Nghành: " + major);
        System.out.println("Điểm :" + getDiem());
        System.out.println("Học lực: " + getHocLuc());
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", major='" + major + '\'';
    }
}
