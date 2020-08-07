package terraformars;

public class SouthDirection implements ProbeDirection{
    public ProbeDirection turnLeft() {
        return new WestDirection();
    }

    public ProbeDirection turnRight() {
        return new EastDirection();
    }

    public Point move() {
        return null;
    }
}
