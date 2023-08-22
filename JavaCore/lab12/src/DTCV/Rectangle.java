package DTCV;

public class Rectangle implements Polygon {
    private double length;
    private double width;

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public void display() {
        System.out.println("Chiêu dài: " + length);
        System.out.println("Chiêu rộng: " + width);
        this.calArea();
    }

    @Override
    public void calArea() {
        System.out.println("Chu vi = "+(length+width)*2);
        System.out.println("Diện tích = "+length*width);
    }
}
