package transport;

public class Trolleybus extends Transport implements PublicTransport {
    public Trolleybus(String name, double speed) {
        super(name, speed);
    }

    @Override
    public void move() {
        System.out.println(getName() + " движется по проводам со скоростью " + getSpeed() + " км/ч.");
    }

    @Override
    public void transportPassengers() {
        System.out.println(getName() + " перевозит пассажиров.");
    }
}
