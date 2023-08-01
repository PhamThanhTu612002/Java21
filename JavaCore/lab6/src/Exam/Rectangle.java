package Exam;

public class Rectangle extends Shape {
    private float length;
    private float width;

    public Rectangle(float length, float width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public void printInfor() {
        System.out.println("Perimeter:" + calPerimeter());
        System.out.println("Acreage:" + calAcreage());
    }

    @Override
    public float calPerimeter() {
        return (length+width)*2;
    }

    @Override
    public float calAcreage() {
        return length*width;
    }
}
