package transport;

public class Tank extends Transport implements MilitaryEquipment {
    public Tank(String name, double speed) {
        super(name, speed);
    }

    @Override
    public void move() {
        System.out.println(getName() + " передвигается по пересечённой местности со скоростью " + getSpeed() + " км/ч.");
    }

    @Override
    public void attack() {
        System.out.println(getName() + " стреляет из пушки!");
    }
}
