package DTCV;

public class Square implements Polygon {
    private double side;

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public Square(double side) {
        this.side = side;
    }


    @Override
    public void display() {
        System.out.println("Cạnh: " +side);
        this.calArea();
    }

    @Override
    public void calArea() {
        System.out.println("Diện tích = " + 4*side);
        System.out.println("Chu vi = " + Math.pow(side,2));
    }
}
