package Exam;

public class Square extends Shape {
    private float side;

    public Square(float side) {
        this.side = side;
    }

    @Override
    public void printInfor() {
        System.out.println("Perimeter:" + calPerimeter());
        System.out.println("Acreage:" + calAcreage());
    }

    @Override
    public float calPerimeter() {
        return side*4;
    }

    @Override
    public float calAcreage() {
        return side*side;
    }
}
