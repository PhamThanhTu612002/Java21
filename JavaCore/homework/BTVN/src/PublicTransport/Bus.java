package PublicTransport;

public class Bus extends PublicTransport {
    private static final double BUS_SPEED = 20;

    @Override
    public double calTime(double distance) {
        return distance/BUS_SPEED;
    }
}
