package terraformars.directions;

import terraformars.Point;

public class SouthDirection implements ProbeDirection{
    public ProbeDirection turnLeft() {
        return new WestDirection();
    }

    public ProbeDirection turnRight() {
        return new EastDirection();
    }

    public Point move(Point point) {
        return null;
    }
}
