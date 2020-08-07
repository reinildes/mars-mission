package terraformars;

public class EastDirection implements ProbeDirection{
    public ProbeDirection turnLeft() {
        return new NorthDirection();
    }

    public ProbeDirection turnRight() {
        return new SouthDirection();
    }

    public Point move() {
        return null;
    }
}
