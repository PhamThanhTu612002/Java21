package PublicTransport;

public class Train extends PublicTransport {
    private static final double TRAIN_SPEED = 40;

    @Override
    public double calTime(double distance) {
        return distance/TRAIN_SPEED;
    }
}
