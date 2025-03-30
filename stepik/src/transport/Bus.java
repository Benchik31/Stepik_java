package transport;

public class Bus extends Transport implements PublicTransport {
    public Bus(String name, double speed) {
        super(name, speed);
    }

    @Override
    public void move() {
        System.out.println(getName() + " движется по дороге со скоростью " + getSpeed() + " км/ч.");
    }

    @Override
    public void transportPassengers() {
        System.out.println(getName() + " перевозит пассажиров.");
    }
}
