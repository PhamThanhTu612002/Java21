package inter;

public class FishFlying implements  ISwimming, IFly{
    @Override
    public void fly() {
        System.out.println("I can fly");
    }

    @Override
    public void swim() {
        System.out.println("I can swing");
    }
}
