package transport;

public abstract class Transport {
    private String name;
    private double speed;

    public Transport(String name, double speed) {
        this.name = name;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public double getSpeed() {
        return speed;
    }

    public abstract void move();
}
