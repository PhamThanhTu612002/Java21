package PublicTransport;

public class Plane extends PublicTransport {
    private static final double PLANE_SPEED = 80;

    @Override
    public double calTime(double distance) {
        return distance/PLANE_SPEED;
    }
}
