package terraformars;

public class WestDirection implements ProbeDirection{
    public ProbeDirection turnLeft() {
        return new SouthDirection();
    }

    public ProbeDirection turnRight() {
        return new NorthDirection();
    }

    public Point move() {
        return null;
    }
}
